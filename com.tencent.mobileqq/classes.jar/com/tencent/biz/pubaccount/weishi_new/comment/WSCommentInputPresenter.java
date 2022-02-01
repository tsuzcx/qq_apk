package com.tencent.biz.pubaccount.weishi_new.comment;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import com.tencent.biz.pubaccount.weishi_new.event.WSActivityResultEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSCommentSuccessEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

public class WSCommentInputPresenter
{
  private static final int a = Color.parseColor("#fe9526");
  private final WSCommentInputView b;
  private final ArrayList<Friends> c;
  private final ArrayList<String> d;
  private int e;
  
  public WSCommentInputPresenter(WSCommentInputView paramWSCommentInputView)
  {
    this.b = paramWSCommentInputView;
    this.c = new ArrayList();
    this.d = new ArrayList();
  }
  
  @NotNull
  private String a(Friends paramFriends)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("@");
    localStringBuilder.append(paramFriends.name);
    localStringBuilder.append(" ");
    return localStringBuilder.toString();
  }
  
  private void a(ArrayList<ResultRecord> paramArrayList)
  {
    IFriendDataService localIFriendDataService = (IFriendDataService)WeishiUtils.a().getRuntimeService(IFriendDataService.class, "");
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    paramArrayList = paramArrayList.iterator();
    int i = 0;
    while (paramArrayList.hasNext())
    {
      Object localObject1 = (ResultRecord)paramArrayList.next();
      if (!this.d.contains(((ResultRecord)localObject1).uin))
      {
        Object localObject2 = localIFriendDataService.getFriend(((ResultRecord)localObject1).uin);
        if (localObject2 != null)
        {
          this.d.add(((ResultRecord)localObject1).uin);
          this.c.add(localObject2);
          localObject1 = a((Friends)localObject2);
          int j = ((String)localObject1).length();
          localSpannableStringBuilder.append((CharSequence)localObject1);
          localObject2 = e();
          j += i;
          localSpannableStringBuilder.setSpan(localObject2, i, j, 17);
          this.e = Math.max(this.e, ((String)localObject1).length());
          i = j;
        }
      }
    }
    this.b.a(localSpannableStringBuilder);
  }
  
  private String b(Friends paramFriends)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("@{uid:");
    localStringBuilder.append(paramFriends.uin);
    localStringBuilder.append(",uidtype:");
    localStringBuilder.append("2");
    localStringBuilder.append(",nick:");
    localStringBuilder.append(URLEncoder.encode(paramFriends.name));
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  private void b(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    WSActivityResultEvent localWSActivityResultEvent = (WSActivityResultEvent)paramWSSimpleBaseEvent;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSCommentInputPresenter.java][onReceiveEvent] event:");
    localStringBuilder.append(paramWSSimpleBaseEvent);
    WSLog.b("WSCommentInputPresenter", localStringBuilder.toString());
    if (localWSActivityResultEvent.getResultCode() != -1) {
      return;
    }
    paramWSSimpleBaseEvent = localWSActivityResultEvent.getData().getParcelableArrayListExtra("result_set");
    if (paramWSSimpleBaseEvent != null)
    {
      if (paramWSSimpleBaseEvent.size() == 0) {
        return;
      }
      a(paramWSSimpleBaseEvent);
    }
  }
  
  @NotNull
  private StyleSpan e()
  {
    return new WSCommentInputPresenter.1(this, 0);
  }
  
  public String a(String paramString)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      Friends localFriends = (Friends)localIterator.next();
      String str = a(localFriends);
      if (paramString.contains(str)) {
        paramString = paramString.replace(str, b(localFriends));
      } else {
        localIterator.remove();
      }
    }
    return paramString;
  }
  
  public ArrayList<Friends> a()
  {
    return this.c;
  }
  
  public void a(Activity paramActivity, int paramInt, String paramString)
  {
    this.d.clear();
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      Friends localFriends = (Friends)localIterator.next();
      if (!paramString.contains(a(localFriends))) {
        localIterator.remove();
      } else {
        this.d.add(localFriends.uin);
      }
    }
    int i = this.d.size();
    paramString = new Intent();
    paramString.putExtra("param_only_friends", true);
    paramString.putExtra("param_min", 1);
    paramString.putExtra("param_max", 5 - i);
    paramString.putExtra("param_uins_selected_default", this.d);
    ((ISelectMemberApi)QRoute.api(ISelectMemberApi.class)).startSelectMemberActivityForResult(paramActivity, paramString, paramInt);
  }
  
  public void a(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    if ((paramWSSimpleBaseEvent instanceof WSActivityResultEvent))
    {
      b(paramWSSimpleBaseEvent);
      return;
    }
    if ((paramWSSimpleBaseEvent instanceof WSCommentSuccessEvent))
    {
      this.c.clear();
      this.d.clear();
    }
  }
  
  public ArrayList<String> b()
  {
    this.d.clear();
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      Friends localFriends = (Friends)localIterator.next();
      this.d.add(localFriends.uin);
    }
    return this.d;
  }
  
  public int c()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WSCommentInputPresenter
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity.history.link.search;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousExtInfo;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.messagesearch.BaseMessageResultAdapter;
import com.tencent.mobileqq.activity.messagesearch.BaseMessageResultAdapter.MessageHolder;
import com.tencent.mobileqq.activity.messagesearch.MessageItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.ColorNickTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.MqqWeakReferenceHandler;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TroopAllMessageResultAdapter
  extends BaseMessageResultAdapter
{
  Object a = new Object();
  protected List<MessageItem> b = new ArrayList();
  public Set<Long> c = new HashSet();
  private SimpleDateFormat m = new SimpleDateFormat("M月d日");
  
  public TroopAllMessageResultAdapter(Context paramContext, MqqWeakReferenceHandler paramMqqWeakReferenceHandler, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramMqqWeakReferenceHandler, paramSessionInfo, paramQQAppInterface);
  }
  
  public void a()
  {
    this.d.clear();
    notifyDataSetChanged();
  }
  
  public void a(long paramLong, String paramString, int paramInt)
  {
    ThreadManager.post(new TroopAllMessageResultAdapter.1(this, paramString, paramInt, paramLong), 8, null, false);
  }
  
  public void a(List<MessageItem> paramList, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setMessageItems loadType: ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", searchMode: ");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(", cloudGetCompleted: ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(", messageItems size: ");
      int i;
      if (paramList == null) {
        i = 0;
      } else {
        i = paramList.size();
      }
      ((StringBuilder)localObject).append(i);
      QLog.d("LinkMessageResultAdapter", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramInt1 == 1) && (paramInt2 == 0))
    {
      this.d = paramList;
      return;
    }
    if ((paramInt1 == 2) && (paramInt2 == 0))
    {
      this.d.addAll(paramList);
      return;
    }
    if ((paramInt1 == 4) && (paramList != null) && (paramList.size() != 0))
    {
      if (paramInt2 != 1) {
        return;
      }
      if ((this.d.size() > 0) && (paramList.size() > 0))
      {
        localObject = (MessageItem)paramList.get(0);
        MessageItem localMessageItem = (MessageItem)this.d.get(this.d.size() - 1);
        if (((MessageItem)localObject).b.time > localMessageItem.b.time)
        {
          if (QLog.isColorLevel()) {
            QLog.e("LinkMessageResultAdapter", 2, "setMessageItems: error firstItem time > lastItem time");
          }
          return;
        }
      }
      this.d.addAll(paramList);
    }
  }
  
  public void a(List<MessageItem> paramList, String paramString, long paramLong)
  {
    this.b.clear();
    if (QLog.isColorLevel()) {
      QLog.d("LinkMessageResultAdapter", 2, "displayCloudMessages...");
    }
    ThreadManager.post(new TroopAllMessageResultAdapter.2(this, paramString, paramLong, paramList), 8, null, false);
  }
  
  public void a(List<MessageItem> paramList, boolean paramBoolean)
  {
    if (paramList != null)
    {
      if (paramList.size() <= 0) {
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("mergeMsgsAtFirstTime: merge cloud and local msgs cloudGetCompleted: ");
        localStringBuilder.append(paramBoolean);
        QLog.d("LinkMessageResultAdapter", 2, localStringBuilder.toString());
      }
      this.d.clear();
      this.d.addAll(paramList);
    }
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    MessageItem localMessageItem = (MessageItem)getItem(paramInt);
    View localView;
    if (paramView == null)
    {
      localView = View.inflate(this.e, 2131625303, null);
      paramView = new BaseMessageResultAdapter.MessageHolder();
      paramView.b = ((ColorNickTextView)localView.findViewById(2131447063));
      paramView.c = ((TextView)localView.findViewById(2131447065));
      paramView.a = ((ImageView)localView.findViewById(2131435219));
      paramView.d = ((TextView)localView.findViewById(2131436844));
      localView.setTag(paramView);
    }
    else
    {
      localObject1 = (BaseMessageResultAdapter.MessageHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject1;
    }
    Object localObject1 = localMessageItem.b;
    Object localObject2 = ContactUtils.a(this.h, this.g, ((MessageRecord)localObject1).isSend(), ((MessageRecord)localObject1).senderuin);
    paramView.c.setText(localMessageItem.a(((MessageRecord)localObject1).msg, -11353092));
    Object localObject3;
    if (((MessageRecord)localObject1).isSend()) {
      this.h.getCurrentAccountUin();
    } else {
      localObject3 = this.g.b;
    }
    if (AnonymousChatHelper.c((MessageRecord)localObject1))
    {
      localObject2 = AnonymousChatHelper.g((MessageRecord)localObject1);
      localObject3 = paramView.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.e.getResources().getString(2131895011));
      localStringBuilder.append(((AnonymousChatHelper.AnonymousExtInfo)localObject2).c);
      ((ColorNickTextView)localObject3).setText(localStringBuilder.toString());
      paramView.a.setBackgroundDrawable(URLDrawable.getDrawable(AnonymousChatHelper.a(((AnonymousChatHelper.AnonymousExtInfo)localObject2).d)));
    }
    else
    {
      paramView.b.setText(localMessageItem.a((String)localObject2, -11353092));
      paramView.a.setBackgroundDrawable(FaceDrawable.getFaceDrawable(this.h, 1, ((MessageRecord)localObject1).senderuin));
    }
    paramView.d.setText(localMessageItem.a(((MessageRecord)localObject1).time));
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.link.search.TroopAllMessageResultAdapter
 * JD-Core Version:    0.7.0.1
 */
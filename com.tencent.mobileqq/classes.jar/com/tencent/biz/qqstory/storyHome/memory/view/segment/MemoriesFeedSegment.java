package com.tencent.biz.qqstory.storyHome.memory.view.segment;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.model.item.IFeedOwner;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.memory.controller.ProfileFeedPresenter;
import com.tencent.biz.qqstory.storyHome.memory.controller.ProfileFeedPresenter.FeedPresenterListener;
import com.tencent.biz.qqstory.storyHome.memory.model.MomeriesYearNode;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter;
import com.tencent.biz.qqstory.storyHome.model.StoryHomeFeed;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListHomeFeed;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.IMyStoryListView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment;
import com.tencent.biz.qqstory.utils.DateUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public class MemoriesFeedSegment
  extends FeedSegment
  implements ProfileFeedPresenter.FeedPresenterListener
{
  public MemoriesFeedSegment(Context paramContext, Activity paramActivity, int paramInt, IMyStoryListView paramIMyStoryListView, boolean paramBoolean)
  {
    super(paramContext, paramActivity, paramInt, paramIMyStoryListView, paramBoolean);
  }
  
  private String a(String paramString1, String paramString2)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.set(1, localCalendar1.get(1));
    localCalendar2.set(2, localCalendar1.get(2));
    localCalendar2.set(5, localCalendar1.get(5) - 1);
    localCalendar2.set(11, 0);
    localCalendar2.set(12, 0);
    localCalendar2.set(13, 0);
    if (TextUtils.isEmpty(paramString2)) {
      return String.valueOf(DateUtils.b(paramString1)[0]);
    }
    paramString2 = DateUtils.b(paramString2);
    paramString1 = DateUtils.b(paramString1);
    if (paramString2[0] != paramString1[0]) {
      return String.valueOf(paramString1[0]);
    }
    return null;
  }
  
  private String e(String paramString)
  {
    Object localObject = Calendar.getInstance();
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(1, ((Calendar)localObject).get(1));
    localCalendar.set(2, ((Calendar)localObject).get(2));
    localCalendar.set(5, ((Calendar)localObject).get(5) - 1);
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    paramString = DateUtils.b(paramString);
    if ((((Calendar)localObject).get(1) + 0 == paramString[0]) && (((Calendar)localObject).get(2) + 1 == paramString[1]) && (((Calendar)localObject).get(5) + 0 == paramString[2])) {
      return HardCodeUtil.a(2131904420);
    }
    if ((localCalendar.get(1) + 0 == paramString[0]) && (localCalendar.get(2) + 1 == paramString[1]) && (localCalendar.get(5) + 0 == paramString[2])) {
      return HardCodeUtil.a(2131904422);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString[1]);
    ((StringBuilder)localObject).append(HardCodeUtil.a(2131904425));
    ((StringBuilder)localObject).append(paramString[2]);
    ((StringBuilder)localObject).append(HardCodeUtil.a(2131904423));
    return ((StringBuilder)localObject).toString();
  }
  
  private void y()
  {
    this.m = true;
  }
  
  public int a()
  {
    if (this.m)
    {
      if (!((ProfileFeedPresenter)this.b).a) {
        return 1;
      }
      if (((ProfileFeedPresenter)this.b).b.size() > 0) {
        return super.a();
      }
    }
    return 0;
  }
  
  public View a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup)
  {
    if (g_(paramInt) == 4) {
      return paramBaseViewHolder.a();
    }
    return super.a(paramInt, paramBaseViewHolder, paramViewGroup);
  }
  
  public BaseViewHolder a(int paramInt, ViewGroup paramViewGroup)
  {
    if (g_(paramInt) == 4) {
      return new BaseViewHolder(LayoutInflater.from(this.l).inflate(2131628082, paramViewGroup, false));
    }
    return super.a(paramInt, paramViewGroup);
  }
  
  protected void a(int paramInt, BaseViewHolder paramBaseViewHolder, VideoListHomeFeed paramVideoListHomeFeed, QQUserUIItem paramQQUserUIItem)
  {
    Object localObject = (RelativeLayout)paramBaseViewHolder.a(2131442675);
    RelativeLayout localRelativeLayout = (RelativeLayout)paramBaseViewHolder.a(2131442671);
    TextView localTextView = (TextView)paramBaseViewHolder.a(2131442670);
    paramQQUserUIItem = (TextView)paramBaseViewHolder.a(2131442661);
    paramBaseViewHolder = (Button)paramBaseViewHolder.a(2131427766);
    ((RelativeLayout)localObject).setVisibility(0);
    localRelativeLayout.setVisibility(0);
    localTextView.setText(e(((StoryHomeFeed)this.b.i().get(paramInt)).g().date));
    localObject = a(paramVideoListHomeFeed.a());
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      paramQQUserUIItem.setVisibility(0);
      paramQQUserUIItem.setText((CharSequence)localObject);
    }
    else
    {
      paramQQUserUIItem.setVisibility(8);
    }
    if (paramVideoListHomeFeed.i().type == 3)
    {
      if (paramVideoListHomeFeed.i().getOwner().isSubscribe())
      {
        paramBaseViewHolder.setVisibility(8);
      }
      else
      {
        paramInt = UIUtils.a(this.l, 13.0F);
        int i = UIUtils.a(this.l, 3.0F);
        paramBaseViewHolder.setText(HardCodeUtil.a(2131899712));
        paramBaseViewHolder.setVisibility(0);
        paramBaseViewHolder.setTextColor(this.l.getResources().getColor(2131167993));
        paramBaseViewHolder.setBackgroundResource(2130848323);
        paramBaseViewHolder.setPadding(paramInt, i, paramInt, i);
      }
      paramInt = UIUtils.a(this.l, 20.0F);
      UIUtils.a(paramBaseViewHolder, paramInt, paramInt, paramInt, paramInt);
      return;
    }
    if (paramVideoListHomeFeed.i().type == 1)
    {
      paramBaseViewHolder.setVisibility(8);
      paramBaseViewHolder.setTextColor(this.l.getResources().getColor(2131167369));
      paramBaseViewHolder.setBackgroundDrawable(null);
      paramInt = UIUtils.a(this.l, 20.0F);
      UIUtils.a(paramBaseViewHolder, paramInt, paramInt, paramInt, paramInt);
    }
  }
  
  protected void a(int paramInt, BaseViewHolder paramBaseViewHolder, boolean paramBoolean)
  {
    Object localObject1 = (RelativeLayout)paramBaseViewHolder.a(2131442667);
    Object localObject2 = (TextView)paramBaseViewHolder.a(2131442685);
    TextView localTextView = (TextView)paramBaseViewHolder.a(2131442682);
    localTextView.setVisibility(8);
    paramBaseViewHolder = this.b.i();
    String str = ((StoryHomeFeed)paramBaseViewHolder.get(paramInt)).g().date;
    if (paramInt > 0) {
      paramBaseViewHolder = ((StoryHomeFeed)paramBaseViewHolder.get(paramInt - 1)).g().date;
    } else {
      paramBaseViewHolder = null;
    }
    paramBaseViewHolder = a(str, paramBaseViewHolder);
    if (TextUtils.isEmpty(paramBaseViewHolder))
    {
      ((RelativeLayout)localObject1).setVisibility(8);
      return;
    }
    ((RelativeLayout)localObject1).setVisibility(0);
    ((TextView)localObject2).setVisibility(0);
    ((TextView)localObject2).setText(paramBaseViewHolder);
    paramBaseViewHolder = DateUtils.b(str);
    localObject1 = ((ProfileFeedPresenter)this.b).b.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (MomeriesYearNode)((Iterator)localObject1).next();
      if (((MomeriesYearNode)localObject2).year == paramBaseViewHolder[0])
      {
        localTextView.setVisibility(0);
        localTextView.setText(String.format(HardCodeUtil.a(2131904428), new Object[] { Integer.valueOf(((MomeriesYearNode)localObject2).videoCount) }));
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    e(paramBoolean);
  }
  
  @NonNull
  protected HomeFeedPresenter b(boolean paramBoolean)
  {
    return new ProfileFeedPresenter(this.a, this, this, paramBoolean);
  }
  
  protected BaseViewHolder b(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new BaseViewHolder(LayoutInflater.from(this.l).inflate(2131628041, paramViewGroup, false));
    paramViewGroup.a(2131427766).setOnClickListener(paramViewGroup);
    a(paramViewGroup);
    return paramViewGroup;
  }
  
  public void br_()
  {
    super.br_();
    y();
  }
  
  protected void bs_()
  {
    super.bs_();
    k();
  }
  
  public boolean bt_()
  {
    if (t()) {
      return super.bt_();
    }
    return true;
  }
  
  public void c(boolean paramBoolean)
  {
    super.c(paramBoolean);
    if (paramBoolean) {
      k();
    }
  }
  
  protected int f()
  {
    return super.f() + 1;
  }
  
  protected int g_(int paramInt)
  {
    if (((ProfileFeedPresenter)this.b).a) {
      return super.g_(paramInt);
    }
    return 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.view.segment.MemoriesFeedSegment
 * JD-Core Version:    0.7.0.1
 */
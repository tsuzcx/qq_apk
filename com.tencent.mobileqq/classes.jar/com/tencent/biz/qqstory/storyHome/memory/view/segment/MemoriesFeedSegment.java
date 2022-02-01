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
  
  private String a(String paramString)
  {
    Object localObject = Calendar.getInstance();
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(1, ((Calendar)localObject).get(1));
    localCalendar.set(2, ((Calendar)localObject).get(2));
    localCalendar.set(5, ((Calendar)localObject).get(5) - 1);
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    paramString = DateUtils.a(paramString);
    if ((((Calendar)localObject).get(1) + 0 == paramString[0]) && (((Calendar)localObject).get(2) + 1 == paramString[1]) && (((Calendar)localObject).get(5) + 0 == paramString[2])) {
      return HardCodeUtil.a(2131706566);
    }
    if ((localCalendar.get(1) + 0 == paramString[0]) && (localCalendar.get(2) + 1 == paramString[1]) && (localCalendar.get(5) + 0 == paramString[2])) {
      return HardCodeUtil.a(2131706568);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString[1]);
    ((StringBuilder)localObject).append(HardCodeUtil.a(2131706571));
    ((StringBuilder)localObject).append(paramString[2]);
    ((StringBuilder)localObject).append(HardCodeUtil.a(2131706569));
    return ((StringBuilder)localObject).toString();
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
      return String.valueOf(DateUtils.a(paramString1)[0]);
    }
    paramString2 = DateUtils.a(paramString2);
    paramString1 = DateUtils.a(paramString1);
    if (paramString2[0] != paramString1[0]) {
      return String.valueOf(paramString1[0]);
    }
    return null;
  }
  
  private void n()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void P_()
  {
    super.P_();
    n();
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (!((ProfileFeedPresenter)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter).jdField_a_of_type_Boolean) {
        return 1;
      }
      if (((ProfileFeedPresenter)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter).jdField_a_of_type_JavaUtilList.size() > 0) {
        return super.a();
      }
    }
    return 0;
  }
  
  protected int a(int paramInt)
  {
    if (((ProfileFeedPresenter)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter).jdField_a_of_type_Boolean) {
      return super.a(paramInt);
    }
    return 4;
  }
  
  public View a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup)
  {
    if (a(paramInt) == 4) {
      return paramBaseViewHolder.a();
    }
    return super.a(paramInt, paramBaseViewHolder, paramViewGroup);
  }
  
  @NonNull
  protected HomeFeedPresenter a(boolean paramBoolean)
  {
    return new ProfileFeedPresenter(this.jdField_a_of_type_Int, this, this, paramBoolean);
  }
  
  public BaseViewHolder a(int paramInt, ViewGroup paramViewGroup)
  {
    if (a(paramInt) == 4) {
      return new BaseViewHolder(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561703, paramViewGroup, false));
    }
    return super.a(paramInt, paramViewGroup);
  }
  
  protected void a(int paramInt, BaseViewHolder paramBaseViewHolder, VideoListHomeFeed paramVideoListHomeFeed, QQUserUIItem paramQQUserUIItem)
  {
    Object localObject = (RelativeLayout)paramBaseViewHolder.a(2131374505);
    RelativeLayout localRelativeLayout = (RelativeLayout)paramBaseViewHolder.a(2131374501);
    TextView localTextView = (TextView)paramBaseViewHolder.a(2131374500);
    paramQQUserUIItem = (TextView)paramBaseViewHolder.a(2131374491);
    paramBaseViewHolder = (Button)paramBaseViewHolder.a(2131362184);
    ((RelativeLayout)localObject).setVisibility(0);
    localRelativeLayout.setVisibility(0);
    localTextView.setText(a(((StoryHomeFeed)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter.a().get(paramInt)).a().date));
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
    if (paramVideoListHomeFeed.a().type == 3)
    {
      if (paramVideoListHomeFeed.a().getOwner().isSubscribe())
      {
        paramBaseViewHolder.setVisibility(8);
      }
      else
      {
        paramInt = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 13.0F);
        int i = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 3.0F);
        paramBaseViewHolder.setText(HardCodeUtil.a(2131706574));
        paramBaseViewHolder.setVisibility(0);
        paramBaseViewHolder.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167056));
        paramBaseViewHolder.setBackgroundResource(2130846771);
        paramBaseViewHolder.setPadding(paramInt, i, paramInt, i);
      }
      paramInt = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 20.0F);
      UIUtils.a(paramBaseViewHolder, paramInt, paramInt, paramInt, paramInt);
      return;
    }
    if (paramVideoListHomeFeed.a().type == 1)
    {
      paramBaseViewHolder.setVisibility(8);
      paramBaseViewHolder.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166512));
      paramBaseViewHolder.setBackgroundDrawable(null);
      paramInt = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 20.0F);
      UIUtils.a(paramBaseViewHolder, paramInt, paramInt, paramInt, paramInt);
    }
  }
  
  protected void a(int paramInt, BaseViewHolder paramBaseViewHolder, boolean paramBoolean)
  {
    Object localObject1 = (RelativeLayout)paramBaseViewHolder.a(2131374497);
    Object localObject2 = (TextView)paramBaseViewHolder.a(2131374515);
    TextView localTextView = (TextView)paramBaseViewHolder.a(2131374512);
    localTextView.setVisibility(8);
    paramBaseViewHolder = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter.a();
    String str = ((StoryHomeFeed)paramBaseViewHolder.get(paramInt)).a().date;
    if (paramInt > 0) {
      paramBaseViewHolder = ((StoryHomeFeed)paramBaseViewHolder.get(paramInt - 1)).a().date;
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
    paramBaseViewHolder = DateUtils.a(str);
    localObject1 = ((ProfileFeedPresenter)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter).jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (MomeriesYearNode)((Iterator)localObject1).next();
      if (((MomeriesYearNode)localObject2).year == paramBaseViewHolder[0])
      {
        localTextView.setVisibility(0);
        localTextView.setText(String.format(HardCodeUtil.a(2131706576), new Object[] { Integer.valueOf(((MomeriesYearNode)localObject2).videoCount) }));
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    c(paramBoolean);
  }
  
  public boolean a()
  {
    if (c()) {
      return super.a();
    }
    return true;
  }
  
  public void a_(boolean paramBoolean)
  {
    super.a_(paramBoolean);
    if (paramBoolean) {
      h();
    }
  }
  
  protected BaseViewHolder b(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new BaseViewHolder(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561662, paramViewGroup, false));
    paramViewGroup.a(2131362184).setOnClickListener(paramViewGroup);
    a(paramViewGroup);
    return paramViewGroup;
  }
  
  protected void b()
  {
    super.b();
    h();
  }
  
  protected int d_()
  {
    return super.d_() + 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.view.segment.MemoriesFeedSegment
 * JD-Core Version:    0.7.0.1
 */
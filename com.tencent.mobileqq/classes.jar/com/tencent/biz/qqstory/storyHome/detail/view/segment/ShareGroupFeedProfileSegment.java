package com.tencent.biz.qqstory.storyHome.detail.view.segment;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.boundaries.StoryDepends.StoryShareGroup;
import com.tencent.biz.qqstory.model.item.IFeedOwner;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.shareGroup.addvideo.AddVideoController;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.ShareGroupFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.view.widget.StoryUserBadgeView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class ShareGroupFeedProfileSegment
  extends GeneralFeedProfileSegment
{
  public static final String KEY = "ShareGroupFeedProfileSegment";
  
  public ShareGroupFeedProfileSegment(Activity paramActivity, int paramInt1, int paramInt2)
  {
    super(paramActivity, paramInt1, paramInt2);
  }
  
  private View a(int paramInt, BaseViewHolder paramBaseViewHolder)
  {
    ShareGroupItem localShareGroupItem = (ShareGroupItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a().getOwner();
    if (localShareGroupItem == null)
    {
      SLog.e("Q.qqstory.detail.ShareGroupFeedProfileSegment", "bind share group view failed because it's invalidate date.");
      return paramBaseViewHolder.a();
    }
    Object localObject = (RelativeLayout)paramBaseViewHolder.a(2131374484);
    ImageView localImageView = (ImageView)paramBaseViewHolder.a(2131368058);
    TextView localTextView1 = (TextView)paramBaseViewHolder.a(2131371854);
    TextView localTextView2 = (TextView)paramBaseViewHolder.a(2131374510);
    TextView localTextView3 = (TextView)paramBaseViewHolder.a(2131374511);
    StoryUserBadgeView localStoryUserBadgeView = (StoryUserBadgeView)paramBaseViewHolder.a(2131380921);
    TextView localTextView4 = (TextView)paramBaseViewHolder.a(2131378070);
    RelativeLayout localRelativeLayout = (RelativeLayout)paramBaseViewHolder.a(2131374509);
    StoryHomeHorizontalListView localStoryHomeHorizontalListView = (StoryHomeHorizontalListView)paramBaseViewHolder.a(2131380668);
    ((RelativeLayout)localObject).setOnClickListener(this);
    localImageView.setImageDrawable(StoryDepends.StoryShareGroup.a(localShareGroupItem.headerUnionIdList));
    if (!TextUtils.isEmpty(localShareGroupItem.getName()))
    {
      localTextView1.setText(localShareGroupItem.getName());
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131713810));
      ((StringBuilder)localObject).append(QQStoryConstant.a);
      localTextView1.setText(((StringBuilder)localObject).toString());
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.f()) {
      a(localTextView2, localTextView3);
    }
    if (localShareGroupItem.isPublic()) {
      localStoryUserBadgeView.setImageResource(2130847031);
    } else {
      localStoryUserBadgeView.setImageResource(2130847030);
    }
    localStoryUserBadgeView.setOnClickListener(null);
    localStoryUserBadgeView.setVisibility(0);
    a(localTextView4, 0, null);
    a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a(), paramBaseViewHolder);
    a(paramInt, paramBaseViewHolder, localRelativeLayout, localStoryHomeHorizontalListView);
    return paramBaseViewHolder.a();
  }
  
  private void a(TextView paramTextView1, TextView paramTextView2)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem != null)
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a() == null) {
        return;
      }
      Object localObject = FeedSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a(), this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a());
      CharSequence localCharSequence = localObject[0];
      localObject = localObject[1];
      if (TextUtils.isEmpty(localCharSequence))
      {
        paramTextView1.setVisibility(8);
      }
      else
      {
        paramTextView1.setVisibility(0);
        paramTextView1.setText(localCharSequence);
      }
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        paramTextView2.setVisibility(8);
        return;
      }
      paramTextView2.setVisibility(0);
      paramTextView2.setText((CharSequence)localObject);
    }
  }
  
  private View b(int paramInt, BaseViewHolder paramBaseViewHolder)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a();
    if ((localObject1 != null) && (((ShareGroupFeedItem)localObject1).getOwner() != null))
    {
      Object localObject2 = (RelativeLayout)paramBaseViewHolder.a(2131374484);
      ImageView localImageView = (ImageView)paramBaseViewHolder.a(2131368058);
      TextView localTextView1 = (TextView)paramBaseViewHolder.a(2131371854);
      TextView localTextView2 = (TextView)paramBaseViewHolder.a(2131374510);
      TextView localTextView3 = (TextView)paramBaseViewHolder.a(2131374511);
      StoryUserBadgeView localStoryUserBadgeView = (StoryUserBadgeView)paramBaseViewHolder.a(2131380921);
      TextView localTextView4 = (TextView)paramBaseViewHolder.a(2131378070);
      RelativeLayout localRelativeLayout = (RelativeLayout)paramBaseViewHolder.a(2131374509);
      StoryHomeHorizontalListView localStoryHomeHorizontalListView = (StoryHomeHorizontalListView)paramBaseViewHolder.a(2131380668);
      ((RelativeLayout)localObject2).setOnClickListener(this);
      localObject2 = ImageUtil.f();
      localImageView.setImageDrawable(FaceDrawable.getFaceDrawable(QQStoryContext.a(), 4, String.valueOf(((ShareGroupFeedItem)localObject1).getOwner().groupUin), 3, (Drawable)localObject2, (Drawable)localObject2));
      if (!TextUtils.isEmpty(((ShareGroupFeedItem)localObject1).getOwner().getName()))
      {
        localTextView1.setText(((ShareGroupFeedItem)localObject1).getOwner().getName());
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(HardCodeUtil.a(2131713817));
        ((StringBuilder)localObject1).append(QQStoryConstant.a);
        localTextView1.setText(((StringBuilder)localObject1).toString());
      }
      a(localTextView2, localTextView3);
      localStoryUserBadgeView.setImageResource(2130847029);
      localStoryUserBadgeView.setOnClickListener(this);
      localStoryUserBadgeView.setVisibility(0);
      a(localTextView4, 2, HardCodeUtil.a(2131713799));
      a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a(), paramBaseViewHolder);
      a(paramInt, paramBaseViewHolder, localRelativeLayout, localStoryHomeHorizontalListView);
      return paramBaseViewHolder.a();
    }
    SLog.e("Q.qqstory.detail.ShareGroupFeedProfileSegment", "bind share group view failed because it's invalidate date.");
    return paramBaseViewHolder.a();
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.f()) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a().getOwner().getRelationType() == 2);
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem != null) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.f()) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a().size() > 0)) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup)
  {
    if (b()) {
      return b(paramInt, paramBaseViewHolder);
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.f()) {
      return a(paramInt, paramBaseViewHolder);
    }
    throw new IllegalStateException("bind view failed because it's not a share group feed.");
  }
  
  public String a()
  {
    return "ShareGroupFeedProfileSegment";
  }
  
  protected void a(int paramInt)
  {
    super.a(paramInt);
    int i;
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.getOwner().isSubscribe()) {
      i = 3;
    } else {
      i = 4;
    }
    if (!(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.getOwner() instanceof ShareGroupItem)) {
      return;
    }
    ShareGroupItem localShareGroupItem = (ShareGroupItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.getOwner();
    if (paramInt != 2)
    {
      if (paramInt != 3) {
        return;
      }
      QQStoryShareGroupProfileActivity.a(this.jdField_a_of_type_AndroidContentContext, 2, localShareGroupItem.shareGroupId, null, i, PlayModeUtils.a(this.jdField_a_of_type_Int, this.b));
      return;
    }
    QQStoryShareGroupProfileActivity.a(this.jdField_a_of_type_AndroidContentContext, 1, localShareGroupItem.shareGroupId, String.valueOf(localShareGroupItem.groupUin), i, PlayModeUtils.a(this.jdField_a_of_type_Int, this.b));
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    int i = paramView.getId();
    if (i != 2131378070)
    {
      if (i == 2131380921) {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 0, HardCodeUtil.a(2131713789), 0).a();
      }
    }
    else if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.f())
    {
      ShareGroupItem localShareGroupItem = (ShareGroupItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a().getOwner();
      if (localShareGroupItem.isSubscribe()) {
        new AddVideoController(PlayModeUtils.a()).a(this.jdField_a_of_type_AndroidContentContext, localShareGroupItem.type, localShareGroupItem.shareGroupId, localShareGroupItem.name, localShareGroupItem.groupUin, 20003, 2);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.segment.ShareGroupFeedProfileSegment
 * JD-Core Version:    0.7.0.1
 */
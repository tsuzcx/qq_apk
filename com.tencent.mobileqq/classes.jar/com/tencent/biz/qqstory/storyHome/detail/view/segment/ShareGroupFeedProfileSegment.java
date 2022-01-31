package com.tencent.biz.qqstory.storyHome.detail.view.segment;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
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
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQToast;
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
    RelativeLayout localRelativeLayout1 = (RelativeLayout)paramBaseViewHolder.a(2131371680);
    ImageView localImageView = (ImageView)paramBaseViewHolder.a(2131371694);
    TextView localTextView1 = (TextView)paramBaseViewHolder.a(2131362743);
    TextView localTextView2 = (TextView)paramBaseViewHolder.a(2131371687);
    TextView localTextView3 = (TextView)paramBaseViewHolder.a(2131371698);
    StoryUserBadgeView localStoryUserBadgeView = (StoryUserBadgeView)paramBaseViewHolder.a(2131371697);
    TextView localTextView4 = (TextView)paramBaseViewHolder.a(2131371695);
    RelativeLayout localRelativeLayout2 = (RelativeLayout)paramBaseViewHolder.a(2131371646);
    StoryHomeHorizontalListView localStoryHomeHorizontalListView = (StoryHomeHorizontalListView)paramBaseViewHolder.a(2131371701);
    localRelativeLayout1.setOnClickListener(this);
    localImageView.setImageDrawable(StoryDepends.StoryShareGroup.a(localShareGroupItem.headerUnionIdList));
    if (!TextUtils.isEmpty(localShareGroupItem.getName()))
    {
      localTextView1.setText(localShareGroupItem.getName());
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.f()) {
        a(localTextView2, localTextView3);
      }
      if (!localShareGroupItem.isPublic()) {
        break label255;
      }
      localStoryUserBadgeView.setImageResource(2130843718);
    }
    for (;;)
    {
      localStoryUserBadgeView.setOnClickListener(null);
      localStoryUserBadgeView.setVisibility(0);
      a(localTextView4, 0, null);
      a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a(), paramBaseViewHolder);
      a(paramInt, paramBaseViewHolder, localRelativeLayout2, localStoryHomeHorizontalListView);
      return paramBaseViewHolder.a();
      localTextView1.setText("未知共享日迹");
      break;
      label255:
      localStoryUserBadgeView.setImageResource(2130843717);
    }
  }
  
  private void a(TextView paramTextView1, TextView paramTextView2)
  {
    Object localObject = FeedSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a(), this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a());
    CharSequence localCharSequence = localObject[0];
    localObject = localObject[1];
    if (TextUtils.isEmpty(localCharSequence)) {
      paramTextView1.setVisibility(8);
    }
    while (TextUtils.isEmpty((CharSequence)localObject))
    {
      paramTextView2.setVisibility(8);
      return;
      paramTextView1.setVisibility(0);
      paramTextView1.setText(localCharSequence);
    }
    paramTextView2.setVisibility(0);
    paramTextView2.setText((CharSequence)localObject);
  }
  
  private View b(int paramInt, BaseViewHolder paramBaseViewHolder)
  {
    ShareGroupFeedItem localShareGroupFeedItem = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a();
    if ((localShareGroupFeedItem == null) || (localShareGroupFeedItem.getOwner() == null))
    {
      SLog.e("Q.qqstory.detail.ShareGroupFeedProfileSegment", "bind share group view failed because it's invalidate date.");
      return paramBaseViewHolder.a();
    }
    Object localObject = (RelativeLayout)paramBaseViewHolder.a(2131371680);
    ImageView localImageView = (ImageView)paramBaseViewHolder.a(2131371694);
    TextView localTextView1 = (TextView)paramBaseViewHolder.a(2131362743);
    TextView localTextView2 = (TextView)paramBaseViewHolder.a(2131371687);
    TextView localTextView3 = (TextView)paramBaseViewHolder.a(2131371698);
    StoryUserBadgeView localStoryUserBadgeView = (StoryUserBadgeView)paramBaseViewHolder.a(2131371697);
    TextView localTextView4 = (TextView)paramBaseViewHolder.a(2131371695);
    RelativeLayout localRelativeLayout = (RelativeLayout)paramBaseViewHolder.a(2131371646);
    StoryHomeHorizontalListView localStoryHomeHorizontalListView = (StoryHomeHorizontalListView)paramBaseViewHolder.a(2131371701);
    ((RelativeLayout)localObject).setOnClickListener(this);
    localObject = ImageUtil.a();
    localImageView.setImageDrawable(FaceDrawable.a(QQStoryContext.a(), 4, String.valueOf(localShareGroupFeedItem.getOwner().groupUin), 3, (Drawable)localObject, (Drawable)localObject));
    if (!TextUtils.isEmpty(localShareGroupFeedItem.getOwner().getName())) {
      localTextView1.setText(localShareGroupFeedItem.getOwner().getName());
    }
    for (;;)
    {
      a(localTextView2, localTextView3);
      localStoryUserBadgeView.setImageResource(2130843716);
      localStoryUserBadgeView.setOnClickListener(this);
      localStoryUserBadgeView.setVisibility(0);
      a(localTextView4, 2, "添加视频");
      a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a(), paramBaseViewHolder);
      a(paramInt, paramBaseViewHolder, localRelativeLayout, localStoryHomeHorizontalListView);
      return paramBaseViewHolder.a();
      localTextView1.setText("未知群主日迹");
    }
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
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.getOwner().isSubscribe()) {}
    for (int i = 3; !(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.getOwner() instanceof ShareGroupItem); i = 4) {
      return;
    }
    ShareGroupItem localShareGroupItem = (ShareGroupItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.getOwner();
    switch (paramInt)
    {
    default: 
      return;
    case 2: 
      QQStoryShareGroupProfileActivity.a(this.jdField_a_of_type_AndroidContentContext, 1, localShareGroupItem.shareGroupId, String.valueOf(localShareGroupItem.groupUin), i, PlayModeUtils.a(this.jdField_a_of_type_Int, this.b));
      return;
    }
    QQStoryShareGroupProfileActivity.a(this.jdField_a_of_type_AndroidContentContext, 2, localShareGroupItem.shareGroupId, null, i, PlayModeUtils.a(this.jdField_a_of_type_Int, this.b));
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    switch (paramView.getId())
    {
    case 2131371696: 
    default: 
    case 2131371695: 
      do
      {
        do
        {
          return;
        } while (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.f());
        paramView = (ShareGroupItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a().getOwner();
      } while (!paramView.isSubscribe());
      new AddVideoController(PlayModeUtils.a()).a(this.jdField_a_of_type_AndroidContentContext, paramView.type, paramView.shareGroupId, paramView.name, paramView.groupUin, 20003, 2);
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, 0, "群友可见，仅成员可添加视频", 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.segment.ShareGroupFeedProfileSegment
 * JD-Core Version:    0.7.0.1
 */
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
    ShareGroupItem localShareGroupItem = (ShareGroupItem)this.a.f().getOwner();
    if (localShareGroupItem == null)
    {
      SLog.e("Q.qqstory.detail.ShareGroupFeedProfileSegment", "bind share group view failed because it's invalidate date.");
      return paramBaseViewHolder.a();
    }
    Object localObject = (RelativeLayout)paramBaseViewHolder.a(2131442654);
    ImageView localImageView = (ImageView)paramBaseViewHolder.a(2131434908);
    TextView localTextView1 = (TextView)paramBaseViewHolder.a(2131439295);
    TextView localTextView2 = (TextView)paramBaseViewHolder.a(2131442680);
    TextView localTextView3 = (TextView)paramBaseViewHolder.a(2131442681);
    StoryUserBadgeView localStoryUserBadgeView = (StoryUserBadgeView)paramBaseViewHolder.a(2131449911);
    TextView localTextView4 = (TextView)paramBaseViewHolder.a(2131446570);
    RelativeLayout localRelativeLayout = (RelativeLayout)paramBaseViewHolder.a(2131442679);
    StoryHomeHorizontalListView localStoryHomeHorizontalListView = (StoryHomeHorizontalListView)paramBaseViewHolder.a(2131449627);
    ((RelativeLayout)localObject).setOnClickListener(this);
    localImageView.setImageDrawable(StoryDepends.StoryShareGroup.a(localShareGroupItem.headerUnionIdList));
    if (!TextUtils.isEmpty(localShareGroupItem.getName()))
    {
      localTextView1.setText(localShareGroupItem.getName());
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131911350));
      ((StringBuilder)localObject).append(QQStoryConstant.a);
      localTextView1.setText(((StringBuilder)localObject).toString());
    }
    if (this.a.k()) {
      a(localTextView2, localTextView3);
    }
    if (localShareGroupItem.isPublic()) {
      localStoryUserBadgeView.setImageResource(2130848583);
    } else {
      localStoryUserBadgeView.setImageResource(2130848582);
    }
    localStoryUserBadgeView.setOnClickListener(null);
    localStoryUserBadgeView.setVisibility(0);
    a(localTextView4, 0, null);
    a(this.a.a(), paramBaseViewHolder);
    a(paramInt, paramBaseViewHolder, localRelativeLayout, localStoryHomeHorizontalListView);
    return paramBaseViewHolder.a();
  }
  
  private void a(TextView paramTextView1, TextView paramTextView2)
  {
    if (this.a != null)
    {
      if (this.a.l() == null) {
        return;
      }
      Object localObject = FeedSegment.a(this.a.l(), this.a.a());
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
    Object localObject1 = this.a.l();
    if ((localObject1 != null) && (((ShareGroupFeedItem)localObject1).getOwner() != null))
    {
      Object localObject2 = (RelativeLayout)paramBaseViewHolder.a(2131442654);
      ImageView localImageView = (ImageView)paramBaseViewHolder.a(2131434908);
      TextView localTextView1 = (TextView)paramBaseViewHolder.a(2131439295);
      TextView localTextView2 = (TextView)paramBaseViewHolder.a(2131442680);
      TextView localTextView3 = (TextView)paramBaseViewHolder.a(2131442681);
      StoryUserBadgeView localStoryUserBadgeView = (StoryUserBadgeView)paramBaseViewHolder.a(2131449911);
      TextView localTextView4 = (TextView)paramBaseViewHolder.a(2131446570);
      RelativeLayout localRelativeLayout = (RelativeLayout)paramBaseViewHolder.a(2131442679);
      StoryHomeHorizontalListView localStoryHomeHorizontalListView = (StoryHomeHorizontalListView)paramBaseViewHolder.a(2131449627);
      ((RelativeLayout)localObject2).setOnClickListener(this);
      localObject2 = ImageUtil.m();
      localImageView.setImageDrawable(FaceDrawable.getFaceDrawable(QQStoryContext.k(), 4, String.valueOf(((ShareGroupFeedItem)localObject1).getOwner().groupUin), 3, (Drawable)localObject2, (Drawable)localObject2));
      if (!TextUtils.isEmpty(((ShareGroupFeedItem)localObject1).getOwner().getName()))
      {
        localTextView1.setText(((ShareGroupFeedItem)localObject1).getOwner().getName());
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(HardCodeUtil.a(2131911357));
        ((StringBuilder)localObject1).append(QQStoryConstant.a);
        localTextView1.setText(((StringBuilder)localObject1).toString());
      }
      a(localTextView2, localTextView3);
      localStoryUserBadgeView.setImageResource(2130848581);
      localStoryUserBadgeView.setOnClickListener(this);
      localStoryUserBadgeView.setVisibility(0);
      a(localTextView4, 2, HardCodeUtil.a(2131911339));
      a(this.a.a(), paramBaseViewHolder);
      a(paramInt, paramBaseViewHolder, localRelativeLayout, localStoryHomeHorizontalListView);
      return paramBaseViewHolder.a();
    }
    SLog.e("Q.qqstory.detail.ShareGroupFeedProfileSegment", "bind share group view failed because it's invalidate date.");
    return paramBaseViewHolder.a();
  }
  
  private boolean j()
  {
    return (this.a.k()) && (this.a.l().getOwner().getRelationType() == 2);
  }
  
  public int a()
  {
    if ((this.m) && (this.a != null) && (this.a.k()) && (this.a.a().size() > 0)) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup)
  {
    if (j()) {
      return b(paramInt, paramBaseViewHolder);
    }
    if (this.a.k()) {
      return a(paramInt, paramBaseViewHolder);
    }
    throw new IllegalStateException("bind view failed because it's not a share group feed.");
  }
  
  protected void a(int paramInt)
  {
    super.a(paramInt);
    int i;
    if (this.a.a.getOwner().isSubscribe()) {
      i = 3;
    } else {
      i = 4;
    }
    if (!(this.a.a.getOwner() instanceof ShareGroupItem)) {
      return;
    }
    ShareGroupItem localShareGroupItem = (ShareGroupItem)this.a.a.getOwner();
    if (paramInt != 2)
    {
      if (paramInt != 3) {
        return;
      }
      QQStoryShareGroupProfileActivity.a(this.l, 2, localShareGroupItem.shareGroupId, null, i, PlayModeUtils.a(this.b, this.c));
      return;
    }
    QQStoryShareGroupProfileActivity.a(this.l, 1, localShareGroupItem.shareGroupId, String.valueOf(localShareGroupItem.groupUin), i, PlayModeUtils.a(this.b, this.c));
  }
  
  public String b()
  {
    return "ShareGroupFeedProfileSegment";
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    int i = paramView.getId();
    if (i != 2131446570)
    {
      if (i == 2131449911) {
        QQToast.makeText(this.l, 0, HardCodeUtil.a(2131911329), 0).show();
      }
    }
    else if (this.a.k())
    {
      ShareGroupItem localShareGroupItem = (ShareGroupItem)this.a.f().getOwner();
      if (localShareGroupItem.isSubscribe()) {
        new AddVideoController(PlayModeUtils.b()).a(this.l, localShareGroupItem.type, localShareGroupItem.shareGroupId, localShareGroupItem.name, localShareGroupItem.groupUin, 20003, 2);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.segment.ShareGroupFeedProfileSegment
 * JD-Core Version:    0.7.0.1
 */
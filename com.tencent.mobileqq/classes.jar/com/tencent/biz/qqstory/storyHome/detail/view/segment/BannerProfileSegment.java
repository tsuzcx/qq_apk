package com.tencent.biz.qqstory.storyHome.detail.view.segment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailEventCallback;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedItem;
import com.tencent.biz.qqstory.storyHome.memory.model.StoryProfileUtils;
import com.tencent.biz.qqstory.storyHome.model.BannerFeedItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.NetworkUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.view.segment.SegmentView;
import com.tencent.biz.qqstory.view.widget.StoryQIMBadgeView;
import com.tencent.biz.qqstory.view.widget.StoryUserBadgeView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class BannerProfileSegment
  extends SegmentView<DetailFeedItem>
  implements View.OnClickListener
{
  public static final String KEY = "BannerProfileSegment";
  private DetailEventCallback jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailEventCallback;
  private DetailFeedItem jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem;
  private BaseViewHolder jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder;
  
  public BannerProfileSegment(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem != null) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.g())) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup)
  {
    if (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.g()) {
      throw new IllegalStateException("bind view failed because it's not a banner feed.");
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a() == null)
    {
      SLog.e("Q.qqstory.detail.BannerProfileSegment", "bind banner view failed because it's invalidate date.");
      return paramBaseViewHolder.a();
    }
    paramViewGroup = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a();
    RelativeLayout localRelativeLayout = (RelativeLayout)paramBaseViewHolder.a(2131374952);
    ImageView localImageView1 = (ImageView)paramBaseViewHolder.a(2131374939);
    TextView localTextView1 = (TextView)paramBaseViewHolder.a(2131374940);
    StoryUserBadgeView localStoryUserBadgeView = (StoryUserBadgeView)paramBaseViewHolder.a(2131374942);
    TextView localTextView2 = (TextView)paramBaseViewHolder.a(2131374978);
    TextView localTextView3 = (TextView)paramBaseViewHolder.a(2131374936);
    ImageView localImageView2 = (ImageView)paramBaseViewHolder.a(2131374935);
    TextView localTextView4 = (TextView)paramBaseViewHolder.a(2131374943);
    StoryQIMBadgeView localStoryQIMBadgeView = (StoryQIMBadgeView)paramBaseViewHolder.a(2131374455);
    localRelativeLayout.setOnClickListener(this);
    UIUtils.b(localImageView1, paramViewGroup.getOwner().headUrl, 68, 68, ImageUtil.a(1), "QQStory_main");
    localStoryQIMBadgeView.a(paramViewGroup.getOwner());
    localTextView1.setText(paramViewGroup.getOwner().getName());
    localStoryUserBadgeView.setUnionID(paramViewGroup.getOwner().getUnionId(), 2);
    if (TextUtils.isEmpty(paramViewGroup.blurb))
    {
      localTextView2.setVisibility(8);
      if (!TextUtils.isEmpty(paramViewGroup.content)) {
        break label417;
      }
      localTextView4.setVisibility(8);
      label245:
      if (QQStoryContext.a())
      {
        localTextView3.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166514));
        localTextView3.setBackgroundResource(2130846893);
      }
      if (!StoryProfileUtils.a(paramViewGroup.getOwner())) {
        break label435;
      }
      localTextView3.setVisibility(0);
      localTextView3.setOnClickListener(this);
    }
    for (;;)
    {
      float f = paramViewGroup.coverHeight * 1.0F / paramViewGroup.coverWidth;
      paramInt = UIUtils.a(this.jdField_a_of_type_AndroidContentContext) - UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 15.0F) * 2;
      int i = (int)(f * paramInt);
      localImageView2.getLayoutParams().width = paramInt;
      localImageView2.getLayoutParams().height = i;
      UIUtils.a(localImageView2, paramViewGroup.coverUrl, paramInt / 2, i / 2, 10, UIUtils.b, "QQStory_main");
      localImageView2.setOnClickListener(this);
      localTextView4.setOnClickListener(this);
      return paramBaseViewHolder.a();
      localTextView2.setText(paramViewGroup.blurb);
      localTextView2.setVisibility(0);
      break;
      label417:
      localTextView4.setVisibility(0);
      localTextView4.setText(paramViewGroup.content);
      break label245;
      label435:
      localTextView3.setVisibility(8);
      localTextView3.setOnClickListener(null);
    }
  }
  
  public BaseViewHolder a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder = new BaseViewHolder(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561775, paramViewGroup, false));
    return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder;
  }
  
  public String a()
  {
    return "BannerProfileSegment";
  }
  
  public void a(DetailEventCallback paramDetailEventCallback)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailEventCallback = paramDetailEventCallback;
  }
  
  public void a(DetailFeedItem paramDetailFeedItem)
  {
    SLog.a("Q.qqstory.detail.BannerProfileSegment", "set data: detail feed item = %s.", paramDetailFeedItem);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem = paramDetailFeedItem;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder == null) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder.a().getMeasuredHeight();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      StoryApi.a(this.jdField_a_of_type_AndroidContentContext, 4, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.ownerId);
      StoryReportor.a("home_page", "clk_head_nick", StoryReportor.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a), 0, new String[] { String.valueOf(StoryReportor.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a)), "2", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.feedId, "" });
      continue;
      ((QQStoryHandler)PlayModeUtils.a().getBusinessHandler(BusinessHandlerFactory.QQSTORY_HANDLER)).a(1, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.ownerId, 0, 13);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a().getOwner().isSubscribe = 1;
      paramView.setVisibility(4);
      StoryReportor.a("home_page", "follow_recom", 0, 0, new String[] { "3", "2", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a().getOwner().getUnionId(), this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a().feedId });
      continue;
      SLog.a("Q.qqstory.detail.BannerProfileSegment", "click banner feed and jump to %s", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a().schema);
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a().schema.startsWith("mqqapi:"))
      {
        QQStoryContext.a();
        JumpParser.a((QQAppInterface)QQStoryContext.a(), this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a().schema).a();
      }
      else if (!NetworkUtils.a(this.jdField_a_of_type_AndroidContentContext))
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, HardCodeUtil.a(2131701008), 0).a();
      }
      else
      {
        Object localObject = new Intent(paramView.getContext(), QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a().schema);
        this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
        continue;
        localObject = (String)paramView.getTag();
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
          localIntent.putExtra("url", (String)localObject);
          this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.segment.BannerProfileSegment
 * JD-Core Version:    0.7.0.1
 */
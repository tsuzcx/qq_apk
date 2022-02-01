package com.tencent.biz.qqstory.playvideo.floatdialog;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.view.segment.SegmentView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class PlayerDoubleTabSegment
  extends SegmentView
  implements View.OnClickListener
{
  public static final String KEY = "PlayerDoubleTabSegment";
  private int jdField_a_of_type_Int = 1;
  private CommentFloatDialogController jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogController;
  private DetailFeedItem jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem;
  private BaseViewHolder jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder;
  
  public PlayerDoubleTabSegment(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(TextView paramTextView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (QQStoryContext.a()) {
        paramTextView.setBackgroundResource(2130846823);
      }
      for (;;)
      {
        paramTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166501));
        return;
        paramTextView.setBackgroundResource(2130846822);
      }
    }
    paramTextView.setBackgroundResource(0);
    if (QQStoryContext.a())
    {
      paramTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166514));
      return;
    }
    paramTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166502));
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem != null) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.b())) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup)
  {
    paramViewGroup = (TextView)paramBaseViewHolder.a(2131378509);
    TextView localTextView = (TextView)paramBaseViewHolder.a(2131378508);
    if (QQStoryContext.a())
    {
      paramViewGroup.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166512));
      localTextView.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166512));
      paramBaseViewHolder.a(2131374953).setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166514));
    }
    if (this.jdField_a_of_type_Int == 1)
    {
      a(paramViewGroup, true);
      a(localTextView, false);
    }
    for (;;)
    {
      return paramBaseViewHolder.a();
      a(paramViewGroup, false);
      a(localTextView, true);
    }
  }
  
  public BaseViewHolder a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder = new BaseViewHolder(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561778, paramViewGroup, false));
    paramViewGroup = (TextView)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder.a(2131378509);
    TextView localTextView = (TextView)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder.a(2131378508);
    paramViewGroup.setOnClickListener(this);
    localTextView.setOnClickListener(this);
    return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder;
  }
  
  public String a()
  {
    return "PlayerDoubleTabSegment";
  }
  
  public void a(CommentFloatDialogController paramCommentFloatDialogController)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogController = paramCommentFloatDialogController;
  }
  
  public void a(DetailFeedItem paramDetailFeedItem)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem = paramDetailFeedItem;
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a()) {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogController.a();
    }
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
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogController.a(1);
      StoryReportor.a("content_flow", "clk_detail_reply", 0, 1, new String[] { "", StoryReportor.a(4444), this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.feedId });
      continue;
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogController.a(2);
      StoryReportor.a("content_flow", "clk_detail_reply", 0, 2, new String[] { "", StoryReportor.a(4444), this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.feedId });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.floatdialog.PlayerDoubleTabSegment
 * JD-Core Version:    0.7.0.1
 */
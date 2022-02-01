package com.tencent.biz.qqstory.playvideo.floatdialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.view.segment.SegmentView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class PlayerCommentTitleSegment
  extends SegmentView
  implements View.OnClickListener
{
  public static final String KEY = "PlayerCommentTitleSegment";
  private PlayerCommentEventCallback jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogPlayerCommentEventCallback;
  private DetailFeedItem jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem;
  private BaseViewHolder jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder;
  
  public PlayerCommentTitleSegment(Context paramContext)
  {
    super(paramContext);
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem != null) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup)
  {
    paramViewGroup = (TextView)paramBaseViewHolder.a(2131378784);
    paramViewGroup = (ImageView)paramBaseViewHolder.a(2131364711);
    return paramBaseViewHolder.a();
  }
  
  public BaseViewHolder a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder = new BaseViewHolder(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561740, paramViewGroup, false));
    paramViewGroup = (ImageView)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder.a(2131364711);
    TextView localTextView = (TextView)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder.a(2131378784);
    paramViewGroup.setOnClickListener(this);
    localTextView.setOnClickListener(this);
    return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder;
  }
  
  public String a()
  {
    return "PlayerCommentTitleSegment";
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131364711)
    {
      PlayerCommentEventCallback localPlayerCommentEventCallback = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogPlayerCommentEventCallback;
      if (localPlayerCommentEventCallback != null) {
        localPlayerCommentEventCallback.a();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.floatdialog.PlayerCommentTitleSegment
 * JD-Core Version:    0.7.0.1
 */
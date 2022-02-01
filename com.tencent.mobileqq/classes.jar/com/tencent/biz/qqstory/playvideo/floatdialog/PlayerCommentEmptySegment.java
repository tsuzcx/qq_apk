package com.tencent.biz.qqstory.playvideo.floatdialog;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.view.segment.SegmentView;
import java.util.List;

public class PlayerCommentEmptySegment
  extends SegmentView
{
  public static final String KEY = "PlayerCommentEmptySegment";
  private View jdField_a_of_type_AndroidViewView;
  private CommentFloatDialogController jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogController;
  public DetailFeedItem a;
  private boolean b = true;
  
  public PlayerCommentEmptySegment(Context paramContext)
  {
    super(paramContext);
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogController == null) || (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogController.a());
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_Boolean) && ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem == null) || (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a(b()).size() == 0))) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup)
  {
    if (this.b) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    for (;;)
    {
      return paramBaseViewHolder.a();
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public BaseViewHolder a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561889, paramViewGroup, false);
    this.jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131370761);
    if (QQStoryContext.a()) {
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166512));
    }
    return new BaseViewHolder(paramViewGroup);
  }
  
  public String a()
  {
    return "PlayerCommentEmptySegment";
  }
  
  public void a(CommentFloatDialogController paramCommentFloatDialogController)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogController = paramCommentFloatDialogController;
  }
  
  public void a(DetailFeedItem paramDetailFeedItem)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem = paramDetailFeedItem;
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.floatdialog.PlayerCommentEmptySegment
 * JD-Core Version:    0.7.0.1
 */
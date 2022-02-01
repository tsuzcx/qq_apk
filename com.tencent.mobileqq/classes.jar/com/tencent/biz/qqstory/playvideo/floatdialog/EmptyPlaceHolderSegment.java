package com.tencent.biz.qqstory.playvideo.floatdialog;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.view.segment.SegmentView;
import com.tencent.widget.AbsListView.LayoutParams;

public class EmptyPlaceHolderSegment
  extends SegmentView
{
  public static final String KEY = "EmptyPlaceHolderSegment";
  private final int jdField_a_of_type_Int;
  private BaseViewHolder jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder;
  
  public EmptyPlaceHolderSegment(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return 1;
  }
  
  public View a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup)
  {
    return paramBaseViewHolder.a();
  }
  
  public BaseViewHolder a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new View(this.jdField_a_of_type_AndroidContentContext);
    paramViewGroup.setLayoutParams(new AbsListView.LayoutParams(-1, this.jdField_a_of_type_Int));
    if (QQStoryContext.a()) {
      paramViewGroup.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166512));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder = new BaseViewHolder(paramViewGroup);
      return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder;
      paramViewGroup.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165559));
    }
  }
  
  public String a()
  {
    return "EmptyPlaceHolderSegment";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.floatdialog.EmptyPlaceHolderSegment
 * JD-Core Version:    0.7.0.1
 */
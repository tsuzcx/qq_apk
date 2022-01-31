package com.tencent.biz.qqstory.storyHome.memory.view.segment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.view.segment.SegmentList;
import com.tencent.biz.qqstory.view.segment.SegmentView;

public class MemoriesVideoListEmptySegment
  extends SegmentView
{
  public static final String KEY = "MemoriesVideoListEmptySegment";
  
  public MemoriesVideoListEmptySegment(Context paramContext, int paramInt, String paramString)
  {
    super(paramContext);
  }
  
  private void f()
  {
    SegmentView localSegmentView = a().a("MemoriesVideoListSegment");
    if ((localSegmentView != null) && (localSegmentView.a() == 0))
    {
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void E_()
  {
    f();
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup)
  {
    paramInt = UIUtils.b(this.jdField_a_of_type_AndroidContentContext);
    int i = UIUtils.c(this.jdField_a_of_type_AndroidContentContext);
    int j = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 225.0F);
    int k = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 50.0F);
    paramBaseViewHolder.a().getLayoutParams().height = (paramInt - i - j - k);
    return paramBaseViewHolder.a();
  }
  
  public BaseViewHolder a(int paramInt, ViewGroup paramViewGroup)
  {
    return new BaseViewHolder(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130970727, paramViewGroup, false));
  }
  
  public String a()
  {
    return "MemoriesVideoListEmptySegment";
  }
  
  protected void c()
  {
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.view.segment.MemoriesVideoListEmptySegment
 * JD-Core Version:    0.7.0.1
 */
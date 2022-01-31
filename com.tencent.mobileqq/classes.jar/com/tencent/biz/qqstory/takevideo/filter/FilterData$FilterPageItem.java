package com.tencent.biz.qqstory.takevideo.filter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

public abstract class FilterData$FilterPageItem
{
  protected int a;
  public final View a;
  public FilterData a;
  
  public FilterData$FilterPageItem(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewView = a(paramContext, paramViewGroup);
    if (this.jdField_a_of_type_AndroidViewView == null) {
      throw new NullPointerException("onCreateView can not return null");
    }
  }
  
  public abstract View a(@NonNull Context paramContext, ViewGroup paramViewGroup);
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoFilterFilterData = null;
    this.jdField_a_of_type_Int = -1;
  }
  
  public void a(FilterData paramFilterData, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoFilterFilterData = paramFilterData;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoFilterFilterData != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoFilterFilterData.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.filter.FilterData.FilterPageItem
 * JD-Core Version:    0.7.0.1
 */
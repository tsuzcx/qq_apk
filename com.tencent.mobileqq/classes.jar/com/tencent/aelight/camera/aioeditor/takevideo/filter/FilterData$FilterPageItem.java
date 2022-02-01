package com.tencent.aelight.camera.aioeditor.takevideo.filter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

public abstract class FilterData$FilterPageItem<T extends FilterData>
{
  protected int a;
  public final View a;
  public T a;
  
  protected FilterData$FilterPageItem(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewView = a(paramContext, paramViewGroup);
    if (this.jdField_a_of_type_AndroidViewView != null) {
      return;
    }
    throw new NullPointerException("onCreateView can not return null");
  }
  
  protected abstract View a(@NonNull Context paramContext, ViewGroup paramViewGroup);
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoFilterFilterData = null;
    this.jdField_a_of_type_Int = -1;
  }
  
  public void a(T paramT, int paramInt)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoFilterFilterData = paramT;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public boolean a()
  {
    FilterData localFilterData = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoFilterFilterData;
    return (localFilterData != null) && (localFilterData.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.filter.FilterData.FilterPageItem
 * JD-Core Version:    0.7.0.1
 */
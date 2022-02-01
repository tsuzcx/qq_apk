package com.tencent.aelight.camera.aioeditor.takevideo.filter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

public abstract class FilterData$FilterPageItem<T extends FilterData>
{
  public final View a = a(paramContext, paramViewGroup);
  public T b;
  protected int c;
  
  protected FilterData$FilterPageItem(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    if (this.a != null) {
      return;
    }
    throw new NullPointerException("onCreateView can not return null");
  }
  
  protected abstract View a(@NonNull Context paramContext, ViewGroup paramViewGroup);
  
  public void a()
  {
    this.b = null;
    this.c = -1;
  }
  
  public void a(T paramT, int paramInt)
  {
    this.b = paramT;
    this.c = paramInt;
  }
  
  public boolean b()
  {
    FilterData localFilterData = this.b;
    return (localFilterData != null) && (localFilterData.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.filter.FilterData.FilterPageItem
 * JD-Core Version:    0.7.0.1
 */
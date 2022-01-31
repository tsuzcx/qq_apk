package com.tencent.biz.qqstory.takevideo.filter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import okp;

public class TimeFilterData
  extends FilterData
{
  public EditVideoParams a;
  public String c;
  
  public TimeFilterData(int paramInt1, String paramString, int paramInt2)
  {
    super(paramInt1, paramString, paramInt2);
  }
  
  public TimeFilterData(int paramInt1, String paramString, int paramInt2, EditVideoParams paramEditVideoParams)
  {
    super(paramInt1, paramString, paramInt2);
    this.a = paramEditVideoParams;
  }
  
  @NonNull
  public FilterData.FilterPageItem a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return new okp(this, paramContext, paramViewGroup, null);
  }
  
  @NonNull
  public Class a()
  {
    return okp.class;
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.filter.TimeFilterData
 * JD-Core Version:    0.7.0.1
 */
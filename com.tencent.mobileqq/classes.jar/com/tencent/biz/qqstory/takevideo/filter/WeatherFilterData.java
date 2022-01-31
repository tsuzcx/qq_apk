package com.tencent.biz.qqstory.takevideo.filter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.support.logging.SLog;
import opf;

public class WeatherFilterData
  extends FilterData
{
  public int c;
  
  public WeatherFilterData(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramString, paramInt2);
    this.c = paramInt3;
  }
  
  @NonNull
  public FilterData.FilterPageItem a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return new opf(this, paramContext, paramViewGroup);
  }
  
  @NonNull
  public Class a()
  {
    return opf.class;
  }
  
  public void a(int paramInt)
  {
    SLog.a("WeatherFilterData", "updateWeather:%s", Integer.valueOf(paramInt));
    this.c = paramInt;
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.filter.WeatherFilterData
 * JD-Core Version:    0.7.0.1
 */
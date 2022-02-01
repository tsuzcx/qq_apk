package com.tencent.aelight.camera.aioeditor.takevideo.filter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

public abstract class FilterData
{
  public final int a;
  public final String b;
  public final int c;
  public String d;
  
  public FilterData(int paramInt1, String paramString, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramString;
    this.c = paramInt2;
  }
  
  @NonNull
  public abstract FilterData.FilterPageItem a(@NonNull Context paramContext, ViewGroup paramViewGroup);
  
  public boolean a()
  {
    return false;
  }
  
  @NonNull
  public abstract Class<? extends FilterData.FilterPageItem> b();
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Filter:{");
    localStringBuilder.append(this.b);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.filter.FilterData
 * JD-Core Version:    0.7.0.1
 */
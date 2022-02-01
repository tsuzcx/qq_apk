package com.tencent.aelight.camera.aioeditor.takevideo.filter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

public abstract class FilterData
{
  public final int a;
  public final String a;
  public final int b;
  public String b;
  
  public FilterData(int paramInt1, String paramString, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.b = paramInt2;
  }
  
  @NonNull
  public abstract FilterData.FilterPageItem a(@NonNull Context paramContext, ViewGroup paramViewGroup);
  
  @NonNull
  public abstract Class<? extends FilterData.FilterPageItem> a();
  
  public boolean a()
  {
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Filter:{");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.filter.FilterData
 * JD-Core Version:    0.7.0.1
 */
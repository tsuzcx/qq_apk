package com.tencent.biz.qqstory.takevideo.filter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.model.filter.PictureFilterConfig;

public class PictureFilterData
  extends FilterData
{
  @NonNull
  public final PictureFilterConfig a;
  @NonNull
  public final String c;
  
  public PictureFilterData(int paramInt1, String paramString1, int paramInt2, @NonNull String paramString2, @NonNull PictureFilterConfig paramPictureFilterConfig)
  {
    super(paramInt1, paramString1, paramInt2);
    this.c = paramString2;
    this.a = paramPictureFilterConfig;
  }
  
  @NonNull
  public FilterData.FilterPageItem a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return new PictureFilterData.PictureFilterItem(paramContext, paramViewGroup, null);
  }
  
  @NonNull
  public Class a()
  {
    return PictureFilterData.PictureFilterItem.class;
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.filter.PictureFilterData
 * JD-Core Version:    0.7.0.1
 */
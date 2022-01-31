package com.tencent.biz.qqstory.takevideo.filter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

public class VideoEffectsFilterData
  extends FilterData
{
  public final int c;
  
  public VideoEffectsFilterData(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt3, paramString, paramInt1);
    this.c = paramInt2;
  }
  
  @NonNull
  public FilterData.FilterPageItem a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return new VideoEffectsFilterData.VideoEffectsFilterPageItem(this, paramContext, paramViewGroup);
  }
  
  @NonNull
  public Class a()
  {
    return VideoEffectsFilterData.VideoEffectsFilterPageItem.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.filter.VideoEffectsFilterData
 * JD-Core Version:    0.7.0.1
 */
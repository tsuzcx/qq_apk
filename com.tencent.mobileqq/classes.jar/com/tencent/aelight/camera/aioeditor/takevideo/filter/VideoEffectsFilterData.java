package com.tencent.aelight.camera.aioeditor.takevideo.filter;

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
  public Class<? extends FilterData.FilterPageItem> a()
  {
    return VideoEffectsFilterData.VideoEffectsFilterPageItem.class;
  }
  
  public String toString()
  {
    int i = this.a;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 8)
            {
              if (i != 9) {
                return "";
              }
              return "very slow";
            }
            return "little fast";
          }
          return "slow";
        }
        return "fast";
      }
      return "rewind";
    }
    return "normal";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.filter.VideoEffectsFilterData
 * JD-Core Version:    0.7.0.1
 */
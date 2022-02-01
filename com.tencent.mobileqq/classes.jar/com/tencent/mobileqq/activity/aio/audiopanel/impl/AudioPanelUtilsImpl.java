package com.tencent.mobileqq.activity.aio.audiopanel.impl;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.activity.aio.audiopanel.IAudioPanelUtils;

public class AudioPanelUtilsImpl
  implements IAudioPanelUtils
{
  private static final int LEVEL_OFFSET = arrayOfInt[1] - arrayOfInt[0];
  private static final int[] VOLUME_LEVELS = { 1038, 1948, 2857, 3766, 4675, 5584, 6493, 7402, 8311, 10000 };
  
  static
  {
    int[] arrayOfInt = VOLUME_LEVELS;
  }
  
  public String getTimeStrByMillis(double paramDouble)
  {
    int i;
    if (paramDouble < 1000.0D) {
      i = 0;
    } else {
      i = (int)(paramDouble / 1000.0D + 0.5D);
    }
    int j = i / 60;
    i %= 60;
    if (i < 10)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(j);
      localStringBuilder.append(":0");
      localStringBuilder.append(i);
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(j);
    localStringBuilder.append(":");
    localStringBuilder.append(i);
    return localStringBuilder.toString();
  }
  
  public int getTitleBarHeight(Context paramContext)
  {
    return paramContext.getResources().getDimensionPixelSize(2131299168);
  }
  
  public int getVolumeLevel(int paramInt)
  {
    int i = 32000;
    if (paramInt < 5000) {
      paramInt = 4000;
    } else if (paramInt < 8000) {
      paramInt = 8000;
    } else if (paramInt < 10000) {
      paramInt = 10000;
    } else if (paramInt < 14000) {
      paramInt = 13000;
    } else if (paramInt < 18000) {
      paramInt = 16000;
    } else if (paramInt < 23000) {
      paramInt = 19000;
    } else if (paramInt < 27000) {
      paramInt = 22000;
    } else if (paramInt < 32000) {
      paramInt = 25000;
    } else if (paramInt < 35000) {
      paramInt = 28000;
    } else if (paramInt < 40000) {
      paramInt = i;
    } else {
      paramInt = 40000;
    }
    paramInt = Math.min((int)(paramInt * 0.3F / LEVEL_OFFSET), VOLUME_LEVELS.length - 1);
    return VOLUME_LEVELS[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.impl.AudioPanelUtilsImpl
 * JD-Core Version:    0.7.0.1
 */
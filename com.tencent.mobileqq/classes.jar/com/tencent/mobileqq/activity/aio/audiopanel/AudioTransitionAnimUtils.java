package com.tencent.mobileqq.activity.aio.audiopanel;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;

public class AudioTransitionAnimUtils
{
  public static float a(float paramFloat, int paramInt)
  {
    return Math.abs(paramFloat) / paramInt;
  }
  
  public static int a(int paramInt)
  {
    int i = paramInt;
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
      i = paramInt + 100;
    }
    return i;
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    int i = 2;
    if ((paramInt1 == 0) && (paramInt2 == 1)) {}
    do
    {
      paramInt1 = 1;
      break;
      if ((paramInt1 == 1) && (paramInt2 == 0))
      {
        paramInt1 = i;
        break;
      }
      if ((paramInt1 == 1) && (paramInt2 == 2))
      {
        paramInt1 = 3;
        break;
      }
      if ((paramInt1 == 2) && (paramInt2 == 1))
      {
        paramInt1 = 4;
        break;
      }
      if ((paramInt1 == 0) && (paramInt2 == 2))
      {
        paramInt1 = 7;
        break;
      }
    } while ((paramInt1 != 2) || (paramInt2 != 0));
    paramInt1 = 6;
    try
    {
      boolean bool = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
      paramInt2 = paramInt1;
      if (bool) {
        paramInt2 = paramInt1 + 100;
      }
      return paramInt2;
    }
    catch (Exception localException) {}
    return paramInt1;
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 4) || (paramInt == 7) || (paramInt == 203) || (paramInt == 104) || (paramInt == 107) || (paramInt == 303);
  }
  
  public static boolean b(int paramInt)
  {
    return paramInt <= 107;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.AudioTransitionAnimUtils
 * JD-Core Version:    0.7.0.1
 */
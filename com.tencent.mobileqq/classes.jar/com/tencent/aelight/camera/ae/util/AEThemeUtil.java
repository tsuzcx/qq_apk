package com.tencent.aelight.camera.ae.util;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;

public class AEThemeUtil
{
  private static boolean a = false;
  
  public static void a()
  {
    a = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
  }
  
  public static boolean a()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.util.AEThemeUtil
 * JD-Core Version:    0.7.0.1
 */
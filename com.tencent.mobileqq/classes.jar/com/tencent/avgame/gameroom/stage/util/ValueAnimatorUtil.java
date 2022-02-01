package com.tencent.avgame.gameroom.stage.util;

import android.animation.ValueAnimator;
import android.support.annotation.NonNull;
import java.lang.reflect.Field;

public class ValueAnimatorUtil
{
  @NonNull
  private static Field a()
  {
    Field localField = ValueAnimator.class.getDeclaredField("sDurationScale");
    localField.setAccessible(true);
    return localField;
  }
  
  public static void a()
  {
    try
    {
      a().setFloat(null, 1.0F);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.util.ValueAnimatorUtil
 * JD-Core Version:    0.7.0.1
 */
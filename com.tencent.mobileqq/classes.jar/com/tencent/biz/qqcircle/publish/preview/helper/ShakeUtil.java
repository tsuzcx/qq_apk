package com.tencent.biz.qqcircle.publish.preview.helper;

import android.content.Context;
import android.os.Vibrator;

public class ShakeUtil
{
  public static void a(Context paramContext, long paramLong)
  {
    ((Vibrator)paramContext.getSystemService("vibrator")).vibrate(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.preview.helper.ShakeUtil
 * JD-Core Version:    0.7.0.1
 */
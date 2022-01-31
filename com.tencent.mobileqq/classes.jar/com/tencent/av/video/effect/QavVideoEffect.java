package com.tencent.av.video.effect;

import android.content.Context;

public class QavVideoEffect
{
  public static boolean DEBUG_MODE = false;
  private static volatile QavVideoEffect mInstance;
  
  QavVideoEffect(Context paramContext) {}
  
  public static QavVideoEffect getInstance(Context paramContext)
  {
    if (mInstance == null) {}
    try
    {
      if (mInstance == null) {
        mInstance = new QavVideoEffect(paramContext);
      }
      return mInstance;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.video.effect.QavVideoEffect
 * JD-Core Version:    0.7.0.1
 */
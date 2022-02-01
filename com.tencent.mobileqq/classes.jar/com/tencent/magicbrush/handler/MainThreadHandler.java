package com.tencent.magicbrush.handler;

import android.os.Handler;
import androidx.annotation.Keep;
import com.tencent.luggage.wxa.gk.f;

@Keep
public class MainThreadHandler
{
  private static native void nativeDoTask(long paramLong1, long paramLong2);
  
  @Keep
  public static void post(long paramLong1, long paramLong2, int paramInt)
  {
    f.a().post(new MainThreadHandler.a(paramInt, paramLong1, paramLong2, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.handler.MainThreadHandler
 * JD-Core Version:    0.7.0.1
 */
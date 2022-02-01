package com.tencent.luggage.wxa.sc;

import android.os.HandlerThread;
import androidx.annotation.NonNull;

public class c
  extends a
{
  public static Thread a(@NonNull String paramString, @NonNull Runnable paramRunnable, int paramInt)
  {
    paramString = a(paramString, paramRunnable);
    paramString.setPriority(paramInt);
    return paramString;
  }
  
  public static HandlerThread b(@NonNull String paramString)
  {
    return a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.sc.c
 * JD-Core Version:    0.7.0.1
 */
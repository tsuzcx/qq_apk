package com.tencent.luggage.wxa.sc;

import android.os.HandlerThread;
import androidx.annotation.NonNull;
import androidx.core.math.MathUtils;
import java.util.concurrent.ConcurrentLinkedQueue;

public class a
{
  private static ConcurrentLinkedQueue<Long> a = new ConcurrentLinkedQueue();
  
  static HandlerThread a(String paramString)
  {
    return a(paramString, 5);
  }
  
  static HandlerThread a(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[GT]");
    localStringBuilder.append(paramString);
    paramString = new a.3(localStringBuilder.toString());
    paramString.setPriority(MathUtils.clamp(paramInt, 1, 10));
    return paramString;
  }
  
  static Thread a(@NonNull String paramString, @NonNull Runnable paramRunnable)
  {
    paramRunnable = new a.1(paramRunnable);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[GT]");
    localStringBuilder.append(paramString);
    return new a.2(paramRunnable, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.sc.a
 * JD-Core Version:    0.7.0.1
 */
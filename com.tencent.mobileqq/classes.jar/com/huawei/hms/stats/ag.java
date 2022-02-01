package com.huawei.hms.stats;

import android.util.Log;

public class ag
{
  private boolean a = false;
  private int b = 4;
  
  private static String a()
  {
    return "HiAnalyticsSDK_2.2.0.305" + br.a();
  }
  
  public void a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('\n');
    localStringBuilder.append("=======================================\n ").append(a()).append("").append("\n=======================================");
    Log.i("HiAnalyticsSDK", localStringBuilder.toString());
    this.b = paramInt;
    this.a = true;
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    b(paramInt, "HiAnalyticsSDK", paramString1 + "=> " + paramString2);
  }
  
  public void b(int paramInt, String paramString1, String paramString2)
  {
    switch (paramInt)
    {
    default: 
      Log.i(paramString1, paramString2);
      return;
    case 3: 
      Log.d(paramString1, paramString2);
      return;
    case 4: 
      Log.i(paramString1, paramString2);
      return;
    case 5: 
      Log.w(paramString1, paramString2);
      return;
    }
    Log.e(paramString1, paramString2);
  }
  
  public boolean b(int paramInt)
  {
    return (this.a) && (paramInt >= this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.stats.ag
 * JD-Core Version:    0.7.0.1
 */
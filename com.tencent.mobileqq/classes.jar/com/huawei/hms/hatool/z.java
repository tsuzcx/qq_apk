package com.huawei.hms.hatool;

import android.util.Log;

public class z
{
  public boolean a = false;
  public int b = 4;
  
  public static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("HiAnalyticsSDK_2.2.0.308");
    localStringBuilder.append(i1.a());
    return localStringBuilder.toString();
  }
  
  public void a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('\n');
    localStringBuilder.append("=======================================\n ");
    localStringBuilder.append(a());
    localStringBuilder.append("");
    localStringBuilder.append("\n=======================================");
    Log.i("HiAnalyticsSDK", localStringBuilder.toString());
    this.b = paramInt;
    this.a = true;
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (paramInt != 3)
    {
      if (paramInt != 5)
      {
        if (paramInt != 6)
        {
          Log.i(paramString1, paramString2);
          return;
        }
        Log.e(paramString1, paramString2);
        return;
      }
      Log.w(paramString1, paramString2);
      return;
    }
    Log.d(paramString1, paramString2);
  }
  
  public void b(int paramInt, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("=> ");
    localStringBuilder.append(paramString2);
    a(paramInt, "HiAnalyticsSDK", localStringBuilder.toString());
  }
  
  public boolean b(int paramInt)
  {
    return (this.a) && (paramInt >= this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.hatool.z
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.app;

import android.app.Activity;
import com.tencent.mobileqq.activity.SplashActivity;
import mqq.app.Foreground;

public class ProcessUtil
{
  public static String a()
  {
    Activity localActivity = Foreground.getTopActivity();
    if (localActivity != null)
    {
      String str = localActivity.getClass().getName();
      Object localObject = str;
      if ((localActivity instanceof SplashActivity))
      {
        if (SplashActivity.currentFragment == 1)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append("_");
          ((StringBuilder)localObject).append(((SplashActivity)localActivity).getCurrentTab());
          return ((StringBuilder)localObject).toString();
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append("_ChatFragment");
        localObject = ((StringBuilder)localObject).toString();
      }
      return localObject;
    }
    return "Null";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.ProcessUtil
 * JD-Core Version:    0.7.0.1
 */
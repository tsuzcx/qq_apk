package com.huawei.hms.hatool;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.UserManager;

public class u0
{
  public static u0 c = new u0();
  public boolean a = false;
  public Context b = b.f();
  
  public static u0 b()
  {
    return c;
  }
  
  @TargetApi(24)
  public boolean a()
  {
    if (!this.a)
    {
      Object localObject = this.b;
      if (localObject == null) {
        return false;
      }
      boolean bool;
      if (Build.VERSION.SDK_INT >= 24)
      {
        localObject = (UserManager)((Context)localObject).getSystemService("user");
        if (localObject != null)
        {
          bool = ((UserManager)localObject).isUserUnlocked();
        }
        else
        {
          this.a = false;
          break label63;
        }
      }
      else
      {
        bool = true;
      }
      this.a = bool;
    }
    label63:
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.hatool.u0
 * JD-Core Version:    0.7.0.1
 */
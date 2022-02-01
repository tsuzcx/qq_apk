package com.huawei.hms.stats;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.UserManager;

public class bd
{
  private static bd a = new bd();
  private boolean b = false;
  private Context c = b.j();
  
  public static bd a()
  {
    return a;
  }
  
  @TargetApi(24)
  public boolean b()
  {
    if (!this.b)
    {
      if (this.c == null) {
        return false;
      }
      if (Build.VERSION.SDK_INT < 24) {
        break label62;
      }
      UserManager localUserManager = (UserManager)this.c.getSystemService("user");
      if (localUserManager == null) {
        break label54;
      }
      this.b = localUserManager.isUserUnlocked();
    }
    for (;;)
    {
      return this.b;
      label54:
      this.b = false;
      continue;
      label62:
      this.b = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.stats.bd
 * JD-Core Version:    0.7.0.1
 */
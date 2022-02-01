package com.tencent.map.sdk.a;

import android.text.TextUtils;

final class bz
  implements Runnable
{
  bz(by paramby) {}
  
  public final void run()
  {
    String str = dc.b("settings_in_client", "");
    if (!TextUtils.isEmpty(str)) {}
    try
    {
      this.a.a.a(str);
      this.a.a();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      dc.a("settings_in_client", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.map.sdk.a.bz
 * JD-Core Version:    0.7.0.1
 */
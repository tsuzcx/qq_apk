package com.tencent.map.sdk.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;

final class cp
  implements Runnable
{
  cp(co paramco) {}
  
  public final void run()
  {
    String str = ac.a().getSharedPreferences(co.d(), 0).getString("halley_cloud_param_content", "");
    if (!TextUtils.isEmpty(str)) {}
    try
    {
      this.a.a.a(str);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      ac.a().getSharedPreferences(co.d(), 0).edit().putString("halley_cloud_param_content", "").commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.cp
 * JD-Core Version:    0.7.0.1
 */
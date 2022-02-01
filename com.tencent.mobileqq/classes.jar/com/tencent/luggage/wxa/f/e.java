package com.tencent.luggage.wxa.f;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class e
{
  private static e a;
  private Context b;
  private SharedPreferences c;
  
  private e(Context paramContext)
  {
    this.b = paramContext;
    this.c = paramContext.getSharedPreferences("camera", 0);
  }
  
  public static e a()
  {
    return a;
  }
  
  public static void a(Context paramContext)
  {
    if (a == null) {
      a = new e(paramContext);
    }
  }
  
  public void b()
  {
    SharedPreferences localSharedPreferences = this.c;
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putBoolean("key_use_camera1", true).apply();
    }
  }
  
  public boolean c()
  {
    SharedPreferences localSharedPreferences = this.c;
    if (localSharedPreferences != null) {
      return localSharedPreferences.getBoolean("key_use_camera1", false);
    }
    return false;
  }
  
  public int d()
  {
    SharedPreferences localSharedPreferences = this.c;
    if (localSharedPreferences != null) {
      return localSharedPreferences.getInt("support_egl_context_client_version", 3);
    }
    return 3;
  }
  
  public Context e()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.f.e
 * JD-Core Version:    0.7.0.1
 */
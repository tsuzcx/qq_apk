package com.tencent.beacon.core.e;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.beacon.core.a.f;

final class a
  implements Runnable
{
  a(Context paramContext, String paramString, long paramLong) {}
  
  public void run()
  {
    SharedPreferences localSharedPreferences = f.a(this.a).c();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putLong(this.b, this.c).apply();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.e.a
 * JD-Core Version:    0.7.0.1
 */
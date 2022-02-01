package com.tencent.bugly.proguard;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

final class n$1
  implements Runnable
{
  n$1(n paramn, int paramInt) {}
  
  public final void run()
  {
    boolean bool = n.a(this.b, this.a);
    SharedPreferences.Editor localEditor = n.b(this.b).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append("_");
    localStringBuilder.append(n.a(this.b));
    localEditor.putBoolean(localStringBuilder.toString(), bool ^ true).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.bugly.proguard.n.1
 * JD-Core Version:    0.7.0.1
 */
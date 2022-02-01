package com.tencent.luggage.wxa.or;

import android.app.Activity;
import android.os.Build.VERSION;
import androidx.annotation.NonNull;
import java.lang.reflect.Proxy;

public class j$a
{
  private static j a()
  {
    j.a.1 local1 = new j.a.1();
    return (j)Proxy.newProxyInstance(j.class.getClassLoader(), new Class[] { j.class }, local1);
  }
  
  @NonNull
  public static j a(Activity paramActivity)
  {
    if (paramActivity == null) {
      return a();
    }
    if (Build.VERSION.SDK_INT >= 28) {
      return new k(paramActivity);
    }
    return new l(paramActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.or.j.a
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.luggage.wxa.on;

import android.text.TextUtils;
import androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback;
import com.tencent.luggage.wxa.pc.h;
import com.tencent.luggage.wxa.qz.o;
import java.util.Collection;
import java.util.Iterator;

public class n
{
  private static final h<String, ActivityCompat.OnRequestPermissionsResultCallback> a = new h();
  
  public static void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      o.b("Luggage.RequestPermissionRegistry", "removeCallbacks fail, invalid arguments");
      return;
    }
    a.b(paramString);
  }
  
  public static void a(String paramString, int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt, boolean paramBoolean)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      paramString = a.a(paramString);
      if (paramString != null)
      {
        Iterator localIterator = paramString.iterator();
        while (localIterator.hasNext()) {
          ((ActivityCompat.OnRequestPermissionsResultCallback)localIterator.next()).onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
        }
        if (paramBoolean) {
          paramString.clear();
        }
      }
      return;
    }
    o.b("Luggage.RequestPermissionRegistry", "removeCallback fail, invalid id");
  }
  
  public static void a(String paramString, ActivityCompat.OnRequestPermissionsResultCallback paramOnRequestPermissionsResultCallback)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramOnRequestPermissionsResultCallback != null))
    {
      a.a(paramString, paramOnRequestPermissionsResultCallback);
      return;
    }
    o.b("Luggage.RequestPermissionRegistry", "addCallback fail, invalid arguments");
  }
  
  @Deprecated
  public static void b(String paramString, ActivityCompat.OnRequestPermissionsResultCallback paramOnRequestPermissionsResultCallback)
  {
    a(paramString, paramOnRequestPermissionsResultCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.on.n
 * JD-Core Version:    0.7.0.1
 */
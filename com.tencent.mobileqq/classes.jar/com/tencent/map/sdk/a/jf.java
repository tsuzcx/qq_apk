package com.tencent.map.sdk.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import java.lang.ref.WeakReference;

public final class jf
{
  Context a;
  WeakReference<jf.a> b;
  
  public jf(Context paramContext, jf.a parama)
  {
    this.a = paramContext;
    this.b = new WeakReference(parama);
  }
  
  static String a(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    String str = paramContext.getPackageName();
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(str, 128);
      if (paramContext == null) {
        return "";
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        paramContext = null;
      }
      if (paramContext.metaData == null) {
        return "";
      }
    }
    return paramContext.metaData.getString("TencentMapSDK");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.jf
 * JD-Core Version:    0.7.0.1
 */
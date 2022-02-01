package com.tencent.luggage.wxa.re;

import android.content.Context;
import android.content.pm.PackageManager;

public class e
{
  public static boolean a(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    return paramContext.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.re.e
 * JD-Core Version:    0.7.0.1
 */
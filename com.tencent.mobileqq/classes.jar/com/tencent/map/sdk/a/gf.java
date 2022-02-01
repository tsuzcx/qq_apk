package com.tencent.map.sdk.a;

import android.content.Context;

public class gf
  extends gc
{
  private static volatile gf b;
  
  private gf(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    this.a = paramContext.getSharedPreferences("com.tencent.tencentmap.mapsdk.maps.offlinemap", 0);
    if (b != null)
    {
      a(new String[] { "taiwanClearCacheVersion", "taiwanStyle", "taiwanVersion", "mapPoiIcon", "worldTileCount" });
      paramContext = a("sdkVersion");
      if ((paramContext != null) && (fz.a("4.1.0", paramContext) > 0)) {
        a();
      }
    }
  }
  
  public static gf a(Context paramContext)
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new gf(paramContext);
        }
      }
      finally {}
    }
    return b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.gf
 * JD-Core Version:    0.7.0.1
 */
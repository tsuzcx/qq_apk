package com.tencent.map.sdk.a;

import android.content.Context;
import com.tencent.tencentmap.io.QStorageManager;

public final class hy
{
  private static boolean a = false;
  
  public static void a(Context paramContext, int paramInt)
  {
    if (gf.a(paramContext).b("mapConfigStyle") != paramInt)
    {
      a = true;
      return;
    }
    a = false;
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if (paramContext == null) {}
    gf localgf;
    int i;
    do
    {
      return;
      paramString = QStorageManager.getInstance(paramContext).getConfigPath(paramString);
      localgf = gf.a(paramContext);
      if (fz.a(localgf.a("sdkVersion"), "4.0.9.1") < 0) {
        localgf.a(new String[] { "mapConfigIndoorVersion", "mapPoiIcon3dIndoorVersion" });
      }
      i = fz.a("4.2.8.1", localgf.a("sdkVersion"));
      gd.a(paramContext, paramString, "mapconfig.dat", "mapconfig.dat");
      gd.a(paramContext, paramString, "poi_icon@2x.png", "poi_icon@2x.png");
      gd.a(paramContext, paramString, "poi_icon_nav@2x.png", "poi_icon_nav@2x.png");
      gd.a(paramContext, paramString, "poi_icon_dark@2x.png", "poi_icon_dark@2x.png");
      gd.a(paramContext, paramString, "rtt_config.json", "rtt_config.json");
      gd.a(paramContext, paramString, "indoormap_config.dat", "indoormap_config.dat");
      gd.a(paramContext, paramString, "poi_icon_indoor_ex@2x.png", "poi_icon_indoor_ex@2x.png");
      gd.a(paramContext, paramString, "style_normalmode.xml", "style_normalmode.xml");
      gd.a(paramContext, paramString, "style_trafficmode.xml", "style_trafficmode.xml");
      gd.a(paramContext, paramString, "blockicon.png", "blockicon.png");
      gd.a(paramContext, paramString, "escalator.dat", "escalator.dat");
    } while (i <= 0);
    localgf.a("sdkVersion", "4.2.8.1");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.map.sdk.a.hy
 * JD-Core Version:    0.7.0.1
 */
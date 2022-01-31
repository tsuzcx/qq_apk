package com.tencent.map.sdk.a;

import android.util.Log;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.tencentmap.mapsdk.maps.model.Language;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlayOptions;
import com.tencent.tencentmap.mapsdk.maps.model.UrlTileProvider;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public final class ka
  extends UrlTileProvider
{
  private TileOverlayOptions a;
  private volatile int b;
  private volatile int c;
  private volatile int d;
  private volatile Language e;
  private jg f;
  
  public ka(TileOverlayOptions paramTileOverlayOptions, Language paramLanguage, jg paramjg)
  {
    super(512, 512);
    this.a = paramTileOverlayOptions;
    if (paramLanguage != null) {}
    for (this.e = paramLanguage;; this.e = Language.zh)
    {
      this.b = jx.a();
      this.c = jx.b();
      this.d = jx.c();
      if (this.a != null) {
        this.a.versionInfo(b());
      }
      this.f = paramjg;
      return;
    }
  }
  
  private String b()
  {
    return this.c + File.separator + this.b + File.separator + this.d + File.separator + this.e.name();
  }
  
  public final void a()
  {
    this.b = jx.a();
    this.c = jx.b();
    this.d = jx.c();
    if (this.a != null) {
      this.a.versionInfo(b());
    }
  }
  
  public final URL getTileUrl(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = jx.e();
    if (localObject == null) {
      return null;
    }
    int[] arrayOfInt = jx.h();
    if (arrayOfInt.length == 0) {}
    int i;
    String str;
    for (localObject = ((String)localObject).replaceFirst("\\{range\\}", "");; str = localMalformedURLException.replaceFirst("\\{range\\}", Integer.toString(i)))
    {
      localObject = ((String)localObject).replaceFirst("\\{z\\}", Integer.toString(paramInt3)).replaceFirst("\\{x\\}", Integer.toString(paramInt1)).replaceFirst("\\{y\\}", Integer.toString(paramInt2)).replaceFirst("\\{style\\}", Integer.toString(this.b)).replaceFirst("\\{scene\\}", Integer.toString(this.c)).replaceFirst("\\{version\\}", Integer.toString(this.d)).replaceFirst("\\{ch\\}", this.e.name());
      try
      {
        localObject = new URL((String)localObject);
        return localObject;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        or.b(Log.getStackTraceString(localMalformedURLException));
        return null;
      }
      int k = arrayOfInt.length;
      int j = (paramInt1 + paramInt2) % k;
      i = j;
      if (j * k < 0) {
        i = j + k;
      }
    }
  }
  
  public final NetResponse requestTileData(String paramString)
  {
    Object localObject = null;
    NetResponse localNetResponse = super.requestTileData(paramString);
    paramString = localObject;
    if (localNetResponse != null) {
      paramString = localNetResponse.data;
    }
    if ((paramString != null) && (paramString.length != 0) && (this.f != null))
    {
      paramString = this.f;
      if (paramString.d == null) {
        paramString.d = new jg.f((byte)0);
      }
      paramString = paramString.d;
      paramString.a += 1;
    }
    return localNetResponse;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.ka
 * JD-Core Version:    0.7.0.1
 */
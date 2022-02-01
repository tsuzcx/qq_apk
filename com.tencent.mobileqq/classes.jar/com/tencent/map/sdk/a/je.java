package com.tencent.map.sdk.a;

import android.text.TextUtils;
import com.tencent.map.sdk.service.MapServiceManager;
import com.tencent.map.sdk.service.protocol.request.SketchDataRequest;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlayOptions;
import com.tencent.tencentmap.mapsdk.maps.model.UrlTileProvider;
import java.net.MalformedURLException;
import java.net.URL;

public final class je
  extends UrlTileProvider
{
  static int a;
  TileOverlayOptions b;
  
  public je(TileOverlayOptions paramTileOverlayOptions)
  {
    super(256, 256);
    this.b = paramTileOverlayOptions;
    a = jc.a();
    if (this.b != null) {
      this.b.versionInfo(Integer.toString(a));
    }
  }
  
  static String a()
  {
    return Integer.toString(a);
  }
  
  public final URL getTileUrl(int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt2 = (int)(Math.pow(2.0D, paramInt3) - 1.0D - paramInt2);
    Object localObject = ((SketchDataRequest)((nj)MapServiceManager.getService(nj.class)).c()).sketchTileUrl(paramInt1, paramInt2, paramInt3, a);
    try
    {
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new URL((String)localObject);
        return localObject;
      }
    }
    catch (MalformedURLException localMalformedURLException)
    {
      localMalformedURLException.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.je
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.luggage.wxa.jv;

import android.graphics.SurfaceTexture;
import com.tencent.luggage.wxa.gd.d;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.xweb.skia_canvas.external_texture.ISkiaCanvasExternalTextureHandler;
import com.tencent.xweb.skia_canvas.external_texture.SkiaCanvasExternalTexturePlugin.PluginLoadResult;
import com.tencent.xweb.skia_canvas.external_texture.SkiaCanvasExternalTexturePluginWithSurfaceTextureDelegate;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class a
  extends SkiaCanvasExternalTexturePluginWithSurfaceTextureDelegate
{
  private static a a;
  private Map<Integer, d> b = new ConcurrentHashMap();
  
  public static a a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new a();
        }
      }
      finally {}
    }
    return a;
  }
  
  public void a(int paramInt1, d paramd, SurfaceTexture paramSurfaceTexture, int paramInt2, int paramInt3, String paramString)
  {
    if ((paramd != null) && (paramSurfaceTexture != null) && ((paramInt2 != 0) || (paramInt3 != 0)))
    {
      o.d("MicroMsg.AppBrand.VideoCanvas.VideoCanvasExternalTexturePlugin", "registerMediaPlayer, id:%s, width:%s, height:%s, surface:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramSurfaceTexture.hashCode()) });
      this.b.put(Integer.valueOf(paramInt1), paramd);
      registerInstance(paramInt1, paramString, paramInt2, paramInt3, paramSurfaceTexture);
    }
  }
  
  public void onPluginInstanceDestroy(ISkiaCanvasExternalTextureHandler paramISkiaCanvasExternalTextureHandler, int paramInt, String paramString)
  {
    o.d("MicroMsg.AppBrand.VideoCanvas.VideoCanvasExternalTexturePlugin", "onPluginInstanceDestroy, id:%s appTag:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    super.onPluginInstanceDestroy(paramISkiaCanvasExternalTextureHandler, paramInt, paramString);
  }
  
  public SkiaCanvasExternalTexturePlugin.PluginLoadResult onPluginInstanceLoad(ISkiaCanvasExternalTextureHandler paramISkiaCanvasExternalTextureHandler, String paramString1, int paramInt, String paramString2)
  {
    o.d("MicroMsg.AppBrand.VideoCanvas.VideoCanvasExternalTexturePlugin", "onPluginInstanceLoad, type:%s, id:%s appTag:%s", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2 });
    return super.onPluginInstanceLoad(paramISkiaCanvasExternalTextureHandler, paramString1, paramInt, paramString2);
  }
  
  protected void replaceDisplaySurface(int paramInt, String paramString, SurfaceTexture paramSurfaceTexture)
  {
    paramString = (d)this.b.get(Integer.valueOf(paramInt));
    if ((paramString != null) && (paramSurfaceTexture != null))
    {
      o.c("MicroMsg.AppBrand.VideoCanvas.VideoCanvasExternalTexturePlugin", "replaceDisplaySurface, surface:%s", new Object[] { Integer.valueOf(paramSurfaceTexture.hashCode()) });
      paramString.b(paramSurfaceTexture);
      return;
    }
    o.c("MicroMsg.AppBrand.VideoCanvas.VideoCanvasExternalTexturePlugin", "replaceDisplaySurface, video plugin handler or surface texture is null");
  }
  
  public boolean supportType(String paramString)
  {
    return paramString.equals("video");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jv.a
 * JD-Core Version:    0.7.0.1
 */
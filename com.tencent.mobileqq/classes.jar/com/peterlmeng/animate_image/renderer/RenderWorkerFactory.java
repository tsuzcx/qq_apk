package com.peterlmeng.animate_image.renderer;

import android.content.Context;
import com.peterlmeng.animate_image.Size;
import com.peterlmeng.animate_image.support.common.BitmapAnimatorRenderWorker;
import com.peterlmeng.animate_image.support.common.CanvasConsumerAnimatorRenderWorker;
import com.peterlmeng.animate_image.support.common.IBitmapAnimatorFactory;
import io.flutter.plugin.common.EventChannel;
import io.flutter.view.TextureRegistry.SurfaceTextureEntry;
import java.util.concurrent.ConcurrentHashMap;

public class RenderWorkerFactory
{
  private static ConcurrentHashMap<String, IRenderWorkerFactory> sRenderWorkerFactory = new ConcurrentHashMap();
  
  public static RenderWorker createRenderWorker(TextureRegistry.SurfaceTextureEntry paramSurfaceTextureEntry, Context paramContext, String paramString1, int paramInt1, int paramInt2, int paramInt3, Size paramSize, EventChannel paramEventChannel, String paramString2)
  {
    if (paramString1.endsWith(".pag")) {
      return new PagRenderWorker(paramSurfaceTextureEntry, paramString1, paramContext, paramInt2, paramInt1, paramInt3, paramSize, paramEventChannel, paramString2);
    }
    Object localObject = "";
    int i = paramString1.lastIndexOf('.');
    if (i >= 0) {
      localObject = paramString1.substring(i + 1);
    }
    localObject = (IRenderWorkerFactory)sRenderWorkerFactory.get(localObject);
    if (localObject == null) {
      return null;
    }
    RenderWorkerFactory.CreateRenderWorkerParams localCreateRenderWorkerParams = new RenderWorkerFactory.CreateRenderWorkerParams();
    localCreateRenderWorkerParams.entry = paramSurfaceTextureEntry;
    localCreateRenderWorkerParams.context = paramContext;
    localCreateRenderWorkerParams.url = paramString1;
    localCreateRenderWorkerParams.loopCount = paramInt1;
    localCreateRenderWorkerParams.playStatus = paramInt2;
    localCreateRenderWorkerParams.scaleType = paramInt3;
    localCreateRenderWorkerParams.size = paramSize;
    localCreateRenderWorkerParams.packagePath = paramString2;
    localCreateRenderWorkerParams.eventChannel = paramEventChannel;
    return ((IRenderWorkerFactory)localObject).create(localCreateRenderWorkerParams);
  }
  
  public static RenderWorker newBitmapRenderWorker(RenderWorkerFactory.CreateRenderWorkerParams paramCreateRenderWorkerParams, IBitmapAnimatorFactory paramIBitmapAnimatorFactory)
  {
    return new BitmapAnimatorRenderWorker(paramCreateRenderWorkerParams, paramIBitmapAnimatorFactory);
  }
  
  public static RenderWorker newCanvasConsumerAnimatorRenderWorker(RenderWorkerFactory.CreateRenderWorkerParams paramCreateRenderWorkerParams, IBitmapAnimatorFactory paramIBitmapAnimatorFactory)
  {
    return new CanvasConsumerAnimatorRenderWorker(paramCreateRenderWorkerParams, paramIBitmapAnimatorFactory);
  }
  
  public static void registerRenderFactory(String paramString, IRenderWorkerFactory paramIRenderWorkerFactory)
  {
    if (paramIRenderWorkerFactory == null)
    {
      sRenderWorkerFactory.remove(paramString);
      return;
    }
    sRenderWorkerFactory.put(paramString, paramIRenderWorkerFactory);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.peterlmeng.animate_image.renderer.RenderWorkerFactory
 * JD-Core Version:    0.7.0.1
 */
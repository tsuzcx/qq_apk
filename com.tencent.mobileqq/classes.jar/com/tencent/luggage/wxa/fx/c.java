package com.tencent.luggage.wxa.fx;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.view.MotionEvent;
import androidx.annotation.Nullable;
import org.xwalk.core.XWalkExtendPluginClient;
import org.xwalk.core.XWalkView;

public class c
  extends XWalkExtendPluginClient
{
  private com.tencent.luggage.wxa.gg.c a;
  
  public c(XWalkView paramXWalkView)
  {
    super(paramXWalkView);
  }
  
  public void a(com.tencent.luggage.wxa.gg.c paramc)
  {
    this.a = paramc;
  }
  
  public void onPluginDestroy(String paramString, int paramInt)
  {
    super.onPluginDestroy(paramString, paramInt);
    com.tencent.luggage.wxa.gg.c localc = this.a;
    if (localc != null) {
      localc.a(paramString, paramInt);
    }
  }
  
  public void onPluginReady(String paramString, int paramInt, SurfaceTexture paramSurfaceTexture)
  {
    super.onPluginReady(paramString, paramInt, paramSurfaceTexture);
    com.tencent.luggage.wxa.gg.c localc = this.a;
    if (localc != null) {
      localc.a(paramString, paramInt, paramSurfaceTexture);
    }
  }
  
  public void onPluginScreenshotTaken(String paramString, int paramInt, @Nullable Bitmap paramBitmap)
  {
    super.onPluginScreenshotTaken(paramString, paramInt, paramBitmap);
    com.tencent.luggage.wxa.gg.c localc = this.a;
    if (localc != null) {
      localc.a(paramString, paramInt, paramBitmap);
    }
  }
  
  public void onPluginTouch(String paramString, int paramInt, MotionEvent paramMotionEvent)
  {
    super.onPluginTouch(paramString, paramInt, paramMotionEvent);
    com.tencent.luggage.wxa.gg.c localc = this.a;
    if (localc != null) {
      localc.a(paramString, paramInt, paramMotionEvent);
    }
  }
  
  public void setPluginTextureScale(String paramString, int paramInt, float paramFloat1, float paramFloat2)
  {
    super.setPluginTextureScale(paramString, paramInt, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fx.c
 * JD-Core Version:    0.7.0.1
 */
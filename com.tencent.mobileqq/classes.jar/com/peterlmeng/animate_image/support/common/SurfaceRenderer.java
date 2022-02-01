package com.peterlmeng.animate_image.support.common;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.peterlmeng.animate_image.Size;
import com.peterlmeng.animate_image.support.log.LogUtils;
import io.flutter.view.TextureRegistry.SurfaceTextureEntry;
import java.util.Locale;

public class SurfaceRenderer
{
  public static final String TAG = "SurfaceRenderer";
  private ICanvasConsumer mCanvasConsumer;
  private final Context mContext;
  private int mDrawCount = 0;
  private boolean mRunning = true;
  private final Size mSize;
  private final Surface mSurface;
  private final SurfaceTexture mSurfaceTexture;
  private final TextureRegistry.SurfaceTextureEntry mTextureEntry;
  private final long mTextureId;
  
  public SurfaceRenderer(Context paramContext, TextureRegistry.SurfaceTextureEntry paramSurfaceTextureEntry, Size paramSize)
  {
    LogUtils.a("SurfaceRenderer", String.format(Locale.getDefault(), "SurfaceRenderer()", new Object[0]));
    this.mContext = paramContext;
    this.mSurfaceTexture = paramSurfaceTextureEntry.surfaceTexture();
    this.mSurface = new Surface(this.mSurfaceTexture);
    this.mTextureId = paramSurfaceTextureEntry.id();
    this.mTextureEntry = paramSurfaceTextureEntry;
    this.mSize = paramSize;
  }
  
  public void init(ICanvasConsumer paramICanvasConsumer)
  {
    this.mCanvasConsumer = paramICanvasConsumer;
    LogUtils.a("SurfaceRenderer", String.format(Locale.getDefault(), "handleInit() %d, %d, textureId=%d", new Object[] { Integer.valueOf(this.mSize.width), Integer.valueOf(this.mSize.height), Long.valueOf(this.mTextureId) }));
    this.mSurfaceTexture.setDefaultBufferSize(DeviceUtils.pixelOf(this.mSize.width), DeviceUtils.pixelOf(this.mSize.height));
    this.mRunning = true;
  }
  
  public void invalidate()
  {
    if (!this.mRunning)
    {
      LogUtils.a("SurfaceRenderer", String.format(Locale.getDefault(), "[%d] handleDraw() but not running", new Object[] { Long.valueOf(this.mTextureId) }));
      return;
    }
    try
    {
      if (!this.mSurface.isValid())
      {
        LogUtils.a("SurfaceRenderer", String.format(Locale.getDefault(), "[%d] handleDraw() canvas is not valid, will try later", new Object[] { Long.valueOf(this.mTextureId) }));
        return;
      }
    }
    catch (Exception localException)
    {
      LogUtils.b("SurfaceRenderer", String.format(Locale.getDefault(), "invalidate() error: %s", new Object[] { localException.getMessage() }));
      return;
    }
    Canvas localCanvas = this.mSurface.lockCanvas(null);
    if (localCanvas == null)
    {
      LogUtils.a("SurfaceRenderer", String.format(Locale.getDefault(), "[%d] handleDraw() canvas is null, will try later", new Object[] { Long.valueOf(this.mTextureId) }));
      return;
    }
    if (this.mDrawCount % 120 == 0) {
      LogUtils.a("SurfaceRenderer", String.format(Locale.getDefault(), "[%d] handleDraw() called canvasConsumer! %d", new Object[] { Long.valueOf(this.mTextureId), Integer.valueOf(this.mDrawCount) }));
    }
    this.mDrawCount += 1;
    this.mCanvasConsumer.draw(localCanvas);
    this.mSurface.unlockCanvasAndPost(localCanvas);
  }
  
  public void unInit()
  {
    this.mRunning = false;
    try
    {
      this.mTextureEntry.release();
      this.mSurface.release();
      LogUtils.a("SurfaceRenderer", String.format(Locale.getDefault(), "unInit() release texture entry %d", new Object[] { Long.valueOf(this.mTextureId) }));
      return;
    }
    catch (Exception localException)
    {
      LogUtils.b("SurfaceRenderer", String.format(Locale.getDefault(), "unInit() error: %s", new Object[] { localException.getMessage() }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.peterlmeng.animate_image.support.common.SurfaceRenderer
 * JD-Core Version:    0.7.0.1
 */
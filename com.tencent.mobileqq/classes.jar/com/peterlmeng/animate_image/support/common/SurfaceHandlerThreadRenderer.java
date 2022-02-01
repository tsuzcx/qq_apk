package com.peterlmeng.animate_image.support.common;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Surface;
import com.peterlmeng.animate_image.Size;
import com.peterlmeng.animate_image.renderer.BitmapTexture;
import com.peterlmeng.animate_image.support.log.LogUtils;
import io.flutter.view.TextureRegistry.SurfaceTextureEntry;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;

public class SurfaceHandlerThreadRenderer
  extends HandlerThread
  implements Handler.Callback
{
  private static final int MSG_DISPOSE = 2;
  private static final int MSG_DRAW = 3;
  private static final int MSG_START = 1;
  public static final String TAG = "SurfaceHandlerThreadRenderer";
  private BitmapTexture mBitmapTexture;
  private ConcurrentLinkedQueue<Integer> mCachedMessage = new ConcurrentLinkedQueue();
  private ICanvasConsumer mCanvasConsumer;
  private final Context mContext;
  private Handler mHandler;
  private final Size mSize;
  private final Surface mSurface;
  private final SurfaceTexture mSurfaceTexture;
  private final long mTextureId;
  
  public SurfaceHandlerThreadRenderer(Context paramContext, TextureRegistry.SurfaceTextureEntry paramSurfaceTextureEntry, Size paramSize)
  {
    super(localStringBuilder.toString());
    LogUtils.a("SurfaceHandlerThreadRenderer", String.format(Locale.getDefault(), "SurfaceHandlerThreadRenderer()", new Object[0]));
    this.mContext = paramContext;
    this.mSurfaceTexture = paramSurfaceTextureEntry.surfaceTexture();
    this.mSurface = new Surface(this.mSurfaceTexture);
    this.mTextureId = paramSurfaceTextureEntry.id();
    this.mSize = paramSize;
    start();
  }
  
  private void handleDraw()
  {
    LogUtils.a("SurfaceHandlerThreadRenderer", String.format(Locale.getDefault(), "handleDraw()", new Object[0]));
    if (!this.mSurface.isValid())
    {
      LogUtils.a("SurfaceHandlerThreadRenderer", String.format(Locale.getDefault(), "handleDraw() canvas is not valid, will try later", new Object[0]));
      return;
    }
    Canvas localCanvas = this.mSurface.lockCanvas(null);
    if (localCanvas == null)
    {
      LogUtils.a("SurfaceHandlerThreadRenderer", String.format(Locale.getDefault(), "handleDraw() canvas is null, will try later", new Object[0]));
      return;
    }
    LogUtils.a("SurfaceHandlerThreadRenderer", String.format(Locale.getDefault(), "handleDraw() called canvasConsumer!", new Object[0]));
    this.mCanvasConsumer.draw(localCanvas);
    this.mSurface.unlockCanvasAndPost(localCanvas);
  }
  
  private void handleInit()
  {
    LogUtils.a("SurfaceHandlerThreadRenderer", String.format(Locale.getDefault(), "handleInit() %d, %d", new Object[] { Integer.valueOf(this.mSize.width), Integer.valueOf(this.mSize.height) }));
    this.mSurfaceTexture.setDefaultBufferSize(DeviceUtils.pixelOf(this.mSize.width), DeviceUtils.pixelOf(this.mSize.height));
  }
  
  private void handleUnInit() {}
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return false;
        }
        handleDraw();
        return true;
      }
      handleUnInit();
      return true;
    }
    handleInit();
    return true;
  }
  
  public void init(ICanvasConsumer paramICanvasConsumer)
  {
    this.mCanvasConsumer = paramICanvasConsumer;
    paramICanvasConsumer = this.mHandler;
    if (paramICanvasConsumer == null)
    {
      this.mCachedMessage.add(Integer.valueOf(1));
      return;
    }
    paramICanvasConsumer.obtainMessage(1).sendToTarget();
  }
  
  public void invalidate()
  {
    Handler localHandler = this.mHandler;
    if (localHandler == null)
    {
      this.mCachedMessage.add(Integer.valueOf(3));
      return;
    }
    localHandler.obtainMessage(3).sendToTarget();
  }
  
  protected void onLooperPrepared()
  {
    super.onLooperPrepared();
    LogUtils.a("SurfaceHandlerThreadRenderer", String.format(Locale.getDefault(), "onLooperPrepared()", new Object[0]));
    this.mHandler = new Handler(getLooper(), this);
    while (!this.mCachedMessage.isEmpty()) {
      this.mHandler.obtainMessage(((Integer)this.mCachedMessage.poll()).intValue()).sendToTarget();
    }
  }
  
  public void unInit()
  {
    Handler localHandler = this.mHandler;
    if (localHandler == null)
    {
      this.mCachedMessage.add(Integer.valueOf(2));
      return;
    }
    localHandler.obtainMessage(2).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.peterlmeng.animate_image.support.common.SurfaceHandlerThreadRenderer
 * JD-Core Version:    0.7.0.1
 */
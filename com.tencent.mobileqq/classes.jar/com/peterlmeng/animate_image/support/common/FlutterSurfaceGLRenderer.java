package com.peterlmeng.animate_image.support.common;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import com.peterlmeng.animate_image.renderer.BitmapTexture;
import com.peterlmeng.animate_image.renderer.OpenGlRenderer2;
import io.flutter.view.TextureRegistry.SurfaceTextureEntry;

public class FlutterSurfaceGLRenderer
  extends HandlerThread
  implements Handler.Callback
{
  private static final int MSG_DISPOSE = 2;
  private static final int MSG_DRAW = 3;
  private static final int MSG_START = 1;
  private BitmapTexture mBitmapTexture;
  private final Context mContext;
  private final OpenGlRenderer2 mGLRenderer;
  private final Handler mHandler;
  private final long mTextureId;
  
  public FlutterSurfaceGLRenderer(Context paramContext, TextureRegistry.SurfaceTextureEntry paramSurfaceTextureEntry)
  {
    super(localStringBuilder.toString());
    this.mContext = paramContext;
    this.mGLRenderer = new OpenGlRenderer2(paramSurfaceTextureEntry);
    this.mHandler = new Handler(getLooper(), this);
    this.mTextureId = paramSurfaceTextureEntry.id();
  }
  
  private void handleRenderBitmap(Bitmap paramBitmap)
  {
    BitmapTexture localBitmapTexture = this.mBitmapTexture;
    if (localBitmapTexture == null)
    {
      this.mBitmapTexture = new BitmapTexture(this.mContext, paramBitmap);
      this.mBitmapTexture.onSurfaceCreated();
    }
    else
    {
      localBitmapTexture.updateBitmap(paramBitmap);
    }
    this.mBitmapTexture.draw();
    this.mGLRenderer.swapBuffer();
  }
  
  public void handleInit()
  {
    this.mGLRenderer.initGL();
  }
  
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
        handleRenderBitmap((Bitmap)paramMessage.obj);
        return true;
      }
      handleUnInit();
      return true;
    }
    handleInit();
    return true;
  }
  
  public void handleUnInit()
  {
    this.mGLRenderer.onDispose();
  }
  
  public void init()
  {
    this.mHandler.obtainMessage(1).sendToTarget();
  }
  
  public void renderBitmap(Bitmap paramBitmap)
  {
    this.mHandler.obtainMessage(3, paramBitmap).sendToTarget();
  }
  
  public void unInit()
  {
    this.mHandler.obtainMessage(2).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.peterlmeng.animate_image.support.common.FlutterSurfaceGLRenderer
 * JD-Core Version:    0.7.0.1
 */
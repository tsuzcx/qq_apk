package com.tencent.avcore.jni.render;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.avcore.util.GlStringParser;
import java.lang.ref.WeakReference;

public class RenderTextureJni
  implements Handler.Callback
{
  private static final String TAG = "TextureJni";
  private final Handler mEventHandler;
  private long mNativeContext = 0L;
  private GlStringParser mStringParser = null;
  private final IGLRenderTexture mTexture;
  
  public RenderTextureJni(IGLRenderTexture paramIGLRenderTexture)
  {
    this.mTexture = paramIGLRenderTexture;
    Looper localLooper = Looper.myLooper();
    paramIGLRenderTexture = localLooper;
    if (localLooper == null) {
      paramIGLRenderTexture = Looper.getMainLooper();
    }
    if (paramIGLRenderTexture != null)
    {
      this.mEventHandler = new Handler(paramIGLRenderTexture, this);
      return;
    }
    this.mEventHandler = null;
  }
  
  private void notifyUpdateUI(int paramInt1, int paramInt2, Object paramObject)
  {
    Object localObject = this.mTexture;
    if (localObject != null) {
      ((IGLRenderTexture)localObject).markForPerf(paramInt1);
    }
    localObject = this.mEventHandler;
    if (localObject != null)
    {
      paramObject = ((Handler)localObject).obtainMessage(paramInt1, 0, 0, paramObject);
      if (paramInt2 == 0)
      {
        this.mEventHandler.sendMessage(paramObject);
        return;
      }
      this.mEventHandler.sendMessageDelayed(paramObject, paramInt2);
      return;
    }
    if (AVCoreLog.isColorLevel()) {
      AVCoreLog.i("TextureJni", "notifyUpdateUI, event handler is null.");
    }
  }
  
  private static void onNativeNotify(Object paramObject1, int paramInt, Object paramObject2)
  {
    if (paramObject1 == null) {
      return;
    }
    paramObject1 = (RenderTextureJni)((WeakReference)paramObject1).get();
    if (paramObject1 != null)
    {
      if (paramInt == 0)
      {
        paramObject1.notifyUpdateUI(0, 0, paramObject2);
        return;
      }
      if (paramInt == 2)
      {
        paramObject1.notifyUpdateUI(2, 0, paramObject2);
        return;
      }
      if (paramInt == 1)
      {
        paramObject1.notifyUpdateUI(1, 0, paramObject2);
        return;
      }
      if (paramInt == 3) {
        paramObject1.notifyUpdateUI(3, 0, paramObject2);
      }
    }
  }
  
  public native boolean canRender();
  
  public native void flush(boolean paramBoolean);
  
  public native int getCaptureFrameHeight();
  
  public native byte[] getCaptureFrameTexture();
  
  public native int getCaptureFrameWidth();
  
  public native byte[] getFaceFeature();
  
  public native byte[] getFrameTexture();
  
  public native int getImgAngle();
  
  public native int getImgHeight();
  
  public native int getImgWidth();
  
  public long getNativeContext()
  {
    return this.mNativeContext;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    IGLRenderTexture localIGLRenderTexture = this.mTexture;
    if (localIGLRenderTexture != null) {
      localIGLRenderTexture.nativeFrameDataUpdate();
    }
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            return true;
          }
          if (this.mTexture != null)
          {
            if (this.mStringParser == null) {
              this.mStringParser = new GlStringParser('=', ';');
            }
            paramMessage = (String)paramMessage.obj;
            this.mStringParser.unflatten(paramMessage);
            i = this.mStringParser.getInt("width");
            int j = this.mStringParser.getInt("height");
            int k = this.mStringParser.getInt("angle");
            int m = this.mStringParser.getInt("rotation", -1);
            this.mTexture.onRenderInfoNotify(i, j, k, m);
            return true;
          }
        }
        else
        {
          paramMessage = this.mTexture;
          if (paramMessage != null)
          {
            paramMessage.onRenderReset();
            return true;
          }
        }
      }
      else
      {
        paramMessage = this.mTexture;
        if (paramMessage != null)
        {
          paramMessage.onRenderFlush();
          return true;
        }
      }
    }
    else
    {
      paramMessage = this.mTexture;
      if (paramMessage != null) {
        paramMessage.onRenderFrame();
      }
    }
    return true;
  }
  
  public native void init(int paramInt, Object paramObject, long paramLong);
  
  public native void onPause();
  
  public native void onResume();
  
  public native void unInit();
  
  public native boolean updateCurFrame();
  
  public native int uploadContent(int[] paramArrayOfInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avcore.jni.render.RenderTextureJni
 * JD-Core Version:    0.7.0.1
 */
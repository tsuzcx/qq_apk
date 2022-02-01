package com.tencent.TMG.opengl.texture;

import android.content.Context;
import android.os.Looper;
import com.tencent.TMG.opengl.GlStringParser;
import com.tencent.TMG.opengl.glrenderer.GLCanvas;
import com.tencent.TMG.opengl.glrenderer.GLId;
import com.tencent.TMG.opengl.utils.Utils;
import com.tencent.TMG.utils.QLog;
import java.lang.ref.WeakReference;

public final class YUVTexture
  extends BasicTexture
{
  public static final int MSG_FLUSH = 1;
  public static final int MSG_RENDER = 0;
  public static final int MSG_RESET = 2;
  public static final int MSG_SHOW = 3;
  private static String TAG = "YUVTexture";
  static boolean soloaded = false;
  public float mBrightness = 1.2F;
  public float mContrast = 1.93F;
  private YUVTexture.EventHandler mEventHandler;
  private YUVTexture.GLRenderListener mListener;
  private int mNativeContext = 0;
  public float mSaturation = 1.05F;
  private GlStringParser mStringParser = null;
  private int m_drawcount = 0;
  private long m_endtime = 0L;
  private long m_starttime = 0L;
  
  public YUVTexture(Context paramContext)
  {
    super(null, 0, 0);
    Looper localLooper = Looper.myLooper();
    if (localLooper != null)
    {
      this.mEventHandler = new YUVTexture.EventHandler(this, localLooper);
    }
    else
    {
      localLooper = Looper.getMainLooper();
      if (localLooper != null) {
        this.mEventHandler = new YUVTexture.EventHandler(this, localLooper);
      } else {
        this.mEventHandler = null;
      }
    }
    init(Utils.getGLVersion(paramContext), new WeakReference(this));
  }
  
  static void onNativeNotify(Object paramObject1, int paramInt, Object paramObject2)
  {
    paramObject1 = (WeakReference)paramObject1;
    if (paramObject1.get() != null)
    {
      if (paramInt == 0)
      {
        ((YUVTexture)paramObject1.get()).notifyupdateui(0, 0, paramObject2);
        return;
      }
      if (paramInt == 2)
      {
        ((YUVTexture)paramObject1.get()).notifyupdateui(2, 0, paramObject2);
        return;
      }
      if (paramInt == 1)
      {
        ((YUVTexture)paramObject1.get()).notifyupdateui(1, 0, paramObject2);
        return;
      }
      if (paramInt == 3) {
        ((YUVTexture)paramObject1.get()).notifyupdateui(3, 0, paramObject2);
      }
    }
  }
  
  public native boolean canRender();
  
  public native void flush(boolean paramBoolean);
  
  public float getBrightness()
  {
    return this.mBrightness;
  }
  
  public float getContrast()
  {
    return this.mContrast;
  }
  
  public int getFormatType()
  {
    return 1;
  }
  
  native int getFrameCount();
  
  native int getFrameIndex();
  
  public native int getImgAngle();
  
  public native int getImgHeight();
  
  public native int getImgWidth();
  
  public float getSaturation()
  {
    return this.mSaturation;
  }
  
  public int getTarget()
  {
    return 3553;
  }
  
  native void init(int paramInt, Object paramObject);
  
  public boolean isOpaque()
  {
    return true;
  }
  
  public void notifyupdateui(int paramInt1, int paramInt2, Object paramObject)
  {
    YUVTexture.EventHandler localEventHandler = this.mEventHandler;
    if (localEventHandler != null)
    {
      paramObject = localEventHandler.obtainMessage(paramInt1, 0, 0, paramObject);
      if (paramInt2 == 0)
      {
        this.mEventHandler.sendMessage(paramObject);
        return;
      }
      this.mEventHandler.sendMessageDelayed(paramObject, paramInt2);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e(TAG, 0, "notifyupdateui|mEventHandler == null");
    }
  }
  
  public boolean onBind(GLCanvas paramGLCanvas)
  {
    if (this.mId == null)
    {
      this.mId = new int[3];
      int i = 0;
      while (i < this.mId.length)
      {
        this.mId[i] = paramGLCanvas.getGLId().generateTexture();
        i += 1;
      }
    }
    uploadContent(this.mId);
    this.mState = 1;
    return isLoaded();
  }
  
  public native void onPause();
  
  public native void onResume();
  
  public void setColorAjust(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.mBrightness = paramFloat1;
    this.mContrast = paramFloat2;
    this.mSaturation = paramFloat3;
  }
  
  public void setGLRenderListener(YUVTexture.GLRenderListener paramGLRenderListener)
  {
    this.mListener = paramGLRenderListener;
  }
  
  native void uninit();
  
  native void uploadContent(int[] paramArrayOfInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.opengl.texture.YUVTexture
 * JD-Core Version:    0.7.0.1
 */
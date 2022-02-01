package com.tencent.av.opengl;

import bnpy;
import com.tencent.av.opengl.texture.YUVTexture;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.startup.step.AVSoUtils;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.SoLoadUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import lnz;
import loz;

public class GraphicRenderMgr
{
  public static int BEAUTY_EFFECTS_FILTER_SO_LOADED = -1;
  private static final String TAG = "GraphicRenderMgr";
  public static boolean ptuSoVersion;
  private static volatile GraphicRenderMgr sGraphicRenderMgr;
  public static boolean soloaded;
  public static boolean soloadedPTV;
  public int decoderPtrRef;
  private lnz mAutoFocusCallback;
  private Object mAutoFocusCallbackLock = new Object();
  
  private GraphicRenderMgr()
  {
    loadSo();
  }
  
  public static native int checkhwyuv(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9);
  
  public static GraphicRenderMgr getInstance()
  {
    if (sGraphicRenderMgr == null) {}
    try
    {
      if (sGraphicRenderMgr == null) {
        sGraphicRenderMgr = new GraphicRenderMgr();
      }
      return sGraphicRenderMgr;
    }
    finally {}
  }
  
  public static void loadPtuSO()
  {
    if (loz.b())
    {
      soloadedPTV = bnpy.c();
      ptuSoVersion = bnpy.b();
    }
    if (QLog.isColorLevel()) {
      QLog.w("GraphicRenderMgr", 1, "loadPtuSO, soloadedPTV[" + soloadedPTV + "], ptuSoVersion[" + ptuSoVersion + "], isSupported[" + loz.b() + "]");
    }
  }
  
  public static boolean loadSo()
  {
    if (!soloaded) {}
    try
    {
      long l = AudioHelper.b();
      QLog.w("GraphicRenderMgr", 1, "loadSo, seq[" + l + "]");
      BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
      SoLoadUtil.a(localBaseApplication, "c++_shared", 0, false);
      SoLoadUtil.a(localBaseApplication, "xplatform", 0, false);
      AVSoUtils.b(l, localBaseApplication, "SDKCommon", true);
      AVSoUtils.a(l, localBaseApplication, "SDKCommon", true);
      AVSoUtils.b(l, localBaseApplication, "qav_graphics", true);
      AVSoUtils.a(l, localBaseApplication, "qav_graphics", true);
      soloaded = true;
      return soloaded;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        localUnsatisfiedLinkError.printStackTrace();
        QLog.w("GraphicRenderMgr", 1, "loadSo UnsatisfiedLinkError", localUnsatisfiedLinkError);
      }
    }
  }
  
  public static native void nativeConvertNV21ToI420(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2);
  
  public static native void nativeConvertRGBA2NV21(int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  private native int sendCameraFrame2Native(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong, boolean paramBoolean, float paramFloat1, float paramFloat2, float paramFloat3, byte[] paramArrayOfByte2, int paramInt6, int paramInt7);
  
  public native void clearCameraFrames();
  
  public native String findConfigValue(String paramString1, String paramString2, String paramString3);
  
  public native void flushGlRender(String paramString);
  
  public native int getBeautyConfig();
  
  public native long getRecvDecoderFrameFunctionptr();
  
  public native void nativeRotatePlane(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3);
  
  public native void nativeScalePlane(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public void onFocusDetectResult(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GraphicRenderMgr", 2, "onFocusDetectResult:" + paramBoolean);
    }
    if (this.mAutoFocusCallback != null) {
      this.mAutoFocusCallback.a(paramBoolean);
    }
  }
  
  public native void onUinChanged(String paramString1, String paramString2);
  
  public int sendCameraFrame(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong, boolean paramBoolean, float[] paramArrayOfFloat, byte[] paramArrayOfByte2, int paramInt6, int paramInt7)
  {
    if ((!paramBoolean) && (paramArrayOfFloat != null) && (paramArrayOfFloat.length >= 3)) {
      return sendCameraFrame2Native(paramArrayOfByte1, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramLong, paramBoolean, paramArrayOfFloat[0], paramArrayOfFloat[1], paramArrayOfFloat[2], paramArrayOfByte2, paramInt6, paramInt7);
    }
    return sendCameraFrame2Native(paramArrayOfByte1, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramLong, paramBoolean, 0.0F, 0.0F, 0.0F, paramArrayOfByte2, paramInt6, paramInt7);
  }
  
  @Deprecated
  public int sendCameraFrame2Native(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong, boolean paramBoolean)
  {
    return sendCameraFrame2Native(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, -1, paramLong, paramBoolean, 0.0F, 0.0F, 0.0F, null, 0, 0);
  }
  
  @Deprecated
  public int sendCameraFrame2Native(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong, boolean paramBoolean, float[] paramArrayOfFloat, byte[] paramArrayOfByte2)
  {
    return sendCameraFrame(paramArrayOfByte1, paramInt1, paramInt2, paramInt3, paramInt4, -1, paramLong, paramBoolean, paramArrayOfFloat, paramArrayOfByte2, 0, 0);
  }
  
  public native void setAccountUin(String paramString);
  
  public native void setBeautyConfig(int paramInt);
  
  public native void setBeautyFlag(int paramInt);
  
  public void setBeautyOrFaceConfig(int paramInt1, int paramInt2)
  {
    i = 0;
    try
    {
      j = getBeautyConfig();
      i = j;
      j = i;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError1)
    {
      try
      {
        int j;
        do
        {
          for (;;)
          {
            setBeautyConfig(i);
            if (QLog.isColorLevel()) {
              QLog.d("GraphicRenderMgr", 1, "setBeautyOrFaceConfig, [" + j + " --> " + i + "], level[" + paramInt1 + "], type[" + paramInt2 + "]");
            }
            return;
            localUnsatisfiedLinkError1 = localUnsatisfiedLinkError1;
            localUnsatisfiedLinkError1.printStackTrace();
            j = 0;
          }
        } while (paramInt2 != 1);
        i = j % 100 + paramInt1 * 100;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError2)
      {
        for (;;)
        {
          localUnsatisfiedLinkError2.printStackTrace();
        }
      }
    }
    if (paramInt2 == 0)
    {
      i = j / 100 * 100 + Math.min(paramInt1, 99);
      if (j == i) {}
    }
  }
  
  public native void setFocusConfig(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2);
  
  public void setFocusDetectCallback(lnz paramlnz)
  {
    synchronized (this.mAutoFocusCallbackLock)
    {
      this.mAutoFocusCallback = paramlnz;
      return;
    }
  }
  
  public native void setGlRender(String paramString, YUVTexture paramYUVTexture);
  
  public native void setIsFocusing(boolean paramBoolean);
  
  public native void setLowlightAndVideoDenoiseInfo(int[] paramArrayOfInt);
  
  public native void setProcessEncodeFrameFunctionPtr(long paramLong);
  
  public native boolean setYuvFrame(String paramString, int paramInt1, ByteBuffer paramByteBuffer, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.opengl.GraphicRenderMgr
 * JD-Core Version:    0.7.0.1
 */
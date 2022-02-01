package com.tencent.avcore.jni.render;

import com.tencent.avcore.util.AVCoreLog;
import java.nio.ByteBuffer;

public class RenderEngineJni
{
  private static final String TAG = "RenderJni";
  private FocusDetectCallback mAutoFocusCallback = null;
  private final Object mAutoFocusCallbackLock = new Object();
  
  static native int checkHwYuv(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9);
  
  static native void nativeConvertNV21ToI420(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2);
  
  static native void nativeConvertRGBA2NV21(int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  native void clearCameraFrames();
  
  native String findConfigValue(String paramString1, String paramString2, String paramString3);
  
  native void flushGlRender(String paramString);
  
  native int getBeautyConfig();
  
  native long getRecvDecoderFrameFunctionPtr();
  
  void onFocusDetectResult(boolean paramBoolean)
  {
    if (AVCoreLog.isColorLevel()) {
      AVCoreLog.i("RenderJni", "onFocusDetectResult:" + paramBoolean);
    }
    if (this.mAutoFocusCallback != null) {
      this.mAutoFocusCallback.onFocusDetectResult(paramBoolean);
    }
  }
  
  native void onUinChanged(String paramString1, String paramString2);
  
  native int sendCameraFrame2Native(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong, boolean paramBoolean, float paramFloat1, float paramFloat2, float paramFloat3, byte[] paramArrayOfByte2, int paramInt6, int paramInt7);
  
  native void setAccountUin(String paramString);
  
  native void setBeautyConfig(int paramInt);
  
  native void setBeautyFlag(int paramInt);
  
  void setBeautyOrFaceConfig(int paramInt1, int paramInt2)
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
            if (AVCoreLog.isColorLevel()) {
              AVCoreLog.e("RenderJni", "setBeautyOrFaceConfig, [" + j + " --> " + i + "], level[" + paramInt1 + "], type[" + paramInt2 + "]");
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
  
  native void setFocusConfig(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2);
  
  void setFocusDetectCallback(FocusDetectCallback paramFocusDetectCallback)
  {
    synchronized (this.mAutoFocusCallbackLock)
    {
      this.mAutoFocusCallback = paramFocusDetectCallback;
      return;
    }
  }
  
  native void setGlRender(String paramString, RenderTextureJni paramRenderTextureJni);
  
  native void setIsFocusing(boolean paramBoolean);
  
  native void setLowlightAndVideoDenoiseInfo(int[] paramArrayOfInt);
  
  native void setProcessEncodeFrameFunctionPtr(long paramLong);
  
  native boolean setYuvFrame(String paramString, int paramInt1, ByteBuffer paramByteBuffer, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avcore.jni.render.RenderEngineJni
 * JD-Core Version:    0.7.0.1
 */
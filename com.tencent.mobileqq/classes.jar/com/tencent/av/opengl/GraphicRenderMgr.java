package com.tencent.av.opengl;

import com.tencent.av.opengl.texture.YUVTexture;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.startup.step.UpdateAvSo;
import com.tencent.mobileqq.utils.SoLoadUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import jjm;

public class GraphicRenderMgr
{
  public static int BEAUTY_EFFECTS_FILTER_SO_LOADED = -1;
  private static final String TAG = "GraphicRenderMgr";
  private static volatile GraphicRenderMgr sGraphicRenderMgr;
  public static boolean soloaded;
  public static boolean soloadedPTV;
  public int decoderPtrRef;
  private GraphicRenderMgr.FocusDetectCallback mAutoFocusCallback;
  private Object mAutoFocusCallbackLock = new Object();
  jjm mSetBeautyOrFaceConfigInfo = new jjm();
  
  private GraphicRenderMgr()
  {
    loadSo();
  }
  
  public static boolean LoadAvEffectSo()
  {
    boolean bool = false;
    try
    {
      System.loadLibrary("qav_video_effect");
      bool = true;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      label9:
      break label9;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LoadAvEffectSo", 2, "loadSo, LoadAvEffectSo: " + bool);
    }
    return bool;
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
    soloadedPTV = PtvFilterSoLoad.a(BaseApplicationImpl.getContext(), false);
    if (QLog.isColorLevel()) {
      QLog.d("soloadedPTV", 2, String.format("loadSo, soloadedPTV[%s]", new Object[] { Boolean.valueOf(soloadedPTV) }));
    }
  }
  
  public static boolean loadSo()
  {
    int i = 1;
    if (!soloaded) {}
    for (;;)
    {
      try
      {
        BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
        SoLoadUtil.a(localBaseApplication, "stlport_shared", 0, false);
        UpdateAvSo.b(localBaseApplication, "SDKCommon", true);
        UpdateAvSo.a(localBaseApplication, "SDKCommon", true);
        UpdateAvSo.b(localBaseApplication, "qav_graphics", true);
        UpdateAvSo.a(localBaseApplication, "qav_graphics", true);
        if (!LoadAvEffectSo()) {
          continue;
        }
        BEAUTY_EFFECTS_FILTER_SO_LOADED = i;
        loadPtuSO();
        soloaded = true;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        localUnsatisfiedLinkError.printStackTrace();
        continue;
      }
      return soloaded;
      i = 0;
    }
  }
  
  public static native void nativeConvertNV21ToI420(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2);
  
  public static native void nativeConvertRGBA2NV21(int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  private native int sendCameraFrame2Native(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong, boolean paramBoolean, float paramFloat1, float paramFloat2, float paramFloat3, byte[] paramArrayOfByte2);
  
  public native void clearCameraFrames();
  
  public native String findConfigValue(String paramString1, String paramString2, String paramString3);
  
  public native void flushGlRender(String paramString);
  
  public native int getBeautyConfig();
  
  public native int getRecvDecoderFrameFunctionptr();
  
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
  
  public int sendCameraFrame2Native(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong, boolean paramBoolean)
  {
    return sendCameraFrame2Native(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramLong, paramBoolean, 0.0F, 0.0F, 0.0F, null);
  }
  
  public int sendCameraFrame2Native(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong, boolean paramBoolean, float[] paramArrayOfFloat, byte[] paramArrayOfByte2)
  {
    if ((!paramBoolean) && (paramArrayOfFloat != null) && (paramArrayOfFloat.length >= 3)) {
      return sendCameraFrame2Native(paramArrayOfByte1, paramInt1, paramInt2, paramInt3, paramInt4, paramLong, paramBoolean, paramArrayOfFloat[0], paramArrayOfFloat[1], paramArrayOfFloat[2], paramArrayOfByte2);
    }
    return sendCameraFrame2Native(paramArrayOfByte1, paramInt1, paramInt2, paramInt3, paramInt4, paramLong, paramBoolean, 0.0F, 0.0F, 0.0F, paramArrayOfByte2);
  }
  
  public native void setAccountUin(String paramString);
  
  public native void setBeautyConfig(int paramInt);
  
  public native void setBeautyFlag(int paramInt);
  
  public void setBeautyOrFaceConfig(int paramInt1, int paramInt2)
  {
    k = -1;
    i = 0;
    try
    {
      j = getBeautyConfig();
      i = j;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError1)
    {
      for (;;)
      {
        int j;
        try
        {
          setBeautyConfig(j);
          this.mSetBeautyOrFaceConfigInfo.a(paramInt1, paramInt2, j, i, k);
          return;
          localUnsatisfiedLinkError1 = localUnsatisfiedLinkError1;
          localUnsatisfiedLinkError1.printStackTrace();
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError2)
        {
          localUnsatisfiedLinkError2.printStackTrace();
          continue;
        }
        if (paramInt2 == 1)
        {
          k = i % 100;
          j = paramInt1 * 100 + k;
          try
          {
            setBeautyConfig(j);
            i = -1;
          }
          catch (UnsatisfiedLinkError localUnsatisfiedLinkError3)
          {
            localUnsatisfiedLinkError3.printStackTrace();
            i = -1;
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("GraphicRenderMgr", 1, "setBeautyOrFaceConfig, thisLevel[" + i + "], level[" + paramInt1 + "], type[" + paramInt2 + "]");
          }
          i = -1;
          j = -1;
        }
      }
    }
    if (paramInt2 == 0)
    {
      i = i / 100 * 100;
      j = Math.min(paramInt1, 99) + i;
    }
  }
  
  public native void setFocusConfig(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2);
  
  public void setFocusDetectCallback(GraphicRenderMgr.FocusDetectCallback paramFocusDetectCallback)
  {
    synchronized (this.mAutoFocusCallbackLock)
    {
      this.mAutoFocusCallback = paramFocusDetectCallback;
      return;
    }
  }
  
  public native void setGlRender(String paramString, YUVTexture paramYUVTexture);
  
  public native void setIsFocusing(boolean paramBoolean);
  
  public native void setLowlightAndVideoDenoiseInfo(int[] paramArrayOfInt);
  
  public native void setProcessEncodeFrameFunctionPtr(int paramInt);
  
  public native boolean setYuvFrame(String paramString, int paramInt1, ByteBuffer paramByteBuffer, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.opengl.GraphicRenderMgr
 * JD-Core Version:    0.7.0.1
 */
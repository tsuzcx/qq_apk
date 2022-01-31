package com.tencent.av.sig;

import android.annotation.SuppressLint;
import com.tencent.TMG.utils.SoUtil;

public class QAVAuthBuffer
{
  private static boolean mIsSoLoaded;
  private static QAVAuthBuffer sAuthBuffer;
  
  public static QAVAuthBuffer getInstance()
  {
    if (sAuthBuffer == null) {}
    try
    {
      if (sAuthBuffer == null)
      {
        loadSo();
        if (mIsSoLoaded) {
          sAuthBuffer = new QAVAuthBuffer();
        }
      }
      return sAuthBuffer;
    }
    finally {}
  }
  
  @SuppressLint({"UnsafeDynamicallyLoadedCode"})
  private static void loadSo()
  {
    if (!mIsSoLoaded) {
      try
      {
        if (SoUtil.customLibPath != null)
        {
          System.load(SoUtil.customLibPath + "/libstlport_shared.so");
          System.load(SoUtil.customLibPath + "/libqav_authbuff.so");
        }
        for (;;)
        {
          mIsSoLoaded = true;
          return;
          System.loadLibrary("stlport_shared");
          System.loadLibrary("qav_authbuff");
        }
        return;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        mIsSoLoaded = false;
        localUnsatisfiedLinkError.printStackTrace();
      }
    }
  }
  
  public native byte[] genAuthBuffer(int paramInt1, int paramInt2, String paramString1, int paramInt3, String paramString2, int paramInt4, int paramInt5);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.sig.QAVAuthBuffer
 * JD-Core Version:    0.7.0.1
 */
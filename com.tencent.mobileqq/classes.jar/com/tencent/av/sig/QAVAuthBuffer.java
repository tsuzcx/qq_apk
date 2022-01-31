package com.tencent.av.sig;

import android.annotation.SuppressLint;
import com.tencent.TMG.utils.SoUtil;

public class QAVAuthBuffer
{
  private static QAVAuthBuffer jdField_a_of_type_ComTencentAvSigQAVAuthBuffer;
  private static boolean jdField_a_of_type_Boolean;
  
  public static QAVAuthBuffer a()
  {
    if (jdField_a_of_type_ComTencentAvSigQAVAuthBuffer == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentAvSigQAVAuthBuffer == null)
      {
        a();
        if (jdField_a_of_type_Boolean) {
          jdField_a_of_type_ComTencentAvSigQAVAuthBuffer = new QAVAuthBuffer();
        }
      }
      return jdField_a_of_type_ComTencentAvSigQAVAuthBuffer;
    }
    finally {}
  }
  
  @SuppressLint({"UnsafeDynamicallyLoadedCode"})
  private static void a()
  {
    if (!jdField_a_of_type_Boolean) {
      try
      {
        if (SoUtil.customLibPath != null)
        {
          System.load(SoUtil.customLibPath + "/libstlport_shared.so");
          System.load(SoUtil.customLibPath + "/libqav_authbuff.so");
        }
        for (;;)
        {
          jdField_a_of_type_Boolean = true;
          return;
          System.loadLibrary("stlport_shared");
          System.loadLibrary("qav_authbuff");
        }
        return;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        jdField_a_of_type_Boolean = false;
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
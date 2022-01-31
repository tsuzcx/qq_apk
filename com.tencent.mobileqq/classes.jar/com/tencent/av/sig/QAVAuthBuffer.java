package com.tencent.av.sig;

public class QAVAuthBuffer
{
  private static boolean mIsSoLoaded = false;
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
  
  private static void loadSo()
  {
    if (!mIsSoLoaded) {}
    try
    {
      System.loadLibrary("stlport_shared");
      System.loadLibrary("qav_authbuff");
      mIsSoLoaded = true;
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      mIsSoLoaded = false;
      localUnsatisfiedLinkError.printStackTrace();
    }
  }
  
  public native byte[] genAuthBuffer(int paramInt1, int paramInt2, String paramString1, int paramInt3, String paramString2, int paramInt4, int paramInt5);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.sig.QAVAuthBuffer
 * JD-Core Version:    0.7.0.1
 */
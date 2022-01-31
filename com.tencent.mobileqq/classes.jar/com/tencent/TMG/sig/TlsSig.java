package com.tencent.TMG.sig;

public class TlsSig
{
  private static boolean mIsSoLoaded = false;
  private static TlsSig sInstance = null;
  
  public static TlsSig getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null)
      {
        loadSo();
        if (mIsSoLoaded) {
          sInstance = new TlsSig();
        }
      }
      return sInstance;
    }
    finally {}
  }
  
  private static void loadSo()
  {
    if (!mIsSoLoaded) {}
    try
    {
      System.loadLibrary("qav_tlssig");
      mIsSoLoaded = true;
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      mIsSoLoaded = false;
      localUnsatisfiedLinkError.printStackTrace();
    }
  }
  
  public native String getTLSSig(int paramInt, String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.TMG.sig.TlsSig
 * JD-Core Version:    0.7.0.1
 */
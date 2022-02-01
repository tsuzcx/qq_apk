package com.tencent.avcore.jni.codec;

public class AndroidCodecAdapterProxy
  implements IAndroidCodecAdapter
{
  private static AndroidCodecAdapterProxy sProxy = null;
  private IAndroidCodecAdapter mImpl = null;
  
  public static AndroidCodecAdapterProxy getInstance()
  {
    if (sProxy == null) {}
    try
    {
      if (sProxy == null) {
        sProxy = new AndroidCodecAdapterProxy();
      }
      return sProxy;
    }
    finally {}
  }
  
  public AndroidCodecBase createDecCodec(String paramString)
  {
    AndroidCodecBase localAndroidCodecBase = null;
    if (this.mImpl != null) {
      localAndroidCodecBase = this.mImpl.createDecCodec(paramString);
    }
    return localAndroidCodecBase;
  }
  
  public AndroidCodecBase createEncCodec(String paramString)
  {
    AndroidCodecBase localAndroidCodecBase = null;
    if (this.mImpl != null) {
      localAndroidCodecBase = this.mImpl.createEncCodec(paramString);
    }
    return localAndroidCodecBase;
  }
  
  public void init(IAndroidCodecAdapter paramIAndroidCodecAdapter)
  {
    this.mImpl = paramIAndroidCodecAdapter;
  }
  
  public boolean isInit()
  {
    return this.mImpl != null;
  }
  
  public boolean isSupportAsyncAPI()
  {
    boolean bool = false;
    if (this.mImpl != null) {
      bool = this.mImpl.isSupportAsyncAPI();
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avcore.jni.codec.AndroidCodecAdapterProxy
 * JD-Core Version:    0.7.0.1
 */
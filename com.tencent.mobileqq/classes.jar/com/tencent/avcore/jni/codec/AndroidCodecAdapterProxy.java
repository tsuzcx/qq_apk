package com.tencent.avcore.jni.codec;

public class AndroidCodecAdapterProxy
  implements IAndroidCodecAdapter
{
  private static AndroidCodecAdapterProxy sProxy;
  private IAndroidCodecAdapter mImpl = null;
  
  public static AndroidCodecAdapterProxy getInstance()
  {
    if (sProxy == null) {
      try
      {
        if (sProxy == null) {
          sProxy = new AndroidCodecAdapterProxy();
        }
      }
      finally {}
    }
    return sProxy;
  }
  
  public AndroidCodecBase createDecCodec(String paramString)
  {
    IAndroidCodecAdapter localIAndroidCodecAdapter = this.mImpl;
    if (localIAndroidCodecAdapter != null) {
      return localIAndroidCodecAdapter.createDecCodec(paramString);
    }
    return null;
  }
  
  public AndroidCodecBase createEncCodec(String paramString)
  {
    IAndroidCodecAdapter localIAndroidCodecAdapter = this.mImpl;
    if (localIAndroidCodecAdapter != null) {
      return localIAndroidCodecAdapter.createEncCodec(paramString);
    }
    return null;
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
    IAndroidCodecAdapter localIAndroidCodecAdapter = this.mImpl;
    if (localIAndroidCodecAdapter != null) {
      return localIAndroidCodecAdapter.isSupportAsyncAPI();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avcore.jni.codec.AndroidCodecAdapterProxy
 * JD-Core Version:    0.7.0.1
 */
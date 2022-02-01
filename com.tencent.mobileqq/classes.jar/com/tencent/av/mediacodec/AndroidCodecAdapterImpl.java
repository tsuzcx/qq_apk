package com.tencent.av.mediacodec;

import com.tencent.avcore.jni.codec.AndroidCodecBase;
import com.tencent.avcore.jni.codec.IAndroidCodecAdapter;

public class AndroidCodecAdapterImpl
  implements IAndroidCodecAdapter
{
  public AndroidCodecBase createDecCodec(String paramString)
  {
    return new AndroidCodec(paramString);
  }
  
  public AndroidCodecBase createEncCodec(String paramString)
  {
    return new AndroidCodec(paramString);
  }
  
  public boolean isSupportAsyncAPI()
  {
    return DeviceCheck.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.mediacodec.AndroidCodecAdapterImpl
 * JD-Core Version:    0.7.0.1
 */
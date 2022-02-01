package com.tencent.av;

import com.tencent.av.mediacodec.AndroidCodecAdapterImpl;
import com.tencent.avcore.jni.codec.AndroidCodecAdapterProxy;
import com.tencent.avcore.util.AVCoreLog;

public class QavEngineAssistant
{
  public static void a()
  {
    if (!AVCoreLog.isInit()) {
      AVCoreLog.init(new AVLogImpl());
    }
    if (!AndroidCodecAdapterProxy.getInstance().isInit()) {
      AndroidCodecAdapterProxy.getInstance().init(new AndroidCodecAdapterImpl());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.QavEngineAssistant
 * JD-Core Version:    0.7.0.1
 */
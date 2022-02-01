package com.tencent.aelight.camera.download.api.impl;

import com.tencent.aelight.camera.ae.AEKitForQQ;
import com.tencent.aelight.camera.download.api.IAEKitForQQ;

public class AEKitForQQImpl
  implements IAEKitForQQ
{
  public boolean init()
  {
    return AEKitForQQ.a();
  }
  
  public boolean isSupported()
  {
    return AEKitForQQ.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.download.api.impl.AEKitForQQImpl
 * JD-Core Version:    0.7.0.1
 */
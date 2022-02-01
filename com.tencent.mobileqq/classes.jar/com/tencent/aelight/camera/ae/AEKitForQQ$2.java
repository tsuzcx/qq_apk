package com.tencent.aelight.camera.ae;

import com.tencent.mobileqq.richmedia.mediacodec.AEVEncoder;
import com.tencent.ttpic.video.AECoderFactory.AEEncoderFactory;
import com.tencent.ttpic.video.AEEncoder;

final class AEKitForQQ$2
  implements AECoderFactory.AEEncoderFactory
{
  public AEEncoder createEncoder(String paramString, int paramInt1, int paramInt2)
  {
    return new AEVEncoder(paramString, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEKitForQQ.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.aelight.camera.aioeditor.shortvideo.util;

import android.media.MediaCodec.BufferInfo;
import java.nio.ByteBuffer;

class HwVideoMerge$SampaleData
{
  public ByteBuffer a;
  public MediaCodec.BufferInfo b = new MediaCodec.BufferInfo();
  public int c;
  public int d;
  
  public void a(int paramInt1, int paramInt2)
  {
    this.a = ByteBuffer.allocate(paramInt1 * paramInt2 * 3 / 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.shortvideo.util.HwVideoMerge.SampaleData
 * JD-Core Version:    0.7.0.1
 */
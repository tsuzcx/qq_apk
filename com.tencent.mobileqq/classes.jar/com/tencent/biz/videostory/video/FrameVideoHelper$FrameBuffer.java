package com.tencent.biz.videostory.video;

import java.io.Serializable;

public class FrameVideoHelper$FrameBuffer
  implements Serializable
{
  private static final long serialVersionUID = 739662983371469000L;
  private final byte[] mData;
  
  public FrameVideoHelper$FrameBuffer(byte[] paramArrayOfByte)
  {
    this.mData = paramArrayOfByte;
  }
  
  public byte[] getData()
  {
    return this.mData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.videostory.video.FrameVideoHelper.FrameBuffer
 * JD-Core Version:    0.7.0.1
 */
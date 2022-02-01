package com.tencent.ilivesdk.playview.codec;

import com.tencent.qt.base.video.VideoFrame;

public abstract interface VideoEncoder
{
  public abstract boolean create(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Object paramObject);
  
  public abstract int encode(byte[] paramArrayOfByte, long paramLong, VideoFrame paramVideoFrame);
  
  public abstract void release();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.playview.codec.VideoEncoder
 * JD-Core Version:    0.7.0.1
 */
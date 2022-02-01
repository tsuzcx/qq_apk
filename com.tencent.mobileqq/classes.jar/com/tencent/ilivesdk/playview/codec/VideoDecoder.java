package com.tencent.ilivesdk.playview.codec;

import com.tencent.ilivesdk.playview.data.VideoFrame;
import com.tencent.ilivesdk.playview.data.VideoImage;

public abstract interface VideoDecoder
{
  public abstract boolean create(int paramInt1, int paramInt2, Object paramObject);
  
  public abstract int decode(VideoFrame paramVideoFrame, VideoImage paramVideoImage);
  
  public abstract void release();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.playview.codec.VideoDecoder
 * JD-Core Version:    0.7.0.1
 */
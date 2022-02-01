package com.tencent.liteav.videodecoder;

import com.tencent.liteav.basic.structs.TXSVideoFrame;

public abstract interface g
{
  public abstract void onDecodeFailed(int paramInt);
  
  public abstract void onDecodeFrame(TXSVideoFrame paramTXSVideoFrame, int paramInt1, int paramInt2, long paramLong1, long paramLong2, int paramInt3);
  
  public abstract void onDecoderChange(String paramString, boolean paramBoolean);
  
  public abstract void onVideoSizeChange(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.videodecoder.g
 * JD-Core Version:    0.7.0.1
 */
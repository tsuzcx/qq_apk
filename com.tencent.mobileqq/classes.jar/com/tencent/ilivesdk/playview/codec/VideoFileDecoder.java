package com.tencent.ilivesdk.playview.codec;

public abstract interface VideoFileDecoder
{
  public abstract int createDecoder(String paramString, Object paramObject);
  
  public abstract void decode();
  
  public abstract long getCurPresentationTimeUs();
  
  public abstract VideoFileDecodeListener getDecodeListener();
  
  public abstract void release();
  
  public abstract void setDecodeListener(VideoFileDecodeListener paramVideoFileDecodeListener);
  
  public abstract void setLoopState(boolean paramBoolean);
  
  public abstract void stop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.playview.codec.VideoFileDecoder
 * JD-Core Version:    0.7.0.1
 */
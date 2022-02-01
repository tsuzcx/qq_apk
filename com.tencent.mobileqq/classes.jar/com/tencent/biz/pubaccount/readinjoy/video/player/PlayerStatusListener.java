package com.tencent.biz.pubaccount.readinjoy.video.player;

public abstract interface PlayerStatusListener
{
  public abstract void beforeVideoStart();
  
  public abstract void onBufferEnd();
  
  public abstract void onBufferStart();
  
  public abstract void onCompletion();
  
  public abstract void onFirstFrameRendered();
  
  public abstract void onProgressChanged(long paramLong);
  
  public abstract void onVideoEnd(int paramInt);
  
  public abstract void onVideoError(int paramInt1, int paramInt2, String paramString);
  
  public abstract void onVideoOpen();
  
  public abstract void onVideoPause();
  
  public abstract void onVideoPrepared();
  
  public abstract void onVideoRestart();
  
  public abstract void onVideoStart();
  
  public abstract void onVideoStop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.player.PlayerStatusListener
 * JD-Core Version:    0.7.0.1
 */
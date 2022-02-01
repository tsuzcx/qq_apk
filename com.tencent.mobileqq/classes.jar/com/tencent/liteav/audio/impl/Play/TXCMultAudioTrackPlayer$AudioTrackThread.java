package com.tencent.liteav.audio.impl.Play;

class TXCMultAudioTrackPlayer$AudioTrackThread
  extends Thread
{
  volatile boolean mIsLooping = false;
  
  public TXCMultAudioTrackPlayer$AudioTrackThread(TXCMultAudioTrackPlayer paramTXCMultAudioTrackPlayer, String paramString)
  {
    super(paramString);
  }
  
  public void startLoop()
  {
    this.mIsLooping = true;
  }
  
  public void stopLoop()
  {
    this.mIsLooping = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.audio.impl.Play.TXCMultAudioTrackPlayer.AudioTrackThread
 * JD-Core Version:    0.7.0.1
 */
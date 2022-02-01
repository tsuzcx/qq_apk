package com.tencent.liteav.audio;

class TXCLiveBGMPlayer$1
  implements Runnable
{
  TXCLiveBGMPlayer$1(TXCLiveBGMPlayer paramTXCLiveBGMPlayer, h paramh) {}
  
  public void run()
  {
    h localh = this.a;
    if (localh != null) {
      localh.onPlayStart();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.audio.TXCLiveBGMPlayer.1
 * JD-Core Version:    0.7.0.1
 */
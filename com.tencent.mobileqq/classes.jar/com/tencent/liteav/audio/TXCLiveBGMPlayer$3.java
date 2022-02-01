package com.tencent.liteav.audio;

class TXCLiveBGMPlayer$3
  implements Runnable
{
  TXCLiveBGMPlayer$3(TXCLiveBGMPlayer paramTXCLiveBGMPlayer, h paramh, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    h localh = this.a;
    if (localh != null) {
      localh.onPlayProgress(this.b, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.audio.TXCLiveBGMPlayer.3
 * JD-Core Version:    0.7.0.1
 */
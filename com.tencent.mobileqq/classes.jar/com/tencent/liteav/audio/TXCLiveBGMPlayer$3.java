package com.tencent.liteav.audio;

class TXCLiveBGMPlayer$3
  implements Runnable
{
  TXCLiveBGMPlayer$3(TXCLiveBGMPlayer paramTXCLiveBGMPlayer, f paramf, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    f localf = this.a;
    if (localf != null) {
      localf.onPlayProgress(this.b, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.audio.TXCLiveBGMPlayer.3
 * JD-Core Version:    0.7.0.1
 */
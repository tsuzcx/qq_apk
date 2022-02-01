package com.tencent.liteav.audio;

class TXCLiveBGMPlayer$1
  implements Runnable
{
  TXCLiveBGMPlayer$1(TXCLiveBGMPlayer paramTXCLiveBGMPlayer, f paramf) {}
  
  public void run()
  {
    f localf = this.a;
    if (localf != null) {
      localf.onPlayStart();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.audio.TXCLiveBGMPlayer.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.liteav.audio;

class TXCLiveBGMPlayer$2
  implements Runnable
{
  TXCLiveBGMPlayer$2(TXCLiveBGMPlayer paramTXCLiveBGMPlayer, f paramf, int paramInt) {}
  
  public void run()
  {
    f localf = this.a;
    if (localf != null) {
      localf.onPlayEnd(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.audio.TXCLiveBGMPlayer.2
 * JD-Core Version:    0.7.0.1
 */
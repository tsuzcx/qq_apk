package com.tencent.liteav.audio;

class TXCLiveBGMPlayer$2
  implements Runnable
{
  TXCLiveBGMPlayer$2(TXCLiveBGMPlayer paramTXCLiveBGMPlayer, h paramh, int paramInt) {}
  
  public void run()
  {
    h localh = this.a;
    if (localh != null) {
      localh.onPlayEnd(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.audio.TXCLiveBGMPlayer.2
 * JD-Core Version:    0.7.0.1
 */
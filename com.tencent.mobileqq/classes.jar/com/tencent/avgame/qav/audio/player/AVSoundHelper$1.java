package com.tencent.avgame.qav.audio.player;

final class AVSoundHelper$1
  implements Runnable
{
  public void run()
  {
    if (AVSoundHelper.j() != null)
    {
      AVSoundHelper.j().a();
      AVSoundHelper.j().d();
      AVSoundHelper.a(null);
    }
    if (AVSoundHelper.k() != null)
    {
      AVSoundHelper.k().c();
      AVSoundHelper.k().d();
      AVSoundHelper.a(null);
    }
    AVSoundHelper.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.qav.audio.player.AVSoundHelper.1
 * JD-Core Version:    0.7.0.1
 */
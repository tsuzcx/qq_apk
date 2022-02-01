package com.tencent.avgame.audio.player;

final class AVSoundHelper$1
  implements Runnable
{
  public void run()
  {
    if (AVSoundHelper.a() != null)
    {
      AVSoundHelper.a().a();
      AVSoundHelper.a().d();
      AVSoundHelper.a(null);
    }
    if (AVSoundHelper.a() != null)
    {
      AVSoundHelper.a().c();
      AVSoundHelper.a().d();
      AVSoundHelper.a(null);
    }
    AVSoundHelper.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.audio.player.AVSoundHelper.1
 * JD-Core Version:    0.7.0.1
 */
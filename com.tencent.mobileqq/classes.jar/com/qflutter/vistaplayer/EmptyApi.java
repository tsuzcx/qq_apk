package com.qflutter.vistaplayer;

import io.flutter.view.TextureRegistry;

public class EmptyApi
  implements IVistaPlayer
{
  public static final String TAG = "VistaPlayer.EmptyApi";
  
  public void clear()
  {
    VistaPlayerLog.w("VistaPlayer.EmptyApi", "clear");
  }
  
  public void dispose(long paramLong)
  {
    VistaPlayerLog.w("VistaPlayer.EmptyApi", "dispose");
  }
  
  public boolean initialize()
  {
    VistaPlayerLog.w("VistaPlayer.EmptyApi", "initialize");
    return false;
  }
  
  public void loop(long paramLong, boolean paramBoolean)
  {
    VistaPlayerLog.w("VistaPlayer.EmptyApi", "loop");
  }
  
  public void pause(long paramLong)
  {
    VistaPlayerLog.w("VistaPlayer.EmptyApi", "pause");
  }
  
  public void playback(long paramLong)
  {
    VistaPlayerLog.w("VistaPlayer.EmptyApi", "playback");
  }
  
  public int position(long paramLong)
  {
    VistaPlayerLog.w("VistaPlayer.EmptyApi", "position");
    return 0;
  }
  
  public long prepare(Object paramObject, TextureRegistry paramTextureRegistry)
  {
    VistaPlayerLog.w("VistaPlayer.EmptyApi", "prepare");
    return 0L;
  }
  
  public void seekTo(long paramLong, int paramInt)
  {
    VistaPlayerLog.w("VistaPlayer.EmptyApi", "seekTo");
  }
  
  public void speed(long paramLong, double paramDouble)
  {
    VistaPlayerLog.w("VistaPlayer.EmptyApi", "speed");
  }
  
  public void stop(long paramLong)
  {
    VistaPlayerLog.w("VistaPlayer.EmptyApi", "stop");
  }
  
  public void volume(long paramLong, double paramDouble)
  {
    VistaPlayerLog.w("VistaPlayer.EmptyApi", "volume");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qflutter.vistaplayer.EmptyApi
 * JD-Core Version:    0.7.0.1
 */
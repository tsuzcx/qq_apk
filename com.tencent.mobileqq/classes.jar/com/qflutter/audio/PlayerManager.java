package com.qflutter.audio;

import com.qflutter.audio.log.LogUtils;
import io.flutter.plugin.common.MethodChannel.Result;

public class PlayerManager
{
  private static final String TAG = "PlayerManager";
  public static BasePlayer sPlayer;
  
  public static void audioPreDownLoad(String paramString, MethodChannel.Result paramResult)
  {
    BasePlayer localBasePlayer = sPlayer;
    if (localBasePlayer == null)
    {
      LogUtils.w("PlayerManager", "audioPreDownLoad: sPlayer is null");
      return;
    }
    localBasePlayer.audioPreDownLoad(paramString, paramResult);
  }
  
  public static void continueAudioPlay(MethodChannel.Result paramResult)
  {
    BasePlayer localBasePlayer = sPlayer;
    if (localBasePlayer == null)
    {
      LogUtils.w("PlayerManager", "continueAudioPlay: sPlayer is null");
      return;
    }
    localBasePlayer.continueAudioPlay(paramResult);
  }
  
  public static void dispose()
  {
    LogUtils.w("PlayerManager", "dispose");
    if (sPlayer != null)
    {
      LogUtils.w("PlayerManager", "dispose: sPlayer is not null");
      sPlayer.stopAudioPlay(null);
      sPlayer.removeAudioPlayerListener();
      sPlayer = null;
    }
  }
  
  public static void pauseAudioPlay(MethodChannel.Result paramResult)
  {
    BasePlayer localBasePlayer = sPlayer;
    if (localBasePlayer == null)
    {
      LogUtils.w("PlayerManager", "pauseAudioPlay: sPlayer is null");
      return;
    }
    localBasePlayer.pauseAudioPlay(paramResult);
  }
  
  public static void setAudioPlayerListener(IPlayerStatusListener paramIPlayerStatusListener)
  {
    BasePlayer localBasePlayer = sPlayer;
    if (localBasePlayer == null)
    {
      LogUtils.w("PlayerManager", "setAudioPlayerListener: sPlayer is null");
      return;
    }
    localBasePlayer.setAudioPlayerListener(paramIPlayerStatusListener);
  }
  
  public static void setPlayer(BasePlayer paramBasePlayer)
  {
    LogUtils.w("PlayerManager", "setPlayer");
    if (sPlayer != null)
    {
      LogUtils.w("PlayerManager", "setPlayer: sPlayer is not null");
      sPlayer.stopAudioPlay(null);
    }
    sPlayer = paramBasePlayer;
  }
  
  public static void startAudioPlay(String paramString, MethodChannel.Result paramResult)
  {
    BasePlayer localBasePlayer = sPlayer;
    if (localBasePlayer == null)
    {
      LogUtils.w("PlayerManager", "startAudioPlay: sPlayer is null");
      return;
    }
    localBasePlayer.startAudioPlay(paramString, paramResult);
  }
  
  public static void stopAudioPlay(MethodChannel.Result paramResult)
  {
    BasePlayer localBasePlayer = sPlayer;
    if (localBasePlayer == null)
    {
      LogUtils.w("PlayerManager", "stopAudioPlay: sPlayer is null");
      return;
    }
    localBasePlayer.stopAudioPlay(paramResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qflutter.audio.PlayerManager
 * JD-Core Version:    0.7.0.1
 */
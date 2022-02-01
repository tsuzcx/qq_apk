package com.qflutter.qqcircle.video;

import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.view.TextureRegistry;

public abstract interface QCircleVideoPlayerApi
{
  public abstract void cleanAll();
  
  public abstract Messages.TextureMessage create(Messages.CreateMessage paramCreateMessage, TextureRegistry paramTextureRegistry, BinaryMessenger paramBinaryMessenger);
  
  public abstract void dispose(Messages.TextureMessage paramTextureMessage);
  
  public abstract void initialize();
  
  public abstract void pause(Messages.TextureMessage paramTextureMessage);
  
  public abstract void play(Messages.TextureMessage paramTextureMessage);
  
  public abstract Messages.PositionMessage position(Messages.TextureMessage paramTextureMessage);
  
  public abstract void seekTo(Messages.PositionMessage paramPositionMessage);
  
  public abstract void setLooping(Messages.LoopingMessage paramLoopingMessage);
  
  public abstract void setPlaybackSpeed(Messages.PlaybackSpeedMessage paramPlaybackSpeedMessage);
  
  public abstract void setVolume(Messages.VolumeMessage paramVolumeMessage);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qflutter.qqcircle.video.QCircleVideoPlayerApi
 * JD-Core Version:    0.7.0.1
 */
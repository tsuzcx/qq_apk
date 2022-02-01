package com.qflutter.qqcircle.video;

import com.qflutter.qqcircle.PLog;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.view.TextureRegistry;

public class QQCircleVideoProxy
  implements Messages.VideoPlayerApi
{
  private QCircleVideoPlayerApi apiImpl;
  private BinaryMessenger messenger;
  private TextureRegistry textureRegistry;
  
  public QQCircleVideoProxy(TextureRegistry paramTextureRegistry, BinaryMessenger paramBinaryMessenger)
  {
    this.textureRegistry = paramTextureRegistry;
    this.messenger = paramBinaryMessenger;
  }
  
  public void clean()
  {
    if (PLog.isColorLevel()) {
      PLog.d("QQCircleVideoProxy", "[clean]");
    }
    if (this.apiImpl != null) {
      this.apiImpl.cleanAll();
    }
    this.apiImpl = null;
    this.messenger = null;
    this.textureRegistry = null;
  }
  
  public Messages.TextureMessage create(Messages.CreateMessage paramCreateMessage)
  {
    if (PLog.isColorLevel()) {
      PLog.d("QQCircleVideoProxy", "[create]");
    }
    if (this.apiImpl != null)
    {
      paramCreateMessage = this.apiImpl.create(paramCreateMessage, this.textureRegistry, this.messenger);
      if (PLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[create] textureId=");
        localStringBuilder.append(paramCreateMessage.getTextureId());
        PLog.d("QQCircleVideoProxy", localStringBuilder.toString());
      }
      return paramCreateMessage;
    }
    return null;
  }
  
  public void dispose(Messages.TextureMessage paramTextureMessage)
  {
    if (PLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[dispose] textureId=");
      localStringBuilder.append(paramTextureMessage.getTextureId());
      PLog.d("QQCircleVideoProxy", localStringBuilder.toString());
    }
    if (this.apiImpl != null) {
      this.apiImpl.dispose(paramTextureMessage);
    }
  }
  
  public void initialize()
  {
    if (PLog.isColorLevel()) {
      PLog.d("QQCircleVideoProxy", "[initialize]");
    }
    if (this.apiImpl != null) {
      this.apiImpl.initialize();
    }
  }
  
  public void pause(Messages.TextureMessage paramTextureMessage)
  {
    if (PLog.isColorLevel()) {
      PLog.d("QQCircleVideoProxy", "[pause]");
    }
    if (this.apiImpl != null) {
      this.apiImpl.pause(paramTextureMessage);
    }
  }
  
  public void play(Messages.TextureMessage paramTextureMessage)
  {
    if (PLog.isColorLevel()) {
      PLog.d("QQCircleVideoProxy", "[play]");
    }
    if (this.apiImpl != null) {
      this.apiImpl.play(paramTextureMessage);
    }
  }
  
  public Messages.PositionMessage position(Messages.TextureMessage paramTextureMessage)
  {
    if (this.apiImpl != null) {
      return this.apiImpl.position(paramTextureMessage);
    }
    return null;
  }
  
  public void seekTo(Messages.PositionMessage paramPositionMessage)
  {
    if (PLog.isColorLevel()) {
      PLog.d("QQCircleVideoProxy", "[seekTo]");
    }
    if (this.apiImpl != null) {
      this.apiImpl.seekTo(paramPositionMessage);
    }
  }
  
  public void setLooping(Messages.LoopingMessage paramLoopingMessage)
  {
    if (PLog.isColorLevel()) {
      PLog.d("QQCircleVideoProxy", "[setLooping]");
    }
    if (this.apiImpl != null) {
      this.apiImpl.setLooping(paramLoopingMessage);
    }
  }
  
  public void setPlaybackSpeed(Messages.PlaybackSpeedMessage paramPlaybackSpeedMessage)
  {
    if (PLog.isColorLevel()) {
      PLog.d("QQCircleVideoProxy", "[setPlaybackSpeed]");
    }
    if (this.apiImpl != null) {
      this.apiImpl.setPlaybackSpeed(paramPlaybackSpeedMessage);
    }
  }
  
  public void setVideoPlayerApi(QCircleVideoPlayerApi paramQCircleVideoPlayerApi)
  {
    if (PLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[setVideoPlayerApi] impl=");
      localStringBuilder.append(paramQCircleVideoPlayerApi.hashCode());
      PLog.d("QQCircleVideoProxy", localStringBuilder.toString());
    }
    this.apiImpl = paramQCircleVideoPlayerApi;
  }
  
  public void setVolume(Messages.VolumeMessage paramVolumeMessage)
  {
    if (PLog.isColorLevel()) {
      PLog.d("QQCircleVideoProxy", "[setVolume]");
    }
    if (this.apiImpl != null) {
      this.apiImpl.setVolume(paramVolumeMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qflutter.qqcircle.video.QQCircleVideoProxy
 * JD-Core Version:    0.7.0.1
 */
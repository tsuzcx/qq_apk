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
    QCircleVideoPlayerApi localQCircleVideoPlayerApi = this.apiImpl;
    if (localQCircleVideoPlayerApi != null) {
      localQCircleVideoPlayerApi.cleanAll();
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
    Object localObject = this.apiImpl;
    if (localObject != null)
    {
      paramCreateMessage = ((QCircleVideoPlayerApi)localObject).create(paramCreateMessage, this.textureRegistry, this.messenger);
      if (PLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[create] textureId=");
        ((StringBuilder)localObject).append(paramCreateMessage.getTextureId());
        PLog.d("QQCircleVideoProxy", ((StringBuilder)localObject).toString());
      }
      return paramCreateMessage;
    }
    return null;
  }
  
  public void dispose(Messages.TextureMessage paramTextureMessage)
  {
    if (PLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[dispose] textureId=");
      ((StringBuilder)localObject).append(paramTextureMessage.getTextureId());
      PLog.d("QQCircleVideoProxy", ((StringBuilder)localObject).toString());
    }
    Object localObject = this.apiImpl;
    if (localObject != null) {
      ((QCircleVideoPlayerApi)localObject).dispose(paramTextureMessage);
    }
  }
  
  public void initialize()
  {
    if (PLog.isColorLevel()) {
      PLog.d("QQCircleVideoProxy", "[initialize]");
    }
    QCircleVideoPlayerApi localQCircleVideoPlayerApi = this.apiImpl;
    if (localQCircleVideoPlayerApi != null) {
      localQCircleVideoPlayerApi.initialize();
    }
  }
  
  public void pause(Messages.TextureMessage paramTextureMessage)
  {
    if (PLog.isColorLevel()) {
      PLog.d("QQCircleVideoProxy", "[pause]");
    }
    QCircleVideoPlayerApi localQCircleVideoPlayerApi = this.apiImpl;
    if (localQCircleVideoPlayerApi != null) {
      localQCircleVideoPlayerApi.pause(paramTextureMessage);
    }
  }
  
  public void play(Messages.TextureMessage paramTextureMessage)
  {
    if (PLog.isColorLevel()) {
      PLog.d("QQCircleVideoProxy", "[play]");
    }
    QCircleVideoPlayerApi localQCircleVideoPlayerApi = this.apiImpl;
    if (localQCircleVideoPlayerApi != null) {
      localQCircleVideoPlayerApi.play(paramTextureMessage);
    }
  }
  
  public Messages.PositionMessage position(Messages.TextureMessage paramTextureMessage)
  {
    QCircleVideoPlayerApi localQCircleVideoPlayerApi = this.apiImpl;
    if (localQCircleVideoPlayerApi != null) {
      return localQCircleVideoPlayerApi.position(paramTextureMessage);
    }
    return null;
  }
  
  public void seekTo(Messages.PositionMessage paramPositionMessage)
  {
    if (PLog.isColorLevel()) {
      PLog.d("QQCircleVideoProxy", "[seekTo]");
    }
    QCircleVideoPlayerApi localQCircleVideoPlayerApi = this.apiImpl;
    if (localQCircleVideoPlayerApi != null) {
      localQCircleVideoPlayerApi.seekTo(paramPositionMessage);
    }
  }
  
  public void setLooping(Messages.LoopingMessage paramLoopingMessage)
  {
    if (PLog.isColorLevel()) {
      PLog.d("QQCircleVideoProxy", "[setLooping]");
    }
    QCircleVideoPlayerApi localQCircleVideoPlayerApi = this.apiImpl;
    if (localQCircleVideoPlayerApi != null) {
      localQCircleVideoPlayerApi.setLooping(paramLoopingMessage);
    }
  }
  
  public void setPlaybackSpeed(Messages.PlaybackSpeedMessage paramPlaybackSpeedMessage)
  {
    if (PLog.isColorLevel()) {
      PLog.d("QQCircleVideoProxy", "[setPlaybackSpeed]");
    }
    QCircleVideoPlayerApi localQCircleVideoPlayerApi = this.apiImpl;
    if (localQCircleVideoPlayerApi != null) {
      localQCircleVideoPlayerApi.setPlaybackSpeed(paramPlaybackSpeedMessage);
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
    QCircleVideoPlayerApi localQCircleVideoPlayerApi = this.apiImpl;
    if (localQCircleVideoPlayerApi != null) {
      localQCircleVideoPlayerApi.setVolume(paramVolumeMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.qflutter.qqcircle.video.QQCircleVideoProxy
 * JD-Core Version:    0.7.0.1
 */
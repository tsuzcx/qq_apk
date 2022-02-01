package com.tencent.ilivesdk.avplayerservice_interface;

import android.content.Context;
import android.graphics.Rect;
import android.widget.FrameLayout;
import com.tencent.falco.base.libapi.ServiceBaseInterface;

public abstract interface AVPlayerServiceInterface
  extends ServiceBaseInterface
{
  public abstract long getCurrentPositionMs();
  
  public abstract Rect getDisplayViewRect();
  
  public abstract long getVideoDurationMs();
  
  public abstract int getVideoHeight();
  
  public abstract int getVideoWidth();
  
  public abstract void init(Context paramContext, FrameLayout paramFrameLayout);
  
  public abstract boolean isPaused();
  
  public abstract boolean isPlaying();
  
  public abstract boolean isUseLocalServerPreload();
  
  public abstract void mutePlay(boolean paramBoolean);
  
  public abstract void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt);
  
  public abstract void onScreenOrientationChange(boolean paramBoolean);
  
  public abstract void pausePlay();
  
  public abstract void preload();
  
  public abstract void preparePlay();
  
  public abstract void readyPlay(FrameLayout paramFrameLayout, boolean paramBoolean);
  
  public abstract void reportPreloadData(boolean paramBoolean);
  
  public abstract void resetPlayer();
  
  public abstract void resumePlay();
  
  public abstract void seekTo(int paramInt);
  
  public abstract void setParams(PlayerParams paramPlayerParams);
  
  public abstract void setPlayerAdapter(AVPlayerServiceAdapter paramAVPlayerServiceAdapter);
  
  public abstract void setPlayerPreloadAdapter(AVPlayerPreloadAdapter paramAVPlayerPreloadAdapter);
  
  public abstract void setPlayerStatusListener(PlayerStatusListener paramPlayerStatusListener);
  
  public abstract void setPlayerSurface();
  
  public abstract void startPlay();
  
  public abstract void stopPlay();
  
  public abstract void switchResolution(PlayerParams paramPlayerParams, PlayerStatusListener paramPlayerStatusListener);
  
  public abstract void uninit();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.avplayerservice_interface.AVPlayerServiceInterface
 * JD-Core Version:    0.7.0.1
 */
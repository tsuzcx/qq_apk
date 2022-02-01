package com.tencent.mobileqq.apollo.game.process.video.api;

import android.content.Context;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.game.process.video.ICmGameVideoCallback;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

@QAPI(process={"all"})
@QRouteFactory(singleton=false)
@Deprecated
public abstract interface ICmGameVideoPlayer
  extends QRouteApi
{
  public static final int STATUS_COMPLETE = 5;
  public static final int STATUS_INIT = 1;
  public static final int STATUS_PAUSED = 4;
  public static final int STATUS_PREPARED = 2;
  public static final int STATUS_RELEASED = 6;
  public static final int STATUS_RESUME = 3;
  
  public abstract void addPlayerCallback(ICmGameVideoCallback paramICmGameVideoCallback);
  
  public abstract void addPlayerCallback(ICmGameVideoCallback paramICmGameVideoCallback, long paramLong);
  
  public abstract long getCurrentPosition();
  
  public abstract boolean getMuteValue();
  
  public abstract int getStatus();
  
  public abstract View getVideoContainer();
  
  public abstract long getVideoDuration();
  
  public abstract int getVideoHeight();
  
  public abstract int getVideoWidth();
  
  public abstract void initVideoPlayer(Context paramContext, AppInterface paramAppInterface);
  
  public abstract boolean isPaused();
  
  public abstract boolean isPlaying();
  
  public abstract boolean isSurfaceDestroyed();
  
  public abstract boolean pause();
  
  public abstract void release();
  
  public abstract void removePlayerCallback(ICmGameVideoCallback paramICmGameVideoCallback);
  
  public abstract void resume();
  
  public abstract void seekTo(int paramInt);
  
  public abstract void setMute(boolean paramBoolean);
  
  public abstract void startPlay(String paramString1, String paramString2, int paramInt);
  
  public abstract void stopPlay();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.video.api.ICmGameVideoPlayer
 * JD-Core Version:    0.7.0.1
 */
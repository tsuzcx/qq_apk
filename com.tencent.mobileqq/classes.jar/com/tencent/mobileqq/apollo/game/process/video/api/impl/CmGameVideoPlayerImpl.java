package com.tencent.mobileqq.apollo.game.process.video.api.impl;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.game.process.video.ICmGameVideoCallback;
import com.tencent.mobileqq.apollo.game.process.video.api.ICmGameVideoPlayer;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener;
import com.tencent.superplayer.api.ISuperPlayer.OnErrorListener;
import com.tencent.superplayer.api.ISuperPlayer.OnInfoListener;
import com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.view.ISPlayerVideoView;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CmGameVideoPlayerImpl
  implements ICmGameVideoPlayer, ISuperPlayer.OnCompletionListener, ISuperPlayer.OnErrorListener, ISuperPlayer.OnInfoListener, ISuperPlayer.OnVideoPreparedListener
{
  public static final String TAG = "[cmshow]CmGameGdtVideoPlayer";
  private long mCallbackFreq = 1000L;
  private Handler mCountHandler = new Handler(Looper.getMainLooper());
  private Runnable mCountRun = new CmGameVideoPlayerImpl.1(this);
  private CopyOnWriteArrayList<ICmGameVideoCallback> mIVideoCallback = new CopyOnWriteArrayList();
  private long mLeftMilSec;
  private ISuperPlayer mPlayer;
  private ISPlayerVideoView mPlayerVideoView;
  private int mStatus;
  private boolean mSurfaceViewDestroyed;
  
  private void startCount()
  {
    if (this.mPlayer != null)
    {
      Handler localHandler = this.mCountHandler;
      if (localHandler != null)
      {
        localHandler.removeCallbacks(this.mCountRun);
        this.mLeftMilSec = (this.mPlayer.getDurationMs() - this.mPlayer.getCurrentPositionMs());
        if (this.mLeftMilSec > 0L) {
          this.mCountHandler.post(this.mCountRun);
        }
      }
    }
  }
  
  private void stopCount()
  {
    Handler localHandler = this.mCountHandler;
    if (localHandler != null) {
      localHandler.removeCallbacks(this.mCountRun);
    }
  }
  
  public void addPlayerCallback(ICmGameVideoCallback paramICmGameVideoCallback)
  {
    addPlayerCallback(paramICmGameVideoCallback, 1000L);
  }
  
  public void addPlayerCallback(ICmGameVideoCallback paramICmGameVideoCallback, long paramLong)
  {
    CopyOnWriteArrayList localCopyOnWriteArrayList = this.mIVideoCallback;
    if ((localCopyOnWriteArrayList != null) && (!localCopyOnWriteArrayList.contains(paramICmGameVideoCallback))) {
      this.mIVideoCallback.add(paramICmGameVideoCallback);
    }
    this.mCallbackFreq = paramLong;
  }
  
  public long getCurrentPosition()
  {
    ISuperPlayer localISuperPlayer = this.mPlayer;
    if (localISuperPlayer != null) {
      return localISuperPlayer.getCurrentPositionMs();
    }
    return 0L;
  }
  
  public boolean getMuteValue()
  {
    ISuperPlayer localISuperPlayer = this.mPlayer;
    if (localISuperPlayer != null) {
      return localISuperPlayer.isOutputMute();
    }
    return false;
  }
  
  public int getStatus()
  {
    return this.mStatus;
  }
  
  public View getVideoContainer()
  {
    if ((this.mPlayerVideoView == null) || (this.mPlayer == null)) {
      try
      {
        QLog.i("[cmshow]CmGameGdtVideoPlayer", 1, "[createPlayerVideoView]");
        this.mPlayerVideoView = SuperPlayerFactory.createPlayerVideoView(BaseApplicationImpl.getContext());
        this.mPlayer = SuperPlayerFactory.createMediaPlayer(BaseApplicationImpl.getContext(), 110, this.mPlayerVideoView);
        this.mPlayer.setOnCompletionListener(this);
        this.mPlayer.setOnVideoPreparedListener(this);
        this.mPlayer.setOnErrorListener(this);
        this.mPlayer.setOnInfoListener(this);
        this.mStatus = 1;
        this.mPlayerVideoView.addViewCallBack(new CmGameVideoPlayerImpl.2(this));
      }
      catch (Exception localException)
      {
        QLog.e("[cmshow]CmGameGdtVideoPlayer", 1, "getVideoContainer", localException);
        this.mPlayerVideoView = null;
        this.mPlayer = null;
      }
    }
    return (View)this.mPlayerVideoView;
  }
  
  public long getVideoDuration()
  {
    ISuperPlayer localISuperPlayer = this.mPlayer;
    if (localISuperPlayer != null) {
      return localISuperPlayer.getDurationMs();
    }
    return 0L;
  }
  
  public int getVideoHeight()
  {
    ISuperPlayer localISuperPlayer = this.mPlayer;
    if (localISuperPlayer != null) {
      return localISuperPlayer.getVideoHeight();
    }
    return 0;
  }
  
  public int getVideoWidth()
  {
    ISuperPlayer localISuperPlayer = this.mPlayer;
    if (localISuperPlayer != null) {
      return localISuperPlayer.getVideoWidth();
    }
    return 0;
  }
  
  public void initVideoPlayer(Context paramContext, AppInterface paramAppInterface) {}
  
  public boolean isPaused()
  {
    ISuperPlayer localISuperPlayer = this.mPlayer;
    if (localISuperPlayer != null) {
      return localISuperPlayer.isPausing();
    }
    return false;
  }
  
  public boolean isPlaying()
  {
    ISuperPlayer localISuperPlayer = this.mPlayer;
    if (localISuperPlayer != null) {
      return localISuperPlayer.isPlaying();
    }
    return false;
  }
  
  public boolean isSurfaceDestroyed()
  {
    return this.mSurfaceViewDestroyed;
  }
  
  public void onCompletion(ISuperPlayer paramISuperPlayer)
  {
    QLog.i("[cmshow]CmGameGdtVideoPlayer", 1, "[onCompletion]");
    this.mLeftMilSec = -1L;
    this.mStatus = 5;
    paramISuperPlayer = this.mIVideoCallback.iterator();
    while (paramISuperPlayer.hasNext())
    {
      ICmGameVideoCallback localICmGameVideoCallback = (ICmGameVideoCallback)paramISuperPlayer.next();
      if (localICmGameVideoCallback != null) {
        localICmGameVideoCallback.e();
      }
    }
  }
  
  public boolean onError(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    paramISuperPlayer = new StringBuilder();
    paramISuperPlayer.append("[onError]extra model = ");
    paramISuperPlayer.append(paramInt1);
    paramISuperPlayer.append(", errorType = ");
    paramISuperPlayer.append(paramInt2);
    paramISuperPlayer.append(", errorCode = ");
    paramISuperPlayer.append(paramInt3);
    paramISuperPlayer.append(", detailInfo = ");
    paramISuperPlayer.append(paramString);
    QLog.i("[cmshow]CmGameGdtVideoPlayer", 1, paramISuperPlayer.toString());
    paramISuperPlayer = this.mIVideoCallback.iterator();
    while (paramISuperPlayer.hasNext())
    {
      ICmGameVideoCallback localICmGameVideoCallback = (ICmGameVideoCallback)paramISuperPlayer.next();
      if (localICmGameVideoCallback != null) {
        localICmGameVideoCallback.a(paramInt1, paramInt2, paramInt2, paramString);
      }
    }
    stopCount();
    return false;
  }
  
  public boolean onInfo(ISuperPlayer paramISuperPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    paramISuperPlayer = new StringBuilder();
    paramISuperPlayer.append("what:");
    paramISuperPlayer.append(paramInt);
    QLog.i("[cmshow]CmGameGdtVideoPlayer", 1, paramISuperPlayer.toString());
    return false;
  }
  
  public void onVideoPrepared(ISuperPlayer paramISuperPlayer)
  {
    QLog.i("[cmshow]CmGameGdtVideoPlayer", 1, "[onVideoPrepared]");
    this.mStatus = 2;
    this.mSurfaceViewDestroyed = false;
    paramISuperPlayer = this.mIVideoCallback.iterator();
    while (paramISuperPlayer.hasNext())
    {
      ICmGameVideoCallback localICmGameVideoCallback = (ICmGameVideoCallback)paramISuperPlayer.next();
      if (localICmGameVideoCallback != null) {
        localICmGameVideoCallback.c();
      }
    }
  }
  
  public boolean pause()
  {
    ISuperPlayer localISuperPlayer = this.mPlayer;
    if ((localISuperPlayer != null) && (localISuperPlayer.isPlaying()))
    {
      QLog.i("[cmshow]CmGameGdtVideoPlayer", 1, "[pause]");
      this.mPlayer.pause();
      stopCount();
      this.mStatus = 4;
      return true;
    }
    return false;
  }
  
  public void release()
  {
    QLog.i("[cmshow]CmGameGdtVideoPlayer", 1, "[release]");
    stopCount();
    ISuperPlayer localISuperPlayer = this.mPlayer;
    if (localISuperPlayer != null)
    {
      localISuperPlayer.stop();
      this.mPlayer.release();
      this.mPlayer = null;
      this.mStatus = 6;
    }
  }
  
  public void removePlayerCallback(ICmGameVideoCallback paramICmGameVideoCallback)
  {
    CopyOnWriteArrayList localCopyOnWriteArrayList = this.mIVideoCallback;
    if ((localCopyOnWriteArrayList != null) && (localCopyOnWriteArrayList.contains(paramICmGameVideoCallback))) {
      this.mIVideoCallback.remove(paramICmGameVideoCallback);
    }
  }
  
  public void resume()
  {
    if (this.mPlayer != null)
    {
      QLog.i("[cmshow]CmGameGdtVideoPlayer", 1, "[resume]");
      this.mPlayer.start();
      this.mStatus = 3;
      startCount();
    }
  }
  
  public void seekTo(int paramInt)
  {
    if (this.mPlayer != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[seekTo]");
      localStringBuilder.append(paramInt);
      QLog.i("[cmshow]CmGameGdtVideoPlayer", 1, localStringBuilder.toString());
      this.mPlayer.seekTo(paramInt);
    }
  }
  
  public void setMute(boolean paramBoolean)
  {
    if (this.mPlayer != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setMute ");
      localStringBuilder.append(paramBoolean);
      QLog.i("[cmshow]CmGameGdtVideoPlayer", 1, localStringBuilder.toString());
      this.mPlayer.setOutputMute(paramBoolean);
    }
  }
  
  public void startPlay(String paramString1, String paramString2, int paramInt)
  {
    if (this.mPlayer != null)
    {
      paramString2 = new StringBuilder();
      paramString2.append("[startPlay] url = ");
      paramString2.append(paramString1);
      QLog.i("[cmshow]CmGameGdtVideoPlayer", 1, paramString2.toString());
      paramString1 = SuperPlayerFactory.createVideoInfoForUrl(paramString1, 104, null);
      this.mPlayer.openMediaPlayer(BaseApplicationImpl.getContext(), paramString1, paramInt);
    }
  }
  
  public void stopPlay()
  {
    this.mPlayer.stop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.video.api.impl.CmGameVideoPlayerImpl
 * JD-Core Version:    0.7.0.1
 */
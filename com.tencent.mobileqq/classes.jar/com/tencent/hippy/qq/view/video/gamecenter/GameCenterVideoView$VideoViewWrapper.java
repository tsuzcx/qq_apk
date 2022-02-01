package com.tencent.hippy.qq.view.video.gamecenter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.SeekBar;
import androidx.collection.ArrayMap;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.mobileqq.gamecenter.media.GameCenterVideoManager;
import com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;

class GameCenterVideoView$VideoViewWrapper
  extends GameCenterVideoViewController
{
  private boolean mAttachCalled;
  private boolean mDestroyed;
  private boolean mDetachCalled;
  private ArrayMap<String, GameCenterVideoView.FunctionExecutor> mFunctionMap;
  private int mHippyEngineId = -2147483648;
  private boolean mOnPreparedCalled;
  private boolean mReleaseCalled;
  
  public GameCenterVideoView$VideoViewWrapper(GameCenterVideoView paramGameCenterVideoView, @NonNull Context paramContext, int paramInt)
  {
    super(paramContext);
    this.mHippyEngineId = paramInt;
  }
  
  private ArrayMap<String, GameCenterVideoView.FunctionExecutor> ensureFunctionMap()
  {
    if (this.mFunctionMap == null)
    {
      this.mFunctionMap = new ArrayMap();
      this.mFunctionMap.put("play", new GameCenterVideoView.VideoViewWrapper.PlayFunction(this, null));
      this.mFunctionMap.put("seek", new GameCenterVideoView.VideoViewWrapper.SeekFunction(this, null));
      this.mFunctionMap.put("pause", new GameCenterVideoView.VideoViewWrapper.PauseFunction(this, null));
      this.mFunctionMap.put("stop", new GameCenterVideoView.VideoViewWrapper.StopFunction(this, null));
      this.mFunctionMap.put("getProgress", new GameCenterVideoView.VideoViewWrapper.GetProgressFunction(this, null));
      this.mFunctionMap.put("curPlayState", new GameCenterVideoView.VideoViewWrapper.GetStateFunction(this, null));
      this.mFunctionMap.put("setListenProgress", new GameCenterVideoView.VideoViewWrapper.setListenProgressFunction(this, null));
      this.mFunctionMap.put("setMuted", new GameCenterVideoView.VideoViewWrapper.setMutedFunction(this, null));
    }
    return this.mFunctionMap;
  }
  
  private HippyMap updateProgressMap(long paramLong)
  {
    GameCenterVideoView.access$1700(this.this$0).pushLong("progressTime", paramLong);
    GameCenterVideoView.access$1700(this.this$0).pushLong("duration", GameCenterVideoView.access$600(this.this$0));
    return GameCenterVideoView.access$1700(this.this$0);
  }
  
  public void destroy()
  {
    this.mDestroyed = true;
    release();
    if (GameCenterVideoManager.a().a() == this) {
      GameCenterVideoManager.a().a();
    }
  }
  
  public void enterFullScreen()
  {
    super.enterFullScreen();
    GameCenterVideoView.access$802(this.this$0, true);
  }
  
  public void exitFullScreen()
  {
    super.exitFullScreen();
    GameCenterVideoView.access$802(this.this$0, false);
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.mAttachCalled = true;
  }
  
  public void onCompletion(ISuperPlayer paramISuperPlayer)
  {
    super.onCompletion(paramISuperPlayer);
    GameCenterVideoView.access$402(this.this$0, 1);
    this.this$0.sendEvent("onPlayFinish", null);
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.mDetachCalled = true;
  }
  
  public boolean onError(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterVideoViewController", 2, new Object[] { "onError, errCode:", Integer.valueOf(paramInt1), ", errMsg:", paramString });
    }
    HippyMap localHippyMap = new HippyMap();
    localHippyMap.pushInt("errcode", paramInt1);
    localHippyMap.pushString("errorMsg", paramString);
    this.this$0.sendEvent("onError", localHippyMap);
    return super.onError(paramISuperPlayer, paramInt1, paramInt2, paramInt3, paramString);
  }
  
  public void onPlayerCreated(ISuperPlayer paramISuperPlayer)
  {
    if ((GameCenterVideoView.access$2100(this.this$0) == 0) || (GameCenterVideoView.access$2100(this.this$0) > 1))
    {
      paramISuperPlayer.setLoopback(true);
      paramISuperPlayer.setOnInfoListener(new GameCenterVideoView.VideoViewWrapper.1(this, paramISuperPlayer));
    }
  }
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    super.onProgressChanged(paramSeekBar, paramInt, paramBoolean);
    if (GameCenterVideoView.access$300(this.this$0)) {
      this.this$0.sendEvent("onProgress", updateProgressMap(paramInt));
    }
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterVideoViewController", 2, "onProgressChanged progress:" + paramInt);
    }
  }
  
  public void onVideoPrepared(ISuperPlayer paramISuperPlayer)
  {
    super.onVideoPrepared(paramISuperPlayer);
    this.mOnPreparedCalled = true;
  }
  
  public void onViewChanged(View paramView)
  {
    GameCenterVideoView.access$700(this.this$0, paramView);
  }
  
  public void play()
  {
    super.play();
    new HippyViewEvent("onVideoPlay").send(this.this$0, "");
  }
  
  public void release()
  {
    super.release();
    this.mReleaseCalled = true;
  }
  
  public Activity scanForActivity(Context paramContext)
  {
    HippyQQEngine localHippyQQEngine = HippyQQEngine.getEngineInstance(this.mHippyEngineId);
    if ((localHippyQQEngine != null) && (localHippyQQEngine.getActivity() != null)) {
      return localHippyQQEngine.getActivity();
    }
    return super.scanForActivity(paramContext);
  }
  
  public void setCurrentStatus(int paramInt)
  {
    int i = getCurrentStatus();
    super.setCurrentStatus(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterVideoViewController", 2, new Object[] { "onVideoStatusChanged, oldStatus:", Integer.valueOf(i), ", curStatus:", Integer.valueOf(paramInt) });
    }
    if ((paramInt == 0) || (paramInt == 4) || (paramInt == 3) || (paramInt == 5) || (paramInt == 7))
    {
      localHippyMap = new HippyMap();
      localHippyMap.pushInt("curPlayState", GameCenterVideoView.access$500().get(paramInt));
      localHippyMap.pushInt("oldPlayState", GameCenterVideoView.access$500().get(i));
      this.this$0.sendEvent("onPlayStateChanged", localHippyMap);
    }
    while (paramInt != 2)
    {
      HippyMap localHippyMap;
      return;
    }
    GameCenterVideoView.access$602(this.this$0, getDuration());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.view.video.gamecenter.GameCenterVideoView.VideoViewWrapper
 * JD-Core Version:    0.7.0.1
 */
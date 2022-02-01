package com.tencent.hippy.qq.view.video;

import com.tencent.mtt.hippy.modules.Promise;
import org.json.JSONObject;

public abstract interface HippyQQVideoView$OnVideoViewControlListener
{
  public abstract void afterChangeFullScreen(HippyQQVideoView paramHippyQQVideoView);
  
  public abstract void beforeChangeFullScreen(HippyQQVideoView paramHippyQQVideoView);
  
  public abstract void enterFullScreen(int paramInt, HippyQQVideoView paramHippyQQVideoView, boolean paramBoolean, Promise paramPromise);
  
  public abstract void exitFullScreen(HippyQQVideoView paramHippyQQVideoView, Promise paramPromise);
  
  public abstract void getPlayInfo(HippyQQVideoView paramHippyQQVideoView, Promise paramPromise);
  
  public abstract boolean isFullScreen();
  
  public abstract void onActivityCreate();
  
  public abstract void onActivityDestroy();
  
  public abstract void onActivityPause();
  
  public abstract void onActivityResume();
  
  public abstract void onActivityStart();
  
  public abstract void onActivityStop();
  
  public abstract void open(HippyQQVideoView paramHippyQQVideoView, JSONObject paramJSONObject);
  
  public abstract void pause(HippyQQVideoView paramHippyQQVideoView);
  
  public abstract void play(HippyQQVideoView paramHippyQQVideoView);
  
  public abstract void preplay(HippyQQVideoView paramHippyQQVideoView);
  
  public abstract void replay(HippyQQVideoView paramHippyQQVideoView);
  
  public abstract void resetSrc(HippyQQVideoView paramHippyQQVideoView, JSONObject paramJSONObject);
  
  public abstract void seek(HippyQQVideoView paramHippyQQVideoView, int paramInt);
  
  public abstract void setEndWithLastFrame(boolean paramBoolean);
  
  public abstract void setLoopBack(boolean paramBoolean);
  
  public abstract void setMuted(HippyQQVideoView paramHippyQQVideoView, boolean paramBoolean);
  
  public abstract void setResize(HippyQQVideoView paramHippyQQVideoView, String paramString);
  
  public abstract void setStartPosition(int paramInt);
  
  public abstract void setTimeInterval(HippyQQVideoView paramHippyQQVideoView, int paramInt);
  
  public abstract void stop(HippyQQVideoView paramHippyQQVideoView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.view.video.HippyQQVideoView.OnVideoViewControlListener
 * JD-Core Version:    0.7.0.1
 */
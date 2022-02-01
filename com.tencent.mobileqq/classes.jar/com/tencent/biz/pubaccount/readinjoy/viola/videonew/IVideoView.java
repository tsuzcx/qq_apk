package com.tencent.biz.pubaccount.readinjoy.viola.videonew;

import android.view.ViewGroup;

public abstract interface IVideoView
  extends VideoPlayManager.VideoStatusListener
{
  public abstract ViewGroup a();
  
  public abstract void a();
  
  public abstract void a(int paramInt);
  
  public abstract void a(int paramInt, boolean paramBoolean);
  
  public abstract void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam);
  
  public abstract void a(VideoPlayManager paramVideoPlayManager);
  
  public abstract boolean a();
  
  public abstract void b();
  
  public abstract void c();
  
  public abstract void setControlType(int paramInt);
  
  public abstract void setEndWithLastFrame(boolean paramBoolean);
  
  public abstract void setEventListener(IVideoView.VideoViewEventListener paramVideoViewEventListener);
  
  public abstract void setFullScreenDisable(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.videonew.IVideoView
 * JD-Core Version:    0.7.0.1
 */
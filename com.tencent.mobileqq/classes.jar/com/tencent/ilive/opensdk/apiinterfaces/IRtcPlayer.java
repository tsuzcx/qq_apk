package com.tencent.ilive.opensdk.apiinterfaces;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import com.tencent.ilive.opensdk.callbacks.RtcCoreEventObserver;
import com.tencent.ilive.opensdk.params.RtcRoomEnterParams;
import java.lang.ref.WeakReference;

public abstract interface IRtcPlayer
{
  public abstract void enterRoom(RtcRoomEnterParams paramRtcRoomEnterParams, WeakReference<View> paramWeakReference, RtcCoreEventObserver paramRtcCoreEventObserver);
  
  public abstract void exitRoom();
  
  public abstract Rect getDisplayViewRect();
  
  public abstract void initRTCPlayer(Context paramContext);
  
  public abstract void pause();
  
  public abstract void release();
  
  public abstract void resume();
  
  public abstract void start();
  
  public abstract void stop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.opensdk.apiinterfaces.IRtcPlayer
 * JD-Core Version:    0.7.0.1
 */
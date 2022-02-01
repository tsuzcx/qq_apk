package com.tencent.ilive.opensdk.apiinterfaces;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import com.tencent.ilive.opensdk.callbacks.RtcCoreEventObserver;
import com.tencent.ilive.opensdk.params.RtcRoomEnterParams;
import java.lang.ref.WeakReference;

public class RtcPlayer
  implements IRtcPlayer
{
  public void enterRoom(RtcRoomEnterParams paramRtcRoomEnterParams, WeakReference<View> paramWeakReference, RtcCoreEventObserver paramRtcCoreEventObserver) {}
  
  public void exitRoom() {}
  
  public Rect getDisplayViewRect()
  {
    return null;
  }
  
  public void initRTCPlayer(Context paramContext) {}
  
  public void pause() {}
  
  public void release() {}
  
  public void resume() {}
  
  public void start() {}
  
  public void stop() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.opensdk.apiinterfaces.RtcPlayer
 * JD-Core Version:    0.7.0.1
 */
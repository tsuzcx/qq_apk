package com.tencent.ilive.audiencepages.room.events;

import android.annotation.SuppressLint;
import android.os.Parcel;
import com.tencent.ilive.base.event.ModuleEventInterface;

@SuppressLint({"ParcelCreator"})
public class FloatWindowStateEvent
  implements ModuleEventInterface
{
  public static final int FROM_ACTIVITY_DESTROY = 7;
  public static final int FROM_ANCHOR_CLOSE = 6;
  public static final int FROM_DEFAULT = 0;
  public static final int FROM_FLOAT_WINDOW_CLICK = 8;
  public static final int FROM_FLOAT_WINDOW_CLOSE_CLICK = 9;
  public static final int FROM_KICK_OUT = 5;
  public static final int FROM_RESUME = 3;
  public static final int FROM_SWITCH_BACKGROUND = 4;
  public int reason;
  public boolean showing = false;
  
  public FloatWindowStateEvent(boolean paramBoolean, int paramInt)
  {
    this.showing = paramBoolean;
    this.reason = paramInt;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.events.FloatWindowStateEvent
 * JD-Core Version:    0.7.0.1
 */
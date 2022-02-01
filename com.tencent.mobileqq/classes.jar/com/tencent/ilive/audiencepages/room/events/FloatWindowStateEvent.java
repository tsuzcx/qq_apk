package com.tencent.ilive.audiencepages.room.events;

import android.annotation.SuppressLint;
import android.os.Parcel;
import com.tencent.ilive.base.event.ModuleEventInterface;

@SuppressLint({"ParcelCreator"})
public class FloatWindowStateEvent
  implements ModuleEventInterface
{
  public boolean showing = false;
  
  public FloatWindowStateEvent(boolean paramBoolean)
  {
    this.showing = paramBoolean;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.events.FloatWindowStateEvent
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.ilive.audiencepages.room.events;

import android.annotation.SuppressLint;
import android.os.Parcel;
import com.tencent.ilive.base.event.ModuleEventInterface;

@SuppressLint({"ParcelCreator"})
public class PlayLittleWindowEvent
  implements ModuleEventInterface
{
  public boolean mIsPlay;
  
  public PlayLittleWindowEvent(boolean paramBoolean)
  {
    this.mIsPlay = paramBoolean;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.events.PlayLittleWindowEvent
 * JD-Core Version:    0.7.0.1
 */
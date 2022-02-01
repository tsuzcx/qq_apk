package com.tencent.ilive.audiencepages.room.events;

import android.annotation.SuppressLint;
import android.os.Parcel;
import com.tencent.ilive.base.event.ModuleEventInterface;

@SuppressLint({"ParcelCreator"})
public class ShowAnchorStateEvent
  implements ModuleEventInterface
{
  public ShowAnchorStateEvent.AnchorState anchorState;
  public long uin;
  
  public ShowAnchorStateEvent(ShowAnchorStateEvent.AnchorState paramAnchorState, long paramLong)
  {
    this.anchorState = paramAnchorState;
    this.uin = paramLong;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.events.ShowAnchorStateEvent
 * JD-Core Version:    0.7.0.1
 */
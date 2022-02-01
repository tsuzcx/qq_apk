package com.tencent.ilive.pages.room.events;

import android.annotation.SuppressLint;
import android.os.Parcel;
import com.tencent.ilive.base.event.ModuleEventInterface;

@SuppressLint({"ParcelCreator"})
public class ExitRoomtEvent
  implements ModuleEventInterface
{
  public boolean isFinishPage = true;
  
  public ExitRoomtEvent(boolean paramBoolean)
  {
    this.isFinishPage = paramBoolean;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.pages.room.events.ExitRoomtEvent
 * JD-Core Version:    0.7.0.1
 */
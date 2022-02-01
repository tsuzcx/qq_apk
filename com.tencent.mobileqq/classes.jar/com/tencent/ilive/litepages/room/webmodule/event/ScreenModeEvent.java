package com.tencent.ilive.litepages.room.webmodule.event;

import android.annotation.SuppressLint;
import android.os.Parcel;
import com.tencent.ilive.base.event.ModuleEventInterface;

@SuppressLint({"ParcelCreator"})
public class ScreenModeEvent
  implements ModuleEventInterface
{
  public boolean isLandscape = false;
  
  public ScreenModeEvent(boolean paramBoolean)
  {
    this.isLandscape = paramBoolean;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.litepages.room.webmodule.event.ScreenModeEvent
 * JD-Core Version:    0.7.0.1
 */
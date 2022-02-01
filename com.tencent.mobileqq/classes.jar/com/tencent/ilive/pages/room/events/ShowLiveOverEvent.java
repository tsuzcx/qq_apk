package com.tencent.ilive.pages.room.events;

import android.annotation.SuppressLint;
import android.os.Parcel;
import com.tencent.ilive.base.event.ModuleEventInterface;

@SuppressLint({"ParcelCreator"})
public class ShowLiveOverEvent
  implements ModuleEventInterface
{
  public String notify;
  public ShowLiveOverEvent.Source source;
  
  public ShowLiveOverEvent(String paramString, ShowLiveOverEvent.Source paramSource)
  {
    this.notify = paramString;
    this.source = paramSource;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.pages.room.events.ShowLiveOverEvent
 * JD-Core Version:    0.7.0.1
 */
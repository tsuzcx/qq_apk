package com.tencent.ilive.litepages.room.webmodule.event;

import android.annotation.SuppressLint;
import android.os.Parcel;
import com.tencent.ilive.base.event.ModuleEventInterface;

@SuppressLint({"ParcelCreator"})
public class WebviewTransmitEvent
  implements ModuleEventInterface
{
  public String a;
  public String b;
  
  public WebviewTransmitEvent(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.litepages.room.webmodule.event.WebviewTransmitEvent
 * JD-Core Version:    0.7.0.1
 */
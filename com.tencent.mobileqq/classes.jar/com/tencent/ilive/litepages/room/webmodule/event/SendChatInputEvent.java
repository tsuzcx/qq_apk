package com.tencent.ilive.litepages.room.webmodule.event;

import android.annotation.SuppressLint;
import android.os.Parcel;
import com.tencent.ilive.base.event.ModuleEventInterface;

@SuppressLint({"ParcelCreator"})
public class SendChatInputEvent
  implements ModuleEventInterface
{
  public static final int CANCEL_KEYBOARD = 2;
  public static final int SEND_MSG = 1;
  public String mContent;
  public int mType;
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.litepages.room.webmodule.event.SendChatInputEvent
 * JD-Core Version:    0.7.0.1
 */
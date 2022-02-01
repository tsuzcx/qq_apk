package com.tencent.ilive.pages.room.events;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.view.MotionEvent;
import com.tencent.ilive.base.event.ModuleEventInterface;

@SuppressLint({"ParcelCreator"})
public class PlayerTouchEvent
  implements ModuleEventInterface
{
  public MotionEvent motionEvent;
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.pages.room.events.PlayerTouchEvent
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.ilive.pages.room.events;

import android.annotation.SuppressLint;
import android.os.Parcel;
import com.tencent.ilive.base.event.ModuleEventInterface;

@SuppressLint({"ParcelCreator"})
public class RoomCloseEvent
  implements ModuleEventInterface
{
  public static final short ID_SCENE_BTN_CLOSE = 3;
  public static final short ID_SCENE_KICK_OUT = 4;
  public static final short ID_SCENE_OTHER = 5;
  public static final short ID_SCENE_PLAY_OVER = 2;
  public static final short ID_SCENE_SCROLL = 1;
  public int sceneId = 5;
  
  public RoomCloseEvent() {}
  
  public RoomCloseEvent(short paramShort)
  {
    this.sceneId = paramShort;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.pages.room.events.RoomCloseEvent
 * JD-Core Version:    0.7.0.1
 */
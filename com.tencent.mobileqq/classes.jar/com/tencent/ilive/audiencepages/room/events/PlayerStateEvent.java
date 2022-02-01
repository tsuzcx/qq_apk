package com.tencent.ilive.audiencepages.room.events;

import android.annotation.SuppressLint;
import android.os.Parcel;
import com.tencent.ilive.base.event.ModuleEventInterface;

@SuppressLint({"ParcelCreator"})
public class PlayerStateEvent
  implements ModuleEventInterface
{
  public int errCode = 0;
  public PlayerStateEvent.PlayerState playerState;
  
  public PlayerStateEvent(PlayerStateEvent.PlayerState paramPlayerState)
  {
    this.playerState = paramPlayerState;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.events.PlayerStateEvent
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.ilive.interfaces;

import com.tencent.ilivesdk.roomswitchservice_interface.SwitchRoomInfo;

public abstract interface RoomPageActionInterface
{
  public abstract void finish();
  
  public abstract boolean onFloatWindowClick(Runnable paramRunnable, SwitchRoomInfo paramSwitchRoomInfo);
  
  public abstract void onScrollTopOrBottom(int paramInt);
  
  public abstract void setRequestedOrientation(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.interfaces.RoomPageActionInterface
 * JD-Core Version:    0.7.0.1
 */
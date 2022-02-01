package com.tencent.avgame.ui;

import android.support.v4.app.FragmentActivity;
import com.tencent.avgame.business.observer.AvGameRoomListObserver;
import com.tencent.avgame.gamelogic.data.RoomInfo;

class AVGameJoinRoomFragment$1
  extends AvGameRoomListObserver
{
  AVGameJoinRoomFragment$1(AVGameJoinRoomFragment paramAVGameJoinRoomFragment) {}
  
  public void b(int paramInt, String paramString, RoomInfo paramRoomInfo, byte[] paramArrayOfByte, long paramLong1, long paramLong2)
  {
    super.b(paramInt, paramString, paramRoomInfo, paramArrayOfByte, paramLong1, paramLong2);
    this.a.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGameJoinRoomFragment.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.avgame.ui;

import com.tencent.avgame.business.observer.AvGameRoomListObserver;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.mobileqq.app.QBaseActivity;

class AVGameJoinRoomFragment$1
  extends AvGameRoomListObserver
{
  AVGameJoinRoomFragment$1(AVGameJoinRoomFragment paramAVGameJoinRoomFragment) {}
  
  public void b(int paramInt, String paramString, RoomInfo paramRoomInfo, byte[] paramArrayOfByte, long paramLong1, long paramLong2)
  {
    super.b(paramInt, paramString, paramRoomInfo, paramArrayOfByte, paramLong1, paramLong2);
    this.a.getQBaseActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGameJoinRoomFragment.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.ilivesdk.supervisionservice_interface;

import com.tencent.ilivesdk.supervisionservice_interface.model.AdminReason;
import java.util.List;

public abstract interface KickOutRoomInterface
{
  public abstract void addKickedOutOfRoomListener(KickOutRoomInterface.OnKickedOutOfRoomListener paramOnKickedOutOfRoomListener);
  
  public abstract void cancelKickOutUser(long paramLong1, long paramLong2, long paramLong3, KickOutRoomInterface.KickOutUserCallback paramKickOutUserCallback);
  
  public abstract List<AdminReason> getKickOutReasonList();
  
  public abstract void kickOutUser(long paramLong1, long paramLong2, long paramLong3, int paramInt, KickOutRoomInterface.KickOutUserCallback paramKickOutUserCallback);
  
  public abstract void queryKickOutHistory(long paramLong1, long paramLong2, int paramInt1, int paramInt2, KickOutRoomInterface.QueryKickOutHistoryCallback paramQueryKickOutHistoryCallback);
  
  public abstract void removeKickedOutOfRoomListener(KickOutRoomInterface.OnKickedOutOfRoomListener paramOnKickedOutOfRoomListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.supervisionservice_interface.KickOutRoomInterface
 * JD-Core Version:    0.7.0.1
 */
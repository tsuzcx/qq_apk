package com.tencent.ilivesdk.supervisionservice_interface;

import com.tencent.ilivesdk.supervisionservice_interface.model.PunishedUserInfo;
import java.util.List;

public abstract interface KickOutRoomInterface$QueryKickOutHistoryCallback
  extends CallbackBase
{
  public abstract void onSuccess(List<PunishedUserInfo> paramList, int paramInt, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.supervisionservice_interface.KickOutRoomInterface.QueryKickOutHistoryCallback
 * JD-Core Version:    0.7.0.1
 */
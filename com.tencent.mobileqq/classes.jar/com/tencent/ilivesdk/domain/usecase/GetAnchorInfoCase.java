package com.tencent.ilivesdk.domain.usecase;

import com.tencent.ilivesdk.domain.factory.LiveUseCase;
import com.tencent.ilivesdk.roomservice_interface.RoomServiceInterface;
import com.tencent.ilivesdk.roomservice_interface.model.LiveAnchorInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveInfo;
import com.tencent.livesdk.roomengine.RoomEngine;

public class GetAnchorInfoCase
  extends LiveUseCase<LiveAnchorInfo, Long>
{
  RoomServiceInterface roomService;
  
  protected void executeRoomUseCase(RoomEngine paramRoomEngine, Long paramLong)
  {
    this.roomService = ((RoomServiceInterface)paramRoomEngine.getService(RoomServiceInterface.class));
    paramRoomEngine = this.roomService;
    if (paramRoomEngine != null)
    {
      if (paramRoomEngine.getLiveInfo() == null) {
        return;
      }
      paramRoomEngine = this.roomService.getLiveInfo().anchorInfo;
      if (paramRoomEngine != null) {
        post(paramRoomEngine);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.domain.usecase.GetAnchorInfoCase
 * JD-Core Version:    0.7.0.1
 */
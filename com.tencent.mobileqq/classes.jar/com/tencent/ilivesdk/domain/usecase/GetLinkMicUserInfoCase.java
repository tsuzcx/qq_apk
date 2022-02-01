package com.tencent.ilivesdk.domain.usecase;

import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilive.enginemanager.BizEngineMgr;
import com.tencent.ilivesdk.domain.factory.LiveUseCase;
import com.tencent.ilivesdk.linkmicbizserviceinterface.LinkMicBizServiceInterface;
import com.tencent.ilivesdk.roomservice_interface.RoomServiceInterface;
import com.tencent.livesdk.liveengine.LiveEngine;
import com.tencent.livesdk.roomengine.RoomEngine;

public class GetLinkMicUserInfoCase
  extends LiveUseCase<GetLinkMicUserInfoCase.ResponseValue, GetLinkMicUserInfoCase.RequestValue>
{
  private final String TAG = "GetLinkMicUserInfoCase";
  private LinkMicBizServiceInterface mLinkMicBizService;
  private LogInterface mLogger = (LogInterface)BizEngineMgr.getInstance().getLiveEngine().getService(LogInterface.class);
  private RoomServiceInterface mRoomService;
  
  protected void executeRoomUseCase(RoomEngine paramRoomEngine, GetLinkMicUserInfoCase.RequestValue paramRequestValue)
  {
    this.mLinkMicBizService = ((LinkMicBizServiceInterface)paramRoomEngine.getService(LinkMicBizServiceInterface.class));
    this.mRoomService = ((RoomServiceInterface)paramRoomEngine.getService(RoomServiceInterface.class));
    this.mLinkMicBizService.a(paramRequestValue.roomId, paramRequestValue.linkMicId, new GetLinkMicUserInfoCase.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.domain.usecase.GetLinkMicUserInfoCase
 * JD-Core Version:    0.7.0.1
 */
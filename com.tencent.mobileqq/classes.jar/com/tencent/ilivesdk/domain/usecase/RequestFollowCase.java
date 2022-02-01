package com.tencent.ilivesdk.domain.usecase;

import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.login.LoginServiceInterface;
import com.tencent.falco.base.libapi.login.NoLoginObserver.NoLoginReason;
import com.tencent.ilive.enginemanager.BizEngineMgr;
import com.tencent.ilivesdk.domain.factory.LiveUseCase;
import com.tencent.ilivesdk.domain.model.AnchorUidInfo;
import com.tencent.ilivesdk.minicardservice_interface.MiniCardServiceInterface;
import com.tencent.ilivesdk.minicardservice_interface.model.CardServerUidInfo;
import com.tencent.ilivesdk.minicardservice_interface.model.FollowUserReqModel;
import com.tencent.ilivesdk.roomservice_interface.RoomServiceInterface;
import com.tencent.ilivesdk.roomservice_interface.model.LiveAnchorInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveInfo;
import com.tencent.livesdk.accountengine.UserEngine;
import com.tencent.livesdk.liveengine.LiveEngine;
import com.tencent.livesdk.roomengine.RoomEngine;

public class RequestFollowCase
  extends LiveUseCase<RequestFollowCase.ResponseValue, Object>
{
  private final String TAG = "RequestFollowCase";
  private AnchorUidInfo anchorUidInfo;
  private boolean mIsFollow = false;
  LoginServiceInterface mLoginService = (LoginServiceInterface)BizEngineMgr.getInstance().getUserEngine().getService(LoginServiceInterface.class);
  MiniCardServiceInterface mMiniCardService;
  RoomServiceInterface mRoomService;
  
  public RequestFollowCase()
  {
    this.mLogger = ((LogInterface)BizEngineMgr.getInstance().getLiveEngine().getService(LogInterface.class));
  }
  
  private AnchorUidInfo getAnchorUidInfo()
  {
    if ((this.mRoomService.getLiveInfo() != null) && (this.mRoomService.getLiveInfo().anchorInfo != null))
    {
      AnchorUidInfo localAnchorUidInfo = new AnchorUidInfo();
      localAnchorUidInfo.uid = this.mRoomService.getLiveInfo().anchorInfo.uid;
      localAnchorUidInfo.businessUid = this.mRoomService.getLiveInfo().anchorInfo.businessUid;
      localAnchorUidInfo.clientType = this.mRoomService.getLiveInfo().anchorInfo.initialClientType;
      return localAnchorUidInfo;
    }
    return null;
  }
  
  public void executeRoomUseCase(RoomEngine paramRoomEngine, Object paramObject)
  {
    this.mMiniCardService = ((MiniCardServiceInterface)paramRoomEngine.getService(MiniCardServiceInterface.class));
    this.mRoomService = ((RoomServiceInterface)paramRoomEngine.getService(RoomServiceInterface.class));
    if (this.mLoginService.isGuest())
    {
      this.mLoginService.notifyNoLogin(NoLoginObserver.NoLoginReason.GUEST);
      return;
    }
    performFollow();
  }
  
  public void performFollow()
  {
    boolean bool = true;
    this.anchorUidInfo = getAnchorUidInfo();
    if (this.anchorUidInfo == null)
    {
      post(new RequestFollowCase.ResponseValue(true, false));
      return;
    }
    if (!this.mIsFollow) {}
    for (;;)
    {
      performFollowUser(bool, this.anchorUidInfo);
      return;
      bool = false;
    }
  }
  
  void performFollowUser(boolean paramBoolean, AnchorUidInfo paramAnchorUidInfo)
  {
    FollowUserReqModel localFollowUserReqModel = new FollowUserReqModel();
    localFollowUserReqModel.isFollow = paramBoolean;
    localFollowUserReqModel.source = 20002;
    localFollowUserReqModel.isPush = 1L;
    localFollowUserReqModel.userUid = new CardServerUidInfo(paramAnchorUidInfo.uid, paramAnchorUidInfo.businessUid);
    localFollowUserReqModel.clientType = paramAnchorUidInfo.clientType;
    this.mMiniCardService.followUser(localFollowUserReqModel, new RequestFollowCase.1(this, paramAnchorUidInfo, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.domain.usecase.RequestFollowCase
 * JD-Core Version:    0.7.0.1
 */
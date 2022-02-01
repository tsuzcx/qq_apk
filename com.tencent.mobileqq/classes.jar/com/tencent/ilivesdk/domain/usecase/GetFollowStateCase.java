package com.tencent.ilivesdk.domain.usecase;

import com.tencent.falco.base.libapi.generalinfo.AppGeneralInfoService;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.login.LoginInfo;
import com.tencent.falco.base.libapi.login.LoginObserver;
import com.tencent.falco.base.libapi.login.LoginServiceInterface;
import com.tencent.ilive.enginemanager.BizEngineMgr;
import com.tencent.ilivesdk.domain.factory.LiveUseCase;
import com.tencent.ilivesdk.domain.model.AnchorUidInfo;
import com.tencent.ilivesdk.minicardservice_interface.MiniCardServiceInterface;
import com.tencent.ilivesdk.minicardservice_interface.OnUserInfoUpdateCallback;
import com.tencent.ilivesdk.minicardservice_interface.model.CardServerUidInfo;
import com.tencent.ilivesdk.minicardservice_interface.model.QueryFollowReqModel;
import com.tencent.ilivesdk.roomservice_interface.RoomServiceInterface;
import com.tencent.ilivesdk.roomservice_interface.model.LiveAnchorInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveInfo;
import com.tencent.livesdk.accountengine.UserEngine;
import com.tencent.livesdk.liveengine.LiveEngine;
import com.tencent.livesdk.roomengine.RoomEngine;

public class GetFollowStateCase
  extends LiveUseCase<Boolean, Object>
{
  private AnchorUidInfo anchorUidInfo;
  private LogInterface logInterface = (LogInterface)BizEngineMgr.getInstance().getLiveEngine().getService(LogInterface.class);
  LoginObserver loginObserver = new GetFollowStateCase.2(this);
  private AppGeneralInfoService mAppService = (AppGeneralInfoService)BizEngineMgr.getInstance().getLiveEngine().getService(AppGeneralInfoService.class);
  private LoginServiceInterface mLoginService = (LoginServiceInterface)BizEngineMgr.getInstance().getUserEngine().getService(LoginServiceInterface.class);
  private MiniCardServiceInterface mMiniCardService;
  private RoomServiceInterface mRoomService;
  private OnUserInfoUpdateCallback onUserInfoUpdateCallback = new GetFollowStateCase.1(this);
  private AnchorUidInfo selfUidInfo;
  
  private AnchorUidInfo getSelfUidInfo()
  {
    if ((this.mRoomService.getLiveInfo() != null) && (this.mRoomService.getLiveInfo().anchorInfo != null))
    {
      AnchorUidInfo localAnchorUidInfo = new AnchorUidInfo();
      localAnchorUidInfo.uid = this.mLoginService.getLoginInfo().uid;
      localAnchorUidInfo.businessUid = this.mLoginService.getLoginInfo().businessUid;
      localAnchorUidInfo.clientType = this.mAppService.getClientType();
      return localAnchorUidInfo;
    }
    return null;
  }
  
  protected void executeRoomUseCase(RoomEngine paramRoomEngine, Object paramObject)
  {
    this.mMiniCardService = ((MiniCardServiceInterface)paramRoomEngine.getService(MiniCardServiceInterface.class));
    this.mRoomService = ((RoomServiceInterface)paramRoomEngine.getService(RoomServiceInterface.class));
    this.anchorUidInfo = getAnchorUidInfo();
    this.selfUidInfo = getSelfUidInfo();
    paramRoomEngine = this.anchorUidInfo;
    if (paramRoomEngine != null)
    {
      paramObject = this.selfUidInfo;
      if (paramObject != null) {
        queryFollowStatus(paramRoomEngine, paramObject);
      }
    }
    this.mLoginService.addRoomReLoginObserver(this.loginObserver);
    this.mMiniCardService.addUserInfoUpdateListener(this.onUserInfoUpdateCallback);
  }
  
  public AnchorUidInfo getAnchorUidInfo()
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
  
  public void onDestroy()
  {
    super.onDestroy();
    this.mLoginService.removeRoomReLoginObserver(this.loginObserver);
  }
  
  public void queryFollowStatus(AnchorUidInfo paramAnchorUidInfo1, AnchorUidInfo paramAnchorUidInfo2)
  {
    QueryFollowReqModel localQueryFollowReqModel = new QueryFollowReqModel();
    localQueryFollowReqModel.targetUin = new CardServerUidInfo(paramAnchorUidInfo1.uid, paramAnchorUidInfo1.businessUid);
    localQueryFollowReqModel.myUin = new CardServerUidInfo(paramAnchorUidInfo2.uid, paramAnchorUidInfo2.businessUid);
    this.mMiniCardService.queryFollowStatus(localQueryFollowReqModel, new GetFollowStateCase.3(this, paramAnchorUidInfo1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.domain.usecase.GetFollowStateCase
 * JD-Core Version:    0.7.0.1
 */
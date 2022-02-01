package com.tencent.ilive.audiencepages.room.pagelogic;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.falco.utils.PreloadUtil;
import com.tencent.ilive.audiencepages.room.AudienceRoomFragment;
import com.tencent.ilive.audiencepages.room.pagelogic.controller.AudienceRoomController;
import com.tencent.ilive.audiencepages.room.pagelogic.controller.ScreenSwitchController;
import com.tencent.ilive.enginemanager.BizEngineMgr;
import com.tencent.ilive.interfaces.IAudienceRoomPager;
import com.tencent.ilive.interfaces.RoomPageActionInterface;
import com.tencent.ilive.pages.room.RoomBootBizModules;
import com.tencent.ilivesdk.avpreloadservice_interface.AVPreloadServiceInterface;
import com.tencent.ilivesdk.qualityreportservice_interface.AudQualityServiceInterface;
import com.tencent.ilivesdk.qualityreportservice_interface.QualityReportServiceInterface;
import com.tencent.ilivesdk.roomswitchservice_interface.SwitchRoomInfo;
import com.tencent.ilivesdk.roomswitchservice_interface.VideoType;
import com.tencent.livesdk.accountengine.UserEngine;
import com.tencent.livesdk.liveengine.LiveEngine;
import com.tencent.livesdk.roomengine.RoomEngine;

public class AudienceMultiRoomPageLogic
{
  protected AudQualityServiceInterface audQualityService;
  private AudienceRoomController audRoomController;
  Activity mActivity;
  Context mContext;
  private IAudienceRoomPager mIAudienceRoomPager;
  private RoomPageActionInterface mRoomPageActionInterface;
  private ScreenSwitchController screenSwitchController;
  
  public AudienceMultiRoomPageLogic(Context paramContext, IAudienceRoomPager paramIAudienceRoomPager, RoomPageActionInterface paramRoomPageActionInterface)
  {
    this.mContext = paramContext;
    this.mActivity = ((Activity)paramContext);
    this.mIAudienceRoomPager = paramIAudienceRoomPager;
    this.mRoomPageActionInterface = paramRoomPageActionInterface;
    this.audQualityService = ((QualityReportServiceInterface)BizEngineMgr.getInstance().getLiveEngine().getService(QualityReportServiceInterface.class)).getAudQualityReporter();
    this.screenSwitchController = new ScreenSwitchController();
    this.screenSwitchController.setAudienceRoomPager(this.mIAudienceRoomPager);
    this.audRoomController = new AudienceRoomController(this.mIAudienceRoomPager.getIntent(), this.mRoomPageActionInterface);
    this.audRoomController.setAudienceRoomPager(this.mIAudienceRoomPager);
    this.audRoomController.setRoomCtrlCallback(new AudienceMultiRoomPageLogic.1(this));
    this.audQualityService.setEnterRoomCode(hashCode());
  }
  
  public void exitRoom()
  {
    this.audRoomController.exitRoomToServer();
    this.audRoomController.switchRoom();
  }
  
  public void initAction()
  {
    this.audRoomController.onInitAction();
    this.screenSwitchController.onInitAction();
  }
  
  public void onBackPressed()
  {
    this.audRoomController.onBackPressed();
  }
  
  public void onCreate()
  {
    this.audRoomController.onCreate(this.mContext);
    this.screenSwitchController.onCreate(this.mContext);
  }
  
  public void onDestroy()
  {
    AudienceRoomController localAudienceRoomController = this.audRoomController;
    if (localAudienceRoomController != null) {
      localAudienceRoomController.onDestroy();
    }
    this.mRoomPageActionInterface = null;
  }
  
  public void onLandscape(boolean paramBoolean)
  {
    this.audRoomController.onLandscape(paramBoolean);
    this.screenSwitchController.onLandscape(paramBoolean);
  }
  
  public void onPause() {}
  
  public void onResume() {}
  
  public void onStart() {}
  
  public void onStop() {}
  
  public void onSwitchFragment()
  {
    this.audRoomController.onSwitchFragment();
    this.screenSwitchController.onSwitchFragment();
  }
  
  public void onSwitchRoomAfter(SwitchRoomInfo paramSwitchRoomInfo)
  {
    this.audRoomController.onSwitchRoom(paramSwitchRoomInfo);
  }
  
  public void onSwitchRoomBefore(SwitchRoomInfo paramSwitchRoomInfo, AudienceRoomFragment paramAudienceRoomFragment)
  {
    String str = paramSwitchRoomInfo.videoUrl;
    VideoType localVideoType1 = paramSwitchRoomInfo.videoType;
    VideoType localVideoType2 = VideoType.LIVE;
    boolean bool = false;
    int i;
    if (localVideoType1 == localVideoType2) {
      i = 0;
    } else {
      i = 1;
    }
    if (PreloadUtil.a(str, i)) {
      bool = ((AVPreloadServiceInterface)BizEngineMgr.getInstance().getUserEngine().getService(AVPreloadServiceInterface.class)).b(paramSwitchRoomInfo.videoUrl);
    }
    this.audQualityService.reportSwitchRoom(paramSwitchRoomInfo.roomId, true ^ TextUtils.isEmpty(paramSwitchRoomInfo.videoUrl), bool);
    paramAudienceRoomFragment = (RoomBootBizModules)paramAudienceRoomFragment.getBootBizModules();
    if (paramAudienceRoomFragment != null) {
      paramAudienceRoomFragment.onSwitchRoom(paramSwitchRoomInfo);
    }
  }
  
  public void setRoomEngine(RoomEngine paramRoomEngine)
  {
    this.audRoomController.setRoomEngine(paramRoomEngine);
    this.screenSwitchController.setRoomEngine(paramRoomEngine);
  }
  
  public void showSwitchCovel() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.pagelogic.AudienceMultiRoomPageLogic
 * JD-Core Version:    0.7.0.1
 */
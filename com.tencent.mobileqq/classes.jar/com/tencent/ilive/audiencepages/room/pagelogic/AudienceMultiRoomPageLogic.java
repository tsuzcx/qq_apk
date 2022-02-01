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
    if (this.audRoomController != null) {
      this.audRoomController.onDestroy();
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
    boolean bool2 = true;
    Object localObject = paramSwitchRoomInfo.videoUrl;
    int i;
    if (paramSwitchRoomInfo.videoType == VideoType.LIVE)
    {
      i = 0;
      if (!PreloadUtil.a((String)localObject, i)) {
        break label134;
      }
    }
    label134:
    for (boolean bool1 = ((AVPreloadServiceInterface)BizEngineMgr.getInstance().getUserEngine().getService(AVPreloadServiceInterface.class)).b(paramSwitchRoomInfo.videoUrl);; bool1 = false)
    {
      localObject = this.audQualityService;
      long l = paramSwitchRoomInfo.roomId;
      if (!TextUtils.isEmpty(paramSwitchRoomInfo.videoUrl)) {}
      for (;;)
      {
        ((AudQualityServiceInterface)localObject).reportSwitchRoom(l, bool2, bool1);
        paramAudienceRoomFragment = (RoomBootBizModules)paramAudienceRoomFragment.getBootBizModules();
        if (paramAudienceRoomFragment != null) {
          paramAudienceRoomFragment.onSwitchRoom(paramSwitchRoomInfo);
        }
        this.audRoomController.exitRoomToServer();
        this.audRoomController.exitRoomToPage(false);
        return;
        i = 1;
        break;
        bool2 = false;
      }
    }
  }
  
  public void setRoomEngine(RoomEngine paramRoomEngine)
  {
    this.audRoomController.setRoomEngine(paramRoomEngine);
    this.screenSwitchController.setRoomEngine(paramRoomEngine);
  }
  
  public void showSwitchCovel() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.pagelogic.AudienceMultiRoomPageLogic
 * JD-Core Version:    0.7.0.1
 */
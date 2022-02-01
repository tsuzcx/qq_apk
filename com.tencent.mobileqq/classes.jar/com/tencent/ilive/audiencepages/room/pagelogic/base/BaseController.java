package com.tencent.ilive.audiencepages.room.pagelogic.base;

import android.content.Context;
import android.content.res.Resources;
import androidx.fragment.app.FragmentActivity;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilive.base.bizmodule.BootBizModules;
import com.tencent.ilive.base.event.ModuleEvent;
import com.tencent.ilive.base.page.fragment.LiveTemplateFragment;
import com.tencent.ilive.dialog.CustomizedDialog;
import com.tencent.ilive.dialog.DialogUtil;
import com.tencent.ilive.enginemanager.BizEngineMgr;
import com.tencent.ilive.interfaces.IAudienceRoomPager;
import com.tencent.ilive.interfaces.RoomPageActionInterface;
import com.tencent.ilivesdk.qualityreportservice_interface.AudQualityServiceInterface;
import com.tencent.ilivesdk.qualityreportservice_interface.QualityReportServiceInterface;
import com.tencent.livesdk.liveengine.LiveEngine;
import com.tencent.livesdk.roomengine.RoomEngine;

public abstract class BaseController
{
  public AudQualityServiceInterface audQualityService;
  public BootBizModules bootBizModules;
  protected boolean landscape;
  protected LogInterface logInterface;
  protected FragmentActivity mActivity;
  private IAudienceRoomPager mAudienceRoomPager;
  protected Context mContext;
  private RoomEngine mRoomEngine;
  protected ModuleEvent moduleEvent;
  
  public IAudienceRoomPager getAudienceRoomPager()
  {
    return this.mAudienceRoomPager;
  }
  
  public ModuleEvent getEvent()
  {
    return this.moduleEvent;
  }
  
  public LogInterface getLog()
  {
    return this.logInterface;
  }
  
  public RoomEngine getRoomEngine()
  {
    return this.mRoomEngine;
  }
  
  public void init()
  {
    this.logInterface = ((LogInterface)BizEngineMgr.getInstance().getLiveEngine().getService(LogInterface.class));
    this.audQualityService = ((QualityReportServiceInterface)BizEngineMgr.getInstance().getLiveEngine().getService(QualityReportServiceInterface.class)).getAudQualityReporter();
  }
  
  public void onCreate(Context paramContext)
  {
    this.mContext = paramContext;
    this.mActivity = ((FragmentActivity)paramContext);
    this.bootBizModules = this.mAudienceRoomPager.getCurrentFragment().getBootBizModules();
    this.moduleEvent = this.bootBizModules.getModuleEvent();
    init();
  }
  
  public abstract void onDestroy();
  
  public abstract void onInitAction();
  
  public void onLandscape(boolean paramBoolean)
  {
    this.landscape = paramBoolean;
  }
  
  public void onPause() {}
  
  public void onRestart() {}
  
  public void onResume() {}
  
  public void onStart() {}
  
  public void onStop() {}
  
  public void onSwitchFragment()
  {
    this.bootBizModules = this.mAudienceRoomPager.getCurrentFragment().getBootBizModules();
    if (this.bootBizModules != null) {
      this.moduleEvent = this.bootBizModules.getModuleEvent();
    }
  }
  
  public void setAudienceRoomPager(IAudienceRoomPager paramIAudienceRoomPager)
  {
    this.mAudienceRoomPager = paramIAudienceRoomPager;
  }
  
  public void setRoomEngine(RoomEngine paramRoomEngine)
  {
    this.mRoomEngine = paramRoomEngine;
  }
  
  public void showErrExitDialog(String paramString, RoomPageActionInterface paramRoomPageActionInterface)
  {
    if (this.mContext == null) {
      return;
    }
    try
    {
      FragmentActivity localFragmentActivity = (FragmentActivity)this.mContext;
      DialogUtil.createOneBtnDialog(localFragmentActivity, null, paramString, localFragmentActivity.getString(2131694616), new BaseController.1(this, paramRoomPageActionInterface)).setRightBtnColor(localFragmentActivity.getResources().getColor(2131165307)).show(localFragmentActivity.getSupportFragmentManager(), "");
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.pagelogic.base.BaseController
 * JD-Core Version:    0.7.0.1
 */
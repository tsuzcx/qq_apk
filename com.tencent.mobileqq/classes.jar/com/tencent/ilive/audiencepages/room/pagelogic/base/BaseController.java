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
  protected AudQualityServiceInterface audQualityService;
  protected BootBizModules bootBizModules;
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
    if (this.mAudienceRoomPager.getCurrentFragment() != null) {
      this.bootBizModules = this.mAudienceRoomPager.getCurrentFragment().getBootBizModules();
    }
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
    if (this.mAudienceRoomPager.getCurrentFragment() != null) {
      this.bootBizModules = this.mAudienceRoomPager.getCurrentFragment().getBootBizModules();
    } else {
      this.bootBizModules = null;
    }
    BootBizModules localBootBizModules = this.bootBizModules;
    if (localBootBizModules != null) {
      this.moduleEvent = localBootBizModules.getModuleEvent();
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
  
  protected void showErrExitDialog(String paramString, RoomPageActionInterface paramRoomPageActionInterface)
  {
    Object localObject = this.mContext;
    if (localObject == null) {
      return;
    }
    try
    {
      localObject = (FragmentActivity)localObject;
      DialogUtil.createOneBtnDialog((Context)localObject, null, paramString, ((FragmentActivity)localObject).getString(2131892268), new BaseController.1(this, paramRoomPageActionInterface)).setRightBtnColor(((FragmentActivity)localObject).getResources().getColor(2131165499)).show(((FragmentActivity)localObject).getSupportFragmentManager(), "");
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.pagelogic.base.BaseController
 * JD-Core Version:    0.7.0.1
 */
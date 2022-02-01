package com.tencent.ilive.pages.room.bizmodule;

import android.content.Context;
import android.content.res.Resources;
import androidx.fragment.app.FragmentActivity;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilive.base.bizmodule.BaseBizModule;
import com.tencent.ilive.base.bizmodule.BizModuleContext;
import com.tencent.ilive.commonpages.room.VerticalViewPager;
import com.tencent.ilive.dialog.CustomizedDialog;
import com.tencent.ilive.dialog.DialogUtil;
import com.tencent.ilive.interfaces.IAudienceRoomPager;
import com.tencent.ilive.pages.room.RoomBizContext;
import com.tencent.ilivesdk.roomservice_interface.model.EnterRoomInfo;
import com.tencent.ilivesdk.roomswitchservice_interface.SwitchRoomInfo;
import com.tencent.livesdk.roomengine.RoomEngine;

public class RoomBizModule
  extends BaseBizModule
{
  private static final String TAG = "RoomBizModule";
  private IAudienceRoomPager mAudienceRoomPager;
  private RoomEngine mRoomEngine;
  public RoomBizContext roomBizContext;
  
  public boolean getAcceptReEnterRoom()
  {
    return false;
  }
  
  public IAudienceRoomPager getAudienceRoomPager()
  {
    return this.mAudienceRoomPager;
  }
  
  protected RoomBizModule.InflateComponentTime getInflateTime()
  {
    return RoomBizModule.InflateComponentTime.ONCREATE_INFLATE;
  }
  
  public RoomBizContext getRoomBizContext()
  {
    return this.roomBizContext;
  }
  
  public RoomEngine getRoomEngine()
  {
    return this.mRoomEngine;
  }
  
  public void onCreate(Context paramContext)
  {
    super.onCreate(paramContext);
    if (getInflateTime() == RoomBizModule.InflateComponentTime.ONCREATE_INFLATE)
    {
      onInflateComponent();
      onInitComponentEvent();
    }
    onCreateCases();
    if (getAudienceRoomPager() != null)
    {
      int i = this.roomBizContext.getEnterRoomInfo().bootModulesIndex;
      int j = getAudienceRoomPager().getViewPager().getCurrentItem();
      getLog().i("RoomBizModule", "onCreate--selfRoomIndex=" + i + ";pagerCurrentIndex=" + j, new Object[0]);
      if (i == j)
      {
        this.isUserVisibleHint = true;
        onVisibleToUser(true);
      }
    }
  }
  
  public void onCreateCases() {}
  
  public void onEnterRoom(boolean paramBoolean)
  {
    if (getInflateTime() == RoomBizModule.InflateComponentTime.ENTERROOM_INFLATE)
    {
      onInflateComponent();
      onInitComponentEvent();
    }
  }
  
  @Deprecated
  public void onExitRoom(boolean paramBoolean) {}
  
  public void onFirstFrame() {}
  
  public void onInflateComponent() {}
  
  public void onInitComponentEvent() {}
  
  public void onPlayOver() {}
  
  public void onSwitchRoom(SwitchRoomInfo paramSwitchRoomInfo) {}
  
  public void onSwitchScreen(boolean paramBoolean) {}
  
  public void setAudienceRoomPager(IAudienceRoomPager paramIAudienceRoomPager)
  {
    this.mAudienceRoomPager = paramIAudienceRoomPager;
  }
  
  public <T extends BizModuleContext> void setBizLogicContext(T paramT)
  {
    this.roomBizContext = ((RoomBizContext)paramT);
  }
  
  public void setRoomEngine(RoomEngine paramRoomEngine)
  {
    this.mRoomEngine = paramRoomEngine;
  }
  
  public void showErrExitDialog(String paramString)
  {
    if (this.context == null) {
      return;
    }
    try
    {
      FragmentActivity localFragmentActivity = (FragmentActivity)this.context;
      DialogUtil.createOneBtnDialog(localFragmentActivity, null, paramString, localFragmentActivity.getString(2131693845), new RoomBizModule.1(this, localFragmentActivity)).setRightBtnColor(localFragmentActivity.getResources().getColor(2131165307)).show(localFragmentActivity.getSupportFragmentManager(), "");
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.pages.room.bizmodule.RoomBizModule
 * JD-Core Version:    0.7.0.1
 */
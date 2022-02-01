package com.tencent.ilive.audiencepages.room.pagelogic.controller;

import android.content.Context;
import android.view.View;
import com.tencent.ilive.audiencepages.room.pagelogic.base.BaseController;
import com.tencent.ilive.audiencepages.room.roomconfig.AudienceBaseBootModules;
import com.tencent.ilive.base.bizmodule.BootBizModules;
import com.tencent.livesdk.roomengine.RoomEngine;
import java.util.List;

public class ScreenSwitchController
  extends BaseController
{
  private View landLayout;
  private View portraitLayout;
  
  private void initView()
  {
    if (this.bootBizModules == null) {
      return;
    }
    View localView = (View)this.bootBizModules.getUiLayoutList().get(3);
    if (localView != null)
    {
      AudienceBaseBootModules localAudienceBaseBootModules = (AudienceBaseBootModules)this.bootBizModules;
      if (localAudienceBaseBootModules.getLandscapeViewId() != 0) {
        this.portraitLayout = localView.findViewById(localAudienceBaseBootModules.getPortraitViewId());
      }
      if (localAudienceBaseBootModules.getLandscapeViewId() != 0) {
        this.landLayout = localView.findViewById(localAudienceBaseBootModules.getLandscapeViewId());
      }
    }
  }
  
  public void onCreate(Context paramContext)
  {
    super.onCreate(paramContext);
    initView();
  }
  
  public void onDestroy() {}
  
  public void onInitAction() {}
  
  public void onLandscape(boolean paramBoolean)
  {
    super.onLandscape(paramBoolean);
    View localView = this.portraitLayout;
    int j = 8;
    int i;
    if (localView != null)
    {
      if (paramBoolean) {
        i = 8;
      } else {
        i = 0;
      }
      localView.setVisibility(i);
    }
    localView = this.landLayout;
    if (localView != null)
    {
      i = j;
      if (paramBoolean) {
        i = 0;
      }
      localView.setVisibility(i);
    }
  }
  
  public void onSwitchFragment()
  {
    super.onSwitchFragment();
    initView();
  }
  
  public void onWitchScreenClear()
  {
    getRoomEngine().clearEventOutput();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.pagelogic.controller.ScreenSwitchController
 * JD-Core Version:    0.7.0.1
 */
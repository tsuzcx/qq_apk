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
    int j = 0;
    super.onLandscape(paramBoolean);
    View localView;
    if (this.portraitLayout != null)
    {
      localView = this.portraitLayout;
      if (paramBoolean)
      {
        i = 8;
        localView.setVisibility(i);
      }
    }
    else if (this.landLayout != null)
    {
      localView = this.landLayout;
      if (!paramBoolean) {
        break label64;
      }
    }
    label64:
    for (int i = j;; i = 8)
    {
      localView.setVisibility(i);
      return;
      i = 0;
      break;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.pagelogic.controller.ScreenSwitchController
 * JD-Core Version:    0.7.0.1
 */
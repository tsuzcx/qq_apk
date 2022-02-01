package com.tencent.ilive.audiencepages.room.bizmodule;

import android.app.Activity;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.falco.base.libapi.floatwindow.FloatWindowConfigServiceInterface;
import com.tencent.falco.base.libapi.floatwindow.FloatWindowPermissionInterface;
import com.tencent.falco.base.libapi.hostproxy.HostProxyInterface;
import com.tencent.falco.base.libapi.hostproxy.SdkInfoInterface;
import com.tencent.ilive.enginemanager.BizEngineMgr;
import com.tencent.ilive.uicomponent.floatwindowcomponent_interface.FloatWindowComponent;
import com.tencent.livesdk.liveengine.FloatRoomManager;
import com.tencent.livesdk.liveengine.FloatRoomManager.RoomEventInterceptor;
import com.tencent.livesdk.liveengine.LiveEngine;

class FloatWindowModule$13
  implements FloatRoomManager.RoomEventInterceptor
{
  FloatWindowModule$13(FloatWindowModule paramFloatWindowModule) {}
  
  public int a()
  {
    if (!FloatWindowModule.access$3600(this.a))
    {
      FloatWindowModule.access$3702(this.a, true);
      return -1;
    }
    LiveEngine localLiveEngine = BizEngineMgr.getInstance().getLiveEngine();
    Object localObject = ((HostProxyInterface)localLiveEngine.getService(HostProxyInterface.class)).getSdkInfoInterface();
    if (localObject == null)
    {
      FloatWindowModule.access$3702(this.a, true);
      return -1;
    }
    if (!((SdkInfoInterface)localObject).isFloatWindowShowWhenRoomFinish())
    {
      FloatWindowModule.access$3702(this.a, true);
      return -1;
    }
    localObject = (FloatWindowPermissionInterface)localLiveEngine.getService(FloatWindowPermissionInterface.class);
    if (((FloatWindowPermissionInterface)localObject).hasFWPermission())
    {
      ((FloatWindowConfigServiceInterface)localLiveEngine.getService(FloatWindowConfigServiceInterface.class)).setFloatWindowEnabledOnce(true);
      return 1;
    }
    ((FloatWindowPermissionInterface)localObject).requestFWPermission((Activity)FloatWindowModule.access$3800(this.a), new FloatWindowModule.13.1(this));
    FloatWindowModule.access$3902(this.a, true);
    return 0;
  }
  
  public void a(FloatRoomManager paramFloatRoomManager)
  {
    if ((this.a.floatWindowComponent != null) && (this.a.floatWindowComponent.isReallyShow()) && (paramFloatRoomManager != null)) {
      paramFloatRoomManager.c();
    }
  }
  
  public boolean b()
  {
    if (this.a.floatWindowComponent != null) {
      return this.a.floatWindowComponent.isCalledShow();
    }
    return false;
  }
  
  public LifecycleOwner c()
  {
    return FloatWindowModule.access$4000(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.bizmodule.FloatWindowModule.13
 * JD-Core Version:    0.7.0.1
 */
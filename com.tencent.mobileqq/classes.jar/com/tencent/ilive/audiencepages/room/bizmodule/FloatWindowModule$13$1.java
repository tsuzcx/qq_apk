package com.tencent.ilive.audiencepages.room.bizmodule;

import com.tencent.falco.base.libapi.floatwindow.FloatWindowPermissionInterface.OnRequestResult;
import com.tencent.ilive.enginemanager.BizEngineMgr;
import com.tencent.livesdk.liveengine.FloatRoomManager;
import com.tencent.livesdk.liveengine.LiveEngine;

class FloatWindowModule$13$1
  implements FloatWindowPermissionInterface.OnRequestResult
{
  FloatWindowModule$13$1(FloatWindowModule.13 param13) {}
  
  public void onCancel()
  {
    BizEngineMgr.getInstance().getLiveEngine().getFloatRoomManager().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.bizmodule.FloatWindowModule.13.1
 * JD-Core Version:    0.7.0.1
 */
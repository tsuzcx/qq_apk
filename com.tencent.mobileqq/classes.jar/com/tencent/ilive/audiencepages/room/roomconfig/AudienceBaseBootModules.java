package com.tencent.ilive.audiencepages.room.roomconfig;

import androidx.annotation.IdRes;
import com.tencent.ilive.pages.room.RoomBizContext;
import com.tencent.ilive.pages.room.RoomBootBizModules;
import com.tencent.ilive.pages.room.bizmodule.RoomBizModule;

public abstract class AudienceBaseBootModules
  extends RoomBootBizModules
{
  protected void addNormalLayoutBizModules(RoomBizModule paramRoomBizModule, boolean paramBoolean)
  {
    if ((super.addNormalLayoutBizModules(paramRoomBizModule)) && (paramBoolean) && (paramRoomBizModule.getRoomBizContext().mLiveInfo != null)) {
      paramRoomBizModule.onEnterRoom(false);
    }
    paramRoomBizModule.setOrientation(paramBoolean);
  }
  
  @IdRes
  public abstract int getLandscapeViewId();
  
  @IdRes
  public abstract int getPortraitViewId();
  
  public void onCreateNormalBizModules(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.roomconfig.AudienceBaseBootModules
 * JD-Core Version:    0.7.0.1
 */
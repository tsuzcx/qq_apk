package com.tencent.ilive.pages.room;

import com.tencent.ilive.base.bizmodule.BizModuleContext;
import com.tencent.ilive.pages.room.datamodel.RoomState;
import com.tencent.ilivesdk.roomservice_interface.model.EnterRoomInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveAnchorInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveMediaInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveRoomInfo;

public class RoomBizContext
  implements BizModuleContext
{
  private EnterRoomInfo enterRoomInfo;
  public LiveInfo mLiveInfo;
  private RoomState mRoomState = new RoomState();
  
  public boolean checkLiveInfoComplete()
  {
    LiveInfo localLiveInfo = this.mLiveInfo;
    return (localLiveInfo != null) && (localLiveInfo.roomInfo != null) && (this.mLiveInfo.anchorInfo != null) && (this.mLiveInfo.mediaInfo != null);
  }
  
  public LiveAnchorInfo getAnchorInfo()
  {
    LiveInfo localLiveInfo = this.mLiveInfo;
    if (localLiveInfo == null) {
      return null;
    }
    return localLiveInfo.anchorInfo;
  }
  
  public EnterRoomInfo getEnterRoomInfo()
  {
    return this.enterRoomInfo;
  }
  
  public LiveMediaInfo getMediaInfo()
  {
    LiveInfo localLiveInfo = this.mLiveInfo;
    if (localLiveInfo == null) {
      return null;
    }
    return localLiveInfo.mediaInfo;
  }
  
  public LiveRoomInfo getRoomInfo()
  {
    LiveInfo localLiveInfo = this.mLiveInfo;
    if (localLiveInfo == null) {
      return null;
    }
    return localLiveInfo.roomInfo;
  }
  
  public RoomState getRoomState()
  {
    return this.mRoomState;
  }
  
  public void setEnterRoomInfo(EnterRoomInfo paramEnterRoomInfo)
  {
    this.enterRoomInfo = paramEnterRoomInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.pages.room.RoomBizContext
 * JD-Core Version:    0.7.0.1
 */
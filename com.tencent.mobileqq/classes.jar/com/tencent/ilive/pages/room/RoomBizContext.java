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
    return (this.mLiveInfo != null) && (this.mLiveInfo.roomInfo != null) && (this.mLiveInfo.anchorInfo != null) && (this.mLiveInfo.mediaInfo != null);
  }
  
  public LiveAnchorInfo getAnchorInfo()
  {
    if (this.mLiveInfo == null) {
      return null;
    }
    return this.mLiveInfo.anchorInfo;
  }
  
  public EnterRoomInfo getEnterRoomInfo()
  {
    return this.enterRoomInfo;
  }
  
  public LiveMediaInfo getMediaInfo()
  {
    if (this.mLiveInfo == null) {
      return null;
    }
    return this.mLiveInfo.mediaInfo;
  }
  
  public LiveRoomInfo getRoomInfo()
  {
    if (this.mLiveInfo == null) {
      return null;
    }
    return this.mLiveInfo.roomInfo;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.pages.room.RoomBizContext
 * JD-Core Version:    0.7.0.1
 */
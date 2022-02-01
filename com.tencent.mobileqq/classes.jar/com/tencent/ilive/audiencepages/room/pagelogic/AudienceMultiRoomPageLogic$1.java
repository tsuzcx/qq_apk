package com.tencent.ilive.audiencepages.room.pagelogic;

import com.tencent.ilive.audiencepages.room.pagelogic.controller.AudienceRoomController.RoomCtrlCallback;
import com.tencent.ilivesdk.qualityreportservice_interface.AudQualityServiceInterface;

class AudienceMultiRoomPageLogic$1
  implements AudienceRoomController.RoomCtrlCallback
{
  AudienceMultiRoomPageLogic$1(AudienceMultiRoomPageLogic paramAudienceMultiRoomPageLogic) {}
  
  public void onEnterRoom(boolean paramBoolean) {}
  
  public void onEnterRoomOver(boolean paramBoolean) {}
  
  public void onExitPage()
  {
    this.this$0.audQualityService.reportExitRoom(this.this$0.hashCode());
  }
  
  public void onPlayOver() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.pagelogic.AudienceMultiRoomPageLogic.1
 * JD-Core Version:    0.7.0.1
 */
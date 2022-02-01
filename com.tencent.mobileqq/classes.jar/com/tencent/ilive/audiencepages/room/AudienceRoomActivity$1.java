package com.tencent.ilive.audiencepages.room;

import com.tencent.falco.base.libapi.hostproxy.SdkEventInterface;
import com.tencent.ilive.interfaces.RoomPageActionInterface;
import com.tencent.ilivesdk.roomswitchservice_interface.SwitchRoomInfo;

class AudienceRoomActivity$1
  implements RoomPageActionInterface
{
  AudienceRoomActivity$1(AudienceRoomActivity paramAudienceRoomActivity) {}
  
  public void finish()
  {
    this.this$0.finish();
    if (AudienceRoomActivity.access$000(this.this$0) != null) {
      AudienceRoomActivity.access$000(this.this$0).overridePendingTransition(this.this$0);
    }
  }
  
  public boolean onFloatWindowClick(Runnable paramRunnable, SwitchRoomInfo paramSwitchRoomInfo)
  {
    return this.this$0.onFloatWindowClicked(paramRunnable, paramSwitchRoomInfo);
  }
  
  public void onScrollTopOrBottom(int paramInt) {}
  
  public void setRequestedOrientation(boolean paramBoolean)
  {
    this.this$0.setRequestedOrientation(paramBoolean ^ true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.AudienceRoomActivity.1
 * JD-Core Version:    0.7.0.1
 */
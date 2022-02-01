package com.tencent.ilive.audiencepages.room;

import com.tencent.falco.base.libapi.hostproxy.SdkEventInterface;
import com.tencent.ilive.interfaces.RoomPageActionInterface;

class AudienceRoomActivity$1
  implements RoomPageActionInterface
{
  AudienceRoomActivity$1(AudienceRoomActivity paramAudienceRoomActivity) {}
  
  public void finish()
  {
    this.this$0.finish();
    AudienceRoomActivity.access$000(this.this$0).overridePendingTransition(this.this$0);
  }
  
  public void onFloatWindowClick() {}
  
  public void onScrollTopOrBottom(int paramInt) {}
  
  public void setRequestedOrientation(boolean paramBoolean)
  {
    AudienceRoomActivity localAudienceRoomActivity = this.this$0;
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      localAudienceRoomActivity.setRequestedOrientation(i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.AudienceRoomActivity.1
 * JD-Core Version:    0.7.0.1
 */
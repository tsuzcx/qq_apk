package com.tencent.ilive.audiencepages.room;

import com.tencent.falco.base.libapi.log.LogInterface;

class AudienceRoomViewPager$1
  implements Runnable
{
  AudienceRoomViewPager$1(AudienceRoomViewPager paramAudienceRoomViewPager) {}
  
  public void run()
  {
    if (AudienceRoomViewPager.access$000(this.this$0) != null) {
      AudienceRoomViewPager.access$000(this.this$0).i("AudienceTime", "activity--queryRoomListRunnable --start query switch list", new Object[0]);
    }
    AudienceRoomViewPager.access$100(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.AudienceRoomViewPager.1
 * JD-Core Version:    0.7.0.1
 */
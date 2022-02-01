package com.tencent.ilive.audiencepages.room;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.utils.ThreadCenter;
import com.tencent.ilive.pages.room.events.FirstFrameEvent;

class AudienceRoomViewPager$4
  implements Observer<FirstFrameEvent>
{
  AudienceRoomViewPager$4(AudienceRoomViewPager paramAudienceRoomViewPager) {}
  
  public void onChanged(@Nullable FirstFrameEvent paramFirstFrameEvent)
  {
    if (AudienceRoomViewPager.access$000(this.this$0) != null) {
      AudienceRoomViewPager.access$000(this.this$0).i("AudienceTime", "activity--the first firstframe come --start query switch list", new Object[0]);
    }
    ThreadCenter.removeDefaultUITask(this.this$0.queryRoomListRunnable);
    AudienceRoomViewPager.access$100(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.AudienceRoomViewPager.4
 * JD-Core Version:    0.7.0.1
 */
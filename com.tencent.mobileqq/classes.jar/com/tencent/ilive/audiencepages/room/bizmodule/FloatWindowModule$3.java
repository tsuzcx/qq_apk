package com.tencent.ilive.audiencepages.room.bizmodule;

import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.toast.ToastInterface;
import com.tencent.livesdk.roomengine.RoomEngine;

class FloatWindowModule$3
  implements Runnable
{
  FloatWindowModule$3(FloatWindowModule paramFloatWindowModule) {}
  
  public void run()
  {
    if (FloatWindowModule.access$500(this.this$0))
    {
      this.this$0.getLog().e("FloatWindowModule", "start AudienceRoomActivity timeout", new Object[0]);
      ((ToastInterface)this.this$0.getRoomEngine().getService(ToastInterface.class)).showToast("正在返回直播间，请耐心等待", 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.bizmodule.FloatWindowModule.3
 * JD-Core Version:    0.7.0.1
 */
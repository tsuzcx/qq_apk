package com.tencent.ilive.audiencepages.room.bizmodule;

import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.toast.ToastInterface;
import com.tencent.livesdk.roomengine.RoomEngine;

class FloatWindowModule$2
  implements Runnable
{
  FloatWindowModule$2(FloatWindowModule paramFloatWindowModule) {}
  
  public void run()
  {
    if (FloatWindowModule.access$400(this.this$0))
    {
      this.this$0.getLog().e("FloatWindowModule", "start AudienceRoomActivity timeout", new Object[0]);
      ((ToastInterface)this.this$0.getRoomEngine().getService(ToastInterface.class)).showToast("后台弹出界面权限关闭，无法返回直播间", 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.bizmodule.FloatWindowModule.2
 * JD-Core Version:    0.7.0.1
 */
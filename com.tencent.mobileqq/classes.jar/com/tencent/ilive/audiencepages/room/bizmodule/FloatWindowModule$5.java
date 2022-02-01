package com.tencent.ilive.audiencepages.room.bizmodule;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.toast.ToastInterface;
import com.tencent.ilive.audiencepages.room.events.KickedOutEvent;
import com.tencent.ilive.base.event.ModuleEvent;
import com.tencent.ilive.pages.room.events.RoomCloseEvent;
import com.tencent.ilive.uicomponent.floatwindowcomponent_interface.FloatWindowComponent;
import com.tencent.livesdk.roomengine.RoomEngine;

class FloatWindowModule$5
  implements Observer<KickedOutEvent>
{
  FloatWindowModule$5(FloatWindowModule paramFloatWindowModule) {}
  
  public void onChanged(@Nullable KickedOutEvent paramKickedOutEvent)
  {
    if ((this.this$0.floatWindowComponent != null) && (this.this$0.floatWindowComponent.isReallyShow()))
    {
      this.this$0.getLog().i("FloatWindowModule", "onKickedOut", new Object[0]);
      ((ToastInterface)this.this$0.getRoomEngine().getService(ToastInterface.class)).showToast("你已被管理员踢出房间", 1);
      this.this$0.floatWindowComponent.dismiss(5);
      FloatWindowModule.access$800(this.this$0, FloatWindowModule.FWCloseType.TYPE_KICK_OUT);
      this.this$0.getEvent().post(new RoomCloseEvent((short)4));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.bizmodule.FloatWindowModule.5
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.ilive.audiencepages.room.bizmodule;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.ilive.audiencepages.room.events.PlayerCatonEvent;
import com.tencent.ilive.uicomponent.floatwindowcomponent_interface.FloatWindowComponent;

class FloatWindowModule$7
  implements Observer<PlayerCatonEvent>
{
  FloatWindowModule$7(FloatWindowModule paramFloatWindowModule) {}
  
  public void onChanged(@Nullable PlayerCatonEvent paramPlayerCatonEvent)
  {
    if ((FloatWindowModule.access$000(this.this$0) != null) && (FloatWindowModule.access$000(this.this$0).isReallyShow()))
    {
      FloatWindowModule.access$300(this.this$0, "主播网络异常");
      FloatWindowModule.access$400(this.this$0, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.bizmodule.FloatWindowModule.7
 * JD-Core Version:    0.7.0.1
 */
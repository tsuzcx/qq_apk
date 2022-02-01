package com.tencent.ilive.audiencepages.room.bizmodule;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.ilive.pages.room.events.PlayOverEvent;
import com.tencent.ilive.uicomponent.floatwindowcomponent_interface.FloatWindowComponent;

class FloatWindowModule$6
  implements Observer<PlayOverEvent>
{
  FloatWindowModule$6(FloatWindowModule paramFloatWindowModule) {}
  
  public void onChanged(@Nullable PlayOverEvent paramPlayOverEvent)
  {
    if ((this.this$0.floatWindowComponent != null) && (this.this$0.floatWindowComponent.isReallyShow()))
    {
      FloatWindowModule.access$902(this.this$0, true);
      this.this$0.floatWindowComponent.dismiss(6);
      FloatWindowModule.access$1000(this.this$0, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.bizmodule.FloatWindowModule.6
 * JD-Core Version:    0.7.0.1
 */
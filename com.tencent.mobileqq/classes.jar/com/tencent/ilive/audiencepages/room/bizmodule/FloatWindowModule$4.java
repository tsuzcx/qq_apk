package com.tencent.ilive.audiencepages.room.bizmodule;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.ilive.audiencepages.room.events.ShowAnchorStateEvent;
import com.tencent.ilive.audiencepages.room.events.ShowAnchorStateEvent.AnchorState;
import com.tencent.ilive.pages.room.RoomBizContext;
import com.tencent.ilive.uicomponent.floatwindowcomponent_interface.FloatWindowComponent;
import com.tencent.ilivesdk.roomservice_interface.model.LiveAnchorInfo;

class FloatWindowModule$4
  implements Observer<ShowAnchorStateEvent>
{
  FloatWindowModule$4(FloatWindowModule paramFloatWindowModule) {}
  
  public void onChanged(@Nullable ShowAnchorStateEvent paramShowAnchorStateEvent)
  {
    if (paramShowAnchorStateEvent.uin != FloatWindowModule.access$500(this.this$0).getAnchorInfo().uid) {
      return;
    }
    if (!FloatWindowModule.access$600(this.this$0)) {
      return;
    }
    if (this.this$0.floatWindowComponent == null) {
      return;
    }
    if ((this.this$0.floatWindowComponent.isReallyShow()) && (paramShowAnchorStateEvent.anchorState == ShowAnchorStateEvent.AnchorState.PAUSE))
    {
      FloatWindowModule.access$700(this.this$0, "主播暂时离开");
      FloatWindowModule.access$300(this.this$0, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.bizmodule.FloatWindowModule.4
 * JD-Core Version:    0.7.0.1
 */
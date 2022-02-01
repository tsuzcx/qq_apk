package com.tencent.ilive.audiencepages.room.bizmodule;

import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilive.audiencepages.room.events.FloatWindowStateEvent;
import com.tencent.ilive.audiencepages.room.events.PlayLittleWindowEvent;
import com.tencent.ilive.base.event.ModuleEvent;
import com.tencent.ilive.pages.room.RoomBizContext;
import com.tencent.ilive.uicomponent.floatwindowcomponent_interface.FloatWindowHandleCallback;
import com.tencent.ilivesdk.avplayerbuilderservice_interface.AVPlayerBuilderServiceInterface;

class FloatWindowModule$9
  implements FloatWindowHandleCallback
{
  FloatWindowModule$9(FloatWindowModule paramFloatWindowModule) {}
  
  public void invokePlayerContainer(@NonNull View paramView)
  {
    FloatWindowModule.access$2700(this.this$0, paramView);
  }
  
  public void onDismissed(int paramInt)
  {
    this.this$0.getLog().i("FloatWindowModule", "on float window dismiss, reason = " + paramInt + " current time = " + System.currentTimeMillis(), new Object[0]);
    this.this$0.changeRenderContainerAndPlay(paramInt);
    FloatWindowModule.access$2400(this.this$0);
    this.this$0.getEvent().post(new FloatWindowStateEvent(false));
    FloatWindowModule.access$900(this.this$0, FloatWindowModule.access$2500(this.this$0, paramInt));
    FloatWindowModule.access$2600(this.this$0).getRoomState().isFloatWindowShow = false;
  }
  
  public void onDragEnd(View paramView)
  {
    FloatWindowModule.access$2800(this.this$0, paramView);
  }
  
  public void onShow()
  {
    this.this$0.getLog().i("FloatWindowModule", "on float window show, current time = " + System.currentTimeMillis(), new Object[0]);
    this.this$0.getEvent().post(new FloatWindowStateEvent(true));
    FloatWindowModule.access$2200(this.this$0).getRoomState().isFloatWindowShow = true;
    if (FloatWindowModule.access$1800(this.this$0).isPaused()) {
      FloatWindowModule.access$1800(this.this$0).resumePlay();
    }
    this.this$0.getEvent().post(new PlayLittleWindowEvent(true));
    FloatWindowModule.access$2300(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.bizmodule.FloatWindowModule.9
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.ilive.audiencepages.room.bizmodule;

import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilive.audiencepages.room.events.FloatWindowStateEvent;
import com.tencent.ilive.audiencepages.room.events.PlayLittleWindowEvent;
import com.tencent.ilive.base.event.ModuleEvent;
import com.tencent.ilive.enginemanager.BizEngineMgr;
import com.tencent.ilive.pages.room.RoomBizContext;
import com.tencent.ilive.uicomponent.floatwindowcomponent_interface.FloatWindowHandleCallback;
import com.tencent.ilivesdk.avplayerbuilderservice_interface.AVPlayerBuilderServiceInterface;
import com.tencent.livesdk.liveengine.FloatRoomManager;
import com.tencent.livesdk.liveengine.FloatRoomManager.RelateRoomControl;
import com.tencent.livesdk.liveengine.FloatRoomManager.Room;
import com.tencent.livesdk.liveengine.LiveEngine;

class FloatWindowModule$9
  implements FloatWindowHandleCallback
{
  FloatWindowModule$9(FloatWindowModule paramFloatWindowModule) {}
  
  public void invokePlayerContainer(@NonNull View paramView)
  {
    FloatWindowModule.access$2800(this.this$0, paramView);
  }
  
  public void onDismissed(int paramInt)
  {
    Object localObject = this.this$0.getLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("on float window dismiss, reason = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" current time = ");
    localStringBuilder.append(System.currentTimeMillis());
    ((LogInterface)localObject).i("FloatWindowModule", localStringBuilder.toString(), new Object[0]);
    this.this$0.changeRenderContainerAndPlay(paramInt);
    FloatWindowModule.access$2500(this.this$0);
    this.this$0.getEvent().post(new FloatWindowStateEvent(false, paramInt));
    localObject = this.this$0;
    FloatWindowModule.access$800((FloatWindowModule)localObject, FloatWindowModule.access$2600((FloatWindowModule)localObject, paramInt));
    FloatWindowModule.access$2700(this.this$0).getRoomState().isFloatWindowShow = false;
    if ((this.this$0.outRoomFloatWindow()) && (this.this$0.roomControl != null)) {
      this.this$0.roomControl.a();
    }
  }
  
  public void onDragEnd(View paramView)
  {
    FloatWindowModule.access$2900(this.this$0, paramView);
  }
  
  public void onShow()
  {
    Object localObject = this.this$0.getLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("on float window show, current time = ");
    localStringBuilder.append(System.currentTimeMillis());
    ((LogInterface)localObject).i("FloatWindowModule", localStringBuilder.toString(), new Object[0]);
    this.this$0.getEvent().post(new FloatWindowStateEvent(true, 0));
    FloatWindowModule.access$2100(this.this$0).getRoomState().isFloatWindowShow = true;
    if (FloatWindowModule.access$1700(this.this$0).isPaused()) {
      FloatWindowModule.access$1700(this.this$0).resumePlay();
    }
    this.this$0.getEvent().post(new PlayLittleWindowEvent(true));
    FloatWindowModule.access$2200(this.this$0);
    if ((this.this$0.outRoomFloatWindow()) && ((FloatWindowModule.access$2300(this.this$0) instanceof FloatRoomManager.Room)))
    {
      localObject = BizEngineMgr.getInstance().getLiveEngine().getFloatRoomManager();
      ((FloatRoomManager)localObject).a((FloatRoomManager.Room)FloatWindowModule.access$2400(this.this$0));
      ((FloatRoomManager)localObject).e();
      this.this$0.roomControl = ((FloatRoomManager)localObject).h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.bizmodule.FloatWindowModule.9
 * JD-Core Version:    0.7.0.1
 */
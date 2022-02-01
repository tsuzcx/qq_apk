package com.tencent.ilive.audiencepages.room.bizmodule;

import com.tencent.falco.base.libapi.activitylife.AppStatusListener;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilive.uicomponent.floatwindowcomponent_interface.FloatWindowComponent;
import com.tencent.ilivesdk.avplayerbuilderservice_interface.AVPlayerBuilderServiceInterface;

class FloatWindowModule$8
  implements AppStatusListener
{
  FloatWindowModule$8(FloatWindowModule paramFloatWindowModule) {}
  
  public void onSwitchBackground()
  {
    FloatWindowModule.access$402(this.this$0, true);
    if (!FloatWindowModule.access$1800(this.this$0)) {
      return;
    }
    LogInterface localLogInterface = this.this$0.getLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSwitchBackground, isShowInBackground=");
    localStringBuilder.append(FloatWindowModule.access$1200(this.this$0));
    localStringBuilder.append(" isFloatWindowShow=");
    localStringBuilder.append(FloatWindowModule.access$1300(this.this$0));
    localStringBuilder.append(" isUserVisibleHint=");
    localStringBuilder.append(FloatWindowModule.access$1900(this.this$0));
    localLogInterface.i("FloatWindowModule", localStringBuilder.toString(), new Object[0]);
    if ((!FloatWindowModule.access$1200(this.this$0)) && (FloatWindowModule.access$1300(this.this$0)) && (FloatWindowModule.access$2000(this.this$0)) && (this.this$0.floatWindowComponent != null))
    {
      this.this$0.floatWindowComponent.dismiss(4);
      this.this$0.getLog().i("FloatWindowModule", "app onSwitchBackground, dismiss floatWindowComponent", new Object[0]);
    }
  }
  
  public void onSwitchForeground()
  {
    FloatWindowModule.access$402(this.this$0, false);
    if (!FloatWindowModule.access$1100(this.this$0)) {
      return;
    }
    LogInterface localLogInterface = this.this$0.getLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSwitchForeground, isShowInBackground=");
    localStringBuilder.append(FloatWindowModule.access$1200(this.this$0));
    localStringBuilder.append(" isFloatWindowShow=");
    localStringBuilder.append(FloatWindowModule.access$1300(this.this$0));
    localStringBuilder.append(" isUserVisibleHint=");
    localStringBuilder.append(FloatWindowModule.access$1400(this.this$0));
    localLogInterface.i("FloatWindowModule", localStringBuilder.toString(), new Object[0]);
    if ((!FloatWindowModule.access$1200(this.this$0)) && (FloatWindowModule.access$1300(this.this$0)) && (FloatWindowModule.access$1500(this.this$0)) && (this.this$0.floatWindowComponent != null) && (!this.this$0.floatWindowComponent.isCalledShow()))
    {
      this.this$0.floatWindowComponent.show(FloatWindowModule.access$1600(this.this$0));
      FloatWindowModule.access$1700(this.this$0).resumePlay();
      this.this$0.getLog().i("FloatWindowModule", "app switchForeground, show floatWindowComponent", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.bizmodule.FloatWindowModule.8
 * JD-Core Version:    0.7.0.1
 */
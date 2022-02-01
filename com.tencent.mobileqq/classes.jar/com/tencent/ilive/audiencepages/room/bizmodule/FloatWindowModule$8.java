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
    FloatWindowModule.access$502(this.this$0, true);
    if (!FloatWindowModule.access$1900(this.this$0)) {}
    do
    {
      return;
      this.this$0.getLog().i("FloatWindowModule", "onSwitchBackground, isShowInBackground=" + FloatWindowModule.access$1300(this.this$0) + " isFloatWindowShow=" + FloatWindowModule.access$1400(this.this$0) + " isUserVisibleHint=" + FloatWindowModule.access$2000(this.this$0), new Object[0]);
    } while ((FloatWindowModule.access$1300(this.this$0)) || (!FloatWindowModule.access$1400(this.this$0)) || (!FloatWindowModule.access$2100(this.this$0)) || (FloatWindowModule.access$000(this.this$0) == null));
    FloatWindowModule.access$000(this.this$0).dismiss(4);
    this.this$0.getLog().i("FloatWindowModule", "app onSwitchBackground, dismiss floatWindowComponent", new Object[0]);
  }
  
  public void onSwitchForeground()
  {
    FloatWindowModule.access$502(this.this$0, false);
    if (!FloatWindowModule.access$1200(this.this$0)) {}
    do
    {
      return;
      this.this$0.getLog().i("FloatWindowModule", "onSwitchForeground, isShowInBackground=" + FloatWindowModule.access$1300(this.this$0) + " isFloatWindowShow=" + FloatWindowModule.access$1400(this.this$0) + " isUserVisibleHint=" + FloatWindowModule.access$1500(this.this$0), new Object[0]);
    } while ((FloatWindowModule.access$1300(this.this$0)) || (!FloatWindowModule.access$1400(this.this$0)) || (!FloatWindowModule.access$1600(this.this$0)) || (FloatWindowModule.access$000(this.this$0) == null) || (FloatWindowModule.access$000(this.this$0).isCalledShow()));
    FloatWindowModule.access$000(this.this$0).show(FloatWindowModule.access$1700(this.this$0));
    FloatWindowModule.access$1800(this.this$0).resumePlay();
    this.this$0.getLog().i("FloatWindowModule", "app switchForeground, show floatWindowComponent", new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.bizmodule.FloatWindowModule.8
 * JD-Core Version:    0.7.0.1
 */
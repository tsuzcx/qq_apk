package com.tencent.ilive.audiencepages.room.bizmodule;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilive.uicomponent.floatwindowcomponent_interface.FloatWindowComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FloatWindowModule$11
  implements View.OnClickListener
{
  FloatWindowModule$11(FloatWindowModule paramFloatWindowModule) {}
  
  public void onClick(View paramView)
  {
    if (!FloatWindowModule.access$000(this.a).isDragEnd()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      FloatWindowModule.access$000(this.a).dismiss(9);
      FloatWindowModule.access$1402(this.a, false);
      this.a.getLog().i("FloatWindowModule", "isFloatWindowShow = false, onFloatWindowCloseClick", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.bizmodule.FloatWindowModule.11
 * JD-Core Version:    0.7.0.1
 */
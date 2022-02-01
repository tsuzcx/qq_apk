package com.tencent.ilive.audiencepages.room.bizmodule;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilive.interfaces.IAudienceRoomPager;
import com.tencent.ilive.interfaces.RoomPageActionInterface;
import com.tencent.ilive.uicomponent.floatwindowcomponent_interface.FloatWindowComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FloatWindowModule$10
  implements View.OnClickListener
{
  FloatWindowModule$10(FloatWindowModule paramFloatWindowModule) {}
  
  public void onClick(View paramView)
  {
    if (this.this$0.floatWindowComponent.isDragEnd())
    {
      this.this$0.floatWindowComponent.dismiss(8);
      FloatWindowModule.10.1 local1 = new FloatWindowModule.10.1(this);
      if (!this.this$0.getAudienceRoomPager().getRoomPageAction().onFloatWindowClick(local1, FloatWindowModule.access$3400(this.this$0))) {
        this.this$0.jumpAudienceRoomActivity(local1);
      }
      FloatWindowModule.access$1302(this.this$0, false);
      this.this$0.getLog().i("FloatWindowModule", "isFloatWindowShow = false, onFloatWindowClick", new Object[0]);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.bizmodule.FloatWindowModule.10
 * JD-Core Version:    0.7.0.1
 */
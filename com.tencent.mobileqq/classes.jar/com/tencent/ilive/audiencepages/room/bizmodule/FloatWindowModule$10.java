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
    if (!FloatWindowModule.access$000(this.this$0).isDragEnd()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      FloatWindowModule.access$000(this.this$0).dismiss(8);
      this.this$0.getAudienceRoomPager().getRoomPageAction().onFloatWindowClick();
      this.this$0.jumpAudienceRoomActivity();
      FloatWindowModule.access$1402(this.this$0, false);
      this.this$0.getLog().i("FloatWindowModule", "isFloatWindowShow = false, onFloatWindowClick", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.bizmodule.FloatWindowModule.10
 * JD-Core Version:    0.7.0.1
 */
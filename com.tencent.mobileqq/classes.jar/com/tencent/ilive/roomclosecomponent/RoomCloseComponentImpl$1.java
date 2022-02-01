package com.tencent.ilive.roomclosecomponent;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.ilive.roomclosecomponent_interface.RoomCloseListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class RoomCloseComponentImpl$1
  implements View.OnClickListener
{
  RoomCloseComponentImpl$1(RoomCloseComponentImpl paramRoomCloseComponentImpl) {}
  
  public void onClick(View paramView)
  {
    if (RoomCloseComponentImpl.access$000(this.this$0) != null) {
      RoomCloseComponentImpl.access$000(this.this$0).onCloseClick();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.roomclosecomponent.RoomCloseComponentImpl.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.ilive.litepages.room.bizmodule;

import com.tencent.falco.base.libapi.datareport.DataReportInterface;
import com.tencent.falco.base.libapi.datareport.ReportTask;
import com.tencent.ilive.base.event.ModuleEvent;
import com.tencent.ilive.pages.room.events.RoomCloseEvent;
import com.tencent.ilive.roomclosecomponent_interface.RoomCloseListener;
import com.tencent.livesdk.roomengine.RoomEngine;

class LiteRoomCloseBtnModule$1
  implements RoomCloseListener
{
  LiteRoomCloseBtnModule$1(LiteRoomCloseBtnModule paramLiteRoomCloseBtnModule) {}
  
  public void onCloseClick()
  {
    ((DataReportInterface)this.this$0.getRoomEngine().getService(DataReportInterface.class)).newTask().setPage("room_page").setPageDesc("直播间").setModule("close_button").setModuleDesc("关闭按钮").setActType("click").setActTypeDesc("直播间关闭按钮点击").send();
    this.this$0.getEvent().post(new RoomCloseEvent((short)3));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.litepages.room.bizmodule.LiteRoomCloseBtnModule.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.ilive.audiencepages.room.pagelogic.base;

import android.app.Dialog;
import com.tencent.ilive.base.event.ModuleEvent;
import com.tencent.ilive.dialog.CustomizedDialog.DialogBtn;
import com.tencent.ilive.dialog.CustomizedDialog.OnDialogBtnClickListener;
import com.tencent.ilive.interfaces.RoomPageActionInterface;
import com.tencent.ilive.pages.room.events.RoomCloseEvent;

class BaseController$1
  implements CustomizedDialog.OnDialogBtnClickListener
{
  BaseController$1(BaseController paramBaseController, RoomPageActionInterface paramRoomPageActionInterface) {}
  
  public void onClick(Dialog paramDialog, CustomizedDialog.DialogBtn paramDialogBtn)
  {
    if (this.this$0.getEvent() != null)
    {
      this.this$0.getEvent().post(new RoomCloseEvent((short)5));
      return;
    }
    paramDialog = this.val$roomPageActionInterface;
    if (paramDialog != null) {
      paramDialog.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.pagelogic.base.BaseController.1
 * JD-Core Version:    0.7.0.1
 */
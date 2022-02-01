package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.activity.aio.core.TroopAIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgListRefresher;
import com.tencent.mobileqq.activity.aio.coreui.msglist.TroopListUI;
import com.tencent.mobileqq.activity.aio.oneclickjump.JumpState;
import com.tencent.mobileqq.activity.aio.oneclickjump.JumpStateMachineController;

class OneClickJumpHelper$1
  implements Runnable
{
  OneClickJumpHelper$1(OneClickJumpHelper paramOneClickJumpHelper, boolean paramBoolean) {}
  
  public void run()
  {
    TroopListUI localTroopListUI = (TroopListUI)OneClickJumpHelper.a(this.this$0).e().b();
    if (this.a) {
      localTroopListUI.y().a(JumpState.GRAY_TIP_BELOW);
    } else {
      localTroopListUI.y().a(JumpState.GRAY_TIP_ABOVE);
    }
    OneClickJumpHelper.a(this.this$0).e().f().a(131072);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.OneClickJumpHelper.1
 * JD-Core Version:    0.7.0.1
 */
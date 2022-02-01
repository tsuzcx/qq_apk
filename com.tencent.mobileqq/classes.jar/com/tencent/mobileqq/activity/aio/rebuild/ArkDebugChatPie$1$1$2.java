package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;

class ArkDebugChatPie$1$1$2
  implements Runnable
{
  ArkDebugChatPie$1$1$2(ArkDebugChatPie.1.1 param1, int paramInt) {}
  
  public void run()
  {
    ArkDebugChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildArkDebugChatPie$1$1.a.this$0);
    String str = "";
    if (this.jdField_a_of_type_Int == 1) {
      str = HardCodeUtil.a(2131700746);
    }
    ArkAppMgr.getInstance().clearDebugAppPathCache();
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildArkDebugChatPie$1$1.a.this$0.a, String.format(HardCodeUtil.a(2131700754), new Object[] { str }), 0).a();
    ArkDispatchTask.getInstance().postToMainThreadDelayed(new ArkDebugChatPie.1.1.2.1(this), 60L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.ArkDebugChatPie.1.1.2
 * JD-Core Version:    0.7.0.1
 */
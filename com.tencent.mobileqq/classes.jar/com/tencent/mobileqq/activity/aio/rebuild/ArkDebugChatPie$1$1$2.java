package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.ark.open.ArkAppMgr;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;

class ArkDebugChatPie$1$1$2
  implements Runnable
{
  ArkDebugChatPie$1$1$2(ArkDebugChatPie.1.1 param1, int paramInt) {}
  
  public void run()
  {
    ArkDebugChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildArkDebugChatPie$1$1.a.this$0);
    String str;
    if (this.jdField_a_of_type_Int == 1) {
      str = HardCodeUtil.a(2131700890);
    } else {
      str = "";
    }
    ArkAppMgr.getInstance().clearDebugAppPathCache();
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildArkDebugChatPie$1$1.a.this$0.a, String.format(HardCodeUtil.a(2131700898), new Object[] { str }), 0).a();
    ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToMainThreadDelay(new ArkDebugChatPie.1.1.2.1(this), 60);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.ArkDebugChatPie.1.1.2
 * JD-Core Version:    0.7.0.1
 */
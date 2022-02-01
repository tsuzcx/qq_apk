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
    ArkDebugChatPie.a(this.b.a.this$0);
    String str;
    if (this.a == 1) {
      str = HardCodeUtil.a(2131898914);
    } else {
      str = "";
    }
    ArkAppMgr.getInstance().clearDebugAppPathCache();
    QQToast.makeText(this.b.a.this$0.e, String.format(HardCodeUtil.a(2131898922), new Object[] { str }), 0).show();
    ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToMainThreadDelay(new ArkDebugChatPie.1.1.2.1(this), 60);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.ArkDebugChatPie.1.1.2
 * JD-Core Version:    0.7.0.1
 */
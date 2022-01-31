package com.tencent.mobileqq.activity.aio.rebuild;

import aemb;
import aemc;
import ajya;
import bcql;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.open.ArkAppMgr;

public class ArkDebugChatPie$1$1$2
  implements Runnable
{
  public ArkDebugChatPie$1$1$2(aemc paramaemc, int paramInt) {}
  
  public void run()
  {
    aemb.a(this.jdField_a_of_type_Aemc.a.this$0);
    String str = "";
    if (this.jdField_a_of_type_Int == 1) {
      str = ajya.a(2131700669);
    }
    ArkAppMgr.getInstance().clearDebugAppPathCache();
    bcql.a(this.jdField_a_of_type_Aemc.a.this$0.a, String.format(ajya.a(2131700677), new Object[] { str }), 0).a();
    ArkDispatchTask.getInstance().postToMainThreadDelayed(new ArkDebugChatPie.1.1.2.1(this), 60L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.ArkDebugChatPie.1.1.2
 * JD-Core Version:    0.7.0.1
 */
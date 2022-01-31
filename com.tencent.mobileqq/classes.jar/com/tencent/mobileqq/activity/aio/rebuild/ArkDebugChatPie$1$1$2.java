package com.tencent.mobileqq.activity.aio.rebuild;

import aemd;
import aeme;
import ajyc;
import bcpw;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.open.ArkAppMgr;

public class ArkDebugChatPie$1$1$2
  implements Runnable
{
  public ArkDebugChatPie$1$1$2(aeme paramaeme, int paramInt) {}
  
  public void run()
  {
    aemd.a(this.jdField_a_of_type_Aeme.a.this$0);
    String str = "";
    if (this.jdField_a_of_type_Int == 1) {
      str = ajyc.a(2131700658);
    }
    ArkAppMgr.getInstance().clearDebugAppPathCache();
    bcpw.a(this.jdField_a_of_type_Aeme.a.this$0.a, String.format(ajyc.a(2131700666), new Object[] { str }), 0).a();
    ArkDispatchTask.getInstance().postToMainThreadDelayed(new ArkDebugChatPie.1.1.2.1(this), 60L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.ArkDebugChatPie.1.1.2
 * JD-Core Version:    0.7.0.1
 */
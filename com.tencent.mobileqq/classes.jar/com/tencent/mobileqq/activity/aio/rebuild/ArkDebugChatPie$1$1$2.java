package com.tencent.mobileqq.activity.aio.rebuild;

import aebe;
import aebf;
import ajjy;
import bbmy;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.open.ArkAppMgr;

public class ArkDebugChatPie$1$1$2
  implements Runnable
{
  public ArkDebugChatPie$1$1$2(aebf paramaebf, int paramInt) {}
  
  public void run()
  {
    aebe.a(this.jdField_a_of_type_Aebf.a.this$0);
    String str = "";
    if (this.jdField_a_of_type_Int == 1) {
      str = ajjy.a(2131634874);
    }
    ArkAppMgr.getInstance().clearDebugAppPathCache();
    bbmy.a(this.jdField_a_of_type_Aebf.a.this$0.a, String.format(ajjy.a(2131634882), new Object[] { str }), 0).a();
    ArkDispatchTask.getInstance().postToMainThreadDelayed(new ArkDebugChatPie.1.1.2.1(this), 60L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.ArkDebugChatPie.1.1.2
 * JD-Core Version:    0.7.0.1
 */
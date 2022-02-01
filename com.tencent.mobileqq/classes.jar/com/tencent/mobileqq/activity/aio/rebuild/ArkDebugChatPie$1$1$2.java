package com.tencent.mobileqq.activity.aio.rebuild;

import ahxn;
import ahxo;
import anni;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.mobileqq.widget.QQToast;

public class ArkDebugChatPie$1$1$2
  implements Runnable
{
  public ArkDebugChatPie$1$1$2(ahxo paramahxo, int paramInt) {}
  
  public void run()
  {
    ahxn.a(this.jdField_a_of_type_Ahxo.a.this$0);
    String str = "";
    if (this.jdField_a_of_type_Int == 1) {
      str = anni.a(2131699475);
    }
    ArkAppMgr.getInstance().clearDebugAppPathCache();
    QQToast.a(this.jdField_a_of_type_Ahxo.a.this$0.a, String.format(anni.a(2131699483), new Object[] { str }), 0).a();
    ArkDispatchTask.getInstance().postToMainThreadDelayed(new ArkDebugChatPie.1.1.2.1(this), 60L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.ArkDebugChatPie.1.1.2
 * JD-Core Version:    0.7.0.1
 */
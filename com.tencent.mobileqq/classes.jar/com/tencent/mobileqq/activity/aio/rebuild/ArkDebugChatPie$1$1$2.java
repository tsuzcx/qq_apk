package com.tencent.mobileqq.activity.aio.rebuild;

import agis;
import agit;
import alpo;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.mobileqq.widget.QQToast;

public class ArkDebugChatPie$1$1$2
  implements Runnable
{
  public ArkDebugChatPie$1$1$2(agit paramagit, int paramInt) {}
  
  public void run()
  {
    agis.a(this.jdField_a_of_type_Agit.a.this$0);
    String str = "";
    if (this.jdField_a_of_type_Int == 1) {
      str = alpo.a(2131701038);
    }
    ArkAppMgr.getInstance().clearDebugAppPathCache();
    QQToast.a(this.jdField_a_of_type_Agit.a.this$0.a, String.format(alpo.a(2131701046), new Object[] { str }), 0).a();
    ArkDispatchTask.getInstance().postToMainThreadDelayed(new ArkDebugChatPie.1.1.2.1(this), 60L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.ArkDebugChatPie.1.1.2
 * JD-Core Version:    0.7.0.1
 */
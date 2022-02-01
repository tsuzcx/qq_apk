package com.tencent.mobileqq.activity.aio.rebuild;

import ahdr;
import ahds;
import amtj;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.mobileqq.widget.QQToast;

public class ArkDebugChatPie$1$1$2
  implements Runnable
{
  public ArkDebugChatPie$1$1$2(ahds paramahds, int paramInt) {}
  
  public void run()
  {
    ahdr.a(this.jdField_a_of_type_Ahds.a.this$0);
    String str = "";
    if (this.jdField_a_of_type_Int == 1) {
      str = amtj.a(2131699817);
    }
    ArkAppMgr.getInstance().clearDebugAppPathCache();
    QQToast.a(this.jdField_a_of_type_Ahds.a.this$0.mContext, String.format(amtj.a(2131699825), new Object[] { str }), 0).a();
    ArkDispatchTask.getInstance().postToMainThreadDelayed(new ArkDebugChatPie.1.1.2.1(this), 60L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.ArkDebugChatPie.1.1.2
 * JD-Core Version:    0.7.0.1
 */
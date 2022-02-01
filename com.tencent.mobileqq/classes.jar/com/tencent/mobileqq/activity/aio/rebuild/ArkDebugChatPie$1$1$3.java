package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.ark.open.ArkAppMgr;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;

class ArkDebugChatPie$1$1$3
  implements Runnable
{
  ArkDebugChatPie$1$1$3(ArkDebugChatPie.1.1 param1, String paramString1, String paramString2) {}
  
  public void run()
  {
    ArkAppMgr.getInstance().setDebugAppPathCache(this.jdField_a_of_type_JavaLangString, this.b);
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildArkDebugChatPie$1$1.a.this$0.a, HardCodeUtil.a(2131700750), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.ArkDebugChatPie.1.1.3
 * JD-Core Version:    0.7.0.1
 */
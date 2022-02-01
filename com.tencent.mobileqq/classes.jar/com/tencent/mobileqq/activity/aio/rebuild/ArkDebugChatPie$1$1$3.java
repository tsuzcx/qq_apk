package com.tencent.mobileqq.activity.aio.rebuild;

import aihb;
import aihc;
import anzj;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.mobileqq.widget.QQToast;

public class ArkDebugChatPie$1$1$3
  implements Runnable
{
  public ArkDebugChatPie$1$1$3(aihc paramaihc, String paramString1, String paramString2) {}
  
  public void run()
  {
    ArkAppMgr.getInstance().setDebugAppPathCache(this.jdField_a_of_type_JavaLangString, this.b);
    QQToast.a(this.jdField_a_of_type_Aihc.a.this$0.a, anzj.a(2131699586), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.ArkDebugChatPie.1.1.3
 * JD-Core Version:    0.7.0.1
 */
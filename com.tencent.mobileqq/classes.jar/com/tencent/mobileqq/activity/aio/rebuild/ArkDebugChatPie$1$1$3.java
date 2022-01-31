package com.tencent.mobileqq.activity.aio.rebuild;

import agis;
import agit;
import alpo;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.mobileqq.widget.QQToast;

public class ArkDebugChatPie$1$1$3
  implements Runnable
{
  public ArkDebugChatPie$1$1$3(agit paramagit, String paramString1, String paramString2) {}
  
  public void run()
  {
    ArkAppMgr.getInstance().setDebugAppPathCache(this.jdField_a_of_type_JavaLangString, this.b);
    QQToast.a(this.jdField_a_of_type_Agit.a.this$0.a, alpo.a(2131701042), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.ArkDebugChatPie.1.1.3
 * JD-Core Version:    0.7.0.1
 */
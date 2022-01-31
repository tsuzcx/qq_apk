package com.tencent.mobileqq.activity.aio.rebuild;

import aemb;
import aemc;
import ajya;
import bcql;
import com.tencent.ark.open.ArkAppMgr;

public class ArkDebugChatPie$1$1$3
  implements Runnable
{
  public ArkDebugChatPie$1$1$3(aemc paramaemc, String paramString1, String paramString2) {}
  
  public void run()
  {
    ArkAppMgr.getInstance().setDebugAppPathCache(this.jdField_a_of_type_JavaLangString, this.b);
    bcql.a(this.jdField_a_of_type_Aemc.a.this$0.a, ajya.a(2131700673), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.ArkDebugChatPie.1.1.3
 * JD-Core Version:    0.7.0.1
 */
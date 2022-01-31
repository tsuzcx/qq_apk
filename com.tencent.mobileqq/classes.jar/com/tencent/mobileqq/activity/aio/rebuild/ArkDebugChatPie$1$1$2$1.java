package com.tencent.mobileqq.activity.aio.rebuild;

import aemb;
import aemc;
import ajya;
import bcql;
import com.tencent.ark.ArkDebugger;
import com.tencent.mobileqq.ark.ArkAppCenter;

class ArkDebugChatPie$1$1$2$1
  implements Runnable
{
  ArkDebugChatPie$1$1$2$1(ArkDebugChatPie.1.1.2 param2) {}
  
  public void run()
  {
    ArkDebugger.Listen("127.0.0.1", 23333L, 600000L, ArkAppCenter.c());
    bcql.a(this.a.a.a.this$0.a, ajya.a(2131700670), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.ArkDebugChatPie.1.1.2.1
 * JD-Core Version:    0.7.0.1
 */
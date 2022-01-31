package com.tencent.mobileqq.activity.aio.rebuild;

import aemd;
import aeme;
import ajyc;
import bcpw;
import com.tencent.ark.ArkDebugger;
import com.tencent.mobileqq.ark.ArkAppCenter;

class ArkDebugChatPie$1$1$2$1
  implements Runnable
{
  ArkDebugChatPie$1$1$2$1(ArkDebugChatPie.1.1.2 param2) {}
  
  public void run()
  {
    ArkDebugger.Listen("127.0.0.1", 23333L, 600000L, ArkAppCenter.c());
    bcpw.a(this.a.a.a.this$0.a, ajyc.a(2131700659), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.ArkDebugChatPie.1.1.2.1
 * JD-Core Version:    0.7.0.1
 */
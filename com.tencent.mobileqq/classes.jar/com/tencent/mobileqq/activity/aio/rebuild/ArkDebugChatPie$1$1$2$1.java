package com.tencent.mobileqq.activity.aio.rebuild;

import agnh;
import agni;
import alud;
import com.tencent.ark.ArkDebugger;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.widget.QQToast;

class ArkDebugChatPie$1$1$2$1
  implements Runnable
{
  ArkDebugChatPie$1$1$2$1(ArkDebugChatPie.1.1.2 param2) {}
  
  public void run()
  {
    ArkDebugger.Listen("127.0.0.1", 23333L, 600000L, ArkAppCenter.c());
    QQToast.a(this.a.a.a.this$0.a, alud.a(2131701051), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.ArkDebugChatPie.1.1.2.1
 * JD-Core Version:    0.7.0.1
 */
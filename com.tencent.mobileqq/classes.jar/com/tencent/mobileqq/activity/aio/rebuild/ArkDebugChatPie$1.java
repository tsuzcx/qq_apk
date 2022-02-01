package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.ark.ArkDebugger;
import com.tencent.ark.ArkDispatchTask;

class ArkDebugChatPie$1
  implements Runnable
{
  ArkDebugChatPie$1(ArkDebugChatPie paramArkDebugChatPie) {}
  
  public void run()
  {
    ArkDebugger.Create();
    ArkDebugger.SetCallback(new ArkDebugChatPie.1.1(this));
    ArkDebugChatPie localArkDebugChatPie = this.this$0;
    ArkDebugChatPie.c(localArkDebugChatPie, ArkDebugChatPie.b(localArkDebugChatPie));
    ArkDebugger.Listen("127.0.0.1", 23333L, 600000L, ArkDebugChatPie.b(this.this$0));
    ArkDispatchTask.getInstance().postToMainThread(new ArkDebugChatPie.1.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.ArkDebugChatPie.1
 * JD-Core Version:    0.7.0.1
 */
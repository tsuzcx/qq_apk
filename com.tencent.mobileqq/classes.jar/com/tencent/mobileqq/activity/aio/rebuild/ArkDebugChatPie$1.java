package com.tencent.mobileqq.activity.aio.rebuild;

import ahdr;
import ahds;
import com.tencent.ark.ArkDebugger;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.ark.ArkAppCenter;

public class ArkDebugChatPie$1
  implements Runnable
{
  public ArkDebugChatPie$1(ahdr paramahdr) {}
  
  public void run()
  {
    ArkDebugger.Create();
    ArkDebugger.SetCallback(new ahds(this));
    ahdr.a(this.this$0, ArkAppCenter.c());
    ArkDebugger.Listen("127.0.0.1", 23333L, 600000L, ArkAppCenter.c());
    ArkDispatchTask.getInstance().postToMainThread(new ArkDebugChatPie.1.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.ArkDebugChatPie.1
 * JD-Core Version:    0.7.0.1
 */
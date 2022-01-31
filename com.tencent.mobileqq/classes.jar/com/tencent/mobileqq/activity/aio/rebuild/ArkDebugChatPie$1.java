package com.tencent.mobileqq.activity.aio.rebuild;

import agnh;
import agni;
import com.tencent.ark.ArkDebugger;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.ark.ArkAppCenter;

public class ArkDebugChatPie$1
  implements Runnable
{
  public ArkDebugChatPie$1(agnh paramagnh) {}
  
  public void run()
  {
    ArkDebugger.Create();
    ArkDebugger.SetCallback(new agni(this));
    agnh.a(this.this$0, ArkAppCenter.c());
    ArkDebugger.Listen("127.0.0.1", 23333L, 600000L, ArkAppCenter.c());
    ArkDispatchTask.getInstance().postToMainThread(new ArkDebugChatPie.1.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.ArkDebugChatPie.1
 * JD-Core Version:    0.7.0.1
 */
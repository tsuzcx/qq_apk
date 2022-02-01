package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.ark.ArkDebugger.DebuggerCallback;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

class ArkDebugChatPie$1$1
  implements ArkDebugger.DebuggerCallback
{
  ArkDebugChatPie$1$1(ArkDebugChatPie.1 param1) {}
  
  public void Accepted()
  {
    ArkDispatchTask.getInstance().postToMainThread(new ArkDebugChatPie.1.1.1(this));
    QLog.d(this.a.this$0.b, 1, "ArkDebugger Accepted");
  }
  
  public boolean ReadyToRun(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToMainThread(new ArkDebugChatPie.1.1.4(this, paramString4, paramString3, paramString2, paramString1));
    QLog.d(this.a.this$0.b, 1, String.format("ArkDebugger ReadyToRun viewId: %s, metaData: %s, mode: %s", new Object[] { paramString1, paramString2, paramString3 }));
    return true;
  }
  
  public void ReceivedPackage(String paramString1, String paramString2)
  {
    ArkDebugChatPie.a(this.a.this$0, paramString1);
    ArkDebugChatPie.b(this.a.this$0, paramString2);
    ArkDispatchTask.getInstance().postToMainThread(new ArkDebugChatPie.1.1.3(this, paramString1, paramString2));
    QLog.d(this.a.this$0.b, 1, String.format("ArkDebugger ReceivedPackage appid: %s, appview: %s", new Object[] { paramString1, paramString2 }));
  }
  
  public void Stopped(int paramInt)
  {
    ArkDispatchTask.getInstance().postToMainThread(new ArkDebugChatPie.1.1.2(this, paramInt));
    QLog.d(this.a.this$0.b, 1, "ArkDebugger Stopped");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.ArkDebugChatPie.1.1
 * JD-Core Version:    0.7.0.1
 */
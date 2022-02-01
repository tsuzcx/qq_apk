package com.tencent.ark.open.internal;

import java.util.ArrayList;

class ArkAppCGIMgr$6
  implements Runnable
{
  ArkAppCGIMgr$6(ArkAppCGIMgr paramArkAppCGIMgr, ArkAppCGIMgr.QueryTask paramQueryTask, boolean paramBoolean, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    synchronized (ArkAppCGIMgr.access$400(this.this$0))
    {
      ArkAppCGIMgr.access$400(this.this$0).remove(this.val$task);
      this.val$task.onParseReply.onTaskHttpResult(this.val$task, this.val$success, this.val$bufReply);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.open.internal.ArkAppCGIMgr.6
 * JD-Core Version:    0.7.0.1
 */
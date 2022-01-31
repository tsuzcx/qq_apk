package com.tencent.ark.open;

import java.util.ArrayList;

class ArkAppCGIMgr$5
  implements Runnable
{
  ArkAppCGIMgr$5(ArkAppCGIMgr paramArkAppCGIMgr, ArkAppCGIMgr.QueryTask paramQueryTask, boolean paramBoolean, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    synchronized (ArkAppCGIMgr.access$700(this.this$0))
    {
      ArkAppCGIMgr.access$700(this.this$0).remove(this.val$task);
      this.val$task.onParseReply.onTaskHttpResult(this.val$task, this.val$success, this.val$bufReply);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.ark.open.ArkAppCGIMgr.5
 * JD-Core Version:    0.7.0.1
 */
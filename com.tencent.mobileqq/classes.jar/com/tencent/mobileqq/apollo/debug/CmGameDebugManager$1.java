package com.tencent.mobileqq.apollo.debug;

import com.tencent.mobileqq.apollo.debug.log.CmGameLogData;
import java.lang.ref.WeakReference;

class CmGameDebugManager$1
  implements Runnable
{
  CmGameDebugManager$1(CmGameDebugManager paramCmGameDebugManager, CmGameLogData paramCmGameLogData) {}
  
  public void run()
  {
    if ((CmGameDebugManager.a(this.this$0) != null) && (CmGameDebugManager.a(this.this$0).get() != null)) {
      ((CmGameDebugManager.OnLogViewRefresh)CmGameDebugManager.a(this.this$0).get()).a(this.a.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.debug.CmGameDebugManager.1
 * JD-Core Version:    0.7.0.1
 */
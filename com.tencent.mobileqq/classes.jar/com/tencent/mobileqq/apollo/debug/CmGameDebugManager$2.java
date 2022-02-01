package com.tencent.mobileqq.apollo.debug;

import java.lang.ref.WeakReference;

class CmGameDebugManager$2
  implements Runnable
{
  CmGameDebugManager$2(CmGameDebugManager paramCmGameDebugManager) {}
  
  public void run()
  {
    if ((CmGameDebugManager.a(this.this$0) != null) && (CmGameDebugManager.a(this.this$0).get() != null)) {
      ((CmGameDebugManager.OnLogViewRefresh)CmGameDebugManager.a(this.this$0).get()).a(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.debug.CmGameDebugManager.2
 * JD-Core Version:    0.7.0.1
 */
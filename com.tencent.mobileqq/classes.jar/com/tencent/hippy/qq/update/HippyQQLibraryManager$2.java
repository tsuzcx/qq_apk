package com.tencent.hippy.qq.update;

import java.util.Iterator;
import java.util.List;

class HippyQQLibraryManager$2
  implements Runnable
{
  HippyQQLibraryManager$2(HippyQQLibraryManager paramHippyQQLibraryManager, int paramInt) {}
  
  public void run()
  {
    if (HippyQQLibraryManager.access$400(this.this$0) != null)
    {
      Iterator localIterator = HippyQQLibraryManager.access$400(this.this$0).iterator();
      while (localIterator.hasNext()) {
        ((HippyQQLibraryManager.LibraryLoadListener)localIterator.next()).onLoadFail(this.val$resultCode, "");
      }
    }
    HippyQQLibraryManager.access$002(this.this$0, 0);
    HippyQQLibraryManager.access$400(this.this$0).clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.update.HippyQQLibraryManager.2
 * JD-Core Version:    0.7.0.1
 */
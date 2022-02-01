package com.tencent.hippy.qq.update;

import java.util.Iterator;
import java.util.List;

class HippyQQLibraryManager$1
  implements Runnable
{
  HippyQQLibraryManager$1(HippyQQLibraryManager paramHippyQQLibraryManager) {}
  
  public void run()
  {
    if (HippyQQLibraryManager.access$000(this.this$0) != 2)
    {
      Object localObject = HippyQQLibraryManager.access$100(this.this$0);
      if ((HippyQQLibraryManager.access$200(this.this$0, (String)localObject)) && (HippyQQLibraryManager.access$300(this.this$0, (String)localObject)))
      {
        HippyQQLibraryManager.access$002(this.this$0, 2);
        UpdateSetting.getInstance().setCDNUpdateFlag(false);
        if (HippyQQLibraryManager.access$400(this.this$0) != null) {
          localObject = HippyQQLibraryManager.access$400(this.this$0).iterator();
        }
      }
      else
      {
        while (((Iterator)localObject).hasNext())
        {
          ((HippyQQLibraryManager.LibraryLoadListener)((Iterator)localObject).next()).onLoadSuccess();
          continue;
          HippyQQLibraryManager.access$002(this.this$0, 0);
          if (HippyQQLibraryManager.access$400(this.this$0) != null)
          {
            localObject = HippyQQLibraryManager.access$400(this.this$0).iterator();
            while (((Iterator)localObject).hasNext()) {
              ((HippyQQLibraryManager.LibraryLoadListener)((Iterator)localObject).next()).onLoadFail(-9, "");
            }
          }
        }
      }
    }
    HippyQQLibraryManager.access$400(this.this$0).clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.update.HippyQQLibraryManager.1
 * JD-Core Version:    0.7.0.1
 */
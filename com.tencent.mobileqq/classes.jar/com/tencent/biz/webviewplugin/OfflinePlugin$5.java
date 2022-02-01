package com.tencent.biz.webviewplugin;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class OfflinePlugin$5
  implements Runnable
{
  OfflinePlugin$5(OfflinePlugin paramOfflinePlugin) {}
  
  public void run()
  {
    if (this.this$0.A != null)
    {
      if (this.this$0.A.size() == 0) {
        return;
      }
      Iterator localIterator = this.this$0.A.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        this.this$0.c(str);
      }
      this.this$0.A.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.OfflinePlugin.5
 * JD-Core Version:    0.7.0.1
 */
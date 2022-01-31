package com.tencent.biz.webviewplugin;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import xlb;

public class OfflinePlugin$5
  implements Runnable
{
  public OfflinePlugin$5(xlb paramxlb) {}
  
  public void run()
  {
    if ((this.this$0.a == null) || (this.this$0.a.size() == 0)) {
      return;
    }
    Iterator localIterator = this.this$0.a.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.this$0.b(str);
    }
    this.this$0.a.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.OfflinePlugin.5
 * JD-Core Version:    0.7.0.1
 */
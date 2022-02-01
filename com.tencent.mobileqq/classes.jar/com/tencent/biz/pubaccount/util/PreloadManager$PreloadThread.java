package com.tencent.biz.pubaccount.util;

import java.util.Iterator;
import java.util.List;

class PreloadManager$PreloadThread
  implements Runnable
{
  PreloadManager$PreloadThread(PreloadManager paramPreloadManager) {}
  
  public void run()
  {
    ??? = PreloadManager.b(this.this$0).iterator();
    while (((Iterator)???).hasNext())
    {
      String str = (String)((Iterator)???).next();
      PreloadManager.a(this.this$0, str);
    }
    synchronized (this.this$0.f)
    {
      PreloadManager.b(this.this$0).clear();
      if (PreloadManager.c(this.this$0).size() > 0) {
        this.this$0.b();
      } else {
        this.this$0.b = false;
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PreloadManager.PreloadThread
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.pubaccount;

import android.os.Build.VERSION;
import java.util.ArrayList;
import java.util.Iterator;

class SuperWebView$1
  implements Runnable
{
  SuperWebView$1(SuperWebView paramSuperWebView) {}
  
  public void run()
  {
    String str;
    if (Build.VERSION.SDK_INT >= 19)
    {
      localIterator = SuperWebView.access$000(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        SuperWebView.access$101(this.this$0, str.substring("javascript:".length()), null);
      }
    }
    Iterator localIterator = SuperWebView.access$000(this.this$0).iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      SuperWebView.access$201(this.this$0, str);
    }
    SuperWebView.access$000(this.this$0).clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.SuperWebView.1
 * JD-Core Version:    0.7.0.1
 */
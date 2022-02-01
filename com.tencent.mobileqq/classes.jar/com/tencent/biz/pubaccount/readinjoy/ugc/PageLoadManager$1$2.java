package com.tencent.biz.pubaccount.readinjoy.ugc;

import java.util.ArrayList;

class PageLoadManager$1$2
  implements Runnable
{
  PageLoadManager$1$2(PageLoadManager.1 param1) {}
  
  public void run()
  {
    PageLoadManager.a(this.a.this$0, true);
    if (PageLoadManager.a(this.a.this$0) != null) {
      PageLoadManager.a(this.a.this$0).a(new ArrayList(), PageLoadManager.a(this.a.this$0));
    }
    PageLoadManager.b(this.a.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.PageLoadManager.1.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.pubaccount;

class CustomWebView$4
  implements Runnable
{
  CustomWebView$4(CustomWebView paramCustomWebView, String paramString) {}
  
  public void run()
  {
    if (this.this$0.isDestroyed) {
      return;
    }
    try
    {
      CustomWebView.access$001(this.this$0, "javascript:" + this.a);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.CustomWebView.4
 * JD-Core Version:    0.7.0.1
 */
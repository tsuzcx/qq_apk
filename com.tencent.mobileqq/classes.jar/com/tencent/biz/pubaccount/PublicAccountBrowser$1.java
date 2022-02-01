package com.tencent.biz.pubaccount;

import android.content.Intent;
import rjv;

public class PublicAccountBrowser$1
  implements Runnable
{
  PublicAccountBrowser$1(PublicAccountBrowser paramPublicAccountBrowser, String paramString) {}
  
  public void run()
  {
    PublicAccountBrowser.a(this.this$0).b();
    PublicAccountBrowser.a(this.this$0, this.this$0.getIntent().getStringExtra("url"));
    PublicAccountBrowser.b(this.this$0, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.PublicAccountBrowser.1
 * JD-Core Version:    0.7.0.1
 */
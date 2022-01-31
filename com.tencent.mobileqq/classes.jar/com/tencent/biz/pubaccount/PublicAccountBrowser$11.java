package com.tencent.biz.pubaccount;

import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketProgressView;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;

class PublicAccountBrowser$11
  implements Runnable
{
  PublicAccountBrowser$11(PublicAccountBrowser paramPublicAccountBrowser, String paramString) {}
  
  public void run()
  {
    if (PublicAccountBrowser.a(this.this$0) <= RIJRedPacketManager.a().c())
    {
      PublicAccountBrowser.b(this.this$0, PublicAccountBrowser.a(this.this$0) + FastWebActivity.a);
      PublicAccountBrowser.a(this.this$0).post(new PublicAccountBrowser.11.1(this));
    }
    for (;;)
    {
      PublicAccountBrowser.a(this.this$0).postDelayed(PublicAccountBrowser.a(this.this$0), FastWebActivity.a);
      return;
      PublicAccountBrowser.a(this.this$0).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.PublicAccountBrowser.11
 * JD-Core Version:    0.7.0.1
 */
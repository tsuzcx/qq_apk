package com.tencent.biz.pubaccount;

import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketPopupView;

class PublicAccountBrowser$7
  implements Runnable
{
  PublicAccountBrowser$7(PublicAccountBrowser paramPublicAccountBrowser) {}
  
  public void run()
  {
    if (PublicAccountBrowser.b(this.this$0) == null)
    {
      PublicAccountBrowser.b(this.this$0, new RIJRedPacketPopupView(this.this$0));
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout)this.this$0.findViewById(2131363457)).addView(PublicAccountBrowser.b(this.this$0), localLayoutParams);
    }
    PublicAccountBrowser.b(this.this$0).a(true);
    PublicAccountBrowser.b(this.this$0).b(true);
    PublicAccountBrowser.b(this.this$0).setText(RIJRedPacketManager.a().c());
    PublicAccountBrowser.b(this.this$0).setVisibility(4);
    PublicAccountBrowser.b(this.this$0).post(new PublicAccountBrowser.7.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.PublicAccountBrowser.7
 * JD-Core Version:    0.7.0.1
 */
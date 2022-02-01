package com.tencent.biz.subscribe.widget.relativevideo;

import android.widget.LinearLayout;
import android.widget.TextView;
import anvx;

class ServiceFolderFollowPBHeadView$3
  implements Runnable
{
  ServiceFolderFollowPBHeadView$3(ServiceFolderFollowPBHeadView paramServiceFolderFollowPBHeadView, int paramInt) {}
  
  public void run()
  {
    if (this.a > 0)
    {
      ServiceFolderFollowPBHeadView.a(this.this$0).setVisibility(0);
      String str = this.a + anvx.a(2131707350);
      ServiceFolderFollowPBHeadView.a(this.this$0).setText(str);
      return;
    }
    ServiceFolderFollowPBHeadView.a(this.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.ServiceFolderFollowPBHeadView.3
 * JD-Core Version:    0.7.0.1
 */
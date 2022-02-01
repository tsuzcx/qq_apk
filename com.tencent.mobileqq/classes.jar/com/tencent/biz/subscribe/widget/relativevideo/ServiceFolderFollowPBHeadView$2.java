package com.tencent.biz.subscribe.widget.relativevideo;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;

class ServiceFolderFollowPBHeadView$2
  implements Runnable
{
  ServiceFolderFollowPBHeadView$2(ServiceFolderFollowPBHeadView paramServiceFolderFollowPBHeadView, int paramInt) {}
  
  public void run()
  {
    if (this.a > 0)
    {
      ServiceFolderFollowPBHeadView.a(this.this$0).setVisibility(0);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.a);
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131707900));
      localObject = ((StringBuilder)localObject).toString();
      ServiceFolderFollowPBHeadView.a(this.this$0).setText((CharSequence)localObject);
      return;
    }
    ServiceFolderFollowPBHeadView.a(this.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.ServiceFolderFollowPBHeadView.2
 * JD-Core Version:    0.7.0.1
 */
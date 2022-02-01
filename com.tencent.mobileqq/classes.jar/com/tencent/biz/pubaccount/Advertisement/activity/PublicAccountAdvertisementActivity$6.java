package com.tencent.biz.pubaccount.Advertisement.activity;

import android.view.View;
import com.tencent.biz.pubaccount.Advertisement.data.AdvertisementItem;
import com.tencent.biz.pubaccount.Advertisement.data.VideoDownloadItem;
import com.tencent.biz.pubaccount.Advertisement.fragment.VideoCoverFragment;
import com.tencent.biz.pubaccount.Advertisement.view.VerticalPagerView;
import com.tencent.qphone.base.util.QLog;

class PublicAccountAdvertisementActivity$6
  implements Runnable
{
  PublicAccountAdvertisementActivity$6(PublicAccountAdvertisementActivity paramPublicAccountAdvertisementActivity) {}
  
  public void run()
  {
    if (!PublicAccountAdvertisementActivity.u(this.this$0))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("doAutoJump = canScrollUp ");
        ((StringBuilder)localObject).append(this.this$0.a());
        QLog.d("PublicAccountAdvertisementActivity", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = PublicAccountAdvertisementActivity.h(this.this$0).g;
      if ((localObject != null) && (((VideoDownloadItem)localObject).F == 1)) {
        if (this.this$0.a())
        {
          if ((PublicAccountAdvertisementActivity.f(this.this$0)) && (PublicAccountAdvertisementActivity.j(this.this$0) != null))
          {
            PublicAccountAdvertisementActivity.e(this.this$0, true);
            PublicAccountAdvertisementActivity.j(this.this$0).setCurrentPage(1);
            PublicAccountAdvertisementActivity.b(this.this$0, 1);
          }
        }
        else if (PublicAccountAdvertisementActivity.l(this.this$0).d())
        {
          localObject = PublicAccountAdvertisementActivity.l(this.this$0).e();
          if ((localObject != null) && (((View)localObject).getVisibility() == 0) && (((View)localObject).isClickable()))
          {
            PublicAccountAdvertisementActivity.e(this.this$0, true);
            ((View)localObject).performClick();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity.6
 * JD-Core Version:    0.7.0.1
 */
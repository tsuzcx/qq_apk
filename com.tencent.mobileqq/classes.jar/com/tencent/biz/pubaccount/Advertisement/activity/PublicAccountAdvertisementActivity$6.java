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
    if (!PublicAccountAdvertisementActivity.f(this.this$0))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("doAutoJump = canScrollUp ");
        ((StringBuilder)localObject).append(this.this$0.a());
        QLog.d("PublicAccountAdvertisementActivity", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = PublicAccountAdvertisementActivity.a(this.this$0).a;
      if ((localObject != null) && (((VideoDownloadItem)localObject).k == 1)) {
        if (this.this$0.a())
        {
          if ((PublicAccountAdvertisementActivity.c(this.this$0)) && (PublicAccountAdvertisementActivity.a(this.this$0) != null))
          {
            PublicAccountAdvertisementActivity.e(this.this$0, true);
            PublicAccountAdvertisementActivity.a(this.this$0).setCurrentPage(1);
            PublicAccountAdvertisementActivity.b(this.this$0, 1);
          }
        }
        else if (PublicAccountAdvertisementActivity.a(this.this$0).b())
        {
          localObject = PublicAccountAdvertisementActivity.a(this.this$0).a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity.6
 * JD-Core Version:    0.7.0.1
 */
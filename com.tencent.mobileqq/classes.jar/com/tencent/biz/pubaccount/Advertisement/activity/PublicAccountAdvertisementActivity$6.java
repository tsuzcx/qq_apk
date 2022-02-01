package com.tencent.biz.pubaccount.Advertisement.activity;

import android.view.View;
import com.tencent.biz.pubaccount.Advertisement.fragment.VideoCoverFragment;
import com.tencent.biz.pubaccount.Advertisement.view.VerticalPagerView;
import com.tencent.qphone.base.util.QLog;
import oeq;
import oes;

class PublicAccountAdvertisementActivity$6
  implements Runnable
{
  PublicAccountAdvertisementActivity$6(PublicAccountAdvertisementActivity paramPublicAccountAdvertisementActivity) {}
  
  public void run()
  {
    Object localObject;
    if (!PublicAccountAdvertisementActivity.f(this.this$0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountAdvertisementActivity", 2, "doAutoJump = canScrollUp " + this.this$0.a());
      }
      localObject = PublicAccountAdvertisementActivity.a(this.this$0).a;
      if ((localObject != null) && (((oes)localObject).k == 1))
      {
        if (!this.this$0.a()) {
          break label130;
        }
        if ((PublicAccountAdvertisementActivity.c(this.this$0)) && (PublicAccountAdvertisementActivity.a(this.this$0) != null))
        {
          PublicAccountAdvertisementActivity.e(this.this$0, true);
          PublicAccountAdvertisementActivity.a(this.this$0).setCurrentPage(1);
        }
      }
    }
    label130:
    do
    {
      PublicAccountAdvertisementActivity.b(this.this$0, 1);
      do
      {
        return;
      } while (!PublicAccountAdvertisementActivity.a(this.this$0).b());
      localObject = PublicAccountAdvertisementActivity.a(this.this$0).a();
    } while ((localObject == null) || (((View)localObject).getVisibility() != 0) || (!((View)localObject).isClickable()));
    PublicAccountAdvertisementActivity.e(this.this$0, true);
    ((View)localObject).performClick();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity.6
 * JD-Core Version:    0.7.0.1
 */
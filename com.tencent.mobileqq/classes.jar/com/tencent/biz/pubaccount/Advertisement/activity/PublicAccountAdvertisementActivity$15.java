package com.tencent.biz.pubaccount.Advertisement.activity;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.Advertisement.data.AdvertisementItem;
import com.tencent.biz.pubaccount.Advertisement.data.VideoDownloadItem;
import com.tencent.mobileqq.imaxad.ImaxAdPresenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class PublicAccountAdvertisementActivity$15
  implements ActionSheet.OnButtonClickListener
{
  PublicAccountAdvertisementActivity$15(PublicAccountAdvertisementActivity paramPublicAccountAdvertisementActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    PublicAccountAdvertisementActivity.a(this.a).dismiss();
    if (paramView != null)
    {
      paramView = PublicAccountAdvertisementActivity.a(this.a).getContent(paramInt);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("action");
        localStringBuilder.append(paramView);
        QLog.i("PublicAccountAdvertisementActivity", 2, localStringBuilder.toString());
      }
      if (!TextUtils.isEmpty(paramView))
      {
        if (paramView.equals(this.a.getResources().getString(2131692635)))
        {
          PublicAccountAdvertisementActivity.d(this.a);
          return;
        }
        if (paramView.equals(this.a.getResources().getString(2131693241)))
        {
          ImaxAdPresenter.a().a(PublicAccountAdvertisementActivity.a(this.a), null, 3, 2);
          ReportController.a(null, "dc00898", "", PublicAccountAdvertisementActivity.a(this.a).a.a, "0X80090FC", "0X80090FC", 0, 0, PublicAccountAdvertisementActivity.a(this.a).a.c, "", "", PublicAccountAdvertisementActivity.a(this.a).a.b);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity.15
 * JD-Core Version:    0.7.0.1
 */
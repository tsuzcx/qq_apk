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

class PublicAccountAdvertisementActivity$14
  implements ActionSheet.OnButtonClickListener
{
  PublicAccountAdvertisementActivity$14(PublicAccountAdvertisementActivity paramPublicAccountAdvertisementActivity) {}
  
  public void onClick(View paramView, int paramInt)
  {
    PublicAccountAdvertisementActivity.z(this.a).dismiss();
    if (paramView != null)
    {
      paramView = PublicAccountAdvertisementActivity.z(this.a).getContent(paramInt);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("action");
        localStringBuilder.append(paramView);
        QLog.i("PublicAccountAdvertisementActivity", 2, localStringBuilder.toString());
      }
      if ((!TextUtils.isEmpty(paramView)) && (paramView.equals(this.a.getResources().getString(2131890789))))
      {
        ImaxAdPresenter.a().a(PublicAccountAdvertisementActivity.h(this.a), null, 3, 2);
        ReportController.a(null, "dc00898", "", PublicAccountAdvertisementActivity.h(this.a).g.a, "0X80090FC", "0X80090FC", 0, 0, PublicAccountAdvertisementActivity.h(this.a).g.c, "", "", PublicAccountAdvertisementActivity.h(this.a).g.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity.14
 * JD-Core Version:    0.7.0.1
 */
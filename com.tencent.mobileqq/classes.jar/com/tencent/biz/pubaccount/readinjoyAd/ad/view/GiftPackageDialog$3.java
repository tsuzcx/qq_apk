package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.GiftServiceBean;

class GiftPackageDialog$3
  implements GiftPkgSelectDialog.GiftSelectListener
{
  GiftPackageDialog$3(GiftPackageDialog paramGiftPackageDialog) {}
  
  public void a(GiftServiceBean paramGiftServiceBean)
  {
    String str = GiftPackageDialog.d(this.a).getText().toString();
    if ((!TextUtils.isEmpty(paramGiftServiceBean.t)) && (!str.equals(paramGiftServiceBean.t)))
    {
      GiftPackageDialog.c(this.a, paramGiftServiceBean);
      GiftPackageDialog.d(this.a).setText(paramGiftServiceBean.t);
    }
    GiftPackageDialog.g(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.GiftPackageDialog.3
 * JD-Core Version:    0.7.0.1
 */
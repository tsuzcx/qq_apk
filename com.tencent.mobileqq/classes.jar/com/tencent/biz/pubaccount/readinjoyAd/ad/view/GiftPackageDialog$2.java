package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.GiftServiceBean;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;

class GiftPackageDialog$2
  implements GiftPkgSelectDialog.GiftSelectListener
{
  GiftPackageDialog$2(GiftPackageDialog paramGiftPackageDialog) {}
  
  public void a(GiftServiceBean paramGiftServiceBean)
  {
    String str = GiftPackageDialog.c(this.a).getText().toString();
    if ((!TextUtils.isEmpty(paramGiftServiceBean.t)) && (!str.equals(paramGiftServiceBean.t)))
    {
      GiftPackageDialog.b(this.a, paramGiftServiceBean);
      GiftPackageDialog.c(this.a).setText(paramGiftServiceBean.t);
      if (GiftPackageDialog.b(this.a)) {
        GiftPackageDialog.c(this.a, null);
      }
      GiftPackageDialog.d(this.a).setText("");
      if (GiftPackageDialog.h(this.a) != null) {
        GiftPackageDialog.h(this.a).clear();
      }
      GiftPackageDialog.g(this.a);
      ThreadManager.executeOnNetWorkThread(new GiftPackageDialog.2.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.GiftPackageDialog.2
 * JD-Core Version:    0.7.0.1
 */
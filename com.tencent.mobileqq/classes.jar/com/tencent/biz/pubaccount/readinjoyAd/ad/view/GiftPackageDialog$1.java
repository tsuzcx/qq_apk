package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.GiftServiceBean;
import com.tencent.mobileqq.app.HardCodeUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class GiftPackageDialog$1
  implements GiftPkgSelectDialog.GiftSelectListener
{
  GiftPackageDialog$1(GiftPackageDialog paramGiftPackageDialog) {}
  
  public void a(GiftServiceBean paramGiftServiceBean)
  {
    Object localObject = GiftPackageDialog.a(this.a).getText().toString();
    if ((!TextUtils.isEmpty(paramGiftServiceBean.t)) && (!((String)localObject).equals(paramGiftServiceBean.t)))
    {
      GiftPackageDialog.a(this.a, paramGiftServiceBean);
      GiftPackageDialog.a(this.a).setText(paramGiftServiceBean.t);
      GiftPackageDialog.b(this.a, null);
      if (GiftPackageDialog.a(this.a)) {
        GiftPackageDialog.c(this.a, null);
      }
      GiftPackageDialog.b(this.a).setText("");
      GiftPackageDialog.c(this.a).setText("");
      GiftPackageDialog.a(this.a, new ArrayList());
      localObject = GiftPackageDialog.a(this.a).iterator();
      while (((Iterator)localObject).hasNext())
      {
        GiftServiceBean localGiftServiceBean = (GiftServiceBean)((Iterator)localObject).next();
        if ((!TextUtils.isEmpty(localGiftServiceBean.ck)) && (localGiftServiceBean.ck.equals(paramGiftServiceBean.ck)) && (localGiftServiceBean.c.equals(paramGiftServiceBean.v))) {
          GiftPackageDialog.b(this.a).add(localGiftServiceBean);
        }
      }
      if (GiftPackageDialog.b(this.a).size() <= 0)
      {
        paramGiftServiceBean = new GiftServiceBean();
        paramGiftServiceBean.t = HardCodeUtil.a(2131705365);
        paramGiftServiceBean.v = "0";
        GiftPackageDialog.b(this.a).add(paramGiftServiceBean);
      }
      GiftPackageDialog.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.GiftPackageDialog.1
 * JD-Core Version:    0.7.0.1
 */
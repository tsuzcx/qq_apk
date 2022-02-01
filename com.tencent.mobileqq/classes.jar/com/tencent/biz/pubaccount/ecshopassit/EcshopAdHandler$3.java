package com.tencent.biz.pubaccount.ecshopassit;

import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.gdtad.statistics.GdtImpressionPolicy.ReportListener;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;

final class EcshopAdHandler$3
  implements GdtImpressionPolicy.ReportListener
{
  EcshopAdHandler$3(AppInterface paramAppInterface) {}
  
  public void reportImpression(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Ecshop_EcshopAdHandler", 1, "--> reportImpression");
    }
    if (paramView == null) {}
    do
    {
      return;
      paramView = paramView.getTag(2131364647);
    } while (paramView == null);
    ThreadManagerV2.executeOnSubThread(new EcshopAdHandler.3.1(this, paramView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.EcshopAdHandler.3
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.SVIPObserver;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.api.IVasSingedApi;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vip.IVipStatusManager;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

class VisitorsActivity$5
  extends SVIPObserver
{
  VisitorsActivity$5(VisitorsActivity paramVisitorsActivity) {}
  
  public void onVipStatusChanged()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VisitorsActivity", 2, "onVipStatusChanged: ");
    }
    if ((this.a.app != null) && (VasUtil.b(this.a.app).getVipStatus().isSVip()))
    {
      this.a.b(true);
      this.a.c(true);
      if (VisitorsActivity.b(this.a).compareAndSet(true, false))
      {
        if (VisitorsActivity.a(this.a).get())
        {
          if (QLog.isColorLevel()) {
            QLog.d("VisitorsActivity", 2, "onVipStatusChanged: showDialog");
          }
          DialogUtil.a(this.a, 232, null, HardCodeUtil.a(2131913742), null, HardCodeUtil.a(2131913739), new VisitorsActivity.5.1(this), null).show();
        }
        VisitorsActivity localVisitorsActivity = this.a;
        localVisitorsActivity.removeObserver(VisitorsActivity.c(localVisitorsActivity));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VisitorsActivity.5
 * JD-Core Version:    0.7.0.1
 */
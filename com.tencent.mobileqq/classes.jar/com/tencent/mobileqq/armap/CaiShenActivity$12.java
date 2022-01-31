package com.tencent.mobileqq.armap;

import android.os.Handler;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class CaiShenActivity$12
  extends ArMapObserver
{
  CaiShenActivity$12(CaiShenActivity paramCaiShenActivity) {}
  
  public void onOpenPOI(boolean paramBoolean1, int paramInt1, ItemInfo paramItemInfo, boolean paramBoolean2, int paramInt2, int paramInt3, boolean paramBoolean3)
  {
    if (this.this$0.mHandler.hasMessages(1002)) {
      this.this$0.mHandler.removeMessages(1002);
    }
    if (this.this$0.mHandler.hasMessages(1001))
    {
      this.this$0.mHandler.removeMessages(1001);
      if (!paramBoolean1) {
        break label232;
      }
    }
    label232:
    for (Object localObject = "1";; localObject = "0")
    {
      ReportController.b(null, "dc01440", "", "", "0X8007A35", "0X8007A35", 0, 0, (String)localObject, "", "", "");
      if (QLog.isColorLevel()) {
        QLog.i("CaiShenActivity", 2, "onOpenPoi isSuccess: " + paramBoolean1 + ", holder: " + paramBoolean2 + ", bussiType: " + paramInt2 + ", mode: " + paramInt3 + ", itemInfo: " + paramItemInfo + ", isServerSuccess:" + paramBoolean3);
      }
      if ((paramInt1 != 19) || (paramItemInfo == null)) {
        break label239;
      }
      paramItemInfo.h = CaiShenActivity.access$900(this.this$0);
      if (QLog.isColorLevel()) {
        QLog.i("CaiShenActivity", 2, "already get dialog");
      }
      this.this$0.runOnUiThread(new CaiShenActivity.12.1(this, paramItemInfo));
      return;
      CaiShenActivity.access$100(this.this$0);
      break;
    }
    label239:
    if (paramInt3 == 0) {
      if ((paramBoolean1) && (paramItemInfo != null) && ((CaiShenActivity.access$200(this.this$0) == 4) || (paramItemInfo.e > 0)))
      {
        paramItemInfo.h = CaiShenActivity.access$900(this.this$0);
        CaiShenActivity.access$1102(this.this$0, paramItemInfo);
        CaiShenActivity.access$1202(this.this$0, true);
        this.this$0.openSuccess = true;
        ReportController.b(null, "dc01440", "", "", "0X800783C", "0X800783C", 0, 0, String.valueOf(CaiShenActivity.access$1300(this.this$0)), String.valueOf(CaiShenActivity.access$1400(this.this$0)), String.valueOf(CaiShenActivity.access$1500(this.this$0)), "");
        if (CaiShenActivity.access$600(this.this$0) != null) {
          CaiShenActivity.access$600(this.this$0).runOnGlThread(new CaiShenActivity.12.2(this));
        }
        CaiShenActivity.access$1602(this.this$0, paramBoolean3);
        if (QLog.isColorLevel()) {
          QLog.i("CaiShenActivity", 2, "set serverRespSuccess to :" + CaiShenActivity.access$1600(this.this$0) + " when lottery");
        }
        if ((CaiShenActivity.access$200(this.this$0) != 6) || (paramInt1 == -1) || ((paramInt3 == 1) && (CaiShenActivity.access$1200(this.this$0)))) {
          break label804;
        }
        localObject = this.this$0;
        if (((paramInt1 != 0) || (paramItemInfo == null) || (paramItemInfo.e <= 0)) && ((paramInt1 != 19) || (paramItemInfo == null) || (paramItemInfo.e > 0))) {
          break label806;
        }
      }
    }
    label355:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      CaiShenActivity.access$1802((CaiShenActivity)localObject, paramBoolean1);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("CaiShenActivity", 2, "onOpenPOI bigredbag hasReceived:" + CaiShenActivity.access$1800(this.this$0));
      return;
      CaiShenActivity.access$1102(this.this$0, null);
      CaiShenActivity.access$1202(this.this$0, false);
      this.this$0.openFailed = true;
      break label355;
      if (paramInt3 == 1)
      {
        if ((!paramBoolean1) || (paramItemInfo == null))
        {
          CaiShenActivity.access$1102(this.this$0, null);
          CaiShenActivity.access$1202(this.this$0, false);
          this.this$0.openFailed = true;
        }
        for (;;)
        {
          if (!CaiShenActivity.access$1200(this.this$0))
          {
            if (QLog.isColorLevel()) {
              QLog.i("CaiShenActivity", 2, "set serverRespSuccess to true when predicting");
            }
            CaiShenActivity.access$1602(this.this$0, true);
          }
          if (CaiShenActivity.access$600(this.this$0) == null) {
            break;
          }
          CaiShenActivity.access$600(this.this$0).runOnGlThread(new CaiShenActivity.12.3(this));
          break;
          if (!paramBoolean2)
          {
            CaiShenActivity.access$1102(this.this$0, null);
            CaiShenActivity.access$1202(this.this$0, true);
          }
          else if (paramItemInfo.e > 0)
          {
            paramItemInfo.h = CaiShenActivity.access$900(this.this$0);
            CaiShenActivity.access$1102(this.this$0, paramItemInfo);
            CaiShenActivity.access$1202(this.this$0, true);
            CaiShenActivity.access$1702(this.this$0, true);
          }
          else
          {
            CaiShenActivity.access$1102(this.this$0, null);
            CaiShenActivity.access$1202(this.this$0, false);
            this.this$0.openFailed = true;
          }
        }
      }
      if (!QLog.isColorLevel()) {
        break label435;
      }
      QLog.i("CaiShenActivity", 2, "onOpenPOI do nothing");
      break label435;
      break;
    }
  }
  
  public void onReport(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.this$0.mHandler.hasMessages(1002)) {
      this.this$0.mHandler.removeMessages(1002);
    }
    if (this.this$0.mHandler.hasMessages(1001))
    {
      this.this$0.mHandler.removeMessages(1001);
      if (QLog.isColorLevel()) {
        QLog.i("CaiShenActivity", 2, "onReport isSuccess: " + paramBoolean1 + ", isServerSuccess:" + paramBoolean2);
      }
      if (CaiShenActivity.access$1900(this.this$0))
      {
        CaiShenActivity.access$1602(this.this$0, paramBoolean2);
        if (QLog.isColorLevel()) {
          QLog.i("CaiShenActivity", 2, "set serverRespSuccess to :" + paramBoolean2 + " when onReport");
        }
      }
      if ((paramBoolean1) && (CaiShenActivity.access$1200(this.this$0)) && (CaiShenActivity.access$1100(this.this$0) != null)) {
        break label322;
      }
      CaiShenActivity.access$1202(this.this$0, false);
      this.this$0.openFailed = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("CaiShenActivity", 2, "onReport taskType" + CaiShenActivity.access$200(this.this$0) + " openSuc:" + CaiShenActivity.access$1200(this.this$0));
      }
      if ((CaiShenActivity.access$1200(this.this$0)) && (CaiShenActivity.access$200(this.this$0) == 6)) {
        CaiShenActivity.access$1802(this.this$0, CaiShenActivity.access$1200(this.this$0));
      }
      if (CaiShenActivity.access$600(this.this$0) != null) {
        CaiShenActivity.access$600(this.this$0).runOnGlThread(new CaiShenActivity.12.4(this));
      }
      return;
      CaiShenActivity.access$100(this.this$0);
      break;
      label322:
      this.this$0.openSuccess = true;
      ReportController.b(null, "dc01440", "", "", "0X800783C", "0X800783C", 0, 0, String.valueOf(CaiShenActivity.access$1300(this.this$0)), String.valueOf(CaiShenActivity.access$1400(this.this$0)), "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.CaiShenActivity.12
 * JD-Core Version:    0.7.0.1
 */
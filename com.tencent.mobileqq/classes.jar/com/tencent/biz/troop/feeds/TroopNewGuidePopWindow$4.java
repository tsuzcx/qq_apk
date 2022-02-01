package com.tencent.biz.troop.feeds;

import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager.TroopNotify;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONObject;

class TroopNewGuidePopWindow$4
  implements Runnable
{
  TroopNewGuidePopWindow$4(TroopNewGuidePopWindow paramTroopNewGuidePopWindow, JSONObject paramJSONObject, boolean paramBoolean, int paramInt) {}
  
  public void run()
  {
    Object localObject1 = this.this$0;
    ((TroopNewGuidePopWindow)localObject1).B = TroopFeedsDataManager.TroopNotify.a(((TroopNewGuidePopWindow)localObject1).w, this.this$0.z, this.a);
    localObject1 = this.this$0;
    ((TroopNewGuidePopWindow)localObject1).G = this.b;
    if (((TroopNewGuidePopWindow)localObject1).B != null)
    {
      boolean bool = TroopNotificationHelper.a(this.this$0.w, this.this$0.z, this.this$0.B.p);
      TroopNotificationHelper.e(this.this$0.w, this.this$0.z);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("initViewInThread, isRead = ");
        ((StringBuilder)localObject1).append(bool);
        ((StringBuilder)localObject1).append(", mTroopNotify. mTroopNotify.isShowTipWindow = ");
        ((StringBuilder)localObject1).append(this.this$0.B.n);
        ((StringBuilder)localObject1).append(", isRemindNotice = ");
        ((StringBuilder)localObject1).append(this.b);
        QLog.d("TroopTipsPopWindow", 2, ((StringBuilder)localObject1).toString());
      }
      if ((!this.this$0.B.h.equals(this.this$0.w.getCurrentUin())) && (((this.this$0.B.n) && (!bool) && (!this.this$0.B.q)) || (this.b)))
      {
        Object localObject3 = (TroopManager)this.this$0.w.getManager(QQManagerFactory.TROOP_MANAGER);
        Object localObject2 = "";
        localObject1 = null;
        if (localObject3 != null) {
          localObject1 = ((TroopManager)localObject3).f(this.this$0.z);
        }
        if (localObject1 != null)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("");
          ((StringBuilder)localObject2).append(((TroopInfo)localObject1).dwGroupClassExt);
          localObject2 = ((StringBuilder)localObject2).toString();
        }
        localObject1 = this.this$0.w;
        localObject3 = this.this$0.z;
        bool = this.this$0.B.o;
        int j = 1;
        int i;
        if (bool) {
          i = 2;
        } else {
          i = 1;
        }
        if (this.this$0.G) {
          j = 2;
        }
        ReportController.b((AppRuntime)localObject1, "dc00898", "", "", "0X800AAC7", "0X800AAC7", 0, 0, (String)localObject3, (String)localObject2, String.valueOf(i), String.valueOf(j));
        if (QLog.isColorLevel()) {
          QLog.d("TroopTipsPopWindow", 2, "initViewInThread showing popup window for troopNotice");
        }
        this.this$0.L.post(new TroopNewGuidePopWindow.4.1(this));
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopTipsPopWindow", 2, "initViewInThread, mTroopNotify is null!");
      }
      TroopNotificationHelper.e(this.this$0.w, this.this$0.z);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troop.feeds.TroopNewGuidePopWindow.4
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.pubaccount.subscript;

import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

class SubscriptFeedsActivity$14
  extends MqqHandler
{
  SubscriptFeedsActivity$14(SubscriptFeedsActivity paramSubscriptFeedsActivity, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a.isFinishing()) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
    case 1007: 
      this.a.runOnUiThread(new SubscriptFeedsActivity.14.6(this));
      return;
    case 1006: 
      this.a.runOnUiThread(new SubscriptFeedsActivity.14.5(this));
      return;
    case 1005: 
      this.a.runOnUiThread(new SubscriptFeedsActivity.14.4(this));
      return;
    case 1004: 
      this.a.runOnUiThread(new SubscriptFeedsActivity.14.2(this));
      return;
    case 1003: 
      paramMessage = paramMessage.getData();
      if ((paramMessage != null) && (((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isOSVersionSupportReadInJoy()))
      {
        paramMessage = paramMessage.getSerializable("ReadInJoyArticleList");
        if ((paramMessage != null) && ((paramMessage instanceof ArrayList)))
        {
          if ((!SubscriptFeedsActivity.a(this.a, (ArrayList)paramMessage)) && (QLog.isColorLevel())) {
            QLog.d("SubscriptFeedsActivity", 2, "onGetRecommendReadInJoyArticleList data save to sp fail");
          }
          this.a.runOnUiThread(new SubscriptFeedsActivity.14.3(this, paramMessage));
          return;
        }
      }
      break;
    case 1002: 
      try
      {
        paramMessage = TroopBarAssistantManager.a().i(this.a.app);
        this.a.runOnUiThread(new SubscriptFeedsActivity.14.1(this, paramMessage));
        return;
      }
      catch (Exception paramMessage)
      {
        if (QLog.isColorLevel()) {
          QLog.i("SubscriptFeedsActivity", 2, paramMessage.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity.14
 * JD-Core Version:    0.7.0.1
 */
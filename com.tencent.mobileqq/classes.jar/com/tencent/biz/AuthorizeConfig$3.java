package com.tencent.biz;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mp.mobileqq_mp.WebviewWhiteListResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.WebviewWhiteListResponse.RetInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;

class AuthorizeConfig$3
  implements BusinessObserver
{
  AuthorizeConfig$3(AuthorizeConfig paramAuthorizeConfig) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onReceive whitelist:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("AuthorizeConfig", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean)
    {
      localObject = paramBundle.getByteArray("data");
      if (localObject != null)
      {
        paramBundle = new mobileqq_mp.WebviewWhiteListResponse();
        try
        {
          paramBundle.mergeFrom((byte[])localObject);
          paramInt = paramBundle.ret_info.ret_code.get();
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("sso status code: ");
            ((StringBuilder)localObject).append(String.valueOf(paramInt));
            QLog.d("AuthorizeConfig", 2, ((StringBuilder)localObject).toString());
          }
          if (paramInt == 0)
          {
            ThreadManager.getSubThreadHandler().post(new AuthorizeConfig.3.1(this, paramBundle));
            ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "webview_whitelist", "update_success", 0, 1, 0, "", "", "", "");
            return;
          }
          if (paramInt == 304)
          {
            this.a.c.set(2);
            this.a.w.edit().putLong("lastUpdate", System.currentTimeMillis()).commit();
            this.a.n();
            this.a.q();
            ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "webview_whitelist", "update_not_modify", 0, 1, 0, "", "", "", "");
            return;
          }
        }
        catch (Exception paramBundle)
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("update error: ");
            ((StringBuilder)localObject).append(paramBundle);
            QLog.d("AuthorizeConfig", 2, ((StringBuilder)localObject).toString());
          }
        }
      }
    }
    this.a.n();
    this.a.q();
    this.a.c.set(0);
    ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "webview_whitelist", "update_failed", 0, 1, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.AuthorizeConfig.3
 * JD-Core Version:    0.7.0.1
 */
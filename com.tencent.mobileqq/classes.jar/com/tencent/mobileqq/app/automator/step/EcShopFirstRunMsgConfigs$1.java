package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.ecshopassit.EcshopReportHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class EcShopFirstRunMsgConfigs$1
  extends DownloadListener
{
  EcShopFirstRunMsgConfigs$1(EcShopFirstRunMsgConfigs paramEcShopFirstRunMsgConfigs) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    if ((paramDownloadTask.a == 0) && (this.a.a.a != null))
    {
      str = paramDownloadTask.a().getString("path");
      if ((this.a.a.a != null) && (!TextUtils.isEmpty(str)))
      {
        if (!EcShopAssistantManager.e.equals(str)) {
          break label143;
        }
        this.a.a.a.getApp().getSharedPreferences("ecshop_sp", 0).edit().putLong("last_modified_report_json", paramDownloadTask.i).commit();
        ((EcshopReportHandler)this.a.a.a.getBusinessHandler(BusinessHandlerFactory.EC_SHOP_REPORT_HANDLER)).a();
        if (QLog.isColorLevel()) {
          QLog.i("Ecshop", 2, "download report json success.");
        }
      }
    }
    label143:
    while (!QLog.isColorLevel())
    {
      do
      {
        String str;
        do
        {
          return;
        } while (!EcShopAssistantManager.f.equals(str));
        this.a.a.a.getApp().getSharedPreferences("ecshop_sp", 0).edit().putLong("last_modified_behaviors_json", paramDownloadTask.i).commit();
      } while (!QLog.isColorLevel());
      QLog.i("Ecshop", 2, "download behaviors json success.");
      return;
    }
    QLog.i("Ecshop", 2, "download json failed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.EcShopFirstRunMsgConfigs.1
 * JD-Core Version:    0.7.0.1
 */
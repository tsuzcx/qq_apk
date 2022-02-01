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
    if ((paramDownloadTask.c == 0) && (this.a.mAutomator.k != null))
    {
      String str = paramDownloadTask.b().getString("path");
      if ((this.a.mAutomator.k != null) && (!TextUtils.isEmpty(str))) {
        if (EcShopAssistantManager.m.equals(str))
        {
          this.a.mAutomator.k.getApp().getSharedPreferences("ecshop_sp", 0).edit().putLong("last_modified_report_json", paramDownloadTask.I).commit();
          ((EcshopReportHandler)this.a.mAutomator.k.getBusinessHandler(BusinessHandlerFactory.EC_SHOP_REPORT_HANDLER)).a();
          if (QLog.isColorLevel()) {
            QLog.i("Ecshop", 2, "download report json success.");
          }
        }
        else if (EcShopAssistantManager.n.equals(str))
        {
          this.a.mAutomator.k.getApp().getSharedPreferences("ecshop_sp", 0).edit().putLong("last_modified_behaviors_json", paramDownloadTask.I).commit();
          if (QLog.isColorLevel()) {
            QLog.i("Ecshop", 2, "download behaviors json success.");
          }
        }
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Ecshop", 2, "download json failed.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.EcShopFirstRunMsgConfigs.1
 * JD-Core Version:    0.7.0.1
 */
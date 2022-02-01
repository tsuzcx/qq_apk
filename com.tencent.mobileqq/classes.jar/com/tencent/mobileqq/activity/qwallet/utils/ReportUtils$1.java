package com.tencent.mobileqq.activity.qwallet.utils;

import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletHelper;

public final class ReportUtils$1
  implements Runnable
{
  public void run()
  {
    try
    {
      String str = "networkType=" + HttpUtil.getNetWorkType() + "&stackType=" + NetConnInfoCenter.getActiveNetIpFamily(true) + "&carrierType=" + DeviceInfoUtil.checkCarrier(QWalletHelper.getIMSI());
      VACDReportUtil.a(str, "qqwallet", "walletNetworkStack", "walletNetworkStack", null, 0, null);
      if (QLog.isColorLevel()) {
        QLog.i("ReportUtils", 2, "reportNetworkStack...data:" + str);
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.utils.ReportUtils.1
 * JD-Core Version:    0.7.0.1
 */
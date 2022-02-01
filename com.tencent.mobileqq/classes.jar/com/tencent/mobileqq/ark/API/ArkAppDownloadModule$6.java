package com.tencent.mobileqq.ark.API;

import com.tencent.gamecenter.appointment.GameCenterUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class ArkAppDownloadModule$6
  implements WadlProxyServiceCallBackInterface
{
  ArkAppDownloadModule$6(ArkAppDownloadModule paramArkAppDownloadModule) {}
  
  public void onQueryCallback(ArrayList<WadlResult> paramArrayList)
  {
    if (paramArrayList != null) {
      QLog.i("ark.download.module", 1, "ark.dctrl.onQueryCallback:" + paramArrayList.toString());
    }
    if (ArkAppDownloadModule.a(this.a) != null)
    {
      GameCenterUtils.a(paramArrayList);
      ArkAppDownloadModule.a(this.a).a(paramArrayList);
    }
  }
  
  public void onQueryCallbackVia(ArrayList<WadlResult> paramArrayList)
  {
    if (paramArrayList != null) {
      QLog.i("ark.download.module", 1, "ark.dctrl.onQueryCallbackVia:" + paramArrayList.toString());
    }
    if (ArkAppDownloadModule.a(this.a) != null)
    {
      GameCenterUtils.a(paramArrayList);
      ArkAppDownloadModule.a(this.a).a(paramArrayList);
    }
  }
  
  public void onWadlTaskStatusChanged(WadlResult paramWadlResult)
  {
    if (ArkAppDownloadModule.a(this.a) != null)
    {
      GameCenterUtils.a(paramWadlResult);
      ArkAppDownloadModule.a(this.a).a(paramWadlResult);
      if (paramWadlResult != null) {}
    }
    else
    {
      return;
    }
    QLog.i("ark.download.module", 1, "ark.dctrl.onWadlTaskStatusChanged:" + paramWadlResult.toString());
    if (paramWadlResult.a != null) {}
    for (String str = paramWadlResult.a.a;; str = "") {
      switch (paramWadlResult.b)
      {
      case 8: 
      case 10: 
      case 11: 
      case 12: 
      case 13: 
      default: 
        return;
      case 6: 
        ReportController.a(null, "dc00898", "", "", "0X8009E14", "0X8009E14", 0, 0, "", "", str, "");
        return;
      }
    }
    ReportController.a(null, "dc00898", "", "", "0X8009E15", "0X8009E15", 0, 0, "", "", str, "");
    return;
    ReportController.a(null, "dc00898", "", "", "0X8009E17", "0X8009E17", 0, 0, "", "", str, "");
    return;
    ReportController.a(null, "dc00898", "", "", "0X8009E18", "0X8009E18", 0, 0, "", "", str, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppDownloadModule.6
 * JD-Core Version:    0.7.0.1
 */
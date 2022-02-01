package com.tencent.mobileqq.ark.api.module;

import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class ArkAppDownloadModule$6
  implements WadlProxyServiceCallBackInterface
{
  ArkAppDownloadModule$6(ArkAppDownloadModule paramArkAppDownloadModule) {}
  
  public void a(WadlResult paramWadlResult)
  {
    if (ArkAppDownloadModule.a(this.a) != null)
    {
      if (paramWadlResult != null) {
        GameCenterUtil.a(paramWadlResult);
      }
      ArkAppDownloadModule.a(this.a).a(paramWadlResult);
      if (paramWadlResult == null) {
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ark.dctrl.onWadlTaskStatusChanged:");
      ((StringBuilder)localObject).append(paramWadlResult.toString());
      QLog.i("ark.download.module", 1, ((StringBuilder)localObject).toString());
      if (paramWadlResult.a != null) {
        localObject = paramWadlResult.a.a;
      } else {
        localObject = "";
      }
      int i = paramWadlResult.b;
      if (i != 6)
      {
        if (i != 7)
        {
          if (i != 9)
          {
            if (i != 14) {
              return;
            }
            ReportController.a(null, "dc00898", "", "", "0X8009E18", "0X8009E18", 0, 0, "", "", (String)localObject, "");
            return;
          }
          ReportController.a(null, "dc00898", "", "", "0X8009E17", "0X8009E17", 0, 0, "", "", (String)localObject, "");
          return;
        }
        ReportController.a(null, "dc00898", "", "", "0X8009E15", "0X8009E15", 0, 0, "", "", (String)localObject, "");
        return;
      }
      ReportController.a(null, "dc00898", "", "", "0X8009E14", "0X8009E14", 0, 0, "", "", (String)localObject, "");
    }
  }
  
  public void a(ArrayList<WadlResult> paramArrayList)
  {
    if (paramArrayList != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ark.dctrl.onQueryCallback:");
      localStringBuilder.append(paramArrayList.toString());
      QLog.i("ark.download.module", 1, localStringBuilder.toString());
    }
    if (ArkAppDownloadModule.a(this.a) != null)
    {
      GameCenterUtil.a(paramArrayList);
      ArkAppDownloadModule.a(this.a).a(paramArrayList);
    }
  }
  
  public void b(ArrayList<WadlResult> paramArrayList)
  {
    if (paramArrayList != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ark.dctrl.onQueryCallbackVia:");
      localStringBuilder.append(paramArrayList.toString());
      QLog.i("ark.download.module", 1, localStringBuilder.toString());
    }
    if (ArkAppDownloadModule.a(this.a) != null)
    {
      GameCenterUtil.a(paramArrayList);
      ArkAppDownloadModule.a(this.a).a(paramArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkAppDownloadModule.6
 * JD-Core Version:    0.7.0.1
 */
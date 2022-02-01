package com.tencent.avgame.gamelogic.gameres;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.springfestival.report.ReportConstant.Event;
import com.tencent.mobileqq.activity.springfestival.report.ReportConstant.Res;
import com.tencent.mobileqq.activity.springfestival.report.SpringHbReporter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletApi;
import java.util.HashMap;
import java.util.Map;

final class CJPreloadMonitorReporter$5
  implements Runnable
{
  CJPreloadMonitorReporter$5(String paramString, int paramInt) {}
  
  public void run()
  {
    if (CJPreloadMonitorReporter.a(this.a))
    {
      String str = ((IQWalletApi)QRoute.api(IQWalletApi.class)).getEncodeUrl(this.a);
      if (!TextUtils.isEmpty(str))
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("ext1", str);
        SpringHbReporter.a(ReportConstant.Event.a, 4, this.b, localHashMap, ReportConstant.Res.a(4));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.gameres.CJPreloadMonitorReporter.5
 * JD-Core Version:    0.7.0.1
 */
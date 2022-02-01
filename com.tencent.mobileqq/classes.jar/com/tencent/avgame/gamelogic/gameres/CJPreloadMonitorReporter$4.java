package com.tencent.avgame.gamelogic.gameres;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.springfestival.report.ReportConstant.Event;
import com.tencent.mobileqq.activity.springfestival.report.ReportConstant.Res;
import com.tencent.mobileqq.activity.springfestival.report.SpringHbReporter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletApi;
import java.util.HashMap;
import java.util.Map;

final class CJPreloadMonitorReporter$4
  implements Runnable
{
  CJPreloadMonitorReporter$4(String paramString, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (CJPreloadMonitorReporter.a(this.a))
    {
      Object localObject = ((IQWalletApi)QRoute.api(IQWalletApi.class)).getEncodeUrl(this.a);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("ext1", localObject);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(CJPreloadMonitorReporter.a(721));
        ((StringBuilder)localObject).append("");
        localHashMap.put("ext2", ((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(CJPreloadMonitorReporter.c(721));
        ((StringBuilder)localObject).append("");
        localHashMap.put("ext3", ((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.b);
        ((StringBuilder)localObject).append("");
        localHashMap.put("ext4", ((StringBuilder)localObject).toString());
        SpringHbReporter.a(ReportConstant.Event.a, 3, this.c, localHashMap, ReportConstant.Res.a(3));
      }
      if (this.c == 0) {
        return;
      }
      int i = this.b;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.gameres.CJPreloadMonitorReporter.4
 * JD-Core Version:    0.7.0.1
 */
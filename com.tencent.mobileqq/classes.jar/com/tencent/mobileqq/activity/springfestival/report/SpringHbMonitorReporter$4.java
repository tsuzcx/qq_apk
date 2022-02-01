package com.tencent.mobileqq.activity.springfestival.report;

import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletApi;
import java.util.HashMap;
import java.util.Map;

final class SpringHbMonitorReporter$4
  implements Runnable
{
  SpringHbMonitorReporter$4(String paramString, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (SpringHbMonitorReporter.a(this.a))
    {
      Object localObject1 = ((IQWalletApi)QRoute.api(IQWalletApi.class)).getEncodeUrl(this.a);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(SpringHbMonitorReporter.a(719));
      ((StringBuilder)localObject2).append("");
      localObject2 = ((StringBuilder)localObject2).toString();
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(SpringHbMonitorReporter.c(719));
      ((StringBuilder)localObject3).append("");
      localObject3 = ((StringBuilder)localObject3).toString();
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("ext1", localObject1);
        localHashMap.put("ext2", localObject2);
        localHashMap.put("ext3", localObject3);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.b);
        ((StringBuilder)localObject1).append("");
        localHashMap.put("ext4", ((StringBuilder)localObject1).toString());
        SpringHbReporter.a(ReportConstant.Event.a, 3, this.c, localHashMap, ReportConstant.Res.a(3));
      }
      if (this.c == 0)
      {
        SpringHbMonitorReporter.a();
        return;
      }
      if (this.b == 404) {
        SpringHbMonitorReporter.a(this.a, 1, true, (String)localObject2, (String)localObject3);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.report.SpringHbMonitorReporter.4
 * JD-Core Version:    0.7.0.1
 */
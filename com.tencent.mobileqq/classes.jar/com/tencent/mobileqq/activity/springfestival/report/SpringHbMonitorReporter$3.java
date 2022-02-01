package com.tencent.mobileqq.activity.springfestival.report;

import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletApi;
import com.tencent.mobileqq.qwallet.preload.IPreloadModule;
import com.tencent.mobileqq.qwallet.preload.IPreloadResource;
import com.tencent.mobileqq.qwallet.preload.IPreloadService;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

final class SpringHbMonitorReporter$3
  implements Runnable
{
  SpringHbMonitorReporter$3(boolean paramBoolean) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i("shua2021report_SpringHbMonitorReporter", 2, "[checkResCover] start");
    }
    Object localObject1 = ((IQWalletApi)QRoute.api(IQWalletApi.class)).getQQAppInterface();
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = (IPreloadService)((BaseQQAppInterface)localObject1).getRuntimeService(IPreloadService.class, "");
    if (localObject2 != null)
    {
      localObject2 = ((IPreloadService)localObject2).getModuleByName("2021_shuayishua");
      if (localObject2 != null)
      {
        Object localObject3 = ((IPreloadModule)localObject2).getResApiList();
        if (((List)localObject3).size() > 0)
        {
          localObject3 = ((List)localObject3).iterator();
          boolean bool = true;
          int i = 0;
          while (((Iterator)localObject3).hasNext()) {
            if (!((IPreloadResource)((Iterator)localObject3).next()).isResFileExist((IPreloadModule)localObject2)) {
              bool = false;
            } else {
              i += 1;
            }
          }
          SpringHbMonitorReporter.a(bool, i, (AppInterface)localObject1, this.a);
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[checkResCover] finished cost:");
      ((StringBuilder)localObject1).append(System.currentTimeMillis() - l);
      QLog.i("shua2021report_SpringHbMonitorReporter", 2, ((StringBuilder)localObject1).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.report.SpringHbMonitorReporter.3
 * JD-Core Version:    0.7.0.1
 */
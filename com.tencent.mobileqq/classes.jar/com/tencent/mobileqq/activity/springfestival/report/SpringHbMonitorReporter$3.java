package com.tencent.mobileqq.activity.springfestival.report;

import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.app.QQAppInterface;
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
    QQAppInterface localQQAppInterface = QWalletTools.a();
    if (localQQAppInterface == null) {}
    do
    {
      return;
      Object localObject1 = (IPreloadService)localQQAppInterface.getRuntimeService(IPreloadService.class, "");
      if (localObject1 != null)
      {
        localObject1 = ((IPreloadService)localObject1).getModuleByName("2021_shuayishua");
        if (localObject1 != null)
        {
          Object localObject2 = ((IPreloadModule)localObject1).getResApiList();
          if (((List)localObject2).size() > 0)
          {
            localObject2 = ((List)localObject2).iterator();
            int i = 0;
            boolean bool = true;
            if (((Iterator)localObject2).hasNext())
            {
              if (!((IPreloadResource)((Iterator)localObject2).next()).isResFileExist((IPreloadModule)localObject1)) {
                bool = false;
              }
              for (;;)
              {
                break;
                i += 1;
              }
            }
            SpringHbMonitorReporter.a(bool, i, localQQAppInterface, this.a);
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.i("shua2021report_SpringHbMonitorReporter", 2, "[checkResCover] finished cost:" + (System.currentTimeMillis() - l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.report.SpringHbMonitorReporter.3
 * JD-Core Version:    0.7.0.1
 */
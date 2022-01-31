package com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.report;

import ahia;
import ahiw;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadModule;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadResource;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public final class SpringHbMonitorReporter$3
  implements Runnable
{
  public SpringHbMonitorReporter$3(boolean paramBoolean) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i("springHb_report_SpringHbMonitorReporter", 2, "[checkResCover] start");
    }
    QQAppInterface localQQAppInterface = ahiw.a();
    if (localQQAppInterface == null) {}
    do
    {
      return;
      Object localObject1 = (PreloadManager)localQQAppInterface.getManager(151);
      if (localObject1 != null)
      {
        localObject1 = ((PreloadManager)localObject1).a("2020_red_packet");
        if (localObject1 != null)
        {
          Object localObject2 = ((PreloadModule)localObject1).getResList();
          if (((List)localObject2).size() > 0)
          {
            localObject2 = ((List)localObject2).iterator();
            int i = 0;
            boolean bool = true;
            if (((Iterator)localObject2).hasNext())
            {
              if (!((PreloadResource)((Iterator)localObject2).next()).isResFileExist((PreloadModule)localObject1)) {
                bool = false;
              }
              for (;;)
              {
                break;
                i += 1;
              }
            }
            ahia.a(bool, i, localQQAppInterface, this.a);
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.i("springHb_report_SpringHbMonitorReporter", 2, "[checkResCover] finished cost:" + (System.currentTimeMillis() - l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.report.SpringHbMonitorReporter.3
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity.qcircle;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import feedcloud.FeedCloudCommon.Entry;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import mqq.app.AppRuntime;

class QCircleThirdTabConfig$1
  implements Runnable
{
  QCircleThirdTabConfig$1(QCircleThirdTabConfig paramQCircleThirdTabConfig, AppRuntime paramAppRuntime) {}
  
  public void run()
  {
    long l1 = System.currentTimeMillis();
    try
    {
      if (!(this.a instanceof AppInterface))
      {
        QLog.d("QCircleThirdTabConfig", 1, "appRuntime  illegal");
        return;
      }
      if (TextUtils.isEmpty(this.a.getAccount()))
      {
        QLog.d("QCircleThirdTabConfig", 1, "account is empty");
        return;
      }
      long l2 = System.currentTimeMillis();
      QzoneConfig.getInstance().loadAllConfigs();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("load config costTime ");
      ((StringBuilder)localObject).append(System.currentTimeMillis() - l2);
      QLog.d("QCircleThirdTabConfig", 1, ((StringBuilder)localObject).toString());
      if (QCircleThirdTabConfig.a(this.this$0))
      {
        QLog.d("QCircleThirdTabConfig", 1, "hasLocalRecord directly notify");
        QCircleThirdTabConfig.b(this.this$0);
        return;
      }
      localObject = new CountDownLatch(1);
      QCircleThirdTabConfig.a(this.this$0, (CountDownLatch)localObject);
      ((CountDownLatch)localObject).await(1L, TimeUnit.SECONDS);
      QCircleThirdTabConfig.b(this.this$0);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QCircleThirdTabConfig.b(this.this$0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("request exception notify kanDianTab:");
      localStringBuilder.append(localException.getMessage());
      QLog.d("QCircleThirdTabConfig", 1, localStringBuilder.toString());
      QCircleThirdTabConfig localQCircleThirdTabConfig = this.this$0;
      QCircleThirdTabConfig.a(localQCircleThirdTabConfig, "EVENT_FETCH_QCIRCLE_THIRD_TAB_CONFIG", Arrays.asList(new FeedCloudCommon.Entry[] { QCircleThirdTabConfig.a(localQCircleThirdTabConfig, "ret_code", "5"), QCircleThirdTabConfig.a(this.this$0, "time_cost", String.valueOf(System.currentTimeMillis() - l1)) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qcircle.QCircleThirdTabConfig.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity.springfestival.config;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.springfestival.report.SpringHbMonitorReporter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.qwallet.preload.IPreloadService;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;

public class SpringFestivalRedpacketPreloadConfProcessor
  extends SpringFestivalBaseConfProcessor<SpringFestivalRedpacketPreloadConfBean>
{
  @NonNull
  public SpringFestivalRedpacketPreloadConfBean a(int paramInt)
  {
    return new SpringFestivalRedpacketPreloadConfBean();
  }
  
  protected SpringFestivalRedpacketPreloadConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      paramArrayOfQConfItem = paramArrayOfQConfItem[0].a;
      if (QLog.isColorLevel()) {
        QLog.i("shua2021_SpringFestivalRedpacketPreloadConfProcessor", 2, String.format("onParsed %s", new Object[] { paramArrayOfQConfItem }));
      }
      return SpringFestivalRedpacketPreloadConfBean.a(paramArrayOfQConfItem);
    }
    return null;
  }
  
  public void a(SpringFestivalRedpacketPreloadConfBean paramSpringFestivalRedpacketPreloadConfBean)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("shua2021_SpringFestivalRedpacketPreloadConfProcessor", 2, String.format("onUpdate %s", new Object[] { paramSpringFestivalRedpacketPreloadConfBean }));
      }
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (localQQAppInterface != null)
      {
        IPreloadService localIPreloadService = (IPreloadService)localQQAppInterface.getRuntimeService(IPreloadService.class, "");
        if (localIPreloadService != null)
        {
          localIPreloadService.replaceConfig(paramSpringFestivalRedpacketPreloadConfBean.a, 2);
          localIPreloadService.savePreloadConfig();
          localIPreloadService.startCheckConfig(true);
        }
        SpringHbMonitorReporter.a();
        if ((paramSpringFestivalRedpacketPreloadConfBean.a != null) && (paramSpringFestivalRedpacketPreloadConfBean.a.length() > 0))
        {
          SpringHbMonitorReporter.a(localQQAppInterface, 1, 0, type(), SpringHbMonitorReporter.a(type()), QConfigManager.a().a(type(), localQQAppInterface.getCurrentAccountUin()), true, SpringHbMonitorReporter.a(type()));
          return;
        }
      }
    }
    catch (Throwable paramSpringFestivalRedpacketPreloadConfBean)
    {
      QLog.e("shua2021_SpringFestivalRedpacketPreloadConfProcessor", 1, QLog.getStackTraceString(paramSpringFestivalRedpacketPreloadConfBean));
    }
  }
  
  @Nullable
  public SpringFestivalRedpacketPreloadConfBean b(QConfItem[] paramArrayOfQConfItem)
  {
    return (SpringFestivalRedpacketPreloadConfBean)super.onParsed(paramArrayOfQConfItem);
  }
  
  public Class<SpringFestivalRedpacketPreloadConfBean> clazz()
  {
    return SpringFestivalRedpacketPreloadConfBean.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqNoReceive()
  {
    super.onReqNoReceive();
    if (QLog.isColorLevel()) {
      QLog.i("shua2021_SpringFestivalRedpacketPreloadConfProcessor", 2, "onReqNoReceive:");
    }
    SpringHbMonitorReporter.a();
  }
  
  public int type()
  {
    return 719;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.config.SpringFestivalRedpacketPreloadConfProcessor
 * JD-Core Version:    0.7.0.1
 */
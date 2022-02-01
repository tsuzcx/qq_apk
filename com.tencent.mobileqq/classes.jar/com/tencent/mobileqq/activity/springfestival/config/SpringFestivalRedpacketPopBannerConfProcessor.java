package com.tencent.mobileqq.activity.springfestival.config;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;

public class SpringFestivalRedpacketPopBannerConfProcessor
  extends SpringFestivalBaseConfProcessor<SpringFestivalRedpacketPopBannerConfBean>
{
  @NonNull
  public SpringFestivalRedpacketPopBannerConfBean a(int paramInt)
  {
    return new SpringFestivalRedpacketPopBannerConfBean();
  }
  
  public void a(SpringFestivalRedpacketPopBannerConfBean paramSpringFestivalRedpacketPopBannerConfBean)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("shua2021_SpringFestivalRedpacketPopBannerConfProcessor", 2, String.format("onUpdate %s", new Object[] { paramSpringFestivalRedpacketPopBannerConfBean }));
      }
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (localQQAppInterface != null)
      {
        int i = QConfigManager.b().a(723, localQQAppInterface.getCurrentAccountUin());
        ((SpringFestivalRedpacketConfigManager)localQQAppInterface.getManager(QQManagerFactory.SPRING_FESTIVAL_RED_PACKET_MANAGER)).a(i, paramSpringFestivalRedpacketPopBannerConfBean);
      }
      super.onUpdate(paramSpringFestivalRedpacketPopBannerConfBean);
      return;
    }
    catch (Throwable paramSpringFestivalRedpacketPopBannerConfBean)
    {
      QLog.e("shua2021_SpringFestivalRedpacketPopBannerConfProcessor", 1, QLog.getStackTraceString(paramSpringFestivalRedpacketPopBannerConfBean));
    }
  }
  
  protected SpringFestivalRedpacketPopBannerConfBean b(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      paramArrayOfQConfItem = paramArrayOfQConfItem[0].b;
      if (QLog.isColorLevel()) {
        QLog.i("shua2021_SpringFestivalRedpacketPopBannerConfProcessor", 2, String.format("onParsed %s", new Object[] { paramArrayOfQConfItem }));
      }
      return SpringFestivalRedpacketPopBannerConfBean.a(paramArrayOfQConfItem);
    }
    return null;
  }
  
  @Nullable
  public SpringFestivalRedpacketPopBannerConfBean c(QConfItem[] paramArrayOfQConfItem)
  {
    return (SpringFestivalRedpacketPopBannerConfBean)super.onParsed(paramArrayOfQConfItem);
  }
  
  public Class<SpringFestivalRedpacketPopBannerConfBean> clazz()
  {
    return SpringFestivalRedpacketPopBannerConfBean.class;
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
  
  public int type()
  {
    return 723;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.config.SpringFestivalRedpacketPopBannerConfProcessor
 * JD-Core Version:    0.7.0.1
 */
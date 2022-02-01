package com.tencent.mobileqq.activity.aio.stickerrecommended.ad;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class AdEmoConfigProcessor
  extends IQConfigProcessor<AdEmoConfigBean>
{
  public AppInterface a()
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getApp, runtime is null ?  ");
      boolean bool;
      if (localAppRuntime == null) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      localStringBuilder.append(" , runtime instanceof QQAppInterface ? ");
      localStringBuilder.append(localAppRuntime instanceof AppInterface);
      QLog.d("AdEmoConfigProcessor", 2, localStringBuilder.toString());
    }
    if ((localAppRuntime instanceof AppInterface)) {
      return (AppInterface)localAppRuntime;
    }
    return null;
  }
  
  @NonNull
  public AdEmoConfigBean a(int paramInt)
  {
    return new AdEmoConfigBean();
  }
  
  @Nullable
  public AdEmoConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      AdEmoConfigBean localAdEmoConfigBean = AdEmoConfigBean.a(paramArrayOfQConfItem[0].a);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onParsed ");
        localStringBuilder.append(paramArrayOfQConfItem[0].a);
        QLog.d("AdEmoConfigProcessor", 2, localStringBuilder.toString());
      }
      return localAdEmoConfigBean;
    }
    return null;
  }
  
  public void a(AdEmoConfigBean paramAdEmoConfigBean)
  {
    AppInterface localAppInterface = a();
    if (localAppInterface != null)
    {
      String str = localAppInterface.getCurrentUin();
      AdEmoCfgProvider.a(localAppInterface.getApp(), str, paramAdEmoConfigBean.a);
    }
  }
  
  public Class<AdEmoConfigBean> clazz()
  {
    return AdEmoConfigBean.class;
  }
  
  public boolean isAccountRelated()
  {
    return super.isAccountRelated();
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
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 657;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.ad.AdEmoConfigProcessor
 * JD-Core Version:    0.7.0.1
 */
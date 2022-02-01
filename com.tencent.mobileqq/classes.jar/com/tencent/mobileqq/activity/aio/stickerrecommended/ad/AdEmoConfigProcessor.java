package com.tencent.mobileqq.activity.aio.stickerrecommended.ad;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class AdEmoConfigProcessor
  extends IQConfigProcessor<AdEmoConfigBean>
{
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
      if (QLog.isColorLevel()) {
        QLog.d("AdEmoConfigProcessor", 2, "onParsed " + paramArrayOfQConfItem[0].a);
      }
      return localAdEmoConfigBean;
    }
    return null;
  }
  
  public QQAppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("getApp, runtime is null ?  ");
      if (localAppRuntime != null) {
        break label70;
      }
    }
    label70:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("AdEmoConfigProcessor", 2, bool + " , runtime instanceof QQAppInterface ? " + (localAppRuntime instanceof QQAppInterface));
      if (!(localAppRuntime instanceof QQAppInterface)) {
        break;
      }
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public void a(AdEmoConfigBean paramAdEmoConfigBean)
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface != null)
    {
      String str = localQQAppInterface.getCurrentUin();
      AdEmoCfgProvider.a(localQQAppInterface.getApp(), str, paramAdEmoConfigBean.a);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.ad.AdEmoConfigProcessor
 * JD-Core Version:    0.7.0.1
 */
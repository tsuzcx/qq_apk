package com.tencent.mobileqq.activity.qqsettingme.config;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;

public class QQSettingMeMenuConfigProcessor
  extends IQConfigProcessor<QQSettingMeMenuConfigBean>
{
  @NonNull
  public QQSettingMeMenuConfigBean a(int paramInt)
  {
    return new QQSettingMeMenuConfigBean();
  }
  
  @Nullable
  public QQSettingMeMenuConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return QQSettingMeMenuConfigBean.a(paramArrayOfQConfItem);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, "QQSettingMeMenuConfigProcessor#onParsed, confFiles is empty!");
    }
    return null;
  }
  
  public void a(QQSettingMeMenuConfigBean paramQQSettingMeMenuConfigBean) {}
  
  public Class<QQSettingMeMenuConfigBean> clazz()
  {
    return QQSettingMeMenuConfigBean.class;
  }
  
  public boolean isAccountRelated()
  {
    return false;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedReloadConf()
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
    return 743;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.config.QQSettingMeMenuConfigProcessor
 * JD-Core Version:    0.7.0.1
 */
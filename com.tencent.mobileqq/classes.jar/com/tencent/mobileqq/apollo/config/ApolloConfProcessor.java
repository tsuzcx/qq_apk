package com.tencent.mobileqq.apollo.config;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;

public class ApolloConfProcessor
  extends IQConfigProcessor<ApolloConfBean>
{
  public static void a()
  {
    ApolloConfBean localApolloConfBean = (ApolloConfBean)QConfigManager.a().a(67);
    ApolloConfBean.a(BaseApplicationImpl.getApplication().getRuntime(), false, localApolloConfBean);
  }
  
  public static void b()
  {
    int i = QConfigManager.a().a(67, "");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resetApolloConfVersion localVersion:");
    localStringBuilder.append(i);
    QLog.w("[cmshow]ApolloConfig_GlobalProcessor", 1, localStringBuilder.toString());
    QConfigManager.a().a(67, 0);
  }
  
  @NonNull
  public ApolloConfBean a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("migrateOldOrDefaultContent type:");
    localStringBuilder.append(paramInt);
    QLog.w("[cmshow]ApolloConfig_GlobalProcessor", 1, localStringBuilder.toString());
    if (paramInt == 1) {
      return new ApolloConfBean();
    }
    ApolloConfBean.a();
    return new ApolloConfBean();
  }
  
  @Nullable
  public ApolloConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    return ApolloConfBean.a(paramArrayOfQConfItem);
  }
  
  public void a(ApolloConfBean paramApolloConfBean)
  {
    QLog.w("[cmshow]ApolloConfig_GlobalProcessor", 1, "onUpdate");
    ApolloConfBean.a(BaseApplicationImpl.getApplication().getRuntime(), true, paramApolloConfBean);
  }
  
  public Class<ApolloConfBean> clazz()
  {
    return ApolloConfBean.class;
  }
  
  public boolean isAccountRelated()
  {
    return false;
  }
  
  public boolean isNeedCompressed()
  {
    return false;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return true;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReqFailed: ");
    localStringBuilder.append(paramInt);
    QLog.e("[cmshow]ApolloConfig_GlobalProcessor", 1, localStringBuilder.toString());
  }
  
  public void onReqNoReceive()
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloConfig_GlobalProcessor", 2, "onReqNoReceive");
    }
  }
  
  public int type()
  {
    return 67;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.config.ApolloConfProcessor
 * JD-Core Version:    0.7.0.1
 */
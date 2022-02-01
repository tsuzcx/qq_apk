package com.tencent.mobileqq.apollo.config;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.api.model.ApolloConfBean;
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
    ApolloConfBean.parseApolloConfBean(BaseApplicationImpl.getApplication().getRuntime(), false, localApolloConfBean);
  }
  
  public static void b()
  {
    int i = QConfigManager.a().a(67, "");
    QLog.w("ApolloConfig_GlobalProcessor", 1, "resetApolloConfVersion localVersion:" + i);
    QConfigManager.a().a(67, 0);
  }
  
  @NonNull
  public ApolloConfBean a(int paramInt)
  {
    QLog.w("ApolloConfig_GlobalProcessor", 1, "migrateOldOrDefaultContent type:" + paramInt);
    if (paramInt == 1) {
      return new ApolloConfBean();
    }
    ApolloConfBean.rollbackConfig();
    return new ApolloConfBean();
  }
  
  @Nullable
  public ApolloConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    return ApolloConfBean.parse(paramArrayOfQConfItem);
  }
  
  public void a(ApolloConfBean paramApolloConfBean)
  {
    QLog.w("ApolloConfig_GlobalProcessor", 1, "onUpdate");
    ApolloConfBean.parseApolloConfBean(BaseApplicationImpl.getApplication().getRuntime(), true, paramApolloConfBean);
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
    QLog.e("ApolloConfig_GlobalProcessor", 1, "onReqFailed: " + paramInt);
  }
  
  public void onReqNoReceive()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloConfig_GlobalProcessor", 2, "onReqNoReceive");
    }
  }
  
  public int type()
  {
    return 67;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.config.ApolloConfProcessor
 * JD-Core Version:    0.7.0.1
 */
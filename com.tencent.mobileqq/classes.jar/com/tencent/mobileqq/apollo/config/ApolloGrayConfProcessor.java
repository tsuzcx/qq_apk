package com.tencent.mobileqq.apollo.config;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;

public class ApolloGrayConfProcessor
  extends IQConfigProcessor<ApolloGrayConfBean>
{
  public static void a()
  {
    ApolloGrayConfBean localApolloGrayConfBean = (ApolloGrayConfBean)QConfigManager.a().a(430);
    ApolloGrayConfBean.a(BaseApplicationImpl.getApplication().getRuntime(), false, localApolloGrayConfBean);
  }
  
  @NonNull
  public ApolloGrayConfBean a(int paramInt)
  {
    return new ApolloGrayConfBean();
  }
  
  @Nullable
  public ApolloGrayConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    return ApolloGrayConfBean.a(paramArrayOfQConfItem);
  }
  
  public void a(ApolloGrayConfBean paramApolloGrayConfBean)
  {
    QLog.w("[cmshow]ApolloConfig_GrayProcessor", 1, "onUpdate");
    ApolloGrayConfBean.a(BaseApplicationImpl.getApplication().getRuntime(), true, paramApolloGrayConfBean);
  }
  
  public Class<ApolloGrayConfBean> clazz()
  {
    return ApolloGrayConfBean.class;
  }
  
  public boolean isAccountRelated()
  {
    return true;
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
  
  public void onReqFailed(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReqFailed: ");
    localStringBuilder.append(paramInt);
    QLog.e("[cmshow]ApolloConfig_GrayProcessor", 1, localStringBuilder.toString());
  }
  
  public int type()
  {
    return 430;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.config.ApolloGrayConfProcessor
 * JD-Core Version:    0.7.0.1
 */
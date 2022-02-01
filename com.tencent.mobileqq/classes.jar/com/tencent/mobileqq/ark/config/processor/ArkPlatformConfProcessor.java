package com.tencent.mobileqq.ark.config.processor;

import android.support.annotation.NonNull;
import com.tencent.ark.open.ArkAppConfigMgr;
import com.tencent.mobileqq.ark.config.bean.ArkPlatformConfigBean;
import com.tencent.mobileqq.ark.config.config.ArkPlatformConfig;
import com.tencent.mobileqq.ark.config.config.ArkPlatformConfigParser;
import com.tencent.mobileqq.ark.util.ArkAppCrashProtect;
import com.tencent.mobileqq.config.QStorage;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

public class ArkPlatformConfProcessor
  extends ArkConfProcessor<ArkPlatformConfigBean>
{
  @NonNull
  public ArkPlatformConfigBean a(int paramInt)
  {
    return new ArkPlatformConfigBean();
  }
  
  public ArkPlatformConfigBean a(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onParsed] type=");
    ((StringBuilder)localObject).append(type());
    ((StringBuilder)localObject).append(", content = ");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("ArkApp.ConfProcessor", 1, ((StringBuilder)localObject).toString());
    ArkPlatformConfig localArkPlatformConfig;
    try
    {
      localObject = (ArkPlatformConfig)QStorage.a(paramString, ArkPlatformConfigParser.class);
    }
    catch (QStorageInstantiateException localQStorageInstantiateException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("readJsonOrXml:");
      localStringBuilder.append(paramString);
      localStringBuilder.append("fail");
      QLog.i("ArkApp.ConfProcessor", 1, localStringBuilder.toString(), localQStorageInstantiateException);
      localArkPlatformConfig = null;
    }
    return new ArkPlatformConfigBean(paramString, localArkPlatformConfig);
  }
  
  public void a(ArkPlatformConfigBean paramArkPlatformConfigBean)
  {
    if (paramArkPlatformConfigBean == null)
    {
      QLog.i("ArkApp.ConfProcessor", 1, "newConf is null");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onUpdate] type=");
    localStringBuilder.append(type());
    localStringBuilder.append(", content = ");
    localStringBuilder.append(paramArkPlatformConfigBean.a());
    QLog.d("ArkApp.ConfProcessor", 1, localStringBuilder.toString());
    ArkAppCrashProtect.a();
    paramArkPlatformConfigBean = paramArkPlatformConfigBean.a();
    if (paramArkPlatformConfigBean == null)
    {
      QLog.i("ArkApp.ConfProcessor", 2, "ArkSafe.updateUrlCheckAndCleanAppUpdateTime error config is null");
      return;
    }
    ArkAppConfigMgr.getInstance().updateUrlCheckAndCleanAppUpdateTime(paramArkPlatformConfigBean.jdField_a_of_type_Boolean, paramArkPlatformConfigBean.b, paramArkPlatformConfigBean.jdField_a_of_type_JavaUtilArrayList);
  }
  
  public Class<ArkPlatformConfigBean> clazz()
  {
    return ArkPlatformConfigBean.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.config.processor.ArkPlatformConfProcessor
 * JD-Core Version:    0.7.0.1
 */
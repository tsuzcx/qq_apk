package com.tencent.mobileqq.ark.config.processor;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.ark.config.bean.ArkAIDictConfBean;
import com.tencent.mobileqq.ark.dict.AIDictConfig;
import com.tencent.mobileqq.ark.dict.DictConfig;
import com.tencent.mobileqq.ark.dict.api.IArkDictManager;
import com.tencent.mobileqq.config.QStorage;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class ArkAIDictConfigProcessor
  extends ArkConfProcessor<ArkAIDictConfBean>
{
  @NonNull
  public ArkAIDictConfBean a(int paramInt)
  {
    return new ArkAIDictConfBean();
  }
  
  public ArkAIDictConfBean a(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onParsed] type=");
    ((StringBuilder)localObject).append(type());
    ((StringBuilder)localObject).append(", content = ");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("ArkApp.ConfProcessor", 1, ((StringBuilder)localObject).toString());
    DictConfig localDictConfig;
    try
    {
      localObject = (AIDictConfig)QStorage.a(paramString, AIDictConfig.class);
    }
    catch (QStorageInstantiateException localQStorageInstantiateException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadConfig:");
      localStringBuilder.append(paramString);
      localStringBuilder.append("fail");
      QLog.i("ArkApp.ConfProcessor", 1, localStringBuilder.toString(), localQStorageInstantiateException);
      localDictConfig = null;
    }
    return new ArkAIDictConfBean(paramString, localDictConfig);
  }
  
  public void a(ArkAIDictConfBean paramArkAIDictConfBean)
  {
    if (paramArkAIDictConfBean == null)
    {
      QLog.i("ArkApp.ConfProcessor", 1, "newConf is null");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onUpdate] type=");
    localStringBuilder.append(type());
    localStringBuilder.append(", content = ");
    localStringBuilder.append(paramArkAIDictConfBean.d());
    QLog.d("ArkApp.ConfProcessor", 1, localStringBuilder.toString());
    ((IArkDictManager)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IArkDictManager.class, "")).updateLocalDict();
  }
  
  public Class<ArkAIDictConfBean> clazz()
  {
    return ArkAIDictConfBean.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.config.processor.ArkAIDictConfigProcessor
 * JD-Core Version:    0.7.0.1
 */
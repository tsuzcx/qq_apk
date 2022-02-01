package com.tencent.mobileqq.ark.config.processor;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.ark.config.bean.ArkMsgAIDisableConfBean;
import com.tencent.mobileqq.ark.config.config.ArkMsgAIDisableConfig;
import com.tencent.mobileqq.config.QStorage;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

public class ArkMsgAIDisableConfProcessor
  extends ArkConfProcessor<ArkMsgAIDisableConfBean>
{
  @NonNull
  public ArkMsgAIDisableConfBean a(int paramInt)
  {
    return new ArkMsgAIDisableConfBean();
  }
  
  public ArkMsgAIDisableConfBean a(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onParsed] type=");
    ((StringBuilder)localObject).append(type());
    ((StringBuilder)localObject).append(", content = ");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("ArkApp.ConfProcessor", 1, ((StringBuilder)localObject).toString());
    ArkMsgAIDisableConfig localArkMsgAIDisableConfig;
    try
    {
      localObject = (ArkMsgAIDisableConfig)QStorage.a(paramString, ArkMsgAIDisableConfig.class);
    }
    catch (QStorageInstantiateException localQStorageInstantiateException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadConfig:");
      localStringBuilder.append(paramString);
      localStringBuilder.append("fail");
      QLog.i("ArkApp.ConfProcessor", 1, localStringBuilder.toString(), localQStorageInstantiateException);
      localArkMsgAIDisableConfig = null;
    }
    return new ArkMsgAIDisableConfBean(paramString, localArkMsgAIDisableConfig);
  }
  
  public void a(ArkMsgAIDisableConfBean paramArkMsgAIDisableConfBean)
  {
    if (paramArkMsgAIDisableConfBean == null) {
      QLog.i("ArkApp.ConfProcessor", 1, "ArkMsgAIDisableConfProcessor.onUpdate, conf is null");
    }
  }
  
  public Class<ArkMsgAIDisableConfBean> clazz()
  {
    return ArkMsgAIDisableConfBean.class;
  }
  
  public boolean isAccountRelated()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.config.processor.ArkMsgAIDisableConfProcessor
 * JD-Core Version:    0.7.0.1
 */
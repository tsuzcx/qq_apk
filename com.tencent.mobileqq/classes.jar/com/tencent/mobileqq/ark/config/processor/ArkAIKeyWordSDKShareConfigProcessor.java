package com.tencent.mobileqq.ark.config.processor;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.ark.config.bean.ArkAIKeyWordSDKShareConfBean;
import com.tencent.mobileqq.ark.config.config.ArkAIKeyWordSDKShareConfig;
import com.tencent.mobileqq.config.QStorage;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

public class ArkAIKeyWordSDKShareConfigProcessor
  extends ArkConfProcessor<ArkAIKeyWordSDKShareConfBean>
{
  @NonNull
  public ArkAIKeyWordSDKShareConfBean a(int paramInt)
  {
    return new ArkAIKeyWordSDKShareConfBean();
  }
  
  public ArkAIKeyWordSDKShareConfBean a(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onParsed] type=");
    ((StringBuilder)localObject).append(type());
    ((StringBuilder)localObject).append(", content = ");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("ArkApp.ConfProcessor", 1, ((StringBuilder)localObject).toString());
    ArkAIKeyWordSDKShareConfig localArkAIKeyWordSDKShareConfig;
    try
    {
      localObject = (ArkAIKeyWordSDKShareConfig)QStorage.a(paramString, ArkAIKeyWordSDKShareConfig.class);
    }
    catch (QStorageInstantiateException localQStorageInstantiateException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadConfig:");
      localStringBuilder.append(paramString);
      localStringBuilder.append("fail");
      QLog.i("ArkApp.ConfProcessor", 1, localStringBuilder.toString(), localQStorageInstantiateException);
      localArkAIKeyWordSDKShareConfig = null;
    }
    return new ArkAIKeyWordSDKShareConfBean(paramString, localArkAIKeyWordSDKShareConfig);
  }
  
  public void a(ArkAIKeyWordSDKShareConfBean paramArkAIKeyWordSDKShareConfBean) {}
  
  public Class<ArkAIKeyWordSDKShareConfBean> clazz()
  {
    return ArkAIKeyWordSDKShareConfBean.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.config.processor.ArkAIKeyWordSDKShareConfigProcessor
 * JD-Core Version:    0.7.0.1
 */
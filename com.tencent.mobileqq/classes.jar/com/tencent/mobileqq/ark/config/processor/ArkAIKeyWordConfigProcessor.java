package com.tencent.mobileqq.ark.config.processor;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.ark.ArkAiAppCenter;
import com.tencent.mobileqq.ark.config.ArkMsgReplyConfigMgr;
import com.tencent.mobileqq.ark.config.bean.ArkAIKeyWordConfBean;
import com.tencent.mobileqq.ark.config.config.AiKeywordConfig;
import com.tencent.mobileqq.ark.config.config.AiKeywordConfigParser;
import com.tencent.mobileqq.ark.config.config.DialogConfig;
import com.tencent.mobileqq.config.QStorage;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class ArkAIKeyWordConfigProcessor
  extends ArkConfProcessor<ArkAIKeyWordConfBean>
{
  @NonNull
  public ArkAIKeyWordConfBean a(int paramInt)
  {
    return new ArkAIKeyWordConfBean();
  }
  
  public ArkAIKeyWordConfBean a(String paramString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[onParsed] type=");
    ((StringBuilder)localObject1).append(type());
    ((StringBuilder)localObject1).append(", content = ");
    ((StringBuilder)localObject1).append(paramString);
    QLog.d("ArkApp.ConfProcessor", 1, ((StringBuilder)localObject1).toString());
    Object localObject3 = null;
    try
    {
      localObject1 = (AiKeywordConfigParser)QStorage.a(paramString, AiKeywordConfigParser.class);
      try
      {
        DialogConfig localDialogConfig = (DialogConfig)QStorage.a(paramString, DialogConfig.class);
      }
      catch (QStorageInstantiateException localQStorageInstantiateException1) {}
      localStringBuilder = new StringBuilder();
    }
    catch (QStorageInstantiateException localQStorageInstantiateException2)
    {
      localObject1 = null;
    }
    StringBuilder localStringBuilder;
    localStringBuilder.append("loadConfig:");
    localStringBuilder.append(paramString);
    localStringBuilder.append("fail");
    QLog.i("ArkApp.ConfProcessor", 1, localStringBuilder.toString(), localQStorageInstantiateException2);
    Object localObject2 = localObject3;
    return new ArkAIKeyWordConfBean(paramString, (AiKeywordConfig)localObject1, localObject2);
  }
  
  public void a(ArkAIKeyWordConfBean paramArkAIKeyWordConfBean)
  {
    if (paramArkAIKeyWordConfBean == null)
    {
      QLog.i("ArkApp.ConfProcessor", 1, "newConf is null");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onUpdate] type=");
    localStringBuilder.append(type());
    localStringBuilder.append(", content = ");
    localStringBuilder.append(paramArkAIKeyWordConfBean.a());
    QLog.d("ArkApp.ConfProcessor", 1, localStringBuilder.toString());
    ArkAiAppCenter.a(paramArkAIKeyWordConfBean.a());
    try
    {
      paramArkAIKeyWordConfBean = new JSONObject(paramArkAIKeyWordConfBean.a());
      ArkMsgReplyConfigMgr.getInstance().updateConfig(paramArkAIKeyWordConfBean);
      return;
    }
    catch (Exception paramArkAIKeyWordConfBean)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("ArkMsgReplyConfigMgr updateConfig exception:");
      localStringBuilder.append(paramArkAIKeyWordConfBean.getMessage());
      QLog.e("ArkApp.ConfProcessor", 1, localStringBuilder.toString());
    }
  }
  
  public Class<ArkAIKeyWordConfBean> clazz()
  {
    return ArkAIKeyWordConfBean.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.config.processor.ArkAIKeyWordConfigProcessor
 * JD-Core Version:    0.7.0.1
 */
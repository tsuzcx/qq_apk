package com.tencent.aelight.camera.aioeditor.config;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.aelight.camera.aioeditor.capture.util.ConfigSimplifier;
import com.tencent.aelight.camera.aioeditor.capture.util.ConfigSimplifier.ZipConfig;
import com.tencent.aelight.camera.qqstory.api.IQIMPtvTemplateManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;

public class QIMTemplateConfigProcessor
  extends IQConfigProcessor<ConfigSimplifier.ZipConfig>
{
  @NonNull
  public ConfigSimplifier.ZipConfig a(int paramInt)
  {
    return new ConfigSimplifier.ZipConfig();
  }
  
  @Nullable
  public ConfigSimplifier.ZipConfig a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length != 0))
    {
      paramArrayOfQConfItem = paramArrayOfQConfItem[0].b;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleQIMTemplateConfig onParsed, content:");
        localStringBuilder.append(paramArrayOfQConfItem);
        QLog.d("QIMTemplateConfigProcessor", 2, localStringBuilder.toString());
      }
      return new ConfigSimplifier().a(paramArrayOfQConfItem, ((IQIMPtvTemplateManager)QRoute.api(IQIMPtvTemplateManager.class)).getDoodleConfigAbsolutePath(), ((IQIMPtvTemplateManager)QRoute.api(IQIMPtvTemplateManager.class)).getTempFaceConfigZip(), new QIMTemplateConfigProcessor.1(this));
    }
    return null;
  }
  
  public void a(ConfigSimplifier.ZipConfig paramZipConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMTemplateConfigProcessor", 2, "handleQIMTemplateConfig onUpdate");
    }
  }
  
  public Class<ConfigSimplifier.ZipConfig> clazz()
  {
    return ConfigSimplifier.ZipConfig.class;
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
    if (!((IQIMPtvTemplateManager)QRoute.api(IQIMPtvTemplateManager.class)).isConfigFileExist()) {
      return 0;
    }
    return SharedPreUtils.X(BaseApplicationImpl.getContext());
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMTemplateConfigProcessor", 2, "handleQIMTemplateConfig onReqFailed");
    }
  }
  
  public int onSend(int paramInt)
  {
    if (!((IQIMPtvTemplateManager)QRoute.api(IQIMPtvTemplateManager.class)).isConfigFileExist())
    {
      QLog.i("QIMTemplateConfigProcessor", 1, "config file not exist");
      QConfigManager.b().a(307, 0);
      return 0;
    }
    return super.onSend(paramInt);
  }
  
  public int type()
  {
    return 307;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.config.QIMTemplateConfigProcessor
 * JD-Core Version:    0.7.0.1
 */
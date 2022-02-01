package com.tencent.aelight.camera.aioeditor.config;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.aelight.camera.aioeditor.capture.paster.QIMPasterConfigManager;
import com.tencent.aelight.camera.aioeditor.capture.util.ConfigSimplifier;
import com.tencent.aelight.camera.aioeditor.capture.util.ConfigSimplifier.ZipConfig;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class QIMPasterConfigProcessor
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
      paramArrayOfQConfItem = paramArrayOfQConfItem[0].a;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleGetQIMPasterConfig onParsed, content:");
        localStringBuilder.append(paramArrayOfQConfItem);
        QLog.d("QIMStickerConfigProcessor", 2, localStringBuilder.toString());
      }
      return new ConfigSimplifier().a(paramArrayOfQConfItem, QIMPasterConfigManager.a.getAbsolutePath(), "temp_sticker_zip", new QIMPasterConfigProcessor.1(this));
    }
    return null;
  }
  
  public void a(ConfigSimplifier.ZipConfig paramZipConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMStickerConfigProcessor", 2, "handleGetQIMPasterConfig onUpdate");
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
    if (!QIMPasterConfigManager.a()) {
      return 0;
    }
    return SharedPreUtils.C(BaseApplicationImpl.getContext());
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMStickerConfigProcessor", 2, "handleGetQIMPasterConfig onReqFailed");
    }
  }
  
  public int onSend(int paramInt)
  {
    if (!QIMPasterConfigManager.a())
    {
      QLog.i("QIMStickerConfigProcessor", 1, "config file not exist");
      QConfigManager.a().a(304, 0);
      return 0;
    }
    return super.onSend(paramInt);
  }
  
  public int type()
  {
    return 304;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.config.QIMPasterConfigProcessor
 * JD-Core Version:    0.7.0.1
 */
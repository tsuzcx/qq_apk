package com.tencent.aelight.camera.aioeditor.config;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.aelight.camera.aioeditor.capture.util.ConfigSimplifier;
import com.tencent.aelight.camera.aioeditor.capture.util.ConfigSimplifier.ZipConfig;
import com.tencent.aelight.camera.qqstory.api.ICaptureVideoFilterManager;
import com.tencent.aelight.camera.qqstory.api.IVideoFilterTools;
import com.tencent.av.AVPathUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class QIMFilterConfigProcessor
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
        localStringBuilder.append("handleGetQIMFilterConfig onParsed, content:");
        localStringBuilder.append(paramArrayOfQConfItem);
        QLog.d("QIMFilterConfigProcessor", 2, localStringBuilder.toString());
      }
      return new ConfigSimplifier().a(paramArrayOfQConfItem, AVPathUtil.e(), "temp_filter_zip", new QIMFilterConfigProcessor.1(this));
    }
    return null;
  }
  
  public void a(ConfigSimplifier.ZipConfig paramZipConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMFilterConfigProcessor", 2, "handleGetQIMFilterConfig onUpdate");
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((ICaptureVideoFilterManager)QRoute.api(ICaptureVideoFilterManager.class)).getQQFilterConfigpath());
    localStringBuilder.append("filter_config_new.xml");
    if (!new File(localStringBuilder.toString()).exists()) {
      return 0;
    }
    return ((IVideoFilterTools)QRoute.api(IVideoFilterTools.class)).getQQShortVideoFilterConfigVersion(BaseApplicationImpl.getContext());
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMFilterConfigProcessor", 2, "handleGetQIMFilterConfig onReqFailed");
    }
  }
  
  public int onSend(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((ICaptureVideoFilterManager)QRoute.api(ICaptureVideoFilterManager.class)).getQQFilterConfigpath());
    localStringBuilder.append("filter_config_new.xml");
    if (!new File(localStringBuilder.toString()).exists())
    {
      QLog.i("QIMFilterConfigProcessor", 1, "config file not exist");
      QConfigManager.a().a(306, 0);
      return 0;
    }
    return super.onSend(paramInt);
  }
  
  public int type()
  {
    return 306;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.config.QIMFilterConfigProcessor
 * JD-Core Version:    0.7.0.1
 */
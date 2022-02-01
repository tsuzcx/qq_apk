package com.tencent.aelight.camera.aioeditor.config;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.aelight.camera.qqstory.api.IPtvTemplateManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;

public class QIMDoodleConfigProcessor
  extends IQConfigProcessor<Object>
{
  public Class<Object> clazz()
  {
    return Object.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  @NonNull
  public Object migrateOldOrDefaultContent(int paramInt)
  {
    return new Object();
  }
  
  public int migrateOldVersion()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (!((IPtvTemplateManager)QRoute.api(IPtvTemplateManager.class)).isDoodleConfigFileExist()) {
      return 0;
    }
    return SharedPreUtils.q(BaseApplicationImpl.getContext());
  }
  
  @Nullable
  public Object onParsed(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length != 0))
    {
      paramArrayOfQConfItem = paramArrayOfQConfItem[0].b;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleQIMDoodleConfig onParsed, content:");
        ((StringBuilder)localObject).append(paramArrayOfQConfItem);
        QLog.d("QIMDoodleConfigProcessor", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      ((IPtvTemplateManager)QRoute.api(IPtvTemplateManager.class)).handleGetDoodleConfig(paramArrayOfQConfItem, (BaseQQAppInterface)localObject);
      return new Object();
    }
    return null;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMDoodleConfigProcessor", 2, "handleQIMDoodleConfig onReqFailed");
    }
  }
  
  public void onReqNoReceive()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMDoodleConfigProcessor", 2, "handleQIMDoodleConfig onReqNoReceive");
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (((IPtvTemplateManager)QRoute.api(IPtvTemplateManager.class)).hasDownloadFailed()) {
      ((IPtvTemplateManager)QRoute.api(IPtvTemplateManager.class)).initLocalDoodleInfo(localQQAppInterface, null);
    }
  }
  
  public int onSend(int paramInt)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (!((IPtvTemplateManager)QRoute.api(IPtvTemplateManager.class)).isDoodleConfigFileExist())
    {
      QLog.i("QIMDoodleConfigProcessor", 1, "config file not exist");
      QConfigManager.b().a(310, 0);
      return 0;
    }
    return super.onSend(paramInt);
  }
  
  public void onUpdate(Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMDoodleConfigProcessor", 2, "handleQIMDoodleConfig onUpdate");
    }
  }
  
  public int type()
  {
    return 310;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.config.QIMDoodleConfigProcessor
 * JD-Core Version:    0.7.0.1
 */
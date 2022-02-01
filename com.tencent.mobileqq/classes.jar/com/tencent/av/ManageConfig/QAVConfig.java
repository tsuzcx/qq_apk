package com.tencent.av.ManageConfig;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.av.business.manager.BusinessManager;
import com.tencent.av.qavperf.QAVPUtils;
import com.tencent.av.ui.AIOTopRightButtonConfig;
import com.tencent.av.utils.QAVConfigUtils;
import com.tencent.av.utils.QAVPerfTestConfig;
import com.tencent.av.utils.ScoreManager;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.utils.BusinessCommonConfig;
import com.tencent.mobileqq.utils.QAVGroupConfig;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

@KeepClassConstructor
public class QAVConfig
  extends QAVConfigBase<QAVConfItem>
{
  public QAVConfig() {}
  
  public QAVConfig(int paramInt)
  {
    super(paramInt);
  }
  
  public static QAVConfItem b(int paramInt)
  {
    return (QAVConfItem)QConfigManager.b().b(paramInt);
  }
  
  public static int c(int paramInt)
  {
    AppInterface localAppInterface = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
    return QConfigManager.b().a(paramInt, localAppInterface.getCurrentAccountUin());
  }
  
  @NonNull
  public QAVConfItem a(int paramInt)
  {
    if (QLog.isDevelopLevel())
    {
      String str = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("migrateOldOrDefaultContent, type[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    return new QAVConfItem();
  }
  
  @Nullable
  protected QAVConfItem a(QConfItem[] paramArrayOfQConfItem)
  {
    QAVConfItem localQAVConfItem = new QAVConfItem();
    paramArrayOfQConfItem = a(this.a, type(), paramArrayOfQConfItem);
    if (paramArrayOfQConfItem != null) {
      localQAVConfItem.a(paramArrayOfQConfItem.a, paramArrayOfQConfItem.b);
    }
    return localQAVConfItem;
  }
  
  public void a(QAVConfItem paramQAVConfItem)
  {
    super.onUpdate(paramQAVConfItem);
    AppInterface localAppInterface = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (!(localAppInterface instanceof QQAppInterface)) {
      return;
    }
    if (paramQAVConfItem == null) {
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)localAppInterface;
    int i = type();
    if (i != 132)
    {
      if (i != 192)
      {
        if (i != 270)
        {
          if (i != 276)
          {
            if (i != 287)
            {
              if ((i != 367) && (i != 382))
              {
                if (i != 735)
                {
                  if (i != 759) {
                    return;
                  }
                  QAVPUtils.a(localQQAppInterface.getApp(), paramQAVConfItem.b);
                  return;
                }
                QAVPerfTestConfig.a(paramQAVConfItem.b, localAppInterface.getCurrentAccountUin());
                return;
              }
              BusinessCommonConfig.getInstance(localQQAppInterface).decodeConfig(localQQAppInterface, type(), paramQAVConfItem.b);
              return;
            }
            QAVConfigUtils.a(paramQAVConfItem.b);
            return;
          }
          QAVGroupConfig.a(paramQAVConfItem.b);
          return;
        }
        ScoreManager.a(localQQAppInterface, paramQAVConfItem.b, localAppInterface.getCurrentAccountUin());
        return;
      }
      AIOTopRightButtonConfig.a().a(paramQAVConfItem.b);
      return;
    }
    BusinessManager.a(this.a, localQQAppInterface.getApp(), 1, false);
  }
  
  public Class<QAVConfItem> clazz()
  {
    return QAVConfItem.class;
  }
  
  public boolean isAccountRelated()
  {
    int i = type();
    return (i == 192) || (i == 249) || (i == 263) || (i == 382) || (i == 591) || (i == 623) || (i == 735);
  }
  
  public void onProcessorConstructed(int paramInt)
  {
    this.b = paramInt;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QAVConfig_");
    localStringBuilder.append(this.b);
    this.a = localStringBuilder.toString();
  }
  
  public void onReqFailed(int paramInt)
  {
    super.onReqFailed(paramInt);
  }
  
  public void onReqNoReceive()
  {
    super.onReqNoReceive();
    Object localObject = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (!(localObject instanceof QQAppInterface)) {
      return;
    }
    localObject = (QQAppInterface)localObject;
    int i = type();
    if ((i != 367) && (i != 382)) {
      return;
    }
    BusinessCommonConfig.getInstance((AppRuntime)localObject).handleResp_Config_NoResp((QQAppInterface)localObject, type());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ManageConfig.QAVConfig
 * JD-Core Version:    0.7.0.1
 */
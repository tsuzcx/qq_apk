package com.tencent.av.ManageConfig;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.av.business.manager.BusinessManager;
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
  
  public static int a(int paramInt)
  {
    AppInterface localAppInterface = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
    return QConfigManager.a().a(paramInt, localAppInterface.getCurrentAccountUin());
  }
  
  public static QAVConfItem b(int paramInt)
  {
    return (QAVConfItem)QConfigManager.a().a(paramInt);
  }
  
  @NonNull
  public QAVConfItem a(int paramInt)
  {
    if (QLog.isDevelopLevel())
    {
      String str = this.jdField_a_of_type_JavaLangString;
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
    paramArrayOfQConfItem = a(this.jdField_a_of_type_JavaLangString, type(), paramArrayOfQConfItem);
    if (paramArrayOfQConfItem != null) {
      localQAVConfItem.a(paramArrayOfQConfItem.jdField_a_of_type_Int, paramArrayOfQConfItem.jdField_a_of_type_JavaLangString);
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
                if (i != 735) {
                  return;
                }
                QAVPerfTestConfig.a(paramQAVConfItem.jdField_a_of_type_JavaLangString, localAppInterface.getCurrentAccountUin());
                return;
              }
              BusinessCommonConfig.getInstance(localQQAppInterface).decodeConfig(localQQAppInterface, type(), paramQAVConfItem.jdField_a_of_type_JavaLangString);
              return;
            }
            QAVConfigUtils.a(paramQAVConfItem.jdField_a_of_type_JavaLangString);
            return;
          }
          QAVGroupConfig.a(paramQAVConfItem.jdField_a_of_type_JavaLangString);
          return;
        }
        ScoreManager.a(localQQAppInterface, paramQAVConfItem.jdField_a_of_type_JavaLangString, localAppInterface.getCurrentAccountUin());
        return;
      }
      AIOTopRightButtonConfig.a().a(paramQAVConfItem.jdField_a_of_type_JavaLangString);
      return;
    }
    BusinessManager.a(this.jdField_a_of_type_JavaLangString, localQQAppInterface.getApp(), 1, false);
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
    this.jdField_a_of_type_Int = paramInt;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QAVConfig_");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
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
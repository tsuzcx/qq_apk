package com.tencent.av.ManageConfig;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.av.business.manager.BusinessManager;
import com.tencent.av.gameplay.QavGPDownloader;
import com.tencent.av.redpacket.AVRedPacketDataCollector;
import com.tencent.av.redpacket.config.AVRedPacketConfigManager;
import com.tencent.av.ui.AIOTopRightButtonConfig;
import com.tencent.av.utils.QAVConfigUtils;
import com.tencent.av.utils.ScoreManager;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
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
    if (QLog.isDevelopLevel()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "migrateOldOrDefaultContent, type[" + paramInt + "]");
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
    if (!(localAppInterface instanceof QQAppInterface)) {}
    while (paramQAVConfItem == null) {
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)localAppInterface;
    switch (type())
    {
    default: 
      return;
    case 132: 
      BusinessManager.a(this.jdField_a_of_type_JavaLangString, localQQAppInterface.getApp(), 1, false);
      return;
    case 270: 
      ScoreManager.a(localQQAppInterface, paramQAVConfItem.jdField_a_of_type_JavaLangString, localAppInterface.getCurrentAccountUin());
      return;
    case 192: 
      AIOTopRightButtonConfig.a().a(paramQAVConfItem.jdField_a_of_type_JavaLangString);
      return;
    case 249: 
      ((AVRedPacketConfigManager)localQQAppInterface.getManager(QQManagerFactory.AV_REDPACKET_CONFIG_MGR)).b(paramQAVConfItem.jdField_a_of_type_JavaLangString);
      AVRedPacketDataCollector.a(true);
      return;
    case 276: 
      QAVGroupConfig.a(paramQAVConfItem.jdField_a_of_type_JavaLangString);
      return;
    case 287: 
      QAVConfigUtils.a(paramQAVConfItem.jdField_a_of_type_JavaLangString);
      return;
    case 367: 
    case 382: 
      BusinessCommonConfig.getInstance(localQQAppInterface).decodeConfig(localQQAppInterface, type(), paramQAVConfItem.jdField_a_of_type_JavaLangString);
      return;
    }
    QavGPDownloader.a(paramQAVConfItem.jdField_a_of_type_JavaLangString);
  }
  
  public Class<QAVConfItem> clazz()
  {
    return QAVConfItem.class;
  }
  
  public boolean isAccountRelated()
  {
    switch (type())
    {
    default: 
      return false;
    }
    return true;
  }
  
  public void onProcessorConstructed(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = ("QAVConfig_" + this.jdField_a_of_type_Int);
  }
  
  public void onReqFailed(int paramInt)
  {
    super.onReqFailed(paramInt);
    Object localObject = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (!(localObject instanceof QQAppInterface)) {
      return;
    }
    localObject = (QQAppInterface)localObject;
    switch (type())
    {
    default: 
      return;
    }
    ((AVRedPacketConfigManager)((QQAppInterface)localObject).getManager(QQManagerFactory.AV_REDPACKET_CONFIG_MGR)).c();
  }
  
  public void onReqNoReceive()
  {
    super.onReqNoReceive();
    Object localObject = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (!(localObject instanceof QQAppInterface)) {
      return;
    }
    localObject = (QQAppInterface)localObject;
    switch (type())
    {
    default: 
      return;
    case 249: 
      ((AVRedPacketConfigManager)((QQAppInterface)localObject).getManager(QQManagerFactory.AV_REDPACKET_CONFIG_MGR)).c();
      return;
    }
    BusinessCommonConfig.getInstance((AppRuntime)localObject).handleResp_Config_NoResp((QQAppInterface)localObject, type());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ManageConfig.QAVConfig
 * JD-Core Version:    0.7.0.1
 */
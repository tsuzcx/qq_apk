package com.tencent.mobileqq.activity.recent.msgbox;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class TempMsgBoxConfigProcessor
  extends IQConfigProcessor<TempMsgBoxConfigData>
{
  @NonNull
  public TempMsgBoxConfigData a(int paramInt)
  {
    return new TempMsgBoxConfigData();
  }
  
  @Nullable
  public TempMsgBoxConfigData a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TempMsgBoxConfigProcessor", 2, "onParsed : " + paramArrayOfQConfItem[0].a);
      }
      return TempMsgBoxConfigData.a(paramArrayOfQConfItem[0].a);
    }
    return new TempMsgBoxConfigData();
  }
  
  public void a(TempMsgBoxConfigData paramTempMsgBoxConfigData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TempMsgBoxConfigProcessor", 2, "onUpdate : " + paramTempMsgBoxConfigData);
    }
    ((TempMsgBoxManager)BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.TEMP_MSG_BOX)).a(paramTempMsgBoxConfigData);
  }
  
  public Class<TempMsgBoxConfigData> clazz()
  {
    return TempMsgBoxConfigData.class;
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
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TempMsgBoxConfigProcessor", 2, "onReqFailed : " + paramInt);
    }
  }
  
  public int type()
  {
    return 704;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msgbox.TempMsgBoxConfigProcessor
 * JD-Core Version:    0.7.0.1
 */
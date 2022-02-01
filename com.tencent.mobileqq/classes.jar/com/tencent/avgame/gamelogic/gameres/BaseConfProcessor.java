package com.tencent.avgame.gamelogic.gameres;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.QConfigureException;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;

public abstract class BaseConfProcessor<T>
  extends IQConfigProcessor<T>
{
  protected abstract T a(QConfItem[] paramArrayOfQConfItem);
  
  public Class<T> clazz()
  {
    return null;
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
  public T migrateOldOrDefaultContent(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BaseConfProcessor", 2, "[migrateOldOrDefaultContent]" + type());
    }
    return null;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  @Nullable
  public T onParsed(QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BaseConfProcessor", 2, "[onParsed]" + type());
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if ((paramArrayOfQConfItem == null) || (paramArrayOfQConfItem.length == 0))
    {
      if (localQQAppInterface != null)
      {
        CJPreloadMonitorReporter.a(2, 3, type(), CJPreloadMonitorReporter.a(type()), QConfigManager.a().a(type(), localQQAppInterface.getCurrentAccountUin()), true, new String[] { "parse config fail!" });
        return null;
      }
    }
    else
    {
      try
      {
        int i = paramArrayOfQConfItem[0].jdField_a_of_type_Int;
        CJPreloadMonitorReporter.a(type(), i);
        CJPreloadMonitorReporter.a(type(), MD5.toMD5(paramArrayOfQConfItem[0].jdField_a_of_type_JavaLangString));
        paramArrayOfQConfItem = a(paramArrayOfQConfItem);
        return paramArrayOfQConfItem;
      }
      catch (Exception paramArrayOfQConfItem)
      {
        if (localQQAppInterface == null) {
          break label234;
        }
      }
      if ((paramArrayOfQConfItem instanceof JSONException)) {
        CJPreloadMonitorReporter.a(2, 5, type(), CJPreloadMonitorReporter.a(type()), QConfigManager.a().a(type(), localQQAppInterface.getCurrentAccountUin()), true, new String[] { QLog.getStackTraceString(paramArrayOfQConfItem.getCause()) });
      }
      for (;;)
      {
        CJPreloadMonitorReporter.a(localQQAppInterface, 1, 1, type(), CJPreloadMonitorReporter.a(type()), QConfigManager.a().a(type(), localQQAppInterface.getCurrentAccountUin()), false, CJPreloadMonitorReporter.a(type()));
        label234:
        throw new QConfigureException(paramArrayOfQConfItem.getMessage());
        CJPreloadMonitorReporter.a(2, 4, type(), CJPreloadMonitorReporter.a(type()), QConfigManager.a().a(type(), localQQAppInterface.getCurrentAccountUin()), true, new String[] { QLog.getStackTraceString(paramArrayOfQConfItem.getCause()) });
      }
    }
    return null;
  }
  
  public void onReqFailed(int paramInt)
  {
    int i = 0;
    int j = 1;
    if (QLog.isColorLevel()) {
      QLog.i("BaseConfProcessor", 2, "[onReqNoReceive] failCode=" + paramInt + " type: " + type());
    }
    for (;;)
    {
      try
      {
        QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        if (localQQAppInterface != null)
        {
          if (paramInt != -1) {
            break label169;
          }
          i = 1;
          break label169;
          CJPreloadMonitorReporter.a(2, i, type(), CJPreloadMonitorReporter.a(type()), QConfigManager.a().a(type(), localQQAppInterface.getCurrentAccountUin()), true, new String[0]);
          if (paramInt != -1) {
            CJPreloadMonitorReporter.a(localQQAppInterface, 1, 1, type(), CJPreloadMonitorReporter.a(type()), QConfigManager.a().a(type(), localQQAppInterface.getCurrentAccountUin()), false, CJPreloadMonitorReporter.a(type()));
          }
        }
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      i = 2;
      continue;
      label169:
      if (i != 0) {
        i = j;
      }
    }
  }
  
  public void onReqNoReceive()
  {
    if (QLog.isColorLevel()) {
      QLog.i("BaseConfProcessor", 2, "[onUpdate] onReqNoReceive = " + type());
    }
  }
  
  public void onUpdate(T paramT)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BaseConfProcessor", 2, "[onUpdate] " + type());
    }
    try
    {
      paramT = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      CJPreloadMonitorReporter.a(paramT, 1, 0, type(), CJPreloadMonitorReporter.a(type()), QConfigManager.a().a(type(), paramT.getCurrentAccountUin()), false, CJPreloadMonitorReporter.a(type()));
      return;
    }
    catch (Throwable paramT)
    {
      QLog.e("BaseConfProcessor", 1, QLog.getStackTraceString(paramT));
    }
  }
  
  public int type()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.gameres.BaseConfProcessor
 * JD-Core Version:    0.7.0.1
 */
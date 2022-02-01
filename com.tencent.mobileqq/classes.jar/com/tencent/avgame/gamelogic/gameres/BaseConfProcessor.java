package com.tencent.avgame.gamelogic.gameres;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.AppInterface;
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[migrateOldOrDefaultContent]");
      localStringBuilder.append(type());
      QLog.i("BaseConfProcessor", 2, localStringBuilder.toString());
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
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[onParsed]");
      ((StringBuilder)localObject).append(type());
      QLog.i("BaseConfProcessor", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length != 0)) {
      try
      {
        int i = paramArrayOfQConfItem[0].a;
        CJPreloadMonitorReporter.a(type(), i);
        CJPreloadMonitorReporter.a(type(), MD5.toMD5(paramArrayOfQConfItem[0].b));
        paramArrayOfQConfItem = a(paramArrayOfQConfItem);
        return paramArrayOfQConfItem;
      }
      catch (Exception paramArrayOfQConfItem)
      {
        if (localObject != null)
        {
          if ((paramArrayOfQConfItem instanceof JSONException)) {
            CJPreloadMonitorReporter.a(2, 5, type(), CJPreloadMonitorReporter.a(type()), QConfigManager.b().a(type(), ((QQAppInterface)localObject).getCurrentAccountUin()), true, new String[] { QLog.getStackTraceString(paramArrayOfQConfItem.getCause()) });
          } else {
            CJPreloadMonitorReporter.a(2, 4, type(), CJPreloadMonitorReporter.a(type()), QConfigManager.b().a(type(), ((QQAppInterface)localObject).getCurrentAccountUin()), true, new String[] { QLog.getStackTraceString(paramArrayOfQConfItem.getCause()) });
          }
          CJPreloadMonitorReporter.a((AppInterface)localObject, 1, 1, type(), CJPreloadMonitorReporter.a(type()), QConfigManager.b().a(type(), ((QQAppInterface)localObject).getCurrentAccountUin()), false, CJPreloadMonitorReporter.b(type()));
        }
        throw new QConfigureException(paramArrayOfQConfItem.getMessage());
      }
    }
    if (localObject != null) {
      CJPreloadMonitorReporter.a(2, 3, type(), CJPreloadMonitorReporter.a(type()), QConfigManager.b().a(type(), ((QQAppInterface)localObject).getCurrentAccountUin()), true, new String[] { "parse config fail!" });
    }
    return null;
  }
  
  public void onReqFailed(int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[onReqNoReceive] failCode=");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" type: ");
      ((StringBuilder)localObject).append(type());
      QLog.i("BaseConfProcessor", 2, ((StringBuilder)localObject).toString());
    }
    for (;;)
    {
      try
      {
        localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        if (localObject == null) {
          break label162;
        }
        if (paramInt != -1) {
          break label163;
        }
        i = 1;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      CJPreloadMonitorReporter.a(2, i, type(), CJPreloadMonitorReporter.a(type()), QConfigManager.b().a(type(), ((QQAppInterface)localObject).getCurrentAccountUin()), true, new String[0]);
      if (paramInt != -1)
      {
        CJPreloadMonitorReporter.a((AppInterface)localObject, 1, 1, type(), CJPreloadMonitorReporter.a(type()), QConfigManager.b().a(type(), ((QQAppInterface)localObject).getCurrentAccountUin()), false, CJPreloadMonitorReporter.b(type()));
        return;
      }
      label162:
      return;
      label163:
      int i = 0;
      if (i != 0) {
        i = 1;
      } else {
        i = 2;
      }
    }
  }
  
  public void onReqNoReceive()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onUpdate] onReqNoReceive = ");
      localStringBuilder.append(type());
      QLog.i("BaseConfProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public void onUpdate(T paramT)
  {
    if (QLog.isColorLevel())
    {
      paramT = new StringBuilder();
      paramT.append("[onUpdate] ");
      paramT.append(type());
      QLog.i("BaseConfProcessor", 2, paramT.toString());
    }
    try
    {
      paramT = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      CJPreloadMonitorReporter.a(paramT, 1, 0, type(), CJPreloadMonitorReporter.a(type()), QConfigManager.b().a(type(), paramT.getCurrentAccountUin()), false, CJPreloadMonitorReporter.b(type()));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.gameres.BaseConfProcessor
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.ark.config.processor;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.ark.config.bean.ArkConfBean;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;

public abstract class ArkConfProcessor<T extends ArkConfBean>
  extends IQConfigProcessor<T>
{
  public static <T extends ArkConfBean> T a(Class<T> paramClass)
  {
    try
    {
      ArkConfBean localArkConfBean1 = (ArkConfBean)paramClass.newInstance();
      ArkConfBean localArkConfBean2 = (ArkConfBean)QConfigManager.a().a(localArkConfBean1.a());
      if (localArkConfBean2 == null) {
        return localArkConfBean1;
      }
      paramClass = (ArkConfBean)paramClass.cast(localArkConfBean2);
      return paramClass;
    }
    catch (Exception paramClass)
    {
      QLog.w("ArkApp.ConfProcessor", 1, paramClass.toString());
    }
    return null;
  }
  
  protected abstract T a(String paramString);
  
  @Nullable
  public T a(QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onParsed] config type = ");
      localStringBuilder.append(type());
      QLog.d("ArkApp.ConfProcessor", 2, localStringBuilder.toString());
    }
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      paramArrayOfQConfItem = paramArrayOfQConfItem[0].a;
      if (!TextUtils.isEmpty(paramArrayOfQConfItem)) {
        return a(paramArrayOfQConfItem);
      }
      paramArrayOfQConfItem = new StringBuilder();
      paramArrayOfQConfItem.append("[onParsed] content is empty, config type = ");
      paramArrayOfQConfItem.append(type());
      QLog.i("ArkApp.ConfProcessor", 1, paramArrayOfQConfItem.toString());
    }
    return null;
  }
  
  public boolean isAccountRelated()
  {
    return false;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onReqFailed] failCode=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", config type = ");
    localStringBuilder.append(type());
    QLog.d("ArkApp.ConfProcessor", 1, localStringBuilder.toString());
  }
  
  public void onReqNoReceive()
  {
    super.onReqNoReceive();
  }
  
  public final int type()
  {
    Class localClass = clazz();
    try
    {
      int i = ((ArkConfBean)localClass.newInstance()).a();
      return i;
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.config.processor.ArkConfProcessor
 * JD-Core Version:    0.7.0.1
 */
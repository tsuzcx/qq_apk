package com.tencent.gamecenter.wadl.config;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;

public class FloatingPermissionConfProcessor
  extends IQConfigProcessor<FloatingPermissionConfBean>
{
  public static FloatingPermissionConfBean a()
  {
    FloatingPermissionConfBean localFloatingPermissionConfBean = (FloatingPermissionConfBean)QConfigManager.b().b(737);
    if ((QLog.isColorLevel()) && (localFloatingPermissionConfBean != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadConfig ");
      localStringBuilder.append(localFloatingPermissionConfBean.toString());
      QLog.i("Wadl_FloatingPermissionConfBean", 2, localStringBuilder.toString());
    }
    return localFloatingPermissionConfBean;
  }
  
  @NonNull
  public FloatingPermissionConfBean a(int paramInt)
  {
    return new FloatingPermissionConfBean();
  }
  
  @Nullable
  public FloatingPermissionConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Wadl_FloatingPermissionConfBean", 2, "onParsed ");
    }
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      new FloatingPermissionConfBean();
      return FloatingPermissionConfBean.a(paramArrayOfQConfItem);
    }
    return null;
  }
  
  public void a(FloatingPermissionConfBean paramFloatingPermissionConfBean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdate ");
      localStringBuilder.append(paramFloatingPermissionConfBean.toString());
      QLog.d("Wadl_FloatingPermissionConfBean", 2, localStringBuilder.toString());
    }
  }
  
  public Class<FloatingPermissionConfBean> clazz()
  {
    return FloatingPermissionConfBean.class;
  }
  
  public boolean isAccountRelated()
  {
    return true;
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReqFailed ");
      localStringBuilder.append(paramInt);
      QLog.d("Wadl_FloatingPermissionConfBean", 2, localStringBuilder.toString());
    }
  }
  
  public void onReqNoReceive() {}
  
  public int type()
  {
    return 737;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.config.FloatingPermissionConfProcessor
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.pubaccount.conf;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountConfigUtilImpl;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class ServiceAccountFolderConfProcessor
  extends IQConfigProcessor<ServiceAccountFolderConfBean>
{
  @NonNull
  public ServiceAccountFolderConfBean a(int paramInt)
  {
    if (paramInt == 0)
    {
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface))
      {
        localObject = (QQAppInterface)localObject;
        ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getServiceAccountFolderConfigData((QQAppInterface)localObject);
        return ServiceAccountFolderConfBean.a();
      }
    }
    return new ServiceAccountFolderConfBean();
  }
  
  @Nullable
  public ServiceAccountFolderConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderConfProcessor", 2, "[onParsed]");
    }
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return ServiceAccountFolderConfBean.a(paramArrayOfQConfItem);
    }
    return null;
  }
  
  public void a(ServiceAccountFolderConfBean paramServiceAccountFolderConfBean)
  {
    paramServiceAccountFolderConfBean.b();
    paramServiceAccountFolderConfBean.a();
    paramServiceAccountFolderConfBean.c();
  }
  
  public Class<ServiceAccountFolderConfBean> clazz()
  {
    return ServiceAccountFolderConfBean.class;
  }
  
  public boolean isAccountRelated()
  {
    return true;
  }
  
  public boolean isNeedCompressed()
  {
    return false;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return PublicAccountConfigUtilImpl.getServiceAccountFolderConfigVersionCode((QQAppInterface)localAppRuntime);
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 81;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.conf.ServiceAccountFolderConfProcessor
 * JD-Core Version:    0.7.0.1
 */
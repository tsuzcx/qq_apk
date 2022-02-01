package com.tencent.biz.pubaccount.conf;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class PublicAccountConfProcessor
  extends IQConfigProcessor<PublicAccountConfBean>
{
  @NonNull
  public PublicAccountConfBean a(int paramInt)
  {
    if (paramInt == 0)
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((localAppRuntime instanceof QQAppInterface)) {
        return PublicAccountConfBean.a(SharedPreUtils.t(((QQAppInterface)localAppRuntime).getApplication()));
      }
    }
    return new PublicAccountConfBean();
  }
  
  @Nullable
  public PublicAccountConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountConfProcessor", 2, "[onParsed]");
    }
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return PublicAccountConfBean.a(paramArrayOfQConfItem);
    }
    return null;
  }
  
  public void a(PublicAccountConfBean paramPublicAccountConfBean)
  {
    paramPublicAccountConfBean.b();
    paramPublicAccountConfBean.a();
  }
  
  public Class<PublicAccountConfBean> clazz()
  {
    return PublicAccountConfBean.class;
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
      return SharedPreUtils.s(((QQAppInterface)localAppRuntime).getApp());
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 32;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.conf.PublicAccountConfProcessor
 * JD-Core Version:    0.7.0.1
 */
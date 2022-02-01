package com.tencent.biz.pubaccount.conf;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class PublicAccountCenterUrlConfProcessor
  extends IQConfigProcessor<PublicAccountCenterUrlConfBean>
{
  @NonNull
  public PublicAccountCenterUrlConfBean a(int paramInt)
  {
    if (paramInt == 0)
    {
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface))
      {
        localObject = (QQAppInterface)localObject;
        String str = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getPublicAccountCenterUrlConfigData((AppInterface)localObject);
        ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).loadPublicAccountCenterUrlConfig((AppInterface)localObject, str);
        return PublicAccountCenterUrlConfBean.a();
      }
    }
    return new PublicAccountCenterUrlConfBean();
  }
  
  @Nullable
  public PublicAccountCenterUrlConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountCenterUrlConfProcessor", 2, "[onParsed]");
    }
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return PublicAccountCenterUrlConfBean.a(paramArrayOfQConfItem);
    }
    return null;
  }
  
  public void a(PublicAccountCenterUrlConfBean paramPublicAccountCenterUrlConfBean)
  {
    paramPublicAccountCenterUrlConfBean.a();
    paramPublicAccountCenterUrlConfBean.b();
  }
  
  public Class<PublicAccountCenterUrlConfBean> clazz()
  {
    return PublicAccountCenterUrlConfBean.class;
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
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      return ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getPublicAccountCenterUrlConfigVersionCode((AppInterface)localObject);
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 70;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.conf.PublicAccountCenterUrlConfProcessor
 * JD-Core Version:    0.7.0.1
 */
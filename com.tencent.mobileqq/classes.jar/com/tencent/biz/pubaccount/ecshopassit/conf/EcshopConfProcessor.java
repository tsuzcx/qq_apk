package com.tencent.biz.pubaccount.ecshopassit.conf;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;

public class EcshopConfProcessor
  extends IQConfigProcessor<EcshopConfBean>
{
  public static EcshopConfBean a()
  {
    return (EcshopConfBean)QConfigManager.a().a(593);
  }
  
  @NonNull
  public EcshopConfBean a(int paramInt)
  {
    return new EcshopConfBean();
  }
  
  @Nullable
  public EcshopConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem == null) || (paramArrayOfQConfItem.length == 0)) {
      return new EcshopConfBean();
    }
    return EcshopConfBean.a(paramArrayOfQConfItem[0].a);
  }
  
  public void a(EcshopConfBean paramEcshopConfBean) {}
  
  public Class<EcshopConfBean> clazz()
  {
    return EcshopConfBean.class;
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
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 593;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.conf.EcshopConfProcessor
 * JD-Core Version:    0.7.0.1
 */
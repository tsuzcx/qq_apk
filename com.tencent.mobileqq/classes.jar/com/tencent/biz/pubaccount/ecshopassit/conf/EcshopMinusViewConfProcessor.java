package com.tencent.biz.pubaccount.ecshopassit.conf;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;

public class EcshopMinusViewConfProcessor
  extends IQConfigProcessor<EcshopMinusViewConfBean>
{
  @NonNull
  public EcshopMinusViewConfBean a(int paramInt)
  {
    return new EcshopMinusViewConfBean();
  }
  
  @Nullable
  public EcshopMinusViewConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem == null) || (paramArrayOfQConfItem.length == 0)) {
      return new EcshopMinusViewConfBean();
    }
    return EcshopMinusViewConfBean.a(paramArrayOfQConfItem[0].a);
  }
  
  public void a(EcshopMinusViewConfBean paramEcshopMinusViewConfBean) {}
  
  public Class<EcshopMinusViewConfBean> clazz()
  {
    return EcshopMinusViewConfBean.class;
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
    return 650;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.conf.EcshopMinusViewConfProcessor
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity.aio.ecommerce;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;

public class ECommerceDataReportConfigProcessor
  extends IQConfigProcessor<ECommerceDataReportConfigProcessor.Config>
{
  @NonNull
  public ECommerceDataReportConfigProcessor.Config a(int paramInt)
  {
    return new ECommerceDataReportConfigProcessor.Config();
  }
  
  @Nullable
  public ECommerceDataReportConfigProcessor.Config a(QConfItem[] paramArrayOfQConfItem)
  {
    ECommerceDataReportConfigProcessor.Config localConfig = new ECommerceDataReportConfigProcessor.Config();
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0) && (paramArrayOfQConfItem[0] != null)) {
      ECommerceDataReportConfigProcessor.Config.a(localConfig, paramArrayOfQConfItem[0].a);
    }
    return localConfig;
  }
  
  public void a(ECommerceDataReportConfigProcessor.Config paramConfig) {}
  
  public Class<ECommerceDataReportConfigProcessor.Config> clazz()
  {
    return ECommerceDataReportConfigProcessor.Config.class;
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
    return 592;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.ecommerce.ECommerceDataReportConfigProcessor
 * JD-Core Version:    0.7.0.1
 */
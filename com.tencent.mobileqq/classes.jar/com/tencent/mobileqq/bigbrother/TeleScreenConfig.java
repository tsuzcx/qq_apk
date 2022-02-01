package com.tencent.mobileqq.bigbrother;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;

public class TeleScreenConfig
  extends IQConfigProcessor<TeleScreenConfig.Config>
{
  @NonNull
  public TeleScreenConfig.Config a(int paramInt)
  {
    return new TeleScreenConfig.Config();
  }
  
  @Nullable
  public TeleScreenConfig.Config a(QConfItem[] paramArrayOfQConfItem)
  {
    TeleScreenConfig.Config localConfig = new TeleScreenConfig.Config();
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0) && (paramArrayOfQConfItem[0] != null)) {
      TeleScreenConfig.Config.a(localConfig, paramArrayOfQConfItem[0].a);
    }
    return localConfig;
  }
  
  public void a(TeleScreenConfig.Config paramConfig) {}
  
  public Class<TeleScreenConfig.Config> clazz()
  {
    return TeleScreenConfig.Config.class;
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
  
  public void onReqFailed(int paramInt) {}
  
  public void onReqNoReceive() {}
  
  public int type()
  {
    return 416;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bigbrother.TeleScreenConfig
 * JD-Core Version:    0.7.0.1
 */
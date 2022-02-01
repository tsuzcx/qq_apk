package com.tencent.mobileqq.activity.aio.anim.config;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;

public class TroopDragonKingAnimEntryConfigProcessor
  extends IQConfigProcessor<TroopDragonKingAnimEntryConfig>
{
  @NonNull
  public TroopDragonKingAnimEntryConfig a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("migrateOldOrDefaultContent, type = ");
    localStringBuilder.append(paramInt);
    QLog.d("TroopDragonKingAnimEntryConfig.config", 2, localStringBuilder.toString());
    return new TroopDragonKingAnimEntryConfig();
  }
  
  @Nullable
  public TroopDragonKingAnimEntryConfig a(QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopDragonKingAnimEntryConfig.config", 2, "onParsed");
    }
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return TroopDragonKingAnimEntryConfig.a(paramArrayOfQConfItem[0].b);
    }
    return null;
  }
  
  public void a(TroopDragonKingAnimEntryConfig paramTroopDragonKingAnimEntryConfig) {}
  
  public Class<TroopDragonKingAnimEntryConfig> clazz()
  {
    return TroopDragonKingAnimEntryConfig.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return true;
  }
  
  public boolean isNeedUpgradeReset()
  {
    return true;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReqFailed, failCode = ");
    localStringBuilder.append(paramInt);
    QLog.d("TroopDragonKingAnimEntryConfig.config", 1, localStringBuilder.toString());
  }
  
  public int type()
  {
    return 609;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.config.TroopDragonKingAnimEntryConfigProcessor
 * JD-Core Version:    0.7.0.1
 */
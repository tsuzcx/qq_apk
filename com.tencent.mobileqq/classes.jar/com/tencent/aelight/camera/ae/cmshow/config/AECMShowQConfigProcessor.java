package com.tencent.aelight.camera.ae.cmshow.config;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;

public class AECMShowQConfigProcessor
  extends IQConfigProcessor<AECMShowConfig>
{
  @NonNull
  public AECMShowConfig a(int paramInt)
  {
    AEQLog.a("AECMShowQConfigProcessor", "[migrateOldOrDefaultContent]");
    return new AECMShowConfig();
  }
  
  @Nullable
  public AECMShowConfig a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0) && (paramArrayOfQConfItem[0] != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onParsed] content=");
      localStringBuilder.append(paramArrayOfQConfItem[0].a);
      AEQLog.a("AECMShowQConfigProcessor", localStringBuilder.toString());
      return AECMShowConfigManager.a(paramArrayOfQConfItem[0].a);
    }
    AEQLog.a("AECMShowQConfigProcessor", "[onParsed] config invalid");
    return null;
  }
  
  public void a(AECMShowConfig paramAECMShowConfig)
  {
    AEQLog.a("AECMShowQConfigProcessor", "[onUpdate]");
    AECMShowConfigManager.a().a(paramAECMShowConfig);
  }
  
  public Class<AECMShowConfig> clazz()
  {
    return AECMShowConfig.class;
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
    AEQLog.a("AECMShowQConfigProcessor", "[migrateOldVersion]");
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onReqFailed], failCode=");
    localStringBuilder.append(paramInt);
    AEQLog.a("AECMShowQConfigProcessor", localStringBuilder.toString());
  }
  
  public int onSend(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onSend], confVersion=");
    localStringBuilder.append(paramInt);
    AEQLog.a("AECMShowQConfigProcessor", localStringBuilder.toString());
    return super.onSend(paramInt);
  }
  
  public int type()
  {
    return 700;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.cmshow.config.AECMShowQConfigProcessor
 * JD-Core Version:    0.7.0.1
 */
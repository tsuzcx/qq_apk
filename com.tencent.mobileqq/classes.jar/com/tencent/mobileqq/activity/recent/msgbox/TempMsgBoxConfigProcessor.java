package com.tencent.mobileqq.activity.recent.msgbox;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxManager;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class TempMsgBoxConfigProcessor
  extends IQConfigProcessor<TempMsgBoxConfigData>
{
  @NonNull
  public TempMsgBoxConfigData a(int paramInt)
  {
    return new TempMsgBoxConfigData();
  }
  
  @Nullable
  public TempMsgBoxConfigData a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onParsed : ");
        localStringBuilder.append(paramArrayOfQConfItem[0].b);
        QLog.d("TempMsgBoxConfigProcessor", 2, localStringBuilder.toString());
      }
      return TempMsgBoxConfigData.a(paramArrayOfQConfItem[0].b);
    }
    return new TempMsgBoxConfigData();
  }
  
  public void a(TempMsgBoxConfigData paramTempMsgBoxConfigData)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdate : ");
      localStringBuilder.append(paramTempMsgBoxConfigData);
      QLog.d("TempMsgBoxConfigProcessor", 2, localStringBuilder.toString());
    }
    ((ITempMsgBoxManager)((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getRuntimeService(ITempMsgBoxManager.class, "")).setTempMsgBoxConfigData(paramTempMsgBoxConfigData);
  }
  
  public Class<TempMsgBoxConfigData> clazz()
  {
    return TempMsgBoxConfigData.class;
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
      localStringBuilder.append("onReqFailed : ");
      localStringBuilder.append(paramInt);
      QLog.d("TempMsgBoxConfigProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public int type()
  {
    return 704;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msgbox.TempMsgBoxConfigProcessor
 * JD-Core Version:    0.7.0.1
 */
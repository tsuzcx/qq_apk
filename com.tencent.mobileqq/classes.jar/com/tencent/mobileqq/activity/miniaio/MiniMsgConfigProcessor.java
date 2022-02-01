package com.tencent.mobileqq.activity.miniaio;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;

public class MiniMsgConfigProcessor
  extends IQConfigProcessor
{
  public static MiniMsgConfigData a()
  {
    return (MiniMsgConfigData)QConfigManager.a().a(470);
  }
  
  @NonNull
  public MiniMsgConfigData a(int paramInt)
  {
    return new MiniMsgConfigData();
  }
  
  @Nullable
  public MiniMsgConfigData a(QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("parse.configData : ");
      localStringBuilder.append(paramArrayOfQConfItem[0].a);
      QLog.d("mini_msg_config", 2, localStringBuilder.toString());
    }
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return MiniMsgConfigData.a(paramArrayOfQConfItem);
    }
    return null;
  }
  
  public Class<MiniMsgConfigData> clazz()
  {
    return MiniMsgConfigData.class;
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
  
  public void onUpdate(Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdate ");
      localStringBuilder.append(paramObject);
      QLog.d("mini_msg_config", 0, localStringBuilder.toString());
    }
  }
  
  public int type()
  {
    return 470;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniMsgConfigProcessor
 * JD-Core Version:    0.7.0.1
 */
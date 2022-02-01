package com.tencent.biz.videostory.config.processor;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import dov.com.qq.im.ae.camera.ui.watermark.WatermarkDataManager;

public class VSWaterMarkProcessor
  extends IQConfigProcessor<VSWaterMarkConfBean>
{
  @NonNull
  public VSWaterMarkConfBean a(int paramInt)
  {
    return new VSWaterMarkConfBean();
  }
  
  @Nullable
  public VSWaterMarkConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return VSWaterMarkConfBean.a(paramArrayOfQConfItem[0].a);
    }
    return null;
  }
  
  public void a(VSWaterMarkConfBean paramVSWaterMarkConfBean)
  {
    WatermarkDataManager.a().a(true);
  }
  
  public Class<VSWaterMarkConfBean> clazz()
  {
    return VSWaterMarkConfBean.class;
  }
  
  public boolean isAccountRelated()
  {
    return true;
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
  
  public void onReqNoReceive()
  {
    super.onReqNoReceive();
    WatermarkDataManager.a().a(false);
  }
  
  public int type()
  {
    return 406;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.videostory.config.processor.VSWaterMarkProcessor
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.ilivesdk.avmediaservice_interface;

import android.content.Context;
import android.view.View;
import com.tencent.ilivesdk.avmediaservice_interface.model.AVMediaRequestInfo;

public abstract interface AVMediaRecordInterface
  extends MediaBaseInterface
{
  public abstract MediaBeautyInterface getBeautyInterface();
  
  public abstract int getGear();
  
  public abstract void init(Context paramContext, View paramView, MediaBaseInterface.IPlayerStatusNotify paramIPlayerStatusNotify, int paramInt);
  
  public abstract void openAVStream(AVMediaRequestInfo paramAVMediaRequestInfo);
  
  public abstract void setCatonListener(AVMediaRecordInterface.CatonListener paramCatonListener);
  
  public abstract void setGear(long paramLong1, long paramLong2, int paramInt1, int paramInt2, AVMediaRecordInterface.OnChangeAnchorGearListener paramOnChangeAnchorGearListener);
  
  public abstract void startRateEstimate(AVMediaRecordInterface.IRateEstimateStatusCallback paramIRateEstimateStatusCallback);
  
  public abstract void stopRateEstimate();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.avmediaservice_interface.AVMediaRecordInterface
 * JD-Core Version:    0.7.0.1
 */
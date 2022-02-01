package com.tencent.ilivesdk.avmediaservice_interface;

import android.content.Context;
import android.view.ViewGroup;

public abstract interface AVMediaPreviewInterface
  extends MediaBaseInterface
{
  public abstract MediaBeautyInterface getBeautyInterface();
  
  public abstract int getGear();
  
  public abstract void init(Context paramContext, ViewGroup paramViewGroup, int paramInt, MediaBaseInterface.IPlayerStatusNotify paramIPlayerStatusNotify);
  
  public abstract void setGear(long paramLong1, long paramLong2, int paramInt1, int paramInt2, AVMediaRecordInterface.OnChangeAnchorGearListener paramOnChangeAnchorGearListener);
  
  public abstract void startPreview();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.avmediaservice_interface.AVMediaPreviewInterface
 * JD-Core Version:    0.7.0.1
 */
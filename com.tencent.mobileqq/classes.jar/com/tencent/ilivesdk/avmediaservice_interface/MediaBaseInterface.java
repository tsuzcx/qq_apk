package com.tencent.ilivesdk.avmediaservice_interface;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.ViewGroup;

public abstract interface MediaBaseInterface
{
  public static final int TEMPLATETYPE_DEFAULT = 1;
  
  public abstract void close();
  
  public abstract Bundle getAVQualityInfo();
  
  public abstract Bitmap getLastFrame();
  
  public abstract String getQualityTips();
  
  public abstract int getRoomAVSDKType();
  
  public abstract Bundle getVideoSize();
  
  public abstract void pauseVideo();
  
  public abstract void resumeVideo();
  
  public abstract void setBackground(Bitmap paramBitmap, Rect paramRect);
  
  public abstract void setEnableFocus(boolean paramBoolean);
  
  public abstract void setProfile(Object paramObject);
  
  public abstract void setRoomCoverBmpAndType(int paramInt, Bitmap paramBitmap);
  
  public abstract void switchRenderView(ViewGroup paramViewGroup);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.avmediaservice_interface.MediaBaseInterface
 * JD-Core Version:    0.7.0.1
 */
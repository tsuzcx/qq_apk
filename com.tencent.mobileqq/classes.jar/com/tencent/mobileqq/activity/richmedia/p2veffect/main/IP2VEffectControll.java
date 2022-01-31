package com.tencent.mobileqq.activity.richmedia.p2veffect.main;

import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.richmedia.p2veffect.listener.IControllerFilterProvider;
import com.tencent.mobileqq.activity.richmedia.p2veffect.listener.IFastRenderCallback;
import com.tencent.mobileqq.activity.richmedia.p2veffect.listener.IOnStopCompleteListener;
import com.tencent.mobileqq.activity.richmedia.p2veffect.listener.IP2VEnginePlayerCallback;
import java.util.ArrayList;

public abstract interface IP2VEffectControll
{
  public static final int ERR_GET_DIMENS = 2;
  public static final int ERR_INVALID_DURATION = 3;
  public static final int ERR_MATERIAL_PARSE = 1;
  
  public abstract void addPlayerCallback(IP2VEnginePlayerCallback paramIP2VEnginePlayerCallback);
  
  public abstract void cancelSave(IOnStopCompleteListener paramIOnStopCompleteListener);
  
  public abstract void onDestroy();
  
  public abstract void pausePlay();
  
  public abstract void prepare();
  
  public abstract void requestDraw();
  
  public abstract void resetVideoIndex();
  
  public abstract void save(String paramString, IFastRenderCallback paramIFastRenderCallback);
  
  public abstract void setFilterProvider(IControllerFilterProvider paramIControllerFilterProvider);
  
  public abstract void setMediaItems(ArrayList paramArrayList);
  
  public abstract void setSquareTypeAndColor(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void setWaterMarkerBitmap(Bitmap paramBitmap);
  
  public abstract void setWaterMarkerEnable(boolean paramBoolean);
  
  public abstract void startPlay(boolean paramBoolean);
  
  public abstract void stopPlay();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.p2veffect.main.IP2VEffectControll
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.ilive.uicomponent.luxurygiftcomponent_interface;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewParent;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.showview.LoadToPlayInter;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.showview.LottieGiftInfo;

public abstract interface LottieViewInterface
{
  public abstract void cancelAnimation();
  
  public abstract void cancelLoaderTask();
  
  public abstract void clearAnimation();
  
  public abstract ViewParent getParent();
  
  public abstract View getView();
  
  public abstract int getVisibility();
  
  public abstract boolean isAnimating();
  
  public abstract boolean isShown();
  
  public abstract void onH264End();
  
  public abstract void onPlayAtTime(long paramLong, boolean paramBoolean);
  
  public abstract void setAnimState(boolean paramBoolean);
  
  public abstract void setConfig(String paramString1, String paramString2, LottieGiftInfo paramLottieGiftInfo, Bitmap paramBitmap, LoadToPlayInter paramLoadToPlayInter);
  
  public abstract void setVisibility(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.LottieViewInterface
 * JD-Core Version:    0.7.0.1
 */
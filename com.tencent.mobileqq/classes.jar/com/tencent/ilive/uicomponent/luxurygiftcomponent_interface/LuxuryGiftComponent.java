package com.tencent.ilive.uicomponent.luxurygiftcomponent_interface;

import com.tencent.ilive.uicomponent.UIOuter;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.model.LuxuryGiftData;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.model.LuxuryGiftInfo;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.model.OnPresentLuxuryGiftOverListener;
import java.util.List;

public abstract interface LuxuryGiftComponent
  extends UIOuter
{
  public abstract void cancelAnimation();
  
  public abstract void clearLuxuryQueue();
  
  public abstract void displayLuxuryGift(LuxuryGiftData paramLuxuryGiftData);
  
  public abstract void hideLuxuryAnimationView();
  
  public abstract void init(LuxuryGiftAdapter paramLuxuryGiftAdapter);
  
  public abstract void onGetLuxuryGiftResInfoList(List<LuxuryGiftInfo> paramList);
  
  public abstract void removeOnPresentLuxuryOverListener(OnPresentLuxuryGiftOverListener paramOnPresentLuxuryGiftOverListener);
  
  public abstract void setOnPresentLuxuryOverListener(OnPresentLuxuryGiftOverListener paramOnPresentLuxuryGiftOverListener);
  
  public abstract void showAllLuxuryView();
  
  public abstract void showLuxuryAnimationView();
  
  public abstract void stopLuxuyAnimationAndHide();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.LuxuryGiftComponent
 * JD-Core Version:    0.7.0.1
 */
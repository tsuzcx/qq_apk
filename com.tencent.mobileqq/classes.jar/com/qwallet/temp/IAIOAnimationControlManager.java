package com.qwallet.temp;

import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(needUin=false, process={""})
public abstract interface IAIOAnimationControlManager
  extends IRuntimeService
{
  public abstract boolean addPlayAnimationList(IAnimationMessageProxy paramIAnimationMessageProxy, boolean paramBoolean);
  
  public abstract void removeAllGiftMsgByTroop(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qwallet.temp.IAIOAnimationControlManager
 * JD-Core Version:    0.7.0.1
 */
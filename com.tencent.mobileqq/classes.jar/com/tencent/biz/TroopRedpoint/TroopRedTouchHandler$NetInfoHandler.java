package com.tencent.biz.TroopRedpoint;

import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import java.lang.ref.WeakReference;

public class TroopRedTouchHandler$NetInfoHandler
  implements INetInfoHandler
{
  protected WeakReference a;
  
  public TroopRedTouchHandler$NetInfoHandler(TroopRedTouchHandler paramTroopRedTouchHandler)
  {
    this.a = new WeakReference(paramTroopRedTouchHandler);
  }
  
  public void onNetMobile2None()
  {
    TroopRedTouchHandler localTroopRedTouchHandler = (TroopRedTouchHandler)this.a.get();
    if (localTroopRedTouchHandler != null) {
      localTroopRedTouchHandler.a = 2;
    }
  }
  
  public void onNetMobile2Wifi(String paramString) {}
  
  public void onNetNone2Mobile(String paramString) {}
  
  public void onNetNone2Wifi(String paramString) {}
  
  public void onNetWifi2Mobile(String paramString) {}
  
  public void onNetWifi2None()
  {
    TroopRedTouchHandler localTroopRedTouchHandler = (TroopRedTouchHandler)this.a.get();
    if (localTroopRedTouchHandler != null) {
      localTroopRedTouchHandler.a = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.TroopRedpoint.TroopRedTouchHandler.NetInfoHandler
 * JD-Core Version:    0.7.0.1
 */
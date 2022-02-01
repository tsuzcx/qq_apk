package com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload;

import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.api.ResNetChangeInterface;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import java.lang.ref.WeakReference;

public class NetInfoHandler
  implements INetInfoHandler
{
  protected WeakReference<ResNetChangeInterface> a;
  
  public NetInfoHandler(ResNetChangeInterface paramResNetChangeInterface)
  {
    this.a = new WeakReference(paramResNetChangeInterface);
  }
  
  public void onNetMobile2None() {}
  
  public void onNetMobile2Wifi(String paramString)
  {
    paramString = this.a;
    if ((paramString != null) && (paramString.get() != null)) {
      ((ResNetChangeInterface)this.a.get()).d();
    }
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    paramString = this.a;
    if ((paramString != null) && (paramString.get() != null)) {
      ((ResNetChangeInterface)this.a.get()).b();
    }
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    paramString = this.a;
    if ((paramString != null) && (paramString.get() != null)) {
      ((ResNetChangeInterface)this.a.get()).c();
    }
  }
  
  public void onNetWifi2Mobile(String paramString) {}
  
  public void onNetWifi2None() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload.NetInfoHandler
 * JD-Core Version:    0.7.0.1
 */
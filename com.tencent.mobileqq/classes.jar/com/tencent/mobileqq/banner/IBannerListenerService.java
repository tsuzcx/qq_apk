package com.tencent.mobileqq.banner;

import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface IBannerListenerService
  extends IRuntimeService
{
  public abstract void addBannerListener(BannerListener paramBannerListener);
  
  public abstract void notifyBannerDismiss(int paramInt);
  
  public abstract void notifyBannerShow(int paramInt);
  
  public abstract void removeBannerListener(BannerListener paramBannerListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.banner.IBannerListenerService
 * JD-Core Version:    0.7.0.1
 */
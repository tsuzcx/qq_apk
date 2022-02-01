package com.tencent.mobileqq.banner.impl;

import com.tencent.mobileqq.banner.BannerListener;
import com.tencent.mobileqq.banner.IBannerListenerManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class BannerListenerManagerImpl
  implements IBannerListenerManager
{
  private List<BannerListener> bannerListenerList;
  
  public void addBannerListener(BannerListener paramBannerListener)
  {
    if (paramBannerListener == null) {}
    while (this.bannerListenerList.contains(paramBannerListener)) {
      return;
    }
    this.bannerListenerList.add(paramBannerListener);
  }
  
  public void notifyBannerDismiss(int paramInt)
  {
    Iterator localIterator = this.bannerListenerList.iterator();
    while (localIterator.hasNext()) {
      ((BannerListener)localIterator.next()).b(paramInt);
    }
  }
  
  public void notifyBannerShow(int paramInt)
  {
    Iterator localIterator = this.bannerListenerList.iterator();
    while (localIterator.hasNext()) {
      ((BannerListener)localIterator.next()).a(paramInt);
    }
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.bannerListenerList = new ArrayList();
  }
  
  public void onDestroy()
  {
    this.bannerListenerList.clear();
  }
  
  public void removeBannerListener(BannerListener paramBannerListener)
  {
    this.bannerListenerList.remove(paramBannerListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.banner.impl.BannerListenerManagerImpl
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.banner.impl;

import com.tencent.mobileqq.banner.BannerListener;
import com.tencent.mobileqq.banner.IBannerListenerService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class BannerListenerServiceImpl
  implements IBannerListenerService
{
  private List<BannerListener> bannerListenerList;
  
  public void addBannerListener(BannerListener paramBannerListener)
  {
    if (paramBannerListener == null) {
      return;
    }
    try
    {
      if (!this.bannerListenerList.contains(paramBannerListener)) {
        this.bannerListenerList.add(paramBannerListener);
      }
      return;
    }
    finally
    {
      paramBannerListener = finally;
      throw paramBannerListener;
    }
  }
  
  public void notifyBannerDismiss(int paramInt)
  {
    try
    {
      Iterator localIterator = this.bannerListenerList.iterator();
      while (localIterator.hasNext()) {
        ((BannerListener)localIterator.next()).b(paramInt);
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void notifyBannerShow(int paramInt)
  {
    try
    {
      Iterator localIterator = this.bannerListenerList.iterator();
      while (localIterator.hasNext()) {
        ((BannerListener)localIterator.next()).a(paramInt);
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
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
    try
    {
      this.bannerListenerList.remove(paramBannerListener);
      return;
    }
    finally
    {
      paramBannerListener = finally;
      throw paramBannerListener;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.banner.impl.BannerListenerServiceImpl
 * JD-Core Version:    0.7.0.1
 */
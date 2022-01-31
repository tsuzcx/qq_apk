package com.tencent.biz.pubaccount.readinjoy.video.discovery;

import android.os.Handler;
import android.os.Looper;
import java.lang.ref.WeakReference;

class BannerView$AutoSidleTimer
  extends Handler
  implements Runnable
{
  private WeakReference<BannerView> a;
  
  public BannerView$AutoSidleTimer(BannerView paramBannerView)
  {
    super(Looper.getMainLooper());
    this.a = new WeakReference(paramBannerView);
  }
  
  public void a()
  {
    if ((this.a != null) && (this.a.get() != null)) {
      removeCallbacks(this);
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.a != null) && (this.a.get() != null))
    {
      removeCallbacks(this);
      b(paramInt);
    }
  }
  
  public void b()
  {
    b(0);
  }
  
  public void b(int paramInt)
  {
    if (paramInt == 0)
    {
      post(this);
      return;
    }
    postDelayed(this, paramInt);
  }
  
  public void run()
  {
    if ((this.a != null) && (this.a.get() != null)) {
      BannerView.a((BannerView)this.a.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.discovery.BannerView.AutoSidleTimer
 * JD-Core Version:    0.7.0.1
 */
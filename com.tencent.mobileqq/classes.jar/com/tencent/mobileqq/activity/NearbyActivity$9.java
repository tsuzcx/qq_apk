package com.tencent.mobileqq.activity;

import android.os.Handler;
import com.tencent.mobileqq.nearby.ipc.NearbyProcObserver;
import com.tencent.mobileqq.newnearby.NearbyActivityController;

class NearbyActivity$9
  extends NearbyProcObserver
{
  NearbyActivity$9(NearbyActivity paramNearbyActivity) {}
  
  protected void a()
  {
    this.a.mHandler.sendEmptyMessageDelayed(2, 0L);
  }
  
  protected void b()
  {
    if (this.a.mIsNew)
    {
      this.a.mNearbyActivityController.c();
      return;
    }
    super.b();
    NearbyActivity.access$100(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NearbyActivity.9
 * JD-Core Version:    0.7.0.1
 */
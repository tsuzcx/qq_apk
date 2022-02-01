package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;

class QQMapActivity$9$1
  implements Runnable
{
  QQMapActivity$9$1(QQMapActivity.9 param9) {}
  
  public void run()
  {
    ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).removeListener(this.a.a.mLocationListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQMapActivity.9.1
 * JD-Core Version:    0.7.0.1
 */
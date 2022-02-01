package com.tencent.mobileqq.activity.aio;

import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.qroute.QRoute;

final class ForwardUtils$6
  implements Runnable
{
  ForwardUtils$6(PicReq paramPicReq) {}
  
  public void run()
  {
    ((IPicBus)QRoute.api(IPicBus.class)).launch(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.ForwardUtils.6
 * JD-Core Version:    0.7.0.1
 */
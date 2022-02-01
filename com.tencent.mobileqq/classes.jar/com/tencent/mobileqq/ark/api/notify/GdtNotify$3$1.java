package com.tencent.mobileqq.ark.api.notify;

import com.tencent.gdtad.aditem.GdtAdLoader;
import com.tencent.gdtad.aditem.GdtAdLoader.Listener;
import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.qroute.QRoute;

class GdtNotify$3$1
  implements GdtAdLoader.Listener
{
  GdtNotify$3$1(GdtNotify.3 param3) {}
  
  public void onResponse(GdtAdLoader paramGdtAdLoader)
  {
    ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToAppThread(this.a.a, new GdtNotify.3.1.1(this, paramGdtAdLoader));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.notify.GdtNotify.3.1
 * JD-Core Version:    0.7.0.1
 */
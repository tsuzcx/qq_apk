package com.tencent.mobileqq.activity.qqsettingme;

import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.data.Card;
import mqq.util.WeakReference;

class DrawerBizFacade$6$3
  implements Runnable
{
  DrawerBizFacade$6$3(DrawerBizFacade.6 param6, Card paramCard) {}
  
  public void run()
  {
    if (DrawerBizFacade.b(this.b.a).get() != null) {
      ((FrameHelperActivity)DrawerBizFacade.b(this.b.a).get()).a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.DrawerBizFacade.6.3
 * JD-Core Version:    0.7.0.1
 */
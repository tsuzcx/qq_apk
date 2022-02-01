package com.tencent.mobileqq.activity.qqsettingme;

import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.data.Card;
import mqq.util.WeakReference;

class DrawerBizFacade$6$2
  implements Runnable
{
  DrawerBizFacade$6$2(DrawerBizFacade.6 param6) {}
  
  public void run()
  {
    if (DrawerBizFacade.b(this.a.a).get() != null)
    {
      Card localCard = ((ICardCatcher)this.a.a.b("d_head_vip")).a();
      ((FrameHelperActivity)DrawerBizFacade.b(this.a.a).get()).a(localCard);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.DrawerBizFacade.6.2
 * JD-Core Version:    0.7.0.1
 */
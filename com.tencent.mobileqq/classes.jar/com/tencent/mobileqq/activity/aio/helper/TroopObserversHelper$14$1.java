package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.anonymous.QQAnonymousDialog;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import mqq.os.MqqHandler;

class TroopObserversHelper$14$1
  implements Runnable
{
  TroopObserversHelper$14$1(TroopObserversHelper.14 param14) {}
  
  public void run()
  {
    if (TroopObserversHelper.a(this.a.a).a != null) {
      TroopObserversHelper.a(this.a.a).a.dismiss();
    }
    TroopObserversHelper.a(this.a.a).o(true);
    TroopObserversHelper.a(this.a.a).a().postDelayed(new TroopObserversHelper.14.1.1(this), 100L);
    if (!AnonymousChatHelper.a(TroopObserversHelper.a(this.a.a), TroopObserversHelper.a(this.a.a))) {
      TroopObserversHelper.a(this.a.a).a().postDelayed(new TroopObserversHelper.14.1.2(this), 200L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopObserversHelper.14.1
 * JD-Core Version:    0.7.0.1
 */
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
    if (TroopObserversHelper.d(this.a.a).by != null) {
      TroopObserversHelper.d(this.a.a).by.dismiss();
    }
    TroopObserversHelper.d(this.a.a).s(true);
    TroopObserversHelper.d(this.a.a).j().postDelayed(new TroopObserversHelper.14.1.1(this), 100L);
    if (!AnonymousChatHelper.a(TroopObserversHelper.g(this.a.a), TroopObserversHelper.a(this.a.a))) {
      TroopObserversHelper.d(this.a.a).j().postDelayed(new TroopObserversHelper.14.1.2(this), 200L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopObserversHelper.14.1
 * JD-Core Version:    0.7.0.1
 */
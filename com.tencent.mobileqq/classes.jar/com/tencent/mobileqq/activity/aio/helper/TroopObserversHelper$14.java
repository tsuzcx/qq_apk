package com.tencent.mobileqq.activity.aio.helper;

import android.content.res.Resources;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.troop.observer.TroopAnonymousObserver;
import mqq.os.MqqHandler;

class TroopObserversHelper$14
  extends TroopAnonymousObserver
{
  TroopObserversHelper$14(TroopObserversHelper paramTroopObserversHelper) {}
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString3, String paramString4)
  {
    if (paramBoolean)
    {
      if ((paramInt4 != 0) && (!TroopObserversHelper.n))
      {
        TroopObserversHelper.d(this.a).a(3, paramString3);
        return;
      }
      AnonymousChatHelper.a().a(paramString1, paramInt2, paramInt1, paramString2, paramInt3, null, paramString4);
      TroopObserversHelper.d(this.a).j().postDelayed(new TroopObserversHelper.14.1(this), 500L);
      return;
    }
    TroopObserversHelper.d(this.a).a(1, TroopObserversHelper.g(this.a).getResources().getString(2131886661));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopObserversHelper.14
 * JD-Core Version:    0.7.0.1
 */
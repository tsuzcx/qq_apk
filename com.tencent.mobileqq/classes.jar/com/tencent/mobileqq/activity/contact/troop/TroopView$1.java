package com.tencent.mobileqq.activity.contact.troop;

import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.troop.api.observer.TroopCommonlyUsedObserver;
import com.tencent.mobileqq.widget.QQToast;

class TroopView$1
  extends TroopCommonlyUsedObserver
{
  TroopView$1(TroopView paramTroopView) {}
  
  protected void a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    if (paramInt2 == 0)
    {
      this.a.j();
      return;
    }
    if (!this.a.a())
    {
      paramString1 = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramString1 = this.a.getResources().getString(2131694666);
      }
      QQToast.a(this.a.a(), 1, paramString1, 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopView.1
 * JD-Core Version:    0.7.0.1
 */
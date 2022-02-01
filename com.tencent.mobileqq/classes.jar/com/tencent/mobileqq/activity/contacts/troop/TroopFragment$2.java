package com.tencent.mobileqq.activity.contacts.troop;

import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.troop.api.observer.TroopCommonlyUsedObserver;
import com.tencent.mobileqq.widget.QQToast;

class TroopFragment$2
  extends TroopCommonlyUsedObserver
{
  TroopFragment$2(TroopFragment paramTroopFragment) {}
  
  protected void a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    if (paramInt2 == 0)
    {
      this.a.j();
      if (this.a.isResumed())
      {
        if (paramInt1 == 0)
        {
          QQToast.makeText(this.a.getActivity(), 2, HardCodeUtil.a(2131912652), 0).show();
          return;
        }
        if (paramInt1 == 1) {
          QQToast.makeText(this.a.getActivity(), 2, HardCodeUtil.a(2131912651), 0).show();
        }
      }
    }
    else if (this.a.isResumed())
    {
      paramString1 = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramString1 = this.a.getResources().getString(2131892358);
      }
      QQToast.makeText(this.a.getActivity(), 1, paramString1, 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.troop.TroopFragment.2
 * JD-Core Version:    0.7.0.1
 */
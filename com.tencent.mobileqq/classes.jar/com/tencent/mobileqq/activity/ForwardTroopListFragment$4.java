package com.tencent.mobileqq.activity;

import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.troop.api.observer.TroopCommonlyUsedObserver;
import com.tencent.mobileqq.widget.QQToast;

class ForwardTroopListFragment$4
  extends TroopCommonlyUsedObserver
{
  ForwardTroopListFragment$4(ForwardTroopListFragment paramForwardTroopListFragment) {}
  
  protected void a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    if (paramInt2 == 0)
    {
      this.a.a();
      if (this.a.isResumed())
      {
        if (paramInt1 == 0)
        {
          QQToast.a(this.a.getActivity(), 2, HardCodeUtil.a(2131704941), 0).a();
          return;
        }
        if (paramInt1 == 1) {
          QQToast.a(this.a.getActivity(), 2, HardCodeUtil.a(2131704940), 0).a();
        }
      }
    }
    else if (this.a.isResumed())
    {
      paramString1 = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramString1 = this.a.getResources().getString(2131694666);
      }
      QQToast.a(this.a.getBaseActivity(), 1, paramString1, 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardTroopListFragment.4
 * JD-Core Version:    0.7.0.1
 */
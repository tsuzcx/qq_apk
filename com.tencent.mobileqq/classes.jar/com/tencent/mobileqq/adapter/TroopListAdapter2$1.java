package com.tencent.mobileqq.adapter;

import android.content.Context;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.troop.showexternal.api.TroopShowExternalObserver;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.Switch;
import java.util.HashMap;

class TroopListAdapter2$1
  extends TroopShowExternalObserver
{
  TroopListAdapter2$1(TroopListAdapter2 paramTroopListAdapter2, TroopActivity paramTroopActivity) {}
  
  protected void a(boolean paramBoolean, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!paramBoolean)
    {
      Object localObject = this.a;
      QQToast.makeText((Context)localObject, ((TroopActivity)localObject).getString(2131893960), 0).show(this.a.getTitleBarHeight());
      if ((this.b.t != null) && (this.b.t.containsKey(paramString)))
      {
        localObject = (Switch)this.b.t.get(paramString);
        if (this.b.s != null) {
          ((Switch)localObject).setChecked(this.b.s.q(paramString));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.TroopListAdapter2.1
 * JD-Core Version:    0.7.0.1
 */
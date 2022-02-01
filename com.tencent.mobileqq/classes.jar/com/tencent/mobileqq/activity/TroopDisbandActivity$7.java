package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressNotifier;

class TroopDisbandActivity$7
  extends TroopMngObserver
{
  TroopDisbandActivity$7(TroopDisbandActivity paramTroopDisbandActivity) {}
  
  protected void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 9)
    {
      Object localObject = this.a;
      ((TroopDisbandActivity)localObject).p &= 0xFFFFFFFE;
      if (paramInt2 == 8)
      {
        if (this.a.w != null) {
          this.a.w.b();
        }
        localObject = DialogUtil.a(this.a, 230);
        ((QQCustomDialog)localObject).setTitle(this.a.getString(2131893895));
        ((QQCustomDialog)localObject).setMessage(this.a.getString(2131893896));
        ((QQCustomDialog)localObject).setNegativeButton(this.a.getString(2131893928), new TroopDisbandActivity.7.1(this, (QQCustomDialog)localObject));
        ((QQCustomDialog)localObject).setPositiveButton(this.a.getString(2131916601), new TroopDisbandActivity.7.2(this, (QQCustomDialog)localObject));
        ((QQCustomDialog)localObject).show();
        return;
      }
      if (this.a.w == null)
      {
        localObject = this.a;
        ((TroopDisbandActivity)localObject).w = new QQProgressNotifier((Activity)localObject);
      }
      this.a.w.b(2, 2131889057, 1500);
    }
  }
  
  protected void a(int paramInt1, int paramInt2, String paramString)
  {
    if (!Utils.a(paramString, this.a.k)) {
      return;
    }
    if (paramInt1 == 9)
    {
      paramString = this.a;
      paramString.p &= 0xFFFFFFFE;
      if (paramInt2 == 0)
      {
        if (this.a.w != null) {
          this.a.w.b();
        }
        paramString = new Intent();
        paramString.putExtra("isNeedFinish", true);
        paramString.putExtra("fin_tip_msg", this.a.getString(2131889067));
        this.a.setResult(-1, paramString);
        this.a.finish();
        return;
      }
      if (this.a.w == null)
      {
        paramString = this.a;
        paramString.w = new QQProgressNotifier(paramString);
      }
      this.a.w.b(2, 2131889057, 1500);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopDisbandActivity.7
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity;

import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressNotifier;

class TroopTransferActivity$5
  extends TroopMngObserver
{
  TroopTransferActivity$5(TroopTransferActivity paramTroopTransferActivity) {}
  
  protected void a(boolean paramBoolean, long paramLong, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    if (Utils.a(String.valueOf(paramLong), this.a.r))
    {
      if (!Utils.a(paramString1, this.a.app.getCurrentAccountUin())) {
        return;
      }
      paramString1 = this.a;
      paramString1.w = false;
      if (paramBoolean)
      {
        if (paramString1.x != null) {
          this.a.x.b();
        }
        paramString1 = (TroopManager)this.a.app.getManager(QQManagerFactory.TROOP_MANAGER);
        paramString3 = new StringBuilder();
        paramString3.append(paramLong);
        paramString3.append("");
        paramString3 = paramString1.f(paramString3.toString());
        if (paramString3 != null)
        {
          paramString3.dwAdditionalFlag = 0L;
          paramString1.b(paramString3);
        }
        paramString1 = new Intent();
        paramString1.putExtra("isNeedFinish", true);
        paramString1.putExtra("fin_tip_msg", this.a.getString(2131917435));
        paramString1.putExtra("uin", paramString2);
        this.a.setResult(-1, paramString1);
        this.a.finish();
        return;
      }
      if ((paramInt != 1) && (paramInt != 2) && (paramInt != 6) && (paramInt != 8) && (paramInt != 9) && (paramInt != 10) && (paramInt != 11))
      {
        if ((paramInt != 3) && (paramInt != 4) && (paramInt != 7) && (paramInt != 16) && (paramInt != 19))
        {
          if ((paramInt != 5) && (paramInt != 17) && (paramInt != 18))
          {
            if (paramInt == 12)
            {
              if (paramString1.x != null) {
                this.a.x.b();
              }
              paramString1 = DialogUtil.a(this.a, 230);
              paramString1.setTitle(this.a.getString(2131893985));
              paramString1.setMessage(this.a.getString(2131893986));
              paramString1.setNegativeButton(this.a.getString(2131893928), new TroopTransferActivity.5.1(this, paramString1));
              paramString1.setPositiveButton(this.a.getString(2131916601), new TroopTransferActivity.5.2(this, paramString1));
              paramString1.show();
              return;
            }
            paramString1 = paramString1.getString(2131917422);
          }
          else
          {
            paramString1 = this.a.getString(2131917422);
          }
        }
        else {
          paramString1 = this.a.getString(2131917423);
        }
      }
      else {
        paramString1 = this.a.getString(2131917421);
      }
      if (this.a.x == null)
      {
        paramString2 = this.a;
        paramString2.x = new QQProgressNotifier(paramString2);
      }
      this.a.x.a(2, paramString1, 1500);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopTransferActivity.5
 * JD-Core Version:    0.7.0.1
 */
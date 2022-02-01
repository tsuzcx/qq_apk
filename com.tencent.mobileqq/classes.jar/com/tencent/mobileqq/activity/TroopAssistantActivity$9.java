package com.tencent.mobileqq.activity;

import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.troop.api.observer.TroopCommonlyUsedObserver;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class TroopAssistantActivity$9
  extends TroopCommonlyUsedObserver
{
  TroopAssistantActivity$9(TroopAssistantActivity paramTroopAssistantActivity) {}
  
  protected void a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    if (paramInt2 != 0)
    {
      paramString1 = paramString2;
      if (!this.a.isFinishing())
      {
        paramString1 = paramString2;
        if (this.a.isResume())
        {
          paramString1 = paramString2;
          if (TextUtils.isEmpty(paramString2)) {
            paramString1 = this.a.getResources().getString(2131892358);
          }
          QQToast.makeText(this.a, 1, paramString1, 0).show();
        }
      }
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("onSetCommonUsedTroop error, retCode = ");
        paramString2.append(paramInt2);
        paramString2.append(" , wording = ");
        paramString2.append(paramString1);
        QLog.e("TroopAssistantActivity", 2, paramString2.toString());
      }
    }
    else
    {
      this.a.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopAssistantActivity.9
 * JD-Core Version:    0.7.0.1
 */
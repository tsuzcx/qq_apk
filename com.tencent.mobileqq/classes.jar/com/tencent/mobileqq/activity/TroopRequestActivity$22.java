package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.res.Resources;
import android.widget.LinearLayout;
import com.tencent.mobileqq.app.StrangerObserver;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.widget.QQToast;
import tencent.im.oidb.cmd0x5d4.oidb_0x5d4.DelResult;

class TroopRequestActivity$22
  extends StrangerObserver
{
  TroopRequestActivity$22(TroopRequestActivity paramTroopRequestActivity) {}
  
  public void a(boolean paramBoolean, PBRepeatMessageField<oidb_0x5d4.DelResult> paramPBRepeatMessageField)
  {
    if (this.a.isFinishing()) {
      return;
    }
    if (paramBoolean)
    {
      QQToast.a(this.a.getApplicationContext(), 2, this.a.getApplicationContext().getResources().getString(2131719440), 0).a();
      this.a.c.setVisibility(8);
      return;
    }
    QQToast.a(this.a.getApplicationContext(), 1, this.a.getApplicationContext().getResources().getString(2131719437), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopRequestActivity.22
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity.aio;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.tencent.mobileqq.data.IntimateInfo;

class IntimateInfoView$12
  implements DialogInterface.OnClickListener
{
  IntimateInfoView$12(IntimateInfoView paramIntimateInfoView) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((!TextUtils.isEmpty(this.a.d)) && (IntimateInfoView.c(this.a) != null))
    {
      if (IntimateInfoView.m(this.a) == 1)
      {
        paramDialogInterface = this.a;
        IntimateInfoView.b(paramDialogInterface, paramDialogInterface.d);
        return;
      }
      paramDialogInterface = this.a;
      IntimateInfoView.a(paramDialogInterface, paramDialogInterface.d, IntimateInfoView.c(this.a).maskType);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.IntimateInfoView.12
 * JD-Core Version:    0.7.0.1
 */
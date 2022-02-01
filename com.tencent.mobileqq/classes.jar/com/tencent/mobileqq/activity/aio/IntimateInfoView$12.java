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
    if ((!TextUtils.isEmpty(this.a.a)) && (IntimateInfoView.a(this.a) != null))
    {
      if (IntimateInfoView.a(this.a) == 1)
      {
        paramDialogInterface = this.a;
        IntimateInfoView.b(paramDialogInterface, paramDialogInterface.a);
        return;
      }
      paramDialogInterface = this.a;
      IntimateInfoView.a(paramDialogInterface, paramDialogInterface.a, IntimateInfoView.a(this.a).maskType);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.IntimateInfoView.12
 * JD-Core Version:    0.7.0.1
 */
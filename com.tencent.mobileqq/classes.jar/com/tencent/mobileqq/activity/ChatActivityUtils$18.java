package com.tencent.mobileqq.activity;

import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.vip.CUKingCardHelper.CUKingDialogListener;
import com.tencent.qphone.base.util.QLog;

final class ChatActivityUtils$18
  implements CUKingCardHelper.CUKingDialogListener
{
  ChatActivityUtils$18(DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2) {}
  
  public void callback(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivityUtils", 2, "showDlgWithCuOpenCheck type = " + paramInt);
    }
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
    case 2: 
      this.a.onClick(null, 0);
      return;
    }
    this.b.onClick(null, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityUtils.18
 * JD-Core Version:    0.7.0.1
 */
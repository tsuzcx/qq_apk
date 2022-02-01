package com.tencent.mobileqq.activity;

import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.vip.CUKingCardHelper.CUKingDialogListener;
import com.tencent.qphone.base.util.QLog;

final class ChatActivityUtils$17
  implements CUKingCardHelper.CUKingDialogListener
{
  ChatActivityUtils$17(DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2) {}
  
  public void callback(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showDlgWithCuOpenCheck type = ");
      localStringBuilder.append(paramInt);
      QLog.d("ChatActivityUtils", 2, localStringBuilder.toString());
    }
    if ((paramInt != 1) && (paramInt != 2))
    {
      if ((paramInt != 3) && (paramInt != 4)) {
        return;
      }
      this.b.onClick(null, 0);
      return;
    }
    this.a.onClick(null, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityUtils.17
 * JD-Core Version:    0.7.0.1
 */
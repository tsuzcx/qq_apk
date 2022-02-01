package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.utils.DataReport;

final class ChatActivityUtils$4
  implements DialogInterface.OnClickListener
{
  ChatActivityUtils$4(ChatActivityUtils.StartVideoListener paramStartVideoListener) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ChatActivityUtils.StartVideoListener localStartVideoListener = this.a;
    if (localStartVideoListener != null) {
      localStartVideoListener.a();
    }
    DataReport.e(true, false);
    paramDialogInterface.dismiss();
    DataReport.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityUtils.4
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QAVHrMeeting;

final class ChatActivityUtils$8
  implements DialogInterface.OnClickListener
{
  ChatActivityUtils$8(ChatActivityUtils.StartVideoListener paramStartVideoListener, String paramString, int paramInt, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Object localObject = this.a;
    if (localObject != null) {
      ((ChatActivityUtils.StartVideoListener)localObject).a();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append("");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.c);
    localStringBuilder.append("");
    ReportController.b(null, "dc00899", "Grp_video", "", "video_jump", "Clk_jump", 0, 0, (String)localObject, localStringBuilder.toString(), "1", "");
    QAVHrMeeting.a(this.d, Long.valueOf(this.b).longValue(), null);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityUtils.8
 * JD-Core Version:    0.7.0.1
 */
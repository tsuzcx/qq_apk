package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;

final class ChatActivityUtils$7
  implements DialogInterface.OnClickListener
{
  ChatActivityUtils$7(long paramLong, QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener, String paramString, int paramInt3) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ChatActivityUtils.a(this.a, this.b, this.c, this.d, this.e);
    this.f.onClick(paramDialogInterface, paramInt);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.g);
    ((StringBuilder)localObject).append("");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.h);
    localStringBuilder.append("");
    ReportController.b(null, "dc00899", "Grp_video", "", "video_jump", "Clk_jump", 0, 0, (String)localObject, localStringBuilder.toString(), "0", "");
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityUtils.7
 * JD-Core Version:    0.7.0.1
 */
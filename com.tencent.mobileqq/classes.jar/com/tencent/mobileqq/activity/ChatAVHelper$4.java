package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.INearbyRelevantHandler;
import com.tencent.mobileqq.nearby.NearbyManagerHelper;
import com.tencent.mobileqq.nearby.api.INearbyProxy;
import com.tencent.mobileqq.statistics.ReportController;

final class ChatAVHelper$4
  implements DialogInterface.OnClickListener
{
  ChatAVHelper$4(QQAppInterface paramQQAppInterface, ChatActivityUtils.VideoCheckFlag paramVideoCheckFlag, long paramLong, Context paramContext, ChatActivityUtils.StartVideoListener paramStartVideoListener) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Object localObject = (INearbyRelevantHandler)this.a.getBusinessHandler(BusinessHandlerFactory.NEARBY_RELEVANT_HANDLER);
    if (localObject != null) {
      ((INearbyRelevantHandler)localObject).a((byte)0);
    }
    NearbyManagerHelper.a(this.a).b(true);
    if (this.b.e) {
      ReportController.b(null, "CliOper", "", "", "Two_call", "Clk_shield_btn", 0, 0, "1", "", "", "");
    }
    localObject = this.b;
    ((ChatActivityUtils.VideoCheckFlag)localObject).l = false;
    ChatActivityUtils.a(this.c, this.a, this.d, this.e, (ChatActivityUtils.VideoCheckFlag)localObject);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatAVHelper.4
 * JD-Core Version:    0.7.0.1
 */
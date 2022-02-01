package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.ark.api.IArkAPIService;
import com.tencent.mobileqq.qroute.QRoute;

class LimitChatPie$13
  implements DialogInterface.OnDismissListener
{
  LimitChatPie$13(LimitChatPie paramLimitChatPie) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    ((IArkAPIService)QRoute.api(IArkAPIService.class)).registerAppNotification("com.tencent.mobileqq.expand.aiosafe", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.13
 * JD-Core Version:    0.7.0.1
 */
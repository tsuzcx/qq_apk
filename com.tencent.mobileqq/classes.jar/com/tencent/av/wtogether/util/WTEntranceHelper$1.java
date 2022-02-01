package com.tencent.av.wtogether.util;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils;
import com.tencent.qphone.base.util.QLog;

class WTEntranceHelper$1
  implements DialogInterface.OnClickListener
{
  WTEntranceHelper$1(WTEntranceHelper paramWTEntranceHelper) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      PlusPanelUtils.a(WTEntranceHelper.a(this.a).i(), WTEntranceHelper.a(this.a).aX(), WTEntranceHelper.a(this.a).aE(), true, "AIOQAVWatchTogether", null);
      return;
    }
    QLog.e(WTEntranceHelper.a, 1, "permission deny");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.util.WTEntranceHelper.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.av.wtogether.util;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.wtogether.data.ChooseFileInfo;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils;
import com.tencent.qphone.base.util.QLog;

class WTEntranceHelper$2
  implements DialogInterface.OnClickListener
{
  WTEntranceHelper$2(WTEntranceHelper paramWTEntranceHelper, int paramInt1, ChooseFileInfo paramChooseFileInfo, int paramInt2, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      if (this.a == 3) {
        ChooseFileAssistant.a().a(WTEntranceHelper.a(this.e).aE().a, WTEntranceHelper.a(this.e).aE().b, this.b);
      } else {
        ChooseFileAssistant.a().a(this.c, this.d, this.b);
      }
      PlusPanelUtils.a(WTEntranceHelper.a(this.e).i(), WTEntranceHelper.a(this.e).aX(), WTEntranceHelper.a(this.e).aE(), true, "AIOQAVWatchTogether", null);
      return;
    }
    QLog.e(WTEntranceHelper.a, 1, "deny permission");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.util.WTEntranceHelper.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.lebasearch;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;

final class Utils$3
  implements DialogInterface.OnClickListener
{
  Utils$3(int paramInt, ILebaHelperService paramILebaHelperService, QQAppInterface paramQQAppInterface, long paramLong, Handler paramHandler) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a == 1)
    {
      paramDialogInterface = this.b;
      if (paramDialogInterface != null) {
        paramDialogInterface.updateAppSetting(this.c, this.d, true, NetConnInfoCenter.getServerTimeMillis(), -9223372036854775808L);
      }
      this.e.sendEmptyMessage(0);
      paramDialogInterface = (ILebaHelperService)this.c.getRuntimeService(ILebaHelperService.class, "multi");
      l = NetConnInfoCenter.getServerTimeMillis();
      paramDialogInterface.netSetPluginState(String.valueOf(this.d), true, l);
      return;
    }
    paramDialogInterface = this.b;
    if (paramDialogInterface != null) {
      paramDialogInterface.updateAppSetting(this.c, this.d, false, NetConnInfoCenter.getServerTimeMillis(), -9223372036854775808L);
    }
    this.e.sendEmptyMessage(1);
    paramDialogInterface = (ILebaHelperService)this.c.getRuntimeService(ILebaHelperService.class, "multi");
    long l = NetConnInfoCenter.getServerTimeMillis();
    paramDialogInterface.netSetPluginState(String.valueOf(this.d), false, l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.lebasearch.Utils.3
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.gdtad.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.ad.tangram.account.AdAccount;
import com.tencent.ad.tangram.analysis.AdUin;

class GdtManager$1$1
  extends BroadcastReceiver
{
  GdtManager$1$1(GdtManager.1 param1) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AdAccount.INSTANCE.onAccountStatusChanged(paramIntent.getAction(), AdUin.INSTANCE.getUIN());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.util.GdtManager.1.1
 * JD-Core Version:    0.7.0.1
 */
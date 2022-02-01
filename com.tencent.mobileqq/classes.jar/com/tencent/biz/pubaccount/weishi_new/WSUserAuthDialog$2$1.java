package com.tencent.biz.pubaccount.weishi_new;

import android.os.Bundle;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.mobileqq.mini.api.MiniAppLaunchListener;

class WSUserAuthDialog$2$1
  implements MiniAppLaunchListener
{
  WSUserAuthDialog$2$1(WSUserAuthDialog.2 param2) {}
  
  public void onLaunchResult(boolean paramBoolean, Bundle paramBundle)
  {
    WSLog.a("WSUserAuthDialog", "jump to miniApp result = " + paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSUserAuthDialog.2.1
 * JD-Core Version:    0.7.0.1
 */
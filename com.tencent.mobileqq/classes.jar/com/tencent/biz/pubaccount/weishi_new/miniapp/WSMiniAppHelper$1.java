package com.tencent.biz.pubaccount.weishi_new.miniapp;

import android.os.Bundle;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.mobileqq.mini.api.MiniAppLaunchListener;

class WSMiniAppHelper$1
  implements MiniAppLaunchListener
{
  WSMiniAppHelper$1(WSMiniAppHelper paramWSMiniAppHelper) {}
  
  public void onLaunchResult(boolean paramBoolean, Bundle paramBundle)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("launch mini program ");
    if (paramBoolean) {}
    for (String str = "success";; str = "fail")
    {
      WSLog.d("WSMiniAppHelper", str + ", bundle: " + paramBundle.toString());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.miniapp.WSMiniAppHelper.1
 * JD-Core Version:    0.7.0.1
 */
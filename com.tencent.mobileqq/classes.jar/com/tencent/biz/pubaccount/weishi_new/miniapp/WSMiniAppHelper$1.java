package com.tencent.biz.pubaccount.weishi_new.miniapp;

import android.os.Bundle;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.mobileqq.mini.api.MiniAppLaunchListener;

class WSMiniAppHelper$1
  implements MiniAppLaunchListener
{
  public void onLaunchResult(boolean paramBoolean, Bundle paramBundle)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("launch mini program ");
    String str;
    if (paramBoolean) {
      str = "success";
    } else {
      str = "fail";
    }
    localStringBuilder.append(str);
    localStringBuilder.append(", bundle: ");
    localStringBuilder.append(paramBundle.toString());
    WSLog.d("WSMiniAppHelper", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.miniapp.WSMiniAppHelper.1
 * JD-Core Version:    0.7.0.1
 */
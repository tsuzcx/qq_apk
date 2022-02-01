package com.tencent.biz.pubaccount.weishi_new;

import android.os.Bundle;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.mobileqq.mini.api.MiniAppLaunchListener;

class WSHomeFragment$9
  implements MiniAppLaunchListener
{
  WSHomeFragment$9(WSHomeFragment paramWSHomeFragment) {}
  
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
    WSLog.d("WSHomeFragmentLog", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSHomeFragment.9
 * JD-Core Version:    0.7.0.1
 */
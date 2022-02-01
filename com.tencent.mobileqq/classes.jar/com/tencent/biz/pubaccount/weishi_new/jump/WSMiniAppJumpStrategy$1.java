package com.tencent.biz.pubaccount.weishi_new.jump;

import android.os.Bundle;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.mobileqq.mini.api.MiniAppLaunchListener;

class WSMiniAppJumpStrategy$1
  implements MiniAppLaunchListener
{
  WSMiniAppJumpStrategy$1(WSMiniAppJumpStrategy paramWSMiniAppJumpStrategy, MiniAppLaunchListener paramMiniAppLaunchListener) {}
  
  public void onLaunchResult(boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[WSMiniAppJumpStrategy.java][jumpAction] onLaunchResult isSuc:");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(", bundle:");
    ((StringBuilder)localObject).append(paramBundle);
    WSLog.e("WSMiniAppJumpStrategy", ((StringBuilder)localObject).toString());
    localObject = this.a;
    if (localObject != null) {
      ((MiniAppLaunchListener)localObject).onLaunchResult(paramBoolean, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.jump.WSMiniAppJumpStrategy.1
 * JD-Core Version:    0.7.0.1
 */
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
    WSLog.e("WSMiniAppJumpStrategy", "[WSMiniAppJumpStrategy.java][jumpAction] onLaunchResult isSuc:" + paramBoolean + ", bundle:" + paramBundle);
    if (this.jdField_a_of_type_ComTencentMobileqqMiniApiMiniAppLaunchListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqMiniApiMiniAppLaunchListener.onLaunchResult(paramBoolean, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.jump.WSMiniAppJumpStrategy.1
 * JD-Core Version:    0.7.0.1
 */
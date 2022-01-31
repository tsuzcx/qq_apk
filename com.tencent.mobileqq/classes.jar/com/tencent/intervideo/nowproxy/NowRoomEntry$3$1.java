package com.tencent.intervideo.nowproxy;

import android.view.View;
import com.tencent.intervideo.nowproxy.ability.SdkBaseAbilityImpl;
import com.tencent.intervideo.nowproxy.common.log.XLog;

class NowRoomEntry$3$1
  implements Runnable
{
  NowRoomEntry$3$1(NowRoomEntry.3 param3, View paramView) {}
  
  public void run()
  {
    XLog.i("NowPluginManager | NowRoomEntry", "enterShadowSdk onShowLoadingView");
    SdkBaseAbilityImpl.getsInstance().showLoadingUI(this.this$1.this$0.mGlobalContext, this.this$1.val$extras, this.val$view);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.intervideo.nowproxy.NowRoomEntry.3.1
 * JD-Core Version:    0.7.0.1
 */
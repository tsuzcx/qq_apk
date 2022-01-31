package com.tencent.mm.opensdk.openapi;

import android.util.Log;
import com.tencent.wxop.stat.StatService;

class WXApiImplV10$ActivityLifecycleCb$1
  implements Runnable
{
  WXApiImplV10$ActivityLifecycleCb$1(WXApiImplV10.ActivityLifecycleCb paramActivityLifecycleCb) {}
  
  public void run()
  {
    if ((WXApiImplV10.access$100() != null) && (WXApiImplV10.ActivityLifecycleCb.access$200(this.this$0)))
    {
      Log.v("MicroMsg.SDK.WXApiImplV10.ActivityLifecycleCb", "WXStat trigger onBackground");
      StatService.trackCustomKVEvent(WXApiImplV10.ActivityLifecycleCb.access$300(this.this$0), "onBackground_WX", null);
      WXApiImplV10.ActivityLifecycleCb.access$202(this.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mm.opensdk.openapi.WXApiImplV10.ActivityLifecycleCb.1
 * JD-Core Version:    0.7.0.1
 */
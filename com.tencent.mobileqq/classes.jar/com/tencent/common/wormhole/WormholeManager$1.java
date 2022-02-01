package com.tencent.common.wormhole;

import android.text.TextUtils;
import com.tencent.mtt.hippy.common.HippyMap;
import java.util.concurrent.ConcurrentHashMap;

class WormholeManager$1
  implements Runnable
{
  WormholeManager$1(WormholeManager paramWormholeManager, String paramString, Integer paramInteger, int paramInt, HippyMap paramHippyMap) {}
  
  public void run()
  {
    if ((WormholeManager.a(this.this$0) != null) && (!TextUtils.isEmpty(this.a)))
    {
      if (WormholeManager.b(this.this$0).containsKey(this.a)) {
        return;
      }
      WormholeManager.b(this.this$0).put(this.a, this.b);
      WormholeManager.c(this.this$0).put(this.a, Integer.valueOf(this.c));
      WormholeManager.a(this.this$0, this.d, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.wormhole.WormholeManager.1
 * JD-Core Version:    0.7.0.1
 */
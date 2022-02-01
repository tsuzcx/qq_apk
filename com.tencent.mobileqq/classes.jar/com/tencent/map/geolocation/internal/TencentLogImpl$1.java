package com.tencent.map.geolocation.internal;

import android.os.Handler;
import android.os.HandlerThread;

class TencentLogImpl$1
  implements Runnable
{
  TencentLogImpl$1(TencentLogImpl paramTencentLogImpl) {}
  
  public void run()
  {
    if (TencentLogImpl.access$100(this.this$0))
    {
      TencentLogImpl.access$202(this.this$0, false);
      TencentLogImpl.access$300(this.this$0).removeCallbacksAndMessages(null);
      TencentLogImpl.access$400(this.this$0).quit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.map.geolocation.internal.TencentLogImpl.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.map.sdk.a;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.SnapshotReadyCallback;

final class ki$1
  extends Handler
{
  ki$1(ki paramki, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    if ((paramMessage != null) && (paramMessage.what == 0))
    {
      if (this.a.b != null)
      {
        paramMessage = (Bitmap)paramMessage.obj;
        this.a.b.onSnapshotReady(paramMessage);
      }
      this.a.b = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.map.sdk.a.ki.1
 * JD-Core Version:    0.7.0.1
 */
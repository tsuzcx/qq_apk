package com.tencent.live2.b;

import android.graphics.Bitmap;
import com.tencent.live2.V2TXLivePlayerObserver;
import com.tencent.trtc.TRTCCloudListener.TRTCSnapshotListener;
import java.util.Map;

class f$32
  implements TRTCCloudListener.TRTCSnapshotListener
{
  f$32(f paramf, int paramInt, String paramString) {}
  
  public void onSnapshotComplete(Bitmap paramBitmap)
  {
    f.b localb = (f.b)f.a(this.c, this.a).get(this.b);
    if ((localb != null) && (localb.f != null) && (localb.g != null)) {
      localb.f.onSnapshotComplete(localb.g, paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.live2.b.f.32
 * JD-Core Version:    0.7.0.1
 */
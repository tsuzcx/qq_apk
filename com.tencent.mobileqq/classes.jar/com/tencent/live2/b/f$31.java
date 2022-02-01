package com.tencent.live2.b;

import android.graphics.Bitmap;
import com.tencent.live2.V2TXLivePusherObserver;
import com.tencent.trtc.TRTCCloudListener.TRTCSnapshotListener;

class f$31
  implements TRTCCloudListener.TRTCSnapshotListener
{
  f$31(f paramf) {}
  
  public void onSnapshotComplete(Bitmap paramBitmap)
  {
    V2TXLivePusherObserver localV2TXLivePusherObserver = f.b(this.a);
    if (localV2TXLivePusherObserver != null) {
      localV2TXLivePusherObserver.onSnapshotComplete(paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.live2.b.f.31
 * JD-Core Version:    0.7.0.1
 */
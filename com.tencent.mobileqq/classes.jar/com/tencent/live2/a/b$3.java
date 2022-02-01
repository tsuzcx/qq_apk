package com.tencent.live2.a;

import android.graphics.Bitmap;
import com.tencent.live2.V2TXLivePusherObserver;
import com.tencent.rtmp.TXLivePusher.ITXSnapshotListener;

class b$3
  implements TXLivePusher.ITXSnapshotListener
{
  b$3(b paramb) {}
  
  public void onSnapshot(Bitmap paramBitmap)
  {
    V2TXLivePusherObserver localV2TXLivePusherObserver = b.b(this.a);
    if (localV2TXLivePusherObserver != null) {
      localV2TXLivePusherObserver.onSnapshotComplete(paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.live2.a.b.3
 * JD-Core Version:    0.7.0.1
 */
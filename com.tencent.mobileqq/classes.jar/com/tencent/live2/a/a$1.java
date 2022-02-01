package com.tencent.live2.a;

import android.graphics.Bitmap;
import com.tencent.live2.V2TXLivePlayerObserver;
import com.tencent.rtmp.TXLivePlayer.ITXSnapshotListener;

class a$1
  implements TXLivePlayer.ITXSnapshotListener
{
  a$1(a parama) {}
  
  public void onSnapshot(Bitmap paramBitmap)
  {
    V2TXLivePlayerObserver localV2TXLivePlayerObserver = a.a(this.a);
    if (localV2TXLivePlayerObserver != null) {
      localV2TXLivePlayerObserver.onSnapshotComplete(a.b(this.a), paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.live2.a.a.1
 * JD-Core Version:    0.7.0.1
 */
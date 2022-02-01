package com.google.android.exoplayer2.drm;

import android.os.Message;

class DefaultDrmSessionManager$MediaDrmEventListener
  implements ExoMediaDrm.OnEventListener<T>
{
  private DefaultDrmSessionManager$MediaDrmEventListener(DefaultDrmSessionManager paramDefaultDrmSessionManager) {}
  
  public void onEvent(ExoMediaDrm<? extends T> paramExoMediaDrm, byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2)
  {
    if (DefaultDrmSessionManager.access$400(this.this$0) == 0) {
      this.this$0.mediaDrmHandler.obtainMessage(paramInt1, paramArrayOfByte1).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.drm.DefaultDrmSessionManager.MediaDrmEventListener
 * JD-Core Version:    0.7.0.1
 */
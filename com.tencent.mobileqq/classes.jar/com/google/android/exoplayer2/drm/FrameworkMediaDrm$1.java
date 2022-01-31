package com.google.android.exoplayer2.drm;

import android.media.MediaDrm;
import android.media.MediaDrm.OnEventListener;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

class FrameworkMediaDrm$1
  implements MediaDrm.OnEventListener
{
  FrameworkMediaDrm$1(FrameworkMediaDrm paramFrameworkMediaDrm, ExoMediaDrm.OnEventListener paramOnEventListener) {}
  
  public void onEvent(@NonNull MediaDrm paramMediaDrm, @Nullable byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2)
  {
    this.val$listener.onEvent(this.this$0, paramArrayOfByte1, paramInt1, paramInt2, paramArrayOfByte2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.drm.FrameworkMediaDrm.1
 * JD-Core Version:    0.7.0.1
 */
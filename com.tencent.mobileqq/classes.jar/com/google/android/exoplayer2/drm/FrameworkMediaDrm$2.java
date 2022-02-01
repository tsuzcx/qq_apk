package com.google.android.exoplayer2.drm;

import android.media.MediaDrm;
import android.media.MediaDrm.KeyStatus;
import android.media.MediaDrm.OnKeyStatusChangeListener;
import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class FrameworkMediaDrm$2
  implements MediaDrm.OnKeyStatusChangeListener
{
  FrameworkMediaDrm$2(FrameworkMediaDrm paramFrameworkMediaDrm, ExoMediaDrm.OnKeyStatusChangeListener paramOnKeyStatusChangeListener) {}
  
  public void onKeyStatusChange(@NonNull MediaDrm paramMediaDrm, @NonNull byte[] paramArrayOfByte, @NonNull List<MediaDrm.KeyStatus> paramList, boolean paramBoolean)
  {
    paramMediaDrm = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MediaDrm.KeyStatus localKeyStatus = (MediaDrm.KeyStatus)paramList.next();
      paramMediaDrm.add(new ExoMediaDrm.DefaultKeyStatus(localKeyStatus.getStatusCode(), localKeyStatus.getKeyId()));
    }
    this.val$listener.onKeyStatusChange(this.this$0, paramArrayOfByte, paramMediaDrm, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.drm.FrameworkMediaDrm.2
 * JD-Core Version:    0.7.0.1
 */
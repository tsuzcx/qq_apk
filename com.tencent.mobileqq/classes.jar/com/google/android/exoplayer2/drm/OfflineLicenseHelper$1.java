package com.google.android.exoplayer2.drm;

import android.os.ConditionVariable;

class OfflineLicenseHelper$1
  implements DefaultDrmSessionManager.EventListener
{
  OfflineLicenseHelper$1(OfflineLicenseHelper paramOfflineLicenseHelper) {}
  
  public void onDrmKeysLoaded()
  {
    OfflineLicenseHelper.access$000(this.this$0).open();
  }
  
  public void onDrmKeysRemoved()
  {
    OfflineLicenseHelper.access$000(this.this$0).open();
  }
  
  public void onDrmKeysRestored()
  {
    OfflineLicenseHelper.access$000(this.this$0).open();
  }
  
  public void onDrmSessionManagerError(Exception paramException)
  {
    OfflineLicenseHelper.access$000(this.this$0).open();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.drm.OfflineLicenseHelper.1
 * JD-Core Version:    0.7.0.1
 */
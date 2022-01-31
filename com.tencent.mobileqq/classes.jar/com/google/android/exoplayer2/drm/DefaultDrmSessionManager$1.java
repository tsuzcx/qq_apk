package com.google.android.exoplayer2.drm;

class DefaultDrmSessionManager$1
  implements Runnable
{
  DefaultDrmSessionManager$1(DefaultDrmSessionManager paramDefaultDrmSessionManager, DefaultDrmSessionManager.MissingSchemeDataException paramMissingSchemeDataException) {}
  
  public void run()
  {
    DefaultDrmSessionManager.access$200(this.this$0).onDrmSessionManagerError(this.val$error);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.drm.DefaultDrmSessionManager.1
 * JD-Core Version:    0.7.0.1
 */
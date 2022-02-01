package com.google.android.exoplayer2.drm;

public abstract interface DefaultDrmSessionManager$EventListener
{
  public abstract void onDrmKeysLoaded();
  
  public abstract void onDrmKeysRemoved();
  
  public abstract void onDrmKeysRestored();
  
  public abstract void onDrmSessionManagerError(Exception paramException);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.drm.DefaultDrmSessionManager.EventListener
 * JD-Core Version:    0.7.0.1
 */
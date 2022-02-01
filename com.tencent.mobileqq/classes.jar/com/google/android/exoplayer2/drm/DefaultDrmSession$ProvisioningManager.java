package com.google.android.exoplayer2.drm;

public abstract interface DefaultDrmSession$ProvisioningManager<T extends ExoMediaCrypto>
{
  public abstract void onProvisionCompleted();
  
  public abstract void onProvisionError(Exception paramException);
  
  public abstract void provisionRequired(DefaultDrmSession<T> paramDefaultDrmSession);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.drm.DefaultDrmSession.ProvisioningManager
 * JD-Core Version:    0.7.0.1
 */
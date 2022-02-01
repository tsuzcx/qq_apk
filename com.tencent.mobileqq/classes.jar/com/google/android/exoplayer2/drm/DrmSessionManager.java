package com.google.android.exoplayer2.drm;

import android.annotation.TargetApi;
import android.os.Looper;

@TargetApi(16)
public abstract interface DrmSessionManager<T extends ExoMediaCrypto>
{
  public abstract DrmSession<T> acquireSession(Looper paramLooper, DrmInitData paramDrmInitData);
  
  public abstract boolean canAcquireSession(DrmInitData paramDrmInitData);
  
  public abstract void releaseSession(DrmSession<T> paramDrmSession);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.drm.DrmSessionManager
 * JD-Core Version:    0.7.0.1
 */
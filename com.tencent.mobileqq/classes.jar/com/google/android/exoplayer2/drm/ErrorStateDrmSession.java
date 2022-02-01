package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.util.Assertions;
import java.util.Map;

final class ErrorStateDrmSession<T extends ExoMediaCrypto>
  implements DrmSession<T>
{
  private final DrmSession.DrmSessionException error;
  
  public ErrorStateDrmSession(DrmSession.DrmSessionException paramDrmSessionException)
  {
    this.error = ((DrmSession.DrmSessionException)Assertions.checkNotNull(paramDrmSessionException));
  }
  
  public DrmSession.DrmSessionException getError()
  {
    return this.error;
  }
  
  public T getMediaCrypto()
  {
    return null;
  }
  
  public byte[] getOfflineLicenseKeySetId()
  {
    return null;
  }
  
  public int getState()
  {
    return 1;
  }
  
  public Map<String, String> queryKeyStatus()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.drm.ErrorStateDrmSession
 * JD-Core Version:    0.7.0.1
 */
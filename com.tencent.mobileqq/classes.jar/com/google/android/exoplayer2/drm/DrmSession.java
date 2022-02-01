package com.google.android.exoplayer2.drm;

import android.annotation.TargetApi;
import java.util.Map;

@TargetApi(16)
public abstract interface DrmSession<T extends ExoMediaCrypto>
{
  public static final int STATE_ERROR = 1;
  public static final int STATE_OPENED = 3;
  public static final int STATE_OPENED_WITH_KEYS = 4;
  public static final int STATE_OPENING = 2;
  public static final int STATE_RELEASED = 0;
  
  public abstract DrmSession.DrmSessionException getError();
  
  public abstract T getMediaCrypto();
  
  public abstract byte[] getOfflineLicenseKeySetId();
  
  public abstract int getState();
  
  public abstract Map<String, String> queryKeyStatus();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.drm.DrmSession
 * JD-Core Version:    0.7.0.1
 */
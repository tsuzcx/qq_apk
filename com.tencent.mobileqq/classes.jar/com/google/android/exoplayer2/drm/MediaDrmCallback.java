package com.google.android.exoplayer2.drm;

import java.util.UUID;

public abstract interface MediaDrmCallback
{
  public abstract byte[] executeKeyRequest(UUID paramUUID, ExoMediaDrm.KeyRequest paramKeyRequest);
  
  public abstract byte[] executeProvisionRequest(UUID paramUUID, ExoMediaDrm.ProvisionRequest paramProvisionRequest);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.drm.MediaDrmCallback
 * JD-Core Version:    0.7.0.1
 */
package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.util.Assertions;
import java.util.UUID;

public final class LocalMediaDrmCallback
  implements MediaDrmCallback
{
  private final byte[] keyResponse;
  
  public LocalMediaDrmCallback(byte[] paramArrayOfByte)
  {
    this.keyResponse = ((byte[])Assertions.checkNotNull(paramArrayOfByte));
  }
  
  public byte[] executeKeyRequest(UUID paramUUID, ExoMediaDrm.KeyRequest paramKeyRequest)
  {
    return this.keyResponse;
  }
  
  public byte[] executeProvisionRequest(UUID paramUUID, ExoMediaDrm.ProvisionRequest paramProvisionRequest)
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.drm.LocalMediaDrmCallback
 * JD-Core Version:    0.7.0.1
 */
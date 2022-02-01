package com.google.android.exoplayer2.drm;

import java.util.UUID;

public final class DefaultDrmSessionManager$MissingSchemeDataException
  extends Exception
{
  private DefaultDrmSessionManager$MissingSchemeDataException(UUID paramUUID)
  {
    super("Media does not support uuid: " + paramUUID);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.drm.DefaultDrmSessionManager.MissingSchemeDataException
 * JD-Core Version:    0.7.0.1
 */
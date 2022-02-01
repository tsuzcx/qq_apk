package com.google.android.exoplayer2.extractor.mp4;

import java.util.UUID;

class PsshAtomUtil$PsshAtom
{
  private final byte[] schemeData;
  private final UUID uuid;
  private final int version;
  
  public PsshAtomUtil$PsshAtom(UUID paramUUID, int paramInt, byte[] paramArrayOfByte)
  {
    this.uuid = paramUUID;
    this.version = paramInt;
    this.schemeData = paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil.PsshAtom
 * JD-Core Version:    0.7.0.1
 */
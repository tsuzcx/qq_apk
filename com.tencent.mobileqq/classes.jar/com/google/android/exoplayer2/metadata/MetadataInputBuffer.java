package com.google.android.exoplayer2.metadata;

import com.google.android.exoplayer2.decoder.DecoderInputBuffer;

public final class MetadataInputBuffer
  extends DecoderInputBuffer
{
  public long subsampleOffsetUs;
  
  public MetadataInputBuffer()
  {
    super(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.MetadataInputBuffer
 * JD-Core Version:    0.7.0.1
 */
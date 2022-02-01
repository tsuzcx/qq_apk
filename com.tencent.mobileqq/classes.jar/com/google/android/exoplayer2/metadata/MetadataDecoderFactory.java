package com.google.android.exoplayer2.metadata;

import com.google.android.exoplayer2.Format;

public abstract interface MetadataDecoderFactory
{
  public static final MetadataDecoderFactory DEFAULT = new MetadataDecoderFactory.1();
  
  public abstract MetadataDecoder createDecoder(Format paramFormat);
  
  public abstract boolean supportsFormat(Format paramFormat);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.MetadataDecoderFactory
 * JD-Core Version:    0.7.0.1
 */
package com.google.android.exoplayer2.ext.vp9;

import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.video.ColorInfo;

final class VpxInputBuffer
  extends DecoderInputBuffer
{
  public ColorInfo colorInfo;
  
  public VpxInputBuffer()
  {
    super(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.ext.vp9.VpxInputBuffer
 * JD-Core Version:    0.7.0.1
 */
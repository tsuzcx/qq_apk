package com.google.android.exoplayer2.ext.hevc;

import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.video.ColorInfo;

final class HevcInputBuffer
  extends DecoderInputBuffer
{
  public ColorInfo colorInfo;
  
  public HevcInputBuffer()
  {
    super(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.ext.hevc.HevcInputBuffer
 * JD-Core Version:    0.7.0.1
 */
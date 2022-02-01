package com.google.android.exoplayer2.source.hls;

import java.io.IOException;

public final class SampleQueueMappingException
  extends IOException
{
  public SampleQueueMappingException(String paramString)
  {
    super("Unable to bind a sample queue to TrackGroup with mime type " + paramString + ".");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.source.hls.SampleQueueMappingException
 * JD-Core Version:    0.7.0.1
 */
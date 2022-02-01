package com.google.android.exoplayer2.metadata;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.emsg.EventMessageDecoder;
import com.google.android.exoplayer2.metadata.id3.Id3Decoder;
import com.google.android.exoplayer2.metadata.scte35.SpliceInfoDecoder;

final class MetadataDecoderFactory$1
  implements MetadataDecoderFactory
{
  public MetadataDecoder createDecoder(Format paramFormat)
  {
    paramFormat = paramFormat.sampleMimeType;
    int i = -1;
    switch (paramFormat.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        throw new IllegalArgumentException("Attempted to create decoder for unsupported format");
        if (paramFormat.equals("application/id3"))
        {
          i = 0;
          continue;
          if (paramFormat.equals("application/x-emsg"))
          {
            i = 1;
            continue;
            if (paramFormat.equals("application/x-scte35")) {
              i = 2;
            }
          }
        }
        break;
      }
    }
    return new Id3Decoder();
    return new EventMessageDecoder();
    return new SpliceInfoDecoder();
  }
  
  public boolean supportsFormat(Format paramFormat)
  {
    paramFormat = paramFormat.sampleMimeType;
    return ("application/id3".equals(paramFormat)) || ("application/x-emsg".equals(paramFormat)) || ("application/x-scte35".equals(paramFormat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.MetadataDecoderFactory.1
 * JD-Core Version:    0.7.0.1
 */
package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekMap.Unseekable;

final class StreamReader$UnseekableOggSeeker
  implements OggSeeker
{
  public SeekMap createSeekMap()
  {
    return new SeekMap.Unseekable(-9223372036854775807L);
  }
  
  public long read(ExtractorInput paramExtractorInput)
  {
    return -1L;
  }
  
  public long startSeek(long paramLong)
  {
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.ogg.StreamReader.UnseekableOggSeeker
 * JD-Core Version:    0.7.0.1
 */
package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekMap.SeekPoints;
import com.google.android.exoplayer2.extractor.SeekPoint;

class DefaultOggSeeker$OggSeekMap
  implements SeekMap
{
  private DefaultOggSeeker$OggSeekMap(DefaultOggSeeker paramDefaultOggSeeker) {}
  
  public long getDurationUs()
  {
    return DefaultOggSeeker.access$200(this.this$0).convertGranuleToTime(DefaultOggSeeker.access$400(this.this$0));
  }
  
  public SeekMap.SeekPoints getSeekPoints(long paramLong)
  {
    if (paramLong == 0L) {
      return new SeekMap.SeekPoints(new SeekPoint(0L, DefaultOggSeeker.access$100(this.this$0)));
    }
    long l = DefaultOggSeeker.access$200(this.this$0).convertTimeToGranule(paramLong);
    return new SeekMap.SeekPoints(new SeekPoint(paramLong, DefaultOggSeeker.access$300(this.this$0, DefaultOggSeeker.access$100(this.this$0), l, 30000L)));
  }
  
  public boolean isSeekable()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.ogg.DefaultOggSeeker.OggSeekMap
 * JD-Core Version:    0.7.0.1
 */
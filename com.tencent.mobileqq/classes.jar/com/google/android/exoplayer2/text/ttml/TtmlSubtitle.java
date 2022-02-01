package com.google.android.exoplayer2.text.ttml;

import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.util.Util;
import java.util.Collections;
import java.util.List;
import java.util.Map;

final class TtmlSubtitle
  implements Subtitle
{
  private final long[] eventTimesUs;
  private final Map<String, TtmlStyle> globalStyles;
  private final Map<String, TtmlRegion> regionMap;
  private final TtmlNode root;
  
  public TtmlSubtitle(TtmlNode paramTtmlNode, Map<String, TtmlStyle> paramMap, Map<String, TtmlRegion> paramMap1)
  {
    this.root = paramTtmlNode;
    this.regionMap = paramMap1;
    if (paramMap != null) {}
    for (paramMap = Collections.unmodifiableMap(paramMap);; paramMap = Collections.emptyMap())
    {
      this.globalStyles = paramMap;
      this.eventTimesUs = paramTtmlNode.getEventTimesUs();
      return;
    }
  }
  
  public List<Cue> getCues(long paramLong)
  {
    return this.root.getCues(paramLong, this.globalStyles, this.regionMap);
  }
  
  public long getEventTime(int paramInt)
  {
    return this.eventTimesUs[paramInt];
  }
  
  public int getEventTimeCount()
  {
    return this.eventTimesUs.length;
  }
  
  Map<String, TtmlStyle> getGlobalStyles()
  {
    return this.globalStyles;
  }
  
  public int getNextEventTimeIndex(long paramLong)
  {
    int i = Util.binarySearchCeil(this.eventTimesUs, paramLong, false, false);
    if (i < this.eventTimesUs.length) {
      return i;
    }
    return -1;
  }
  
  TtmlNode getRoot()
  {
    return this.root;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.text.ttml.TtmlSubtitle
 * JD-Core Version:    0.7.0.1
 */
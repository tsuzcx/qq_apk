package com.tencent.autotemplate.filter;

import com.tencent.tavkit.composition.video.ImageCollection.TrackImagePair;
import java.util.Comparator;

class TAVBaseMixFilter$1
  implements Comparator<ImageCollection.TrackImagePair>
{
  TAVBaseMixFilter$1(TAVBaseMixFilter paramTAVBaseMixFilter) {}
  
  public int compare(ImageCollection.TrackImagePair paramTrackImagePair1, ImageCollection.TrackImagePair paramTrackImagePair2)
  {
    return this.this$0.getTrackIndex(paramTrackImagePair1) - this.this$0.getTrackIndex(paramTrackImagePair2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.autotemplate.filter.TAVBaseMixFilter.1
 * JD-Core Version:    0.7.0.1
 */
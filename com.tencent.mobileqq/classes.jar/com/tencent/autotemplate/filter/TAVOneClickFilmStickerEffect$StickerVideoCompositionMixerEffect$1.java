package com.tencent.autotemplate.filter;

import com.tencent.tavkit.composition.model.TAVVideoCompositionTrack;
import com.tencent.tavkit.composition.video.ImageCollection.TrackImagePair;
import java.util.Comparator;

class TAVOneClickFilmStickerEffect$StickerVideoCompositionMixerEffect$1
  implements Comparator<ImageCollection.TrackImagePair>
{
  TAVOneClickFilmStickerEffect$StickerVideoCompositionMixerEffect$1(TAVOneClickFilmStickerEffect.StickerVideoCompositionMixerEffect paramStickerVideoCompositionMixerEffect) {}
  
  public int compare(ImageCollection.TrackImagePair paramTrackImagePair1, ImageCollection.TrackImagePair paramTrackImagePair2)
  {
    if ((paramTrackImagePair1 != null) && (paramTrackImagePair1.getTrack() != null) && ((paramTrackImagePair1.getTrack().getExtraTrackInfo("trackIndex") instanceof Integer))) {}
    for (int i = ((Integer)paramTrackImagePair1.getTrack().getExtraTrackInfo("trackIndex")).intValue();; i = 0)
    {
      if ((paramTrackImagePair2 != null) && (paramTrackImagePair2.getTrack() != null) && ((paramTrackImagePair2.getTrack().getExtraTrackInfo("trackIndex") instanceof Integer))) {}
      for (int j = ((Integer)paramTrackImagePair2.getTrack().getExtraTrackInfo("trackIndex")).intValue();; j = 0) {
        return i - j;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.autotemplate.filter.TAVOneClickFilmStickerEffect.StickerVideoCompositionMixerEffect.1
 * JD-Core Version:    0.7.0.1
 */
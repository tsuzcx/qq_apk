package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.Assertions;

final class FragmentedMp4Extractor$TrackBundle
{
  public int currentSampleInTrackRun;
  public int currentSampleIndex;
  public int currentTrackRunIndex;
  public DefaultSampleValues defaultSampleValues;
  public final TrackFragment fragment = new TrackFragment();
  public final TrackOutput output;
  public Track track;
  
  public FragmentedMp4Extractor$TrackBundle(TrackOutput paramTrackOutput)
  {
    this.output = paramTrackOutput;
  }
  
  public void init(Track paramTrack, DefaultSampleValues paramDefaultSampleValues)
  {
    this.track = ((Track)Assertions.checkNotNull(paramTrack));
    this.defaultSampleValues = ((DefaultSampleValues)Assertions.checkNotNull(paramDefaultSampleValues));
    this.output.format(paramTrack.format);
    reset();
  }
  
  public void reset()
  {
    this.fragment.reset();
    this.currentSampleIndex = 0;
    this.currentTrackRunIndex = 0;
    this.currentSampleInTrackRun = 0;
  }
  
  public void updateDrmInitData(DrmInitData paramDrmInitData)
  {
    Object localObject = this.track.getSampleDescriptionEncryptionBox(this.fragment.header.sampleDescriptionIndex);
    if (localObject != null) {}
    for (localObject = ((TrackEncryptionBox)localObject).schemeType;; localObject = null)
    {
      this.output.format(this.track.format.copyWithDrmInitData(paramDrmInitData.copyWithSchemeType((String)localObject)));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor.TrackBundle
 * JD-Core Version:    0.7.0.1
 */
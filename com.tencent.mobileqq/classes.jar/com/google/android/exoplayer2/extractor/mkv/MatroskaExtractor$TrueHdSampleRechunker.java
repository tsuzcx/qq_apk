package com.google.android.exoplayer2.extractor.mkv;

import com.google.android.exoplayer2.audio.Ac3Util;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.TrackOutput;

final class MatroskaExtractor$TrueHdSampleRechunker
{
  private int blockFlags;
  private int chunkSize;
  private boolean foundSyncframe;
  private int sampleCount;
  private final byte[] syncframePrefix = new byte[12];
  private long timeUs;
  
  public void outputPendingSampleMetadata(MatroskaExtractor.Track paramTrack)
  {
    if ((this.foundSyncframe) && (this.sampleCount > 0))
    {
      paramTrack.output.sampleMetadata(this.timeUs, this.blockFlags, this.chunkSize, 0, paramTrack.cryptoData);
      this.sampleCount = 0;
    }
  }
  
  public void reset()
  {
    this.foundSyncframe = false;
  }
  
  public void sampleMetadata(MatroskaExtractor.Track paramTrack, long paramLong)
  {
    if (!this.foundSyncframe) {}
    do
    {
      return;
      int i = this.sampleCount;
      this.sampleCount = (i + 1);
      if (i == 0) {
        this.timeUs = paramLong;
      }
    } while (this.sampleCount < 8);
    paramTrack.output.sampleMetadata(this.timeUs, this.blockFlags, this.chunkSize, 0, paramTrack.cryptoData);
    this.sampleCount = 0;
  }
  
  public void startSample(ExtractorInput paramExtractorInput, int paramInt1, int paramInt2)
  {
    if (!this.foundSyncframe)
    {
      paramExtractorInput.peekFully(this.syncframePrefix, 0, 12);
      paramExtractorInput.resetPeekPosition();
      if (Ac3Util.parseTrueHdSyncframeAudioSampleCount(this.syncframePrefix) == -1) {
        return;
      }
      this.foundSyncframe = true;
      this.sampleCount = 0;
    }
    if (this.sampleCount == 0)
    {
      this.blockFlags = paramInt1;
      this.chunkSize = 0;
    }
    this.chunkSize += paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.TrueHdSampleRechunker
 * JD-Core Version:    0.7.0.1
 */
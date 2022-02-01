package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.DummyTrackOutput;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.TrackOutput.CryptoData;
import com.google.android.exoplayer2.util.ParsableByteArray;

final class ChunkExtractorWrapper$BindingTrackOutput
  implements TrackOutput
{
  private final int id;
  private final Format manifestFormat;
  public Format sampleFormat;
  private TrackOutput trackOutput;
  private final int type;
  
  public ChunkExtractorWrapper$BindingTrackOutput(int paramInt1, int paramInt2, Format paramFormat)
  {
    this.id = paramInt1;
    this.type = paramInt2;
    this.manifestFormat = paramFormat;
  }
  
  public void bind(ChunkExtractorWrapper.TrackOutputProvider paramTrackOutputProvider)
  {
    if (paramTrackOutputProvider == null)
    {
      this.trackOutput = new DummyTrackOutput();
      return;
    }
    this.trackOutput = paramTrackOutputProvider.track(this.id, this.type);
    paramTrackOutputProvider = this.sampleFormat;
    if (paramTrackOutputProvider != null) {
      this.trackOutput.format(paramTrackOutputProvider);
    }
  }
  
  public void format(Format paramFormat)
  {
    Format localFormat2 = this.manifestFormat;
    Format localFormat1 = paramFormat;
    if (localFormat2 != null) {
      localFormat1 = paramFormat.copyWithManifestFormatInfo(localFormat2);
    }
    this.sampleFormat = localFormat1;
    this.trackOutput.format(this.sampleFormat);
  }
  
  public int sampleData(ExtractorInput paramExtractorInput, int paramInt, boolean paramBoolean)
  {
    return this.trackOutput.sampleData(paramExtractorInput, paramInt, paramBoolean);
  }
  
  public void sampleData(ParsableByteArray paramParsableByteArray, int paramInt)
  {
    this.trackOutput.sampleData(paramParsableByteArray, paramInt);
  }
  
  public void sampleMetadata(long paramLong, int paramInt1, int paramInt2, int paramInt3, TrackOutput.CryptoData paramCryptoData)
  {
    this.trackOutput.sampleMetadata(paramLong, paramInt1, paramInt2, paramInt3, paramCryptoData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.source.chunk.ChunkExtractorWrapper.BindingTrackOutput
 * JD-Core Version:    0.7.0.1
 */
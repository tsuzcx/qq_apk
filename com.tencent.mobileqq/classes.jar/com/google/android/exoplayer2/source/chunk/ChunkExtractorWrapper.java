package com.google.android.exoplayer2.source.chunk;

import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.Assertions;

public final class ChunkExtractorWrapper
  implements ExtractorOutput
{
  private final SparseArray<ChunkExtractorWrapper.BindingTrackOutput> bindingTrackOutputs;
  public final Extractor extractor;
  private boolean extractorInitialized;
  private final Format primaryTrackManifestFormat;
  private final int primaryTrackType;
  private Format[] sampleFormats;
  private SeekMap seekMap;
  private ChunkExtractorWrapper.TrackOutputProvider trackOutputProvider;
  
  public ChunkExtractorWrapper(Extractor paramExtractor, int paramInt, Format paramFormat)
  {
    this.extractor = paramExtractor;
    this.primaryTrackType = paramInt;
    this.primaryTrackManifestFormat = paramFormat;
    this.bindingTrackOutputs = new SparseArray();
  }
  
  public void endTracks()
  {
    Format[] arrayOfFormat = new Format[this.bindingTrackOutputs.size()];
    int i = 0;
    while (i < this.bindingTrackOutputs.size())
    {
      arrayOfFormat[i] = ((ChunkExtractorWrapper.BindingTrackOutput)this.bindingTrackOutputs.valueAt(i)).sampleFormat;
      i += 1;
    }
    this.sampleFormats = arrayOfFormat;
  }
  
  public Format[] getSampleFormats()
  {
    return this.sampleFormats;
  }
  
  public SeekMap getSeekMap()
  {
    return this.seekMap;
  }
  
  public void init(ChunkExtractorWrapper.TrackOutputProvider paramTrackOutputProvider)
  {
    this.trackOutputProvider = paramTrackOutputProvider;
    if (!this.extractorInitialized)
    {
      this.extractor.init(this);
      this.extractorInitialized = true;
      return;
    }
    this.extractor.seek(0L, 0L);
    int i = 0;
    while (i < this.bindingTrackOutputs.size())
    {
      ((ChunkExtractorWrapper.BindingTrackOutput)this.bindingTrackOutputs.valueAt(i)).bind(paramTrackOutputProvider);
      i += 1;
    }
  }
  
  public void seekMap(SeekMap paramSeekMap)
  {
    this.seekMap = paramSeekMap;
  }
  
  public TrackOutput track(int paramInt1, int paramInt2)
  {
    ChunkExtractorWrapper.BindingTrackOutput localBindingTrackOutput = (ChunkExtractorWrapper.BindingTrackOutput)this.bindingTrackOutputs.get(paramInt1);
    Object localObject = localBindingTrackOutput;
    if (localBindingTrackOutput == null)
    {
      boolean bool;
      if (this.sampleFormats == null) {
        bool = true;
      } else {
        bool = false;
      }
      Assertions.checkState(bool);
      if (paramInt2 == this.primaryTrackType) {
        localObject = this.primaryTrackManifestFormat;
      } else {
        localObject = null;
      }
      localObject = new ChunkExtractorWrapper.BindingTrackOutput(paramInt1, paramInt2, (Format)localObject);
      ((ChunkExtractorWrapper.BindingTrackOutput)localObject).bind(this.trackOutputProvider);
      this.bindingTrackOutputs.put(paramInt1, localObject);
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.source.chunk.ChunkExtractorWrapper
 * JD-Core Version:    0.7.0.1
 */
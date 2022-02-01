package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Collections;
import java.util.List;

public final class DvbSubtitleReader
  implements ElementaryStreamReader
{
  private int bytesToCheck;
  private final TrackOutput[] outputs;
  private int sampleBytesWritten;
  private long sampleTimeUs;
  private final List<TsPayloadReader.DvbSubtitleInfo> subtitleInfos;
  private boolean writingSample;
  
  public DvbSubtitleReader(List<TsPayloadReader.DvbSubtitleInfo> paramList)
  {
    this.subtitleInfos = paramList;
    this.outputs = new TrackOutput[paramList.size()];
  }
  
  private boolean checkNextByte(ParsableByteArray paramParsableByteArray, int paramInt)
  {
    if (paramParsableByteArray.bytesLeft() == 0) {
      return false;
    }
    if (paramParsableByteArray.readUnsignedByte() != paramInt) {
      this.writingSample = false;
    }
    this.bytesToCheck -= 1;
    return this.writingSample;
  }
  
  public void consume(ParsableByteArray paramParsableByteArray)
  {
    int i = 0;
    if ((!this.writingSample) || ((this.bytesToCheck == 2) && (!checkNextByte(paramParsableByteArray, 32)))) {}
    while ((this.bytesToCheck == 1) && (!checkNextByte(paramParsableByteArray, 0))) {
      return;
    }
    int j = paramParsableByteArray.getPosition();
    int k = paramParsableByteArray.bytesLeft();
    TrackOutput[] arrayOfTrackOutput = this.outputs;
    int m = arrayOfTrackOutput.length;
    while (i < m)
    {
      TrackOutput localTrackOutput = arrayOfTrackOutput[i];
      paramParsableByteArray.setPosition(j);
      localTrackOutput.sampleData(paramParsableByteArray, k);
      i += 1;
    }
    this.sampleBytesWritten += k;
  }
  
  public void createTracks(ExtractorOutput paramExtractorOutput, TsPayloadReader.TrackIdGenerator paramTrackIdGenerator)
  {
    int i = 0;
    while (i < this.outputs.length)
    {
      TsPayloadReader.DvbSubtitleInfo localDvbSubtitleInfo = (TsPayloadReader.DvbSubtitleInfo)this.subtitleInfos.get(i);
      paramTrackIdGenerator.generateNewId();
      TrackOutput localTrackOutput = paramExtractorOutput.track(paramTrackIdGenerator.getTrackId(), 3);
      localTrackOutput.format(Format.createImageSampleFormat(paramTrackIdGenerator.getFormatId(), "application/dvbsubs", null, -1, 0, Collections.singletonList(localDvbSubtitleInfo.initializationData), localDvbSubtitleInfo.language, null));
      this.outputs[i] = localTrackOutput;
      i += 1;
    }
  }
  
  public void packetFinished()
  {
    if (this.writingSample)
    {
      TrackOutput[] arrayOfTrackOutput = this.outputs;
      int j = arrayOfTrackOutput.length;
      int i = 0;
      while (i < j)
      {
        arrayOfTrackOutput[i].sampleMetadata(this.sampleTimeUs, 1, this.sampleBytesWritten, 0, null);
        i += 1;
      }
      this.writingSample = false;
    }
  }
  
  public void packetStarted(long paramLong, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    this.writingSample = true;
    this.sampleTimeUs = paramLong;
    this.sampleBytesWritten = 0;
    this.bytesToCheck = 2;
  }
  
  public void seek()
  {
    this.writingSample = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.ts.DvbSubtitleReader
 * JD-Core Version:    0.7.0.1
 */
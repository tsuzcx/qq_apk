package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.text.cea.CeaUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.List;

final class SeiReader
{
  private final List<Format> closedCaptionFormats;
  private final TrackOutput[] outputs;
  
  public SeiReader(List<Format> paramList)
  {
    this.closedCaptionFormats = paramList;
    this.outputs = new TrackOutput[paramList.size()];
  }
  
  public void consume(long paramLong, ParsableByteArray paramParsableByteArray)
  {
    CeaUtil.consume(paramLong, paramParsableByteArray, this.outputs);
  }
  
  public void createTracks(ExtractorOutput paramExtractorOutput, TsPayloadReader.TrackIdGenerator paramTrackIdGenerator)
  {
    int i = 0;
    while (i < this.outputs.length)
    {
      paramTrackIdGenerator.generateNewId();
      TrackOutput localTrackOutput = paramExtractorOutput.track(paramTrackIdGenerator.getTrackId(), 3);
      Format localFormat = (Format)this.closedCaptionFormats.get(i);
      String str = localFormat.sampleMimeType;
      boolean bool;
      if ((!"application/cea-608".equals(str)) && (!"application/cea-708".equals(str))) {
        bool = false;
      } else {
        bool = true;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Invalid closed caption mime type provided: ");
      ((StringBuilder)localObject).append(str);
      Assertions.checkArgument(bool, ((StringBuilder)localObject).toString());
      if (localFormat.id != null) {
        localObject = localFormat.id;
      } else {
        localObject = paramTrackIdGenerator.getFormatId();
      }
      localTrackOutput.format(Format.createTextSampleFormat((String)localObject, str, null, -1, localFormat.selectionFlags, localFormat.language, localFormat.accessibilityChannel, null));
      this.outputs[i] = localTrackOutput;
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.ts.SeiReader
 * JD-Core Version:    0.7.0.1
 */
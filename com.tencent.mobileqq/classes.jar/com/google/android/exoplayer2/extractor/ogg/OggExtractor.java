package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.ParsableByteArray;

public class OggExtractor
  implements Extractor
{
  public static final ExtractorsFactory FACTORY = new OggExtractor.1();
  private static final int MAX_VERIFICATION_BYTES = 8;
  private ExtractorOutput output;
  private StreamReader streamReader;
  private boolean streamReaderInitialized;
  
  private static ParsableByteArray resetPosition(ParsableByteArray paramParsableByteArray)
  {
    paramParsableByteArray.setPosition(0);
    return paramParsableByteArray;
  }
  
  private boolean sniffInternal(ExtractorInput paramExtractorInput)
  {
    Object localObject = new OggPageHeader();
    if (((OggPageHeader)localObject).populate(paramExtractorInput, true))
    {
      if ((((OggPageHeader)localObject).type & 0x2) != 2) {
        return false;
      }
      int i = Math.min(((OggPageHeader)localObject).bodySize, 8);
      localObject = new ParsableByteArray(i);
      paramExtractorInput.peekFully(((ParsableByteArray)localObject).data, 0, i);
      if (FlacReader.verifyBitstreamType(resetPosition((ParsableByteArray)localObject)))
      {
        this.streamReader = new FlacReader();
        return true;
      }
      if (VorbisReader.verifyBitstreamType(resetPosition((ParsableByteArray)localObject)))
      {
        this.streamReader = new VorbisReader();
        return true;
      }
      if (OpusReader.verifyBitstreamType(resetPosition((ParsableByteArray)localObject)))
      {
        this.streamReader = new OpusReader();
        return true;
      }
    }
    return false;
  }
  
  public void init(ExtractorOutput paramExtractorOutput)
  {
    this.output = paramExtractorOutput;
  }
  
  public int read(ExtractorInput paramExtractorInput, PositionHolder paramPositionHolder)
  {
    if (this.streamReader == null) {
      if (sniffInternal(paramExtractorInput)) {
        paramExtractorInput.resetPeekPosition();
      } else {
        throw new ParserException("Failed to determine bitstream type");
      }
    }
    if (!this.streamReaderInitialized)
    {
      TrackOutput localTrackOutput = this.output.track(0, 1);
      this.output.endTracks();
      this.streamReader.init(this.output, localTrackOutput);
      this.streamReaderInitialized = true;
    }
    return this.streamReader.read(paramExtractorInput, paramPositionHolder);
  }
  
  public void release() {}
  
  public void seek(long paramLong1, long paramLong2)
  {
    StreamReader localStreamReader = this.streamReader;
    if (localStreamReader != null) {
      localStreamReader.seek(paramLong1, paramLong2);
    }
  }
  
  public boolean sniff(ExtractorInput paramExtractorInput)
  {
    try
    {
      boolean bool = sniffInternal(paramExtractorInput);
      return bool;
    }
    catch (ParserException paramExtractorInput)
    {
      label8:
      break label8;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.ogg.OggExtractor
 * JD-Core Version:    0.7.0.1
 */
package com.google.android.exoplayer2.extractor.wav;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.TrackOutput;

public final class WavExtractor
  implements Extractor
{
  public static final ExtractorsFactory FACTORY = new WavExtractor.1();
  private static final int MAX_INPUT_SIZE = 32768;
  private int bytesPerFrame;
  private ExtractorOutput extractorOutput;
  private int pendingBytes;
  private TrackOutput trackOutput;
  private WavHeader wavHeader;
  
  public void init(ExtractorOutput paramExtractorOutput)
  {
    this.extractorOutput = paramExtractorOutput;
    this.trackOutput = paramExtractorOutput.track(0, 1);
    this.wavHeader = null;
    paramExtractorOutput.endTracks();
  }
  
  public int read(ExtractorInput paramExtractorInput, PositionHolder paramPositionHolder)
  {
    if (this.wavHeader == null)
    {
      this.wavHeader = WavHeaderReader.peek(paramExtractorInput);
      if (this.wavHeader == null) {
        throw new ParserException("Unsupported or unrecognized wav header.");
      }
      paramPositionHolder = Format.createAudioSampleFormat(null, "audio/raw", null, this.wavHeader.getBitrate(), 32768, this.wavHeader.getNumChannels(), this.wavHeader.getSampleRateHz(), this.wavHeader.getEncoding(), null, null, 0, null);
      this.trackOutput.format(paramPositionHolder);
      this.bytesPerFrame = this.wavHeader.getBytesPerFrame();
    }
    if (!this.wavHeader.hasDataBounds())
    {
      WavHeaderReader.skipToData(paramExtractorInput, this.wavHeader);
      this.extractorOutput.seekMap(this.wavHeader);
    }
    int i = this.trackOutput.sampleData(paramExtractorInput, 32768 - this.pendingBytes, true);
    if (i != -1) {
      this.pendingBytes += i;
    }
    int j = this.pendingBytes / this.bytesPerFrame;
    if (j > 0)
    {
      long l = this.wavHeader.getTimeUs(paramExtractorInput.getPosition() - this.pendingBytes);
      j *= this.bytesPerFrame;
      this.pendingBytes -= j;
      this.trackOutput.sampleMetadata(l, 1, j, this.pendingBytes, null);
    }
    if (i == -1) {
      return -1;
    }
    return 0;
  }
  
  public void release() {}
  
  public void seek(long paramLong1, long paramLong2)
  {
    this.pendingBytes = 0;
  }
  
  public boolean sniff(ExtractorInput paramExtractorInput)
  {
    return WavHeaderReader.peek(paramExtractorInput) != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.wav.WavExtractor
 * JD-Core Version:    0.7.0.1
 */
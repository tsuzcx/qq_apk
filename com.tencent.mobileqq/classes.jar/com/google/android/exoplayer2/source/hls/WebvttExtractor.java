package com.google.android.exoplayer2.source.hls;

import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap.Unseekable;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.webvtt.WebvttParserUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class WebvttExtractor
  implements Extractor
{
  private static final Pattern LOCAL_TIMESTAMP = Pattern.compile("LOCAL:([^,]+)");
  private static final Pattern MEDIA_TIMESTAMP = Pattern.compile("MPEGTS:(\\d+)");
  private final String language;
  private ExtractorOutput output;
  private byte[] sampleData;
  private final ParsableByteArray sampleDataWrapper;
  private int sampleSize;
  private final TimestampAdjuster timestampAdjuster;
  
  public WebvttExtractor(String paramString, TimestampAdjuster paramTimestampAdjuster)
  {
    this.language = paramString;
    this.timestampAdjuster = paramTimestampAdjuster;
    this.sampleDataWrapper = new ParsableByteArray();
    this.sampleData = new byte[1024];
  }
  
  private TrackOutput buildTrackOutput(long paramLong)
  {
    TrackOutput localTrackOutput = this.output.track(0, 3);
    localTrackOutput.format(Format.createTextSampleFormat(null, "text/vtt", null, -1, 0, this.language, null, paramLong));
    this.output.endTracks();
    return localTrackOutput;
  }
  
  private void processSample()
  {
    ParsableByteArray localParsableByteArray = new ParsableByteArray(this.sampleData);
    long l2;
    for (;;)
    {
      String str;
      Matcher localMatcher1;
      try
      {
        WebvttParserUtil.validateWebvttHeaderLine(localParsableByteArray);
        l1 = 0L;
        l2 = 0L;
        str = localParsableByteArray.readLine();
        if (TextUtils.isEmpty(str)) {
          break;
        }
        if (!str.startsWith("X-TIMESTAMP-MAP")) {
          continue;
        }
        localMatcher1 = LOCAL_TIMESTAMP.matcher(str);
        if (!localMatcher1.find()) {
          throw new ParserException("X-TIMESTAMP-MAP doesn't contain local timestamp: " + str);
        }
      }
      catch (SubtitleDecoderException localSubtitleDecoderException)
      {
        throw new ParserException(localSubtitleDecoderException);
      }
      Matcher localMatcher2 = MEDIA_TIMESTAMP.matcher(str);
      if (!localMatcher2.find()) {
        throw new ParserException("X-TIMESTAMP-MAP doesn't contain media timestamp: " + str);
      }
      l2 = WebvttParserUtil.parseTimestampUs(localMatcher1.group(1));
      l1 = TimestampAdjuster.ptsToUs(Long.parseLong(localMatcher2.group(1)));
    }
    Object localObject = WebvttParserUtil.findNextCueHeader(localSubtitleDecoderException);
    if (localObject == null)
    {
      buildTrackOutput(0L);
      return;
    }
    long l3 = WebvttParserUtil.parseTimestampUs(((Matcher)localObject).group(1));
    long l1 = this.timestampAdjuster.adjustTsTimestamp(TimestampAdjuster.usToPts(l1 + l3 - l2));
    localObject = buildTrackOutput(l1 - l3);
    this.sampleDataWrapper.reset(this.sampleData, this.sampleSize);
    ((TrackOutput)localObject).sampleData(this.sampleDataWrapper, this.sampleSize);
    ((TrackOutput)localObject).sampleMetadata(l1, 1, this.sampleSize, 0, null);
  }
  
  public void init(ExtractorOutput paramExtractorOutput)
  {
    this.output = paramExtractorOutput;
    paramExtractorOutput.seekMap(new SeekMap.Unseekable(-9223372036854775807L));
  }
  
  public int read(ExtractorInput paramExtractorInput, PositionHolder paramPositionHolder)
  {
    int j = (int)paramExtractorInput.getLength();
    if (this.sampleSize == this.sampleData.length)
    {
      paramPositionHolder = this.sampleData;
      if (j == -1) {
        break label105;
      }
    }
    label105:
    for (int i = j;; i = this.sampleData.length)
    {
      this.sampleData = Arrays.copyOf(paramPositionHolder, i * 3 / 2);
      i = paramExtractorInput.read(this.sampleData, this.sampleSize, this.sampleData.length - this.sampleSize);
      if (i == -1) {
        break;
      }
      this.sampleSize = (i + this.sampleSize);
      if ((j != -1) && (this.sampleSize == j)) {
        break;
      }
      return 0;
    }
    processSample();
    return -1;
  }
  
  public void release() {}
  
  public void seek(long paramLong1, long paramLong2)
  {
    throw new IllegalStateException();
  }
  
  public boolean sniff(ExtractorInput paramExtractorInput)
  {
    throw new IllegalStateException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.hls.WebvttExtractor
 * JD-Core Version:    0.7.0.1
 */
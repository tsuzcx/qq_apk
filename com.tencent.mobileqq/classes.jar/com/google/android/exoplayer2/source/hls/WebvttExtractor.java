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
    Object localObject2 = new ParsableByteArray(this.sampleData);
    label147:
    label185:
    ParserException localParserException;
    try
    {
      WebvttParserUtil.validateWebvttHeaderLine((ParsableByteArray)localObject2);
      long l1 = 0L;
      long l2 = l1;
      for (;;)
      {
        localObject1 = ((ParsableByteArray)localObject2).readLine();
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label185;
        }
        if (((String)localObject1).startsWith("X-TIMESTAMP-MAP"))
        {
          Matcher localMatcher1 = LOCAL_TIMESTAMP.matcher((CharSequence)localObject1);
          if (!localMatcher1.find()) {
            break label147;
          }
          Matcher localMatcher2 = MEDIA_TIMESTAMP.matcher((CharSequence)localObject1);
          if (!localMatcher2.find()) {
            break;
          }
          l2 = WebvttParserUtil.parseTimestampUs(localMatcher1.group(1));
          l1 = TimestampAdjuster.ptsToUs(Long.parseLong(localMatcher2.group(1)));
        }
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("X-TIMESTAMP-MAP doesn't contain media timestamp: ");
      ((StringBuilder)localObject2).append((String)localObject1);
      throw new ParserException(((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("X-TIMESTAMP-MAP doesn't contain local timestamp: ");
      ((StringBuilder)localObject2).append((String)localObject1);
      throw new ParserException(((StringBuilder)localObject2).toString());
      Object localObject1 = WebvttParserUtil.findNextCueHeader((ParsableByteArray)localObject2);
      if (localObject1 == null)
      {
        buildTrackOutput(0L);
        return;
      }
      long l3 = WebvttParserUtil.parseTimestampUs(((Matcher)localObject1).group(1));
      l1 = this.timestampAdjuster.adjustTsTimestamp(TimestampAdjuster.usToPts(l1 + l3 - l2));
      localObject1 = buildTrackOutput(l1 - l3);
      this.sampleDataWrapper.reset(this.sampleData, this.sampleSize);
      ((TrackOutput)localObject1).sampleData(this.sampleDataWrapper, this.sampleSize);
      ((TrackOutput)localObject1).sampleMetadata(l1, 1, this.sampleSize, 0, null);
      return;
    }
    catch (SubtitleDecoderException localSubtitleDecoderException)
    {
      localParserException = new ParserException(localSubtitleDecoderException);
    }
    for (;;)
    {
      throw localParserException;
    }
  }
  
  public void init(ExtractorOutput paramExtractorOutput)
  {
    this.output = paramExtractorOutput;
    paramExtractorOutput.seekMap(new SeekMap.Unseekable(-9223372036854775807L));
  }
  
  public int read(ExtractorInput paramExtractorInput, PositionHolder paramPositionHolder)
  {
    int j = (int)paramExtractorInput.getLength();
    int i = this.sampleSize;
    paramPositionHolder = this.sampleData;
    if (i == paramPositionHolder.length)
    {
      if (j != -1) {
        i = j;
      } else {
        i = paramPositionHolder.length;
      }
      this.sampleData = Arrays.copyOf(paramPositionHolder, i * 3 / 2);
    }
    paramPositionHolder = this.sampleData;
    i = this.sampleSize;
    i = paramExtractorInput.read(paramPositionHolder, i, paramPositionHolder.length - i);
    if (i != -1)
    {
      this.sampleSize += i;
      if ((j == -1) || (this.sampleSize != j)) {
        return 0;
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.source.hls.WebvttExtractor
 * JD-Core Version:    0.7.0.1
 */
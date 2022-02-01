package com.google.android.exoplayer2.extractor.ts;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Arrays;
import java.util.Collections;

public final class H262Reader
  implements ElementaryStreamReader
{
  private static final double[] FRAME_RATE_VALUES = { 23.976023976023978D, 24.0D, 25.0D, 29.970029970029969D, 30.0D, 50.0D, 59.940059940059939D, 60.0D };
  private static final int START_EXTENSION = 181;
  private static final int START_GROUP = 184;
  private static final int START_PICTURE = 0;
  private static final int START_SEQUENCE_HEADER = 179;
  private final H262Reader.CsdBuffer csdBuffer = new H262Reader.CsdBuffer(128);
  private String formatId;
  private long frameDurationUs;
  private boolean hasOutputFormat;
  private TrackOutput output;
  private long pesTimeUs;
  private final boolean[] prefixFlags = new boolean[4];
  private boolean sampleHasPicture;
  private boolean sampleIsKeyframe;
  private long samplePosition;
  private long sampleTimeUs;
  private boolean startedFirstSample;
  private long totalBytesWritten;
  
  private static Pair<Format, Long> parseCsdBuffer(H262Reader.CsdBuffer paramCsdBuffer, String paramString)
  {
    byte[] arrayOfByte = Arrays.copyOf(paramCsdBuffer.data, paramCsdBuffer.length);
    int j = arrayOfByte[4];
    int i = arrayOfByte[5] & 0xFF;
    int k = arrayOfByte[6];
    j = (j & 0xFF) << 4 | i >> 4;
    k = (i & 0xF) << 8 | k & 0xFF;
    i = (arrayOfByte[7] & 0xF0) >> 4;
    float f;
    if (i != 2)
    {
      if (i != 3)
      {
        if (i != 4)
        {
          f = 1.0F;
          break label162;
        }
        f = k * 121;
        i = j * 100;
      }
      else
      {
        f = k * 16;
        i = j * 9;
      }
    }
    else
    {
      f = k * 4;
      i = j * 3;
    }
    f /= i;
    label162:
    paramString = Format.createVideoSampleFormat(paramString, "video/mpeg2", null, -1, -1, j, k, -1.0F, Collections.singletonList(arrayOfByte), -1, f, null);
    long l2 = 0L;
    i = (arrayOfByte[7] & 0xF) - 1;
    long l1 = l2;
    if (i >= 0)
    {
      double[] arrayOfDouble = FRAME_RATE_VALUES;
      l1 = l2;
      if (i < arrayOfDouble.length)
      {
        double d2 = arrayOfDouble[i];
        j = paramCsdBuffer.sequenceExtensionPosition + 9;
        i = (arrayOfByte[j] & 0x60) >> 5;
        j = arrayOfByte[j] & 0x1F;
        double d1 = d2;
        if (i != j)
        {
          d1 = i;
          Double.isNaN(d1);
          double d3 = j + 1;
          Double.isNaN(d3);
          d1 = d2 * ((d1 + 1.0D) / d3);
        }
        l1 = (1000000.0D / d1);
      }
    }
    return Pair.create(paramString, Long.valueOf(l1));
  }
  
  public void consume(ParsableByteArray paramParsableByteArray)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void createTracks(ExtractorOutput paramExtractorOutput, TsPayloadReader.TrackIdGenerator paramTrackIdGenerator)
  {
    paramTrackIdGenerator.generateNewId();
    this.formatId = paramTrackIdGenerator.getFormatId();
    this.output = paramExtractorOutput.track(paramTrackIdGenerator.getTrackId(), 2);
  }
  
  public void packetFinished() {}
  
  public void packetStarted(long paramLong, boolean paramBoolean)
  {
    this.pesTimeUs = paramLong;
  }
  
  public void seek()
  {
    NalUnitUtil.clearPrefixFlags(this.prefixFlags);
    this.csdBuffer.reset();
    this.totalBytesWritten = 0L;
    this.startedFirstSample = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.ts.H262Reader
 * JD-Core Version:    0.7.0.1
 */
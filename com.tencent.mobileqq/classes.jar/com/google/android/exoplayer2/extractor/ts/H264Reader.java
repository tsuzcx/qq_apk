package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.NalUnitUtil.PpsData;
import com.google.android.exoplayer2.util.NalUnitUtil.SpsData;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class H264Reader
  implements ElementaryStreamReader
{
  private static final int NAL_UNIT_TYPE_PPS = 8;
  private static final int NAL_UNIT_TYPE_SEI = 6;
  private static final int NAL_UNIT_TYPE_SPS = 7;
  private final boolean allowNonIdrKeyframes;
  private final boolean detectAccessUnits;
  private String formatId;
  private boolean hasOutputFormat;
  private TrackOutput output;
  private long pesTimeUs;
  private final NalUnitTargetBuffer pps;
  private final boolean[] prefixFlags;
  private H264Reader.SampleReader sampleReader;
  private final NalUnitTargetBuffer sei;
  private final SeiReader seiReader;
  private final ParsableByteArray seiWrapper;
  private final NalUnitTargetBuffer sps;
  private long totalBytesWritten;
  
  public H264Reader(SeiReader paramSeiReader, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.seiReader = paramSeiReader;
    this.allowNonIdrKeyframes = paramBoolean1;
    this.detectAccessUnits = paramBoolean2;
    this.prefixFlags = new boolean[3];
    this.sps = new NalUnitTargetBuffer(7, 128);
    this.pps = new NalUnitTargetBuffer(8, 128);
    this.sei = new NalUnitTargetBuffer(6, 128);
    this.seiWrapper = new ParsableByteArray();
  }
  
  private void endNalUnit(long paramLong1, int paramInt1, int paramInt2, long paramLong2)
  {
    Object localObject;
    if ((!this.hasOutputFormat) || (this.sampleReader.needsSpsPps()))
    {
      this.sps.endNalUnit(paramInt2);
      this.pps.endNalUnit(paramInt2);
      if (this.hasOutputFormat) {
        break label320;
      }
      if ((this.sps.isCompleted()) && (this.pps.isCompleted()))
      {
        localObject = new ArrayList();
        ((List)localObject).add(Arrays.copyOf(this.sps.nalData, this.sps.nalLength));
        ((List)localObject).add(Arrays.copyOf(this.pps.nalData, this.pps.nalLength));
        NalUnitUtil.SpsData localSpsData = NalUnitUtil.parseSpsNalUnit(this.sps.nalData, 3, this.sps.nalLength);
        NalUnitUtil.PpsData localPpsData = NalUnitUtil.parsePpsNalUnit(this.pps.nalData, 3, this.pps.nalLength);
        this.output.format(Format.createVideoSampleFormat(this.formatId, "video/avc", null, -1, -1, localSpsData.width, localSpsData.height, -1.0F, (List)localObject, -1, localSpsData.pixelWidthAspectRatio, null));
        this.hasOutputFormat = true;
        this.sampleReader.putSps(localSpsData);
        this.sampleReader.putPps(localPpsData);
        this.sps.reset();
        this.pps.reset();
      }
    }
    for (;;)
    {
      if (this.sei.endNalUnit(paramInt2))
      {
        paramInt2 = NalUnitUtil.unescapeStream(this.sei.nalData, this.sei.nalLength);
        this.seiWrapper.reset(this.sei.nalData, paramInt2);
        this.seiWrapper.setPosition(4);
        this.seiReader.consume(paramLong2, this.seiWrapper);
      }
      this.sampleReader.endNalUnit(paramLong1, paramInt1);
      return;
      label320:
      if (this.sps.isCompleted())
      {
        localObject = NalUnitUtil.parseSpsNalUnit(this.sps.nalData, 3, this.sps.nalLength);
        this.sampleReader.putSps((NalUnitUtil.SpsData)localObject);
        this.sps.reset();
      }
      else if (this.pps.isCompleted())
      {
        localObject = NalUnitUtil.parsePpsNalUnit(this.pps.nalData, 3, this.pps.nalLength);
        this.sampleReader.putPps((NalUnitUtil.PpsData)localObject);
        this.pps.reset();
      }
    }
  }
  
  private void nalUnitData(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((!this.hasOutputFormat) || (this.sampleReader.needsSpsPps()))
    {
      this.sps.appendToNalUnit(paramArrayOfByte, paramInt1, paramInt2);
      this.pps.appendToNalUnit(paramArrayOfByte, paramInt1, paramInt2);
    }
    this.sei.appendToNalUnit(paramArrayOfByte, paramInt1, paramInt2);
    this.sampleReader.appendToNalUnit(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  private void startNalUnit(long paramLong1, int paramInt, long paramLong2)
  {
    if ((!this.hasOutputFormat) || (this.sampleReader.needsSpsPps()))
    {
      this.sps.startNalUnit(paramInt);
      this.pps.startNalUnit(paramInt);
    }
    this.sei.startNalUnit(paramInt);
    this.sampleReader.startNalUnit(paramLong1, paramInt, paramLong2);
  }
  
  public void consume(ParsableByteArray paramParsableByteArray)
  {
    int i = paramParsableByteArray.getPosition();
    int j = paramParsableByteArray.limit();
    byte[] arrayOfByte = paramParsableByteArray.data;
    this.totalBytesWritten += paramParsableByteArray.bytesLeft();
    this.output.sampleData(paramParsableByteArray, paramParsableByteArray.bytesLeft());
    int k = NalUnitUtil.findNalUnit(arrayOfByte, i, j, this.prefixFlags);
    if (k == j)
    {
      nalUnitData(arrayOfByte, i, j);
      return;
    }
    int m = NalUnitUtil.getNalUnitType(arrayOfByte, k);
    int i1 = k - i;
    if (i1 > 0) {
      nalUnitData(arrayOfByte, i, k);
    }
    int n = j - k;
    long l = this.totalBytesWritten - n;
    if (i1 < 0) {}
    for (i = -i1;; i = 0)
    {
      endNalUnit(l, n, i, this.pesTimeUs);
      startNalUnit(l, m, this.pesTimeUs);
      i = k + 3;
      break;
    }
  }
  
  public void createTracks(ExtractorOutput paramExtractorOutput, TsPayloadReader.TrackIdGenerator paramTrackIdGenerator)
  {
    paramTrackIdGenerator.generateNewId();
    this.formatId = paramTrackIdGenerator.getFormatId();
    this.output = paramExtractorOutput.track(paramTrackIdGenerator.getTrackId(), 2);
    this.sampleReader = new H264Reader.SampleReader(this.output, this.allowNonIdrKeyframes, this.detectAccessUnits);
    this.seiReader.createTracks(paramExtractorOutput, paramTrackIdGenerator);
  }
  
  public void packetFinished() {}
  
  public void packetStarted(long paramLong, boolean paramBoolean)
  {
    this.pesTimeUs = paramLong;
  }
  
  public void seek()
  {
    NalUnitUtil.clearPrefixFlags(this.prefixFlags);
    this.sps.reset();
    this.pps.reset();
    this.sei.reset();
    this.sampleReader.reset();
    this.totalBytesWritten = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.ts.H264Reader
 * JD-Core Version:    0.7.0.1
 */
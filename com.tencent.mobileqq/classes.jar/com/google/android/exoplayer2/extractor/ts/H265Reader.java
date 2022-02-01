package com.google.android.exoplayer2.extractor.ts;

import android.util.Log;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.ParsableNalUnitBitArray;
import java.util.Collections;

public final class H265Reader
  implements ElementaryStreamReader
{
  private static final int BLA_W_LP = 16;
  private static final int CRA_NUT = 21;
  private static final int PPS_NUT = 34;
  private static final int PREFIX_SEI_NUT = 39;
  private static final int RASL_R = 9;
  private static final int SPS_NUT = 33;
  private static final int SUFFIX_SEI_NUT = 40;
  private static final String TAG = "H265Reader";
  private static final int VPS_NUT = 32;
  private String formatId;
  private boolean hasOutputFormat;
  private TrackOutput output;
  private long pesTimeUs;
  private final NalUnitTargetBuffer pps;
  private final boolean[] prefixFlags;
  private final NalUnitTargetBuffer prefixSei;
  private H265Reader.SampleReader sampleReader;
  private final SeiReader seiReader;
  private final ParsableByteArray seiWrapper;
  private final NalUnitTargetBuffer sps;
  private final NalUnitTargetBuffer suffixSei;
  private long totalBytesWritten;
  private final NalUnitTargetBuffer vps;
  
  public H265Reader(SeiReader paramSeiReader)
  {
    this.seiReader = paramSeiReader;
    this.prefixFlags = new boolean[3];
    this.vps = new NalUnitTargetBuffer(32, 128);
    this.sps = new NalUnitTargetBuffer(33, 128);
    this.pps = new NalUnitTargetBuffer(34, 128);
    this.prefixSei = new NalUnitTargetBuffer(39, 128);
    this.suffixSei = new NalUnitTargetBuffer(40, 128);
    this.seiWrapper = new ParsableByteArray();
  }
  
  private void endNalUnit(long paramLong1, int paramInt1, int paramInt2, long paramLong2)
  {
    if (this.hasOutputFormat)
    {
      this.sampleReader.endNalUnit(paramLong1, paramInt1);
    }
    else
    {
      this.vps.endNalUnit(paramInt2);
      this.sps.endNalUnit(paramInt2);
      this.pps.endNalUnit(paramInt2);
      if ((this.vps.isCompleted()) && (this.sps.isCompleted()) && (this.pps.isCompleted()))
      {
        this.output.format(parseMediaFormat(this.formatId, this.vps, this.sps, this.pps));
        this.hasOutputFormat = true;
      }
    }
    if (this.prefixSei.endNalUnit(paramInt2))
    {
      paramInt1 = NalUnitUtil.unescapeStream(this.prefixSei.nalData, this.prefixSei.nalLength);
      this.seiWrapper.reset(this.prefixSei.nalData, paramInt1);
      this.seiWrapper.skipBytes(5);
      this.seiReader.consume(paramLong2, this.seiWrapper);
    }
    if (this.suffixSei.endNalUnit(paramInt2))
    {
      paramInt1 = NalUnitUtil.unescapeStream(this.suffixSei.nalData, this.suffixSei.nalLength);
      this.seiWrapper.reset(this.suffixSei.nalData, paramInt1);
      this.seiWrapper.skipBytes(5);
      this.seiReader.consume(paramLong2, this.seiWrapper);
    }
  }
  
  private void nalUnitData(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.hasOutputFormat)
    {
      this.sampleReader.readNalUnitData(paramArrayOfByte, paramInt1, paramInt2);
    }
    else
    {
      this.vps.appendToNalUnit(paramArrayOfByte, paramInt1, paramInt2);
      this.sps.appendToNalUnit(paramArrayOfByte, paramInt1, paramInt2);
      this.pps.appendToNalUnit(paramArrayOfByte, paramInt1, paramInt2);
    }
    this.prefixSei.appendToNalUnit(paramArrayOfByte, paramInt1, paramInt2);
    this.suffixSei.appendToNalUnit(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  private static Format parseMediaFormat(String paramString, NalUnitTargetBuffer paramNalUnitTargetBuffer1, NalUnitTargetBuffer paramNalUnitTargetBuffer2, NalUnitTargetBuffer paramNalUnitTargetBuffer3)
  {
    byte[] arrayOfByte1 = new byte[paramNalUnitTargetBuffer1.nalLength + paramNalUnitTargetBuffer2.nalLength + paramNalUnitTargetBuffer3.nalLength];
    byte[] arrayOfByte2 = paramNalUnitTargetBuffer1.nalData;
    int i = paramNalUnitTargetBuffer1.nalLength;
    int m = 0;
    System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 0, i);
    System.arraycopy(paramNalUnitTargetBuffer2.nalData, 0, arrayOfByte1, paramNalUnitTargetBuffer1.nalLength, paramNalUnitTargetBuffer2.nalLength);
    System.arraycopy(paramNalUnitTargetBuffer3.nalData, 0, arrayOfByte1, paramNalUnitTargetBuffer1.nalLength + paramNalUnitTargetBuffer2.nalLength, paramNalUnitTargetBuffer3.nalLength);
    paramNalUnitTargetBuffer1 = new ParsableNalUnitBitArray(paramNalUnitTargetBuffer2.nalData, 0, paramNalUnitTargetBuffer2.nalLength);
    paramNalUnitTargetBuffer1.skipBits(44);
    int n = paramNalUnitTargetBuffer1.readBits(3);
    paramNalUnitTargetBuffer1.skipBit();
    paramNalUnitTargetBuffer1.skipBits(88);
    paramNalUnitTargetBuffer1.skipBits(8);
    int k = 0;
    i = 0;
    while (k < n)
    {
      j = i;
      if (paramNalUnitTargetBuffer1.readBit()) {
        j = i + 89;
      }
      i = j;
      if (paramNalUnitTargetBuffer1.readBit()) {
        i = j + 8;
      }
      k += 1;
    }
    paramNalUnitTargetBuffer1.skipBits(i);
    if (n > 0) {
      paramNalUnitTargetBuffer1.skipBits((8 - n) * 2);
    }
    paramNalUnitTargetBuffer1.readUnsignedExpGolombCodedInt();
    int i6 = paramNalUnitTargetBuffer1.readUnsignedExpGolombCodedInt();
    if (i6 == 3) {
      paramNalUnitTargetBuffer1.skipBit();
    }
    int i2 = paramNalUnitTargetBuffer1.readUnsignedExpGolombCodedInt();
    int i1 = paramNalUnitTargetBuffer1.readUnsignedExpGolombCodedInt();
    k = i2;
    int j = i1;
    if (paramNalUnitTargetBuffer1.readBit())
    {
      k = paramNalUnitTargetBuffer1.readUnsignedExpGolombCodedInt();
      int i5 = paramNalUnitTargetBuffer1.readUnsignedExpGolombCodedInt();
      int i3 = paramNalUnitTargetBuffer1.readUnsignedExpGolombCodedInt();
      int i4 = paramNalUnitTargetBuffer1.readUnsignedExpGolombCodedInt();
      if ((i6 != 1) && (i6 != 2)) {
        i = 1;
      } else {
        i = 2;
      }
      if (i6 == 1) {
        j = 2;
      } else {
        j = 1;
      }
      k = i2 - i * (k + i5);
      j = i1 - j * (i3 + i4);
    }
    paramNalUnitTargetBuffer1.readUnsignedExpGolombCodedInt();
    paramNalUnitTargetBuffer1.readUnsignedExpGolombCodedInt();
    i1 = paramNalUnitTargetBuffer1.readUnsignedExpGolombCodedInt();
    if (paramNalUnitTargetBuffer1.readBit()) {
      i = 0;
    } else {
      i = n;
    }
    while (i <= n)
    {
      paramNalUnitTargetBuffer1.readUnsignedExpGolombCodedInt();
      paramNalUnitTargetBuffer1.readUnsignedExpGolombCodedInt();
      paramNalUnitTargetBuffer1.readUnsignedExpGolombCodedInt();
      i += 1;
    }
    paramNalUnitTargetBuffer1.readUnsignedExpGolombCodedInt();
    paramNalUnitTargetBuffer1.readUnsignedExpGolombCodedInt();
    paramNalUnitTargetBuffer1.readUnsignedExpGolombCodedInt();
    paramNalUnitTargetBuffer1.readUnsignedExpGolombCodedInt();
    paramNalUnitTargetBuffer1.readUnsignedExpGolombCodedInt();
    paramNalUnitTargetBuffer1.readUnsignedExpGolombCodedInt();
    if ((paramNalUnitTargetBuffer1.readBit()) && (paramNalUnitTargetBuffer1.readBit())) {
      skipScalingList(paramNalUnitTargetBuffer1);
    }
    paramNalUnitTargetBuffer1.skipBits(2);
    if (paramNalUnitTargetBuffer1.readBit())
    {
      paramNalUnitTargetBuffer1.skipBits(8);
      paramNalUnitTargetBuffer1.readUnsignedExpGolombCodedInt();
      paramNalUnitTargetBuffer1.readUnsignedExpGolombCodedInt();
      paramNalUnitTargetBuffer1.skipBit();
    }
    skipShortTermRefPicSets(paramNalUnitTargetBuffer1);
    if (paramNalUnitTargetBuffer1.readBit())
    {
      i = m;
      while (i < paramNalUnitTargetBuffer1.readUnsignedExpGolombCodedInt())
      {
        paramNalUnitTargetBuffer1.skipBits(i1 + 4 + 1);
        i += 1;
      }
    }
    paramNalUnitTargetBuffer1.skipBits(2);
    float f2 = 1.0F;
    float f1;
    if ((paramNalUnitTargetBuffer1.readBit()) && (paramNalUnitTargetBuffer1.readBit()))
    {
      i = paramNalUnitTargetBuffer1.readBits(8);
      if (i == 255)
      {
        i = paramNalUnitTargetBuffer1.readBits(16);
        m = paramNalUnitTargetBuffer1.readBits(16);
        f1 = f2;
        if (i != 0)
        {
          f1 = f2;
          if (m != 0) {
            f1 = i / m;
          }
        }
      }
      else if (i < NalUnitUtil.ASPECT_RATIO_IDC_VALUES.length)
      {
        f1 = NalUnitUtil.ASPECT_RATIO_IDC_VALUES[i];
      }
      else
      {
        paramNalUnitTargetBuffer1 = new StringBuilder();
        paramNalUnitTargetBuffer1.append("Unexpected aspect_ratio_idc value: ");
        paramNalUnitTargetBuffer1.append(i);
        Log.w("H265Reader", paramNalUnitTargetBuffer1.toString());
      }
    }
    else
    {
      f1 = 1.0F;
    }
    return Format.createVideoSampleFormat(paramString, "video/hevc", null, -1, -1, k, j, -1.0F, Collections.singletonList(arrayOfByte1), -1, f1, null);
  }
  
  private static void skipScalingList(ParsableNalUnitBitArray paramParsableNalUnitBitArray)
  {
    int i = 0;
    while (i < 4)
    {
      int j = 0;
      while (j < 6)
      {
        if (!paramParsableNalUnitBitArray.readBit())
        {
          paramParsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        }
        else
        {
          int m = Math.min(64, 1 << (i << 1) + 4);
          if (i > 1) {
            paramParsableNalUnitBitArray.readSignedExpGolombCodedInt();
          }
          k = 0;
          while (k < m)
          {
            paramParsableNalUnitBitArray.readSignedExpGolombCodedInt();
            k += 1;
          }
        }
        int k = 3;
        if (i != 3) {
          k = 1;
        }
        j += k;
      }
      i += 1;
    }
  }
  
  private static void skipShortTermRefPicSets(ParsableNalUnitBitArray paramParsableNalUnitBitArray)
  {
    int n = paramParsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
    int i = 0;
    boolean bool = false;
    int k;
    for (int j = 0; i < n; j = k)
    {
      if (i != 0) {
        bool = paramParsableNalUnitBitArray.readBit();
      }
      if (bool)
      {
        paramParsableNalUnitBitArray.skipBit();
        paramParsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        m = 0;
        for (;;)
        {
          k = j;
          if (m > j) {
            break;
          }
          if (paramParsableNalUnitBitArray.readBit()) {
            paramParsableNalUnitBitArray.skipBit();
          }
          m += 1;
        }
      }
      k = paramParsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
      int m = paramParsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
      j = 0;
      while (j < k)
      {
        paramParsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        paramParsableNalUnitBitArray.skipBit();
        j += 1;
      }
      j = 0;
      while (j < m)
      {
        paramParsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        paramParsableNalUnitBitArray.skipBit();
        j += 1;
      }
      k += m;
      i += 1;
    }
  }
  
  private void startNalUnit(long paramLong1, int paramInt1, int paramInt2, long paramLong2)
  {
    if (this.hasOutputFormat)
    {
      this.sampleReader.startNalUnit(paramLong1, paramInt1, paramInt2, paramLong2);
    }
    else
    {
      this.vps.startNalUnit(paramInt2);
      this.sps.startNalUnit(paramInt2);
      this.pps.startNalUnit(paramInt2);
    }
    this.prefixSei.startNalUnit(paramInt2);
    this.suffixSei.startNalUnit(paramInt2);
  }
  
  public void consume(ParsableByteArray paramParsableByteArray)
  {
    if (paramParsableByteArray.bytesLeft() > 0)
    {
      int i = paramParsableByteArray.getPosition();
      int j = paramParsableByteArray.limit();
      byte[] arrayOfByte = paramParsableByteArray.data;
      this.totalBytesWritten += paramParsableByteArray.bytesLeft();
      this.output.sampleData(paramParsableByteArray, paramParsableByteArray.bytesLeft());
      while (i < j)
      {
        int k = NalUnitUtil.findNalUnit(arrayOfByte, i, j, this.prefixFlags);
        if (k == j)
        {
          nalUnitData(arrayOfByte, i, j);
          return;
        }
        int m = NalUnitUtil.getH265NalUnitType(arrayOfByte, k);
        int i1 = k - i;
        if (i1 > 0) {
          nalUnitData(arrayOfByte, i, k);
        }
        int n = j - k;
        long l = this.totalBytesWritten - n;
        if (i1 < 0) {
          i = -i1;
        } else {
          i = 0;
        }
        endNalUnit(l, n, i, this.pesTimeUs);
        startNalUnit(l, n, m, this.pesTimeUs);
        i = k + 3;
      }
    }
  }
  
  public void createTracks(ExtractorOutput paramExtractorOutput, TsPayloadReader.TrackIdGenerator paramTrackIdGenerator)
  {
    paramTrackIdGenerator.generateNewId();
    this.formatId = paramTrackIdGenerator.getFormatId();
    this.output = paramExtractorOutput.track(paramTrackIdGenerator.getTrackId(), 2);
    this.sampleReader = new H265Reader.SampleReader(this.output);
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
    this.vps.reset();
    this.sps.reset();
    this.pps.reset();
    this.prefixSei.reset();
    this.suffixSei.reset();
    this.sampleReader.reset();
    this.totalBytesWritten = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.ts.H265Reader
 * JD-Core Version:    0.7.0.1
 */
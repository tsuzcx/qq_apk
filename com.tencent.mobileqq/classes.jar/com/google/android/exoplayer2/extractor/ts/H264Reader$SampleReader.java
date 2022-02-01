package com.google.android.exoplayer2.extractor.ts;

import android.util.SparseArray;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.NalUnitUtil.PpsData;
import com.google.android.exoplayer2.util.NalUnitUtil.SpsData;
import com.google.android.exoplayer2.util.ParsableNalUnitBitArray;
import java.util.Arrays;

final class H264Reader$SampleReader
{
  private static final int DEFAULT_BUFFER_SIZE = 128;
  private static final int NAL_UNIT_TYPE_AUD = 9;
  private static final int NAL_UNIT_TYPE_IDR = 5;
  private static final int NAL_UNIT_TYPE_NON_IDR = 1;
  private static final int NAL_UNIT_TYPE_PARTITION_A = 2;
  private final boolean allowNonIdrKeyframes;
  private final ParsableNalUnitBitArray bitArray;
  private byte[] buffer;
  private int bufferLength;
  private final boolean detectAccessUnits;
  private boolean isFilling;
  private long nalUnitStartPosition;
  private long nalUnitTimeUs;
  private int nalUnitType;
  private final TrackOutput output;
  private final SparseArray<NalUnitUtil.PpsData> pps;
  private H264Reader.SampleReader.SliceHeaderData previousSliceHeader;
  private boolean readingSample;
  private boolean sampleIsKeyframe;
  private long samplePosition;
  private long sampleTimeUs;
  private H264Reader.SampleReader.SliceHeaderData sliceHeader;
  private final SparseArray<NalUnitUtil.SpsData> sps;
  
  public H264Reader$SampleReader(TrackOutput paramTrackOutput, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.output = paramTrackOutput;
    this.allowNonIdrKeyframes = paramBoolean1;
    this.detectAccessUnits = paramBoolean2;
    this.sps = new SparseArray();
    this.pps = new SparseArray();
    this.previousSliceHeader = new H264Reader.SampleReader.SliceHeaderData(null);
    this.sliceHeader = new H264Reader.SampleReader.SliceHeaderData(null);
    this.buffer = new byte[''];
    this.bitArray = new ParsableNalUnitBitArray(this.buffer, 0, 0);
    reset();
  }
  
  private void outputSample(int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void appendToNalUnit(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (!this.isFilling) {
      return;
    }
    paramInt2 -= paramInt1;
    Object localObject = this.buffer;
    int i = localObject.length;
    int j = this.bufferLength;
    if (i < j + paramInt2) {
      this.buffer = Arrays.copyOf((byte[])localObject, (j + paramInt2) * 2);
    }
    System.arraycopy(paramArrayOfByte, paramInt1, this.buffer, this.bufferLength, paramInt2);
    this.bufferLength += paramInt2;
    this.bitArray.reset(this.buffer, 0, this.bufferLength);
    if (!this.bitArray.canReadBits(8)) {
      return;
    }
    this.bitArray.skipBit();
    int m = this.bitArray.readBits(2);
    this.bitArray.skipBits(5);
    if (!this.bitArray.canReadExpGolombCodedNum()) {
      return;
    }
    this.bitArray.readUnsignedExpGolombCodedInt();
    if (!this.bitArray.canReadExpGolombCodedNum()) {
      return;
    }
    int n = this.bitArray.readUnsignedExpGolombCodedInt();
    if (!this.detectAccessUnits)
    {
      this.isFilling = false;
      this.sliceHeader.setSliceType(n);
      return;
    }
    if (!this.bitArray.canReadExpGolombCodedNum()) {
      return;
    }
    int i1 = this.bitArray.readUnsignedExpGolombCodedInt();
    if (this.pps.indexOfKey(i1) < 0)
    {
      this.isFilling = false;
      return;
    }
    paramArrayOfByte = (NalUnitUtil.PpsData)this.pps.get(i1);
    localObject = (NalUnitUtil.SpsData)this.sps.get(paramArrayOfByte.seqParameterSetId);
    if (((NalUnitUtil.SpsData)localObject).separateColorPlaneFlag)
    {
      if (!this.bitArray.canReadBits(2)) {
        return;
      }
      this.bitArray.skipBits(2);
    }
    if (!this.bitArray.canReadBits(((NalUnitUtil.SpsData)localObject).frameNumLength)) {
      return;
    }
    int i2 = this.bitArray.readBits(((NalUnitUtil.SpsData)localObject).frameNumLength);
    boolean bool1;
    if (!((NalUnitUtil.SpsData)localObject).frameMbsOnlyFlag)
    {
      if (!this.bitArray.canReadBits(1)) {
        return;
      }
      bool1 = this.bitArray.readBit();
      if (bool1)
      {
        if (!this.bitArray.canReadBits(1)) {
          return;
        }
        bool3 = this.bitArray.readBit();
        bool2 = true;
        break label390;
      }
    }
    else
    {
      bool1 = false;
    }
    boolean bool2 = false;
    boolean bool3 = false;
    label390:
    boolean bool4;
    if (this.nalUnitType == 5) {
      bool4 = true;
    } else {
      bool4 = false;
    }
    if (bool4)
    {
      if (!this.bitArray.canReadExpGolombCodedNum()) {
        return;
      }
      j = this.bitArray.readUnsignedExpGolombCodedInt();
    }
    else
    {
      j = 0;
    }
    if (((NalUnitUtil.SpsData)localObject).picOrderCountType == 0)
    {
      if (!this.bitArray.canReadBits(((NalUnitUtil.SpsData)localObject).picOrderCntLsbLength)) {
        return;
      }
      paramInt1 = this.bitArray.readBits(((NalUnitUtil.SpsData)localObject).picOrderCntLsbLength);
      if ((paramArrayOfByte.bottomFieldPicOrderInFramePresentFlag) && (!bool1))
      {
        if (!this.bitArray.canReadExpGolombCodedNum()) {
          return;
        }
        paramInt2 = this.bitArray.readSignedExpGolombCodedInt();
        break label599;
      }
    }
    else
    {
      if ((((NalUnitUtil.SpsData)localObject).picOrderCountType == 1) && (!((NalUnitUtil.SpsData)localObject).deltaPicOrderAlwaysZeroFlag))
      {
        if (!this.bitArray.canReadExpGolombCodedNum()) {
          return;
        }
        i = this.bitArray.readSignedExpGolombCodedInt();
        if ((paramArrayOfByte.bottomFieldPicOrderInFramePresentFlag) && (!bool1))
        {
          if (!this.bitArray.canReadExpGolombCodedNum()) {
            return;
          }
          k = this.bitArray.readSignedExpGolombCodedInt();
          paramInt1 = 0;
          paramInt2 = 0;
          break label605;
        }
        paramInt1 = 0;
        paramInt2 = 0;
        break label602;
      }
      paramInt1 = 0;
    }
    paramInt2 = 0;
    label599:
    i = 0;
    label602:
    int k = 0;
    label605:
    this.sliceHeader.setAll((NalUnitUtil.SpsData)localObject, m, n, i2, i1, bool1, bool2, bool3, bool4, j, paramInt1, paramInt2, i, k);
    this.isFilling = false;
  }
  
  public void endNalUnit(long paramLong, int paramInt)
  {
    int j = this.nalUnitType;
    int i = 0;
    if ((j == 9) || ((this.detectAccessUnits) && (H264Reader.SampleReader.SliceHeaderData.access$100(this.sliceHeader, this.previousSliceHeader))))
    {
      if (this.readingSample) {
        outputSample(paramInt + (int)(paramLong - this.nalUnitStartPosition));
      }
      this.samplePosition = this.nalUnitStartPosition;
      this.sampleTimeUs = this.nalUnitTimeUs;
      this.sampleIsKeyframe = false;
      this.readingSample = true;
    }
    int k = this.sampleIsKeyframe;
    j = this.nalUnitType;
    if (j != 5)
    {
      paramInt = i;
      if (this.allowNonIdrKeyframes)
      {
        paramInt = i;
        if (j == 1)
        {
          paramInt = i;
          if (!this.sliceHeader.isISlice()) {}
        }
      }
    }
    else
    {
      paramInt = 1;
    }
    this.sampleIsKeyframe = (k | paramInt);
  }
  
  public boolean needsSpsPps()
  {
    return this.detectAccessUnits;
  }
  
  public void putPps(NalUnitUtil.PpsData paramPpsData)
  {
    this.pps.append(paramPpsData.picParameterSetId, paramPpsData);
  }
  
  public void putSps(NalUnitUtil.SpsData paramSpsData)
  {
    this.sps.append(paramSpsData.seqParameterSetId, paramSpsData);
  }
  
  public void reset()
  {
    this.isFilling = false;
    this.readingSample = false;
    this.sliceHeader.clear();
  }
  
  public void startNalUnit(long paramLong1, int paramInt, long paramLong2)
  {
    this.nalUnitType = paramInt;
    this.nalUnitTimeUs = paramLong2;
    this.nalUnitStartPosition = paramLong1;
    if ((!this.allowNonIdrKeyframes) || (this.nalUnitType != 1))
    {
      if (this.detectAccessUnits)
      {
        paramInt = this.nalUnitType;
        if ((paramInt != 5) && (paramInt != 1) && (paramInt != 2)) {}
      }
    }
    else
    {
      H264Reader.SampleReader.SliceHeaderData localSliceHeaderData = this.previousSliceHeader;
      this.previousSliceHeader = this.sliceHeader;
      this.sliceHeader = localSliceHeaderData;
      this.sliceHeader.clear();
      this.bufferLength = 0;
      this.isFilling = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.ts.H264Reader.SampleReader
 * JD-Core Version:    0.7.0.1
 */
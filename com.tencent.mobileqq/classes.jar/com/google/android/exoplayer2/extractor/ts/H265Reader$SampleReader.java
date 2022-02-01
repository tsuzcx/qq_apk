package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.extractor.TrackOutput;

final class H265Reader$SampleReader
{
  private static final int FIRST_SLICE_FLAG_OFFSET = 2;
  private boolean isFirstParameterSet;
  private boolean isFirstSlice;
  private boolean lookingForFirstSliceFlag;
  private int nalUnitBytesRead;
  private boolean nalUnitHasKeyframeData;
  private long nalUnitStartPosition;
  private long nalUnitTimeUs;
  private final TrackOutput output;
  private boolean readingSample;
  private boolean sampleIsKeyframe;
  private long samplePosition;
  private long sampleTimeUs;
  private boolean writingParameterSets;
  
  public H265Reader$SampleReader(TrackOutput paramTrackOutput)
  {
    this.output = paramTrackOutput;
  }
  
  private void outputSample(int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void endNalUnit(long paramLong, int paramInt)
  {
    if ((this.writingParameterSets) && (this.isFirstSlice))
    {
      this.sampleIsKeyframe = this.nalUnitHasKeyframeData;
      this.writingParameterSets = false;
      return;
    }
    if ((this.isFirstParameterSet) || (this.isFirstSlice))
    {
      if (this.readingSample) {
        outputSample(paramInt + (int)(paramLong - this.nalUnitStartPosition));
      }
      this.samplePosition = this.nalUnitStartPosition;
      this.sampleTimeUs = this.nalUnitTimeUs;
      this.readingSample = true;
      this.sampleIsKeyframe = this.nalUnitHasKeyframeData;
    }
  }
  
  public void readNalUnitData(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.lookingForFirstSliceFlag)
    {
      int i = this.nalUnitBytesRead;
      int j = paramInt1 + 2 - i;
      if (j < paramInt2)
      {
        boolean bool;
        if ((paramArrayOfByte[j] & 0x80) != 0) {
          bool = true;
        } else {
          bool = false;
        }
        this.isFirstSlice = bool;
        this.lookingForFirstSliceFlag = false;
        return;
      }
      this.nalUnitBytesRead = (i + (paramInt2 - paramInt1));
    }
  }
  
  public void reset()
  {
    this.lookingForFirstSliceFlag = false;
    this.isFirstSlice = false;
    this.isFirstParameterSet = false;
    this.readingSample = false;
    this.writingParameterSets = false;
  }
  
  public void startNalUnit(long paramLong1, int paramInt1, int paramInt2, long paramLong2)
  {
    this.isFirstSlice = false;
    this.isFirstParameterSet = false;
    this.nalUnitTimeUs = paramLong2;
    this.nalUnitBytesRead = 0;
    this.nalUnitStartPosition = paramLong1;
    boolean bool2 = true;
    if (paramInt2 >= 32)
    {
      if ((!this.writingParameterSets) && (this.readingSample))
      {
        outputSample(paramInt1);
        this.readingSample = false;
      }
      if (paramInt2 <= 34)
      {
        this.isFirstParameterSet = (this.writingParameterSets ^ true);
        this.writingParameterSets = true;
      }
    }
    if ((paramInt2 >= 16) && (paramInt2 <= 21)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.nalUnitHasKeyframeData = bool1;
    boolean bool1 = bool2;
    if (!this.nalUnitHasKeyframeData) {
      if (paramInt2 <= 9) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
    }
    this.lookingForFirstSliceFlag = bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.ts.H265Reader.SampleReader
 * JD-Core Version:    0.7.0.1
 */
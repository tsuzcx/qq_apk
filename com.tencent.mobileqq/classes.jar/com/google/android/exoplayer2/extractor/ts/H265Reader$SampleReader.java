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
    if (this.sampleIsKeyframe) {}
    for (int i = 1;; i = 0)
    {
      int j = (int)(this.nalUnitStartPosition - this.samplePosition);
      this.output.sampleMetadata(this.sampleTimeUs, i, j, paramInt, null);
      return;
    }
  }
  
  public void endNalUnit(long paramLong, int paramInt)
  {
    if ((this.writingParameterSets) && (this.isFirstSlice))
    {
      this.sampleIsKeyframe = this.nalUnitHasKeyframeData;
      this.writingParameterSets = false;
    }
    while ((!this.isFirstParameterSet) && (!this.isFirstSlice)) {
      return;
    }
    if (this.readingSample) {
      outputSample((int)(paramLong - this.nalUnitStartPosition) + paramInt);
    }
    this.samplePosition = this.nalUnitStartPosition;
    this.sampleTimeUs = this.nalUnitTimeUs;
    this.readingSample = true;
    this.sampleIsKeyframe = this.nalUnitHasKeyframeData;
  }
  
  public void readNalUnitData(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.lookingForFirstSliceFlag)
    {
      int i = paramInt1 + 2 - this.nalUnitBytesRead;
      if (i >= paramInt2) {
        break label55;
      }
      if ((paramArrayOfByte[i] & 0x80) == 0) {
        break label49;
      }
    }
    label49:
    for (boolean bool = true;; bool = false)
    {
      this.isFirstSlice = bool;
      this.lookingForFirstSliceFlag = false;
      return;
    }
    label55:
    this.nalUnitBytesRead += paramInt2 - paramInt1;
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
    boolean bool2 = false;
    this.isFirstSlice = false;
    this.isFirstParameterSet = false;
    this.nalUnitTimeUs = paramLong2;
    this.nalUnitBytesRead = 0;
    this.nalUnitStartPosition = paramLong1;
    if (paramInt2 >= 32)
    {
      if ((!this.writingParameterSets) && (this.readingSample))
      {
        outputSample(paramInt1);
        this.readingSample = false;
      }
      if (paramInt2 <= 34)
      {
        if (this.writingParameterSets) {
          break label139;
        }
        bool1 = true;
        this.isFirstParameterSet = bool1;
        this.writingParameterSets = true;
      }
    }
    if ((paramInt2 >= 16) && (paramInt2 <= 21)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.nalUnitHasKeyframeData = bool1;
      if (!this.nalUnitHasKeyframeData)
      {
        bool1 = bool2;
        if (paramInt2 > 9) {}
      }
      else
      {
        bool1 = true;
      }
      this.lookingForFirstSliceFlag = bool1;
      return;
      label139:
      bool1 = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.ts.H265Reader.SampleReader
 * JD-Core Version:    0.7.0.1
 */
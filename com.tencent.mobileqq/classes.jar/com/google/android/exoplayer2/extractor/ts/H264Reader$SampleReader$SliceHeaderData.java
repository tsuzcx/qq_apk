package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.util.NalUnitUtil.SpsData;

final class H264Reader$SampleReader$SliceHeaderData
{
  private static final int SLICE_TYPE_ALL_I = 7;
  private static final int SLICE_TYPE_I = 2;
  private boolean bottomFieldFlag;
  private boolean bottomFieldFlagPresent;
  private int deltaPicOrderCnt0;
  private int deltaPicOrderCnt1;
  private int deltaPicOrderCntBottom;
  private boolean fieldPicFlag;
  private int frameNum;
  private boolean hasSliceType;
  private boolean idrPicFlag;
  private int idrPicId;
  private boolean isComplete;
  private int nalRefIdc;
  private int picOrderCntLsb;
  private int picParameterSetId;
  private int sliceType;
  private NalUnitUtil.SpsData spsData;
  
  private boolean isFirstVclNalUnitOfPicture(SliceHeaderData paramSliceHeaderData)
  {
    boolean bool1 = this.isComplete;
    boolean bool2 = true;
    if (bool1)
    {
      bool1 = bool2;
      if (!paramSliceHeaderData.isComplete) {
        break label281;
      }
      bool1 = bool2;
      if (this.frameNum != paramSliceHeaderData.frameNum) {
        break label281;
      }
      bool1 = bool2;
      if (this.picParameterSetId != paramSliceHeaderData.picParameterSetId) {
        break label281;
      }
      bool1 = bool2;
      if (this.fieldPicFlag != paramSliceHeaderData.fieldPicFlag) {
        break label281;
      }
      if ((this.bottomFieldFlagPresent) && (paramSliceHeaderData.bottomFieldFlagPresent))
      {
        bool1 = bool2;
        if (this.bottomFieldFlag != paramSliceHeaderData.bottomFieldFlag) {
          break label281;
        }
      }
      int i = this.nalRefIdc;
      int j = paramSliceHeaderData.nalRefIdc;
      if (i != j)
      {
        bool1 = bool2;
        if (i == 0) {
          break label281;
        }
        bool1 = bool2;
        if (j == 0) {
          break label281;
        }
      }
      if ((this.spsData.picOrderCountType == 0) && (paramSliceHeaderData.spsData.picOrderCountType == 0))
      {
        bool1 = bool2;
        if (this.picOrderCntLsb != paramSliceHeaderData.picOrderCntLsb) {
          break label281;
        }
        bool1 = bool2;
        if (this.deltaPicOrderCntBottom != paramSliceHeaderData.deltaPicOrderCntBottom) {
          break label281;
        }
      }
      if ((this.spsData.picOrderCountType == 1) && (paramSliceHeaderData.spsData.picOrderCountType == 1))
      {
        bool1 = bool2;
        if (this.deltaPicOrderCnt0 != paramSliceHeaderData.deltaPicOrderCnt0) {
          break label281;
        }
        bool1 = bool2;
        if (this.deltaPicOrderCnt1 != paramSliceHeaderData.deltaPicOrderCnt1) {
          break label281;
        }
      }
      boolean bool3 = this.idrPicFlag;
      boolean bool4 = paramSliceHeaderData.idrPicFlag;
      bool1 = bool2;
      if (bool3 != bool4) {
        break label281;
      }
      if ((bool3) && (bool4) && (this.idrPicId != paramSliceHeaderData.idrPicId)) {
        return true;
      }
    }
    bool1 = false;
    label281:
    return bool1;
  }
  
  public void clear()
  {
    this.hasSliceType = false;
    this.isComplete = false;
  }
  
  public boolean isISlice()
  {
    if (this.hasSliceType)
    {
      int i = this.sliceType;
      if ((i == 7) || (i == 2)) {
        return true;
      }
    }
    return false;
  }
  
  public void setAll(NalUnitUtil.SpsData paramSpsData, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
  {
    this.spsData = paramSpsData;
    this.nalRefIdc = paramInt1;
    this.sliceType = paramInt2;
    this.frameNum = paramInt3;
    this.picParameterSetId = paramInt4;
    this.fieldPicFlag = paramBoolean1;
    this.bottomFieldFlagPresent = paramBoolean2;
    this.bottomFieldFlag = paramBoolean3;
    this.idrPicFlag = paramBoolean4;
    this.idrPicId = paramInt5;
    this.picOrderCntLsb = paramInt6;
    this.deltaPicOrderCntBottom = paramInt7;
    this.deltaPicOrderCnt0 = paramInt8;
    this.deltaPicOrderCnt1 = paramInt9;
    this.isComplete = true;
    this.hasSliceType = true;
  }
  
  public void setSliceType(int paramInt)
  {
    this.sliceType = paramInt;
    this.hasSliceType = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.ts.H264Reader.SampleReader.SliceHeaderData
 * JD-Core Version:    0.7.0.1
 */
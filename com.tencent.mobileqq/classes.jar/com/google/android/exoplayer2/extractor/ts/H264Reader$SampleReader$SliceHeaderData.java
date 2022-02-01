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
    return (this.isComplete) && ((!paramSliceHeaderData.isComplete) || (this.frameNum != paramSliceHeaderData.frameNum) || (this.picParameterSetId != paramSliceHeaderData.picParameterSetId) || (this.fieldPicFlag != paramSliceHeaderData.fieldPicFlag) || ((this.bottomFieldFlagPresent) && (paramSliceHeaderData.bottomFieldFlagPresent) && (this.bottomFieldFlag != paramSliceHeaderData.bottomFieldFlag)) || ((this.nalRefIdc != paramSliceHeaderData.nalRefIdc) && ((this.nalRefIdc == 0) || (paramSliceHeaderData.nalRefIdc == 0))) || ((this.spsData.picOrderCountType == 0) && (paramSliceHeaderData.spsData.picOrderCountType == 0) && ((this.picOrderCntLsb != paramSliceHeaderData.picOrderCntLsb) || (this.deltaPicOrderCntBottom != paramSliceHeaderData.deltaPicOrderCntBottom))) || ((this.spsData.picOrderCountType == 1) && (paramSliceHeaderData.spsData.picOrderCountType == 1) && ((this.deltaPicOrderCnt0 != paramSliceHeaderData.deltaPicOrderCnt0) || (this.deltaPicOrderCnt1 != paramSliceHeaderData.deltaPicOrderCnt1))) || (this.idrPicFlag != paramSliceHeaderData.idrPicFlag) || ((this.idrPicFlag) && (paramSliceHeaderData.idrPicFlag) && (this.idrPicId != paramSliceHeaderData.idrPicId)));
  }
  
  public void clear()
  {
    this.hasSliceType = false;
    this.isComplete = false;
  }
  
  public boolean isISlice()
  {
    return (this.hasSliceType) && ((this.sliceType == 7) || (this.sliceType == 2));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.ts.H264Reader.SampleReader.SliceHeaderData
 * JD-Core Version:    0.7.0.1
 */
package com.google.android.exoplayer2.extractor.mkv;

import com.google.android.exoplayer2.extractor.ExtractorInput;

final class MatroskaExtractor$InnerEbmlReaderOutput
  implements EbmlReaderOutput
{
  private MatroskaExtractor$InnerEbmlReaderOutput(MatroskaExtractor paramMatroskaExtractor) {}
  
  public void binaryElement(int paramInt1, int paramInt2, ExtractorInput paramExtractorInput)
  {
    this.this$0.binaryElement(paramInt1, paramInt2, paramExtractorInput);
  }
  
  public void endMasterElement(int paramInt)
  {
    this.this$0.endMasterElement(paramInt);
  }
  
  public void floatElement(int paramInt, double paramDouble)
  {
    this.this$0.floatElement(paramInt, paramDouble);
  }
  
  public int getElementType(int paramInt)
  {
    return this.this$0.getElementType(paramInt);
  }
  
  public void integerElement(int paramInt, long paramLong)
  {
    this.this$0.integerElement(paramInt, paramLong);
  }
  
  public boolean isLevel1Element(int paramInt)
  {
    return this.this$0.isLevel1Element(paramInt);
  }
  
  public void startMasterElement(int paramInt, long paramLong1, long paramLong2)
  {
    this.this$0.startMasterElement(paramInt, paramLong1, paramLong2);
  }
  
  public void stringElement(int paramInt, String paramString)
  {
    this.this$0.stringElement(paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.InnerEbmlReaderOutput
 * JD-Core Version:    0.7.0.1
 */
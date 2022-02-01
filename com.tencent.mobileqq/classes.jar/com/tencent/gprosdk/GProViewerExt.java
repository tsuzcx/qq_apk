package com.tencent.gprosdk;

public final class GProViewerExt
{
  final int mFakeNum;
  final int mRealNum;
  final int mRebotNum;
  
  public GProViewerExt(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mFakeNum = paramInt1;
    this.mRealNum = paramInt2;
    this.mRebotNum = paramInt3;
  }
  
  public int getFakeNum()
  {
    return this.mFakeNum;
  }
  
  public int getRealNum()
  {
    return this.mRealNum;
  }
  
  public int getRebotNum()
  {
    return this.mRebotNum;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GProViewerExt{mFakeNum=");
    localStringBuilder.append(this.mFakeNum);
    localStringBuilder.append(",mRealNum=");
    localStringBuilder.append(this.mRealNum);
    localStringBuilder.append(",mRebotNum=");
    localStringBuilder.append(this.mRebotNum);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gprosdk.GProViewerExt
 * JD-Core Version:    0.7.0.1
 */
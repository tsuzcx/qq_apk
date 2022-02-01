package com.tencent.hippy.qq.view.tkd.listview;

public class HippyTKDUISize
{
  public int mHeight;
  public int mWidth;
  
  public HippyTKDUISize()
  {
    this.mWidth = 0;
    this.mHeight = 0;
  }
  
  public HippyTKDUISize(int paramInt1, int paramInt2)
  {
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
  }
  
  public void add(HippyTKDUISize paramHippyTKDUISize)
  {
    if (paramHippyTKDUISize == null) {
      return;
    }
    this.mWidth += paramHippyTKDUISize.mWidth;
    this.mHeight += paramHippyTKDUISize.mHeight;
  }
  
  public void add(short paramShort1, short paramShort2)
  {
    this.mWidth += paramShort1;
    this.mHeight += paramShort2;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof HippyTKDUISize)) {
      return false;
    }
    if (paramObject == this) {
      return true;
    }
    paramObject = (HippyTKDUISize)paramObject;
    return (paramObject.mHeight == this.mHeight) && (paramObject.mWidth == this.mWidth);
  }
  
  public int hashCode()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.mWidth);
    localStringBuilder.append("x");
    localStringBuilder.append(this.mHeight);
    return localStringBuilder.toString().hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.view.tkd.listview.HippyTKDUISize
 * JD-Core Version:    0.7.0.1
 */
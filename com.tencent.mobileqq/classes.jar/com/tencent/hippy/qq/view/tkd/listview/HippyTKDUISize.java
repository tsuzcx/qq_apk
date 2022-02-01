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
    boolean bool2 = true;
    boolean bool1;
    if (!(paramObject instanceof HippyTKDUISize)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramObject == this);
      paramObject = (HippyTKDUISize)paramObject;
      if (paramObject.mHeight != this.mHeight) {
        break;
      }
      bool1 = bool2;
    } while (paramObject.mWidth == this.mWidth);
    return false;
  }
  
  public int hashCode()
  {
    return ("" + this.mWidth + "x" + this.mHeight).hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.view.tkd.listview.HippyTKDUISize
 * JD-Core Version:    0.7.0.1
 */
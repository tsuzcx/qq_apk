package com.huawei.hms.common.size;

public class Size
{
  private final int height;
  private final int width;
  
  public Size(int paramInt1, int paramInt2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
  }
  
  public static Size parseSize(String paramString)
  {
    try
    {
      int j = paramString.indexOf("x");
      int i = j;
      if (j < 0) {
        i = paramString.indexOf("*");
      }
      paramString = new Size(Integer.parseInt(paramString.substring(0, i)), Integer.parseInt(paramString.substring(i + 1)));
      return paramString;
    }
    catch (Exception paramString)
    {
      label49:
      break label49;
    }
    throw new IllegalArgumentException("Size parses failed");
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    boolean bool1 = bool2;
    if ((paramObject instanceof Size))
    {
      paramObject = (Size)paramObject;
      bool1 = bool2;
      if (this.width == paramObject.width)
      {
        bool1 = bool2;
        if (this.height == paramObject.height) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public final int getHeight()
  {
    return this.height;
  }
  
  public final int getWidth()
  {
    return this.width;
  }
  
  public final String toString()
  {
    int i = this.width;
    int j = this.height;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Width is ");
    localStringBuilder.append(i);
    localStringBuilder.append(" Height is ");
    localStringBuilder.append(j);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.common.size.Size
 * JD-Core Version:    0.7.0.1
 */
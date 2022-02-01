package com.huawei.hms.common.size;

public class Size
{
  private final int a;
  private final int b;
  
  public Size(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
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
      throw new IllegalArgumentException("Size parses failed");
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == null) {}
    do
    {
      return false;
      if (this == paramObject) {
        return true;
      }
    } while (!(paramObject instanceof Size));
    paramObject = (Size)paramObject;
    if ((this.a == paramObject.a) && (this.b == paramObject.b)) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public final int getHeight()
  {
    return this.b;
  }
  
  public final int getWidth()
  {
    return this.a;
  }
  
  public final String toString()
  {
    int i = this.a;
    int j = this.b;
    return "Width is " + i + " Height is " + j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.common.size.Size
 * JD-Core Version:    0.7.0.1
 */
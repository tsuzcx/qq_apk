package com.tencent.mobileqq.ar.arengine;

public abstract class ARCloudObjectClassifyBaseResult
  extends ARCloudRecogResultBase
{
  private int a = 1;
  private int b = 1;
  
  public ARCloudObjectClassifyBaseResult()
  {
    this(1, 1, 5);
  }
  
  public ARCloudObjectClassifyBaseResult(int paramInt1, int paramInt2)
  {
    this(paramInt1, paramInt2, 5);
  }
  
  public ARCloudObjectClassifyBaseResult(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public static boolean a(ARCloudObjectClassifyBaseResult paramARCloudObjectClassifyBaseResult)
  {
    return (paramARCloudObjectClassifyBaseResult != null) && (paramARCloudObjectClassifyBaseResult.a());
  }
  
  public int a()
  {
    return this.b;
  }
  
  public abstract boolean a();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudObjectClassifyBaseResult
 * JD-Core Version:    0.7.0.1
 */
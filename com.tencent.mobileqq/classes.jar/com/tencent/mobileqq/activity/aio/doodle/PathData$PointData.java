package com.tencent.mobileqq.activity.aio.doodle;

public class PathData$PointData
  implements MyParcelable
{
  public static final MyParcelable.Creator<PointData> a = new PathData.PointData.1();
  private float b;
  private float c;
  private float d;
  private long e;
  
  public PathData$PointData() {}
  
  public PathData$PointData(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    a(paramFloat1, paramFloat2, paramFloat3, paramLong);
  }
  
  public PathData$PointData(MyParcel paramMyParcel)
  {
    paramMyParcel.b();
    this.b = paramMyParcel.d();
    this.c = paramMyParcel.d();
    this.d = paramMyParcel.d();
    this.e = paramMyParcel.e();
  }
  
  public PathData$PointData(PointData paramPointData)
  {
    if (paramPointData != null) {
      a(paramPointData.a(), paramPointData.b(), paramPointData.c(), 0L);
    }
  }
  
  public float a()
  {
    return this.b;
  }
  
  public void a(float paramFloat)
  {
    this.b = paramFloat;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    this.d = paramFloat3;
    this.b = paramFloat1;
    this.c = paramFloat2;
    this.e = paramLong;
  }
  
  public void a(long paramLong)
  {
    this.e = paramLong;
  }
  
  public void a(MyParcel paramMyParcel, int paramInt)
  {
    paramMyParcel.a(1);
    paramMyParcel.a(this.b);
    paramMyParcel.a(this.c);
    paramMyParcel.a(this.d);
    paramMyParcel.a(this.e);
  }
  
  public float b()
  {
    return this.c;
  }
  
  public void b(float paramFloat)
  {
    this.c = paramFloat;
  }
  
  public float c()
  {
    return this.d;
  }
  
  public void c(float paramFloat)
  {
    this.d = paramFloat;
  }
  
  public long d()
  {
    return this.e;
  }
  
  public void d(float paramFloat)
  {
    this.b *= paramFloat;
    this.c *= paramFloat;
    this.d *= paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.PathData.PointData
 * JD-Core Version:    0.7.0.1
 */
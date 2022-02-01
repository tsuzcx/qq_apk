package com.tencent.mobileqq.activity.aio.doodle;

public class PathData$PointData
  implements MyParcelable
{
  public static final MyParcelable.Creator<PointData> a;
  private float jdField_a_of_type_Float;
  private long jdField_a_of_type_Long;
  private float b;
  private float c;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqActivityAioDoodleMyParcelable$Creator = new PathData.PointData.1();
  }
  
  public PathData$PointData() {}
  
  public PathData$PointData(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    a(paramFloat1, paramFloat2, paramFloat3, paramLong);
  }
  
  public PathData$PointData(MyParcel paramMyParcel)
  {
    paramMyParcel.a();
    this.jdField_a_of_type_Float = paramMyParcel.a();
    this.b = paramMyParcel.a();
    this.c = paramMyParcel.a();
    this.jdField_a_of_type_Long = paramMyParcel.a();
  }
  
  public PathData$PointData(PointData paramPointData)
  {
    if (paramPointData != null) {
      a(paramPointData.a(), paramPointData.b(), paramPointData.c(), 0L);
    }
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    this.c = paramFloat3;
    this.jdField_a_of_type_Float = paramFloat1;
    this.b = paramFloat2;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(MyParcel paramMyParcel, int paramInt)
  {
    paramMyParcel.a(1);
    paramMyParcel.a(this.jdField_a_of_type_Float);
    paramMyParcel.a(this.b);
    paramMyParcel.a(this.c);
    paramMyParcel.a(this.jdField_a_of_type_Long);
  }
  
  public float b()
  {
    return this.b;
  }
  
  public void b(float paramFloat)
  {
    this.b = paramFloat;
  }
  
  public float c()
  {
    return this.c;
  }
  
  public void c(float paramFloat)
  {
    this.c = paramFloat;
  }
  
  public void d(float paramFloat)
  {
    this.jdField_a_of_type_Float *= paramFloat;
    this.b *= paramFloat;
    this.c *= paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.PathData.PointData
 * JD-Core Version:    0.7.0.1
 */
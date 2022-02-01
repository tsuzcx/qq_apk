package com.tencent.mobileqq.activity.aio.doodle;

import android.graphics.Matrix;
import android.graphics.Path;

public class PathDrawer$PathSegment
  implements MyParcelable
{
  public static final MyParcelable.Creator<PathSegment> a;
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private Path jdField_a_of_type_AndroidGraphicsPath;
  private float b;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqActivityAioDoodleMyParcelable$Creator = new PathDrawer.PathSegment.1();
  }
  
  public PathDrawer$PathSegment(Path paramPath)
  {
    this.jdField_a_of_type_AndroidGraphicsPath = paramPath;
  }
  
  public PathDrawer$PathSegment(MyParcel paramMyParcel)
  {
    paramMyParcel.a();
    this.jdField_a_of_type_Float = paramMyParcel.a();
    this.jdField_a_of_type_Long = paramMyParcel.a();
    this.jdField_a_of_type_Int = paramMyParcel.a();
    this.b = paramMyParcel.a();
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public Path a()
  {
    return this.jdField_a_of_type_AndroidGraphicsPath;
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(Path paramPath)
  {
    this.jdField_a_of_type_AndroidGraphicsPath = paramPath;
  }
  
  public void a(MyParcel paramMyParcel, int paramInt)
  {
    paramMyParcel.a(1);
    paramMyParcel.a(this.jdField_a_of_type_Float);
    paramMyParcel.a(this.jdField_a_of_type_Long);
    paramMyParcel.a(this.jdField_a_of_type_Int);
    paramMyParcel.a(this.b);
  }
  
  public void a(PathSegment paramPathSegment)
  {
    if (this.jdField_a_of_type_AndroidGraphicsPath != null)
    {
      this.jdField_a_of_type_AndroidGraphicsPath.addPath(paramPathSegment.jdField_a_of_type_AndroidGraphicsPath);
      this.b += paramPathSegment.b;
    }
  }
  
  public float b()
  {
    return this.b;
  }
  
  public void b(float paramFloat)
  {
    this.b = paramFloat;
  }
  
  public void c(float paramFloat)
  {
    if (this.jdField_a_of_type_AndroidGraphicsPath == null) {
      return;
    }
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(paramFloat, paramFloat);
    Path localPath = new Path();
    localPath.addPath(this.jdField_a_of_type_AndroidGraphicsPath, localMatrix);
    this.jdField_a_of_type_AndroidGraphicsPath = localPath;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.PathDrawer.PathSegment
 * JD-Core Version:    0.7.0.1
 */
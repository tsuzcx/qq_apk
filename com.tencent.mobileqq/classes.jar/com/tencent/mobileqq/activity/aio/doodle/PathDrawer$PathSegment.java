package com.tencent.mobileqq.activity.aio.doodle;

import android.graphics.Matrix;
import android.graphics.Path;

public class PathDrawer$PathSegment
  implements MyParcelable
{
  public static final MyParcelable.Creator<PathSegment> a = new PathDrawer.PathSegment.1();
  private Path b;
  private float c;
  private long d;
  private float e;
  private int f = 0;
  
  public PathDrawer$PathSegment(Path paramPath)
  {
    this.b = paramPath;
  }
  
  public PathDrawer$PathSegment(MyParcel paramMyParcel)
  {
    paramMyParcel.b();
    this.c = paramMyParcel.d();
    this.d = paramMyParcel.e();
    this.f = paramMyParcel.b();
    this.e = paramMyParcel.d();
  }
  
  public Path a()
  {
    return this.b;
  }
  
  public void a(float paramFloat)
  {
    this.c = paramFloat;
  }
  
  public void a(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.d = paramLong;
  }
  
  public void a(Path paramPath)
  {
    this.b = paramPath;
  }
  
  public void a(MyParcel paramMyParcel, int paramInt)
  {
    paramMyParcel.a(1);
    paramMyParcel.a(this.c);
    paramMyParcel.a(this.d);
    paramMyParcel.a(this.f);
    paramMyParcel.a(this.e);
  }
  
  public void a(PathSegment paramPathSegment)
  {
    Path localPath = this.b;
    if (localPath != null)
    {
      localPath.addPath(paramPathSegment.b);
      this.e += paramPathSegment.e;
    }
  }
  
  public float b()
  {
    return this.c;
  }
  
  public void b(float paramFloat)
  {
    this.e = paramFloat;
  }
  
  public float c()
  {
    return this.e;
  }
  
  public void c(float paramFloat)
  {
    if (this.b == null) {
      return;
    }
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(paramFloat, paramFloat);
    Path localPath = new Path();
    localPath.addPath(this.b, localMatrix);
    this.b = localPath;
  }
  
  public long d()
  {
    return this.d;
  }
  
  public int e()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.PathDrawer.PathSegment
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.ar.arengine;

import com.tencent.qphone.base.util.QLog;

public class ARLocalGestureCircleRecogResult
  extends ARLocalRecogResultBase
{
  public long a = 0L;
  public ARLocalGestureCircleRecogResult.ARGestureResult b = new ARLocalGestureCircleRecogResult.ARGestureResult();
  public ARLocalGestureCircleRecogResult.ARCircleResult c = new ARLocalGestureCircleRecogResult.ARCircleResult();
  
  public ARLocalGestureCircleRecogResult()
  {
    a();
  }
  
  public void a()
  {
    QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "ARLocalGestureCircleRecogResult.reset");
    this.j = 4096L;
    this.a = 0L;
    this.b.a();
    this.c.a();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ARLocalGestureCircleRecogResult{recogType = ");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", frameIdx = ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", gestureResult = ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", circleResult = ");
    localStringBuilder.append(this.c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARLocalGestureCircleRecogResult
 * JD-Core Version:    0.7.0.1
 */
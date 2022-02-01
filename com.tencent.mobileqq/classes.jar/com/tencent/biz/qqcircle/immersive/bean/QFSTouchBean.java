package com.tencent.biz.qqcircle.immersive.bean;

import com.tencent.qphone.base.util.QLog;

public class QFSTouchBean
{
  private QFSTouchBean.TouchPoint a;
  private QFSTouchBean.TouchPoint b;
  private QFSTouchBean.TouchPoint c;
  
  public QFSTouchBean.TouchPoint a()
  {
    return this.a;
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    QFSTouchBean.TouchPoint localTouchPoint = this.a;
    if (localTouchPoint == null)
    {
      this.a = new QFSTouchBean.TouchPoint(paramFloat1, paramFloat2);
      return;
    }
    localTouchPoint.b(paramFloat1);
    this.a.b(paramFloat2);
  }
  
  public QFSTouchBean.TouchPoint b()
  {
    if (this.a == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QFSTouchBean", 1, "[getDeltaTouchPoint] down touch point not is null.");
      }
      return null;
    }
    QFSTouchBean.TouchPoint localTouchPoint = this.b;
    if (localTouchPoint == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QFSTouchBean", 1, "[getDeltaTouchPoint] move touch point not is null.");
      }
      return null;
    }
    float f2 = localTouchPoint.a();
    float f1 = this.b.b();
    f2 -= this.a.a();
    f1 -= this.a.b();
    localTouchPoint = this.c;
    if (localTouchPoint == null)
    {
      this.c = new QFSTouchBean.TouchPoint(f2, f1);
    }
    else
    {
      localTouchPoint.a(f2);
      this.c.b(f1);
    }
    return this.c;
  }
  
  public void b(float paramFloat1, float paramFloat2)
  {
    QFSTouchBean.TouchPoint localTouchPoint = this.b;
    if (localTouchPoint == null)
    {
      this.b = new QFSTouchBean.TouchPoint(paramFloat1, paramFloat2);
      return;
    }
    localTouchPoint.b(paramFloat1);
    this.b.b(paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.bean.QFSTouchBean
 * JD-Core Version:    0.7.0.1
 */
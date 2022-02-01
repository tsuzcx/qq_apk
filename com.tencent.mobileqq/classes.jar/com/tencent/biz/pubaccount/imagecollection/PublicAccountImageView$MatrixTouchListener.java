package com.tencent.biz.pubaccount.imagecollection;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView.ScaleType;
import com.tencent.qphone.base.util.QLog;

public class PublicAccountImageView$MatrixTouchListener
  implements View.OnTouchListener
{
  boolean a;
  boolean b;
  boolean c = false;
  private int e = 0;
  private float f;
  private Matrix g = new Matrix();
  private PointF h = new PointF();
  
  public PublicAccountImageView$MatrixTouchListener(PublicAccountImageView paramPublicAccountImageView) {}
  
  private float a(float[] paramArrayOfFloat, float paramFloat)
  {
    float f2 = this.d.getHeight();
    if (PublicAccountImageView.f(this.d) * paramArrayOfFloat[4] / this.d.g[4] < f2) {
      return 0.0F;
    }
    if (paramArrayOfFloat[5] + paramFloat > 0.0F) {
      return -paramArrayOfFloat[5];
    }
    float f1 = paramFloat;
    if (paramArrayOfFloat[5] + paramFloat < -(PublicAccountImageView.f(this.d) * paramArrayOfFloat[4] / this.d.g[4] - f2)) {
      f1 = -(PublicAccountImageView.f(this.d) * paramArrayOfFloat[4] / this.d.g[4] - f2) - paramArrayOfFloat[5];
    }
    return f1;
  }
  
  private void a()
  {
    if (PublicAccountImageView.c(this.d) != null) {
      PublicAccountImageView.c(this.d).a();
    }
  }
  
  private float b(float[] paramArrayOfFloat, float paramFloat)
  {
    float f2 = this.d.getWidth();
    if (PublicAccountImageView.d(this.d) * paramArrayOfFloat[0] / this.d.g[0] < f2) {
      return 0.0F;
    }
    if (paramArrayOfFloat[2] + paramFloat > 0.0F) {
      return -paramArrayOfFloat[2];
    }
    float f1 = paramFloat;
    if (paramArrayOfFloat[2] + paramFloat < -(PublicAccountImageView.d(this.d) * paramArrayOfFloat[0] / this.d.g[0] - f2)) {
      f1 = -(PublicAccountImageView.d(this.d) * paramArrayOfFloat[0] / this.d.g[0] - f2) - paramArrayOfFloat[2];
    }
    return f1;
  }
  
  private void b()
  {
    if (PublicAccountImageView.c(this.d) != null) {
      PublicAccountImageView.c(this.d).b();
    }
  }
  
  private void b(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getPointerCount() < 2) {
      return;
    }
    float f1 = c(paramMotionEvent);
    if (f1 > 10.0F)
    {
      float f2 = f1 / this.f;
      this.f = f1;
      paramMotionEvent = this.d;
      paramMotionEvent.e = false;
      paramMotionEvent.f = false;
      this.g.set(paramMotionEvent.getImageMatrix());
      paramMotionEvent = new float[9];
      this.g.getValues(paramMotionEvent);
      if (paramMotionEvent[0] > PublicAccountImageView.e(this.d) * this.d.c)
      {
        f1 = 1.0F;
        this.d.e = true;
      }
      else
      {
        f1 = f2;
        if (paramMotionEvent[0] < PublicAccountImageView.e(this.d))
        {
          this.d.f = true;
          f1 = f2;
        }
      }
      this.g.postScale(f1, f1, this.d.getWidth() / 2, this.d.getHeight() / 2);
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("the current scale is");
        localStringBuilder.append(f1);
        QLog.d("PublicAccountImageView", 2, localStringBuilder.toString());
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("scale of x is");
        localStringBuilder.append(paramMotionEvent[0]);
        QLog.d("PublicAccountImageView", 2, localStringBuilder.toString());
      }
      this.d.setImageMatrix(this.g);
    }
  }
  
  private float c(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX(1) - paramMotionEvent.getX(0);
    float f2 = paramMotionEvent.getY(1) - paramMotionEvent.getY(0);
    return (float)Math.sqrt(f1 * f1 + f2 * f2);
  }
  
  private void c()
  {
    this.a = true;
    this.b = true;
    this.c = true;
    float[] arrayOfFloat = new float[9];
    this.d.getImageMatrix().getValues(arrayOfFloat);
    if (arrayOfFloat[2] >= 0.0F) {
      this.b = false;
    }
    if (PublicAccountImageView.d(this.d) * arrayOfFloat[0] + arrayOfFloat[2] <= this.d.getWidth()) {
      this.a = false;
    }
  }
  
  private boolean d()
  {
    float[] arrayOfFloat = new float[9];
    this.d.getImageMatrix().getValues(arrayOfFloat);
    boolean bool = false;
    if (arrayOfFloat[0] != PublicAccountImageView.e(this.d)) {
      bool = true;
    }
    return bool;
  }
  
  private void e()
  {
    float f1 = this.d.d / this.d.c;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("back scale is");
      localStringBuilder.append(f1);
      QLog.d("PublicAccountImageView", 2, localStringBuilder.toString());
    }
    this.g.postScale(f1, f1, this.d.getWidth() / 2, this.d.getHeight() / 2);
    this.d.setImageMatrix(this.g);
  }
  
  private void f()
  {
    if (g())
    {
      this.g.set(PublicAccountImageView.a(this.d));
      this.d.setImageMatrix(this.g);
      this.d.setScaleType(ImageView.ScaleType.FIT_CENTER);
    }
  }
  
  private boolean g()
  {
    float[] arrayOfFloat = new float[9];
    this.d.getImageMatrix().getValues(arrayOfFloat);
    boolean bool = false;
    if (arrayOfFloat[0] < PublicAccountImageView.e(this.d)) {
      bool = true;
    }
    return bool;
  }
  
  private void h()
  {
    if (this.d.getScaleType() != ImageView.ScaleType.CENTER)
    {
      this.d.setScaleType(ImageView.ScaleType.MATRIX);
      return;
    }
    this.e = 3;
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    if (d())
    {
      float f1 = paramMotionEvent.getX() - this.h.x;
      float f2 = paramMotionEvent.getY() - this.h.y;
      if (Math.sqrt(f1 * f1 + f2 * f2) > 10.0D)
      {
        this.h.set(paramMotionEvent.getX(), paramMotionEvent.getY());
        this.g.set(this.d.getImageMatrix());
        paramMotionEvent = new float[9];
        this.g.getValues(paramMotionEvent);
        f2 = a(paramMotionEvent, f2);
        f1 = b(paramMotionEvent, f1);
        this.g.postTranslate(f1, f2);
        this.d.setImageMatrix(this.g);
      }
    }
    else
    {
      b();
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i == 5)
            {
              if (this.e == 3) {
                return true;
              }
              this.e = 2;
              this.f = c(paramMotionEvent);
            }
          }
          else {
            f();
          }
        }
        else
        {
          i = this.e;
          if (i == 2) {
            b(paramMotionEvent);
          } else if (i == 1) {
            a(paramMotionEvent);
          } else {
            b();
          }
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("PublicAccountImageView", 2, "the current state is action up");
        }
        if (this.d.e)
        {
          e();
          this.d.e = false;
        }
        else if (this.d.f)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountImageView", 2, "back to init matrix");
          }
          paramView = this.d;
          paramView.setImageMatrix(PublicAccountImageView.a(paramView));
          this.d.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
      }
    }
    else
    {
      this.e = 1;
      this.h.set(paramMotionEvent.getX(), paramMotionEvent.getY());
      h();
      a();
      c();
    }
    return PublicAccountImageView.b(this.d).onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.imagecollection.PublicAccountImageView.MatrixTouchListener
 * JD-Core Version:    0.7.0.1
 */
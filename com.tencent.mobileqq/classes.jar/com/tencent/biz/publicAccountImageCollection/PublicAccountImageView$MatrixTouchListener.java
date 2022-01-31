package com.tencent.biz.publicAccountImageCollection;

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
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private PointF jdField_a_of_type_AndroidGraphicsPointF = new PointF();
  boolean jdField_a_of_type_Boolean;
  boolean b;
  boolean c = false;
  
  public PublicAccountImageView$MatrixTouchListener(PublicAccountImageView paramPublicAccountImageView) {}
  
  private float a(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX(1) - paramMotionEvent.getX(0);
    float f2 = paramMotionEvent.getY(1) - paramMotionEvent.getY(0);
    return (float)Math.sqrt(f1 * f1 + f2 * f2);
  }
  
  private float a(float[] paramArrayOfFloat, float paramFloat)
  {
    float f2 = this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageView.getHeight();
    float f1;
    if (PublicAccountImageView.c(this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageView) * paramArrayOfFloat[4] / this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageView.jdField_a_of_type_ArrayOfFloat[4] < f2) {
      f1 = 0.0F;
    }
    do
    {
      return f1;
      if (paramArrayOfFloat[5] + paramFloat > 0.0F) {
        return -paramArrayOfFloat[5];
      }
      f1 = paramFloat;
    } while (paramArrayOfFloat[5] + paramFloat >= -(PublicAccountImageView.c(this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageView) * paramArrayOfFloat[4] / this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageView.jdField_a_of_type_ArrayOfFloat[4] - f2));
    return -(PublicAccountImageView.c(this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageView) * paramArrayOfFloat[4] / this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageView.jdField_a_of_type_ArrayOfFloat[4] - f2) - paramArrayOfFloat[5];
  }
  
  private void a()
  {
    if (PublicAccountImageView.a(this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageView) != null) {
      PublicAccountImageView.a(this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageView).a();
    }
  }
  
  private boolean a()
  {
    boolean bool = false;
    float[] arrayOfFloat = new float[9];
    this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageView.getImageMatrix().getValues(arrayOfFloat);
    if (arrayOfFloat[0] != PublicAccountImageView.b(this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageView)) {
      bool = true;
    }
    return bool;
  }
  
  private float b(float[] paramArrayOfFloat, float paramFloat)
  {
    float f2 = this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageView.getWidth();
    float f1;
    if (PublicAccountImageView.a(this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageView) * paramArrayOfFloat[0] / this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageView.jdField_a_of_type_ArrayOfFloat[0] < f2) {
      f1 = 0.0F;
    }
    do
    {
      return f1;
      if (paramArrayOfFloat[2] + paramFloat > 0.0F) {
        return -paramArrayOfFloat[2];
      }
      f1 = paramFloat;
    } while (paramArrayOfFloat[2] + paramFloat >= -(PublicAccountImageView.a(this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageView) * paramArrayOfFloat[0] / this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageView.jdField_a_of_type_ArrayOfFloat[0] - f2));
    return -(PublicAccountImageView.a(this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageView) * paramArrayOfFloat[0] / this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageView.jdField_a_of_type_ArrayOfFloat[0] - f2) - paramArrayOfFloat[2];
  }
  
  private void b()
  {
    if (PublicAccountImageView.a(this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageView) != null) {
      PublicAccountImageView.a(this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageView).b();
    }
  }
  
  private void b(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getPointerCount() < 2) {}
    float f1;
    do
    {
      return;
      f1 = a(paramMotionEvent);
    } while (f1 <= 10.0F);
    float f2 = f1 / this.jdField_a_of_type_Float;
    this.jdField_a_of_type_Float = f1;
    this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageView.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageView.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidGraphicsMatrix.set(this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageView.getImageMatrix());
    paramMotionEvent = new float[9];
    this.jdField_a_of_type_AndroidGraphicsMatrix.getValues(paramMotionEvent);
    if (paramMotionEvent[0] > PublicAccountImageView.b(this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageView) * this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageView.jdField_a_of_type_Float)
    {
      f1 = 1.0F;
      this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageView.jdField_a_of_type_Boolean = true;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidGraphicsMatrix.postScale(f1, f1, this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageView.getWidth() / 2, this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageView.getHeight() / 2);
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountImageView", 2, "the current scale is" + f1);
      }
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountImageView", 2, "scale of x is" + paramMotionEvent[0]);
      }
      this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageView.setImageMatrix(this.jdField_a_of_type_AndroidGraphicsMatrix);
      return;
      f1 = f2;
      if (paramMotionEvent[0] < PublicAccountImageView.b(this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageView))
      {
        this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageView.jdField_b_of_type_Boolean = true;
        f1 = f2;
      }
    }
  }
  
  private boolean b()
  {
    boolean bool = false;
    float[] arrayOfFloat = new float[9];
    this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageView.getImageMatrix().getValues(arrayOfFloat);
    if (arrayOfFloat[0] < PublicAccountImageView.b(this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageView)) {
      bool = true;
    }
    return bool;
  }
  
  private void c()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
    this.c = true;
    float[] arrayOfFloat = new float[9];
    this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageView.getImageMatrix().getValues(arrayOfFloat);
    if (arrayOfFloat[2] >= 0.0F) {
      this.jdField_b_of_type_Boolean = false;
    }
    float f1 = PublicAccountImageView.a(this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageView);
    float f2 = arrayOfFloat[0];
    if (arrayOfFloat[2] + f1 * f2 <= this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageView.getWidth()) {
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  private void d()
  {
    float f = this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageView.jdField_b_of_type_Float / this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageView.jdField_a_of_type_Float;
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountImageView", 2, "back scale is" + f);
    }
    this.jdField_a_of_type_AndroidGraphicsMatrix.postScale(f, f, this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageView.getWidth() / 2, this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageView.getHeight() / 2);
    this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageView.setImageMatrix(this.jdField_a_of_type_AndroidGraphicsMatrix);
  }
  
  private void e()
  {
    if (b())
    {
      this.jdField_a_of_type_AndroidGraphicsMatrix.set(PublicAccountImageView.a(this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageView));
      this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageView.setImageMatrix(this.jdField_a_of_type_AndroidGraphicsMatrix);
      this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageView.getScaleType() != ImageView.ScaleType.CENTER)
    {
      this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageView.setScaleType(ImageView.ScaleType.MATRIX);
      return;
    }
    this.jdField_a_of_type_Int = 3;
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    if (a())
    {
      float f1 = paramMotionEvent.getX() - this.jdField_a_of_type_AndroidGraphicsPointF.x;
      float f2 = paramMotionEvent.getY() - this.jdField_a_of_type_AndroidGraphicsPointF.y;
      if (Math.sqrt(f1 * f1 + f2 * f2) > 10.0D)
      {
        this.jdField_a_of_type_AndroidGraphicsPointF.set(paramMotionEvent.getX(), paramMotionEvent.getY());
        this.jdField_a_of_type_AndroidGraphicsMatrix.set(this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageView.getImageMatrix());
        paramMotionEvent = new float[9];
        this.jdField_a_of_type_AndroidGraphicsMatrix.getValues(paramMotionEvent);
        f2 = a(paramMotionEvent, f2);
        f1 = b(paramMotionEvent, f1);
        this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(f1, f2);
        this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageView.setImageMatrix(this.jdField_a_of_type_AndroidGraphicsMatrix);
      }
      return;
    }
    b();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      bool = PublicAccountImageView.a(this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageView).onTouchEvent(paramMotionEvent);
      do
      {
        return bool;
        this.jdField_a_of_type_Int = 1;
        this.jdField_a_of_type_AndroidGraphicsPointF.set(paramMotionEvent.getX(), paramMotionEvent.getY());
        f();
        a();
        c();
        break;
        if (QLog.isColorLevel()) {
          QLog.d("PublicAccountImageView", 2, "the current state is action up");
        }
        if (this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageView.jdField_a_of_type_Boolean)
        {
          d();
          this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageView.jdField_a_of_type_Boolean = false;
          break;
        }
        if (!this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageView.jdField_b_of_type_Boolean) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("PublicAccountImageView", 2, "back to init matrix");
        }
        this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageView.setImageMatrix(PublicAccountImageView.a(this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageView));
        this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        break;
        e();
        break;
        if (this.jdField_a_of_type_Int == 2)
        {
          b(paramMotionEvent);
          break;
        }
        if (this.jdField_a_of_type_Int == 1)
        {
          a(paramMotionEvent);
          break;
        }
        b();
        break;
      } while (this.jdField_a_of_type_Int == 3);
      this.jdField_a_of_type_Int = 2;
      this.jdField_a_of_type_Float = a(paramMotionEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.publicAccountImageCollection.PublicAccountImageView.MatrixTouchListener
 * JD-Core Version:    0.7.0.1
 */
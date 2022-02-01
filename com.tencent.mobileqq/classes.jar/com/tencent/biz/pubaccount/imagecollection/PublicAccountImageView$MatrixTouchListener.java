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
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = 0;
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
    float f2 = this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageView.getHeight();
    if (PublicAccountImageView.c(this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageView) * paramArrayOfFloat[4] / this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageView.jdField_a_of_type_ArrayOfFloat[4] < f2) {
      return 0.0F;
    }
    if (paramArrayOfFloat[5] + paramFloat > 0.0F) {
      return -paramArrayOfFloat[5];
    }
    float f1 = paramFloat;
    if (paramArrayOfFloat[5] + paramFloat < -(PublicAccountImageView.c(this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageView) * paramArrayOfFloat[4] / this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageView.jdField_a_of_type_ArrayOfFloat[4] - f2)) {
      f1 = -(PublicAccountImageView.c(this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageView) * paramArrayOfFloat[4] / this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageView.jdField_a_of_type_ArrayOfFloat[4] - f2) - paramArrayOfFloat[5];
    }
    return f1;
  }
  
  private void a()
  {
    if (PublicAccountImageView.a(this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageView) != null) {
      PublicAccountImageView.a(this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageView).a();
    }
  }
  
  private boolean a()
  {
    float[] arrayOfFloat = new float[9];
    this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageView.getImageMatrix().getValues(arrayOfFloat);
    boolean bool = false;
    if (arrayOfFloat[0] != PublicAccountImageView.b(this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageView)) {
      bool = true;
    }
    return bool;
  }
  
  private float b(float[] paramArrayOfFloat, float paramFloat)
  {
    float f2 = this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageView.getWidth();
    if (PublicAccountImageView.a(this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageView) * paramArrayOfFloat[0] / this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageView.jdField_a_of_type_ArrayOfFloat[0] < f2) {
      return 0.0F;
    }
    if (paramArrayOfFloat[2] + paramFloat > 0.0F) {
      return -paramArrayOfFloat[2];
    }
    float f1 = paramFloat;
    if (paramArrayOfFloat[2] + paramFloat < -(PublicAccountImageView.a(this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageView) * paramArrayOfFloat[0] / this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageView.jdField_a_of_type_ArrayOfFloat[0] - f2)) {
      f1 = -(PublicAccountImageView.a(this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageView) * paramArrayOfFloat[0] / this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageView.jdField_a_of_type_ArrayOfFloat[0] - f2) - paramArrayOfFloat[2];
    }
    return f1;
  }
  
  private void b()
  {
    if (PublicAccountImageView.a(this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageView) != null) {
      PublicAccountImageView.a(this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageView).b();
    }
  }
  
  private void b(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getPointerCount() < 2) {
      return;
    }
    float f1 = a(paramMotionEvent);
    if (f1 > 10.0F)
    {
      float f2 = f1 / this.jdField_a_of_type_Float;
      this.jdField_a_of_type_Float = f1;
      paramMotionEvent = this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageView;
      paramMotionEvent.jdField_a_of_type_Boolean = false;
      paramMotionEvent.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidGraphicsMatrix.set(paramMotionEvent.getImageMatrix());
      paramMotionEvent = new float[9];
      this.jdField_a_of_type_AndroidGraphicsMatrix.getValues(paramMotionEvent);
      if (paramMotionEvent[0] > PublicAccountImageView.b(this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageView) * this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageView.jdField_a_of_type_Float)
      {
        f1 = 1.0F;
        this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageView.jdField_a_of_type_Boolean = true;
      }
      else
      {
        f1 = f2;
        if (paramMotionEvent[0] < PublicAccountImageView.b(this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageView))
        {
          this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageView.jdField_b_of_type_Boolean = true;
          f1 = f2;
        }
      }
      this.jdField_a_of_type_AndroidGraphicsMatrix.postScale(f1, f1, this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageView.getWidth() / 2, this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageView.getHeight() / 2);
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
      this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageView.setImageMatrix(this.jdField_a_of_type_AndroidGraphicsMatrix);
    }
  }
  
  private boolean b()
  {
    float[] arrayOfFloat = new float[9];
    this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageView.getImageMatrix().getValues(arrayOfFloat);
    boolean bool = false;
    if (arrayOfFloat[0] < PublicAccountImageView.b(this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageView)) {
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
    this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageView.getImageMatrix().getValues(arrayOfFloat);
    if (arrayOfFloat[2] >= 0.0F) {
      this.jdField_b_of_type_Boolean = false;
    }
    if (PublicAccountImageView.a(this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageView) * arrayOfFloat[0] + arrayOfFloat[2] <= this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageView.getWidth()) {
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  private void d()
  {
    float f = this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageView.jdField_b_of_type_Float / this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageView.jdField_a_of_type_Float;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("back scale is");
      localStringBuilder.append(f);
      QLog.d("PublicAccountImageView", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_AndroidGraphicsMatrix.postScale(f, f, this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageView.getWidth() / 2, this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageView.getHeight() / 2);
    this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageView.setImageMatrix(this.jdField_a_of_type_AndroidGraphicsMatrix);
  }
  
  private void e()
  {
    if (b())
    {
      this.jdField_a_of_type_AndroidGraphicsMatrix.set(PublicAccountImageView.a(this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageView));
      this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageView.setImageMatrix(this.jdField_a_of_type_AndroidGraphicsMatrix);
      this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageView.getScaleType() != ImageView.ScaleType.CENTER)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageView.setScaleType(ImageView.ScaleType.MATRIX);
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
        this.jdField_a_of_type_AndroidGraphicsMatrix.set(this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageView.getImageMatrix());
        paramMotionEvent = new float[9];
        this.jdField_a_of_type_AndroidGraphicsMatrix.getValues(paramMotionEvent);
        f2 = a(paramMotionEvent, f2);
        f1 = b(paramMotionEvent, f1);
        this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(f1, f2);
        this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageView.setImageMatrix(this.jdField_a_of_type_AndroidGraphicsMatrix);
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
              if (this.jdField_a_of_type_Int == 3) {
                return true;
              }
              this.jdField_a_of_type_Int = 2;
              this.jdField_a_of_type_Float = a(paramMotionEvent);
            }
          }
          else {
            e();
          }
        }
        else
        {
          i = this.jdField_a_of_type_Int;
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
        if (this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageView.jdField_a_of_type_Boolean)
        {
          d();
          this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageView.jdField_a_of_type_Boolean = false;
        }
        else if (this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageView.jdField_b_of_type_Boolean)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountImageView", 2, "back to init matrix");
          }
          paramView = this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageView;
          paramView.setImageMatrix(PublicAccountImageView.a(paramView));
          this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
      }
    }
    else
    {
      this.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_AndroidGraphicsPointF.set(paramMotionEvent.getX(), paramMotionEvent.getY());
      f();
      a();
      c();
    }
    return PublicAccountImageView.a(this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageView).onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.imagecollection.PublicAccountImageView.MatrixTouchListener
 * JD-Core Version:    0.7.0.1
 */
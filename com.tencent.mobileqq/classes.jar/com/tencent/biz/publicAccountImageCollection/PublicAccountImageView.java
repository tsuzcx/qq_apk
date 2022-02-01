package com.tencent.biz.publicAccountImageCollection;

import android.content.Context;
import android.graphics.Matrix;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.widget.ImageView.ScaleType;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;
import uww;
import uwx;
import uwy;

public class PublicAccountImageView
  extends URLImageView
{
  public float a;
  Context jdField_a_of_type_AndroidContentContext;
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  Handler jdField_a_of_type_AndroidOsHandler;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private uwy jdField_a_of_type_Uwy;
  public boolean a;
  public float[] a;
  public float b;
  public boolean b;
  private float c;
  private float d;
  private float e;
  
  public PublicAccountImageView(Context paramContext, Handler paramHandler, Matrix paramMatrix, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramContext, null);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ArrayOfFloat = new float[9];
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    paramContext = new uwx(this);
    setOnTouchListener(paramContext);
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(getContext(), new uww(this, paramContext));
    setBackgroundColor(-16777216);
    if (paramInt1 == 1) {
      setScaleType(ImageView.ScaleType.FIT_CENTER);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidGraphicsMatrix.set(paramMatrix);
      this.jdField_a_of_type_AndroidGraphicsMatrix.getValues(this.jdField_a_of_type_ArrayOfFloat);
      this.jdField_a_of_type_AndroidOsHandler = paramHandler;
      this.d = paramInt3;
      this.c = paramInt2;
      a();
      return;
      setScaleType(ImageView.ScaleType.MATRIX);
    }
  }
  
  public PublicAccountImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ArrayOfFloat = new float[9];
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    paramContext = new uwx(this);
    setOnTouchListener(paramContext);
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(getContext(), new uww(this, paramContext));
    setBackgroundColor(-16777216);
    setScaleType(ImageView.ScaleType.MATRIX);
    a();
  }
  
  private void a()
  {
    float[] arrayOfFloat = new float[9];
    this.jdField_a_of_type_AndroidGraphicsMatrix.getValues(arrayOfFloat);
    if (QLog.isColorLevel())
    {
      QLog.d("PublicAccountImageView", 2, "image height is" + this.d);
      QLog.d("PublicAccountImageView", 2, "image width is" + this.c);
    }
    this.e = arrayOfFloat[0];
    this.jdField_a_of_type_Float = 5.5F;
    this.jdField_b_of_type_Float = 5.0F;
  }
  
  private void b()
  {
    if (PublicAccountImageCollectionMainActivity.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.publicAccountImageCollection.PublicAccountImageView
 * JD-Core Version:    0.7.0.1
 */
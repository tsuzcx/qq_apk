package com.tencent.biz.pubaccount.imagecollection;

import android.content.Context;
import android.graphics.Matrix;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.widget.ImageView.ScaleType;
import com.tencent.biz.pubaccount.imagecollection.api.impl.PublicAccountImageCollectionMainActivityImpl;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;

public class PublicAccountImageView
  extends URLImageView
{
  float jdField_a_of_type_Float;
  Context jdField_a_of_type_AndroidContentContext;
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  Handler jdField_a_of_type_AndroidOsHandler;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private PublicAccountImageView.OnMovingListener jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageView$OnMovingListener;
  boolean jdField_a_of_type_Boolean = false;
  float[] jdField_a_of_type_ArrayOfFloat = new float[9];
  float jdField_b_of_type_Float;
  boolean jdField_b_of_type_Boolean = false;
  private float c;
  private float d;
  private float e;
  
  public PublicAccountImageView(Context paramContext, Handler paramHandler, Matrix paramMatrix, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramContext, null);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    paramContext = new PublicAccountImageView.MatrixTouchListener(this);
    setOnTouchListener(paramContext);
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(getContext(), new PublicAccountImageView.GestureListener(this, paramContext));
    setBackgroundColor(-16777216);
    if (paramInt1 == 1) {
      setScaleType(ImageView.ScaleType.FIT_CENTER);
    } else {
      setScaleType(ImageView.ScaleType.MATRIX);
    }
    this.jdField_a_of_type_AndroidGraphicsMatrix.set(paramMatrix);
    this.jdField_a_of_type_AndroidGraphicsMatrix.getValues(this.jdField_a_of_type_ArrayOfFloat);
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.d = paramInt3;
    this.c = paramInt2;
    a();
  }
  
  public PublicAccountImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    paramContext = new PublicAccountImageView.MatrixTouchListener(this);
    setOnTouchListener(paramContext);
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(getContext(), new PublicAccountImageView.GestureListener(this, paramContext));
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("image height is");
      localStringBuilder.append(this.d);
      QLog.d("PublicAccountImageView", 2, localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("image width is");
      localStringBuilder.append(this.c);
      QLog.d("PublicAccountImageView", 2, localStringBuilder.toString());
    }
    this.e = arrayOfFloat[0];
    this.jdField_a_of_type_Float = 5.5F;
    this.jdField_b_of_type_Float = 5.0F;
  }
  
  private void b()
  {
    if (PublicAccountImageCollectionMainActivityImpl.doubleTapFlag)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.imagecollection.PublicAccountImageView
 * JD-Core Version:    0.7.0.1
 */
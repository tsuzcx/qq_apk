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
  Context a;
  Handler b;
  float c;
  float d;
  boolean e = false;
  boolean f = false;
  float[] g = new float[9];
  private GestureDetector h;
  private Matrix i = new Matrix();
  private float j;
  private float k;
  private float l;
  private PublicAccountImageView.OnMovingListener m;
  
  public PublicAccountImageView(Context paramContext, Handler paramHandler, Matrix paramMatrix, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramContext, null);
    this.a = paramContext;
    paramContext = new PublicAccountImageView.MatrixTouchListener(this);
    setOnTouchListener(paramContext);
    this.h = new GestureDetector(getContext(), new PublicAccountImageView.GestureListener(this, paramContext));
    setBackgroundColor(-16777216);
    if (paramInt1 == 1) {
      setScaleType(ImageView.ScaleType.FIT_CENTER);
    } else {
      setScaleType(ImageView.ScaleType.MATRIX);
    }
    this.i.set(paramMatrix);
    this.i.getValues(this.g);
    this.b = paramHandler;
    this.k = paramInt3;
    this.j = paramInt2;
    a();
  }
  
  public PublicAccountImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
    paramContext = new PublicAccountImageView.MatrixTouchListener(this);
    setOnTouchListener(paramContext);
    this.h = new GestureDetector(getContext(), new PublicAccountImageView.GestureListener(this, paramContext));
    setBackgroundColor(-16777216);
    setScaleType(ImageView.ScaleType.MATRIX);
    a();
  }
  
  private void a()
  {
    float[] arrayOfFloat = new float[9];
    this.i.getValues(arrayOfFloat);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("image height is");
      localStringBuilder.append(this.k);
      QLog.d("PublicAccountImageView", 2, localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("image width is");
      localStringBuilder.append(this.j);
      QLog.d("PublicAccountImageView", 2, localStringBuilder.toString());
    }
    this.l = arrayOfFloat[0];
    this.c = 5.5F;
    this.d = 5.0F;
  }
  
  private void b()
  {
    if (PublicAccountImageCollectionMainActivityImpl.doubleTapFlag)
    {
      this.b.sendEmptyMessage(2);
      return;
    }
    this.b.sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.imagecollection.PublicAccountImageView
 * JD-Core Version:    0.7.0.1
 */
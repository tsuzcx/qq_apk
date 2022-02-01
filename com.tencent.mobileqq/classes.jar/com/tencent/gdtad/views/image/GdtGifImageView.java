package com.tencent.gdtad.views.image;

import acho;
import acju;
import acjw;
import acjx;
import acjy;
import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import java.lang.ref.WeakReference;

public class GdtGifImageView
  extends URLImageView
{
  acjw jdField_a_of_type_Acjw;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<acjy> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  acjw jdField_b_of_type_Acjw;
  private String jdField_b_of_type_JavaLangString;
  private volatile boolean jdField_b_of_type_Boolean;
  private volatile boolean c;
  
  public GdtGifImageView(Context paramContext, String paramString1, String paramString2, WeakReference<acjy> paramWeakReference, boolean paramBoolean)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.c = paramBoolean;
    if (!TextUtils.isEmpty(paramString2))
    {
      this.jdField_a_of_type_Acjw = new acjx(this);
      new acju(paramString2, new WeakReference(this.jdField_a_of_type_Acjw)).a();
    }
    if (!paramBoolean)
    {
      this.jdField_b_of_type_Acjw = new acjx(this);
      paramContext = new acju(paramString1, new WeakReference(this.jdField_b_of_type_Acjw));
      paramContext.a();
      setImageDrawable(paramContext.a());
    }
    URLDrawable.resume();
    AbstractGifImage.resumeAll();
  }
  
  private void a(URLDrawable paramURLDrawable, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (paramString.equals(this.jdField_a_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_Boolean = true;
      setImageDrawable(paramURLDrawable);
    }
    while ((TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) || (!paramString.equals(this.jdField_b_of_type_JavaLangString)) || (this.jdField_a_of_type_Boolean)) {
      return;
    }
    setImageDrawable(paramURLDrawable);
  }
  
  public void a(String paramString, WeakReference<acjy> paramWeakReference)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
    paramWeakReference = new acju(paramString, new WeakReference(this.jdField_b_of_type_Acjw));
    paramWeakReference.a();
    setImageDrawable(paramWeakReference.a());
    this.jdField_b_of_type_Boolean = true;
    acho.a("GdtImageView", "GdtGifImageView update completed " + paramString);
    URLDrawable.resume();
    AbstractGifImage.resumeAll();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.views.image.GdtGifImageView
 * JD-Core Version:    0.7.0.1
 */
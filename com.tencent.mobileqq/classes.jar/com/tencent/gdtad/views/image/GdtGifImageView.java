package com.tencent.gdtad.views.image;

import aapv;
import aapx;
import aapy;
import aapz;
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
  aapx jdField_a_of_type_Aapx;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<aapz> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  aapx jdField_b_of_type_Aapx;
  private String jdField_b_of_type_JavaLangString;
  
  public GdtGifImageView(Context paramContext, String paramString1, String paramString2, WeakReference<aapz> paramWeakReference)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    if (!TextUtils.isEmpty(paramString2))
    {
      this.jdField_a_of_type_Aapx = new aapy(this);
      new aapv(paramString2, new WeakReference(this.jdField_a_of_type_Aapx)).a();
    }
    this.jdField_b_of_type_Aapx = new aapy(this);
    paramContext = new aapv(paramString1, new WeakReference(this.jdField_b_of_type_Aapx));
    paramContext.a();
    setImageDrawable(paramContext.a());
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
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.gdtad.views.image.GdtGifImageView
 * JD-Core Version:    0.7.0.1
 */
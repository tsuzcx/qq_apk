package com.tencent.gdtad.views.image;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import java.lang.ref.WeakReference;
import zax;
import zaz;
import zba;
import zbb;

public class GdtGifImageView
  extends URLImageView
{
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<zbb> jdField_a_of_type_JavaLangRefWeakReference;
  zaz jdField_a_of_type_Zaz;
  private boolean jdField_a_of_type_Boolean;
  private String jdField_b_of_type_JavaLangString;
  zaz jdField_b_of_type_Zaz;
  
  public GdtGifImageView(Context paramContext, String paramString1, String paramString2, WeakReference<zbb> paramWeakReference)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    if (!TextUtils.isEmpty(paramString2))
    {
      this.jdField_a_of_type_Zaz = new zba(this);
      new zax(paramString2, new WeakReference(this.jdField_a_of_type_Zaz)).a();
    }
    this.jdField_b_of_type_Zaz = new zba(this);
    paramContext = new zax(paramString1, new WeakReference(this.jdField_b_of_type_Zaz));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.views.image.GdtGifImageView
 * JD-Core Version:    0.7.0.1
 */
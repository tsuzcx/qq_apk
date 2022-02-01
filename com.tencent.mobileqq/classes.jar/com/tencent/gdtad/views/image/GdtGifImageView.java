package com.tencent.gdtad.views.image;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import java.lang.ref.WeakReference;

public class GdtGifImageView
  extends URLImageView
{
  GdtDrawableLoader.Listener jdField_a_of_type_ComTencentGdtadViewsImageGdtDrawableLoader$Listener;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<GdtGifImageView.LoadListener> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  GdtDrawableLoader.Listener jdField_b_of_type_ComTencentGdtadViewsImageGdtDrawableLoader$Listener;
  private String jdField_b_of_type_JavaLangString;
  private volatile boolean jdField_b_of_type_Boolean;
  private volatile boolean c;
  
  public GdtGifImageView(Context paramContext, String paramString1, String paramString2, WeakReference<GdtGifImageView.LoadListener> paramWeakReference, boolean paramBoolean)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.c = paramBoolean;
    if (!TextUtils.isEmpty(paramString2))
    {
      this.jdField_a_of_type_ComTencentGdtadViewsImageGdtDrawableLoader$Listener = new GdtGifImageView.ImageLoadListener(this);
      new GdtDrawableLoader(paramString2, new WeakReference(this.jdField_a_of_type_ComTencentGdtadViewsImageGdtDrawableLoader$Listener)).a();
    }
    if (!paramBoolean)
    {
      this.jdField_b_of_type_ComTencentGdtadViewsImageGdtDrawableLoader$Listener = new GdtGifImageView.ImageLoadListener(this);
      paramContext = new GdtDrawableLoader(paramString1, new WeakReference(this.jdField_b_of_type_ComTencentGdtadViewsImageGdtDrawableLoader$Listener));
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
      return;
    }
    if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (paramString.equals(this.jdField_b_of_type_JavaLangString)) && (!this.jdField_a_of_type_Boolean)) {
      setImageDrawable(paramURLDrawable);
    }
  }
  
  public void a(String paramString, WeakReference<GdtGifImageView.LoadListener> paramWeakReference)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
    paramWeakReference = new GdtDrawableLoader(paramString, new WeakReference(this.jdField_b_of_type_ComTencentGdtadViewsImageGdtDrawableLoader$Listener));
    paramWeakReference.a();
    setImageDrawable(paramWeakReference.a());
    this.jdField_b_of_type_Boolean = true;
    paramWeakReference = new StringBuilder();
    paramWeakReference.append("GdtGifImageView update completed ");
    paramWeakReference.append(paramString);
    GdtLog.a("GdtImageView", paramWeakReference.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.views.image.GdtGifImageView
 * JD-Core Version:    0.7.0.1
 */
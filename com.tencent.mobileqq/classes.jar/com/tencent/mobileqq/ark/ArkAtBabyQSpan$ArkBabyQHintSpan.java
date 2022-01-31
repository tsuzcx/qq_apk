package com.tencent.mobileqq.ark;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.DynamicDrawableSpan;
import android.widget.EditText;

public class ArkAtBabyQSpan$ArkBabyQHintSpan
  extends DynamicDrawableSpan
{
  private int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private String jdField_a_of_type_JavaLangString = "";
  
  private ArkAtBabyQSpan$ArkBabyQHintSpan(Context paramContext, String paramString, Paint paramPaint)
  {
    super(0);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a(paramPaint);
  }
  
  public static SpannableString a(Context paramContext, String paramString, EditText paramEditText)
  {
    if ((paramContext == null) || (paramEditText == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    Object localObject = paramEditText.getEditableText();
    localObject = (ArkBabyQHintSpan[])((Editable)localObject).getSpans(0, localObject.toString().length(), ArkBabyQHintSpan.class);
    if ((localObject != null) && (localObject.length > 0)) {
      return null;
    }
    try
    {
      paramContext = a(paramContext, paramString, paramEditText.getPaint());
      if (paramContext == null) {
        return null;
      }
    }
    catch (OutOfMemoryError paramContext)
    {
      for (;;)
      {
        paramContext = null;
      }
      paramString = paramContext.jdField_a_of_type_JavaLangString;
      paramEditText = new SpannableString(paramString);
      paramEditText.setSpan(paramContext, 0, paramString.length(), 17);
    }
    return paramEditText;
  }
  
  private static ArkBabyQHintSpan a(Context paramContext, String paramString, Paint paramPaint)
  {
    if ((paramContext == null) || (paramPaint == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    return new ArkBabyQHintSpan(paramContext, paramString, paramPaint);
  }
  
  private void a(Paint paramPaint)
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      return;
    }
    b(paramPaint);
    Object localObject = paramPaint.getFontMetrics();
    float f = -((Paint.FontMetrics)localObject).top;
    int i = (int)Math.ceil(((Paint.FontMetrics)localObject).bottom - ((Paint.FontMetrics)localObject).top);
    localObject = Bitmap.createBitmap(this.jdField_a_of_type_Int, i, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas((Bitmap)localObject);
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    i = paramPaint.getColor();
    paramPaint.setColor(localResources.getColor(2131492893));
    localCanvas.drawText(this.jdField_a_of_type_JavaLangString, 0.0F, f, paramPaint);
    paramPaint.setColor(i);
    localCanvas.save(31);
    localCanvas.restore();
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(localResources, (Bitmap)localObject);
    i = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight();
    paramPaint = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    int j = this.jdField_a_of_type_Int;
    if (i > 0) {}
    for (;;)
    {
      paramPaint.setBounds(0, 0, j, i);
      return;
      i = 0;
    }
  }
  
  private void b(Paint paramPaint)
  {
    if (this.jdField_a_of_type_Int != -1) {
      return;
    }
    this.jdField_a_of_type_Int = ((int)Math.ceil(paramPaint.measureText(this.jdField_a_of_type_JavaLangString)));
  }
  
  public Drawable getDrawable()
  {
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAtBabyQSpan.ArkBabyQHintSpan
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.ark;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.SpannableString;
import android.text.style.DynamicDrawableSpan;
import android.widget.EditText;

public class ArkAtBabyQSpan
  extends DynamicDrawableSpan
{
  private int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private String jdField_a_of_type_JavaLangString = "";
  
  private ArkAtBabyQSpan(Context paramContext, Paint paramPaint)
  {
    super(0);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a(paramPaint);
  }
  
  public static SpannableString a(Context paramContext, EditText paramEditText)
  {
    if ((paramContext == null) || (paramEditText == null)) {
      return null;
    }
    Object localObject = paramEditText.getEditableText();
    localObject = (ArkAtBabyQSpan[])((Editable)localObject).getSpans(0, localObject.toString().length(), ArkAtBabyQSpan.class);
    if ((localObject != null) && (localObject.length > 0)) {
      return null;
    }
    try
    {
      paramContext = a(paramContext, paramEditText.getPaint());
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
      paramEditText = new SpannableString("@babyQ");
      paramEditText.setSpan(paramContext, 0, "@babyQ".length(), 17);
    }
    return paramEditText;
  }
  
  private static ArkAtBabyQSpan a(Context paramContext, Paint paramPaint)
  {
    if (paramContext == null) {
      return null;
    }
    return new ArkAtBabyQSpan(paramContext, paramPaint);
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
    localObject = new RectF(0.0F, ((Paint.FontMetrics)localObject).ascent - ((Paint.FontMetrics)localObject).top, this.jdField_a_of_type_Int - 2, ((Paint.FontMetrics)localObject).descent + f);
    Bitmap localBitmap = Bitmap.createBitmap(this.jdField_a_of_type_Int, i, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    int j = paramPaint.getColor();
    paramPaint.setColor(localResources.getColor(2131493051));
    localCanvas.drawRoundRect((RectF)localObject, i / 2, i / 2, paramPaint);
    paramPaint.setColor(localResources.getColor(2131493355));
    localCanvas.drawText(this.jdField_a_of_type_JavaLangString, 0.0F, f, paramPaint);
    paramPaint.setColor(j);
    localCanvas.save(31);
    localCanvas.restore();
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(localResources, localBitmap);
    i = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight();
    paramPaint = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    j = this.jdField_a_of_type_Int;
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
    this.jdField_a_of_type_Int = ((int)Math.ceil(paramPaint.measureText("  ") * 2.0F + paramPaint.measureText("@babyQ")));
    this.jdField_a_of_type_JavaLangString = String.format("%s%s%s", new Object[] { "  ", "@babyQ", "  " });
  }
  
  public Drawable getDrawable()
  {
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAtBabyQSpan
 * JD-Core Version:    0.7.0.1
 */
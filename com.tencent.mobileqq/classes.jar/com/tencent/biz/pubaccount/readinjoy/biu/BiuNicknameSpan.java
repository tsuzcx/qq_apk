package com.tencent.biz.pubaccount.readinjoy.biu;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.style.DynamicDrawableSpan;
import android.util.SparseIntArray;
import com.tencent.mobileqq.text.EmotcationConstants;

public class BiuNicknameSpan
  extends DynamicDrawableSpan
{
  private int jdField_a_of_type_Int = -1;
  public long a;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  public String a;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  
  public BiuNicknameSpan(String paramString, long paramLong, CharSequence paramCharSequence, Context paramContext, Paint paramPaint, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_b_of_type_JavaLangString = a(paramCharSequence);
    this.jdField_b_of_type_Int = paramInt;
    a(paramContext, paramPaint);
  }
  
  public static String a(CharSequence paramCharSequence)
  {
    paramCharSequence = new StringBuffer(paramCharSequence);
    int i = 0;
    if (i < paramCharSequence.length())
    {
      int k = paramCharSequence.codePointAt(i);
      int j;
      if ((k == 20) && (i < paramCharSequence.length() - 1))
      {
        paramCharSequence.delete(i, i + 2);
        j = i - 1;
      }
      do
      {
        i = j + 1;
        break;
        j = i;
      } while (EmotcationConstants.a.get(k, -1) < 0);
      if ((k > 65535) && (paramCharSequence.length() >= i + 2)) {
        paramCharSequence.delete(i, i + 2);
      }
      for (;;)
      {
        j = i - 1;
        break;
        paramCharSequence.delete(i, i + 1);
      }
    }
    return paramCharSequence.toString();
  }
  
  private void a(Context paramContext, Paint paramPaint)
  {
    a(paramPaint);
    Object localObject = paramPaint.getFontMetrics();
    float f = -((Paint.FontMetrics)localObject).top;
    int i = (int)Math.ceil(((Paint.FontMetrics)localObject).bottom - ((Paint.FontMetrics)localObject).top);
    new RectF(0.0F, ((Paint.FontMetrics)localObject).ascent - ((Paint.FontMetrics)localObject).top, this.jdField_a_of_type_Int - 2, ((Paint.FontMetrics)localObject).descent + f);
    localObject = Bitmap.createBitmap(this.jdField_a_of_type_Int, i, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas((Bitmap)localObject);
    paramPaint.setColor(-14132075);
    localCanvas.drawText(this.jdField_b_of_type_JavaLangString, 0.0F, f, paramPaint);
    localCanvas.save(31);
    localCanvas.restore();
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(paramContext.getResources(), (Bitmap)localObject);
    i = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight();
    paramContext = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    int j = this.jdField_a_of_type_Int;
    if (i > 0) {}
    for (;;)
    {
      paramContext.setBounds(0, 0, j, i);
      return;
      i = 0;
    }
  }
  
  private void a(Paint paramPaint)
  {
    if (this.jdField_a_of_type_Int != -1) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_Int = ((int)Math.ceil(paramPaint.measureText(this.jdField_b_of_type_JavaLangString)));
      if (this.jdField_a_of_type_Int > this.jdField_b_of_type_Int)
      {
        int i = this.jdField_b_of_type_JavaLangString.length() - 1;
        float f = paramPaint.measureText("...");
        while (i > 0)
        {
          this.jdField_a_of_type_Int = ((int)Math.ceil(paramPaint.measureText(this.jdField_b_of_type_JavaLangString, 0, i) + f));
          if (this.jdField_a_of_type_Int <= this.jdField_b_of_type_Int)
          {
            this.jdField_b_of_type_JavaLangString = String.format("%s%s", new Object[] { this.jdField_b_of_type_JavaLangString.substring(0, i), "..." });
            return;
          }
          i -= 1;
        }
      }
    }
  }
  
  public Drawable getDrawable()
  {
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.biu.BiuNicknameSpan
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.aelight.camera.ae.gif.giftext;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.aelight.camera.ae.font.AEFontManager;

public class AEGIFOutlineTextView
  extends View
{
  private float jdField_a_of_type_Float = 0.0F;
  private int jdField_a_of_type_Int = 0;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Canvas jdField_a_of_type_AndroidGraphicsCanvas;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private TextPaint jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float = 0.0F;
  private TextPaint jdField_b_of_type_AndroidTextTextPaint = new TextPaint();
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = true;
  private float jdField_c_of_type_Float = 0.0F;
  private String jdField_c_of_type_JavaLangString = "#00FFFFFF";
  
  public AEGIFOutlineTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public AEGIFOutlineTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AEGIFOutlineTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a()
  {
    Typeface localTypeface = AEFontManager.a().a(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(localTypeface);
    this.jdField_b_of_type_AndroidTextTextPaint.setTypeface(localTypeface);
  }
  
  private void a(Canvas paramCanvas, String paramString, float paramFloat1, float paramFloat2, Paint paramPaint)
  {
    paramCanvas.drawText(paramString, paramFloat1, paramFloat2, paramPaint);
  }
  
  private void a(String paramString, Paint paramPaint, int paramInt1, int paramInt2, int paramInt3)
  {
    Rect localRect = new Rect();
    paramPaint.getTextBounds(paramString, 0, paramString.length(), localRect);
    for (;;)
    {
      if ((localRect.width() + paramInt3 <= paramInt1 * 1.0F) && (localRect.height() + paramInt3 <= paramInt2 * 1.0F)) {
        return;
      }
      paramPaint.setTextSize(paramPaint.getTextSize() - 2.0F);
      paramPaint.getTextBounds(paramString, 0, paramString.length(), localRect);
    }
  }
  
  public float a()
  {
    return this.jdField_a_of_type_AndroidTextTextPaint.getTextSize();
  }
  
  public Bitmap a()
  {
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public float b()
  {
    return this.jdField_a_of_type_AndroidTextTextPaint.getStrokeWidth();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    a();
    this.jdField_b_of_type_AndroidTextTextPaint.setTextSize(this.jdField_a_of_type_AndroidTextTextPaint.getTextSize());
    this.jdField_b_of_type_AndroidTextTextPaint.setStyle(Paint.Style.STROKE);
    this.jdField_b_of_type_AndroidTextTextPaint.setStrokeWidth(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidTextTextPaint.setAntiAlias(true);
    Object localObject = this.jdField_a_of_type_AndroidTextTextPaint;
    String str = this.jdField_a_of_type_JavaLangString;
    ((TextPaint)localObject).getTextBounds(str, 0, str.length(), this.jdField_a_of_type_AndroidGraphicsRect);
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_AndroidTextTextPaint.setShadowLayer(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.jdField_c_of_type_Float, Color.parseColor(this.jdField_c_of_type_JavaLangString));
    } else {
      this.jdField_a_of_type_AndroidTextTextPaint.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    }
    float f1 = this.jdField_a_of_type_AndroidGraphicsRect.height();
    int i = this.jdField_a_of_type_JavaLangString.indexOf("\r\n");
    float f2;
    if (i < 0)
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        return;
      }
      a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_AndroidTextTextPaint, getWidth(), getHeight(), this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_b_of_type_AndroidTextTextPaint.getTextSize());
      f2 = f1 / 2.0F + (Math.abs(this.jdField_a_of_type_AndroidTextTextPaint.ascent()) - this.jdField_a_of_type_AndroidTextTextPaint.descent()) / 2.0F;
      if (this.jdField_a_of_type_Boolean) {
        a(this.jdField_a_of_type_AndroidGraphicsCanvas, this.jdField_a_of_type_JavaLangString, (getWidth() - this.jdField_b_of_type_AndroidTextTextPaint.measureText(this.jdField_a_of_type_JavaLangString)) / 2.0F, (getHeight() - f1) / 2.0F + f2, this.jdField_b_of_type_AndroidTextTextPaint);
      }
      a(this.jdField_a_of_type_AndroidGraphicsCanvas, this.jdField_a_of_type_JavaLangString, (getWidth() - this.jdField_a_of_type_AndroidTextTextPaint.measureText(this.jdField_a_of_type_JavaLangString)) / 2.0F, (getHeight() - f1) / 2.0F + f2, this.jdField_a_of_type_AndroidTextTextPaint);
    }
    else
    {
      localObject = this.jdField_a_of_type_JavaLangString.substring(0, i);
      str = this.jdField_a_of_type_JavaLangString.substring(i + 2);
      a((String)localObject, this.jdField_b_of_type_AndroidTextTextPaint, getWidth(), getHeight() / 2, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_b_of_type_AndroidTextTextPaint.getTextSize());
      f1 /= 2.0F;
      f2 = f1 + (Math.abs(this.jdField_a_of_type_AndroidTextTextPaint.ascent()) - this.jdField_a_of_type_AndroidTextTextPaint.descent()) / 2.0F;
      if (this.jdField_a_of_type_Boolean) {
        a(this.jdField_a_of_type_AndroidGraphicsCanvas, (String)localObject, (getWidth() - this.jdField_b_of_type_AndroidTextTextPaint.measureText((String)localObject)) / 2.0F, getHeight() * 0.35F - f1 + f2, this.jdField_b_of_type_AndroidTextTextPaint);
      }
      a(this.jdField_a_of_type_AndroidGraphicsCanvas, (String)localObject, (getWidth() - this.jdField_a_of_type_AndroidTextTextPaint.measureText((String)localObject)) / 2.0F, getHeight() * 0.35F - f1 + f2, this.jdField_a_of_type_AndroidTextTextPaint);
      if (this.jdField_a_of_type_Boolean) {
        a(this.jdField_a_of_type_AndroidGraphicsCanvas, str, (getWidth() - this.jdField_b_of_type_AndroidTextTextPaint.measureText(str)) / 2.0F, getHeight() * 0.75F - f1 + f2, this.jdField_b_of_type_AndroidTextTextPaint);
      }
      a(this.jdField_a_of_type_AndroidGraphicsCanvas, str, (getWidth() - this.jdField_a_of_type_AndroidTextTextPaint.measureText(str)) / 2.0F, getHeight() * 0.75F - f1 + f2, this.jdField_a_of_type_AndroidTextTextPaint);
    }
    paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, 0.0F, 0.0F, this.jdField_a_of_type_AndroidTextTextPaint);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt1 != paramInt3) || (paramInt2 != paramInt4))
    {
      Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
      if ((localBitmap != null) && (!localBitmap.isRecycled())) {
        this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      }
      this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      this.jdField_a_of_type_AndroidGraphicsCanvas = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
  }
  
  public void setFontId(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void setOutlineColor(String paramString)
  {
    this.jdField_b_of_type_AndroidTextTextPaint.setColor(Color.parseColor(paramString));
  }
  
  public void setOutlineWidth(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setShadow(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setShadowParam(float paramFloat1, float paramFloat2, float paramFloat3, String paramString)
  {
    this.jdField_a_of_type_Float = paramFloat1;
    this.jdField_b_of_type_Float = paramFloat2;
    this.jdField_c_of_type_Float = paramFloat3;
    this.jdField_c_of_type_JavaLangString = paramString;
  }
  
  public void setStroke(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setText(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString.trim();
    paramString = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (paramString != null)
    {
      paramString.eraseColor(0);
      invalidate();
    }
  }
  
  public void setTextColor(String paramString)
  {
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(Color.parseColor(paramString));
  }
  
  public void setTextSize(float paramFloat)
  {
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.giftext.AEGIFOutlineTextView
 * JD-Core Version:    0.7.0.1
 */
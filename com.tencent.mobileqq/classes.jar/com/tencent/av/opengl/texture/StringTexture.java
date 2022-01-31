package com.tencent.av.opengl.texture;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint.FontMetricsInt;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.av.utils.CharacterUtil;
import com.tencent.qphone.base.util.QLog;

public class StringTexture
  extends UploadedTexture
{
  private float jdField_a_of_type_Float = 15.0F;
  private final Bitmap.Config jdField_a_of_type_AndroidGraphicsBitmap$Config;
  protected Canvas a;
  private Paint.FontMetricsInt jdField_a_of_type_AndroidGraphicsPaint$FontMetricsInt;
  private TextPaint jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
  private String jdField_a_of_type_JavaLangString = "";
  private int k = -1;
  private int l = 2147483647;
  private int m = 2147483647;
  private int n = 2147483647;
  
  public StringTexture()
  {
    this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(this.k);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_a_of_type_Float);
    this.jdField_a_of_type_AndroidTextTextPaint.setShadowLayer(2.0F, 0.0F, 0.0F, -16777216);
    this.jdField_a_of_type_AndroidGraphicsPaint$FontMetricsInt = this.jdField_a_of_type_AndroidTextTextPaint.getFontMetricsInt();
    this.jdField_a_of_type_AndroidGraphicsBitmap$Config = Bitmap.Config.ARGB_8888;
    a(false);
  }
  
  protected Bitmap a()
  {
    Bitmap localBitmap = Bitmap.createBitmap(this.e, this.f, this.jdField_a_of_type_AndroidGraphicsBitmap$Config);
    this.jdField_a_of_type_AndroidGraphicsCanvas = new Canvas(localBitmap);
    this.jdField_a_of_type_AndroidGraphicsCanvas.translate(0.0F, -this.jdField_a_of_type_AndroidGraphicsPaint$FontMetricsInt.ascent);
    this.jdField_a_of_type_AndroidGraphicsCanvas.drawText(this.jdField_a_of_type_JavaLangString, 0.0F, 0.0F, this.jdField_a_of_type_AndroidTextTextPaint);
    return localBitmap;
  }
  
  public void a(float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StringTexture", 2, "setTextSize textSize: " + paramFloat);
    }
    this.jdField_a_of_type_Float = paramFloat;
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_a_of_type_Float);
    this.jdField_a_of_type_AndroidGraphicsPaint$FontMetricsInt = this.jdField_a_of_type_AndroidTextTextPaint.getFontMetricsInt();
  }
  
  protected void a(Bitmap paramBitmap)
  {
    if (!d()) {
      paramBitmap.recycle();
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StringTexture", 2, "setText text: " + paramString);
    }
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void e()
  {
    int i = 1;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      j = CharacterUtil.a(this.jdField_a_of_type_JavaLangString);
      i = (int)Math.ceil(this.jdField_a_of_type_AndroidTextTextPaint.measureText(this.jdField_a_of_type_JavaLangString));
      if ((j <= this.n) && (i <= this.l)) {
        break label287;
      }
    }
    label287:
    for (int j = 1;; j = 0)
    {
      if (j != 0)
      {
        i = Math.min(Math.max((this.l - (int)Math.ceil(this.jdField_a_of_type_AndroidTextTextPaint.measureText("..."))) / (int)Math.ceil(this.jdField_a_of_type_AndroidTextTextPaint.measureText("M")), 1), this.n);
        this.jdField_a_of_type_JavaLangString = (CharacterUtil.a(this.jdField_a_of_type_JavaLangString, 0, i) + "...");
        i = (int)Math.ceil(this.jdField_a_of_type_AndroidTextTextPaint.measureText(this.jdField_a_of_type_JavaLangString));
      }
      j = this.jdField_a_of_type_AndroidGraphicsPaint$FontMetricsInt.bottom - this.jdField_a_of_type_AndroidGraphicsPaint$FontMetricsInt.top;
      if (i <= 0) {
        i = 1;
      }
      for (;;)
      {
        if (j <= 0) {
          j = 1;
        }
        for (;;)
        {
          b(i, j);
          a(i, j);
          if (QLog.isColorLevel()) {
            QLog.d("StringTexture", 2, "refreshText width: " + this.e + ", height: " + this.f + ", maxLength: " + this.n + ", textSize: " + this.jdField_a_of_type_Float + ", text: " + this.jdField_a_of_type_JavaLangString);
          }
          return;
          j = 1;
        }
      }
    }
  }
  
  public void e(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StringTexture", 2, "setTextColor textColor: " + paramInt);
    }
    this.k = paramInt;
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(this.k);
  }
  
  public void f(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StringTexture", 2, "setMaxLength maxLength: " + paramInt);
    }
    this.n = paramInt;
  }
  
  public void g(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StringTexture", 2, "setWidth width: " + paramInt);
    }
    if (paramInt > 0) {
      this.l = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.opengl.texture.StringTexture
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.av.opengl.texture;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint.FontMetricsInt;
import android.os.Build.VERSION;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.av.opengl.glrenderer.GLCanvas;
import com.tencent.av.utils.CharacterUtil;
import com.tencent.qphone.base.util.QLog;

public class StringTexture
  extends UploadedTexture
{
  private float jdField_a_of_type_Float = 1.0F;
  private final Bitmap.Config jdField_a_of_type_AndroidGraphicsBitmap$Config;
  protected Canvas a;
  private Paint.FontMetricsInt jdField_a_of_type_AndroidGraphicsPaint$FontMetricsInt;
  private TextPaint jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
  private String jdField_a_of_type_JavaLangString = "";
  private float b = 15.0F;
  private int k = -1;
  private int l = 2147483647;
  private int m = 2147483647;
  private int n = 2147483647;
  
  public StringTexture()
  {
    this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(this.k);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.b);
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setTextSize textSize: ");
      localStringBuilder.append(paramFloat);
      QLog.d("StringTexture", 2, localStringBuilder.toString());
    }
    this.b = paramFloat;
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.b);
    this.jdField_a_of_type_AndroidGraphicsPaint$FontMetricsInt = this.jdField_a_of_type_AndroidTextTextPaint.getFontMetricsInt();
  }
  
  protected void a(Bitmap paramBitmap)
  {
    if (!d()) {
      paramBitmap.recycle();
    }
  }
  
  public void a(GLCanvas paramGLCanvas, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i;
    if ((this.jdField_a_of_type_Float < 0.99F) && (Build.VERSION.SDK_INT >= 16)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      paramGLCanvas.a(3);
      paramGLCanvas.a(this.jdField_a_of_type_Float);
    }
    paramGLCanvas.a(this, paramInt1, paramInt2, paramInt3, paramInt4);
    if (i != 0) {
      paramGLCanvas.c();
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setText text: ");
      localStringBuilder.append(paramString);
      QLog.d("StringTexture", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void c(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setTextColor textColor: ");
      localStringBuilder.append(paramInt);
      QLog.d("StringTexture", 2, localStringBuilder.toString());
    }
    this.k = paramInt;
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(this.k);
  }
  
  public void d(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setMaxLength maxLength: ");
      localStringBuilder.append(paramInt);
      QLog.d("StringTexture", 2, localStringBuilder.toString());
    }
    this.n = paramInt;
  }
  
  public void e()
  {
    boolean bool = TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString);
    int i = 1;
    int i1 = 1;
    int j;
    StringBuilder localStringBuilder;
    if (!bool)
    {
      i = CharacterUtil.a(this.jdField_a_of_type_JavaLangString);
      j = (int)Math.ceil(this.jdField_a_of_type_AndroidTextTextPaint.measureText(this.jdField_a_of_type_JavaLangString));
      if ((i <= this.n) && (j <= this.l)) {
        i = 0;
      } else {
        i = 1;
      }
      if (i != 0)
      {
        i = Math.min(Math.max((this.l - (int)Math.ceil(this.jdField_a_of_type_AndroidTextTextPaint.measureText("..."))) / (int)Math.ceil(this.jdField_a_of_type_AndroidTextTextPaint.measureText("M")), 1), this.n);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(CharacterUtil.a(this.jdField_a_of_type_JavaLangString, 0, i));
        localStringBuilder.append("...");
        this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
        j = (int)Math.ceil(this.jdField_a_of_type_AndroidTextTextPaint.measureText(this.jdField_a_of_type_JavaLangString));
      }
      int i2 = this.jdField_a_of_type_AndroidGraphicsPaint$FontMetricsInt.bottom - this.jdField_a_of_type_AndroidGraphicsPaint$FontMetricsInt.top;
      i = j;
      if (j <= 0) {
        i = 1;
      }
      if (i2 <= 0) {
        j = i1;
      } else {
        j = i2;
      }
    }
    else
    {
      j = 1;
    }
    b(i, j);
    a(i, j);
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("refreshText width: ");
      localStringBuilder.append(this.e);
      localStringBuilder.append(", height: ");
      localStringBuilder.append(this.f);
      localStringBuilder.append(", maxLength: ");
      localStringBuilder.append(this.n);
      localStringBuilder.append(", textSize: ");
      localStringBuilder.append(this.b);
      localStringBuilder.append(", text: ");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(";mMetrics:=");
      localStringBuilder.append(this.jdField_a_of_type_AndroidGraphicsPaint$FontMetricsInt.toString());
      QLog.d("StringTexture", 2, localStringBuilder.toString());
    }
  }
  
  public void e(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setWidth width: ");
      localStringBuilder.append(paramInt);
      QLog.d("StringTexture", 2, localStringBuilder.toString());
    }
    if (paramInt > 0) {
      this.l = paramInt;
    }
  }
  
  public int j()
  {
    return (int)Math.ceil(this.jdField_a_of_type_AndroidGraphicsPaint$FontMetricsInt.descent - this.jdField_a_of_type_AndroidGraphicsPaint$FontMetricsInt.ascent);
  }
  
  public int k()
  {
    return Math.abs(this.jdField_a_of_type_AndroidGraphicsPaint$FontMetricsInt.ascent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.texture.StringTexture
 * JD-Core Version:    0.7.0.1
 */
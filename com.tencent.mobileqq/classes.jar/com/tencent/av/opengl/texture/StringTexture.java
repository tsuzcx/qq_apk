package com.tencent.av.opengl.texture;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.av.opengl.glrenderer.GLCanvas;
import com.tencent.av.utils.CharacterUtil;
import com.tencent.qphone.base.util.QLog;

public class StringTexture
  extends UploadedTexture
{
  private final Bitmap.Config A;
  private boolean B = false;
  protected Canvas o;
  private String p = "";
  private float s = 1.0F;
  private float t = 15.0F;
  private int u = -1;
  private int v = 2147483647;
  private int w = 2147483647;
  private int x = 2147483647;
  private TextPaint y = new TextPaint();
  private Paint.FontMetricsInt z;
  
  public StringTexture()
  {
    this.y.setAntiAlias(true);
    this.y.setColor(this.u);
    this.y.setTextSize(this.t);
    this.y.setShadowLayer(2.0F, 0.0F, 0.0F, -16777216);
    this.z = this.y.getFontMetricsInt();
    this.A = Bitmap.Config.ARGB_8888;
    b(false);
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
    this.t = paramFloat;
    this.y.setTextSize(this.t);
    this.z = this.y.getFontMetricsInt();
  }
  
  protected void a(Bitmap paramBitmap)
  {
    if (!p()) {
      paramBitmap.recycle();
    }
  }
  
  public void a(GLCanvas paramGLCanvas, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i;
    if ((this.s < 0.99F) && (Build.VERSION.SDK_INT >= 16)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      paramGLCanvas.a(3);
      paramGLCanvas.a(this.s);
    }
    paramGLCanvas.a(this, paramInt1, paramInt2, paramInt3, paramInt4);
    if (i != 0) {
      paramGLCanvas.g();
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
    this.p = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.y.setTypeface(Typeface.defaultFromStyle(1));
    } else {
      this.y.setTypeface(Typeface.defaultFromStyle(0));
    }
    this.B = paramBoolean;
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
    this.u = paramInt;
    this.y.setColor(this.u);
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
    this.x = paramInt;
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
      this.v = paramInt;
    }
  }
  
  protected Bitmap v()
  {
    Bitmap localBitmap = Bitmap.createBitmap(this.g, this.h, this.A);
    this.o = new Canvas(localBitmap);
    this.o.translate(0.0F, -this.z.ascent);
    this.o.drawText(this.p, 0.0F, 0.0F, this.y);
    return localBitmap;
  }
  
  public boolean w()
  {
    return this.B;
  }
  
  public int x()
  {
    return (int)Math.ceil(this.z.descent - this.z.ascent);
  }
  
  public int y()
  {
    return Math.abs(this.z.ascent);
  }
  
  public void z()
  {
    boolean bool = TextUtils.isEmpty(this.p);
    int i = 1;
    int k = 1;
    int j;
    StringBuilder localStringBuilder;
    if (!bool)
    {
      i = CharacterUtil.a(this.p);
      j = (int)Math.ceil(this.y.measureText(this.p));
      if ((i <= this.x) && (j <= this.v)) {
        i = 0;
      } else {
        i = 1;
      }
      if (i != 0)
      {
        i = Math.min(Math.max((this.v - (int)Math.ceil(this.y.measureText("..."))) / (int)Math.ceil(this.y.measureText("M")), 1), this.x);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(CharacterUtil.a(this.p, 0, i));
        localStringBuilder.append("...");
        this.p = localStringBuilder.toString();
        j = (int)Math.ceil(this.y.measureText(this.p));
      }
      int m = this.z.bottom - this.z.top;
      i = j;
      if (j <= 0) {
        i = 1;
      }
      if (m <= 0) {
        j = k;
      } else {
        j = m;
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
      localStringBuilder.append(this.g);
      localStringBuilder.append(", height: ");
      localStringBuilder.append(this.h);
      localStringBuilder.append(", maxLength: ");
      localStringBuilder.append(this.x);
      localStringBuilder.append(", textSize: ");
      localStringBuilder.append(this.t);
      localStringBuilder.append(", text: ");
      localStringBuilder.append(this.p);
      localStringBuilder.append(";mMetrics:=");
      localStringBuilder.append(this.z.toString());
      QLog.d("StringTexture", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.texture.StringTexture
 * JD-Core Version:    0.7.0.1
 */
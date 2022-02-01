package com.tencent.luggage.wxa.jf;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.Typeface;
import com.tencent.luggage.wxa.pc.j;
import java.io.Serializable;

public class a
  extends Paint
  implements Serializable
{
  private a.a a = a.a.a;
  private float b;
  private int c;
  private String d;
  private int e;
  private float f = 3.4028235E+38F;
  private int g = 2147483647;
  
  public a()
  {
    e();
  }
  
  private void e()
  {
    this.b = 0.0F;
    this.c = 0;
    this.d = null;
    this.e = 0;
    float f1 = this.f;
    if (f1 == 3.4028235E+38F)
    {
      this.b = (getAlpha() / 255.0F);
      this.f = this.b;
    }
    else
    {
      this.b = f1;
    }
    int i = this.g;
    if (i == 2147483647)
    {
      this.c = getColor();
      this.g = this.c;
      return;
    }
    this.c = i;
  }
  
  public a a()
  {
    a locala = new a();
    locala.setColor(getColor());
    locala.setFlags(getFlags());
    locala.setDither(isDither());
    Shader localShader2 = getShader();
    if (localShader2 != null)
    {
      Object localObject = j.a(Shader.class, "copy", localShader2, new Class[0], new Object[0]);
      Shader localShader1 = localShader2;
      if (localObject != null)
      {
        localShader1 = localShader2;
        if ((localObject instanceof Shader)) {
          localShader1 = (Shader)localObject;
        }
      }
      locala.setShader(localShader1);
    }
    locala.setStrokeJoin(getStrokeJoin());
    locala.setStrokeMiter(getStrokeMiter());
    locala.setStrokeWidth(getStrokeWidth());
    locala.setStrokeCap(getStrokeCap());
    locala.setStyle(getStyle());
    locala.setTextSize(getTextSize());
    locala.setTextAlign(getTextAlign());
    locala.setTypeface(getTypeface());
    locala.a(b());
    return locala;
  }
  
  public a a(a parama)
  {
    parama.setColor(getColor());
    parama.setFlags(getFlags());
    parama.setDither(isDither());
    Shader localShader2 = getShader();
    if (localShader2 != null)
    {
      Object localObject = j.a(Shader.class, "copy", localShader2, new Class[0], new Object[0]);
      Shader localShader1 = localShader2;
      if (localObject != null)
      {
        localShader1 = localShader2;
        if ((localObject instanceof Shader)) {
          localShader1 = (Shader)localObject;
        }
      }
      parama.setShader(localShader1);
    }
    parama.setStrokeJoin(getStrokeJoin());
    parama.setStrokeMiter(getStrokeMiter());
    parama.setStrokeWidth(getStrokeWidth());
    parama.setStrokeCap(getStrokeCap());
    parama.setStyle(getStyle());
    parama.setTextSize(getTextSize());
    parama.setTextAlign(getTextAlign());
    parama.setTypeface(getTypeface());
    parama.a(b());
    return parama;
  }
  
  public void a(float paramFloat)
  {
    this.b = paramFloat;
    setColor(this.c);
  }
  
  public void a(int paramInt)
  {
    this.e = paramInt;
    setTypeface(Typeface.create(this.d, paramInt));
  }
  
  public void a(a.a parama)
  {
    this.a = parama;
  }
  
  public void a(String paramString)
  {
    this.d = paramString;
    setTypeface(Typeface.create(paramString, this.e));
  }
  
  public a.a b()
  {
    return this.a;
  }
  
  public float c()
  {
    return this.b;
  }
  
  protected Object clone()
  {
    return super.clone();
  }
  
  public void d()
  {
    reset();
    e();
  }
  
  public void reset()
  {
    super.reset();
    this.a = a.a.a;
  }
  
  public void setColor(int paramInt)
  {
    this.c = paramInt;
    super.setColor(paramInt & 0xFFFFFF | ((int)(Color.alpha(paramInt) * c()) & 0xFF) << 24);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jf.a
 * JD-Core Version:    0.7.0.1
 */
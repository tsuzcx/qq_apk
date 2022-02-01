package com.tencent.magicbrush.handler.glfont;

import java.nio.FloatBuffer;
import java.util.Iterator;
import java.util.List;

class k
{
  static final k a = new k();
  float b;
  float c;
  float d;
  float e;
  float f;
  float g;
  float h;
  float i;
  boolean j;
  int k = 1;
  
  static
  {
    a.a();
  }
  
  static void a(FloatBuffer paramFloatBuffer, List<k> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        k localk = (k)paramList.next();
        if (localk != null) {
          localk.a(paramFloatBuffer);
        }
      }
    }
  }
  
  public k a(boolean paramBoolean)
  {
    this.j = paramBoolean;
    return this;
  }
  
  public void a()
  {
    this.e = 0.0F;
    this.d = 0.0F;
    this.c = 0.0F;
    this.b = 0.0F;
    this.i = 0.0F;
    this.h = 0.0F;
    this.g = 0.0F;
    this.f = 0.0F;
    this.k = 1;
    this.j = false;
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    b(paramFloat1, paramFloat2);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.f = paramFloat1;
    this.g = paramFloat2;
    this.h = paramFloat3;
    this.i = paramFloat4;
  }
  
  public void a(FloatBuffer paramFloatBuffer)
  {
    b(paramFloatBuffer);
  }
  
  public void b(float paramFloat1, float paramFloat2)
  {
    this.d = paramFloat1;
    this.e = paramFloat2;
  }
  
  void b(FloatBuffer paramFloatBuffer)
  {
    paramFloatBuffer = paramFloatBuffer.put(this.b).put(this.c).put(this.d).put(this.e).put(this.f).put(this.g).put(this.h).put(this.i);
    float f1;
    if (this.j) {
      f1 = 1.0F;
    } else {
      f1 = 0.0F;
    }
    paramFloatBuffer.put(f1).put(this.k);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("glyph(");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", [");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.e);
    localStringBuilder.append("], [");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.j);
    localStringBuilder.append("])");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.handler.glfont.k
 * JD-Core Version:    0.7.0.1
 */
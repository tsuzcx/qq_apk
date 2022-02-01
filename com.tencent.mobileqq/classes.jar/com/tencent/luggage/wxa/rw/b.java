package com.tencent.luggage.wxa.rw;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import com.tencent.neattextview.textview.layout.d;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class b<T extends CharacterStyle>
  implements Serializable
{
  protected LinkedList<RectF> a;
  private int b;
  private int c;
  private CharacterStyle d;
  
  b(int paramInt1, int paramInt2, CharacterStyle paramCharacterStyle)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramCharacterStyle;
  }
  
  public T a()
  {
    return this.d;
  }
  
  public abstract void a(Canvas paramCanvas, TextPaint paramTextPaint, List<d> paramList);
  
  void a(List<d> paramList)
  {
    if (this.a == null)
    {
      this.a = new LinkedList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        d locald = (d)paramList.next();
        if ((locald.f() <= this.b) && (this.c < locald.g()))
        {
          this.a.add(locald.b(this.b, this.c));
          return;
        }
        int i = locald.f();
        int j = this.b;
        if ((i <= j) && (j < locald.g()) && (locald.g() <= this.c))
        {
          this.a.add(locald.b(this.b, locald.g()));
        }
        else
        {
          if ((this.b < locald.f()) && (this.c < locald.g()) && (this.c >= locald.f()))
          {
            this.a.add(locald.b(locald.f(), this.c));
            return;
          }
          if ((this.b < locald.f()) && (this.c >= locald.g())) {
            this.a.add(locald.b(locald.f(), locald.g()));
          }
        }
      }
    }
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    Object localObject = this.a;
    if (localObject == null) {
      return false;
    }
    localObject = ((LinkedList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      if (((RectF)((Iterator)localObject).next()).contains(paramFloat1, paramFloat2)) {
        return true;
      }
    }
    return false;
  }
  
  public Class b()
  {
    return getClass();
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    if ((paramObject instanceof b))
    {
      paramObject = (b)paramObject;
      if ((paramObject.b == this.b) && (paramObject.c == this.c))
      {
        int i = 0;
        while (i < this.a.size())
        {
          if (!((RectF)this.a.get(i)).equals((RectF)paramObject.a.get(i))) {
            return false;
          }
          i += 1;
        }
        return true;
      }
    }
    return false;
  }
  
  public int hashCode()
  {
    int i = 0;
    int j = 0;
    while (i < this.a.size())
    {
      j += ((RectF)this.a.get(i)).hashCode();
      i += 1;
    }
    return this.b + this.c + j;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CharacterBgStyle{mRectFList=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", mStart=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", mEnd=");
    localStringBuilder.append(this.c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.rw.b
 * JD-Core Version:    0.7.0.1
 */
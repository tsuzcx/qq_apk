package com.tencent.luggage.wxa.il;

import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.im.a;
import com.tencent.luggage.wxa.im.b;

public class c
  implements b<Integer>
{
  private int a;
  private int b;
  private a c;
  
  public c(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2, null);
  }
  
  public c(int paramInt1, int paramInt2, @Nullable a parama)
  {
    a(paramInt1, paramInt2, parama);
  }
  
  private void a(int paramInt1, int paramInt2, @Nullable a parama)
  {
    this.c = parama;
    if (this.c == null) {
      this.c = new c.a(this);
    }
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public int a()
  {
    return this.b - this.a + 1;
  }
  
  public int b()
  {
    return this.a;
  }
  
  public String b(int paramInt)
  {
    Object localObject = c(paramInt);
    if (localObject == null) {
      localObject = "";
    } else {
      localObject = ((Integer)localObject).toString();
    }
    return this.c.a((String)localObject);
  }
  
  public int c()
  {
    return this.b;
  }
  
  public Integer c(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < a())) {
      return Integer.valueOf(this.a + paramInt);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.il.c
 * JD-Core Version:    0.7.0.1
 */
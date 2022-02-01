package com.tencent.luggage.wxa.il;

import android.content.Context;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.im.a;

public class d
  extends c
{
  private int a;
  private int b;
  private a c;
  private boolean d;
  private Context e;
  
  public d(int paramInt1, int paramInt2, Context paramContext)
  {
    super(paramInt1, paramInt2);
    this.e = paramContext;
    a(paramInt1, paramInt2, this.c);
  }
  
  private void a(int paramInt1, int paramInt2, @Nullable a parama)
  {
    this.c = parama;
    if (this.c == null) {
      this.c = new d.a(this);
    }
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public int a()
  {
    if (this.d) {}
    for (int i = this.b - this.a + 1;; i = this.b - this.a) {
      return i + 1;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public int b()
  {
    return this.a;
  }
  
  public String b(int paramInt)
  {
    if ((paramInt == 0) && (this.d)) {
      return this.e.getString(2131892602);
    }
    return super.b(paramInt);
  }
  
  public int c()
  {
    return this.b;
  }
  
  public Integer c(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < a()))
    {
      if (this.d) {
        return Integer.valueOf(this.a + paramInt - 1);
      }
      return Integer.valueOf(this.a + paramInt);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.il.d
 * JD-Core Version:    0.7.0.1
 */
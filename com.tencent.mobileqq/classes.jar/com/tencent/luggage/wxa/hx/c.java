package com.tencent.luggage.wxa.hx;

import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;

public class c
{
  public boolean a = true;
  private int b;
  private int c;
  private CharSequence d;
  private CharSequence e;
  private TextPaint f;
  private Layout.Alignment g;
  private TextUtils.TruncateAt h;
  private int i;
  private int j = -1;
  private StaticLayout k;
  
  public c(StaticLayout paramStaticLayout)
  {
    this.k = paramStaticLayout;
  }
  
  public StaticLayout a()
  {
    return this.k;
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void a(Layout.Alignment paramAlignment)
  {
    this.g = paramAlignment;
  }
  
  public void a(TextPaint paramTextPaint)
  {
    this.f = paramTextPaint;
  }
  
  public void a(TextUtils.TruncateAt paramTruncateAt)
  {
    this.h = paramTruncateAt;
  }
  
  public void a(CharSequence paramCharSequence)
  {
    this.e = paramCharSequence;
  }
  
  public void b(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void b(CharSequence paramCharSequence)
  {
    this.d = paramCharSequence;
  }
  
  public void c(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void d(int paramInt)
  {
    this.j = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hx.c
 * JD-Core Version:    0.7.0.1
 */
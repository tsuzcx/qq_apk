package com.tencent.luggage.wxa.a;

import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.util.Log;

class i$g
{
  h.ae a;
  boolean b;
  boolean c;
  Paint d;
  Paint e;
  h.b f;
  h.b g;
  boolean h;
  
  i$g(i parami)
  {
    this.d = new Paint();
    this.d.setFlags(193);
    if (Build.VERSION.SDK_INT >= 14) {
      this.d.setHinting(0);
    }
    this.d.setStyle(Paint.Style.FILL);
    this.d.setTypeface(Typeface.DEFAULT);
    this.e = new Paint();
    this.e.setFlags(193);
    if (Build.VERSION.SDK_INT >= 14) {
      this.e.setHinting(0);
    }
    this.e.setStyle(Paint.Style.STROKE);
    this.e.setTypeface(Typeface.DEFAULT);
    this.a = h.ae.a();
  }
  
  i$g(i parami, g paramg)
  {
    this.b = paramg.b;
    this.c = paramg.c;
    this.d = new Paint(paramg.d);
    this.e = new Paint(paramg.e);
    parami = paramg.f;
    if (parami != null) {
      this.f = new h.b(parami);
    }
    parami = paramg.g;
    if (parami != null) {
      this.g = new h.b(parami);
    }
    this.h = paramg.h;
    try
    {
      this.a = ((h.ae)paramg.a.clone());
      return;
    }
    catch (CloneNotSupportedException parami)
    {
      Log.e("SVGAndroidRenderer", "Unexpected clone error", parami);
      this.a = h.ae.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.a.i.g
 * JD-Core Version:    0.7.0.1
 */
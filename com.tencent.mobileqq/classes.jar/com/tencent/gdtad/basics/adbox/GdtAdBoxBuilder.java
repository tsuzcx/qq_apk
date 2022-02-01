package com.tencent.gdtad.basics.adbox;

import android.content.Context;

public class GdtAdBoxBuilder
{
  private Context a;
  private GdtAdBoxData b;
  private GdtAdBoxListener c;
  
  GdtAdBoxBuilder(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public GdtAdBox a()
  {
    GdtAdBox localGdtAdBox = new GdtAdBox();
    localGdtAdBox.b(this.a);
    localGdtAdBox.a(this.b);
    localGdtAdBox.a(this.c);
    return localGdtAdBox;
  }
  
  public GdtAdBoxBuilder a(GdtAdBoxData paramGdtAdBoxData)
  {
    this.b = paramGdtAdBoxData;
    return this;
  }
  
  public GdtAdBoxBuilder a(GdtAdBoxListener paramGdtAdBoxListener)
  {
    this.c = paramGdtAdBoxListener;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.basics.adbox.GdtAdBoxBuilder
 * JD-Core Version:    0.7.0.1
 */
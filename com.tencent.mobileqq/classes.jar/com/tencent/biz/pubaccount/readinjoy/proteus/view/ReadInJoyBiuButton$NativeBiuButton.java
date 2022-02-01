package com.tencent.biz.pubaccount.readinjoy.proteus.view;

import android.content.Context;
import android.widget.ImageView;

public class ReadInJoyBiuButton$NativeBiuButton
  extends ImageView
{
  ReadInJoyBiuButton.OnAttachedListener a;
  
  public ReadInJoyBiuButton$NativeBiuButton(Context paramContext)
  {
    super(paramContext);
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.a != null) {
      this.a.a();
    }
  }
  
  public void onDetachedFromWindow()
  {
    if (this.a != null) {
      this.a.b();
    }
    super.onDetachedFromWindow();
  }
  
  public void setOnAttachedListener(ReadInJoyBiuButton.OnAttachedListener paramOnAttachedListener)
  {
    this.a = paramOnAttachedListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoyBiuButton.NativeBiuButton
 * JD-Core Version:    0.7.0.1
 */
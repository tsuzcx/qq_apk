package com.tencent.biz.pubaccount.readinjoy.proteus.view;

import android.content.Context;
import android.widget.ImageView;
import qto;

public class ReadInJoyBiuButton$NativeBiuButton
  extends ImageView
{
  qto a;
  
  public ReadInJoyBiuButton$NativeBiuButton(Context paramContext)
  {
    super(paramContext);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.a != null) {
      this.a.a();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    if (this.a != null) {
      this.a.b();
    }
    super.onDetachedFromWindow();
  }
  
  public void setOnAttachedListener(qto paramqto)
  {
    this.a = paramqto;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoyBiuButton.NativeBiuButton
 * JD-Core Version:    0.7.0.1
 */
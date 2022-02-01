package com.tencent.luggage.wxa.po;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.ImageView;

@SuppressLint({"AppCompatCustomView"})
class f
  extends ImageView
  implements com.tencent.luggage.wxa.kd.f
{
  private boolean a;
  
  public f(Context paramContext)
  {
    super(paramContext);
  }
  
  public boolean a()
  {
    return this.a;
  }
  
  public void setInterceptEvent(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.po.f
 * JD-Core Version:    0.7.0.1
 */
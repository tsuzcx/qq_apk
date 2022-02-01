package com.tencent.luggage.wxa.ks;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.kt.s;

public class a
  extends FrameLayout
  implements s
{
  private boolean a;
  
  public a(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public boolean a()
  {
    return this.a;
  }
  
  public void setFullscreenWithChild(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ks.a
 * JD-Core Version:    0.7.0.1
 */
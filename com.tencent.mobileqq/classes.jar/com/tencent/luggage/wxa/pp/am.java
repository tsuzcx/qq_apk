package com.tencent.luggage.wxa.pp;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import androidx.annotation.NonNull;

public class am
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private final View a;
  private final am.a b;
  private int c;
  private int d;
  private boolean e;
  
  private am(View paramView, am.a parama)
  {
    this.a = paramView;
    this.b = parama;
  }
  
  private void a()
  {
    this.a.getViewTreeObserver().addOnGlobalLayoutListener(this);
  }
  
  public static void a(@NonNull View paramView, @NonNull am.a parama)
  {
    new am(paramView, parama).a();
  }
  
  public void onGlobalLayout()
  {
    if (!this.e)
    {
      this.e = true;
      this.c = this.a.getWidth();
      this.d = this.a.getHeight();
      return;
    }
    if ((this.a.getWidth() != this.c) || (this.a.getHeight() != this.d))
    {
      this.b.a(this.a);
      this.c = this.a.getWidth();
      this.d = this.a.getHeight();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pp.am
 * JD-Core Version:    0.7.0.1
 */
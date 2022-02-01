package com.tencent.luggage.wxa.iv;

import android.annotation.SuppressLint;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;

@SuppressLint({"ViewConstructor"})
public class c
  extends FrameLayout
{
  private FrameLayout a;
  private a b;
  private c.a c;
  
  public ViewGroup getContentContainer()
  {
    return this.a;
  }
  
  public void setActionBarFullscreenMode(boolean paramBoolean)
  {
    a locala = this.b;
    if (locala != null) {
      locala.a(paramBoolean);
    }
  }
  
  public void setBackButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    a locala = this.b;
    if (locala != null) {
      locala.setBackButtonClickListener(paramOnClickListener);
    }
  }
  
  public void setCloseButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    a locala = this.b;
    if (locala != null) {
      locala.setCloseButtonClickListener(paramOnClickListener);
    }
  }
  
  public void setForegroundStyle(boolean paramBoolean)
  {
    a locala = this.b;
    if (locala != null) {
      locala.b(paramBoolean);
    }
  }
  
  public void setOnHideListener(c.a parama)
  {
    this.c = parama;
  }
  
  public void setOptionButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    a locala = this.b;
    if (locala != null) {
      locala.a(paramOnClickListener);
    }
  }
  
  public void setTitle(String paramString)
  {
    a locala = this.b;
    if (locala != null) {
      locala.setMainTitle(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.iv.c
 * JD-Core Version:    0.7.0.1
 */
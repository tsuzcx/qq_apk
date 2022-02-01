package com.tencent.luggage.wxa.pp;

import android.content.Context;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.luggage.wxa.pq.b;
import com.tencent.mm.plugin.appbrand.page.u;

public abstract interface ac
{
  public abstract int a(int paramInt);
  
  public abstract void a(float paramFloat1, float paramFloat2);
  
  public abstract void a(View.OnFocusChangeListener paramOnFocusChangeListener);
  
  public abstract void a(ac.a parama);
  
  public abstract void a(ac.c paramc);
  
  public abstract void a(u paramu);
  
  public abstract void addTextChangedListener(TextWatcher paramTextWatcher);
  
  public abstract void b(View.OnFocusChangeListener paramOnFocusChangeListener);
  
  public abstract void b(u paramu);
  
  public abstract boolean b();
  
  public abstract boolean c();
  
  public abstract boolean d();
  
  public abstract b getAutoFillController();
  
  public abstract Context getContext();
  
  public abstract int getInputId();
  
  public abstract View getInputPanel();
  
  public abstract char getLastKeyPressed();
  
  public abstract CharSequence getText();
  
  public abstract View getView();
  
  public abstract void h();
  
  public abstract void i();
  
  public abstract void j();
  
  public abstract void p();
  
  public abstract void setFixed(boolean paramBoolean);
  
  public abstract void setInputId(int paramInt);
  
  public abstract void setOnKeyUpPostImeListener(ac.b paramb);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pp.ac
 * JD-Core Version:    0.7.0.1
 */
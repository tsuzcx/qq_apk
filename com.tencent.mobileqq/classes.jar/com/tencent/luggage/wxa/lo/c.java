package com.tencent.luggage.wxa.lo;

import android.view.View;
import com.tencent.mm.plugin.appbrand.widget.picker.d;

public abstract interface c<T>
{
  public abstract T currentValue();
  
  public abstract View getView();
  
  public abstract void onAttach(d paramd);
  
  public abstract void onDetach(d paramd);
  
  public abstract void onHide(d paramd);
  
  public abstract void onShow(d paramd);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lo.c
 * JD-Core Version:    0.7.0.1
 */
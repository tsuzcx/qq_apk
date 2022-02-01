package com.tencent.luggage.wxa.pp;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class i$10
  implements TextView.OnEditorActionListener
{
  i$10(i parami, int paramInt) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool;
    if (paramInt == this.a)
    {
      i.a(this.b, i.d.b);
      i.j(this.b);
      i.a(this.b, null);
      bool = true;
    }
    else
    {
      bool = false;
    }
    EventCollector.getInstance().onEditorAction(paramTextView, paramInt, paramKeyEvent);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pp.i.10
 * JD-Core Version:    0.7.0.1
 */
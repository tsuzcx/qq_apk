package com.tencent.luggage.wxa.pt;

import android.os.Looper;
import android.text.Selection;
import com.tencent.luggage.wxa.qz.s;

public final class a
{
  private final s a = new a.1(this, Looper.getMainLooper());
  private volatile c b;
  
  public void a(c paramc)
  {
    this.b = paramc;
  }
  
  public void a(CharSequence paramCharSequence, boolean paramBoolean)
  {
    if (paramCharSequence == null) {
      return;
    }
    paramCharSequence = this.a.a(1000, Selection.getSelectionEnd(paramCharSequence), 0, paramCharSequence.toString());
    this.a.b(1000);
    s locals = this.a;
    long l;
    if (paramBoolean) {
      l = 150L;
    } else {
      l = 0L;
    }
    locals.a(paramCharSequence, l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pt.a
 * JD-Core Version:    0.7.0.1
 */
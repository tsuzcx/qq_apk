package com.tencent.luggage.wxa.pp;

import android.text.SpanWatcher;
import android.text.Spannable;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.s;

class aa$2
  implements SpanWatcher
{
  aa$2(aa paramaa) {}
  
  public void onSpanAdded(Spannable paramSpannable, Object paramObject, int paramInt1, int paramInt2)
  {
    if (ak.a(paramObject)) {
      o.e("MicroMsg.EditTextComposingTextDismissedObserver", "[bindInput] onSpanAdded %s, %s", new Object[] { paramSpannable, paramObject.getClass().getSimpleName() });
    }
  }
  
  public void onSpanChanged(Spannable paramSpannable, Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (ak.a(paramObject)) {
      o.e("MicroMsg.EditTextComposingTextDismissedObserver", "[bindInput] onSpanChanged %s, %s", new Object[] { paramSpannable, paramObject.getClass().getSimpleName() });
    }
  }
  
  public void onSpanRemoved(Spannable paramSpannable, Object paramObject, int paramInt1, int paramInt2)
  {
    if (ak.a(paramObject))
    {
      o.e("MicroMsg.EditTextComposingTextDismissedObserver", "[bindInput] onSpanRemoved %s, %s", new Object[] { paramSpannable, paramObject.getClass().getSimpleName() });
      aa.c(this.a).b(aa.b(this.a));
      aa.c(this.a).b(aa.b(this.a), 100L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pp.aa.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.luggage.wxa.rx;

import android.text.SpanWatcher;
import android.text.Spannable;
import com.tencent.neattextview.textview.layout.c;
import java.lang.ref.WeakReference;

class b$a
  implements SpanWatcher
{
  WeakReference<c> a;
  
  private void a(Spannable paramSpannable)
  {
    if (b.a(this.b))
    {
      this.b.postInvalidate();
      return;
    }
    Object localObject = this.a;
    if (localObject == null) {
      return;
    }
    localObject = (c)((WeakReference)localObject).get();
    if ((localObject != null) && (((c)localObject).d() == paramSpannable))
    {
      ((c)localObject).a(paramSpannable);
      this.b.postInvalidate();
    }
  }
  
  public void a(c paramc)
  {
    this.a = new WeakReference(paramc);
  }
  
  public void onSpanAdded(Spannable paramSpannable, Object paramObject, int paramInt1, int paramInt2)
  {
    a(paramSpannable);
  }
  
  public void onSpanChanged(Spannable paramSpannable, Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a(paramSpannable);
  }
  
  public void onSpanRemoved(Spannable paramSpannable, Object paramObject, int paramInt1, int paramInt2)
  {
    a(paramSpannable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.rx.b.a
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.luggage.wxa.pp;

import android.text.Editable;
import com.tencent.luggage.wxa.pt.a;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.ui.widget.MMTextWatcherAdapter;
import java.lang.ref.WeakReference;

class i$15
  extends MMTextWatcherAdapter
{
  i$15(i parami) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if ((this.a.f != null) && (this.a.f.get() != null))
    {
      if (i.d(this.a) == null) {
        return;
      }
      i.b(this.a);
      if (ak.b(paramEditable))
      {
        o.e("MicroMsg.AppBrandInputInvokeHandler", "[bindInput] text composing %s", new Object[] { paramEditable });
        return;
      }
      o.e("MicroMsg.AppBrandInputInvokeHandler", "[bindInput] not composing text %s", new Object[] { paramEditable });
      paramEditable = i.d(this.a).getEditableText();
      i.f(this.a).a(paramEditable, i.g(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pp.i.15
 * JD-Core Version:    0.7.0.1
 */
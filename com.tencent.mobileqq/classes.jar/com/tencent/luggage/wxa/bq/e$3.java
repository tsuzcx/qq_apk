package com.tencent.luggage.wxa.bq;

import android.text.Editable;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.pp.ak;
import com.tencent.mm.ui.widget.MMTextWatcherAdapter;

class e$3
  extends MMTextWatcherAdapter
{
  e$3(e parame, h paramh) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (ak.b(paramEditable)) {
      return;
    }
    e.a(this.b).a(paramEditable.toString(), this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bq.e.3
 * JD-Core Version:    0.7.0.1
 */
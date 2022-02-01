package com.tencent.luggage.wxa.pq;

import android.text.Editable;
import android.text.TextWatcher;

class b$4
  implements TextWatcher
{
  private boolean b = false;
  
  b$4(b paramb) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if ((this.b) && (!b.b(this.a).g())) {
      return;
    }
    if (!b.b(this.a).g()) {
      this.a.b();
    }
    b.a(this.a, paramEditable);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.b = b.b(this.a).g();
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pq.b.4
 * JD-Core Version:    0.7.0.1
 */
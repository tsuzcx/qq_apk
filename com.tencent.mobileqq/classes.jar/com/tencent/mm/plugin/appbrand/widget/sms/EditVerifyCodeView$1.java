package com.tencent.mm.plugin.appbrand.widget.sms;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.luggage.wxa.qz.o;

class EditVerifyCodeView$1
  implements TextWatcher
{
  EditVerifyCodeView$1(EditVerifyCodeView paramEditVerifyCodeView) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable != null)
    {
      if (paramEditable.length() == 0) {
        return;
      }
      o.d("MicroMsg.EditVerifyCodeView", "afterTextChanged:%s", new Object[] { paramEditable.toString() });
      if (EditVerifyCodeView.a(this.a).length() < 6)
      {
        EditVerifyCodeView.a(this.a).append(paramEditable.toString());
        EditVerifyCodeView.b(this.a);
      }
      paramEditable.delete(0, paramEditable.length());
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.sms.EditVerifyCodeView.1
 * JD-Core Version:    0.7.0.1
 */
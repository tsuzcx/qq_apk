package com.tencent.ad.tangram.canvas.views.form.textbox;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.ad.tangram.log.AdLog;

class b$1
  implements TextWatcher
{
  b$1(b paramb) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if ((this.this$0.getData() == null) || (!this.this$0.getData().isValid()) || (paramEditable == null))
    {
      AdLog.e("AdFormItemTextBoxView", "afterTextChanged error");
      return;
    }
    AdLog.i("AdFormItemTextBoxView", "afterTextChanged " + paramEditable.toString());
    this.this$0.getData().content.text = paramEditable.toString();
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.form.textbox.b.1
 * JD-Core Version:    0.7.0.1
 */
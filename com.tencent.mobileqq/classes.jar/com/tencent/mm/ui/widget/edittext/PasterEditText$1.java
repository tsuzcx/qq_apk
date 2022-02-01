package com.tencent.mm.ui.widget.edittext;

import android.text.Editable;
import android.text.TextWatcher;
import java.util.Iterator;
import java.util.LinkedList;

class PasterEditText$1
  implements TextWatcher
{
  PasterEditText$1(PasterEditText paramPasterEditText) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (PasterEditText.b(this.a))
    {
      PasterEditText.a(this.a, false);
      localObject = this.a;
      PasterEditText.c((PasterEditText)localObject, PasterEditText.c((PasterEditText)localObject));
      localObject = this.a;
      PasterEditText.b((PasterEditText)localObject, PasterEditText.d((PasterEditText)localObject));
      localObject = PasterEditText.e(this.a).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((PasterEditText.TextPasteListener)((Iterator)localObject).next()).onTextPaste(paramEditable, PasterEditText.d(this.a), PasterEditText.f(this.a), PasterEditText.c(this.a));
      }
    }
    Object localObject = PasterEditText.a(this.a).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((TextWatcher)((Iterator)localObject).next()).afterTextChanged(paramEditable);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    Iterator localIterator = PasterEditText.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((TextWatcher)localIterator.next()).beforeTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    PasterEditText.a(this.a, paramInt1);
    PasterEditText.b(this.a, paramInt3);
    PasterEditText.a(this.a, paramCharSequence.subSequence(paramInt1, paramInt1 + paramInt3));
    Iterator localIterator = PasterEditText.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((TextWatcher)localIterator.next()).onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.edittext.PasterEditText.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.luggage.wxa.pp;

import android.text.TextUtils;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;

class z$2
  extends InputConnectionWrapper
{
  z$2(z paramz, InputConnection paramInputConnection1, boolean paramBoolean, InputConnection paramInputConnection2)
  {
    super(paramInputConnection1, paramBoolean);
  }
  
  public boolean commitText(CharSequence paramCharSequence, int paramInt)
  {
    if (!TextUtils.isEmpty(paramCharSequence)) {
      this.b.a(paramCharSequence.charAt(paramCharSequence.length() - 1));
    }
    return super.commitText(paramCharSequence, paramInt);
  }
  
  public boolean deleteSurroundingText(int paramInt1, int paramInt2)
  {
    this.b.a('\b');
    return super.deleteSurroundingText(paramInt1, paramInt2);
  }
  
  public boolean finishComposingText()
  {
    Object localObject = this.a;
    if ((localObject instanceof BaseInputConnection)) {
      localObject = ((BaseInputConnection)localObject).getEditable();
    } else {
      localObject = this.b.getEditableText();
    }
    boolean bool1 = ak.b((CharSequence)localObject);
    boolean bool2 = super.finishComposingText();
    if ((bool2) && (z.a(this.b) == this) && (bool1)) {
      z.b(this.b).a();
    }
    return bool2;
  }
  
  public boolean setComposingText(CharSequence paramCharSequence, int paramInt)
  {
    if (!TextUtils.isEmpty(paramCharSequence)) {
      this.b.a(paramCharSequence.charAt(paramCharSequence.length() - 1));
    }
    return super.setComposingText(paramCharSequence, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pp.z.2
 * JD-Core Version:    0.7.0.1
 */
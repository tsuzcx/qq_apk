package com.tencent.mobileqq.activity;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mobileqq.widget.ClearableEditText;

class EditActivity$6
  implements TextWatcher
{
  String a;
  String b;
  String c;
  boolean d = true;
  int e = 0;
  boolean f = true;
  boolean g = false;
  
  EditActivity$6(EditActivity paramEditActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    EditActivity.b(this.h, true);
    if (!this.f) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    if (this.d) {
      paramEditable = this.c;
    } else {
      paramEditable = "";
    }
    localStringBuilder.append(paramEditable);
    localStringBuilder.append(this.b);
    paramEditable = localStringBuilder.toString();
    if (this.g)
    {
      this.f = false;
      this.h.a.setText(paramEditable);
      this.f = true;
    }
    int i = this.a.length();
    int j = this.e;
    this.h.a.setSelection(i + j);
    this.h.c();
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!this.f) {
      return;
    }
    this.g = false;
    this.a = paramCharSequence.toString().substring(0, paramInt1);
    this.b = paramCharSequence.toString().substring(paramInt1 + paramInt2);
    if (paramInt3 > 0)
    {
      this.d = true;
      return;
    }
    this.d = false;
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!this.f) {
      return;
    }
    this.c = paramCharSequence.toString().substring(paramInt1, paramInt3 + paramInt1);
    if (this.d)
    {
      if ((this.h.d == 100) && (this.c.contains("\n")))
      {
        this.g = true;
        this.c = this.c.replace("\n", "");
      }
      this.e = this.c.length();
      return;
    }
    this.e = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EditActivity.6
 * JD-Core Version:    0.7.0.1
 */
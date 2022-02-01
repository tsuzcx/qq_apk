package com.tencent.mobileqq.activity;

import android.text.Editable;
import android.text.Editable.Factory;
import com.tencent.mobileqq.text.QQTextBuilder;

class EditInfoActivity$11
  extends Editable.Factory
{
  EditInfoActivity$11(EditInfoActivity paramEditInfoActivity) {}
  
  public Editable newEditable(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof QQTextBuilder)) {
      return (Editable)paramCharSequence;
    }
    return new QQTextBuilder(paramCharSequence, 3, 20);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EditInfoActivity.11
 * JD-Core Version:    0.7.0.1
 */
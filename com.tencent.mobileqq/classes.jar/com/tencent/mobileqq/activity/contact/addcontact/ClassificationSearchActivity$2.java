package com.tencent.mobileqq.activity.contact.addcontact;

import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import com.tencent.common.config.AppSetting;

class ClassificationSearchActivity$2
  implements TextWatcher
{
  ClassificationSearchActivity$2(ClassificationSearchActivity paramClassificationSearchActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    String str = this.a.K.getText().toString();
    paramEditable = this.a.J;
    if (str.equals("")) {
      i = 8;
    } else {
      i = 0;
    }
    paramEditable.setVisibility(i);
    int j = this.a.q;
    int k = ClassificationSearchActivity.m;
    int i = 2131887648;
    if (j == k)
    {
      this.a.I.setText(this.a.getResources().getString(2131887648));
    }
    else
    {
      Button localButton = this.a.I;
      if (!str.equals(""))
      {
        paramEditable = this.a.getResources();
        i = 2131916124;
      }
      else
      {
        paramEditable = this.a.getResources();
      }
      localButton.setText(paramEditable.getString(i));
    }
    if (AppSetting.e) {
      this.a.I.setContentDescription(this.a.I.getText().toString());
    }
    if ((str.equals("")) && (this.a.M != null))
    {
      if ((this.a.q != ClassificationSearchActivity.k) && (this.a.q != ClassificationSearchActivity.n))
      {
        this.a.M.e();
        return;
      }
      ClassificationSearchActivity.a(this.a);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity.2
 * JD-Core Version:    0.7.0.1
 */
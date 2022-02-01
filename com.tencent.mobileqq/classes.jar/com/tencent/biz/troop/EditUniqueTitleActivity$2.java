package com.tencent.biz.troop;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;

class EditUniqueTitleActivity$2
  implements TextWatcher
{
  EditUniqueTitleActivity$2(EditUniqueTitleActivity paramEditUniqueTitleActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    String str = this.a.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    if (str.equals("")) {
      this.a.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
    } else {
      this.a.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
    }
    int i = str.length();
    ThemeUtil.getCurrentThemeInfo().getString("themeId");
    if (i > 6)
    {
      EditUniqueTitleActivity.a(this.a, false);
      if (!this.a.jdField_a_of_type_Boolean) {
        this.a.rightViewText.setAlpha(0.5F);
      }
      paramEditable = this.a.getResources().getColorStateList(2131167200);
    }
    else
    {
      EditUniqueTitleActivity.b(this.a, true);
      if (!this.a.jdField_a_of_type_Boolean) {
        this.a.rightViewText.setAlpha(1.0F);
      }
      paramEditable = this.a.getResources().getColorStateList(2131167144);
    }
    this.a.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramEditable);
    paramEditable = this.a.jdField_a_of_type_AndroidWidgetTextView;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str.length());
    localStringBuilder.append("/");
    localStringBuilder.append(6);
    paramEditable.setText(localStringBuilder.toString());
    int j = 6 - str.length();
    i = j;
    if (j < 0) {
      i = 0;
    }
    this.a.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(String.format(this.a.getString(2131696143), new Object[] { Integer.valueOf(i) }));
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.troop.EditUniqueTitleActivity.2
 * JD-Core Version:    0.7.0.1
 */
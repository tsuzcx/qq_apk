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
    String str = this.a.h.getText().toString();
    if (str.equals("")) {
      this.a.i.setVisibility(8);
    } else {
      this.a.i.setVisibility(0);
    }
    int i = str.length();
    ThemeUtil.getCurrentThemeInfo().getString("themeId");
    if (i > 6)
    {
      EditUniqueTitleActivity.a(this.a, false);
      if (!this.a.m) {
        this.a.rightViewText.setAlpha(0.5F);
      }
      paramEditable = this.a.getResources().getColorStateList(2131168185);
    }
    else
    {
      EditUniqueTitleActivity.b(this.a, true);
      if (!this.a.m) {
        this.a.rightViewText.setAlpha(1.0F);
      }
      paramEditable = this.a.getResources().getColorStateList(2131168125);
    }
    this.a.j.setTextColor(paramEditable);
    paramEditable = this.a.j;
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
    this.a.j.setContentDescription(String.format(this.a.getString(2131893908), new Object[] { Integer.valueOf(i) }));
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troop.EditUniqueTitleActivity.2
 * JD-Core Version:    0.7.0.1
 */
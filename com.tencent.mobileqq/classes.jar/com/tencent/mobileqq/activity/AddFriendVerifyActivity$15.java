package com.tencent.mobileqq.activity;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import java.io.UnsupportedEncodingException;

class AddFriendVerifyActivity$15
  implements TextWatcher
{
  AddFriendVerifyActivity$15(AddFriendVerifyActivity paramAddFriendVerifyActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (AddFriendVerifyActivity.a(this.a) != 4)
    {
      int i = paramEditable.length();
      if (i > 30)
      {
        paramEditable = paramEditable.toString();
        while (i > 30)
        {
          i = paramEditable.length();
          if (i >= 2)
          {
            int j = i - 2;
            if (Character.isHighSurrogate(paramEditable.charAt(j)))
            {
              paramEditable = paramEditable.substring(0, j);
              break label79;
            }
          }
          paramEditable = paramEditable.substring(0, i - 1);
          label79:
          i = paramEditable.length();
        }
        this.a.a.setText(paramEditable);
        this.a.a.setSelection(paramEditable.length());
      }
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (AddFriendVerifyActivity.a(this.a) != 4) {
      return;
    }
    try
    {
      paramInt3 = paramCharSequence.toString().getBytes("utf-8").length;
      paramInt1 = 90 - paramInt3;
      paramCharSequence = paramCharSequence.toString();
      paramInt2 = paramInt1;
      if (paramInt3 > 90)
      {
        paramInt2 = paramInt3;
        while (paramInt2 > 90)
        {
          paramInt1 = paramCharSequence.length();
          if (paramInt1 >= 2)
          {
            paramInt2 = paramInt1 - 2;
            if (Character.isHighSurrogate(paramCharSequence.charAt(paramInt2)))
            {
              paramCharSequence = paramCharSequence.substring(0, paramInt2);
              break label101;
            }
          }
          paramCharSequence = paramCharSequence.substring(0, paramInt1 - 1);
          label101:
          paramInt2 = paramCharSequence.getBytes("utf-8").length;
          paramInt1 = 90 - paramInt2;
        }
        AddFriendVerifyActivity.a(this.a).setText(paramCharSequence);
        AddFriendVerifyActivity.a(this.a).setSelection(paramCharSequence.length());
        paramInt2 = paramInt1;
      }
      if (AddFriendVerifyActivity.b(this.a).getVisibility() == 0)
      {
        paramCharSequence = new StringBuilder();
        paramCharSequence.append(paramInt2);
        paramCharSequence.append("");
        paramCharSequence = paramCharSequence.toString();
        AddFriendVerifyActivity.b(this.a).setText(paramCharSequence);
        return;
      }
    }
    catch (UnsupportedEncodingException paramCharSequence)
    {
      paramCharSequence.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendVerifyActivity.15
 * JD-Core Version:    0.7.0.1
 */
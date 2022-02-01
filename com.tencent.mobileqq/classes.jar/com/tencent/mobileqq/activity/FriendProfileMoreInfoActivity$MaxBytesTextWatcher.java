package com.tencent.mobileqq.activity;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

class FriendProfileMoreInfoActivity$MaxBytesTextWatcher
  implements TextWatcher
{
  boolean a = false;
  boolean b = false;
  private int d;
  private EditText e;
  private int f;
  private int g;
  
  public FriendProfileMoreInfoActivity$MaxBytesTextWatcher(FriendProfileMoreInfoActivity paramFriendProfileMoreInfoActivity, int paramInt, EditText paramEditText)
  {
    this.d = paramInt;
    this.e = paramEditText;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    Object localObject2 = this.e.getText().toString();
    paramEditable = (Editable)localObject2;
    if (((String)localObject2).getBytes().length > this.d) {
      localObject1 = localObject2;
    }
    try
    {
      String str1 = ((String)localObject2).substring(0, this.f);
      localObject1 = localObject2;
      String str2 = ((String)localObject2).substring(this.f + this.g, ((String)localObject2).length());
      localObject1 = localObject2;
      Object localObject3 = ((String)localObject2).substring(this.f, this.f + this.g);
      paramEditable = (Editable)localObject2;
      localObject1 = localObject2;
      if (str1.getBytes().length + str2.getBytes().length <= this.d)
      {
        paramEditable = (Editable)localObject2;
        localObject2 = localObject3;
        for (;;)
        {
          localObject1 = paramEditable;
          if (paramEditable.getBytes().length <= this.d) {
            break;
          }
          localObject1 = paramEditable;
          if (((String)localObject2).length() <= 0) {
            break;
          }
          localObject1 = paramEditable;
          localObject2 = ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
          localObject1 = paramEditable;
          localObject3 = new StringBuilder();
          localObject1 = paramEditable;
          ((StringBuilder)localObject3).append(str1);
          localObject1 = paramEditable;
          ((StringBuilder)localObject3).append((String)localObject2);
          localObject1 = paramEditable;
          ((StringBuilder)localObject3).append(str2);
          localObject1 = paramEditable;
          paramEditable = ((StringBuilder)localObject3).toString();
        }
        localObject1 = paramEditable;
        this.e.setText(paramEditable);
        localObject1 = paramEditable;
        this.e.setSelection(str1.length() + ((String)localObject2).length());
      }
    }
    catch (Exception paramEditable)
    {
      for (;;)
      {
        paramEditable = (Editable)localObject1;
      }
    }
    if (this.a) {
      this.a = false;
    } else {
      this.b = true;
    }
    if (this.e == this.c.f)
    {
      localObject1 = this.c;
      ((FriendProfileMoreInfoActivity)localObject1).a(FriendProfileMoreInfoActivity.j((FriendProfileMoreInfoActivity)localObject1), this.c.f, this.c.getString(2131892795), paramEditable);
      return;
    }
    if (this.e == this.c.g)
    {
      localObject1 = this.c;
      ((FriendProfileMoreInfoActivity)localObject1).a(FriendProfileMoreInfoActivity.k((FriendProfileMoreInfoActivity)localObject1), this.c.g, this.c.getString(2131892748), paramEditable);
      return;
    }
    if (this.e == this.c.h)
    {
      localObject1 = this.c;
      ((FriendProfileMoreInfoActivity)localObject1).a(FriendProfileMoreInfoActivity.l((FriendProfileMoreInfoActivity)localObject1), this.c.h, this.c.getString(2131892844), paramEditable);
      return;
    }
    if (this.e == this.c.i)
    {
      localObject1 = this.c;
      ((FriendProfileMoreInfoActivity)localObject1).a(FriendProfileMoreInfoActivity.m((FriendProfileMoreInfoActivity)localObject1), this.c.i, this.c.getString(2131892778), paramEditable);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.f = paramInt1;
    this.g = paramInt3;
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity.MaxBytesTextWatcher
 * JD-Core Version:    0.7.0.1
 */
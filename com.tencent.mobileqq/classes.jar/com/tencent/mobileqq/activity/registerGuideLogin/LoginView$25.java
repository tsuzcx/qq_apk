package com.tencent.mobileqq.activity.registerGuideLogin;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.ViewGroup.LayoutParams;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.widget.NewStyleDropdownView;

class LoginView$25
  implements TextWatcher
{
  LoginView$25(LoginView paramLoginView) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    LoginView.c(this.a);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramCharSequence.length() > 0)
    {
      if (this.a.b != null)
      {
        Object localObject = (LoginView.AccountAdapter)this.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getAdapter();
        if ((localObject != null) && (((LoginView.AccountAdapter)localObject).getCount() != 0))
        {
          localObject = (RelativeLayout.LayoutParams)this.a.b.getLayoutParams();
          paramInt1 = (int)(LoginView.a(this.a) * 40.0F + 0.5F);
          if (((RelativeLayout.LayoutParams)localObject).rightMargin != paramInt1)
          {
            ((RelativeLayout.LayoutParams)localObject).rightMargin = paramInt1;
            this.a.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
          }
        }
        else
        {
          localObject = (RelativeLayout.LayoutParams)this.a.b.getLayoutParams();
          paramInt1 = (int)(LoginView.a(this.a) * 15.0F + 0.5F);
          if (((RelativeLayout.LayoutParams)localObject).rightMargin != paramInt1)
          {
            ((RelativeLayout.LayoutParams)localObject).rightMargin = paramInt1;
            this.a.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
          }
        }
        this.a.b.setVisibility(0);
      }
    }
    else if ((this.a.b != null) && (this.a.b.isShown())) {
      this.a.b.setVisibility(8);
    }
    if (paramCharSequence.length() > 4)
    {
      this.a.a(paramCharSequence.toString());
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView.a(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.LoginView.25
 * JD-Core Version:    0.7.0.1
 */
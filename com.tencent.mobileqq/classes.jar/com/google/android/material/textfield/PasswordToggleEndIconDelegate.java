package com.google.android.material.textfield;

import android.content.res.Resources;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import com.google.android.material.R.drawable;
import com.google.android.material.R.string;

class PasswordToggleEndIconDelegate
  extends EndIconDelegate
{
  private final TextWatcher d = new PasswordToggleEndIconDelegate.1(this);
  private final TextInputLayout.OnEditTextAttachedListener e = new PasswordToggleEndIconDelegate.2(this);
  private final TextInputLayout.OnEndIconChangedListener f = new PasswordToggleEndIconDelegate.3(this);
  
  PasswordToggleEndIconDelegate(@NonNull TextInputLayout paramTextInputLayout)
  {
    super(paramTextInputLayout);
  }
  
  private static boolean a(EditText paramEditText)
  {
    return (paramEditText != null) && ((paramEditText.getInputType() == 16) || (paramEditText.getInputType() == 128) || (paramEditText.getInputType() == 144) || (paramEditText.getInputType() == 224));
  }
  
  private boolean c()
  {
    EditText localEditText = this.a.getEditText();
    return (localEditText != null) && ((localEditText.getTransformationMethod() instanceof PasswordTransformationMethod));
  }
  
  void a()
  {
    this.a.setEndIconDrawable(AppCompatResources.getDrawable(this.b, R.drawable.b));
    this.a.setEndIconContentDescription(this.a.getResources().getText(R.string.R));
    this.a.setEndIconOnClickListener(new PasswordToggleEndIconDelegate.4(this));
    this.a.a(this.e);
    this.a.a(this.f);
    EditText localEditText = this.a.getEditText();
    if (a(localEditText)) {
      localEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.textfield.PasswordToggleEndIconDelegate
 * JD-Core Version:    0.7.0.1
 */
package com.google.android.material.theme;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatViewInflater;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.google.android.material.textview.MaterialTextView;

public class MaterialComponentsViewInflater
  extends AppCompatViewInflater
{
  @NonNull
  protected AppCompatAutoCompleteTextView createAutoCompleteTextView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    return new MaterialAutoCompleteTextView(paramContext, paramAttributeSet);
  }
  
  @NonNull
  protected AppCompatButton createButton(@NonNull Context paramContext, @NonNull AttributeSet paramAttributeSet)
  {
    return new MaterialButton(paramContext, paramAttributeSet);
  }
  
  @NonNull
  protected AppCompatCheckBox createCheckBox(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new MaterialCheckBox(paramContext, paramAttributeSet);
  }
  
  @NonNull
  protected AppCompatRadioButton createRadioButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new MaterialRadioButton(paramContext, paramAttributeSet);
  }
  
  @NonNull
  protected AppCompatTextView createTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new MaterialTextView(paramContext, paramAttributeSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.theme.MaterialComponentsViewInflater
 * JD-Core Version:    0.7.0.1
 */
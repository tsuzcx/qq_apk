package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.LocaleList;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R.id;
import com.google.android.material.R.layout;
import com.google.android.material.chip.Chip;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Arrays;

class ChipTextInputComboView
  extends FrameLayout
  implements Checkable
{
  private TextWatcher jdField_a_of_type_AndroidTextTextWatcher;
  private final EditText jdField_a_of_type_AndroidWidgetEditText;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private final Chip jdField_a_of_type_ComGoogleAndroidMaterialChipChip;
  private final TextInputLayout jdField_a_of_type_ComGoogleAndroidMaterialTextfieldTextInputLayout;
  
  public ChipTextInputComboView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ChipTextInputComboView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ChipTextInputComboView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_ComGoogleAndroidMaterialChipChip = ((Chip)paramContext.inflate(R.layout.p, this, false));
    this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldTextInputLayout = ((TextInputLayout)paramContext.inflate(R.layout.q, this, false));
    this.jdField_a_of_type_AndroidWidgetEditText = this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldTextInputLayout.a();
    this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(4);
    this.jdField_a_of_type_AndroidTextTextWatcher = new ChipTextInputComboView.TextFormatter(this, null);
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    a();
    addView(this.jdField_a_of_type_ComGoogleAndroidMaterialChipChip);
    addView(this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldTextInputLayout);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(R.id.t));
    this.jdField_a_of_type_AndroidWidgetEditText.setSaveEnabled(false);
  }
  
  private String a(CharSequence paramCharSequence)
  {
    return TimeModel.a(getResources(), paramCharSequence);
  }
  
  private void a()
  {
    if (Build.VERSION.SDK_INT >= 24)
    {
      LocaleList localLocaleList = getContext().getResources().getConfiguration().getLocales();
      this.jdField_a_of_type_AndroidWidgetEditText.setImeHintLocales(localLocaleList);
    }
  }
  
  public TextInputLayout a()
  {
    return this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldTextInputLayout;
  }
  
  public void a(InputFilter paramInputFilter)
  {
    InputFilter[] arrayOfInputFilter1 = this.jdField_a_of_type_AndroidWidgetEditText.getFilters();
    InputFilter[] arrayOfInputFilter2 = (InputFilter[])Arrays.copyOf(arrayOfInputFilter1, arrayOfInputFilter1.length + 1);
    arrayOfInputFilter2[arrayOfInputFilter1.length] = paramInputFilter;
    this.jdField_a_of_type_AndroidWidgetEditText.setFilters(arrayOfInputFilter2);
  }
  
  public void a(AccessibilityDelegateCompat paramAccessibilityDelegateCompat)
  {
    ViewCompat.setAccessibilityDelegate(this.jdField_a_of_type_ComGoogleAndroidMaterialChipChip, paramAccessibilityDelegateCompat);
  }
  
  public void a(CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialChipChip.setText(a(paramCharSequence));
    if (!TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetEditText.getText()))
    {
      this.jdField_a_of_type_AndroidWidgetEditText.removeTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
      this.jdField_a_of_type_AndroidWidgetEditText.setText(null);
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    }
  }
  
  public boolean isChecked()
  {
    return this.jdField_a_of_type_ComGoogleAndroidMaterialChipChip.isChecked();
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    a();
  }
  
  public void setChecked(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialChipChip.setChecked(paramBoolean);
    Object localObject = this.jdField_a_of_type_AndroidWidgetEditText;
    int j = 0;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 4;
    }
    ((EditText)localObject).setVisibility(i);
    localObject = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChip;
    int i = j;
    if (paramBoolean) {
      i = 8;
    }
    ((Chip)localObject).setVisibility(i);
    if (isChecked())
    {
      this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
      if (!TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetEditText.getText()))
      {
        localObject = this.jdField_a_of_type_AndroidWidgetEditText;
        ((EditText)localObject).setSelection(((EditText)localObject).getText().length());
      }
    }
  }
  
  public void setOnClickListener(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialChipChip.setOnClickListener(paramOnClickListener);
  }
  
  public void setTag(int paramInt, Object paramObject)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialChipChip.setTag(paramInt, paramObject);
  }
  
  public void toggle()
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialChipChip.toggle();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.timepicker.ChipTextInputComboView
 * JD-Core Version:    0.7.0.1
 */
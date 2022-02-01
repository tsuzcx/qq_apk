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
  private final Chip a;
  private final TextInputLayout b;
  private final EditText c;
  private TextWatcher d;
  private TextView e;
  
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
    this.a = ((Chip)paramContext.inflate(R.layout.p, this, false));
    this.b = ((TextInputLayout)paramContext.inflate(R.layout.q, this, false));
    this.c = this.b.getEditText();
    this.c.setVisibility(4);
    this.d = new ChipTextInputComboView.TextFormatter(this, null);
    this.c.addTextChangedListener(this.d);
    b();
    addView(this.a);
    addView(this.b);
    this.e = ((TextView)findViewById(R.id.t));
    this.c.setSaveEnabled(false);
  }
  
  private String b(CharSequence paramCharSequence)
  {
    return TimeModel.a(getResources(), paramCharSequence);
  }
  
  private void b()
  {
    if (Build.VERSION.SDK_INT >= 24)
    {
      LocaleList localLocaleList = getContext().getResources().getConfiguration().getLocales();
      this.c.setImeHintLocales(localLocaleList);
    }
  }
  
  public TextInputLayout a()
  {
    return this.b;
  }
  
  public void a(InputFilter paramInputFilter)
  {
    InputFilter[] arrayOfInputFilter1 = this.c.getFilters();
    InputFilter[] arrayOfInputFilter2 = (InputFilter[])Arrays.copyOf(arrayOfInputFilter1, arrayOfInputFilter1.length + 1);
    arrayOfInputFilter2[arrayOfInputFilter1.length] = paramInputFilter;
    this.c.setFilters(arrayOfInputFilter2);
  }
  
  public void a(AccessibilityDelegateCompat paramAccessibilityDelegateCompat)
  {
    ViewCompat.setAccessibilityDelegate(this.a, paramAccessibilityDelegateCompat);
  }
  
  public void a(CharSequence paramCharSequence)
  {
    this.a.setText(b(paramCharSequence));
    if (!TextUtils.isEmpty(this.c.getText()))
    {
      this.c.removeTextChangedListener(this.d);
      this.c.setText(null);
      this.c.addTextChangedListener(this.d);
    }
  }
  
  public boolean isChecked()
  {
    return this.a.isChecked();
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    b();
  }
  
  public void setChecked(boolean paramBoolean)
  {
    this.a.setChecked(paramBoolean);
    Object localObject = this.c;
    int j = 0;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 4;
    }
    ((EditText)localObject).setVisibility(i);
    localObject = this.a;
    int i = j;
    if (paramBoolean) {
      i = 8;
    }
    ((Chip)localObject).setVisibility(i);
    if (isChecked())
    {
      this.c.requestFocus();
      if (!TextUtils.isEmpty(this.c.getText()))
      {
        localObject = this.c;
        ((EditText)localObject).setSelection(((EditText)localObject).getText().length());
      }
    }
  }
  
  public void setOnClickListener(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.a.setOnClickListener(paramOnClickListener);
  }
  
  public void setTag(int paramInt, Object paramObject)
  {
    this.a.setTag(paramInt, paramObject);
  }
  
  public void toggle()
  {
    this.a.toggle();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.timepicker.ChipTextInputComboView
 * JD-Core Version:    0.7.0.1
 */
package com.google.android.material.timepicker;

import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.google.android.material.textfield.TextInputLayout;

class TimePickerTextInputKeyController
  implements View.OnKeyListener, TextView.OnEditorActionListener
{
  private final ChipTextInputComboView jdField_a_of_type_ComGoogleAndroidMaterialTimepickerChipTextInputComboView;
  private final TimeModel jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimeModel;
  private boolean jdField_a_of_type_Boolean = false;
  private final ChipTextInputComboView b;
  
  TimePickerTextInputKeyController(ChipTextInputComboView paramChipTextInputComboView1, ChipTextInputComboView paramChipTextInputComboView2, TimeModel paramTimeModel)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerChipTextInputComboView = paramChipTextInputComboView1;
    this.b = paramChipTextInputComboView2;
    this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimeModel = paramTimeModel;
  }
  
  private void a(int paramInt)
  {
    ChipTextInputComboView localChipTextInputComboView = this.b;
    boolean bool2 = true;
    boolean bool1;
    if (paramInt == 12) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localChipTextInputComboView.setChecked(bool1);
    localChipTextInputComboView = this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerChipTextInputComboView;
    if (paramInt == 10) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    localChipTextInputComboView.setChecked(bool1);
    this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimeModel.d = paramInt;
  }
  
  private boolean a(int paramInt, KeyEvent paramKeyEvent, EditText paramEditText)
  {
    if ((paramInt == 67) && (paramKeyEvent.getAction() == 0) && (TextUtils.isEmpty(paramEditText.getText()))) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if (paramInt != 0)
    {
      a(10);
      return true;
    }
    return false;
  }
  
  private boolean b(int paramInt, KeyEvent paramKeyEvent, EditText paramEditText)
  {
    Editable localEditable = paramEditText.getText();
    if (localEditable == null) {
      return false;
    }
    if ((paramInt >= 7) && (paramInt <= 16) && (paramKeyEvent.getAction() == 1) && (paramEditText.getSelectionStart() == 2) && (localEditable.length() == 2)) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if (paramInt != 0)
    {
      a(12);
      return true;
    }
    return false;
  }
  
  public void a()
  {
    Object localObject2 = this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerChipTextInputComboView.a();
    Object localObject1 = this.b.a();
    localObject2 = ((TextInputLayout)localObject2).a();
    localObject1 = ((TextInputLayout)localObject1).a();
    ((EditText)localObject2).setImeOptions(268435461);
    ((EditText)localObject1).setImeOptions(268435462);
    ((EditText)localObject2).setOnEditorActionListener(this);
    ((EditText)localObject2).setOnKeyListener(this);
    ((EditText)localObject1).setOnKeyListener(this);
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool;
    if (paramInt == 5) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool) {
      a(12);
    }
    return bool;
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.jdField_a_of_type_Boolean) {
      return false;
    }
    this.jdField_a_of_type_Boolean = true;
    paramView = (EditText)paramView;
    boolean bool;
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimeModel.d == 12) {
      bool = a(paramInt, paramKeyEvent, paramView);
    } else {
      bool = b(paramInt, paramKeyEvent, paramView);
    }
    this.jdField_a_of_type_Boolean = false;
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.timepicker.TimePickerTextInputKeyController
 * JD-Core Version:    0.7.0.1
 */
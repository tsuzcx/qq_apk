package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import com.google.android.material.R.attr;
import com.google.android.material.R.id;
import com.google.android.material.R.string;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.reflect.Field;
import java.util.Locale;

class TimePickerTextInputPresenter
  implements TimePickerPresenter, TimePickerView.OnSelectionChange
{
  private final TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new TimePickerTextInputPresenter.1(this);
  private final EditText jdField_a_of_type_AndroidWidgetEditText;
  private final LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private MaterialButtonToggleGroup jdField_a_of_type_ComGoogleAndroidMaterialButtonMaterialButtonToggleGroup;
  private final ChipTextInputComboView jdField_a_of_type_ComGoogleAndroidMaterialTimepickerChipTextInputComboView;
  private final TimeModel jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimeModel;
  private final TimePickerTextInputKeyController jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimePickerTextInputKeyController;
  private final TextWatcher jdField_b_of_type_AndroidTextTextWatcher = new TimePickerTextInputPresenter.2(this);
  private final EditText jdField_b_of_type_AndroidWidgetEditText;
  private final ChipTextInputComboView jdField_b_of_type_ComGoogleAndroidMaterialTimepickerChipTextInputComboView;
  
  public TimePickerTextInputPresenter(LinearLayout paramLinearLayout, TimeModel paramTimeModel)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = paramLinearLayout;
    this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimeModel = paramTimeModel;
    Object localObject = paramLinearLayout.getResources();
    this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerChipTextInputComboView = ((ChipTextInputComboView)paramLinearLayout.findViewById(R.id.u));
    this.jdField_b_of_type_ComGoogleAndroidMaterialTimepickerChipTextInputComboView = ((ChipTextInputComboView)paramLinearLayout.findViewById(R.id.r));
    TextView localTextView1 = (TextView)this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerChipTextInputComboView.findViewById(R.id.t);
    TextView localTextView2 = (TextView)this.jdField_b_of_type_ComGoogleAndroidMaterialTimepickerChipTextInputComboView.findViewById(R.id.t);
    localTextView1.setText(((Resources)localObject).getString(R.string.q));
    localTextView2.setText(((Resources)localObject).getString(R.string.p));
    this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerChipTextInputComboView.setTag(R.id.aa, Integer.valueOf(12));
    this.jdField_b_of_type_ComGoogleAndroidMaterialTimepickerChipTextInputComboView.setTag(R.id.aa, Integer.valueOf(10));
    if (paramTimeModel.a == 0) {
      i();
    }
    localObject = new TimePickerTextInputPresenter.3(this);
    this.jdField_b_of_type_ComGoogleAndroidMaterialTimepickerChipTextInputComboView.setOnClickListener((View.OnClickListener)localObject);
    this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerChipTextInputComboView.setOnClickListener((View.OnClickListener)localObject);
    this.jdField_b_of_type_ComGoogleAndroidMaterialTimepickerChipTextInputComboView.a(paramTimeModel.b());
    this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerChipTextInputComboView.a(paramTimeModel.a());
    this.jdField_a_of_type_AndroidWidgetEditText = this.jdField_b_of_type_ComGoogleAndroidMaterialTimepickerChipTextInputComboView.a().a();
    this.jdField_b_of_type_AndroidWidgetEditText = this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerChipTextInputComboView.a().a();
    if (Build.VERSION.SDK_INT < 21)
    {
      int i = MaterialColors.a(paramLinearLayout, R.attr.colorPrimary);
      a(this.jdField_a_of_type_AndroidWidgetEditText, i);
      a(this.jdField_b_of_type_AndroidWidgetEditText, i);
    }
    this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimePickerTextInputKeyController = new TimePickerTextInputKeyController(this.jdField_b_of_type_ComGoogleAndroidMaterialTimepickerChipTextInputComboView, this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerChipTextInputComboView, paramTimeModel);
    this.jdField_b_of_type_ComGoogleAndroidMaterialTimepickerChipTextInputComboView.a(new ClickActionDelegate(paramLinearLayout.getContext(), R.string.i));
    this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerChipTextInputComboView.a(new ClickActionDelegate(paramLinearLayout.getContext(), R.string.k));
    a();
  }
  
  private static void a(EditText paramEditText, @ColorInt int paramInt)
  {
    try
    {
      Object localObject = paramEditText.getContext();
      Field localField = TextView.class.getDeclaredField("mCursorDrawableRes");
      localField.setAccessible(true);
      int i = localField.getInt(paramEditText);
      localField = TextView.class.getDeclaredField("mEditor");
      localField.setAccessible(true);
      paramEditText = localField.get(paramEditText);
      localField = paramEditText.getClass().getDeclaredField("mCursorDrawable");
      localField.setAccessible(true);
      localObject = AppCompatResources.getDrawable((Context)localObject, i);
      ((Drawable)localObject).setColorFilter(paramInt, PorterDuff.Mode.SRC_IN);
      localField.set(paramEditText, new Drawable[] { localObject, localObject });
      return;
    }
    catch (Throwable paramEditText) {}
  }
  
  private void a(TimeModel paramTimeModel)
  {
    h();
    Locale localLocale = this.jdField_a_of_type_AndroidWidgetLinearLayout.getResources().getConfiguration().locale;
    String str = String.format(localLocale, "%02d", new Object[] { Integer.valueOf(paramTimeModel.c) });
    paramTimeModel = String.format(localLocale, "%02d", new Object[] { Integer.valueOf(paramTimeModel.a()) });
    this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerChipTextInputComboView.a(str);
    this.jdField_b_of_type_ComGoogleAndroidMaterialTimepickerChipTextInputComboView.a(paramTimeModel);
    g();
    j();
  }
  
  private void g()
  {
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_b_of_type_AndroidTextTextWatcher);
    this.jdField_b_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
  }
  
  private void h()
  {
    this.jdField_a_of_type_AndroidWidgetEditText.removeTextChangedListener(this.jdField_b_of_type_AndroidTextTextWatcher);
    this.jdField_b_of_type_AndroidWidgetEditText.removeTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
  }
  
  private void i()
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialButtonMaterialButtonToggleGroup = ((MaterialButtonToggleGroup)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(R.id.q));
    this.jdField_a_of_type_ComGoogleAndroidMaterialButtonMaterialButtonToggleGroup.a(new TimePickerTextInputPresenter.4(this));
    this.jdField_a_of_type_ComGoogleAndroidMaterialButtonMaterialButtonToggleGroup.setVisibility(0);
    j();
  }
  
  private void j()
  {
    MaterialButtonToggleGroup localMaterialButtonToggleGroup = this.jdField_a_of_type_ComGoogleAndroidMaterialButtonMaterialButtonToggleGroup;
    if (localMaterialButtonToggleGroup == null) {
      return;
    }
    int i;
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimeModel.e == 0) {
      i = R.id.o;
    } else {
      i = R.id.p;
    }
    localMaterialButtonToggleGroup.a(i);
  }
  
  public void a()
  {
    g();
    a(this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimeModel);
    this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimePickerTextInputKeyController.a();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimeModel.d = paramInt;
    ChipTextInputComboView localChipTextInputComboView = this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerChipTextInputComboView;
    boolean bool2 = true;
    boolean bool1;
    if (paramInt == 12) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localChipTextInputComboView.setChecked(bool1);
    localChipTextInputComboView = this.jdField_b_of_type_ComGoogleAndroidMaterialTimepickerChipTextInputComboView;
    if (paramInt == 10) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    localChipTextInputComboView.setChecked(bool1);
    j();
  }
  
  public void b()
  {
    a(this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimeModel);
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
  }
  
  public void d()
  {
    View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getFocusedChild();
    if (localView == null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
    InputMethodManager localInputMethodManager = (InputMethodManager)ContextCompat.getSystemService(this.jdField_a_of_type_AndroidWidgetLinearLayout.getContext(), InputMethodManager.class);
    if (localInputMethodManager != null) {
      localInputMethodManager.hideSoftInputFromWindow(localView.getWindowToken(), 0);
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  public void e()
  {
    ChipTextInputComboView localChipTextInputComboView = this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerChipTextInputComboView;
    int i = this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimeModel.d;
    boolean bool2 = true;
    boolean bool1;
    if (i == 12) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localChipTextInputComboView.setChecked(bool1);
    localChipTextInputComboView = this.jdField_b_of_type_ComGoogleAndroidMaterialTimepickerChipTextInputComboView;
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerTimeModel.d == 10) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    localChipTextInputComboView.setChecked(bool1);
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerChipTextInputComboView.setChecked(false);
    this.jdField_b_of_type_ComGoogleAndroidMaterialTimepickerChipTextInputComboView.setChecked(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.timepicker.TimePickerTextInputPresenter
 * JD-Core Version:    0.7.0.1
 */
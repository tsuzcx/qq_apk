package com.google.android.material.datepicker;

import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public final class MaterialTextInputPicker<S>
  extends PickerFragment<S>
{
  @StyleRes
  private int jdField_a_of_type_Int;
  @Nullable
  private CalendarConstraints jdField_a_of_type_ComGoogleAndroidMaterialDatepickerCalendarConstraints;
  @Nullable
  private DateSelector<S> jdField_a_of_type_ComGoogleAndroidMaterialDatepickerDateSelector;
  
  @NonNull
  static <T> MaterialTextInputPicker<T> a(DateSelector<T> paramDateSelector, @StyleRes int paramInt, @NonNull CalendarConstraints paramCalendarConstraints)
  {
    MaterialTextInputPicker localMaterialTextInputPicker = new MaterialTextInputPicker();
    Bundle localBundle = new Bundle();
    localBundle.putInt("THEME_RES_ID_KEY", paramInt);
    localBundle.putParcelable("DATE_SELECTOR_KEY", paramDateSelector);
    localBundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", paramCalendarConstraints);
    localMaterialTextInputPicker.setArguments(localBundle);
    return localMaterialTextInputPicker;
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = getArguments();
    }
    this.jdField_a_of_type_Int = localBundle.getInt("THEME_RES_ID_KEY");
    this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerDateSelector = ((DateSelector)localBundle.getParcelable("DATE_SELECTOR_KEY"));
    this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerCalendarConstraints = ((CalendarConstraints)localBundle.getParcelable("CALENDAR_CONSTRAINTS_KEY"));
  }
  
  @NonNull
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.cloneInContext(new ContextThemeWrapper(getContext(), this.jdField_a_of_type_Int));
    return this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerDateSelector.a(paramLayoutInflater, paramViewGroup, paramBundle, this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerCalendarConstraints, new MaterialTextInputPicker.1(this));
  }
  
  public void onSaveInstanceState(@NonNull Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putInt("THEME_RES_ID_KEY", this.jdField_a_of_type_Int);
    paramBundle.putParcelable("DATE_SELECTOR_KEY", this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerDateSelector);
    paramBundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerCalendarConstraints);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.datepicker.MaterialTextInputPicker
 * JD-Core Version:    0.7.0.1
 */
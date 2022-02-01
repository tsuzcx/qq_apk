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
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public final class MaterialTextInputPicker<S>
  extends PickerFragment<S>
{
  @StyleRes
  private int a;
  @Nullable
  private DateSelector<S> b;
  @Nullable
  private CalendarConstraints c;
  
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
    this.a = localBundle.getInt("THEME_RES_ID_KEY");
    this.b = ((DateSelector)localBundle.getParcelable("DATE_SELECTOR_KEY"));
    this.c = ((CalendarConstraints)localBundle.getParcelable("CALENDAR_CONSTRAINTS_KEY"));
  }
  
  @NonNull
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.cloneInContext(new ContextThemeWrapper(getContext(), this.a));
    paramLayoutInflater = this.b.a(paramLayoutInflater, paramViewGroup, paramBundle, this.c, new MaterialTextInputPicker.1(this));
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onSaveInstanceState(@NonNull Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putInt("THEME_RES_ID_KEY", this.a);
    paramBundle.putParcelable("DATE_SELECTOR_KEY", this.b);
    paramBundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.datepicker.MaterialTextInputPicker
 * JD-Core Version:    0.7.0.1
 */
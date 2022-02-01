package com.google.android.material.datepicker;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R.string;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

abstract class DateFormatTextWatcher
  extends TextWatcherAdapter
{
  private final CalendarConstraints jdField_a_of_type_ComGoogleAndroidMaterialDatepickerCalendarConstraints;
  @NonNull
  private final TextInputLayout jdField_a_of_type_ComGoogleAndroidMaterialTextfieldTextInputLayout;
  private final Runnable jdField_a_of_type_JavaLangRunnable;
  private final String jdField_a_of_type_JavaLangString;
  private final DateFormat jdField_a_of_type_JavaTextDateFormat;
  private Runnable b;
  
  DateFormatTextWatcher(String paramString, DateFormat paramDateFormat, @NonNull TextInputLayout paramTextInputLayout, CalendarConstraints paramCalendarConstraints)
  {
    this.jdField_a_of_type_JavaTextDateFormat = paramDateFormat;
    this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldTextInputLayout = paramTextInputLayout;
    this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerCalendarConstraints = paramCalendarConstraints;
    this.jdField_a_of_type_JavaLangString = paramTextInputLayout.getContext().getString(R.string.F);
    this.jdField_a_of_type_JavaLangRunnable = new DateFormatTextWatcher.1(this, paramString);
  }
  
  private Runnable a(long paramLong)
  {
    return new DateFormatTextWatcher.2(this, paramLong);
  }
  
  void a() {}
  
  public void a(View paramView, Runnable paramRunnable)
  {
    paramView.postDelayed(paramRunnable, 1000L);
  }
  
  abstract void a(@Nullable Long paramLong);
  
  public void onTextChanged(@NonNull CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldTextInputLayout.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldTextInputLayout.removeCallbacks(this.b);
    this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldTextInputLayout.setError(null);
    a(null);
    if (TextUtils.isEmpty(paramCharSequence)) {
      return;
    }
    try
    {
      paramCharSequence = this.jdField_a_of_type_JavaTextDateFormat.parse(paramCharSequence.toString());
      this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldTextInputLayout.setError(null);
      long l = paramCharSequence.getTime();
      if ((this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerCalendarConstraints.a().a(l)) && (this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerCalendarConstraints.a(l)))
      {
        a(Long.valueOf(paramCharSequence.getTime()));
        return;
      }
      this.b = a(l);
      a(this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldTextInputLayout, this.b);
      return;
    }
    catch (ParseException paramCharSequence)
    {
      label137:
      break label137;
    }
    a(this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldTextInputLayout, this.jdField_a_of_type_JavaLangRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.datepicker.DateFormatTextWatcher
 * JD-Core Version:    0.7.0.1
 */
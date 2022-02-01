package com.google.android.material.datepicker;

import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.google.android.material.R.id;

public class MonthsPagerAdapter$ViewHolder
  extends RecyclerView.ViewHolder
{
  final TextView jdField_a_of_type_AndroidWidgetTextView;
  final MaterialCalendarGridView jdField_a_of_type_ComGoogleAndroidMaterialDatepickerMaterialCalendarGridView;
  
  MonthsPagerAdapter$ViewHolder(@NonNull LinearLayout paramLinearLayout, boolean paramBoolean)
  {
    super(paramLinearLayout);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLinearLayout.findViewById(R.id.G));
    ViewCompat.setAccessibilityHeading(this.jdField_a_of_type_AndroidWidgetTextView, true);
    this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerMaterialCalendarGridView = ((MaterialCalendarGridView)paramLinearLayout.findViewById(R.id.C));
    if (!paramBoolean) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.datepicker.MonthsPagerAdapter.ViewHolder
 * JD-Core Version:    0.7.0.1
 */
package com.google.android.material.datepicker;

import android.os.Build.VERSION;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;
import com.google.android.material.button.MaterialButton;

class MaterialCalendar$6
  extends RecyclerView.OnScrollListener
{
  MaterialCalendar$6(MaterialCalendar paramMaterialCalendar, MonthsPagerAdapter paramMonthsPagerAdapter, MaterialButton paramMaterialButton) {}
  
  public void onScrollStateChanged(@NonNull RecyclerView paramRecyclerView, int paramInt)
  {
    if (paramInt == 0)
    {
      CharSequence localCharSequence = this.jdField_a_of_type_ComGoogleAndroidMaterialButtonMaterialButton.getText();
      if (Build.VERSION.SDK_INT >= 16)
      {
        paramRecyclerView.announceForAccessibility(localCharSequence);
        return;
      }
      paramRecyclerView.sendAccessibilityEvent(2048);
    }
  }
  
  public void onScrolled(@NonNull RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      paramInt1 = this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerMaterialCalendar.a().findFirstVisibleItemPosition();
    } else {
      paramInt1 = this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerMaterialCalendar.a().findLastVisibleItemPosition();
    }
    MaterialCalendar.a(this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerMaterialCalendar, this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerMonthsPagerAdapter.a(paramInt1));
    this.jdField_a_of_type_ComGoogleAndroidMaterialButtonMaterialButton.setText(this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerMonthsPagerAdapter.a(paramInt1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.datepicker.MaterialCalendar.6
 * JD-Core Version:    0.7.0.1
 */
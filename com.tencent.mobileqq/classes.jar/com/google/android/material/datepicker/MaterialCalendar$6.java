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
      CharSequence localCharSequence = this.b.getText();
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
      paramInt1 = this.c.f().findFirstVisibleItemPosition();
    } else {
      paramInt1 = this.c.f().findLastVisibleItemPosition();
    }
    MaterialCalendar.a(this.c, this.a.b(paramInt1));
    this.b.setText(this.a.a(paramInt1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.datepicker.MaterialCalendar.6
 * JD-Core Version:    0.7.0.1
 */
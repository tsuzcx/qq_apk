package com.google.android.material.datepicker;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.State;

class MaterialCalendar$2
  extends SmoothCalendarLayoutManager
{
  MaterialCalendar$2(MaterialCalendar paramMaterialCalendar, Context paramContext, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    super(paramContext, paramInt1, paramBoolean);
  }
  
  protected void calculateExtraLayoutSpace(@NonNull RecyclerView.State paramState, @NonNull int[] paramArrayOfInt)
  {
    if (this.a == 0)
    {
      paramArrayOfInt[0] = MaterialCalendar.a(this.b).getWidth();
      paramArrayOfInt[1] = MaterialCalendar.a(this.b).getWidth();
      return;
    }
    paramArrayOfInt[0] = MaterialCalendar.a(this.b).getHeight();
    paramArrayOfInt[1] = MaterialCalendar.a(this.b).getHeight();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.datepicker.MaterialCalendar.2
 * JD-Core Version:    0.7.0.1
 */
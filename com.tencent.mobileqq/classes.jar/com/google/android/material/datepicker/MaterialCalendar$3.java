package com.google.android.material.datepicker;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import java.util.Iterator;
import java.util.LinkedHashSet;

class MaterialCalendar$3
  implements MaterialCalendar.OnDayClickListener
{
  MaterialCalendar$3(MaterialCalendar paramMaterialCalendar) {}
  
  public void a(long paramLong)
  {
    if (MaterialCalendar.b(this.a).a().a(paramLong))
    {
      MaterialCalendar.c(this.a).a(paramLong);
      Iterator localIterator = this.a.e.iterator();
      while (localIterator.hasNext()) {
        ((OnSelectionChangedListener)localIterator.next()).a(MaterialCalendar.c(this.a).a());
      }
      MaterialCalendar.a(this.a).getAdapter().notifyDataSetChanged();
      if (MaterialCalendar.d(this.a) != null) {
        MaterialCalendar.d(this.a).getAdapter().notifyDataSetChanged();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.datepicker.MaterialCalendar.3
 * JD-Core Version:    0.7.0.1
 */
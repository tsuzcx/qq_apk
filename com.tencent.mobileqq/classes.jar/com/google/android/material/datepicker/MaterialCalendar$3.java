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
    if (MaterialCalendar.a(this.a).a().a(paramLong))
    {
      MaterialCalendar.a(this.a).a(paramLong);
      Iterator localIterator = this.a.a.iterator();
      while (localIterator.hasNext()) {
        ((OnSelectionChangedListener)localIterator.next()).a(MaterialCalendar.a(this.a).a());
      }
      MaterialCalendar.a(this.a).getAdapter().notifyDataSetChanged();
      if (MaterialCalendar.b(this.a) != null) {
        MaterialCalendar.b(this.a).getAdapter().notifyDataSetChanged();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.datepicker.MaterialCalendar.3
 * JD-Core Version:    0.7.0.1
 */
package com.google.android.material.datepicker;

import android.graphics.Canvas;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.util.Pair;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ItemDecoration;
import androidx.recyclerview.widget.RecyclerView.State;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;

class MaterialCalendar$4
  extends RecyclerView.ItemDecoration
{
  private final Calendar b = UtcDates.c();
  private final Calendar c = UtcDates.c();
  
  MaterialCalendar$4(MaterialCalendar paramMaterialCalendar) {}
  
  public void onDraw(@NonNull Canvas paramCanvas, @NonNull RecyclerView paramRecyclerView, @NonNull RecyclerView.State paramState)
  {
    if ((paramRecyclerView.getAdapter() instanceof YearGridAdapter))
    {
      if (!(paramRecyclerView.getLayoutManager() instanceof GridLayoutManager)) {
        return;
      }
      paramState = (YearGridAdapter)paramRecyclerView.getAdapter();
      GridLayoutManager localGridLayoutManager = (GridLayoutManager)paramRecyclerView.getLayoutManager();
      Iterator localIterator = MaterialCalendar.c(this.a).d().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Pair)localIterator.next();
        if ((((Pair)localObject).first != null) && (((Pair)localObject).second != null))
        {
          this.b.setTimeInMillis(((Long)((Pair)localObject).first).longValue());
          this.c.setTimeInMillis(((Long)((Pair)localObject).second).longValue());
          int j = paramState.a(this.b.get(1));
          int i = paramState.a(this.c.get(1));
          localObject = localGridLayoutManager.findViewByPosition(j);
          View localView1 = localGridLayoutManager.findViewByPosition(i);
          int m = j / localGridLayoutManager.getSpanCount();
          int n = i / localGridLayoutManager.getSpanCount();
          i = m;
          while (i <= n)
          {
            View localView2 = localGridLayoutManager.findViewByPosition(localGridLayoutManager.getSpanCount() * i);
            if (localView2 != null)
            {
              int i1 = localView2.getTop();
              int i2 = MaterialCalendar.e(this.a).d.a();
              int i3 = localView2.getBottom();
              int i4 = MaterialCalendar.e(this.a).d.b();
              if (i == m) {
                j = ((View)localObject).getLeft() + ((View)localObject).getWidth() / 2;
              } else {
                j = 0;
              }
              int k;
              if (i == n) {
                k = localView1.getLeft() + localView1.getWidth() / 2;
              } else {
                k = paramRecyclerView.getWidth();
              }
              paramCanvas.drawRect(j, i1 + i2, k, i3 - i4, MaterialCalendar.e(this.a).h);
            }
            i += 1;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.datepicker.MaterialCalendar.4
 * JD-Core Version:    0.7.0.1
 */
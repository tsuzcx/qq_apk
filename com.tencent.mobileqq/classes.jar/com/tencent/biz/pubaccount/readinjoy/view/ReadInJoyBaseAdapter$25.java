package com.tencent.biz.pubaccount.readinjoy.view;

import bhvy;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.AbsListView;
import java.util.Calendar;
import ram;

public class ReadInJoyBaseAdapter$25
  implements Runnable
{
  public ReadInJoyBaseAdapter$25(ram paramram, AbsListView paramAbsListView) {}
  
  public void run()
  {
    int i;
    int j;
    long l1;
    long l2;
    if ((ram.a(this.this$0) == 0) && (bhvy.h(ram.a()) > 0) && (this.a.getLastVisiblePosition() >= bhvy.h(ram.a())) && (bhvy.g(ram.a()) > 0))
    {
      ram.a(this.this$0, this.a.getLastVisiblePosition());
      i = bhvy.g(ram.a());
      j = bhvy.i(ram.a());
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.set(10, 0);
      localCalendar.set(12, 0);
      localCalendar.set(13, 0);
      localCalendar.set(14, 0);
      l1 = localCalendar.getTimeInMillis();
      l2 = bhvy.a(ram.a());
      if (l1 <= l2) {
        break label161;
      }
      bhvy.j(ram.a(), 1);
      bhvy.a(ram.a(), l1);
      ((KandianMergeManager)ram.a().getManager(162)).n();
    }
    label161:
    while ((l1 != l2) || (j >= i)) {
      return;
    }
    bhvy.j(ram.a(), j + 1);
    ((KandianMergeManager)ram.a().getManager(162)).n();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.25
 * JD-Core Version:    0.7.0.1
 */
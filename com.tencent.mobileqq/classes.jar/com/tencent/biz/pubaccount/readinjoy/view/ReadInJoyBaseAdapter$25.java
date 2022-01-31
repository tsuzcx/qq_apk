package com.tencent.biz.pubaccount.readinjoy.view;

import bhvh;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.AbsListView;
import java.util.Calendar;
import rap;

public class ReadInJoyBaseAdapter$25
  implements Runnable
{
  public ReadInJoyBaseAdapter$25(rap paramrap, AbsListView paramAbsListView) {}
  
  public void run()
  {
    int i;
    int j;
    long l1;
    long l2;
    if ((rap.a(this.this$0) == 0) && (bhvh.h(rap.a()) > 0) && (this.a.getLastVisiblePosition() >= bhvh.h(rap.a())) && (bhvh.g(rap.a()) > 0))
    {
      rap.a(this.this$0, this.a.getLastVisiblePosition());
      i = bhvh.g(rap.a());
      j = bhvh.i(rap.a());
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.set(10, 0);
      localCalendar.set(12, 0);
      localCalendar.set(13, 0);
      localCalendar.set(14, 0);
      l1 = localCalendar.getTimeInMillis();
      l2 = bhvh.a(rap.a());
      if (l1 <= l2) {
        break label161;
      }
      bhvh.j(rap.a(), 1);
      bhvh.a(rap.a(), l1);
      ((KandianMergeManager)rap.a().getManager(162)).n();
    }
    label161:
    while ((l1 != l2) || (j >= i)) {
      return;
    }
    bhvh.j(rap.a(), j + 1);
    ((KandianMergeManager)rap.a().getManager(162)).n();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.25
 * JD-Core Version:    0.7.0.1
 */
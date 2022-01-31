package com.tencent.biz.pubaccount.readinjoy.view;

import bjxj;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.AbsListView;
import java.util.Calendar;
import rqj;

public class ReadInJoyBaseAdapter$25
  implements Runnable
{
  public ReadInJoyBaseAdapter$25(rqj paramrqj, AbsListView paramAbsListView) {}
  
  public void run()
  {
    int i;
    int j;
    long l1;
    long l2;
    if ((rqj.a(this.this$0) == 0) && (bjxj.h(rqj.a()) > 0) && (this.a.getLastVisiblePosition() >= bjxj.h(rqj.a())) && (bjxj.g(rqj.a()) > 0))
    {
      rqj.a(this.this$0, this.a.getLastVisiblePosition());
      i = bjxj.g(rqj.a());
      j = bjxj.i(rqj.a());
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.set(10, 0);
      localCalendar.set(12, 0);
      localCalendar.set(13, 0);
      localCalendar.set(14, 0);
      l1 = localCalendar.getTimeInMillis();
      l2 = bjxj.a(rqj.a());
      if (l1 <= l2) {
        break label161;
      }
      bjxj.j(rqj.a(), 1);
      bjxj.a(rqj.a(), l1);
      ((KandianMergeManager)rqj.a().getManager(162)).n();
    }
    label161:
    while ((l1 != l2) || (j >= i)) {
      return;
    }
    bjxj.j(rqj.a(), j + 1);
    ((KandianMergeManager)rqj.a().getManager(162)).n();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.25
 * JD-Core Version:    0.7.0.1
 */
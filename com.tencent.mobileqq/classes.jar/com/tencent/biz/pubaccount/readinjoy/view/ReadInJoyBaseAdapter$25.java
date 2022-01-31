package com.tencent.biz.pubaccount.readinjoy.view;

import bgmq;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.AbsListView;
import java.util.Calendar;
import qoe;

public class ReadInJoyBaseAdapter$25
  implements Runnable
{
  public ReadInJoyBaseAdapter$25(qoe paramqoe, AbsListView paramAbsListView) {}
  
  public void run()
  {
    int i;
    int j;
    long l1;
    long l2;
    if ((qoe.a(this.this$0) == 0) && (bgmq.h(qoe.a()) > 0) && (this.a.getLastVisiblePosition() >= bgmq.h(qoe.a())) && (bgmq.g(qoe.a()) > 0))
    {
      qoe.a(this.this$0, this.a.getLastVisiblePosition());
      i = bgmq.g(qoe.a());
      j = bgmq.i(qoe.a());
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.set(10, 0);
      localCalendar.set(12, 0);
      localCalendar.set(13, 0);
      localCalendar.set(14, 0);
      l1 = localCalendar.getTimeInMillis();
      l2 = bgmq.a(qoe.a());
      if (l1 <= l2) {
        break label161;
      }
      bgmq.j(qoe.a(), 1);
      bgmq.a(qoe.a(), l1);
      ((KandianMergeManager)qoe.a().getManager(162)).n();
    }
    label161:
    while ((l1 != l2) || (j >= i)) {
      return;
    }
    bgmq.j(qoe.a(), j + 1);
    ((KandianMergeManager)qoe.a().getManager(162)).n();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.25
 * JD-Core Version:    0.7.0.1
 */
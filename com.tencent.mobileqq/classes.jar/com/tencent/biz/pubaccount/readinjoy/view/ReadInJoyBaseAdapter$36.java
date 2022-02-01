package com.tencent.biz.pubaccount.readinjoy.view;

import bmqa;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.AbsListView;
import java.util.Calendar;
import snh;

public class ReadInJoyBaseAdapter$36
  implements Runnable
{
  public ReadInJoyBaseAdapter$36(snh paramsnh, AbsListView paramAbsListView) {}
  
  public void run()
  {
    int i;
    int j;
    long l1;
    long l2;
    if ((snh.a(this.this$0) == 0) && (bmqa.h(snh.a()) > 0) && (this.a.getLastVisiblePosition() >= bmqa.h(snh.a())) && (bmqa.g(snh.a()) > 0))
    {
      snh.a(this.this$0, this.a.getLastVisiblePosition());
      i = bmqa.g(snh.a());
      j = bmqa.i(snh.a());
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.set(10, 0);
      localCalendar.set(12, 0);
      localCalendar.set(13, 0);
      localCalendar.set(14, 0);
      l1 = localCalendar.getTimeInMillis();
      l2 = bmqa.a(snh.a());
      if (l1 <= l2) {
        break label161;
      }
      bmqa.j(snh.a(), 1);
      bmqa.a(snh.a(), l1);
      ((KandianMergeManager)snh.a().getManager(162)).o();
    }
    label161:
    while ((l1 != l2) || (j >= i)) {
      return;
    }
    bmqa.j(snh.a(), j + 1);
    ((KandianMergeManager)snh.a().getManager(162)).o();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.36
 * JD-Core Version:    0.7.0.1
 */
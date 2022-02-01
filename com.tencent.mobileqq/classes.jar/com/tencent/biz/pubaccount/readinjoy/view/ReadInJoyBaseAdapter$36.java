package com.tencent.biz.pubaccount.readinjoy.view;

import bnrf;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.AbsListView;
import java.util.Calendar;
import sel;

public class ReadInJoyBaseAdapter$36
  implements Runnable
{
  public ReadInJoyBaseAdapter$36(sel paramsel, AbsListView paramAbsListView) {}
  
  public void run()
  {
    int i;
    int j;
    long l1;
    long l2;
    if ((sel.a(this.this$0) == 0) && (bnrf.h(sel.a()) > 0) && (this.a.getLastVisiblePosition() >= bnrf.h(sel.a())) && (bnrf.g(sel.a()) > 0))
    {
      sel.a(this.this$0, this.a.getLastVisiblePosition());
      i = bnrf.g(sel.a());
      j = bnrf.i(sel.a());
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.set(10, 0);
      localCalendar.set(12, 0);
      localCalendar.set(13, 0);
      localCalendar.set(14, 0);
      l1 = localCalendar.getTimeInMillis();
      l2 = bnrf.a(sel.a());
      if (l1 <= l2) {
        break label161;
      }
      bnrf.j(sel.a(), 1);
      bnrf.a(sel.a(), l1);
      ((KandianMergeManager)sel.a().getManager(162)).o();
    }
    label161:
    while ((l1 != l2) || (j >= i)) {
      return;
    }
    bnrf.j(sel.a(), j + 1);
    ((KandianMergeManager)sel.a().getManager(162)).o();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.36
 * JD-Core Version:    0.7.0.1
 */
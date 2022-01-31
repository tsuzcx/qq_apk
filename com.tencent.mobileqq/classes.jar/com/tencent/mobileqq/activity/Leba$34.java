package com.tencent.mobileqq.activity;

import adou;
import alra;
import android.widget.TextView;
import aovj;
import ayxn;
import azmz;
import bizg;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadRegulator;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.report.lp.LinkReport;
import java.util.HashMap;

class Leba$34
  implements Runnable
{
  Leba$34(Leba paramLeba, aovj paramaovj) {}
  
  public void run()
  {
    boolean bool = true;
    if ((Leba.a(this.this$0) != null) && (Leba.a(this.this$0).getVisibility() == 0)) {}
    this.this$0.a(null, true, this.a);
    ThreadRegulator.a().a(4);
    ThreadRegulator.a().a(4, 2000L);
    Leba.d(this.this$0, true);
    ayxn localayxn = (ayxn)this.this$0.a.getManager(10);
    if (localayxn != null)
    {
      if ((localayxn.a(1) <= 0) && (localayxn.a(2) <= 0))
      {
        Object localObject = new bizg();
        ((bizg)localObject).c = "1";
        ((bizg)localObject).d = "0";
        ((bizg)localObject).b = 4;
        ((bizg)localObject).l = "3";
        ((bizg)localObject).m = "mainEntrance";
        ((bizg)localObject).n = "activefeed";
        QZoneClickReport.report(this.this$0.a.getAccount(), (bizg)localObject, false);
        localObject = new HashMap();
        ((HashMap)localObject).put("source_type", "3");
        ((HashMap)localObject).put("source_from", "mainEntrance");
        ((HashMap)localObject).put("source_to", "activefeed");
        azmz.a(BaseApplicationImpl.getContext()).a(this.this$0.a.getAccount(), "actQZSourceDataReport", true, 0L, 0L, (HashMap)localObject, null);
      }
      if ((this.this$0.a.a() == null) || (!this.this$0.a.a().a())) {
        break label308;
      }
    }
    for (;;)
    {
      adou.a(localayxn, false, bool);
      if ((Leba.b(this.this$0) != null) && (Leba.b(this.this$0).getVisibility() == 0))
      {
        localayxn.c(3);
        localayxn.c(61);
        localayxn.c(6);
      }
      LinkReport.reportClickQZoneEntry(this.this$0.a.c());
      return;
      label308:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Leba.34
 * JD-Core Version:    0.7.0.1
 */
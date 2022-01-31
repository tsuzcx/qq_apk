package com.tencent.mobileqq.activity;

import abxm;
import ajzm;
import android.widget.TextView;
import anec;
import axcj;
import axrn;
import bgyj;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadRegulator;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.report.lp.LinkReport;
import java.util.HashMap;

class Leba$32
  implements Runnable
{
  Leba$32(Leba paramLeba, anec paramanec) {}
  
  public void run()
  {
    boolean bool = true;
    if ((Leba.a(this.this$0) != null) && (Leba.a(this.this$0).getVisibility() == 0)) {}
    this.this$0.a(null, true, this.a);
    ThreadRegulator.a().a(4);
    ThreadRegulator.a().a(4, 2000L);
    Leba.d(this.this$0, true);
    axcj localaxcj = (axcj)this.this$0.a.getManager(10);
    if (localaxcj != null)
    {
      if ((localaxcj.a(1) <= 0) && (localaxcj.a(2) <= 0))
      {
        Object localObject = new bgyj();
        ((bgyj)localObject).c = "1";
        ((bgyj)localObject).d = "0";
        ((bgyj)localObject).b = 4;
        ((bgyj)localObject).l = "3";
        ((bgyj)localObject).m = "mainEntrance";
        ((bgyj)localObject).n = "activefeed";
        QZoneClickReport.report(this.this$0.a.getAccount(), (bgyj)localObject, false);
        localObject = new HashMap();
        ((HashMap)localObject).put("source_type", "3");
        ((HashMap)localObject).put("source_from", "mainEntrance");
        ((HashMap)localObject).put("source_to", "activefeed");
        axrn.a(BaseApplicationImpl.getContext()).a(this.this$0.a.getAccount(), "actQZSourceDataReport", true, 0L, 0L, (HashMap)localObject, null);
      }
      if ((this.this$0.a.a() == null) || (!this.this$0.a.a().a())) {
        break label308;
      }
    }
    for (;;)
    {
      abxm.a(localaxcj, false, bool);
      if ((Leba.b(this.this$0) != null) && (Leba.b(this.this$0).getVisibility() == 0))
      {
        localaxcj.c(3);
        localaxcj.c(61);
        localaxcj.c(6);
      }
      LinkReport.reportClickQZoneEntry(this.this$0.a.c());
      return;
      label308:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Leba.32
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity;

import adtj;
import alvp;
import android.widget.TextView;
import aozs;
import azbw;
import azri;
import bjdn;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadRegulator;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.report.lp.LinkReport;
import java.util.HashMap;

class Leba$34
  implements Runnable
{
  Leba$34(Leba paramLeba, aozs paramaozs) {}
  
  public void run()
  {
    boolean bool = true;
    if ((Leba.a(this.this$0) != null) && (Leba.a(this.this$0).getVisibility() == 0)) {}
    this.this$0.a(null, true, this.a);
    ThreadRegulator.a().a(4);
    ThreadRegulator.a().a(4, 2000L);
    Leba.d(this.this$0, true);
    azbw localazbw = (azbw)this.this$0.a.getManager(10);
    if (localazbw != null)
    {
      if ((localazbw.a(1) <= 0) && (localazbw.a(2) <= 0))
      {
        Object localObject = new bjdn();
        ((bjdn)localObject).c = "1";
        ((bjdn)localObject).d = "0";
        ((bjdn)localObject).b = 4;
        ((bjdn)localObject).l = "3";
        ((bjdn)localObject).m = "mainEntrance";
        ((bjdn)localObject).n = "activefeed";
        QZoneClickReport.report(this.this$0.a.getAccount(), (bjdn)localObject, false);
        localObject = new HashMap();
        ((HashMap)localObject).put("source_type", "3");
        ((HashMap)localObject).put("source_from", "mainEntrance");
        ((HashMap)localObject).put("source_to", "activefeed");
        azri.a(BaseApplicationImpl.getContext()).a(this.this$0.a.getAccount(), "actQZSourceDataReport", true, 0L, 0L, (HashMap)localObject, null);
      }
      if ((this.this$0.a.a() == null) || (!this.this$0.a.a().a())) {
        break label308;
      }
    }
    for (;;)
    {
      adtj.a(localazbw, false, bool);
      if ((Leba.b(this.this$0) != null) && (Leba.b(this.this$0).getVisibility() == 0))
      {
        localazbw.c(3);
        localazbw.c(61);
        localazbw.c(6);
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
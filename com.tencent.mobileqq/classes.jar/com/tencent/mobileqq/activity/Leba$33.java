package com.tencent.mobileqq.activity;

import aezt;
import android.widget.TextView;
import anov;
import arcs;
import bccv;
import bctj;
import blrv;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadRegulator;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.report.lp.LinkReport;
import java.util.HashMap;

class Leba$33
  implements Runnable
{
  Leba$33(Leba paramLeba, arcs paramarcs) {}
  
  public void run()
  {
    boolean bool = true;
    if ((Leba.a(this.this$0) != null) && (Leba.a(this.this$0).getVisibility() == 0)) {}
    try
    {
      this.this$0.a(null, true, this.a);
      ThreadRegulator.a().a(4);
      ThreadRegulator.a().a(4, 2000L);
      Leba.d(this.this$0, true);
      bccv localbccv = (bccv)this.this$0.a.getManager(10);
      if (localbccv != null)
      {
        if ((localbccv.a(1) <= 0) && (localbccv.a(2) <= 0))
        {
          Object localObject = new blrv();
          ((blrv)localObject).c = "1";
          ((blrv)localObject).d = "0";
          ((blrv)localObject).b = 4;
          ((blrv)localObject).l = "3";
          ((blrv)localObject).m = "mainEntrance";
          ((blrv)localObject).n = "activefeed";
          QZoneClickReport.report(this.this$0.a.getAccount(), (blrv)localObject, false);
          localObject = new HashMap();
          ((HashMap)localObject).put("source_type", "3");
          ((HashMap)localObject).put("source_from", "mainEntrance");
          ((HashMap)localObject).put("source_to", "activefeed");
          bctj.a(BaseApplicationImpl.getContext()).a(this.this$0.a.getAccount(), "actQZSourceDataReport", true, 0L, 0L, (HashMap)localObject, null);
        }
        if ((this.this$0.a.a() == null) || (!this.this$0.a.a().a())) {
          break label321;
        }
        aezt.a(localbccv, false, bool);
        if ((Leba.b(this.this$0) != null) && (Leba.b(this.this$0).getVisibility() == 0))
        {
          localbccv.c(3);
          localbccv.c(61);
          localbccv.c(6);
        }
      }
      LinkReport.reportClickQZoneEntry(this.this$0.a.c());
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.i("Leba", 1, "clickAction", localException);
        continue;
        label321:
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Leba.33
 * JD-Core Version:    0.7.0.1
 */
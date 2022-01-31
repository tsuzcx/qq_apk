package com.tencent.mobileqq.activity;

import abai;
import abnm;
import amnq;
import android.widget.TextView;
import awcz;
import awrn;
import bfpl;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadRegulator;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.report.lp.LinkReport;
import java.util.HashMap;

public class Leba$33
  implements Runnable
{
  public Leba$33(abai paramabai, amnq paramamnq) {}
  
  public void run()
  {
    if ((abai.a(this.this$0) != null) && (abai.a(this.this$0).getVisibility() == 0)) {}
    this.this$0.b(null, -1, this.a);
    ThreadRegulator.a().a(4);
    ThreadRegulator.a().a(4, 2000L);
    abai.d(this.this$0, true);
    awcz localawcz = (awcz)this.this$0.a.getManager(10);
    if (localawcz != null)
    {
      if ((localawcz.a(1) <= 0) && (localawcz.a(2) <= 0))
      {
        Object localObject = new bfpl();
        ((bfpl)localObject).c = "1";
        ((bfpl)localObject).d = "0";
        ((bfpl)localObject).b = 4;
        ((bfpl)localObject).l = "3";
        ((bfpl)localObject).m = "mainEntrance";
        ((bfpl)localObject).n = "activefeed";
        QZoneClickReport.report(this.this$0.a.getAccount(), (bfpl)localObject, false);
        localObject = new HashMap();
        ((HashMap)localObject).put("source_type", "3");
        ((HashMap)localObject).put("source_from", "mainEntrance");
        ((HashMap)localObject).put("source_to", "activefeed");
        awrn.a(BaseApplicationImpl.getContext()).a(this.this$0.a.getAccount(), "actQZSourceDataReport", true, 0L, 0L, (HashMap)localObject, null);
      }
      abnm.a(localawcz, false);
      if ((abai.b(this.this$0) != null) && (abai.b(this.this$0).getVisibility() == 0))
      {
        localawcz.c(3);
        localawcz.c(61);
        localawcz.c(6);
      }
    }
    LinkReport.reportClickQZoneEntry(this.this$0.a.c());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Leba.33
 * JD-Core Version:    0.7.0.1
 */
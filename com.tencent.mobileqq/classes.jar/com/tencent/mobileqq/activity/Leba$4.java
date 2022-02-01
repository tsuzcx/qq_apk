package com.tencent.mobileqq.activity;

import aebs;
import ajek;
import amux;
import aqmf;
import aufo;
import bboh;
import bbox;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.ReportInfo;
import cooperation.qzone.QZoneHelper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import nmq;
import nru;
import xwa;

class Leba$4
  implements Runnable
{
  Leba$4(Leba paramLeba) {}
  
  public void run()
  {
    Object localObject = ajek.a().a(this.this$0.a);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        aqmf localaqmf = (aqmf)((Iterator)localObject).next();
        if ((localaqmf != null) && (localaqmf.a.uiResId == nru.a)) {
          xwa.a("dynamic", "exp_story", 0, ((nmq)this.this$0.a.getManager(70)).c(), new String[0]);
        }
      }
    }
    Leba.a(this.this$0).a();
    QZoneHelper.preloadQzone(this.this$0.a, "Leba");
    Leba.a(this.this$0);
    localObject = (bbox)this.this$0.a.getManager(10);
    boolean bool;
    if (localObject != null)
    {
      if ((this.this$0.a.getLebaHelper() != null) && (this.this$0.a.getLebaHelper().a()))
      {
        bool = true;
        aebs.a((bbox)localObject, true, bool);
        if (((bbox)localObject).a(1) <= 0) {
          break label467;
        }
        localObject = new QZoneClickReport.ReportInfo();
        ((QZoneClickReport.ReportInfo)localObject).actionType = "1";
        ((QZoneClickReport.ReportInfo)localObject).subactionType = "5";
        QZoneClickReport.report(this.this$0.a.getAccount(), (QZoneClickReport.ReportInfo)localObject, false);
        localObject = new HashMap();
        ((HashMap)localObject).put("unread_type", "5");
        StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(this.this$0.a.getAccount(), "actQZUnreadDataReport", true, 0L, 0L, (HashMap)localObject, null);
      }
    }
    else {
      label268:
      if (System.currentTimeMillis() - LocalMultiProcConfig.getLong(BaseApplicationImpl.getContext().getString(2131717793) + this.this$0.a.getAccount(), 0L) > 86400000L)
      {
        localObject = new HashMap();
        if (!LocalMultiProcConfig.getBool(BaseApplicationImpl.getContext().getString(2131717792) + this.this$0.a.getAccount(), true)) {
          break label556;
        }
        ((HashMap)localObject).put("myfeednotifypush", "0");
        label375:
        if (!bboh.a(BaseApplicationImpl.getContext(), "com.qzone")) {
          break label568;
        }
        ((HashMap)localObject).put("qzoneinstalled", "0");
      }
    }
    for (;;)
    {
      StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(this.this$0.a.getAccount(), "qzonepushstate", true, 0L, 0L, (HashMap)localObject, null);
      LocalMultiProcConfig.putLong(BaseApplicationImpl.getContext().getString(2131717793) + this.this$0.a.getAccount(), System.currentTimeMillis());
      return;
      bool = false;
      break;
      label467:
      if (((bbox)localObject).a(2) <= 0) {
        break label268;
      }
      localObject = new QZoneClickReport.ReportInfo();
      ((QZoneClickReport.ReportInfo)localObject).actionType = "1";
      ((QZoneClickReport.ReportInfo)localObject).subactionType = "6";
      QZoneClickReport.report(this.this$0.a.getAccount(), (QZoneClickReport.ReportInfo)localObject, false);
      localObject = new HashMap();
      ((HashMap)localObject).put("unread_type", "6");
      StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(this.this$0.a.getAccount(), "actQZUnreadDataReport", true, 0L, 0L, (HashMap)localObject, null);
      break label268;
      label556:
      ((HashMap)localObject).put("myfeednotifypush", "1");
      break label375;
      label568:
      ((HashMap)localObject).put("qzoneinstalled", "1");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Leba.4
 * JD-Core Version:    0.7.0.1
 */
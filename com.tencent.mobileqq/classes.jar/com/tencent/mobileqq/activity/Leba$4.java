package com.tencent.mobileqq.activity;

import aesx;
import ajzy;
import anxl;
import arpq;
import avli;
import bcvb;
import bcvr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
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
import ntq;
import nyv;
import ykv;

class Leba$4
  implements Runnable
{
  Leba$4(Leba paramLeba) {}
  
  public void run()
  {
    Object localObject = ajzy.a().a(this.this$0.a);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        arpq localarpq = (arpq)((Iterator)localObject).next();
        if ((localarpq != null) && (localarpq.a.uiResId == nyv.a)) {
          ykv.a("dynamic", "exp_story", 0, ((ntq)this.this$0.a.getManager(QQManagerFactory.MGR_RED_TOUCH_EX)).c(), new String[0]);
        }
      }
    }
    Leba.a(this.this$0).a();
    QZoneHelper.preloadQzone(this.this$0.a, "Leba");
    Leba.a(this.this$0);
    localObject = (bcvr)this.this$0.a.getManager(QQManagerFactory.QZONE_MANAGER);
    boolean bool;
    if (localObject != null)
    {
      if ((this.this$0.a.getLebaHelper() != null) && (this.this$0.a.getLebaHelper().a()))
      {
        bool = true;
        aesx.a((bcvr)localObject, true, bool);
        if (((bcvr)localObject).a(1) <= 0) {
          break label469;
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
      label270:
      if (System.currentTimeMillis() - LocalMultiProcConfig.getLong(BaseApplicationImpl.getContext().getString(2131718175) + this.this$0.a.getAccount(), 0L) > 86400000L)
      {
        localObject = new HashMap();
        if (!LocalMultiProcConfig.getBool(BaseApplicationImpl.getContext().getString(2131718174) + this.this$0.a.getAccount(), true)) {
          break label558;
        }
        ((HashMap)localObject).put("myfeednotifypush", "0");
        label377:
        if (!bcvb.a(BaseApplicationImpl.getContext(), "com.qzone")) {
          break label570;
        }
        ((HashMap)localObject).put("qzoneinstalled", "0");
      }
    }
    for (;;)
    {
      StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(this.this$0.a.getAccount(), "qzonepushstate", true, 0L, 0L, (HashMap)localObject, null);
      LocalMultiProcConfig.putLong(BaseApplicationImpl.getContext().getString(2131718175) + this.this$0.a.getAccount(), System.currentTimeMillis());
      return;
      bool = false;
      break;
      label469:
      if (((bcvr)localObject).a(2) <= 0) {
        break label270;
      }
      localObject = new QZoneClickReport.ReportInfo();
      ((QZoneClickReport.ReportInfo)localObject).actionType = "1";
      ((QZoneClickReport.ReportInfo)localObject).subactionType = "6";
      QZoneClickReport.report(this.this$0.a.getAccount(), (QZoneClickReport.ReportInfo)localObject, false);
      localObject = new HashMap();
      ((HashMap)localObject).put("unread_type", "6");
      StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(this.this$0.a.getAccount(), "actQZUnreadDataReport", true, 0L, 0L, (HashMap)localObject, null);
      break label270;
      label558:
      ((HashMap)localObject).put("myfeednotifypush", "1");
      break label377;
      label570:
      ((HashMap)localObject).put("qzoneinstalled", "1");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Leba.4
 * JD-Core Version:    0.7.0.1
 */
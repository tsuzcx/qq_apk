package com.tencent.mobileqq.activity;

import adtj;
import aieq;
import alvp;
import aozs;
import astc;
import azbg;
import azbw;
import azri;
import bjdn;
import bjdt;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneClickReport;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import nan;
import nga;
import wxj;

class Leba$4
  implements Runnable
{
  Leba$4(Leba paramLeba) {}
  
  public void run()
  {
    Object localObject = aieq.a().a(this.this$0.a);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        aozs localaozs = (aozs)((Iterator)localObject).next();
        if ((localaozs != null) && (localaozs.a.uiResId == nga.a)) {
          wxj.a("dynamic", "exp_story", 0, ((nan)this.this$0.a.getManager(70)).c(), new String[0]);
        }
      }
    }
    Leba.a(this.this$0).a();
    bjdt.a(this.this$0.a, "Leba");
    Leba.a(this.this$0);
    localObject = (azbw)this.this$0.a.getManager(10);
    boolean bool;
    if (localObject != null)
    {
      if ((this.this$0.a.a() != null) && (this.this$0.a.a().a()))
      {
        bool = true;
        adtj.a((azbw)localObject, true, bool);
        if (((azbw)localObject).a(1) <= 0) {
          break label467;
        }
        localObject = new bjdn();
        ((bjdn)localObject).c = "1";
        ((bjdn)localObject).d = "5";
        QZoneClickReport.report(this.this$0.a.getAccount(), (bjdn)localObject, false);
        localObject = new HashMap();
        ((HashMap)localObject).put("unread_type", "5");
        azri.a(BaseApplicationImpl.getContext()).a(this.this$0.a.getAccount(), "actQZUnreadDataReport", true, 0L, 0L, (HashMap)localObject, null);
      }
    }
    else {
      label268:
      if (System.currentTimeMillis() - LocalMultiProcConfig.getLong(BaseApplicationImpl.getContext().getString(2131719347) + this.this$0.a.getAccount(), 0L) > 86400000L)
      {
        localObject = new HashMap();
        if (!LocalMultiProcConfig.getBool(BaseApplicationImpl.getContext().getString(2131719346) + this.this$0.a.getAccount(), true)) {
          break label556;
        }
        ((HashMap)localObject).put("myfeednotifypush", "0");
        label375:
        if (!azbg.a(BaseApplicationImpl.getContext(), "com.qzone")) {
          break label568;
        }
        ((HashMap)localObject).put("qzoneinstalled", "0");
      }
    }
    for (;;)
    {
      azri.a(BaseApplicationImpl.getContext()).a(this.this$0.a.getAccount(), "qzonepushstate", true, 0L, 0L, (HashMap)localObject, null);
      LocalMultiProcConfig.putLong(BaseApplicationImpl.getContext().getString(2131719347) + this.this$0.a.getAccount(), System.currentTimeMillis());
      return;
      bool = false;
      break;
      label467:
      if (((azbw)localObject).a(2) <= 0) {
        break label268;
      }
      localObject = new bjdn();
      ((bjdn)localObject).c = "1";
      ((bjdn)localObject).d = "6";
      QZoneClickReport.report(this.this$0.a.getAccount(), (bjdn)localObject, false);
      localObject = new HashMap();
      ((HashMap)localObject).put("unread_type", "6");
      azri.a(BaseApplicationImpl.getContext()).a(this.this$0.a.getAccount(), "actQZUnreadDataReport", true, 0L, 0L, (HashMap)localObject, null);
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
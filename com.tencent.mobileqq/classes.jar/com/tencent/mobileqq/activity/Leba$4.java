package com.tencent.mobileqq.activity;

import abai;
import abnm;
import afqa;
import amnq;
import aqeb;
import awcj;
import awcz;
import awrn;
import bfpl;
import bfpr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneClickReport;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mmy;
import msg;
import urp;

public class Leba$4
  implements Runnable
{
  public Leba$4(abai paramabai) {}
  
  public void run()
  {
    Object localObject = afqa.a().a(this.this$0.a);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        amnq localamnq = (amnq)((Iterator)localObject).next();
        if ((localamnq != null) && (localamnq.a.uiResId == msg.a)) {
          urp.a("dynamic", "exp_story", 0, ((mmy)this.this$0.a.getManager(70)).c(), new String[0]);
        }
      }
    }
    abai.a(this.this$0).a();
    bfpr.a(this.this$0.a, "Leba");
    abai.a(this.this$0);
    localObject = (awcz)this.this$0.a.getManager(10);
    if (localObject != null)
    {
      abnm.a((awcz)localObject, true);
      if (((awcz)localObject).a(1) > 0)
      {
        localObject = new bfpl();
        ((bfpl)localObject).c = "1";
        ((bfpl)localObject).d = "5";
        QZoneClickReport.report(this.this$0.a.getAccount(), (bfpl)localObject, false);
        localObject = new HashMap();
        ((HashMap)localObject).put("unread_type", "5");
        awrn.a(BaseApplicationImpl.getContext()).a(this.this$0.a.getAccount(), "actQZUnreadDataReport", true, 0L, 0L, (HashMap)localObject, null);
      }
    }
    else if (System.currentTimeMillis() - LocalMultiProcConfig.getLong(BaseApplicationImpl.getContext().getString(2131653021) + this.this$0.a.getAccount(), 0L) > 86400000L)
    {
      localObject = new HashMap();
      if (!LocalMultiProcConfig.getBool(BaseApplicationImpl.getContext().getString(2131653020) + this.this$0.a.getAccount(), true)) {
        break label519;
      }
      ((HashMap)localObject).put("myfeednotifypush", "0");
      label343:
      if (!awcj.a(BaseApplicationImpl.getContext(), "com.qzone")) {
        break label531;
      }
      ((HashMap)localObject).put("qzoneinstalled", "0");
    }
    for (;;)
    {
      awrn.a(BaseApplicationImpl.getContext()).a(this.this$0.a.getAccount(), "qzonepushstate", true, 0L, 0L, (HashMap)localObject, null);
      LocalMultiProcConfig.putLong(BaseApplicationImpl.getContext().getString(2131653021) + this.this$0.a.getAccount(), System.currentTimeMillis());
      return;
      if (((awcz)localObject).a(2) <= 0) {
        break;
      }
      localObject = new bfpl();
      ((bfpl)localObject).c = "1";
      ((bfpl)localObject).d = "6";
      QZoneClickReport.report(this.this$0.a.getAccount(), (bfpl)localObject, false);
      localObject = new HashMap();
      ((HashMap)localObject).put("unread_type", "6");
      awrn.a(BaseApplicationImpl.getContext()).a(this.this$0.a.getAccount(), "actQZUnreadDataReport", true, 0L, 0L, (HashMap)localObject, null);
      break;
      label519:
      ((HashMap)localObject).put("myfeednotifypush", "1");
      break label343;
      label531:
      ((HashMap)localObject).put("qzoneinstalled", "1");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Leba.4
 * JD-Core Version:    0.7.0.1
 */
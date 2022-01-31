package com.tencent.mobileqq.app.automator.step;

import amhw;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import apmq;
import beae;
import beag;
import beaj;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import ntw;

public class EcShopFirstRunMsgConfigs
  extends AsyncStep
{
  public int a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "EcShopFirstRunMsgConfigs start in addEcShopAssistToRUFirstTime...");
    }
    ((ntw)this.a.app.getManager(88)).c();
    amhw localamhw = new amhw(this);
    List localList1 = Arrays.asList(new String[] { "http://imgcache.qq.com/zzapp/qqshop/stat/qqshp_client_log_wl_conf.json", "http://imgcache.qq.com/zzapp/qqshop/stat/qqshp_client_log_jd_conf.json" });
    List localList2 = Arrays.asList(new String[] { ntw.e, ntw.f });
    List localList3 = Arrays.asList(new String[] { "last_modified_report_json", "last_modified_behaviors_json" });
    int i = 0;
    if (i < localList1.size())
    {
      Object localObject2 = (String)localList1.get(i);
      String str = (String)localList2.get(i);
      Object localObject1 = (String)localList3.get(i);
      if ((TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty(str)) || (TextUtils.isEmpty((CharSequence)localObject1))) {}
      for (;;)
      {
        i += 1;
        break;
        beaj localbeaj = ((beag)this.a.app.getManager(47)).a(1);
        if (localbeaj != null)
        {
          Object localObject3 = apmq.a("VIP_shop_assit_cfg", (String)localObject2);
          if (localbeaj.a((String)localObject3) == null)
          {
            localObject2 = new File(str);
            localObject3 = new beae((String)localObject3, (File)localObject2);
            if (((File)localObject2).exists())
            {
              long l = ((File)localObject2).lastModified();
              ((beae)localObject3).i = this.a.app.getApp().getSharedPreferences("ecshop_sp", 0).getLong((String)localObject1, 0L);
              if (Long.valueOf(l).longValue() != ((beae)localObject3).i) {
                ((beae)localObject3).m = true;
              }
            }
            ((beae)localObject3).j = true;
            ((beae)localObject3).p = false;
            localObject1 = new Bundle();
            ((Bundle)localObject1).putString("path", str);
            localbeaj.a((beae)localObject3, localamhw, (Bundle)localObject1);
          }
        }
      }
    }
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.EcShopFirstRunMsgConfigs
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import aoig;
import asdi;
import bhyo;
import bhyq;
import bhyt;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import onq;

public class EcShopFirstRunMsgConfigs
  extends AsyncStep
{
  public int a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "EcShopFirstRunMsgConfigs start in addEcShopAssistToRUFirstTime...");
    }
    ((onq)this.a.app.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER)).c();
    aoig localaoig = new aoig(this);
    List localList1 = Arrays.asList(new String[] { "https://imgcache.qq.com/zzapp/qqshop/stat/qqshp_client_log_wl_conf.json", "https://imgcache.qq.com/zzapp/qqshop/stat/qqshp_client_log_jd_conf.json" });
    List localList2 = Arrays.asList(new String[] { onq.e, onq.f });
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
        bhyt localbhyt = ((bhyq)this.a.app.getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(1);
        if (localbhyt != null)
        {
          Object localObject3 = asdi.a("VIP_shop_assit_cfg", (String)localObject2);
          if (localbhyt.a((String)localObject3) == null)
          {
            localObject2 = new File(str);
            localObject3 = new bhyo((String)localObject3, (File)localObject2);
            if (((File)localObject2).exists())
            {
              long l = ((File)localObject2).lastModified();
              ((bhyo)localObject3).i = this.a.app.getApp().getSharedPreferences("ecshop_sp", 0).getLong((String)localObject1, 0L);
              if (Long.valueOf(l).longValue() != ((bhyo)localObject3).i) {
                ((bhyo)localObject3).m = true;
              }
            }
            ((bhyo)localObject3).j = true;
            ((bhyo)localObject3).p = false;
            localObject1 = new Bundle();
            ((Bundle)localObject1).putString("path", str);
            localbhyt.a((bhyo)localObject3, localaoig, (Bundle)localObject1);
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
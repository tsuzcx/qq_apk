package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import zqn;

public class EcShopFirstRunMsgConfigs
  extends AsyncStep
{
  protected int a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "EcShopFirstRunMsgConfigs start in addEcShopAssistToRUFirstTime...");
    }
    ((EcShopAssistantManager)this.a.b.getManager(87)).c();
    zqn localzqn = new zqn(this);
    List localList1 = Arrays.asList(new String[] { "http://imgcache.qq.com/zzapp/qqshop/stat/qqshp_client_log_wl_conf.json", "http://imgcache.qq.com/zzapp/qqshop/stat/qqshp_client_log_jd_conf.json" });
    List localList2 = Arrays.asList(new String[] { EcShopAssistantManager.e, EcShopAssistantManager.f });
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
        DownloaderInterface localDownloaderInterface = ((DownloaderFactory)this.a.b.getManager(46)).a(1);
        if (localDownloaderInterface != null)
        {
          Object localObject3 = EmosmUtils.a("VIP_shop_assit_cfg", (String)localObject2);
          if (localDownloaderInterface.a((String)localObject3) == null)
          {
            localObject2 = new File(str);
            localObject3 = new DownloadTask((String)localObject3, (File)localObject2);
            if (((File)localObject2).exists())
            {
              long l = ((File)localObject2).lastModified();
              ((DownloadTask)localObject3).i = this.a.b.getApp().getSharedPreferences("ecshop_sp", 0).getLong((String)localObject1, 0L);
              if (Long.valueOf(l).longValue() != ((DownloadTask)localObject3).i) {
                ((DownloadTask)localObject3).k = true;
              }
            }
            ((DownloadTask)localObject3).h = true;
            ((DownloadTask)localObject3).n = false;
            localObject1 = new Bundle();
            ((Bundle)localObject1).putString("path", str);
            localDownloaderInterface.a((DownloadTask)localObject3, localzqn, (Bundle)localObject1);
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
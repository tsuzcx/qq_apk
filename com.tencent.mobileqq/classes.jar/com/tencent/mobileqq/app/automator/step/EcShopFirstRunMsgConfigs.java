package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
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

public class EcShopFirstRunMsgConfigs
  extends AsyncStep
{
  protected int doStep()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "EcShopFirstRunMsgConfigs start in addEcShopAssistToRUFirstTime...");
    }
    ((EcShopAssistantManager)this.mAutomator.a.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER)).c();
    EcShopFirstRunMsgConfigs.1 local1 = new EcShopFirstRunMsgConfigs.1(this);
    List localList1 = Arrays.asList(new String[] { "https://imgcache.qq.com/zzapp/qqshop/stat/qqshp_client_log_wl_conf.json", "https://imgcache.qq.com/zzapp/qqshop/stat/qqshp_client_log_jd_conf.json" });
    List localList2 = Arrays.asList(new String[] { EcShopAssistantManager.e, EcShopAssistantManager.f });
    List localList3 = Arrays.asList(new String[] { "last_modified_report_json", "last_modified_behaviors_json" });
    int i = 0;
    while (i < localList1.size())
    {
      Object localObject2 = (String)localList1.get(i);
      String str = (String)localList2.get(i);
      Object localObject1 = (String)localList3.get(i);
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject1)))
      {
        DownloaderInterface localDownloaderInterface = ((DownloaderFactory)this.mAutomator.a.getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(1);
        if (localDownloaderInterface != null)
        {
          Object localObject3 = EmosmUtils.a("VIP_shop_assit_cfg", (String)localObject2);
          if (localDownloaderInterface.getTask((String)localObject3) == null)
          {
            localObject2 = new File(str);
            localObject3 = new DownloadTask((String)localObject3, (File)localObject2);
            if (((File)localObject2).exists())
            {
              long l = ((File)localObject2).lastModified();
              ((DownloadTask)localObject3).i = this.mAutomator.a.getApp().getSharedPreferences("ecshop_sp", 0).getLong((String)localObject1, 0L);
              if (Long.valueOf(l).longValue() != ((DownloadTask)localObject3).i) {
                ((DownloadTask)localObject3).m = true;
              }
            }
            ((DownloadTask)localObject3).j = true;
            ((DownloadTask)localObject3).p = false;
            localObject1 = new Bundle();
            ((Bundle)localObject1).putString("path", str);
            localDownloaderInterface.startDownload((DownloadTask)localObject3, local1, (Bundle)localObject1);
          }
        }
      }
      i += 1;
    }
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.EcShopFirstRunMsgConfigs
 * JD-Core Version:    0.7.0.1
 */
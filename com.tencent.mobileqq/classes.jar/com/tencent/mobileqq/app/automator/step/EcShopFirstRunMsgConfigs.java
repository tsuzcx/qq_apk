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
    ((EcShopAssistantManager)this.mAutomator.k.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER)).e();
    EcShopFirstRunMsgConfigs.1 local1 = new EcShopFirstRunMsgConfigs.1(this);
    List localList1 = Arrays.asList(new String[] { "https://imgcache.qq.com/zzapp/qqshop/stat/qqshp_client_log_wl_conf.json", "https://imgcache.qq.com/zzapp/qqshop/stat/qqshp_client_log_jd_conf.json" });
    List localList2 = Arrays.asList(new String[] { EcShopAssistantManager.m, EcShopAssistantManager.n });
    List localList3 = Arrays.asList(new String[] { "last_modified_report_json", "last_modified_behaviors_json" });
    int i = 0;
    while (i < localList1.size())
    {
      Object localObject2 = (String)localList1.get(i);
      String str = (String)localList2.get(i);
      Object localObject1 = (String)localList3.get(i);
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject1)))
      {
        DownloaderInterface localDownloaderInterface = ((DownloaderFactory)this.mAutomator.k.getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(1);
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
              ((DownloadTask)localObject3).I = this.mAutomator.k.getApp().getSharedPreferences("ecshop_sp", 0).getLong((String)localObject1, 0L);
              if (Long.valueOf(l).longValue() != ((DownloadTask)localObject3).I) {
                ((DownloadTask)localObject3).G = true;
              }
            }
            ((DownloadTask)localObject3).D = true;
            ((DownloadTask)localObject3).N = false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.EcShopFirstRunMsgConfigs
 * JD-Core Version:    0.7.0.1
 */
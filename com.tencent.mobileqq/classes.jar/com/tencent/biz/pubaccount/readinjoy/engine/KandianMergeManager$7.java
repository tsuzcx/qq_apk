package com.tencent.biz.pubaccount.readinjoy.engine;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAppSetting;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.push.RIJKanDianFolderStatus;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ReadInJoyGlobalReporter;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.AdMiniGameGuideManager;
import com.tencent.mobileqq.mini.notify.MiniAppNotify.IMiniAppNotifyListener;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.List;

class KandianMergeManager$7
  implements MiniAppNotify.IMiniAppNotifyListener
{
  KandianMergeManager$7(KandianMergeManager paramKandianMergeManager) {}
  
  public void onNotify(String paramString1, int paramInt, String paramString2, String paramString3, long paramLong)
  {
    QLog.d("KandianMergeManager", 1, "appid: " + paramString1 + " scene: " + paramInt + " via: " + paramString2 + " event: " + paramString3 + " timestamp: " + paramLong);
    List localList1 = Arrays.asList(Aladdin.getConfig(329).getString("scene", "").split("\\|"));
    List localList2 = Arrays.asList(Aladdin.getConfig(329).getString("via", "").split("\\|"));
    QLog.d("KandianMergeManager", 1, "miniapp config: " + localList1 + " " + localList2);
    if ("onResume".equals(paramString3))
    {
      if ((localList1 != null) && (localList1.contains(paramInt + "")) && (localList2 != null) && (localList2.contains(paramString2)))
      {
        paramInt = RIJAppSetting.a();
        i = RIJKanDianFolderStatus.a;
        KandianMergeManager.a(this.a).a(KandianMergeManager.a(this.a), NetConnInfoCenter.getServerTimeMillis(), paramInt, i);
      }
      AdMiniGameGuideManager.a.a(Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
    }
    while (!"onPause".equals(paramString3))
    {
      int i;
      return;
    }
    if ((localList1 != null) && (localList1.contains(paramInt + "")) && (localList2 != null) && (localList2.contains(paramString2)) && (KandianMergeManager.a(this.a).a() > 0L)) {
      KandianMergeManager.a(this.a).a();
    }
    AdMiniGameGuideManager.a.b(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.7
 * JD-Core Version:    0.7.0.1
 */
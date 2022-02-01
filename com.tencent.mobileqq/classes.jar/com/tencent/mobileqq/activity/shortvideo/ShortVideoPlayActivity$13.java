package com.tencent.mobileqq.activity.shortvideo;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import mqq.os.MqqHandler;

class ShortVideoPlayActivity$13
  implements TVK_SDKMgr.InstallListener
{
  ShortVideoPlayActivity$13(ShortVideoPlayActivity paramShortVideoPlayActivity) {}
  
  public void onInstallProgress(float paramFloat) {}
  
  public void onInstalledFailed(int paramInt)
  {
    ShortVideoPlayActivity.access$1302(this.a, false);
    ShortVideoPlayActivity.access$1402(this.a, System.currentTimeMillis() - ShortVideoPlayActivity.access$1500(this.a));
    Object localObject = this.a;
    ((ShortVideoPlayActivity)localObject).showErrorDlg(((ShortVideoPlayActivity)localObject).mContext.getResources().getString(2131895510));
    ShortVideoPlayActivity.access$1602(this.a, 3000);
    ShortVideoPlayActivity.access$1702(this.a, paramInt);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onInstalledFailed:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("ShortVideoPlayActivity", 2, ((StringBuilder)localObject).toString());
    }
    localObject = new HashMap();
    ((HashMap)localObject).put("param_entrance", "ShortVideoPlayActivity");
    ((HashMap)localObject).put("param_erroCode", String.valueOf(paramInt));
    ((HashMap)localObject).put("param_result", "0");
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actInstallTVK", false, 0L, 0L, (HashMap)localObject, "");
  }
  
  public void onInstalledSuccessed()
  {
    ShortVideoPlayActivity.access$1302(this.a, true);
    ShortVideoPlayActivity.access$1402(this.a, System.currentTimeMillis() - ShortVideoPlayActivity.access$1500(this.a));
    if (this.a.mHandler.get() != null) {
      ((MqqHandler)this.a.mHandler.get()).post(new ShortVideoPlayActivity.13.1(this));
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_entrance", "ShortVideoPlayActivity");
    localHashMap.put("param_erroCode", "0");
    localHashMap.put("param_result", "1");
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actInstallTVK", true, 0L, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity.13
 * JD-Core Version:    0.7.0.1
 */
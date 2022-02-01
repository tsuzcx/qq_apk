package com.tencent.comic;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.DcReportUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

class VipComicHelper$1$1
  implements AsyncBack
{
  VipComicHelper$1$1(VipComicHelper.1 param1) {}
  
  public void loaded(String paramString, int paramInt)
  {
    paramString = (AppRuntime)this.a.a.get();
    if (paramString == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Finish update offline pkg. code = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", entry = ");
      ((StringBuilder)localObject).append(this.a.b);
      QLog.d("ComicHelper", 2, ((StringBuilder)localObject).toString());
    }
    int j = 0;
    int i;
    if ((paramInt != 1) && (paramInt != 2) && (paramInt != 3) && (paramInt != 4) && (paramInt != 6)) {
      i = 0;
    } else {
      i = 1;
    }
    Object localObject = paramString.getApplication().getSharedPreferences("vip_comic_file", 4);
    int k = ((SharedPreferences)localObject).getInt("totalOfflinePkgDownloadCount", 0);
    if (i != 0) {
      j = k + 1;
    }
    if (j != k) {
      ((SharedPreferences)localObject).edit().putInt("totalOfflinePkgDownloadCount", j).apply();
    }
    if (i != 0)
    {
      long l = NetConnInfoCenter.getServerTime();
      localObject = new StringBuilder();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt);
      localStringBuilder.append("|");
      ((StringBuilder)localObject).append(localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(j);
      localStringBuilder.append("|");
      ((StringBuilder)localObject).append(localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(l);
      localStringBuilder.append("|");
      ((StringBuilder)localObject).append(localStringBuilder.toString());
      ((StringBuilder)localObject).append("|||||");
      DcReportUtil.a(paramString, "sendtdbank|b_sng_qqvip_qqcomic|offlinePkgDownload", ((StringBuilder)localObject).toString(), true);
    }
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.comic.VipComicHelper.1.1
 * JD-Core Version:    0.7.0.1
 */
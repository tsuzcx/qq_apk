package com.tencent.biz.common.offline;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import com.tencent.biz.common.offline.util.IThreadManager;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.webviewplugin.OfflinePlugin;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;

class BidDownloader$1
  implements AsyncBack
{
  BidDownloader$1(BidDownloader paramBidDownloader, long paramLong) {}
  
  public void loaded(String paramString, int paramInt)
  {
    int j = (int)(System.currentTimeMillis() - this.a);
    if ((HtmlOffline.g != null) && (HtmlOffline.g.containsKey(this.b.b))) {
      HtmlOffline.g.remove(this.b.b);
    }
    this.b.o.sendEmptyMessage(0);
    boolean bool = true;
    if (paramInt == 0)
    {
      OfflinePlugin.h(this.b.b);
      if (this.b.e)
      {
        if (!HtmlOffline.a(this.b.b))
        {
          Util.b(this.b.k);
          paramString = new StringBuilder();
          paramString.append(OfflineEnvHelper.b(this.b.b));
          paramString.append(this.b.b);
          Util.a(paramString.toString());
          paramString = this.b.o.obtainMessage(2, 10, j);
          this.b.o.sendMessage(paramString);
          HtmlOffline.a(this.b.b, 14, 0L, NetworkUtil.getNetWorkType(), "lixian_update", "0");
          OfflinePlugin.a(this.b.b, "Offline_Update_BSDiff", j, 14, "", "", "");
          BidDownloader.a(0, this.b.b, 14, 0, "lixian_update", 0);
        }
      }
      else if (((this.b.g) || (this.b.h)) && (!this.b.e()))
      {
        paramString = BidDownloader.s;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("businessId ");
        localStringBuilder.append(this.b.b);
        localStringBuilder.append(" now un compress file error! ");
        localStringBuilder.append(this.b.k);
        QLog.e(paramString, 1, localStringBuilder.toString());
        return;
      }
      if (2 == this.b.c)
      {
        bool = HtmlOffline.b(this.b.b);
        paramString = this.b.o.obtainMessage(2, -1, j);
        this.b.o.sendMessage(paramString);
      }
      else
      {
        if (this.b.d) {
          bool = HtmlOffline.b(this.b.b);
        }
        paramString = this.b.o.obtainMessage(2, 0, j);
        this.b.o.sendMessage(paramString);
      }
      if (this.b.e)
      {
        OfflinePlugin.a(this.b.b, "Offline_Update_BSDiff", j, 0, "", "", "");
      }
      else
      {
        paramString = this.b.b;
        if (bool) {
          i = 0;
        } else {
          i = 13;
        }
        OfflinePlugin.a(paramString, "Offline_Update", j, i, "", "", "");
      }
      BaseApplication.getContext().getSharedPreferences("bid_update_success_time", 4).edit().putLong(this.b.b, System.currentTimeMillis()).commit();
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("success update bid: ");
        paramString.append(this.b.b);
        QLog.i("OfflinePluginQQ", 2, paramString.toString());
      }
      paramString = this.b.b;
      l = j;
      i = NetworkUtil.getNetWorkType();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.b.p);
      localStringBuilder.append("");
      HtmlOffline.a(paramString, paramInt, l, i, "lixian_update", localStringBuilder.toString());
      BidDownloader.a(j, this.b.b, paramInt, this.b.p, "lixian_update", 0);
      return;
    }
    paramString = this.b;
    paramString.j += 1;
    if (this.b.j < 3)
    {
      BidDownloader.q.c(new BidDownloader.1.1(this));
      return;
    }
    paramString = this.b.o.obtainMessage(2, 2, j);
    this.b.o.sendMessage(paramString);
    paramString = this.b.b;
    long l = j;
    int i = NetworkUtil.getNetWorkType();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.b.p);
    localStringBuilder.append("");
    HtmlOffline.a(paramString, paramInt, l, i, "lixian_update", localStringBuilder.toString());
    OfflinePlugin.a(this.b.b, "Offline_Update", j, paramInt, "", "", "");
    BidDownloader.a(j, this.b.b, paramInt, this.b.p, "lixian_update", 0);
  }
  
  public void progress(int paramInt)
  {
    if (this.b.a.get() != null) {
      ((AsyncBack)this.b.a.get()).progress(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.common.offline.BidDownloader.1
 * JD-Core Version:    0.7.0.1
 */
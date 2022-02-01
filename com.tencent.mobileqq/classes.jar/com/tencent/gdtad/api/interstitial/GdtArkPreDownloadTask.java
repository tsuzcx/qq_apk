package com.tencent.gdtad.api.interstitial;

import android.text.TextUtils;
import com.tencent.ad.tangram.analysis.AdUin;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.ark.open.ArkAppMgr.IGetAppPathByNameCallback;
import com.tencent.gdtad.log.GdtLog;
import java.lang.ref.WeakReference;

final class GdtArkPreDownloadTask
{
  private WeakReference<GdtArkPreDownloadTask.Listener> a;
  private GdtArkApp b;
  private long c = -2147483648L;
  private volatile int d = 0;
  private boolean e = false;
  private ArkAppMgr.IGetAppPathByNameCallback f = new GdtArkPreDownloadTask.6(this);
  
  public GdtArkPreDownloadTask(WeakReference<GdtArkPreDownloadTask.Listener> paramWeakReference, GdtArkApp paramGdtArkApp, long paramLong)
  {
    this.a = paramWeakReference;
    this.b = paramGdtArkApp;
    this.c = paramLong;
    b();
  }
  
  private void a(int paramInt)
  {
    AdThreadManager.INSTANCE.post(new GdtArkPreDownloadTask.4(this, paramInt), 0);
  }
  
  private void a(int paramInt1, int paramInt2, long paramLong)
  {
    AdThreadManager.INSTANCE.postDelayed(new GdtArkPreDownloadTask.3(this, paramInt1, paramInt2), 0, paramLong);
  }
  
  private static boolean a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0)
    {
      if ((paramInt2 == 1) || (paramInt2 == 1)) {
        return true;
      }
    }
    else if (paramInt1 == 1)
    {
      if ((paramInt2 == 2) || (paramInt2 == 3)) {
        return true;
      }
    }
    else if ((paramInt1 == 2) && ((paramInt2 == 3) || (paramInt2 == 4))) {
      return true;
    }
    GdtLog.d("GdtArkPreDownloadTask", String.format("checkStatus result:false oldStatus:%d newStatus:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    return false;
  }
  
  private void b()
  {
    AdThreadManager.INSTANCE.post(new GdtArkPreDownloadTask.1(this), 4);
  }
  
  private void b(int paramInt)
  {
    int i = this.d;
    if (i != paramInt)
    {
      if (i != paramInt) {}
      try
      {
        if (a(i, paramInt))
        {
          this.d = paramInt;
          a(paramInt);
        }
        else
        {
          a(1, -2147483648, 0L);
        }
      }
      finally {}
    }
    GdtLog.b("GdtArkPreDownloadTask", String.format("setStatus oldStatus:%d newStatus:%d result:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), Integer.valueOf(this.d) }));
  }
  
  private boolean c()
  {
    GdtArkApp localGdtArkApp = this.b;
    return (localGdtArkApp != null) && (localGdtArkApp.a()) && (!TextUtils.isEmpty(AdUin.INSTANCE.getUIN()));
  }
  
  private void d()
  {
    AdThreadManager.INSTANCE.post(new GdtArkPreDownloadTask.2(this), 0);
  }
  
  private String e()
  {
    String str;
    if (c()) {
      str = ArkAppMgr.getInstance().getAppPathFromLocal(this.b.a);
    } else {
      str = null;
    }
    GdtLog.b("GdtArkPreDownloadTask", String.format("getPath %s", new Object[] { str }));
    return str;
  }
  
  private void f()
  {
    AdThreadManager.INSTANCE.post(new GdtArkPreDownloadTask.5(this), 4);
  }
  
  public int a()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtArkPreDownloadTask
 * JD-Core Version:    0.7.0.1
 */
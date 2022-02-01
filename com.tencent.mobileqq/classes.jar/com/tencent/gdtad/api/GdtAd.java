package com.tencent.gdtad.api;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.gdtad.aditem.GdtAdLoader;
import com.tencent.gdtad.aditem.GdtAdLoader.Listener;
import com.tencent.gdtad.aditem.GdtAdLoader.Session;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.log.GdtLog;
import java.io.Serializable;
import java.lang.ref.WeakReference;

public abstract class GdtAd
  implements IGdtAd, Serializable
{
  private static int a = 0;
  private static long b = -2147483648L;
  private WeakReference<GdtAdListener> listener;
  private GdtAdLoader.Listener loadListener = new GdtAd.6(this);
  private long loadedTimeMillis = -2147483648L;
  private GdtAdLoader loader;
  private int status = 0;
  
  public GdtAd(GdtAdParams paramGdtAdParams)
  {
    if (paramGdtAdParams == null)
    {
      GdtLog.d("GdtAd", "constructor");
      return;
    }
    GdtAdLoader.Session localSession = new GdtAdLoader.Session();
    localSession.a = paramGdtAdParams.a;
    this.loader = new GdtAdLoader(localSession, new WeakReference(this.loadListener));
  }
  
  private void a()
  {
    WeakReference localWeakReference = new WeakReference(this);
    new Handler().post(new GdtAd.2(this, localWeakReference));
  }
  
  private void a(GdtAdError paramGdtAdError)
  {
    WeakReference localWeakReference = new WeakReference(this);
    new Handler().post(new GdtAd.1(this, localWeakReference, paramGdtAdError));
  }
  
  public com.tencent.gdtad.aditem.GdtAd getAd()
  {
    if (isLoaded()) {
      return getParams().b.a;
    }
    return null;
  }
  
  protected int getErrorCode(com.tencent.gdtad.aditem.GdtAd paramGdtAd, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == -2147483648) {
      return 3;
    }
    int i = 6;
    if (paramInt1 != 200) {
      return 6;
    }
    if (paramInt2 != 0)
    {
      if (paramInt2 == 1) {
        i = 4;
      }
      return i;
    }
    if (paramInt3 != 0)
    {
      if (paramInt3 == 102006) {
        i = 5;
      }
      return i;
    }
    if (paramGdtAd == null) {
      return 1;
    }
    if (!paramGdtAd.isValid()) {
      return 1;
    }
    return 0;
  }
  
  public GdtAdLoader getGdtAdLoader()
  {
    return this.loader;
  }
  
  protected abstract GdtAdParams getParams();
  
  protected void init()
  {
    if (getParams() == null) {
      return;
    }
    if (getParams().b == null) {
      return;
    }
    if (getParams().b.a == null) {
      return;
    }
    if (!getParams().b.a.isValid()) {
      return;
    }
    this.status = 2;
    this.loadedTimeMillis = System.currentTimeMillis();
  }
  
  public boolean isInvalidated()
  {
    return (isLoaded()) && (SystemClock.elapsedRealtime() - this.loadedTimeMillis > 86400000L);
  }
  
  public boolean isLoaded()
  {
    return (isValid()) && (this.status == 2) && (getParams().b.a != null) && (getParams().b.a.isValid()) && (this.loadedTimeMillis != -9223372036854775808L);
  }
  
  protected boolean isValid()
  {
    return (getParams() != null) && (getParams().a());
  }
  
  public boolean load(Context paramContext)
  {
    if ((paramContext != null) && (isValid()) && (getParams().a != null))
    {
      int i = this.status;
      if ((i == 0) || (i == 3))
      {
        if ((b != -2147483648L) && (SystemClock.elapsedRealtime() - b <= 60000L))
        {
          if (a >= 30)
          {
            this.status = 3;
            a(new GdtAdError(2));
            break label136;
          }
        }
        else
        {
          a = 0;
          b = SystemClock.elapsedRealtime();
        }
        this.status = 1;
        a += 1;
        this.loader.a(new WeakReference(paramContext));
        return true;
      }
    }
    label136:
    GdtLog.d("GdtAd", String.format("load error, status:%d", new Object[] { Integer.valueOf(this.status) }));
    return false;
  }
  
  protected void notifyClicked()
  {
    WeakReference localWeakReference = new WeakReference(this);
    new Handler().post(new GdtAd.4(this, localWeakReference));
  }
  
  protected void notifyClosed()
  {
    WeakReference localWeakReference = new WeakReference(this);
    AdThreadManager.INSTANCE.post(new GdtAd.5(this, localWeakReference), 0);
  }
  
  protected void notifyImpression()
  {
    WeakReference localWeakReference = new WeakReference(this);
    new Handler().post(new GdtAd.3(this, localWeakReference));
  }
  
  public void setListener(WeakReference<GdtAdListener> paramWeakReference)
  {
    this.listener = paramWeakReference;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.api.GdtAd
 * JD-Core Version:    0.7.0.1
 */
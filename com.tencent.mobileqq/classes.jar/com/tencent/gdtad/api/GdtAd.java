package com.tencent.gdtad.api;

import acaf;
import acag;
import acah;
import acao;
import acap;
import acaq;
import acar;
import acho;
import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import java.io.Serializable;
import java.lang.ref.WeakReference;

public abstract class GdtAd
  implements Serializable
{
  private static int jdField_a_of_type_Int;
  private static long jdField_a_of_type_Long = -2147483648L;
  private WeakReference<acaq> listener;
  private acag loadListener = new acao(this);
  private long loadedTimeMillis = -2147483648L;
  private acaf loader;
  private int status = 0;
  
  public GdtAd(acar paramacar)
  {
    if (paramacar == null)
    {
      acho.d("GdtAd", "constructor");
      return;
    }
    acah localacah = new acah();
    localacah.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet = paramacar.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet;
    this.loader = new acaf(localacah, new WeakReference(this.loadListener));
  }
  
  private void a()
  {
    WeakReference localWeakReference = new WeakReference(this);
    new Handler().post(new GdtAd.2(this, localWeakReference));
  }
  
  private void a(acap paramacap)
  {
    WeakReference localWeakReference = new WeakReference(this);
    new Handler().post(new GdtAd.1(this, localWeakReference, paramacap));
  }
  
  public com.tencent.gdtad.aditem.GdtAd getAd()
  {
    if (isLoaded()) {
      return getParams().jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.a;
    }
    return null;
  }
  
  public int getErrorCode(com.tencent.gdtad.aditem.GdtAd paramGdtAd, int paramInt1, int paramInt2, int paramInt3)
  {
    int j = 6;
    int i;
    if (paramInt1 == -2147483648) {
      i = 3;
    }
    do
    {
      do
      {
        do
        {
          return i;
          i = j;
        } while (paramInt1 != 200);
        if (paramInt2 == 0) {
          break;
        }
        i = j;
      } while (paramInt2 != 1);
      return 4;
      if (paramInt3 == 0) {
        break;
      }
      i = j;
    } while (paramInt3 != 102006);
    return 5;
    if (paramGdtAd == null) {
      return 1;
    }
    if (!paramGdtAd.isValid()) {
      return 1;
    }
    return 0;
  }
  
  public acaf getGdtAdLoader()
  {
    return this.loader;
  }
  
  public abstract acar getParams();
  
  protected void init()
  {
    if (getParams() == null) {}
    while ((getParams().jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params == null) || (getParams().jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.a == null) || (!getParams().jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.a.isValid())) {
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
    return (isValid()) && (this.status == 2) && (getParams().jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.a != null) && (getParams().jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.a.isValid()) && (this.loadedTimeMillis != -9223372036854775808L);
  }
  
  public boolean isValid()
  {
    return (getParams() != null) && (getParams().a());
  }
  
  public boolean load(Context paramContext)
  {
    if (paramContext == null) {}
    for (;;)
    {
      acho.d("GdtAd", String.format("load error, status:%d", new Object[] { Integer.valueOf(this.status) }));
      return false;
      if ((isValid()) && (getParams().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet != null) && ((this.status == 0) || (this.status == 3)))
      {
        if ((jdField_a_of_type_Long == -2147483648L) || (SystemClock.elapsedRealtime() - jdField_a_of_type_Long > 60000L)) {
          break;
        }
        if (jdField_a_of_type_Int < 30) {
          break label124;
        }
        this.status = 3;
        a(new acap(2));
      }
    }
    jdField_a_of_type_Int = 0;
    jdField_a_of_type_Long = SystemClock.elapsedRealtime();
    label124:
    this.status = 1;
    jdField_a_of_type_Int += 1;
    this.loader.a(new WeakReference(paramContext));
    return true;
  }
  
  public void notifyClicked()
  {
    WeakReference localWeakReference = new WeakReference(this);
    new Handler().post(new GdtAd.4(this, localWeakReference));
  }
  
  public void notifyClosed()
  {
    WeakReference localWeakReference = new WeakReference(this);
    AdThreadManager.INSTANCE.post(new GdtAd.5(this, localWeakReference), 0);
  }
  
  protected void notifyImpression()
  {
    WeakReference localWeakReference = new WeakReference(this);
    new Handler().post(new GdtAd.3(this, localWeakReference));
  }
  
  public void setListener(WeakReference<acaq> paramWeakReference)
  {
    this.listener = paramWeakReference;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.GdtAd
 * JD-Core Version:    0.7.0.1
 */
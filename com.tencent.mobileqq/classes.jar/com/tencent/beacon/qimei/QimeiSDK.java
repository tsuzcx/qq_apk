package com.tencent.beacon.qimei;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class QimeiSDK
  implements com.tencent.beacon.a.a.d
{
  public static final String TAG = "[Qimei]";
  private static volatile QimeiSDK instance;
  private String appKey;
  private String beaconId = "";
  private Context mContext;
  private String oaID = "";
  private String omgID = "";
  private final List<IAsyncQimeiListener> qimeiListeners = Collections.synchronizedList(new ArrayList(3));
  
  public static QimeiSDK getInstance()
  {
    if (instance == null) {
      try
      {
        if (instance == null) {
          instance = new QimeiSDK();
        }
      }
      finally {}
    }
    return instance;
  }
  
  private boolean isInit()
  {
    try
    {
      Context localContext = this.mContext;
      if (localContext != null) {
        return true;
      }
      com.tencent.beacon.base.util.c.d("[qimei] QimeiSdk not init", new Object[0]);
      return false;
    }
    finally {}
  }
  
  private boolean isUpdateQimei()
  {
    Qimei localQimei = getQimei();
    boolean bool = true;
    if (localQimei != null)
    {
      if (localQimei.isEmpty()) {
        return true;
      }
      if ((!f.c()) && (!f.a()))
      {
        if (!f.b())
        {
          if (com.tencent.beacon.a.c.b.h()) {
            return true;
          }
          bool = false;
        }
        return bool;
      }
      com.tencent.beacon.base.util.c.d("[qimei] isQIMEIReqZeroPeak or Qimei disable", new Object[0]);
      return false;
    }
    return true;
  }
  
  public String getAppKey()
  {
    try
    {
      String str = this.appKey;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  @Deprecated
  public String getBeaconIdInfo()
  {
    try
    {
      if (TextUtils.isEmpty(this.beaconId)) {
        this.beaconId = com.tencent.beacon.b.a.a(Build.VERSION.SDK_INT);
      }
      String str = this.beaconId;
      return str;
    }
    finally {}
  }
  
  public Context getContext()
  {
    try
    {
      Context localContext = this.mContext;
      return localContext;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  @Deprecated
  public String getOAID()
  {
    return "";
  }
  
  public String getOmgID()
  {
    return this.omgID;
  }
  
  public Qimei getQimei()
  {
    if (com.tencent.beacon.a.c.c.d().c() == null) {
      return null;
    }
    return a.a().b();
  }
  
  public void getQimei(IAsyncQimeiListener paramIAsyncQimeiListener)
  {
    try
    {
      com.tencent.beacon.a.b.a.a().a(new d(this, paramIAsyncQimeiListener));
      return;
    }
    finally
    {
      paramIAsyncQimeiListener = finally;
      throw paramIAsyncQimeiListener;
    }
  }
  
  @Deprecated
  public String getQimeiInternal()
  {
    try
    {
      if (!isInit()) {
        return "";
      }
      Object localObject1 = a.a().b();
      if (!TextUtils.isEmpty(((Qimei)localObject1).getQimeiOld()))
      {
        localObject1 = ((Qimei)localObject1).getQimeiOld();
        return localObject1;
      }
      return "";
    }
    finally {}
  }
  
  public QimeiSDK init(Context paramContext)
  {
    try
    {
      if (!isInit())
      {
        com.tencent.beacon.base.util.c.a("[Qimei]", "QimeiSDK init!", new Object[0]);
        this.mContext = paramContext;
        com.tencent.beacon.a.a.b.a().a(1, this);
        boolean bool = isUpdateQimei();
        com.tencent.beacon.base.util.c.a("[Qimei]", "isUpdate Qimei: %s", new Object[] { Boolean.valueOf(bool) });
        if (bool) {
          com.tencent.beacon.a.b.a.a().a(new c(paramContext));
        }
      }
      return this;
    }
    finally {}
  }
  
  public void logQimeiCallbackError(Throwable paramThrowable)
  {
    com.tencent.beacon.base.util.c.b("[qimei] onQimeiDispatch error!", new Object[] { paramThrowable.getMessage() });
    com.tencent.beacon.base.util.c.a(paramThrowable);
    com.tencent.beacon.a.b.d.b().a("514", "QimeiDispatch error", paramThrowable);
  }
  
  @WorkerThread
  public void onEvent(com.tencent.beacon.a.a.c arg1)
  {
    if (???.a == 1) {
      synchronized (this.qimeiListeners)
      {
        Qimei localQimei = a.a().b();
        if ((localQimei != null) && (localQimei.isEmpty())) {
          return;
        }
        Iterator localIterator = this.qimeiListeners.iterator();
        while (localIterator.hasNext())
        {
          IAsyncQimeiListener localIAsyncQimeiListener = (IAsyncQimeiListener)localIterator.next();
          try
          {
            localIAsyncQimeiListener.onQimeiDispatch(localQimei);
          }
          catch (Throwable localThrowable)
          {
            logQimeiCallbackError(localThrowable);
          }
        }
        this.qimeiListeners.clear();
        return;
      }
    }
  }
  
  public QimeiSDK setAppKey(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.appKey = paramString;
    }
    return this;
  }
  
  public QimeiSDK setLogAble(boolean paramBoolean)
  {
    try
    {
      com.tencent.beacon.base.util.c.a(paramBoolean);
      com.tencent.beacon.base.util.c.b(paramBoolean);
      return this;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  @Deprecated
  public void setOAID(String paramString) {}
  
  public QimeiSDK setOmgId(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.omgID = paramString;
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.qimei.QimeiSDK
 * JD-Core Version:    0.7.0.1
 */
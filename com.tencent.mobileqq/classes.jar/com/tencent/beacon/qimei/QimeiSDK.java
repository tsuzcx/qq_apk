package com.tencent.beacon.qimei;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.beacon.core.BeaconIdJNI;
import com.tencent.beacon.core.d.h;

public class QimeiSDK
{
  private static volatile QimeiSDK instance;
  private String beaconId = "";
  private Context mContext;
  private b qimeiModule;
  
  public static QimeiSDK getInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new QimeiSDK();
      }
      return instance;
    }
    finally {}
  }
  
  private boolean isInit(Context paramContext)
  {
    boolean bool = true;
    if (paramContext == null) {}
    for (;;)
    {
      try
      {
        com.tencent.beacon.core.d.b.d("[qimei] init context is null!", new Object[0]);
        return bool;
      }
      finally {}
      if (this.mContext != null) {
        com.tencent.beacon.core.d.b.a("[qimei] QimeiSdk has been initialized", new Object[0]);
      } else {
        bool = false;
      }
    }
  }
  
  public String getAppKey()
  {
    try
    {
      String str = com.tencent.beacon.core.b.b.a(this.mContext).b();
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  @Deprecated
  public String getBeaconIdInfo(Context paramContext)
  {
    try
    {
      if (h.a(this.beaconId)) {
        this.beaconId = BeaconIdJNI.a(paramContext, Build.VERSION.SDK_INT);
      }
      paramContext = this.beaconId;
      return paramContext;
    }
    finally {}
  }
  
  public void getQimei(IAsyncQimeiListener paramIAsyncQimeiListener)
  {
    for (;;)
    {
      try
      {
        String str = getQimeiInternal();
        if (!h.a(str))
        {
          paramIAsyncQimeiListener.onQimeiDispatch(str);
          return;
        }
        if (this.qimeiModule == null)
        {
          com.tencent.beacon.core.d.b.d("[qimei] QimeiModule is null, QimeiSDK has not initialized !", new Object[0]);
          paramIAsyncQimeiListener.onQimeiDispatch("");
        }
        else
        {
          this.qimeiModule.a(paramIAsyncQimeiListener);
        }
      }
      finally {}
    }
  }
  
  /* Error */
  @Deprecated
  public String getQimeiInternal()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 86	com/tencent/beacon/qimei/QimeiSDK:qimeiModule	Lcom/tencent/beacon/qimei/b;
    //   6: ifnull +24 -> 30
    //   9: aload_0
    //   10: getfield 86	com/tencent/beacon/qimei/QimeiSDK:qimeiModule	Lcom/tencent/beacon/qimei/b;
    //   13: invokevirtual 95	com/tencent/beacon/qimei/b:c	()Ljava/lang/String;
    //   16: astore_2
    //   17: aload_2
    //   18: invokestatic 61	com/tencent/beacon/core/d/h:a	(Ljava/lang/String;)Z
    //   21: istore_1
    //   22: iload_1
    //   23: ifne +7 -> 30
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_2
    //   29: areturn
    //   30: aload_0
    //   31: getfield 38	com/tencent/beacon/qimei/QimeiSDK:mContext	Landroid/content/Context;
    //   34: ifnull +14 -> 48
    //   37: aload_0
    //   38: getfield 38	com/tencent/beacon/qimei/QimeiSDK:mContext	Landroid/content/Context;
    //   41: invokestatic 99	com/tencent/beacon/qimei/d:a	(Landroid/content/Context;)Ljava/lang/String;
    //   44: astore_2
    //   45: goto -19 -> 26
    //   48: ldc 18
    //   50: astore_2
    //   51: goto -25 -> 26
    //   54: astore_2
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_2
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	QimeiSDK
    //   21	2	1	bool	boolean
    //   16	35	2	str	String
    //   54	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	22	54	finally
    //   30	45	54	finally
  }
  
  public QimeiSDK init(Context paramContext)
  {
    try
    {
      if (!isInit(paramContext))
      {
        this.mContext = paramContext;
        b.a(this.mContext).a();
      }
      return this;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public QimeiSDK setAppKey(String paramString)
  {
    if (!h.a(paramString)) {
      com.tencent.beacon.core.b.b.a = paramString;
    }
    return this;
  }
  
  public QimeiSDK setLogAble(boolean paramBoolean)
  {
    try
    {
      com.tencent.beacon.core.d.b.a = paramBoolean;
      com.tencent.beacon.core.d.b.c = paramBoolean;
      return this;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public QimeiSDK setOmgId(String paramString)
  {
    if (!h.a(paramString)) {
      com.tencent.beacon.core.b.c.a = paramString;
    }
    return this;
  }
  
  protected void setQimeiModule(b paramb)
  {
    this.qimeiModule = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.beacon.qimei.QimeiSDK
 * JD-Core Version:    0.7.0.1
 */
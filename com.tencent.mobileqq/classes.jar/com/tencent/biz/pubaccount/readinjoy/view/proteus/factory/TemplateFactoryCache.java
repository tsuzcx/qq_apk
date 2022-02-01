package com.tencent.biz.pubaccount.readinjoy.view.proteus.factory;

import bmhv;
import com.tencent.commonsdk.cache.QQHashMap;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import tmk;
import tml;
import tmm;

public class TemplateFactoryCache
  extends QQHashMap<String, tmm>
{
  private volatile tmk mStyleConfigHelper = new tmk();
  
  public TemplateFactoryCache()
  {
    super(2018, 10, 230000);
  }
  
  public void clear()
  {
    try
    {
      super.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void clearMemory()
  {
    if (!bmhv.s()) {
      clear();
    }
  }
  
  public tmm get(String paramString)
  {
    try
    {
      paramString = (tmm)super.get(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public tmh getAutoCreate(android.content.Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_2
    //   4: invokevirtual 42	com/tencent/biz/pubaccount/readinjoy/view/proteus/factory/TemplateFactoryCache:get	(Ljava/lang/String;)Ltmm;
    //   7: astore 5
    //   9: aload 5
    //   11: ifnull +83 -> 94
    //   14: aload 5
    //   16: getfield 46	tmm:a	Ltmh;
    //   19: ifnull +75 -> 94
    //   22: aload_0
    //   23: getfield 19	com/tencent/biz/pubaccount/readinjoy/view/proteus/factory/TemplateFactoryCache:mStyleConfigHelper	Ltmk;
    //   26: aload_1
    //   27: aload_2
    //   28: invokevirtual 49	tmk:a	(Landroid/content/Context;Ljava/lang/String;)Ltmm;
    //   31: invokevirtual 52	tmm:a	()Ljava/lang/String;
    //   34: invokestatic 57	tmz:a	(Ljava/lang/String;)Ltmh;
    //   37: astore_1
    //   38: aload_1
    //   39: ifnull +46 -> 85
    //   42: aload 5
    //   44: getfield 46	tmm:a	Ltmh;
    //   47: invokevirtual 60	tmh:a	()Ljava/lang/String;
    //   50: aload_1
    //   51: invokevirtual 60	tmh:a	()Ljava/lang/String;
    //   54: invokevirtual 66	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   57: ifeq +28 -> 85
    //   60: aload 5
    //   62: getfield 46	tmm:a	Ltmh;
    //   65: invokevirtual 70	tmh:getTemplateId	()I
    //   68: istore_3
    //   69: aload_1
    //   70: invokevirtual 70	tmh:getTemplateId	()I
    //   73: istore 4
    //   75: iload_3
    //   76: iload 4
    //   78: if_icmpeq +7 -> 85
    //   81: aload_0
    //   82: monitorexit
    //   83: aload_1
    //   84: areturn
    //   85: aload 5
    //   87: getfield 46	tmm:a	Ltmh;
    //   90: astore_1
    //   91: goto -10 -> 81
    //   94: aload_0
    //   95: getfield 19	com/tencent/biz/pubaccount/readinjoy/view/proteus/factory/TemplateFactoryCache:mStyleConfigHelper	Ltmk;
    //   98: aload_1
    //   99: aload_2
    //   100: invokevirtual 49	tmk:a	(Landroid/content/Context;Ljava/lang/String;)Ltmm;
    //   103: astore_1
    //   104: aload_1
    //   105: ifnull +33 -> 138
    //   108: aload_1
    //   109: getfield 46	tmm:a	Ltmh;
    //   112: ifnull +26 -> 138
    //   115: aload_1
    //   116: getfield 46	tmm:a	Ltmh;
    //   119: aload_2
    //   120: invokevirtual 74	tmh:b	(Ljava/lang/String;)V
    //   123: aload_0
    //   124: aload_2
    //   125: aload_1
    //   126: invokevirtual 78	com/tencent/biz/pubaccount/readinjoy/view/proteus/factory/TemplateFactoryCache:put	(Ljava/lang/String;Ltmm;)Ltmm;
    //   129: pop
    //   130: aload_1
    //   131: getfield 46	tmm:a	Ltmh;
    //   134: astore_1
    //   135: goto -54 -> 81
    //   138: aconst_null
    //   139: astore_1
    //   140: goto -59 -> 81
    //   143: astore_1
    //   144: aload_0
    //   145: monitorexit
    //   146: aload_1
    //   147: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	148	0	this	TemplateFactoryCache
    //   0	148	1	paramContext	android.content.Context
    //   0	148	2	paramString	String
    //   68	11	3	i	int
    //   73	6	4	j	int
    //   7	79	5	localtmm	tmm
    // Exception table:
    //   from	to	target	type
    //   2	9	143	finally
    //   14	38	143	finally
    //   42	75	143	finally
    //   85	91	143	finally
    //   94	104	143	finally
    //   108	135	143	finally
  }
  
  public tmm put(String paramString, tmm paramtmm)
  {
    try
    {
      paramString = (tmm)super.put(paramString, paramtmm);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public tmm remove(String paramString)
  {
    try
    {
      paramString = (tmm)super.remove(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void reset()
  {
    Object localObject1 = this.mStyleConfigHelper;
    tmk localtmk = new tmk();
    Object localObject2 = ((tmk)localObject1).a();
    localObject1 = new ArrayList();
    localObject2 = ((Map)localObject2).entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
      if (!((tml)localEntry.getValue()).equals(localtmk.a((String)localEntry.getKey()))) {
        ((List)localObject1).add(localEntry.getKey());
      }
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      remove((String)((Iterator)localObject1).next());
    }
    QLog.d("TemplateFactory", 2, "reset: " + localtmk);
    this.mStyleConfigHelper = localtmk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.TemplateFactoryCache
 * JD-Core Version:    0.7.0.1
 */
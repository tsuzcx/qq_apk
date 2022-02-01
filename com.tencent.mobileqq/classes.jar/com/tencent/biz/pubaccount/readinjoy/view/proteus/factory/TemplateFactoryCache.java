package com.tencent.biz.pubaccount.readinjoy.view.proteus.factory;

import bkwm;
import com.tencent.commonsdk.cache.QQHashMap;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import szc;
import szd;
import sze;

public class TemplateFactoryCache
  extends QQHashMap<String, sze>
{
  private volatile szc mStyleConfigHelper = new szc();
  
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
    if (!bkwm.p()) {
      clear();
    }
  }
  
  public sze get(String paramString)
  {
    try
    {
      paramString = (sze)super.get(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public syz getAutoCreate(android.content.Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_2
    //   4: invokevirtual 42	com/tencent/biz/pubaccount/readinjoy/view/proteus/factory/TemplateFactoryCache:get	(Ljava/lang/String;)Lsze;
    //   7: astore 5
    //   9: aload 5
    //   11: ifnull +83 -> 94
    //   14: aload 5
    //   16: getfield 46	sze:a	Lsyz;
    //   19: ifnull +75 -> 94
    //   22: aload_0
    //   23: getfield 19	com/tencent/biz/pubaccount/readinjoy/view/proteus/factory/TemplateFactoryCache:mStyleConfigHelper	Lszc;
    //   26: aload_1
    //   27: aload_2
    //   28: invokevirtual 49	szc:a	(Landroid/content/Context;Ljava/lang/String;)Lsze;
    //   31: invokevirtual 52	sze:a	()Ljava/lang/String;
    //   34: invokestatic 57	szr:a	(Ljava/lang/String;)Lsyz;
    //   37: astore_1
    //   38: aload_1
    //   39: ifnull +46 -> 85
    //   42: aload 5
    //   44: getfield 46	sze:a	Lsyz;
    //   47: invokevirtual 60	syz:a	()Ljava/lang/String;
    //   50: aload_1
    //   51: invokevirtual 60	syz:a	()Ljava/lang/String;
    //   54: invokevirtual 66	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   57: ifeq +28 -> 85
    //   60: aload 5
    //   62: getfield 46	sze:a	Lsyz;
    //   65: invokevirtual 70	syz:getTemplateId	()I
    //   68: istore_3
    //   69: aload_1
    //   70: invokevirtual 70	syz:getTemplateId	()I
    //   73: istore 4
    //   75: iload_3
    //   76: iload 4
    //   78: if_icmpeq +7 -> 85
    //   81: aload_0
    //   82: monitorexit
    //   83: aload_1
    //   84: areturn
    //   85: aload 5
    //   87: getfield 46	sze:a	Lsyz;
    //   90: astore_1
    //   91: goto -10 -> 81
    //   94: aload_0
    //   95: getfield 19	com/tencent/biz/pubaccount/readinjoy/view/proteus/factory/TemplateFactoryCache:mStyleConfigHelper	Lszc;
    //   98: aload_1
    //   99: aload_2
    //   100: invokevirtual 49	szc:a	(Landroid/content/Context;Ljava/lang/String;)Lsze;
    //   103: astore_1
    //   104: aload_1
    //   105: ifnull +33 -> 138
    //   108: aload_1
    //   109: getfield 46	sze:a	Lsyz;
    //   112: ifnull +26 -> 138
    //   115: aload_1
    //   116: getfield 46	sze:a	Lsyz;
    //   119: aload_2
    //   120: invokevirtual 74	syz:b	(Ljava/lang/String;)V
    //   123: aload_0
    //   124: aload_2
    //   125: aload_1
    //   126: invokevirtual 78	com/tencent/biz/pubaccount/readinjoy/view/proteus/factory/TemplateFactoryCache:put	(Ljava/lang/String;Lsze;)Lsze;
    //   129: pop
    //   130: aload_1
    //   131: getfield 46	sze:a	Lsyz;
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
    //   7	79	5	localsze	sze
    // Exception table:
    //   from	to	target	type
    //   2	9	143	finally
    //   14	38	143	finally
    //   42	75	143	finally
    //   85	91	143	finally
    //   94	104	143	finally
    //   108	135	143	finally
  }
  
  public sze put(String paramString, sze paramsze)
  {
    try
    {
      paramString = (sze)super.put(paramString, paramsze);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public sze remove(String paramString)
  {
    try
    {
      paramString = (sze)super.remove(paramString);
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
    szc localszc = new szc();
    Object localObject2 = ((szc)localObject1).a();
    localObject1 = new ArrayList();
    localObject2 = ((Map)localObject2).entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
      if (!((szd)localEntry.getValue()).equals(localszc.a((String)localEntry.getKey()))) {
        ((List)localObject1).add(localEntry.getKey());
      }
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      remove((String)((Iterator)localObject1).next());
    }
    QLog.d("TemplateFactory", 2, "reset: " + localszc);
    this.mStyleConfigHelper = localszc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.TemplateFactoryCache
 * JD-Core Version:    0.7.0.1
 */
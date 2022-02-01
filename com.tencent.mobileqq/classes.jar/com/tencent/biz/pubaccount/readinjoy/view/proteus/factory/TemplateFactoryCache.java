package com.tencent.biz.pubaccount.readinjoy.view.proteus.factory;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.loaders.StyleConfigHelper;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.loaders.StyleConfigHelper.Config;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.loaders.StyleConfigHelper.TemplateFactoryWrapper;
import com.tencent.commonsdk.cache.QQHashMap;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TemplateFactoryCache
  extends QQHashMap<String, StyleConfigHelper.TemplateFactoryWrapper>
{
  private volatile StyleConfigHelper mStyleConfigHelper = new StyleConfigHelper();
  
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
    if (!ReadInJoyHelper.t()) {
      clear();
    }
  }
  
  public StyleConfigHelper.TemplateFactoryWrapper get(String paramString)
  {
    try
    {
      paramString = (StyleConfigHelper.TemplateFactoryWrapper)super.get(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public TemplateFactory getAutoCreate(android.content.Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_2
    //   4: invokevirtual 42	com/tencent/biz/pubaccount/readinjoy/view/proteus/factory/TemplateFactoryCache:get	(Ljava/lang/String;)Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/loaders/StyleConfigHelper$TemplateFactoryWrapper;
    //   7: astore 5
    //   9: aload 5
    //   11: ifnull +83 -> 94
    //   14: aload 5
    //   16: getfield 46	com/tencent/biz/pubaccount/readinjoy/view/proteus/loaders/StyleConfigHelper$TemplateFactoryWrapper:a	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/factory/TemplateFactory;
    //   19: ifnull +75 -> 94
    //   22: aload_0
    //   23: getfield 19	com/tencent/biz/pubaccount/readinjoy/view/proteus/factory/TemplateFactoryCache:mStyleConfigHelper	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/loaders/StyleConfigHelper;
    //   26: aload_1
    //   27: aload_2
    //   28: invokevirtual 49	com/tencent/biz/pubaccount/readinjoy/view/proteus/loaders/StyleConfigHelper:a	(Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/loaders/StyleConfigHelper$TemplateFactoryWrapper;
    //   31: invokevirtual 52	com/tencent/biz/pubaccount/readinjoy/view/proteus/loaders/StyleConfigHelper$TemplateFactoryWrapper:a	()Ljava/lang/String;
    //   34: invokestatic 57	com/tencent/biz/pubaccount/readinjoy/view/proteus/utils/OfflineUtils:a	(Ljava/lang/String;)Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/factory/TemplateFactory;
    //   37: astore_1
    //   38: aload_1
    //   39: ifnull +46 -> 85
    //   42: aload 5
    //   44: getfield 46	com/tencent/biz/pubaccount/readinjoy/view/proteus/loaders/StyleConfigHelper$TemplateFactoryWrapper:a	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/factory/TemplateFactory;
    //   47: invokevirtual 60	com/tencent/biz/pubaccount/readinjoy/view/proteus/factory/TemplateFactory:a	()Ljava/lang/String;
    //   50: aload_1
    //   51: invokevirtual 60	com/tencent/biz/pubaccount/readinjoy/view/proteus/factory/TemplateFactory:a	()Ljava/lang/String;
    //   54: invokevirtual 66	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   57: ifeq +28 -> 85
    //   60: aload 5
    //   62: getfield 46	com/tencent/biz/pubaccount/readinjoy/view/proteus/loaders/StyleConfigHelper$TemplateFactoryWrapper:a	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/factory/TemplateFactory;
    //   65: invokevirtual 70	com/tencent/biz/pubaccount/readinjoy/view/proteus/factory/TemplateFactory:getTemplateId	()I
    //   68: istore_3
    //   69: aload_1
    //   70: invokevirtual 70	com/tencent/biz/pubaccount/readinjoy/view/proteus/factory/TemplateFactory:getTemplateId	()I
    //   73: istore 4
    //   75: iload_3
    //   76: iload 4
    //   78: if_icmpeq +7 -> 85
    //   81: aload_0
    //   82: monitorexit
    //   83: aload_1
    //   84: areturn
    //   85: aload 5
    //   87: getfield 46	com/tencent/biz/pubaccount/readinjoy/view/proteus/loaders/StyleConfigHelper$TemplateFactoryWrapper:a	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/factory/TemplateFactory;
    //   90: astore_1
    //   91: goto -10 -> 81
    //   94: aload_0
    //   95: getfield 19	com/tencent/biz/pubaccount/readinjoy/view/proteus/factory/TemplateFactoryCache:mStyleConfigHelper	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/loaders/StyleConfigHelper;
    //   98: aload_1
    //   99: aload_2
    //   100: invokevirtual 49	com/tencent/biz/pubaccount/readinjoy/view/proteus/loaders/StyleConfigHelper:a	(Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/loaders/StyleConfigHelper$TemplateFactoryWrapper;
    //   103: astore_1
    //   104: aload_1
    //   105: ifnull +33 -> 138
    //   108: aload_1
    //   109: getfield 46	com/tencent/biz/pubaccount/readinjoy/view/proteus/loaders/StyleConfigHelper$TemplateFactoryWrapper:a	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/factory/TemplateFactory;
    //   112: ifnull +26 -> 138
    //   115: aload_1
    //   116: getfield 46	com/tencent/biz/pubaccount/readinjoy/view/proteus/loaders/StyleConfigHelper$TemplateFactoryWrapper:a	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/factory/TemplateFactory;
    //   119: aload_2
    //   120: invokevirtual 74	com/tencent/biz/pubaccount/readinjoy/view/proteus/factory/TemplateFactory:b	(Ljava/lang/String;)V
    //   123: aload_0
    //   124: aload_2
    //   125: aload_1
    //   126: invokevirtual 78	com/tencent/biz/pubaccount/readinjoy/view/proteus/factory/TemplateFactoryCache:put	(Ljava/lang/String;Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/loaders/StyleConfigHelper$TemplateFactoryWrapper;)Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/loaders/StyleConfigHelper$TemplateFactoryWrapper;
    //   129: pop
    //   130: aload_1
    //   131: getfield 46	com/tencent/biz/pubaccount/readinjoy/view/proteus/loaders/StyleConfigHelper$TemplateFactoryWrapper:a	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/factory/TemplateFactory;
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
    //   7	79	5	localTemplateFactoryWrapper	StyleConfigHelper.TemplateFactoryWrapper
    // Exception table:
    //   from	to	target	type
    //   2	9	143	finally
    //   14	38	143	finally
    //   42	75	143	finally
    //   85	91	143	finally
    //   94	104	143	finally
    //   108	135	143	finally
  }
  
  public StyleConfigHelper.TemplateFactoryWrapper put(String paramString, StyleConfigHelper.TemplateFactoryWrapper paramTemplateFactoryWrapper)
  {
    try
    {
      paramString = (StyleConfigHelper.TemplateFactoryWrapper)super.put(paramString, paramTemplateFactoryWrapper);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public StyleConfigHelper.TemplateFactoryWrapper remove(String paramString)
  {
    try
    {
      paramString = (StyleConfigHelper.TemplateFactoryWrapper)super.remove(paramString);
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
    StyleConfigHelper localStyleConfigHelper = new StyleConfigHelper();
    Object localObject2 = ((StyleConfigHelper)localObject1).a();
    localObject1 = new ArrayList();
    localObject2 = ((Map)localObject2).entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
      if (!((StyleConfigHelper.Config)localEntry.getValue()).equals(localStyleConfigHelper.a((String)localEntry.getKey()))) {
        ((List)localObject1).add(localEntry.getKey());
      }
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      remove((String)((Iterator)localObject1).next());
    }
    QLog.d("TemplateFactory", 2, "reset: " + localStyleConfigHelper);
    this.mStyleConfigHelper = localStyleConfigHelper;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.TemplateFactoryCache
 * JD-Core Version:    0.7.0.1
 */
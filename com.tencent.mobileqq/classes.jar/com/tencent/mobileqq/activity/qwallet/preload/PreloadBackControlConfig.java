package com.tencent.mobileqq.activity.qwallet.preload;

import Wallet.ResInfo;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;

public class PreloadBackControlConfig
  implements Serializable
{
  public static final String CONFIG_NAME = "back_config";
  private static final long serialVersionUID = 1L;
  private transient AppRuntime a;
  private int mConfigVersion;
  private ArrayList mLastBackResInfos;
  
  public PreloadBackControlConfig(AppRuntime paramAppRuntime)
  {
    this.a = paramAppRuntime;
    this.mConfigVersion = 0;
  }
  
  public static String getConfigPath(AppRuntime paramAppRuntime)
  {
    return PreloadManager.b(paramAppRuntime) + "back_config";
  }
  
  public static PreloadBackControlConfig readBackControlConfig(AppRuntime paramAppRuntime)
  {
    try
    {
      PreloadBackControlConfig localPreloadBackControlConfig = (PreloadBackControlConfig)QWalletTools.a(getConfigPath(paramAppRuntime));
      if (localPreloadBackControlConfig == null)
      {
        localPreloadBackControlConfig = new PreloadBackControlConfig(paramAppRuntime);
        if (QLog.isColorLevel()) {
          QLog.d("BackControlConfig", 2, "readBackControlConfig:" + localPreloadBackControlConfig);
        }
        return localPreloadBackControlConfig;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject = null;
        continue;
        localObject.a = paramAppRuntime;
      }
    }
  }
  
  public ArrayList getLastBackResInfos()
  {
    try
    {
      ArrayList localArrayList1 = new ArrayList();
      if (this.mLastBackResInfos != null)
      {
        Iterator localIterator = this.mLastBackResInfos.iterator();
        while (localIterator.hasNext()) {
          localArrayList1.add((ResInfo)localIterator.next());
        }
      }
    }
    finally {}
    return localArrayList2;
  }
  
  public boolean isBackResInLocalAlready(ArrayList paramArrayList)
  {
    boolean bool = false;
    label246:
    for (;;)
    {
      try
      {
        int i = SharedPreUtils.X(this.a.getApplication(), this.a.getLongAccountUin() + "");
        int j = this.mConfigVersion;
        if (i != j) {
          return bool;
        }
        if ((this.mLastBackResInfos != null) && (this.mLastBackResInfos.size() != 0))
        {
          Iterator localIterator1 = this.mLastBackResInfos.iterator();
          j = 0;
          if (localIterator1.hasNext())
          {
            ResInfo localResInfo = (ResInfo)localIterator1.next();
            Iterator localIterator2 = paramArrayList.iterator();
            i = j;
            j = i;
            if (!localIterator2.hasNext()) {
              continue;
            }
            String str = (String)localIterator2.next();
            if (localResInfo.sResId.equals(str))
            {
              i += 1;
              break label246;
            }
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.d("BackControlConfig", 2, "isBackResInLocalAlready|" + j + "|" + this.mLastBackResInfos.size());
            }
            i = this.mLastBackResInfos.size();
            if (j == i)
            {
              bool = true;
              continue;
            }
            bool = false;
            continue;
          }
        }
      }
      finally {}
      bool = true;
    }
  }
  
  /* Error */
  public boolean isLocalResNewest()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 27	com/tencent/mobileqq/activity/qwallet/preload/PreloadBackControlConfig:a	Lmqq/app/AppRuntime;
    //   6: invokevirtual 112	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   9: new 34	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   16: aload_0
    //   17: getfield 27	com/tencent/mobileqq/activity/qwallet/preload/PreloadBackControlConfig:a	Lmqq/app/AppRuntime;
    //   20: invokevirtual 116	mqq/app/AppRuntime:getLongAccountUin	()J
    //   23: invokevirtual 119	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   26: ldc 121
    //   28: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokestatic 127	com/tencent/mobileqq/utils/SharedPreUtils:X	(Landroid/content/Context;Ljava/lang/String;)I
    //   37: istore_1
    //   38: aload_0
    //   39: getfield 29	com/tencent/mobileqq/activity/qwallet/preload/PreloadBackControlConfig:mConfigVersion	I
    //   42: istore_2
    //   43: iload_1
    //   44: iload_2
    //   45: if_icmpeq +9 -> 54
    //   48: iconst_0
    //   49: istore_3
    //   50: aload_0
    //   51: monitorexit
    //   52: iload_3
    //   53: ireturn
    //   54: iconst_1
    //   55: istore_3
    //   56: goto -6 -> 50
    //   59: astore 4
    //   61: aload_0
    //   62: monitorexit
    //   63: aload 4
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	PreloadBackControlConfig
    //   37	9	1	i	int
    //   42	4	2	j	int
    //   49	7	3	bool	boolean
    //   59	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	43	59	finally
  }
  
  public String toString()
  {
    return "BackControlConfig [mVersion=" + this.mConfigVersion + ", mLastRes=" + this.mLastBackResInfos + "]";
  }
  
  public void update(ArrayList paramArrayList)
  {
    try
    {
      this.mConfigVersion = SharedPreUtils.X(this.a.getApplication(), this.a.getLongAccountUin() + "");
      this.mLastBackResInfos = paramArrayList;
      QWalletTools.a(this, getConfigPath(this.a));
      return;
    }
    finally
    {
      paramArrayList = finally;
      throw paramArrayList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.preload.PreloadBackControlConfig
 * JD-Core Version:    0.7.0.1
 */
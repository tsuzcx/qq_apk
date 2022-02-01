package com.tencent.component.network.downloader.strategy;

import android.text.TextUtils;
import com.tencent.component.network.downloader.common.Utils;
import com.tencent.component.network.module.base.QDLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public class PortConfigStrategy
{
  private static final String TAG = "PortConfigStrategy";
  private ReadWriteLock RW_LOCK = new ReentrantReadWriteLock();
  private Map<String, Pattern> mDominPatterns = new HashMap();
  private String mJsonConfig = null;
  private Map<String, List<Integer>> mapAvailablePorts = new HashMap();
  private Map<String, List<Integer>> mapCacheAvailablePorts = new HashMap();
  
  /* Error */
  private List<Integer> findPortConfig(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 48	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: istore 7
    //   6: aconst_null
    //   7: astore 9
    //   9: iload 7
    //   11: ifeq +5 -> 16
    //   14: aconst_null
    //   15: areturn
    //   16: iconst_1
    //   17: istore 4
    //   19: iconst_1
    //   20: istore_3
    //   21: aload_0
    //   22: getfield 37	com/tencent/component/network/downloader/strategy/PortConfigStrategy:RW_LOCK	Ljava/util/concurrent/locks/ReadWriteLock;
    //   25: invokeinterface 54 1 0
    //   30: invokeinterface 59 1 0
    //   35: iload_3
    //   36: istore_2
    //   37: aload_0
    //   38: getfield 30	com/tencent/component/network/downloader/strategy/PortConfigStrategy:mapCacheAvailablePorts	Ljava/util/Map;
    //   41: aload_1
    //   42: invokeinterface 65 2 0
    //   47: ifeq +26 -> 73
    //   50: iload_3
    //   51: istore_2
    //   52: aload_0
    //   53: getfield 30	com/tencent/component/network/downloader/strategy/PortConfigStrategy:mapCacheAvailablePorts	Ljava/util/Map;
    //   56: aload_1
    //   57: invokeinterface 69 2 0
    //   62: checkcast 71	java/util/List
    //   65: astore 8
    //   67: iload 4
    //   69: istore_3
    //   70: goto +219 -> 289
    //   73: iconst_0
    //   74: istore 5
    //   76: iconst_0
    //   77: istore 6
    //   79: iconst_0
    //   80: istore 4
    //   82: iload 4
    //   84: istore_2
    //   85: aload_0
    //   86: aload_1
    //   87: invokespecial 75	com/tencent/component/network/downloader/strategy/PortConfigStrategy:getDominKey	(Ljava/lang/String;)Ljava/lang/String;
    //   90: astore 10
    //   92: iload 4
    //   94: istore_2
    //   95: iload 5
    //   97: istore_3
    //   98: aload 9
    //   100: astore 8
    //   102: aload 10
    //   104: invokestatic 48	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   107: ifne +73 -> 180
    //   110: iload 4
    //   112: istore_2
    //   113: iload 5
    //   115: istore_3
    //   116: aload 9
    //   118: astore 8
    //   120: aload_0
    //   121: getfield 28	com/tencent/component/network/downloader/strategy/PortConfigStrategy:mapAvailablePorts	Ljava/util/Map;
    //   124: aload 10
    //   126: invokeinterface 65 2 0
    //   131: ifeq +49 -> 180
    //   134: iload 4
    //   136: istore_2
    //   137: aload_0
    //   138: getfield 28	com/tencent/component/network/downloader/strategy/PortConfigStrategy:mapAvailablePorts	Ljava/util/Map;
    //   141: aload 10
    //   143: invokeinterface 69 2 0
    //   148: checkcast 71	java/util/List
    //   151: astore 8
    //   153: iload 6
    //   155: istore_3
    //   156: goto +133 -> 289
    //   159: astore_1
    //   160: goto +107 -> 267
    //   163: astore 8
    //   165: ldc 8
    //   167: ldc 76
    //   169: aload 8
    //   171: invokestatic 82	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   174: aload 9
    //   176: astore 8
    //   178: iload_2
    //   179: istore_3
    //   180: aload_0
    //   181: getfield 37	com/tencent/component/network/downloader/strategy/PortConfigStrategy:RW_LOCK	Ljava/util/concurrent/locks/ReadWriteLock;
    //   184: invokeinterface 54 1 0
    //   189: invokeinterface 85 1 0
    //   194: iload_3
    //   195: ifne +69 -> 264
    //   198: aload 8
    //   200: ifnull +64 -> 264
    //   203: aload_0
    //   204: getfield 37	com/tencent/component/network/downloader/strategy/PortConfigStrategy:RW_LOCK	Ljava/util/concurrent/locks/ReadWriteLock;
    //   207: invokeinterface 88 1 0
    //   212: invokeinterface 59 1 0
    //   217: aload_0
    //   218: getfield 30	com/tencent/component/network/downloader/strategy/PortConfigStrategy:mapCacheAvailablePorts	Ljava/util/Map;
    //   221: aload_1
    //   222: aload 8
    //   224: invokeinterface 92 3 0
    //   229: pop
    //   230: aload_0
    //   231: getfield 37	com/tencent/component/network/downloader/strategy/PortConfigStrategy:RW_LOCK	Ljava/util/concurrent/locks/ReadWriteLock;
    //   234: invokeinterface 88 1 0
    //   239: invokeinterface 85 1 0
    //   244: aload 8
    //   246: areturn
    //   247: astore_1
    //   248: aload_0
    //   249: getfield 37	com/tencent/component/network/downloader/strategy/PortConfigStrategy:RW_LOCK	Ljava/util/concurrent/locks/ReadWriteLock;
    //   252: invokeinterface 88 1 0
    //   257: invokeinterface 85 1 0
    //   262: aload_1
    //   263: athrow
    //   264: aload 8
    //   266: areturn
    //   267: aload_0
    //   268: getfield 37	com/tencent/component/network/downloader/strategy/PortConfigStrategy:RW_LOCK	Ljava/util/concurrent/locks/ReadWriteLock;
    //   271: invokeinterface 54 1 0
    //   276: invokeinterface 85 1 0
    //   281: goto +5 -> 286
    //   284: aload_1
    //   285: athrow
    //   286: goto -2 -> 284
    //   289: goto -109 -> 180
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	292	0	this	PortConfigStrategy
    //   0	292	1	paramString	String
    //   36	143	2	i	int
    //   20	175	3	j	int
    //   17	118	4	k	int
    //   74	40	5	m	int
    //   77	77	6	n	int
    //   4	6	7	bool	boolean
    //   65	87	8	localObject1	Object
    //   163	7	8	localThrowable	java.lang.Throwable
    //   176	89	8	localObject2	Object
    //   7	168	9	localObject3	Object
    //   90	52	10	str	String
    // Exception table:
    //   from	to	target	type
    //   37	50	159	finally
    //   52	67	159	finally
    //   85	92	159	finally
    //   102	110	159	finally
    //   120	134	159	finally
    //   137	153	159	finally
    //   165	174	159	finally
    //   37	50	163	java/lang/Throwable
    //   52	67	163	java/lang/Throwable
    //   85	92	163	java/lang/Throwable
    //   102	110	163	java/lang/Throwable
    //   120	134	163	java/lang/Throwable
    //   137	153	163	java/lang/Throwable
    //   203	230	247	finally
  }
  
  private String getDominKey(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject2 = null;
    if (bool) {
      return null;
    }
    Iterator localIterator = this.mDominPatterns.entrySet().iterator();
    Object localObject1;
    Map.Entry localEntry;
    do
    {
      localObject1 = localObject2;
      if (!localIterator.hasNext()) {
        break;
      }
      localEntry = (Map.Entry)localIterator.next();
      localObject1 = (String)localEntry.getKey();
    } while (!Utils.match((Pattern)localEntry.getValue(), paramString));
    return localObject1;
  }
  
  /* Error */
  public final int changePort(String paramString, int paramInt)
  {
    // Byte code:
    //   0: iload_2
    //   1: ifle +152 -> 153
    //   4: aload_1
    //   5: invokestatic 48	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8: ifeq +6 -> 14
    //   11: goto +142 -> 153
    //   14: aload_0
    //   15: aload_1
    //   16: invokespecial 138	com/tencent/component/network/downloader/strategy/PortConfigStrategy:findPortConfig	(Ljava/lang/String;)Ljava/util/List;
    //   19: astore_1
    //   20: aload_1
    //   21: ifnull +130 -> 151
    //   24: aload_1
    //   25: invokeinterface 142 1 0
    //   30: ifle +121 -> 151
    //   33: aload_0
    //   34: getfield 37	com/tencent/component/network/downloader/strategy/PortConfigStrategy:RW_LOCK	Ljava/util/concurrent/locks/ReadWriteLock;
    //   37: invokeinterface 54 1 0
    //   42: invokeinterface 59 1 0
    //   47: aload_1
    //   48: new 144	java/lang/Integer
    //   51: dup
    //   52: iload_2
    //   53: invokespecial 147	java/lang/Integer:<init>	(I)V
    //   56: invokeinterface 151 2 0
    //   61: istore_3
    //   62: iload_3
    //   63: istore_2
    //   64: iload_3
    //   65: ifge +5 -> 70
    //   68: iconst_0
    //   69: istore_2
    //   70: aload_1
    //   71: iload_2
    //   72: iconst_1
    //   73: iadd
    //   74: aload_1
    //   75: invokeinterface 142 1 0
    //   80: irem
    //   81: invokeinterface 154 2 0
    //   86: checkcast 144	java/lang/Integer
    //   89: invokevirtual 157	java/lang/Integer:intValue	()I
    //   92: istore_2
    //   93: aload_0
    //   94: getfield 37	com/tencent/component/network/downloader/strategy/PortConfigStrategy:RW_LOCK	Ljava/util/concurrent/locks/ReadWriteLock;
    //   97: invokeinterface 54 1 0
    //   102: invokeinterface 85 1 0
    //   107: iload_2
    //   108: ireturn
    //   109: astore_1
    //   110: goto +25 -> 135
    //   113: astore_1
    //   114: aload_1
    //   115: invokevirtual 160	java/lang/Exception:printStackTrace	()V
    //   118: aload_0
    //   119: getfield 37	com/tencent/component/network/downloader/strategy/PortConfigStrategy:RW_LOCK	Ljava/util/concurrent/locks/ReadWriteLock;
    //   122: invokeinterface 54 1 0
    //   127: invokeinterface 85 1 0
    //   132: goto +19 -> 151
    //   135: aload_0
    //   136: getfield 37	com/tencent/component/network/downloader/strategy/PortConfigStrategy:RW_LOCK	Ljava/util/concurrent/locks/ReadWriteLock;
    //   139: invokeinterface 54 1 0
    //   144: invokeinterface 85 1 0
    //   149: aload_1
    //   150: athrow
    //   151: iconst_m1
    //   152: ireturn
    //   153: bipush 80
    //   155: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	this	PortConfigStrategy
    //   0	156	1	paramString	String
    //   0	156	2	paramInt	int
    //   61	4	3	i	int
    // Exception table:
    //   from	to	target	type
    //   33	62	109	finally
    //   70	93	109	finally
    //   114	118	109	finally
    //   33	62	113	java/lang/Exception
    //   70	93	113	java/lang/Exception
  }
  
  public final void setConfig(String paramString)
  {
    Object localObject;
    HashMap localHashMap;
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.equals(this.mJsonConfig)) {
        return;
      }
      if (QDLog.isInfoEnable())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Downloader port config:");
        ((StringBuilder)localObject).append(paramString);
        QDLog.i("PortConfigStrategy", ((StringBuilder)localObject).toString());
      }
      localObject = new HashMap();
      localHashMap = new HashMap();
    }
    for (;;)
    {
      int j;
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        JSONArray localJSONArray1 = localJSONObject.names();
        if (localJSONArray1 != null)
        {
          int i = 0;
          if (i < localJSONArray1.length())
          {
            String str = localJSONArray1.getString(i);
            ArrayList localArrayList = new ArrayList();
            JSONArray localJSONArray2 = localJSONObject.getJSONArray(localJSONArray1.getString(i));
            if (localJSONArray2 != null)
            {
              j = 0;
              if (j < localJSONArray2.length())
              {
                Integer localInteger = Integer.valueOf(localJSONArray2.getJSONObject(j).getInt("port"));
                localArrayList.add(localInteger);
                if (!QDLog.isInfoEnable()) {
                  break label385;
                }
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("downloader port: domain:");
                localStringBuilder.append(str);
                localStringBuilder.append(" port:");
                localStringBuilder.append(localInteger);
                QDLog.i("PortConfigStrategy", localStringBuilder.toString());
                break label385;
              }
            }
            ((Map)localObject).put(str, localArrayList);
            localHashMap.put(str, Pattern.compile(str, 2));
            i += 1;
            continue;
          }
        }
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        try
        {
          this.RW_LOCK.writeLock().lock();
          this.mJsonConfig = paramString;
          this.mapAvailablePorts.clear();
          this.mapAvailablePorts.putAll((Map)localObject);
          this.mapCacheAvailablePorts.clear();
          this.mDominPatterns.clear();
          this.mDominPatterns.putAll(localHashMap);
          return;
        }
        finally
        {
          this.RW_LOCK.writeLock().unlock();
        }
      }
      label385:
      j += 1;
    }
  }
  
  public final boolean supportExtraPort(String paramString)
  {
    boolean bool2 = TextUtils.isEmpty(paramString);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if (findPortConfig(paramString) != null) {
      bool1 = true;
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.downloader.strategy.PortConfigStrategy
 * JD-Core Version:    0.7.0.1
 */
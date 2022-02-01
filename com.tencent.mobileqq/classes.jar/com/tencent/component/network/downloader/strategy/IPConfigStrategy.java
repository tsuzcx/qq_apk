package com.tencent.component.network.downloader.strategy;

import android.text.TextUtils;
import com.tencent.component.network.NetworkManager;
import com.tencent.component.network.downloader.common.IPInfo;
import com.tencent.component.network.downloader.common.Utils;
import com.tencent.component.network.module.base.QDLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public class IPConfigStrategy
  implements IPStrategy
{
  private static final String TAG = "IPConfigStrategy";
  private byte[] CONFIG_LOCK = new byte[0];
  private ReadWriteLock RW_LOCK = new ReentrantReadWriteLock();
  private Map<String, Map<Integer, IPConfigStrategy.IPConfig>> mCacheIPConfigs = new HashMap();
  private Map<String, String> mConfigs = new HashMap();
  private int mDefaultIsp = -1;
  private Map<String, Pattern> mDominPatterns = new HashMap();
  private Map<String, Map<Integer, IPConfigStrategy.IPConfig>> mIPConfigs = new HashMap();
  private Map<String, String> mValidIPCache = new ConcurrentHashMap();
  
  private final void addConfig(String paramString, Map<String, Map<Integer, IPConfigStrategy.IPConfig>> paramMap, Map<String, Pattern> paramMap1)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramMap != null))
    {
      if (paramMap1 == null) {
        return;
      }
      Object localObject1 = paramString.trim();
      paramString = (String)localObject1;
      if (((String)localObject1).startsWith(","))
      {
        paramString = new StringBuilder();
        paramString.append("{");
        paramString.append(((String)localObject1).substring(1));
        paramString = paramString.toString();
      }
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        JSONArray localJSONArray1 = localJSONObject.names();
        if (localJSONArray1 != null)
        {
          int i = 0;
          while (i < localJSONArray1.length())
          {
            String str = localJSONArray1.getString(i);
            Object localObject2 = (Map)paramMap.get(str);
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              localObject1 = new HashMap();
              paramMap.put(str, localObject1);
            }
            JSONArray localJSONArray2 = localJSONObject.getJSONArray(localJSONArray1.getString(i));
            if (localJSONArray2 != null)
            {
              int j = 0;
              while (j < localJSONArray2.length())
              {
                Object localObject3 = localJSONArray2.getJSONObject(j);
                localObject2 = ((JSONObject)localObject3).getString("ip");
                int k = ((JSONObject)localObject3).getInt("port");
                Integer localInteger = Integer.valueOf(((JSONObject)localObject3).getInt("apn"));
                IPInfo localIPInfo = new IPInfo((String)localObject2, Integer.valueOf(k).intValue());
                localObject3 = (IPConfigStrategy.IPConfig)((Map)localObject1).get(localInteger);
                localObject2 = localObject3;
                if (localObject3 == null)
                {
                  localObject2 = new IPConfigStrategy.IPConfig();
                  ((Map)localObject1).put(localInteger, localObject2);
                }
                ((IPConfigStrategy.IPConfig)localObject2).appendIP(localIPInfo);
                j += 1;
              }
            }
            paramMap1.put(str, Pattern.compile(str, 2));
            i += 1;
          }
        }
        return;
      }
      catch (Throwable paramMap)
      {
        paramMap1 = new StringBuilder();
        paramMap1.append("exception when add ip config: ");
        paramMap1.append(paramString);
        QDLog.e("IPConfigStrategy", paramMap1.toString(), paramMap);
      }
    }
  }
  
  /* Error */
  private Map<Integer, IPConfigStrategy.IPConfig> findIPConfigs(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 65	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
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
    //   22: getfield 34	com/tencent/component/network/downloader/strategy/IPConfigStrategy:RW_LOCK	Ljava/util/concurrent/locks/ReadWriteLock;
    //   25: invokeinterface 187 1 0
    //   30: invokeinterface 192 1 0
    //   35: iload_3
    //   36: istore_2
    //   37: aload_0
    //   38: getfield 41	com/tencent/component/network/downloader/strategy/IPConfigStrategy:mCacheIPConfigs	Ljava/util/Map;
    //   41: aload_1
    //   42: invokeinterface 196 2 0
    //   47: ifeq +26 -> 73
    //   50: iload_3
    //   51: istore_2
    //   52: aload_0
    //   53: getfield 41	com/tencent/component/network/downloader/strategy/IPConfigStrategy:mCacheIPConfigs	Ljava/util/Map;
    //   56: aload_1
    //   57: invokeinterface 117 2 0
    //   62: checkcast 113	java/util/Map
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
    //   87: invokespecial 199	com/tencent/component/network/downloader/strategy/IPConfigStrategy:getDominKey	(Ljava/lang/String;)Ljava/lang/String;
    //   90: astore 10
    //   92: iload 4
    //   94: istore_2
    //   95: iload 5
    //   97: istore_3
    //   98: aload 9
    //   100: astore 8
    //   102: aload 10
    //   104: invokestatic 65	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   107: ifne +73 -> 180
    //   110: iload 4
    //   112: istore_2
    //   113: iload 5
    //   115: istore_3
    //   116: aload 9
    //   118: astore 8
    //   120: aload_0
    //   121: getfield 39	com/tencent/component/network/downloader/strategy/IPConfigStrategy:mIPConfigs	Ljava/util/Map;
    //   124: aload 10
    //   126: invokeinterface 196 2 0
    //   131: ifeq +49 -> 180
    //   134: iload 4
    //   136: istore_2
    //   137: aload_0
    //   138: getfield 39	com/tencent/component/network/downloader/strategy/IPConfigStrategy:mIPConfigs	Ljava/util/Map;
    //   141: aload 10
    //   143: invokeinterface 117 2 0
    //   148: checkcast 113	java/util/Map
    //   151: astore 8
    //   153: iload 6
    //   155: istore_3
    //   156: goto +133 -> 289
    //   159: astore_1
    //   160: goto +107 -> 267
    //   163: astore 8
    //   165: ldc 10
    //   167: ldc 200
    //   169: aload 8
    //   171: invokestatic 203	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   174: aload 9
    //   176: astore 8
    //   178: iload_2
    //   179: istore_3
    //   180: aload_0
    //   181: getfield 34	com/tencent/component/network/downloader/strategy/IPConfigStrategy:RW_LOCK	Ljava/util/concurrent/locks/ReadWriteLock;
    //   184: invokeinterface 187 1 0
    //   189: invokeinterface 206 1 0
    //   194: iload_3
    //   195: ifne +69 -> 264
    //   198: aload 8
    //   200: ifnull +64 -> 264
    //   203: aload_0
    //   204: getfield 34	com/tencent/component/network/downloader/strategy/IPConfigStrategy:RW_LOCK	Ljava/util/concurrent/locks/ReadWriteLock;
    //   207: invokeinterface 209 1 0
    //   212: invokeinterface 192 1 0
    //   217: aload_0
    //   218: getfield 41	com/tencent/component/network/downloader/strategy/IPConfigStrategy:mCacheIPConfigs	Ljava/util/Map;
    //   221: aload_1
    //   222: aload 8
    //   224: invokeinterface 121 3 0
    //   229: pop
    //   230: aload_0
    //   231: getfield 34	com/tencent/component/network/downloader/strategy/IPConfigStrategy:RW_LOCK	Ljava/util/concurrent/locks/ReadWriteLock;
    //   234: invokeinterface 209 1 0
    //   239: invokeinterface 206 1 0
    //   244: aload 8
    //   246: areturn
    //   247: astore_1
    //   248: aload_0
    //   249: getfield 34	com/tencent/component/network/downloader/strategy/IPConfigStrategy:RW_LOCK	Ljava/util/concurrent/locks/ReadWriteLock;
    //   252: invokeinterface 209 1 0
    //   257: invokeinterface 206 1 0
    //   262: aload_1
    //   263: athrow
    //   264: aload 8
    //   266: areturn
    //   267: aload_0
    //   268: getfield 34	com/tencent/component/network/downloader/strategy/IPConfigStrategy:RW_LOCK	Ljava/util/concurrent/locks/ReadWriteLock;
    //   271: invokeinterface 187 1 0
    //   276: invokeinterface 206 1 0
    //   281: goto +5 -> 286
    //   284: aload_1
    //   285: athrow
    //   286: goto -2 -> 284
    //   289: goto -109 -> 180
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	292	0	this	IPConfigStrategy
    //   0	292	1	paramString	String
    //   36	143	2	i	int
    //   20	175	3	j	int
    //   17	118	4	k	int
    //   74	40	5	m	int
    //   77	77	6	n	int
    //   4	6	7	bool	boolean
    //   65	87	8	localObject1	Object
    //   163	7	8	localThrowable	Throwable
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
    Iterator localIterator = this.mIPConfigs.entrySet().iterator();
    Object localObject1;
    do
    {
      localObject1 = localObject2;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject1 = (String)((Map.Entry)localIterator.next()).getKey();
    } while (!Utils.match((Pattern)this.mDominPatterns.get(localObject1), paramString));
    return localObject1;
  }
  
  /* Error */
  private String resolveIP(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 65	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: istore 4
    //   6: aconst_null
    //   7: astore 6
    //   9: iload 4
    //   11: ifeq +5 -> 16
    //   14: aconst_null
    //   15: areturn
    //   16: aload_0
    //   17: aload_1
    //   18: invokespecial 245	com/tencent/component/network/downloader/strategy/IPConfigStrategy:findIPConfigs	(Ljava/lang/String;)Ljava/util/Map;
    //   21: astore 7
    //   23: aload_0
    //   24: getfield 34	com/tencent/component/network/downloader/strategy/IPConfigStrategy:RW_LOCK	Ljava/util/concurrent/locks/ReadWriteLock;
    //   27: invokeinterface 187 1 0
    //   32: invokeinterface 192 1 0
    //   37: aload 6
    //   39: astore 5
    //   41: aload 7
    //   43: ifnull +164 -> 207
    //   46: aload 7
    //   48: iload_2
    //   49: invokestatic 148	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   52: invokeinterface 117 2 0
    //   57: checkcast 158	com/tencent/component/network/downloader/strategy/IPConfigStrategy$IPConfig
    //   60: astore 5
    //   62: aload 5
    //   64: astore_1
    //   65: aload 5
    //   67: ifnonnull +26 -> 93
    //   70: aload 5
    //   72: astore_1
    //   73: iload_3
    //   74: iconst_m1
    //   75: if_icmpeq +18 -> 93
    //   78: aload 7
    //   80: iload_3
    //   81: invokestatic 148	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   84: invokeinterface 117 2 0
    //   89: checkcast 158	com/tencent/component/network/downloader/strategy/IPConfigStrategy$IPConfig
    //   92: astore_1
    //   93: aload 6
    //   95: astore 5
    //   97: aload_1
    //   98: ifnull +109 -> 207
    //   101: aload 6
    //   103: astore 5
    //   105: aload_1
    //   106: getfield 249	com/tencent/component/network/downloader/strategy/IPConfigStrategy$IPConfig:ipInfos	Ljava/util/ArrayList;
    //   109: ifnull +98 -> 207
    //   112: aload 6
    //   114: astore 5
    //   116: aload_1
    //   117: getfield 249	com/tencent/component/network/downloader/strategy/IPConfigStrategy$IPConfig:ipInfos	Ljava/util/ArrayList;
    //   120: invokevirtual 254	java/util/ArrayList:size	()I
    //   123: ifle +84 -> 207
    //   126: aload_1
    //   127: invokevirtual 257	com/tencent/component/network/downloader/strategy/IPConfigStrategy$IPConfig:getFailCount	()I
    //   130: istore_2
    //   131: aload_1
    //   132: getfield 249	com/tencent/component/network/downloader/strategy/IPConfigStrategy$IPConfig:ipInfos	Ljava/util/ArrayList;
    //   135: invokevirtual 254	java/util/ArrayList:size	()I
    //   138: istore_3
    //   139: aload_1
    //   140: getfield 249	com/tencent/component/network/downloader/strategy/IPConfigStrategy$IPConfig:ipInfos	Ljava/util/ArrayList;
    //   143: iload_2
    //   144: iload_3
    //   145: irem
    //   146: invokevirtual 260	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   149: checkcast 150	com/tencent/component/network/downloader/common/IPInfo
    //   152: astore_1
    //   153: aload 6
    //   155: astore 5
    //   157: aload_1
    //   158: ifnull +49 -> 207
    //   161: aload_1
    //   162: getfield 262	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   165: astore 5
    //   167: goto +40 -> 207
    //   170: astore_1
    //   171: goto +20 -> 191
    //   174: astore_1
    //   175: ldc 10
    //   177: ldc_w 263
    //   180: aload_1
    //   181: invokestatic 203	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   184: aload 6
    //   186: astore 5
    //   188: goto +19 -> 207
    //   191: aload_0
    //   192: getfield 34	com/tencent/component/network/downloader/strategy/IPConfigStrategy:RW_LOCK	Ljava/util/concurrent/locks/ReadWriteLock;
    //   195: invokeinterface 187 1 0
    //   200: invokeinterface 206 1 0
    //   205: aload_1
    //   206: athrow
    //   207: aload_0
    //   208: getfield 34	com/tencent/component/network/downloader/strategy/IPConfigStrategy:RW_LOCK	Ljava/util/concurrent/locks/ReadWriteLock;
    //   211: invokeinterface 187 1 0
    //   216: invokeinterface 206 1 0
    //   221: aload 5
    //   223: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	224	0	this	IPConfigStrategy
    //   0	224	1	paramString	String
    //   0	224	2	paramInt1	int
    //   0	224	3	paramInt2	int
    //   4	6	4	bool	boolean
    //   39	183	5	localObject1	Object
    //   7	178	6	localObject2	Object
    //   21	58	7	localMap	Map
    // Exception table:
    //   from	to	target	type
    //   46	62	170	finally
    //   78	93	170	finally
    //   105	112	170	finally
    //   116	153	170	finally
    //   161	167	170	finally
    //   175	184	170	finally
    //   46	62	174	java/lang/Throwable
    //   78	93	174	java/lang/Throwable
    //   105	112	174	java/lang/Throwable
    //   116	153	174	java/lang/Throwable
    //   161	167	174	java/lang/Throwable
  }
  
  /* Error */
  private List<IPInfo> resolveVideoIP(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 65	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: istore 4
    //   6: aconst_null
    //   7: astore 6
    //   9: iload 4
    //   11: ifeq +5 -> 16
    //   14: aconst_null
    //   15: areturn
    //   16: aload_0
    //   17: aload_1
    //   18: invokespecial 245	com/tencent/component/network/downloader/strategy/IPConfigStrategy:findIPConfigs	(Ljava/lang/String;)Ljava/util/Map;
    //   21: astore 7
    //   23: aload_0
    //   24: getfield 34	com/tencent/component/network/downloader/strategy/IPConfigStrategy:RW_LOCK	Ljava/util/concurrent/locks/ReadWriteLock;
    //   27: invokeinterface 187 1 0
    //   32: invokeinterface 192 1 0
    //   37: aload 6
    //   39: astore 5
    //   41: aload 7
    //   43: ifnull +104 -> 147
    //   46: aload 7
    //   48: iload_2
    //   49: invokestatic 148	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   52: invokeinterface 117 2 0
    //   57: checkcast 158	com/tencent/component/network/downloader/strategy/IPConfigStrategy$IPConfig
    //   60: astore 5
    //   62: aload 5
    //   64: astore_1
    //   65: aload 5
    //   67: ifnonnull +26 -> 93
    //   70: aload 5
    //   72: astore_1
    //   73: iload_3
    //   74: iconst_m1
    //   75: if_icmpeq +18 -> 93
    //   78: aload 7
    //   80: iload_3
    //   81: invokestatic 148	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   84: invokeinterface 117 2 0
    //   89: checkcast 158	com/tencent/component/network/downloader/strategy/IPConfigStrategy$IPConfig
    //   92: astore_1
    //   93: aload 6
    //   95: astore 5
    //   97: aload_1
    //   98: ifnull +49 -> 147
    //   101: aload_1
    //   102: getfield 249	com/tencent/component/network/downloader/strategy/IPConfigStrategy$IPConfig:ipInfos	Ljava/util/ArrayList;
    //   105: astore 5
    //   107: goto +40 -> 147
    //   110: astore_1
    //   111: goto +20 -> 131
    //   114: astore_1
    //   115: ldc 10
    //   117: ldc_w 263
    //   120: aload_1
    //   121: invokestatic 203	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   124: aload 6
    //   126: astore 5
    //   128: goto +19 -> 147
    //   131: aload_0
    //   132: getfield 34	com/tencent/component/network/downloader/strategy/IPConfigStrategy:RW_LOCK	Ljava/util/concurrent/locks/ReadWriteLock;
    //   135: invokeinterface 187 1 0
    //   140: invokeinterface 206 1 0
    //   145: aload_1
    //   146: athrow
    //   147: aload_0
    //   148: getfield 34	com/tencent/component/network/downloader/strategy/IPConfigStrategy:RW_LOCK	Ljava/util/concurrent/locks/ReadWriteLock;
    //   151: invokeinterface 187 1 0
    //   156: invokeinterface 206 1 0
    //   161: aload 5
    //   163: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	this	IPConfigStrategy
    //   0	164	1	paramString	String
    //   0	164	2	paramInt1	int
    //   0	164	3	paramInt2	int
    //   4	6	4	bool	boolean
    //   39	123	5	localObject1	Object
    //   7	118	6	localObject2	Object
    //   21	58	7	localMap	Map
    // Exception table:
    //   from	to	target	type
    //   46	62	110	finally
    //   78	93	110	finally
    //   101	107	110	finally
    //   115	124	110	finally
    //   46	62	114	java/lang/Throwable
    //   78	93	114	java/lang/Throwable
    //   101	107	114	java/lang/Throwable
  }
  
  private boolean strEqual(String paramString1, String paramString2)
  {
    if (paramString1 != null) {
      return paramString1.equals(paramString2);
    }
    return paramString2 == null;
  }
  
  protected String getLogTag()
  {
    return "IPConfigStrategy";
  }
  
  /* Error */
  public boolean isIPValid(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 65	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: istore 4
    //   6: iconst_0
    //   7: istore 5
    //   9: iconst_0
    //   10: istore 6
    //   12: iload 4
    //   14: ifne +307 -> 321
    //   17: aload_2
    //   18: invokestatic 65	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   21: ifeq +5 -> 26
    //   24: iconst_0
    //   25: ireturn
    //   26: invokestatic 278	com/tencent/component/network/NetworkManager:getIspType	()I
    //   29: istore_3
    //   30: new 79	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   37: astore 7
    //   39: aload 7
    //   41: aload_1
    //   42: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload 7
    //   48: ldc_w 280
    //   51: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload 7
    //   57: iload_3
    //   58: invokevirtual 283	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: aload 7
    //   64: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: astore 8
    //   69: aload_2
    //   70: aload_0
    //   71: getfield 46	com/tencent/component/network/downloader/strategy/IPConfigStrategy:mValidIPCache	Ljava/util/Map;
    //   74: aload 8
    //   76: invokeinterface 117 2 0
    //   81: checkcast 67	java/lang/String
    //   84: invokevirtual 271	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   87: ifeq +5 -> 92
    //   90: iconst_1
    //   91: ireturn
    //   92: aload_0
    //   93: aload_1
    //   94: invokespecial 245	com/tencent/component/network/downloader/strategy/IPConfigStrategy:findIPConfigs	(Ljava/lang/String;)Ljava/util/Map;
    //   97: astore 9
    //   99: aload_0
    //   100: getfield 34	com/tencent/component/network/downloader/strategy/IPConfigStrategy:RW_LOCK	Ljava/util/concurrent/locks/ReadWriteLock;
    //   103: invokeinterface 187 1 0
    //   108: invokeinterface 192 1 0
    //   113: iload 6
    //   115: istore 4
    //   117: aload 9
    //   119: ifnull +162 -> 281
    //   122: aload 9
    //   124: iload_3
    //   125: invokestatic 148	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   128: invokeinterface 117 2 0
    //   133: checkcast 158	com/tencent/component/network/downloader/strategy/IPConfigStrategy$IPConfig
    //   136: astore 7
    //   138: aload 7
    //   140: astore_1
    //   141: aload 7
    //   143: ifnonnull +32 -> 175
    //   146: aload 7
    //   148: astore_1
    //   149: aload_0
    //   150: getfield 54	com/tencent/component/network/downloader/strategy/IPConfigStrategy:mDefaultIsp	I
    //   153: iconst_m1
    //   154: if_icmpeq +21 -> 175
    //   157: aload 9
    //   159: aload_0
    //   160: getfield 54	com/tencent/component/network/downloader/strategy/IPConfigStrategy:mDefaultIsp	I
    //   163: invokestatic 148	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   166: invokeinterface 117 2 0
    //   171: checkcast 158	com/tencent/component/network/downloader/strategy/IPConfigStrategy$IPConfig
    //   174: astore_1
    //   175: iload 6
    //   177: istore 4
    //   179: aload_1
    //   180: ifnull +101 -> 281
    //   183: iload 6
    //   185: istore 4
    //   187: aload_1
    //   188: getfield 249	com/tencent/component/network/downloader/strategy/IPConfigStrategy$IPConfig:ipInfos	Ljava/util/ArrayList;
    //   191: ifnull +90 -> 281
    //   194: aload_1
    //   195: getfield 249	com/tencent/component/network/downloader/strategy/IPConfigStrategy$IPConfig:ipInfos	Ljava/util/ArrayList;
    //   198: invokevirtual 284	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   201: astore_1
    //   202: iload 6
    //   204: istore 4
    //   206: aload_1
    //   207: invokeinterface 226 1 0
    //   212: ifeq +69 -> 281
    //   215: aload_2
    //   216: aload_1
    //   217: invokeinterface 230 1 0
    //   222: checkcast 150	com/tencent/component/network/downloader/common/IPInfo
    //   225: getfield 262	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   228: invokevirtual 271	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   231: istore 4
    //   233: iload 4
    //   235: ifeq -33 -> 202
    //   238: iconst_1
    //   239: istore 4
    //   241: goto +40 -> 281
    //   244: astore_1
    //   245: goto +20 -> 265
    //   248: astore_1
    //   249: ldc 10
    //   251: ldc_w 285
    //   254: aload_1
    //   255: invokestatic 203	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   258: iload 6
    //   260: istore 4
    //   262: goto +19 -> 281
    //   265: aload_0
    //   266: getfield 34	com/tencent/component/network/downloader/strategy/IPConfigStrategy:RW_LOCK	Ljava/util/concurrent/locks/ReadWriteLock;
    //   269: invokeinterface 187 1 0
    //   274: invokeinterface 206 1 0
    //   279: aload_1
    //   280: athrow
    //   281: aload_0
    //   282: getfield 34	com/tencent/component/network/downloader/strategy/IPConfigStrategy:RW_LOCK	Ljava/util/concurrent/locks/ReadWriteLock;
    //   285: invokeinterface 187 1 0
    //   290: invokeinterface 206 1 0
    //   295: iload 4
    //   297: istore 5
    //   299: iload 4
    //   301: ifeq +20 -> 321
    //   304: aload_0
    //   305: getfield 46	com/tencent/component/network/downloader/strategy/IPConfigStrategy:mValidIPCache	Ljava/util/Map;
    //   308: aload 8
    //   310: aload_2
    //   311: invokeinterface 121 3 0
    //   316: pop
    //   317: iload 4
    //   319: istore 5
    //   321: iload 5
    //   323: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	324	0	this	IPConfigStrategy
    //   0	324	1	paramString1	String
    //   0	324	2	paramString2	String
    //   29	96	3	i	int
    //   4	314	4	bool1	boolean
    //   7	315	5	bool2	boolean
    //   10	249	6	bool3	boolean
    //   37	110	7	localObject	Object
    //   67	242	8	str	String
    //   97	61	9	localMap	Map
    // Exception table:
    //   from	to	target	type
    //   122	138	244	finally
    //   149	175	244	finally
    //   187	202	244	finally
    //   206	233	244	finally
    //   249	258	244	finally
    //   122	138	248	java/lang/Throwable
    //   149	175	248	java/lang/Throwable
    //   187	202	248	java/lang/Throwable
    //   206	233	248	java/lang/Throwable
  }
  
  /* Error */
  public void onIPAccessResult(String paramString1, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 65	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +174 -> 178
    //   7: iload_3
    //   8: ifne +170 -> 178
    //   11: aload_2
    //   12: invokestatic 65	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   15: ifeq +4 -> 19
    //   18: return
    //   19: invokestatic 278	com/tencent/component/network/NetworkManager:getIspType	()I
    //   22: istore 4
    //   24: aload_0
    //   25: aload_1
    //   26: invokespecial 245	com/tencent/component/network/downloader/strategy/IPConfigStrategy:findIPConfigs	(Ljava/lang/String;)Ljava/util/Map;
    //   29: astore_1
    //   30: aload_0
    //   31: getfield 34	com/tencent/component/network/downloader/strategy/IPConfigStrategy:RW_LOCK	Ljava/util/concurrent/locks/ReadWriteLock;
    //   34: invokeinterface 209 1 0
    //   39: invokeinterface 192 1 0
    //   44: aload_1
    //   45: ifnull +119 -> 164
    //   48: aload_1
    //   49: iload 4
    //   51: invokestatic 148	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   54: invokeinterface 117 2 0
    //   59: checkcast 158	com/tencent/component/network/downloader/strategy/IPConfigStrategy$IPConfig
    //   62: astore_1
    //   63: aload_1
    //   64: ifnull +100 -> 164
    //   67: aload_1
    //   68: getfield 249	com/tencent/component/network/downloader/strategy/IPConfigStrategy$IPConfig:ipInfos	Ljava/util/ArrayList;
    //   71: ifnull +93 -> 164
    //   74: aload_1
    //   75: invokevirtual 290	com/tencent/component/network/downloader/strategy/IPConfigStrategy$IPConfig:getCurrFailCount	()I
    //   78: ifge +8 -> 86
    //   81: aload_1
    //   82: aload_2
    //   83: invokevirtual 293	com/tencent/component/network/downloader/strategy/IPConfigStrategy$IPConfig:initFailCount	(Ljava/lang/String;)V
    //   86: aload_2
    //   87: aload_1
    //   88: getfield 249	com/tencent/component/network/downloader/strategy/IPConfigStrategy$IPConfig:ipInfos	Ljava/util/ArrayList;
    //   91: aload_1
    //   92: invokevirtual 257	com/tencent/component/network/downloader/strategy/IPConfigStrategy$IPConfig:getFailCount	()I
    //   95: aload_1
    //   96: getfield 249	com/tencent/component/network/downloader/strategy/IPConfigStrategy$IPConfig:ipInfos	Ljava/util/ArrayList;
    //   99: invokevirtual 254	java/util/ArrayList:size	()I
    //   102: irem
    //   103: invokevirtual 260	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   106: checkcast 150	com/tencent/component/network/downloader/common/IPInfo
    //   109: getfield 262	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   112: invokevirtual 271	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   115: ifeq +49 -> 164
    //   118: aload_1
    //   119: aload_1
    //   120: invokevirtual 257	com/tencent/component/network/downloader/strategy/IPConfigStrategy$IPConfig:getFailCount	()I
    //   123: iconst_1
    //   124: iadd
    //   125: invokevirtual 297	com/tencent/component/network/downloader/strategy/IPConfigStrategy$IPConfig:setFailCount	(I)V
    //   128: goto +36 -> 164
    //   131: astore_1
    //   132: goto +16 -> 148
    //   135: astore_1
    //   136: ldc 10
    //   138: ldc_w 298
    //   141: aload_1
    //   142: invokestatic 203	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   145: goto +19 -> 164
    //   148: aload_0
    //   149: getfield 34	com/tencent/component/network/downloader/strategy/IPConfigStrategy:RW_LOCK	Ljava/util/concurrent/locks/ReadWriteLock;
    //   152: invokeinterface 209 1 0
    //   157: invokeinterface 206 1 0
    //   162: aload_1
    //   163: athrow
    //   164: aload_0
    //   165: getfield 34	com/tencent/component/network/downloader/strategy/IPConfigStrategy:RW_LOCK	Ljava/util/concurrent/locks/ReadWriteLock;
    //   168: invokeinterface 209 1 0
    //   173: invokeinterface 206 1 0
    //   178: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	179	0	this	IPConfigStrategy
    //   0	179	1	paramString1	String
    //   0	179	2	paramString2	String
    //   0	179	3	paramBoolean	boolean
    //   22	28	4	i	int
    // Exception table:
    //   from	to	target	type
    //   48	63	131	finally
    //   67	86	131	finally
    //   86	128	131	finally
    //   136	145	131	finally
    //   48	63	135	java/lang/Throwable
    //   67	86	135	java/lang/Throwable
    //   86	128	135	java/lang/Throwable
  }
  
  public String resolveIP(String paramString)
  {
    return resolveIP(paramString, NetworkManager.getIspType(), this.mDefaultIsp);
  }
  
  public String resolveIP(String paramString, int paramInt)
  {
    return resolveIP(paramString, paramInt, -1);
  }
  
  public List<IPInfo> resolveVideoIP(String paramString)
  {
    return resolveVideoIP(paramString, NetworkManager.getIspType(), this.mDefaultIsp);
  }
  
  public final void setConfig(Map<String, String> paramMap)
  {
    if (paramMap == null) {
      return;
    }
    int i;
    label418:
    synchronized (this.CONFIG_LOCK)
    {
      int j = paramMap.size();
      int k = this.mConfigs.size();
      i = 1;
      Object localObject2;
      Object localObject3;
      Object localObject4;
      if (j == k)
      {
        localObject2 = paramMap.entrySet().iterator();
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label418;
          }
          localObject3 = (Map.Entry)((Iterator)localObject2).next();
          localObject4 = (String)((Map.Entry)localObject3).getKey();
          if (!strEqual((String)((Map.Entry)localObject3).getValue(), (String)this.mConfigs.get(localObject4))) {
            break;
          }
        }
      }
      if (i != 0)
      {
        this.mConfigs.clear();
        this.mConfigs.putAll(paramMap);
      }
      if (i != 0)
      {
        ??? = new HashMap();
        localObject2 = new HashMap();
        paramMap = paramMap.entrySet().iterator();
        while (paramMap.hasNext())
        {
          localObject4 = (Map.Entry)paramMap.next();
          localObject3 = (String)((Map.Entry)localObject4).getKey();
          localObject4 = (String)((Map.Entry)localObject4).getValue();
          String str = getLogTag();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("IP Config -- ");
          localStringBuilder.append((String)localObject3);
          localStringBuilder.append(":");
          localStringBuilder.append((String)localObject4);
          QDLog.i(str, localStringBuilder.toString(), null);
          addConfig((String)localObject4, (Map)???, (Map)localObject2);
        }
        try
        {
          this.RW_LOCK.writeLock().lock();
          this.mIPConfigs.clear();
          this.mIPConfigs.putAll((Map)???);
          this.mDominPatterns.clear();
          this.mDominPatterns.putAll((Map)localObject2);
          this.mCacheIPConfigs.clear();
          this.mValidIPCache.clear();
          return;
        }
        finally
        {
          this.RW_LOCK.writeLock().unlock();
        }
      }
      return;
    }
  }
  
  public void setDefaultIsp(int paramInt)
  {
    this.mDefaultIsp = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.network.downloader.strategy.IPConfigStrategy
 * JD-Core Version:    0.7.0.1
 */
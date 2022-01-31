package com.tencent.component.network.downloader.strategy;

import android.text.TextUtils;
import com.tencent.component.network.module.base.Config;
import com.tencent.component.network.utils.http.HttpUtil;
import com.tencent.component.network.utils.http.HttpUtil.RequestOptions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.regex.Pattern;
import org.apache.http.HttpRequest;

public class ConfigKeepAliveStrategy
  implements KeepAliveStrategy
{
  private static final String CONFIG_SPLIT = ",";
  private static final String DEFAULT_KP_DOMAIN_CONFIG = "m.qpic.cn,a[0-9].qpic.cn";
  private static final String TAG = "ConfigKeepAliveStrategy";
  private ReadWriteLock RW_LOCK = new ReentrantReadWriteLock();
  private Map<String, Pattern> mDominPatterns = new HashMap();
  private List<String> mKpDomainCacheList = new ArrayList();
  private List<String> mKpDomainRegularList = new ArrayList();
  private String mStrCurrConfig;
  
  public final KeepAliveStrategy.KeepAlive keepAlive(String paramString, HttpRequest paramHttpRequest, HttpUtil.RequestOptions paramRequestOptions)
  {
    if (TextUtils.isEmpty(paramString)) {
      return KeepAliveStrategy.KeepAlive.DISABLE;
    }
    if (!supportKeepAlive(paramString)) {
      return KeepAliveStrategy.KeepAlive.DISABLE;
    }
    boolean bool = HttpUtil.containsProxy(paramHttpRequest, paramRequestOptions);
    int j = Config.photoDownloadKeepAliveConfig();
    int i = j;
    if (bool)
    {
      int k = Config.photoDownloadKeepAliveProxyConfig();
      i = j;
      if (k != -1) {
        i = k;
      }
    }
    switch (i)
    {
    default: 
      return null;
    case 0: 
      return KeepAliveStrategy.KeepAlive.ENABLE;
    case 1: 
      return KeepAliveStrategy.KeepAlive.DISABLE;
    }
    return KeepAliveStrategy.KeepAlive.IGNORE;
  }
  
  /* Error */
  public void setConfig(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +14 -> 15
    //   4: aload_1
    //   5: aload_0
    //   6: getfield 93	com/tencent/component/network/downloader/strategy/ConfigKeepAliveStrategy:mStrCurrConfig	Ljava/lang/String;
    //   9: invokevirtual 99	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12: ifeq +4 -> 16
    //   15: return
    //   16: invokestatic 105	com/tencent/component/network/module/base/QDLog:isInfoEnable	()Z
    //   19: ifeq +27 -> 46
    //   22: ldc 16
    //   24: new 107	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   31: ldc 110
    //   33: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: aload_1
    //   37: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokestatic 122	com/tencent/component/network/module/base/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   46: new 32	java/util/ArrayList
    //   49: dup
    //   50: invokespecial 33	java/util/ArrayList:<init>	()V
    //   53: astore 4
    //   55: new 39	java/util/HashMap
    //   58: dup
    //   59: invokespecial 40	java/util/HashMap:<init>	()V
    //   62: astore 5
    //   64: aload_1
    //   65: ldc 10
    //   67: invokevirtual 126	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   70: astore 6
    //   72: aload 6
    //   74: ifnull +68 -> 142
    //   77: aload 6
    //   79: arraylength
    //   80: istore_3
    //   81: iconst_0
    //   82: istore_2
    //   83: iload_2
    //   84: iload_3
    //   85: if_icmpge +57 -> 142
    //   88: aload 6
    //   90: iload_2
    //   91: aaload
    //   92: astore 7
    //   94: aload 7
    //   96: invokestatic 56	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   99: ifne +29 -> 128
    //   102: aload 4
    //   104: aload 7
    //   106: invokeinterface 131 2 0
    //   111: pop
    //   112: aload 5
    //   114: aload 7
    //   116: aload 7
    //   118: iconst_2
    //   119: invokestatic 137	java/util/regex/Pattern:compile	(Ljava/lang/String;I)Ljava/util/regex/Pattern;
    //   122: invokeinterface 143 3 0
    //   127: pop
    //   128: iload_2
    //   129: iconst_1
    //   130: iadd
    //   131: istore_2
    //   132: goto -49 -> 83
    //   135: astore 6
    //   137: aload 6
    //   139: invokevirtual 146	java/lang/Throwable:printStackTrace	()V
    //   142: aload_0
    //   143: getfield 47	com/tencent/component/network/downloader/strategy/ConfigKeepAliveStrategy:RW_LOCK	Ljava/util/concurrent/locks/ReadWriteLock;
    //   146: invokeinterface 152 1 0
    //   151: invokeinterface 157 1 0
    //   156: aload_0
    //   157: aload_1
    //   158: putfield 93	com/tencent/component/network/downloader/strategy/ConfigKeepAliveStrategy:mStrCurrConfig	Ljava/lang/String;
    //   161: aload_0
    //   162: getfield 35	com/tencent/component/network/downloader/strategy/ConfigKeepAliveStrategy:mKpDomainRegularList	Ljava/util/List;
    //   165: invokeinterface 160 1 0
    //   170: aload_0
    //   171: getfield 35	com/tencent/component/network/downloader/strategy/ConfigKeepAliveStrategy:mKpDomainRegularList	Ljava/util/List;
    //   174: aload 4
    //   176: invokeinterface 164 2 0
    //   181: pop
    //   182: aload_0
    //   183: getfield 37	com/tencent/component/network/downloader/strategy/ConfigKeepAliveStrategy:mKpDomainCacheList	Ljava/util/List;
    //   186: invokeinterface 160 1 0
    //   191: aload_0
    //   192: getfield 42	com/tencent/component/network/downloader/strategy/ConfigKeepAliveStrategy:mDominPatterns	Ljava/util/Map;
    //   195: invokeinterface 165 1 0
    //   200: aload_0
    //   201: getfield 42	com/tencent/component/network/downloader/strategy/ConfigKeepAliveStrategy:mDominPatterns	Ljava/util/Map;
    //   204: aload 5
    //   206: invokeinterface 169 2 0
    //   211: aload_0
    //   212: getfield 47	com/tencent/component/network/downloader/strategy/ConfigKeepAliveStrategy:RW_LOCK	Ljava/util/concurrent/locks/ReadWriteLock;
    //   215: invokeinterface 152 1 0
    //   220: invokeinterface 172 1 0
    //   225: return
    //   226: astore_1
    //   227: aload_0
    //   228: getfield 47	com/tencent/component/network/downloader/strategy/ConfigKeepAliveStrategy:RW_LOCK	Ljava/util/concurrent/locks/ReadWriteLock;
    //   231: invokeinterface 152 1 0
    //   236: invokeinterface 172 1 0
    //   241: aload_1
    //   242: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	243	0	this	ConfigKeepAliveStrategy
    //   0	243	1	paramString	String
    //   82	50	2	i	int
    //   80	6	3	j	int
    //   53	122	4	localArrayList	ArrayList
    //   62	143	5	localHashMap	HashMap
    //   70	19	6	arrayOfString	String[]
    //   135	3	6	localThrowable	java.lang.Throwable
    //   92	25	7	str	String
    // Exception table:
    //   from	to	target	type
    //   64	72	135	java/lang/Throwable
    //   77	81	135	java/lang/Throwable
    //   94	128	135	java/lang/Throwable
    //   142	211	226	finally
  }
  
  /* Error */
  public final boolean supportKeepAlive(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 56	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: aload_0
    //   10: getfield 47	com/tencent/component/network/downloader/strategy/ConfigKeepAliveStrategy:RW_LOCK	Ljava/util/concurrent/locks/ReadWriteLock;
    //   13: invokeinterface 175 1 0
    //   18: invokeinterface 157 1 0
    //   23: aload_0
    //   24: getfield 37	com/tencent/component/network/downloader/strategy/ConfigKeepAliveStrategy:mKpDomainCacheList	Ljava/util/List;
    //   27: aload_1
    //   28: invokeinterface 178 2 0
    //   33: istore_2
    //   34: iload_2
    //   35: ifeq +19 -> 54
    //   38: aload_0
    //   39: getfield 47	com/tencent/component/network/downloader/strategy/ConfigKeepAliveStrategy:RW_LOCK	Ljava/util/concurrent/locks/ReadWriteLock;
    //   42: invokeinterface 175 1 0
    //   47: invokeinterface 172 1 0
    //   52: iconst_1
    //   53: ireturn
    //   54: aload_0
    //   55: getfield 42	com/tencent/component/network/downloader/strategy/ConfigKeepAliveStrategy:mDominPatterns	Ljava/util/Map;
    //   58: invokeinterface 182 1 0
    //   63: invokeinterface 188 1 0
    //   68: astore_3
    //   69: aload_3
    //   70: invokeinterface 193 1 0
    //   75: ifeq +140 -> 215
    //   78: aload_3
    //   79: invokeinterface 197 1 0
    //   84: checkcast 199	java/util/Map$Entry
    //   87: invokeinterface 202 1 0
    //   92: checkcast 95	java/lang/String
    //   95: astore 4
    //   97: aload_0
    //   98: getfield 42	com/tencent/component/network/downloader/strategy/ConfigKeepAliveStrategy:mDominPatterns	Ljava/util/Map;
    //   101: aload 4
    //   103: invokeinterface 206 2 0
    //   108: checkcast 133	java/util/regex/Pattern
    //   111: aload_1
    //   112: invokestatic 212	com/tencent/component/network/downloader/common/Utils:match	(Ljava/util/regex/Pattern;Ljava/lang/String;)Z
    //   115: istore_2
    //   116: iload_2
    //   117: ifeq -48 -> 69
    //   120: iconst_1
    //   121: istore_2
    //   122: aload_0
    //   123: getfield 47	com/tencent/component/network/downloader/strategy/ConfigKeepAliveStrategy:RW_LOCK	Ljava/util/concurrent/locks/ReadWriteLock;
    //   126: invokeinterface 175 1 0
    //   131: invokeinterface 172 1 0
    //   136: iload_2
    //   137: ifeq +42 -> 179
    //   140: aload_0
    //   141: getfield 47	com/tencent/component/network/downloader/strategy/ConfigKeepAliveStrategy:RW_LOCK	Ljava/util/concurrent/locks/ReadWriteLock;
    //   144: invokeinterface 152 1 0
    //   149: invokeinterface 157 1 0
    //   154: aload_0
    //   155: getfield 37	com/tencent/component/network/downloader/strategy/ConfigKeepAliveStrategy:mKpDomainCacheList	Ljava/util/List;
    //   158: aload_1
    //   159: invokeinterface 131 2 0
    //   164: pop
    //   165: aload_0
    //   166: getfield 47	com/tencent/component/network/downloader/strategy/ConfigKeepAliveStrategy:RW_LOCK	Ljava/util/concurrent/locks/ReadWriteLock;
    //   169: invokeinterface 152 1 0
    //   174: invokeinterface 172 1 0
    //   179: iload_2
    //   180: ireturn
    //   181: astore_1
    //   182: aload_0
    //   183: getfield 47	com/tencent/component/network/downloader/strategy/ConfigKeepAliveStrategy:RW_LOCK	Ljava/util/concurrent/locks/ReadWriteLock;
    //   186: invokeinterface 175 1 0
    //   191: invokeinterface 172 1 0
    //   196: aload_1
    //   197: athrow
    //   198: astore_1
    //   199: aload_0
    //   200: getfield 47	com/tencent/component/network/downloader/strategy/ConfigKeepAliveStrategy:RW_LOCK	Ljava/util/concurrent/locks/ReadWriteLock;
    //   203: invokeinterface 152 1 0
    //   208: invokeinterface 172 1 0
    //   213: aload_1
    //   214: athrow
    //   215: iconst_0
    //   216: istore_2
    //   217: goto -95 -> 122
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	220	0	this	ConfigKeepAliveStrategy
    //   0	220	1	paramString	String
    //   33	184	2	bool	boolean
    //   68	11	3	localIterator	java.util.Iterator
    //   95	7	4	str	String
    // Exception table:
    //   from	to	target	type
    //   9	34	181	finally
    //   54	69	181	finally
    //   69	116	181	finally
    //   140	165	198	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.component.network.downloader.strategy.ConfigKeepAliveStrategy
 * JD-Core Version:    0.7.0.1
 */
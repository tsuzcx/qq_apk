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
import org.apache.http.HttpRequest;

public class ConfigKeepAliveStrategy
  implements KeepAliveStrategy
{
  private String jdField_a_of_type_JavaLangString;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private Map jdField_a_of_type_JavaUtilMap = new HashMap();
  private ReadWriteLock jdField_a_of_type_JavaUtilConcurrentLocksReadWriteLock = new ReentrantReadWriteLock();
  private List b = new ArrayList();
  
  public final KeepAliveStrategy.KeepAlive a(String paramString, HttpRequest paramHttpRequest, HttpUtil.RequestOptions paramRequestOptions)
  {
    if (TextUtils.isEmpty(paramString)) {
      return KeepAliveStrategy.KeepAlive.DISABLE;
    }
    if (!a(paramString)) {
      return KeepAliveStrategy.KeepAlive.DISABLE;
    }
    boolean bool = HttpUtil.a(paramHttpRequest, paramRequestOptions);
    int j = Config.a();
    int i = j;
    if (bool)
    {
      int k = Config.b();
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
  public void a(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +14 -> 15
    //   4: aload_1
    //   5: aload_0
    //   6: getfield 73	com/tencent/component/network/downloader/strategy/ConfigKeepAliveStrategy:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   9: invokevirtual 79	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12: ifeq +4 -> 16
    //   15: return
    //   16: invokestatic 84	com/tencent/component/network/module/base/QDLog:b	()Z
    //   19: ifeq +27 -> 46
    //   22: ldc 86
    //   24: new 88	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   31: ldc 91
    //   33: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: aload_1
    //   37: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokestatic 102	com/tencent/component/network/module/base/QDLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   46: new 18	java/util/ArrayList
    //   49: dup
    //   50: invokespecial 19	java/util/ArrayList:<init>	()V
    //   53: astore 4
    //   55: new 25	java/util/HashMap
    //   58: dup
    //   59: invokespecial 26	java/util/HashMap:<init>	()V
    //   62: astore 5
    //   64: aload_1
    //   65: ldc 104
    //   67: invokevirtual 108	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
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
    //   96: invokestatic 41	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   99: ifne +29 -> 128
    //   102: aload 4
    //   104: aload 7
    //   106: invokeinterface 113 2 0
    //   111: pop
    //   112: aload 5
    //   114: aload 7
    //   116: aload 7
    //   118: iconst_2
    //   119: invokestatic 119	java/util/regex/Pattern:compile	(Ljava/lang/String;I)Ljava/util/regex/Pattern;
    //   122: invokeinterface 125 3 0
    //   127: pop
    //   128: iload_2
    //   129: iconst_1
    //   130: iadd
    //   131: istore_2
    //   132: goto -49 -> 83
    //   135: astore 6
    //   137: aload 6
    //   139: invokevirtual 128	java/lang/Throwable:printStackTrace	()V
    //   142: aload_0
    //   143: getfield 33	com/tencent/component/network/downloader/strategy/ConfigKeepAliveStrategy:jdField_a_of_type_JavaUtilConcurrentLocksReadWriteLock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   146: invokeinterface 134 1 0
    //   151: invokeinterface 139 1 0
    //   156: aload_0
    //   157: aload_1
    //   158: putfield 73	com/tencent/component/network/downloader/strategy/ConfigKeepAliveStrategy:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   161: aload_0
    //   162: getfield 21	com/tencent/component/network/downloader/strategy/ConfigKeepAliveStrategy:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   165: invokeinterface 142 1 0
    //   170: aload_0
    //   171: getfield 21	com/tencent/component/network/downloader/strategy/ConfigKeepAliveStrategy:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   174: aload 4
    //   176: invokeinterface 146 2 0
    //   181: pop
    //   182: aload_0
    //   183: getfield 23	com/tencent/component/network/downloader/strategy/ConfigKeepAliveStrategy:b	Ljava/util/List;
    //   186: invokeinterface 142 1 0
    //   191: aload_0
    //   192: getfield 28	com/tencent/component/network/downloader/strategy/ConfigKeepAliveStrategy:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   195: invokeinterface 147 1 0
    //   200: aload_0
    //   201: getfield 28	com/tencent/component/network/downloader/strategy/ConfigKeepAliveStrategy:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   204: aload 5
    //   206: invokeinterface 151 2 0
    //   211: aload_0
    //   212: getfield 33	com/tencent/component/network/downloader/strategy/ConfigKeepAliveStrategy:jdField_a_of_type_JavaUtilConcurrentLocksReadWriteLock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   215: invokeinterface 134 1 0
    //   220: invokeinterface 154 1 0
    //   225: return
    //   226: astore_1
    //   227: aload_0
    //   228: getfield 33	com/tencent/component/network/downloader/strategy/ConfigKeepAliveStrategy:jdField_a_of_type_JavaUtilConcurrentLocksReadWriteLock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   231: invokeinterface 134 1 0
    //   236: invokeinterface 154 1 0
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
  public final boolean a(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 41	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +7 -> 11
    //   7: iconst_0
    //   8: istore_3
    //   9: iload_3
    //   10: ireturn
    //   11: aload_0
    //   12: getfield 33	com/tencent/component/network/downloader/strategy/ConfigKeepAliveStrategy:jdField_a_of_type_JavaUtilConcurrentLocksReadWriteLock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   15: invokeinterface 157 1 0
    //   20: invokeinterface 139 1 0
    //   25: aload_0
    //   26: getfield 23	com/tencent/component/network/downloader/strategy/ConfigKeepAliveStrategy:b	Ljava/util/List;
    //   29: aload_1
    //   30: invokeinterface 160 2 0
    //   35: istore_2
    //   36: iload_2
    //   37: ifeq +19 -> 56
    //   40: aload_0
    //   41: getfield 33	com/tencent/component/network/downloader/strategy/ConfigKeepAliveStrategy:jdField_a_of_type_JavaUtilConcurrentLocksReadWriteLock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   44: invokeinterface 157 1 0
    //   49: invokeinterface 154 1 0
    //   54: iconst_1
    //   55: ireturn
    //   56: aload_0
    //   57: getfield 28	com/tencent/component/network/downloader/strategy/ConfigKeepAliveStrategy:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   60: invokeinterface 164 1 0
    //   65: invokeinterface 170 1 0
    //   70: astore 4
    //   72: aload 4
    //   74: invokeinterface 175 1 0
    //   79: ifeq +143 -> 222
    //   82: aload 4
    //   84: invokeinterface 179 1 0
    //   89: checkcast 181	java/util/Map$Entry
    //   92: invokeinterface 184 1 0
    //   97: checkcast 75	java/lang/String
    //   100: astore 5
    //   102: aload_0
    //   103: getfield 28	com/tencent/component/network/downloader/strategy/ConfigKeepAliveStrategy:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   106: aload 5
    //   108: invokeinterface 188 2 0
    //   113: checkcast 115	java/util/regex/Pattern
    //   116: aload_1
    //   117: invokestatic 194	com/tencent/component/network/downloader/common/Utils:match	(Ljava/util/regex/Pattern;Ljava/lang/String;)Z
    //   120: istore_2
    //   121: iload_2
    //   122: ifeq -50 -> 72
    //   125: iconst_1
    //   126: istore_2
    //   127: aload_0
    //   128: getfield 33	com/tencent/component/network/downloader/strategy/ConfigKeepAliveStrategy:jdField_a_of_type_JavaUtilConcurrentLocksReadWriteLock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   131: invokeinterface 157 1 0
    //   136: invokeinterface 154 1 0
    //   141: iload_2
    //   142: istore_3
    //   143: iload_2
    //   144: ifeq -135 -> 9
    //   147: aload_0
    //   148: getfield 33	com/tencent/component/network/downloader/strategy/ConfigKeepAliveStrategy:jdField_a_of_type_JavaUtilConcurrentLocksReadWriteLock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   151: invokeinterface 134 1 0
    //   156: invokeinterface 139 1 0
    //   161: aload_0
    //   162: getfield 23	com/tencent/component/network/downloader/strategy/ConfigKeepAliveStrategy:b	Ljava/util/List;
    //   165: aload_1
    //   166: invokeinterface 113 2 0
    //   171: pop
    //   172: aload_0
    //   173: getfield 33	com/tencent/component/network/downloader/strategy/ConfigKeepAliveStrategy:jdField_a_of_type_JavaUtilConcurrentLocksReadWriteLock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   176: invokeinterface 134 1 0
    //   181: invokeinterface 154 1 0
    //   186: iload_2
    //   187: ireturn
    //   188: astore_1
    //   189: aload_0
    //   190: getfield 33	com/tencent/component/network/downloader/strategy/ConfigKeepAliveStrategy:jdField_a_of_type_JavaUtilConcurrentLocksReadWriteLock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   193: invokeinterface 157 1 0
    //   198: invokeinterface 154 1 0
    //   203: aload_1
    //   204: athrow
    //   205: astore_1
    //   206: aload_0
    //   207: getfield 33	com/tencent/component/network/downloader/strategy/ConfigKeepAliveStrategy:jdField_a_of_type_JavaUtilConcurrentLocksReadWriteLock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   210: invokeinterface 134 1 0
    //   215: invokeinterface 154 1 0
    //   220: aload_1
    //   221: athrow
    //   222: iconst_0
    //   223: istore_2
    //   224: goto -97 -> 127
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	227	0	this	ConfigKeepAliveStrategy
    //   0	227	1	paramString	String
    //   35	189	2	bool1	boolean
    //   8	135	3	bool2	boolean
    //   70	13	4	localIterator	java.util.Iterator
    //   100	7	5	str	String
    // Exception table:
    //   from	to	target	type
    //   11	36	188	finally
    //   56	72	188	finally
    //   72	121	188	finally
    //   147	172	205	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.downloader.strategy.ConfigKeepAliveStrategy
 * JD-Core Version:    0.7.0.1
 */
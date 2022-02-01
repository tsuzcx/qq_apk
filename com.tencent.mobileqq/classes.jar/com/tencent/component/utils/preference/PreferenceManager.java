package com.tencent.component.utils.preference;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.component.network.module.cache.common.LruCache;
import java.io.File;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class PreferenceManager
{
  private static final String CACHE_NAME = "cache_pref";
  private static final String DEFAULT_NAME = "default_pref";
  private static final float DEFAULT_VERSION = 0.0F;
  private static final long GLOBAL_UID = 0L;
  private static final boolean OPTIMIZE = true;
  private static final int OPTIMIZE_BOUNDS = 1;
  private static final String OPTIMIZE_PREFIX = "preferences";
  private static final LruCache<String, SharedPreferences> sSharedPrefs = new LruCache(12);
  private static final ReentrantReadWriteLock sUniqueReadWriteLock = new ReentrantReadWriteLock();
  
  private static String convertToString(float paramFloat)
  {
    int i = (int)paramFloat;
    if (paramFloat == i) {
      return String.valueOf(i);
    }
    return String.valueOf(paramFloat);
  }
  
  public static SharedPreferences getCacheGlobalPreference(Context paramContext)
  {
    return obtainPreference(paramContext, 0L, "cache_pref", 0.0F);
  }
  
  public static SharedPreferences getCacheGlobalPreference(Context paramContext, float paramFloat)
  {
    return obtainPreference(paramContext, 0L, "cache_pref", paramFloat);
  }
  
  public static SharedPreferences getCachePreference(Context paramContext, long paramLong)
  {
    return obtainPreference(paramContext, paramLong, "cache_pref", 0.0F);
  }
  
  public static SharedPreferences getCachePreference(Context paramContext, long paramLong, float paramFloat)
  {
    return obtainPreference(paramContext, paramLong, "cache_pref", paramFloat);
  }
  
  public static SharedPreferences getDefaultGlobalPreference(Context paramContext)
  {
    return obtainPreference(paramContext, 0L, "default_pref", 0.0F);
  }
  
  public static SharedPreferences getDefaultGlobalPreference(Context paramContext, float paramFloat)
  {
    return obtainPreference(paramContext, 0L, "default_pref", paramFloat);
  }
  
  public static SharedPreferences getDefaultGlobalPreference(Context paramContext, boolean paramBoolean)
  {
    return obtainPreference(paramContext, 0L, "default_pref", 0.0F, paramBoolean);
  }
  
  public static SharedPreferences getDefaultPreference(Context paramContext, long paramLong)
  {
    return obtainPreference(paramContext, paramLong, "default_pref", 0.0F);
  }
  
  public static SharedPreferences getDefaultPreference(Context paramContext, long paramLong, float paramFloat)
  {
    return obtainPreference(paramContext, paramLong, "default_pref", paramFloat);
  }
  
  public static SharedPreferences getGlobalPreference(Context paramContext, String paramString)
  {
    return obtainPreference(paramContext, 0L, paramString, 0.0F);
  }
  
  public static SharedPreferences getGlobalPreference(Context paramContext, String paramString, float paramFloat)
  {
    return obtainPreference(paramContext, 0L, paramString, paramFloat);
  }
  
  public static SharedPreferences getPreference(Context paramContext, long paramLong, String paramString)
  {
    return obtainPreference(paramContext, paramLong, paramString, 0.0F);
  }
  
  public static SharedPreferences getPreference(Context paramContext, long paramLong, String paramString, float paramFloat)
  {
    return obtainPreference(paramContext, paramLong, paramString, paramFloat);
  }
  
  private static String obtainLegalName(String paramString)
  {
    if (paramString == null) {
      return paramString;
    }
    String str = paramString;
    if (paramString.indexOf(File.separatorChar) >= 0) {
      str = paramString.replaceAll(File.separator, "_");
    }
    return str;
  }
  
  private static String obtainOptimizeName(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    int j = paramString.hashCode() % 1;
    int i = j;
    if (j < 0) {
      i = j + 1;
    }
    paramString = new StringBuilder();
    paramString.append("preferences");
    paramString.append(i);
    return paramString.toString();
  }
  
  private static SharedPreferences obtainPreference(Context paramContext, long paramLong, String paramString, float paramFloat)
  {
    return obtainPreference(paramContext, paramLong, paramString, paramFloat, false);
  }
  
  /* Error */
  private static SharedPreferences obtainPreference(Context paramContext, long paramLong, String paramString, float paramFloat, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_3
    //   1: invokestatic 128	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +9 -> 13
    //   7: ldc 11
    //   9: astore_3
    //   10: goto +8 -> 18
    //   13: aload_3
    //   14: invokestatic 130	com/tencent/component/utils/preference/PreferenceManager:obtainLegalName	(Ljava/lang/String;)Ljava/lang/String;
    //   17: astore_3
    //   18: ldc 132
    //   20: astore 6
    //   22: iload 5
    //   24: ifeq +120 -> 144
    //   27: lload_1
    //   28: lconst_0
    //   29: lcmp
    //   30: ifne +6 -> 36
    //   33: goto +9 -> 42
    //   36: lload_1
    //   37: invokestatic 135	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   40: astore 6
    //   42: new 108	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   49: astore 7
    //   51: aload 7
    //   53: aload 6
    //   55: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: aload 7
    //   61: ldc 97
    //   63: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: aload 7
    //   69: aload_3
    //   70: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: aload 7
    //   76: ldc 97
    //   78: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload 7
    //   84: fload 4
    //   86: invokestatic 137	com/tencent/component/utils/preference/PreferenceManager:convertToString	(F)Ljava/lang/String;
    //   89: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: aload 7
    //   95: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: astore_3
    //   99: new 108	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   106: astore 6
    //   108: aload 6
    //   110: aload_0
    //   111: invokevirtual 142	android/content/Context:getPackageName	()Ljava/lang/String;
    //   114: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: aload 6
    //   120: ldc 97
    //   122: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: pop
    //   126: aload 6
    //   128: aload_3
    //   129: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: aload_0
    //   134: aload 6
    //   136: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: iconst_0
    //   140: invokevirtual 146	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   143: areturn
    //   144: lload_1
    //   145: lconst_0
    //   146: lcmp
    //   147: ifne +6 -> 153
    //   150: goto +9 -> 159
    //   153: lload_1
    //   154: invokestatic 135	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   157: astore 6
    //   159: new 108	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   166: astore 7
    //   168: aload 7
    //   170: aload 6
    //   172: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: pop
    //   176: aload 7
    //   178: ldc 97
    //   180: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload 7
    //   186: aload_3
    //   187: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: aload 7
    //   193: ldc 97
    //   195: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: pop
    //   199: aload 7
    //   201: fload 4
    //   203: invokestatic 137	com/tencent/component/utils/preference/PreferenceManager:convertToString	(F)Ljava/lang/String;
    //   206: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: pop
    //   210: aload 7
    //   212: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: astore 9
    //   217: getstatic 47	com/tencent/component/utils/preference/PreferenceManager:sUniqueReadWriteLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   220: invokevirtual 150	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   223: astore 6
    //   225: aload 6
    //   227: ifnull +10 -> 237
    //   230: aload 6
    //   232: invokeinterface 155 1 0
    //   237: getstatic 41	com/tencent/component/utils/preference/PreferenceManager:sSharedPrefs	Lcom/tencent/component/network/module/cache/common/LruCache;
    //   240: aload 9
    //   242: invokevirtual 159	com/tencent/component/network/module/cache/common/LruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   245: checkcast 161	android/content/SharedPreferences
    //   248: astore_3
    //   249: aload_3
    //   250: ifnull +17 -> 267
    //   253: aload 6
    //   255: ifnull +10 -> 265
    //   258: aload 6
    //   260: invokeinterface 164 1 0
    //   265: aload_3
    //   266: areturn
    //   267: aload 6
    //   269: ifnull +10 -> 279
    //   272: aload 6
    //   274: invokeinterface 164 1 0
    //   279: getstatic 47	com/tencent/component/utils/preference/PreferenceManager:sUniqueReadWriteLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   282: invokevirtual 168	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   285: astore 8
    //   287: aload 8
    //   289: ifnull +10 -> 299
    //   292: aload 8
    //   294: invokeinterface 155 1 0
    //   299: getstatic 41	com/tencent/component/utils/preference/PreferenceManager:sSharedPrefs	Lcom/tencent/component/network/module/cache/common/LruCache;
    //   302: aload 9
    //   304: invokevirtual 159	com/tencent/component/network/module/cache/common/LruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   307: checkcast 161	android/content/SharedPreferences
    //   310: astore 6
    //   312: aload 6
    //   314: ifnonnull +127 -> 441
    //   317: new 108	java/lang/StringBuilder
    //   320: dup
    //   321: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   324: astore_3
    //   325: aload_3
    //   326: aload_0
    //   327: invokevirtual 142	android/content/Context:getPackageName	()Ljava/lang/String;
    //   330: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: pop
    //   334: aload_3
    //   335: ldc 97
    //   337: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: pop
    //   341: aload_3
    //   342: aload 9
    //   344: invokestatic 170	com/tencent/component/utils/preference/PreferenceManager:obtainOptimizeName	(Ljava/lang/String;)Ljava/lang/String;
    //   347: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: pop
    //   351: aload_0
    //   352: aload_3
    //   353: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   356: iconst_0
    //   357: invokevirtual 146	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   360: astore 7
    //   362: aload 7
    //   364: astore_0
    //   365: aload 7
    //   367: ifnull +52 -> 419
    //   370: aload 7
    //   372: astore_3
    //   373: new 108	java/lang/StringBuilder
    //   376: dup
    //   377: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   380: astore_0
    //   381: aload 7
    //   383: astore_3
    //   384: aload_0
    //   385: aload 9
    //   387: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: pop
    //   391: aload 7
    //   393: astore_3
    //   394: aload_0
    //   395: ldc 172
    //   397: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: pop
    //   401: aload 7
    //   403: astore_3
    //   404: new 174	com/tencent/component/utils/preference/OptimizedSharedPreferencesWrapper
    //   407: dup
    //   408: aload 7
    //   410: aload_0
    //   411: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   414: iconst_1
    //   415: invokespecial 177	com/tencent/component/utils/preference/OptimizedSharedPreferencesWrapper:<init>	(Landroid/content/SharedPreferences;Ljava/lang/String;Z)V
    //   418: astore_0
    //   419: aload_0
    //   420: astore_3
    //   421: getstatic 41	com/tencent/component/utils/preference/PreferenceManager:sSharedPrefs	Lcom/tencent/component/network/module/cache/common/LruCache;
    //   424: aload 9
    //   426: aload_0
    //   427: invokevirtual 181	com/tencent/component/network/module/cache/common/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   430: pop
    //   431: goto +13 -> 444
    //   434: astore_0
    //   435: aload 6
    //   437: astore_3
    //   438: goto +28 -> 466
    //   441: aload 6
    //   443: astore_0
    //   444: aload_0
    //   445: astore 6
    //   447: aload 8
    //   449: ifnull +71 -> 520
    //   452: aload 8
    //   454: invokeinterface 164 1 0
    //   459: aload_0
    //   460: areturn
    //   461: astore_0
    //   462: goto +61 -> 523
    //   465: astore_0
    //   466: aload_0
    //   467: invokevirtual 184	java/lang/Exception:printStackTrace	()V
    //   470: new 108	java/lang/StringBuilder
    //   473: dup
    //   474: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   477: astore 6
    //   479: aload 6
    //   481: ldc 186
    //   483: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: pop
    //   487: aload 6
    //   489: aload_0
    //   490: invokevirtual 189	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   493: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: pop
    //   497: ldc 191
    //   499: aload 6
    //   501: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   504: invokestatic 197	com/tencent/ttpic/baseutils/log/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   507: aload_3
    //   508: astore 6
    //   510: aload 8
    //   512: ifnull +8 -> 520
    //   515: aload_3
    //   516: astore_0
    //   517: goto -65 -> 452
    //   520: aload 6
    //   522: areturn
    //   523: aload 8
    //   525: ifnull +10 -> 535
    //   528: aload 8
    //   530: invokeinterface 164 1 0
    //   535: aload_0
    //   536: athrow
    //   537: astore_0
    //   538: aload 6
    //   540: ifnull +10 -> 550
    //   543: aload 6
    //   545: invokeinterface 164 1 0
    //   550: goto +5 -> 555
    //   553: aload_0
    //   554: athrow
    //   555: goto -2 -> 553
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	558	0	paramContext	Context
    //   0	558	1	paramLong	long
    //   0	558	3	paramString	String
    //   0	558	4	paramFloat	float
    //   0	558	5	paramBoolean	boolean
    //   20	524	6	localObject1	Object
    //   49	360	7	localObject2	Object
    //   285	244	8	localWriteLock	java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock
    //   215	210	9	str	String
    // Exception table:
    //   from	to	target	type
    //   317	362	434	java/lang/Exception
    //   299	312	461	finally
    //   317	362	461	finally
    //   373	381	461	finally
    //   384	391	461	finally
    //   394	401	461	finally
    //   404	419	461	finally
    //   421	431	461	finally
    //   466	507	461	finally
    //   299	312	465	java/lang/Exception
    //   373	381	465	java/lang/Exception
    //   384	391	465	java/lang/Exception
    //   394	401	465	java/lang/Exception
    //   404	419	465	java/lang/Exception
    //   421	431	465	java/lang/Exception
    //   237	249	537	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.utils.preference.PreferenceManager
 * JD-Core Version:    0.7.0.1
 */
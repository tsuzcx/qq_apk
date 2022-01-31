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
  private static final LruCache sSharedPrefs = new LruCache(12);
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
    if (paramString == null) {}
    while (paramString.indexOf(File.separatorChar) < 0) {
      return paramString;
    }
    return paramString.replaceAll(File.separator, "_");
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
    return "preferences" + i;
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
    //   1: invokestatic 127	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +93 -> 97
    //   7: ldc 11
    //   9: astore_3
    //   10: iload 5
    //   12: ifeq +102 -> 114
    //   15: lload_1
    //   16: lconst_0
    //   17: lcmp
    //   18: ifne +87 -> 105
    //   21: ldc 129
    //   23: astore 6
    //   25: new 107	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   32: aload 6
    //   34: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc 96
    //   39: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_3
    //   43: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: ldc 96
    //   48: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: fload 4
    //   53: invokestatic 131	com/tencent/component/utils/preference/PreferenceManager:convertToString	(F)Ljava/lang/String;
    //   56: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: astore_3
    //   63: aload_0
    //   64: new 107	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   71: aload_0
    //   72: invokevirtual 136	android/content/Context:getPackageName	()Ljava/lang/String;
    //   75: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: ldc 96
    //   80: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: aload_3
    //   84: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: iconst_0
    //   91: invokevirtual 140	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   94: astore_0
    //   95: aload_0
    //   96: areturn
    //   97: aload_3
    //   98: invokestatic 142	com/tencent/component/utils/preference/PreferenceManager:obtainLegalName	(Ljava/lang/String;)Ljava/lang/String;
    //   101: astore_3
    //   102: goto -92 -> 10
    //   105: lload_1
    //   106: invokestatic 145	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   109: astore 6
    //   111: goto -86 -> 25
    //   114: lload_1
    //   115: lconst_0
    //   116: lcmp
    //   117: ifne +98 -> 215
    //   120: ldc 129
    //   122: astore 6
    //   124: new 107	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   131: aload 6
    //   133: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: ldc 96
    //   138: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: aload_3
    //   142: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: ldc 96
    //   147: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: fload 4
    //   152: invokestatic 131	com/tencent/component/utils/preference/PreferenceManager:convertToString	(F)Ljava/lang/String;
    //   155: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: astore 8
    //   163: getstatic 46	com/tencent/component/utils/preference/PreferenceManager:sUniqueReadWriteLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   166: invokevirtual 149	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   169: astore 6
    //   171: aload 6
    //   173: ifnull +10 -> 183
    //   176: aload 6
    //   178: invokeinterface 154 1 0
    //   183: getstatic 40	com/tencent/component/utils/preference/PreferenceManager:sSharedPrefs	Lcom/tencent/component/network/module/cache/common/LruCache;
    //   186: aload 8
    //   188: invokevirtual 158	com/tencent/component/network/module/cache/common/LruCache:a	(Ljava/lang/Object;)Ljava/lang/Object;
    //   191: checkcast 160	android/content/SharedPreferences
    //   194: astore_3
    //   195: aload_3
    //   196: ifnull +28 -> 224
    //   199: aload_3
    //   200: astore_0
    //   201: aload 6
    //   203: ifnull -108 -> 95
    //   206: aload 6
    //   208: invokeinterface 163 1 0
    //   213: aload_3
    //   214: areturn
    //   215: lload_1
    //   216: invokestatic 145	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   219: astore 6
    //   221: goto -97 -> 124
    //   224: aload 6
    //   226: ifnull +10 -> 236
    //   229: aload 6
    //   231: invokeinterface 163 1 0
    //   236: getstatic 46	com/tencent/component/utils/preference/PreferenceManager:sUniqueReadWriteLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   239: invokevirtual 167	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   242: astore 7
    //   244: aload 7
    //   246: ifnull +10 -> 256
    //   249: aload 7
    //   251: invokeinterface 154 1 0
    //   256: getstatic 40	com/tencent/component/utils/preference/PreferenceManager:sSharedPrefs	Lcom/tencent/component/network/module/cache/common/LruCache;
    //   259: aload 8
    //   261: invokevirtual 158	com/tencent/component/network/module/cache/common/LruCache:a	(Ljava/lang/Object;)Ljava/lang/Object;
    //   264: checkcast 160	android/content/SharedPreferences
    //   267: astore 6
    //   269: aload 6
    //   271: astore_3
    //   272: aload 6
    //   274: ifnonnull +92 -> 366
    //   277: aload 6
    //   279: astore_3
    //   280: aload_0
    //   281: new 107	java/lang/StringBuilder
    //   284: dup
    //   285: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   288: aload_0
    //   289: invokevirtual 136	android/content/Context:getPackageName	()Ljava/lang/String;
    //   292: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: ldc 96
    //   297: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: aload 8
    //   302: invokestatic 169	com/tencent/component/utils/preference/PreferenceManager:obtainOptimizeName	(Ljava/lang/String;)Ljava/lang/String;
    //   305: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   311: iconst_0
    //   312: invokevirtual 140	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   315: astore_0
    //   316: aload_0
    //   317: astore_3
    //   318: aload_3
    //   319: astore_0
    //   320: aload_3
    //   321: ifnull +33 -> 354
    //   324: new 171	pkf
    //   327: dup
    //   328: aload_3
    //   329: new 107	java/lang/StringBuilder
    //   332: dup
    //   333: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   336: aload 8
    //   338: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: ldc 173
    //   343: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   349: iconst_1
    //   350: invokespecial 176	pkf:<init>	(Landroid/content/SharedPreferences;Ljava/lang/String;Z)V
    //   353: astore_0
    //   354: getstatic 40	com/tencent/component/utils/preference/PreferenceManager:sSharedPrefs	Lcom/tencent/component/network/module/cache/common/LruCache;
    //   357: aload 8
    //   359: aload_0
    //   360: invokevirtual 179	com/tencent/component/network/module/cache/common/LruCache:a	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   363: pop
    //   364: aload_0
    //   365: astore_3
    //   366: aload_3
    //   367: astore_0
    //   368: aload 7
    //   370: ifnull -275 -> 95
    //   373: aload 7
    //   375: invokeinterface 163 1 0
    //   380: aload_3
    //   381: areturn
    //   382: astore_0
    //   383: aload 6
    //   385: ifnull +10 -> 395
    //   388: aload 6
    //   390: invokeinterface 163 1 0
    //   395: aload_0
    //   396: athrow
    //   397: astore_0
    //   398: aload_0
    //   399: invokevirtual 182	java/lang/Exception:printStackTrace	()V
    //   402: ldc 184
    //   404: new 107	java/lang/StringBuilder
    //   407: dup
    //   408: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   411: ldc 186
    //   413: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: aload_0
    //   417: invokevirtual 189	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   420: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   426: invokestatic 195	com/tencent/util/LogUtil:i	(Ljava/lang/Object;Ljava/lang/String;)I
    //   429: pop
    //   430: aload_3
    //   431: astore_0
    //   432: aload 7
    //   434: ifnull -339 -> 95
    //   437: aload 7
    //   439: invokeinterface 163 1 0
    //   444: aload_3
    //   445: areturn
    //   446: astore_0
    //   447: aload 7
    //   449: ifnull +10 -> 459
    //   452: aload 7
    //   454: invokeinterface 163 1 0
    //   459: aload_0
    //   460: athrow
    //   461: astore_0
    //   462: goto -64 -> 398
    //   465: astore 6
    //   467: aload_0
    //   468: astore_3
    //   469: aload 6
    //   471: astore_0
    //   472: goto -74 -> 398
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	475	0	paramContext	Context
    //   0	475	1	paramLong	long
    //   0	475	3	paramString	String
    //   0	475	4	paramFloat	float
    //   0	475	5	paramBoolean	boolean
    //   23	366	6	localObject	Object
    //   465	5	6	localException	java.lang.Exception
    //   242	211	7	localWriteLock	java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock
    //   161	197	8	str	String
    // Exception table:
    //   from	to	target	type
    //   183	195	382	finally
    //   256	269	397	java/lang/Exception
    //   280	316	397	java/lang/Exception
    //   256	269	446	finally
    //   280	316	446	finally
    //   324	354	446	finally
    //   354	364	446	finally
    //   398	430	446	finally
    //   324	354	461	java/lang/Exception
    //   354	364	465	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.component.utils.preference.PreferenceManager
 * JD-Core Version:    0.7.0.1
 */
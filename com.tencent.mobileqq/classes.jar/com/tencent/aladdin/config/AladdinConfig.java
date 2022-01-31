package com.tencent.aladdin.config;

import android.support.annotation.GuardedBy;
import android.support.annotation.NonNull;
import com.tencent.aladdin.config.network.AsyncTaskExecutor;
import com.tencent.aladdin.config.parse.AladdinConfigBean;
import com.tencent.aladdin.config.parse.AladdinConfigParser;
import com.tencent.aladdin.config.utils.Log;
import java.io.File;
import java.io.StringReader;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AladdinConfig
{
  private static final String TAG = "AladdinConfig";
  private final AsyncTaskExecutor asyncTaskExecutor;
  private final File mBackupFile;
  private final int mConfigId;
  private final File mFile;
  private final Object mFileLock = new Object();
  @GuardedBy("mLock")
  private boolean mLoaded = false;
  private final Object mLock = new Object();
  @GuardedBy("mLock")
  private Map<String, ?> mMap = null;
  private final AladdinConfigParser mParser;
  
  AladdinConfig(@NonNull String paramString, int paramInt, @NonNull AsyncTaskExecutor paramAsyncTaskExecutor, @NonNull AladdinConfigParser paramAladdinConfigParser)
  {
    Log.d("AladdinConfig", "AladdinConfig: construct");
    this.mConfigId = paramInt;
    this.mFile = new File(paramString);
    this.mBackupFile = new File(paramString + ".backup");
    this.asyncTaskExecutor = paramAsyncTaskExecutor;
    this.mParser = paramAladdinConfigParser;
    startLoadFromDisk();
  }
  
  private void awaitLoadedLocked()
  {
    while (!this.mLoaded) {
      try
      {
        this.mLock.wait();
      }
      catch (InterruptedException localInterruptedException) {}
    }
  }
  
  /* Error */
  private void loadFromDisk()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: ldc 8
    //   5: new 60	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   12: ldc 100
    //   14: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: aload_0
    //   18: getfield 51	com/tencent/aladdin/config/AladdinConfig:mConfigId	I
    //   21: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   24: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: invokestatic 49	com/tencent/aladdin/config/utils/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   30: aload_0
    //   31: getfield 35	com/tencent/aladdin/config/AladdinConfig:mLock	Ljava/lang/Object;
    //   34: astore_3
    //   35: aload_3
    //   36: monitorenter
    //   37: aload_0
    //   38: getfield 39	com/tencent/aladdin/config/AladdinConfig:mLoaded	Z
    //   41: ifeq +33 -> 74
    //   44: ldc 8
    //   46: new 60	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   53: ldc 105
    //   55: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload_0
    //   59: getfield 51	com/tencent/aladdin/config/AladdinConfig:mConfigId	I
    //   62: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   65: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: invokestatic 49	com/tencent/aladdin/config/utils/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   71: aload_3
    //   72: monitorexit
    //   73: return
    //   74: aload_0
    //   75: getfield 73	com/tencent/aladdin/config/AladdinConfig:mBackupFile	Ljava/io/File;
    //   78: invokevirtual 109	java/io/File:exists	()Z
    //   81: ifeq +56 -> 137
    //   84: aload_0
    //   85: getfield 58	com/tencent/aladdin/config/AladdinConfig:mFile	Ljava/io/File;
    //   88: invokevirtual 112	java/io/File:delete	()Z
    //   91: istore_1
    //   92: aload_0
    //   93: getfield 73	com/tencent/aladdin/config/AladdinConfig:mBackupFile	Ljava/io/File;
    //   96: aload_0
    //   97: getfield 58	com/tencent/aladdin/config/AladdinConfig:mFile	Ljava/io/File;
    //   100: invokevirtual 116	java/io/File:renameTo	(Ljava/io/File;)Z
    //   103: istore_2
    //   104: ldc 8
    //   106: new 60	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   113: ldc 118
    //   115: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: iload_1
    //   119: invokevirtual 121	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   122: ldc 123
    //   124: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: iload_2
    //   128: invokevirtual 121	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   131: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: invokestatic 126	com/tencent/aladdin/config/utils/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   137: aload_3
    //   138: monitorexit
    //   139: new 128	java/io/FileReader
    //   142: dup
    //   143: aload_0
    //   144: getfield 58	com/tencent/aladdin/config/AladdinConfig:mFile	Ljava/io/File;
    //   147: invokespecial 131	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   150: astore 6
    //   152: aload 6
    //   154: astore 5
    //   156: aload_0
    //   157: getfield 35	com/tencent/aladdin/config/AladdinConfig:mLock	Ljava/lang/Object;
    //   160: astore 8
    //   162: aload 6
    //   164: astore 5
    //   166: aload 8
    //   168: monitorenter
    //   169: aload_0
    //   170: getfield 77	com/tencent/aladdin/config/AladdinConfig:mParser	Lcom/tencent/aladdin/config/parse/AladdinConfigParser;
    //   173: aload 6
    //   175: invokeinterface 137 2 0
    //   180: astore_3
    //   181: aload 8
    //   183: monitorexit
    //   184: aload 6
    //   186: astore 5
    //   188: aload 6
    //   190: invokevirtual 140	java/io/FileReader:close	()V
    //   193: aload_3
    //   194: astore 4
    //   196: aload 6
    //   198: ifnull +11 -> 209
    //   201: aload 6
    //   203: invokevirtual 140	java/io/FileReader:close	()V
    //   206: aload_3
    //   207: astore 4
    //   209: aload_0
    //   210: getfield 35	com/tencent/aladdin/config/AladdinConfig:mLock	Ljava/lang/Object;
    //   213: astore_3
    //   214: aload_3
    //   215: monitorenter
    //   216: aload_0
    //   217: iconst_1
    //   218: putfield 39	com/tencent/aladdin/config/AladdinConfig:mLoaded	Z
    //   221: aload 4
    //   223: ifnull +475 -> 698
    //   226: aload_0
    //   227: aload 4
    //   229: putfield 41	com/tencent/aladdin/config/AladdinConfig:mMap	Ljava/util/Map;
    //   232: invokestatic 143	com/tencent/aladdin/config/utils/Log:isDebugVersion	()Z
    //   235: ifeq +45 -> 280
    //   238: ldc 8
    //   240: new 60	java/lang/StringBuilder
    //   243: dup
    //   244: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   247: ldc 145
    //   249: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: aload_0
    //   253: getfield 58	com/tencent/aladdin/config/AladdinConfig:mFile	Ljava/io/File;
    //   256: invokevirtual 148	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   259: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: ldc 150
    //   264: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: aload_0
    //   268: getfield 41	com/tencent/aladdin/config/AladdinConfig:mMap	Ljava/util/Map;
    //   271: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   274: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   277: invokestatic 49	com/tencent/aladdin/config/utils/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   280: aload_0
    //   281: getfield 35	com/tencent/aladdin/config/AladdinConfig:mLock	Ljava/lang/Object;
    //   284: invokevirtual 156	java/lang/Object:notifyAll	()V
    //   287: aload_3
    //   288: monitorexit
    //   289: return
    //   290: astore 4
    //   292: aload_3
    //   293: monitorexit
    //   294: aload 4
    //   296: athrow
    //   297: astore 4
    //   299: aload_3
    //   300: monitorexit
    //   301: aload 4
    //   303: athrow
    //   304: astore 7
    //   306: aload 4
    //   308: astore_3
    //   309: aload_3
    //   310: astore 4
    //   312: aload 8
    //   314: monitorexit
    //   315: aload 6
    //   317: astore 5
    //   319: aload 7
    //   321: athrow
    //   322: astore 4
    //   324: aload 6
    //   326: astore 5
    //   328: ldc 8
    //   330: new 60	java/lang/StringBuilder
    //   333: dup
    //   334: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   337: ldc 100
    //   339: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: aload_0
    //   343: getfield 51	com/tencent/aladdin/config/AladdinConfig:mConfigId	I
    //   346: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   349: ldc 158
    //   351: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: aload 4
    //   356: invokevirtual 161	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   359: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   365: invokestatic 164	com/tencent/aladdin/config/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   368: aload 6
    //   370: astore 5
    //   372: invokestatic 143	com/tencent/aladdin/config/utils/Log:isDebugVersion	()Z
    //   375: ifeq +36 -> 411
    //   378: aload 6
    //   380: astore 5
    //   382: ldc 8
    //   384: new 60	java/lang/StringBuilder
    //   387: dup
    //   388: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   391: ldc 100
    //   393: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: aload_0
    //   397: getfield 51	com/tencent/aladdin/config/AladdinConfig:mConfigId	I
    //   400: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   403: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   406: aload 4
    //   408: invokestatic 167	com/tencent/aladdin/config/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   411: aload_3
    //   412: astore 4
    //   414: aload 6
    //   416: ifnull -207 -> 209
    //   419: aload 6
    //   421: invokevirtual 140	java/io/FileReader:close	()V
    //   424: aload_3
    //   425: astore 4
    //   427: goto -218 -> 209
    //   430: astore 5
    //   432: ldc 8
    //   434: new 60	java/lang/StringBuilder
    //   437: dup
    //   438: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   441: ldc 100
    //   443: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: aload_0
    //   447: getfield 51	com/tencent/aladdin/config/AladdinConfig:mConfigId	I
    //   450: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   453: ldc 158
    //   455: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: aload 5
    //   460: invokevirtual 161	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   463: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   469: invokestatic 164	com/tencent/aladdin/config/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   472: aload_3
    //   473: astore 4
    //   475: invokestatic 143	com/tencent/aladdin/config/utils/Log:isDebugVersion	()Z
    //   478: ifeq -269 -> 209
    //   481: ldc 8
    //   483: new 60	java/lang/StringBuilder
    //   486: dup
    //   487: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   490: ldc 100
    //   492: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: aload_0
    //   496: getfield 51	com/tencent/aladdin/config/AladdinConfig:mConfigId	I
    //   499: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   502: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   505: aload 5
    //   507: invokestatic 167	com/tencent/aladdin/config/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   510: aload_3
    //   511: astore 4
    //   513: goto -304 -> 209
    //   516: astore 5
    //   518: ldc 8
    //   520: new 60	java/lang/StringBuilder
    //   523: dup
    //   524: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   527: ldc 100
    //   529: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: aload_0
    //   533: getfield 51	com/tencent/aladdin/config/AladdinConfig:mConfigId	I
    //   536: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   539: ldc 158
    //   541: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   544: aload 5
    //   546: invokevirtual 161	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   549: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   552: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   555: invokestatic 164	com/tencent/aladdin/config/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   558: aload_3
    //   559: astore 4
    //   561: invokestatic 143	com/tencent/aladdin/config/utils/Log:isDebugVersion	()Z
    //   564: ifeq -355 -> 209
    //   567: ldc 8
    //   569: new 60	java/lang/StringBuilder
    //   572: dup
    //   573: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   576: ldc 100
    //   578: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   581: aload_0
    //   582: getfield 51	com/tencent/aladdin/config/AladdinConfig:mConfigId	I
    //   585: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   588: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   591: aload 5
    //   593: invokestatic 167	com/tencent/aladdin/config/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   596: aload_3
    //   597: astore 4
    //   599: goto -390 -> 209
    //   602: astore_3
    //   603: aconst_null
    //   604: astore 5
    //   606: aload 5
    //   608: ifnull +8 -> 616
    //   611: aload 5
    //   613: invokevirtual 140	java/io/FileReader:close	()V
    //   616: aload_3
    //   617: athrow
    //   618: astore 4
    //   620: ldc 8
    //   622: new 60	java/lang/StringBuilder
    //   625: dup
    //   626: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   629: ldc 100
    //   631: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   634: aload_0
    //   635: getfield 51	com/tencent/aladdin/config/AladdinConfig:mConfigId	I
    //   638: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   641: ldc 158
    //   643: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   646: aload 4
    //   648: invokevirtual 161	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   651: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   654: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   657: invokestatic 164	com/tencent/aladdin/config/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   660: invokestatic 143	com/tencent/aladdin/config/utils/Log:isDebugVersion	()Z
    //   663: ifeq -47 -> 616
    //   666: ldc 8
    //   668: new 60	java/lang/StringBuilder
    //   671: dup
    //   672: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   675: ldc 100
    //   677: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   680: aload_0
    //   681: getfield 51	com/tencent/aladdin/config/AladdinConfig:mConfigId	I
    //   684: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   687: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   690: aload 4
    //   692: invokestatic 167	com/tencent/aladdin/config/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   695: goto -79 -> 616
    //   698: aload_0
    //   699: new 169	java/util/HashMap
    //   702: dup
    //   703: invokespecial 170	java/util/HashMap:<init>	()V
    //   706: putfield 41	com/tencent/aladdin/config/AladdinConfig:mMap	Ljava/util/Map;
    //   709: goto -477 -> 232
    //   712: astore_3
    //   713: goto -107 -> 606
    //   716: astore 4
    //   718: aconst_null
    //   719: astore 6
    //   721: aconst_null
    //   722: astore_3
    //   723: goto -399 -> 324
    //   726: astore 4
    //   728: aconst_null
    //   729: astore_3
    //   730: goto -406 -> 324
    //   733: astore 4
    //   735: goto -411 -> 324
    //   738: astore 7
    //   740: goto -431 -> 309
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	743	0	this	AladdinConfig
    //   91	28	1	bool1	boolean
    //   103	25	2	bool2	boolean
    //   602	15	3	localObject2	Object
    //   712	1	3	localObject3	Object
    //   722	8	3	localObject4	Object
    //   1	227	4	localObject5	Object
    //   290	5	4	localObject6	Object
    //   297	10	4	localObject7	Object
    //   310	1	4	localObject8	Object
    //   322	85	4	localException1	java.lang.Exception
    //   412	186	4	localObject9	Object
    //   618	73	4	localException2	java.lang.Exception
    //   716	1	4	localException3	java.lang.Exception
    //   726	1	4	localException4	java.lang.Exception
    //   733	1	4	localException5	java.lang.Exception
    //   154	227	5	localFileReader1	java.io.FileReader
    //   430	76	5	localException6	java.lang.Exception
    //   516	76	5	localException7	java.lang.Exception
    //   604	8	5	localObject10	Object
    //   150	570	6	localFileReader2	java.io.FileReader
    //   304	16	7	localObject11	Object
    //   738	1	7	localObject12	Object
    //   160	153	8	localObject13	Object
    // Exception table:
    //   from	to	target	type
    //   216	221	290	finally
    //   226	232	290	finally
    //   232	280	290	finally
    //   280	289	290	finally
    //   292	294	290	finally
    //   698	709	290	finally
    //   37	73	297	finally
    //   74	137	297	finally
    //   137	139	297	finally
    //   299	301	297	finally
    //   169	181	304	finally
    //   312	315	304	finally
    //   319	322	322	java/lang/Exception
    //   419	424	430	java/lang/Exception
    //   201	206	516	java/lang/Exception
    //   139	152	602	finally
    //   611	616	618	java/lang/Exception
    //   156	162	712	finally
    //   166	169	712	finally
    //   188	193	712	finally
    //   319	322	712	finally
    //   328	368	712	finally
    //   372	378	712	finally
    //   382	411	712	finally
    //   139	152	716	java/lang/Exception
    //   156	162	726	java/lang/Exception
    //   166	169	726	java/lang/Exception
    //   188	193	733	java/lang/Exception
    //   181	184	738	finally
  }
  
  private void startLoadFromDisk()
  {
    Log.d("AladdinConfig", "startLoadFromDisk: ");
    synchronized (this.mLock)
    {
      this.mLoaded = false;
      Log.d("AladdinConfig", "startLoadFromDisk: mLoaded = false");
      this.asyncTaskExecutor.execute(new AladdinConfig.3(this));
      return;
    }
  }
  
  public void clear()
  {
    this.asyncTaskExecutor.execute(new AladdinConfig.2(this));
  }
  
  public Map<String, ?> getAll()
  {
    synchronized (this.mLock)
    {
      awaitLoadedLocked();
      Map localMap = Collections.unmodifiableMap(this.mMap);
      return localMap;
    }
  }
  
  public <T extends AladdinConfigBean> T getBean(String paramString)
  {
    synchronized (this.mLock)
    {
      awaitLoadedLocked();
      try
      {
        paramString = (AladdinConfigBean)this.mMap.get(paramString);
        return paramString;
      }
      catch (ClassCastException paramString)
      {
        return null;
      }
    }
  }
  
  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    synchronized (this.mLock)
    {
      awaitLoadedLocked();
      try
      {
        paramString = (Boolean)this.mMap.get(paramString);
        boolean bool = paramBoolean;
        if (paramString != null) {
          bool = paramString.booleanValue();
        }
        return bool;
      }
      catch (ClassCastException paramString)
      {
        return paramBoolean;
      }
    }
  }
  
  public boolean getBooleanFromString(String paramString, boolean paramBoolean)
  {
    synchronized (this.mLock)
    {
      awaitLoadedLocked();
      try
      {
        boolean bool = Boolean.valueOf((String)this.mMap.get(paramString)).booleanValue();
        return bool;
      }
      catch (ClassCastException paramString)
      {
        return paramBoolean;
      }
    }
  }
  
  public float getFloat(String paramString, float paramFloat)
  {
    synchronized (this.mLock)
    {
      awaitLoadedLocked();
      try
      {
        paramString = (Float)this.mMap.get(paramString);
        float f = paramFloat;
        if (paramString != null) {
          f = paramString.floatValue();
        }
        return f;
      }
      catch (ClassCastException paramString)
      {
        return paramFloat;
      }
    }
  }
  
  public float getFloatFromString(String paramString, float paramFloat)
  {
    synchronized (this.mLock)
    {
      awaitLoadedLocked();
    }
    try
    {
      paramString = (String)this.mMap.get(paramString);
      float f = paramFloat;
      if (paramString != null) {
        f = Float.valueOf(paramString).floatValue();
      }
      return f;
    }
    catch (ClassCastException paramString)
    {
      return paramFloat;
      paramString = finally;
      throw paramString;
    }
    catch (NumberFormatException paramString) {}
    return paramFloat;
  }
  
  public int getInteger(String paramString, int paramInt)
  {
    synchronized (this.mLock)
    {
      awaitLoadedLocked();
      try
      {
        paramString = (Integer)this.mMap.get(paramString);
        int i = paramInt;
        if (paramString != null) {
          i = paramString.intValue();
        }
        return i;
      }
      catch (ClassCastException paramString)
      {
        return paramInt;
      }
    }
  }
  
  public int getIntegerFromString(String paramString, int paramInt)
  {
    synchronized (this.mLock)
    {
      awaitLoadedLocked();
    }
    try
    {
      paramString = (String)this.mMap.get(paramString);
      int i = paramInt;
      if (paramString != null) {
        i = Integer.valueOf(paramString).intValue();
      }
      return i;
    }
    catch (ClassCastException paramString)
    {
      return paramInt;
      paramString = finally;
      throw paramString;
    }
    catch (NumberFormatException paramString) {}
    return paramInt;
  }
  
  public <T> List<T> getList(String paramString)
  {
    synchronized (this.mLock)
    {
      awaitLoadedLocked();
      try
      {
        paramString = (List)this.mMap.get(paramString);
        if (paramString != null) {}
        for (;;)
        {
          return paramString;
          paramString = Collections.emptyList();
        }
        paramString = finally;
      }
      catch (ClassCastException paramString)
      {
        paramString = Collections.emptyList();
        return paramString;
      }
    }
  }
  
  public long getLongFromString(String paramString, long paramLong)
  {
    synchronized (this.mLock)
    {
      awaitLoadedLocked();
    }
    try
    {
      paramString = (String)this.mMap.get(paramString);
      long l = paramLong;
      if (paramString != null) {
        l = Long.valueOf(paramString).longValue();
      }
      return l;
    }
    catch (ClassCastException paramString)
    {
      return paramLong;
      paramString = finally;
      throw paramString;
    }
    catch (NumberFormatException paramString) {}
    return paramLong;
  }
  
  public <T> Map<String, T> getMap(String paramString)
  {
    synchronized (this.mLock)
    {
      awaitLoadedLocked();
      try
      {
        paramString = (Map)this.mMap.get(paramString);
        if (paramString != null) {}
        for (;;)
        {
          return paramString;
          paramString = Collections.emptyMap();
        }
        paramString = finally;
      }
      catch (ClassCastException paramString)
      {
        paramString = Collections.emptyMap();
        return paramString;
      }
    }
  }
  
  public <T> Set<T> getSet(String paramString)
  {
    synchronized (this.mLock)
    {
      awaitLoadedLocked();
      try
      {
        paramString = (Set)this.mMap.get(paramString);
        if (paramString != null) {}
        for (;;)
        {
          return paramString;
          paramString = Collections.emptySet();
        }
        paramString = finally;
      }
      catch (ClassCastException paramString)
      {
        paramString = Collections.emptySet();
        return paramString;
      }
    }
  }
  
  public String getString(String paramString1, String paramString2)
  {
    synchronized (this.mLock)
    {
      awaitLoadedLocked();
      try
      {
        paramString1 = (String)this.mMap.get(paramString1);
        if (paramString1 != null) {
          paramString2 = paramString1;
        }
        return paramString2;
      }
      catch (ClassCastException paramString1)
      {
        return paramString2;
      }
    }
  }
  
  public String toString()
  {
    synchronized (this.mLock)
    {
      awaitLoadedLocked();
      String str = "AladdinConfig{mConfigId=" + this.mConfigId + ", mMap=" + this.mMap + '}';
      return str;
    }
  }
  
  public boolean update(String arg1)
  {
    boolean bool = true;
    Map localMap = this.mParser.parse(new StringReader(???));
    synchronized (this.mLock)
    {
      awaitLoadedLocked();
      this.mMap = localMap;
      this.mLoaded = true;
      Log.d("AladdinConfig", "run: updated, renew mMap for " + this.mConfigId);
      this.asyncTaskExecutor.execute(new AladdinConfig.1(this, ???));
    }
    synchronized (this.mLock)
    {
      if (!this.mMap.isEmpty())
      {
        return bool;
        ??? = finally;
        throw ???;
      }
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.aladdin.config.AladdinConfig
 * JD-Core Version:    0.7.0.1
 */
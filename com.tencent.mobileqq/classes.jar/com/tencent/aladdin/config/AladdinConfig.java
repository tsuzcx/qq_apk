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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(".backup");
    this.mBackupFile = new File(localStringBuilder.toString());
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
      catch (InterruptedException localInterruptedException)
      {
        label17:
        break label17;
      }
    }
  }
  
  /* Error */
  private void loadFromDisk()
  {
    // Byte code:
    //   0: new 60	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: ldc 100
    //   11: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: pop
    //   15: aload_3
    //   16: aload_0
    //   17: getfield 51	com/tencent/aladdin/config/AladdinConfig:mConfigId	I
    //   20: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: ldc 8
    //   26: aload_3
    //   27: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 49	com/tencent/aladdin/config/utils/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   33: aload_0
    //   34: getfield 35	com/tencent/aladdin/config/AladdinConfig:mLock	Ljava/lang/Object;
    //   37: astore_3
    //   38: aload_3
    //   39: monitorenter
    //   40: aload_0
    //   41: getfield 39	com/tencent/aladdin/config/AladdinConfig:mLoaded	Z
    //   44: ifeq +43 -> 87
    //   47: new 60	java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   54: astore 4
    //   56: aload 4
    //   58: ldc 105
    //   60: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: aload 4
    //   66: aload_0
    //   67: getfield 51	com/tencent/aladdin/config/AladdinConfig:mConfigId	I
    //   70: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: ldc 8
    //   76: aload 4
    //   78: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokestatic 49	com/tencent/aladdin/config/utils/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   84: aload_3
    //   85: monitorexit
    //   86: return
    //   87: aload_0
    //   88: getfield 73	com/tencent/aladdin/config/AladdinConfig:mBackupFile	Ljava/io/File;
    //   91: invokevirtual 109	java/io/File:exists	()Z
    //   94: ifeq +72 -> 166
    //   97: aload_0
    //   98: getfield 58	com/tencent/aladdin/config/AladdinConfig:mFile	Ljava/io/File;
    //   101: invokevirtual 112	java/io/File:delete	()Z
    //   104: istore_1
    //   105: aload_0
    //   106: getfield 73	com/tencent/aladdin/config/AladdinConfig:mBackupFile	Ljava/io/File;
    //   109: aload_0
    //   110: getfield 58	com/tencent/aladdin/config/AladdinConfig:mFile	Ljava/io/File;
    //   113: invokevirtual 116	java/io/File:renameTo	(Ljava/io/File;)Z
    //   116: istore_2
    //   117: new 60	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   124: astore 4
    //   126: aload 4
    //   128: ldc 118
    //   130: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: pop
    //   134: aload 4
    //   136: iload_1
    //   137: invokevirtual 121	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: aload 4
    //   143: ldc 123
    //   145: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: aload 4
    //   151: iload_2
    //   152: invokevirtual 121	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: ldc 8
    //   158: aload 4
    //   160: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokestatic 126	com/tencent/aladdin/config/utils/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   166: aload_3
    //   167: monitorexit
    //   168: aconst_null
    //   169: astore 8
    //   171: aconst_null
    //   172: astore 4
    //   174: aconst_null
    //   175: astore_3
    //   176: aconst_null
    //   177: astore 7
    //   179: aconst_null
    //   180: astore 6
    //   182: aload_3
    //   183: astore 5
    //   185: aload_0
    //   186: getfield 58	com/tencent/aladdin/config/AladdinConfig:mFile	Ljava/io/File;
    //   189: invokevirtual 109	java/io/File:exists	()Z
    //   192: ifeq +91 -> 283
    //   195: aload_3
    //   196: astore 5
    //   198: new 128	java/io/FileReader
    //   201: dup
    //   202: aload_0
    //   203: getfield 58	com/tencent/aladdin/config/AladdinConfig:mFile	Ljava/io/File;
    //   206: invokespecial 131	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   209: astore 4
    //   211: aload 8
    //   213: astore_3
    //   214: aload_0
    //   215: getfield 35	com/tencent/aladdin/config/AladdinConfig:mLock	Ljava/lang/Object;
    //   218: astore 7
    //   220: aload 8
    //   222: astore_3
    //   223: aload 7
    //   225: monitorenter
    //   226: aload 6
    //   228: astore_3
    //   229: aload_0
    //   230: getfield 77	com/tencent/aladdin/config/AladdinConfig:mParser	Lcom/tencent/aladdin/config/parse/AladdinConfigParser;
    //   233: aload 4
    //   235: invokeinterface 137 2 0
    //   240: astore 5
    //   242: aload 5
    //   244: astore_3
    //   245: aload 7
    //   247: monitorexit
    //   248: aload 5
    //   250: astore_3
    //   251: aload 4
    //   253: invokevirtual 140	java/io/FileReader:close	()V
    //   256: aload 5
    //   258: astore_3
    //   259: goto +86 -> 345
    //   262: astore 5
    //   264: aload 7
    //   266: monitorexit
    //   267: aload 5
    //   269: athrow
    //   270: astore_3
    //   271: aload 4
    //   273: astore 5
    //   275: goto +574 -> 849
    //   278: astore 6
    //   280: goto +208 -> 488
    //   283: aload_3
    //   284: astore 5
    //   286: new 60	java/lang/StringBuilder
    //   289: dup
    //   290: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   293: astore 6
    //   295: aload_3
    //   296: astore 5
    //   298: aload 6
    //   300: ldc 142
    //   302: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: pop
    //   306: aload_3
    //   307: astore 5
    //   309: aload 6
    //   311: aload_0
    //   312: getfield 51	com/tencent/aladdin/config/AladdinConfig:mConfigId	I
    //   315: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   318: pop
    //   319: aload_3
    //   320: astore 5
    //   322: aload 6
    //   324: ldc 144
    //   326: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: pop
    //   330: aload_3
    //   331: astore 5
    //   333: ldc 8
    //   335: aload 6
    //   337: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   340: invokestatic 49	com/tencent/aladdin/config/utils/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   343: aconst_null
    //   344: astore_3
    //   345: aload_3
    //   346: astore 5
    //   348: aload 4
    //   350: ifnull +381 -> 731
    //   353: aload 4
    //   355: invokevirtual 140	java/io/FileReader:close	()V
    //   358: aload_3
    //   359: astore 5
    //   361: goto +370 -> 731
    //   364: astore 4
    //   366: new 60	java/lang/StringBuilder
    //   369: dup
    //   370: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   373: astore 5
    //   375: aload 5
    //   377: ldc 100
    //   379: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: pop
    //   383: aload 5
    //   385: aload_0
    //   386: getfield 51	com/tencent/aladdin/config/AladdinConfig:mConfigId	I
    //   389: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   392: pop
    //   393: aload 5
    //   395: ldc 146
    //   397: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: pop
    //   401: aload 5
    //   403: aload 4
    //   405: invokevirtual 149	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   408: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: pop
    //   412: ldc 8
    //   414: aload 5
    //   416: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   419: invokestatic 152	com/tencent/aladdin/config/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   422: aload_3
    //   423: astore 5
    //   425: invokestatic 155	com/tencent/aladdin/config/utils/Log:isDebugVersion	()Z
    //   428: ifeq +303 -> 731
    //   431: new 60	java/lang/StringBuilder
    //   434: dup
    //   435: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   438: astore 5
    //   440: aload 5
    //   442: ldc 100
    //   444: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   447: pop
    //   448: aload 5
    //   450: aload_0
    //   451: getfield 51	com/tencent/aladdin/config/AladdinConfig:mConfigId	I
    //   454: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   457: pop
    //   458: ldc 8
    //   460: aload 5
    //   462: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   465: aload 4
    //   467: invokestatic 158	com/tencent/aladdin/config/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   470: aload_3
    //   471: astore 5
    //   473: goto +258 -> 731
    //   476: astore_3
    //   477: goto +372 -> 849
    //   480: astore 6
    //   482: aconst_null
    //   483: astore_3
    //   484: aload 7
    //   486: astore 4
    //   488: aload 4
    //   490: astore 5
    //   492: new 60	java/lang/StringBuilder
    //   495: dup
    //   496: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   499: astore 7
    //   501: aload 4
    //   503: astore 5
    //   505: aload 7
    //   507: ldc 100
    //   509: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   512: pop
    //   513: aload 4
    //   515: astore 5
    //   517: aload 7
    //   519: aload_0
    //   520: getfield 51	com/tencent/aladdin/config/AladdinConfig:mConfigId	I
    //   523: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   526: pop
    //   527: aload 4
    //   529: astore 5
    //   531: aload 7
    //   533: ldc 146
    //   535: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   538: pop
    //   539: aload 4
    //   541: astore 5
    //   543: aload 7
    //   545: aload 6
    //   547: invokevirtual 149	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   550: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   553: pop
    //   554: aload 4
    //   556: astore 5
    //   558: ldc 8
    //   560: aload 7
    //   562: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   565: invokestatic 152	com/tencent/aladdin/config/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   568: aload 4
    //   570: astore 5
    //   572: invokestatic 155	com/tencent/aladdin/config/utils/Log:isDebugVersion	()Z
    //   575: ifeq +58 -> 633
    //   578: aload 4
    //   580: astore 5
    //   582: new 60	java/lang/StringBuilder
    //   585: dup
    //   586: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   589: astore 7
    //   591: aload 4
    //   593: astore 5
    //   595: aload 7
    //   597: ldc 100
    //   599: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   602: pop
    //   603: aload 4
    //   605: astore 5
    //   607: aload 7
    //   609: aload_0
    //   610: getfield 51	com/tencent/aladdin/config/AladdinConfig:mConfigId	I
    //   613: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   616: pop
    //   617: aload 4
    //   619: astore 5
    //   621: ldc 8
    //   623: aload 7
    //   625: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   628: aload 6
    //   630: invokestatic 158	com/tencent/aladdin/config/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   633: aload_3
    //   634: astore 5
    //   636: aload 4
    //   638: ifnull +93 -> 731
    //   641: aload 4
    //   643: invokevirtual 140	java/io/FileReader:close	()V
    //   646: aload_3
    //   647: astore 5
    //   649: goto +82 -> 731
    //   652: astore 4
    //   654: new 60	java/lang/StringBuilder
    //   657: dup
    //   658: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   661: astore 5
    //   663: aload 5
    //   665: ldc 100
    //   667: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   670: pop
    //   671: aload 5
    //   673: aload_0
    //   674: getfield 51	com/tencent/aladdin/config/AladdinConfig:mConfigId	I
    //   677: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   680: pop
    //   681: aload 5
    //   683: ldc 146
    //   685: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   688: pop
    //   689: aload 5
    //   691: aload 4
    //   693: invokevirtual 149	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   696: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   699: pop
    //   700: ldc 8
    //   702: aload 5
    //   704: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   707: invokestatic 152	com/tencent/aladdin/config/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   710: aload_3
    //   711: astore 5
    //   713: invokestatic 155	com/tencent/aladdin/config/utils/Log:isDebugVersion	()Z
    //   716: ifeq +15 -> 731
    //   719: new 60	java/lang/StringBuilder
    //   722: dup
    //   723: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   726: astore 5
    //   728: goto -288 -> 440
    //   731: aload_0
    //   732: getfield 35	com/tencent/aladdin/config/AladdinConfig:mLock	Ljava/lang/Object;
    //   735: astore_3
    //   736: aload_3
    //   737: monitorenter
    //   738: aload_0
    //   739: iconst_1
    //   740: putfield 39	com/tencent/aladdin/config/AladdinConfig:mLoaded	Z
    //   743: aload 5
    //   745: ifnull +12 -> 757
    //   748: aload_0
    //   749: aload 5
    //   751: putfield 41	com/tencent/aladdin/config/AladdinConfig:mMap	Ljava/util/Map;
    //   754: goto +14 -> 768
    //   757: aload_0
    //   758: new 160	java/util/HashMap
    //   761: dup
    //   762: invokespecial 161	java/util/HashMap:<init>	()V
    //   765: putfield 41	com/tencent/aladdin/config/AladdinConfig:mMap	Ljava/util/Map;
    //   768: invokestatic 155	com/tencent/aladdin/config/utils/Log:isDebugVersion	()Z
    //   771: ifeq +61 -> 832
    //   774: new 60	java/lang/StringBuilder
    //   777: dup
    //   778: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   781: astore 4
    //   783: aload 4
    //   785: ldc 163
    //   787: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   790: pop
    //   791: aload 4
    //   793: aload_0
    //   794: getfield 58	com/tencent/aladdin/config/AladdinConfig:mFile	Ljava/io/File;
    //   797: invokevirtual 166	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   800: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   803: pop
    //   804: aload 4
    //   806: ldc 168
    //   808: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   811: pop
    //   812: aload 4
    //   814: aload_0
    //   815: getfield 41	com/tencent/aladdin/config/AladdinConfig:mMap	Ljava/util/Map;
    //   818: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   821: pop
    //   822: ldc 8
    //   824: aload 4
    //   826: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   829: invokestatic 49	com/tencent/aladdin/config/utils/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   832: aload_0
    //   833: getfield 35	com/tencent/aladdin/config/AladdinConfig:mLock	Ljava/lang/Object;
    //   836: invokevirtual 174	java/lang/Object:notifyAll	()V
    //   839: aload_3
    //   840: monitorexit
    //   841: return
    //   842: astore 4
    //   844: aload_3
    //   845: monitorexit
    //   846: aload 4
    //   848: athrow
    //   849: aload 5
    //   851: ifnull +114 -> 965
    //   854: aload 5
    //   856: invokevirtual 140	java/io/FileReader:close	()V
    //   859: goto +106 -> 965
    //   862: astore 4
    //   864: new 60	java/lang/StringBuilder
    //   867: dup
    //   868: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   871: astore 5
    //   873: aload 5
    //   875: ldc 100
    //   877: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   880: pop
    //   881: aload 5
    //   883: aload_0
    //   884: getfield 51	com/tencent/aladdin/config/AladdinConfig:mConfigId	I
    //   887: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   890: pop
    //   891: aload 5
    //   893: ldc 146
    //   895: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   898: pop
    //   899: aload 5
    //   901: aload 4
    //   903: invokevirtual 149	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   906: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   909: pop
    //   910: ldc 8
    //   912: aload 5
    //   914: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   917: invokestatic 152	com/tencent/aladdin/config/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   920: invokestatic 155	com/tencent/aladdin/config/utils/Log:isDebugVersion	()Z
    //   923: ifeq +42 -> 965
    //   926: new 60	java/lang/StringBuilder
    //   929: dup
    //   930: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   933: astore 5
    //   935: aload 5
    //   937: ldc 100
    //   939: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   942: pop
    //   943: aload 5
    //   945: aload_0
    //   946: getfield 51	com/tencent/aladdin/config/AladdinConfig:mConfigId	I
    //   949: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   952: pop
    //   953: ldc 8
    //   955: aload 5
    //   957: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   960: aload 4
    //   962: invokestatic 158	com/tencent/aladdin/config/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   965: aload_3
    //   966: athrow
    //   967: astore 4
    //   969: aload_3
    //   970: monitorexit
    //   971: goto +6 -> 977
    //   974: aload 4
    //   976: athrow
    //   977: goto -3 -> 974
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	980	0	this	AladdinConfig
    //   104	33	1	bool1	boolean
    //   116	36	2	bool2	boolean
    //   7	252	3	localObject1	Object
    //   270	61	3	localObject2	Object
    //   344	127	3	localObject3	Object
    //   476	1	3	localObject4	Object
    //   483	487	3	localObject5	Object
    //   54	300	4	localObject6	Object
    //   364	102	4	localException1	java.lang.Exception
    //   486	156	4	localObject7	Object
    //   652	40	4	localException2	java.lang.Exception
    //   781	44	4	localStringBuilder1	StringBuilder
    //   842	5	4	localObject8	Object
    //   862	99	4	localException3	java.lang.Exception
    //   967	8	4	localObject9	Object
    //   183	74	5	localObject10	Object
    //   262	6	5	localObject11	Object
    //   273	683	5	localObject12	Object
    //   180	47	6	localObject13	Object
    //   278	1	6	localException4	java.lang.Exception
    //   293	43	6	localStringBuilder2	StringBuilder
    //   480	149	6	localException5	java.lang.Exception
    //   177	447	7	localObject14	Object
    //   169	52	8	localObject15	Object
    // Exception table:
    //   from	to	target	type
    //   229	242	262	finally
    //   245	248	262	finally
    //   264	267	262	finally
    //   214	220	270	finally
    //   223	226	270	finally
    //   251	256	270	finally
    //   267	270	270	finally
    //   214	220	278	java/lang/Exception
    //   223	226	278	java/lang/Exception
    //   251	256	278	java/lang/Exception
    //   267	270	278	java/lang/Exception
    //   353	358	364	java/lang/Exception
    //   185	195	476	finally
    //   198	211	476	finally
    //   286	295	476	finally
    //   298	306	476	finally
    //   309	319	476	finally
    //   322	330	476	finally
    //   333	343	476	finally
    //   492	501	476	finally
    //   505	513	476	finally
    //   517	527	476	finally
    //   531	539	476	finally
    //   543	554	476	finally
    //   558	568	476	finally
    //   572	578	476	finally
    //   582	591	476	finally
    //   595	603	476	finally
    //   607	617	476	finally
    //   621	633	476	finally
    //   185	195	480	java/lang/Exception
    //   198	211	480	java/lang/Exception
    //   286	295	480	java/lang/Exception
    //   298	306	480	java/lang/Exception
    //   309	319	480	java/lang/Exception
    //   322	330	480	java/lang/Exception
    //   333	343	480	java/lang/Exception
    //   641	646	652	java/lang/Exception
    //   738	743	842	finally
    //   748	754	842	finally
    //   757	768	842	finally
    //   768	832	842	finally
    //   832	841	842	finally
    //   844	846	842	finally
    //   854	859	862	java/lang/Exception
    //   40	86	967	finally
    //   87	166	967	finally
    //   166	168	967	finally
    //   969	971	967	finally
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
        label29:
        break label29;
      }
      return null;
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
        label43:
        break label43;
      }
      return paramBoolean;
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
        label38:
        break label38;
      }
      return paramBoolean;
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
        label43:
        break label43;
      }
      return paramFloat;
    }
  }
  
  public float getFloatFromString(String paramString, float paramFloat)
  {
    synchronized (this.mLock)
    {
      awaitLoadedLocked();
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
        break label51;
      }
      catch (NumberFormatException paramString)
      {
        label46:
        label51:
        break label46;
      }
      return paramFloat;
      return paramFloat;
    }
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
        label43:
        break label43;
      }
      return paramInt;
    }
  }
  
  public int getIntegerFromString(String paramString, int paramInt)
  {
    synchronized (this.mLock)
    {
      awaitLoadedLocked();
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
        break label51;
      }
      catch (NumberFormatException paramString)
      {
        label46:
        label51:
        break label46;
      }
      return paramInt;
      return paramInt;
    }
  }
  
  public <T> List<T> getList(String paramString)
  {
    synchronized (this.mLock)
    {
      awaitLoadedLocked();
      try
      {
        paramString = (List)this.mMap.get(paramString);
        if (paramString == null) {
          paramString = Collections.emptyList();
        }
        return paramString;
      }
      catch (ClassCastException paramString)
      {
        label40:
        break label40;
      }
      paramString = Collections.emptyList();
      return paramString;
    }
  }
  
  public long getLongFromString(String paramString, long paramLong)
  {
    synchronized (this.mLock)
    {
      awaitLoadedLocked();
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
        break label54;
      }
      catch (NumberFormatException paramString)
      {
        label49:
        label54:
        break label49;
      }
      return paramLong;
      return paramLong;
    }
  }
  
  public <T> Map<String, T> getMap(String paramString)
  {
    synchronized (this.mLock)
    {
      awaitLoadedLocked();
      try
      {
        paramString = (Map)this.mMap.get(paramString);
        if (paramString == null) {
          paramString = Collections.emptyMap();
        }
        return paramString;
      }
      catch (ClassCastException paramString)
      {
        label40:
        break label40;
      }
      paramString = Collections.emptyMap();
      return paramString;
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
        if (paramString == null) {
          paramString = Collections.emptySet();
        }
        return paramString;
      }
      catch (ClassCastException paramString)
      {
        label40:
        break label40;
      }
      paramString = Collections.emptySet();
      return paramString;
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
        label38:
        break label38;
      }
      return paramString2;
    }
  }
  
  public String toString()
  {
    synchronized (this.mLock)
    {
      awaitLoadedLocked();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("AladdinConfig{mConfigId=");
      ((StringBuilder)localObject2).append(this.mConfigId);
      ((StringBuilder)localObject2).append(", mMap=");
      ((StringBuilder)localObject2).append(this.mMap);
      ((StringBuilder)localObject2).append('}');
      localObject2 = ((StringBuilder)localObject2).toString();
      return localObject2;
    }
  }
  
  public boolean update(String arg1)
  {
    Object localObject3 = this.mParser.parse(new StringReader(???));
    for (;;)
    {
      synchronized (this.mLock)
      {
        awaitLoadedLocked();
        this.mMap = ((Map)localObject3);
        bool = true;
        this.mLoaded = true;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("run: updated, renew mMap for ");
        ((StringBuilder)localObject3).append(this.mConfigId);
        Log.d("AladdinConfig", ((StringBuilder)localObject3).toString());
        this.asyncTaskExecutor.execute(new AladdinConfig.1(this, ???));
        synchronized (this.mLock)
        {
          if (!this.mMap.isEmpty()) {
            return bool;
          }
        }
      }
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aladdin.config.AladdinConfig
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.apollo.game.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.game.process.CmGameUtil;
import com.tencent.mobileqq.apollo.game.process.data.CmGameLauncher;
import com.tencent.mobileqq.apollo.model.ApolloGameData;
import com.tencent.mobileqq.apollo.utils.RSAVerify;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.SOPreLoader;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class ApolloGameRscVerify
{
  public long a;
  public int b;
  private JSONObject c = null;
  private AtomicBoolean d = new AtomicBoolean(false);
  private AtomicBoolean e = new AtomicBoolean(false);
  private SharedPreferences f;
  private int g;
  private int h;
  private String i;
  private String j;
  private int k = 0;
  private ApolloGameRscVerify.OnVerifyResultCallback l;
  
  public ApolloGameRscVerify(int paramInt)
  {
    this(paramInt, 0, "", "");
  }
  
  public ApolloGameRscVerify(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    this.i = paramString1;
    this.h = paramInt2;
    this.j = paramString2;
    this.b = 0;
    this.a = 0L;
    this.g = paramInt1;
    this.f = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_sp", 4);
  }
  
  private void a(String paramString, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("gameId:");
    ((StringBuilder)localObject).append(this.g);
    ((StringBuilder)localObject).append(",failType:");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(",fileName:");
    ((StringBuilder)localObject).append(paramString);
    QLog.w("cmgame_process.ApolloGameRscVerify", 1, ((StringBuilder)localObject).toString());
    if ((this.f != null) && (this.e != null))
    {
      this.k = paramInt;
      localObject = this.l;
      if (localObject != null) {
        ((ApolloGameRscVerify.OnVerifyResultCallback)localObject).a(paramInt);
      }
      int m = this.h;
      if (m != 3)
      {
        if (m == 4) {
          return;
        }
        localObject = this.f.edit();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("apollo_sp_game_rsc_verify_");
        localStringBuilder.append(c());
        ((SharedPreferences.Editor)localObject).putBoolean(localStringBuilder.toString(), true).commit();
        this.e.set(true);
        localObject = new HashMap();
        ((HashMap)localObject).put("gameId", Integer.toString(this.g));
        ((HashMap)localObject).put("rscPath", paramString);
        ((HashMap)localObject).put("errType", Integer.toString(paramInt));
        paramString = d();
        StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(paramString, "cmshow_game_rsc_error", true, -1L, -1L, (HashMap)localObject, "", true);
      }
      return;
    }
    QLog.e("cmgame_process.ApolloGameRscVerify", 1, "[onVerifyFailure] fails, param is wrong");
  }
  
  public static boolean a(int paramInt)
  {
    try
    {
      CmGameLauncher localCmGameLauncher = CmGameUtil.a(paramInt);
      if (localCmGameLauncher == null)
      {
        QLog.w("cmgame_process.ApolloGameRscVerify", 1, "[isNeedVerify], launcher is null.");
        return false;
      }
      if (localCmGameLauncher.d() != null) {
        return true;
      }
      if (localCmGameLauncher.c() != null)
      {
        QLog.w("cmgame_process.ApolloGameRscVerify", 1, "[isNeedVerify], initParams is null use startCheckParam check");
        return true;
      }
      QLog.w("cmgame_process.ApolloGameRscVerify", 1, "[isNeedVerify], initParams and startCheckParam is null.");
      return true;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmgame_process.ApolloGameRscVerify", 1, localThrowable, new Object[0]);
    }
    return true;
  }
  
  private boolean f()
  {
    try
    {
      if (!a(this.g, this.h))
      {
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.ApolloGameRscVerify", 2, "Verifying switch is off in debug mode.");
        }
        this.e.set(false);
        if (this.l != null)
        {
          this.l.a(0);
          return false;
        }
      }
      else
      {
        new ApolloGameData().gameId = this.g;
        Object localObject = new File(g(), h());
        if (!((File)localObject).exists())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("game checklist NOT exist, gameId:");
          ((StringBuilder)localObject).append(this.g);
          QLog.w("cmgame_process.ApolloGameRscVerify", 1, ((StringBuilder)localObject).toString());
          a("checkList", 2);
          return false;
        }
        if ((this.h == 0) || (this.h == 1))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(g());
          localStringBuilder.append("/checkList.sig");
          if (!new RSAVerify(localStringBuilder.toString(), ((File)localObject).getAbsolutePath()).a(0))
          {
            a("checkList.sig", 3);
            return false;
          }
        }
        this.c = new JSONObject(FileUtils.readFileToString((File)localObject));
        this.d.set(true);
        return true;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmgame_process.ApolloGameRscVerify", 1, "[ApolloGameRscVerify], errInfo->", localThrowable);
      return true;
    }
    return false;
  }
  
  private String g()
  {
    StringBuilder localStringBuilder = new StringBuilder(500);
    int m = this.h;
    if (m == 0)
    {
      localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/game/");
      localStringBuilder.append(this.g);
    }
    else if (m == 1)
    {
      localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/game/");
      localStringBuilder.append(this.g);
      localStringBuilder.append("/");
      localStringBuilder.append(this.j);
    }
    else
    {
      if ((m == 3) || (m == 4)) {
        break label100;
      }
    }
    return localStringBuilder.toString();
    label100:
    return SOPreLoader.b();
  }
  
  private String h()
  {
    if (this.h == 4) {
      return "checkList_jsc";
    }
    return "checkList";
  }
  
  public void a()
  {
    ThreadManager.post(new ApolloGameRscVerify.1(this), 5, null, true);
  }
  
  public void a(ApolloGameRscVerify.OnVerifyResultCallback paramOnVerifyResultCallback)
  {
    this.l = paramOnVerifyResultCallback;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if ((paramInt2 != 4) && (paramInt2 != 3)) {
      return a(paramInt1);
    }
    return true;
  }
  
  /* Error */
  public boolean a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 43	com/tencent/mobileqq/apollo/game/utils/ApolloGameRscVerify:d	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   4: invokevirtual 290	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   7: ifeq +299 -> 306
    //   10: aload_0
    //   11: getfield 36	com/tencent/mobileqq/apollo/game/utils/ApolloGameRscVerify:c	Lorg/json/JSONObject;
    //   14: ifnull +292 -> 306
    //   17: aload_2
    //   18: invokestatic 296	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   21: ifne +285 -> 306
    //   24: aload_1
    //   25: invokestatic 296	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   28: ifne +278 -> 306
    //   31: aload_0
    //   32: getfield 45	com/tencent/mobileqq/apollo/game/utils/ApolloGameRscVerify:e	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   35: astore_3
    //   36: aload_3
    //   37: ifnull +269 -> 306
    //   40: aload_3
    //   41: invokevirtual 290	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   44: ifeq +5 -> 49
    //   47: iconst_0
    //   48: ireturn
    //   49: aconst_null
    //   50: astore 6
    //   52: aconst_null
    //   53: astore 4
    //   55: new 215	java/io/File
    //   58: dup
    //   59: aload_1
    //   60: invokespecial 297	java/io/File:<init>	(Ljava/lang/String;)V
    //   63: astore 7
    //   65: aload 4
    //   67: astore_3
    //   68: aload 7
    //   70: invokevirtual 225	java/io/File:exists	()Z
    //   73: ifne +14 -> 87
    //   76: aload 4
    //   78: astore_3
    //   79: aload_0
    //   80: aload_2
    //   81: iconst_1
    //   82: invokespecial 231	com/tencent/mobileqq/apollo/game/utils/ApolloGameRscVerify:a	(Ljava/lang/String;I)V
    //   85: iconst_0
    //   86: ireturn
    //   87: aload 4
    //   89: astore_3
    //   90: aload_0
    //   91: getfield 36	com/tencent/mobileqq/apollo/game/utils/ApolloGameRscVerify:c	Lorg/json/JSONObject;
    //   94: aload_2
    //   95: invokevirtual 301	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   98: astore 5
    //   100: aload 4
    //   102: astore_3
    //   103: new 303	java/io/FileInputStream
    //   106: dup
    //   107: aload_1
    //   108: invokespecial 304	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   111: astore 4
    //   113: aload 4
    //   115: aload 7
    //   117: invokevirtual 308	java/io/File:length	()J
    //   120: invokestatic 314	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   123: invokestatic 320	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   126: astore_3
    //   127: aload_3
    //   128: invokestatic 296	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   131: ifne +52 -> 183
    //   134: aload 5
    //   136: invokestatic 296	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   139: ifne +44 -> 183
    //   142: aload_3
    //   143: invokevirtual 325	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   146: aload 5
    //   148: invokevirtual 325	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   151: invokevirtual 329	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   154: ifne +29 -> 183
    //   157: aload_0
    //   158: aload_2
    //   159: iconst_4
    //   160: invokespecial 231	com/tencent/mobileqq/apollo/game/utils/ApolloGameRscVerify:a	(Ljava/lang/String;I)V
    //   163: aload 4
    //   165: invokevirtual 332	java/io/FileInputStream:close	()V
    //   168: iconst_0
    //   169: ireturn
    //   170: astore_1
    //   171: ldc 92
    //   173: iconst_1
    //   174: ldc_w 334
    //   177: aload_1
    //   178: invokestatic 259	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   181: iconst_0
    //   182: ireturn
    //   183: aload 4
    //   185: invokevirtual 332	java/io/FileInputStream:close	()V
    //   188: iconst_1
    //   189: ireturn
    //   190: astore_1
    //   191: ldc 92
    //   193: iconst_1
    //   194: ldc_w 334
    //   197: aload_1
    //   198: invokestatic 259	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   201: iconst_1
    //   202: ireturn
    //   203: astore_1
    //   204: aload 4
    //   206: astore_3
    //   207: goto +75 -> 282
    //   210: astore 5
    //   212: goto +13 -> 225
    //   215: astore_1
    //   216: goto +66 -> 282
    //   219: astore 5
    //   221: aload 6
    //   223: astore 4
    //   225: aload 4
    //   227: astore_3
    //   228: ldc 92
    //   230: iconst_1
    //   231: bipush 6
    //   233: anewarray 4	java/lang/Object
    //   236: dup
    //   237: iconst_0
    //   238: ldc_w 336
    //   241: aastore
    //   242: dup
    //   243: iconst_1
    //   244: aload 5
    //   246: aastore
    //   247: dup
    //   248: iconst_2
    //   249: ldc_w 338
    //   252: aastore
    //   253: dup
    //   254: iconst_3
    //   255: aload_1
    //   256: aastore
    //   257: dup
    //   258: iconst_4
    //   259: ldc_w 340
    //   262: aastore
    //   263: dup
    //   264: iconst_5
    //   265: aload_2
    //   266: aastore
    //   267: invokestatic 343	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   270: aload 4
    //   272: ifnull +8 -> 280
    //   275: aload 4
    //   277: invokevirtual 332	java/io/FileInputStream:close	()V
    //   280: iconst_1
    //   281: ireturn
    //   282: aload_3
    //   283: ifnull +21 -> 304
    //   286: aload_3
    //   287: invokevirtual 332	java/io/FileInputStream:close	()V
    //   290: goto +14 -> 304
    //   293: astore_2
    //   294: ldc 92
    //   296: iconst_1
    //   297: ldc_w 334
    //   300: aload_2
    //   301: invokestatic 259	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   304: aload_1
    //   305: athrow
    //   306: iconst_0
    //   307: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	308	0	this	ApolloGameRscVerify
    //   0	308	1	paramString1	String
    //   0	308	2	paramString2	String
    //   35	252	3	localObject1	Object
    //   53	223	4	localObject2	Object
    //   98	49	5	str	String
    //   210	1	5	localThrowable1	Throwable
    //   219	26	5	localThrowable2	Throwable
    //   50	172	6	localObject3	Object
    //   63	53	7	localFile	File
    // Exception table:
    //   from	to	target	type
    //   163	168	170	java/io/IOException
    //   183	188	190	java/io/IOException
    //   275	280	190	java/io/IOException
    //   113	163	203	finally
    //   113	163	210	java/lang/Throwable
    //   68	76	215	finally
    //   79	85	215	finally
    //   90	100	215	finally
    //   103	113	215	finally
    //   228	270	215	finally
    //   68	76	219	java/lang/Throwable
    //   79	85	219	java/lang/Throwable
    //   90	100	219	java/lang/Throwable
    //   103	113	219	java/lang/Throwable
    //   286	290	293	java/io/IOException
  }
  
  public boolean b()
  {
    try
    {
      long l1 = System.currentTimeMillis();
      if (!a(this.g, this.h))
      {
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.ApolloGameRscVerify", 2, "Verifying switch is off in debug mode.");
        }
        this.e.set(false);
        if (this.l != null)
        {
          this.l.a(0);
          return true;
        }
      }
      else
      {
        if (!f()) {
          return false;
        }
        if (this.c == null) {
          return false;
        }
        Iterator localIterator = this.c.keys();
        StringBuilder localStringBuilder = new StringBuilder(200);
        while (localIterator.hasNext())
        {
          this.b += 1;
          String str = (String)localIterator.next();
          localStringBuilder.delete(0, localStringBuilder.length());
          localStringBuilder.append(g());
          localStringBuilder.append("/");
          localStringBuilder.append(str);
          if (!a(localStringBuilder.toString(), str)) {
            return false;
          }
        }
        this.a = (System.currentTimeMillis() - l1);
        if (this.l != null) {
          this.l.a(0);
        }
        return true;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmgame_process.ApolloGameRscVerify", 1, localThrowable, new Object[0]);
      return false;
    }
    return true;
  }
  
  public String c()
  {
    if (this.h == 0) {
      return String.valueOf(this.g);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.g);
    localStringBuilder.append("_");
    localStringBuilder.append(this.i);
    return localStringBuilder.toString();
  }
  
  public String d()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return ((QQAppInterface)localAppRuntime).getCurrentAccountUin();
    }
    return "";
  }
  
  public void e()
  {
    if (this.b == 0)
    {
      QLog.w("cmgame_process.ApolloGameRscVerify", 1, "mTotalFiles is 0.");
      return;
    }
    Object localObject = new StringBuilder(200);
    float f1 = (float)this.a * 1.0F / this.b;
    ((StringBuilder)localObject).append("gameId:");
    ((StringBuilder)localObject).append(this.g);
    ((StringBuilder)localObject).append(",totalCost:");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append(",totalFiles:");
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append(",avgCost:");
    ((StringBuilder)localObject).append(f1);
    QLog.i("cmgame_process.ApolloGameRscVerify", 1, ((StringBuilder)localObject).toString());
    localObject = new HashMap();
    ((HashMap)localObject).put("gameId", Integer.toString(this.g));
    ((HashMap)localObject).put("avgCost", Float.toString(f1));
    String str = d();
    StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(str, "cmshow_game_rsc_avg_cost", true, -1L, -1L, (HashMap)localObject, "", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.utils.ApolloGameRscVerify
 * JD-Core Version:    0.7.0.1
 */
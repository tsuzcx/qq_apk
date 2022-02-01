package com.tencent.mobileqq.apollo.game.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.game.process.CmGameUtil;
import com.tencent.mobileqq.apollo.game.process.data.CmGameInitParams;
import com.tencent.mobileqq.apollo.game.process.data.CmGameLauncher;
import com.tencent.mobileqq.apollo.model.ApolloGameData;
import com.tencent.mobileqq.apollo.model.StartCheckParam;
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
  public int a;
  public long a;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private ApolloGameRscVerify.OnVerifyResultCallback jdField_a_of_type_ComTencentMobileqqApolloGameUtilsApolloGameRscVerify$OnVerifyResultCallback;
  private String jdField_a_of_type_JavaLangString;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private JSONObject jdField_a_of_type_OrgJsonJSONObject = null;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private int c;
  private int d = 0;
  
  public ApolloGameRscVerify(int paramInt)
  {
    this(paramInt, 0, "", "");
  }
  
  public ApolloGameRscVerify(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.c = paramInt2;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_a_of_type_AndroidContentSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_sp", 4);
  }
  
  private void a(String paramString, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("gameId:");
    ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
    ((StringBuilder)localObject).append(",failType:");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(",fileName:");
    ((StringBuilder)localObject).append(paramString);
    QLog.w("cmgame_process.ApolloGameRscVerify", 1, ((StringBuilder)localObject).toString());
    if ((this.jdField_a_of_type_AndroidContentSharedPreferences != null) && (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean != null))
    {
      this.d = paramInt;
      localObject = this.jdField_a_of_type_ComTencentMobileqqApolloGameUtilsApolloGameRscVerify$OnVerifyResultCallback;
      if (localObject != null) {
        ((ApolloGameRscVerify.OnVerifyResultCallback)localObject).a(paramInt);
      }
      int i = this.c;
      if (i != 3)
      {
        if (i == 4) {
          return;
        }
        localObject = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("apollo_sp_game_rsc_verify_");
        localStringBuilder.append(a());
        ((SharedPreferences.Editor)localObject).putBoolean(localStringBuilder.toString(), true).commit();
        this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        localObject = new HashMap();
        ((HashMap)localObject).put("gameId", Integer.toString(this.jdField_b_of_type_Int));
        ((HashMap)localObject).put("rscPath", paramString);
        ((HashMap)localObject).put("errType", Integer.toString(paramInt));
        paramString = b();
        StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(paramString, "cmshow_game_rsc_error", true, -1L, -1L, (HashMap)localObject, "", true);
      }
      return;
    }
    QLog.e("cmgame_process.ApolloGameRscVerify", 1, "[onVerifyFailure] fails, param is wrong");
  }
  
  @Deprecated
  public static boolean a(int paramInt)
  {
    try
    {
      Object localObject = CmGameUtil.a(paramInt);
      if (localObject == null)
      {
        QLog.w("cmgame_process.ApolloGameRscVerify", 1, "[isNeedVerify], launcher is null.");
        return false;
      }
      CmGameInitParams localCmGameInitParams = ((CmGameLauncher)localObject).a();
      if (localCmGameInitParams != null) {
        return a(localCmGameInitParams.isWhiteUsr, paramInt);
      }
      localObject = ((CmGameLauncher)localObject).a();
      if (localObject != null)
      {
        QLog.w("cmgame_process.ApolloGameRscVerify", 1, "[isNeedVerify], initParams is null use startCheckParam check");
        return a(((StartCheckParam)localObject).isWhiteUsr, paramInt);
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
  
  @Deprecated
  public static boolean a(boolean paramBoolean, int paramInt)
  {
    return true;
  }
  
  private String c()
  {
    StringBuilder localStringBuilder = new StringBuilder(500);
    int i = this.c;
    if (i == 0)
    {
      localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/game/");
      localStringBuilder.append(this.jdField_b_of_type_Int);
    }
    else if (i == 1)
    {
      localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/game/");
      localStringBuilder.append(this.jdField_b_of_type_Int);
      localStringBuilder.append("/");
      localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    }
    else
    {
      if ((i == 3) || (i == 4)) {
        break label97;
      }
    }
    return localStringBuilder.toString();
    label97:
    return SOPreLoader.b();
  }
  
  private boolean c()
  {
    try
    {
      if (!a(this.jdField_b_of_type_Int, this.c))
      {
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.ApolloGameRscVerify", 2, "Verifying switch is off in debug mode.");
        }
        this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        if (this.jdField_a_of_type_ComTencentMobileqqApolloGameUtilsApolloGameRscVerify$OnVerifyResultCallback != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqApolloGameUtilsApolloGameRscVerify$OnVerifyResultCallback.a(0);
          return false;
        }
      }
      else
      {
        new ApolloGameData().gameId = this.jdField_b_of_type_Int;
        Object localObject = new File(c(), d());
        if (!((File)localObject).exists())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("game checklist NOT exist, gameId:");
          ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
          QLog.w("cmgame_process.ApolloGameRscVerify", 1, ((StringBuilder)localObject).toString());
          a("checkList", 2);
          return false;
        }
        if ((this.c == 0) || (this.c == 1))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(c());
          localStringBuilder.append("/checkList.sig");
          if (!new RSAVerify(localStringBuilder.toString(), ((File)localObject).getAbsolutePath()).a(0))
          {
            a("checkList.sig", 3);
            return false;
          }
        }
        this.jdField_a_of_type_OrgJsonJSONObject = new JSONObject(FileUtils.readFileToString((File)localObject));
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
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
  
  private String d()
  {
    if (this.c == 4) {
      return "checkList_jsc";
    }
    return "checkList";
  }
  
  public String a()
  {
    if (this.c == 0) {
      return String.valueOf(this.jdField_b_of_type_Int);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append("_");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    return localStringBuilder.toString();
  }
  
  public void a()
  {
    ThreadManager.post(new ApolloGameRscVerify.1(this), 5, null, true);
  }
  
  public void a(ApolloGameRscVerify.OnVerifyResultCallback paramOnVerifyResultCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloGameUtilsApolloGameRscVerify$OnVerifyResultCallback = paramOnVerifyResultCallback;
  }
  
  public boolean a()
  {
    try
    {
      long l = System.currentTimeMillis();
      if (!a(this.jdField_b_of_type_Int, this.c))
      {
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.ApolloGameRscVerify", 2, "Verifying switch is off in debug mode.");
        }
        this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        if (this.jdField_a_of_type_ComTencentMobileqqApolloGameUtilsApolloGameRscVerify$OnVerifyResultCallback != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqApolloGameUtilsApolloGameRscVerify$OnVerifyResultCallback.a(0);
          return true;
        }
      }
      else
      {
        if (!c()) {
          return false;
        }
        if (this.jdField_a_of_type_OrgJsonJSONObject == null) {
          return false;
        }
        Iterator localIterator = this.jdField_a_of_type_OrgJsonJSONObject.keys();
        StringBuilder localStringBuilder = new StringBuilder(200);
        while (localIterator.hasNext())
        {
          this.jdField_a_of_type_Int += 1;
          String str = (String)localIterator.next();
          localStringBuilder.delete(0, localStringBuilder.length());
          localStringBuilder.append(c());
          localStringBuilder.append("/");
          localStringBuilder.append(str);
          if (!a(localStringBuilder.toString(), str)) {
            return false;
          }
        }
        this.jdField_a_of_type_Long = (System.currentTimeMillis() - l);
        if (this.jdField_a_of_type_ComTencentMobileqqApolloGameUtilsApolloGameRscVerify$OnVerifyResultCallback != null) {
          this.jdField_a_of_type_ComTencentMobileqqApolloGameUtilsApolloGameRscVerify$OnVerifyResultCallback.a(0);
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
  
  @Deprecated
  public boolean a(int paramInt1, int paramInt2)
  {
    if ((paramInt2 != 4) && (paramInt2 != 3)) {
      return a(paramInt1);
    }
    return true;
  }
  
  public boolean a(String paramString)
  {
    JSONObject localJSONObject = this.jdField_a_of_type_OrgJsonJSONObject;
    return (localJSONObject != null) && (!TextUtils.isEmpty(localJSONObject.optString(paramString)));
  }
  
  /* Error */
  public boolean a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 35	com/tencent/mobileqq/apollo/game/utils/ApolloGameRscVerify:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   4: invokevirtual 345	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   7: ifeq +299 -> 306
    //   10: aload_0
    //   11: getfield 28	com/tencent/mobileqq/apollo/game/utils/ApolloGameRscVerify:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   14: ifnull +292 -> 306
    //   17: aload_2
    //   18: invokestatic 340	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   21: ifne +285 -> 306
    //   24: aload_1
    //   25: invokestatic 340	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   28: ifne +278 -> 306
    //   31: aload_0
    //   32: getfield 37	com/tencent/mobileqq/apollo/game/utils/ApolloGameRscVerify:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   35: astore_3
    //   36: aload_3
    //   37: ifnull +269 -> 306
    //   40: aload_3
    //   41: invokevirtual 345	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   44: ifeq +5 -> 49
    //   47: iconst_0
    //   48: ireturn
    //   49: aconst_null
    //   50: astore 6
    //   52: aconst_null
    //   53: astore 4
    //   55: new 231	java/io/File
    //   58: dup
    //   59: aload_1
    //   60: invokespecial 346	java/io/File:<init>	(Ljava/lang/String;)V
    //   63: astore 7
    //   65: aload 4
    //   67: astore_3
    //   68: aload 7
    //   70: invokevirtual 241	java/io/File:exists	()Z
    //   73: ifne +14 -> 87
    //   76: aload 4
    //   78: astore_3
    //   79: aload_0
    //   80: aload_2
    //   81: iconst_1
    //   82: invokespecial 247	com/tencent/mobileqq/apollo/game/utils/ApolloGameRscVerify:a	(Ljava/lang/String;I)V
    //   85: iconst_0
    //   86: ireturn
    //   87: aload 4
    //   89: astore_3
    //   90: aload_0
    //   91: getfield 28	com/tencent/mobileqq/apollo/game/utils/ApolloGameRscVerify:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   94: aload_2
    //   95: invokevirtual 334	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   98: astore 5
    //   100: aload 4
    //   102: astore_3
    //   103: new 348	java/io/FileInputStream
    //   106: dup
    //   107: aload_1
    //   108: invokespecial 349	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   111: astore 4
    //   113: aload 4
    //   115: aload 7
    //   117: invokevirtual 351	java/io/File:length	()J
    //   120: invokestatic 357	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   123: invokestatic 363	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   126: astore_3
    //   127: aload_3
    //   128: invokestatic 340	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   131: ifne +52 -> 183
    //   134: aload 5
    //   136: invokestatic 340	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   139: ifne +44 -> 183
    //   142: aload_3
    //   143: invokevirtual 366	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   146: aload 5
    //   148: invokevirtual 366	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   151: invokevirtual 370	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   154: ifne +29 -> 183
    //   157: aload_0
    //   158: aload_2
    //   159: iconst_4
    //   160: invokespecial 247	com/tencent/mobileqq/apollo/game/utils/ApolloGameRscVerify:a	(Ljava/lang/String;I)V
    //   163: aload 4
    //   165: invokevirtual 373	java/io/FileInputStream:close	()V
    //   168: iconst_0
    //   169: ireturn
    //   170: astore_1
    //   171: ldc 84
    //   173: iconst_1
    //   174: ldc_w 375
    //   177: aload_1
    //   178: invokestatic 275	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   181: iconst_0
    //   182: ireturn
    //   183: aload 4
    //   185: invokevirtual 373	java/io/FileInputStream:close	()V
    //   188: iconst_1
    //   189: ireturn
    //   190: astore_1
    //   191: ldc 84
    //   193: iconst_1
    //   194: ldc_w 375
    //   197: aload_1
    //   198: invokestatic 275	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
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
    //   228: ldc 84
    //   230: iconst_1
    //   231: bipush 6
    //   233: anewarray 4	java/lang/Object
    //   236: dup
    //   237: iconst_0
    //   238: ldc_w 377
    //   241: aastore
    //   242: dup
    //   243: iconst_1
    //   244: aload 5
    //   246: aastore
    //   247: dup
    //   248: iconst_2
    //   249: ldc_w 379
    //   252: aastore
    //   253: dup
    //   254: iconst_3
    //   255: aload_1
    //   256: aastore
    //   257: dup
    //   258: iconst_4
    //   259: ldc_w 381
    //   262: aastore
    //   263: dup
    //   264: iconst_5
    //   265: aload_2
    //   266: aastore
    //   267: invokestatic 384	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   270: aload 4
    //   272: ifnull +8 -> 280
    //   275: aload 4
    //   277: invokevirtual 373	java/io/FileInputStream:close	()V
    //   280: iconst_1
    //   281: ireturn
    //   282: aload_3
    //   283: ifnull +21 -> 304
    //   286: aload_3
    //   287: invokevirtual 373	java/io/FileInputStream:close	()V
    //   290: goto +14 -> 304
    //   293: astore_2
    //   294: ldc 84
    //   296: iconst_1
    //   297: ldc_w 375
    //   300: aload_2
    //   301: invokestatic 275	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
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
  
  public String b()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return ((QQAppInterface)localAppRuntime).getCurrentAccountUin();
    }
    return "";
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Int == 0)
    {
      QLog.w("cmgame_process.ApolloGameRscVerify", 1, "mTotalFiles is 0.");
      return;
    }
    Object localObject = new StringBuilder(200);
    float f = (float)this.jdField_a_of_type_Long * 1.0F / this.jdField_a_of_type_Int;
    ((StringBuilder)localObject).append("gameId:");
    ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
    ((StringBuilder)localObject).append(",totalCost:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
    ((StringBuilder)localObject).append(",totalFiles:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
    ((StringBuilder)localObject).append(",avgCost:");
    ((StringBuilder)localObject).append(f);
    QLog.i("cmgame_process.ApolloGameRscVerify", 1, ((StringBuilder)localObject).toString());
    localObject = new HashMap();
    ((HashMap)localObject).put("gameId", Integer.toString(this.jdField_b_of_type_Int));
    ((HashMap)localObject).put("avgCost", Float.toString(f));
    String str = b();
    StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(str, "cmshow_game_rsc_avg_cost", true, -1L, -1L, (HashMap)localObject, "", true);
  }
  
  public boolean b()
  {
    return c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.utils.ApolloGameRscVerify
 * JD-Core Version:    0.7.0.1
 */
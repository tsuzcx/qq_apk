import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;
import com.tencent.mobileqq.apollo.utils.ApolloGameRscVerify.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class anop
{
  public int a;
  public long a;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private anoq jdField_a_of_type_Anoq;
  private String jdField_a_of_type_JavaLangString;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private JSONObject jdField_a_of_type_OrgJsonJSONObject;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private int c;
  private int d = 0;
  
  public anop(int paramInt)
  {
    this(paramInt, 0, "", "");
  }
  
  public anop(int paramInt1, int paramInt2, String paramString1, String paramString2)
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
    QLog.w("cmgame_process.ApolloGameRscVerify", 1, "gameId:" + this.jdField_b_of_type_Int + ",failType:" + paramInt + ",fileName:" + paramString);
    if ((this.jdField_a_of_type_AndroidContentSharedPreferences == null) || (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean == null)) {
      QLog.e("cmgame_process.ApolloGameRscVerify", 1, "[onVerifyFailure] fails, param is wrong");
    }
    do
    {
      return;
      this.d = paramInt;
      if (this.jdField_a_of_type_Anoq != null) {
        this.jdField_a_of_type_Anoq.a(paramInt);
      }
    } while ((this.c == 3) || (this.c == 4));
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("apollo_sp_game_rsc_verify_" + a(), true).commit();
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    HashMap localHashMap = new HashMap();
    localHashMap.put("gameId", Integer.toString(this.jdField_b_of_type_Int));
    localHashMap.put("rscPath", paramString);
    localHashMap.put("errType", Integer.toString(paramInt));
    paramString = b();
    bdmc.a(BaseApplicationImpl.getContext()).a(paramString, "cmshow_game_rsc_error", true, -1L, -1L, localHashMap, "", true);
  }
  
  public static boolean a(int paramInt)
  {
    try
    {
      Object localObject = anbd.a(paramInt);
      if (localObject == null)
      {
        QLog.w("cmgame_process.ApolloGameRscVerify", 1, "[isNeedVerify], launcher is null.");
        return false;
      }
      CmGameInitParams localCmGameInitParams = ((ande)localObject).a();
      if (localCmGameInitParams != null) {
        return a(localCmGameInitParams.isWhiteUsr, paramInt);
      }
      localObject = ((ande)localObject).a();
      if (localObject != null)
      {
        QLog.w("cmgame_process.ApolloGameRscVerify", 1, "[isNeedVerify], initParams is null use startCheckParam check");
        return a(((CmGameStartChecker.StartCheckParam)localObject).isWhiteUsr, paramInt);
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
  
  public static boolean a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean) {}
    try
    {
      if (amxt.a(paramInt))
      {
        paramBoolean = BaseApplicationImpl.getApplication().getSharedPreferences("cmgame_sp", 4).getBoolean("game_whitelist_verify_switch", true);
        QLog.i("cmgame_process.ApolloGameRscVerify", 1, "game_rsc_verify_switch:" + paramBoolean);
        return paramBoolean;
      }
      return true;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmgame_process.ApolloGameRscVerify", 1, localThrowable, new Object[0]);
    }
    return true;
  }
  
  private String c()
  {
    StringBuilder localStringBuilder = new StringBuilder(500);
    if (this.c == 0) {
      localStringBuilder.append(annv.s).append(this.jdField_b_of_type_Int);
    }
    do
    {
      for (;;)
      {
        return localStringBuilder.toString();
        if (this.c != 1) {
          break;
        }
        localStringBuilder.append(annv.s).append(this.jdField_b_of_type_Int).append("/").append(this.jdField_b_of_type_JavaLangString);
      }
    } while ((this.c != 3) && (this.c != 4));
    return blhg.b();
  }
  
  private boolean c()
  {
    for (;;)
    {
      try
      {
        if (!a(this.jdField_b_of_type_Int, this.c))
        {
          if (QLog.isColorLevel()) {
            QLog.d("cmgame_process.ApolloGameRscVerify", 2, "Verifying switch is off in debug mode.");
          }
          this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
          if (this.jdField_a_of_type_Anoq == null) {
            break;
          }
          this.jdField_a_of_type_Anoq.a(0);
          return false;
        }
        new ApolloGameData().gameId = this.jdField_b_of_type_Int;
        File localFile = new File(c(), d());
        if (!localFile.exists())
        {
          QLog.w("cmgame_process.ApolloGameRscVerify", 1, "game checklist NOT exist, gameId:" + this.jdField_b_of_type_Int);
          a("checkList", 2);
          return false;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("cmgame_process.ApolloGameRscVerify", 1, "[ApolloGameRscVerify], errInfo->", localThrowable);
        return true;
      }
      if (((this.c == 0) || (this.c == 1)) && (!new anqa(c() + "/checkList.sig", localThrowable.getAbsolutePath()).a(0)))
      {
        a("checkList.sig", 3);
        return false;
      }
      this.jdField_a_of_type_OrgJsonJSONObject = new JSONObject(bhmi.b(localThrowable));
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
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
    return this.jdField_b_of_type_Int + "_" + this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    ThreadManager.post(new ApolloGameRscVerify.1(this), 5, null, true);
  }
  
  public void a(anoq paramanoq)
  {
    this.jdField_a_of_type_Anoq = paramanoq;
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
        if (this.jdField_a_of_type_Anoq != null) {
          this.jdField_a_of_type_Anoq.a(0);
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
          localStringBuilder.append("/").append(str);
          if (!a(localStringBuilder.toString(), str)) {
            return false;
          }
        }
        this.jdField_a_of_type_Long = (System.currentTimeMillis() - l);
        if (this.jdField_a_of_type_Anoq != null) {
          this.jdField_a_of_type_Anoq.a(0);
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
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if ((paramInt2 == 4) || (paramInt2 == 3)) {
      return true;
    }
    return a(paramInt1);
  }
  
  public boolean a(String paramString)
  {
    return (this.jdField_a_of_type_OrgJsonJSONObject != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_OrgJsonJSONObject.optString(paramString)));
  }
  
  /* Error */
  public boolean a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 33	anop:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   4: invokevirtual 362	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   7: ifeq +41 -> 48
    //   10: aload_0
    //   11: getfield 292	anop:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   14: ifnull +34 -> 48
    //   17: aload_2
    //   18: invokestatic 357	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   21: ifne +27 -> 48
    //   24: aload_1
    //   25: invokestatic 357	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   28: ifne +20 -> 48
    //   31: aload_0
    //   32: getfield 35	anop:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   35: ifnull +13 -> 48
    //   38: aload_0
    //   39: getfield 35	anop:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   42: invokevirtual 362	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   45: ifeq +5 -> 50
    //   48: iconst_0
    //   49: ireturn
    //   50: invokestatic 319	java/lang/System:currentTimeMillis	()J
    //   53: pop2
    //   54: aconst_null
    //   55: astore 4
    //   57: aconst_null
    //   58: astore 5
    //   60: new 248	java/io/File
    //   63: dup
    //   64: aload_1
    //   65: invokespecial 363	java/io/File:<init>	(Ljava/lang/String;)V
    //   68: astore 7
    //   70: aload 4
    //   72: astore_3
    //   73: aload 7
    //   75: invokevirtual 258	java/io/File:exists	()Z
    //   78: ifne +37 -> 115
    //   81: aload 4
    //   83: astore_3
    //   84: aload_0
    //   85: aload_2
    //   86: iconst_1
    //   87: invokespecial 264	anop:a	(Ljava/lang/String;I)V
    //   90: iconst_0
    //   91: ifeq -43 -> 48
    //   94: new 365	java/lang/NullPointerException
    //   97: dup
    //   98: invokespecial 366	java/lang/NullPointerException:<init>	()V
    //   101: athrow
    //   102: astore_1
    //   103: ldc 66
    //   105: iconst_1
    //   106: ldc_w 368
    //   109: aload_1
    //   110: invokestatic 269	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   113: iconst_0
    //   114: ireturn
    //   115: aload 4
    //   117: astore_3
    //   118: aload_0
    //   119: getfield 292	anop:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   122: aload_2
    //   123: invokevirtual 351	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   126: astore 6
    //   128: aload 4
    //   130: astore_3
    //   131: new 370	java/io/FileInputStream
    //   134: dup
    //   135: aload_1
    //   136: invokespecial 371	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   139: astore 4
    //   141: aload 4
    //   143: aload 7
    //   145: invokevirtual 373	java/io/File:length	()J
    //   148: invokestatic 379	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   151: invokestatic 385	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   154: astore_3
    //   155: aload_3
    //   156: invokestatic 357	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   159: ifne +57 -> 216
    //   162: aload 6
    //   164: invokestatic 357	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   167: ifne +49 -> 216
    //   170: aload_3
    //   171: invokevirtual 388	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   174: aload 6
    //   176: invokevirtual 388	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   179: invokevirtual 392	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   182: ifne +34 -> 216
    //   185: aload_0
    //   186: aload_2
    //   187: iconst_4
    //   188: invokespecial 264	anop:a	(Ljava/lang/String;I)V
    //   191: aload 4
    //   193: ifnull -145 -> 48
    //   196: aload 4
    //   198: invokevirtual 395	java/io/FileInputStream:close	()V
    //   201: iconst_0
    //   202: ireturn
    //   203: astore_1
    //   204: ldc 66
    //   206: iconst_1
    //   207: ldc_w 368
    //   210: aload_1
    //   211: invokestatic 269	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   214: iconst_0
    //   215: ireturn
    //   216: aload 4
    //   218: ifnull +8 -> 226
    //   221: aload 4
    //   223: invokevirtual 395	java/io/FileInputStream:close	()V
    //   226: iconst_1
    //   227: ireturn
    //   228: astore_1
    //   229: ldc 66
    //   231: iconst_1
    //   232: ldc_w 368
    //   235: aload_1
    //   236: invokestatic 269	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   239: goto -13 -> 226
    //   242: astore_3
    //   243: aload 5
    //   245: astore 4
    //   247: aload_3
    //   248: astore 5
    //   250: aload 4
    //   252: astore_3
    //   253: ldc 66
    //   255: iconst_1
    //   256: bipush 6
    //   258: anewarray 4	java/lang/Object
    //   261: dup
    //   262: iconst_0
    //   263: ldc_w 397
    //   266: aastore
    //   267: dup
    //   268: iconst_1
    //   269: aload 5
    //   271: aastore
    //   272: dup
    //   273: iconst_2
    //   274: ldc_w 399
    //   277: aastore
    //   278: dup
    //   279: iconst_3
    //   280: aload_1
    //   281: aastore
    //   282: dup
    //   283: iconst_4
    //   284: ldc_w 401
    //   287: aastore
    //   288: dup
    //   289: iconst_5
    //   290: aload_2
    //   291: aastore
    //   292: invokestatic 404	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   295: aload 4
    //   297: ifnull -71 -> 226
    //   300: aload 4
    //   302: invokevirtual 395	java/io/FileInputStream:close	()V
    //   305: goto -79 -> 226
    //   308: astore_1
    //   309: ldc 66
    //   311: iconst_1
    //   312: ldc_w 368
    //   315: aload_1
    //   316: invokestatic 269	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   319: goto -93 -> 226
    //   322: astore_1
    //   323: aload_3
    //   324: ifnull +7 -> 331
    //   327: aload_3
    //   328: invokevirtual 395	java/io/FileInputStream:close	()V
    //   331: aload_1
    //   332: athrow
    //   333: astore_2
    //   334: ldc 66
    //   336: iconst_1
    //   337: ldc_w 368
    //   340: aload_2
    //   341: invokestatic 269	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   344: goto -13 -> 331
    //   347: astore_1
    //   348: aload 4
    //   350: astore_3
    //   351: goto -28 -> 323
    //   354: astore 5
    //   356: goto -106 -> 250
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	359	0	this	anop
    //   0	359	1	paramString1	String
    //   0	359	2	paramString2	String
    //   72	99	3	localObject1	Object
    //   242	6	3	localThrowable1	Throwable
    //   252	99	3	localObject2	Object
    //   55	294	4	localObject3	Object
    //   58	212	5	localObject4	Object
    //   354	1	5	localThrowable2	Throwable
    //   126	49	6	str	String
    //   68	76	7	localFile	File
    // Exception table:
    //   from	to	target	type
    //   94	102	102	java/io/IOException
    //   196	201	203	java/io/IOException
    //   221	226	228	java/io/IOException
    //   73	81	242	java/lang/Throwable
    //   84	90	242	java/lang/Throwable
    //   118	128	242	java/lang/Throwable
    //   131	141	242	java/lang/Throwable
    //   300	305	308	java/io/IOException
    //   73	81	322	finally
    //   84	90	322	finally
    //   118	128	322	finally
    //   131	141	322	finally
    //   253	295	322	finally
    //   327	331	333	java/io/IOException
    //   141	191	347	finally
    //   141	191	354	java/lang/Throwable
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
    float f = 1.0F * (float)this.jdField_a_of_type_Long / this.jdField_a_of_type_Int;
    ((StringBuilder)localObject).append("gameId:").append(this.jdField_b_of_type_Int).append(",totalCost:").append(this.jdField_a_of_type_Long).append(",totalFiles:").append(this.jdField_a_of_type_Int).append(",avgCost:").append(f);
    QLog.i("cmgame_process.ApolloGameRscVerify", 1, ((StringBuilder)localObject).toString());
    localObject = new HashMap();
    ((HashMap)localObject).put("gameId", Integer.toString(this.jdField_b_of_type_Int));
    ((HashMap)localObject).put("avgCost", Float.toString(f));
    String str = b();
    bdmc.a(BaseApplicationImpl.getContext()).a(str, "cmshow_game_rsc_avg_cost", true, -1L, -1L, (HashMap)localObject, "", true);
  }
  
  public boolean b()
  {
    return c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anop
 * JD-Core Version:    0.7.0.1
 */
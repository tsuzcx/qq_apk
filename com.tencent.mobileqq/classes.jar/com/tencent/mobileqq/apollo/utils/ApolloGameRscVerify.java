package com.tencent.mobileqq.apollo.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import org.json.JSONObject;
import ytb;

public class ApolloGameRscVerify
{
  public int a;
  public long a;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private JSONObject jdField_a_of_type_OrgJsonJSONObject;
  private int jdField_b_of_type_Int;
  private AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  
  public ApolloGameRscVerify(int paramInt)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidContentSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_sp", 0);
  }
  
  private void a(String paramString, int paramInt)
  {
    QLog.w("cmgame_process.ApolloGameRscVerify", 1, "gameId:" + this.jdField_b_of_type_Int + ",failType:" + paramInt + ",fileName:" + paramString);
    if ((this.jdField_a_of_type_AndroidContentSharedPreferences == null) || (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean == null))
    {
      QLog.e("cmgame_process.ApolloGameRscVerify", 1, "[onVerifyFailure] fails, param is wrong");
      return;
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("apollo_sp_game_rsc_verify_" + this.jdField_b_of_type_Int, true).commit();
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    HashMap localHashMap = new HashMap();
    localHashMap.put("gameId", Integer.toString(this.jdField_b_of_type_Int));
    localHashMap.put("rscPath", paramString);
    localHashMap.put("errType", Integer.toString(paramInt));
    paramString = a();
    StatisticCollector.a(BaseApplicationImpl.getContext()).a(paramString, "cmshow_game_rsc_error", true, -1L, -1L, localHashMap, "", true);
  }
  
  private boolean a()
  {
    File localFile;
    try
    {
      ApolloGameData localApolloGameData = new ApolloGameData();
      localApolloGameData.gameId = this.jdField_b_of_type_Int;
      localFile = new File(ApolloUtil.a(localApolloGameData), "checkList");
      if (!localFile.exists())
      {
        QLog.w("cmgame_process.ApolloGameRscVerify", 1, "game checklist NOT exist, gameId:" + this.jdField_b_of_type_Int);
        a("checkList", 2);
        return false;
      }
      if (!new RSAVerify(ApolloUtil.a(localApolloGameData) + "/checkList.sig", localFile.getAbsolutePath()).a(0))
      {
        a("checkList.sig", 3);
        return false;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmgame_process.ApolloGameRscVerify", 1, "[ApolloGameRscVerify], errInfo->", localThrowable);
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_OrgJsonJSONObject = new JSONObject(FileUtils.b(localFile));
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    }
  }
  
  public String a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return ((QQAppInterface)localAppRuntime).getCurrentAccountUin();
    }
    return "";
  }
  
  public void a()
  {
    ThreadManager.post(new ytb(this), 5, null, true);
  }
  
  /* Error */
  public boolean a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 23	com/tencent/mobileqq/apollo/utils/ApolloGameRscVerify:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   4: invokevirtual 226	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   7: ifeq +50 -> 57
    //   10: aload_0
    //   11: getfield 50	com/tencent/mobileqq/apollo/utils/ApolloGameRscVerify:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   14: ifnull +43 -> 57
    //   17: aload_2
    //   18: invokestatic 232	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   21: ifne +36 -> 57
    //   24: aload_1
    //   25: invokestatic 232	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   28: ifne +29 -> 57
    //   31: aload_1
    //   32: ldc 234
    //   34: invokevirtual 239	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   37: ifeq +20 -> 57
    //   40: aload_0
    //   41: getfield 25	com/tencent/mobileqq/apollo/utils/ApolloGameRscVerify:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   44: ifnull +13 -> 57
    //   47: aload_0
    //   48: getfield 25	com/tencent/mobileqq/apollo/utils/ApolloGameRscVerify:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   51: invokevirtual 226	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   54: ifeq +5 -> 59
    //   57: iconst_0
    //   58: ireturn
    //   59: invokestatic 245	java/lang/System:currentTimeMillis	()J
    //   62: pop2
    //   63: aconst_null
    //   64: astore 4
    //   66: aconst_null
    //   67: astore 5
    //   69: new 152	java/io/File
    //   72: dup
    //   73: aload_1
    //   74: invokespecial 246	java/io/File:<init>	(Ljava/lang/String;)V
    //   77: astore 7
    //   79: aload 4
    //   81: astore_3
    //   82: aload 7
    //   84: invokevirtual 165	java/io/File:exists	()Z
    //   87: ifne +36 -> 123
    //   90: aload 4
    //   92: astore_3
    //   93: aload_0
    //   94: aload_2
    //   95: iconst_1
    //   96: invokespecial 169	com/tencent/mobileqq/apollo/utils/ApolloGameRscVerify:a	(Ljava/lang/String;I)V
    //   99: iconst_0
    //   100: ifeq -43 -> 57
    //   103: new 248	java/lang/NullPointerException
    //   106: dup
    //   107: invokespecial 249	java/lang/NullPointerException:<init>	()V
    //   110: athrow
    //   111: astore_1
    //   112: ldc 53
    //   114: iconst_1
    //   115: ldc 251
    //   117: aload_1
    //   118: invokestatic 187	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   121: iconst_0
    //   122: ireturn
    //   123: aload 4
    //   125: astore_3
    //   126: aload_0
    //   127: getfield 50	com/tencent/mobileqq/apollo/utils/ApolloGameRscVerify:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   130: aload_2
    //   131: invokevirtual 255	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   134: astore 6
    //   136: aload 4
    //   138: astore_3
    //   139: new 257	java/io/FileInputStream
    //   142: dup
    //   143: aload_1
    //   144: invokespecial 258	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   147: astore 4
    //   149: aload 4
    //   151: aload 7
    //   153: invokevirtual 261	java/io/File:length	()J
    //   156: invokestatic 267	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   159: invokestatic 273	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   162: astore_3
    //   163: aload_3
    //   164: invokestatic 232	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   167: ifne +56 -> 223
    //   170: aload 6
    //   172: invokestatic 232	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   175: ifne +48 -> 223
    //   178: aload_3
    //   179: invokevirtual 276	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   182: aload 6
    //   184: invokevirtual 276	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   187: invokevirtual 280	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   190: ifne +33 -> 223
    //   193: aload_0
    //   194: aload_2
    //   195: iconst_4
    //   196: invokespecial 169	com/tencent/mobileqq/apollo/utils/ApolloGameRscVerify:a	(Ljava/lang/String;I)V
    //   199: aload 4
    //   201: ifnull -144 -> 57
    //   204: aload 4
    //   206: invokevirtual 283	java/io/FileInputStream:close	()V
    //   209: iconst_0
    //   210: ireturn
    //   211: astore_1
    //   212: ldc 53
    //   214: iconst_1
    //   215: ldc 251
    //   217: aload_1
    //   218: invokestatic 187	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   221: iconst_0
    //   222: ireturn
    //   223: aload 4
    //   225: ifnull +8 -> 233
    //   228: aload 4
    //   230: invokevirtual 283	java/io/FileInputStream:close	()V
    //   233: iconst_1
    //   234: ireturn
    //   235: astore_1
    //   236: ldc 53
    //   238: iconst_1
    //   239: ldc 251
    //   241: aload_1
    //   242: invokestatic 187	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   245: goto -12 -> 233
    //   248: astore_3
    //   249: aload 5
    //   251: astore 4
    //   253: aload_3
    //   254: astore 5
    //   256: aload 4
    //   258: astore_3
    //   259: ldc 53
    //   261: iconst_1
    //   262: bipush 6
    //   264: anewarray 4	java/lang/Object
    //   267: dup
    //   268: iconst_0
    //   269: ldc_w 285
    //   272: aastore
    //   273: dup
    //   274: iconst_1
    //   275: aload 5
    //   277: aastore
    //   278: dup
    //   279: iconst_2
    //   280: ldc_w 287
    //   283: aastore
    //   284: dup
    //   285: iconst_3
    //   286: aload_1
    //   287: aastore
    //   288: dup
    //   289: iconst_4
    //   290: ldc_w 289
    //   293: aastore
    //   294: dup
    //   295: iconst_5
    //   296: aload_2
    //   297: aastore
    //   298: invokestatic 292	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   301: aload 4
    //   303: ifnull -70 -> 233
    //   306: aload 4
    //   308: invokevirtual 283	java/io/FileInputStream:close	()V
    //   311: goto -78 -> 233
    //   314: astore_1
    //   315: ldc 53
    //   317: iconst_1
    //   318: ldc 251
    //   320: aload_1
    //   321: invokestatic 187	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   324: goto -91 -> 233
    //   327: astore_1
    //   328: aload_3
    //   329: ifnull +7 -> 336
    //   332: aload_3
    //   333: invokevirtual 283	java/io/FileInputStream:close	()V
    //   336: aload_1
    //   337: athrow
    //   338: astore_2
    //   339: ldc 53
    //   341: iconst_1
    //   342: ldc 251
    //   344: aload_2
    //   345: invokestatic 187	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   348: goto -12 -> 336
    //   351: astore_1
    //   352: aload 4
    //   354: astore_3
    //   355: goto -27 -> 328
    //   358: astore 5
    //   360: goto -104 -> 256
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	363	0	this	ApolloGameRscVerify
    //   0	363	1	paramString1	String
    //   0	363	2	paramString2	String
    //   81	98	3	localObject1	Object
    //   248	6	3	localThrowable1	Throwable
    //   258	97	3	localObject2	Object
    //   64	289	4	localObject3	Object
    //   67	209	5	localObject4	Object
    //   358	1	5	localThrowable2	Throwable
    //   134	49	6	str	String
    //   77	75	7	localFile	File
    // Exception table:
    //   from	to	target	type
    //   103	111	111	java/io/IOException
    //   204	209	211	java/io/IOException
    //   228	233	235	java/io/IOException
    //   82	90	248	java/lang/Throwable
    //   93	99	248	java/lang/Throwable
    //   126	136	248	java/lang/Throwable
    //   139	149	248	java/lang/Throwable
    //   306	311	314	java/io/IOException
    //   82	90	327	finally
    //   93	99	327	finally
    //   126	136	327	finally
    //   139	149	327	finally
    //   259	301	327	finally
    //   332	336	338	java/io/IOException
    //   149	199	351	finally
    //   149	199	358	java/lang/Throwable
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
    String str = a();
    StatisticCollector.a(BaseApplicationImpl.getContext()).a(str, "cmshow_game_rsc_avg_cost", true, -1L, -1L, (HashMap)localObject, "", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloGameRscVerify
 * JD-Core Version:    0.7.0.1
 */
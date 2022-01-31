package com.tencent.mobileqq.apollo.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
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
import zda;

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
  
  private boolean b()
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
    ThreadManager.post(new zda(this), 5, null, true);
  }
  
  public boolean a()
  {
    return b();
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
    //   1: getfield 23	com/tencent/mobileqq/apollo/utils/ApolloGameRscVerify:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   4: invokevirtual 237	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   7: ifeq +50 -> 57
    //   10: aload_0
    //   11: getfield 50	com/tencent/mobileqq/apollo/utils/ApolloGameRscVerify:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   14: ifnull +43 -> 57
    //   17: aload_2
    //   18: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   21: ifne +36 -> 57
    //   24: aload_1
    //   25: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   28: ifne +29 -> 57
    //   31: aload_1
    //   32: ldc 239
    //   34: invokevirtual 244	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   37: ifeq +20 -> 57
    //   40: aload_0
    //   41: getfield 25	com/tencent/mobileqq/apollo/utils/ApolloGameRscVerify:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   44: ifnull +13 -> 57
    //   47: aload_0
    //   48: getfield 25	com/tencent/mobileqq/apollo/utils/ApolloGameRscVerify:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   51: invokevirtual 237	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   54: ifeq +5 -> 59
    //   57: iconst_0
    //   58: ireturn
    //   59: invokestatic 250	java/lang/System:currentTimeMillis	()J
    //   62: pop2
    //   63: aconst_null
    //   64: astore 4
    //   66: aconst_null
    //   67: astore 5
    //   69: new 155	java/io/File
    //   72: dup
    //   73: aload_1
    //   74: invokespecial 251	java/io/File:<init>	(Ljava/lang/String;)V
    //   77: astore 7
    //   79: aload 4
    //   81: astore_3
    //   82: aload 7
    //   84: invokevirtual 168	java/io/File:exists	()Z
    //   87: ifne +37 -> 124
    //   90: aload 4
    //   92: astore_3
    //   93: aload_0
    //   94: aload_2
    //   95: iconst_1
    //   96: invokespecial 172	com/tencent/mobileqq/apollo/utils/ApolloGameRscVerify:a	(Ljava/lang/String;I)V
    //   99: iconst_0
    //   100: ifeq -43 -> 57
    //   103: new 253	java/lang/NullPointerException
    //   106: dup
    //   107: invokespecial 254	java/lang/NullPointerException:<init>	()V
    //   110: athrow
    //   111: astore_1
    //   112: ldc 53
    //   114: iconst_1
    //   115: ldc_w 256
    //   118: aload_1
    //   119: invokestatic 190	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   122: iconst_0
    //   123: ireturn
    //   124: aload 4
    //   126: astore_3
    //   127: aload_0
    //   128: getfield 50	com/tencent/mobileqq/apollo/utils/ApolloGameRscVerify:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   131: aload_2
    //   132: invokevirtual 225	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   135: astore 6
    //   137: aload 4
    //   139: astore_3
    //   140: new 258	java/io/FileInputStream
    //   143: dup
    //   144: aload_1
    //   145: invokespecial 259	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   148: astore 4
    //   150: aload 4
    //   152: aload 7
    //   154: invokevirtual 262	java/io/File:length	()J
    //   157: invokestatic 268	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   160: invokestatic 274	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   163: astore_3
    //   164: aload_3
    //   165: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   168: ifne +57 -> 225
    //   171: aload 6
    //   173: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   176: ifne +49 -> 225
    //   179: aload_3
    //   180: invokevirtual 277	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   183: aload 6
    //   185: invokevirtual 277	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   188: invokevirtual 281	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   191: ifne +34 -> 225
    //   194: aload_0
    //   195: aload_2
    //   196: iconst_4
    //   197: invokespecial 172	com/tencent/mobileqq/apollo/utils/ApolloGameRscVerify:a	(Ljava/lang/String;I)V
    //   200: aload 4
    //   202: ifnull -145 -> 57
    //   205: aload 4
    //   207: invokevirtual 284	java/io/FileInputStream:close	()V
    //   210: iconst_0
    //   211: ireturn
    //   212: astore_1
    //   213: ldc 53
    //   215: iconst_1
    //   216: ldc_w 256
    //   219: aload_1
    //   220: invokestatic 190	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   223: iconst_0
    //   224: ireturn
    //   225: aload 4
    //   227: ifnull +8 -> 235
    //   230: aload 4
    //   232: invokevirtual 284	java/io/FileInputStream:close	()V
    //   235: iconst_1
    //   236: ireturn
    //   237: astore_1
    //   238: ldc 53
    //   240: iconst_1
    //   241: ldc_w 256
    //   244: aload_1
    //   245: invokestatic 190	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   248: goto -13 -> 235
    //   251: astore_3
    //   252: aload 5
    //   254: astore 4
    //   256: aload_3
    //   257: astore 5
    //   259: aload 4
    //   261: astore_3
    //   262: ldc 53
    //   264: iconst_1
    //   265: bipush 6
    //   267: anewarray 4	java/lang/Object
    //   270: dup
    //   271: iconst_0
    //   272: ldc_w 286
    //   275: aastore
    //   276: dup
    //   277: iconst_1
    //   278: aload 5
    //   280: aastore
    //   281: dup
    //   282: iconst_2
    //   283: ldc_w 288
    //   286: aastore
    //   287: dup
    //   288: iconst_3
    //   289: aload_1
    //   290: aastore
    //   291: dup
    //   292: iconst_4
    //   293: ldc_w 290
    //   296: aastore
    //   297: dup
    //   298: iconst_5
    //   299: aload_2
    //   300: aastore
    //   301: invokestatic 293	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   304: aload 4
    //   306: ifnull -71 -> 235
    //   309: aload 4
    //   311: invokevirtual 284	java/io/FileInputStream:close	()V
    //   314: goto -79 -> 235
    //   317: astore_1
    //   318: ldc 53
    //   320: iconst_1
    //   321: ldc_w 256
    //   324: aload_1
    //   325: invokestatic 190	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   328: goto -93 -> 235
    //   331: astore_1
    //   332: aload_3
    //   333: ifnull +7 -> 340
    //   336: aload_3
    //   337: invokevirtual 284	java/io/FileInputStream:close	()V
    //   340: aload_1
    //   341: athrow
    //   342: astore_2
    //   343: ldc 53
    //   345: iconst_1
    //   346: ldc_w 256
    //   349: aload_2
    //   350: invokestatic 190	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   353: goto -13 -> 340
    //   356: astore_1
    //   357: aload 4
    //   359: astore_3
    //   360: goto -28 -> 332
    //   363: astore 5
    //   365: goto -106 -> 259
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	368	0	this	ApolloGameRscVerify
    //   0	368	1	paramString1	String
    //   0	368	2	paramString2	String
    //   81	99	3	localObject1	Object
    //   251	6	3	localThrowable1	Throwable
    //   261	99	3	localObject2	Object
    //   64	294	4	localObject3	Object
    //   67	212	5	localObject4	Object
    //   363	1	5	localThrowable2	Throwable
    //   135	49	6	str	String
    //   77	76	7	localFile	File
    // Exception table:
    //   from	to	target	type
    //   103	111	111	java/io/IOException
    //   205	210	212	java/io/IOException
    //   230	235	237	java/io/IOException
    //   82	90	251	java/lang/Throwable
    //   93	99	251	java/lang/Throwable
    //   127	137	251	java/lang/Throwable
    //   140	150	251	java/lang/Throwable
    //   309	314	317	java/io/IOException
    //   82	90	331	finally
    //   93	99	331	finally
    //   127	137	331	finally
    //   140	150	331	finally
    //   262	304	331	finally
    //   336	340	342	java/io/IOException
    //   150	200	356	finally
    //   150	200	363	java/lang/Throwable
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
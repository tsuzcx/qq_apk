package com.tencent.mobileqq.apollo.game;

import android.text.TextUtils;
import android.util.LruCache;
import com.tencent.mobileqq.apollo.game.utils.ApolloGameRscVerify;
import com.tencent.mobileqq.apollo.model.StartCheckParam;
import com.tencent.mobileqq.apollo.script.SpriteRscBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import java.io.File;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class ApolloGameResManager
{
  private static LRULinkedHashMap<String, LruCache<String, ApolloGameResManager.ApolloGameRes>> a = new LRULinkedHashMap(2);
  private static HashMap<String, ApolloGameRscVerify> b = new HashMap();
  
  public static int a(int paramInt)
  {
    try
    {
      Object localObject = new StringBuilder(100);
      ((StringBuilder)localObject).append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/game/");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append("gameConfig.json");
      localObject = new File(((StringBuilder)localObject).toString());
      if (!((File)localObject).exists())
      {
        QLog.w("cmgame_process.CmGameUtil", 1, "[getGameRscType], gameConfig.json NOT exist.");
        return 0;
      }
      localObject = new JSONObject(FileUtils.readFileToString((File)localObject)).optJSONArray("subpackages");
      if (localObject != null)
      {
        paramInt = ((JSONArray)localObject).length();
        if (paramInt > 0) {
          return 1;
        }
      }
      return 0;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmgame_process.CmGameUtil", 1, localThrowable, new Object[0]);
    }
    return 0;
  }
  
  public static JSONObject a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return null;
      }
      try
      {
        paramString = new JSONObject(paramString);
        long l = paramString.optLong("taskId");
        paramQQAppInterface = SpriteRscBuilder.a(paramQQAppInterface, paramString);
        if (paramQQAppInterface == null) {
          return null;
        }
        paramString = new JSONObject();
        paramString.put("ret", 0);
        paramString.put("actionInfo", paramQQAppInterface);
        paramString.put("taskId", l);
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]ApolloGameUtil", 2, new Object[] { "ReqAction,", paramString.toString() });
        }
        return paramString;
      }
      catch (Throwable paramQQAppInterface)
      {
        QLog.e("[cmshow]ApolloGameUtil", 1, paramQQAppInterface, new Object[0]);
      }
    }
    return null;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, StartCheckParam paramStartCheckParam)
  {
    if (paramQQAppInterface != null)
    {
      if (paramStartCheckParam == null) {
        return;
      }
      ThreadManager.post(new ApolloGameResManager.1(paramQQAppInterface, paramStartCheckParam), 5, null, true);
    }
  }
  
  /* Error */
  public static boolean a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 33	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: ldc 36
    //   11: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: pop
    //   15: aload_2
    //   16: aload_0
    //   17: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: pop
    //   21: aload_2
    //   22: ldc 159
    //   24: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: aload_2
    //   29: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: astore_2
    //   33: new 33	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   40: astore_3
    //   41: aload_3
    //   42: ldc 36
    //   44: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload_3
    //   49: aload_0
    //   50: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload_3
    //   55: ldc 161
    //   57: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: aload_3
    //   62: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: astore_3
    //   66: new 33	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   73: astore 4
    //   75: aload 4
    //   77: ldc 36
    //   79: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: aload 4
    //   85: aload_0
    //   86: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: aload 4
    //   92: ldc 163
    //   94: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: pop
    //   98: aload 4
    //   100: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: astore 4
    //   105: new 45	java/io/File
    //   108: dup
    //   109: aload_2
    //   110: invokespecial 58	java/io/File:<init>	(Ljava/lang/String;)V
    //   113: astore_0
    //   114: new 45	java/io/File
    //   117: dup
    //   118: aload_3
    //   119: invokespecial 58	java/io/File:<init>	(Ljava/lang/String;)V
    //   122: astore_2
    //   123: new 45	java/io/File
    //   126: dup
    //   127: aload 4
    //   129: invokespecial 58	java/io/File:<init>	(Ljava/lang/String;)V
    //   132: astore_3
    //   133: aload_3
    //   134: invokevirtual 62	java/io/File:exists	()Z
    //   137: ifeq +8 -> 145
    //   140: aload_3
    //   141: invokevirtual 166	java/io/File:delete	()Z
    //   144: pop
    //   145: aload_3
    //   146: invokevirtual 169	java/io/File:createNewFile	()Z
    //   149: pop
    //   150: aload_0
    //   151: invokevirtual 62	java/io/File:exists	()Z
    //   154: ifeq +151 -> 305
    //   157: aload_0
    //   158: invokevirtual 172	java/io/File:isFile	()Z
    //   161: ifeq +144 -> 305
    //   164: aload_2
    //   165: invokevirtual 62	java/io/File:exists	()Z
    //   168: ifeq +137 -> 305
    //   171: aload_2
    //   172: invokevirtual 172	java/io/File:isFile	()Z
    //   175: ifeq +130 -> 305
    //   178: aload_0
    //   179: invokevirtual 175	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   182: aload_2
    //   183: invokevirtual 175	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   186: aload_3
    //   187: invokevirtual 175	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   190: invokestatic 180	com/tencent/open/base/BspatchUtil:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   193: ifeq +112 -> 305
    //   196: aload_2
    //   197: invokevirtual 166	java/io/File:delete	()Z
    //   200: pop
    //   201: aload_0
    //   202: invokevirtual 166	java/io/File:delete	()Z
    //   205: pop
    //   206: aload_3
    //   207: aload_0
    //   208: invokevirtual 184	java/io/File:renameTo	(Ljava/io/File;)Z
    //   211: pop
    //   212: aload_0
    //   213: invokestatic 188	com/tencent/qqprotect/singleupdate/MD5FileUtil:a	(Ljava/io/File;)Ljava/lang/String;
    //   216: astore 4
    //   218: aload 4
    //   220: ifnull +51 -> 271
    //   223: aload 4
    //   225: aload_1
    //   226: invokevirtual 194	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   229: ifne +42 -> 271
    //   232: ldc 64
    //   234: iconst_1
    //   235: ldc 196
    //   237: invokestatic 198	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   240: aload_0
    //   241: invokevirtual 166	java/io/File:delete	()Z
    //   244: pop
    //   245: aload_3
    //   246: invokevirtual 62	java/io/File:exists	()Z
    //   249: ifeq +8 -> 257
    //   252: aload_3
    //   253: invokevirtual 166	java/io/File:delete	()Z
    //   256: pop
    //   257: aload_2
    //   258: invokevirtual 62	java/io/File:exists	()Z
    //   261: ifeq +8 -> 269
    //   264: aload_2
    //   265: invokevirtual 166	java/io/File:delete	()Z
    //   268: pop
    //   269: iconst_0
    //   270: ireturn
    //   271: ldc 64
    //   273: iconst_1
    //   274: ldc 200
    //   276: invokestatic 203	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   279: aload_3
    //   280: invokevirtual 62	java/io/File:exists	()Z
    //   283: ifeq +8 -> 291
    //   286: aload_3
    //   287: invokevirtual 166	java/io/File:delete	()Z
    //   290: pop
    //   291: aload_2
    //   292: invokevirtual 62	java/io/File:exists	()Z
    //   295: ifeq +8 -> 303
    //   298: aload_2
    //   299: invokevirtual 166	java/io/File:delete	()Z
    //   302: pop
    //   303: iconst_1
    //   304: ireturn
    //   305: ldc 64
    //   307: iconst_1
    //   308: ldc 205
    //   310: invokestatic 198	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   313: aload_0
    //   314: invokevirtual 62	java/io/File:exists	()Z
    //   317: ifeq +8 -> 325
    //   320: aload_0
    //   321: invokevirtual 166	java/io/File:delete	()Z
    //   324: pop
    //   325: aload_3
    //   326: invokevirtual 62	java/io/File:exists	()Z
    //   329: ifeq +8 -> 337
    //   332: aload_3
    //   333: invokevirtual 166	java/io/File:delete	()Z
    //   336: pop
    //   337: aload_2
    //   338: invokevirtual 62	java/io/File:exists	()Z
    //   341: ifeq +8 -> 349
    //   344: aload_2
    //   345: invokevirtual 166	java/io/File:delete	()Z
    //   348: pop
    //   349: iconst_0
    //   350: ireturn
    //   351: astore_0
    //   352: goto +51 -> 403
    //   355: astore_1
    //   356: ldc 64
    //   358: iconst_1
    //   359: ldc 207
    //   361: aload_1
    //   362: invokestatic 210	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   365: aload_0
    //   366: invokevirtual 62	java/io/File:exists	()Z
    //   369: ifeq +8 -> 377
    //   372: aload_0
    //   373: invokevirtual 166	java/io/File:delete	()Z
    //   376: pop
    //   377: aload_3
    //   378: invokevirtual 62	java/io/File:exists	()Z
    //   381: ifeq +8 -> 389
    //   384: aload_3
    //   385: invokevirtual 166	java/io/File:delete	()Z
    //   388: pop
    //   389: aload_2
    //   390: invokevirtual 62	java/io/File:exists	()Z
    //   393: ifeq +8 -> 401
    //   396: aload_2
    //   397: invokevirtual 166	java/io/File:delete	()Z
    //   400: pop
    //   401: iconst_0
    //   402: ireturn
    //   403: aload_3
    //   404: invokevirtual 62	java/io/File:exists	()Z
    //   407: ifeq +8 -> 415
    //   410: aload_3
    //   411: invokevirtual 166	java/io/File:delete	()Z
    //   414: pop
    //   415: aload_2
    //   416: invokevirtual 62	java/io/File:exists	()Z
    //   419: ifeq +8 -> 427
    //   422: aload_2
    //   423: invokevirtual 166	java/io/File:delete	()Z
    //   426: pop
    //   427: aload_0
    //   428: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	429	0	paramString1	String
    //   0	429	1	paramString2	String
    //   7	416	2	localObject1	Object
    //   40	371	3	localObject2	Object
    //   73	151	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   133	145	351	finally
    //   145	218	351	finally
    //   223	245	351	finally
    //   271	279	351	finally
    //   305	325	351	finally
    //   356	377	351	finally
    //   133	145	355	java/lang/Exception
    //   145	218	355	java/lang/Exception
    //   223	245	355	java/lang/Exception
    //   271	279	355	java/lang/Exception
    //   305	325	355	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.ApolloGameResManager
 * JD-Core Version:    0.7.0.1
 */
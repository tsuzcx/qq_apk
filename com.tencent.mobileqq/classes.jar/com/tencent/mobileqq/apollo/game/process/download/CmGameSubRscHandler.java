package com.tencent.mobileqq.apollo.game.process.download;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.game.CmGameStartChecker.ICmGameConfirmListener;
import com.tencent.mobileqq.apollo.game.process.CmGameUtil;
import com.tencent.mobileqq.apollo.game.process.data.CmGameResUpdateInfo;
import com.tencent.mobileqq.apollo.game.process.sso.CmGameSSoHandler;
import com.tencent.mobileqq.apollo.game.utils.ApolloGameRscVerify;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloCmdChannel;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class CmGameSubRscHandler
  implements ICmGameRscDownloadListener
{
  private long a;
  private int b;
  private Context c;
  private Map<String, CmGameSubRscHandler.SubpackTask> d = Collections.synchronizedMap(new LinkedHashMap());
  
  public CmGameSubRscHandler(int paramInt)
  {
    this.b = paramInt;
    this.d.clear();
    ThreadManager.excute(new CmGameSubRscHandler.1(this), 64, null, true);
  }
  
  private int a(String paramString1, String paramString2)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder(100);
      localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/game/");
      localStringBuilder.append(this.b);
      localStringBuilder.append(File.separator);
      localStringBuilder.append(paramString2);
      localStringBuilder.append(File.separator);
      localStringBuilder.append("config.json");
      paramString2 = new File(localStringBuilder.toString());
      if (!paramString2.exists()) {
        return -1;
      }
      int i = (int)new JSONObject(FileUtils.readFileToString(paramString2)).optDouble("version");
      paramString1 = (CmGameSubRscHandler.SubpackTask)this.d.get(paramString1);
      if (paramString1 != null) {
        paramString1.c = i;
      }
      return i;
    }
    catch (Throwable paramString1)
    {
      QLog.e("cmgame_process.CmGameSubRscHandler", 1, paramString1, new Object[0]);
    }
    return -1;
  }
  
  public String a(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/game/");
    localStringBuilder.append(this.b);
    localStringBuilder.append("/");
    localStringBuilder.append(a(paramString));
    return localStringBuilder.toString();
  }
  
  public String a(String paramString)
  {
    if (this.d.size() == 0) {
      a();
    }
    CmGameSubRscHandler.SubpackTask localSubpackTask = (CmGameSubRscHandler.SubpackTask)this.d.get(paramString);
    if (localSubpackTask == null) {
      return "";
    }
    String str2 = localSubpackTask.b;
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      a();
      str1 = localSubpackTask.b;
    }
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameSubRscHandler", 2, new Object[] { "name:", paramString, ",root:", str1 });
    }
    return str1;
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 110
    //   4: iconst_1
    //   5: ldc 156
    //   7: invokestatic 160	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   10: new 55	java/lang/StringBuilder
    //   13: dup
    //   14: bipush 100
    //   16: invokespecial 57	java/lang/StringBuilder:<init>	(I)V
    //   19: astore_2
    //   20: aload_2
    //   21: ldc 59
    //   23: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: aload_2
    //   28: aload_0
    //   29: getfield 33	com/tencent/mobileqq/apollo/game/process/download/CmGameSubRscHandler:b	I
    //   32: invokevirtual 66	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload_2
    //   37: getstatic 72	java/io/File:separator	Ljava/lang/String;
    //   40: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: aload_2
    //   45: ldc 162
    //   47: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: new 68	java/io/File
    //   54: dup
    //   55: aload_2
    //   56: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: invokespecial 81	java/io/File:<init>	(Ljava/lang/String;)V
    //   62: astore_2
    //   63: aload_2
    //   64: invokevirtual 85	java/io/File:exists	()Z
    //   67: ifne +14 -> 81
    //   70: ldc 110
    //   72: iconst_1
    //   73: ldc 164
    //   75: invokestatic 167	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   78: aload_0
    //   79: monitorexit
    //   80: return
    //   81: new 87	org/json/JSONObject
    //   84: dup
    //   85: aload_2
    //   86: invokestatic 93	com/tencent/mobileqq/utils/FileUtils:readFileToString	(Ljava/io/File;)Ljava/lang/String;
    //   89: invokespecial 94	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   92: ldc 169
    //   94: invokevirtual 173	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   97: astore 4
    //   99: aload 4
    //   101: ifnonnull +6 -> 107
    //   104: aload_0
    //   105: monitorexit
    //   106: return
    //   107: iconst_0
    //   108: istore_1
    //   109: iload_1
    //   110: aload 4
    //   112: invokevirtual 178	org/json/JSONArray:length	()I
    //   115: if_icmpge +96 -> 211
    //   118: aload 4
    //   120: iload_1
    //   121: invokevirtual 182	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   124: astore_2
    //   125: aload_2
    //   126: ldc 184
    //   128: invokevirtual 187	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   131: astore 5
    //   133: aload_2
    //   134: ldc 189
    //   136: invokevirtual 187	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   139: astore 6
    //   141: aload_0
    //   142: getfield 31	com/tencent/mobileqq/apollo/game/process/download/CmGameSubRscHandler:d	Ljava/util/Map;
    //   145: aload 5
    //   147: invokeinterface 104 2 0
    //   152: checkcast 106	com/tencent/mobileqq/apollo/game/process/download/CmGameSubRscHandler$SubpackTask
    //   155: astore_3
    //   156: aload_3
    //   157: astore_2
    //   158: aload_3
    //   159: ifnonnull +11 -> 170
    //   162: new 106	com/tencent/mobileqq/apollo/game/process/download/CmGameSubRscHandler$SubpackTask
    //   165: dup
    //   166: invokespecial 190	com/tencent/mobileqq/apollo/game/process/download/CmGameSubRscHandler$SubpackTask:<init>	()V
    //   169: astore_2
    //   170: aload_2
    //   171: aload 5
    //   173: putfield 192	com/tencent/mobileqq/apollo/game/process/download/CmGameSubRscHandler$SubpackTask:a	Ljava/lang/String;
    //   176: aload_2
    //   177: aload 6
    //   179: putfield 138	com/tencent/mobileqq/apollo/game/process/download/CmGameSubRscHandler$SubpackTask:b	Ljava/lang/String;
    //   182: aload_0
    //   183: getfield 31	com/tencent/mobileqq/apollo/game/process/download/CmGameSubRscHandler:d	Ljava/util/Map;
    //   186: aload 5
    //   188: aload_2
    //   189: invokeinterface 196 3 0
    //   194: pop
    //   195: aload_0
    //   196: aload 5
    //   198: aload 6
    //   200: invokespecial 198	com/tencent/mobileqq/apollo/game/process/download/CmGameSubRscHandler:a	(Ljava/lang/String;Ljava/lang/String;)I
    //   203: pop
    //   204: iload_1
    //   205: iconst_1
    //   206: iadd
    //   207: istore_1
    //   208: goto -99 -> 109
    //   211: ldc 110
    //   213: iconst_1
    //   214: ldc 200
    //   216: invokestatic 160	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   219: goto +19 -> 238
    //   222: astore_2
    //   223: goto +18 -> 241
    //   226: astore_2
    //   227: ldc 110
    //   229: iconst_1
    //   230: aload_2
    //   231: iconst_0
    //   232: anewarray 4	java/lang/Object
    //   235: invokestatic 116	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   238: aload_0
    //   239: monitorexit
    //   240: return
    //   241: aload_0
    //   242: monitorexit
    //   243: goto +5 -> 248
    //   246: aload_2
    //   247: athrow
    //   248: goto -2 -> 246
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	251	0	this	CmGameSubRscHandler
    //   108	100	1	i	int
    //   19	170	2	localObject1	Object
    //   222	1	2	localObject2	Object
    //   226	21	2	localThrowable	Throwable
    //   155	4	3	localSubpackTask	CmGameSubRscHandler.SubpackTask
    //   97	22	4	localJSONArray	org.json.JSONArray
    //   131	66	5	str1	String
    //   139	60	6	str2	String
    // Exception table:
    //   from	to	target	type
    //   2	78	222	finally
    //   81	99	222	finally
    //   109	156	222	finally
    //   162	170	222	finally
    //   170	204	222	finally
    //   211	219	222	finally
    //   227	238	222	finally
    //   2	78	226	java/lang/Throwable
    //   81	99	226	java/lang/Throwable
    //   109	156	226	java/lang/Throwable
    //   162	170	226	java/lang/Throwable
    //   170	204	226	java/lang/Throwable
    //   211	219	226	java/lang/Throwable
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("packName", paramString);
      localJSONObject.put("percentage", paramInt1);
      ApolloCmdChannel.getInstance().callbackFromRequest(this.a, 0, "sc.load_percentage_nofity.local", localJSONObject.toString());
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("cmgame_process.CmGameSubRscHandler", 1, paramString, new Object[0]);
    }
  }
  
  public void a(long paramLong, String paramString)
  {
    try
    {
      this.a = paramLong;
      CmGameSSoHandler localCmGameSSoHandler = CmGameUtil.d();
      if (localCmGameSSoHandler == null)
      {
        paramString = new StringBuilder();
        paramString.append("jsState:");
        paramString.append(paramLong);
        QLog.w("cmgame_process.CmGameSubRscHandler", 1, paramString.toString());
        return;
      }
      String str = new JSONObject(paramString).optString("packName");
      if (TextUtils.isEmpty(str))
      {
        d(-10003, "");
        return;
      }
      CmGameResUpdateInfo localCmGameResUpdateInfo = new CmGameResUpdateInfo();
      localCmGameResUpdateInfo.a = 10001;
      paramString = new StringBuilder();
      paramString.append(this.b);
      paramString.append("_");
      paramString.append(str);
      localCmGameResUpdateInfo.b = paramString.toString();
      paramString = (CmGameSubRscHandler.SubpackTask)this.d.get(str);
      if (paramString != null)
      {
        if ((paramString.e != null) && (paramString.e.a() == 1))
        {
          d(-1004, str);
          return;
        }
        localCmGameResUpdateInfo.c = paramString.c;
        paramString.a = str;
      }
      else
      {
        paramString = new CmGameSubRscHandler.SubpackTask();
        paramString.a = str;
        localCmGameResUpdateInfo.c = 0;
        this.d.put(str, paramString);
      }
      if (paramString.d)
      {
        paramString = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_sp", 4);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("apollo_sp_game_rsc_verify_");
        localStringBuilder.append(localCmGameResUpdateInfo.b);
        if (!paramString.getBoolean(localStringBuilder.toString(), false))
        {
          QLog.i("cmgame_process.CmGameSubRscHandler", 1, "each pack requst only once in game.");
          c(this.b, str);
          return;
        }
      }
      paramString = new StringBuilder();
      paramString.append("[cmgame_pack_sub], request, packname:");
      paramString.append(str);
      paramString.append(",ver:");
      paramString.append(localCmGameResUpdateInfo.c);
      QLog.i("cmgame_process.CmGameSubRscHandler", 1, paramString.toString());
      paramString = new ArrayList();
      paramString.add(localCmGameResUpdateInfo);
      localCmGameSSoHandler.a(this.b, str, paramString);
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("cmgame_process.CmGameSubRscHandler", 1, paramString, new Object[0]);
    }
  }
  
  public void a(Context paramContext)
  {
    this.c = paramContext;
  }
  
  public void a(CmGameStartChecker.ICmGameConfirmListener paramICmGameConfirmListener, long paramLong)
  {
    if ((this.c == null) && (paramICmGameConfirmListener != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onDownloadConfirm], ctx:");
      localStringBuilder.append(this.c);
      QLog.w("cmgame_process.CmGameSubRscHandler", 1, localStringBuilder.toString());
      paramICmGameConfirmListener.a(null);
      return;
    }
    ThreadManager.getUIHandler().post(new CmGameSubRscHandler.2(this, paramLong, paramICmGameConfirmListener));
  }
  
  public void a(CmGameRscSvrInfo paramCmGameRscSvrInfo)
  {
    CmGameRscDownloader localCmGameRscDownloader = new CmGameRscDownloader(paramCmGameRscSvrInfo, this);
    Object localObject = (CmGameSubRscHandler.SubpackTask)this.d.get(paramCmGameRscSvrInfo.i);
    if (localObject != null) {
      ((CmGameSubRscHandler.SubpackTask)localObject).e = localCmGameRscDownloader;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[cmgame_pack_sub], response, isUpdate:");
    ((StringBuilder)localObject).append(paramCmGameRscSvrInfo.a);
    ((StringBuilder)localObject).append(",svrVer:");
    ((StringBuilder)localObject).append(paramCmGameRscSvrInfo.c);
    ((StringBuilder)localObject).append(",isPatch:");
    ((StringBuilder)localObject).append(paramCmGameRscSvrInfo.b);
    QLog.i("cmgame_process.CmGameSubRscHandler", 1, ((StringBuilder)localObject).toString());
    if (!localCmGameRscDownloader.b()) {
      c(paramCmGameRscSvrInfo.g, paramCmGameRscSvrInfo.i);
    }
  }
  
  public void b(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onStartDownload], gameId:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(",packN:");
    localStringBuilder.append(paramString);
    QLog.i("cmgame_process.CmGameSubRscHandler", 1, localStringBuilder.toString());
  }
  
  public void b(long paramLong, String paramString)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.CmGameSubRscHandler", 2, "[verifyRsc]");
      }
      paramString = new JSONObject(paramString).optString("packName");
      Object localObject = (CmGameSubRscHandler.SubpackTask)this.d.get(paramString);
      if (localObject == null) {
        return;
      }
      if (TextUtils.isEmpty(((CmGameSubRscHandler.SubpackTask)localObject).b)) {
        a();
      }
      localObject = new ApolloGameRscVerify(this.b, 1, paramString, ((CmGameSubRscHandler.SubpackTask)localObject).b);
      ((ApolloGameRscVerify)localObject).a(new CmGameSubRscHandler.3(this, paramString));
      ((ApolloGameRscVerify)localObject).a();
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("cmgame_process.CmGameSubRscHandler", 1, paramString, new Object[0]);
    }
  }
  
  public void c(int paramInt, String paramString)
  {
    d(0, paramString);
    Object localObject = (CmGameSubRscHandler.SubpackTask)this.d.get(paramString);
    if (localObject != null)
    {
      ((CmGameSubRscHandler.SubpackTask)localObject).d = true;
      paramInt = a(paramString, ((CmGameSubRscHandler.SubpackTask)localObject).b);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[onDownloadSuccess], newV:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(",packName:");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("cmgame_process.CmGameSubRscHandler", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public void d(int paramInt, String paramString)
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[onDownloadFailure], ret:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(",packName:");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("cmgame_process.CmGameSubRscHandler", 1, ((StringBuilder)localObject).toString());
      localObject = new JSONObject();
      ((JSONObject)localObject).put("packName", paramString);
      ((JSONObject)localObject).put("result", paramInt);
      ApolloCmdChannel.getInstance().callbackFromRequest(this.a, 0, "cs.load_subpackage.local", ((JSONObject)localObject).toString());
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("cmgame_process.CmGameSubRscHandler", 1, paramString, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.download.CmGameSubRscHandler
 * JD-Core Version:    0.7.0.1
 */
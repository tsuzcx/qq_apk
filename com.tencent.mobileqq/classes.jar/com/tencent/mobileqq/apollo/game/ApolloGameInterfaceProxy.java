package com.tencent.mobileqq.apollo.game;

import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.tencent.mobileqq.apollo.game.process.CmGameUtil;
import com.tencent.mobileqq.apollo.game.process.data.CmGameInitParams;
import com.tencent.mobileqq.apollo.game.process.data.CmGameLauncher;
import com.tencent.mobileqq.apollo.game.process.data.CmGameManager;
import com.tencent.mobileqq.apollo.game.process.data.CmGameOpenIdFinder;
import com.tencent.mobileqq.apollo.game.process.sso.CmGameSSoHandler;
import com.tencent.mobileqq.apollo.render.IApolloRunnableTask;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloCmdChannel;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import java.security.Key;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;

public class ApolloGameInterfaceProxy
  implements IApolloGameInterface
{
  private int jdField_a_of_type_Int;
  private ApolloJSContext jdField_a_of_type_ComTencentMobileqqApolloGameApolloJSContext;
  private CmGameInitParams jdField_a_of_type_ComTencentMobileqqApolloGameProcessDataCmGameInitParams;
  private String jdField_a_of_type_JavaLangString;
  private Pattern jdField_a_of_type_JavaUtilRegexPattern;
  private boolean jdField_a_of_type_Boolean;
  
  public ApolloGameInterfaceProxy(ApolloJSContext paramApolloJSContext, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloJSContext = paramApolloJSContext;
    try
    {
      this.jdField_a_of_type_Int = Integer.parseInt(paramString);
    }
    catch (Throwable paramApolloJSContext)
    {
      label20:
      break label20;
    }
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = paramString;
    if (QLog.isColorLevel())
    {
      paramApolloJSContext = new StringBuilder();
      paramApolloJSContext.append("[ApolloGameInterfaceProxy] ");
      paramApolloJSContext.append(this.jdField_a_of_type_Int);
      paramApolloJSContext.append(" ");
      paramApolloJSContext.append(this.jdField_a_of_type_JavaLangString);
      QLog.d("[cmshow]ApolloGameInterfaceProxy", 2, paramApolloJSContext.toString());
    }
  }
  
  public static String a(int paramInt1, int paramInt2, CmGameInitParams paramCmGameInitParams)
  {
    if ((paramCmGameInitParams != null) && (paramCmGameInitParams.extInfoFromSvr != null))
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append(";");
      ((StringBuilder)localObject1).append(paramInt2 + paramInt1);
      localObject1 = ((StringBuilder)localObject1).toString();
      String str1 = paramCmGameInitParams.extInfoFromSvr;
      paramCmGameInitParams = new JSONObject();
      try
      {
        Object localObject3 = new JSONObject(new JSONObject(str1).optString("certInfo"));
        Object localObject2 = new JSONObject(((JSONObject)localObject3).optString("credentials"));
        str1 = ((JSONObject)localObject2).optString("tmpSecretId");
        Object localObject4 = ((JSONObject)localObject2).optString("tmpSecretKey");
        localObject2 = ((JSONObject)localObject2).optString("sessionToken");
        String str2 = ((JSONObject)localObject3).optString("upLoadPrefUrl");
        localObject3 = ((JSONObject)localObject3).optString("downLoadPrefUrl");
        localObject4 = new SecretKeySpec(((String)localObject4).getBytes(), "HmacSHA1");
        Object localObject5 = Mac.getInstance("HmacSHA1");
        ((Mac)localObject5).init((Key)localObject4);
        localObject4 = ((Mac)localObject5).doFinal(((String)localObject1).getBytes());
        localObject5 = new StringBuilder();
        paramInt2 = localObject4.length;
        paramInt1 = 0;
        while (paramInt1 < paramInt2)
        {
          ((StringBuilder)localObject5).append(HexUtil.byte2HexStr(localObject4[paramInt1]));
          paramInt1 += 1;
        }
        localObject4 = ((StringBuilder)localObject5).toString().toLowerCase();
        paramCmGameInitParams.put("tmpSecretId", str1);
        paramCmGameInitParams.put("sessionToken", localObject2);
        paramCmGameInitParams.put("upLoadPrefUrl", str2);
        paramCmGameInitParams.put("downloadUrl", localObject3);
        paramCmGameInitParams.put("signature", localObject4);
        paramCmGameInitParams.put("signTime", localObject1);
      }
      catch (Throwable localThrowable)
      {
        QLog.e("[cmshow]ApolloGameInterfaceProxy", 1, localThrowable, new Object[0]);
      }
      return paramCmGameInitParams.toString();
    }
    return null;
  }
  
  private void a(int paramInt, String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      ApolloJSContext localApolloJSContext = this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloJSContext;
      if (localApolloJSContext != null)
      {
        localApolloJSContext.a(paramInt, paramString1, paramString2);
        return;
      }
    }
    paramString2 = new StringBuilder();
    paramString2.append("[callbackJS] fail for ");
    paramString2.append(paramString1);
    QLog.e("[cmshow]ApolloGameInterfaceProxy", 1, paramString2.toString());
  }
  
  private boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilRegexPattern == null)
    {
      localObject = CmGameUtil.a();
      if (localObject != null)
      {
        localObject = ((CmGameManager)localObject).a(this.jdField_a_of_type_Int);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("isValidSsoCmd cmd:");
          localStringBuilder.append(paramString);
          localStringBuilder.append(", rule: ");
          localStringBuilder.append((String)localObject);
          QLog.w("[cmshow]ApolloGameInterfaceProxy", 1, localStringBuilder.toString());
        }
        this.jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile((String)localObject);
      }
    }
    Object localObject = this.jdField_a_of_type_JavaUtilRegexPattern;
    if (localObject == null) {
      return false;
    }
    boolean bool = ((Pattern)localObject).matcher(paramString).matches();
    if (!bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ssoCmdRule,fail to match sso cmd, cmd:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", gameId: ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      QLog.w("[cmshow]ApolloGameInterfaceProxy", 1, ((StringBuilder)localObject).toString());
    }
    return bool;
  }
  
  private void b(String paramString1, String paramString2)
  {
    if ("cs.openNativeWebView.local".equals(paramString2)) {
      return;
    }
    if ("cs.gameBack.local".equals(paramString2)) {
      return;
    }
    if ("cs.ssoMessage.local".equals(paramString2))
    {
      c(paramString1);
      return;
    }
    if ("cs.get_userInfo.local".equals(paramString2))
    {
      try
      {
        paramString2 = new JSONObject(paramString1);
        if (paramString2.optInt("nickname") == 1)
        {
          a(paramString1);
          return;
        }
        if (paramString2.optInt("avatar") != 1) {
          return;
        }
        b(paramString1);
        return;
      }
      catch (Throwable paramString1)
      {
        QLog.e("[cmshow]ApolloGameInterfaceProxy", 1, paramString1, new Object[0]);
        return;
      }
    }
    else
    {
      if ("cs.on_get_open_key.local".equals(paramString2)) {
        try
        {
          ApolloGameInterfaceProxy.1 local1 = new ApolloGameInterfaceProxy.1(this);
          Bundle localBundle = new Bundle();
          localBundle.putString("cmd", paramString2);
          localBundle.putString("reqData", paramString1);
          localBundle.putBoolean("async", true);
          localBundle.putInt("gameId", this.jdField_a_of_type_Int);
          QIPCClientHelper.getInstance().callServer("cm_game_module", "action_chanel_req", localBundle, local1);
          return;
        }
        catch (Throwable paramString1)
        {
          QLog.e("[cmshow]ApolloGameInterfaceProxy", 1, paramString1, new Object[0]);
          return;
        }
      }
      if ("cs.get_file_data.local".equals(paramString2)) {
        try
        {
          d("cs.get_file_data.local", a(new JSONObject(paramString1).optString("path")));
          return;
        }
        catch (Throwable paramString1)
        {
          QLog.e("[cmshow]ApolloGameInterfaceProxy", 1, paramString1, new Object[0]);
          return;
        }
      }
      if ("cs.fetch_cloud_signature.local".equals(paramString2)) {
        try
        {
          paramString1 = new JSONObject(paramString1);
          d("cs.fetch_cloud_signature.local", a(paramString1.optInt("now"), paramString1.optInt("delta"), this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDataCmGameInitParams));
          return;
        }
        catch (Throwable paramString1)
        {
          QLog.e("[cmshow]ApolloGameInterfaceProxy", 1, paramString1, new Object[0]);
          return;
        }
      }
      if ("cs.closeWebview.local".equals(paramString2))
      {
        try
        {
          int i = new JSONObject(paramString1).optInt("taskId");
          paramString1 = CmGameUtil.a(this.jdField_a_of_type_Int);
          if (paramString1 == null) {
            return;
          }
          paramString1.a(i);
          return;
        }
        catch (Throwable paramString1)
        {
          QLog.e("[cmshow]ApolloGameInterfaceProxy", 1, paramString1, new Object[0]);
          return;
        }
      }
      else
      {
        if ("cs.get_state_info.local".equals(paramString2))
        {
          c(paramString2, paramString1);
          return;
        }
        a(paramString2, paramString1);
      }
    }
  }
  
  private void c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        Object localObject = new JSONObject(paramString);
        String str = ((JSONObject)localObject).optString("cmd");
        localObject = ApolloGameTool.a(((JSONObject)localObject).optString("data"), String.valueOf(this.jdField_a_of_type_Int));
        CmGameSSoHandler localCmGameSSoHandler = CmGameUtil.a();
        if ((localCmGameSSoHandler != null) && (!TextUtils.isEmpty(paramString)) && (a(str)))
        {
          localCmGameSSoHandler.a(str, (String)localObject);
          return;
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("[cmshow]ApolloGameInterfaceProxy", 1, paramString, new Object[0]);
      }
    }
  }
  
  private void c(String paramString1, String paramString2)
  {
    a(0, paramString1, CmGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDataCmGameInitParams));
  }
  
  private void d(String paramString1, String paramString2)
  {
    a(0, paramString1, paramString2);
  }
  
  @JavascriptInterface
  public static void log(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    if ((paramInt2 >= 0) && (paramInt1 <= 0)) {}
    try
    {
      if (!QLog.isColorLevel()) {
        return;
      }
      QLog.d("sava_native_log", 2, new Object[] { "level:", Integer.valueOf(paramInt1), ",code:", Integer.valueOf(paramInt2), ",info1:", paramString1, ",info2:", paramString2, ",info3:", paramString3 });
      return;
    }
    catch (Throwable paramString1)
    {
      QLog.e("[cmshow]ApolloGameInterfaceProxy", 1, "[printNativeLog]", paramString1);
    }
    QLog.e("sava_native_log", 1, new Object[] { "level:", Integer.valueOf(paramInt1), ",code:", Integer.valueOf(paramInt2), ",info1:", ApolloUtilImpl.logFilter(paramString1), ",info2:", ApolloUtilImpl.logFilter(paramString2), ",info3:", ApolloUtilImpl.logFilter(paramString3) });
    return;
  }
  
  /* Error */
  public String a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 365	com/tencent/mobileqq/apollo/game/ApolloGameInterfaceProxy:b	(Ljava/lang/String;)Ljava/lang/String;
    //   5: astore 5
    //   7: aconst_null
    //   8: astore_2
    //   9: aconst_null
    //   10: astore_3
    //   11: aconst_null
    //   12: astore_1
    //   13: aconst_null
    //   14: astore 4
    //   16: aload 5
    //   18: ifnonnull +5 -> 23
    //   21: aconst_null
    //   22: areturn
    //   23: new 367	java/io/File
    //   26: dup
    //   27: aload 5
    //   29: invokespecial 368	java/io/File:<init>	(Ljava/lang/String;)V
    //   32: astore 6
    //   34: aload 6
    //   36: invokevirtual 371	java/io/File:exists	()Z
    //   39: ifne +5 -> 44
    //   42: aconst_null
    //   43: areturn
    //   44: aload 6
    //   46: invokevirtual 371	java/io/File:exists	()Z
    //   49: ifeq +143 -> 192
    //   52: aload_2
    //   53: astore_1
    //   54: new 373	java/io/FileInputStream
    //   57: dup
    //   58: aload 5
    //   60: invokespecial 374	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   63: astore_2
    //   64: aload 4
    //   66: astore_1
    //   67: aload_2
    //   68: invokevirtual 380	java/io/InputStream:available	()I
    //   71: newarray byte
    //   73: astore_3
    //   74: aload_3
    //   75: astore_1
    //   76: aload_2
    //   77: aload_3
    //   78: invokevirtual 384	java/io/InputStream:read	([B)I
    //   81: pop
    //   82: aload_2
    //   83: invokevirtual 387	java/io/InputStream:close	()V
    //   86: aload_3
    //   87: astore_1
    //   88: goto +104 -> 192
    //   91: astore_1
    //   92: ldc 54
    //   94: iconst_1
    //   95: aload_1
    //   96: iconst_0
    //   97: anewarray 4	java/lang/Object
    //   100: invokestatic 145	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   103: aload_3
    //   104: astore_1
    //   105: goto +87 -> 192
    //   108: astore_3
    //   109: aload_2
    //   110: astore_1
    //   111: aload_3
    //   112: astore_2
    //   113: goto +58 -> 171
    //   116: astore 4
    //   118: aload_2
    //   119: astore_3
    //   120: aload_1
    //   121: astore_2
    //   122: goto +11 -> 133
    //   125: astore_2
    //   126: goto +45 -> 171
    //   129: astore 4
    //   131: aconst_null
    //   132: astore_2
    //   133: aload_3
    //   134: astore_1
    //   135: ldc 54
    //   137: iconst_1
    //   138: aload 4
    //   140: iconst_0
    //   141: anewarray 4	java/lang/Object
    //   144: invokestatic 145	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   147: aload_3
    //   148: invokevirtual 387	java/io/InputStream:close	()V
    //   151: goto +15 -> 166
    //   154: astore_1
    //   155: ldc 54
    //   157: iconst_1
    //   158: aload_1
    //   159: iconst_0
    //   160: anewarray 4	java/lang/Object
    //   163: invokestatic 145	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   166: aload_2
    //   167: astore_1
    //   168: goto +24 -> 192
    //   171: aload_1
    //   172: invokevirtual 387	java/io/InputStream:close	()V
    //   175: goto +15 -> 190
    //   178: astore_1
    //   179: ldc 54
    //   181: iconst_1
    //   182: aload_1
    //   183: iconst_0
    //   184: anewarray 4	java/lang/Object
    //   187: invokestatic 145	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   190: aload_2
    //   191: athrow
    //   192: new 99	java/lang/String
    //   195: dup
    //   196: aload_1
    //   197: invokestatic 391	com/tencent/mobileqq/musicpendant/Base64:a	([B)[B
    //   200: invokespecial 394	java/lang/String:<init>	([B)V
    //   203: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	204	0	this	ApolloGameInterfaceProxy
    //   0	204	1	paramString	String
    //   8	114	2	localObject1	Object
    //   125	1	2	localObject2	Object
    //   132	59	2	localObject3	Object
    //   10	94	3	arrayOfByte	byte[]
    //   108	4	3	localObject4	Object
    //   119	29	3	localObject5	Object
    //   14	51	4	localObject6	Object
    //   116	1	4	localThrowable1	Throwable
    //   129	10	4	localThrowable2	Throwable
    //   5	54	5	str	String
    //   32	13	6	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   82	86	91	java/lang/Throwable
    //   67	74	108	finally
    //   76	82	108	finally
    //   67	74	116	java/lang/Throwable
    //   76	82	116	java/lang/Throwable
    //   54	64	125	finally
    //   135	147	125	finally
    //   54	64	129	java/lang/Throwable
    //   147	151	154	java/lang/Throwable
    //   171	175	178	java/lang/Throwable
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloJSContext = null;
    this.jdField_a_of_type_Int = 0;
  }
  
  public void a(int paramInt, String paramString)
  {
    int i = this.jdField_a_of_type_Int;
    if (i == 0) {
      return;
    }
    CmGameOpenIdFinder localCmGameOpenIdFinder = CmGameUtil.a(i);
    if (localCmGameOpenIdFinder == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    localCmGameOpenIdFinder.a(2, localArrayList, null, 10, 0L, false, "", "", new ApolloGameInterfaceProxy.2(this, paramInt, paramString));
  }
  
  public void a(Object paramObject)
  {
    if (this.jdField_a_of_type_Int > 0)
    {
      if ((paramObject != null) && ((paramObject instanceof CmGameInitParams))) {
        this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDataCmGameInitParams = ((CmGameInitParams)paramObject);
      }
      if ((paramObject instanceof ApolloJSContext)) {
        this.jdField_a_of_type_Boolean = true;
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDataCmGameInitParams;
      if ((localObject != null) && (this.jdField_a_of_type_Boolean)) {
        d("sc.init_global_var.local", CmGameUtil.a((CmGameInitParams)localObject));
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[onCheckFinish] gameId ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
        ((StringBuilder)localObject).append(" # ");
        CmGameInitParams localCmGameInitParams = this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDataCmGameInitParams;
        boolean bool2 = false;
        if (localCmGameInitParams == null) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        ((StringBuilder)localObject).append(bool1);
        ((StringBuilder)localObject).append(" # ");
        boolean bool1 = bool2;
        if (paramObject == null) {
          bool1 = true;
        }
        ((StringBuilder)localObject).append(bool1);
        QLog.e("[cmshow]ApolloGameInterfaceProxy", 1, ((StringBuilder)localObject).toString());
      }
    }
    else
    {
      QLog.e("[cmshow]ApolloGameInterfaceProxy", 1, "[onCheckFinish] gameId 0");
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("openId");
      if (!TextUtils.isEmpty(paramString))
      {
        a(1, paramString);
        return;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("[cmshow]ApolloGameInterfaceProxy", 1, paramString, new Object[0]);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    ApolloCmdChannel localApolloCmdChannel = ApolloCmdChannel.getInstance();
    if (localApolloCmdChannel != null)
    {
      localApolloCmdChannel.requestData(this.jdField_a_of_type_Int, paramString1, paramString2, false, false);
      return;
    }
    QLog.d("[cmshow]ApolloGameInterfaceProxy", 1, "[onRequestMessage] no cmd handler");
  }
  
  public String b(String paramString)
  {
    String str = null;
    if ((paramString != "") && (paramString != null))
    {
      if (paramString.endsWith(".js")) {
        return null;
      }
      if (paramString.startsWith("GameSandBox")) {
        str = "sandbox";
      }
      return ApolloGameTool.a(paramString, this.jdField_a_of_type_Int, str, false);
    }
    return null;
  }
  
  public void b(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("openId");
      if (!TextUtils.isEmpty(paramString))
      {
        a(2, paramString);
        return;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("[cmshow]ApolloGameInterfaceProxy", 1, paramString, new Object[0]);
    }
  }
  
  public long getLuaState()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long getRenderThreadId()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public boolean isJsRuntime()
  {
    return false;
  }
  
  public void runRenderTask(IApolloRunnableTask paramIApolloRunnableTask)
  {
    ThreadManagerV2.executeOnSubThread(paramIApolloRunnableTask);
  }
  
  public void runRenderTask(String paramString, int paramInt) {}
  
  @JavascriptInterface
  public void send(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString1);
        localStringBuilder.append(" ");
        localStringBuilder.append(paramString2);
        localStringBuilder.append(" ");
        localStringBuilder.append(this.jdField_a_of_type_Int);
        QLog.d("[cmshow]ApolloGameInterfaceProxy", 2, localStringBuilder.toString());
      }
      if (this.jdField_a_of_type_Int > 0)
      {
        b(paramString1, paramString2);
        return;
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[send] invalid request for ");
        localStringBuilder.append(paramString2);
        localStringBuilder.append(" ");
        localStringBuilder.append(paramString1);
        QLog.d("[cmshow]ApolloGameInterfaceProxy", 2, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.ApolloGameInterfaceProxy
 * JD-Core Version:    0.7.0.1
 */
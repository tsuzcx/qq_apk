package com.tencent.mobileqq.apollo.game;

import aikb;
import aikz;
import aild;
import aile;
import ailf;
import ailh;
import ailj;
import ailn;
import ailo;
import ailu;
import aing;
import aioy;
import aipj;
import aips;
import aipx;
import aiqr;
import aiqs;
import aizc;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.URLUtil;
import bach;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.IApolloRunnableTask;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;
import com.tencent.mobileqq.apollo.store.ApolloFloatActivity;
import com.tencent.mobileqq.apollo.store.ApolloGameActivity;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.security.Key;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;

public class ApolloGameInterfaceProxy
  implements ailu
{
  private int jdField_a_of_type_Int;
  private ailo jdField_a_of_type_Ailo;
  private aiqr jdField_a_of_type_Aiqr = new aild(this);
  private WebGameFakeView jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView;
  private CmGameInitParams jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams;
  private String jdField_a_of_type_JavaLangString;
  private Pattern jdField_a_of_type_JavaUtilRegexPattern;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  
  public ApolloGameInterfaceProxy(ailo paramailo, String paramString)
  {
    this.jdField_a_of_type_Ailo = paramailo;
    try
    {
      this.jdField_a_of_type_Int = Integer.parseInt(paramString);
      a();
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameInterfaceProxy", 2, "[ApolloGameInterfaceProxy] " + this.jdField_a_of_type_Int + " " + this.jdField_a_of_type_JavaLangString);
      }
      return;
    }
    catch (Throwable paramailo)
    {
      for (;;)
      {
        this.jdField_a_of_type_Int = 0;
        this.jdField_a_of_type_JavaLangString = paramString;
      }
    }
  }
  
  public static String a(int paramInt1, int paramInt2, CmGameInitParams paramCmGameInitParams)
  {
    if ((paramCmGameInitParams == null) || (paramCmGameInitParams.extInfoFromSvr == null)) {
      return null;
    }
    String str1 = paramInt1 + ";" + (paramInt1 + paramInt2);
    String str2 = paramCmGameInitParams.extInfoFromSvr;
    paramCmGameInitParams = new JSONObject();
    try
    {
      Object localObject2 = new JSONObject(new JSONObject(str2).optString("certInfo"));
      Object localObject1 = new JSONObject(((JSONObject)localObject2).optString("credentials"));
      str2 = ((JSONObject)localObject1).optString("tmpSecretId");
      Object localObject3 = ((JSONObject)localObject1).optString("tmpSecretKey");
      localObject1 = ((JSONObject)localObject1).optString("sessionToken");
      String str3 = ((JSONObject)localObject2).optString("upLoadPrefUrl");
      localObject2 = ((JSONObject)localObject2).optString("downLoadPrefUrl");
      localObject3 = new SecretKeySpec(((String)localObject3).getBytes(), "HmacSHA1");
      Object localObject4 = Mac.getInstance("HmacSHA1");
      ((Mac)localObject4).init((Key)localObject3);
      localObject3 = ((Mac)localObject4).doFinal(str1.getBytes());
      localObject4 = new StringBuilder();
      paramInt2 = localObject3.length;
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        ((StringBuilder)localObject4).append(bach.a(localObject3[paramInt1]));
        paramInt1 += 1;
      }
      localObject3 = ((StringBuilder)localObject4).toString().toLowerCase();
      paramCmGameInitParams.put("tmpSecretId", str2);
      paramCmGameInitParams.put("sessionToken", localObject1);
      paramCmGameInitParams.put("upLoadPrefUrl", str3);
      paramCmGameInitParams.put("downloadUrl", localObject2);
      paramCmGameInitParams.put("signature", localObject3);
      paramCmGameInitParams.put("signTime", str1);
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("ApolloGameInterfaceProxy", 1, localThrowable, new Object[0]);
      }
    }
    return paramCmGameInitParams.toString();
  }
  
  private boolean a(String paramString)
  {
    boolean bool1 = false;
    if (TextUtils.isEmpty(paramString)) {}
    boolean bool2;
    do
    {
      do
      {
        return bool1;
        if (this.jdField_a_of_type_JavaUtilRegexPattern == null)
        {
          Object localObject = aing.a();
          if (localObject != null)
          {
            localObject = ((aips)localObject).a(this.jdField_a_of_type_Int);
            if (QLog.isColorLevel()) {
              QLog.w("ApolloGameInterfaceProxy", 1, "isValidSsoCmd cmd:" + paramString + ", rule: " + (String)localObject);
            }
            this.jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile((String)localObject);
          }
        }
      } while (this.jdField_a_of_type_JavaUtilRegexPattern == null);
      bool2 = this.jdField_a_of_type_JavaUtilRegexPattern.matcher(paramString).matches();
      bool1 = bool2;
    } while (bool2);
    QLog.w("ApolloGameInterfaceProxy", 1, "ssoCmdRule,fail to match sso cmd, cmd:" + paramString + ", gameId: " + this.jdField_a_of_type_Int);
    return bool2;
  }
  
  private void b(int paramInt, String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (this.jdField_a_of_type_Ailo != null))
    {
      this.jdField_a_of_type_Ailo.a(paramInt, paramString1, paramString2);
      return;
    }
    QLog.e("ApolloGameInterfaceProxy", 1, "[callbackJS] fail for " + paramString1);
  }
  
  /* Error */
  private void c(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 173	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +389 -> 393
    //   7: new 85	org/json/JSONObject
    //   10: dup
    //   11: aload_1
    //   12: invokespecial 89	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   15: astore 4
    //   17: aload 4
    //   19: ldc 222
    //   21: invokevirtual 95	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   24: astore_3
    //   25: new 85	org/json/JSONObject
    //   28: dup
    //   29: aload_3
    //   30: invokespecial 89	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   33: astore_1
    //   34: aload_1
    //   35: ldc 222
    //   37: invokevirtual 95	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   40: invokestatic 173	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   43: istore_2
    //   44: iload_2
    //   45: ifne +342 -> 387
    //   48: aload_1
    //   49: ldc 222
    //   51: invokevirtual 95	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   54: astore 4
    //   56: aload 4
    //   58: astore_3
    //   59: aload_3
    //   60: invokestatic 173	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   63: ifne +330 -> 393
    //   66: aload_0
    //   67: getfield 224	com/tencent/mobileqq/apollo/game/ApolloGameInterfaceProxy:jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView	Lcom/tencent/mobileqq/apollo/game/WebGameFakeView;
    //   70: ifnull +323 -> 393
    //   73: aload_0
    //   74: getfield 224	com/tencent/mobileqq/apollo/game/ApolloGameInterfaceProxy:jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView	Lcom/tencent/mobileqq/apollo/game/WebGameFakeView;
    //   77: getfield 229	com/tencent/mobileqq/apollo/game/WebGameFakeView:a	Landroid/content/Context;
    //   80: ifnull +313 -> 393
    //   83: aload_3
    //   84: ldc 231
    //   86: invokevirtual 234	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   89: ifeq +161 -> 250
    //   92: new 52	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   99: aload_3
    //   100: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: ldc 236
    //   105: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: astore_3
    //   112: new 238	android/content/Intent
    //   115: dup
    //   116: invokespecial 239	android/content/Intent:<init>	()V
    //   119: astore 4
    //   121: aload 4
    //   123: ldc 222
    //   125: aload_3
    //   126: invokevirtual 243	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   129: pop
    //   130: aload 4
    //   132: ldc 222
    //   134: aload_3
    //   135: invokevirtual 243	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   138: pop
    //   139: aload 4
    //   141: ldc 245
    //   143: invokestatic 251	java/lang/System:currentTimeMillis	()J
    //   146: invokevirtual 254	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   149: pop
    //   150: aload_0
    //   151: getfield 224	com/tencent/mobileqq/apollo/game/ApolloGameInterfaceProxy:jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView	Lcom/tencent/mobileqq/apollo/game/WebGameFakeView;
    //   154: invokevirtual 257	com/tencent/mobileqq/apollo/game/WebGameFakeView:a	()Landroid/os/Bundle;
    //   157: astore_3
    //   158: aload_3
    //   159: ifnull +213 -> 372
    //   162: aload_3
    //   163: ldc_w 259
    //   166: invokevirtual 265	android/os/Bundle:getSerializable	(Ljava/lang/String;)Ljava/io/Serializable;
    //   169: astore_3
    //   170: aload_3
    //   171: ifnull +191 -> 362
    //   174: aload_3
    //   175: instanceof 267
    //   178: ifeq +184 -> 362
    //   181: aload_3
    //   182: checkcast 267	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker$StartCheckParam
    //   185: getfield 270	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker$StartCheckParam:mGameType	I
    //   188: iconst_3
    //   189: if_icmpne +85 -> 274
    //   192: aload 4
    //   194: getstatic 275	com/tencent/mobileqq/apollo/game/WebGameFakeView$Director:BACKGROUND_COLOR	Ljava/lang/String;
    //   197: aload_1
    //   198: getstatic 275	com/tencent/mobileqq/apollo/game/WebGameFakeView$Director:BACKGROUND_COLOR	Ljava/lang/String;
    //   201: invokevirtual 95	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   204: invokevirtual 243	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   207: pop
    //   208: aload 4
    //   210: getstatic 278	com/tencent/mobileqq/apollo/game/WebGameFakeView$Director:TITLE	Ljava/lang/String;
    //   213: aload_1
    //   214: getstatic 278	com/tencent/mobileqq/apollo/game/WebGameFakeView$Director:TITLE	Ljava/lang/String;
    //   217: invokevirtual 95	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   220: invokevirtual 243	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   223: pop
    //   224: aload 4
    //   226: getstatic 281	com/tencent/mobileqq/apollo/game/WebGameFakeView$Director:FOREGROUND_COLOR	Ljava/lang/String;
    //   229: aload_1
    //   230: getstatic 281	com/tencent/mobileqq/apollo/game/WebGameFakeView$Director:FOREGROUND_COLOR	Ljava/lang/String;
    //   233: invokevirtual 95	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   236: invokevirtual 243	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   239: pop
    //   240: aload_0
    //   241: getfield 224	com/tencent/mobileqq/apollo/game/ApolloGameInterfaceProxy:jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView	Lcom/tencent/mobileqq/apollo/game/WebGameFakeView;
    //   244: aload 4
    //   246: invokevirtual 284	com/tencent/mobileqq/apollo/game/WebGameFakeView:b	(Landroid/content/Intent;)V
    //   249: return
    //   250: new 52	java/lang/StringBuilder
    //   253: dup
    //   254: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   257: aload_3
    //   258: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: ldc_w 286
    //   264: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: astore_3
    //   271: goto -159 -> 112
    //   274: aload 4
    //   276: ldc_w 288
    //   279: ldc_w 290
    //   282: invokevirtual 243	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   285: pop
    //   286: aload 4
    //   288: aload_0
    //   289: getfield 224	com/tencent/mobileqq/apollo/game/ApolloGameInterfaceProxy:jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView	Lcom/tencent/mobileqq/apollo/game/WebGameFakeView;
    //   292: getfield 229	com/tencent/mobileqq/apollo/game/WebGameFakeView:a	Landroid/content/Context;
    //   295: ldc_w 292
    //   298: invokevirtual 296	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
    //   301: pop
    //   302: aload 4
    //   304: ldc_w 297
    //   307: invokevirtual 301	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   310: pop
    //   311: aload_0
    //   312: getfield 224	com/tencent/mobileqq/apollo/game/ApolloGameInterfaceProxy:jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView	Lcom/tencent/mobileqq/apollo/game/WebGameFakeView;
    //   315: getfield 229	com/tencent/mobileqq/apollo/game/WebGameFakeView:a	Landroid/content/Context;
    //   318: instanceof 303
    //   321: ifeq +72 -> 393
    //   324: aload_0
    //   325: getfield 224	com/tencent/mobileqq/apollo/game/ApolloGameInterfaceProxy:jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView	Lcom/tencent/mobileqq/apollo/game/WebGameFakeView;
    //   328: getfield 229	com/tencent/mobileqq/apollo/game/WebGameFakeView:a	Landroid/content/Context;
    //   331: checkcast 303	android/app/Activity
    //   334: aload 4
    //   336: sipush 999
    //   339: invokevirtual 307	android/app/Activity:startActivityForResult	(Landroid/content/Intent;I)V
    //   342: return
    //   343: astore_1
    //   344: ldc 50
    //   346: iconst_1
    //   347: aload_1
    //   348: iconst_1
    //   349: anewarray 4	java/lang/Object
    //   352: dup
    //   353: iconst_0
    //   354: ldc_w 309
    //   357: aastore
    //   358: invokestatic 157	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   361: return
    //   362: ldc 50
    //   364: iconst_1
    //   365: ldc_w 311
    //   368: invokestatic 219	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   371: return
    //   372: ldc 50
    //   374: iconst_1
    //   375: ldc_w 313
    //   378: invokestatic 219	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   381: return
    //   382: astore 4
    //   384: goto +14 -> 398
    //   387: aload 4
    //   389: astore_1
    //   390: goto -331 -> 59
    //   393: return
    //   394: astore_1
    //   395: aload 4
    //   397: astore_1
    //   398: goto -339 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	401	0	this	ApolloGameInterfaceProxy
    //   0	401	1	paramString	String
    //   43	2	2	bool	boolean
    //   24	247	3	localObject1	Object
    //   15	320	4	localObject2	Object
    //   382	14	4	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   0	25	343	java/lang/Throwable
    //   59	112	343	java/lang/Throwable
    //   112	158	343	java/lang/Throwable
    //   162	170	343	java/lang/Throwable
    //   174	249	343	java/lang/Throwable
    //   250	271	343	java/lang/Throwable
    //   274	342	343	java/lang/Throwable
    //   362	371	343	java/lang/Throwable
    //   372	381	343	java/lang/Throwable
    //   48	56	382	java/lang/Throwable
    //   25	44	394	java/lang/Throwable
  }
  
  private void d(String paramString)
  {
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString)) {
          break;
        }
        paramString = new JSONObject(paramString).optString("url");
        if (TextUtils.isEmpty(paramString)) {
          break;
        }
        if ((TextUtils.isEmpty(paramString)) || (!URLUtil.isNetworkUrl(paramString)))
        {
          QLog.e("ApolloGameInterfaceProxy", 1, "[openWebViewWithoutUrl] ill url " + paramString);
          return;
        }
        if (paramString.contains("?"))
        {
          paramString = paramString + "&apollo_bk=1";
          int i = this.b;
          Intent localIntent = new Intent();
          localIntent.putExtra("big_brother_source_key", "biz_src_zf_lmx");
          localIntent.putExtra("extra_key_weburl", paramString);
          localIntent.putExtra("url", paramString);
          localIntent.putExtra("extra_key_fullscreen", true);
          localIntent.putExtra("extra_key_close_btn", false);
          localIntent.putExtra("extra_key_from", 1);
          localIntent.addFlags(65536);
          localIntent.putExtra("game_busid", "Android.H5");
          localIntent.putExtra("extra_key_gameid", this.jdField_a_of_type_Int);
          localIntent.putExtra("extra_key_taskid", i);
          if ((this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView.a == null)) {
            break;
          }
          paramString = this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView.a().getSerializable("game_init");
          if ((paramString == null) || (!(paramString instanceof CmGameStartChecker.StartCheckParam))) {
            break;
          }
          paramString = (CmGameStartChecker.StartCheckParam)paramString;
          localIntent.setClass(this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView.a, ApolloFloatActivity.class);
          localIntent.putExtra("extra_key_entratation", paramString.viewMode + 1);
          if (!(this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView.a instanceof Activity)) {
            break;
          }
          ((Activity)this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView.a).startActivityForResult(localIntent, 999);
          paramString = new JSONObject();
          paramString.put("taskId", i);
          g("cs.openWebViewWithoutUrl.local", paramString.toString());
          this.b += 1;
          return;
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("ApolloGameInterfaceProxy", 1, paramString, new Object[] { "[send]" });
        return;
      }
      paramString = paramString + "?apollo_bk=1";
    }
  }
  
  private void d(String paramString1, String paramString2)
  {
    if ("cs.make_room_min.local".equals(paramString2)) {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView != null) {
        b();
      }
    }
    for (;;)
    {
      return;
      if ("cs.close_room.local".equals(paramString2))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView != null) {
          this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView.a(true);
        }
      }
      else
      {
        if ("cs.share_game_in_ark.local".equals(paramString2))
        {
          if (this.jdField_a_of_type_Ailo != null) {
            this.jdField_a_of_type_Ailo.a();
          }
          e(paramString1);
          return;
        }
        if ("cs.game_shell_share_callback.local".equals(paramString2))
        {
          if (this.jdField_a_of_type_Ailo != null) {
            this.jdField_a_of_type_Ailo.a();
          }
          f(paramString1);
          return;
        }
        if ("cs.share_game_result.local".equals(paramString2))
        {
          if (this.jdField_a_of_type_Ailo != null) {
            this.jdField_a_of_type_Ailo.a();
          }
          if (!TextUtils.isEmpty(paramString1)) {
            g(paramString1);
          }
        }
        else
        {
          if ("cs.openWebView.local".equals(paramString2))
          {
            c(paramString1);
            return;
          }
          if ("cs.openWebViewWithoutUrl.local".equals(paramString2))
          {
            d(paramString1);
            return;
          }
          if ("cs.openNativeWebView.local".equals(paramString2))
          {
            j(paramString1);
            return;
          }
          if ("cs.gameBack.local".equals(paramString2))
          {
            i(paramString1);
            return;
          }
          if ("cs.ssoMessage.local".equals(paramString2))
          {
            h(paramString1);
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
            }
            catch (Throwable paramString1)
            {
              QLog.e("ApolloGameInterfaceProxy", 1, paramString1, new Object[0]);
              return;
            }
            if (paramString2.optInt("avatar") == 1) {
              b(paramString1);
            }
          }
          else
          {
            if ("cs.on_get_open_key.local".equals(paramString2)) {
              try
              {
                aile localaile = new aile(this);
                Bundle localBundle = new Bundle();
                localBundle.putString("cmd", paramString2);
                localBundle.putString("reqData", paramString1);
                localBundle.putBoolean("async", true);
                localBundle.putInt("gameId", this.jdField_a_of_type_Int);
                QIPCClientHelper.getInstance().callServer("cm_game_module", "action_chanel_req", localBundle, localaile);
                return;
              }
              catch (Throwable paramString1)
              {
                QLog.e("ApolloGameInterfaceProxy", 1, paramString1, new Object[0]);
                return;
              }
            }
            if ("sc.web_callback_game.local".equals(paramString2))
            {
              if ((paramString1 != null) && (paramString1.length() < 502)) {
                try
                {
                  new JSONObject(paramString1);
                  k(paramString1);
                  return;
                }
                catch (Throwable paramString1)
                {
                  QLog.e("ApolloGameInterfaceProxy", 1, "[callNormalInterface] invalid");
                  return;
                }
              }
              QLog.e("ApolloGameInterfaceProxy", 1, "[send] length invalid");
              return;
            }
            if ("cs.get_file_data.local".equals(paramString2)) {
              try
              {
                g("cs.get_file_data.local", a(new JSONObject(paramString1).optString("path")));
                return;
              }
              catch (Throwable paramString1)
              {
                QLog.e("ApolloGameInterfaceProxy", 1, paramString1, new Object[0]);
                return;
              }
            }
            if ("cs.fetch_cloud_signature.local".equals(paramString2)) {
              try
              {
                paramString1 = new JSONObject(paramString1);
                g("cs.fetch_cloud_signature.local", a(paramString1.optInt("now"), paramString1.optInt("delta"), this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams));
                return;
              }
              catch (Throwable paramString1)
              {
                QLog.e("ApolloGameInterfaceProxy", 1, paramString1, new Object[0]);
                return;
              }
            }
            if ("cs.closeWebview.local".equals(paramString2)) {
              try
              {
                int i = new JSONObject(paramString1).optInt("taskId");
                paramString1 = aing.a(this.jdField_a_of_type_Int);
                if (paramString1 != null)
                {
                  paramString1.a(i);
                  return;
                }
              }
              catch (Throwable paramString1)
              {
                QLog.e("ApolloGameInterfaceProxy", 1, paramString1, new Object[0]);
                return;
              }
            }
          }
        }
      }
    }
    if ("cs.create_xy.local".equals(paramString2))
    {
      aioy.a("cs.create_xy.local", paramString1, false, null, this.jdField_a_of_type_Int);
      return;
    }
    if ("cs.get_state_info.local".equals(paramString2))
    {
      f(paramString2, paramString1);
      return;
    }
    c(paramString2, paramString1);
  }
  
  private void e(String paramString)
  {
    aipj localaipj = aing.a(this.jdField_a_of_type_Int);
    if ((localaipj != null) && (!TextUtils.isEmpty(paramString)))
    {
      aizc.a(this.jdField_a_of_type_Int, paramString, localaipj.a());
      return;
    }
    QLog.e("ApolloGameInterfaceProxy", 1, "[shareGameInARK] can not find launcher for " + this.jdField_a_of_type_Int);
  }
  
  private void e(String paramString1, String paramString2)
  {
    if ((!"sc.web_callback_game.local".equals(paramString2)) || ((paramString1 != null) && (paramString1.length() < 502))) {
      try
      {
        new JSONObject(paramString1);
        k(paramString1);
        return;
      }
      catch (Throwable paramString1)
      {
        QLog.e("ApolloGameInterfaceProxy", 1, "[callNormalInterface] invalid");
        return;
      }
    }
    QLog.e("ApolloGameInterfaceProxy", 1, "[send] length invalid");
  }
  
  private void f(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      aipj localaipj = aing.a(this.jdField_a_of_type_Int);
      if (localaipj != null) {
        localaipj.d(paramString);
      }
    }
  }
  
  private void f(String paramString1, String paramString2)
  {
    b(0, paramString1, aing.a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams));
  }
  
  private void g(String paramString) {}
  
  private void g(String paramString1, String paramString2)
  {
    b(0, paramString1, paramString2);
  }
  
  private void h(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      Object localObject = new JSONObject(paramString);
      String str = ((JSONObject)localObject).optString("cmd");
      localObject = ailn.a(((JSONObject)localObject).optString("data"), String.valueOf(this.jdField_a_of_type_Int));
      aiqs localaiqs = aing.a();
      if ((localaiqs != null) && (!TextUtils.isEmpty(paramString)) && (a(str))) {
        localaiqs.a(str, (String)localObject);
      }
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("ApolloGameInterfaceProxy", 1, paramString, new Object[0]);
    }
  }
  
  private void i(String paramString)
  {
    try
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("url", new JSONObject(paramString).optString("url"));
      localIntent.putExtra("isFullScreen", true);
      aikz.a().a(localIntent);
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("ApolloGameInterfaceProxy", 1, paramString, new Object[0]);
    }
  }
  
  private void j(String paramString)
  {
    try
    {
      Intent localIntent = new Intent();
      String str = new JSONObject(paramString).optString("url");
      paramString = str;
      if (!TextUtils.isEmpty(str))
      {
        paramString = str;
        if (!str.startsWith("http://"))
        {
          paramString = str;
          if (!str.startsWith("https://"))
          {
            paramString = str;
            if (this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView != null)
            {
              ailj localailj = ailh.a().a(str, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView.a()));
              paramString = str;
              if (localailj != null) {
                paramString = localailj.a();
              }
            }
          }
        }
      }
      if (paramString.contains("?")) {}
      for (paramString = paramString + "&apollo_bk=1";; paramString = paramString + "?apollo_bk=1")
      {
        localIntent.putExtra("url", paramString);
        aikz.a().a(localIntent, ApolloWebViewFragment.class);
        return;
      }
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("ApolloGameInterfaceProxy", 1, paramString, new Object[0]);
    }
  }
  
  private void k(String paramString)
  {
    for (;;)
    {
      try
      {
        new JSONObject(paramString).optString("business");
        if (QLog.isColorLevel()) {
          QLog.d("ApolloGameInterfaceProxy", 2, "[sendMessageToGame] " + paramString);
        }
        a("sc.web_callback_game.local", paramString);
        aipj localaipj = aing.a();
        if (localaipj != null)
        {
          i = localaipj.a();
          if (i > 0)
          {
            localaipj = aing.a(i);
            if (localaipj == null) {
              break;
            }
            localaipj.c(paramString);
            return;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("ApolloGameInterfaceProxy", 2, "[sendMessageToGame] no running game");
          return;
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("ApolloGameInterfaceProxy", 1, paramString, new Object[] { "[send]" });
        return;
      }
      int i = 0;
    }
  }
  
  @JavascriptInterface
  public static void log(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    try
    {
      aikb localaikb = aing.a();
      if ((paramInt2 < 0) || (paramInt1 > 0))
      {
        paramString1 = ApolloUtil.e(paramString1);
        paramString2 = ApolloUtil.e(paramString2);
        paramString3 = ApolloUtil.e(paramString3);
        QLog.e("sava_native_log", 1, new Object[] { "level:", Integer.valueOf(paramInt1), ",code:", Integer.valueOf(paramInt2), ",info1:", paramString1, ",info2:", paramString2, ",info3:", paramString3 });
        if (localaikb != null) {
          localaikb.a("sava_native_log", 2, new Object[] { "level:", Integer.valueOf(paramInt1), ",code:", Integer.valueOf(paramInt2), ",info1:", paramString1, ",info2:", paramString2, ",info3:", paramString3 });
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("sava_native_log", 2, new Object[] { "level:", Integer.valueOf(paramInt1), ",code:", Integer.valueOf(paramInt2), ",info1:", paramString1, ",info2:", paramString2, ",info3:", paramString3 });
        if (localaikb != null)
        {
          localaikb.a("sava_native_log", 1, new Object[] { "level:", Integer.valueOf(paramInt1), ",code:", Integer.valueOf(paramInt2), ",info1:", paramString1, ",info2:", paramString2, ",info3:", paramString3 });
          return;
        }
      }
    }
    catch (Throwable paramString1)
    {
      QLog.e("ApolloGameInterfaceProxy", 1, "[printNativeLog]", paramString1);
    }
  }
  
  /* Error */
  public String a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aconst_null
    //   7: astore_2
    //   8: aload_0
    //   9: aload_1
    //   10: invokevirtual 631	com/tencent/mobileqq/apollo/game/ApolloGameInterfaceProxy:b	(Ljava/lang/String;)Ljava/lang/String;
    //   13: astore_1
    //   14: aload_1
    //   15: ifnonnull +5 -> 20
    //   18: aconst_null
    //   19: areturn
    //   20: new 633	java/io/File
    //   23: dup
    //   24: aload_1
    //   25: invokespecial 634	java/io/File:<init>	(Ljava/lang/String;)V
    //   28: astore_3
    //   29: aload_3
    //   30: invokevirtual 637	java/io/File:exists	()Z
    //   33: ifeq -15 -> 18
    //   36: aload_3
    //   37: invokevirtual 637	java/io/File:exists	()Z
    //   40: ifeq +44 -> 84
    //   43: new 639	java/io/FileInputStream
    //   46: dup
    //   47: aload_1
    //   48: invokespecial 640	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   51: astore_3
    //   52: aload_3
    //   53: astore_1
    //   54: aload 4
    //   56: astore_2
    //   57: aload_3
    //   58: invokevirtual 645	java/io/InputStream:available	()I
    //   61: newarray byte
    //   63: astore 4
    //   65: aload_3
    //   66: astore_1
    //   67: aload 4
    //   69: astore_2
    //   70: aload_3
    //   71: aload 4
    //   73: invokevirtual 649	java/io/InputStream:read	([B)I
    //   76: pop
    //   77: aload_3
    //   78: invokevirtual 652	java/io/InputStream:close	()V
    //   81: aload 4
    //   83: astore_2
    //   84: new 111	java/lang/String
    //   87: dup
    //   88: aload_2
    //   89: invokestatic 656	asat:a	([B)[B
    //   92: invokespecial 659	java/lang/String:<init>	([B)V
    //   95: areturn
    //   96: astore_1
    //   97: ldc 50
    //   99: iconst_1
    //   100: aload_1
    //   101: iconst_0
    //   102: anewarray 4	java/lang/Object
    //   105: invokestatic 157	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   108: aload 4
    //   110: astore_2
    //   111: goto -27 -> 84
    //   114: astore 4
    //   116: aconst_null
    //   117: astore_3
    //   118: aload 5
    //   120: astore_2
    //   121: aload_3
    //   122: astore_1
    //   123: ldc 50
    //   125: iconst_1
    //   126: aload 4
    //   128: iconst_0
    //   129: anewarray 4	java/lang/Object
    //   132: invokestatic 157	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   135: aload_3
    //   136: invokevirtual 652	java/io/InputStream:close	()V
    //   139: goto -55 -> 84
    //   142: astore_1
    //   143: ldc 50
    //   145: iconst_1
    //   146: aload_1
    //   147: iconst_0
    //   148: anewarray 4	java/lang/Object
    //   151: invokestatic 157	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   154: goto -70 -> 84
    //   157: astore_2
    //   158: aconst_null
    //   159: astore_1
    //   160: aload_1
    //   161: invokevirtual 652	java/io/InputStream:close	()V
    //   164: aload_2
    //   165: athrow
    //   166: astore_1
    //   167: ldc 50
    //   169: iconst_1
    //   170: aload_1
    //   171: iconst_0
    //   172: anewarray 4	java/lang/Object
    //   175: invokestatic 157	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   178: goto -14 -> 164
    //   181: astore_2
    //   182: goto -22 -> 160
    //   185: astore 4
    //   187: goto -66 -> 121
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	190	0	this	ApolloGameInterfaceProxy
    //   0	190	1	paramString	String
    //   7	114	2	localObject1	Object
    //   157	8	2	localObject2	Object
    //   181	1	2	localObject3	Object
    //   28	108	3	localObject4	Object
    //   4	105	4	arrayOfByte	byte[]
    //   114	13	4	localThrowable1	Throwable
    //   185	1	4	localThrowable2	Throwable
    //   1	118	5	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   77	81	96	java/lang/Throwable
    //   43	52	114	java/lang/Throwable
    //   135	139	142	java/lang/Throwable
    //   43	52	157	finally
    //   160	164	166	java/lang/Throwable
    //   57	65	181	finally
    //   70	77	181	finally
    //   123	135	181	finally
    //   57	65	185	java/lang/Throwable
    //   70	77	185	java/lang/Throwable
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Int != 0)
    {
      localaipj = aing.a(this.jdField_a_of_type_Int);
      if (localaipj != null)
      {
        localObject = localaipj.a();
        if ((localObject != null) && ((localObject instanceof ApolloGameActivity)))
        {
          localObject = (ApolloGameActivity)localObject;
          if (!((ApolloGameActivity)localObject).isFinishing())
          {
            this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView = ((ApolloGameActivity)localObject).a();
            if (this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView != null)
            {
              this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView.a(this);
              localObject = aing.a();
              if ((localObject != null) && (this.jdField_a_of_type_Aiqr != null)) {
                ((AppInterface)localObject).addObserver(this.jdField_a_of_type_Aiqr);
              }
              localaipj.a(this);
            }
          }
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      aipj localaipj;
      Object localObject;
      return;
      QLog.e("ApolloGameInterfaceProxy", 1, "[bindGameView] cann not bindGameView");
      return;
    }
    QLog.d("ApolloGameInterfaceProxy", 2, "[bindGameView] " + this.jdField_a_of_type_Int);
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Int == 0) {}
    aipx localaipx;
    do
    {
      return;
      localaipx = aing.a(this.jdField_a_of_type_Int);
    } while (localaipx == null);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    localaipx.a(2, localArrayList, null, 10, 0L, false, "", "", new ailf(this, paramInt, paramString));
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    b(paramInt, paramString1, paramString2);
  }
  
  public void a(Object paramObject)
  {
    boolean bool2 = false;
    if (this.jdField_a_of_type_Int > 0)
    {
      if ((paramObject != null) && ((paramObject instanceof CmGameInitParams))) {
        this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams = ((CmGameInitParams)paramObject);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams == null) && (this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView != null)) {
        this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams = this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView.a();
      }
      if ((paramObject instanceof ailo)) {
        this.jdField_a_of_type_Boolean = true;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams != null) && (this.jdField_a_of_type_Boolean)) {
        g("sc.init_global_var.local", aing.a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams));
      }
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("[onCheckFinish] gameId ").append(this.jdField_a_of_type_Int).append(" # ");
        if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams != null) {
          break label174;
        }
      }
      label174:
      for (boolean bool1 = true;; bool1 = false)
      {
        localStringBuilder = localStringBuilder.append(bool1).append(" # ");
        bool1 = bool2;
        if (paramObject == null) {
          bool1 = true;
        }
        QLog.e("ApolloGameInterfaceProxy", 1, bool1);
        return;
      }
    }
    QLog.e("ApolloGameInterfaceProxy", 1, "[onCheckFinish] gameId 0");
  }
  
  public void a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("openId");
      if (!TextUtils.isEmpty(paramString)) {
        a(1, paramString);
      }
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("ApolloGameInterfaceProxy", 1, paramString, new Object[0]);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      Object localObject1 = ApolloGamePlugin.a;
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (WeakReference)((Iterator)localObject1).next();
          if ((localObject2 != null) && (((WeakReference)localObject2).get() != null))
          {
            localObject2 = (ApolloGamePlugin)((WeakReference)localObject2).get();
            if (localObject2 != null) {
              ((ApolloGamePlugin)localObject2).a(paramString1, paramString2);
            }
          }
        }
      }
    }
  }
  
  public String b(String paramString)
  {
    String str = null;
    if ((paramString == "") || (paramString == null) || (paramString.endsWith(".js"))) {
      return null;
    }
    if (paramString.startsWith("GameSandBox")) {
      str = "sandbox";
    }
    return ailn.a(paramString, this.jdField_a_of_type_Int, str, false);
  }
  
  public void b()
  {
    g("sc.game_shell_pack_up.local", "{}");
    aipj localaipj = aing.a(this.jdField_a_of_type_Int);
    if (localaipj != null) {
      localaipj.h();
    }
  }
  
  public void b(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("openId");
      if (!TextUtils.isEmpty(paramString)) {
        a(2, paramString);
      }
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("ApolloGameInterfaceProxy", 1, paramString, new Object[0]);
    }
  }
  
  public void b(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameInterfaceProxy", 2, new Object[] { "onNotify, cmd:", paramString1 });
    }
    g(paramString1, paramString2);
  }
  
  public void c()
  {
    g("sc.game_shell_share.local", "{}");
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView.a != null))
      {
        Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView.a();
        if (localObject1 != null)
        {
          localObject1 = ((Bundle)localObject1).getSerializable("game_init");
          if ((localObject1 != null) && ((localObject1 instanceof CmGameStartChecker.StartCheckParam)))
          {
            Object localObject2 = (CmGameStartChecker.StartCheckParam)localObject1;
            localObject1 = new JSONObject();
            ((JSONObject)localObject1).put("gameId", String.valueOf(((CmGameStartChecker.StartCheckParam)localObject2).gameId));
            ((JSONObject)localObject1).put("isSelectFriend", 1);
            localObject2 = aing.a(this.jdField_a_of_type_Int);
            if (localObject2 != null) {
              ((aipj)localObject2).b(((JSONObject)localObject1).toString());
            }
          }
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloGameInterfaceProxy", 1, localThrowable, new Object[] { "[shareGame]" });
    }
  }
  
  public void c(String paramString1, String paramString2)
  {
    ApolloCmdChannel localApolloCmdChannel = aing.a();
    if (localApolloCmdChannel != null)
    {
      localApolloCmdChannel.requestData(this.jdField_a_of_type_Int, paramString1, paramString2, false, false);
      return;
    }
    QLog.d("ApolloGameInterfaceProxy", 1, "[onRequestMessage] no cmd handler");
  }
  
  public void d() {}
  
  public void e()
  {
    g("sc.game_shell_close.local", "{}");
    Object localObject = aing.a(this.jdField_a_of_type_Int);
    if (localObject != null)
    {
      localObject = ((aipj)localObject).a();
      if ((localObject != null) && (!((Activity)localObject).isFinishing())) {
        ((Activity)localObject).finish();
      }
    }
  }
  
  public void exeJsOnEngine(String paramString) {}
  
  public void f()
  {
    g("sc.game_enter_foreground.local", "{}");
    g("sc.game_maximize.local", "{}");
  }
  
  public void g()
  {
    g("sc.game_enter_background.local", "{}");
  }
  
  public long getRenderThreadId()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long getRuntimeState()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView = null;
    this.jdField_a_of_type_Ailo = null;
    this.jdField_a_of_type_Int = 0;
    AppInterface localAppInterface = aing.a();
    if ((localAppInterface != null) && (this.jdField_a_of_type_Aiqr != null)) {
      localAppInterface.removeObserver(this.jdField_a_of_type_Aiqr);
    }
  }
  
  public boolean isJsRuntime()
  {
    return false;
  }
  
  public void runRenderTask(IApolloRunnableTask paramIApolloRunnableTask)
  {
    ThreadManagerV2.executeOnSubThread(paramIApolloRunnableTask);
  }
  
  @JavascriptInterface
  public void send(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameInterfaceProxy", 2, paramString1 + " " + paramString2 + " " + this.jdField_a_of_type_Int);
      }
      if (this.jdField_a_of_type_Int <= 0) {
        break label68;
      }
      d(paramString1, paramString2);
    }
    label68:
    do
    {
      return;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        e(paramString1, paramString2);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloGameInterfaceProxy", 2, "[send] invalid request for " + paramString2 + " " + paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.ApolloGameInterfaceProxy
 * JD-Core Version:    0.7.0.1
 */
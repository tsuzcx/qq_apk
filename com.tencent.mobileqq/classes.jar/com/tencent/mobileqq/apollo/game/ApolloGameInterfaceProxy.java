package com.tencent.mobileqq.apollo.game;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.URLUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;
import com.tencent.mobileqq.apollo.process.data.CmGameLauncher;
import com.tencent.mobileqq.apollo.process.data.CmGameOpenIdFinder;
import com.tencent.mobileqq.apollo.process.sso.CmGameObserver;
import com.tencent.mobileqq.apollo.process.sso.CmGameSSoHandler;
import com.tencent.mobileqq.apollo.store.ApolloFloatActivity;
import com.tencent.mobileqq.apollo.store.ApolloGameActivity;
import com.tencent.mobileqq.apollo.utils.ApolloGameBasicEventUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.security.Key;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;
import yvm;
import yvn;
import yvo;

public class ApolloGameInterfaceProxy
  implements IApolloGameInterface
{
  private int jdField_a_of_type_Int;
  private ApolloGameView jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameView;
  private ApolloJSContext jdField_a_of_type_ComTencentMobileqqApolloGameApolloJSContext;
  private CmGameInitParams jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams;
  private CmGameObserver jdField_a_of_type_ComTencentMobileqqApolloProcessSsoCmGameObserver = new yvm(this);
  private String jdField_a_of_type_JavaLangString;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private boolean jdField_a_of_type_Boolean;
  private int b;
  
  public ApolloGameInterfaceProxy(ApolloJSContext paramApolloJSContext, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloJSContext = paramApolloJSContext;
    try
    {
      this.jdField_a_of_type_Int = Integer.parseInt(paramString);
      a();
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameInterfaceProxy", 2, "[ApolloGameInterfaceProxy] " + this.jdField_a_of_type_Int + " " + this.jdField_a_of_type_JavaLangString);
      }
      return;
    }
    catch (Throwable paramApolloJSContext)
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
        ((StringBuilder)localObject4).append(HexUtil.a(localObject3[paramInt1]));
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
  
  private void a(int paramInt, String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloJSContext != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloJSContext.a(paramInt, paramString1, paramString2);
      return;
    }
    QLog.e("ApolloGameInterfaceProxy", 1, "[callbackJS] fail for " + paramString1);
  }
  
  /* Error */
  private void c(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 171	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +386 -> 390
    //   7: new 92	org/json/JSONObject
    //   10: dup
    //   11: aload_1
    //   12: invokespecial 96	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   15: astore 4
    //   17: aload 4
    //   19: ldc 188
    //   21: invokevirtual 102	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   24: astore_3
    //   25: new 92	org/json/JSONObject
    //   28: dup
    //   29: aload_3
    //   30: invokespecial 96	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   33: astore_1
    //   34: aload_1
    //   35: ldc 188
    //   37: invokevirtual 102	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   40: invokestatic 171	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   43: istore_2
    //   44: iload_2
    //   45: ifne +339 -> 384
    //   48: aload_1
    //   49: ldc 188
    //   51: invokevirtual 102	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   54: astore 4
    //   56: aload 4
    //   58: astore_3
    //   59: aload_3
    //   60: invokestatic 171	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   63: ifne +327 -> 390
    //   66: aload_0
    //   67: getfield 190	com/tencent/mobileqq/apollo/game/ApolloGameInterfaceProxy:jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameView	Lcom/tencent/mobileqq/apollo/game/ApolloGameView;
    //   70: ifnull +320 -> 390
    //   73: aload_0
    //   74: getfield 190	com/tencent/mobileqq/apollo/game/ApolloGameInterfaceProxy:jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameView	Lcom/tencent/mobileqq/apollo/game/ApolloGameView;
    //   77: getfield 195	com/tencent/mobileqq/apollo/game/ApolloGameView:a	Landroid/content/Context;
    //   80: ifnull +310 -> 390
    //   83: aload_3
    //   84: ldc 197
    //   86: invokevirtual 200	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   89: ifeq +160 -> 249
    //   92: new 59	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   99: aload_3
    //   100: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: ldc 202
    //   105: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: astore_3
    //   112: new 204	android/content/Intent
    //   115: dup
    //   116: invokespecial 205	android/content/Intent:<init>	()V
    //   119: astore 4
    //   121: aload 4
    //   123: ldc 188
    //   125: aload_3
    //   126: invokevirtual 209	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   129: pop
    //   130: aload 4
    //   132: ldc 188
    //   134: aload_3
    //   135: invokevirtual 209	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   138: pop
    //   139: aload 4
    //   141: ldc 211
    //   143: invokestatic 217	java/lang/System:currentTimeMillis	()J
    //   146: invokevirtual 220	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   149: pop
    //   150: aload_0
    //   151: getfield 190	com/tencent/mobileqq/apollo/game/ApolloGameInterfaceProxy:jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameView	Lcom/tencent/mobileqq/apollo/game/ApolloGameView;
    //   154: invokevirtual 223	com/tencent/mobileqq/apollo/game/ApolloGameView:a	()Landroid/os/Bundle;
    //   157: astore_3
    //   158: aload_3
    //   159: ifnull +210 -> 369
    //   162: aload_3
    //   163: ldc 225
    //   165: invokevirtual 231	android/os/Bundle:getSerializable	(Ljava/lang/String;)Ljava/io/Serializable;
    //   168: astore_3
    //   169: aload_3
    //   170: ifnull +189 -> 359
    //   173: aload_3
    //   174: instanceof 233
    //   177: ifeq +182 -> 359
    //   180: aload_3
    //   181: checkcast 233	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker$StartCheckParam
    //   184: getfield 236	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker$StartCheckParam:mGameType	I
    //   187: iconst_3
    //   188: if_icmpne +84 -> 272
    //   191: aload 4
    //   193: getstatic 241	com/tencent/mobileqq/apollo/game/ApolloGameView$Director:BACKGROUND_COLOR	Ljava/lang/String;
    //   196: aload_1
    //   197: getstatic 241	com/tencent/mobileqq/apollo/game/ApolloGameView$Director:BACKGROUND_COLOR	Ljava/lang/String;
    //   200: invokevirtual 102	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   203: invokevirtual 209	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   206: pop
    //   207: aload 4
    //   209: getstatic 244	com/tencent/mobileqq/apollo/game/ApolloGameView$Director:TITLE	Ljava/lang/String;
    //   212: aload_1
    //   213: getstatic 244	com/tencent/mobileqq/apollo/game/ApolloGameView$Director:TITLE	Ljava/lang/String;
    //   216: invokevirtual 102	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   219: invokevirtual 209	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   222: pop
    //   223: aload 4
    //   225: getstatic 247	com/tencent/mobileqq/apollo/game/ApolloGameView$Director:FOREGROUND_COLOR	Ljava/lang/String;
    //   228: aload_1
    //   229: getstatic 247	com/tencent/mobileqq/apollo/game/ApolloGameView$Director:FOREGROUND_COLOR	Ljava/lang/String;
    //   232: invokevirtual 102	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   235: invokevirtual 209	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   238: pop
    //   239: aload_0
    //   240: getfield 190	com/tencent/mobileqq/apollo/game/ApolloGameInterfaceProxy:jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameView	Lcom/tencent/mobileqq/apollo/game/ApolloGameView;
    //   243: aload 4
    //   245: invokevirtual 250	com/tencent/mobileqq/apollo/game/ApolloGameView:b	(Landroid/content/Intent;)V
    //   248: return
    //   249: new 59	java/lang/StringBuilder
    //   252: dup
    //   253: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   256: aload_3
    //   257: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: ldc 252
    //   262: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   268: astore_3
    //   269: goto -157 -> 112
    //   272: aload 4
    //   274: ldc 254
    //   276: ldc_w 256
    //   279: invokevirtual 209	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   282: pop
    //   283: aload 4
    //   285: aload_0
    //   286: getfield 190	com/tencent/mobileqq/apollo/game/ApolloGameInterfaceProxy:jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameView	Lcom/tencent/mobileqq/apollo/game/ApolloGameView;
    //   289: getfield 195	com/tencent/mobileqq/apollo/game/ApolloGameView:a	Landroid/content/Context;
    //   292: ldc_w 258
    //   295: invokevirtual 262	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
    //   298: pop
    //   299: aload 4
    //   301: ldc_w 263
    //   304: invokevirtual 267	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   307: pop
    //   308: aload_0
    //   309: getfield 190	com/tencent/mobileqq/apollo/game/ApolloGameInterfaceProxy:jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameView	Lcom/tencent/mobileqq/apollo/game/ApolloGameView;
    //   312: getfield 195	com/tencent/mobileqq/apollo/game/ApolloGameView:a	Landroid/content/Context;
    //   315: instanceof 269
    //   318: ifeq +72 -> 390
    //   321: aload_0
    //   322: getfield 190	com/tencent/mobileqq/apollo/game/ApolloGameInterfaceProxy:jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameView	Lcom/tencent/mobileqq/apollo/game/ApolloGameView;
    //   325: getfield 195	com/tencent/mobileqq/apollo/game/ApolloGameView:a	Landroid/content/Context;
    //   328: checkcast 269	android/app/Activity
    //   331: aload 4
    //   333: sipush 999
    //   336: invokevirtual 273	android/app/Activity:startActivityForResult	(Landroid/content/Intent;I)V
    //   339: return
    //   340: astore_1
    //   341: ldc 57
    //   343: iconst_1
    //   344: aload_1
    //   345: iconst_1
    //   346: anewarray 4	java/lang/Object
    //   349: dup
    //   350: iconst_0
    //   351: ldc_w 275
    //   354: aastore
    //   355: invokestatic 164	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   358: return
    //   359: ldc 57
    //   361: iconst_1
    //   362: ldc_w 277
    //   365: invokestatic 179	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   368: return
    //   369: ldc 57
    //   371: iconst_1
    //   372: ldc_w 279
    //   375: invokestatic 179	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   378: return
    //   379: astore 4
    //   381: goto +14 -> 395
    //   384: aload 4
    //   386: astore_1
    //   387: goto -328 -> 59
    //   390: return
    //   391: astore_1
    //   392: aload 4
    //   394: astore_1
    //   395: goto -336 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	398	0	this	ApolloGameInterfaceProxy
    //   0	398	1	paramString	String
    //   43	2	2	bool	boolean
    //   24	245	3	localObject1	Object
    //   15	317	4	localObject2	Object
    //   379	14	4	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   0	25	340	java/lang/Throwable
    //   59	112	340	java/lang/Throwable
    //   112	158	340	java/lang/Throwable
    //   162	169	340	java/lang/Throwable
    //   173	248	340	java/lang/Throwable
    //   249	269	340	java/lang/Throwable
    //   272	339	340	java/lang/Throwable
    //   359	368	340	java/lang/Throwable
    //   369	378	340	java/lang/Throwable
    //   48	56	379	java/lang/Throwable
    //   25	44	391	java/lang/Throwable
  }
  
  private void c(String paramString1, String paramString2)
  {
    if ("cs.make_room_min.local".equals(paramString2)) {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameView != null) {
        b();
      }
    }
    for (;;)
    {
      return;
      if ("cs.close_room.local".equals(paramString2))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameView != null) {
          this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameView.a(true);
        }
      }
      else
      {
        if ("cs.share_game_in_ark.local".equals(paramString2))
        {
          e(paramString1);
          return;
        }
        if ("cs.game_shell_share_callback.local".equals(paramString2))
        {
          f(paramString1);
          return;
        }
        if ("cs.share_game_result.local".equals(paramString2))
        {
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
                yvn localyvn = new yvn(this);
                Bundle localBundle = new Bundle();
                localBundle.putString("cmd", paramString2);
                localBundle.putString("reqData", paramString1);
                localBundle.putBoolean("async", true);
                localBundle.putInt("gameId", this.jdField_a_of_type_Int);
                QIPCClientHelper.getInstance().callServer("cm_game_module", "action_chanel_req", localBundle, localyvn);
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
                e("cs.get_file_data.local", a(new JSONObject(paramString1).optString("path")));
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
                e("cs.fetch_cloud_signature.local", a(paramString1.optInt("now"), paramString1.optInt("delta"), this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams));
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
                paramString1 = CmGameUtil.a(this.jdField_a_of_type_Int);
                if (paramString1 != null)
                {
                  paramString1.a(i);
                  return;
                }
              }
              catch (Throwable paramString1)
              {
                QLog.e("ApolloGameInterfaceProxy", 1, paramString1, new Object[0]);
              }
            }
          }
        }
      }
    }
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
          localIntent.putExtra("extra_key_weburl", paramString);
          localIntent.putExtra("url", paramString);
          localIntent.putExtra("extra_key_fullscreen", true);
          localIntent.putExtra("extra_key_close_btn", false);
          localIntent.putExtra("extra_key_from", 1);
          localIntent.addFlags(65536);
          localIntent.putExtra("game_busid", "Android.H5");
          localIntent.putExtra("extra_key_gameid", this.jdField_a_of_type_Int);
          localIntent.putExtra("extra_key_taskid", i);
          if ((this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameView == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameView.a == null)) {
            break;
          }
          paramString = this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameView.a().getSerializable("game_data");
          if ((paramString == null) || (!(paramString instanceof ApolloGameData))) {
            break;
          }
          paramString = (ApolloGameData)paramString;
          localIntent.setClass(this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameView.a, ApolloFloatActivity.class);
          localIntent.putExtra("extra_key_entratation", paramString.viewMode + 1);
          if (!(this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameView.a instanceof Activity)) {
            break;
          }
          ((Activity)this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameView.a).startActivityForResult(localIntent, 999);
          paramString = new JSONObject();
          paramString.put("taskId", i);
          e("cs.openWebViewWithoutUrl.local", paramString.toString());
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
  
  private void e(String paramString)
  {
    CmGameLauncher localCmGameLauncher = CmGameUtil.a(this.jdField_a_of_type_Int);
    if ((localCmGameLauncher != null) && (!TextUtils.isEmpty(paramString)))
    {
      ApolloGameBasicEventUtil.a(this.jdField_a_of_type_Int, paramString, localCmGameLauncher.a());
      return;
    }
    QLog.e("ApolloGameInterfaceProxy", 1, "[shareGameInARK] can not find launcher for " + this.jdField_a_of_type_Int);
  }
  
  private void e(String paramString1, String paramString2)
  {
    a(0, paramString1, paramString2);
  }
  
  private void f(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      CmGameLauncher localCmGameLauncher = CmGameUtil.a(this.jdField_a_of_type_Int);
      if (localCmGameLauncher != null) {
        localCmGameLauncher.c(paramString);
      }
    }
  }
  
  private void g(String paramString) {}
  
  private void h(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      Object localObject = new JSONObject(paramString);
      String str = ((JSONObject)localObject).optString("cmd");
      localObject = ApolloGameTool.a(((JSONObject)localObject).optString("data"), String.valueOf(this.jdField_a_of_type_Int));
      CmGameSSoHandler localCmGameSSoHandler = CmGameUtil.a();
      if ((localCmGameSSoHandler != null) && (!TextUtils.isEmpty(paramString))) {
        localCmGameSSoHandler.a(str, (String)localObject);
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
      ApolloFragmentManager.a().a(localIntent);
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
            if (this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameView != null)
            {
              ApolloGameResManager.ApolloGameRes localApolloGameRes = ApolloGameResManager.a().a(str, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameView.a()));
              paramString = str;
              if (localApolloGameRes != null) {
                paramString = localApolloGameRes.a();
              }
            }
          }
        }
      }
      if (paramString.contains("?")) {}
      for (paramString = paramString + "&apollo_bk=1";; paramString = paramString + "?apollo_bk=1")
      {
        localIntent.putExtra("url", paramString);
        ApolloFragmentManager.a().a(localIntent, ApolloWebViewFragment.class);
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
        CmGameLauncher localCmGameLauncher = CmGameUtil.a();
        if (localCmGameLauncher != null)
        {
          i = localCmGameLauncher.a();
          if (i > 0)
          {
            localCmGameLauncher = CmGameUtil.a(i);
            if (localCmGameLauncher == null) {
              break;
            }
            localCmGameLauncher.b(paramString);
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
    if ((paramInt2 < 0) || (paramInt1 > 0)) {}
    try
    {
      QLog.e("sava_native_log", 1, new Object[] { "level:", Integer.valueOf(paramInt1), ",code:", Integer.valueOf(paramInt2), ",info1:", ApolloUtil.e(paramString1), ",info2:", ApolloUtil.e(paramString2), ",info3:", ApolloUtil.e(paramString3) });
      return;
    }
    catch (Throwable paramString1)
    {
      QLog.e("ApolloGameInterfaceProxy", 1, "[printNativeLog]", paramString1);
    }
    if (QLog.isColorLevel())
    {
      QLog.d("sava_native_log", 2, new Object[] { "level:", Integer.valueOf(paramInt1), ",code:", Integer.valueOf(paramInt2), ",info1:", paramString1, ",info2:", paramString2, ",info3:", paramString3 });
      return;
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
    //   10: invokevirtual 575	com/tencent/mobileqq/apollo/game/ApolloGameInterfaceProxy:b	(Ljava/lang/String;)Ljava/lang/String;
    //   13: astore_1
    //   14: aload_1
    //   15: ifnonnull +5 -> 20
    //   18: aconst_null
    //   19: areturn
    //   20: new 577	java/io/File
    //   23: dup
    //   24: aload_1
    //   25: invokespecial 578	java/io/File:<init>	(Ljava/lang/String;)V
    //   28: astore_3
    //   29: aload_3
    //   30: invokevirtual 581	java/io/File:exists	()Z
    //   33: ifeq -15 -> 18
    //   36: aload_3
    //   37: invokevirtual 581	java/io/File:exists	()Z
    //   40: ifeq +44 -> 84
    //   43: new 583	java/io/FileInputStream
    //   46: dup
    //   47: aload_1
    //   48: invokespecial 584	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   51: astore_3
    //   52: aload_3
    //   53: astore_1
    //   54: aload 4
    //   56: astore_2
    //   57: aload_3
    //   58: invokevirtual 589	java/io/InputStream:available	()I
    //   61: newarray byte
    //   63: astore 4
    //   65: aload_3
    //   66: astore_1
    //   67: aload 4
    //   69: astore_2
    //   70: aload_3
    //   71: aload 4
    //   73: invokevirtual 593	java/io/InputStream:read	([B)I
    //   76: pop
    //   77: aload_3
    //   78: invokevirtual 596	java/io/InputStream:close	()V
    //   81: aload 4
    //   83: astore_2
    //   84: new 118	java/lang/String
    //   87: dup
    //   88: aload_2
    //   89: invokestatic 600	com/tencent/mobileqq/musicpendant/Base64:a	([B)[B
    //   92: invokespecial 603	java/lang/String:<init>	([B)V
    //   95: areturn
    //   96: astore_1
    //   97: ldc 57
    //   99: iconst_1
    //   100: aload_1
    //   101: iconst_0
    //   102: anewarray 4	java/lang/Object
    //   105: invokestatic 164	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
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
    //   123: ldc 57
    //   125: iconst_1
    //   126: aload 4
    //   128: iconst_0
    //   129: anewarray 4	java/lang/Object
    //   132: invokestatic 164	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   135: aload_3
    //   136: invokevirtual 596	java/io/InputStream:close	()V
    //   139: goto -55 -> 84
    //   142: astore_1
    //   143: ldc 57
    //   145: iconst_1
    //   146: aload_1
    //   147: iconst_0
    //   148: anewarray 4	java/lang/Object
    //   151: invokestatic 164	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   154: goto -70 -> 84
    //   157: astore_2
    //   158: aconst_null
    //   159: astore_1
    //   160: aload_1
    //   161: invokevirtual 596	java/io/InputStream:close	()V
    //   164: aload_2
    //   165: athrow
    //   166: astore_1
    //   167: ldc 57
    //   169: iconst_1
    //   170: aload_1
    //   171: iconst_0
    //   172: anewarray 4	java/lang/Object
    //   175: invokestatic 164	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
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
      localObject = CmGameUtil.a(this.jdField_a_of_type_Int);
      if (localObject != null)
      {
        localObject = ((CmGameLauncher)localObject).a();
        if ((localObject != null) && ((localObject instanceof ApolloGameActivity)))
        {
          localObject = (ApolloGameActivity)localObject;
          if (!((ApolloGameActivity)localObject).isFinishing())
          {
            this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameView = ((ApolloGameActivity)localObject).a();
            this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameView.a(this);
            localObject = CmGameUtil.a();
            if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloProcessSsoCmGameObserver != null)) {
              ((AppInterface)localObject).addObserver(this.jdField_a_of_type_ComTencentMobileqqApolloProcessSsoCmGameObserver);
            }
          }
        }
      }
    }
    while (!QLog.isColorLevel())
    {
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
    CmGameOpenIdFinder localCmGameOpenIdFinder;
    do
    {
      return;
      localCmGameOpenIdFinder = CmGameUtil.a(this.jdField_a_of_type_Int);
    } while (localCmGameOpenIdFinder == null);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    localCmGameOpenIdFinder.a(2, localArrayList, null, 10, 0L, false, "", "", new yvo(this, paramInt, paramString));
  }
  
  public void a(Object paramObject)
  {
    boolean bool2 = false;
    if (this.jdField_a_of_type_Int > 0)
    {
      if ((paramObject != null) && ((paramObject instanceof CmGameInitParams))) {
        this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams = ((CmGameInitParams)paramObject);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams == null) && (this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameView != null)) {
        this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams = this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameView.a();
      }
      if ((paramObject instanceof ApolloJSContext)) {
        this.jdField_a_of_type_Boolean = true;
      }
      if ((!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams != null) && (this.jdField_a_of_type_Boolean))
      {
        e("sc.init_global_var.local", CmGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams));
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      }
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("[onCheckFinish] gameId ").append(this.jdField_a_of_type_Int).append(" # ");
        if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams != null) {
          break label192;
        }
      }
      label192:
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
    return ApolloGameTool.a(paramString, this.jdField_a_of_type_Int, str, false);
  }
  
  public void b()
  {
    e("sc.game_shell_pack_up.local", "{}");
    CmGameLauncher localCmGameLauncher = CmGameUtil.a(this.jdField_a_of_type_Int);
    if (localCmGameLauncher != null) {
      localCmGameLauncher.f();
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
    e(paramString1, paramString2);
  }
  
  public void c()
  {
    e("sc.game_shell_share.local", "{}");
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameView.a != null))
      {
        Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameView.a();
        if (localObject1 != null)
        {
          localObject1 = ((Bundle)localObject1).getSerializable("game_data");
          if ((localObject1 != null) && ((localObject1 instanceof ApolloGameData)))
          {
            Object localObject2 = (ApolloGameData)localObject1;
            localObject1 = new JSONObject();
            ((JSONObject)localObject1).put("gameId", String.valueOf(((ApolloGameData)localObject2).gameId));
            ((JSONObject)localObject1).put("isSelectFriend", 1);
            localObject2 = CmGameUtil.a(this.jdField_a_of_type_Int);
            if (localObject2 != null) {
              ((CmGameLauncher)localObject2).a(((JSONObject)localObject1).toString());
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
  
  public void d() {}
  
  public void e()
  {
    e("sc.game_shell_close.local", "{}");
    Object localObject = CmGameUtil.a(this.jdField_a_of_type_Int);
    if (localObject != null)
    {
      localObject = ((CmGameLauncher)localObject).a();
      if ((localObject != null) && (!((Activity)localObject).isFinishing())) {
        ((Activity)localObject).finish();
      }
    }
  }
  
  public void f()
  {
    e("sc.game_enter_foreground.local", "{}");
    e("sc.game_maximize.local", "{}");
  }
  
  public void g()
  {
    e("sc.game_enter_background.local", "{}");
  }
  
  public void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameView = null;
    this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloJSContext = null;
    this.jdField_a_of_type_Int = 0;
    AppInterface localAppInterface = CmGameUtil.a();
    if ((localAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloProcessSsoCmGameObserver != null)) {
      localAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqApolloProcessSsoCmGameObserver);
    }
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
      c(paramString1, paramString2);
    }
    label68:
    do
    {
      return;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        d(paramString1, paramString2);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloGameInterfaceProxy", 2, "[send] invalid request for " + paramString2 + " " + paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.ApolloGameInterfaceProxy
 * JD-Core Version:    0.7.0.1
 */
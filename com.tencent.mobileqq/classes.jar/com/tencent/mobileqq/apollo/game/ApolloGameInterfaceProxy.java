package com.tencent.mobileqq.apollo.game;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.URLUtil;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.process.data.CmGameLauncher;
import com.tencent.mobileqq.apollo.process.data.CmGameOpenIdFinder;
import com.tencent.mobileqq.apollo.process.sso.CmGameSSoHandler;
import com.tencent.mobileqq.apollo.store.ApolloFloatActivity;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
import yma;
import ymb;

public class ApolloGameInterfaceProxy
  implements IApolloGameInterface
{
  private int jdField_a_of_type_Int;
  private ApolloGameView jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameView;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  
  public ApolloGameInterfaceProxy() {}
  
  public ApolloGameInterfaceProxy(ApolloJSContext paramApolloJSContext)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramApolloJSContext);
  }
  
  /* Error */
  private void c(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 34	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +334 -> 338
    //   7: new 36	org/json/JSONObject
    //   10: dup
    //   11: aload_1
    //   12: invokespecial 38	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   15: astore 4
    //   17: aload 4
    //   19: ldc 40
    //   21: invokevirtual 44	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   24: astore_3
    //   25: new 36	org/json/JSONObject
    //   28: dup
    //   29: aload_3
    //   30: invokespecial 38	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   33: astore_1
    //   34: aload_1
    //   35: ldc 40
    //   37: invokevirtual 44	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   40: invokestatic 34	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   43: istore_2
    //   44: iload_2
    //   45: ifne +287 -> 332
    //   48: aload_1
    //   49: ldc 40
    //   51: invokevirtual 44	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   54: astore 4
    //   56: aload 4
    //   58: astore_3
    //   59: aload_3
    //   60: invokestatic 34	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   63: ifne +275 -> 338
    //   66: aload_0
    //   67: getfield 46	com/tencent/mobileqq/apollo/game/ApolloGameInterfaceProxy:jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameView	Lcom/tencent/mobileqq/apollo/game/ApolloGameView;
    //   70: ifnull +268 -> 338
    //   73: aload_0
    //   74: getfield 46	com/tencent/mobileqq/apollo/game/ApolloGameInterfaceProxy:jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameView	Lcom/tencent/mobileqq/apollo/game/ApolloGameView;
    //   77: getfield 51	com/tencent/mobileqq/apollo/game/ApolloGameView:a	Landroid/content/Context;
    //   80: ifnull +258 -> 338
    //   83: aload_3
    //   84: ldc 53
    //   86: invokevirtual 58	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   89: ifeq +151 -> 240
    //   92: new 60	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   99: aload_3
    //   100: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: ldc 67
    //   105: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: astore_3
    //   112: new 73	android/content/Intent
    //   115: dup
    //   116: invokespecial 74	android/content/Intent:<init>	()V
    //   119: astore 4
    //   121: aload 4
    //   123: ldc 40
    //   125: aload_3
    //   126: invokevirtual 78	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   129: pop
    //   130: aload 4
    //   132: ldc 80
    //   134: invokestatic 86	java/lang/System:currentTimeMillis	()J
    //   137: invokevirtual 89	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   140: pop
    //   141: aload_0
    //   142: getfield 46	com/tencent/mobileqq/apollo/game/ApolloGameInterfaceProxy:jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameView	Lcom/tencent/mobileqq/apollo/game/ApolloGameView;
    //   145: invokevirtual 92	com/tencent/mobileqq/apollo/game/ApolloGameView:a	()Landroid/os/Bundle;
    //   148: astore_3
    //   149: aload_3
    //   150: ifnull +168 -> 318
    //   153: aload_3
    //   154: ldc 94
    //   156: invokevirtual 100	android/os/Bundle:getSerializable	(Ljava/lang/String;)Ljava/io/Serializable;
    //   159: astore_3
    //   160: aload_3
    //   161: ifnull +148 -> 309
    //   164: aload_3
    //   165: instanceof 102
    //   168: ifeq +141 -> 309
    //   171: aload_3
    //   172: checkcast 102	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker$StartCheckParam
    //   175: getfield 105	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker$StartCheckParam:mGameType	I
    //   178: iconst_3
    //   179: if_icmpne +84 -> 263
    //   182: aload 4
    //   184: getstatic 111	com/tencent/mobileqq/apollo/game/ApolloGameView$Director:BACKGROUND_COLOR	Ljava/lang/String;
    //   187: aload_1
    //   188: getstatic 111	com/tencent/mobileqq/apollo/game/ApolloGameView$Director:BACKGROUND_COLOR	Ljava/lang/String;
    //   191: invokevirtual 44	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   194: invokevirtual 78	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   197: pop
    //   198: aload 4
    //   200: getstatic 114	com/tencent/mobileqq/apollo/game/ApolloGameView$Director:TITLE	Ljava/lang/String;
    //   203: aload_1
    //   204: getstatic 114	com/tencent/mobileqq/apollo/game/ApolloGameView$Director:TITLE	Ljava/lang/String;
    //   207: invokevirtual 44	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   210: invokevirtual 78	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   213: pop
    //   214: aload 4
    //   216: getstatic 117	com/tencent/mobileqq/apollo/game/ApolloGameView$Director:FOREGROUND_COLOR	Ljava/lang/String;
    //   219: aload_1
    //   220: getstatic 117	com/tencent/mobileqq/apollo/game/ApolloGameView$Director:FOREGROUND_COLOR	Ljava/lang/String;
    //   223: invokevirtual 44	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   226: invokevirtual 78	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   229: pop
    //   230: aload_0
    //   231: getfield 46	com/tencent/mobileqq/apollo/game/ApolloGameInterfaceProxy:jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameView	Lcom/tencent/mobileqq/apollo/game/ApolloGameView;
    //   234: aload 4
    //   236: invokevirtual 121	com/tencent/mobileqq/apollo/game/ApolloGameView:b	(Landroid/content/Intent;)V
    //   239: return
    //   240: new 60	java/lang/StringBuilder
    //   243: dup
    //   244: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   247: aload_3
    //   248: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: ldc 123
    //   253: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: astore_3
    //   260: goto -148 -> 112
    //   263: aload 4
    //   265: aload_0
    //   266: getfield 46	com/tencent/mobileqq/apollo/game/ApolloGameInterfaceProxy:jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameView	Lcom/tencent/mobileqq/apollo/game/ApolloGameView;
    //   269: getfield 51	com/tencent/mobileqq/apollo/game/ApolloGameView:a	Landroid/content/Context;
    //   272: ldc 125
    //   274: invokevirtual 129	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
    //   277: pop
    //   278: aload_0
    //   279: getfield 46	com/tencent/mobileqq/apollo/game/ApolloGameInterfaceProxy:jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameView	Lcom/tencent/mobileqq/apollo/game/ApolloGameView;
    //   282: getfield 51	com/tencent/mobileqq/apollo/game/ApolloGameView:a	Landroid/content/Context;
    //   285: aload 4
    //   287: invokevirtual 134	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   290: return
    //   291: astore_1
    //   292: ldc 136
    //   294: iconst_1
    //   295: aload_1
    //   296: iconst_1
    //   297: anewarray 4	java/lang/Object
    //   300: dup
    //   301: iconst_0
    //   302: ldc 138
    //   304: aastore
    //   305: invokestatic 144	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   308: return
    //   309: ldc 136
    //   311: iconst_1
    //   312: ldc 146
    //   314: invokestatic 149	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   317: return
    //   318: ldc 136
    //   320: iconst_1
    //   321: ldc 151
    //   323: invokestatic 149	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   326: return
    //   327: astore 4
    //   329: goto +14 -> 343
    //   332: aload 4
    //   334: astore_1
    //   335: goto -276 -> 59
    //   338: return
    //   339: astore_1
    //   340: aload 4
    //   342: astore_1
    //   343: goto -284 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	346	0	this	ApolloGameInterfaceProxy
    //   0	346	1	paramString	String
    //   43	2	2	bool	boolean
    //   24	236	3	localObject1	Object
    //   15	271	4	localObject2	Object
    //   327	14	4	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   0	25	291	java/lang/Throwable
    //   59	112	291	java/lang/Throwable
    //   112	149	291	java/lang/Throwable
    //   153	160	291	java/lang/Throwable
    //   164	239	291	java/lang/Throwable
    //   240	260	291	java/lang/Throwable
    //   263	290	291	java/lang/Throwable
    //   309	317	291	java/lang/Throwable
    //   318	326	291	java/lang/Throwable
    //   48	56	327	java/lang/Throwable
    //   25	44	339	java/lang/Throwable
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
          Intent localIntent = new Intent();
          localIntent.putExtra("extra_key_weburl", paramString);
          localIntent.putExtra("extra_key_fullscreen", true);
          localIntent.putExtra("extra_key_close_btn", false);
          localIntent.putExtra("extra_key_from", 1);
          localIntent.addFlags(65536);
          localIntent.addFlags(268435456);
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
          this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameView.a.startActivity(localIntent);
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
  
  private void e(String paramString)
  {
    CmGameLauncher localCmGameLauncher = CmGameUtil.a(this.jdField_a_of_type_Int);
    if (localCmGameLauncher != null) {
      localCmGameLauncher.a(paramString);
    }
  }
  
  private void f(String paramString) {}
  
  private void g(String paramString)
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
  
  private void h(String paramString)
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
  
  private void i(String paramString)
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
  
  private void j(String paramString)
  {
    try
    {
      new JSONObject(paramString).optString("business");
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameInterfaceProxy", 2, "[sendMessageToGame] " + paramString);
      }
      a("sc.web_callback_game.local", paramString);
      CmGameLauncher localCmGameLauncher = CmGameUtil.a(this.jdField_a_of_type_Int);
      if (localCmGameLauncher != null) {
        localCmGameLauncher.b(paramString);
      }
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("ApolloGameInterfaceProxy", 1, paramString, new Object[] { "[send]" });
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
  
  public void a()
  {
    CmGameLauncher localCmGameLauncher = CmGameUtil.a(this.jdField_a_of_type_Int);
    if (localCmGameLauncher != null) {
      localCmGameLauncher.f();
    }
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
    localCmGameOpenIdFinder.a(2, localArrayList, null, 10, 0L, false, "", "", new ymb(this, paramInt, paramString));
  }
  
  public void a(ApolloGameView paramApolloGameView)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameView = paramApolloGameView;
    this.jdField_a_of_type_Int = paramApolloGameView.a();
  }
  
  public void a(Object paramObject) {}
  
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
  
  public void b()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameView.a != null))
      {
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameView.a();
        if (localObject != null)
        {
          localObject = ((Bundle)localObject).getSerializable("game_data");
          if ((localObject != null) && ((localObject instanceof ApolloGameData)))
          {
            localObject = (ApolloGameData)localObject;
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("gameId", String.valueOf(((ApolloGameData)localObject).gameId));
            localJSONObject.put("isSelectFriend", 1);
            e(localJSONObject.toString());
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
  
  public void c() {}
  
  public void d()
  {
    Object localObject = CmGameUtil.a(this.jdField_a_of_type_Int);
    if (localObject != null)
    {
      localObject = ((CmGameLauncher)localObject).a();
      if ((localObject != null) && (!((Activity)localObject).isFinishing())) {
        ((Activity)localObject).finish();
      }
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameView = null;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_Int = 0;
  }
  
  @JavascriptInterface
  public void send(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameInterfaceProxy", 2, paramString1 + " " + paramString2);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameView != null)
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameView.b) {
          break label432;
        }
        if (!"cs.make_room_min.local".equals(paramString2)) {
          break label82;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameView != null) {
          a();
        }
      }
    }
    label82:
    while (!"sc.web_callback_game.local".equals(paramString2))
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if (!"cs.close_room.local".equals(paramString2)) {
                break;
              }
            } while (this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameView == null);
            this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameView.a(true);
            d();
            return;
            if ("cs.game_shell_share_callback.local".equals(paramString2))
            {
              e(paramString1);
              return;
            }
            if (!"cs.share_game_result.local".equals(paramString2)) {
              break;
            }
          } while (TextUtils.isEmpty(paramString1));
          f(paramString1);
          return;
          if ("sc.web_callback_game.local".equals(paramString2))
          {
            if ((paramString1 != null) && (paramString1.length() < 1024))
            {
              j(paramString1);
              return;
            }
            QLog.e("ApolloGameInterfaceProxy", 1, "[send] length invalid");
            return;
          }
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
            i(paramString1);
            return;
          }
          if ("cs.gameBack.local".equals(paramString2))
          {
            h(paramString1);
            return;
          }
          if ("cs.ssoMessage.local".equals(paramString2))
          {
            g(paramString1);
            return;
          }
          if (!"cs.get_userInfo.local".equals(paramString2)) {
            break;
          }
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
        } while (paramString2.optInt("avatar") != 1);
        b(paramString1);
        return;
      } while (!"cs.on_get_open_key.local".equals(paramString2));
      try
      {
        yma localyma = new yma(this);
        Bundle localBundle = new Bundle();
        localBundle.putString("cmd", paramString2);
        localBundle.putString("reqData", paramString1);
        localBundle.putBoolean("async", true);
        localBundle.putInt("gameId", this.jdField_a_of_type_Int);
        QIPCClientHelper.getInstance().callServer("cm_game_module", "action_chanel_req", localBundle, localyma);
        return;
      }
      catch (Throwable paramString1)
      {
        QLog.e("ApolloGameInterfaceProxy", 1, paramString1, new Object[0]);
        return;
      }
    }
    label432:
    if ((paramString1 != null) && (paramString1.length() < 1024))
    {
      j(paramString1);
      return;
    }
    QLog.e("ApolloGameInterfaceProxy", 1, "[send] length invalid");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.ApolloGameInterfaceProxy
 * JD-Core Version:    0.7.0.1
 */
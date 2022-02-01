import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import mqq.app.MobileQQ;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginHelper;
import org.json.JSONException;
import org.json.JSONObject;

public class autg
  extends WebViewPlugin
{
  protected aqyp a;
  private bgzi jdField_a_of_type_Bgzi;
  private bgzs jdField_a_of_type_Bgzs;
  private bgzu jdField_a_of_type_Bgzu;
  private bgzw jdField_a_of_type_Bgzw;
  CookieManager jdField_a_of_type_ComTencentSmttSdkCookieManager;
  nko jdField_a_of_type_Nko;
  zon jdField_a_of_type_Zon;
  
  public autg()
  {
    this.jdField_a_of_type_Aqyp = new auth(this);
    this.mPluginNameSpace = "data";
  }
  
  private void a(String paramString)
  {
    Object localObject = this.mRuntime.a();
    if ((TextUtils.isEmpty(paramString)) || (!((AppInterface)localObject).isLogin())) {}
    String str1;
    do
    {
      do
      {
        return;
        str1 = ((AppInterface)localObject).getAccount();
        localObject = CookieManager.getInstance().getCookie(paramString);
      } while ((TextUtils.isEmpty((CharSequence)localObject)) || (((String)localObject).contains("uin=")));
      String str2 = SwiftBrowserCookieMonster.a(str1);
      str1 = npn.b(paramString);
      QLog.e("DataApiPlugin", 1, "can not find uin from " + npn.b(paramString, new String[0]) + ", dump cookie: " + npn.c((String)localObject, new String[0]));
      if (this.jdField_a_of_type_ComTencentSmttSdkCookieManager == null)
      {
        this.jdField_a_of_type_ComTencentSmttSdkCookieManager = CookieManager.getInstance();
        this.jdField_a_of_type_ComTencentSmttSdkCookieManager.setAcceptCookie(true);
      }
      localObject = String.format("%s=%s; PATH=/; DOMAIN=.%s; Max-Age=21600;", new Object[] { "uin", str2, str1 });
      this.jdField_a_of_type_ComTencentSmttSdkCookieManager.setCookie(paramString, (String)localObject);
    } while (!QLog.isColorLevel());
    QLog.i("DataApiPlugin", 2, "set uin cookie for host " + str1 + ", cookie : " + npn.c((String)localObject, new String[0]));
  }
  
  private void a(String paramString, String[] paramArrayOfString)
  {
    int i = 0;
    long l = 0L;
    String str = null;
    if ((this.jdField_a_of_type_Bgzs != null) && (this.jdField_a_of_type_Bgzw != null))
    {
      i = this.jdField_a_of_type_Bgzs.a();
      l = this.jdField_a_of_type_Bgzw.getmClickTime();
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramArrayOfString[0]);
      int j = localJSONObject.getJSONObject("data").getInt("status");
      paramArrayOfString = "onFirstLine";
      paramString = "state_activity_first_line";
      if ((j != 12) && (j != 13))
      {
        if (str != null) {
          str.c(paramString);
        }
        if ((i < j) && (this.jdField_a_of_type_Bgzu != null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQBrowser_report", 2, "try report web status, " + paramArrayOfString + ", step: " + j + ", stepTime: " + (System.currentTimeMillis() - l) + ", totalTime: " + (System.currentTimeMillis() - l) + ", \n " + this.jdField_a_of_type_Bgzu.getCurrentUrl());
          }
          if (this.jdField_a_of_type_Bgzs == null) {
            break label305;
          }
          this.jdField_a_of_type_Bgzs.a(j);
          this.jdField_a_of_type_Bgzs.a(System.currentTimeMillis());
        }
        label232:
        while (str == null)
        {
          paramString = localJSONObject.optString("callback");
          if (!TextUtils.isEmpty(paramString)) {
            callJs(paramString, new String[] { "{\"result\": 0}" });
          }
          return;
          paramString = (bgxd)super.getBrowserComponent(-2);
          str = paramString;
          if (paramString == null) {
            break;
          }
          i = paramString.a.jdField_a_of_type_Int;
          l = paramString.b;
          str = paramString;
          break;
          paramArrayOfString = "onPageFinished";
          break label441;
        }
        label299:
        label305:
        str.a.jdField_a_of_type_Int = j;
        str.a.jdField_a_of_type_Long = System.currentTimeMillis();
        switch (j)
        {
        }
      }
      for (;;)
      {
        str.ac = (str.a.jdField_a_of_type_Long - l);
        break label232;
        str.ad = (str.a.jdField_a_of_type_Long - l);
        break label232;
        str.ae = (str.a.jdField_a_of_type_Long - l);
        str.a.a(this.jdField_a_of_type_Bgzu.getCurrentUrl());
        break label232;
        if (j != 12) {
          break label299;
        }
        paramArrayOfString = "onPageVisible";
        label441:
        if (j == 12)
        {
          paramString = "state_first_screen";
          break;
        }
        paramString = "state_page_finished";
        break;
      }
      return;
    }
    catch (JSONException paramString) {}
  }
  
  private void c(String paramString1, String paramString2)
  {
    Object localObject = this.mRuntime.a();
    if ((TextUtils.isEmpty(paramString1)) || (!((AppInterface)localObject).isLogin())) {}
    do
    {
      do
      {
        return;
        str = ((AppInterface)localObject).getAccount();
        localObject = CookieManager.getInstance().getCookie(paramString1);
      } while ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty((CharSequence)localObject)) || (((String)localObject).contains("p_uin=")));
      String str = SwiftBrowserCookieMonster.a(str);
      QLog.e("DataApiPlugin", 1, "can not find p_uin from " + npn.b(paramString1, new String[0]) + ", dump cookie: " + npn.c((String)localObject, new String[0]));
      if (this.jdField_a_of_type_ComTencentSmttSdkCookieManager == null)
      {
        this.jdField_a_of_type_ComTencentSmttSdkCookieManager = CookieManager.getInstance();
        this.jdField_a_of_type_ComTencentSmttSdkCookieManager.setAcceptCookie(true);
      }
      localObject = String.format("%s=%s; PATH=/; DOMAIN=.%s; Max-Age=21600;", new Object[] { "p_uin", str, paramString2 });
      this.jdField_a_of_type_ComTencentSmttSdkCookieManager.setCookie(paramString1, (String)localObject);
    } while (!QLog.isColorLevel());
    QLog.i("DataApiPlugin", 2, "set p_uin cookie for host " + paramString2 + ", cookie: " + npn.c((String)localObject, new String[0]));
  }
  
  public void a(String paramString1, String paramString2)
  {
    String str1;
    int i;
    String str2;
    JSONObject localJSONObject;
    String str3;
    SharedPreferences localSharedPreferences;
    SharedPreferences.Editor localEditor;
    Object localObject1;
    int k;
    int j;
    String str4;
    try
    {
      str1 = bghb.a(this.mRuntime.a(), "ticketInterval");
      if (TextUtils.isEmpty(str1)) {
        break label998;
      }
      i = Integer.parseInt(str1);
      localObject2 = new JSONObject(paramString1);
      str2 = ((JSONObject)localObject2).optString("callback");
      localJSONObject = new JSONObject();
      if (!this.mRuntime.a().isLogin())
      {
        localJSONObject.put("result", -2);
        localJSONObject.put("message", amtj.a(2131701869));
        callJs(str2, new String[] { localJSONObject.toString() });
        return;
      }
      str3 = this.mRuntime.a().getCurrentAccountUin();
      localSharedPreferences = this.mRuntime.a().getApplication().getSharedPreferences(str3 + "_get_ticket_interval", 0);
      localEditor = localSharedPreferences.edit();
      if (this.jdField_a_of_type_ComTencentSmttSdkCookieManager == null)
      {
        this.jdField_a_of_type_ComTencentSmttSdkCookieManager = CookieManager.getInstance();
        this.jdField_a_of_type_ComTencentSmttSdkCookieManager.setAcceptCookie(true);
      }
      if (this.jdField_a_of_type_Nko == null) {
        this.jdField_a_of_type_Nko = nko.a();
      }
      str1 = null;
      localObject1 = null;
      paramString1 = null;
      k = 0;
      j = 0;
      str4 = ((JSONObject)localObject2).optString("key");
      if (!TextUtils.isEmpty(str4)) {
        break label320;
      }
      localJSONObject.put("result", -2);
      localJSONObject.put("message", "参数key为空");
      callJs(str2, new String[] { localJSONObject.toString() });
      return;
    }
    catch (Exception paramString1)
    {
      if (!QLog.isColorLevel()) {
        break label1005;
      }
    }
    QLog.e("DataApiPlugin", 2, "updateLoginInfo error: " + paramString1.getMessage());
    return;
    label320:
    Object localObject2 = new WUserSigInfo();
    long l;
    if ("skey".equals(str4))
    {
      l = localSharedPreferences.getLong("skey", 0L);
      if (System.currentTimeMillis() - l > i * 1000)
      {
        localEditor.putLong("skey", System.currentTimeMillis());
        localEditor.commit();
        i = j;
        if (!this.jdField_a_of_type_Nko.a(paramString2)) {
          break label1006;
        }
        i = 4096;
        break label1006;
      }
    }
    label998:
    label1005:
    label1006:
    label1009:
    for (;;)
    {
      if (i == 0)
      {
        localJSONObject.put("result", -2);
        localJSONObject.put("message", amtj.a(2131701871));
        callJs(str2, new String[] { localJSONObject.toString() });
        return;
        localJSONObject.put("result", 1);
        localJSONObject.put("message", amtj.a(2131701870));
        callJs(str2, new String[] { localJSONObject.toString() });
        return;
        if ("pskey".equals(str4))
        {
          str1 = this.jdField_a_of_type_Nko.d(paramString2);
          l = localSharedPreferences.getLong("pskey_" + str1, 0L);
          if (System.currentTimeMillis() - l > i * 1000)
          {
            localEditor.putLong("pskey_" + str1, System.currentTimeMillis());
            localEditor.commit();
            i = k;
            if (TextUtils.isEmpty(str1)) {
              break label1009;
            }
            ((WUserSigInfo)localObject2)._domains.add(str1);
            i = 1048576;
            break label1009;
          }
          localJSONObject.put("result", 1);
          localJSONObject.put("message", amtj.a(2131701872));
          callJs(str2, new String[] { localJSONObject.toString() });
          return;
        }
        paramString1 = (String)localObject1;
        if ("pt4_token".equals(str4))
        {
          localObject1 = this.jdField_a_of_type_Nko.e(paramString2);
          l = localSharedPreferences.getLong("pt4_token_" + (String)localObject1, 0L);
          if (System.currentTimeMillis() - l > i * 1000)
          {
            localEditor.putLong("pt4_token_" + (String)localObject1, System.currentTimeMillis());
            localEditor.commit();
            paramString1 = (String)localObject1;
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              ((WUserSigInfo)localObject2)._domains.add(String.format(Locale.getDefault(), "(%d)%s", new Object[] { Integer.valueOf(134217728), localObject1 }));
              i = 135266304;
              paramString1 = (String)localObject1;
            }
          }
          else
          {
            localJSONObject.put("result", 1);
            localJSONObject.put("message", amtj.a(2131701873));
            callJs(str2, new String[] { localJSONObject.toString() });
          }
        }
      }
      else
      {
        QLog.d("DataApiPlugin", 1, "GetStWithoutPasswd|key=" + i);
        localObject1 = new WtloginHelper(this.mRuntime.a().getApplication());
        ((WtloginHelper)localObject1).setCallSource(30);
        ((WtloginHelper)localObject1).SetListener(new auti(this, paramString2, str2, str1, paramString1));
        ((WtloginHelper)localObject1).GetStWithoutPasswd(str3, 16L, 16L, 1L, i, (WUserSigInfo)localObject2);
        return;
      }
      i = 0;
      continue;
      i = 28800;
      break;
      return;
    }
  }
  
  void a(String paramString1, WUserSigInfo paramWUserSigInfo, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    if (paramWUserSigInfo == null)
    {
      b(paramString2, "get WUserSigInfo = null");
      return;
    }
    int i = 0;
    int j = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    String str = npn.a(paramString1, 1);
    Object localObject2;
    Object localObject3;
    Object localObject1;
    if ((paramInt & 0x1000) != 0)
    {
      localObject2 = null;
      localObject3 = WtloginHelper.GetUserSigInfoTicket(paramWUserSigInfo, 4096);
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject1 = localObject2;
        if (((Ticket)localObject3)._sig != null) {
          localObject1 = new String(((Ticket)localObject3)._sig);
        }
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label404;
      }
      j = -2;
      localStringBuilder.append("skey获取失败;");
      label112:
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label444;
      }
      QLog.i("DataApiPlugin", 1, npn.c("skey=" + (String)localObject1, new String[0]));
      label154:
      i = j;
      if (localObject3 != null)
      {
        QLog.i("DataApiPlugin", 1, "last refresh skey time: " + ((Ticket)localObject3)._create_time);
        localStringBuilder.append("skey create time: " + ((Ticket)localObject3)._create_time);
        i = j;
      }
    }
    if (((0x100000 & paramInt) != 0) && ((0x8000000 & paramInt) == 0))
    {
      localObject2 = WtloginHelper.GetUserSigInfoTicket(paramWUserSigInfo, 1048576);
      if ((localObject2 == null) || (((Ticket)localObject2)._pskey_map == null))
      {
        i = -2;
        localStringBuilder.append("pskey获取失败;Ticket = null or ticket._pskey_map = null");
        label280:
        if ((0x8000000 & paramInt) == 0) {
          break label812;
        }
        paramWUserSigInfo = WtloginHelper.GetUserSigInfoTicket(paramWUserSigInfo, 1048576);
        if (paramWUserSigInfo != null) {
          break label662;
        }
        paramInt = -2;
        localStringBuilder.append("pt4token获取失败;Ticket = null");
      }
    }
    for (;;)
    {
      try
      {
        paramString1 = new JSONObject();
        paramString1.put("result", paramInt);
        if (paramInt < 0) {
          paramString1.put("message", localStringBuilder.toString());
        }
        callJs(paramString2, new String[] { paramString1.toString() });
        return;
      }
      catch (Exception paramString1) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("DataApiPlugin", 2, "updateLoginInfo error: " + paramString1.getMessage());
      return;
      label404:
      localObject2 = String.format("skey=%1$s; PATH=/; DOMAIN=.%2$s;", new Object[] { localObject1, str });
      this.jdField_a_of_type_ComTencentSmttSdkCookieManager.setCookie(paramString1, (String)localObject2);
      a(paramString1);
      break label112;
      label444:
      QLog.e("DataApiPlugin", 1, "skey is null!");
      break label154;
      localObject3 = (byte[])((Ticket)localObject2)._pskey_map.get(paramString3);
      localObject1 = new String();
      if (localObject3 != null) {
        localObject1 = new String((byte[])localObject3);
      }
      for (;;)
      {
        QLog.i("DataApiPlugin", 1, "last refresh pskey time: " + ((Ticket)localObject2)._create_time);
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label603;
        }
        i = -2;
        localStringBuilder.append("pskey获取失败;pskey = null, create time: " + ((Ticket)localObject2)._create_time);
        break;
        QLog.e("DataApiPlugin", 1, "onDoneGetTicket pskey_map not contain domain: " + paramString3);
      }
      label603:
      localObject1 = "p_skey=" + (String)localObject1 + "; PATH=/; DOMAIN=." + paramString3 + ';';
      this.jdField_a_of_type_ComTencentSmttSdkCookieManager.setCookie(paramString1, (String)localObject1);
      c(paramString1, paramString3);
      break label280;
      label662:
      paramString3 = new String((byte[])paramWUserSigInfo._pt4token_map.get(paramString4));
      QLog.i("DataApiPlugin", 1, "last refresh pt4token time: " + paramWUserSigInfo._create_time);
      if (TextUtils.isEmpty(paramString3))
      {
        paramInt = -2;
        localStringBuilder.append("pt4token获取失败;pt4token = null, create time: " + paramWUserSigInfo._create_time);
      }
      for (;;)
      {
        paramWUserSigInfo = "pt4_token=" + paramString3 + "; PATH=/; DOMAIN=." + paramString4 + ';';
        this.jdField_a_of_type_ComTencentSmttSdkCookieManager.setCookie(paramString1, paramWUserSigInfo);
        break;
        paramInt = i;
      }
      label812:
      paramInt = i;
    }
  }
  
  void b(String paramString1, String paramString2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("result", -2);
      localJSONObject.put("message", paramString2);
      callJs(paramString1, new String[] { localJSONObject.toString() });
      return;
    }
    catch (Exception paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("DataApiPlugin", 2, "updateLoginInfo error: " + paramString1.getMessage());
    }
  }
  
  /* Error */
  public boolean handleJsRequest(com.tencent.mobileqq.webview.swift.JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    // Byte code:
    //   0: ldc 26
    //   2: aload_3
    //   3: invokevirtual 355	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6: ifeq +5012 -> 5018
    //   9: ldc_w 520
    //   12: aload 4
    //   14: invokevirtual 355	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   17: ifeq +1145 -> 1162
    //   20: aload 5
    //   22: arraylength
    //   23: iconst_1
    //   24: if_icmpne +1138 -> 1162
    //   27: new 161	org/json/JSONObject
    //   30: dup
    //   31: aload 5
    //   33: iconst_0
    //   34: aaload
    //   35: invokespecial 163	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   38: ldc 222
    //   40: invokevirtual 225	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   43: astore 11
    //   45: aload_0
    //   46: getfield 36	autg:mRuntime	Lbgve;
    //   49: invokevirtual 523	bgve:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   52: invokevirtual 528	com/tencent/biz/pubaccount/CustomWebView:getUrl	()Ljava/lang/String;
    //   55: astore 5
    //   57: aload 5
    //   59: ifnull +5014 -> 5073
    //   62: aload 5
    //   64: ldc_w 530
    //   67: invokevirtual 533	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   70: ifeq +5003 -> 5073
    //   73: aload 5
    //   75: invokestatic 537	nny:c	(Ljava/lang/String;)Ljava/lang/String;
    //   78: astore 5
    //   80: aload_0
    //   81: getfield 36	autg:mRuntime	Lbgve;
    //   84: invokevirtual 41	bgve:a	()Lcom/tencent/common/app/AppInterface;
    //   87: astore 17
    //   89: aload 5
    //   91: invokestatic 47	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   94: ifne +11 -> 105
    //   97: aload 17
    //   99: invokevirtual 53	com/tencent/common/app/AppInterface:isLogin	()Z
    //   102: ifne +29 -> 131
    //   105: aload 11
    //   107: invokestatic 47	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   110: ifne +21 -> 131
    //   113: aload_0
    //   114: aload 11
    //   116: iconst_1
    //   117: anewarray 71	java/lang/String
    //   120: dup
    //   121: iconst_0
    //   122: ldc_w 539
    //   125: aastore
    //   126: invokevirtual 230	autg:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   129: iconst_1
    //   130: ireturn
    //   131: aload_0
    //   132: getfield 332	autg:jdField_a_of_type_Nko	Lnko;
    //   135: ifnonnull +10 -> 145
    //   138: aload_0
    //   139: invokestatic 337	nko:a	()Lnko;
    //   142: putfield 332	autg:jdField_a_of_type_Nko	Lnko;
    //   145: aload_0
    //   146: getfield 332	autg:jdField_a_of_type_Nko	Lnko;
    //   149: aload 5
    //   151: invokevirtual 540	nko:a	(Ljava/lang/String;)Ljava/lang/String;
    //   154: invokestatic 47	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   157: ifne +915 -> 1072
    //   160: iconst_1
    //   161: istore 6
    //   163: aload_0
    //   164: getfield 332	autg:jdField_a_of_type_Nko	Lnko;
    //   167: aload 5
    //   169: invokevirtual 371	nko:a	(Ljava/lang/String;)Z
    //   172: istore 9
    //   174: aload_0
    //   175: getfield 332	autg:jdField_a_of_type_Nko	Lnko;
    //   178: aload 5
    //   180: invokevirtual 543	nko:f	(Ljava/lang/String;)Ljava/lang/String;
    //   183: astore 13
    //   185: aload_0
    //   186: getfield 332	autg:jdField_a_of_type_Nko	Lnko;
    //   189: aload 5
    //   191: invokevirtual 394	nko:e	(Ljava/lang/String;)Ljava/lang/String;
    //   194: astore 16
    //   196: aload_0
    //   197: getfield 332	autg:jdField_a_of_type_Nko	Lnko;
    //   200: aload 5
    //   202: invokevirtual 377	nko:d	(Ljava/lang/String;)Ljava/lang/String;
    //   205: astore 18
    //   207: aload 17
    //   209: iconst_2
    //   210: invokevirtual 547	com/tencent/common/app/AppInterface:getManager	(I)Lmqq/manager/Manager;
    //   213: checkcast 549	mqq/manager/TicketManager
    //   216: astore 14
    //   218: new 161	org/json/JSONObject
    //   221: dup
    //   222: invokespecial 291	org/json/JSONObject:<init>	()V
    //   225: astore 12
    //   227: aload 17
    //   229: invokevirtual 57	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   232: astore 15
    //   234: aload 12
    //   236: ldc 123
    //   238: aload 15
    //   240: invokevirtual 308	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   243: pop
    //   244: aload 17
    //   246: invokevirtual 316	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   249: new 87	java/lang/StringBuilder
    //   252: dup
    //   253: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   256: getstatic 555	mqq/app/Constants$PropertiesKey:nickName	Lmqq/app/Constants$PropertiesKey;
    //   259: invokevirtual 556	mqq/app/Constants$PropertiesKey:toString	()Ljava/lang/String;
    //   262: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: aload 15
    //   267: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   273: invokevirtual 559	mqq/app/MobileQQ:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   276: astore_1
    //   277: aload_1
    //   278: invokestatic 47	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   281: ifeq +4787 -> 5068
    //   284: invokestatic 565	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   287: invokevirtual 571	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   290: astore_2
    //   291: aload_2
    //   292: new 87	java/lang/StringBuilder
    //   295: dup
    //   296: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   299: ldc_w 573
    //   302: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: aload 15
    //   307: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   313: invokestatic 579	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   316: aconst_null
    //   317: ldc_w 581
    //   320: iconst_1
    //   321: anewarray 71	java/lang/String
    //   324: dup
    //   325: iconst_0
    //   326: aload 15
    //   328: aastore
    //   329: aconst_null
    //   330: invokevirtual 587	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   333: astore_2
    //   334: aload_2
    //   335: ifnull +4727 -> 5062
    //   338: aload_2
    //   339: astore_3
    //   340: aload_2
    //   341: invokeinterface 592 1 0
    //   346: ifeq +4716 -> 5062
    //   349: aload_2
    //   350: astore_3
    //   351: aload_2
    //   352: aload_2
    //   353: ldc_w 594
    //   356: invokeinterface 597 2 0
    //   361: invokeinterface 600 2 0
    //   366: astore 4
    //   368: aload_2
    //   369: astore_3
    //   370: aload 4
    //   372: invokestatic 47	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   375: ifne +4684 -> 5059
    //   378: aload_2
    //   379: astore_3
    //   380: new 71	java/lang/String
    //   383: dup
    //   384: aload 4
    //   386: invokevirtual 604	java/lang/String:getBytes	()[B
    //   389: ldc_w 606
    //   392: invokespecial 609	java/lang/String:<init>	([BLjava/lang/String;)V
    //   395: invokestatic 614	com/tencent/mobileqq/utils/SecurityUtile:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   398: astore 4
    //   400: aload 4
    //   402: astore_1
    //   403: aload_1
    //   404: astore 4
    //   406: aload_2
    //   407: astore_3
    //   408: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   411: ifeq +34 -> 445
    //   414: aload_2
    //   415: astore_3
    //   416: ldc 85
    //   418: iconst_2
    //   419: new 87	java/lang/StringBuilder
    //   422: dup
    //   423: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   426: ldc_w 616
    //   429: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: aload_1
    //   433: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   439: invokestatic 141	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   442: aload_1
    //   443: astore 4
    //   445: aload 4
    //   447: astore_3
    //   448: aload_2
    //   449: ifnull +12 -> 461
    //   452: aload_2
    //   453: invokeinterface 619 1 0
    //   458: aload 4
    //   460: astore_3
    //   461: aload 12
    //   463: ldc_w 621
    //   466: aload_3
    //   467: invokevirtual 308	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   470: pop
    //   471: iload 6
    //   473: ifeq +3 -> 476
    //   476: iload 9
    //   478: ifeq +566 -> 1044
    //   481: aload_0
    //   482: aload 5
    //   484: invokespecial 482	autg:a	(Ljava/lang/String;)V
    //   487: aload 5
    //   489: invokestatic 83	npn:b	(Ljava/lang/String;)Ljava/lang/String;
    //   492: astore_1
    //   493: aload_0
    //   494: getfield 113	autg:jdField_a_of_type_ComTencentSmttSdkCookieManager	Lcom/tencent/smtt/sdk/CookieManager;
    //   497: ifnonnull +18 -> 515
    //   500: aload_0
    //   501: invokestatic 63	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   504: putfield 113	autg:jdField_a_of_type_ComTencentSmttSdkCookieManager	Lcom/tencent/smtt/sdk/CookieManager;
    //   507: aload_0
    //   508: getfield 113	autg:jdField_a_of_type_ComTencentSmttSdkCookieManager	Lcom/tencent/smtt/sdk/CookieManager;
    //   511: iconst_1
    //   512: invokevirtual 117	com/tencent/smtt/sdk/CookieManager:setAcceptCookie	(Z)V
    //   515: aload 14
    //   517: aload 15
    //   519: invokeinterface 624 2 0
    //   524: astore_2
    //   525: aload 12
    //   527: ldc_w 351
    //   530: aload_2
    //   531: invokevirtual 308	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   534: pop
    //   535: aload_2
    //   536: invokestatic 47	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   539: ifne +89 -> 628
    //   542: ldc_w 481
    //   545: iconst_2
    //   546: anewarray 121	java/lang/Object
    //   549: dup
    //   550: iconst_0
    //   551: aload_2
    //   552: aastore
    //   553: dup
    //   554: iconst_1
    //   555: aload_1
    //   556: aastore
    //   557: invokestatic 127	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   560: astore_1
    //   561: aload_0
    //   562: getfield 113	autg:jdField_a_of_type_ComTencentSmttSdkCookieManager	Lcom/tencent/smtt/sdk/CookieManager;
    //   565: aload 5
    //   567: aload_1
    //   568: invokevirtual 131	com/tencent/smtt/sdk/CookieManager:setCookie	(Ljava/lang/String;Ljava/lang/String;)V
    //   571: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   574: ifeq +54 -> 628
    //   577: ldc 85
    //   579: iconst_2
    //   580: new 87	java/lang/StringBuilder
    //   583: dup
    //   584: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   587: ldc_w 626
    //   590: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   593: aload_1
    //   594: iconst_0
    //   595: anewarray 71	java/lang/String
    //   598: invokestatic 102	npn:c	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   601: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   604: ldc_w 628
    //   607: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   610: aload 5
    //   612: iconst_0
    //   613: anewarray 71	java/lang/String
    //   616: invokestatic 97	npn:b	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   619: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   622: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   625: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   628: aload 18
    //   630: invokestatic 47	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   633: ifne +144 -> 777
    //   636: aload_0
    //   637: aload 5
    //   639: aload 18
    //   641: invokespecial 507	autg:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   644: aload 14
    //   646: aload 15
    //   648: aload 18
    //   650: invokeinterface 632 3 0
    //   655: astore_1
    //   656: aload_1
    //   657: invokestatic 47	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   660: ifne +117 -> 777
    //   663: aload 12
    //   665: ldc_w 634
    //   668: aload_1
    //   669: invokevirtual 308	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   672: pop
    //   673: new 87	java/lang/StringBuilder
    //   676: dup
    //   677: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   680: ldc_w 500
    //   683: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   686: aload_1
    //   687: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   690: ldc_w 502
    //   693: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   696: aload 18
    //   698: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   701: bipush 59
    //   703: invokevirtual 505	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   706: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   709: astore_1
    //   710: aload_0
    //   711: getfield 113	autg:jdField_a_of_type_ComTencentSmttSdkCookieManager	Lcom/tencent/smtt/sdk/CookieManager;
    //   714: aload 5
    //   716: aload_1
    //   717: invokevirtual 131	com/tencent/smtt/sdk/CookieManager:setCookie	(Ljava/lang/String;Ljava/lang/String;)V
    //   720: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   723: ifeq +54 -> 777
    //   726: ldc 85
    //   728: iconst_2
    //   729: new 87	java/lang/StringBuilder
    //   732: dup
    //   733: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   736: ldc_w 626
    //   739: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   742: aload_1
    //   743: iconst_0
    //   744: anewarray 71	java/lang/String
    //   747: invokestatic 102	npn:c	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   750: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   753: ldc_w 628
    //   756: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   759: aload 5
    //   761: iconst_0
    //   762: anewarray 71	java/lang/String
    //   765: invokestatic 97	npn:b	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   768: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   771: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   774: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   777: aload 16
    //   779: invokestatic 47	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   782: ifne +132 -> 914
    //   785: aload 17
    //   787: aload 16
    //   789: invokestatic 636	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:b	(Lmqq/app/AppRuntime;Ljava/lang/String;)Ljava/lang/String;
    //   792: astore_1
    //   793: aload_1
    //   794: invokestatic 47	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   797: ifne +117 -> 914
    //   800: aload 12
    //   802: ldc_w 392
    //   805: aload_1
    //   806: invokevirtual 308	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   809: pop
    //   810: new 87	java/lang/StringBuilder
    //   813: dup
    //   814: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   817: ldc_w 516
    //   820: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   823: aload_1
    //   824: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   827: ldc_w 502
    //   830: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   833: aload 16
    //   835: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   838: bipush 59
    //   840: invokevirtual 505	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   843: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   846: astore_1
    //   847: aload_0
    //   848: getfield 113	autg:jdField_a_of_type_ComTencentSmttSdkCookieManager	Lcom/tencent/smtt/sdk/CookieManager;
    //   851: aload 5
    //   853: aload_1
    //   854: invokevirtual 131	com/tencent/smtt/sdk/CookieManager:setCookie	(Ljava/lang/String;Ljava/lang/String;)V
    //   857: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   860: ifeq +54 -> 914
    //   863: ldc 85
    //   865: iconst_2
    //   866: new 87	java/lang/StringBuilder
    //   869: dup
    //   870: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   873: ldc_w 626
    //   876: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   879: aload_1
    //   880: iconst_0
    //   881: anewarray 71	java/lang/String
    //   884: invokestatic 102	npn:c	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   887: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   890: ldc_w 628
    //   893: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   896: aload 5
    //   898: iconst_0
    //   899: anewarray 71	java/lang/String
    //   902: invokestatic 97	npn:b	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   905: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   908: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   911: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   914: aload 13
    //   916: invokestatic 47	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   919: ifne +125 -> 1044
    //   922: aload 14
    //   924: aload 15
    //   926: invokeinterface 639 2 0
    //   931: astore_1
    //   932: aload_1
    //   933: invokestatic 47	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   936: ifne +108 -> 1044
    //   939: new 87	java/lang/StringBuilder
    //   942: dup
    //   943: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   946: ldc_w 641
    //   949: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   952: aload_1
    //   953: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   956: ldc_w 502
    //   959: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   962: aload 13
    //   964: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   967: ldc_w 643
    //   970: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   973: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   976: astore_1
    //   977: aload_0
    //   978: getfield 113	autg:jdField_a_of_type_ComTencentSmttSdkCookieManager	Lcom/tencent/smtt/sdk/CookieManager;
    //   981: aload 5
    //   983: aload_1
    //   984: invokevirtual 131	com/tencent/smtt/sdk/CookieManager:setCookie	(Ljava/lang/String;Ljava/lang/String;)V
    //   987: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   990: ifeq +54 -> 1044
    //   993: ldc 85
    //   995: iconst_2
    //   996: new 87	java/lang/StringBuilder
    //   999: dup
    //   1000: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   1003: ldc_w 626
    //   1006: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1009: aload_1
    //   1010: iconst_0
    //   1011: anewarray 71	java/lang/String
    //   1014: invokestatic 102	npn:c	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   1017: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1020: ldc_w 628
    //   1023: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1026: aload 5
    //   1028: iconst_0
    //   1029: anewarray 71	java/lang/String
    //   1032: invokestatic 97	npn:b	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   1035: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1038: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1041: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1044: aload 11
    //   1046: invokestatic 47	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1049: ifne +21 -> 1070
    //   1052: aload_0
    //   1053: aload 11
    //   1055: iconst_1
    //   1056: anewarray 71	java/lang/String
    //   1059: dup
    //   1060: iconst_0
    //   1061: aload 12
    //   1063: invokevirtual 309	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1066: aastore
    //   1067: invokevirtual 230	autg:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1070: iconst_1
    //   1071: ireturn
    //   1072: iconst_0
    //   1073: istore 6
    //   1075: goto -912 -> 163
    //   1078: astore 4
    //   1080: aconst_null
    //   1081: astore_2
    //   1082: aload_2
    //   1083: astore_3
    //   1084: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1087: ifeq +35 -> 1122
    //   1090: aload_2
    //   1091: astore_3
    //   1092: ldc 85
    //   1094: iconst_2
    //   1095: new 87	java/lang/StringBuilder
    //   1098: dup
    //   1099: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   1102: ldc_w 645
    //   1105: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1108: aload 4
    //   1110: invokestatic 649	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1113: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1116: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1119: invokestatic 111	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1122: aload_1
    //   1123: astore_3
    //   1124: aload_2
    //   1125: ifnull -664 -> 461
    //   1128: aload_2
    //   1129: invokeinterface 619 1 0
    //   1134: aload_1
    //   1135: astore_3
    //   1136: goto -675 -> 461
    //   1139: astore_1
    //   1140: aload_1
    //   1141: invokevirtual 652	org/json/JSONException:printStackTrace	()V
    //   1144: goto -74 -> 1070
    //   1147: astore_1
    //   1148: aconst_null
    //   1149: astore_3
    //   1150: aload_3
    //   1151: ifnull +9 -> 1160
    //   1154: aload_3
    //   1155: invokeinterface 619 1 0
    //   1160: aload_1
    //   1161: athrow
    //   1162: ldc_w 654
    //   1165: aload 4
    //   1167: invokevirtual 355	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1170: ifeq +35 -> 1205
    //   1173: new 656	com/tencent/mobileqq/jsp/DataApiPlugin$2
    //   1176: dup
    //   1177: aload_0
    //   1178: aload 5
    //   1180: iconst_0
    //   1181: aaload
    //   1182: aload_0
    //   1183: getfield 36	autg:mRuntime	Lbgve;
    //   1186: invokevirtual 523	bgve:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   1189: invokevirtual 528	com/tencent/biz/pubaccount/CustomWebView:getUrl	()Ljava/lang/String;
    //   1192: invokespecial 659	com/tencent/mobileqq/jsp/DataApiPlugin$2:<init>	(Lautg;Ljava/lang/String;Ljava/lang/String;)V
    //   1195: bipush 8
    //   1197: aconst_null
    //   1198: iconst_1
    //   1199: invokestatic 665	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1202: goto -132 -> 1070
    //   1205: ldc_w 667
    //   1208: aload 4
    //   1210: invokevirtual 355	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1213: ifeq +259 -> 1472
    //   1216: aload_0
    //   1217: getfield 36	autg:mRuntime	Lbgve;
    //   1220: invokevirtual 670	bgve:a	()Landroid/app/Activity;
    //   1223: invokevirtual 676	android/app/Activity:getIntent	()Landroid/content/Intent;
    //   1226: astore_1
    //   1227: aload_1
    //   1228: ldc_w 678
    //   1231: iconst_m1
    //   1232: invokevirtual 684	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1235: istore 6
    //   1237: new 161	org/json/JSONObject
    //   1240: dup
    //   1241: invokespecial 291	org/json/JSONObject:<init>	()V
    //   1244: astore_2
    //   1245: aload_0
    //   1246: getfield 36	autg:mRuntime	Lbgve;
    //   1249: invokevirtual 41	bgve:a	()Lcom/tencent/common/app/AppInterface;
    //   1252: invokevirtual 57	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   1255: astore_3
    //   1256: new 161	org/json/JSONObject
    //   1259: dup
    //   1260: aload 5
    //   1262: iconst_0
    //   1263: aaload
    //   1264: invokespecial 163	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1267: ldc 222
    //   1269: invokevirtual 225	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1272: astore 4
    //   1274: aload_2
    //   1275: ldc 123
    //   1277: aload_3
    //   1278: invokevirtual 308	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1281: pop
    //   1282: iload 6
    //   1284: iconst_m1
    //   1285: if_icmpne +62 -> 1347
    //   1288: aload_2
    //   1289: ldc_w 686
    //   1292: ldc_w 688
    //   1295: invokevirtual 308	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1298: pop
    //   1299: aload 4
    //   1301: invokestatic 47	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1304: ifne -234 -> 1070
    //   1307: aload_0
    //   1308: aload 4
    //   1310: iconst_1
    //   1311: anewarray 71	java/lang/String
    //   1314: dup
    //   1315: iconst_0
    //   1316: aload_2
    //   1317: invokevirtual 309	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1320: aastore
    //   1321: invokevirtual 230	autg:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1324: goto -254 -> 1070
    //   1327: astore_1
    //   1328: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1331: ifeq -261 -> 1070
    //   1334: ldc 85
    //   1336: iconst_2
    //   1337: ldc_w 690
    //   1340: aload_1
    //   1341: invokestatic 694	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1344: goto -274 -> 1070
    //   1347: iload 6
    //   1349: iconst_1
    //   1350: if_icmpne +47 -> 1397
    //   1353: aload_2
    //   1354: ldc_w 696
    //   1357: aload_1
    //   1358: ldc_w 698
    //   1361: invokevirtual 701	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1364: invokevirtual 308	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1367: pop
    //   1368: aload_2
    //   1369: ldc_w 686
    //   1372: ldc_w 703
    //   1375: invokevirtual 308	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1378: pop
    //   1379: aload_2
    //   1380: ldc_w 705
    //   1383: aload_1
    //   1384: ldc_w 707
    //   1387: invokevirtual 701	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1390: invokevirtual 308	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1393: pop
    //   1394: goto -95 -> 1299
    //   1397: iload 6
    //   1399: sipush 3000
    //   1402: if_icmpne +32 -> 1434
    //   1405: aload_2
    //   1406: ldc_w 709
    //   1409: aload_1
    //   1410: ldc_w 709
    //   1413: invokevirtual 701	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1416: invokevirtual 308	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1419: pop
    //   1420: aload_2
    //   1421: ldc_w 686
    //   1424: ldc_w 711
    //   1427: invokevirtual 308	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1430: pop
    //   1431: goto -52 -> 1379
    //   1434: aload_1
    //   1435: ldc_w 713
    //   1438: invokevirtual 701	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1441: astore_3
    //   1442: aload_3
    //   1443: invokestatic 47	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1446: ifne +12 -> 1458
    //   1449: aload_2
    //   1450: ldc_w 713
    //   1453: aload_3
    //   1454: invokevirtual 308	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1457: pop
    //   1458: aload_2
    //   1459: ldc_w 686
    //   1462: ldc_w 715
    //   1465: invokevirtual 308	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1468: pop
    //   1469: goto -90 -> 1379
    //   1472: ldc_w 717
    //   1475: aload 4
    //   1477: invokevirtual 355	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1480: ifeq +102 -> 1582
    //   1483: new 161	org/json/JSONObject
    //   1486: dup
    //   1487: aload 5
    //   1489: iconst_0
    //   1490: aaload
    //   1491: invokespecial 163	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1494: astore_2
    //   1495: aload_2
    //   1496: ldc 222
    //   1498: invokevirtual 225	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1501: astore_1
    //   1502: aload_2
    //   1503: ldc 123
    //   1505: invokevirtual 225	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1508: astore_2
    //   1509: aload_2
    //   1510: aload_0
    //   1511: getfield 36	autg:mRuntime	Lbgve;
    //   1514: invokevirtual 41	bgve:a	()Lcom/tencent/common/app/AppInterface;
    //   1517: invokevirtual 57	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   1520: invokevirtual 355	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1523: ifeq -453 -> 1070
    //   1526: aload_1
    //   1527: invokestatic 47	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1530: ifne -460 -> 1070
    //   1533: new 719	android/os/Bundle
    //   1536: dup
    //   1537: invokespecial 720	android/os/Bundle:<init>	()V
    //   1540: astore_3
    //   1541: aload_3
    //   1542: ldc 123
    //   1544: aload_2
    //   1545: invokevirtual 723	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1548: ldc_w 725
    //   1551: aload_1
    //   1552: aload_0
    //   1553: getfield 24	autg:jdField_a_of_type_Aqyp	Laqyp;
    //   1556: getfield 729	aqyp:key	I
    //   1559: aload_3
    //   1560: invokestatic 734	aqyt:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)Landroid/os/Bundle;
    //   1563: astore_1
    //   1564: invokestatic 739	ardu:a	()Lardu;
    //   1567: aload_1
    //   1568: invokevirtual 742	ardu:a	(Landroid/os/Bundle;)V
    //   1571: goto -501 -> 1070
    //   1574: astore_1
    //   1575: aload_1
    //   1576: invokevirtual 652	org/json/JSONException:printStackTrace	()V
    //   1579: goto -509 -> 1070
    //   1582: ldc_w 744
    //   1585: aload 4
    //   1587: invokevirtual 355	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1590: ifeq +137 -> 1727
    //   1593: aload 5
    //   1595: arraylength
    //   1596: iconst_1
    //   1597: if_icmpne +130 -> 1727
    //   1600: new 161	org/json/JSONObject
    //   1603: dup
    //   1604: aload 5
    //   1606: iconst_0
    //   1607: aaload
    //   1608: invokespecial 163	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1611: astore_1
    //   1612: aload_1
    //   1613: ldc 222
    //   1615: invokevirtual 225	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1618: astore_2
    //   1619: aload_2
    //   1620: invokestatic 47	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1623: ifne -553 -> 1070
    //   1626: ldc_w 746
    //   1629: aload_1
    //   1630: ldc_w 339
    //   1633: invokevirtual 225	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1636: invokevirtual 355	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1639: ifeq +23 -> 1662
    //   1642: aload_0
    //   1643: aload_2
    //   1644: iconst_1
    //   1645: anewarray 71	java/lang/String
    //   1648: dup
    //   1649: iconst_0
    //   1650: getstatic 750	com/tencent/mobileqq/activity/QQBrowserActivity:d	I
    //   1653: invokestatic 752	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   1656: aastore
    //   1657: invokevirtual 230	autg:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1660: iconst_1
    //   1661: ireturn
    //   1662: aconst_null
    //   1663: astore_1
    //   1664: aload_0
    //   1665: getfield 36	autg:mRuntime	Lbgve;
    //   1668: invokevirtual 670	bgve:a	()Landroid/app/Activity;
    //   1671: astore_3
    //   1672: aload_3
    //   1673: ifnull +14 -> 1687
    //   1676: aload_3
    //   1677: invokevirtual 676	android/app/Activity:getIntent	()Landroid/content/Intent;
    //   1680: ldc_w 754
    //   1683: invokevirtual 701	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1686: astore_1
    //   1687: aload_1
    //   1688: ifnonnull +31 -> 1719
    //   1691: ldc_w 756
    //   1694: astore_1
    //   1695: aload_0
    //   1696: aload_2
    //   1697: iconst_1
    //   1698: anewarray 71	java/lang/String
    //   1701: dup
    //   1702: iconst_0
    //   1703: aload_1
    //   1704: aastore
    //   1705: invokevirtual 230	autg:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1708: goto -638 -> 1070
    //   1711: astore_1
    //   1712: aload_1
    //   1713: invokevirtual 652	org/json/JSONException:printStackTrace	()V
    //   1716: goto -646 -> 1070
    //   1719: aload_1
    //   1720: invokestatic 757	npn:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1723: astore_1
    //   1724: goto -29 -> 1695
    //   1727: ldc_w 759
    //   1730: aload 4
    //   1732: invokevirtual 355	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1735: ifeq +126 -> 1861
    //   1738: aload 5
    //   1740: arraylength
    //   1741: iconst_1
    //   1742: if_icmpne +119 -> 1861
    //   1745: new 161	org/json/JSONObject
    //   1748: dup
    //   1749: aload 5
    //   1751: iconst_0
    //   1752: aaload
    //   1753: invokespecial 163	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1756: astore_1
    //   1757: aload_1
    //   1758: ldc_w 761
    //   1761: invokevirtual 225	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1764: astore_2
    //   1765: aload_1
    //   1766: ldc 222
    //   1768: invokevirtual 225	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1771: astore_1
    //   1772: aload_2
    //   1773: ifnonnull +3283 -> 5056
    //   1776: ldc_w 756
    //   1779: astore_2
    //   1780: invokestatic 565	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1783: ldc_w 763
    //   1786: invokevirtual 767	com/tencent/qphone/base/util/BaseApplication:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   1789: checkcast 769	android/text/ClipboardManager
    //   1792: astore_3
    //   1793: aload_3
    //   1794: ifnull +32 -> 1826
    //   1797: aload_3
    //   1798: aload_2
    //   1799: invokevirtual 773	android/text/ClipboardManager:setText	(Ljava/lang/CharSequence;)V
    //   1802: aload_1
    //   1803: invokestatic 47	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1806: ifne +18 -> 1824
    //   1809: aload_0
    //   1810: aload_1
    //   1811: iconst_1
    //   1812: anewarray 71	java/lang/String
    //   1815: dup
    //   1816: iconst_0
    //   1817: ldc_w 775
    //   1820: aastore
    //   1821: invokevirtual 230	autg:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1824: iconst_1
    //   1825: ireturn
    //   1826: aload_1
    //   1827: invokestatic 47	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1830: ifne -760 -> 1070
    //   1833: aload_0
    //   1834: aload_1
    //   1835: iconst_1
    //   1836: anewarray 71	java/lang/String
    //   1839: dup
    //   1840: iconst_0
    //   1841: ldc_w 777
    //   1844: aastore
    //   1845: invokevirtual 230	autg:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1848: goto -778 -> 1070
    //   1851: astore_2
    //   1852: aconst_null
    //   1853: astore_1
    //   1854: aload_2
    //   1855: invokevirtual 652	org/json/JSONException:printStackTrace	()V
    //   1858: goto -32 -> 1826
    //   1861: ldc_w 779
    //   1864: aload 4
    //   1866: invokevirtual 355	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1869: ifeq +123 -> 1992
    //   1872: aload 5
    //   1874: arraylength
    //   1875: iconst_1
    //   1876: if_icmpne +116 -> 1992
    //   1879: new 161	org/json/JSONObject
    //   1882: dup
    //   1883: aload 5
    //   1885: iconst_0
    //   1886: aaload
    //   1887: invokespecial 163	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1890: ldc 222
    //   1892: invokevirtual 225	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1895: astore_2
    //   1896: aload_2
    //   1897: invokestatic 47	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1900: ifne -830 -> 1070
    //   1903: invokestatic 565	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1906: ldc_w 763
    //   1909: invokevirtual 767	com/tencent/qphone/base/util/BaseApplication:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   1912: checkcast 769	android/text/ClipboardManager
    //   1915: astore_1
    //   1916: aload_1
    //   1917: ifnull +3132 -> 5049
    //   1920: aload_1
    //   1921: invokevirtual 783	android/text/ClipboardManager:getText	()Ljava/lang/CharSequence;
    //   1924: astore_1
    //   1925: aload_1
    //   1926: ifnull +3123 -> 5049
    //   1929: aload_1
    //   1930: invokeinterface 786 1 0
    //   1935: astore_1
    //   1936: aload_0
    //   1937: aload_2
    //   1938: iconst_1
    //   1939: anewarray 71	java/lang/String
    //   1942: dup
    //   1943: iconst_0
    //   1944: aload_1
    //   1945: invokestatic 757	npn:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1948: aastore
    //   1949: invokevirtual 230	autg:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1952: goto -882 -> 1070
    //   1955: astore_1
    //   1956: ldc 85
    //   1958: iconst_1
    //   1959: new 87	java/lang/StringBuilder
    //   1962: dup
    //   1963: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   1966: ldc_w 788
    //   1969: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1972: aload_1
    //   1973: invokevirtual 346	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1976: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1979: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1982: invokestatic 111	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1985: aload_1
    //   1986: invokevirtual 789	java/lang/Exception:printStackTrace	()V
    //   1989: goto -919 -> 1070
    //   1992: ldc_w 791
    //   1995: aload 4
    //   1997: invokevirtual 355	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2000: ifeq +203 -> 2203
    //   2003: aload 5
    //   2005: arraylength
    //   2006: iconst_1
    //   2007: if_icmpne +196 -> 2203
    //   2010: new 161	org/json/JSONObject
    //   2013: dup
    //   2014: aload 5
    //   2016: iconst_0
    //   2017: aaload
    //   2018: invokespecial 163	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2021: astore_1
    //   2022: aload_1
    //   2023: ldc_w 793
    //   2026: invokevirtual 225	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2029: astore_2
    //   2030: aload_1
    //   2031: ldc_w 795
    //   2034: invokevirtual 225	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2037: astore_3
    //   2038: aload_1
    //   2039: ldc_w 797
    //   2042: iconst_1
    //   2043: invokevirtual 801	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   2046: istore 9
    //   2048: aload_1
    //   2049: ldc 222
    //   2051: invokevirtual 225	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2054: astore 4
    //   2056: new 161	org/json/JSONObject
    //   2059: dup
    //   2060: invokespecial 291	org/json/JSONObject:<init>	()V
    //   2063: astore 5
    //   2065: aload_2
    //   2066: invokestatic 47	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2069: ifne +109 -> 2178
    //   2072: aload_3
    //   2073: invokestatic 47	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2076: ifne +102 -> 2178
    //   2079: aload_0
    //   2080: getfield 36	autg:mRuntime	Lbgve;
    //   2083: invokevirtual 41	bgve:a	()Lcom/tencent/common/app/AppInterface;
    //   2086: astore_1
    //   2087: aload_1
    //   2088: instanceof 803
    //   2091: ifeq +2953 -> 5044
    //   2094: aload_1
    //   2095: checkcast 803	com/tencent/mobileqq/app/QQAppInterface
    //   2098: astore_1
    //   2099: aload_1
    //   2100: aload_2
    //   2101: aload_3
    //   2102: iload 9
    //   2104: invokestatic 808	bcdf:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Z)V
    //   2107: aload 5
    //   2109: ldc_w 293
    //   2112: iconst_0
    //   2113: invokevirtual 297	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2116: pop
    //   2117: aload 5
    //   2119: ldc_w 299
    //   2122: ldc_w 810
    //   2125: invokevirtual 308	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2128: pop
    //   2129: aload 4
    //   2131: invokestatic 47	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2134: ifne -1064 -> 1070
    //   2137: aload_0
    //   2138: aload 4
    //   2140: iconst_1
    //   2141: anewarray 71	java/lang/String
    //   2144: dup
    //   2145: iconst_0
    //   2146: aload 5
    //   2148: invokevirtual 309	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2151: aastore
    //   2152: invokevirtual 230	autg:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2155: goto -1085 -> 1070
    //   2158: astore_1
    //   2159: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2162: ifeq -1092 -> 1070
    //   2165: ldc 85
    //   2167: iconst_2
    //   2168: aload_1
    //   2169: invokevirtual 346	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2172: invokestatic 812	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   2175: goto -1105 -> 1070
    //   2178: aload 5
    //   2180: ldc_w 293
    //   2183: iconst_m1
    //   2184: invokevirtual 297	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2187: pop
    //   2188: aload 5
    //   2190: ldc_w 299
    //   2193: ldc_w 814
    //   2196: invokevirtual 308	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2199: pop
    //   2200: goto -71 -> 2129
    //   2203: ldc_w 816
    //   2206: aload 4
    //   2208: invokevirtual 355	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2211: ifeq +473 -> 2684
    //   2214: aload 5
    //   2216: arraylength
    //   2217: iconst_1
    //   2218: if_icmpne +466 -> 2684
    //   2221: new 161	org/json/JSONObject
    //   2224: dup
    //   2225: aload 5
    //   2227: iconst_0
    //   2228: aaload
    //   2229: invokespecial 163	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2232: astore_1
    //   2233: aload_1
    //   2234: ldc_w 818
    //   2237: invokevirtual 225	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2240: astore_3
    //   2241: aload_1
    //   2242: ldc_w 820
    //   2245: invokevirtual 167	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   2248: astore_1
    //   2249: aload_0
    //   2250: getfield 36	autg:mRuntime	Lbgve;
    //   2253: invokevirtual 41	bgve:a	()Lcom/tencent/common/app/AppInterface;
    //   2256: astore_2
    //   2257: ldc_w 822
    //   2260: aload_3
    //   2261: invokevirtual 825	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   2264: ifeq +232 -> 2496
    //   2267: aload_1
    //   2268: ldc_w 827
    //   2271: ldc_w 756
    //   2274: invokevirtual 829	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2277: astore_3
    //   2278: aload_1
    //   2279: ldc_w 831
    //   2282: invokevirtual 833	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2285: astore 4
    //   2287: aload_1
    //   2288: ldc_w 835
    //   2291: invokevirtual 833	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2294: astore 5
    //   2296: aload_1
    //   2297: ldc_w 837
    //   2300: invokevirtual 833	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2303: astore 11
    //   2305: aload_1
    //   2306: ldc_w 839
    //   2309: ldc_w 756
    //   2312: invokevirtual 829	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2315: astore 12
    //   2317: aload_1
    //   2318: ldc_w 841
    //   2321: iconst_0
    //   2322: invokevirtual 844	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   2325: istore 6
    //   2327: aload_1
    //   2328: ldc_w 846
    //   2331: iconst_1
    //   2332: invokevirtual 844	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   2335: istore 7
    //   2337: aload_1
    //   2338: ldc_w 848
    //   2341: iconst_0
    //   2342: invokevirtual 844	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   2345: istore 8
    //   2347: aload_1
    //   2348: ldc_w 850
    //   2351: ldc_w 756
    //   2354: invokevirtual 829	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2357: astore 13
    //   2359: aload_1
    //   2360: ldc_w 852
    //   2363: ldc_w 756
    //   2366: invokevirtual 829	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2369: astore 14
    //   2371: aload_1
    //   2372: ldc_w 854
    //   2375: ldc_w 756
    //   2378: invokevirtual 829	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2381: astore 15
    //   2383: aload_1
    //   2384: ldc_w 856
    //   2387: ldc_w 756
    //   2390: invokevirtual 829	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2393: astore 16
    //   2395: aconst_null
    //   2396: astore_1
    //   2397: aload_2
    //   2398: instanceof 803
    //   2401: ifeq +8 -> 2409
    //   2404: aload_2
    //   2405: checkcast 803	com/tencent/mobileqq/app/QQAppInterface
    //   2408: astore_1
    //   2409: aload_2
    //   2410: invokevirtual 53	com/tencent/common/app/AppInterface:isLogin	()Z
    //   2413: ifeq +53 -> 2466
    //   2416: aload_1
    //   2417: aload 4
    //   2419: aload_3
    //   2420: aload 12
    //   2422: aload 5
    //   2424: aload 11
    //   2426: iload 6
    //   2428: iload 7
    //   2430: iload 8
    //   2432: aload 13
    //   2434: aload 14
    //   2436: aload 15
    //   2438: aload 16
    //   2440: invokestatic 861	bcef:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2443: goto -1373 -> 1070
    //   2446: astore_1
    //   2447: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2450: ifeq -1380 -> 1070
    //   2453: ldc 85
    //   2455: iconst_2
    //   2456: aload_1
    //   2457: invokevirtual 862	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   2460: invokestatic 812	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   2463: goto -1393 -> 1070
    //   2466: aload_1
    //   2467: aload 4
    //   2469: aload_3
    //   2470: aload 12
    //   2472: aload 5
    //   2474: aload 11
    //   2476: iload 6
    //   2478: iload 7
    //   2480: iload 8
    //   2482: aload 13
    //   2484: aload 14
    //   2486: aload 15
    //   2488: aload 16
    //   2490: invokestatic 864	bcef:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2493: goto -1423 -> 1070
    //   2496: ldc_w 866
    //   2499: aload_3
    //   2500: invokevirtual 825	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   2503: ifeq +163 -> 2666
    //   2506: aload_1
    //   2507: ldc_w 868
    //   2510: invokevirtual 833	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2513: astore_3
    //   2514: aload_1
    //   2515: ldc_w 870
    //   2518: iconst_1
    //   2519: invokevirtual 801	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   2522: istore 9
    //   2524: aload_1
    //   2525: ldc_w 872
    //   2528: iconst_1
    //   2529: invokevirtual 801	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   2532: istore 10
    //   2534: aload_1
    //   2535: ldc_w 874
    //   2538: iconst_0
    //   2539: invokevirtual 844	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   2542: istore 6
    //   2544: aload_1
    //   2545: ldc_w 876
    //   2548: iconst_0
    //   2549: invokevirtual 844	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   2552: istore 7
    //   2554: new 878	java/util/HashMap
    //   2557: dup
    //   2558: invokespecial 879	java/util/HashMap:<init>	()V
    //   2561: astore 4
    //   2563: aload_1
    //   2564: ldc_w 881
    //   2567: invokevirtual 884	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   2570: astore_1
    //   2571: aload_1
    //   2572: ifnull +53 -> 2625
    //   2575: aload_1
    //   2576: invokevirtual 888	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   2579: astore 5
    //   2581: aload 5
    //   2583: ifnull +42 -> 2625
    //   2586: aload 5
    //   2588: invokeinterface 893 1 0
    //   2593: ifeq +32 -> 2625
    //   2596: aload 5
    //   2598: invokeinterface 897 1 0
    //   2603: checkcast 71	java/lang/String
    //   2606: astore 11
    //   2608: aload 4
    //   2610: aload 11
    //   2612: aload_1
    //   2613: aload 11
    //   2615: invokevirtual 225	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2618: invokevirtual 900	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2621: pop
    //   2622: goto -41 -> 2581
    //   2625: aconst_null
    //   2626: astore_1
    //   2627: aload_2
    //   2628: invokevirtual 53	com/tencent/common/app/AppInterface:isLogin	()Z
    //   2631: ifeq +8 -> 2639
    //   2634: aload_2
    //   2635: invokevirtual 57	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   2638: astore_1
    //   2639: aconst_null
    //   2640: invokestatic 905	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   2643: aload_1
    //   2644: aload_3
    //   2645: iload 10
    //   2647: iload 6
    //   2649: i2l
    //   2650: iload 7
    //   2652: i2l
    //   2653: aload 4
    //   2655: ldc_w 756
    //   2658: iload 9
    //   2660: invokevirtual 909	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   2663: goto -1593 -> 1070
    //   2666: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2669: ifeq -1599 -> 1070
    //   2672: ldc 85
    //   2674: iconst_2
    //   2675: ldc_w 911
    //   2678: invokestatic 812	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   2681: goto -1611 -> 1070
    //   2684: ldc_w 913
    //   2687: aload 4
    //   2689: invokevirtual 355	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2692: ifeq +175 -> 2867
    //   2695: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2698: ifeq +12 -> 2710
    //   2701: ldc 85
    //   2703: iconst_2
    //   2704: ldc_w 913
    //   2707: invokestatic 141	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2710: new 161	org/json/JSONObject
    //   2713: dup
    //   2714: aload 5
    //   2716: iconst_0
    //   2717: aaload
    //   2718: invokespecial 163	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2721: astore_2
    //   2722: aload_2
    //   2723: ldc 222
    //   2725: invokevirtual 225	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2728: astore_1
    //   2729: aload_2
    //   2730: ldc 123
    //   2732: invokevirtual 225	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2735: astore_2
    //   2736: aload_1
    //   2737: invokestatic 47	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2740: ifne +109 -> 2849
    //   2743: new 719	android/os/Bundle
    //   2746: dup
    //   2747: invokespecial 720	android/os/Bundle:<init>	()V
    //   2750: astore_3
    //   2751: aload_2
    //   2752: invokestatic 47	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2755: ifne +75 -> 2830
    //   2758: aload_3
    //   2759: ldc 123
    //   2761: aload_2
    //   2762: invokevirtual 723	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2765: ldc_w 915
    //   2768: aload_1
    //   2769: aload_0
    //   2770: getfield 24	autg:jdField_a_of_type_Aqyp	Laqyp;
    //   2773: getfield 729	aqyp:key	I
    //   2776: aload_3
    //   2777: invokestatic 734	aqyt:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)Landroid/os/Bundle;
    //   2780: astore_1
    //   2781: invokestatic 739	ardu:a	()Lardu;
    //   2784: aload_1
    //   2785: invokevirtual 742	ardu:a	(Landroid/os/Bundle;)V
    //   2788: goto -1718 -> 1070
    //   2791: astore_1
    //   2792: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2795: ifeq -1725 -> 1070
    //   2798: ldc 85
    //   2800: iconst_2
    //   2801: new 87	java/lang/StringBuilder
    //   2804: dup
    //   2805: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   2808: ldc_w 917
    //   2811: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2814: aload_1
    //   2815: invokevirtual 862	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   2818: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2821: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2824: invokestatic 812	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   2827: goto -1757 -> 1070
    //   2830: aload_3
    //   2831: ldc 123
    //   2833: aload_0
    //   2834: getfield 36	autg:mRuntime	Lbgve;
    //   2837: invokevirtual 41	bgve:a	()Lcom/tencent/common/app/AppInterface;
    //   2840: invokevirtual 57	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   2843: invokevirtual 723	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2846: goto -81 -> 2765
    //   2849: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2852: ifeq -1782 -> 1070
    //   2855: ldc 85
    //   2857: iconst_2
    //   2858: ldc_w 919
    //   2861: invokestatic 141	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2864: goto -1794 -> 1070
    //   2867: ldc_w 921
    //   2870: aload 4
    //   2872: invokevirtual 355	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2875: ifeq +116 -> 2991
    //   2878: aload 5
    //   2880: arraylength
    //   2881: iconst_1
    //   2882: if_icmpne +109 -> 2991
    //   2885: new 161	org/json/JSONObject
    //   2888: dup
    //   2889: aload 5
    //   2891: iconst_0
    //   2892: aaload
    //   2893: invokespecial 163	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2896: ldc 222
    //   2898: invokevirtual 225	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2901: astore_1
    //   2902: aload_1
    //   2903: invokestatic 47	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2906: ifne -1836 -> 1070
    //   2909: aload_0
    //   2910: aload_1
    //   2911: iconst_1
    //   2912: anewarray 71	java/lang/String
    //   2915: dup
    //   2916: iconst_0
    //   2917: new 87	java/lang/StringBuilder
    //   2920: dup
    //   2921: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   2924: ldc_w 923
    //   2927: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2930: invokestatic 926	com/tencent/common/config/AppSetting:a	()I
    //   2933: invokevirtual 192	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2936: ldc_w 928
    //   2939: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2942: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2945: aastore
    //   2946: invokevirtual 230	autg:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2949: goto -1879 -> 1070
    //   2952: astore_1
    //   2953: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2956: ifeq -1886 -> 1070
    //   2959: ldc 85
    //   2961: iconst_2
    //   2962: new 87	java/lang/StringBuilder
    //   2965: dup
    //   2966: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   2969: ldc_w 930
    //   2972: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2975: aload_1
    //   2976: invokevirtual 862	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   2979: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2982: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2985: invokestatic 812	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   2988: goto -1918 -> 1070
    //   2991: ldc_w 932
    //   2994: aload 4
    //   2996: invokevirtual 355	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2999: ifeq +521 -> 3520
    //   3002: aload 5
    //   3004: arraylength
    //   3005: iconst_1
    //   3006: if_icmpne +514 -> 3520
    //   3009: new 161	org/json/JSONObject
    //   3012: dup
    //   3013: aload 5
    //   3015: iconst_0
    //   3016: aaload
    //   3017: invokespecial 163	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3020: astore_1
    //   3021: aload_1
    //   3022: ldc 222
    //   3024: invokevirtual 225	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3027: astore_3
    //   3028: aload_1
    //   3029: ldc_w 934
    //   3032: invokevirtual 225	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3035: astore_1
    //   3036: aload_1
    //   3037: invokestatic 47	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3040: ifne +1998 -> 5038
    //   3043: aload_1
    //   3044: invokevirtual 937	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   3047: astore 4
    //   3049: aload_0
    //   3050: getfield 36	autg:mRuntime	Lbgve;
    //   3053: invokevirtual 41	bgve:a	()Lcom/tencent/common/app/AppInterface;
    //   3056: astore_2
    //   3057: aload_2
    //   3058: ifnull +1980 -> 5038
    //   3061: aload_2
    //   3062: invokevirtual 53	com/tencent/common/app/AppInterface:isLogin	()Z
    //   3065: ifeq +1973 -> 5038
    //   3068: aload_2
    //   3069: invokevirtual 57	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   3072: astore_1
    //   3073: aload_2
    //   3074: iconst_2
    //   3075: invokevirtual 547	com/tencent/common/app/AppInterface:getManager	(I)Lmqq/manager/Manager;
    //   3078: checkcast 549	mqq/manager/TicketManager
    //   3081: astore_2
    //   3082: aload_2
    //   3083: aload_1
    //   3084: aload 4
    //   3086: invokeinterface 632 3 0
    //   3091: astore 13
    //   3093: aload_2
    //   3094: aload_1
    //   3095: aload 4
    //   3097: invokeinterface 940 3 0
    //   3102: astore 5
    //   3104: aload 13
    //   3106: invokestatic 47	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3109: ifne +1929 -> 5038
    //   3112: new 87	java/lang/StringBuilder
    //   3115: dup
    //   3116: bipush 111
    //   3118: invokespecial 942	java/lang/StringBuilder:<init>	(I)V
    //   3121: astore_2
    //   3122: aload_1
    //   3123: invokevirtual 945	java/lang/String:length	()I
    //   3126: bipush 10
    //   3128: if_icmpge +32 -> 3160
    //   3131: aload_1
    //   3132: invokevirtual 945	java/lang/String:length	()I
    //   3135: istore 6
    //   3137: iload 6
    //   3139: bipush 10
    //   3141: if_icmpge +19 -> 3160
    //   3144: aload_2
    //   3145: bipush 48
    //   3147: invokevirtual 505	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   3150: pop
    //   3151: iload 6
    //   3153: iconst_1
    //   3154: iadd
    //   3155: istore 6
    //   3157: goto -20 -> 3137
    //   3160: aload_2
    //   3161: aload_1
    //   3162: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3165: pop
    //   3166: invokestatic 63	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   3169: astore 11
    //   3171: aload 11
    //   3173: iconst_1
    //   3174: invokevirtual 117	com/tencent/smtt/sdk/CookieManager:setAcceptCookie	(Z)V
    //   3177: new 87	java/lang/StringBuilder
    //   3180: dup
    //   3181: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   3184: ldc_w 947
    //   3187: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3190: aload 4
    //   3192: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3195: bipush 47
    //   3197: invokevirtual 505	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   3200: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3203: astore 12
    //   3205: new 87	java/lang/StringBuilder
    //   3208: dup
    //   3209: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   3212: ldc_w 268
    //   3215: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3218: aload_2
    //   3219: invokevirtual 950	java/lang/StringBuilder:append	(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
    //   3222: ldc_w 502
    //   3225: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3228: aload 4
    //   3230: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3233: bipush 59
    //   3235: invokevirtual 505	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   3238: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3241: astore 14
    //   3243: aload 11
    //   3245: aload 12
    //   3247: aload 14
    //   3249: invokevirtual 131	com/tencent/smtt/sdk/CookieManager:setCookie	(Ljava/lang/String;Ljava/lang/String;)V
    //   3252: ldc_w 756
    //   3255: astore_1
    //   3256: ldc_w 756
    //   3259: astore_2
    //   3260: aload 13
    //   3262: invokestatic 47	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3265: ifne +49 -> 3314
    //   3268: new 87	java/lang/StringBuilder
    //   3271: dup
    //   3272: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   3275: ldc_w 500
    //   3278: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3281: aload 13
    //   3283: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3286: ldc_w 502
    //   3289: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3292: aload 4
    //   3294: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3297: bipush 59
    //   3299: invokevirtual 505	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   3302: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3305: astore_1
    //   3306: aload 11
    //   3308: aload 12
    //   3310: aload_1
    //   3311: invokevirtual 131	com/tencent/smtt/sdk/CookieManager:setCookie	(Ljava/lang/String;Ljava/lang/String;)V
    //   3314: aload 5
    //   3316: invokestatic 47	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3319: ifne +49 -> 3368
    //   3322: new 87	java/lang/StringBuilder
    //   3325: dup
    //   3326: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   3329: ldc_w 516
    //   3332: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3335: aload 5
    //   3337: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3340: ldc_w 502
    //   3343: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3346: aload 4
    //   3348: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3351: bipush 59
    //   3353: invokevirtual 505	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   3356: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3359: astore_2
    //   3360: aload 11
    //   3362: aload 12
    //   3364: aload_2
    //   3365: invokevirtual 131	com/tencent/smtt/sdk/CookieManager:setCookie	(Ljava/lang/String;Ljava/lang/String;)V
    //   3368: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3371: ifeq +1705 -> 5076
    //   3374: ldc 85
    //   3376: iconst_2
    //   3377: new 87	java/lang/StringBuilder
    //   3380: dup
    //   3381: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   3384: ldc_w 626
    //   3387: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3390: aload 14
    //   3392: iconst_0
    //   3393: anewarray 71	java/lang/String
    //   3396: invokestatic 102	npn:c	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   3399: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3402: aload_1
    //   3403: iconst_0
    //   3404: anewarray 71	java/lang/String
    //   3407: invokestatic 102	npn:c	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   3410: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3413: aload_2
    //   3414: iconst_0
    //   3415: anewarray 71	java/lang/String
    //   3418: invokestatic 102	npn:c	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   3421: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3424: ldc_w 628
    //   3427: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3430: aload 12
    //   3432: iconst_0
    //   3433: anewarray 71	java/lang/String
    //   3436: invokestatic 97	npn:b	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   3439: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3442: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3445: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3448: goto +1628 -> 5076
    //   3451: aload_3
    //   3452: invokestatic 47	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3455: ifne -2385 -> 1070
    //   3458: aload_0
    //   3459: aload_3
    //   3460: iconst_1
    //   3461: anewarray 71	java/lang/String
    //   3464: dup
    //   3465: iconst_0
    //   3466: new 87	java/lang/StringBuilder
    //   3469: dup
    //   3470: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   3473: ldc_w 952
    //   3476: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3479: iload 6
    //   3481: invokevirtual 192	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3484: ldc_w 928
    //   3487: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3490: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3493: aastore
    //   3494: invokevirtual 230	autg:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   3497: goto -2427 -> 1070
    //   3500: astore_1
    //   3501: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3504: ifeq -2434 -> 1070
    //   3507: ldc 85
    //   3509: iconst_2
    //   3510: ldc_w 954
    //   3513: aload_1
    //   3514: invokestatic 694	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3517: goto -2447 -> 1070
    //   3520: ldc_w 956
    //   3523: aload 4
    //   3525: invokevirtual 355	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3528: ifeq +13 -> 3541
    //   3531: aload_0
    //   3532: aload_2
    //   3533: aload 5
    //   3535: invokespecial 958	autg:a	(Ljava/lang/String;[Ljava/lang/String;)V
    //   3538: goto -2468 -> 1070
    //   3541: ldc_w 960
    //   3544: aload 4
    //   3546: invokevirtual 355	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3549: ifeq +137 -> 3686
    //   3552: aconst_null
    //   3553: astore_2
    //   3554: aload_2
    //   3555: astore_1
    //   3556: new 161	org/json/JSONObject
    //   3559: dup
    //   3560: aload 5
    //   3562: iconst_0
    //   3563: aaload
    //   3564: invokespecial 163	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3567: astore_3
    //   3568: aload_2
    //   3569: astore_1
    //   3570: aload_3
    //   3571: ldc 222
    //   3573: invokevirtual 225	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3576: astore_2
    //   3577: aload_2
    //   3578: astore_1
    //   3579: aload_3
    //   3580: ldc 123
    //   3582: invokevirtual 833	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   3585: astore_3
    //   3586: aload_2
    //   3587: astore_1
    //   3588: invokestatic 739	ardu:a	()Lardu;
    //   3591: invokevirtual 962	ardu:a	()Z
    //   3594: ifeq -2524 -> 1070
    //   3597: aload_2
    //   3598: astore_1
    //   3599: new 719	android/os/Bundle
    //   3602: dup
    //   3603: invokespecial 720	android/os/Bundle:<init>	()V
    //   3606: astore 4
    //   3608: aload_2
    //   3609: astore_1
    //   3610: aload 4
    //   3612: ldc 123
    //   3614: aload_3
    //   3615: invokevirtual 723	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   3618: aload_2
    //   3619: astore_1
    //   3620: ldc_w 964
    //   3623: aload_2
    //   3624: aload_0
    //   3625: getfield 24	autg:jdField_a_of_type_Aqyp	Laqyp;
    //   3628: getfield 729	aqyp:key	I
    //   3631: aload 4
    //   3633: invokestatic 734	aqyt:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)Landroid/os/Bundle;
    //   3636: astore_3
    //   3637: aload_2
    //   3638: astore_1
    //   3639: invokestatic 739	ardu:a	()Lardu;
    //   3642: aload_3
    //   3643: invokevirtual 742	ardu:a	(Landroid/os/Bundle;)V
    //   3646: goto -2576 -> 1070
    //   3649: astore_2
    //   3650: aload_1
    //   3651: invokestatic 47	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3654: ifne -2584 -> 1070
    //   3657: aload_0
    //   3658: aload_1
    //   3659: iconst_1
    //   3660: anewarray 71	java/lang/String
    //   3663: dup
    //   3664: iconst_0
    //   3665: ldc_w 966
    //   3668: iconst_1
    //   3669: anewarray 121	java/lang/Object
    //   3672: dup
    //   3673: iconst_0
    //   3674: aload_2
    //   3675: aastore
    //   3676: invokestatic 127	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   3679: aastore
    //   3680: invokevirtual 230	autg:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   3683: goto -2613 -> 1070
    //   3686: ldc_w 968
    //   3689: aload 4
    //   3691: invokevirtual 355	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3694: ifeq +128 -> 3822
    //   3697: new 161	org/json/JSONObject
    //   3700: dup
    //   3701: aload 5
    //   3703: iconst_0
    //   3704: aaload
    //   3705: invokespecial 163	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3708: astore_1
    //   3709: ldc_w 970
    //   3712: aload_1
    //   3713: ldc_w 972
    //   3716: invokevirtual 225	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3719: invokevirtual 355	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3722: ifeq +24 -> 3746
    //   3725: aload_0
    //   3726: getfield 36	autg:mRuntime	Lbgve;
    //   3729: invokevirtual 670	bgve:a	()Landroid/app/Activity;
    //   3732: astore_2
    //   3733: aload_2
    //   3734: ifnull +12 -> 3746
    //   3737: aload_2
    //   3738: iconst_m1
    //   3739: invokevirtual 975	android/app/Activity:setResult	(I)V
    //   3742: aload_2
    //   3743: invokevirtual 978	android/app/Activity:finish	()V
    //   3746: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3749: ifeq -2679 -> 1070
    //   3752: ldc 85
    //   3754: iconst_2
    //   3755: new 87	java/lang/StringBuilder
    //   3758: dup
    //   3759: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   3762: ldc_w 980
    //   3765: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3768: aload_1
    //   3769: invokevirtual 983	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3772: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3775: invokestatic 812	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   3778: goto -2708 -> 1070
    //   3781: astore_1
    //   3782: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3785: ifeq +13 -> 3798
    //   3788: ldc 85
    //   3790: iconst_2
    //   3791: ldc_w 985
    //   3794: aload_1
    //   3795: invokestatic 694	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3798: aload_0
    //   3799: getfield 36	autg:mRuntime	Lbgve;
    //   3802: invokevirtual 670	bgve:a	()Landroid/app/Activity;
    //   3805: astore_1
    //   3806: aload_1
    //   3807: ifnull -2737 -> 1070
    //   3810: aload_1
    //   3811: iconst_0
    //   3812: invokevirtual 975	android/app/Activity:setResult	(I)V
    //   3815: aload_1
    //   3816: invokevirtual 978	android/app/Activity:finish	()V
    //   3819: goto -2749 -> 1070
    //   3822: ldc_w 987
    //   3825: aload 4
    //   3827: invokevirtual 355	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3830: ifeq +380 -> 4210
    //   3833: aload 5
    //   3835: arraylength
    //   3836: iconst_1
    //   3837: if_icmpne +373 -> 4210
    //   3840: new 161	org/json/JSONObject
    //   3843: dup
    //   3844: aload 5
    //   3846: iconst_0
    //   3847: aaload
    //   3848: invokespecial 163	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3851: astore_3
    //   3852: aload_3
    //   3853: ldc 222
    //   3855: invokevirtual 833	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   3858: astore_2
    //   3859: aload_3
    //   3860: ldc_w 989
    //   3863: invokevirtual 833	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   3866: astore 4
    //   3868: aload_3
    //   3869: ldc_w 934
    //   3872: invokevirtual 833	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   3875: astore_1
    //   3876: aload_0
    //   3877: getfield 332	autg:jdField_a_of_type_Nko	Lnko;
    //   3880: ifnonnull +10 -> 3890
    //   3883: aload_0
    //   3884: invokestatic 337	nko:a	()Lnko;
    //   3887: putfield 332	autg:jdField_a_of_type_Nko	Lnko;
    //   3890: iconst_0
    //   3891: istore 10
    //   3893: iload 10
    //   3895: istore 9
    //   3897: aload 4
    //   3899: invokestatic 47	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3902: ifne +71 -> 3973
    //   3905: iload 10
    //   3907: istore 9
    //   3909: aload_1
    //   3910: invokestatic 47	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3913: ifne +60 -> 3973
    //   3916: new 87	java/lang/StringBuilder
    //   3919: dup
    //   3920: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   3923: ldc_w 947
    //   3926: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3929: aload_1
    //   3930: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3933: ldc_w 991
    //   3936: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3939: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3942: astore_1
    //   3943: ldc_w 993
    //   3946: aload 4
    //   3948: invokevirtual 355	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3951: ifeq +67 -> 4018
    //   3954: aload_3
    //   3955: ldc_w 995
    //   3958: invokevirtual 833	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   3961: astore_3
    //   3962: aload_0
    //   3963: getfield 332	autg:jdField_a_of_type_Nko	Lnko;
    //   3966: aload_1
    //   3967: aload_3
    //   3968: invokevirtual 998	nko:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   3971: istore 9
    //   3973: iload 9
    //   3975: ifeq +228 -> 4203
    //   3978: ldc_w 1000
    //   3981: astore_1
    //   3982: aload_0
    //   3983: aload_2
    //   3984: iconst_1
    //   3985: anewarray 71	java/lang/String
    //   3988: dup
    //   3989: iconst_0
    //   3990: aload_1
    //   3991: aastore
    //   3992: invokevirtual 230	autg:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   3995: goto -2925 -> 1070
    //   3998: astore_1
    //   3999: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4002: ifeq -2932 -> 1070
    //   4005: ldc 85
    //   4007: iconst_2
    //   4008: ldc_w 1002
    //   4011: aload_1
    //   4012: invokestatic 694	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   4015: goto -2945 -> 1070
    //   4018: ldc_w 351
    //   4021: aload 4
    //   4023: invokevirtual 355	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4026: ifeq +16 -> 4042
    //   4029: aload_0
    //   4030: getfield 332	autg:jdField_a_of_type_Nko	Lnko;
    //   4033: aload_1
    //   4034: invokevirtual 371	nko:a	(Ljava/lang/String;)Z
    //   4037: istore 9
    //   4039: goto -66 -> 3973
    //   4042: ldc_w 1004
    //   4045: aload 4
    //   4047: invokevirtual 355	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4050: ifeq +23 -> 4073
    //   4053: aload_0
    //   4054: getfield 332	autg:jdField_a_of_type_Nko	Lnko;
    //   4057: aload_1
    //   4058: invokevirtual 540	nko:a	(Ljava/lang/String;)Ljava/lang/String;
    //   4061: invokestatic 47	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4064: ifne +1018 -> 5082
    //   4067: iconst_1
    //   4068: istore 9
    //   4070: goto -97 -> 3973
    //   4073: ldc_w 375
    //   4076: aload 4
    //   4078: invokevirtual 355	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4081: ifeq +23 -> 4104
    //   4084: aload_0
    //   4085: getfield 332	autg:jdField_a_of_type_Nko	Lnko;
    //   4088: aload_1
    //   4089: invokevirtual 377	nko:d	(Ljava/lang/String;)Ljava/lang/String;
    //   4092: invokestatic 47	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4095: ifne +993 -> 5088
    //   4098: iconst_1
    //   4099: istore 9
    //   4101: goto -128 -> 3973
    //   4104: ldc_w 1006
    //   4107: aload 4
    //   4109: invokevirtual 355	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4112: ifeq +25 -> 4137
    //   4115: aload_3
    //   4116: ldc_w 1006
    //   4119: invokevirtual 833	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   4122: astore_3
    //   4123: aload_0
    //   4124: getfield 332	autg:jdField_a_of_type_Nko	Lnko;
    //   4127: aload_1
    //   4128: aload_3
    //   4129: invokevirtual 1008	nko:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   4132: istore 9
    //   4134: goto -161 -> 3973
    //   4137: ldc_w 392
    //   4140: aload 4
    //   4142: invokevirtual 355	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4145: ifeq +23 -> 4168
    //   4148: aload_0
    //   4149: getfield 332	autg:jdField_a_of_type_Nko	Lnko;
    //   4152: aload_1
    //   4153: invokevirtual 394	nko:e	(Ljava/lang/String;)Ljava/lang/String;
    //   4156: invokestatic 47	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4159: ifne +935 -> 5094
    //   4162: iconst_1
    //   4163: istore 9
    //   4165: goto -192 -> 3973
    //   4168: iload 10
    //   4170: istore 9
    //   4172: ldc_w 1010
    //   4175: aload 4
    //   4177: invokevirtual 355	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4180: ifeq -207 -> 3973
    //   4183: aload_0
    //   4184: getfield 332	autg:jdField_a_of_type_Nko	Lnko;
    //   4187: aload_1
    //   4188: invokevirtual 543	nko:f	(Ljava/lang/String;)Ljava/lang/String;
    //   4191: invokestatic 47	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4194: ifne +906 -> 5100
    //   4197: iconst_1
    //   4198: istore 9
    //   4200: goto -227 -> 3973
    //   4203: ldc_w 1012
    //   4206: astore_1
    //   4207: goto -225 -> 3982
    //   4210: ldc_w 1014
    //   4213: aload 4
    //   4215: invokevirtual 355	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4218: ifeq +110 -> 4328
    //   4221: new 161	org/json/JSONObject
    //   4224: dup
    //   4225: aload 5
    //   4227: iconst_0
    //   4228: aaload
    //   4229: invokespecial 163	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   4232: astore_1
    //   4233: aload_1
    //   4234: ldc_w 293
    //   4237: iconst_0
    //   4238: invokevirtual 801	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   4241: istore 9
    //   4243: aload_0
    //   4244: getfield 1016	autg:jdField_a_of_type_Zon	Lzon;
    //   4247: ifnonnull +17 -> 4264
    //   4250: aload_0
    //   4251: invokestatic 1021	zon:a	()Lzon;
    //   4254: putfield 1016	autg:jdField_a_of_type_Zon	Lzon;
    //   4257: aload_0
    //   4258: getfield 1016	autg:jdField_a_of_type_Zon	Lzon;
    //   4261: invokevirtual 1023	zon:a	()V
    //   4264: aload_0
    //   4265: getfield 1016	autg:jdField_a_of_type_Zon	Lzon;
    //   4268: iload 9
    //   4270: invokevirtual 1025	zon:a	(Z)V
    //   4273: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4276: ifeq -3206 -> 1070
    //   4279: ldc 85
    //   4281: iconst_2
    //   4282: new 87	java/lang/StringBuilder
    //   4285: dup
    //   4286: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   4289: ldc_w 1027
    //   4292: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4295: aload_1
    //   4296: invokevirtual 983	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4299: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4302: invokestatic 812	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4305: goto -3235 -> 1070
    //   4308: astore_1
    //   4309: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4312: ifeq -3242 -> 1070
    //   4315: ldc 85
    //   4317: iconst_2
    //   4318: ldc_w 985
    //   4321: aload_1
    //   4322: invokestatic 694	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   4325: goto -3255 -> 1070
    //   4328: ldc_w 1029
    //   4331: aload 4
    //   4333: invokevirtual 355	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4336: ifeq +146 -> 4482
    //   4339: new 161	org/json/JSONObject
    //   4342: dup
    //   4343: aload 5
    //   4345: iconst_0
    //   4346: aaload
    //   4347: invokespecial 163	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   4350: astore_1
    //   4351: aload_1
    //   4352: ldc_w 1031
    //   4355: invokevirtual 225	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4358: astore_2
    //   4359: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4362: ifeq +29 -> 4391
    //   4365: ldc 85
    //   4367: iconst_2
    //   4368: new 87	java/lang/StringBuilder
    //   4371: dup
    //   4372: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   4375: ldc_w 1033
    //   4378: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4381: aload_2
    //   4382: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4385: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4388: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4391: aload_0
    //   4392: getfield 183	autg:jdField_a_of_type_Bgzu	Lbgzu;
    //   4395: invokeinterface 1036 1 0
    //   4400: astore_2
    //   4401: aload_2
    //   4402: ifnull -3332 -> 1070
    //   4405: aload_2
    //   4406: invokevirtual 1040	com/tencent/biz/pubaccount/CustomWebView:getPluginEngine	()Lcom/tencent/mobileqq/webview/swift/WebViewPluginEngine;
    //   4409: astore_2
    //   4410: aload_2
    //   4411: iconst_1
    //   4412: anewarray 71	java/lang/String
    //   4415: dup
    //   4416: iconst_0
    //   4417: ldc_w 1042
    //   4420: aastore
    //   4421: invokevirtual 1047	com/tencent/mobileqq/webview/swift/WebViewPluginEngine:a	([Ljava/lang/String;)V
    //   4424: aload_2
    //   4425: ldc_w 1042
    //   4428: invokevirtual 1050	com/tencent/mobileqq/webview/swift/WebViewPluginEngine:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;
    //   4431: astore_2
    //   4432: aload_2
    //   4433: ifnull -3363 -> 1070
    //   4436: aload_2
    //   4437: instanceof 1052
    //   4440: ifeq -3370 -> 1070
    //   4443: aload_2
    //   4444: checkcast 1052	aadq
    //   4447: aload_1
    //   4448: ldc_w 1054
    //   4451: invokevirtual 173	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   4454: aload_1
    //   4455: ldc_w 1056
    //   4458: invokevirtual 173	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   4461: aload_1
    //   4462: ldc_w 1058
    //   4465: invokevirtual 173	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   4468: invokevirtual 1061	aadq:a	(III)V
    //   4471: goto -3401 -> 1070
    //   4474: astore_1
    //   4475: aload_1
    //   4476: invokevirtual 652	org/json/JSONException:printStackTrace	()V
    //   4479: goto -3409 -> 1070
    //   4482: ldc_w 1063
    //   4485: aload 4
    //   4487: invokevirtual 355	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4490: ifeq +130 -> 4620
    //   4493: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4496: ifeq +30 -> 4526
    //   4499: ldc 85
    //   4501: iconst_2
    //   4502: new 87	java/lang/StringBuilder
    //   4505: dup
    //   4506: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   4509: ldc_w 1065
    //   4512: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4515: aload 5
    //   4517: invokevirtual 983	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4520: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4523: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4526: aload 5
    //   4528: ifnull -3458 -> 1070
    //   4531: aload 5
    //   4533: arraylength
    //   4534: ifle -3464 -> 1070
    //   4537: new 161	org/json/JSONObject
    //   4540: dup
    //   4541: aload 5
    //   4543: iconst_0
    //   4544: aaload
    //   4545: invokespecial 163	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   4548: astore_1
    //   4549: aload_1
    //   4550: ldc_w 1067
    //   4553: invokevirtual 225	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4556: astore_2
    //   4557: aload_1
    //   4558: ldc 222
    //   4560: invokevirtual 225	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4563: astore_1
    //   4564: aload_1
    //   4565: invokestatic 47	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4568: ifne -3498 -> 1070
    //   4571: aload_2
    //   4572: invokestatic 1070	awkh:a	(Ljava/lang/String;)Ljava/lang/String;
    //   4575: astore_2
    //   4576: new 161	org/json/JSONObject
    //   4579: dup
    //   4580: invokespecial 291	org/json/JSONObject:<init>	()V
    //   4583: astore_3
    //   4584: aload_3
    //   4585: ldc_w 1072
    //   4588: aload_2
    //   4589: invokevirtual 308	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   4592: pop
    //   4593: aload_0
    //   4594: aload_1
    //   4595: iconst_1
    //   4596: anewarray 71	java/lang/String
    //   4599: dup
    //   4600: iconst_0
    //   4601: aload_3
    //   4602: invokevirtual 309	org/json/JSONObject:toString	()Ljava/lang/String;
    //   4605: aastore
    //   4606: invokevirtual 230	autg:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   4609: goto -3539 -> 1070
    //   4612: astore_1
    //   4613: aload_1
    //   4614: invokevirtual 652	org/json/JSONException:printStackTrace	()V
    //   4617: goto -3547 -> 1070
    //   4620: ldc_w 1074
    //   4623: aload 4
    //   4625: invokevirtual 355	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4628: ifeq +130 -> 4758
    //   4631: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4634: ifeq +30 -> 4664
    //   4637: ldc 85
    //   4639: iconst_2
    //   4640: new 87	java/lang/StringBuilder
    //   4643: dup
    //   4644: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   4647: ldc_w 1076
    //   4650: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4653: aload 5
    //   4655: invokevirtual 983	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4658: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4661: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4664: aload 5
    //   4666: ifnull -3596 -> 1070
    //   4669: aload 5
    //   4671: arraylength
    //   4672: ifle -3602 -> 1070
    //   4675: new 161	org/json/JSONObject
    //   4678: dup
    //   4679: aload 5
    //   4681: iconst_0
    //   4682: aaload
    //   4683: invokespecial 163	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   4686: astore_1
    //   4687: aload_1
    //   4688: ldc_w 1078
    //   4691: invokevirtual 225	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4694: astore_2
    //   4695: aload_1
    //   4696: ldc 222
    //   4698: invokevirtual 225	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4701: astore_1
    //   4702: aload_1
    //   4703: invokestatic 47	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4706: ifne -3636 -> 1070
    //   4709: aload_2
    //   4710: invokestatic 1079	awkh:b	(Ljava/lang/String;)Ljava/lang/String;
    //   4713: astore_2
    //   4714: new 161	org/json/JSONObject
    //   4717: dup
    //   4718: invokespecial 291	org/json/JSONObject:<init>	()V
    //   4721: astore_3
    //   4722: aload_3
    //   4723: ldc_w 1081
    //   4726: aload_2
    //   4727: invokevirtual 308	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   4730: pop
    //   4731: aload_0
    //   4732: aload_1
    //   4733: iconst_1
    //   4734: anewarray 71	java/lang/String
    //   4737: dup
    //   4738: iconst_0
    //   4739: aload_3
    //   4740: invokevirtual 309	org/json/JSONObject:toString	()Ljava/lang/String;
    //   4743: aastore
    //   4744: invokevirtual 230	autg:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   4747: goto -3677 -> 1070
    //   4750: astore_1
    //   4751: aload_1
    //   4752: invokevirtual 652	org/json/JSONException:printStackTrace	()V
    //   4755: goto -3685 -> 1070
    //   4758: ldc_w 1083
    //   4761: aload 4
    //   4763: invokevirtual 355	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4766: ifeq +109 -> 4875
    //   4769: new 161	org/json/JSONObject
    //   4772: dup
    //   4773: aload 5
    //   4775: iconst_0
    //   4776: aaload
    //   4777: invokespecial 163	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   4780: ldc_w 1085
    //   4783: invokevirtual 225	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4786: astore_1
    //   4787: aload_0
    //   4788: getfield 1016	autg:jdField_a_of_type_Zon	Lzon;
    //   4791: ifnonnull +17 -> 4808
    //   4794: aload_0
    //   4795: invokestatic 1021	zon:a	()Lzon;
    //   4798: putfield 1016	autg:jdField_a_of_type_Zon	Lzon;
    //   4801: aload_0
    //   4802: getfield 1016	autg:jdField_a_of_type_Zon	Lzon;
    //   4805: invokevirtual 1023	zon:a	()V
    //   4808: aload_0
    //   4809: getfield 1016	autg:jdField_a_of_type_Zon	Lzon;
    //   4812: iconst_1
    //   4813: aload_1
    //   4814: invokevirtual 1088	zon:a	(ZLjava/lang/String;)V
    //   4817: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4820: ifeq -3750 -> 1070
    //   4823: ldc 85
    //   4825: iconst_2
    //   4826: new 87	java/lang/StringBuilder
    //   4829: dup
    //   4830: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   4833: ldc_w 1090
    //   4836: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4839: aload 5
    //   4841: iconst_0
    //   4842: aaload
    //   4843: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4846: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4849: invokestatic 812	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4852: goto -3782 -> 1070
    //   4855: astore_1
    //   4856: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4859: ifeq -3789 -> 1070
    //   4862: ldc 85
    //   4864: iconst_2
    //   4865: ldc_w 1092
    //   4868: aload_1
    //   4869: invokestatic 694	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   4872: goto -3802 -> 1070
    //   4875: ldc_w 1094
    //   4878: aload 4
    //   4880: invokevirtual 355	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4883: ifeq -3813 -> 1070
    //   4886: aload_0
    //   4887: getfield 36	autg:mRuntime	Lbgve;
    //   4890: invokevirtual 670	bgve:a	()Landroid/app/Activity;
    //   4893: astore_1
    //   4894: aload_1
    //   4895: ifnull -3825 -> 1070
    //   4898: aload_1
    //   4899: invokevirtual 676	android/app/Activity:getIntent	()Landroid/content/Intent;
    //   4902: astore_1
    //   4903: new 161	org/json/JSONObject
    //   4906: dup
    //   4907: aload 5
    //   4909: iconst_0
    //   4910: aaload
    //   4911: invokespecial 163	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   4914: astore_3
    //   4915: aload_3
    //   4916: ldc_w 1096
    //   4919: invokevirtual 225	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4922: astore_2
    //   4923: aload_3
    //   4924: ldc_w 1098
    //   4927: invokevirtual 225	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4930: astore_3
    //   4931: aload_2
    //   4932: invokestatic 47	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4935: ifne +31 -> 4966
    //   4938: aload_1
    //   4939: ifnull +27 -> 4966
    //   4942: aload_1
    //   4943: ldc_w 1100
    //   4946: aload_2
    //   4947: invokevirtual 1104	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   4950: pop
    //   4951: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4954: ifeq +12 -> 4966
    //   4957: ldc 85
    //   4959: iconst_2
    //   4960: ldc_w 1106
    //   4963: invokestatic 141	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4966: aload_3
    //   4967: invokestatic 47	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4970: ifne -3900 -> 1070
    //   4973: aload_1
    //   4974: ifnull -3904 -> 1070
    //   4977: aload_1
    //   4978: ldc_w 1108
    //   4981: aload_3
    //   4982: invokevirtual 1104	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   4985: pop
    //   4986: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4989: ifeq -3919 -> 1070
    //   4992: ldc 85
    //   4994: iconst_2
    //   4995: ldc_w 1110
    //   4998: invokestatic 141	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5001: goto -3931 -> 1070
    //   5004: astore_1
    //   5005: ldc 85
    //   5007: iconst_2
    //   5008: ldc_w 1112
    //   5011: aload_1
    //   5012: invokestatic 1114	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   5015: goto -3945 -> 1070
    //   5018: iconst_0
    //   5019: ireturn
    //   5020: astore_2
    //   5021: goto -3167 -> 1854
    //   5024: astore_1
    //   5025: goto -3875 -> 1150
    //   5028: astore 4
    //   5030: goto -3948 -> 1082
    //   5033: astore 4
    //   5035: goto -3953 -> 1082
    //   5038: iconst_1
    //   5039: istore 6
    //   5041: goto -1590 -> 3451
    //   5044: aconst_null
    //   5045: astore_1
    //   5046: goto -2947 -> 2099
    //   5049: ldc_w 756
    //   5052: astore_1
    //   5053: goto -3117 -> 1936
    //   5056: goto -3276 -> 1780
    //   5059: goto -4656 -> 403
    //   5062: aload_1
    //   5063: astore 4
    //   5065: goto -4620 -> 445
    //   5068: aload_1
    //   5069: astore_3
    //   5070: goto -4609 -> 461
    //   5073: goto -4993 -> 80
    //   5076: iconst_0
    //   5077: istore 6
    //   5079: goto -1628 -> 3451
    //   5082: iconst_0
    //   5083: istore 9
    //   5085: goto -1112 -> 3973
    //   5088: iconst_0
    //   5089: istore 9
    //   5091: goto -1118 -> 3973
    //   5094: iconst_0
    //   5095: istore 9
    //   5097: goto -1124 -> 3973
    //   5100: iconst_0
    //   5101: istore 9
    //   5103: goto -1130 -> 3973
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	5106	0	this	autg
    //   0	5106	1	paramJsBridgeListener	com.tencent.mobileqq.webview.swift.JsBridgeListener
    //   0	5106	2	paramString1	String
    //   0	5106	3	paramString2	String
    //   0	5106	4	paramString3	String
    //   0	5106	5	paramVarArgs	String[]
    //   161	4917	6	i	int
    //   2335	316	7	j	int
    //   2345	136	8	k	int
    //   172	4930	9	bool1	boolean
    //   2532	1637	10	bool2	boolean
    //   43	3318	11	localObject1	Object
    //   225	3206	12	localObject2	Object
    //   183	3099	13	str1	String
    //   216	3175	14	localObject3	Object
    //   232	2255	15	str2	String
    //   194	2295	16	str3	String
    //   87	699	17	localAppInterface	AppInterface
    //   205	492	18	str4	String
    // Exception table:
    //   from	to	target	type
    //   291	334	1078	java/lang/Exception
    //   27	57	1139	org/json/JSONException
    //   62	80	1139	org/json/JSONException
    //   80	105	1139	org/json/JSONException
    //   105	129	1139	org/json/JSONException
    //   131	145	1139	org/json/JSONException
    //   145	160	1139	org/json/JSONException
    //   163	291	1139	org/json/JSONException
    //   452	458	1139	org/json/JSONException
    //   461	471	1139	org/json/JSONException
    //   481	515	1139	org/json/JSONException
    //   515	628	1139	org/json/JSONException
    //   628	777	1139	org/json/JSONException
    //   777	914	1139	org/json/JSONException
    //   914	1044	1139	org/json/JSONException
    //   1044	1070	1139	org/json/JSONException
    //   1128	1134	1139	org/json/JSONException
    //   1154	1160	1139	org/json/JSONException
    //   1160	1162	1139	org/json/JSONException
    //   291	334	1147	finally
    //   1256	1282	1327	org/json/JSONException
    //   1288	1299	1327	org/json/JSONException
    //   1299	1324	1327	org/json/JSONException
    //   1353	1379	1327	org/json/JSONException
    //   1379	1394	1327	org/json/JSONException
    //   1405	1431	1327	org/json/JSONException
    //   1434	1458	1327	org/json/JSONException
    //   1458	1469	1327	org/json/JSONException
    //   1483	1571	1574	org/json/JSONException
    //   1600	1660	1711	org/json/JSONException
    //   1664	1672	1711	org/json/JSONException
    //   1676	1687	1711	org/json/JSONException
    //   1695	1708	1711	org/json/JSONException
    //   1719	1724	1711	org/json/JSONException
    //   1745	1772	1851	org/json/JSONException
    //   1879	1916	1955	java/lang/Exception
    //   1920	1925	1955	java/lang/Exception
    //   1929	1936	1955	java/lang/Exception
    //   1936	1952	1955	java/lang/Exception
    //   2010	2099	2158	java/lang/Exception
    //   2099	2129	2158	java/lang/Exception
    //   2129	2155	2158	java/lang/Exception
    //   2178	2200	2158	java/lang/Exception
    //   2221	2395	2446	org/json/JSONException
    //   2397	2409	2446	org/json/JSONException
    //   2409	2443	2446	org/json/JSONException
    //   2466	2493	2446	org/json/JSONException
    //   2496	2571	2446	org/json/JSONException
    //   2575	2581	2446	org/json/JSONException
    //   2586	2622	2446	org/json/JSONException
    //   2627	2639	2446	org/json/JSONException
    //   2639	2663	2446	org/json/JSONException
    //   2666	2681	2446	org/json/JSONException
    //   2710	2765	2791	org/json/JSONException
    //   2765	2788	2791	org/json/JSONException
    //   2830	2846	2791	org/json/JSONException
    //   2849	2864	2791	org/json/JSONException
    //   2885	2949	2952	org/json/JSONException
    //   3009	3057	3500	org/json/JSONException
    //   3061	3137	3500	org/json/JSONException
    //   3144	3151	3500	org/json/JSONException
    //   3160	3252	3500	org/json/JSONException
    //   3260	3314	3500	org/json/JSONException
    //   3314	3368	3500	org/json/JSONException
    //   3368	3448	3500	org/json/JSONException
    //   3451	3497	3500	org/json/JSONException
    //   3556	3568	3649	org/json/JSONException
    //   3570	3577	3649	org/json/JSONException
    //   3579	3586	3649	org/json/JSONException
    //   3588	3597	3649	org/json/JSONException
    //   3599	3608	3649	org/json/JSONException
    //   3610	3618	3649	org/json/JSONException
    //   3620	3637	3649	org/json/JSONException
    //   3639	3646	3649	org/json/JSONException
    //   3697	3733	3781	java/lang/Exception
    //   3737	3746	3781	java/lang/Exception
    //   3746	3778	3781	java/lang/Exception
    //   3840	3890	3998	org/json/JSONException
    //   3897	3905	3998	org/json/JSONException
    //   3909	3973	3998	org/json/JSONException
    //   3982	3995	3998	org/json/JSONException
    //   4018	4039	3998	org/json/JSONException
    //   4042	4067	3998	org/json/JSONException
    //   4073	4098	3998	org/json/JSONException
    //   4104	4134	3998	org/json/JSONException
    //   4137	4162	3998	org/json/JSONException
    //   4172	4197	3998	org/json/JSONException
    //   4221	4264	4308	java/lang/Exception
    //   4264	4305	4308	java/lang/Exception
    //   4339	4391	4474	org/json/JSONException
    //   4391	4401	4474	org/json/JSONException
    //   4405	4432	4474	org/json/JSONException
    //   4436	4471	4474	org/json/JSONException
    //   4537	4609	4612	org/json/JSONException
    //   4675	4747	4750	org/json/JSONException
    //   4769	4808	4855	java/lang/Exception
    //   4808	4852	4855	java/lang/Exception
    //   4886	4894	5004	java/lang/Exception
    //   4898	4938	5004	java/lang/Exception
    //   4942	4966	5004	java/lang/Exception
    //   4966	4973	5004	java/lang/Exception
    //   4977	5001	5004	java/lang/Exception
    //   1780	1793	5020	org/json/JSONException
    //   1797	1824	5020	org/json/JSONException
    //   340	349	5024	finally
    //   351	368	5024	finally
    //   370	378	5024	finally
    //   380	400	5024	finally
    //   408	414	5024	finally
    //   416	442	5024	finally
    //   1084	1090	5024	finally
    //   1092	1122	5024	finally
    //   340	349	5028	java/lang/Exception
    //   351	368	5028	java/lang/Exception
    //   370	378	5028	java/lang/Exception
    //   380	400	5028	java/lang/Exception
    //   408	414	5033	java/lang/Exception
    //   416	442	5033	java/lang/Exception
  }
  
  public void onCreate()
  {
    super.onCreate();
    ardu.a().a(this.jdField_a_of_type_Aqyp);
    bguj localbguj = this.mRuntime.a(this.mRuntime.a());
    if ((localbguj != null) && ((localbguj instanceof bgzs))) {
      this.jdField_a_of_type_Bgzs = ((bgzs)localbguj);
    }
    localbguj = this.mRuntime.a(this.mRuntime.a());
    if ((localbguj != null) && ((localbguj instanceof bgzu))) {
      this.jdField_a_of_type_Bgzu = ((bgzu)localbguj);
    }
    localbguj = this.mRuntime.a(this.mRuntime.a());
    if ((localbguj != null) && ((localbguj instanceof bgzw))) {
      this.jdField_a_of_type_Bgzw = ((bgzw)localbguj);
    }
    localbguj = this.mRuntime.a(this.mRuntime.a());
    if ((localbguj != null) && ((localbguj instanceof bgzi))) {
      this.jdField_a_of_type_Bgzi = ((bgzi)localbguj);
    }
  }
  
  public void onDestroy()
  {
    ardu.a().b(this.jdField_a_of_type_Aqyp);
    if (this.jdField_a_of_type_Zon != null) {
      this.jdField_a_of_type_Zon.b();
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     autg
 * JD-Core Version:    0.7.0.1
 */
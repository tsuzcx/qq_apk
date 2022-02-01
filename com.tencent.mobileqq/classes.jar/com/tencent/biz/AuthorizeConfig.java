package com.tencent.biz;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Looper;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.authorize.AbstractConfig;
import com.tencent.biz.authorize.FlatBuffersConfig;
import com.tencent.biz.authorize.JsonConfig;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.flatbuffers.FlatBuffersParser;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.TicketAuthorizeConfBean;
import com.tencent.mobileqq.config.business.WVPreloadPskeyConfBean;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.mobileqq.webview.authorize.IAuthorizeConfigDownloadInjector;
import com.tencent.mobileqq.webview.authorize.IAuthorizeConfigInjector;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils;
import com.tencent.mobileqq.webview.util.WebViewConstant;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Set<Ljava.lang.String;>;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;
import oicq.wlogin_sdk.request.WtTicketPromise;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AuthorizeConfig
{
  protected static AuthorizeConfig A;
  private static final List<String> F;
  private static final Object G = new Object();
  private static final Object I = new Object();
  private static long J;
  public static final String[] a = { "skey", "pskey", "a1", "a2", "ptlogin2", "pt4_token" };
  protected static final ArrayMap<String, String> b = new ArrayMap(a.length);
  protected static volatile long d;
  protected static volatile long e;
  static final AtomicBoolean z;
  WtTicketPromise B = new AuthorizeConfig.4(this);
  protected ArrayList<String> C = new ArrayList();
  private ArrayList<IAuthorizeConfigInjector> D = new ArrayList();
  private IAuthorizeConfigDownloadInjector E;
  private boolean H = false;
  public final AtomicInteger c = new AtomicInteger(-1);
  protected volatile JSONObject f;
  protected volatile JSONObject g;
  protected volatile JSONObject h;
  protected volatile JSONArray i;
  protected volatile JSONArray j;
  protected volatile JSONArray k;
  protected volatile int l = -1;
  protected volatile JSONArray m;
  protected volatile JSONArray n;
  protected volatile long o;
  protected volatile JSONObject p;
  public volatile JSONObject q;
  protected volatile JSONObject r;
  protected volatile long s = -1L;
  protected final ConcurrentHashMap<String, JSONArray> t = new ConcurrentHashMap(a.length);
  protected final ConcurrentHashMap<String, Set<String>> u = new ConcurrentHashMap(a.length);
  Context v;
  SharedPreferences w;
  JsonConfig x;
  FlatBuffersConfig y;
  
  static
  {
    b.put("skey", "[\"*.qq.com\",\"*.tenpay.com\"]");
    b.put("pskey", "[\"qun.qq.com\",\"game.qq.com\",\"kg.qq.com\",\"id.qq.com\",\"qzone.qq.com\",\"qzone.com\",\"openmobile.qq.com\", \"tenpay.com\", \"buluo.qq.com\", \"docs.qq.com\",\"ti.qq.com\",\"accounts.qq.com\"]");
    b.put("a1", "[]");
    b.put("a2", "[\"aq.qq.com\",\"weloan.tenpay.com\"]");
    b.put("ptlogin2", "[\"http://ptlogin2.qq.com\",\"https://ssl.ptlogin2.qq.com\", \"https://ptlogin2.qq.com\"]");
    b.put("pt4_token", "[\"gamecenter.qq.com\",\"imgcache.qq.com\",\"vip.qq.com\",\"haoma.qq.com\"]");
    d = -1L;
    e = -1L;
    F = Arrays.asList(new String[] { "ti.qq.com", "accounts.qq.com", "graph.qq.com" });
    z = new AtomicBoolean(false);
  }
  
  private AuthorizeConfig(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AuthorizeConfig", 2, "AuthorizeConfig init");
    }
    a(paramContext);
  }
  
  public static AuthorizeConfig a()
  {
    if (A == null) {
      try
      {
        if (A == null) {
          A = new AuthorizeConfig(BaseApplication.getContext());
        }
      }
      finally {}
    }
    A.c();
    if (!A.b(true)) {
      A.q();
    }
    return A;
  }
  
  public static AuthorizeConfig a(boolean paramBoolean)
  {
    if (A == null) {
      try
      {
        if (A == null) {
          A = new AuthorizeConfig(BaseApplication.getContext());
        }
      }
      finally {}
    }
    A.c();
    A.b(paramBoolean);
    return A;
  }
  
  private static String a(String paramString1, String paramString2, Set<String> paramSet)
  {
    Object localObject1;
    if (!TextUtils.isEmpty(paramString2))
    {
      localObject1 = Uri.parse(paramString2);
      Object localObject2 = ((Uri)localObject1).getScheme();
      if ((!"http".equals(localObject2)) && (!"https".equals(localObject2))) {
        return "";
      }
      if (((Uri)localObject1).isHierarchical())
      {
        localObject1 = ((Uri)localObject1).getHost();
        if (localObject1 != null)
        {
          localObject1 = ((String)localObject1).toLowerCase();
          if (paramSet.contains(localObject1))
          {
            paramSet = (Set<String>)localObject1;
            break label149;
          }
          localObject2 = paramSet.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            paramSet = (String)((Iterator)localObject2).next();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(".");
            localStringBuilder.append(paramSet);
            if (((String)localObject1).endsWith(localStringBuilder.toString())) {
              break label149;
            }
          }
        }
      }
    }
    paramSet = "";
    label149:
    if (QLog.isColorLevel())
    {
      if (!TextUtils.isEmpty(paramSet))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramSet);
        ((StringBuilder)localObject1).append(" need ");
        ((StringBuilder)localObject1).append(paramString1);
        ((StringBuilder)localObject1).append(" which extract from ");
        ((StringBuilder)localObject1).append(paramString2);
        QLog.d("AuthorizeConfig", 2, ((StringBuilder)localObject1).toString());
        return paramSet;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString2);
      ((StringBuilder)localObject1).append(" not need ");
      ((StringBuilder)localObject1).append(paramString1);
      QLog.d("AuthorizeConfig", 2, ((StringBuilder)localObject1).toString());
    }
    return paramSet;
  }
  
  /* Error */
  public static String a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_1
    //   4: new 292	java/io/ByteArrayOutputStream
    //   7: dup
    //   8: invokespecial 293	java/io/ByteArrayOutputStream:<init>	()V
    //   11: astore_2
    //   12: new 295	java/util/zip/Inflater
    //   15: dup
    //   16: invokespecial 296	java/util/zip/Inflater:<init>	()V
    //   19: astore_1
    //   20: aload_1
    //   21: aload_0
    //   22: invokevirtual 300	java/util/zip/Inflater:setInput	([B)V
    //   25: sipush 1024
    //   28: newarray byte
    //   30: astore_0
    //   31: aload_1
    //   32: invokevirtual 303	java/util/zip/Inflater:finished	()Z
    //   35: ifne +17 -> 52
    //   38: aload_2
    //   39: aload_0
    //   40: iconst_0
    //   41: aload_1
    //   42: aload_0
    //   43: invokevirtual 307	java/util/zip/Inflater:inflate	([B)I
    //   46: invokevirtual 311	java/io/ByteArrayOutputStream:write	([BII)V
    //   49: goto -18 -> 31
    //   52: aload_1
    //   53: invokevirtual 314	java/util/zip/Inflater:end	()V
    //   56: new 68	java/lang/String
    //   59: dup
    //   60: aload_2
    //   61: invokevirtual 318	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   64: invokespecial 320	java/lang/String:<init>	([B)V
    //   67: astore_0
    //   68: aload_2
    //   69: invokevirtual 323	java/io/ByteArrayOutputStream:close	()V
    //   72: aload_0
    //   73: areturn
    //   74: astore_1
    //   75: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   78: ifeq +12 -> 90
    //   81: ldc 181
    //   83: iconst_2
    //   84: ldc 234
    //   86: aload_1
    //   87: invokestatic 326	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   90: aload_0
    //   91: areturn
    //   92: astore_0
    //   93: goto +69 -> 162
    //   96: astore_1
    //   97: aload_2
    //   98: astore_0
    //   99: aload_1
    //   100: astore_2
    //   101: goto +12 -> 113
    //   104: astore_0
    //   105: aload_1
    //   106: astore_2
    //   107: goto +55 -> 162
    //   110: astore_2
    //   111: aload_3
    //   112: astore_0
    //   113: aload_0
    //   114: astore_1
    //   115: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   118: ifeq +14 -> 132
    //   121: aload_0
    //   122: astore_1
    //   123: ldc 181
    //   125: iconst_2
    //   126: ldc 234
    //   128: aload_2
    //   129: invokestatic 326	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   132: aload_0
    //   133: ifnull +26 -> 159
    //   136: aload_0
    //   137: invokevirtual 323	java/io/ByteArrayOutputStream:close	()V
    //   140: ldc 234
    //   142: areturn
    //   143: astore_0
    //   144: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   147: ifeq +12 -> 159
    //   150: ldc 181
    //   152: iconst_2
    //   153: ldc 234
    //   155: aload_0
    //   156: invokestatic 326	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   159: ldc 234
    //   161: areturn
    //   162: aload_2
    //   163: ifnull +26 -> 189
    //   166: aload_2
    //   167: invokevirtual 323	java/io/ByteArrayOutputStream:close	()V
    //   170: goto +19 -> 189
    //   173: astore_1
    //   174: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   177: ifeq +12 -> 189
    //   180: ldc 181
    //   182: iconst_2
    //   183: ldc 234
    //   185: aload_1
    //   186: invokestatic 326	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   189: goto +5 -> 194
    //   192: aload_0
    //   193: athrow
    //   194: goto -2 -> 192
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	197	0	paramArrayOfByte	byte[]
    //   3	50	1	localInflater	java.util.zip.Inflater
    //   74	13	1	localException1	Exception
    //   96	10	1	localThrowable1	Throwable
    //   114	9	1	arrayOfByte	byte[]
    //   173	13	1	localException2	Exception
    //   11	96	2	localObject1	Object
    //   110	57	2	localThrowable2	Throwable
    //   1	111	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   68	72	74	java/lang/Exception
    //   12	31	92	finally
    //   31	49	92	finally
    //   52	68	92	finally
    //   12	31	96	java/lang/Throwable
    //   31	49	96	java/lang/Throwable
    //   52	68	96	java/lang/Throwable
    //   4	12	104	finally
    //   115	121	104	finally
    //   123	132	104	finally
    //   4	12	110	java/lang/Throwable
    //   136	140	143	java/lang/Exception
    //   166	170	173	java/lang/Exception
  }
  
  private void a(NewIntent paramNewIntent)
  {
    paramNewIntent.setObserver(new AuthorizeConfig.3(this));
  }
  
  private boolean a(String paramString1, String paramString2, Uri paramUri)
  {
    if ("identification.loginVerify".equals(paramString2)) {
      return true;
    }
    if (("identification.identifyNoLogin".equals(paramString2)) && (F.contains(paramUri.getHost()))) {
      return true;
    }
    if ("faceUnblockCamera.startPTVActivity".equals(paramString2)) {
      return true;
    }
    return ("qbizApi.getClientInfo".equals(paramString2)) && (paramString1.startsWith("https://mysec.qq.com/v2/account_control/index.html"));
  }
  
  public static boolean b(String paramString1, String paramString2)
  {
    boolean bool2 = TextUtils.isEmpty(paramString1);
    boolean bool1 = false;
    if (!bool2)
    {
      if (TextUtils.isEmpty(paramString2)) {
        return false;
      }
      if ("*".equals(paramString1)) {
        return true;
      }
      if ("*.*".equals(paramString1))
      {
        if (paramString2.indexOf('.') != -1) {
          bool1 = true;
        }
        return bool1;
      }
      if (paramString1.startsWith("*")) {
        return paramString2.endsWith(paramString1.substring(1));
      }
      if (paramString1.endsWith("*")) {
        return paramString2.startsWith(paramString1.substring(0, paramString1.length() - 1));
      }
      return paramString2.equals(paramString1);
    }
    return false;
  }
  
  private boolean g(String paramString1, String paramString2)
  {
    Iterator localIterator = this.D.iterator();
    while (localIterator.hasNext()) {
      if (((IAuthorizeConfigInjector)localIterator.next()).a(paramString1, paramString2)) {
        return true;
      }
    }
    return false;
  }
  
  private String h(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (paramString1.startsWith(paramString2)) {
      str = paramString1.substring(paramString2.length());
    }
    return str;
  }
  
  private JSONArray s(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return new JSONArray();
    }
    Object localObject1 = (JSONArray)this.t.get(paramString);
    if (localObject1 == null) {}
    for (;;)
    {
      Object localObject2;
      synchronized (this.t)
      {
        localObject2 = (JSONArray)this.t.get(paramString);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject2 = n(paramString);
          if (localObject2 == null)
          {
            try
            {
              JSONArray localJSONArray = new JSONArray((String)b.get(paramString));
              localObject1 = localJSONArray;
              try
              {
                if (!QLog.isColorLevel()) {
                  continue;
                }
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("Load local default config for ");
                ((StringBuilder)localObject1).append(paramString);
                QLog.e("AuthorizeConfig", 2, ((StringBuilder)localObject1).toString());
                localObject1 = localJSONArray;
              }
              catch (JSONException localJSONException3)
              {
                localObject2 = localJSONArray;
              }
              localObject1 = localObject2;
            }
            catch (JSONException localJSONException4) {}
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("Decode builtin ");
              ((StringBuilder)localObject1).append(paramString);
              ((StringBuilder)localObject1).append(" config failed ");
              ((StringBuilder)localObject1).append(localJSONException4.getMessage());
              QLog.e("AuthorizeConfig", 2, ((StringBuilder)localObject1).toString());
              localObject1 = localObject2;
            }
          }
          else
          {
            boolean bool = "pskey".equals(paramString);
            if (!bool) {
              break label438;
            }
            Object localObject3 = null;
            int i2 = 0;
            try
            {
              localObject1 = new JSONArray((String)b.get("pskey"));
              try
              {
                i1 = ((JSONArray)localObject1).length();
              }
              catch (JSONException localJSONException1) {}
              localJSONException2.printStackTrace();
            }
            catch (JSONException localJSONException2)
            {
              localObject1 = localObject3;
            }
            int i1 = 0;
            if (i2 < i1)
            {
              ((JSONArray)localObject2).put(((JSONArray)localObject1).optString(i2));
              i2 += 1;
              continue;
            }
            if (!QLog.isColorLevel()) {
              break label438;
            }
            QLog.d("AuthorizeConfig", 2, "p_skey need merge server and local config");
            break label438;
          }
          localObject2 = localObject1;
          if (localObject1 == null)
          {
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(paramString);
              ((StringBuilder)localObject1).append(" config is null, please check server and local configuration!");
              QLog.e("AuthorizeConfig", 2, ((StringBuilder)localObject1).toString());
            }
            localObject2 = new JSONArray();
          }
          this.t.put(paramString, localObject2);
          this.u.remove(paramString);
          localObject1 = localObject2;
        }
        return localObject1;
      }
      return localObject1;
      label438:
      localObject1 = localObject2;
    }
  }
  
  private void t()
  {
    try
    {
      if (AuthorizeConfigInjectUtil.a != null)
      {
        Iterator localIterator = AuthorizeConfigInjectUtil.a.iterator();
        while (localIterator.hasNext())
        {
          IAuthorizeConfigInjector localIAuthorizeConfigInjector = (IAuthorizeConfigInjector)((Class)localIterator.next()).newInstance();
          this.D.add(localIAuthorizeConfigInjector);
        }
      }
      if ((AuthorizeConfigInjectUtil.b != null) && (AuthorizeConfigInjectUtil.b.size() > 0))
      {
        this.E = ((IAuthorizeConfigDownloadInjector)((Class)AuthorizeConfigInjectUtil.b.get(0)).newInstance());
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("AuthorizeConfig", 1, "initBusinessInjetor Fail,", localThrowable);
    }
  }
  
  private boolean u()
  {
    for (;;)
    {
      boolean bool;
      synchronized (this.c)
      {
        i1 = this.c.get();
        bool = false;
        if (i1 == 1) {
          return false;
        }
        if (this.c.get() == 3) {
          return true;
        }
        if (this.c.get() != -1) {
          break label125;
        }
        if (MobileQQ.sProcessId == 1)
        {
          i1 = 1;
          this.c.set(0);
          long l1 = System.currentTimeMillis() - e;
          if (l1 < 0L) {
            break label135;
          }
          if (l1 < 1800000L) {
            break label130;
          }
          break label135;
          return bool;
        }
      }
      int i1 = 0;
      continue;
      label125:
      i1 = 0;
      continue;
      label130:
      int i2 = 0;
      break label137;
      label135:
      i2 = 1;
      label137:
      if ((i1 != 0) || (i2 != 0)) {
        bool = true;
      }
    }
  }
  
  private JSONObject v()
  {
    JSONObject localJSONObject2 = this.f;
    System.currentTimeMillis();
    Object localObject = localJSONObject2;
    if (localJSONObject2 == null)
    {
      localObject = this.x.b();
      localJSONObject1 = localJSONObject2;
      if (localObject == null) {}
    }
    try
    {
      localJSONObject1 = new JSONObject((String)localObject);
    }
    catch (JSONException localJSONException)
    {
      label41:
      break label41;
    }
    JSONObject localJSONObject1 = localJSONObject2;
    if (QLog.isColorLevel())
    {
      QLog.d("AuthorizeConfig", 2, "Decode mOfflineConfig  error");
      localJSONObject1 = localJSONObject2;
    }
    localObject = localJSONObject1;
    if (localJSONObject1 == null) {
      localObject = new JSONObject();
    }
    return localObject;
  }
  
  private JSONObject w()
  {
    Object localObject2 = this.g;
    System.currentTimeMillis();
    Object localObject1 = localObject2;
    String str;
    if (localObject2 == null)
    {
      str = this.x.c();
      localObject1 = localObject2;
      if (str == null) {}
    }
    try
    {
      localObject1 = new JSONObject(str);
    }
    catch (JSONException localJSONException)
    {
      label41:
      break label41;
    }
    localObject1 = localObject2;
    if (QLog.isColorLevel())
    {
      QLog.d("AuthorizeConfig", 2, "Decode mExtraConfig error");
      localObject1 = localObject2;
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new JSONObject();
    }
    this.g = ((JSONObject)localObject2);
    localObject1 = localObject2;
    return localObject1;
  }
  
  private boolean x()
  {
    Iterator localIterator = this.D.iterator();
    while (localIterator.hasNext()) {
      if (((IAuthorizeConfigInjector)localIterator.next()).b()) {
        return true;
      }
    }
    return false;
  }
  
  protected void a(Context paramContext)
  {
    this.v = paramContext;
    this.w = this.v.getSharedPreferences("domainCmdRight", 4);
    this.y = new FlatBuffersConfig(this.w);
    this.x = new JsonConfig(this.w, this.y);
    this.y.a(this.x);
    FlatBuffersParser.j();
    t();
    s();
  }
  
  protected void a(String paramString1, String paramString2, String paramString3)
  {
    System.currentTimeMillis();
    SharedPreferences.Editor localEditor = this.w.edit();
    if (FlatBuffersParser.a()) {
      paramString1 = this.y.a(localEditor, paramString1);
    } else {
      paramString1 = this.x.a(localEditor, paramString1);
    }
    if (paramString1 == null) {
      return;
    }
    long l1 = this.s;
    this.s = this.w.getLong("publishSeq", this.s);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("update white list's publishSeq from ");
    localStringBuilder.append(l1);
    localStringBuilder.append(" to ");
    localStringBuilder.append(this.s);
    localStringBuilder.append(".");
    QLog.i("AuthorizeConfig", 1, localStringBuilder.toString());
    if (TextUtils.isEmpty(paramString1))
    {
      this.c.set(2);
      localEditor.putLong("lastUpdate", System.currentTimeMillis());
      localEditor.putString("qqVersion", "2013 8.8.17");
      localEditor.putString(paramString3, paramString2);
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("White list update completed as version=");
        paramString1.append(paramString2);
        QLog.d("AuthorizeConfig", 2, paramString1.toString());
      }
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "webview_whitelist", "update_ok", 0, 1, 0, "", "", "", "");
    }
    else
    {
      this.c.set(0);
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "webview_whitelist", "update_failed", 0, 1, 0, "", "", "", "");
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("Authorize config parse failed include: ");
        paramString2.append(paramString1);
        QLog.e("AuthorizeConfig", 2, paramString2.toString());
      }
    }
    localEditor.commit();
    n();
    q();
    this.t.clear();
    this.u.clear();
  }
  
  public boolean a(String paramString)
  {
    Object localObject = Uri.parse(paramString).getScheme();
    if ((!"http".equals(localObject)) && (!"https".equals(localObject))) {
      return false;
    }
    localObject = Uri.parse(paramString).getHost();
    paramString = (String)localObject;
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      paramString = ((String)localObject).toLowerCase();
    }
    localObject = s("skey");
    int i2 = ((JSONArray)localObject).length();
    int i1 = 0;
    while (i1 < i2)
    {
      if (b(((JSONArray)localObject).optString(i1), paramString)) {
        return true;
      }
      i1 += 1;
    }
    return false;
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    String str1 = paramString1;
    if (str1 == null) {
      return false;
    }
    Object localObject = Uri.parse(paramString1);
    String str2 = ((Uri)localObject).getScheme();
    if (paramString2.startsWith("guild")) {
      return true;
    }
    if ("file".equals(str2))
    {
      localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
      paramString2 = str1;
      if (paramString1.length() > 200) {
        paramString2 = str1.substring(0, 200);
      }
      ReportController.b((AppRuntime)localObject, "dc00899", "Grp_tech_report", "", "webview", "file_js", 0, 0, paramString2, "", "", "");
      QLog.e("AuthorizeConfig", 1, "action deprecated with file protocol");
      return false;
    }
    if ((!"http".equals(str2)) && (!"https".equals(str2))) {
      return false;
    }
    if ("data.checkPermission".equals(paramString2)) {
      return str1.startsWith("https://qqweb.qq.com/m/whitelist/testing/");
    }
    if (paramString2.startsWith("CAPTCHA.")) {
      return true;
    }
    if ((paramString2.startsWith("login.openSmsPage")) && ("ti.qq.com".equals(((Uri)localObject).getHost()))) {
      return true;
    }
    if (a(str1, paramString2, (Uri)localObject)) {
      return true;
    }
    if (paramString2.startsWith("qq_live")) {
      return true;
    }
    System.currentTimeMillis();
    int i1 = this.x.a(((Uri)localObject).getHost(), paramString2);
    if (AbstractConfig.a(i1)) {
      return true;
    }
    if (AbstractConfig.b(i1)) {
      return false;
    }
    return g(paramString1, paramString2);
  }
  
  public boolean a(JSONObject paramJSONObject)
  {
    return SwiftWebViewUtils.a(paramJSONObject, "sonicWhiteList");
  }
  
  public long b()
  {
    if (-1L == this.s) {
      this.s = this.w.getLong("publishSeq", 0L);
    }
    return this.s;
  }
  
  public String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = paramString.split("\\?");
    JSONObject localJSONObject = v();
    if (localJSONObject.has(paramString[0])) {
      try
      {
        paramString = localJSONObject.getJSONObject(paramString[0]).getString("bid");
        return paramString;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d("AuthorizeConfig", 2, "getOfflineId error");
        }
      }
    }
    return null;
  }
  
  protected boolean b(boolean paramBoolean)
  {
    if (u())
    {
      this.c.set(1);
      ThreadManager.executeOnNetWorkThread(new AuthorizeConfig.2(this, paramBoolean));
      return true;
    }
    return false;
  }
  
  public String c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = paramString.split("\\?");
    JSONObject localJSONObject = v();
    if (localJSONObject.has(paramString[0])) {
      try
      {
        paramString = localJSONObject.getJSONObject(paramString[0]).getString("duck");
        return paramString;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d("AuthorizeConfig", 2, "getCheckUpType error");
        }
      }
    }
    return null;
  }
  
  public String c(String paramString1, String paramString2)
  {
    return w().optString(paramString1, paramString2);
  }
  
  protected void c()
  {
    ThreadManager.executeOnSubThread(new AuthorizeConfig.1(this));
  }
  
  public int d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    paramString = paramString.split("\\?");
    JSONObject localJSONObject = v();
    if (localJSONObject.has(paramString[0])) {
      try
      {
        int i1 = localJSONObject.getJSONObject(paramString[0]).getInt("delay");
        return i1;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d("AuthorizeConfig", 2, "getCheckUpDelayTime error");
        }
      }
    }
    return 0;
  }
  
  public Boolean d(String paramString1, String paramString2)
  {
    Object localObject1 = paramString1;
    int i2 = 0;
    Boolean localBoolean = Boolean.valueOf(false);
    if (localObject1 == null) {
      return localBoolean;
    }
    Object localObject2 = Uri.parse(paramString1);
    String str2 = ((Uri)localObject2).getScheme();
    if ("file".equals(str2))
    {
      localObject2 = MobileQQ.sMobileQQ.waitAppRuntime(null);
      paramString2 = (String)localObject1;
      if (paramString1.length() > 200) {
        paramString2 = ((String)localObject1).substring(0, 200);
      }
      ReportController.b((AppRuntime)localObject2, "dc00899", "Grp_tech_report", "", "webview", "file_jump", 0, 0, paramString2, "", "", "");
      QLog.e("AuthorizeConfig", 1, "action deprecated with file protocol");
      return localBoolean;
    }
    if ((!"http".equals(str2)) && (!"https".equals(str2))) {
      return localBoolean;
    }
    paramString1 = ((Uri)localObject2).getHost();
    localObject2 = paramString1;
    if (!TextUtils.isEmpty(paramString1)) {
      localObject2 = paramString1.toLowerCase();
    }
    localObject1 = this.h;
    System.currentTimeMillis();
    paramString1 = (String)localObject1;
    if (localObject1 == null)
    {
      str2 = this.x.d();
      paramString1 = (String)localObject1;
      if (str2 == null) {}
    }
    try
    {
      paramString1 = new JSONObject(str2);
    }
    catch (JSONException paramString1)
    {
      try
      {
        localObject1 = new JSONObject("{\"host\": [\"*.qq.com\",\"*.tenpay.com\"]}");
        this.h = ((JSONObject)localObject1);
        paramString1 = (String)localObject1;
        try
        {
          localObject1 = paramString1.getJSONArray("host");
          i3 = ((JSONArray)localObject1).length();
          i1 = 0;
          while (i1 < i3)
          {
            if (b(((JSONArray)localObject1).optString(i1), (String)localObject2)) {
              return Boolean.valueOf(true);
            }
            i1 += 1;
          }
        }
        catch (JSONException localJSONException2)
        {
          int i3;
          int i1;
          label308:
          label326:
          label357:
          label374:
          String str1;
          break label308;
        }
        try
        {
          localObject1 = paramString1.getJSONArray("scheme");
          i3 = ((JSONArray)localObject1).length();
          i1 = 0;
          if (i1 < i3)
          {
            if (((JSONArray)localObject1).optString(i1).equals(paramString2)) {
              return Boolean.valueOf(true);
            }
            i1 += 1;
            break label326;
          }
        }
        catch (JSONException localJSONException3)
        {
          break label357;
        }
        try
        {
          paramString1 = paramString1.getJSONArray("scheme_a");
          i3 = paramString1.length();
          i1 = i2;
          if (i1 < i3)
          {
            if (paramString1.optString(i1).equals(paramString2)) {
              return Boolean.valueOf(true);
            }
            i1 += 1;
            break label374;
          }
          return localBoolean;
        }
        catch (JSONException paramString1) {}
        paramString1 = paramString1;
      }
      catch (JSONException localJSONException1)
      {
        for (;;)
        {
          str1 = paramString1;
        }
      }
    }
    paramString1 = (String)localObject1;
    if (QLog.isColorLevel())
    {
      QLog.d("AuthorizeConfig", 2, "Decode mJumpConfig error");
      paramString1 = (String)localObject1;
    }
    localObject1 = paramString1;
    if (paramString1 == null) {}
    return localBoolean;
  }
  
  public void d()
  {
    SharedPreferences.Editor localEditor = this.w.edit();
    localEditor.remove("lastVersion");
    localEditor.commit();
    this.c.set(3);
    b(false);
  }
  
  public String e(String paramString)
  {
    return a("p_skey", paramString, m("pskey"));
  }
  
  public boolean e()
  {
    String str = WebCgiWhiteListManager.a();
    if (!TextUtils.isEmpty(str))
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("CgiConfig sp content: ");
        localStringBuilder.append(str);
        QLog.d("AuthorizeConfig", 2, localStringBuilder.toString());
      }
      try
      {
        this.i = new JSONArray(str);
      }
      catch (JSONException localJSONException)
      {
        if (!QLog.isColorLevel()) {
          break label124;
        }
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("CgiConfig load exception: ");
      localStringBuilder.append(localJSONException.getMessage());
      QLog.d("AuthorizeConfig", 2, localStringBuilder.toString());
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("AuthorizeConfig", 2, "CgiConfig sp content empty!");
    }
    label124:
    return this.i != null;
  }
  
  public boolean e(String paramString1, String paramString2)
  {
    localObject1 = paramString1;
    if (localObject1 != null)
    {
      paramString1 = (String)localObject1;
      if (!"about:blank".equalsIgnoreCase((String)localObject1)) {}
    }
    else
    {
      paramString1 = "https://localhost/";
    }
    localUri = Uri.parse(paramString1);
    localObject1 = localUri.getScheme();
    if ("file".equals(localObject1))
    {
      localObject1 = MobileQQ.sMobileQQ.waitAppRuntime(null);
      paramString2 = paramString1;
      if (paramString1.length() > 200) {
        paramString2 = paramString1.substring(0, 200);
      }
      ReportController.b((AppRuntime)localObject1, "dc00899", "Grp_tech_report", "", "webview", "file_scheme", 0, 0, paramString2, "", "", "");
      QLog.e("AuthorizeConfig", 1, "action deprecated with file protocol");
      return false;
    }
    if ((!"http".equals(localObject1)) && (!"https".equals(localObject1))) {
      return false;
    }
    localObject2 = this.r;
    System.currentTimeMillis();
    localObject1 = localObject2;
    if (localObject2 == null) {}
    try
    {
      paramString1 = this.x.e();
    }
    catch (JSONException paramString1)
    {
      try
      {
        localObject1 = new JSONObject("{\"*.qq.com\":[\"*\"],\"*.tencent.com\":[\"*\"],\"*.soso.com\":[\"*\"],\"*.paipai.com\":[\"*\"],\"*.tenpay.com\":[\"*\"],\"*.yixun.com\":[\"*\"],\"*.myapp.com\":[\"*\"],\"*.wanggou.com\":[\"*\"],\"*.qzone.com\":[\"*\"],\"*.weishi.com\":[\"*\"],\"*.weiyun.com\":[\"*\"],\"*\":[\"tel\",\"sms\",\"http\",\"https\",\"file\", \"mqqc2b\"]}");
        this.r = ((JSONObject)localObject1);
        JSONArray localJSONArray = ((JSONObject)localObject1).names();
        if (localJSONArray != null) {
          break label231;
        }
        return false;
        localObject2 = localUri.getHost();
        paramString1 = (String)localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label255;
        }
        paramString1 = ((String)localObject2).toLowerCase();
        int i3 = localJSONArray.length();
        int i1 = 0;
        while (i1 < i3)
        {
          localObject2 = localJSONArray.optString(i1);
          if (b((String)localObject2, paramString1)) {
            for (;;)
            {
              localObject2 = ((JSONObject)localObject1).optJSONArray((String)localObject2);
              if (localObject2 != null)
              {
                int i4 = ((JSONArray)localObject2).length();
                int i2 = 0;
                while (i2 < i4)
                {
                  if (b(((JSONArray)localObject2).optString(i2), paramString2)) {
                    return true;
                  }
                  i2 += 1;
                }
              }
            }
          }
          i1 += 1;
        }
        return false;
        paramString1 = paramString1;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          String str = paramString1;
        }
      }
    }
    paramString1 = (String)localObject2;
    if (QLog.isColorLevel())
    {
      QLog.d("AuthorizeConfig", 2, "Decode mSchemeConfig error");
      paramString1 = (String)localObject2;
    }
    localObject1 = paramString1;
    if (paramString1 != null) {}
  }
  
  public String f(String paramString)
  {
    return a("pt4_token", paramString, m("pt4_token"));
  }
  
  public boolean f()
  {
    String str = WebCgiWhiteListManager.b();
    if (!TextUtils.isEmpty(str))
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("AsyncCheckConfig sp content: ");
        localStringBuilder.append(str);
        QLog.d("AuthorizeConfig", 2, localStringBuilder.toString());
      }
      try
      {
        this.j = new JSONArray(str);
      }
      catch (JSONException localJSONException)
      {
        if (!QLog.isColorLevel()) {
          break label124;
        }
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AsyncCheckConfig load exception: ");
      localStringBuilder.append(localJSONException.getMessage());
      QLog.d("AuthorizeConfig", 2, localStringBuilder.toString());
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("AuthorizeConfig", 2, "AsyncCheckConfig sp content empty!");
    }
    label124:
    return this.j != null;
  }
  
  public boolean f(@NonNull String paramString1, String paramString2)
  {
    Iterator localIterator = this.D.iterator();
    while (localIterator.hasNext())
    {
      IAuthorizeConfigInjector localIAuthorizeConfigInjector = (IAuthorizeConfigInjector)localIterator.next();
      if (localIAuthorizeConfigInjector.a().equals(paramString1)) {
        return localIAuthorizeConfigInjector.a(paramString2);
      }
    }
    return false;
  }
  
  public boolean g()
  {
    String str = WebCgiWhiteListManager.d();
    if (!TextUtils.isEmpty(str))
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("SkipInputWarningConfig sp content: ");
        localStringBuilder.append(str);
        QLog.d("AuthorizeConfig", 2, localStringBuilder.toString());
      }
      try
      {
        this.k = new JSONArray(str);
      }
      catch (JSONException localJSONException)
      {
        if (!QLog.isColorLevel()) {
          break label124;
        }
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SkipInputWarningConfig load exception: ");
      localStringBuilder.append(localJSONException.getMessage());
      QLog.d("AuthorizeConfig", 2, localStringBuilder.toString());
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("AuthorizeConfig", 2, "SkipInputWarningConfig sp content empty!");
    }
    label124:
    return this.k != null;
  }
  
  public boolean g(String paramString)
  {
    for (;;)
    {
      int i1;
      try
      {
        boolean bool = TextUtils.isEmpty(paramString);
        if (!bool)
        {
          if ((this.i == null) && (!e()))
          {
            if (!QLog.isColorLevel()) {
              break label287;
            }
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("CgiConfig loadfromsp fail , url: ");
            ((StringBuilder)localObject1).append(Util.b(paramString, new String[0]));
            QLog.d("AuthorizeConfig", 2, ((StringBuilder)localObject1).toString());
            return false;
          }
          Object localObject1 = Uri.parse(paramString).getHost();
          if ((this.i.length() != 0) && (!TextUtils.isEmpty((CharSequence)localObject1)))
          {
            Object localObject2 = ((String)localObject1).toLowerCase();
            int i2 = this.i.length();
            i1 = 0;
            if (i1 < i2)
            {
              localObject1 = this.i.optString(i1, "");
              if (TextUtils.isEmpty((CharSequence)localObject1)) {
                break label291;
              }
              if (!TextUtils.equals((CharSequence)localObject2, (CharSequence)localObject1))
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append(".");
                localStringBuilder.append((String)localObject1);
                if (!((String)localObject2).endsWith(localStringBuilder.toString())) {
                  break label291;
                }
              }
              if (!QLog.isColorLevel()) {
                break label289;
              }
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("CgiConfig hit , url: ");
              ((StringBuilder)localObject2).append(Util.b(paramString, new String[0]));
              ((StringBuilder)localObject2).append(" domain: ");
              ((StringBuilder)localObject2).append((String)localObject1);
              QLog.d("AuthorizeConfig", 2, ((StringBuilder)localObject2).toString());
              break label289;
            }
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("AuthorizeConfig", 2, "CgiConfig check fail , url empty!");
          return false;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
      return false;
      label287:
      return false;
      label289:
      return true;
      label291:
      i1 += 1;
    }
  }
  
  public boolean h()
  {
    try
    {
      if ((this.l == -1) && (!i()))
      {
        if (QLog.isColorLevel())
        {
          QLog.d("AuthorizeConfig", 2, "forceHttpsConfig loadfromsp fail");
          return false;
        }
      }
      else
      {
        int i1 = this.l;
        return i1 == 1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AuthorizeConfig", 2, "forceHttps enable check exception", localException);
      }
      return false;
    }
    return false;
  }
  
  public boolean h(String paramString)
  {
    for (;;)
    {
      int i1;
      try
      {
        if (!TextUtils.isEmpty(paramString))
        {
          if ((this.j == null) && (!f()))
          {
            if (!QLog.isColorLevel()) {
              break label289;
            }
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("AsyncCheckConfig loadfromsp fail , url: ");
            ((StringBuilder)localObject1).append(Util.b(paramString, new String[0]));
            QLog.d("AuthorizeConfig", 2, ((StringBuilder)localObject1).toString());
            return false;
          }
          Object localObject1 = Uri.parse(paramString).getHost();
          int i2 = this.j.length();
          if ((i2 != 0) && (!TextUtils.isEmpty((CharSequence)localObject1)))
          {
            Object localObject2 = ((String)localObject1).toLowerCase();
            i1 = 0;
            if (i1 < i2)
            {
              localObject1 = this.j.optString(i1, "");
              if (TextUtils.isEmpty((CharSequence)localObject1)) {
                break label293;
              }
              if (!TextUtils.equals((CharSequence)localObject2, (CharSequence)localObject1))
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append(".");
                localStringBuilder.append((String)localObject1);
                if (!((String)localObject2).endsWith(localStringBuilder.toString())) {
                  break label293;
                }
              }
              if (!QLog.isColorLevel()) {
                break label291;
              }
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("AsyncCheckConfig hit , url: ");
              ((StringBuilder)localObject2).append(Util.b(paramString, new String[0]));
              ((StringBuilder)localObject2).append(" domain: ");
              ((StringBuilder)localObject2).append((String)localObject1);
              QLog.d("AuthorizeConfig", 2, ((StringBuilder)localObject2).toString());
              break label291;
            }
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("AuthorizeConfig", 2, "AsyncCheckConfig check fail , url empty!");
          return false;
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AuthorizeConfig", 2, "AsyncCheckConfig check exception", paramString);
        }
      }
      return false;
      label289:
      return false;
      label291:
      return true;
      label293:
      i1 += 1;
    }
  }
  
  public boolean i()
  {
    int i2 = WebCgiWhiteListManager.e();
    boolean bool2 = false;
    int i1;
    if (i2 == 1) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    this.l = i1;
    String str1 = WebCgiWhiteListManager.f();
    StringBuilder localStringBuilder;
    if (!TextUtils.isEmpty(str1))
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("forceHttpsConfig sp content: ");
        localStringBuilder.append(str1);
        QLog.d("AuthorizeConfig", 2, localStringBuilder.toString());
      }
      try
      {
        this.m = new JSONArray(str1);
      }
      catch (JSONException localJSONException1)
      {
        if (!QLog.isColorLevel()) {
          break label162;
        }
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("forceHttpsConfig load exception: ");
      localStringBuilder.append(localJSONException1.getMessage());
      QLog.d("AuthorizeConfig", 2, localStringBuilder.toString());
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("AuthorizeConfig", 2, "forceHttpsConfig sp content empty!");
    }
    label162:
    String str2 = WebCgiWhiteListManager.g();
    if (!TextUtils.isEmpty(str2))
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("forceHttpsExcludeConfig sp content: ");
        localStringBuilder.append(str2);
        QLog.d("AuthorizeConfig", 2, localStringBuilder.toString());
      }
      try
      {
        this.n = new JSONArray(str2);
      }
      catch (JSONException localJSONException2)
      {
        if (!QLog.isColorLevel()) {
          break label300;
        }
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("forceHttpsExcludeConfig load exception: ");
      localStringBuilder.append(localJSONException2.getMessage());
      QLog.d("AuthorizeConfig", 2, localStringBuilder.toString());
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("AuthorizeConfig", 2, "forceHttpsExcludeConfig sp content empty!");
    }
    label300:
    boolean bool1 = bool2;
    if (i2 != -1)
    {
      bool1 = bool2;
      if (this.m != null)
      {
        bool1 = bool2;
        if (this.n != null) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean i(String paramString)
  {
    for (;;)
    {
      int i1;
      try
      {
        if (!TextUtils.isEmpty(paramString))
        {
          if ((this.k == null) && (!g()))
          {
            if (!QLog.isColorLevel()) {
              break label289;
            }
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("SkipInputWarningConfig loadfromsp fail , url: ");
            ((StringBuilder)localObject1).append(Util.b(paramString, new String[0]));
            QLog.d("AuthorizeConfig", 2, ((StringBuilder)localObject1).toString());
            return false;
          }
          Object localObject1 = Uri.parse(paramString).getHost();
          int i2 = this.k.length();
          if ((i2 != 0) && (!TextUtils.isEmpty((CharSequence)localObject1)))
          {
            Object localObject2 = ((String)localObject1).toLowerCase();
            i1 = 0;
            if (i1 < i2)
            {
              localObject1 = this.k.optString(i1, "");
              if (TextUtils.isEmpty((CharSequence)localObject1)) {
                break label293;
              }
              if (!TextUtils.equals((CharSequence)localObject2, (CharSequence)localObject1))
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append(".");
                localStringBuilder.append((String)localObject1);
                if (!((String)localObject2).endsWith(localStringBuilder.toString())) {
                  break label293;
                }
              }
              if (!QLog.isColorLevel()) {
                break label291;
              }
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("SkipInputWarningConfig hit , url: ");
              ((StringBuilder)localObject2).append(Util.b(paramString, new String[0]));
              ((StringBuilder)localObject2).append(" domain: ");
              ((StringBuilder)localObject2).append((String)localObject1);
              QLog.d("AuthorizeConfig", 2, ((StringBuilder)localObject2).toString());
              break label291;
            }
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("AuthorizeConfig", 2, "SkipInputWarningConfig check fail , url empty!");
          return false;
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AuthorizeConfig", 2, "SkipInputWarningConfig check exception", paramString);
        }
      }
      return false;
      label289:
      return false;
      label291:
      return true;
      label293:
      i1 += 1;
    }
  }
  
  public void j()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AuthorizeConfig", 2, "readAndSaveX5Config from VasQuickUpdateManager.SCID_FUNCDEV_WEBVIEW.");
    }
    Object localObject1 = MobileQQ.sMobileQQ.waitAppRuntime(null);
    Object localObject2 = VasUpdateUtil.a((AppRuntime)localObject1, "VASBiz_FuncDev_webview.json", false, null);
    if ((localObject2 != null) && (localObject1 != null) && (((AppRuntime)localObject1).isLogin()))
    {
      Object localObject3;
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("receive X5Config data: ");
        ((StringBuilder)localObject3).append(((JSONObject)localObject2).toString());
        QLog.i("AuthorizeConfig", 2, ((StringBuilder)localObject3).toString());
      }
      localObject2 = ((JSONObject)localObject2).optJSONArray("vipGrayConfig2");
      if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0))
      {
        int i1 = 0;
        boolean bool1 = true;
        boolean bool2;
        for (boolean bool3 = true; i1 < ((JSONArray)localObject2).length(); bool3 = bool2)
        {
          localObject3 = ((JSONArray)localObject2).optJSONObject(i1);
          boolean bool4 = bool1;
          bool2 = bool3;
          if (localObject3 != null)
          {
            if (SwiftWebViewUtils.a((JSONObject)localObject3, "X5Config")) {
              if (((JSONObject)localObject3).optInt("mainThreadControl", 0) == 0) {
                bool1 = true;
              } else {
                bool1 = false;
              }
            }
            bool4 = bool1;
            bool2 = bool3;
            if (SwiftWebViewUtils.a((JSONObject)localObject3, "X5Config")) {
              if (((JSONObject)localObject3).optInt("enableQuic", 1) == 1)
              {
                bool2 = true;
                bool4 = bool1;
              }
              else
              {
                bool2 = false;
                bool4 = bool1;
              }
            }
          }
          i1 += 1;
          bool1 = bool4;
        }
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("readAndSaveX5Config isInitOnSubThread : ");
          ((StringBuilder)localObject2).append(bool1);
          ((StringBuilder)localObject2).append(", enable quick: ");
          ((StringBuilder)localObject2).append(bool3);
          QLog.i("AuthorizeConfig", 2, ((StringBuilder)localObject2).toString());
        }
        localObject2 = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
        localObject1 = ((AppRuntime)localObject1).getApplication();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("sp_x5_config_");
        ((StringBuilder)localObject3).append((String)localObject2);
        localObject1 = ((MobileQQ)localObject1).getSharedPreferences(((StringBuilder)localObject3).toString(), 4).edit();
        ((SharedPreferences.Editor)localObject1).putBoolean("key_x5_init_sub_thread", bool1);
        ((SharedPreferences.Editor)localObject1).putBoolean("key_x5_enable_quic", bool3);
        ((SharedPreferences.Editor)localObject1).apply();
      }
    }
  }
  
  public boolean j(String paramString)
  {
    for (;;)
    {
      int i1;
      try
      {
        if (!TextUtils.isEmpty(paramString))
        {
          if ((this.m == null) && (!i()))
          {
            if (!QLog.isColorLevel()) {
              break label289;
            }
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("forceHttpsConfig loadfromsp fail , url: ");
            ((StringBuilder)localObject1).append(Util.b(paramString, new String[0]));
            QLog.d("AuthorizeConfig", 2, ((StringBuilder)localObject1).toString());
            return false;
          }
          Object localObject1 = Uri.parse(paramString).getHost();
          int i2 = this.m.length();
          if ((i2 != 0) && (!TextUtils.isEmpty((CharSequence)localObject1)))
          {
            Object localObject2 = ((String)localObject1).toLowerCase();
            i1 = 0;
            if (i1 < i2)
            {
              localObject1 = this.m.optString(i1, "");
              if (TextUtils.isEmpty((CharSequence)localObject1)) {
                break label293;
              }
              if (!TextUtils.equals((CharSequence)localObject2, (CharSequence)localObject1))
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append(".");
                localStringBuilder.append((String)localObject1);
                if (!((String)localObject2).endsWith(localStringBuilder.toString())) {
                  break label293;
                }
              }
              if (!QLog.isColorLevel()) {
                break label291;
              }
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("forceHttpsConfig hit , url: ");
              ((StringBuilder)localObject2).append(Util.b(paramString, new String[0]));
              ((StringBuilder)localObject2).append(" domain: ");
              ((StringBuilder)localObject2).append((String)localObject1);
              QLog.d("AuthorizeConfig", 2, ((StringBuilder)localObject2).toString());
              break label291;
            }
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("AuthorizeConfig", 2, "forceHttpsConfig check fail , url empty!");
          return false;
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AuthorizeConfig", 2, "forceHttpsConfig check exception", paramString);
        }
      }
      return false;
      label289:
      return false;
      label291:
      return true;
      label293:
      i1 += 1;
    }
  }
  
  public void k()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AuthorizeConfig", 2, "readAndSaveX5PreloadWhiteListConfig from VasQuickUpdateManager.SCID_FUNCDEV_WEBVIEW.");
    }
    Object localObject2 = MobileQQ.sMobileQQ.waitAppRuntime(null);
    Object localObject1 = VasUpdateUtil.a((AppRuntime)localObject2, "VASBiz_FuncDev_webview.json", false, null);
    if ((localObject1 != null) && (localObject2 != null) && (((AppRuntime)localObject2).isLogin()))
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("receive X5PreloadWhiteList data: ");
        ((StringBuilder)localObject2).append(((JSONObject)localObject1).toString());
        QLog.i("AuthorizeConfig", 2, ((StringBuilder)localObject2).toString());
      }
      localObject1 = ((JSONObject)localObject1).optJSONArray("x5PreloadWhiteList");
      if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0)) {
        this.p = ((JSONArray)localObject1).optJSONObject(0);
      }
    }
  }
  
  public boolean k(String paramString)
  {
    for (;;)
    {
      int i1;
      try
      {
        if (!TextUtils.isEmpty(paramString))
        {
          if ((this.n == null) && (!i()))
          {
            if (!QLog.isColorLevel()) {
              break label289;
            }
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("forceHttpsExcludeConfig loadfromsp fail , url: ");
            ((StringBuilder)localObject1).append(Util.b(paramString, new String[0]));
            QLog.d("AuthorizeConfig", 2, ((StringBuilder)localObject1).toString());
            return false;
          }
          Object localObject1 = Uri.parse(paramString).getHost();
          int i2 = this.n.length();
          if ((i2 != 0) && (!TextUtils.isEmpty((CharSequence)localObject1)))
          {
            Object localObject2 = ((String)localObject1).toLowerCase();
            i1 = 0;
            if (i1 < i2)
            {
              localObject1 = this.n.optString(i1, "");
              if (TextUtils.isEmpty((CharSequence)localObject1)) {
                break label293;
              }
              if (!TextUtils.equals((CharSequence)localObject2, (CharSequence)localObject1))
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append(".");
                localStringBuilder.append((String)localObject1);
                if (!((String)localObject2).endsWith(localStringBuilder.toString())) {
                  break label293;
                }
              }
              if (!QLog.isColorLevel()) {
                break label291;
              }
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("forceHttpsExcludeConfig hit , url: ");
              ((StringBuilder)localObject2).append(Util.b(paramString, new String[0]));
              ((StringBuilder)localObject2).append(" domain: ");
              ((StringBuilder)localObject2).append((String)localObject1);
              QLog.d("AuthorizeConfig", 2, ((StringBuilder)localObject2).toString());
              break label291;
            }
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("AuthorizeConfig", 2, "forceHttpsExcludeConfig check fail , url empty!");
          return false;
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AuthorizeConfig", 2, "forceHttpsExcludeConfig check exception", paramString);
        }
      }
      return false;
      label289:
      return false;
      label291:
      return true;
      label293:
      i1 += 1;
    }
  }
  
  public void l()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AuthorizeConfig", 2, "readAndSaveSonicWhiteListConfig from VasQuickUpdateManager.SCID_FUNCDEV_WEBVIEW.");
    }
    Object localObject2 = MobileQQ.sMobileQQ.waitAppRuntime(null);
    int i1 = 0;
    Object localObject1 = VasUpdateUtil.a((AppRuntime)localObject2, "VASBiz_FuncDev_webview.json", false, null);
    if (localObject1 != null)
    {
      Object localObject3;
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("receive WhiteListConfig data: ");
        ((StringBuilder)localObject3).append(((JSONObject)localObject1).toString());
        QLog.i("AuthorizeConfig", 2, ((StringBuilder)localObject3).toString());
      }
      localObject1 = ((JSONObject)localObject1).optJSONArray("vipGrayConfig2");
      if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
      {
        while (i1 < ((JSONArray)localObject1).length())
        {
          localObject3 = ((JSONArray)localObject1).optJSONObject(i1);
          if ((localObject3 != null) && (a((JSONObject)localObject3)))
          {
            localObject1 = ((JSONObject)localObject3).optJSONObject("configs");
            break label153;
          }
          i1 += 1;
        }
        localObject1 = null;
        label153:
        localObject3 = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
        localObject2 = ((AppRuntime)localObject2).getApplication();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("sp_sonic_white_list_config_");
        localStringBuilder.append((String)localObject3);
        localObject2 = ((MobileQQ)localObject2).getSharedPreferences(localStringBuilder.toString(), 4).edit();
        if (localObject1 != null)
        {
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("readAndSaveSonicWhiteListConfig: ");
            ((StringBuilder)localObject3).append(((JSONObject)localObject1).toString());
            QLog.i("AuthorizeConfig", 2, ((StringBuilder)localObject3).toString());
          }
          ((SharedPreferences.Editor)localObject2).putString("key_sonic_white_list_conifg", ((JSONObject)localObject1).toString());
        }
        else
        {
          QLog.e("AuthorizeConfig", 1, "readAndSaveSonicWhiteListConfig encounter error!. so remove all sonic white list.");
          ((SharedPreferences.Editor)localObject2).remove("key_sonic_white_list_conifg");
        }
        this.q = ((JSONObject)localObject1);
        ((SharedPreferences.Editor)localObject2).apply();
      }
    }
    else
    {
      QLog.d("AuthorizeConfig", 1, "readAndSaveSonicWhiteListConfig VasQuickUpdateManager.SCID_FUNCDEV_WEBVIEW is null");
    }
  }
  
  public boolean l(String paramString)
  {
    Object localObject2 = Uri.parse(paramString);
    Object localObject1;
    if ((localObject2 != null) && (((Uri)localObject2).isHierarchical()))
    {
      if (this.q == null) {
        m();
      }
      localObject1 = this.q;
      boolean bool2 = true;
      if (localObject1 != null)
      {
        localObject1 = ((Uri)localObject2).getHost();
        localObject2 = ((Uri)localObject2).getPath();
        if (this.q != null)
        {
          JSONArray localJSONArray = this.q.optJSONArray((String)localObject1);
          if ((localJSONArray != null) && (localJSONArray.length() > 0))
          {
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("isInSonicWhiteList, host: ");
              localStringBuilder.append((String)localObject1);
              localStringBuilder.append(", rules: ");
              localStringBuilder.append(localJSONArray.toString());
              QLog.i("AuthorizeConfig", 2, localStringBuilder.toString());
            }
            int i1 = 0;
            while (i1 < localJSONArray.length())
            {
              localObject1 = localJSONArray.optString(i1);
              bool1 = bool2;
              if (((String)localObject1).equalsIgnoreCase((String)localObject2)) {
                break label254;
              }
              if (((String)localObject1).equals("*"))
              {
                bool1 = bool2;
                break label254;
              }
              if ((((String)localObject1).endsWith("*")) && (((String)localObject2).startsWith(((String)localObject1).replace("/*", ""))))
              {
                bool1 = bool2;
                break label254;
              }
              i1 += 1;
            }
          }
        }
      }
      else
      {
        QLog.e("AuthorizeConfig", 1, "mSonicWhiteListConfig is null! ");
      }
    }
    boolean bool1 = false;
    label254:
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("isInSonicWhiteList: ");
      ((StringBuilder)localObject1).append(bool1);
      ((StringBuilder)localObject1).append(", url: ");
      ((StringBuilder)localObject1).append(Util.b(paramString, new String[0]));
      QLog.i("AuthorizeConfig", 2, ((StringBuilder)localObject1).toString());
    }
    return bool1;
  }
  
  public Set<String> m(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return new HashSet();
    }
    Object localObject1 = (Set)this.u.get(paramString);
    if (localObject1 == null) {}
    for (;;)
    {
      int i1;
      synchronized (this.u)
      {
        Object localObject2 = (Set)this.u.get(paramString);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject2 = new HashSet(32);
          localObject1 = s(paramString);
          if ((localObject1 != null) && (((JSONArray)localObject1).length() != 0))
          {
            int i2 = ((JSONArray)localObject1).length();
            i1 = 0;
            if (i1 < i2)
            {
              if ("skey".equals(paramString))
              {
                ((Set)localObject2).add(h(((JSONArray)localObject1).optString(i1, ""), "*."));
                break label246;
              }
              ((Set)localObject2).add(((JSONArray)localObject1).optString(i1, ""));
              break label246;
            }
          }
          this.u.put(paramString, localObject2);
          localObject1 = localObject2;
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(paramString);
            ((StringBuilder)localObject1).append(" domain white list: ");
            ((StringBuilder)localObject1).append(localObject2);
            QLog.d("AuthorizeConfig", 2, ((StringBuilder)localObject1).toString());
            localObject1 = localObject2;
          }
        }
        return localObject1;
      }
      return localObject1;
      label246:
      i1 += 1;
    }
  }
  
  public void m()
  {
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    boolean bool = true;
    if ((localObject != null) && (((AppRuntime)localObject).isLogin()))
    {
      String str = ((AppRuntime)localObject).getAccount();
      localObject = ((AppRuntime)localObject).getApplication();
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("sp_sonic_white_list_config_");
      localStringBuilder2.append(str);
      str = ((MobileQQ)localObject).getSharedPreferences(localStringBuilder2.toString(), 4).getString("key_sonic_white_list_conifg", null);
      if (!TextUtils.isEmpty(str))
      {
        try
        {
          this.q = new JSONObject(str);
        }
        catch (Exception localException)
        {
          if (!QLog.isColorLevel()) {
            break label129;
          }
        }
        QLog.e("AuthorizeConfig", 2, "", localException);
      }
      else
      {
        QLog.e("AuthorizeConfig", 1, "loadSonicWhiteListConfigFromSp is null!");
      }
      label129:
      if (this.q == null) {
        l();
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("loadSonicWhiteListConfigFromSp:  ");
        if (this.q == null) {
          bool = false;
        }
        localStringBuilder1.append(bool);
        QLog.i("AuthorizeConfig", 2, localStringBuilder1.toString());
      }
      return;
    }
    QLog.e("AuthorizeConfig", 1, "loadSonicWhiteListConfigFromSp, runtime is null or is not login!");
  }
  
  JSONArray n(String paramString)
  {
    Object localObject = MobileQQ.sMobileQQ.peekAppRuntime();
    if ((localObject != null) && (((AppRuntime)localObject).isLogin()))
    {
      localObject = (TicketAuthorizeConfBean)QConfigManager.b().b(757);
      if (((TicketAuthorizeConfBean)localObject).a)
      {
        localObject = this.x.a(paramString);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("load mqq config for ");
        localStringBuilder.append(paramString);
        QLog.w("AuthorizeConfig", 1, localStringBuilder.toString());
        return localObject;
      }
      localObject = ((TicketAuthorizeConfBean)localObject).a(paramString);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("load manage config for ");
      localStringBuilder.append(paramString);
      QLog.i("AuthorizeConfig", 1, localStringBuilder.toString());
      return localObject;
    }
    return null;
  }
  
  public void n()
  {
    Object localObject1 = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (!((AppRuntime)localObject1).isLogin())
    {
      if (QLog.isColorLevel()) {
        QLog.d("AuthorizeConfig", 2, "[preload] cachePreloadPskeyList is not login");
      }
      return;
    }
    localObject1 = ((AppRuntime)localObject1).getAccount();
    Object localObject2 = this.w;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("lastPreloadPskey");
    localStringBuilder.append((String)localObject1);
    long l1 = ((SharedPreferences)localObject2).getLong(localStringBuilder.toString(), 0L);
    long l2 = System.currentTimeMillis();
    if (l2 - l1 < 43200000L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AuthorizeConfig", 1, new Object[] { "[preload] cachePreloadPskeyList too often lastTime:", Long.valueOf(l1), " interval:", Long.valueOf(43200000L) });
      }
      return;
    }
    localObject2 = (WVPreloadPskeyConfBean)QConfigManager.b().b(585);
    if (((WVPreloadPskeyConfBean)localObject2).a != 1)
    {
      QLog.d("AuthorizeConfig", 1, new Object[] { "[preload] do not support preloadPskey:", Integer.valueOf(((WVPreloadPskeyConfBean)localObject2).a) });
      return;
    }
    localObject1 = new AuthorizeConfig.5(this, (String)localObject1, l2);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      ((Runnable)localObject1).run();
      return;
    }
    ThreadManager.post((Runnable)localObject1, 8, null, true);
  }
  
  void o()
  {
    ??? = MobileQQ.sMobileQQ.peekAppRuntime();
    TicketManager localTicketManager = (TicketManager)((AppRuntime)???).getManager(2);
    Set localSet = m("pskey");
    ArrayList localArrayList = new ArrayList(localSet.size());
    HashSet localHashSet = new HashSet(20);
    Object localObject3 = WebViewConstant.a;
    int i2 = localObject3.length;
    int i1 = 0;
    while (i1 < i2)
    {
      localHashSet.add(localObject3[i1]);
      i1 += 1;
    }
    localObject3 = localSet.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      String str1 = (String)((Iterator)localObject3).next();
      String str2 = localTicketManager.getPskey(((AppRuntime)???).getAccount(), str1);
      if ((!localHashSet.contains(str1)) && (TextUtils.isEmpty(str2))) {
        localArrayList.add(str1);
      }
    }
    synchronized (G)
    {
      this.C = localArrayList;
      if (QLog.isColorLevel()) {
        QLog.d("AuthorizeConfig", 2, new Object[] { "[preload] getNeedCacheDomains domains:", Integer.valueOf(localSet.size()), " default:", Integer.valueOf(localHashSet.size()), " cur:", Integer.valueOf(localArrayList.size()) });
      }
      return;
    }
    for (;;)
    {
      throw localObject1;
    }
  }
  
  public boolean o(String paramString)
  {
    Object localObject = Uri.parse(paramString).getScheme();
    if ((!"http".equals(localObject)) && (!"https".equals(localObject))) {
      return false;
    }
    Set localSet = m("a1");
    localObject = Uri.parse(paramString).getHost();
    paramString = (String)localObject;
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      paramString = ((String)localObject).toLowerCase();
    }
    if (localSet.contains(paramString)) {
      return true;
    }
    localObject = localSet.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (b((String)((Iterator)localObject).next(), paramString)) {
        return true;
      }
    }
    return false;
  }
  
  public String p(String paramString)
  {
    return a("a2", paramString, m("a2"));
  }
  
  public void p()
  {
    if (this.H)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AuthorizeConfig", 2, "[preload] preloadPskey waiting");
      }
      return;
    }
    Object localObject1 = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (!((AppRuntime)localObject1).isLogin())
    {
      if (QLog.isColorLevel()) {
        QLog.d("AuthorizeConfig", 2, "[preload] preloadPskey is not login");
      }
      return;
    }
    TicketManager localTicketManager = (TicketManager)((AppRuntime)localObject1).getManager(2);
    ArrayList localArrayList1 = new ArrayList(20);
    ArrayList localArrayList2 = new ArrayList();
    Object localObject3 = G;
    int i1 = 0;
    for (;;)
    {
      try
      {
        if (i1 < this.C.size())
        {
          if (i1 < 20) {
            localArrayList1.add(this.C.get(i1));
          } else {
            localArrayList2.add(this.C.get(i1));
          }
        }
        else
        {
          StringBuilder localStringBuilder = new StringBuilder(100);
          localStringBuilder.append("[preload] list:");
          localStringBuilder.append(localArrayList1.toString());
          localStringBuilder.append(" mPreloadDomains:");
          localStringBuilder.append(this.C.size());
          localStringBuilder.append(" curDomainList:");
          localStringBuilder.append(localArrayList1.size());
          localStringBuilder.append(" leftDomainList:");
          localStringBuilder.append(localArrayList2.size());
          if (QLog.isColorLevel()) {
            QLog.d("AuthorizeConfig", 2, localStringBuilder.toString());
          }
          this.C = localArrayList2;
          if (localArrayList1.size() == 0) {
            return;
          }
          localObject3 = new String[localArrayList1.size()];
          i1 = 0;
          if (i1 < localArrayList1.size())
          {
            localObject3[i1] = String.format("(%d)%s", new Object[] { Integer.valueOf(1048576), localArrayList1.get(i1) });
            i1 += 1;
            continue;
          }
          localObject1 = new AuthorizeConfig.6(this, localTicketManager, ((AppRuntime)localObject1).getAccount(), (String[])localObject3);
          if (Looper.myLooper() != Looper.getMainLooper())
          {
            ((Runnable)localObject1).run();
            return;
          }
          ThreadManager.post((Runnable)localObject1, 8, null, true);
          return;
        }
      }
      finally
      {
        continue;
        throw localObject2;
        continue;
        i1 += 1;
      }
    }
  }
  
  public void q()
  {
    long l1 = System.currentTimeMillis();
    if (l1 - J < 21600000L)
    {
      QLog.d("AuthorizeConfig", 1, "preload too often");
      return;
    }
    synchronized (I)
    {
      if (l1 - J < 21600000L)
      {
        QLog.d("AuthorizeConfig", 1, "preload too often");
        return;
      }
      J = l1;
      ??? = MobileQQ.sMobileQQ.waitAppRuntime(null);
      if (MobileQQ.sProcessId != 1) {
        return;
      }
      if (!((AppRuntime)???).isLogin()) {
        return;
      }
      if (com.tencent.mobileqq.webprocess.WebAccelerateHelper.getInstance().getWebViewFeatureParams()[3].intValue() == 1)
      {
        TicketManager localTicketManager = (TicketManager)((AppRuntime)???).getManager(2);
        Object localObject3 = m("pt4_token");
        String[] arrayOfString = new String[((Set)localObject3).size()];
        localObject3 = ((Set)localObject3).iterator();
        int i1 = 0;
        while (((Iterator)localObject3).hasNext())
        {
          arrayOfString[i1] = String.format("(%d)%s", new Object[] { Integer.valueOf(134217728), (String)((Iterator)localObject3).next() });
          i1 += 1;
        }
        ??? = new AuthorizeConfig.7(this, localTicketManager, ((AppRuntime)???).getAccount(), arrayOfString);
        if (Looper.myLooper() != Looper.getMainLooper()) {
          ((Runnable)???).run();
        } else {
          ThreadManager.post((Runnable)???, 8, null, true);
        }
        this.H = true;
        return;
      }
      QLog.d("AuthorizeConfig", 1, "do not support preload.");
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public boolean q(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      localObject1 = paramString;
      if (!"about:blank".equalsIgnoreCase(paramString)) {}
    }
    else
    {
      localObject1 = "https://localhost/";
    }
    Uri localUri = Uri.parse((String)localObject1);
    paramString = localUri.getScheme();
    if ((!"http".equals(paramString)) && (!"https".equals(paramString))) {
      return false;
    }
    Object localObject2 = this.r;
    System.currentTimeMillis();
    Object localObject1 = localObject2;
    if (localObject2 == null) {}
    try
    {
      paramString = this.x.e();
    }
    catch (JSONException paramString)
    {
      label88:
      break label88;
    }
    paramString = (String)localObject2;
    if (QLog.isColorLevel())
    {
      QLog.d("AuthorizeConfig", 2, "Decode mSchemeConfig error");
      paramString = (String)localObject2;
    }
    localObject1 = paramString;
    if (paramString == null) {}
    try
    {
      localObject1 = new JSONObject("{\"*.qq.com\":[\"*\"],\"*.tencent.com\":[\"*\"],\"*.soso.com\":[\"*\"],\"*.paipai.com\":[\"*\"],\"*.tenpay.com\":[\"*\"],\"*.yixun.com\":[\"*\"],\"*.myapp.com\":[\"*\"],\"*.wanggou.com\":[\"*\"],\"*.qzone.com\":[\"*\"],\"*.weishi.com\":[\"*\"],\"*.weiyun.com\":[\"*\"],\"*\":[\"tel\",\"sms\",\"http\",\"https\",\"file\", \"mqqc2b\"]}");
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        int i2;
        int i1;
        String str = paramString;
      }
    }
    localObject2 = ((JSONObject)localObject1).names();
    if (localObject2 == null) {
      return false;
    }
    localObject1 = localUri.getHost();
    paramString = (String)localObject1;
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      paramString = ((String)localObject1).toLowerCase();
    }
    i2 = ((JSONArray)localObject2).length();
    i1 = 0;
    while (i1 < i2)
    {
      localObject1 = ((JSONArray)localObject2).optString(i1);
      if (((localObject1 != null) && (((String)localObject1).equals("*"))) || (!b((String)localObject1, paramString))) {
        i1 += 1;
      } else {
        return true;
      }
    }
    return false;
  }
  
  public void r()
  {
    Object localObject = this.E;
    if (localObject == null) {
      return;
    }
    localObject = ((IAuthorizeConfigDownloadInjector)localObject).a();
    if (localObject != null)
    {
      Iterator localIterator = this.D.iterator();
      while (localIterator.hasNext()) {
        ((IAuthorizeConfigInjector)localIterator.next()).a((JSONObject)localObject);
      }
    }
    QLog.d("AuthorizeConfig", 1, "WebViewSwitchAio loadFuncDevWebViewConfig return null");
  }
  
  public boolean r(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (this.p == null) {
      k();
    }
    Object localObject = this.p;
    JSONArray localJSONArray = null;
    if (localObject != null) {
      localJSONArray = ((JSONObject)localObject).optJSONArray("domainList");
    }
    if (localObject != null)
    {
      localObject = localJSONArray;
      if (localJSONArray != null) {}
    }
    else
    {
      localObject = new JSONArray();
      ((JSONArray)localObject).put("*.vip.qq.com");
    }
    int i1 = ((JSONArray)localObject).length() - 1;
    while (i1 >= 0)
    {
      if (b(((JSONArray)localObject).optString(i1), paramString)) {
        return true;
      }
      i1 -= 1;
    }
    return false;
  }
  
  public void s()
  {
    try
    {
      long l1 = System.currentTimeMillis();
      if ((l1 - this.o < 1800000L) && (!x())) {
        return;
      }
      this.o = l1;
      ThreadManager.post(new AuthorizeConfig.8(this), 5, null, false);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.AuthorizeConfig
 * JD-Core Version:    0.7.0.1
 */
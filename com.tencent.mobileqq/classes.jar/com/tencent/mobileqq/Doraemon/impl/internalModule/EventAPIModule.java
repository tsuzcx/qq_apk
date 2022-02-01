package com.tencent.mobileqq.Doraemon.impl.internalModule;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.Doraemon.APIParam;
import com.tencent.mobileqq.Doraemon.DoraemonAPIManager;
import com.tencent.mobileqq.Doraemon.DoraemonAPIModule;
import com.tencent.mobileqq.Doraemon.util.DoraemonUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EventAPIModule
  extends DoraemonAPIModule
{
  private static BroadcastReceiver b;
  private static boolean c = false;
  private static HashSet<WeakReference<EventAPIModule>> d;
  private WeakReference<EventAPIModule> e;
  private HashMap<String, APICallback> f;
  private boolean g = false;
  private String h;
  private String i;
  
  private static void g()
  {
    d = new HashSet();
    b = new EventAPIModule.1();
  }
  
  /* Error */
  protected void a(android.content.Context paramContext, Intent paramIntent)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_2
    //   6: ldc 47
    //   8: iconst_1
    //   9: invokevirtual 53	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   12: ifne +4 -> 16
    //   15: return
    //   16: aload_2
    //   17: ldc 55
    //   19: invokevirtual 59	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   22: astore_1
    //   23: aload_1
    //   24: ifnull +15 -> 39
    //   27: aload_1
    //   28: aload_0
    //   29: invokevirtual 62	com/tencent/mobileqq/Doraemon/impl/internalModule/EventAPIModule:e	()Ljava/lang/String;
    //   32: invokevirtual 68	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   35: ifeq +4 -> 39
    //   38: return
    //   39: aload_2
    //   40: ldc 70
    //   42: invokevirtual 59	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   45: astore 7
    //   47: aload 7
    //   49: invokestatic 76	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   52: ifeq +4 -> 56
    //   55: return
    //   56: aload_2
    //   57: ldc 78
    //   59: invokevirtual 59	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   62: astore_1
    //   63: aconst_null
    //   64: astore 6
    //   66: aload_1
    //   67: ifnull +15 -> 82
    //   70: new 80	org/json/JSONObject
    //   73: dup
    //   74: aload_1
    //   75: invokespecial 83	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   78: astore_1
    //   79: goto +5 -> 84
    //   82: aconst_null
    //   83: astore_1
    //   84: aload_2
    //   85: ldc 85
    //   87: invokevirtual 89	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   90: astore 8
    //   92: aload 8
    //   94: ifnonnull +4 -> 98
    //   97: return
    //   98: aload_2
    //   99: ldc 91
    //   101: invokevirtual 59	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   104: astore 9
    //   106: aload 6
    //   108: astore_2
    //   109: aload 9
    //   111: ifnull +16 -> 127
    //   114: new 80	org/json/JSONObject
    //   117: dup
    //   118: aload 9
    //   120: invokespecial 83	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   123: astore_2
    //   124: goto +3 -> 127
    //   127: aload_0
    //   128: invokevirtual 93	com/tencent/mobileqq/Doraemon/impl/internalModule/EventAPIModule:d	()Ljava/lang/String;
    //   131: astore 9
    //   133: invokestatic 99	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   136: istore 5
    //   138: iconst_0
    //   139: istore_3
    //   140: iload 5
    //   142: ifeq +70 -> 212
    //   145: aload_0
    //   146: invokevirtual 104	java/lang/Object:toString	()Ljava/lang/String;
    //   149: astore 10
    //   151: aload_1
    //   152: ifnull +12 -> 164
    //   155: aload_1
    //   156: invokevirtual 105	org/json/JSONObject:toString	()Ljava/lang/String;
    //   159: astore 6
    //   161: goto +7 -> 168
    //   164: ldc 107
    //   166: astore 6
    //   168: ldc 109
    //   170: iconst_2
    //   171: ldc 111
    //   173: iconst_5
    //   174: anewarray 101	java/lang/Object
    //   177: dup
    //   178: iconst_0
    //   179: aload 10
    //   181: aastore
    //   182: dup
    //   183: iconst_1
    //   184: aload 7
    //   186: aastore
    //   187: dup
    //   188: iconst_2
    //   189: aload 6
    //   191: aastore
    //   192: dup
    //   193: iconst_3
    //   194: ldc 113
    //   196: aload 8
    //   198: invokestatic 117	android/text/TextUtils:join	(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;
    //   201: aastore
    //   202: dup
    //   203: iconst_4
    //   204: aload_2
    //   205: aastore
    //   206: invokestatic 121	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   209: invokestatic 124	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   212: aload 8
    //   214: invokevirtual 130	java/util/ArrayList:size	()I
    //   217: istore 4
    //   219: iload_3
    //   220: iload 4
    //   222: if_icmpge +36 -> 258
    //   225: aload 8
    //   227: iload_3
    //   228: invokevirtual 134	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   231: checkcast 64	java/lang/String
    //   234: aload 9
    //   236: invokestatic 139	com/tencent/biz/AuthorizeConfig:b	(Ljava/lang/String;Ljava/lang/String;)Z
    //   239: ifeq +12 -> 251
    //   242: aload_0
    //   243: aload 7
    //   245: aload_1
    //   246: aload_2
    //   247: invokevirtual 142	com/tencent/mobileqq/Doraemon/impl/internalModule/EventAPIModule:a	(Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONObject;)V
    //   250: return
    //   251: iload_3
    //   252: iconst_1
    //   253: iadd
    //   254: istore_3
    //   255: goto -36 -> 219
    //   258: return
    //   259: astore_1
    //   260: return
    //   261: astore_1
    //   262: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	263	0	this	EventAPIModule
    //   0	263	1	paramContext	android.content.Context
    //   0	263	2	paramIntent	Intent
    //   139	116	3	j	int
    //   217	6	4	k	int
    //   136	5	5	bool	boolean
    //   64	126	6	str1	String
    //   45	199	7	str2	String
    //   90	136	8	localArrayList	ArrayList
    //   104	131	9	str3	String
    //   149	31	10	str4	String
    // Exception table:
    //   from	to	target	type
    //   70	79	259	org/json/JSONException
    //   114	124	261	org/json/JSONException
  }
  
  protected void a(String paramString, JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    Object localObject = this.f;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = (APICallback)((HashMap)localObject).get(paramString);
    }
    if (localObject != null)
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("event", paramString);
        localJSONObject.put("data", paramJSONObject1);
        localJSONObject.put("source", paramJSONObject2);
      }
      catch (JSONException paramString)
      {
        QLog.e("DoraemonOpenAPI.event", 1, paramString.getMessage(), paramString);
      }
      DoraemonUtil.b((APICallback)localObject, localJSONObject);
    }
  }
  
  public boolean a(int paramInt, String paramString, JSONObject paramJSONObject, @NonNull APICallback paramAPICallback)
  {
    paramString = "";
    boolean bool1;
    boolean bool2;
    if (paramInt != 1)
    {
      if (paramInt != 4)
      {
        if (paramInt != 23) {
          return false;
        }
        paramString = paramJSONObject.optString("event", "");
        if (TextUtils.isEmpty(paramString))
        {
          if (QLog.isColorLevel()) {
            QLog.w("DoraemonOpenAPI.event", 2, "event name is required");
          }
          DoraemonUtil.a(paramAPICallback, -1, "event name is required");
          break label619;
        }
        paramJSONObject = this.f;
        if (paramJSONObject != null) {
          paramJSONObject.remove(paramString);
        }
        DoraemonUtil.a(paramAPICallback, APIParam.a);
        break label619;
      }
      try
      {
        str1 = paramJSONObject.optString("event");
        if (TextUtils.isEmpty(str1))
        {
          if (QLog.isColorLevel()) {
            QLog.w("DoraemonOpenAPI.event", 2, "event name is required");
          }
          DoraemonUtil.a(paramAPICallback, -1, "event name is required");
          break label619;
        }
        localJSONObject = paramJSONObject.optJSONObject("data");
        if (localJSONObject != null) {
          paramString = localJSONObject.toString();
        }
        if ((!TextUtils.isEmpty(paramString)) && (paramString.length() >= 460800L))
        {
          bool1 = QLog.isColorLevel();
          if (bool1) {
            QLog.w("DoraemonOpenAPI.event", 2, "param data is over size");
          }
          DoraemonUtil.a(paramAPICallback, -2, "param data is over size");
          break label619;
        }
        paramString = paramJSONObject.optJSONObject("options");
        paramJSONObject = new ArrayList();
        if (paramString == null) {
          break label631;
        }
        bool2 = paramString.optBoolean("echo", true);
        bool1 = paramString.optBoolean("broadcast", true);
        paramString = paramString.optJSONArray("domains");
        if (paramString == null) {
          break label628;
        }
        int j = paramString.length();
        paramInt = 0;
        if (paramInt >= j) {
          break label628;
        }
        localObject = paramString.optString(paramInt);
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label621;
        }
        paramJSONObject.add(localObject);
      }
      catch (Throwable paramString)
      {
        String str1;
        JSONObject localJSONObject;
        Object localObject;
        label284:
        Intent localIntent;
        String str2;
        QLog.e("DoraemonOpenAPI.event", 1, paramString.getMessage(), paramString);
        DoraemonUtil.a(paramAPICallback, -3, paramString.getMessage());
        break label619;
      }
      localObject = new JSONObject();
      ((JSONObject)localObject).put("appid", this.a.b);
      ((JSONObject)localObject).put("appType", this.a.a);
      if (paramJSONObject.size() == 0) {
        paramJSONObject.add(d());
      }
      localIntent = new Intent("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
      localIntent.putExtra("broadcast", bool1);
      localIntent.putExtra("unique", e());
      localIntent.putExtra("event", str1);
      if (localJSONObject != null) {
        localIntent.putExtra("data", localJSONObject.toString());
      }
      localIntent.putStringArrayListExtra("domains", paramJSONObject);
      localIntent.putExtra("source", ((JSONObject)localObject).toString());
      if (QLog.isColorLevel())
      {
        str2 = toString();
        if (localJSONObject == null) {
          break label640;
        }
        paramString = localJSONObject.toString();
      }
    }
    for (;;)
    {
      QLog.d("DoraemonOpenAPI.event", 2, String.format("send event broadcast, pluginReference: %s, event: %s, data: %s, domains: %s, source: %s", new Object[] { str2, str1, paramString, TextUtils.join(",", paramJSONObject), localObject }));
      BaseApplicationImpl.getContext().sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
      if (bool2) {
        a(str1, localJSONObject, (JSONObject)localObject);
      }
      DoraemonUtil.a(paramAPICallback, APIParam.a);
      break label619;
      paramString = paramJSONObject.optString("event", "");
      if (TextUtils.isEmpty(paramString))
      {
        if (QLog.isColorLevel()) {
          QLog.w("DoraemonOpenAPI.event", 2, "event name is required");
        }
        DoraemonUtil.a(paramAPICallback, -1, "event name is required");
      }
      else
      {
        c();
        this.f.put(paramString, paramAPICallback);
        DoraemonUtil.a(paramAPICallback, APIParam.a);
      }
      label619:
      return true;
      label621:
      paramInt += 1;
      break;
      label628:
      break label284;
      label631:
      bool1 = true;
      bool2 = true;
      break label284;
      label640:
      paramString = "NULL";
    }
  }
  
  public void b()
  {
    if (this.g)
    {
      d.remove(this.e);
      if (d.size() == 0)
      {
        c = false;
        BaseApplicationImpl.getApplication().unregisterReceiver(b);
      }
    }
  }
  
  protected void c()
  {
    if (this.g) {
      return;
    }
    if (b == null) {
      g();
    }
    if (!c)
    {
      c = true;
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
      BaseApplicationImpl.getApplication().registerReceiver(b, localIntentFilter, "com.tencent.msg.permission.pushnotify", null);
    }
    this.g = true;
    this.f = new HashMap();
    this.e = new WeakReference(this);
    d.add(this.e);
  }
  
  protected String d()
  {
    if (this.i == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a.a);
      localStringBuilder.append("_");
      localStringBuilder.append(this.a.b);
      localStringBuilder.append(".virtual_host");
      this.i = localStringBuilder.toString();
    }
    return this.i;
  }
  
  protected String e()
  {
    if (this.h == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(String.valueOf(System.currentTimeMillis()));
      localStringBuilder.append(String.valueOf((int)(Math.random() * 1000000.0D)));
      this.h = localStringBuilder.toString();
    }
    return this.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.internalModule.EventAPIModule
 * JD-Core Version:    0.7.0.1
 */
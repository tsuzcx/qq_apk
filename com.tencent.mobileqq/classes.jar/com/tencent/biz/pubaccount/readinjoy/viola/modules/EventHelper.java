package com.tencent.biz.pubaccount.readinjoy.viola.modules;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment;
import com.tencent.biz.pubaccount.readinjoy.viola.event.ViolaEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.utils.ViolaUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EventHelper
{
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<BridgeModule> jdField_a_of_type_JavaLangRefWeakReference = null;
  private HashMap<String, ArrayList<EventHelper.Event>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_a_of_type_Boolean = false;
  private String b;
  
  public EventHelper(BridgeModule paramBridgeModule)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBridgeModule);
  }
  
  private String a()
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
    {
      BridgeModule localBridgeModule = (BridgeModule)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localBridgeModule.getViolaInstance() != null) && (localBridgeModule.getViolaInstance().getFragment() != null) && ((localBridgeModule.getViolaInstance().getFragment() instanceof ViolaFragment))) {
        return ((ViolaFragment)localBridgeModule.getViolaInstance().getFragment()).getUrl();
      }
    }
    return "https://qq.com";
  }
  
  private void a(String paramString1, String paramString2)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      ((BridgeModule)this.jdField_a_of_type_JavaLangRefWeakReference.get()).invokeErrorCallJS(paramString1, paramString2);
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3))) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString1))
    {
      localArrayList = (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(paramString1);
      localArrayList.add(new EventHelper.Event(this, paramString2, paramString3));
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, localArrayList);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new EventHelper.Event(this, paramString2, paramString3));
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, localArrayList);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, JSONObject paramJSONObject1, String paramString4, JSONObject paramJSONObject2)
  {
    if ((!TextUtils.isEmpty(paramString2)) && (paramString2.length() >= 460800L))
    {
      if (QLog.isColorLevel()) {
        QLog.w("BridgeModule.event", 2, "param data is over size");
      }
      a(paramString3, "param data is over size");
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        paramJSONObject1 = paramJSONObject1.optJSONObject("options");
        int k = 1;
        boolean bool1 = true;
        paramString2 = new ArrayList();
        if (paramJSONObject1 != null)
        {
          boolean bool2 = paramJSONObject1.optBoolean("echo", true);
          boolean bool3 = paramJSONObject1.optBoolean("broadcast", true);
          paramJSONObject1 = paramJSONObject1.optJSONArray("domains");
          bool1 = bool3;
          k = bool2;
          if (paramJSONObject1 != null)
          {
            i = 0;
            int j = paramJSONObject1.length();
            bool1 = bool3;
            k = bool2;
            if (i < j)
            {
              localObject = paramJSONObject1.optString(i);
              if (TextUtils.isEmpty((CharSequence)localObject)) {
                break label411;
              }
              paramString2.add(localObject);
              break label411;
            }
          }
        }
        paramJSONObject1 = new JSONObject();
        paramJSONObject1.put("url", paramString1);
        if ((paramString2.size() == 0) && (!TextUtils.isEmpty(paramString1)))
        {
          paramString1 = Uri.parse(paramString1);
          if (paramString1.isHierarchical()) {
            paramString2.add(paramString1.getHost());
          }
        }
        Object localObject = new Intent("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
        ((Intent)localObject).putExtra("broadcast", bool1);
        ((Intent)localObject).putExtra("unique", b());
        ((Intent)localObject).putExtra("event", paramString4);
        if (paramJSONObject2 != null) {
          ((Intent)localObject).putExtra("data", paramJSONObject2.toString());
        }
        ((Intent)localObject).putStringArrayListExtra("domains", paramString2);
        ((Intent)localObject).putExtra("source", paramJSONObject1.toString());
        if (QLog.isColorLevel())
        {
          String str = this.jdField_a_of_type_JavaLangRefWeakReference.toString();
          if (paramJSONObject2 != null)
          {
            paramString1 = paramJSONObject2.toString();
            QLog.d("BridgeModule.event", 2, String.format("send event broadcast, pluginReference: %s, event: %s, data: %s, domains: %s, source: %s", new Object[] { str, paramString4, paramString1, TextUtils.join(",", paramString2), paramJSONObject1 }));
          }
        }
        else
        {
          BaseApplicationImpl.getContext().sendBroadcast((Intent)localObject, "com.tencent.msg.permission.pushnotify");
          if (k == 0) {
            break;
          }
          a(paramString4, paramJSONObject2, paramJSONObject1);
          return;
        }
      }
      catch (JSONException paramString1)
      {
        a(paramString3, paramString1.getMessage());
        return;
      }
      paramString1 = "NULL";
      continue;
      label411:
      i += 1;
    }
  }
  
  private void a(String paramString, JSONObject paramJSONObject)
  {
    SimpleEventBus.getInstance().dispatchEvent(new ViolaEvent(paramString, paramJSONObject));
  }
  
  private String b()
  {
    if (this.b == null) {
      this.b = (String.valueOf(System.currentTimeMillis()) + (int)(Math.random() * 1000000.0D));
    }
    return this.b;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null) {
      c();
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
    BaseApplicationImpl.getApplication().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter, "com.tencent.msg.permission.pushnotify", null);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  private void b(String paramString1, String paramString2, String paramString3)
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3))) {}
    ArrayList localArrayList;
    do
    {
      do
      {
        return;
      } while (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString1));
      localArrayList = (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.remove(paramString1);
      int i = 0;
      while (i < localArrayList.size())
      {
        EventHelper.Event localEvent = (EventHelper.Event)localArrayList.get(i);
        if ((localEvent.jdField_a_of_type_JavaLangString.equals(paramString2)) && (localEvent.b.equals(paramString3))) {
          localArrayList.remove(localEvent);
        }
        i += 1;
      }
    } while (localArrayList.size() <= 0);
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, localArrayList);
  }
  
  private void b(String paramString, JSONObject paramJSONObject)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      ((BridgeModule)this.jdField_a_of_type_JavaLangRefWeakReference.get()).invokeCallJS(paramString, paramJSONObject);
    }
  }
  
  private String c()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return Uri.parse(this.jdField_a_of_type_JavaLangString).getHost();
    }
    return null;
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new EventHelper.1(this);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null))
    {
      BaseApplicationImpl.getApplication().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      this.jdField_a_of_type_JavaLangRefWeakReference.clear();
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
    }
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
      while (localIterator.hasNext())
      {
        ArrayList localArrayList = (ArrayList)localIterator.next();
        if ((localArrayList != null) && (localArrayList.size() > 0)) {
          localArrayList.clear();
        }
      }
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      this.jdField_a_of_type_JavaUtilHashMap = null;
    }
  }
  
  /* Error */
  protected void a(android.content.Context paramContext, Intent paramIntent)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: iconst_0
    //   4: istore_3
    //   5: aload_2
    //   6: ifnonnull +4 -> 10
    //   9: return
    //   10: aload_2
    //   11: ldc 135
    //   13: iconst_1
    //   14: invokevirtual 356	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   17: ifeq -8 -> 9
    //   20: aload_2
    //   21: ldc 182
    //   23: invokevirtual 360	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   26: astore_1
    //   27: aload_1
    //   28: ifnull +14 -> 42
    //   31: aload_1
    //   32: aload_0
    //   33: invokespecial 184	com/tencent/biz/pubaccount/readinjoy/viola/modules/EventHelper:b	()Ljava/lang/String;
    //   36: invokevirtual 312	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   39: ifne -30 -> 9
    //   42: aload_2
    //   43: ldc 189
    //   45: invokevirtual 360	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   48: astore 7
    //   50: aload 7
    //   52: invokestatic 70	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   55: ifne -46 -> 9
    //   58: aload_2
    //   59: ldc 191
    //   61: invokevirtual 360	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   64: astore_1
    //   65: aload_1
    //   66: ifnull +198 -> 264
    //   69: new 123	org/json/JSONObject
    //   72: dup
    //   73: aload_1
    //   74: invokespecial 361	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   77: astore_1
    //   78: aload_2
    //   79: ldc 137
    //   81: invokevirtual 365	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   84: astore 8
    //   86: aload 8
    //   88: ifnull -79 -> 9
    //   91: aload_2
    //   92: ldc 200
    //   94: invokevirtual 360	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   97: astore 6
    //   99: aload 5
    //   101: astore_2
    //   102: aload 6
    //   104: ifnull +13 -> 117
    //   107: new 123	org/json/JSONObject
    //   110: dup
    //   111: aload 6
    //   113: invokespecial 361	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   116: astore_2
    //   117: aload_0
    //   118: invokespecial 367	com/tencent/biz/pubaccount/readinjoy/viola/modules/EventHelper:c	()Ljava/lang/String;
    //   121: astore 9
    //   123: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   126: ifeq +74 -> 200
    //   129: aload_0
    //   130: getfield 29	com/tencent/biz/pubaccount/readinjoy/viola/modules/EventHelper:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   133: ifnull +106 -> 239
    //   136: aload_0
    //   137: getfield 29	com/tencent/biz/pubaccount/readinjoy/viola/modules/EventHelper:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   140: invokevirtual 201	java/lang/Object:toString	()Ljava/lang/String;
    //   143: astore 5
    //   145: aload_1
    //   146: ifnull +100 -> 246
    //   149: aload_1
    //   150: invokevirtual 194	org/json/JSONObject:toString	()Ljava/lang/String;
    //   153: astore 6
    //   155: ldc 111
    //   157: iconst_2
    //   158: ldc_w 369
    //   161: iconst_5
    //   162: anewarray 4	java/lang/Object
    //   165: dup
    //   166: iconst_0
    //   167: aload 5
    //   169: aastore
    //   170: dup
    //   171: iconst_1
    //   172: aload 7
    //   174: aastore
    //   175: dup
    //   176: iconst_2
    //   177: aload 6
    //   179: aastore
    //   180: dup
    //   181: iconst_3
    //   182: ldc 205
    //   184: aload 8
    //   186: invokestatic 209	android/text/TextUtils:join	(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;
    //   189: aastore
    //   190: dup
    //   191: iconst_4
    //   192: aload_2
    //   193: aastore
    //   194: invokestatic 213	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   197: invokestatic 216	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   200: aload 8
    //   202: invokevirtual 157	java/util/ArrayList:size	()I
    //   205: istore 4
    //   207: iload_3
    //   208: iload 4
    //   210: if_icmpge -201 -> 9
    //   213: aload 8
    //   215: iload_3
    //   216: invokevirtual 307	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   219: checkcast 97	java/lang/String
    //   222: aload 9
    //   224: invokestatic 374	com/tencent/biz/AuthorizeConfig:b	(Ljava/lang/String;Ljava/lang/String;)Z
    //   227: ifeq +26 -> 253
    //   230: aload_0
    //   231: aload 7
    //   233: aload_1
    //   234: aload_2
    //   235: invokevirtual 233	com/tencent/biz/pubaccount/readinjoy/viola/modules/EventHelper:a	(Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONObject;)V
    //   238: return
    //   239: ldc 238
    //   241: astore 5
    //   243: goto -98 -> 145
    //   246: ldc 238
    //   248: astore 6
    //   250: goto -95 -> 155
    //   253: iload_3
    //   254: iconst_1
    //   255: iadd
    //   256: istore_3
    //   257: goto -50 -> 207
    //   260: astore_1
    //   261: return
    //   262: astore_1
    //   263: return
    //   264: aconst_null
    //   265: astore_1
    //   266: goto -188 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	269	0	this	EventHelper
    //   0	269	1	paramContext	android.content.Context
    //   0	269	2	paramIntent	Intent
    //   4	253	3	i	int
    //   205	6	4	j	int
    //   1	241	5	str1	String
    //   97	152	6	str2	String
    //   48	184	7	str3	String
    //   84	130	8	localArrayList	ArrayList
    //   121	102	9	str4	String
    // Exception table:
    //   from	to	target	type
    //   107	117	260	org/json/JSONException
    //   69	78	262	org/json/JSONException
  }
  
  protected void a(String paramString, JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    ArrayList localArrayList;
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      localArrayList = null;
    }
    for (;;)
    {
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        int i = 0;
        label26:
        if (i < localArrayList.size())
        {
          String str = ((EventHelper.Event)localArrayList.get(i)).b;
          JSONObject localJSONObject = new JSONObject();
          try
          {
            localJSONObject.put("event", paramString);
            localJSONObject.put("data", paramJSONObject1);
            localJSONObject.put("source", paramJSONObject2);
            b(str, localJSONObject);
            i += 1;
            break label26;
            localArrayList = (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              QLog.e("BridgeModule.event", 1, localJSONException.getMessage(), localJSONException);
            }
          }
        }
      }
    }
  }
  
  public void a(JSONObject paramJSONObject, String paramString)
  {
    String str = paramJSONObject.optString("event", paramJSONObject.optString("eventName", ""));
    this.jdField_a_of_type_JavaLangString = a();
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.w("BridgeModule.event", 2, "source url is null");
      }
      a(paramString, "source url is null");
    }
    do
    {
      return;
      if (TextUtils.isEmpty(str))
      {
        if (QLog.isColorLevel()) {
          QLog.w("BridgeModule.event", 2, "event name is null");
        }
        a(paramString, "event name is null");
        return;
      }
      b();
    } while ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null));
    a(str, paramJSONObject.optString("identifier", ((BridgeModule)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getViolaInstance().getInstanceId()), paramString);
  }
  
  public void b(JSONObject paramJSONObject, String paramString)
  {
    String str = paramJSONObject.optString("event", paramJSONObject.optString("eventName", ""));
    if (TextUtils.isEmpty(str))
    {
      if (QLog.isColorLevel()) {
        QLog.w("BridgeModule.event", 2, "event name is null");
      }
      a(paramString, "event name is null");
      return;
    }
    if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      b(str, paramJSONObject.optString("identifier", ((BridgeModule)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getViolaInstance().getInstanceId()), paramString);
    }
    b(paramString, new JSONObject());
  }
  
  public void c(JSONObject paramJSONObject, String paramString)
  {
    String str2 = paramJSONObject.optString("event", paramJSONObject.optString("eventName", ""));
    String str3 = a();
    if (TextUtils.isEmpty(str2))
    {
      if (QLog.isColorLevel()) {
        QLog.w("BridgeModule.event", 2, "event name is null");
      }
      a(paramString, "event name is null");
      return;
    }
    if ((paramString == null) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey(str2))) {
      paramString = ((EventHelper.Event)((ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(str2)).get(0)).b;
    }
    for (;;)
    {
      JSONObject localJSONObject = paramJSONObject.optJSONObject("data");
      if (localJSONObject != null) {}
      for (String str1 = localJSONObject.toString(); ViolaUtils.getBoolean(paramJSONObject.opt("toNative")); str1 = "")
      {
        a(str2, localJSONObject);
        b(paramString, null);
        return;
      }
      a(str3, str1, paramString, paramJSONObject, str2, localJSONObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.modules.EventHelper
 * JD-Core Version:    0.7.0.1
 */
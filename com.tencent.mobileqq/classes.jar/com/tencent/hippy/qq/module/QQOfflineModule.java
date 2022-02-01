package com.tencent.hippy.qq.module;

import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

@HippyNativeModule(name="QQOfflineModule")
public class QQOfflineModule
  extends QQBaseModule
{
  public static final String TAG = "QQOfflineModule";
  
  public QQOfflineModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  private void doPromiseCallback(Promise paramPromise, Object paramObject)
  {
    if ((paramPromise != null) && (paramPromise.isCallback()) && (paramObject != null)) {
      paramPromise.resolve(paramObject);
    }
  }
  
  private void doPromiseCallback(Promise paramPromise, JSONObject paramJSONObject)
  {
    if ((paramPromise != null) && (paramPromise.isCallback()) && (paramJSONObject != null))
    {
      HippyMap localHippyMap = new HippyMap();
      localHippyMap.pushJSONObject(paramJSONObject);
      paramPromise.resolve(localHippyMap);
    }
  }
  
  @HippyMethod(name="batchCheckUpdate")
  public void batchCheckUpdate(HippyMap paramHippyMap, Promise paramPromise)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("batchCheckUpdate:");
      ((StringBuilder)localObject1).append(paramHippyMap);
      ((StringBuilder)localObject1).append(",promise:");
      ((StringBuilder)localObject1).append(paramPromise);
      QLog.i("QQOfflineModule", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new JSONObject();
    if (paramHippyMap != null) {}
    try
    {
      paramHippyMap = paramHippyMap.toJSONObject();
      break label85;
      paramHippyMap = new JSONObject();
      label85:
      paramHippyMap = paramHippyMap.optJSONArray("bids");
      int j = paramHippyMap.length();
      localObject2 = new ArrayList(j);
      int i = 0;
      while (i < j)
      {
        ((ArrayList)localObject2).add(paramHippyMap.optString(i));
        i += 1;
      }
      HtmlOffline.a((ArrayList)localObject2, MobileQQ.sMobileQQ.waitAppRuntime(null), new QQOfflineModule.1(this, (JSONObject)localObject1, paramPromise), true, true);
      return;
    }
    catch (Throwable paramHippyMap)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("OfflinePlugin, batchCheckUpdate, JSONException :");
      ((StringBuilder)localObject2).append(paramHippyMap);
      QLog.d("QQOfflineModule", 1, ((StringBuilder)localObject2).toString());
      try
      {
        ((JSONObject)localObject1).put("retcode", -1);
        ((JSONObject)localObject1).put("msg", "error");
        doPromiseCallback(paramPromise, (JSONObject)localObject1);
        return;
      }
      catch (Throwable paramHippyMap)
      {
        QLog.d("QQOfflineModule", 1, paramHippyMap, new Object[0]);
      }
    }
  }
  
  /* Error */
  @HippyMethod(name="clearCache")
  public void clearCache(HippyMap paramHippyMap, Promise paramPromise)
  {
    // Byte code:
    //   0: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +53 -> 56
    //   6: new 53	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   13: astore 4
    //   15: aload 4
    //   17: ldc 153
    //   19: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: pop
    //   23: aload 4
    //   25: aload_1
    //   26: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload 4
    //   32: ldc 65
    //   34: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload 4
    //   40: aload_2
    //   41: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: ldc 10
    //   47: iconst_2
    //   48: aload 4
    //   50: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokestatic 73	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   56: new 75	org/json/JSONObject
    //   59: dup
    //   60: invokespecial 76	org/json/JSONObject:<init>	()V
    //   63: astore 4
    //   65: aload_1
    //   66: ifnull +11 -> 77
    //   69: aload_1
    //   70: invokevirtual 80	com/tencent/mtt/hippy/common/HippyMap:toJSONObject	()Lorg/json/JSONObject;
    //   73: astore_1
    //   74: goto +11 -> 85
    //   77: new 75	org/json/JSONObject
    //   80: dup
    //   81: invokespecial 76	org/json/JSONObject:<init>	()V
    //   84: astore_1
    //   85: aload_1
    //   86: ldc 155
    //   88: invokevirtual 158	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   91: astore_1
    //   92: getstatic 111	mqq/app/MobileQQ:sMobileQQ	Lmqq/app/MobileQQ;
    //   95: aload_1
    //   96: iconst_1
    //   97: invokestatic 161	com/tencent/biz/common/offline/HtmlOffline:a	(Landroid/content/Context;Ljava/lang/String;I)V
    //   100: aload 4
    //   102: ldc 133
    //   104: iconst_0
    //   105: invokevirtual 137	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   108: pop
    //   109: aload 4
    //   111: ldc 139
    //   113: ldc 163
    //   115: invokevirtual 144	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   118: pop
    //   119: goto +115 -> 234
    //   122: astore_1
    //   123: goto +119 -> 242
    //   126: astore_1
    //   127: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   130: istore_3
    //   131: iload_3
    //   132: ifeq +38 -> 170
    //   135: new 53	java/lang/StringBuilder
    //   138: dup
    //   139: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   142: astore 5
    //   144: aload 5
    //   146: ldc 165
    //   148: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: pop
    //   152: aload 5
    //   154: aload_1
    //   155: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   158: pop
    //   159: ldc 10
    //   161: iconst_2
    //   162: aload 5
    //   164: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokestatic 131	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   170: aload 4
    //   172: ldc 133
    //   174: iconst_m1
    //   175: invokevirtual 137	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   178: pop
    //   179: aload 4
    //   181: ldc 139
    //   183: ldc 141
    //   185: invokevirtual 144	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   188: pop
    //   189: goto +45 -> 234
    //   192: astore_1
    //   193: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   196: ifeq +38 -> 234
    //   199: new 53	java/lang/StringBuilder
    //   202: dup
    //   203: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   206: astore 5
    //   208: aload 5
    //   210: ldc 165
    //   212: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: aload 5
    //   218: aload_1
    //   219: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: ldc 10
    //   225: iconst_2
    //   226: aload 5
    //   228: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: invokestatic 131	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   234: aload_0
    //   235: aload_2
    //   236: aload 4
    //   238: invokespecial 21	com/tencent/hippy/qq/module/QQOfflineModule:doPromiseCallback	(Lcom/tencent/mtt/hippy/modules/Promise;Lorg/json/JSONObject;)V
    //   241: return
    //   242: aload_0
    //   243: aload_2
    //   244: aload 4
    //   246: invokespecial 21	com/tencent/hippy/qq/module/QQOfflineModule:doPromiseCallback	(Lcom/tencent/mtt/hippy/modules/Promise;Lorg/json/JSONObject;)V
    //   249: aload_1
    //   250: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	251	0	this	QQOfflineModule
    //   0	251	1	paramHippyMap	HippyMap
    //   0	251	2	paramPromise	Promise
    //   130	2	3	bool	boolean
    //   13	232	4	localObject	Object
    //   142	85	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   69	74	122	finally
    //   77	85	122	finally
    //   85	119	122	finally
    //   127	131	122	finally
    //   135	170	122	finally
    //   170	189	122	finally
    //   193	234	122	finally
    //   69	74	126	java/lang/Throwable
    //   77	85	126	java/lang/Throwable
    //   85	119	126	java/lang/Throwable
    //   170	189	192	java/lang/Throwable
  }
  
  /* Error */
  @HippyMethod(name="isCached")
  public void isCached(HippyMap paramHippyMap, Promise paramPromise)
  {
    // Byte code:
    //   0: ldc 170
    //   2: astore_3
    //   3: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +53 -> 59
    //   9: new 53	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   16: astore 4
    //   18: aload 4
    //   20: ldc 172
    //   22: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: pop
    //   26: aload 4
    //   28: aload_1
    //   29: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: aload 4
    //   35: ldc 65
    //   37: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload 4
    //   43: aload_2
    //   44: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: ldc 10
    //   50: iconst_2
    //   51: aload 4
    //   53: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokestatic 73	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   59: aload_1
    //   60: invokevirtual 80	com/tencent/mtt/hippy/common/HippyMap:toJSONObject	()Lorg/json/JSONObject;
    //   63: ldc 155
    //   65: invokevirtual 158	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   68: invokestatic 174	com/tencent/biz/common/offline/HtmlOffline:a	(Ljava/lang/String;)Ljava/lang/String;
    //   71: astore 4
    //   73: aload 4
    //   75: astore_1
    //   76: aload 4
    //   78: invokestatic 180	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   81: ifeq +6 -> 87
    //   84: ldc 170
    //   86: astore_1
    //   87: aload_0
    //   88: aload_2
    //   89: aload_1
    //   90: invokespecial 182	com/tencent/hippy/qq/module/QQOfflineModule:doPromiseCallback	(Lcom/tencent/mtt/hippy/modules/Promise;Ljava/lang/Object;)V
    //   93: return
    //   94: astore_1
    //   95: goto +58 -> 153
    //   98: astore_1
    //   99: new 53	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   106: astore 4
    //   108: aload 4
    //   110: ldc 184
    //   112: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: aload 4
    //   118: aload_1
    //   119: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: ldc 10
    //   125: iconst_1
    //   126: aload 4
    //   128: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: invokestatic 131	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   134: aconst_null
    //   135: invokestatic 180	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   138: ifeq +6 -> 144
    //   141: goto +5 -> 146
    //   144: aconst_null
    //   145: astore_3
    //   146: aload_0
    //   147: aload_2
    //   148: aload_3
    //   149: invokespecial 182	com/tencent/hippy/qq/module/QQOfflineModule:doPromiseCallback	(Lcom/tencent/mtt/hippy/modules/Promise;Ljava/lang/Object;)V
    //   152: return
    //   153: aconst_null
    //   154: invokestatic 180	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   157: ifeq +6 -> 163
    //   160: goto +5 -> 165
    //   163: aconst_null
    //   164: astore_3
    //   165: aload_0
    //   166: aload_2
    //   167: aload_3
    //   168: invokespecial 182	com/tencent/hippy/qq/module/QQOfflineModule:doPromiseCallback	(Lcom/tencent/mtt/hippy/modules/Promise;Ljava/lang/Object;)V
    //   171: aload_1
    //   172: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	this	QQOfflineModule
    //   0	173	1	paramHippyMap	HippyMap
    //   0	173	2	paramPromise	Promise
    //   2	166	3	str	String
    //   16	111	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   59	73	94	finally
    //   99	134	94	finally
    //   59	73	98	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.module.QQOfflineModule
 * JD-Core Version:    0.7.0.1
 */
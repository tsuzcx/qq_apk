import android.content.Context;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;

@JsPlugin(secondary=true)
public class bjtl
  extends BaseJsPlugin
{
  private bjtn a;
  
  /* Error */
  @com.tencent.qqmini.sdk.annotation.JsEvent({"checkin_invokeGYCamera"})
  public void checkinInvokeGYCamera(com.tencent.qqmini.sdk.launcher.core.model.RequestEvent paramRequestEvent)
  {
    // Byte code:
    //   0: new 37	org/json/JSONObject
    //   3: dup
    //   4: aload_1
    //   5: getfield 43	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:jsonParams	Ljava/lang/String;
    //   8: invokespecial 46	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   11: astore_3
    //   12: aload_0
    //   13: getfield 19	bjtl:mMiniAppContext	Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   16: invokeinterface 52 1 0
    //   21: ifnull +294 -> 315
    //   24: aload_0
    //   25: getfield 54	bjtl:a	Lbjtn;
    //   28: ifnull +19 -> 47
    //   31: aload_0
    //   32: getfield 19	bjtl:mMiniAppContext	Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   35: invokeinterface 52 1 0
    //   40: aload_0
    //   41: getfield 54	bjtl:a	Lbjtn;
    //   44: invokevirtual 60	android/content/Context:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   47: aload_3
    //   48: ldc 62
    //   50: invokevirtual 66	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   53: astore 6
    //   55: new 68	android/os/Bundle
    //   58: dup
    //   59: invokespecial 69	android/os/Bundle:<init>	()V
    //   62: astore 5
    //   64: aload 6
    //   66: ifnonnull +28 -> 94
    //   69: ldc 71
    //   71: iconst_1
    //   72: ldc 73
    //   74: invokestatic 79	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   77: aload_1
    //   78: invokevirtual 83	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:fail	()Ljava/lang/String;
    //   81: pop
    //   82: return
    //   83: astore_1
    //   84: ldc 71
    //   86: iconst_1
    //   87: ldc 85
    //   89: aload_1
    //   90: invokestatic 88	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   93: return
    //   94: ldc 71
    //   96: iconst_1
    //   97: new 90	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   104: ldc 93
    //   106: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: aload 6
    //   111: invokevirtual 100	org/json/JSONObject:toString	()Ljava/lang/String;
    //   114: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   123: ldc 106
    //   125: astore_3
    //   126: getstatic 111	bnqb:a	Lbnqb;
    //   129: invokevirtual 114	bnqb:a	()I
    //   132: istore_2
    //   133: ldc 106
    //   135: astore 4
    //   137: aload 6
    //   139: ldc 116
    //   141: invokevirtual 120	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   144: ifeq +11 -> 155
    //   147: aload 6
    //   149: ldc 116
    //   151: invokevirtual 124	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   154: astore_3
    //   155: aload 6
    //   157: ldc 126
    //   159: invokevirtual 120	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   162: ifeq +17 -> 179
    //   165: aload 6
    //   167: ldc 126
    //   169: invokevirtual 124	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   172: invokestatic 129	bnqb:a	(Ljava/lang/String;)Lbnqb;
    //   175: invokevirtual 114	bnqb:a	()I
    //   178: istore_2
    //   179: aload 6
    //   181: ldc 131
    //   183: invokevirtual 120	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   186: ifeq +12 -> 198
    //   189: aload 6
    //   191: ldc 131
    //   193: invokevirtual 124	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   196: astore 4
    //   198: aload 5
    //   200: ldc 133
    //   202: iload_2
    //   203: invokevirtual 137	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   206: aload 5
    //   208: ldc 131
    //   210: aload 4
    //   212: invokevirtual 140	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   215: aload_0
    //   216: getfield 19	bjtl:mMiniAppContext	Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   219: invokeinterface 52 1 0
    //   224: ldc 142
    //   226: iconst_0
    //   227: invokevirtual 146	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   230: invokeinterface 152 1 0
    //   235: ldc 154
    //   237: aload_3
    //   238: invokeinterface 159 3 0
    //   243: invokeinterface 162 1 0
    //   248: invokestatic 168	com/tencent/mobileqq/qipc/QIPCClientHelper:getInstance	()Lcom/tencent/mobileqq/qipc/QIPCClientHelper;
    //   251: ldc 170
    //   253: ldc 172
    //   255: aload 5
    //   257: aconst_null
    //   258: invokevirtual 176	com/tencent/mobileqq/qipc/QIPCClientHelper:callServer	(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Leipc/EIPCResultCallback;)V
    //   261: aload_1
    //   262: invokevirtual 179	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:ok	()Ljava/lang/String;
    //   265: pop
    //   266: aload_0
    //   267: getfield 19	bjtl:mMiniAppContext	Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   270: invokeinterface 52 1 0
    //   275: astore_1
    //   276: new 181	bjtn
    //   279: dup
    //   280: aload_0
    //   281: aconst_null
    //   282: invokespecial 184	bjtn:<init>	(Lbjtl;Lbjtm;)V
    //   285: astore_3
    //   286: aload_0
    //   287: aload_3
    //   288: putfield 54	bjtl:a	Lbjtn;
    //   291: aload_1
    //   292: aload_3
    //   293: new 186	android/content/IntentFilter
    //   296: dup
    //   297: ldc 188
    //   299: invokespecial 189	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
    //   302: invokevirtual 193	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   305: pop
    //   306: return
    //   307: astore_3
    //   308: aload_3
    //   309: invokevirtual 196	org/json/JSONException:printStackTrace	()V
    //   312: goto -64 -> 248
    //   315: ldc 71
    //   317: iconst_1
    //   318: ldc 198
    //   320: invokestatic 79	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   323: return
    //   324: astore 4
    //   326: goto -279 -> 47
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	329	0	this	bjtl
    //   0	329	1	paramRequestEvent	com.tencent.qqmini.sdk.launcher.core.model.RequestEvent
    //   132	71	2	i	int
    //   11	282	3	localObject	java.lang.Object
    //   307	2	3	localJSONException	org.json.JSONException
    //   135	76	4	str	java.lang.String
    //   324	1	4	localThrowable	Throwable
    //   62	194	5	localBundle	android.os.Bundle
    //   53	137	6	localJSONObject	org.json.JSONObject
    // Exception table:
    //   from	to	target	type
    //   0	12	83	org/json/JSONException
    //   69	82	307	org/json/JSONException
    //   94	123	307	org/json/JSONException
    //   126	133	307	org/json/JSONException
    //   137	155	307	org/json/JSONException
    //   155	179	307	org/json/JSONException
    //   179	198	307	org/json/JSONException
    //   198	248	307	org/json/JSONException
    //   31	47	324	java/lang/Throwable
  }
  
  public void onDestroy()
  {
    if ((this.mMiniAppContext.getContext() != null) && (this.a != null)) {}
    try
    {
      this.mMiniAppContext.getContext().unregisterReceiver(this.a);
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjtl
 * JD-Core Version:    0.7.0.1
 */
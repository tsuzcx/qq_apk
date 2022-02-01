import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.qqmini.proxyimpl.AdProxyImpl.1;

public class bjbl
  implements MiniAppCmdInterface
{
  public bjbl(AdProxyImpl.1 param1) {}
  
  /* Error */
  public void onCmdListener(boolean paramBoolean, org.json.JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: iload_1
    //   1: ifeq +7 -> 8
    //   4: aload_2
    //   5: ifnonnull +28 -> 33
    //   8: aload_0
    //   9: getfield 12	bjbl:a	Lcom/tencent/qqmini/proxyimpl/AdProxyImpl$1;
    //   12: getfield 27	com/tencent/qqmini/proxyimpl/AdProxyImpl$1:a	Lcom/tencent/qqmini/sdk/launcher/core/proxy/AdProxy$ICmdListener;
    //   15: ifnull +17 -> 32
    //   18: aload_0
    //   19: getfield 12	bjbl:a	Lcom/tencent/qqmini/proxyimpl/AdProxyImpl$1;
    //   22: getfield 27	com/tencent/qqmini/proxyimpl/AdProxyImpl$1:a	Lcom/tencent/qqmini/sdk/launcher/core/proxy/AdProxy$ICmdListener;
    //   25: iconst_0
    //   26: aload_2
    //   27: invokeinterface 31 3 0
    //   32: return
    //   33: new 33	org/json/JSONObject
    //   36: dup
    //   37: invokespecial 34	org/json/JSONObject:<init>	()V
    //   40: astore 4
    //   42: aload_2
    //   43: ldc 36
    //   45: invokevirtual 40	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   48: checkcast 42	NS_MINI_AD/MiniAppAd$StGetAdRsp
    //   51: astore 5
    //   53: aload_2
    //   54: ldc 44
    //   56: invokevirtual 48	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   59: istore_3
    //   60: aload_2
    //   61: ldc 50
    //   63: invokevirtual 54	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   66: astore_2
    //   67: aload 5
    //   69: getfield 58	NS_MINI_AD/MiniAppAd$StGetAdRsp:strAdsJson	Lcom/tencent/mobileqq/pb/PBStringField;
    //   72: invokevirtual 63	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   75: astore 6
    //   77: ldc 65
    //   79: iconst_1
    //   80: new 67	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   87: ldc 70
    //   89: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: iload_3
    //   93: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   96: ldc 79
    //   98: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: aload_2
    //   102: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: ldc 81
    //   107: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: aload 6
    //   112: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokestatic 90	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   121: aload 4
    //   123: ldc 44
    //   125: iload_3
    //   126: invokevirtual 94	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   129: pop
    //   130: aload 4
    //   132: ldc 50
    //   134: aload_2
    //   135: invokevirtual 97	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   138: pop
    //   139: aload 4
    //   141: ldc 36
    //   143: aload 6
    //   145: invokevirtual 97	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   148: pop
    //   149: aload 4
    //   151: ldc 99
    //   153: aload 5
    //   155: getfield 102	NS_MINI_AD/MiniAppAd$StGetAdRsp:strAdTemplateJson	Lcom/tencent/mobileqq/pb/PBStringField;
    //   158: invokevirtual 63	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   161: invokevirtual 97	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   164: pop
    //   165: aload_0
    //   166: getfield 12	bjbl:a	Lcom/tencent/qqmini/proxyimpl/AdProxyImpl$1;
    //   169: getfield 27	com/tencent/qqmini/proxyimpl/AdProxyImpl$1:a	Lcom/tencent/qqmini/sdk/launcher/core/proxy/AdProxy$ICmdListener;
    //   172: ifnull +18 -> 190
    //   175: aload_0
    //   176: getfield 12	bjbl:a	Lcom/tencent/qqmini/proxyimpl/AdProxyImpl$1;
    //   179: getfield 27	com/tencent/qqmini/proxyimpl/AdProxyImpl$1:a	Lcom/tencent/qqmini/sdk/launcher/core/proxy/AdProxy$ICmdListener;
    //   182: iload_1
    //   183: aload 4
    //   185: invokeinterface 31 3 0
    //   190: iload_3
    //   191: ifne -159 -> 32
    //   194: aload 6
    //   196: invokestatic 108	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   199: istore_1
    //   200: iload_1
    //   201: ifne -169 -> 32
    //   204: aload 5
    //   206: getfield 112	NS_MINI_AD/MiniAppAd$StGetAdRsp:vecAppInfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   209: ifnull -177 -> 32
    //   212: aload 5
    //   214: getfield 112	NS_MINI_AD/MiniAppAd$StGetAdRsp:vecAppInfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   217: invokevirtual 118	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   220: ifle -188 -> 32
    //   223: aload 5
    //   225: getfield 122	NS_MINI_AD/MiniAppAd$StGetAdRsp:iPreLoadLevel	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   228: invokevirtual 127	com/tencent/mobileqq/pb/PBInt64Field:get	()J
    //   231: ldc2_w 128
    //   234: lcmp
    //   235: ifne -203 -> 32
    //   238: iconst_0
    //   239: istore_3
    //   240: iload_3
    //   241: aload 5
    //   243: getfield 112	NS_MINI_AD/MiniAppAd$StGetAdRsp:vecAppInfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   246: invokevirtual 118	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   249: if_icmpge -217 -> 32
    //   252: aload 5
    //   254: getfield 112	NS_MINI_AD/MiniAppAd$StGetAdRsp:vecAppInfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   257: iload_3
    //   258: invokevirtual 132	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   261: checkcast 134	NS_MINI_INTERFACE/INTERFACE$StApiAppInfo
    //   264: invokestatic 140	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:from	(LNS_MINI_INTERFACE/INTERFACE$StApiAppInfo;)Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   267: invokestatic 145	bjeo:a	(Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;)Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   270: invokestatic 151	com/tencent/mobileqq/minigame/gpkg/GpkgManager:preloadGpkgByConfig	(Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;)V
    //   273: iload_3
    //   274: iconst_1
    //   275: iadd
    //   276: istore_3
    //   277: goto -37 -> 240
    //   280: astore_2
    //   281: ldc 65
    //   283: iconst_1
    //   284: ldc 153
    //   286: aload_2
    //   287: invokestatic 157	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   290: return
    //   291: astore_2
    //   292: aload_2
    //   293: invokevirtual 160	org/json/JSONException:printStackTrace	()V
    //   296: aload_0
    //   297: getfield 12	bjbl:a	Lcom/tencent/qqmini/proxyimpl/AdProxyImpl$1;
    //   300: getfield 27	com/tencent/qqmini/proxyimpl/AdProxyImpl$1:a	Lcom/tencent/qqmini/sdk/launcher/core/proxy/AdProxy$ICmdListener;
    //   303: ifnull -271 -> 32
    //   306: aload_0
    //   307: getfield 12	bjbl:a	Lcom/tencent/qqmini/proxyimpl/AdProxyImpl$1;
    //   310: getfield 27	com/tencent/qqmini/proxyimpl/AdProxyImpl$1:a	Lcom/tencent/qqmini/sdk/launcher/core/proxy/AdProxy$ICmdListener;
    //   313: iconst_0
    //   314: aconst_null
    //   315: invokeinterface 31 3 0
    //   320: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	321	0	this	bjbl
    //   0	321	1	paramBoolean	boolean
    //   0	321	2	paramJSONObject	org.json.JSONObject
    //   59	218	3	i	int
    //   40	144	4	localJSONObject	org.json.JSONObject
    //   51	202	5	localStGetAdRsp	NS_MINI_AD.MiniAppAd.StGetAdRsp
    //   75	120	6	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   204	238	280	java/lang/Throwable
    //   240	273	280	java/lang/Throwable
    //   42	190	291	org/json/JSONException
    //   194	200	291	org/json/JSONException
    //   204	238	291	org/json/JSONException
    //   240	273	291	org/json/JSONException
    //   281	290	291	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjbl
 * JD-Core Version:    0.7.0.1
 */
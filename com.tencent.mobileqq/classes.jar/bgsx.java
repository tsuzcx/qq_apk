import android.os.Bundle;
import cooperation.wadl.ipc.WadlParams;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class bgsx
  implements bgte
{
  public bgsp a;
  
  public bgsx()
  {
    bckd.b("WadlProxyServiceWrap", "##@WadlProxyServiceWrap()");
    this.a = new bgsp();
    bgtf.a().a(this);
  }
  
  public static long a()
  {
    try
    {
      long l = azzz.b();
      return l;
    }
    catch (Exception localException) {}
    return 0L;
  }
  
  public List<bgso> a()
  {
    return this.a.a();
  }
  
  public void a()
  {
    bckd.b("WadlProxyServiceWrap", "##@launchService");
    this.a.a();
  }
  
  public void a(int paramInt, String paramString)
  {
    bckd.b("WadlProxyServiceWrap", "doPauseAction from=" + paramInt + ",appId=" + paramString);
    Bundle localBundle = new Bundle();
    localBundle.putString("WADL.REMOTE_NOTIFY_CMD_NAME", "doPauseAction");
    localBundle.putString("appId", paramString);
    localBundle.putInt("actionFrom", paramInt);
    this.a.a(localBundle);
  }
  
  public void a(bgso parambgso)
  {
    this.a.a(parambgso);
  }
  
  public void a(WadlParams paramWadlParams)
  {
    bckd.b("WadlProxyServiceWrap", "doDownloadAction wadlParams=" + paramWadlParams);
    Bundle localBundle = new Bundle();
    localBundle.putString("WADL.REMOTE_NOTIFY_CMD_NAME", "doDownloadAction");
    localBundle.putString("appId", paramWadlParams.a);
    localBundle.putInt("actionFrom", paramWadlParams.jdField_d_of_type_Int);
    localBundle.putParcelable("download_wadl_params", paramWadlParams);
    bgtf.a().a(paramWadlParams, localBundle);
  }
  
  public void a(String paramString)
  {
    bckd.b("WadlProxyServiceWrap", "doQueryActionByVia via=" + paramString);
    Bundle localBundle = new Bundle();
    localBundle.putString("WADL.REMOTE_NOTIFY_CMD_NAME", "doQueryActionByVia");
    localBundle.putString("via", paramString);
    this.a.a(localBundle);
  }
  
  public void a(String paramString1, String paramString2)
  {
    bckd.b("WadlProxyServiceWrap", "receive system receiver cmd=" + paramString1 + ",packageName=" + paramString2);
    Bundle localBundle = new Bundle();
    localBundle.putString("WADL.REMOTE_NOTIFY_CMD_NAME", paramString1);
    localBundle.putString("packageName", paramString2);
    this.a.a(localBundle);
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    bckd.b("WadlProxyServiceWrap", "doQueryAction:" + paramArrayList.toString());
    Bundle localBundle = new Bundle();
    localBundle.putString("WADL.REMOTE_NOTIFY_CMD_NAME", "doQueryAction");
    localBundle.putStringArrayList("appIdLis", paramArrayList);
    this.a.a(localBundle);
  }
  
  public void b()
  {
    bckd.b("WadlProxyServiceWrap", "doQueryAllTask");
    Bundle localBundle = new Bundle();
    localBundle.putString("WADL.REMOTE_NOTIFY_CMD_NAME", "doQueryAllTask");
    this.a.a(localBundle);
  }
  
  public void b(int paramInt, String paramString)
  {
    bckd.b("WadlProxyServiceWrap", "doResumeAction from=" + paramInt + ",appId=" + paramString);
    Bundle localBundle = new Bundle();
    localBundle.putString("WADL.REMOTE_NOTIFY_CMD_NAME", "doResumeAction");
    localBundle.putString("appId", paramString);
    localBundle.putInt("actionFrom", paramInt);
    this.a.a(localBundle);
  }
  
  public void b(bgso parambgso)
  {
    this.a.b(parambgso);
  }
  
  public void b(WadlParams paramWadlParams)
  {
    bckd.b("WadlProxyServiceWrap", "doInstallAction：" + paramWadlParams);
    Bundle localBundle = new Bundle();
    localBundle.putString("WADL.REMOTE_NOTIFY_CMD_NAME", "doInstallAction");
    localBundle.putParcelable("download_wadl_params", paramWadlParams);
    localBundle.putString("appId", paramWadlParams.a);
    localBundle.putInt("actionFrom", paramWadlParams.jdField_d_of_type_Int);
    this.a.a(localBundle);
    try
    {
      bcko.a(paramWadlParams.j, paramWadlParams.a);
      return;
    }
    catch (Exception paramWadlParams)
    {
      bckd.a("WadlProxyServiceWrap", "savePackageInfo", paramWadlParams);
    }
  }
  
  public void c()
  {
    bckd.b("WadlProxyServiceWrap", "initWadlTaskManager:");
    Bundle localBundle = new Bundle();
    localBundle.putString("WADL.REMOTE_NOTIFY_CMD_NAME", "doInitWadlTaskManager");
    this.a.a(localBundle);
  }
  
  public void c(int paramInt, String paramString)
  {
    bckd.b("WadlProxyServiceWrap", "##@deleteDownload from=" + paramInt + ",appID=" + paramString);
    Bundle localBundle = new Bundle();
    localBundle.putString("WADL.REMOTE_NOTIFY_CMD_NAME", "doDeleteAction");
    localBundle.putString("appId", paramString);
    localBundle.putInt("actionFrom", paramInt);
    this.a.a(localBundle);
  }
  
  public void d()
  {
    bgtf.a().b();
    this.a.d();
  }
  
  public HashSet<String> getFilterCmds()
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add("12829");
    return localHashSet;
  }
  
  /* Error */
  public void onCmdRsp(android.content.Intent paramIntent, String paramString, long paramLong, org.json.JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: ldc 14
    //   2: new 55	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   9: ldc 209
    //   11: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: aload_2
    //   15: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: ldc 211
    //   20: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: lload_3
    //   24: invokevirtual 214	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   27: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 22	bckd:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   33: ldc 196
    //   35: aload_2
    //   36: invokevirtual 219	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   39: ifeq +26 -> 65
    //   42: aload_1
    //   43: invokevirtual 225	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   46: astore 12
    //   48: aload 12
    //   50: ldc 114
    //   52: invokevirtual 229	android/os/Bundle:getParcelable	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   55: checkcast 105	cooperation/wadl/ipc/WadlParams
    //   58: astore 13
    //   60: aload 13
    //   62: ifnonnull +4 -> 66
    //   65: return
    //   66: lload_3
    //   67: lconst_0
    //   68: lcmp
    //   69: ifne +200 -> 269
    //   72: aload 5
    //   74: ifnull +195 -> 269
    //   77: aload 5
    //   79: ldc 231
    //   81: ldc 233
    //   83: invokevirtual 239	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   86: astore_1
    //   87: aload 5
    //   89: ldc 241
    //   91: ldc 233
    //   93: invokevirtual 239	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   96: astore_2
    //   97: aload 5
    //   99: ldc 243
    //   101: ldc 233
    //   103: invokevirtual 239	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   106: astore 11
    //   108: aload 5
    //   110: ldc 245
    //   112: ldc 233
    //   114: invokevirtual 239	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   117: astore 10
    //   119: aload 5
    //   121: ldc 247
    //   123: ldc 233
    //   125: invokevirtual 239	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   128: astore 9
    //   130: aload 5
    //   132: ldc 249
    //   134: invokevirtual 252	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   137: astore 14
    //   139: aload 5
    //   141: ldc 254
    //   143: ldc 233
    //   145: invokevirtual 239	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   148: astore 5
    //   150: iconst_0
    //   151: istore 7
    //   153: aload 14
    //   155: invokestatic 260	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   158: istore 8
    //   160: iload 7
    //   162: istore 6
    //   164: iload 8
    //   166: ifne +10 -> 176
    //   169: aload 14
    //   171: invokestatic 266	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   174: istore 6
    //   176: aload_1
    //   177: invokestatic 260	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   180: ifne +132 -> 312
    //   183: aload 13
    //   185: aload_1
    //   186: putfield 108	cooperation/wadl/ipc/WadlParams:a	Ljava/lang/String;
    //   189: aload 11
    //   191: invokestatic 260	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   194: ifne +127 -> 321
    //   197: aload 11
    //   199: astore_1
    //   200: aload 13
    //   202: aload_1
    //   203: putfield 268	cooperation/wadl/ipc/WadlParams:b	Ljava/lang/String;
    //   206: aload 10
    //   208: invokestatic 260	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   211: ifne +119 -> 330
    //   214: aload 10
    //   216: astore_1
    //   217: aload 13
    //   219: aload_1
    //   220: putfield 164	cooperation/wadl/ipc/WadlParams:j	Ljava/lang/String;
    //   223: aload 13
    //   225: iload 6
    //   227: putfield 271	cooperation/wadl/ipc/WadlParams:f	I
    //   230: aload 9
    //   232: invokestatic 260	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   235: ifne +104 -> 339
    //   238: aload 9
    //   240: astore_1
    //   241: aload 13
    //   243: aload_1
    //   244: putfield 274	cooperation/wadl/ipc/WadlParams:k	Ljava/lang/String;
    //   247: aload_2
    //   248: invokestatic 260	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   251: ifne +97 -> 348
    //   254: aload_2
    //   255: astore_1
    //   256: aload 13
    //   258: aload_1
    //   259: putfield 276	cooperation/wadl/ipc/WadlParams:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   262: aload 13
    //   264: aload 5
    //   266: putfield 278	cooperation/wadl/ipc/WadlParams:c	Ljava/lang/String;
    //   269: aload 12
    //   271: ldc 114
    //   273: aload 13
    //   275: invokevirtual 118	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   278: aload_0
    //   279: getfield 27	bgsx:a	Lbgsp;
    //   282: aload 12
    //   284: invokevirtual 92	bgsp:a	(Landroid/os/Bundle;)V
    //   287: aload 13
    //   289: getfield 164	cooperation/wadl/ipc/WadlParams:j	Ljava/lang/String;
    //   292: aload 13
    //   294: getfield 108	cooperation/wadl/ipc/WadlParams:a	Ljava/lang/String;
    //   297: invokestatic 169	bcko:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   300: pop
    //   301: return
    //   302: astore_1
    //   303: ldc 14
    //   305: ldc 171
    //   307: aload_1
    //   308: invokestatic 174	bckd:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   311: return
    //   312: aload 13
    //   314: getfield 108	cooperation/wadl/ipc/WadlParams:a	Ljava/lang/String;
    //   317: astore_1
    //   318: goto -135 -> 183
    //   321: aload 13
    //   323: getfield 268	cooperation/wadl/ipc/WadlParams:b	Ljava/lang/String;
    //   326: astore_1
    //   327: goto -127 -> 200
    //   330: aload 13
    //   332: getfield 164	cooperation/wadl/ipc/WadlParams:j	Ljava/lang/String;
    //   335: astore_1
    //   336: goto -119 -> 217
    //   339: aload 13
    //   341: getfield 274	cooperation/wadl/ipc/WadlParams:k	Ljava/lang/String;
    //   344: astore_1
    //   345: goto -104 -> 241
    //   348: aload 13
    //   350: getfield 276	cooperation/wadl/ipc/WadlParams:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   353: astore_1
    //   354: goto -98 -> 256
    //   357: astore_1
    //   358: ldc 14
    //   360: ldc_w 280
    //   363: aload_1
    //   364: invokestatic 174	bckd:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   367: goto -98 -> 269
    //   370: astore 14
    //   372: iload 7
    //   374: istore 6
    //   376: goto -200 -> 176
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	379	0	this	bgsx
    //   0	379	1	paramIntent	android.content.Intent
    //   0	379	2	paramString	String
    //   0	379	3	paramLong	long
    //   0	379	5	paramJSONObject	org.json.JSONObject
    //   162	213	6	i	int
    //   151	222	7	j	int
    //   158	7	8	bool	boolean
    //   128	111	9	str1	String
    //   117	98	10	str2	String
    //   106	92	11	str3	String
    //   46	237	12	localBundle	Bundle
    //   58	291	13	localWadlParams	WadlParams
    //   137	33	14	str4	String
    //   370	1	14	localNumberFormatException	java.lang.NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   287	301	302	java/lang/Exception
    //   77	150	357	java/lang/Throwable
    //   153	160	357	java/lang/Throwable
    //   169	176	357	java/lang/Throwable
    //   176	183	357	java/lang/Throwable
    //   183	197	357	java/lang/Throwable
    //   200	214	357	java/lang/Throwable
    //   217	238	357	java/lang/Throwable
    //   241	254	357	java/lang/Throwable
    //   256	269	357	java/lang/Throwable
    //   312	318	357	java/lang/Throwable
    //   321	327	357	java/lang/Throwable
    //   330	336	357	java/lang/Throwable
    //   339	345	357	java/lang/Throwable
    //   348	354	357	java/lang/Throwable
    //   169	176	370	java/lang/NumberFormatException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgsx
 * JD-Core Version:    0.7.0.1
 */
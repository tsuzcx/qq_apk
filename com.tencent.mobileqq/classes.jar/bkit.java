import android.os.Bundle;
import cooperation.wadl.ipc.WadlParams;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class bkit
  implements bkja
{
  public bkil a;
  
  public bkit()
  {
    bfrz.c("WadlProxyServiceWrap", "##@WadlProxyServiceWrap()");
    this.a = new bkil();
    bkjb.a().a(this);
  }
  
  public static long a()
  {
    try
    {
      long l = bdeu.b();
      return l;
    }
    catch (Exception localException) {}
    return 0L;
  }
  
  public List<bkik> a()
  {
    return this.a.a();
  }
  
  public void a()
  {
    bfrz.c("WadlProxyServiceWrap", "##@launchService");
    this.a.a();
  }
  
  public void a(int paramInt, String paramString)
  {
    bfrz.c("WadlProxyServiceWrap", "doPauseAction from=" + paramInt + ",appId=" + paramString);
    Bundle localBundle = new Bundle();
    localBundle.putString("WADL.REMOTE_NOTIFY_CMD_NAME", "doPauseAction");
    localBundle.putString("appId", paramString);
    localBundle.putInt("actionFrom", paramInt);
    this.a.a(localBundle);
  }
  
  public void a(bkik parambkik)
  {
    this.a.a(parambkik);
  }
  
  public void a(WadlParams paramWadlParams)
  {
    bfrz.c("WadlProxyServiceWrap", "doDownloadAction wadlParams=" + paramWadlParams);
    Bundle localBundle = new Bundle();
    localBundle.putString("WADL.REMOTE_NOTIFY_CMD_NAME", "doDownloadAction");
    localBundle.putString("appId", paramWadlParams.a);
    localBundle.putInt("actionFrom", paramWadlParams.jdField_d_of_type_Int);
    localBundle.putParcelable("download_wadl_params", paramWadlParams);
    bkjb.a().a(paramWadlParams, localBundle);
  }
  
  public void a(String paramString)
  {
    bfrz.c("WadlProxyServiceWrap", "doQueryActionByVia via=" + paramString);
    Bundle localBundle = new Bundle();
    localBundle.putString("WADL.REMOTE_NOTIFY_CMD_NAME", "doQueryActionByVia");
    localBundle.putString("via", paramString);
    this.a.a(localBundle);
  }
  
  public void a(String paramString1, String paramString2)
  {
    bfrz.c("WadlProxyServiceWrap", "receive system receiver cmd=" + paramString1 + ",packageName=" + paramString2);
    Bundle localBundle = new Bundle();
    localBundle.putString("WADL.REMOTE_NOTIFY_CMD_NAME", paramString1);
    localBundle.putString("packageName", paramString2);
    this.a.a(localBundle);
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    bfrz.c("WadlProxyServiceWrap", "doQueryAction:" + paramArrayList.toString());
    Bundle localBundle = new Bundle();
    localBundle.putString("WADL.REMOTE_NOTIFY_CMD_NAME", "doQueryAction");
    localBundle.putStringArrayList("appIdLis", paramArrayList);
    this.a.a(localBundle);
  }
  
  public void b()
  {
    bfrz.c("WadlProxyServiceWrap", "doQueryAllTask");
    Bundle localBundle = new Bundle();
    localBundle.putString("WADL.REMOTE_NOTIFY_CMD_NAME", "doQueryAllTask");
    this.a.a(localBundle);
  }
  
  public void b(int paramInt, String paramString)
  {
    bfrz.c("WadlProxyServiceWrap", "doResumeAction from=" + paramInt + ",appId=" + paramString);
    Bundle localBundle = new Bundle();
    localBundle.putString("WADL.REMOTE_NOTIFY_CMD_NAME", "doResumeAction");
    localBundle.putString("appId", paramString);
    localBundle.putInt("actionFrom", paramInt);
    this.a.a(localBundle);
  }
  
  public void b(bkik parambkik)
  {
    this.a.b(parambkik);
  }
  
  public void b(WadlParams paramWadlParams)
  {
    bfrz.c("WadlProxyServiceWrap", "doInstallAction：" + paramWadlParams);
    Bundle localBundle = new Bundle();
    localBundle.putString("WADL.REMOTE_NOTIFY_CMD_NAME", "doInstallAction");
    localBundle.putParcelable("download_wadl_params", paramWadlParams);
    localBundle.putString("appId", paramWadlParams.a);
    localBundle.putInt("actionFrom", paramWadlParams.jdField_d_of_type_Int);
    this.a.a(localBundle);
    try
    {
      bfsk.a(paramWadlParams.j, paramWadlParams.a);
      return;
    }
    catch (Exception paramWadlParams)
    {
      bfrz.a("WadlProxyServiceWrap", "savePackageInfo", paramWadlParams);
    }
  }
  
  public void c()
  {
    bfrz.c("WadlProxyServiceWrap", "initWadlTaskManager:");
    Bundle localBundle = new Bundle();
    localBundle.putString("WADL.REMOTE_NOTIFY_CMD_NAME", "doInitWadlTaskManager");
    this.a.a(localBundle);
  }
  
  public void c(int paramInt, String paramString)
  {
    bfrz.c("WadlProxyServiceWrap", "##@deleteDownload from=" + paramInt + ",appID=" + paramString);
    Bundle localBundle = new Bundle();
    localBundle.putString("WADL.REMOTE_NOTIFY_CMD_NAME", "doDeleteAction");
    localBundle.putString("appId", paramString);
    localBundle.putInt("actionFrom", paramInt);
    this.a.a(localBundle);
  }
  
  public void d()
  {
    bkjb.a().b();
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
    //   2: new 56	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   9: ldc 209
    //   11: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: aload_2
    //   15: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: ldc 211
    //   20: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: lload_3
    //   24: invokevirtual 214	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   27: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 22	bfrz:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   33: ldc 196
    //   35: aload_2
    //   36: invokevirtual 219	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   39: ifeq +26 -> 65
    //   42: aload_1
    //   43: invokevirtual 225	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   46: astore 13
    //   48: aload 13
    //   50: ldc 115
    //   52: invokevirtual 229	android/os/Bundle:getParcelable	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   55: checkcast 106	cooperation/wadl/ipc/WadlParams
    //   58: astore 14
    //   60: aload 14
    //   62: ifnonnull +4 -> 66
    //   65: return
    //   66: iconst_0
    //   67: istore 7
    //   69: iload 7
    //   71: istore 6
    //   73: lload_3
    //   74: lconst_0
    //   75: lcmp
    //   76: ifne +215 -> 291
    //   79: iload 7
    //   81: istore 6
    //   83: aload 5
    //   85: ifnull +206 -> 291
    //   88: aload 5
    //   90: ldc 231
    //   92: ldc 233
    //   94: invokevirtual 239	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   97: astore_1
    //   98: aload 5
    //   100: ldc 241
    //   102: ldc 233
    //   104: invokevirtual 239	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   107: astore_2
    //   108: aload 5
    //   110: ldc 243
    //   112: ldc 233
    //   114: invokevirtual 239	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   117: astore 12
    //   119: aload 5
    //   121: ldc 245
    //   123: ldc 233
    //   125: invokevirtual 239	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   128: astore 11
    //   130: aload 5
    //   132: ldc 247
    //   134: ldc 233
    //   136: invokevirtual 239	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   139: astore 10
    //   141: aload 5
    //   143: ldc 249
    //   145: invokevirtual 252	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   148: astore 16
    //   150: aload 5
    //   152: ldc 254
    //   154: ldc 233
    //   156: invokevirtual 239	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   159: astore 15
    //   161: iconst_0
    //   162: istore 8
    //   164: aload 16
    //   166: invokestatic 260	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   169: istore 9
    //   171: iload 8
    //   173: istore 6
    //   175: iload 9
    //   177: ifne +10 -> 187
    //   180: aload 16
    //   182: invokestatic 266	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   185: istore 6
    //   187: aload_1
    //   188: invokestatic 260	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   191: ifne +178 -> 369
    //   194: aload 14
    //   196: aload_1
    //   197: putfield 109	cooperation/wadl/ipc/WadlParams:a	Ljava/lang/String;
    //   200: aload 12
    //   202: invokestatic 260	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   205: ifne +173 -> 378
    //   208: aload 12
    //   210: astore_1
    //   211: aload 14
    //   213: aload_1
    //   214: putfield 268	cooperation/wadl/ipc/WadlParams:b	Ljava/lang/String;
    //   217: aload 11
    //   219: invokestatic 260	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   222: ifne +165 -> 387
    //   225: aload 11
    //   227: astore_1
    //   228: aload 14
    //   230: aload_1
    //   231: putfield 165	cooperation/wadl/ipc/WadlParams:j	Ljava/lang/String;
    //   234: aload 14
    //   236: iload 6
    //   238: putfield 271	cooperation/wadl/ipc/WadlParams:f	I
    //   241: aload 10
    //   243: invokestatic 260	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   246: ifne +150 -> 396
    //   249: aload 10
    //   251: astore_1
    //   252: aload 14
    //   254: aload_1
    //   255: putfield 274	cooperation/wadl/ipc/WadlParams:k	Ljava/lang/String;
    //   258: aload_2
    //   259: invokestatic 260	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   262: ifne +143 -> 405
    //   265: aload_2
    //   266: astore_1
    //   267: aload 14
    //   269: aload_1
    //   270: putfield 276	cooperation/wadl/ipc/WadlParams:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   273: aload 14
    //   275: aload 15
    //   277: putfield 278	cooperation/wadl/ipc/WadlParams:c	Ljava/lang/String;
    //   280: aload 5
    //   282: ldc_w 280
    //   285: iconst_0
    //   286: invokevirtual 284	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   289: istore 6
    //   291: aload 14
    //   293: getfield 274	cooperation/wadl/ipc/WadlParams:k	Ljava/lang/String;
    //   296: invokestatic 260	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   299: ifeq +13 -> 312
    //   302: aload 14
    //   304: aload 14
    //   306: getfield 165	cooperation/wadl/ipc/WadlParams:j	Ljava/lang/String;
    //   309: putfield 274	cooperation/wadl/ipc/WadlParams:k	Ljava/lang/String;
    //   312: iload 6
    //   314: iconst_1
    //   315: if_icmpne +116 -> 431
    //   318: aload 14
    //   320: sipush 256
    //   323: invokevirtual 287	cooperation/wadl/ipc/WadlParams:b	(I)V
    //   326: aload 13
    //   328: ldc 115
    //   330: aload 14
    //   332: invokevirtual 119	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   335: aload_0
    //   336: getfield 27	bkit:a	Lbkil;
    //   339: aload 13
    //   341: invokevirtual 93	bkil:a	(Landroid/os/Bundle;)V
    //   344: aload 14
    //   346: getfield 165	cooperation/wadl/ipc/WadlParams:j	Ljava/lang/String;
    //   349: aload 14
    //   351: getfield 109	cooperation/wadl/ipc/WadlParams:a	Ljava/lang/String;
    //   354: invokestatic 170	bfsk:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   357: pop
    //   358: return
    //   359: astore_1
    //   360: ldc 14
    //   362: ldc 172
    //   364: aload_1
    //   365: invokestatic 175	bfrz:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   368: return
    //   369: aload 14
    //   371: getfield 109	cooperation/wadl/ipc/WadlParams:a	Ljava/lang/String;
    //   374: astore_1
    //   375: goto -181 -> 194
    //   378: aload 14
    //   380: getfield 268	cooperation/wadl/ipc/WadlParams:b	Ljava/lang/String;
    //   383: astore_1
    //   384: goto -173 -> 211
    //   387: aload 14
    //   389: getfield 165	cooperation/wadl/ipc/WadlParams:j	Ljava/lang/String;
    //   392: astore_1
    //   393: goto -165 -> 228
    //   396: aload 14
    //   398: getfield 274	cooperation/wadl/ipc/WadlParams:k	Ljava/lang/String;
    //   401: astore_1
    //   402: goto -150 -> 252
    //   405: aload 14
    //   407: getfield 276	cooperation/wadl/ipc/WadlParams:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   410: astore_1
    //   411: goto -144 -> 267
    //   414: astore_1
    //   415: ldc 14
    //   417: ldc_w 289
    //   420: aload_1
    //   421: invokestatic 175	bfrz:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   424: iload 7
    //   426: istore 6
    //   428: goto -137 -> 291
    //   431: aload 14
    //   433: sipush 256
    //   436: invokevirtual 291	cooperation/wadl/ipc/WadlParams:a	(I)V
    //   439: goto -113 -> 326
    //   442: astore 16
    //   444: iload 8
    //   446: istore 6
    //   448: goto -261 -> 187
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	451	0	this	bkit
    //   0	451	1	paramIntent	android.content.Intent
    //   0	451	2	paramString	String
    //   0	451	3	paramLong	long
    //   0	451	5	paramJSONObject	org.json.JSONObject
    //   71	376	6	i	int
    //   67	358	7	j	int
    //   162	283	8	k	int
    //   169	7	9	bool	boolean
    //   139	111	10	str1	String
    //   128	98	11	str2	String
    //   117	92	12	str3	String
    //   46	294	13	localBundle	Bundle
    //   58	374	14	localWadlParams	WadlParams
    //   159	117	15	str4	String
    //   148	33	16	str5	String
    //   442	1	16	localNumberFormatException	java.lang.NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   344	358	359	java/lang/Exception
    //   88	161	414	java/lang/Throwable
    //   164	171	414	java/lang/Throwable
    //   180	187	414	java/lang/Throwable
    //   187	194	414	java/lang/Throwable
    //   194	208	414	java/lang/Throwable
    //   211	225	414	java/lang/Throwable
    //   228	249	414	java/lang/Throwable
    //   252	265	414	java/lang/Throwable
    //   267	291	414	java/lang/Throwable
    //   369	375	414	java/lang/Throwable
    //   378	384	414	java/lang/Throwable
    //   387	393	414	java/lang/Throwable
    //   396	402	414	java/lang/Throwable
    //   405	411	414	java/lang/Throwable
    //   180	187	442	java/lang/NumberFormatException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkit
 * JD-Core Version:    0.7.0.1
 */
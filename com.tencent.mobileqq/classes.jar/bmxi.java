import android.os.Bundle;
import cooperation.wadl.ipc.WadlParams;
import java.util.ArrayList;
import java.util.HashSet;

public class bmxi
  implements bmxp
{
  public bmxf a;
  
  public bmxi()
  {
    bize.c("WadlProxyServiceWrap", "##@WadlProxyServiceWrap()");
    this.a = new bmxf();
    bmxq.a().a(this);
  }
  
  public static long a()
  {
    try
    {
      long l = bgjw.b();
      return l;
    }
    catch (Exception localException) {}
    return 0L;
  }
  
  public void a()
  {
    bize.c("WadlProxyServiceWrap", "##@launchService");
    this.a.b();
  }
  
  public void a(int paramInt, String paramString)
  {
    bize.c("WadlProxyServiceWrap", "doPauseAction from=" + paramInt + ",appId=" + paramString);
    Bundle localBundle = new Bundle();
    localBundle.putString("WADL.REMOTE_NOTIFY_CMD_NAME", "doPauseAction");
    localBundle.putString("appId", paramString);
    localBundle.putInt("actionFrom", paramInt);
    this.a.a(localBundle);
  }
  
  public void a(bmxe parambmxe)
  {
    this.a.a(parambmxe);
  }
  
  public void a(WadlParams paramWadlParams)
  {
    bize.c("WadlProxyServiceWrap", "doDownloadAction wadlParams=" + paramWadlParams);
    Bundle localBundle = new Bundle();
    localBundle.putString("WADL.REMOTE_NOTIFY_CMD_NAME", "doDownloadAction");
    localBundle.putString("appId", paramWadlParams.jdField_a_of_type_JavaLangString);
    localBundle.putInt("actionFrom", paramWadlParams.d);
    localBundle.putParcelable("download_wadl_params", paramWadlParams);
    if (paramWadlParams.jdField_a_of_type_Boolean)
    {
      this.a.a(localBundle);
      return;
    }
    bmxq.a().a(paramWadlParams, localBundle);
  }
  
  public void a(String paramString)
  {
    bize.c("WadlProxyServiceWrap", "doQueryActionByVia via=" + paramString);
    Bundle localBundle = new Bundle();
    localBundle.putString("WADL.REMOTE_NOTIFY_CMD_NAME", "doQueryActionByVia");
    localBundle.putString("via", paramString);
    this.a.a(localBundle);
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    bize.c("WadlProxyServiceWrap", "##@unpackTgpaApk appid=" + paramString1 + ",version=" + paramInt + ",cdnUrl=" + paramString2 + ",cdnMD5=" + paramString3);
    Bundle localBundle = new Bundle();
    localBundle.putString("WADL.REMOTE_NOTIFY_CMD_NAME", "unpackTgpaApk");
    localBundle.putString("appId", paramString1);
    localBundle.putInt("version", paramInt);
    localBundle.putString("url", paramString2);
    localBundle.putString("md5", paramString3);
    this.a.a(localBundle);
  }
  
  public void a(String paramString1, String paramString2)
  {
    bize.c("WadlProxyServiceWrap", "receive system receiver cmd=" + paramString1 + ",packageName=" + paramString2);
    Bundle localBundle = new Bundle();
    localBundle.putString("WADL.REMOTE_NOTIFY_CMD_NAME", paramString1);
    localBundle.putString("packageName", paramString2);
    this.a.a(localBundle);
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    bize.c("WadlProxyServiceWrap", "doQueryAction:" + paramArrayList.toString());
    Bundle localBundle = new Bundle();
    localBundle.putString("WADL.REMOTE_NOTIFY_CMD_NAME", "doQueryAction");
    localBundle.putStringArrayList("appIdLis", paramArrayList);
    this.a.a(localBundle);
  }
  
  public void b()
  {
    bize.c("WadlProxyServiceWrap", "doQueryAllTask");
    Bundle localBundle = new Bundle();
    localBundle.putString("WADL.REMOTE_NOTIFY_CMD_NAME", "doQueryAllTask");
    this.a.a(localBundle);
  }
  
  public void b(int paramInt, String paramString)
  {
    bize.c("WadlProxyServiceWrap", "doResumeAction from=" + paramInt + ",appId=" + paramString);
    Bundle localBundle = new Bundle();
    localBundle.putString("WADL.REMOTE_NOTIFY_CMD_NAME", "doResumeAction");
    localBundle.putString("appId", paramString);
    localBundle.putInt("actionFrom", paramInt);
    this.a.a(localBundle);
  }
  
  public void b(bmxe parambmxe)
  {
    this.a.b(parambmxe);
  }
  
  public void b(WadlParams paramWadlParams)
  {
    bize.c("WadlProxyServiceWrap", "doInstallAction：" + paramWadlParams);
    Bundle localBundle = new Bundle();
    localBundle.putString("WADL.REMOTE_NOTIFY_CMD_NAME", "doInstallAction");
    localBundle.putParcelable("download_wadl_params", paramWadlParams);
    localBundle.putString("appId", paramWadlParams.jdField_a_of_type_JavaLangString);
    localBundle.putInt("actionFrom", paramWadlParams.d);
    this.a.a(localBundle);
    try
    {
      bizo.a(paramWadlParams.f, paramWadlParams.jdField_a_of_type_JavaLangString);
      return;
    }
    catch (Exception paramWadlParams)
    {
      bize.a("WadlProxyServiceWrap", "savePackageInfo", paramWadlParams);
    }
  }
  
  @Deprecated
  public void c()
  {
    bize.c("WadlProxyServiceWrap", "initWadlTaskManager:");
  }
  
  public void c(int paramInt, String paramString)
  {
    bize.c("WadlProxyServiceWrap", "##@deleteDownload from=" + paramInt + ",appID=" + paramString);
    Bundle localBundle = new Bundle();
    localBundle.putString("WADL.REMOTE_NOTIFY_CMD_NAME", "doDeleteAction");
    localBundle.putString("appId", paramString);
    localBundle.putInt("actionFrom", paramInt);
    this.a.a(localBundle);
  }
  
  @Deprecated
  public void d() {}
  
  public void e()
  {
    bmxq.a().c();
    this.a.e();
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
    //   2: new 51	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   9: ldc 226
    //   11: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: aload_2
    //   15: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: ldc 228
    //   20: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: lload_3
    //   24: invokevirtual 231	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   27: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 22	bize:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   33: ldc 213
    //   35: aload_2
    //   36: invokevirtual 236	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   39: ifeq +26 -> 65
    //   42: aload_1
    //   43: invokevirtual 242	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   46: astore 15
    //   48: aload 15
    //   50: ldc 110
    //   52: invokevirtual 246	android/os/Bundle:getParcelable	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   55: checkcast 101	cooperation/wadl/ipc/WadlParams
    //   58: astore 16
    //   60: aload 16
    //   62: ifnonnull +4 -> 66
    //   65: return
    //   66: iconst_0
    //   67: istore 9
    //   69: iconst_0
    //   70: istore 10
    //   72: iconst_1
    //   73: istore 8
    //   75: iload 8
    //   77: istore 7
    //   79: iload 10
    //   81: istore 6
    //   83: lload_3
    //   84: lconst_0
    //   85: lcmp
    //   86: ifne +340 -> 426
    //   89: iload 8
    //   91: istore 7
    //   93: iload 10
    //   95: istore 6
    //   97: aload 5
    //   99: ifnull +327 -> 426
    //   102: iload 9
    //   104: istore 6
    //   106: aload 5
    //   108: ldc 248
    //   110: ldc 250
    //   112: invokevirtual 256	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   115: astore_1
    //   116: iload 9
    //   118: istore 6
    //   120: aload 5
    //   122: ldc_w 258
    //   125: ldc 250
    //   127: invokevirtual 256	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   130: astore_2
    //   131: iload 9
    //   133: istore 6
    //   135: aload 5
    //   137: ldc_w 260
    //   140: ldc 250
    //   142: invokevirtual 256	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   145: astore 14
    //   147: iload 9
    //   149: istore 6
    //   151: aload 5
    //   153: ldc_w 262
    //   156: ldc 250
    //   158: invokevirtual 256	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   161: astore 13
    //   163: iload 9
    //   165: istore 6
    //   167: aload 5
    //   169: ldc_w 264
    //   172: ldc 250
    //   174: invokevirtual 256	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   177: astore 12
    //   179: iload 9
    //   181: istore 6
    //   183: aload 5
    //   185: ldc_w 266
    //   188: invokevirtual 269	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   191: astore 18
    //   193: iload 9
    //   195: istore 6
    //   197: aload 5
    //   199: ldc_w 271
    //   202: ldc 250
    //   204: invokevirtual 256	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   207: astore 17
    //   209: iconst_0
    //   210: istore 10
    //   212: iload 9
    //   214: istore 6
    //   216: aload 18
    //   218: invokestatic 277	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   221: istore 11
    //   223: iload 10
    //   225: istore 7
    //   227: iload 11
    //   229: ifne +14 -> 243
    //   232: iload 9
    //   234: istore 6
    //   236: aload 18
    //   238: invokestatic 283	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   241: istore 7
    //   243: iload 9
    //   245: istore 6
    //   247: aload_1
    //   248: invokestatic 277	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   251: ifne +273 -> 524
    //   254: iload 9
    //   256: istore 6
    //   258: aload 16
    //   260: aload_1
    //   261: putfield 104	cooperation/wadl/ipc/WadlParams:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   264: iload 9
    //   266: istore 6
    //   268: aload 14
    //   270: invokestatic 277	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   273: ifne +264 -> 537
    //   276: aload 14
    //   278: astore_1
    //   279: iload 9
    //   281: istore 6
    //   283: aload 16
    //   285: aload_1
    //   286: putfield 285	cooperation/wadl/ipc/WadlParams:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   289: iload 9
    //   291: istore 6
    //   293: aload 13
    //   295: invokestatic 277	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   298: ifne +252 -> 550
    //   301: aload 13
    //   303: astore_1
    //   304: iload 9
    //   306: istore 6
    //   308: aload 16
    //   310: aload_1
    //   311: putfield 181	cooperation/wadl/ipc/WadlParams:f	Ljava/lang/String;
    //   314: iload 9
    //   316: istore 6
    //   318: aload 16
    //   320: iload 7
    //   322: putfield 287	cooperation/wadl/ipc/WadlParams:jdField_e_of_type_Int	I
    //   325: iload 9
    //   327: istore 6
    //   329: aload 12
    //   331: invokestatic 277	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   334: ifne +229 -> 563
    //   337: aload 12
    //   339: astore_1
    //   340: iload 9
    //   342: istore 6
    //   344: aload 16
    //   346: aload_1
    //   347: putfield 290	cooperation/wadl/ipc/WadlParams:j	Ljava/lang/String;
    //   350: iload 9
    //   352: istore 6
    //   354: aload_2
    //   355: invokestatic 277	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   358: ifne +218 -> 576
    //   361: aload_2
    //   362: astore_1
    //   363: iload 9
    //   365: istore 6
    //   367: aload 16
    //   369: aload_1
    //   370: putfield 292	cooperation/wadl/ipc/WadlParams:c	Ljava/lang/String;
    //   373: iload 9
    //   375: istore 6
    //   377: aload 16
    //   379: aload 17
    //   381: putfield 294	cooperation/wadl/ipc/WadlParams:b	Ljava/lang/String;
    //   384: iload 9
    //   386: istore 6
    //   388: aload 5
    //   390: ldc_w 296
    //   393: iconst_0
    //   394: invokevirtual 300	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   397: istore 7
    //   399: iload 7
    //   401: istore 6
    //   403: aload 5
    //   405: ldc_w 302
    //   408: iconst_1
    //   409: invokevirtual 300	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   412: istore 9
    //   414: iload 9
    //   416: istore 8
    //   418: iload 7
    //   420: istore 6
    //   422: iload 8
    //   424: istore 7
    //   426: aload 16
    //   428: getfield 290	cooperation/wadl/ipc/WadlParams:j	Ljava/lang/String;
    //   431: invokestatic 277	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   434: ifeq +13 -> 447
    //   437: aload 16
    //   439: aload 16
    //   441: getfield 181	cooperation/wadl/ipc/WadlParams:f	Ljava/lang/String;
    //   444: putfield 290	cooperation/wadl/ipc/WadlParams:j	Ljava/lang/String;
    //   447: iload 6
    //   449: iconst_1
    //   450: if_icmpne +156 -> 606
    //   453: aload 16
    //   455: sipush 256
    //   458: invokevirtual 305	cooperation/wadl/ipc/WadlParams:b	(I)V
    //   461: iload 7
    //   463: istore 6
    //   465: iload 7
    //   467: iconst_1
    //   468: if_icmpge +6 -> 474
    //   471: iconst_1
    //   472: istore 6
    //   474: aload 16
    //   476: iload 6
    //   478: putfield 308	cooperation/wadl/ipc/WadlParams:i	I
    //   481: aload 15
    //   483: ldc 110
    //   485: aload 16
    //   487: invokevirtual 114	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   490: aload_0
    //   491: getfield 27	bmxi:a	Lbmxf;
    //   494: aload 15
    //   496: invokevirtual 88	bmxf:a	(Landroid/os/Bundle;)V
    //   499: aload 16
    //   501: getfield 181	cooperation/wadl/ipc/WadlParams:f	Ljava/lang/String;
    //   504: aload 16
    //   506: getfield 104	cooperation/wadl/ipc/WadlParams:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   509: invokestatic 186	bizo:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   512: pop
    //   513: return
    //   514: astore_1
    //   515: ldc 14
    //   517: ldc 188
    //   519: aload_1
    //   520: invokestatic 191	bize:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   523: return
    //   524: iload 9
    //   526: istore 6
    //   528: aload 16
    //   530: getfield 104	cooperation/wadl/ipc/WadlParams:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   533: astore_1
    //   534: goto -280 -> 254
    //   537: iload 9
    //   539: istore 6
    //   541: aload 16
    //   543: getfield 285	cooperation/wadl/ipc/WadlParams:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   546: astore_1
    //   547: goto -268 -> 279
    //   550: iload 9
    //   552: istore 6
    //   554: aload 16
    //   556: getfield 181	cooperation/wadl/ipc/WadlParams:f	Ljava/lang/String;
    //   559: astore_1
    //   560: goto -256 -> 304
    //   563: iload 9
    //   565: istore 6
    //   567: aload 16
    //   569: getfield 290	cooperation/wadl/ipc/WadlParams:j	Ljava/lang/String;
    //   572: astore_1
    //   573: goto -233 -> 340
    //   576: iload 9
    //   578: istore 6
    //   580: aload 16
    //   582: getfield 292	cooperation/wadl/ipc/WadlParams:c	Ljava/lang/String;
    //   585: astore_1
    //   586: goto -223 -> 363
    //   589: astore_1
    //   590: ldc 14
    //   592: ldc_w 310
    //   595: aload_1
    //   596: invokestatic 191	bize:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   599: iload 8
    //   601: istore 7
    //   603: goto -177 -> 426
    //   606: aload 16
    //   608: sipush 256
    //   611: invokevirtual 312	cooperation/wadl/ipc/WadlParams:a	(I)V
    //   614: goto -133 -> 481
    //   617: astore 18
    //   619: iload 10
    //   621: istore 7
    //   623: goto -380 -> 243
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	626	0	this	bmxi
    //   0	626	1	paramIntent	android.content.Intent
    //   0	626	2	paramString	String
    //   0	626	3	paramLong	long
    //   0	626	5	paramJSONObject	org.json.JSONObject
    //   81	498	6	i	int
    //   77	545	7	j	int
    //   73	527	8	k	int
    //   67	510	9	m	int
    //   70	550	10	n	int
    //   221	7	11	bool	boolean
    //   177	161	12	str1	String
    //   161	141	13	str2	String
    //   145	132	14	str3	String
    //   46	449	15	localBundle	Bundle
    //   58	549	16	localWadlParams	WadlParams
    //   207	173	17	str4	String
    //   191	46	18	str5	String
    //   617	1	18	localNumberFormatException	java.lang.NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   499	513	514	java/lang/Exception
    //   106	116	589	java/lang/Throwable
    //   120	131	589	java/lang/Throwable
    //   135	147	589	java/lang/Throwable
    //   151	163	589	java/lang/Throwable
    //   167	179	589	java/lang/Throwable
    //   183	193	589	java/lang/Throwable
    //   197	209	589	java/lang/Throwable
    //   216	223	589	java/lang/Throwable
    //   236	243	589	java/lang/Throwable
    //   247	254	589	java/lang/Throwable
    //   258	264	589	java/lang/Throwable
    //   268	276	589	java/lang/Throwable
    //   283	289	589	java/lang/Throwable
    //   293	301	589	java/lang/Throwable
    //   308	314	589	java/lang/Throwable
    //   318	325	589	java/lang/Throwable
    //   329	337	589	java/lang/Throwable
    //   344	350	589	java/lang/Throwable
    //   354	361	589	java/lang/Throwable
    //   367	373	589	java/lang/Throwable
    //   377	384	589	java/lang/Throwable
    //   388	399	589	java/lang/Throwable
    //   403	414	589	java/lang/Throwable
    //   528	534	589	java/lang/Throwable
    //   541	547	589	java/lang/Throwable
    //   554	560	589	java/lang/Throwable
    //   567	573	589	java/lang/Throwable
    //   580	586	589	java/lang/Throwable
    //   236	243	617	java/lang/NumberFormatException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmxi
 * JD-Core Version:    0.7.0.1
 */
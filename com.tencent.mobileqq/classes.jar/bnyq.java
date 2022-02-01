import android.os.Bundle;
import cooperation.wadl.ipc.WadlParams;
import java.util.ArrayList;
import java.util.HashSet;

public class bnyq
  implements bnyx
{
  private static bnyn a;
  public final int a;
  public final int b = 1;
  public final int c = 1;
  
  public bnyq()
  {
    this.jdField_a_of_type_Int = 0;
    bkad.c("WadlProxyServiceWrap", "##@WadlProxyServiceWrap()");
    if (jdField_a_of_type_Bnyn == null) {
      jdField_a_of_type_Bnyn = new bnyn();
    }
    bnyy.a().a(this);
  }
  
  public static long a()
  {
    try
    {
      long l = bhjx.b();
      return l;
    }
    catch (Exception localException) {}
    return 0L;
  }
  
  public void a()
  {
    if (jdField_a_of_type_Bnyn != null) {
      jdField_a_of_type_Bnyn.b();
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    bkad.c("WadlProxyServiceWrap", "doPauseAction from=" + paramInt + ",appId=" + paramString);
    if (jdField_a_of_type_Bnyn != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("WADL.REMOTE_NOTIFY_CMD_NAME", "doPauseAction");
      localBundle.putString("appId", paramString);
      localBundle.putInt("actionFrom", paramInt);
      jdField_a_of_type_Bnyn.a(localBundle);
    }
  }
  
  public void a(bnym parambnym)
  {
    if (jdField_a_of_type_Bnyn != null) {
      jdField_a_of_type_Bnyn.a(parambnym);
    }
  }
  
  public void a(WadlParams paramWadlParams)
  {
    bkad.c("WadlProxyServiceWrap", "doDownloadAction wadlParams=" + paramWadlParams);
    Bundle localBundle;
    if (jdField_a_of_type_Bnyn != null)
    {
      localBundle = new Bundle();
      localBundle.putString("WADL.REMOTE_NOTIFY_CMD_NAME", "doDownloadAction");
      localBundle.putString("appId", paramWadlParams.jdField_a_of_type_JavaLangString);
      localBundle.putInt("actionFrom", paramWadlParams.d);
      localBundle.putParcelable("download_wadl_params", paramWadlParams);
      if (paramWadlParams.jdField_a_of_type_Boolean) {
        jdField_a_of_type_Bnyn.a(localBundle);
      }
    }
    else
    {
      return;
    }
    bnyy.a().a(paramWadlParams, localBundle);
  }
  
  public void a(String paramString)
  {
    bkad.c("WadlProxyServiceWrap", "doQueryActionByVia via=" + paramString);
    if (jdField_a_of_type_Bnyn != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("WADL.REMOTE_NOTIFY_CMD_NAME", "doQueryActionByVia");
      localBundle.putString("via", paramString);
      jdField_a_of_type_Bnyn.a(localBundle);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    bkad.c("WadlProxyServiceWrap", "receive system receiver cmd=" + paramString1 + ",packageName=" + paramString2);
    Bundle localBundle = new Bundle();
    localBundle.putString("WADL.REMOTE_NOTIFY_CMD_NAME", paramString1);
    localBundle.putString("packageName", paramString2);
    if (jdField_a_of_type_Bnyn != null) {
      jdField_a_of_type_Bnyn.a(localBundle);
    }
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    bkad.c("WadlProxyServiceWrap", "doQueryAction:" + paramArrayList.toString());
    if (jdField_a_of_type_Bnyn != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("WADL.REMOTE_NOTIFY_CMD_NAME", "doQueryAction");
      localBundle.putStringArrayList("appIdLis", paramArrayList);
      jdField_a_of_type_Bnyn.a(localBundle);
    }
  }
  
  public void b()
  {
    bkad.c("WadlProxyServiceWrap", "doQueryAllTask");
    if (jdField_a_of_type_Bnyn != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("WADL.REMOTE_NOTIFY_CMD_NAME", "doQueryAllTask");
      jdField_a_of_type_Bnyn.a(localBundle);
    }
  }
  
  public void b(int paramInt, String paramString)
  {
    bkad.c("WadlProxyServiceWrap", "doResumeAction from=" + paramInt + ",appId=" + paramString);
    if (jdField_a_of_type_Bnyn != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("WADL.REMOTE_NOTIFY_CMD_NAME", "doResumeAction");
      localBundle.putString("appId", paramString);
      localBundle.putInt("actionFrom", paramInt);
      jdField_a_of_type_Bnyn.a(localBundle);
    }
  }
  
  public void b(bnym parambnym)
  {
    if (jdField_a_of_type_Bnyn != null) {
      jdField_a_of_type_Bnyn.b(parambnym);
    }
  }
  
  public void b(WadlParams paramWadlParams)
  {
    bkad.c("WadlProxyServiceWrap", "doInstallAction：" + paramWadlParams);
    if (jdField_a_of_type_Bnyn != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("WADL.REMOTE_NOTIFY_CMD_NAME", "doInstallAction");
      localBundle.putParcelable("download_wadl_params", paramWadlParams);
      localBundle.putString("appId", paramWadlParams.jdField_a_of_type_JavaLangString);
      localBundle.putInt("actionFrom", paramWadlParams.d);
      jdField_a_of_type_Bnyn.a(localBundle);
    }
  }
  
  @Deprecated
  public void c()
  {
    bkad.c("WadlProxyServiceWrap", "initWadlTaskManager:");
  }
  
  public void c(int paramInt, String paramString)
  {
    bkad.c("WadlProxyServiceWrap", "##@deleteDownload from=" + paramInt + ",appID=" + paramString);
    if (jdField_a_of_type_Bnyn != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("WADL.REMOTE_NOTIFY_CMD_NAME", "doDeleteAction");
      localBundle.putString("appId", paramString);
      localBundle.putInt("actionFrom", paramInt);
      jdField_a_of_type_Bnyn.a(localBundle);
    }
  }
  
  public void d()
  {
    bnyy.a().b();
    if (jdField_a_of_type_Bnyn != null)
    {
      jdField_a_of_type_Bnyn.e();
      jdField_a_of_type_Bnyn = null;
    }
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
    //   0: ldc 23
    //   2: new 56	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   9: ldc 199
    //   11: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: aload_2
    //   15: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: ldc 201
    //   20: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: lload_3
    //   24: invokevirtual 204	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   27: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 30	bkad:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   33: ldc 186
    //   35: aload_2
    //   36: invokevirtual 209	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   39: ifeq +26 -> 65
    //   42: aload_1
    //   43: invokevirtual 215	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   46: astore 16
    //   48: aload 16
    //   50: ldc 114
    //   52: invokevirtual 219	android/os/Bundle:getParcelable	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   55: checkcast 106	cooperation/wadl/ipc/WadlParams
    //   58: astore 17
    //   60: aload 17
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
    //   86: ifne +379 -> 465
    //   89: iload 8
    //   91: istore 7
    //   93: iload 10
    //   95: istore 6
    //   97: aload 5
    //   99: ifnull +366 -> 465
    //   102: iload 9
    //   104: istore 6
    //   106: aload 5
    //   108: ldc 221
    //   110: ldc 223
    //   112: invokevirtual 229	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   115: astore_1
    //   116: iload 9
    //   118: istore 6
    //   120: aload 5
    //   122: ldc 231
    //   124: ldc 223
    //   126: invokevirtual 229	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   129: astore_2
    //   130: iload 9
    //   132: istore 6
    //   134: aload 5
    //   136: ldc 233
    //   138: ldc 223
    //   140: invokevirtual 229	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   143: astore 15
    //   145: iload 9
    //   147: istore 6
    //   149: aload 5
    //   151: ldc 235
    //   153: ldc 223
    //   155: invokevirtual 229	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   158: astore 14
    //   160: iload 9
    //   162: istore 6
    //   164: aload 5
    //   166: ldc 237
    //   168: ldc 223
    //   170: invokevirtual 229	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   173: astore 13
    //   175: iload 9
    //   177: istore 6
    //   179: aload 5
    //   181: ldc 239
    //   183: ldc 223
    //   185: invokevirtual 229	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   188: astore 12
    //   190: iload 9
    //   192: istore 6
    //   194: aload 5
    //   196: ldc 241
    //   198: invokevirtual 244	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   201: astore 19
    //   203: iload 9
    //   205: istore 6
    //   207: aload 5
    //   209: ldc 246
    //   211: ldc 223
    //   213: invokevirtual 229	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   216: astore 18
    //   218: iconst_0
    //   219: istore 10
    //   221: iload 9
    //   223: istore 6
    //   225: aload 19
    //   227: invokestatic 252	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   230: istore 11
    //   232: iload 10
    //   234: istore 7
    //   236: iload 11
    //   238: ifne +14 -> 252
    //   241: iload 9
    //   243: istore 6
    //   245: aload 19
    //   247: invokestatic 258	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   250: istore 7
    //   252: iload 9
    //   254: istore 6
    //   256: aload_1
    //   257: invokestatic 252	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   260: ifne +300 -> 560
    //   263: iload 9
    //   265: istore 6
    //   267: aload 17
    //   269: aload_1
    //   270: putfield 109	cooperation/wadl/ipc/WadlParams:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   273: iload 9
    //   275: istore 6
    //   277: aload 15
    //   279: invokestatic 252	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   282: ifne +291 -> 573
    //   285: aload 15
    //   287: astore_1
    //   288: iload 9
    //   290: istore 6
    //   292: aload 17
    //   294: aload_1
    //   295: putfield 260	cooperation/wadl/ipc/WadlParams:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   298: iload 9
    //   300: istore 6
    //   302: aload 14
    //   304: invokestatic 252	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   307: ifne +279 -> 586
    //   310: aload 14
    //   312: astore_1
    //   313: iload 9
    //   315: istore 6
    //   317: aload 17
    //   319: aload_1
    //   320: putfield 263	cooperation/wadl/ipc/WadlParams:f	Ljava/lang/String;
    //   323: iload 7
    //   325: ifle +274 -> 599
    //   328: iload 9
    //   330: istore 6
    //   332: aload 17
    //   334: iload 7
    //   336: putfield 265	cooperation/wadl/ipc/WadlParams:jdField_e_of_type_Int	I
    //   339: iload 9
    //   341: istore 6
    //   343: aload 13
    //   345: invokestatic 252	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   348: ifne +265 -> 613
    //   351: aload 13
    //   353: astore_1
    //   354: iload 9
    //   356: istore 6
    //   358: aload 17
    //   360: aload_1
    //   361: putfield 268	cooperation/wadl/ipc/WadlParams:j	Ljava/lang/String;
    //   364: iload 9
    //   366: istore 6
    //   368: aload 12
    //   370: invokestatic 252	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   373: ifne +253 -> 626
    //   376: aload 12
    //   378: astore_1
    //   379: iload 9
    //   381: istore 6
    //   383: aload 17
    //   385: aload_1
    //   386: putfield 271	cooperation/wadl/ipc/WadlParams:k	Ljava/lang/String;
    //   389: iload 9
    //   391: istore 6
    //   393: aload_2
    //   394: invokestatic 252	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   397: ifne +242 -> 639
    //   400: aload_2
    //   401: astore_1
    //   402: iload 9
    //   404: istore 6
    //   406: aload 17
    //   408: aload_1
    //   409: putfield 273	cooperation/wadl/ipc/WadlParams:c	Ljava/lang/String;
    //   412: iload 9
    //   414: istore 6
    //   416: aload 17
    //   418: aload 18
    //   420: putfield 275	cooperation/wadl/ipc/WadlParams:b	Ljava/lang/String;
    //   423: iload 9
    //   425: istore 6
    //   427: aload 5
    //   429: ldc_w 277
    //   432: iconst_0
    //   433: invokevirtual 281	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   436: istore 7
    //   438: iload 7
    //   440: istore 6
    //   442: aload 5
    //   444: ldc_w 283
    //   447: iconst_1
    //   448: invokevirtual 281	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   451: istore 9
    //   453: iload 9
    //   455: istore 8
    //   457: iload 7
    //   459: istore 6
    //   461: iload 8
    //   463: istore 7
    //   465: aload 17
    //   467: getfield 268	cooperation/wadl/ipc/WadlParams:j	Ljava/lang/String;
    //   470: invokestatic 252	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   473: ifeq +13 -> 486
    //   476: aload 17
    //   478: aload 17
    //   480: getfield 263	cooperation/wadl/ipc/WadlParams:f	Ljava/lang/String;
    //   483: putfield 268	cooperation/wadl/ipc/WadlParams:j	Ljava/lang/String;
    //   486: iload 6
    //   488: iconst_1
    //   489: if_icmpne +180 -> 669
    //   492: aload 17
    //   494: sipush 256
    //   497: invokevirtual 286	cooperation/wadl/ipc/WadlParams:b	(I)V
    //   500: iload 7
    //   502: istore 6
    //   504: iload 7
    //   506: iconst_1
    //   507: if_icmpge +6 -> 513
    //   510: iconst_1
    //   511: istore 6
    //   513: aload 17
    //   515: iload 6
    //   517: putfield 289	cooperation/wadl/ipc/WadlParams:i	I
    //   520: aload 16
    //   522: ldc 114
    //   524: aload 17
    //   526: invokevirtual 118	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   529: getstatic 32	bnyq:jdField_a_of_type_Bnyn	Lbnyn;
    //   532: ifnull +11 -> 543
    //   535: getstatic 32	bnyq:jdField_a_of_type_Bnyn	Lbnyn;
    //   538: aload 16
    //   540: invokevirtual 93	bnyn:a	(Landroid/os/Bundle;)V
    //   543: ldc_w 291
    //   546: aload 17
    //   548: getfield 263	cooperation/wadl/ipc/WadlParams:f	Ljava/lang/String;
    //   551: aload 17
    //   553: getfield 109	cooperation/wadl/ipc/WadlParams:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   556: invokestatic 296	acij:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   559: return
    //   560: iload 9
    //   562: istore 6
    //   564: aload 17
    //   566: getfield 109	cooperation/wadl/ipc/WadlParams:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   569: astore_1
    //   570: goto -307 -> 263
    //   573: iload 9
    //   575: istore 6
    //   577: aload 17
    //   579: getfield 260	cooperation/wadl/ipc/WadlParams:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   582: astore_1
    //   583: goto -295 -> 288
    //   586: iload 9
    //   588: istore 6
    //   590: aload 17
    //   592: getfield 263	cooperation/wadl/ipc/WadlParams:f	Ljava/lang/String;
    //   595: astore_1
    //   596: goto -283 -> 313
    //   599: iload 9
    //   601: istore 6
    //   603: aload 17
    //   605: getfield 265	cooperation/wadl/ipc/WadlParams:jdField_e_of_type_Int	I
    //   608: istore 7
    //   610: goto -282 -> 328
    //   613: iload 9
    //   615: istore 6
    //   617: aload 17
    //   619: getfield 268	cooperation/wadl/ipc/WadlParams:j	Ljava/lang/String;
    //   622: astore_1
    //   623: goto -269 -> 354
    //   626: iload 9
    //   628: istore 6
    //   630: aload 17
    //   632: getfield 271	cooperation/wadl/ipc/WadlParams:k	Ljava/lang/String;
    //   635: astore_1
    //   636: goto -257 -> 379
    //   639: iload 9
    //   641: istore 6
    //   643: aload 17
    //   645: getfield 273	cooperation/wadl/ipc/WadlParams:c	Ljava/lang/String;
    //   648: astore_1
    //   649: goto -247 -> 402
    //   652: astore_1
    //   653: ldc 23
    //   655: ldc_w 298
    //   658: aload_1
    //   659: invokestatic 301	bkad:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   662: iload 8
    //   664: istore 7
    //   666: goto -201 -> 465
    //   669: aload 17
    //   671: sipush 256
    //   674: invokevirtual 303	cooperation/wadl/ipc/WadlParams:a	(I)V
    //   677: goto -157 -> 520
    //   680: astore 19
    //   682: iload 10
    //   684: istore 7
    //   686: goto -434 -> 252
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	689	0	this	bnyq
    //   0	689	1	paramIntent	android.content.Intent
    //   0	689	2	paramString	String
    //   0	689	3	paramLong	long
    //   0	689	5	paramJSONObject	org.json.JSONObject
    //   81	561	6	i	int
    //   77	608	7	j	int
    //   73	590	8	k	int
    //   67	573	9	m	int
    //   70	613	10	n	int
    //   230	7	11	bool	boolean
    //   188	189	12	str1	String
    //   173	179	13	str2	String
    //   158	153	14	str3	String
    //   143	143	15	str4	String
    //   46	493	16	localBundle	Bundle
    //   58	612	17	localWadlParams	WadlParams
    //   216	203	18	str5	String
    //   201	45	19	str6	String
    //   680	1	19	localNumberFormatException	java.lang.NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   106	116	652	java/lang/Throwable
    //   120	130	652	java/lang/Throwable
    //   134	145	652	java/lang/Throwable
    //   149	160	652	java/lang/Throwable
    //   164	175	652	java/lang/Throwable
    //   179	190	652	java/lang/Throwable
    //   194	203	652	java/lang/Throwable
    //   207	218	652	java/lang/Throwable
    //   225	232	652	java/lang/Throwable
    //   245	252	652	java/lang/Throwable
    //   256	263	652	java/lang/Throwable
    //   267	273	652	java/lang/Throwable
    //   277	285	652	java/lang/Throwable
    //   292	298	652	java/lang/Throwable
    //   302	310	652	java/lang/Throwable
    //   317	323	652	java/lang/Throwable
    //   332	339	652	java/lang/Throwable
    //   343	351	652	java/lang/Throwable
    //   358	364	652	java/lang/Throwable
    //   368	376	652	java/lang/Throwable
    //   383	389	652	java/lang/Throwable
    //   393	400	652	java/lang/Throwable
    //   406	412	652	java/lang/Throwable
    //   416	423	652	java/lang/Throwable
    //   427	438	652	java/lang/Throwable
    //   442	453	652	java/lang/Throwable
    //   564	570	652	java/lang/Throwable
    //   577	583	652	java/lang/Throwable
    //   590	596	652	java/lang/Throwable
    //   603	610	652	java/lang/Throwable
    //   617	623	652	java/lang/Throwable
    //   630	636	652	java/lang/Throwable
    //   643	649	652	java/lang/Throwable
    //   245	252	680	java/lang/NumberFormatException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnyq
 * JD-Core Version:    0.7.0.1
 */
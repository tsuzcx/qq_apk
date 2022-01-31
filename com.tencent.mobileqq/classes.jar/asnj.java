import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import cooperation.wadl.ipc.WadlParams;

public class asnj
  extends WebViewPlugin
{
  public asnj()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterInterruptPlugin", 2, "GameCenterInterruptPlugin init");
    }
    this.mPluginNameSpace = "gameCenter";
  }
  
  private WadlParams a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    WadlParams localWadlParams = new WadlParams();
    localWadlParams.jdField_d_of_type_Int = 6;
    localWadlParams.b(1);
    localWadlParams.b(2);
    localWadlParams.b(4);
    localWadlParams.jdField_b_of_type_JavaLangString = paramString1;
    localWadlParams.a = paramString2;
    localWadlParams.f = 0;
    localWadlParams.j = paramString3;
    localWadlParams.k = paramString4;
    localWadlParams.m = "GameCenterIntterup";
    localWadlParams.jdField_b_of_type_Int = 2;
    localWadlParams.n = "interrupt";
    localWadlParams.q = "biz_src_zf_games";
    return localWadlParams;
  }
  
  /* Error */
  public boolean handleSchemaRequest(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_1
    //   3: ifnull +475 -> 478
    //   6: aload_1
    //   7: ldc 79
    //   9: invokevirtual 85	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   12: ifne +6 -> 18
    //   15: goto +463 -> 478
    //   18: invokestatic 90	bfsc:a	()Lbfsc;
    //   21: ldc 92
    //   23: invokevirtual 95	bfsc:a	(Ljava/lang/String;)Ljava/lang/Object;
    //   26: checkcast 97	bfsb
    //   29: astore 5
    //   31: aload 5
    //   33: ifnull +447 -> 480
    //   36: aload 5
    //   38: aload_1
    //   39: invokevirtual 100	bfsb:a	(Ljava/lang/String;)Lbfrx;
    //   42: astore_2
    //   43: invokestatic 14	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   46: ifeq +37 -> 83
    //   49: ldc 16
    //   51: iconst_1
    //   52: new 102	java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   59: ldc 105
    //   61: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: aload_1
    //   65: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: ldc 111
    //   70: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: aload_2
    //   74: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   77: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokestatic 22	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   83: aload_2
    //   84: ifnull +16 -> 100
    //   87: invokestatic 124	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   90: aload_2
    //   91: getfield 129	bfrx:c	Ljava/lang/String;
    //   94: invokestatic 134	bdiv:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   97: ifeq +46 -> 143
    //   100: invokestatic 139	bfsp:a	()Lbfsp;
    //   103: astore 4
    //   105: new 141	java/net/URL
    //   108: dup
    //   109: aload_1
    //   110: invokespecial 144	java/net/URL:<init>	(Ljava/lang/String;)V
    //   113: invokevirtual 147	java/net/URL:getHost	()Ljava/lang/String;
    //   116: astore_2
    //   117: aload 4
    //   119: aload_1
    //   120: putfield 150	bfsp:g	Ljava/lang/String;
    //   123: aload 4
    //   125: aload_2
    //   126: putfield 153	bfsp:h	Ljava/lang/String;
    //   129: invokestatic 158	bkjb:a	()Lbkjb;
    //   132: ldc 160
    //   134: ldc 162
    //   136: aload 4
    //   138: invokevirtual 165	bkjb:a	(Ljava/lang/String;Ljava/lang/String;Lbfsp;)V
    //   141: iconst_0
    //   142: ireturn
    //   143: ldc 16
    //   145: iconst_1
    //   146: new 102	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   153: ldc 167
    //   155: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: aload_2
    //   159: getfield 169	bfrx:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   162: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: ldc 171
    //   167: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: aload_2
    //   171: getfield 129	bfrx:c	Ljava/lang/String;
    //   174: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: ldc 173
    //   179: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: aload_2
    //   183: getfield 174	bfrx:a	Ljava/lang/String;
    //   186: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: ldc 176
    //   191: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: aload_2
    //   195: getfield 177	bfrx:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   198: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: ldc 179
    //   203: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: aload_1
    //   207: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: invokestatic 182	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   216: aload_0
    //   217: getfield 186	asnj:mRuntime	Lbegz;
    //   220: ifnull +265 -> 485
    //   223: aload_0
    //   224: getfield 186	asnj:mRuntime	Lbegz;
    //   227: invokevirtual 191	begz:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   230: astore_3
    //   231: aload_3
    //   232: ifnull +238 -> 470
    //   235: ldc 16
    //   237: iconst_1
    //   238: new 102	java/lang/StringBuilder
    //   241: dup
    //   242: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   245: ldc 193
    //   247: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: aload_3
    //   251: invokevirtual 198	com/tencent/biz/pubaccount/CustomWebView:getOriginalUrl	()Ljava/lang/String;
    //   254: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: ldc 179
    //   259: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: aload_3
    //   263: invokevirtual 201	com/tencent/biz/pubaccount/CustomWebView:getUrl	()Ljava/lang/String;
    //   266: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   272: invokestatic 182	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   275: aload_0
    //   276: aload_2
    //   277: getfield 204	bfrx:e	Ljava/lang/String;
    //   280: aload_2
    //   281: getfield 174	bfrx:a	Ljava/lang/String;
    //   284: aload_2
    //   285: getfield 129	bfrx:c	Ljava/lang/String;
    //   288: aload_2
    //   289: getfield 177	bfrx:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   292: invokespecial 206	asnj:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcooperation/wadl/ipc/WadlParams;
    //   295: astore 6
    //   297: aload 6
    //   299: aload_2
    //   300: getfield 169	bfrx:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   303: putfield 207	cooperation/wadl/ipc/WadlParams:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   306: aload_3
    //   307: invokevirtual 201	com/tencent/biz/pubaccount/CustomWebView:getUrl	()Ljava/lang/String;
    //   310: astore 4
    //   312: aload 4
    //   314: astore_1
    //   315: aload 4
    //   317: invokestatic 212	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   320: ifeq +8 -> 328
    //   323: aload_3
    //   324: invokevirtual 198	com/tencent/biz/pubaccount/CustomWebView:getOriginalUrl	()Ljava/lang/String;
    //   327: astore_1
    //   328: aload 6
    //   330: aload_1
    //   331: putfield 215	cooperation/wadl/ipc/WadlParams:p	Ljava/lang/String;
    //   334: aload 6
    //   336: getfield 215	cooperation/wadl/ipc/WadlParams:p	Ljava/lang/String;
    //   339: invokestatic 212	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   342: ifeq +10 -> 352
    //   345: aload 6
    //   347: ldc 217
    //   349: putfield 215	cooperation/wadl/ipc/WadlParams:p	Ljava/lang/String;
    //   352: invokestatic 221	bkis:a	()V
    //   355: invokestatic 224	bkis:a	()Lbkit;
    //   358: aload 6
    //   360: invokevirtual 229	bkit:a	(Lcooperation/wadl/ipc/WadlParams;)V
    //   363: aload 5
    //   365: ifnull +70 -> 435
    //   368: aload 5
    //   370: getfield 230	bfsb:c	Ljava/lang/String;
    //   373: astore_1
    //   374: aload_1
    //   375: astore 4
    //   377: aload_1
    //   378: invokestatic 212	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   381: ifeq +7 -> 388
    //   384: ldc 232
    //   386: astore 4
    //   388: aload_3
    //   389: aload 4
    //   391: invokevirtual 235	com/tencent/biz/pubaccount/CustomWebView:loadUrl	(Ljava/lang/String;)V
    //   394: aconst_null
    //   395: ldc 237
    //   397: ldc 239
    //   399: aload_2
    //   400: getfield 174	bfrx:a	Ljava/lang/String;
    //   403: ldc 241
    //   405: ldc 243
    //   407: ldc 245
    //   409: invokestatic 250	aahi:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   412: invokestatic 139	bfsp:a	()Lbfsp;
    //   415: astore_1
    //   416: aload_1
    //   417: aload 6
    //   419: invokevirtual 251	bfsp:a	(Lcooperation/wadl/ipc/WadlParams;)V
    //   422: invokestatic 158	bkjb:a	()Lbkjb;
    //   425: ldc 239
    //   427: ldc 162
    //   429: aload_1
    //   430: invokevirtual 165	bkjb:a	(Ljava/lang/String;Ljava/lang/String;Lbfsp;)V
    //   433: iconst_1
    //   434: ireturn
    //   435: ldc 232
    //   437: astore_1
    //   438: goto -64 -> 374
    //   441: astore_1
    //   442: ldc 16
    //   444: iconst_1
    //   445: new 102	java/lang/StringBuilder
    //   448: dup
    //   449: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   452: ldc 253
    //   454: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: aload_1
    //   458: invokevirtual 254	java/lang/Exception:toString	()Ljava/lang/String;
    //   461: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   467: invokestatic 256	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   470: iconst_0
    //   471: ireturn
    //   472: astore_2
    //   473: aload_3
    //   474: astore_2
    //   475: goto -358 -> 117
    //   478: iconst_0
    //   479: ireturn
    //   480: aconst_null
    //   481: astore_2
    //   482: goto -439 -> 43
    //   485: aconst_null
    //   486: astore_3
    //   487: goto -256 -> 231
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	490	0	this	asnj
    //   0	490	1	paramString1	String
    //   0	490	2	paramString2	String
    //   1	486	3	localCustomWebView	com.tencent.biz.pubaccount.CustomWebView
    //   103	287	4	localObject	java.lang.Object
    //   29	340	5	localbfsb	bfsb
    //   295	123	6	localWadlParams	WadlParams
    // Exception table:
    //   from	to	target	type
    //   6	15	441	java/lang/Exception
    //   18	31	441	java/lang/Exception
    //   36	43	441	java/lang/Exception
    //   43	83	441	java/lang/Exception
    //   87	100	441	java/lang/Exception
    //   100	105	441	java/lang/Exception
    //   105	117	441	java/lang/Exception
    //   117	141	441	java/lang/Exception
    //   143	231	441	java/lang/Exception
    //   235	312	441	java/lang/Exception
    //   315	328	441	java/lang/Exception
    //   328	352	441	java/lang/Exception
    //   352	363	441	java/lang/Exception
    //   368	374	441	java/lang/Exception
    //   377	384	441	java/lang/Exception
    //   388	433	441	java/lang/Exception
    //   105	117	472	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asnj
 * JD-Core Version:    0.7.0.1
 */
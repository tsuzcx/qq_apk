import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.dynamic.host.PluginManagerUpdater;
import java.io.File;
import java.util.concurrent.Future;

public class asum
  implements PluginManagerUpdater
{
  private Context jdField_a_of_type_AndroidContentContext;
  private final SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("IVShadowAssetsPmUpdater", 0);
  private File jdField_a_of_type_JavaIoFile;
  private String jdField_a_of_type_JavaLangString = "";
  private String b;
  private String c;
  private String d;
  
  public asum(Context paramContext, String paramString1, String paramString2)
  {
    this.d = paramString2;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.c = paramString1;
    paramContext = new File(paramContext.getFilesDir(), "IVShadowCdnPmUpdater/assets");
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    if ("Now".equals(paramString1))
    {
      this.jdField_a_of_type_JavaLangString = "NowPluginManager.apk";
      this.b = "shadow/NowPluginManager.apk";
    }
    this.jdField_a_of_type_JavaIoFile = new File(paramContext, this.jdField_a_of_type_JavaLangString);
  }
  
  /* Error */
  private boolean a(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 7
    //   6: iconst_1
    //   7: istore 5
    //   9: aload_1
    //   10: invokevirtual 89	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   13: aload_2
    //   14: invokevirtual 95	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   17: astore_1
    //   18: new 97	java/io/BufferedInputStream
    //   21: dup
    //   22: aload_1
    //   23: invokespecial 100	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   26: astore 6
    //   28: new 47	java/io/File
    //   31: dup
    //   32: aload_3
    //   33: invokespecial 103	java/io/File:<init>	(Ljava/lang/String;)V
    //   36: astore_2
    //   37: aload_2
    //   38: invokevirtual 62	java/io/File:exists	()Z
    //   41: ifeq +8 -> 49
    //   44: aload_2
    //   45: invokevirtual 106	java/io/File:delete	()Z
    //   48: pop
    //   49: aload_2
    //   50: invokevirtual 109	java/io/File:createNewFile	()Z
    //   53: pop
    //   54: new 111	java/io/FileOutputStream
    //   57: dup
    //   58: aload_2
    //   59: invokespecial 114	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   62: astore_3
    //   63: new 116	java/io/BufferedOutputStream
    //   66: dup
    //   67: aload_3
    //   68: invokespecial 119	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   71: astore_2
    //   72: sipush 1024
    //   75: newarray byte
    //   77: astore 7
    //   79: aload 6
    //   81: aload 7
    //   83: invokevirtual 123	java/io/BufferedInputStream:read	([B)I
    //   86: istore 4
    //   88: iload 4
    //   90: iconst_m1
    //   91: if_icmpeq +104 -> 195
    //   94: aload_2
    //   95: aload 7
    //   97: iconst_0
    //   98: iload 4
    //   100: invokevirtual 127	java/io/BufferedOutputStream:write	([BII)V
    //   103: goto -24 -> 79
    //   106: astore 9
    //   108: aload_2
    //   109: astore 7
    //   111: aload_3
    //   112: astore 8
    //   114: aload 6
    //   116: astore_2
    //   117: aload_1
    //   118: astore_3
    //   119: aload 8
    //   121: astore_1
    //   122: aload 9
    //   124: astore 6
    //   126: ldc 129
    //   128: iconst_1
    //   129: new 131	java/lang/StringBuilder
    //   132: dup
    //   133: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   136: ldc 134
    //   138: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: aload 6
    //   143: invokevirtual 142	java/io/IOException:toString	()Ljava/lang/String;
    //   146: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: invokestatic 149	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   155: aload_3
    //   156: ifnull +7 -> 163
    //   159: aload_3
    //   160: invokevirtual 154	java/io/InputStream:close	()V
    //   163: aload_2
    //   164: ifnull +7 -> 171
    //   167: aload_2
    //   168: invokevirtual 155	java/io/BufferedInputStream:close	()V
    //   171: aload_1
    //   172: ifnull +7 -> 179
    //   175: aload_1
    //   176: invokevirtual 156	java/io/FileOutputStream:close	()V
    //   179: aload 7
    //   181: ifnull +8 -> 189
    //   184: aload 7
    //   186: invokevirtual 157	java/io/BufferedOutputStream:close	()V
    //   189: iconst_0
    //   190: istore 5
    //   192: iload 5
    //   194: ireturn
    //   195: aload_2
    //   196: invokevirtual 160	java/io/BufferedOutputStream:flush	()V
    //   199: aload_0
    //   200: getfield 39	asum:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   203: invokeinterface 166 1 0
    //   208: new 131	java/lang/StringBuilder
    //   211: dup
    //   212: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   215: ldc 168
    //   217: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: aload_0
    //   221: getfield 41	asum:d	Ljava/lang/String;
    //   224: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: iconst_1
    //   231: invokeinterface 174 3 0
    //   236: invokeinterface 177 1 0
    //   241: aload_1
    //   242: ifnull +7 -> 249
    //   245: aload_1
    //   246: invokevirtual 154	java/io/InputStream:close	()V
    //   249: aload 6
    //   251: ifnull +8 -> 259
    //   254: aload 6
    //   256: invokevirtual 155	java/io/BufferedInputStream:close	()V
    //   259: aload_3
    //   260: ifnull +7 -> 267
    //   263: aload_3
    //   264: invokevirtual 156	java/io/FileOutputStream:close	()V
    //   267: aload_2
    //   268: ifnull -76 -> 192
    //   271: aload_2
    //   272: invokevirtual 157	java/io/BufferedOutputStream:close	()V
    //   275: iconst_1
    //   276: ireturn
    //   277: astore_1
    //   278: ldc 129
    //   280: iconst_1
    //   281: new 131	java/lang/StringBuilder
    //   284: dup
    //   285: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   288: ldc 179
    //   290: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: aload_1
    //   294: invokevirtual 142	java/io/IOException:toString	()Ljava/lang/String;
    //   297: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: invokestatic 182	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   306: iconst_1
    //   307: ireturn
    //   308: astore_1
    //   309: ldc 129
    //   311: iconst_1
    //   312: new 131	java/lang/StringBuilder
    //   315: dup
    //   316: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   319: ldc 179
    //   321: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: aload_1
    //   325: invokevirtual 142	java/io/IOException:toString	()Ljava/lang/String;
    //   328: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   334: invokestatic 182	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   337: goto -88 -> 249
    //   340: astore_1
    //   341: ldc 129
    //   343: iconst_1
    //   344: new 131	java/lang/StringBuilder
    //   347: dup
    //   348: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   351: ldc 179
    //   353: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: aload_1
    //   357: invokevirtual 142	java/io/IOException:toString	()Ljava/lang/String;
    //   360: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   366: invokestatic 182	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   369: goto -110 -> 259
    //   372: astore_1
    //   373: ldc 129
    //   375: iconst_1
    //   376: new 131	java/lang/StringBuilder
    //   379: dup
    //   380: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   383: ldc 179
    //   385: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: aload_1
    //   389: invokevirtual 142	java/io/IOException:toString	()Ljava/lang/String;
    //   392: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   398: invokestatic 182	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   401: goto -134 -> 267
    //   404: astore_3
    //   405: ldc 129
    //   407: iconst_1
    //   408: new 131	java/lang/StringBuilder
    //   411: dup
    //   412: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   415: ldc 179
    //   417: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: aload_3
    //   421: invokevirtual 142	java/io/IOException:toString	()Ljava/lang/String;
    //   424: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   430: invokestatic 182	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   433: goto -270 -> 163
    //   436: astore_2
    //   437: ldc 129
    //   439: iconst_1
    //   440: new 131	java/lang/StringBuilder
    //   443: dup
    //   444: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   447: ldc 179
    //   449: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: aload_2
    //   453: invokevirtual 142	java/io/IOException:toString	()Ljava/lang/String;
    //   456: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   462: invokestatic 182	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   465: goto -294 -> 171
    //   468: astore_1
    //   469: ldc 129
    //   471: iconst_1
    //   472: new 131	java/lang/StringBuilder
    //   475: dup
    //   476: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   479: ldc 179
    //   481: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: aload_1
    //   485: invokevirtual 142	java/io/IOException:toString	()Ljava/lang/String;
    //   488: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   494: invokestatic 182	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   497: goto -318 -> 179
    //   500: astore_1
    //   501: ldc 129
    //   503: iconst_1
    //   504: new 131	java/lang/StringBuilder
    //   507: dup
    //   508: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   511: ldc 179
    //   513: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: aload_1
    //   517: invokevirtual 142	java/io/IOException:toString	()Ljava/lang/String;
    //   520: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   523: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   526: invokestatic 182	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   529: goto -340 -> 189
    //   532: astore_2
    //   533: aconst_null
    //   534: astore_3
    //   535: aconst_null
    //   536: astore 6
    //   538: aconst_null
    //   539: astore_1
    //   540: aload 8
    //   542: astore 7
    //   544: aload_1
    //   545: ifnull +7 -> 552
    //   548: aload_1
    //   549: invokevirtual 154	java/io/InputStream:close	()V
    //   552: aload 6
    //   554: ifnull +8 -> 562
    //   557: aload 6
    //   559: invokevirtual 155	java/io/BufferedInputStream:close	()V
    //   562: aload_3
    //   563: ifnull +7 -> 570
    //   566: aload_3
    //   567: invokevirtual 156	java/io/FileOutputStream:close	()V
    //   570: aload 7
    //   572: ifnull +8 -> 580
    //   575: aload 7
    //   577: invokevirtual 157	java/io/BufferedOutputStream:close	()V
    //   580: aload_2
    //   581: athrow
    //   582: astore_1
    //   583: ldc 129
    //   585: iconst_1
    //   586: new 131	java/lang/StringBuilder
    //   589: dup
    //   590: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   593: ldc 179
    //   595: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   598: aload_1
    //   599: invokevirtual 142	java/io/IOException:toString	()Ljava/lang/String;
    //   602: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   605: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   608: invokestatic 182	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   611: goto -59 -> 552
    //   614: astore_1
    //   615: ldc 129
    //   617: iconst_1
    //   618: new 131	java/lang/StringBuilder
    //   621: dup
    //   622: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   625: ldc 179
    //   627: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   630: aload_1
    //   631: invokevirtual 142	java/io/IOException:toString	()Ljava/lang/String;
    //   634: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   637: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   640: invokestatic 182	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   643: goto -81 -> 562
    //   646: astore_1
    //   647: ldc 129
    //   649: iconst_1
    //   650: new 131	java/lang/StringBuilder
    //   653: dup
    //   654: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   657: ldc 179
    //   659: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   662: aload_1
    //   663: invokevirtual 142	java/io/IOException:toString	()Ljava/lang/String;
    //   666: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   669: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   672: invokestatic 182	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   675: goto -105 -> 570
    //   678: astore_1
    //   679: ldc 129
    //   681: iconst_1
    //   682: new 131	java/lang/StringBuilder
    //   685: dup
    //   686: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   689: ldc 179
    //   691: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   694: aload_1
    //   695: invokevirtual 142	java/io/IOException:toString	()Ljava/lang/String;
    //   698: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   701: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   704: invokestatic 182	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   707: goto -127 -> 580
    //   710: astore_2
    //   711: aconst_null
    //   712: astore_3
    //   713: aconst_null
    //   714: astore 6
    //   716: aload 8
    //   718: astore 7
    //   720: goto -176 -> 544
    //   723: astore_2
    //   724: aconst_null
    //   725: astore_3
    //   726: aload 8
    //   728: astore 7
    //   730: goto -186 -> 544
    //   733: astore_2
    //   734: aload 8
    //   736: astore 7
    //   738: goto -194 -> 544
    //   741: astore 8
    //   743: aload_2
    //   744: astore 7
    //   746: aload 8
    //   748: astore_2
    //   749: goto -205 -> 544
    //   752: astore 9
    //   754: aload_3
    //   755: astore 8
    //   757: aload_2
    //   758: astore 6
    //   760: aload 9
    //   762: astore_2
    //   763: aload_1
    //   764: astore_3
    //   765: aload 8
    //   767: astore_1
    //   768: goto -224 -> 544
    //   771: astore 6
    //   773: aconst_null
    //   774: astore_1
    //   775: aconst_null
    //   776: astore_2
    //   777: aconst_null
    //   778: astore_3
    //   779: goto -653 -> 126
    //   782: astore 6
    //   784: aconst_null
    //   785: astore 8
    //   787: aconst_null
    //   788: astore_2
    //   789: aload_1
    //   790: astore_3
    //   791: aload 8
    //   793: astore_1
    //   794: goto -668 -> 126
    //   797: astore 9
    //   799: aconst_null
    //   800: astore 8
    //   802: aload 6
    //   804: astore_2
    //   805: aload_1
    //   806: astore_3
    //   807: aload 9
    //   809: astore 6
    //   811: aload 8
    //   813: astore_1
    //   814: goto -688 -> 126
    //   817: astore 9
    //   819: aload 6
    //   821: astore_2
    //   822: aload_1
    //   823: astore 8
    //   825: aload 9
    //   827: astore 6
    //   829: aload_3
    //   830: astore_1
    //   831: aload 8
    //   833: astore_3
    //   834: goto -708 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	837	0	this	asum
    //   0	837	1	paramContext	Context
    //   0	837	2	paramString1	String
    //   0	837	3	paramString2	String
    //   86	13	4	i	int
    //   7	186	5	bool	boolean
    //   26	733	6	localObject1	Object
    //   771	1	6	localIOException1	java.io.IOException
    //   782	21	6	localIOException2	java.io.IOException
    //   809	19	6	localObject2	Object
    //   4	741	7	localObject3	Object
    //   1	734	8	str	String
    //   741	6	8	localObject4	Object
    //   755	77	8	localObject5	Object
    //   106	17	9	localIOException3	java.io.IOException
    //   752	9	9	localObject6	Object
    //   797	11	9	localIOException4	java.io.IOException
    //   817	9	9	localIOException5	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   72	79	106	java/io/IOException
    //   79	88	106	java/io/IOException
    //   94	103	106	java/io/IOException
    //   195	241	106	java/io/IOException
    //   271	275	277	java/io/IOException
    //   245	249	308	java/io/IOException
    //   254	259	340	java/io/IOException
    //   263	267	372	java/io/IOException
    //   159	163	404	java/io/IOException
    //   167	171	436	java/io/IOException
    //   175	179	468	java/io/IOException
    //   184	189	500	java/io/IOException
    //   9	18	532	finally
    //   548	552	582	java/io/IOException
    //   557	562	614	java/io/IOException
    //   566	570	646	java/io/IOException
    //   575	580	678	java/io/IOException
    //   18	28	710	finally
    //   28	49	723	finally
    //   49	63	723	finally
    //   63	72	733	finally
    //   72	79	741	finally
    //   79	88	741	finally
    //   94	103	741	finally
    //   195	241	741	finally
    //   126	155	752	finally
    //   9	18	771	java/io/IOException
    //   18	28	782	java/io/IOException
    //   28	49	797	java/io/IOException
    //   49	63	797	java/io/IOException
    //   63	72	817	java/io/IOException
  }
  
  public boolean a()
  {
    return "Now".equals(this.c);
  }
  
  public File getLatest()
  {
    if (a())
    {
      long l = System.currentTimeMillis();
      boolean bool = a(this.jdField_a_of_type_AndroidContentContext, this.b, this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
      asyp localasyp = aszx.a().a().b("copy_pm");
      String str;
      if (bool)
      {
        str = "0";
        localasyp.c(str).b();
        if (!bool) {
          break label107;
        }
        QLog.i("shadow::AssetsPmUpdater", 1, "copy asset pm success, cost=" + (System.currentTimeMillis() - l));
      }
      for (;;)
      {
        return this.jdField_a_of_type_JavaIoFile;
        str = "1";
        break;
        label107:
        QLog.i("shadow::AssetsPmUpdater", 1, "copy asset pm fail");
      }
    }
    return null;
  }
  
  public Future isAvailable(File paramFile)
  {
    return null;
  }
  
  public Future update()
  {
    return null;
  }
  
  public boolean wasUpdating()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asum
 * JD-Core Version:    0.7.0.1
 */
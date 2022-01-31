import android.graphics.BitmapFactory;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.GifDrawable;
import com.tencent.image.NativeGifFactory;
import com.tencent.image.URLDrawableHandler;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.apache.http.Header;

public class ayqg
  extends ayoi
{
  static File jdField_a_of_type_JavaIoFile;
  static File b;
  public final int a;
  BaseApplicationImpl jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl;
  public final int b;
  
  public ayqg(BaseApplicationImpl paramBaseApplicationImpl)
  {
    this.jdField_a_of_type_Int = 89500;
    this.jdField_b_of_type_Int = 89501;
    this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl = paramBaseApplicationImpl;
    jdField_b_of_type_JavaIoFile = paramBaseApplicationImpl.getDir("", 0);
  }
  
  /* Error */
  public File a(java.io.OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    // Byte code:
    //   0: getstatic 38	ayqg:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   3: ifnull +12 -> 15
    //   6: getstatic 38	ayqg:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   9: invokevirtual 44	java/io/File:exists	()Z
    //   12: ifne +55 -> 67
    //   15: aload_0
    //   16: getfield 22	ayqg:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   19: ldc 46
    //   21: iconst_0
    //   22: invokevirtual 30	com/tencent/common/app/BaseApplicationImpl:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   25: putstatic 38	ayqg:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   28: aload_0
    //   29: getfield 22	ayqg:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   32: ldc 48
    //   34: iconst_0
    //   35: invokevirtual 30	com/tencent/common/app/BaseApplicationImpl:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   38: astore_1
    //   39: aload_1
    //   40: invokevirtual 44	java/io/File:exists	()Z
    //   43: ifeq +8 -> 51
    //   46: aload_1
    //   47: invokevirtual 51	java/io/File:delete	()Z
    //   50: pop
    //   51: getstatic 38	ayqg:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   54: invokevirtual 44	java/io/File:exists	()Z
    //   57: ifne +10 -> 67
    //   60: getstatic 38	ayqg:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   63: invokevirtual 54	java/io/File:mkdirs	()Z
    //   66: pop
    //   67: invokestatic 59	anpc:a	()Ljava/lang/String;
    //   70: astore_1
    //   71: aload_0
    //   72: getfield 22	ayqg:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   75: aload_1
    //   76: invokevirtual 63	com/tencent/common/app/BaseApplicationImpl:getAppRuntime	(Ljava/lang/String;)Lmqq/app/AppRuntime;
    //   79: checkcast 65	com/tencent/mobileqq/app/QQAppInterface
    //   82: astore_1
    //   83: aload_1
    //   84: ifnull +658 -> 742
    //   87: aload_1
    //   88: bipush 77
    //   90: invokevirtual 69	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   93: checkcast 56	anpc
    //   96: astore_1
    //   97: aload_1
    //   98: ifnull +644 -> 742
    //   101: aload_1
    //   102: ldc 71
    //   104: invokevirtual 74	anpc:a	(Ljava/lang/String;)Lanpn;
    //   107: checkcast 76	anqe
    //   110: astore_1
    //   111: aload_2
    //   112: getfield 82	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   115: invokevirtual 87	java/net/URL:getHost	()Ljava/lang/String;
    //   118: astore_3
    //   119: new 40	java/io/File
    //   122: dup
    //   123: new 89	java/lang/StringBuilder
    //   126: dup
    //   127: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   130: getstatic 38	ayqg:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   133: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   136: ldc 96
    //   138: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: aload_3
    //   142: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: invokespecial 105	java/io/File:<init>	(Ljava/lang/String;)V
    //   151: astore 9
    //   153: iconst_0
    //   154: istore 6
    //   156: aload 9
    //   158: invokevirtual 44	java/io/File:exists	()Z
    //   161: ifeq +13 -> 174
    //   164: aload 9
    //   166: invokevirtual 109	java/io/File:length	()J
    //   169: lconst_0
    //   170: lcmp
    //   171: ifne +467 -> 638
    //   174: invokestatic 114	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   177: ifeq +53 -> 230
    //   180: ldc 116
    //   182: iconst_2
    //   183: new 89	java/lang/StringBuilder
    //   186: dup
    //   187: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   190: ldc 118
    //   192: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: aload_2
    //   196: getfield 122	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   199: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: ldc 124
    //   204: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: aload_3
    //   208: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: ldc 126
    //   213: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: aload 9
    //   218: invokevirtual 129	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   221: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: invokestatic 133	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   230: getstatic 139	ayjy:c	[Ljava/lang/String;
    //   233: astore 8
    //   235: aload 8
    //   237: arraylength
    //   238: istore 7
    //   240: iconst_0
    //   241: istore 4
    //   243: iload 6
    //   245: istore 5
    //   247: iload 4
    //   249: iload 7
    //   251: if_icmpge +18 -> 269
    //   254: aload 8
    //   256: iload 4
    //   258: aaload
    //   259: aload_3
    //   260: invokevirtual 145	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   263: ifeq +489 -> 752
    //   266: iconst_1
    //   267: istore 5
    //   269: iload 5
    //   271: ifeq +329 -> 600
    //   274: new 40	java/io/File
    //   277: dup
    //   278: new 89	java/lang/StringBuilder
    //   281: dup
    //   282: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   285: getstatic 38	ayqg:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   288: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   291: ldc 96
    //   293: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: aload_3
    //   297: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: ldc 147
    //   302: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   308: invokespecial 105	java/io/File:<init>	(Ljava/lang/String;)V
    //   311: astore 10
    //   313: aload 10
    //   315: invokevirtual 44	java/io/File:exists	()Z
    //   318: ifeq +9 -> 327
    //   321: aload 10
    //   323: invokevirtual 51	java/io/File:delete	()Z
    //   326: pop
    //   327: aconst_null
    //   328: astore_2
    //   329: aconst_null
    //   330: astore 8
    //   332: aload_0
    //   333: getfield 22	ayqg:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   336: invokevirtual 151	com/tencent/common/app/BaseApplicationImpl:getAssets	()Landroid/content/res/AssetManager;
    //   339: new 89	java/lang/StringBuilder
    //   342: dup
    //   343: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   346: ldc 153
    //   348: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: aload_3
    //   352: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: ldc 155
    //   357: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   363: invokevirtual 161	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   366: astore_1
    //   367: sipush 4096
    //   370: newarray byte
    //   372: astore_2
    //   373: new 163	java/io/FileOutputStream
    //   376: dup
    //   377: aload 10
    //   379: invokespecial 166	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   382: astore_3
    //   383: aload_1
    //   384: aload_2
    //   385: invokevirtual 172	java/io/InputStream:read	([B)I
    //   388: iconst_m1
    //   389: if_icmpeq +158 -> 547
    //   392: aload_3
    //   393: aload_2
    //   394: invokevirtual 176	java/io/FileOutputStream:write	([B)V
    //   397: aload_3
    //   398: invokevirtual 179	java/io/FileOutputStream:flush	()V
    //   401: goto -18 -> 383
    //   404: astore 8
    //   406: aload_1
    //   407: astore_2
    //   408: aload_3
    //   409: astore_1
    //   410: aload 8
    //   412: astore_3
    //   413: aload_3
    //   414: athrow
    //   415: astore 8
    //   417: aload_1
    //   418: astore_3
    //   419: aload 8
    //   421: astore_1
    //   422: aload_2
    //   423: ifnull +7 -> 430
    //   426: aload_2
    //   427: invokevirtual 182	java/io/InputStream:close	()V
    //   430: aload_3
    //   431: ifnull +7 -> 438
    //   434: aload_3
    //   435: invokevirtual 183	java/io/FileOutputStream:close	()V
    //   438: aload_1
    //   439: athrow
    //   440: astore_1
    //   441: new 185	java/util/HashMap
    //   444: dup
    //   445: invokespecial 186	java/util/HashMap:<init>	()V
    //   448: astore_2
    //   449: aload_2
    //   450: ldc 188
    //   452: ldc 15
    //   454: invokestatic 193	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   457: invokevirtual 197	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   460: pop
    //   461: aload_2
    //   462: ldc 199
    //   464: aload_1
    //   465: invokestatic 204	ayoj:a	(Ljava/lang/Exception;)Ljava/lang/String;
    //   468: invokevirtual 197	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   471: pop
    //   472: invokestatic 210	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   475: invokestatic 215	axrn:a	(Landroid/content/Context;)Laxrn;
    //   478: aconst_null
    //   479: ldc 217
    //   481: iconst_0
    //   482: lconst_0
    //   483: lconst_0
    //   484: aload_2
    //   485: ldc 24
    //   487: invokevirtual 220	axrn:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   490: invokestatic 114	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   493: ifeq +12 -> 505
    //   496: ldc 116
    //   498: iconst_2
    //   499: ldc 222
    //   501: aload_1
    //   502: invokestatic 226	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   505: getstatic 32	ayqg:jdField_b_of_type_JavaIoFile	Ljava/io/File;
    //   508: areturn
    //   509: astore_1
    //   510: invokestatic 114	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   513: ifeq +234 -> 747
    //   516: ldc 116
    //   518: iconst_2
    //   519: new 89	java/lang/StringBuilder
    //   522: dup
    //   523: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   526: ldc 228
    //   528: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   531: aload_1
    //   532: invokevirtual 231	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   535: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   538: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   541: invokestatic 234	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   544: goto +203 -> 747
    //   547: aload_1
    //   548: ifnull +7 -> 555
    //   551: aload_1
    //   552: invokevirtual 182	java/io/InputStream:close	()V
    //   555: aload_3
    //   556: ifnull +7 -> 563
    //   559: aload_3
    //   560: invokevirtual 183	java/io/FileOutputStream:close	()V
    //   563: aload 10
    //   565: aload 9
    //   567: invokevirtual 238	java/io/File:renameTo	(Ljava/io/File;)Z
    //   570: pop
    //   571: invokestatic 210	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   574: invokestatic 215	axrn:a	(Landroid/content/Context;)Laxrn;
    //   577: aconst_null
    //   578: ldc 217
    //   580: iconst_1
    //   581: lconst_0
    //   582: lconst_0
    //   583: aconst_null
    //   584: ldc 24
    //   586: invokevirtual 220	axrn:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   589: aload 9
    //   591: invokevirtual 44	java/io/File:exists	()Z
    //   594: ifeq +56 -> 650
    //   597: aload 9
    //   599: areturn
    //   600: aload_1
    //   601: ifnull -12 -> 589
    //   604: aload_2
    //   605: ldc 240
    //   607: invokevirtual 244	com/tencent/image/DownloadParams:getHeader	(Ljava/lang/String;)Lorg/apache/http/Header;
    //   610: astore_2
    //   611: aload_2
    //   612: ifnull +13 -> 625
    //   615: aload_1
    //   616: aload_2
    //   617: invokeinterface 249 1 0
    //   622: invokevirtual 251	anqe:b	(Ljava/lang/String;)V
    //   625: aload_1
    //   626: iconst_0
    //   627: invokevirtual 254	anqe:c	(Z)V
    //   630: aload_1
    //   631: iconst_0
    //   632: invokevirtual 256	anqe:d	(Z)V
    //   635: goto -46 -> 589
    //   638: aload_1
    //   639: ifnull -50 -> 589
    //   642: aload_1
    //   643: iconst_1
    //   644: invokevirtual 256	anqe:d	(Z)V
    //   647: goto -58 -> 589
    //   650: new 185	java/util/HashMap
    //   653: dup
    //   654: invokespecial 186	java/util/HashMap:<init>	()V
    //   657: astore_1
    //   658: aload_1
    //   659: ldc 188
    //   661: ldc 18
    //   663: invokestatic 193	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   666: invokevirtual 197	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   669: pop
    //   670: invokestatic 210	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   673: invokestatic 215	axrn:a	(Landroid/content/Context;)Laxrn;
    //   676: aconst_null
    //   677: ldc 217
    //   679: iconst_0
    //   680: lconst_0
    //   681: lconst_0
    //   682: aload_1
    //   683: ldc 24
    //   685: invokevirtual 220	axrn:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   688: getstatic 32	ayqg:jdField_b_of_type_JavaIoFile	Ljava/io/File;
    //   691: astore_1
    //   692: aload_1
    //   693: areturn
    //   694: astore_1
    //   695: aload 8
    //   697: astore_3
    //   698: goto -276 -> 422
    //   701: astore_3
    //   702: aload_1
    //   703: astore_2
    //   704: aload_3
    //   705: astore_1
    //   706: aload 8
    //   708: astore_3
    //   709: goto -287 -> 422
    //   712: astore 8
    //   714: aload_1
    //   715: astore_2
    //   716: aload 8
    //   718: astore_1
    //   719: goto -297 -> 422
    //   722: astore_3
    //   723: aconst_null
    //   724: astore_2
    //   725: aconst_null
    //   726: astore_1
    //   727: goto -314 -> 413
    //   730: astore_3
    //   731: aconst_null
    //   732: astore 8
    //   734: aload_1
    //   735: astore_2
    //   736: aload 8
    //   738: astore_1
    //   739: goto -326 -> 413
    //   742: aconst_null
    //   743: astore_1
    //   744: goto -633 -> 111
    //   747: aconst_null
    //   748: astore_1
    //   749: goto -666 -> 83
    //   752: iload 4
    //   754: iconst_1
    //   755: iadd
    //   756: istore 4
    //   758: goto -515 -> 243
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	761	0	this	ayqg
    //   0	761	1	paramOutputStream	java.io.OutputStream
    //   0	761	2	paramDownloadParams	DownloadParams
    //   0	761	3	paramURLDrawableHandler	URLDrawableHandler
    //   241	516	4	i	int
    //   245	25	5	j	int
    //   154	90	6	k	int
    //   238	14	7	m	int
    //   233	98	8	arrayOfString	java.lang.String[]
    //   404	7	8	localException	Exception
    //   415	292	8	localObject1	Object
    //   712	5	8	localObject2	Object
    //   732	5	8	localObject3	Object
    //   151	447	9	localFile1	File
    //   311	253	10	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   383	401	404	java/lang/Exception
    //   413	415	415	finally
    //   0	15	440	java/lang/Exception
    //   15	51	440	java/lang/Exception
    //   51	67	440	java/lang/Exception
    //   87	97	440	java/lang/Exception
    //   101	111	440	java/lang/Exception
    //   111	153	440	java/lang/Exception
    //   156	174	440	java/lang/Exception
    //   174	230	440	java/lang/Exception
    //   230	240	440	java/lang/Exception
    //   254	266	440	java/lang/Exception
    //   274	327	440	java/lang/Exception
    //   426	430	440	java/lang/Exception
    //   434	438	440	java/lang/Exception
    //   438	440	440	java/lang/Exception
    //   510	544	440	java/lang/Exception
    //   551	555	440	java/lang/Exception
    //   559	563	440	java/lang/Exception
    //   563	589	440	java/lang/Exception
    //   589	597	440	java/lang/Exception
    //   604	611	440	java/lang/Exception
    //   615	625	440	java/lang/Exception
    //   625	635	440	java/lang/Exception
    //   642	647	440	java/lang/Exception
    //   650	692	440	java/lang/Exception
    //   67	83	509	java/lang/Exception
    //   332	367	694	finally
    //   367	383	701	finally
    //   383	401	712	finally
    //   332	367	722	java/lang/Exception
    //   367	383	730	java/lang/Exception
  }
  
  public boolean a()
  {
    return false;
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    try
    {
      if (paramFile.equals(jdField_b_of_type_JavaIoFile))
      {
        paramFile = paramDownloadParams.getHeader("KEY_STATIC_DRAWABLE_ID");
        if (paramFile != null)
        {
          paramFile = paramFile.getValue();
          if (paramFile != null)
          {
            int i = Integer.valueOf(paramFile).intValue();
            return BitmapFactory.decodeResource(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getResources(), i);
          }
        }
      }
      else
      {
        if (GifDrawable.isGifFile(paramFile)) {
          return NativeGifFactory.getNativeGifObject(paramFile, false);
        }
        paramFile = BitmapFactory.decodeFile(paramFile.getAbsolutePath());
        return paramFile;
      }
    }
    catch (Exception paramFile)
    {
      if (QLog.isColorLevel()) {
        QLog.e("EmotionDownloader", 2, "decode file", paramFile);
      }
      return null;
    }
    catch (OutOfMemoryError paramFile)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("EmotionDownloader", 2, "decode file", paramFile);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayqg
 * JD-Core Version:    0.7.0.1
 */
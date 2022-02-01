package com.tencent.biz.pubaccount.util;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.FileObserver;
import android.provider.MediaStore.Images.Media;
import com.tencent.mobileqq.app.HardCodeUtil;

public class ScreenshotContentObserver
  extends ContentObserver
{
  private static final String jdField_a_of_type_JavaLangString = MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString();
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "_data", "date_added" };
  private static final String jdField_b_of_type_JavaLangString = HardCodeUtil.a(2131713502);
  private int jdField_a_of_type_Int;
  private ContentResolver jdField_a_of_type_AndroidContentContentResolver;
  private FileObserver jdField_a_of_type_AndroidOsFileObserver;
  private ScreenshotContentObserver.Listener jdField_a_of_type_ComTencentBizPubaccountUtilScreenshotContentObserver$Listener;
  private int jdField_b_of_type_Int;
  private String c;
  
  public ScreenshotContentObserver(Context paramContext, int paramInt1, int paramInt2)
  {
    super(null);
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    if (Build.VERSION.SDK_INT < 23)
    {
      if (Build.MANUFACTURER.equalsIgnoreCase("Xiaomi")) {
        paramContext = ScreenshotContentObserver.ScreenShotPath.jdField_b_of_type_JavaLangString;
      } else if (Build.MANUFACTURER.equalsIgnoreCase("vivo")) {
        paramContext = ScreenshotContentObserver.ScreenShotPath.c;
      } else {
        paramContext = ScreenshotContentObserver.ScreenShotPath.jdField_a_of_type_JavaLangString;
      }
      this.jdField_a_of_type_AndroidOsFileObserver = new ScreenshotContentObserver.1(this, paramContext, 256, paramContext);
    }
    else
    {
      this.jdField_a_of_type_AndroidContentContentResolver = paramContext.getContentResolver();
    }
    b();
  }
  
  private boolean a(long paramLong)
  {
    return System.currentTimeMillis() - paramLong * 1000L < 1500L;
  }
  
  private boolean a(String paramString)
  {
    paramString = paramString.toLowerCase();
    return (paramString.contains("screenshot")) || (paramString.contains(jdField_b_of_type_JavaLangString));
  }
  
  private void b()
  {
    if (Build.VERSION.SDK_INT < 23)
    {
      this.jdField_a_of_type_AndroidOsFileObserver.startWatching();
      return;
    }
    this.jdField_a_of_type_AndroidContentContentResolver.registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this);
  }
  
  private void c()
  {
    if (Build.VERSION.SDK_INT < 23)
    {
      this.jdField_a_of_type_AndroidOsFileObserver.stopWatching();
      return;
    }
    this.jdField_a_of_type_AndroidContentContentResolver.unregisterContentObserver(this);
  }
  
  public void a()
  {
    c();
    this.jdField_a_of_type_AndroidOsFileObserver = null;
    this.jdField_a_of_type_AndroidContentContentResolver = null;
    this.jdField_a_of_type_ComTencentBizPubaccountUtilScreenshotContentObserver$Listener = null;
  }
  
  public void a(ScreenshotContentObserver.Listener paramListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountUtilScreenshotContentObserver$Listener = paramListener;
  }
  
  public void onChange(boolean paramBoolean)
  {
    super.onChange(paramBoolean);
    onChange(paramBoolean, null);
  }
  
  /* Error */
  public void onChange(boolean paramBoolean, Uri paramUri)
  {
    // Byte code:
    //   0: invokestatic 158	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3: ifeq +36 -> 39
    //   6: new 160	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   13: astore_3
    //   14: aload_3
    //   15: ldc 164
    //   17: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: pop
    //   21: aload_3
    //   22: invokestatic 109	java/lang/System:currentTimeMillis	()J
    //   25: invokevirtual 171	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: ldc 173
    //   31: iconst_2
    //   32: aload_3
    //   33: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokestatic 178	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   39: aconst_null
    //   40: astore 4
    //   42: aconst_null
    //   43: astore 6
    //   45: aconst_null
    //   46: astore 5
    //   48: aconst_null
    //   49: astore 7
    //   51: aconst_null
    //   52: astore_3
    //   53: aload_2
    //   54: ifnonnull +378 -> 432
    //   57: aload_0
    //   58: getfield 94	com/tencent/biz/pubaccount/util/ScreenshotContentObserver:jdField_a_of_type_AndroidContentContentResolver	Landroid/content/ContentResolver;
    //   61: getstatic 21	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   64: getstatic 37	com/tencent/biz/pubaccount/util/ScreenshotContentObserver:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   67: aconst_null
    //   68: aconst_null
    //   69: ldc 180
    //   71: invokevirtual 184	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   74: astore 5
    //   76: aload 5
    //   78: ifnull +290 -> 368
    //   81: aload 5
    //   83: astore_3
    //   84: aload 5
    //   86: astore 4
    //   88: aload 5
    //   90: invokeinterface 190 1 0
    //   95: ifle +273 -> 368
    //   98: aload 5
    //   100: astore_3
    //   101: aload 5
    //   103: astore 4
    //   105: aload 5
    //   107: invokeinterface 193 1 0
    //   112: pop
    //   113: aload 5
    //   115: astore_3
    //   116: aload 5
    //   118: astore 4
    //   120: aload 5
    //   122: aload 5
    //   124: ldc 33
    //   126: invokeinterface 197 2 0
    //   131: invokeinterface 200 2 0
    //   136: astore 6
    //   138: aload 5
    //   140: astore_3
    //   141: aload 5
    //   143: astore 4
    //   145: aload_0
    //   146: aload 5
    //   148: aload 5
    //   150: ldc 35
    //   152: invokeinterface 197 2 0
    //   157: invokeinterface 204 2 0
    //   162: invokespecial 206	com/tencent/biz/pubaccount/util/ScreenshotContentObserver:a	(J)Z
    //   165: ifeq +203 -> 368
    //   168: aload 5
    //   170: astore_3
    //   171: aload 5
    //   173: astore 4
    //   175: aload_0
    //   176: aload 6
    //   178: invokespecial 208	com/tencent/biz/pubaccount/util/ScreenshotContentObserver:a	(Ljava/lang/String;)Z
    //   181: ifeq +187 -> 368
    //   184: aload 5
    //   186: astore_3
    //   187: aload 5
    //   189: astore 4
    //   191: invokestatic 211	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   194: ifeq +82 -> 276
    //   197: aload 5
    //   199: astore_3
    //   200: aload 5
    //   202: astore 4
    //   204: new 160	java/lang/StringBuilder
    //   207: dup
    //   208: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   211: astore 7
    //   213: aload 5
    //   215: astore_3
    //   216: aload 5
    //   218: astore 4
    //   220: aload 7
    //   222: ldc 213
    //   224: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: pop
    //   228: aload 5
    //   230: astore_3
    //   231: aload 5
    //   233: astore 4
    //   235: aload 7
    //   237: aload 6
    //   239: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: pop
    //   243: aload 5
    //   245: astore_3
    //   246: aload 5
    //   248: astore 4
    //   250: aload 7
    //   252: ldc 215
    //   254: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: pop
    //   258: aload 5
    //   260: astore_3
    //   261: aload 5
    //   263: astore 4
    //   265: ldc 173
    //   267: iconst_2
    //   268: aload 7
    //   270: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   273: invokestatic 178	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   276: aload 6
    //   278: ifnull +56 -> 334
    //   281: aload 5
    //   283: astore_3
    //   284: aload 5
    //   286: astore 4
    //   288: aload 6
    //   290: aload_0
    //   291: getfield 101	com/tencent/biz/pubaccount/util/ScreenshotContentObserver:c	Ljava/lang/String;
    //   294: invokevirtual 71	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   297: istore_1
    //   298: iload_1
    //   299: ifeq +22 -> 321
    //   302: aload 5
    //   304: ifnull +16 -> 320
    //   307: aload 5
    //   309: invokeinterface 218 1 0
    //   314: return
    //   315: astore_2
    //   316: aload_2
    //   317: invokevirtual 221	java/lang/Exception:printStackTrace	()V
    //   320: return
    //   321: aload 5
    //   323: astore_3
    //   324: aload 5
    //   326: astore 4
    //   328: aload_0
    //   329: aload 6
    //   331: putfield 101	com/tencent/biz/pubaccount/util/ScreenshotContentObserver:c	Ljava/lang/String;
    //   334: aload 5
    //   336: astore_3
    //   337: aload 5
    //   339: astore 4
    //   341: aload_0
    //   342: getfield 99	com/tencent/biz/pubaccount/util/ScreenshotContentObserver:jdField_a_of_type_ComTencentBizPubaccountUtilScreenshotContentObserver$Listener	Lcom/tencent/biz/pubaccount/util/ScreenshotContentObserver$Listener;
    //   345: ifnull +23 -> 368
    //   348: aload 5
    //   350: astore_3
    //   351: aload 5
    //   353: astore 4
    //   355: aload_0
    //   356: getfield 99	com/tencent/biz/pubaccount/util/ScreenshotContentObserver:jdField_a_of_type_ComTencentBizPubaccountUtilScreenshotContentObserver$Listener	Lcom/tencent/biz/pubaccount/util/ScreenshotContentObserver$Listener;
    //   359: aload_2
    //   360: aload 6
    //   362: iconst_1
    //   363: invokeinterface 226 4 0
    //   368: aload 5
    //   370: ifnull +479 -> 849
    //   373: aload 5
    //   375: invokeinterface 218 1 0
    //   380: return
    //   381: astore_2
    //   382: goto +30 -> 412
    //   385: astore_2
    //   386: aload 4
    //   388: astore_3
    //   389: aload_2
    //   390: invokevirtual 221	java/lang/Exception:printStackTrace	()V
    //   393: aload 4
    //   395: ifnull +454 -> 849
    //   398: aload 4
    //   400: invokeinterface 218 1 0
    //   405: return
    //   406: astore_2
    //   407: aload_2
    //   408: invokevirtual 221	java/lang/Exception:printStackTrace	()V
    //   411: return
    //   412: aload_3
    //   413: ifnull +17 -> 430
    //   416: aload_3
    //   417: invokeinterface 218 1 0
    //   422: goto +8 -> 430
    //   425: astore_3
    //   426: aload_3
    //   427: invokevirtual 221	java/lang/Exception:printStackTrace	()V
    //   430: aload_2
    //   431: athrow
    //   432: aload 5
    //   434: astore_3
    //   435: aload 7
    //   437: astore 4
    //   439: aload_2
    //   440: invokevirtual 27	android/net/Uri:toString	()Ljava/lang/String;
    //   443: getstatic 29	com/tencent/biz/pubaccount/util/ScreenshotContentObserver:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   446: invokevirtual 229	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   449: ifeq +357 -> 806
    //   452: aload 5
    //   454: astore_3
    //   455: aload 7
    //   457: astore 4
    //   459: aload_0
    //   460: getfield 94	com/tencent/biz/pubaccount/util/ScreenshotContentObserver:jdField_a_of_type_AndroidContentContentResolver	Landroid/content/ContentResolver;
    //   463: aload_2
    //   464: getstatic 37	com/tencent/biz/pubaccount/util/ScreenshotContentObserver:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   467: aconst_null
    //   468: aconst_null
    //   469: ldc 180
    //   471: invokevirtual 184	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   474: astore 5
    //   476: aload 5
    //   478: astore 6
    //   480: aload 5
    //   482: ifnull +324 -> 806
    //   485: aload 5
    //   487: astore 6
    //   489: aload 5
    //   491: astore_3
    //   492: aload 5
    //   494: astore 4
    //   496: aload 5
    //   498: invokeinterface 190 1 0
    //   503: ifle +303 -> 806
    //   506: aload 5
    //   508: astore_3
    //   509: aload 5
    //   511: astore 4
    //   513: aload 5
    //   515: invokeinterface 193 1 0
    //   520: pop
    //   521: aload 5
    //   523: astore_3
    //   524: aload 5
    //   526: astore 4
    //   528: aload 5
    //   530: aload 5
    //   532: ldc 33
    //   534: invokeinterface 197 2 0
    //   539: invokeinterface 200 2 0
    //   544: astore 7
    //   546: aload 5
    //   548: astore 6
    //   550: aload 5
    //   552: astore_3
    //   553: aload 5
    //   555: astore 4
    //   557: aload_0
    //   558: aload 5
    //   560: aload 5
    //   562: ldc 35
    //   564: invokeinterface 197 2 0
    //   569: invokeinterface 204 2 0
    //   574: invokespecial 206	com/tencent/biz/pubaccount/util/ScreenshotContentObserver:a	(J)Z
    //   577: ifeq +229 -> 806
    //   580: aload 5
    //   582: astore 6
    //   584: aload 5
    //   586: astore_3
    //   587: aload 5
    //   589: astore 4
    //   591: aload_0
    //   592: aload 7
    //   594: invokespecial 208	com/tencent/biz/pubaccount/util/ScreenshotContentObserver:a	(Ljava/lang/String;)Z
    //   597: ifeq +209 -> 806
    //   600: aload 5
    //   602: astore_3
    //   603: aload 5
    //   605: astore 4
    //   607: invokestatic 211	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   610: ifeq +96 -> 706
    //   613: aload 5
    //   615: astore_3
    //   616: aload 5
    //   618: astore 4
    //   620: new 160	java/lang/StringBuilder
    //   623: dup
    //   624: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   627: astore 6
    //   629: aload 5
    //   631: astore_3
    //   632: aload 5
    //   634: astore 4
    //   636: aload 6
    //   638: ldc 213
    //   640: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   643: pop
    //   644: aload 5
    //   646: astore_3
    //   647: aload 5
    //   649: astore 4
    //   651: aload 6
    //   653: aload 7
    //   655: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   658: pop
    //   659: aload 5
    //   661: astore_3
    //   662: aload 5
    //   664: astore 4
    //   666: aload 6
    //   668: ldc 231
    //   670: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   673: pop
    //   674: aload 5
    //   676: astore_3
    //   677: aload 5
    //   679: astore 4
    //   681: aload 6
    //   683: aload_2
    //   684: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   687: pop
    //   688: aload 5
    //   690: astore_3
    //   691: aload 5
    //   693: astore 4
    //   695: ldc 173
    //   697: iconst_2
    //   698: aload 6
    //   700: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   703: invokestatic 178	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   706: aload 7
    //   708: ifnull +56 -> 764
    //   711: aload 5
    //   713: astore_3
    //   714: aload 5
    //   716: astore 4
    //   718: aload 7
    //   720: aload_0
    //   721: getfield 101	com/tencent/biz/pubaccount/util/ScreenshotContentObserver:c	Ljava/lang/String;
    //   724: invokevirtual 71	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   727: istore_1
    //   728: iload_1
    //   729: ifeq +22 -> 751
    //   732: aload 5
    //   734: ifnull +16 -> 750
    //   737: aload 5
    //   739: invokeinterface 218 1 0
    //   744: return
    //   745: astore_2
    //   746: aload_2
    //   747: invokevirtual 221	java/lang/Exception:printStackTrace	()V
    //   750: return
    //   751: aload 5
    //   753: astore_3
    //   754: aload 5
    //   756: astore 4
    //   758: aload_0
    //   759: aload 7
    //   761: putfield 101	com/tencent/biz/pubaccount/util/ScreenshotContentObserver:c	Ljava/lang/String;
    //   764: aload 5
    //   766: astore 6
    //   768: aload 5
    //   770: astore_3
    //   771: aload 5
    //   773: astore 4
    //   775: aload_0
    //   776: getfield 99	com/tencent/biz/pubaccount/util/ScreenshotContentObserver:jdField_a_of_type_ComTencentBizPubaccountUtilScreenshotContentObserver$Listener	Lcom/tencent/biz/pubaccount/util/ScreenshotContentObserver$Listener;
    //   779: ifnull +27 -> 806
    //   782: aload 5
    //   784: astore_3
    //   785: aload 5
    //   787: astore 4
    //   789: aload_0
    //   790: getfield 99	com/tencent/biz/pubaccount/util/ScreenshotContentObserver:jdField_a_of_type_ComTencentBizPubaccountUtilScreenshotContentObserver$Listener	Lcom/tencent/biz/pubaccount/util/ScreenshotContentObserver$Listener;
    //   793: aload_2
    //   794: aload 7
    //   796: iconst_1
    //   797: invokeinterface 226 4 0
    //   802: aload 5
    //   804: astore 6
    //   806: aload 6
    //   808: ifnull +41 -> 849
    //   811: aload 6
    //   813: invokeinterface 218 1 0
    //   818: return
    //   819: astore_2
    //   820: goto +30 -> 850
    //   823: astore_2
    //   824: aload 4
    //   826: astore_3
    //   827: aload_2
    //   828: invokevirtual 221	java/lang/Exception:printStackTrace	()V
    //   831: aload 4
    //   833: ifnull +16 -> 849
    //   836: aload 4
    //   838: invokeinterface 218 1 0
    //   843: return
    //   844: astore_2
    //   845: aload_2
    //   846: invokevirtual 221	java/lang/Exception:printStackTrace	()V
    //   849: return
    //   850: aload_3
    //   851: ifnull +17 -> 868
    //   854: aload_3
    //   855: invokeinterface 218 1 0
    //   860: goto +8 -> 868
    //   863: astore_3
    //   864: aload_3
    //   865: invokevirtual 221	java/lang/Exception:printStackTrace	()V
    //   868: aload_2
    //   869: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	870	0	this	ScreenshotContentObserver
    //   0	870	1	paramBoolean	boolean
    //   0	870	2	paramUri	Uri
    //   13	404	3	localObject1	java.lang.Object
    //   425	2	3	localException1	java.lang.Exception
    //   434	421	3	localObject2	java.lang.Object
    //   863	2	3	localException2	java.lang.Exception
    //   40	797	4	localObject3	java.lang.Object
    //   46	757	5	localCursor	android.database.Cursor
    //   43	769	6	localObject4	java.lang.Object
    //   49	746	7	localObject5	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   307	314	315	java/lang/Exception
    //   57	76	381	finally
    //   88	98	381	finally
    //   105	113	381	finally
    //   120	138	381	finally
    //   145	168	381	finally
    //   175	184	381	finally
    //   191	197	381	finally
    //   204	213	381	finally
    //   220	228	381	finally
    //   235	243	381	finally
    //   250	258	381	finally
    //   265	276	381	finally
    //   288	298	381	finally
    //   328	334	381	finally
    //   341	348	381	finally
    //   355	368	381	finally
    //   389	393	381	finally
    //   57	76	385	java/lang/Exception
    //   88	98	385	java/lang/Exception
    //   105	113	385	java/lang/Exception
    //   120	138	385	java/lang/Exception
    //   145	168	385	java/lang/Exception
    //   175	184	385	java/lang/Exception
    //   191	197	385	java/lang/Exception
    //   204	213	385	java/lang/Exception
    //   220	228	385	java/lang/Exception
    //   235	243	385	java/lang/Exception
    //   250	258	385	java/lang/Exception
    //   265	276	385	java/lang/Exception
    //   288	298	385	java/lang/Exception
    //   328	334	385	java/lang/Exception
    //   341	348	385	java/lang/Exception
    //   355	368	385	java/lang/Exception
    //   373	380	406	java/lang/Exception
    //   398	405	406	java/lang/Exception
    //   416	422	425	java/lang/Exception
    //   737	744	745	java/lang/Exception
    //   439	452	819	finally
    //   459	476	819	finally
    //   496	506	819	finally
    //   513	521	819	finally
    //   528	546	819	finally
    //   557	580	819	finally
    //   591	600	819	finally
    //   607	613	819	finally
    //   620	629	819	finally
    //   636	644	819	finally
    //   651	659	819	finally
    //   666	674	819	finally
    //   681	688	819	finally
    //   695	706	819	finally
    //   718	728	819	finally
    //   758	764	819	finally
    //   775	782	819	finally
    //   789	802	819	finally
    //   827	831	819	finally
    //   439	452	823	java/lang/Exception
    //   459	476	823	java/lang/Exception
    //   496	506	823	java/lang/Exception
    //   513	521	823	java/lang/Exception
    //   528	546	823	java/lang/Exception
    //   557	580	823	java/lang/Exception
    //   591	600	823	java/lang/Exception
    //   607	613	823	java/lang/Exception
    //   620	629	823	java/lang/Exception
    //   636	644	823	java/lang/Exception
    //   651	659	823	java/lang/Exception
    //   666	674	823	java/lang/Exception
    //   681	688	823	java/lang/Exception
    //   695	706	823	java/lang/Exception
    //   718	728	823	java/lang/Exception
    //   758	764	823	java/lang/Exception
    //   775	782	823	java/lang/Exception
    //   789	802	823	java/lang/Exception
    //   811	818	844	java/lang/Exception
    //   836	843	844	java/lang/Exception
    //   854	860	863	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.ScreenshotContentObserver
 * JD-Core Version:    0.7.0.1
 */
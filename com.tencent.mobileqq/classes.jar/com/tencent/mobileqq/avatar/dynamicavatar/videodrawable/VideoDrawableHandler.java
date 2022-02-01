package com.tencent.mobileqq.avatar.dynamicavatar.videodrawable;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Vector;

public class VideoDrawableHandler
  implements Handler.Callback
{
  public static int a = 1;
  public static int b = 2;
  public static int c = 4;
  private static int d;
  long jdField_a_of_type_Long = 0L;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  MediaMetadataRetriever jdField_a_of_type_AndroidMediaMediaMetadataRetriever;
  Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  VideoDrawableHandler.OnGetFrameListener jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler$OnGetFrameListener;
  final Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString;
  LinkedList<VideoDrawableHandler.DecodeFrameTask> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  Vector<WeakReference<VideoDrawable>> jdField_a_of_type_JavaUtilVector = new Vector();
  boolean jdField_a_of_type_Boolean = true;
  Bitmap b;
  private Bitmap c;
  
  public VideoDrawableHandler(AppInterface paramAppInterface, VideoDrawableHandler.OnGetFrameListener paramOnGetFrameListener)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler$OnGetFrameListener = paramOnGetFrameListener;
  }
  
  /* Error */
  public static Bitmap a(String paramString)
  {
    // Byte code:
    //   0: ldc 91
    //   2: invokestatic 97	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   5: astore_1
    //   6: aload_1
    //   7: invokevirtual 101	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   10: astore_2
    //   11: aload_1
    //   12: astore 4
    //   14: aload_2
    //   15: astore_3
    //   16: aload_1
    //   17: ldc 103
    //   19: iconst_1
    //   20: anewarray 93	java/lang/Class
    //   23: dup
    //   24: iconst_0
    //   25: ldc 105
    //   27: aastore
    //   28: invokevirtual 109	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   31: aload_2
    //   32: iconst_1
    //   33: anewarray 4	java/lang/Object
    //   36: dup
    //   37: iconst_0
    //   38: aload_0
    //   39: aastore
    //   40: invokevirtual 115	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   43: pop
    //   44: aload_1
    //   45: astore 4
    //   47: aload_2
    //   48: astore_3
    //   49: getstatic 120	android/os/Build$VERSION:SDK_INT	I
    //   52: bipush 9
    //   54: if_icmpgt +55 -> 109
    //   57: aload_1
    //   58: astore 4
    //   60: aload_2
    //   61: astore_3
    //   62: aload_1
    //   63: ldc 122
    //   65: iconst_0
    //   66: anewarray 93	java/lang/Class
    //   69: invokevirtual 109	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   72: aload_2
    //   73: iconst_0
    //   74: anewarray 4	java/lang/Object
    //   77: invokevirtual 115	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   80: checkcast 124	android/graphics/Bitmap
    //   83: astore_0
    //   84: aload_2
    //   85: ifnull +22 -> 107
    //   88: aload_1
    //   89: ldc 126
    //   91: iconst_0
    //   92: anewarray 93	java/lang/Class
    //   95: invokevirtual 109	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   98: aload_2
    //   99: iconst_0
    //   100: anewarray 4	java/lang/Object
    //   103: invokevirtual 115	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   106: pop
    //   107: aload_0
    //   108: areturn
    //   109: aload_1
    //   110: astore 4
    //   112: aload_2
    //   113: astore_3
    //   114: aload_1
    //   115: ldc 128
    //   117: iconst_0
    //   118: anewarray 93	java/lang/Class
    //   121: invokevirtual 109	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   124: aload_2
    //   125: iconst_0
    //   126: anewarray 4	java/lang/Object
    //   129: invokevirtual 115	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   132: checkcast 130	[B
    //   135: checkcast 130	[B
    //   138: astore 5
    //   140: aload 5
    //   142: ifnull +87 -> 229
    //   145: aload_1
    //   146: astore 4
    //   148: aload_2
    //   149: astore_3
    //   150: aload 5
    //   152: iconst_0
    //   153: aload 5
    //   155: arraylength
    //   156: invokestatic 136	android/graphics/BitmapFactory:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   159: astore 5
    //   161: aload 5
    //   163: astore_3
    //   164: goto +36 -> 200
    //   167: astore 5
    //   169: aload_1
    //   170: astore 4
    //   172: aload_2
    //   173: astore_3
    //   174: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   177: ifeq +21 -> 198
    //   180: aload_1
    //   181: astore 4
    //   183: aload_2
    //   184: astore_3
    //   185: ldc 144
    //   187: iconst_2
    //   188: aload 5
    //   190: invokevirtual 148	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   193: aload 5
    //   195: invokestatic 152	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   198: aconst_null
    //   199: astore_3
    //   200: aload_3
    //   201: ifnull +28 -> 229
    //   204: aload_2
    //   205: ifnull +22 -> 227
    //   208: aload_1
    //   209: ldc 126
    //   211: iconst_0
    //   212: anewarray 93	java/lang/Class
    //   215: invokevirtual 109	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   218: aload_2
    //   219: iconst_0
    //   220: anewarray 4	java/lang/Object
    //   223: invokevirtual 115	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   226: pop
    //   227: aload_3
    //   228: areturn
    //   229: aload_1
    //   230: astore 4
    //   232: aload_2
    //   233: astore_3
    //   234: aload_0
    //   235: iconst_1
    //   236: invokestatic 158	android/media/ThumbnailUtils:createVideoThumbnail	(Ljava/lang/String;I)Landroid/graphics/Bitmap;
    //   239: astore_0
    //   240: aload_0
    //   241: ifnull +28 -> 269
    //   244: aload_2
    //   245: ifnull +22 -> 267
    //   248: aload_1
    //   249: ldc 126
    //   251: iconst_0
    //   252: anewarray 93	java/lang/Class
    //   255: invokevirtual 109	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   258: aload_2
    //   259: iconst_0
    //   260: anewarray 4	java/lang/Object
    //   263: invokevirtual 115	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   266: pop
    //   267: aload_0
    //   268: areturn
    //   269: aload_1
    //   270: astore 4
    //   272: aload_2
    //   273: astore_3
    //   274: aload_1
    //   275: ldc 160
    //   277: iconst_0
    //   278: anewarray 93	java/lang/Class
    //   281: invokevirtual 109	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   284: aload_2
    //   285: iconst_0
    //   286: anewarray 4	java/lang/Object
    //   289: invokevirtual 115	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   292: checkcast 124	android/graphics/Bitmap
    //   295: astore_0
    //   296: aload_2
    //   297: ifnull +22 -> 319
    //   300: aload_1
    //   301: ldc 126
    //   303: iconst_0
    //   304: anewarray 93	java/lang/Class
    //   307: invokevirtual 109	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   310: aload_2
    //   311: iconst_0
    //   312: anewarray 4	java/lang/Object
    //   315: invokevirtual 115	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   318: pop
    //   319: aload_0
    //   320: areturn
    //   321: astore_0
    //   322: aload 4
    //   324: astore_1
    //   325: goto +297 -> 622
    //   328: astore_0
    //   329: goto +78 -> 407
    //   332: astore_0
    //   333: goto +118 -> 451
    //   336: astore_0
    //   337: goto +158 -> 495
    //   340: astore_0
    //   341: goto +198 -> 539
    //   344: astore_0
    //   345: goto +238 -> 583
    //   348: astore_0
    //   349: aconst_null
    //   350: astore_3
    //   351: goto +271 -> 622
    //   354: astore_0
    //   355: aconst_null
    //   356: astore_2
    //   357: goto +50 -> 407
    //   360: astore_0
    //   361: aconst_null
    //   362: astore_2
    //   363: goto +88 -> 451
    //   366: astore_0
    //   367: aconst_null
    //   368: astore_2
    //   369: goto +126 -> 495
    //   372: astore_0
    //   373: aconst_null
    //   374: astore_2
    //   375: goto +164 -> 539
    //   378: astore_0
    //   379: aconst_null
    //   380: astore_2
    //   381: goto +202 -> 583
    //   384: aconst_null
    //   385: astore_2
    //   386: goto +265 -> 651
    //   389: aconst_null
    //   390: astore_2
    //   391: goto +285 -> 676
    //   394: astore_0
    //   395: aconst_null
    //   396: astore_1
    //   397: aload_1
    //   398: astore_3
    //   399: goto +223 -> 622
    //   402: astore_0
    //   403: aconst_null
    //   404: astore_1
    //   405: aload_1
    //   406: astore_2
    //   407: aload_1
    //   408: astore 4
    //   410: aload_2
    //   411: astore_3
    //   412: ldc 144
    //   414: ldc 161
    //   416: aload_0
    //   417: invokestatic 167	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   420: pop
    //   421: aload_2
    //   422: ifnull +277 -> 699
    //   425: aload_1
    //   426: ldc 126
    //   428: iconst_0
    //   429: anewarray 93	java/lang/Class
    //   432: invokevirtual 109	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   435: aload_2
    //   436: iconst_0
    //   437: anewarray 4	java/lang/Object
    //   440: invokevirtual 115	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   443: pop
    //   444: aconst_null
    //   445: areturn
    //   446: astore_0
    //   447: aconst_null
    //   448: astore_1
    //   449: aload_1
    //   450: astore_2
    //   451: aload_1
    //   452: astore 4
    //   454: aload_2
    //   455: astore_3
    //   456: ldc 144
    //   458: ldc 161
    //   460: aload_0
    //   461: invokestatic 167	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   464: pop
    //   465: aload_2
    //   466: ifnull +233 -> 699
    //   469: aload_1
    //   470: ldc 126
    //   472: iconst_0
    //   473: anewarray 93	java/lang/Class
    //   476: invokevirtual 109	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   479: aload_2
    //   480: iconst_0
    //   481: anewarray 4	java/lang/Object
    //   484: invokevirtual 115	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   487: pop
    //   488: aconst_null
    //   489: areturn
    //   490: astore_0
    //   491: aconst_null
    //   492: astore_1
    //   493: aload_1
    //   494: astore_2
    //   495: aload_1
    //   496: astore 4
    //   498: aload_2
    //   499: astore_3
    //   500: ldc 144
    //   502: ldc 161
    //   504: aload_0
    //   505: invokestatic 167	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   508: pop
    //   509: aload_2
    //   510: ifnull +189 -> 699
    //   513: aload_1
    //   514: ldc 126
    //   516: iconst_0
    //   517: anewarray 93	java/lang/Class
    //   520: invokevirtual 109	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   523: aload_2
    //   524: iconst_0
    //   525: anewarray 4	java/lang/Object
    //   528: invokevirtual 115	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   531: pop
    //   532: aconst_null
    //   533: areturn
    //   534: astore_0
    //   535: aconst_null
    //   536: astore_1
    //   537: aload_1
    //   538: astore_2
    //   539: aload_1
    //   540: astore 4
    //   542: aload_2
    //   543: astore_3
    //   544: ldc 144
    //   546: ldc 161
    //   548: aload_0
    //   549: invokestatic 167	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   552: pop
    //   553: aload_2
    //   554: ifnull +145 -> 699
    //   557: aload_1
    //   558: ldc 126
    //   560: iconst_0
    //   561: anewarray 93	java/lang/Class
    //   564: invokevirtual 109	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   567: aload_2
    //   568: iconst_0
    //   569: anewarray 4	java/lang/Object
    //   572: invokevirtual 115	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   575: pop
    //   576: aconst_null
    //   577: areturn
    //   578: astore_0
    //   579: aconst_null
    //   580: astore_1
    //   581: aload_1
    //   582: astore_2
    //   583: aload_1
    //   584: astore 4
    //   586: aload_2
    //   587: astore_3
    //   588: ldc 144
    //   590: ldc 161
    //   592: aload_0
    //   593: invokestatic 167	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   596: pop
    //   597: aload_2
    //   598: ifnull +101 -> 699
    //   601: aload_1
    //   602: ldc 126
    //   604: iconst_0
    //   605: anewarray 93	java/lang/Class
    //   608: invokevirtual 109	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   611: aload_2
    //   612: iconst_0
    //   613: anewarray 4	java/lang/Object
    //   616: invokevirtual 115	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   619: pop
    //   620: aconst_null
    //   621: areturn
    //   622: aload_3
    //   623: ifnull +22 -> 645
    //   626: aload_1
    //   627: ldc 126
    //   629: iconst_0
    //   630: anewarray 93	java/lang/Class
    //   633: invokevirtual 109	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   636: aload_3
    //   637: iconst_0
    //   638: anewarray 4	java/lang/Object
    //   641: invokevirtual 115	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   644: pop
    //   645: aload_0
    //   646: athrow
    //   647: aconst_null
    //   648: astore_1
    //   649: aload_1
    //   650: astore_2
    //   651: aload_2
    //   652: ifnull +47 -> 699
    //   655: aload_1
    //   656: ldc 126
    //   658: iconst_0
    //   659: anewarray 93	java/lang/Class
    //   662: invokevirtual 109	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   665: aload_2
    //   666: iconst_0
    //   667: anewarray 4	java/lang/Object
    //   670: invokevirtual 115	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   673: pop
    //   674: aconst_null
    //   675: areturn
    //   676: aload_2
    //   677: ifnull +22 -> 699
    //   680: aload_1
    //   681: ldc 126
    //   683: iconst_0
    //   684: anewarray 93	java/lang/Class
    //   687: invokevirtual 109	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   690: aload_2
    //   691: iconst_0
    //   692: anewarray 4	java/lang/Object
    //   695: invokevirtual 115	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   698: pop
    //   699: aconst_null
    //   700: areturn
    //   701: astore_0
    //   702: goto +42 -> 744
    //   705: astore_0
    //   706: goto -59 -> 647
    //   709: astore_0
    //   710: goto -321 -> 389
    //   713: astore_0
    //   714: goto -330 -> 384
    //   717: astore_0
    //   718: goto -42 -> 676
    //   721: astore_0
    //   722: goto -71 -> 651
    //   725: astore_1
    //   726: aload_0
    //   727: areturn
    //   728: astore_0
    //   729: aload_3
    //   730: areturn
    //   731: astore_1
    //   732: aload_0
    //   733: areturn
    //   734: astore_1
    //   735: aload_0
    //   736: areturn
    //   737: astore_0
    //   738: aconst_null
    //   739: areturn
    //   740: astore_1
    //   741: goto -96 -> 645
    //   744: aconst_null
    //   745: astore_1
    //   746: aload_1
    //   747: astore_2
    //   748: goto -72 -> 676
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	751	0	paramString	String
    //   5	676	1	localObject1	Object
    //   725	1	1	localException1	Exception
    //   731	1	1	localException2	Exception
    //   734	1	1	localException3	Exception
    //   740	1	1	localException4	Exception
    //   745	2	1	localObject2	Object
    //   10	738	2	localObject3	Object
    //   15	715	3	localObject4	Object
    //   12	573	4	localObject5	Object
    //   138	24	5	localObject6	Object
    //   167	27	5	localOutOfMemoryError	OutOfMemoryError
    // Exception table:
    //   from	to	target	type
    //   150	161	167	java/lang/OutOfMemoryError
    //   16	44	321	finally
    //   49	57	321	finally
    //   62	84	321	finally
    //   114	140	321	finally
    //   150	161	321	finally
    //   174	180	321	finally
    //   185	198	321	finally
    //   234	240	321	finally
    //   274	296	321	finally
    //   412	421	321	finally
    //   456	465	321	finally
    //   500	509	321	finally
    //   544	553	321	finally
    //   588	597	321	finally
    //   16	44	328	java/lang/IllegalAccessException
    //   49	57	328	java/lang/IllegalAccessException
    //   62	84	328	java/lang/IllegalAccessException
    //   114	140	328	java/lang/IllegalAccessException
    //   150	161	328	java/lang/IllegalAccessException
    //   174	180	328	java/lang/IllegalAccessException
    //   185	198	328	java/lang/IllegalAccessException
    //   234	240	328	java/lang/IllegalAccessException
    //   274	296	328	java/lang/IllegalAccessException
    //   16	44	332	java/lang/NoSuchMethodException
    //   49	57	332	java/lang/NoSuchMethodException
    //   62	84	332	java/lang/NoSuchMethodException
    //   114	140	332	java/lang/NoSuchMethodException
    //   150	161	332	java/lang/NoSuchMethodException
    //   174	180	332	java/lang/NoSuchMethodException
    //   185	198	332	java/lang/NoSuchMethodException
    //   234	240	332	java/lang/NoSuchMethodException
    //   274	296	332	java/lang/NoSuchMethodException
    //   16	44	336	java/lang/ClassNotFoundException
    //   49	57	336	java/lang/ClassNotFoundException
    //   62	84	336	java/lang/ClassNotFoundException
    //   114	140	336	java/lang/ClassNotFoundException
    //   150	161	336	java/lang/ClassNotFoundException
    //   174	180	336	java/lang/ClassNotFoundException
    //   185	198	336	java/lang/ClassNotFoundException
    //   234	240	336	java/lang/ClassNotFoundException
    //   274	296	336	java/lang/ClassNotFoundException
    //   16	44	340	java/lang/reflect/InvocationTargetException
    //   49	57	340	java/lang/reflect/InvocationTargetException
    //   62	84	340	java/lang/reflect/InvocationTargetException
    //   114	140	340	java/lang/reflect/InvocationTargetException
    //   150	161	340	java/lang/reflect/InvocationTargetException
    //   174	180	340	java/lang/reflect/InvocationTargetException
    //   185	198	340	java/lang/reflect/InvocationTargetException
    //   234	240	340	java/lang/reflect/InvocationTargetException
    //   274	296	340	java/lang/reflect/InvocationTargetException
    //   16	44	344	java/lang/InstantiationException
    //   49	57	344	java/lang/InstantiationException
    //   62	84	344	java/lang/InstantiationException
    //   114	140	344	java/lang/InstantiationException
    //   150	161	344	java/lang/InstantiationException
    //   174	180	344	java/lang/InstantiationException
    //   185	198	344	java/lang/InstantiationException
    //   234	240	344	java/lang/InstantiationException
    //   274	296	344	java/lang/InstantiationException
    //   6	11	348	finally
    //   6	11	354	java/lang/IllegalAccessException
    //   6	11	360	java/lang/NoSuchMethodException
    //   6	11	366	java/lang/ClassNotFoundException
    //   6	11	372	java/lang/reflect/InvocationTargetException
    //   6	11	378	java/lang/InstantiationException
    //   0	6	394	finally
    //   0	6	402	java/lang/IllegalAccessException
    //   0	6	446	java/lang/NoSuchMethodException
    //   0	6	490	java/lang/ClassNotFoundException
    //   0	6	534	java/lang/reflect/InvocationTargetException
    //   0	6	578	java/lang/InstantiationException
    //   0	6	701	java/lang/IllegalArgumentException
    //   0	6	705	java/lang/RuntimeException
    //   6	11	709	java/lang/IllegalArgumentException
    //   6	11	713	java/lang/RuntimeException
    //   16	44	717	java/lang/IllegalArgumentException
    //   49	57	717	java/lang/IllegalArgumentException
    //   62	84	717	java/lang/IllegalArgumentException
    //   114	140	717	java/lang/IllegalArgumentException
    //   150	161	717	java/lang/IllegalArgumentException
    //   174	180	717	java/lang/IllegalArgumentException
    //   185	198	717	java/lang/IllegalArgumentException
    //   234	240	717	java/lang/IllegalArgumentException
    //   274	296	717	java/lang/IllegalArgumentException
    //   16	44	721	java/lang/RuntimeException
    //   49	57	721	java/lang/RuntimeException
    //   62	84	721	java/lang/RuntimeException
    //   114	140	721	java/lang/RuntimeException
    //   150	161	721	java/lang/RuntimeException
    //   174	180	721	java/lang/RuntimeException
    //   185	198	721	java/lang/RuntimeException
    //   234	240	721	java/lang/RuntimeException
    //   274	296	721	java/lang/RuntimeException
    //   88	107	725	java/lang/Exception
    //   208	227	728	java/lang/Exception
    //   248	267	731	java/lang/Exception
    //   300	319	734	java/lang/Exception
    //   425	444	737	java/lang/Exception
    //   469	488	737	java/lang/Exception
    //   513	532	737	java/lang/Exception
    //   557	576	737	java/lang/Exception
    //   601	620	737	java/lang/Exception
    //   655	674	737	java/lang/Exception
    //   680	699	737	java/lang/Exception
    //   626	645	740	java/lang/Exception
  }
  
  private void d()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    VideoDrawableHandler.DecodeFrameTask localDecodeFrameTask = (VideoDrawableHandler.DecodeFrameTask)this.jdField_a_of_type_JavaUtilLinkedList.poll();
    if (localDecodeFrameTask != null)
    {
      this.jdField_a_of_type_Boolean = false;
      ThreadManager.postImmediately(localDecodeFrameTask, null, true);
    }
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public Bitmap a()
  {
    return this.jdField_c_of_type_AndroidGraphicsBitmap;
  }
  
  @TargetApi(10)
  public Bitmap a(int paramInt)
  {
    Object localObject2 = this.jdField_a_of_type_AndroidMediaMediaMetadataRetriever;
    Object localObject1 = null;
    if (localObject2 == null) {
      return null;
    }
    int j;
    if (this.jdField_c_of_type_AndroidGraphicsBitmap != null) {
      j = jdField_c_of_type_Int | 0x0;
    } else {
      j = 0;
    }
    int k;
    if (d < 3)
    {
      try
      {
        localObject2 = this.jdField_a_of_type_AndroidMediaMediaMetadataRetriever.getFrameAtTime(paramInt * 1000, 2);
        if (localObject2 == null)
        {
          i = 1;
          localObject1 = localObject2;
        }
        else
        {
          i = 0;
          localObject1 = localObject2;
        }
      }
      catch (Throwable localThrowable1)
      {
        if (QLog.isColorLevel()) {
          QLog.i("VideoDrawableHandler", 2, localThrowable1.getMessage(), localThrowable1);
        }
        i = 2;
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        if (QLog.isColorLevel()) {
          QLog.i("VideoDrawableHandler", 2, localOutOfMemoryError1.getMessage(), localOutOfMemoryError1);
        }
        i = 3;
      }
      k = j;
      if (localObject1 != null) {
        k = j | jdField_a_of_type_Int;
      }
      j = k;
      k = i;
    }
    else
    {
      localObject1 = null;
      k = 0;
    }
    if ((k == 1) || (k == 2)) {
      d += 1;
    }
    int m;
    Object localObject3;
    int n;
    if ((localObject1 == null) && (k != 3))
    {
      try
      {
        Bitmap localBitmap = this.jdField_a_of_type_AndroidMediaMediaMetadataRetriever.getFrameAtTime(paramInt * 1000, 2);
        if (localBitmap == null)
        {
          i = 1;
          localObject1 = localBitmap;
        }
        else
        {
          i = 0;
          localObject1 = localBitmap;
        }
      }
      catch (Throwable localThrowable2)
      {
        if (QLog.isColorLevel()) {
          QLog.i("VideoDrawableHandler", 2, localThrowable2.getMessage(), localThrowable2);
        }
        i = 2;
      }
      catch (OutOfMemoryError localOutOfMemoryError2)
      {
        if (QLog.isColorLevel()) {
          QLog.i("VideoDrawableHandler", 2, localOutOfMemoryError2.getMessage(), localOutOfMemoryError2);
        }
        i = 3;
      }
      m = i;
      localObject3 = localObject1;
      n = j;
      if (localObject1 != null)
      {
        n = j | jdField_b_of_type_Int;
        m = i;
        localObject3 = localObject1;
      }
    }
    else
    {
      m = 0;
      n = j;
      localObject3 = localObject1;
    }
    int i = m << 2 | k;
    if (localObject3 == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getBitmapAt at:");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(" status:");
      ((StringBuilder)localObject1).append(n);
      ((StringBuilder)localObject1).append(" errorReason:");
      ((StringBuilder)localObject1).append(i);
      QLog.i("VideoDrawableHandler", 1, ((StringBuilder)localObject1).toString());
    }
    boolean bool;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getBitmapAt ");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(" failCount:");
      ((StringBuilder)localObject1).append(d);
      ((StringBuilder)localObject1).append(" bmp!=null:");
      if (localObject3 != null) {
        bool = true;
      } else {
        bool = false;
      }
      ((StringBuilder)localObject1).append(bool);
      ((StringBuilder)localObject1).append(" status:");
      ((StringBuilder)localObject1).append(n);
      ((StringBuilder)localObject1).append(" errorReason:");
      ((StringBuilder)localObject1).append(i);
      QLog.i("VideoDrawableHandler", 2, ((StringBuilder)localObject1).toString());
    }
    localObject1 = new HashMap();
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append(DeviceInfoUtil.f());
    ((StringBuilder)localObject4).append("");
    ((HashMap)localObject1).put("param_DeviceType", ((StringBuilder)localObject4).toString());
    localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append(k);
    ((StringBuilder)localObject4).append("");
    ((HashMap)localObject1).put("param_ErrorArbitary", ((StringBuilder)localObject4).toString());
    localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append(m);
    ((StringBuilder)localObject4).append("");
    ((HashMap)localObject1).put("param_ErrorKey", ((StringBuilder)localObject4).toString());
    localObject4 = StatisticCollector.getInstance(BaseApplicationImpl.getContext());
    String str = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
    if (localObject3 != null) {
      bool = true;
    } else {
      bool = false;
    }
    ((StatisticCollector)localObject4).collectPerformance(str, "CMD_EXTRACT_FRAME", bool, n, i, (HashMap)localObject1, "");
    return localObject3;
  }
  
  public void a()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilVector.size())
    {
      WeakReference localWeakReference = (WeakReference)this.jdField_a_of_type_JavaUtilVector.get(i);
      if ((localWeakReference != null) && (localWeakReference.get() != null)) {
        ((VideoDrawable)localWeakReference.get()).a(this.jdField_a_of_type_AndroidGraphicsBitmap);
      }
      i += 1;
    }
  }
  
  public void a(int paramInt)
  {
    VideoDrawableHandler.DecodeFrameTask localDecodeFrameTask = new VideoDrawableHandler.DecodeFrameTask(this, paramInt);
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilLinkedList.add(localDecodeFrameTask);
      if (this.jdField_a_of_type_JavaUtilLinkedList.size() > 2) {
        this.jdField_a_of_type_JavaUtilLinkedList.removeFirst();
      }
      d();
      return;
    }
  }
  
  public void a(VideoDrawable paramVideoDrawable)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (!this.jdField_a_of_type_JavaUtilVector.contains(paramVideoDrawable)) {
        this.jdField_a_of_type_JavaUtilVector.add(new WeakReference(paramVideoDrawable));
      }
      return;
    }
  }
  
  @TargetApi(10)
  public boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1;
    try
    {
      if (this.jdField_a_of_type_AndroidMediaMediaMetadataRetriever != null) {
        this.jdField_a_of_type_AndroidMediaMediaMetadataRetriever.release();
      }
      this.jdField_a_of_type_AndroidMediaMediaMetadataRetriever = new MediaMetadataRetriever();
      this.jdField_a_of_type_AndroidMediaMediaMetadataRetriever.setDataSource(paramString);
      this.jdField_a_of_type_Long = Long.valueOf(this.jdField_a_of_type_AndroidMediaMediaMetadataRetriever.extractMetadata(9)).longValue();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("duration:");
        localStringBuilder1.append(this.jdField_a_of_type_Long);
        QLog.i("VideoDrawableHandler", 2, localStringBuilder1.toString());
      }
      long l = this.jdField_a_of_type_Long;
      if (l > 0L) {
        bool1 = true;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("VideoDrawableHandler", 2, localException.getMessage(), localException);
      }
      bool1 = false;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("init suc:");
      localStringBuilder2.append(bool1);
      localStringBuilder2.append(" path:");
      localStringBuilder2.append(paramString);
      QLog.i("VideoDrawableHandler", 2, localStringBuilder2.toString());
    }
    if (bool1)
    {
      this.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_c_of_type_AndroidGraphicsBitmap = a(this.jdField_a_of_type_JavaLangString);
    }
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("init suc:");
    localStringBuilder2.append(bool1);
    localStringBuilder2.append(" thumb!=Null:");
    if (this.jdField_c_of_type_AndroidGraphicsBitmap != null) {
      bool2 = true;
    }
    localStringBuilder2.append(bool2);
    localStringBuilder2.append(" path:");
    localStringBuilder2.append(paramString);
    QLog.i("VideoDrawableHandler", 1, localStringBuilder2.toString());
    return bool1;
  }
  
  public void b()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilLinkedList.clear();
      return;
    }
  }
  
  @TargetApi(10)
  public void c()
  {
    b();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    MediaMetadataRetriever localMediaMetadataRetriever = this.jdField_a_of_type_AndroidMediaMediaMetadataRetriever;
    if (localMediaMetadataRetriever != null)
    {
      localMediaMetadataRetriever.release();
      this.jdField_a_of_type_AndroidMediaMediaMetadataRetriever = null;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0)
    {
      int i = paramMessage.arg1;
      paramMessage = this.jdField_a_of_type_JavaLangObject;
      if (i == 0) {}
      try
      {
        a();
        if ((this.jdField_b_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_b_of_type_AndroidGraphicsBitmap.isRecycled()) && (this.jdField_b_of_type_AndroidGraphicsBitmap != this.jdField_a_of_type_AndroidGraphicsBitmap) && (this.jdField_b_of_type_AndroidGraphicsBitmap != this.jdField_c_of_type_AndroidGraphicsBitmap)) {
          this.jdField_b_of_type_AndroidGraphicsBitmap.recycle();
        }
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("refresh. pending task size:");
          localStringBuilder.append(this.jdField_a_of_type_JavaUtilLinkedList.size());
          QLog.i("VideoDrawableHandler", 2, localStringBuilder.toString());
        }
        this.jdField_a_of_type_Boolean = true;
        d();
      }
      finally {}
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.videodrawable.VideoDrawableHandler
 * JD-Core Version:    0.7.0.1
 */
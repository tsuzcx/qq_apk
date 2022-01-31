package com.tencent.mobileqq.activity.aio.doodle;

import android.graphics.Rect;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.scribble.ScribbleMsgUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import uxo;
import uxq;
import uxu;

public class LoadDataJob
  implements Runnable
{
  private static final String jdField_b_of_type_JavaLangString = ScribbleMsgUtils.jdField_a_of_type_JavaLangString + "pclcache" + File.separator;
  private int jdField_a_of_type_Int;
  public String a;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private int jdField_b_of_type_Int;
  private int c;
  
  public LoadDataJob(String paramString, int paramInt1, int paramInt2, uxq paramuxq)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramuxq);
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  /* Error */
  private DoodleParam a(String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aconst_null
    //   3: astore 6
    //   5: aload_1
    //   6: invokestatic 67	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: ifeq +5 -> 14
    //   12: aconst_null
    //   13: areturn
    //   14: new 69	java/io/FileInputStream
    //   17: dup
    //   18: aload_1
    //   19: invokespecial 72	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   22: astore 7
    //   24: aload 7
    //   26: invokevirtual 76	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   29: lconst_0
    //   30: ldc2_w 77
    //   33: iconst_1
    //   34: invokevirtual 84	java/nio/channels/FileChannel:tryLock	(JJZ)Ljava/nio/channels/FileLock;
    //   37: astore 4
    //   39: aload 4
    //   41: astore 6
    //   43: aload 6
    //   45: ifnull +636 -> 681
    //   48: new 86	java/io/BufferedInputStream
    //   51: dup
    //   52: aload 7
    //   54: invokespecial 89	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   57: astore 5
    //   59: iconst_4
    //   60: newarray byte
    //   62: astore 4
    //   64: aload 5
    //   66: aload 4
    //   68: invokevirtual 95	java/io/InputStream:read	([B)I
    //   71: iconst_4
    //   72: if_icmpne +603 -> 675
    //   75: aload 4
    //   77: iconst_0
    //   78: invokestatic 100	com/tencent/mobileqq/activity/aio/doodle/DoodleMsgTranslator:a	([BI)I
    //   81: istore_3
    //   82: iload_3
    //   83: ifle +9 -> 92
    //   86: iload_3
    //   87: ldc 101
    //   89: if_icmplt +103 -> 192
    //   92: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   95: ifeq +28 -> 123
    //   98: ldc 109
    //   100: iconst_2
    //   101: new 16	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   108: ldc 111
    //   110: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: iload_3
    //   114: invokevirtual 114	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   117: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 118	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   123: iconst_0
    //   124: istore_2
    //   125: aconst_null
    //   126: astore 4
    //   128: aload 6
    //   130: ifnull +8 -> 138
    //   133: aload 6
    //   135: invokevirtual 123	java/nio/channels/FileLock:release	()V
    //   138: aload 7
    //   140: ifnull +8 -> 148
    //   143: aload 7
    //   145: invokevirtual 126	java/io/FileInputStream:close	()V
    //   148: aload 5
    //   150: ifnull +8 -> 158
    //   153: aload 5
    //   155: invokevirtual 127	java/io/InputStream:close	()V
    //   158: aload 4
    //   160: astore 5
    //   162: iload_2
    //   163: ifne +26 -> 189
    //   166: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   169: ifeq +11 -> 180
    //   172: ldc 109
    //   174: iconst_2
    //   175: ldc 129
    //   177: invokestatic 118	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   180: aload_1
    //   181: invokestatic 135	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;)Z
    //   184: pop
    //   185: aload 4
    //   187: astore 5
    //   189: aload 5
    //   191: areturn
    //   192: iload_3
    //   193: newarray byte
    //   195: astore 4
    //   197: aload 5
    //   199: aload 4
    //   201: iconst_0
    //   202: iload_3
    //   203: invokevirtual 138	java/io/InputStream:read	([BII)I
    //   206: iload_3
    //   207: if_icmpeq +37 -> 244
    //   210: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   213: ifeq +477 -> 690
    //   216: ldc 109
    //   218: iconst_2
    //   219: new 16	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   226: ldc 140
    //   228: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: iload_3
    //   232: invokevirtual 114	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   235: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   238: invokestatic 118	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   241: goto +449 -> 690
    //   244: aload_0
    //   245: aload 4
    //   247: invokevirtual 143	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob:a	([B)Lcom/tencent/mobileqq/activity/aio/doodle/MyParcel;
    //   250: astore 4
    //   252: aload 4
    //   254: ifnull +421 -> 675
    //   257: getstatic 148	com/tencent/mobileqq/activity/aio/doodle/DoodleParam:a	Lcom/tencent/mobileqq/activity/aio/doodle/MyParcelable$Creator;
    //   260: aload 4
    //   262: invokeinterface 153 2 0
    //   267: checkcast 145	com/tencent/mobileqq/activity/aio/doodle/DoodleParam
    //   270: astore 4
    //   272: goto -144 -> 128
    //   275: astore 5
    //   277: aload 5
    //   279: invokevirtual 156	java/lang/Exception:printStackTrace	()V
    //   282: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   285: ifeq -127 -> 158
    //   288: ldc 109
    //   290: iconst_2
    //   291: new 16	java/lang/StringBuilder
    //   294: dup
    //   295: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   298: ldc 158
    //   300: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: aload 5
    //   305: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   308: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   311: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   314: goto -156 -> 158
    //   317: astore 7
    //   319: aconst_null
    //   320: astore 6
    //   322: aconst_null
    //   323: astore 4
    //   325: aconst_null
    //   326: astore 5
    //   328: aload 7
    //   330: invokevirtual 156	java/lang/Exception:printStackTrace	()V
    //   333: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   336: ifeq +29 -> 365
    //   339: ldc 109
    //   341: iconst_2
    //   342: new 16	java/lang/StringBuilder
    //   345: dup
    //   346: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   349: ldc 165
    //   351: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: aload 7
    //   356: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   359: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   362: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   365: aload 6
    //   367: ifnull +8 -> 375
    //   370: aload 6
    //   372: invokevirtual 123	java/nio/channels/FileLock:release	()V
    //   375: aload 4
    //   377: ifnull +8 -> 385
    //   380: aload 4
    //   382: invokevirtual 126	java/io/FileInputStream:close	()V
    //   385: aload 5
    //   387: ifnull +8 -> 395
    //   390: aload 5
    //   392: invokevirtual 127	java/io/InputStream:close	()V
    //   395: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   398: ifeq +11 -> 409
    //   401: ldc 109
    //   403: iconst_2
    //   404: ldc 129
    //   406: invokestatic 118	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   409: aload_1
    //   410: invokestatic 135	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;)Z
    //   413: pop
    //   414: aconst_null
    //   415: astore 5
    //   417: goto -228 -> 189
    //   420: astore 4
    //   422: aload 4
    //   424: invokevirtual 156	java/lang/Exception:printStackTrace	()V
    //   427: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   430: ifeq -35 -> 395
    //   433: ldc 109
    //   435: iconst_2
    //   436: new 16	java/lang/StringBuilder
    //   439: dup
    //   440: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   443: ldc 158
    //   445: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: aload 4
    //   450: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   453: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   456: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   459: goto -64 -> 395
    //   462: astore 4
    //   464: iconst_1
    //   465: istore_2
    //   466: aconst_null
    //   467: astore 7
    //   469: aconst_null
    //   470: astore 5
    //   472: aload 6
    //   474: ifnull +8 -> 482
    //   477: aload 6
    //   479: invokevirtual 123	java/nio/channels/FileLock:release	()V
    //   482: aload 7
    //   484: ifnull +8 -> 492
    //   487: aload 7
    //   489: invokevirtual 126	java/io/FileInputStream:close	()V
    //   492: aload 5
    //   494: ifnull +8 -> 502
    //   497: aload 5
    //   499: invokevirtual 127	java/io/InputStream:close	()V
    //   502: iload_2
    //   503: ifne +22 -> 525
    //   506: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   509: ifeq +11 -> 520
    //   512: ldc 109
    //   514: iconst_2
    //   515: ldc 129
    //   517: invokestatic 118	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   520: aload_1
    //   521: invokestatic 135	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;)Z
    //   524: pop
    //   525: aload 4
    //   527: athrow
    //   528: astore 5
    //   530: aload 5
    //   532: invokevirtual 156	java/lang/Exception:printStackTrace	()V
    //   535: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   538: ifeq -36 -> 502
    //   541: ldc 109
    //   543: iconst_2
    //   544: new 16	java/lang/StringBuilder
    //   547: dup
    //   548: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   551: ldc 158
    //   553: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: aload 5
    //   558: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   561: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   564: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   567: goto -65 -> 502
    //   570: astore 4
    //   572: iconst_1
    //   573: istore_2
    //   574: aconst_null
    //   575: astore 5
    //   577: goto -105 -> 472
    //   580: astore 4
    //   582: aconst_null
    //   583: astore 5
    //   585: iconst_1
    //   586: istore_2
    //   587: goto -115 -> 472
    //   590: astore 4
    //   592: iconst_1
    //   593: istore_2
    //   594: goto -122 -> 472
    //   597: astore 8
    //   599: aload 4
    //   601: astore 7
    //   603: iconst_1
    //   604: istore_2
    //   605: aload 8
    //   607: astore 4
    //   609: goto -137 -> 472
    //   612: astore 8
    //   614: aload 4
    //   616: astore 7
    //   618: iconst_0
    //   619: istore_2
    //   620: aload 8
    //   622: astore 4
    //   624: goto -152 -> 472
    //   627: astore 8
    //   629: aconst_null
    //   630: astore 6
    //   632: aload 7
    //   634: astore 4
    //   636: aconst_null
    //   637: astore 5
    //   639: aload 8
    //   641: astore 7
    //   643: goto -315 -> 328
    //   646: astore 8
    //   648: aload 7
    //   650: astore 4
    //   652: aconst_null
    //   653: astore 5
    //   655: aload 8
    //   657: astore 7
    //   659: goto -331 -> 328
    //   662: astore 8
    //   664: aload 7
    //   666: astore 4
    //   668: aload 8
    //   670: astore 7
    //   672: goto -344 -> 328
    //   675: aconst_null
    //   676: astore 4
    //   678: goto -550 -> 128
    //   681: aconst_null
    //   682: astore 5
    //   684: aconst_null
    //   685: astore 4
    //   687: goto -559 -> 128
    //   690: iconst_0
    //   691: istore_2
    //   692: aconst_null
    //   693: astore 4
    //   695: goto -567 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	698	0	this	LoadDataJob
    //   0	698	1	paramString	String
    //   1	691	2	i	int
    //   81	151	3	j	int
    //   37	344	4	localObject1	Object
    //   420	29	4	localException1	Exception
    //   462	64	4	localObject2	Object
    //   570	1	4	localObject3	Object
    //   580	1	4	localObject4	Object
    //   590	10	4	localObject5	Object
    //   607	87	4	localObject6	Object
    //   57	141	5	localObject7	Object
    //   275	29	5	localException2	Exception
    //   326	172	5	localObject8	Object
    //   528	29	5	localException3	Exception
    //   575	108	5	localObject9	Object
    //   3	628	6	localObject10	Object
    //   22	122	7	localFileInputStream	java.io.FileInputStream
    //   317	38	7	localException4	Exception
    //   467	204	7	localObject11	Object
    //   597	9	8	localObject12	Object
    //   612	9	8	localObject13	Object
    //   627	13	8	localException5	Exception
    //   646	10	8	localException6	Exception
    //   662	7	8	localException7	Exception
    // Exception table:
    //   from	to	target	type
    //   133	138	275	java/lang/Exception
    //   143	148	275	java/lang/Exception
    //   153	158	275	java/lang/Exception
    //   14	24	317	java/lang/Exception
    //   370	375	420	java/lang/Exception
    //   380	385	420	java/lang/Exception
    //   390	395	420	java/lang/Exception
    //   14	24	462	finally
    //   477	482	528	java/lang/Exception
    //   487	492	528	java/lang/Exception
    //   497	502	528	java/lang/Exception
    //   24	39	570	finally
    //   48	59	580	finally
    //   59	82	590	finally
    //   92	123	590	finally
    //   192	241	590	finally
    //   244	252	590	finally
    //   257	272	590	finally
    //   328	333	597	finally
    //   333	365	612	finally
    //   24	39	627	java/lang/Exception
    //   48	59	646	java/lang/Exception
    //   59	82	662	java/lang/Exception
    //   92	123	662	java/lang/Exception
    //   192	241	662	java/lang/Exception
    //   244	252	662	java/lang/Exception
    //   257	272	662	java/lang/Exception
  }
  
  private String a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return null;
      try
      {
        paramString = jdField_b_of_type_JavaLangString + paramString.substring(paramString.lastIndexOf(File.separator) + 1, paramString.lastIndexOf('_')) + "_dwr";
        if (paramBoolean)
        {
          paramBoolean = FileUtils.a(paramString);
          if (paramBoolean) {
            return paramString;
          }
        }
        else
        {
          return paramString;
        }
      }
      catch (Exception paramString) {}
    }
    return null;
  }
  
  /* Error */
  private List a(String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_1
    //   3: invokestatic 67	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifeq +5 -> 11
    //   9: aconst_null
    //   10: areturn
    //   11: new 191	java/util/ArrayList
    //   14: dup
    //   15: invokespecial 192	java/util/ArrayList:<init>	()V
    //   18: astore 11
    //   20: aload_0
    //   21: iconst_1
    //   22: putfield 58	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob:c	I
    //   25: new 69	java/io/FileInputStream
    //   28: dup
    //   29: aload_1
    //   30: invokespecial 72	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   33: astore 7
    //   35: aload 7
    //   37: invokevirtual 76	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   40: lconst_0
    //   41: ldc2_w 77
    //   44: iconst_1
    //   45: invokevirtual 84	java/nio/channels/FileChannel:tryLock	(JJZ)Ljava/nio/channels/FileLock;
    //   48: astore 8
    //   50: aload 8
    //   52: ifnull +1111 -> 1163
    //   55: new 86	java/io/BufferedInputStream
    //   58: dup
    //   59: aload 7
    //   61: invokespecial 89	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   64: astore 6
    //   66: aload 6
    //   68: astore 5
    //   70: iconst_4
    //   71: newarray byte
    //   73: astore 9
    //   75: aload 6
    //   77: astore 5
    //   79: aload 6
    //   81: aload 9
    //   83: invokevirtual 95	java/io/InputStream:read	([B)I
    //   86: iconst_4
    //   87: if_icmpne +1071 -> 1158
    //   90: aload 6
    //   92: astore 5
    //   94: aload 9
    //   96: iconst_0
    //   97: invokestatic 100	com/tencent/mobileqq/activity/aio/doodle/DoodleMsgTranslator:a	([BI)I
    //   100: istore_3
    //   101: iload_3
    //   102: ifle +9 -> 111
    //   105: iload_3
    //   106: ldc 101
    //   108: if_icmplt +243 -> 351
    //   111: aload 6
    //   113: astore 5
    //   115: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   118: ifeq +32 -> 150
    //   121: aload 6
    //   123: astore 5
    //   125: ldc 109
    //   127: iconst_2
    //   128: new 16	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   135: ldc 194
    //   137: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: iload_3
    //   141: invokevirtual 114	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   144: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokestatic 118	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   150: iconst_0
    //   151: istore_2
    //   152: aload 6
    //   154: astore 5
    //   156: aload 11
    //   158: monitorenter
    //   159: aload_0
    //   160: aload_0
    //   161: getfield 58	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob:c	I
    //   164: iconst_1
    //   165: isub
    //   166: putfield 58	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob:c	I
    //   169: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   172: ifeq +46 -> 218
    //   175: ldc 109
    //   177: iconst_2
    //   178: new 16	java/lang/StringBuilder
    //   181: dup
    //   182: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   185: ldc 196
    //   187: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: aload_0
    //   191: getfield 58	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob:c	I
    //   194: invokevirtual 114	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   197: ldc 198
    //   199: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: aload 11
    //   204: invokeinterface 204 1 0
    //   209: invokevirtual 114	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   212: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   218: aload_0
    //   219: getfield 58	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob:c	I
    //   222: istore_3
    //   223: aload 11
    //   225: invokeinterface 204 1 0
    //   230: istore 4
    //   232: iload_3
    //   233: iload 4
    //   235: if_icmple +15 -> 250
    //   238: iload_2
    //   239: ifeq +11 -> 250
    //   242: aload 11
    //   244: ldc2_w 205
    //   247: invokevirtual 210	java/lang/Object:wait	(J)V
    //   250: aload 11
    //   252: new 212	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob$SortComparator
    //   255: dup
    //   256: aload_0
    //   257: invokespecial 215	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob$SortComparator:<init>	(Lcom/tencent/mobileqq/activity/aio/doodle/LoadDataJob;)V
    //   260: invokestatic 221	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   263: aload 11
    //   265: monitorexit
    //   266: aload 6
    //   268: astore 5
    //   270: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   273: ifeq +15 -> 288
    //   276: aload 6
    //   278: astore 5
    //   280: ldc 109
    //   282: iconst_2
    //   283: ldc 223
    //   285: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   288: aload 8
    //   290: ifnull +8 -> 298
    //   293: aload 8
    //   295: invokevirtual 123	java/nio/channels/FileLock:release	()V
    //   298: aload 7
    //   300: ifnull +8 -> 308
    //   303: aload 7
    //   305: invokevirtual 126	java/io/FileInputStream:close	()V
    //   308: aload 6
    //   310: ifnull +8 -> 318
    //   313: aload 6
    //   315: invokevirtual 127	java/io/InputStream:close	()V
    //   318: iload_2
    //   319: ifne +29 -> 348
    //   322: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   325: ifeq +11 -> 336
    //   328: ldc 109
    //   330: iconst_2
    //   331: ldc 225
    //   333: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   336: aload_1
    //   337: invokestatic 135	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;)Z
    //   340: pop
    //   341: aload 11
    //   343: invokeinterface 228 1 0
    //   348: aload 11
    //   350: areturn
    //   351: aload 6
    //   353: astore 5
    //   355: iload_3
    //   356: newarray byte
    //   358: astore 10
    //   360: aload 6
    //   362: astore 5
    //   364: aload 6
    //   366: aload 10
    //   368: iconst_0
    //   369: iload_3
    //   370: invokevirtual 138	java/io/InputStream:read	([BII)I
    //   373: iload_3
    //   374: if_icmpeq +45 -> 419
    //   377: aload 6
    //   379: astore 5
    //   381: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   384: ifeq +787 -> 1171
    //   387: aload 6
    //   389: astore 5
    //   391: ldc 109
    //   393: iconst_2
    //   394: new 16	java/lang/StringBuilder
    //   397: dup
    //   398: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   401: ldc 230
    //   403: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: iload_3
    //   407: invokevirtual 114	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   410: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   413: invokestatic 118	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   416: goto +755 -> 1171
    //   419: aload 6
    //   421: astore 5
    //   423: aload_0
    //   424: aload_0
    //   425: getfield 58	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob:c	I
    //   428: iconst_1
    //   429: iadd
    //   430: putfield 58	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob:c	I
    //   433: aload 6
    //   435: astore 5
    //   437: new 232	uxr
    //   440: dup
    //   441: aload_0
    //   442: aload 10
    //   444: new 234	uxp
    //   447: dup
    //   448: aload_0
    //   449: aload 11
    //   451: invokespecial 237	uxp:<init>	(Lcom/tencent/mobileqq/activity/aio/doodle/LoadDataJob;Ljava/util/List;)V
    //   454: invokespecial 240	uxr:<init>	(Lcom/tencent/mobileqq/activity/aio/doodle/LoadDataJob;[BLuxs;)V
    //   457: iconst_5
    //   458: aconst_null
    //   459: iconst_1
    //   460: invokestatic 246	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   463: goto -388 -> 75
    //   466: astore 9
    //   468: aload 5
    //   470: astore 6
    //   472: aload 8
    //   474: astore 5
    //   476: aload 7
    //   478: astore 8
    //   480: aload 6
    //   482: astore 7
    //   484: aload 8
    //   486: astore 6
    //   488: aload 9
    //   490: astore 8
    //   492: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   495: ifeq +32 -> 527
    //   498: ldc 109
    //   500: iconst_2
    //   501: new 16	java/lang/StringBuilder
    //   504: dup
    //   505: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   508: ldc 248
    //   510: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: aload 8
    //   515: invokevirtual 249	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   518: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   521: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   524: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   527: aload 5
    //   529: ifnull +8 -> 537
    //   532: aload 5
    //   534: invokevirtual 123	java/nio/channels/FileLock:release	()V
    //   537: aload 6
    //   539: ifnull +8 -> 547
    //   542: aload 6
    //   544: invokevirtual 126	java/io/FileInputStream:close	()V
    //   547: aload 7
    //   549: ifnull +8 -> 557
    //   552: aload 7
    //   554: invokevirtual 127	java/io/InputStream:close	()V
    //   557: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   560: ifeq +11 -> 571
    //   563: ldc 109
    //   565: iconst_2
    //   566: ldc 225
    //   568: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   571: aload_1
    //   572: invokestatic 135	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;)Z
    //   575: pop
    //   576: aload 11
    //   578: invokeinterface 228 1 0
    //   583: goto -235 -> 348
    //   586: astore 5
    //   588: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   591: ifeq -341 -> 250
    //   594: ldc 109
    //   596: iconst_2
    //   597: new 16	java/lang/StringBuilder
    //   600: dup
    //   601: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   604: ldc 251
    //   606: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   609: aload 5
    //   611: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   614: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   617: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   620: goto -370 -> 250
    //   623: astore 9
    //   625: aload 11
    //   627: monitorexit
    //   628: aload 6
    //   630: astore 5
    //   632: aload 9
    //   634: athrow
    //   635: astore 9
    //   637: aload 6
    //   639: astore 5
    //   641: aload 9
    //   643: astore 6
    //   645: aload 6
    //   647: invokevirtual 156	java/lang/Exception:printStackTrace	()V
    //   650: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   653: ifeq +29 -> 682
    //   656: ldc 109
    //   658: iconst_2
    //   659: new 16	java/lang/StringBuilder
    //   662: dup
    //   663: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   666: ldc 253
    //   668: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   671: aload 6
    //   673: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   676: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   679: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   682: aload 8
    //   684: ifnull +8 -> 692
    //   687: aload 8
    //   689: invokevirtual 123	java/nio/channels/FileLock:release	()V
    //   692: aload 7
    //   694: ifnull +8 -> 702
    //   697: aload 7
    //   699: invokevirtual 126	java/io/FileInputStream:close	()V
    //   702: aload 5
    //   704: ifnull +8 -> 712
    //   707: aload 5
    //   709: invokevirtual 127	java/io/InputStream:close	()V
    //   712: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   715: ifeq +11 -> 726
    //   718: ldc 109
    //   720: iconst_2
    //   721: ldc 225
    //   723: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   726: aload_1
    //   727: invokestatic 135	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;)Z
    //   730: pop
    //   731: aload 11
    //   733: invokeinterface 228 1 0
    //   738: goto -390 -> 348
    //   741: astore 5
    //   743: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   746: ifeq -428 -> 318
    //   749: ldc 109
    //   751: iconst_2
    //   752: new 16	java/lang/StringBuilder
    //   755: dup
    //   756: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   759: ldc 158
    //   761: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   764: aload 5
    //   766: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   769: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   772: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   775: goto -457 -> 318
    //   778: astore 5
    //   780: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   783: ifeq -226 -> 557
    //   786: ldc 109
    //   788: iconst_2
    //   789: new 16	java/lang/StringBuilder
    //   792: dup
    //   793: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   796: ldc 158
    //   798: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   801: aload 5
    //   803: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   806: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   809: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   812: goto -255 -> 557
    //   815: astore 5
    //   817: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   820: ifeq -108 -> 712
    //   823: ldc 109
    //   825: iconst_2
    //   826: new 16	java/lang/StringBuilder
    //   829: dup
    //   830: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   833: ldc 158
    //   835: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   838: aload 5
    //   840: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   843: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   846: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   849: goto -137 -> 712
    //   852: astore 5
    //   854: aconst_null
    //   855: astore 8
    //   857: aconst_null
    //   858: astore 7
    //   860: aconst_null
    //   861: astore 6
    //   863: aload 8
    //   865: ifnull +8 -> 873
    //   868: aload 8
    //   870: invokevirtual 123	java/nio/channels/FileLock:release	()V
    //   873: aload 7
    //   875: ifnull +8 -> 883
    //   878: aload 7
    //   880: invokevirtual 126	java/io/FileInputStream:close	()V
    //   883: aload 6
    //   885: ifnull +8 -> 893
    //   888: aload 6
    //   890: invokevirtual 127	java/io/InputStream:close	()V
    //   893: iload_2
    //   894: ifne +29 -> 923
    //   897: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   900: ifeq +11 -> 911
    //   903: ldc 109
    //   905: iconst_2
    //   906: ldc 225
    //   908: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   911: aload_1
    //   912: invokestatic 135	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;)Z
    //   915: pop
    //   916: aload 11
    //   918: invokeinterface 228 1 0
    //   923: aload 5
    //   925: athrow
    //   926: astore 6
    //   928: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   931: ifeq -38 -> 893
    //   934: ldc 109
    //   936: iconst_2
    //   937: new 16	java/lang/StringBuilder
    //   940: dup
    //   941: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   944: ldc 158
    //   946: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   949: aload 6
    //   951: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   954: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   957: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   960: goto -67 -> 893
    //   963: astore 5
    //   965: aconst_null
    //   966: astore 8
    //   968: aconst_null
    //   969: astore 6
    //   971: goto -108 -> 863
    //   974: astore 5
    //   976: aconst_null
    //   977: astore 6
    //   979: goto -116 -> 863
    //   982: astore 5
    //   984: goto -121 -> 863
    //   987: astore 5
    //   989: goto -126 -> 863
    //   992: astore 10
    //   994: iconst_0
    //   995: istore_2
    //   996: aload 6
    //   998: astore 9
    //   1000: aload 5
    //   1002: astore 8
    //   1004: aload 7
    //   1006: astore 6
    //   1008: aload 10
    //   1010: astore 5
    //   1012: aload 9
    //   1014: astore 7
    //   1016: goto -153 -> 863
    //   1019: astore 9
    //   1021: aload 5
    //   1023: astore 6
    //   1025: aload 9
    //   1027: astore 5
    //   1029: goto -166 -> 863
    //   1032: astore 9
    //   1034: iconst_0
    //   1035: istore_2
    //   1036: aload 5
    //   1038: astore 6
    //   1040: aload 9
    //   1042: astore 5
    //   1044: goto -181 -> 863
    //   1047: astore 6
    //   1049: aconst_null
    //   1050: astore 8
    //   1052: aconst_null
    //   1053: astore 7
    //   1055: aconst_null
    //   1056: astore 5
    //   1058: iconst_1
    //   1059: istore_2
    //   1060: goto -415 -> 645
    //   1063: astore 6
    //   1065: aconst_null
    //   1066: astore 8
    //   1068: aconst_null
    //   1069: astore 5
    //   1071: iconst_1
    //   1072: istore_2
    //   1073: goto -428 -> 645
    //   1076: astore 6
    //   1078: aconst_null
    //   1079: astore 5
    //   1081: iconst_1
    //   1082: istore_2
    //   1083: goto -438 -> 645
    //   1086: astore 9
    //   1088: aload 6
    //   1090: astore 5
    //   1092: iconst_1
    //   1093: istore_2
    //   1094: aload 9
    //   1096: astore 6
    //   1098: goto -453 -> 645
    //   1101: astore 8
    //   1103: aconst_null
    //   1104: astore 6
    //   1106: aconst_null
    //   1107: astore 7
    //   1109: aconst_null
    //   1110: astore 5
    //   1112: goto -620 -> 492
    //   1115: astore 8
    //   1117: aload 7
    //   1119: astore 6
    //   1121: aconst_null
    //   1122: astore 7
    //   1124: aconst_null
    //   1125: astore 5
    //   1127: goto -635 -> 492
    //   1130: astore 5
    //   1132: aconst_null
    //   1133: astore 9
    //   1135: aload 8
    //   1137: astore 6
    //   1139: aload 5
    //   1141: astore 8
    //   1143: aload 6
    //   1145: astore 5
    //   1147: aload 7
    //   1149: astore 6
    //   1151: aload 9
    //   1153: astore 7
    //   1155: goto -663 -> 492
    //   1158: iconst_1
    //   1159: istore_2
    //   1160: goto -1008 -> 152
    //   1163: iconst_1
    //   1164: istore_2
    //   1165: aconst_null
    //   1166: astore 6
    //   1168: goto -1016 -> 152
    //   1171: iconst_0
    //   1172: istore_2
    //   1173: goto -1021 -> 152
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1176	0	this	LoadDataJob
    //   0	1176	1	paramString	String
    //   1	1172	2	i	int
    //   100	307	3	j	int
    //   230	6	4	k	int
    //   68	465	5	localObject1	Object
    //   586	24	5	localException1	Exception
    //   630	78	5	localObject2	Object
    //   741	24	5	localException2	Exception
    //   778	24	5	localException3	Exception
    //   815	24	5	localException4	Exception
    //   852	72	5	localObject3	Object
    //   963	1	5	localObject4	Object
    //   974	1	5	localObject5	Object
    //   982	1	5	localObject6	Object
    //   987	14	5	localObject7	Object
    //   1010	116	5	localObject8	Object
    //   1130	10	5	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   1145	1	5	localObject9	Object
    //   64	825	6	localObject10	Object
    //   926	24	6	localException5	Exception
    //   969	70	6	localObject11	Object
    //   1047	1	6	localException6	Exception
    //   1063	1	6	localException7	Exception
    //   1076	13	6	localException8	Exception
    //   1096	71	6	localObject12	Object
    //   33	1121	7	localObject13	Object
    //   48	1019	8	localObject14	Object
    //   1101	1	8	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   1115	21	8	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   1141	1	8	localObject15	Object
    //   73	22	9	arrayOfByte1	byte[]
    //   466	23	9	localOutOfMemoryError4	java.lang.OutOfMemoryError
    //   623	10	9	localObject16	Object
    //   635	7	9	localException9	Exception
    //   998	15	9	localObject17	Object
    //   1019	7	9	localObject18	Object
    //   1032	9	9	localObject19	Object
    //   1086	9	9	localException10	Exception
    //   1133	19	9	localObject20	Object
    //   358	85	10	arrayOfByte2	byte[]
    //   992	17	10	localObject21	Object
    //   18	899	11	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   70	75	466	java/lang/OutOfMemoryError
    //   79	90	466	java/lang/OutOfMemoryError
    //   94	101	466	java/lang/OutOfMemoryError
    //   115	121	466	java/lang/OutOfMemoryError
    //   125	150	466	java/lang/OutOfMemoryError
    //   156	159	466	java/lang/OutOfMemoryError
    //   270	276	466	java/lang/OutOfMemoryError
    //   280	288	466	java/lang/OutOfMemoryError
    //   355	360	466	java/lang/OutOfMemoryError
    //   364	377	466	java/lang/OutOfMemoryError
    //   381	387	466	java/lang/OutOfMemoryError
    //   391	416	466	java/lang/OutOfMemoryError
    //   423	433	466	java/lang/OutOfMemoryError
    //   437	463	466	java/lang/OutOfMemoryError
    //   632	635	466	java/lang/OutOfMemoryError
    //   242	250	586	java/lang/Exception
    //   159	218	623	finally
    //   218	232	623	finally
    //   242	250	623	finally
    //   250	266	623	finally
    //   588	620	623	finally
    //   625	628	623	finally
    //   156	159	635	java/lang/Exception
    //   270	276	635	java/lang/Exception
    //   280	288	635	java/lang/Exception
    //   632	635	635	java/lang/Exception
    //   293	298	741	java/lang/Exception
    //   303	308	741	java/lang/Exception
    //   313	318	741	java/lang/Exception
    //   532	537	778	java/lang/Exception
    //   542	547	778	java/lang/Exception
    //   552	557	778	java/lang/Exception
    //   687	692	815	java/lang/Exception
    //   697	702	815	java/lang/Exception
    //   707	712	815	java/lang/Exception
    //   20	35	852	finally
    //   868	873	926	java/lang/Exception
    //   878	883	926	java/lang/Exception
    //   888	893	926	java/lang/Exception
    //   35	50	963	finally
    //   55	66	974	finally
    //   70	75	982	finally
    //   79	90	982	finally
    //   94	101	982	finally
    //   115	121	982	finally
    //   125	150	982	finally
    //   355	360	982	finally
    //   364	377	982	finally
    //   381	387	982	finally
    //   391	416	982	finally
    //   423	433	982	finally
    //   437	463	982	finally
    //   156	159	987	finally
    //   270	276	987	finally
    //   280	288	987	finally
    //   632	635	987	finally
    //   492	527	992	finally
    //   645	650	1019	finally
    //   650	682	1032	finally
    //   20	35	1047	java/lang/Exception
    //   35	50	1063	java/lang/Exception
    //   55	66	1076	java/lang/Exception
    //   70	75	1086	java/lang/Exception
    //   79	90	1086	java/lang/Exception
    //   94	101	1086	java/lang/Exception
    //   115	121	1086	java/lang/Exception
    //   125	150	1086	java/lang/Exception
    //   355	360	1086	java/lang/Exception
    //   364	377	1086	java/lang/Exception
    //   381	387	1086	java/lang/Exception
    //   391	416	1086	java/lang/Exception
    //   423	433	1086	java/lang/Exception
    //   437	463	1086	java/lang/Exception
    //   20	35	1101	java/lang/OutOfMemoryError
    //   35	50	1115	java/lang/OutOfMemoryError
    //   55	66	1130	java/lang/OutOfMemoryError
  }
  
  private List a(List paramList, Rect paramRect)
  {
    Object localObject1 = paramList.iterator();
    long l = 0L;
    Object localObject2;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (PathData)((Iterator)localObject1).next();
      if (((PathData)localObject2).b() == null) {
        break label251;
      }
      l = ((PathData)localObject2).b().a() + l;
    }
    label251:
    for (;;)
    {
      break;
      int i;
      int j;
      if (l <= 3000L)
      {
        i = 10;
        j = 30;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("LoadDataJob", 2, "setPathDatas params: totaltime:" + l + "  segmentLen:" + i + " timeInterval:" + j);
        }
        localObject1 = new ArrayList();
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject2 = new PathDrawer((PathData)paramList.next(), paramRect.width(), paramRect.height(), this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, i, j, 1.0F);
          if (localObject2 != null) {
            ((ArrayList)localObject1).add(localObject2);
          }
        }
        if (l <= 20000L)
        {
          i = 20;
          j = 37;
        }
        else
        {
          i = 50;
          j = 45;
        }
      }
      Collections.sort((List)localObject1, new LoadDataJob.SortComparator(this));
      return localObject1;
    }
  }
  
  private Map a(List paramList)
  {
    HashMap localHashMap = new HashMap();
    if (paramList == null) {
      return localHashMap;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      int i = ((PathDrawer)paramList.next()).a();
      if (i > 0) {
        if (!DoodleResHelper.a().b(0, i)) {
          localHashMap.put(Integer.valueOf(i), Integer.valueOf(4));
        } else {
          localHashMap.put(Integer.valueOf(i), Integer.valueOf(0));
        }
      }
    }
    return localHashMap;
  }
  
  private String b(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return null;
      try
      {
        paramString = jdField_b_of_type_JavaLangString + paramString.substring(paramString.lastIndexOf(File.separator) + 1, paramString.lastIndexOf('_')) + "_prm";
        if (paramBoolean)
        {
          paramBoolean = FileUtils.a(paramString);
          if (paramBoolean) {
            return paramString;
          }
        }
        else
        {
          return paramString;
        }
      }
      catch (Exception paramString) {}
    }
    return null;
  }
  
  public MyParcel a(byte[] paramArrayOfByte)
  {
    MyParcel localMyParcel = new MyParcel(0);
    localMyParcel.a(paramArrayOfByte, 0, paramArrayOfByte.length);
    return localMyParcel;
  }
  
  public uxu a(MyParcelable paramMyParcelable)
  {
    MyParcel localMyParcel = new MyParcel(102400);
    paramMyParcelable.a(localMyParcel, 0);
    return localMyParcel.a();
  }
  
  /* Error */
  public void a(DoodleParam paramDoodleParam, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore_3
    //   5: aconst_null
    //   6: astore 4
    //   8: aconst_null
    //   9: astore 9
    //   11: aconst_null
    //   12: astore 8
    //   14: aconst_null
    //   15: astore 7
    //   17: aload_1
    //   18: ifnull +10 -> 28
    //   21: aload_2
    //   22: invokestatic 67	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   25: ifeq +4 -> 29
    //   28: return
    //   29: aload_2
    //   30: invokestatic 186	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Z
    //   33: ifne -5 -> 28
    //   36: new 16	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   43: aload_2
    //   44: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: ldc_w 360
    //   50: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: astore 10
    //   58: new 362	java/io/FileOutputStream
    //   61: dup
    //   62: aload 10
    //   64: invokespecial 363	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   67: astore 5
    //   69: aload 4
    //   71: astore_3
    //   72: aload 5
    //   74: astore 4
    //   76: aload 9
    //   78: astore 6
    //   80: aload 8
    //   82: astore 7
    //   84: aload 5
    //   86: invokevirtual 364	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   89: invokevirtual 367	java/nio/channels/FileChannel:tryLock	()Ljava/nio/channels/FileLock;
    //   92: astore 8
    //   94: aload 8
    //   96: ifnull +105 -> 201
    //   99: aload 8
    //   101: astore_3
    //   102: aload 5
    //   104: astore 4
    //   106: aload 8
    //   108: astore 6
    //   110: aload 8
    //   112: astore 7
    //   114: aload 5
    //   116: invokevirtual 364	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   119: lconst_0
    //   120: invokevirtual 371	java/nio/channels/FileChannel:position	(J)Ljava/nio/channels/FileChannel;
    //   123: pop
    //   124: aload 8
    //   126: astore_3
    //   127: aload 5
    //   129: astore 4
    //   131: aload 8
    //   133: astore 6
    //   135: aload 8
    //   137: astore 7
    //   139: aload_0
    //   140: aload_1
    //   141: invokevirtual 373	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob:a	(Lcom/tencent/mobileqq/activity/aio/doodle/MyParcelable;)Luxu;
    //   144: astore_1
    //   145: aload 8
    //   147: astore_3
    //   148: aload 5
    //   150: astore 4
    //   152: aload 8
    //   154: astore 6
    //   156: aload 8
    //   158: astore 7
    //   160: aload 5
    //   162: aload_1
    //   163: getfield 376	uxu:jdField_a_of_type_Int	I
    //   166: invokestatic 379	com/tencent/mobileqq/activity/aio/doodle/DoodleMsgTranslator:a	(I)[B
    //   169: invokevirtual 383	java/io/FileOutputStream:write	([B)V
    //   172: aload 8
    //   174: astore_3
    //   175: aload 5
    //   177: astore 4
    //   179: aload 8
    //   181: astore 6
    //   183: aload 8
    //   185: astore 7
    //   187: aload 5
    //   189: aload_1
    //   190: getfield 386	uxu:jdField_a_of_type_ArrayOfByte	[B
    //   193: iconst_0
    //   194: aload_1
    //   195: getfield 376	uxu:jdField_a_of_type_Int	I
    //   198: invokevirtual 388	java/io/FileOutputStream:write	([BII)V
    //   201: aload 8
    //   203: ifnull +8 -> 211
    //   206: aload 8
    //   208: invokevirtual 123	java/nio/channels/FileLock:release	()V
    //   211: aload 5
    //   213: ifnull +8 -> 221
    //   216: aload 5
    //   218: invokevirtual 389	java/io/FileOutputStream:close	()V
    //   221: aload 10
    //   223: aload_2
    //   224: invokestatic 392	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   227: pop
    //   228: return
    //   229: astore_1
    //   230: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   233: ifeq -12 -> 221
    //   236: ldc 109
    //   238: iconst_2
    //   239: new 16	java/lang/StringBuilder
    //   242: dup
    //   243: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   246: ldc_w 394
    //   249: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: aload_1
    //   253: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   256: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: invokestatic 118	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   262: goto -41 -> 221
    //   265: astore_1
    //   266: aconst_null
    //   267: astore 5
    //   269: aload 7
    //   271: astore_3
    //   272: aload 5
    //   274: astore 4
    //   276: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   279: ifeq +36 -> 315
    //   282: aload 7
    //   284: astore_3
    //   285: aload 5
    //   287: astore 4
    //   289: ldc 109
    //   291: iconst_2
    //   292: new 16	java/lang/StringBuilder
    //   295: dup
    //   296: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   299: ldc_w 396
    //   302: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: aload_1
    //   306: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   309: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   312: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   315: aload 7
    //   317: ifnull +8 -> 325
    //   320: aload 7
    //   322: invokevirtual 123	java/nio/channels/FileLock:release	()V
    //   325: aload 5
    //   327: ifnull +8 -> 335
    //   330: aload 5
    //   332: invokevirtual 389	java/io/FileOutputStream:close	()V
    //   335: aload 10
    //   337: aload_2
    //   338: invokestatic 392	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   341: pop
    //   342: return
    //   343: astore_1
    //   344: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   347: ifeq -12 -> 335
    //   350: ldc 109
    //   352: iconst_2
    //   353: new 16	java/lang/StringBuilder
    //   356: dup
    //   357: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   360: ldc_w 394
    //   363: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: aload_1
    //   367: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   370: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   373: invokestatic 118	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   376: goto -41 -> 335
    //   379: astore_1
    //   380: aconst_null
    //   381: astore 5
    //   383: aload 6
    //   385: astore_3
    //   386: aload 5
    //   388: astore 4
    //   390: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   393: ifeq +36 -> 429
    //   396: aload 6
    //   398: astore_3
    //   399: aload 5
    //   401: astore 4
    //   403: ldc 109
    //   405: iconst_2
    //   406: new 16	java/lang/StringBuilder
    //   409: dup
    //   410: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   413: ldc_w 398
    //   416: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: aload_1
    //   420: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   423: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   426: invokestatic 118	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   429: aload 6
    //   431: ifnull +8 -> 439
    //   434: aload 6
    //   436: invokevirtual 123	java/nio/channels/FileLock:release	()V
    //   439: aload 5
    //   441: ifnull +8 -> 449
    //   444: aload 5
    //   446: invokevirtual 389	java/io/FileOutputStream:close	()V
    //   449: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   452: ifeq -424 -> 28
    //   455: ldc 109
    //   457: iconst_2
    //   458: ldc_w 400
    //   461: invokestatic 118	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   464: return
    //   465: astore_1
    //   466: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   469: ifeq -20 -> 449
    //   472: ldc 109
    //   474: iconst_2
    //   475: new 16	java/lang/StringBuilder
    //   478: dup
    //   479: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   482: ldc_w 394
    //   485: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   488: aload_1
    //   489: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   492: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   495: invokestatic 118	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   498: goto -49 -> 449
    //   501: astore_1
    //   502: aconst_null
    //   503: astore 4
    //   505: aload_3
    //   506: ifnull +7 -> 513
    //   509: aload_3
    //   510: invokevirtual 123	java/nio/channels/FileLock:release	()V
    //   513: aload 4
    //   515: ifnull +8 -> 523
    //   518: aload 4
    //   520: invokevirtual 389	java/io/FileOutputStream:close	()V
    //   523: aload 10
    //   525: aload_2
    //   526: invokestatic 392	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   529: pop
    //   530: aload_1
    //   531: athrow
    //   532: astore_3
    //   533: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   536: ifeq -13 -> 523
    //   539: ldc 109
    //   541: iconst_2
    //   542: new 16	java/lang/StringBuilder
    //   545: dup
    //   546: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   549: ldc_w 394
    //   552: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: aload_3
    //   556: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   559: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   562: invokestatic 118	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   565: goto -42 -> 523
    //   568: astore_1
    //   569: goto -64 -> 505
    //   572: astore_1
    //   573: goto -190 -> 383
    //   576: astore_1
    //   577: goto -308 -> 269
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	580	0	this	LoadDataJob
    //   0	580	1	paramDoodleParam	DoodleParam
    //   0	580	2	paramString	String
    //   4	506	3	localObject1	Object
    //   532	24	3	localException	Exception
    //   6	513	4	localObject2	Object
    //   67	378	5	localFileOutputStream	java.io.FileOutputStream
    //   1	434	6	localObject3	Object
    //   15	306	7	localFileLock1	java.nio.channels.FileLock
    //   12	195	8	localFileLock2	java.nio.channels.FileLock
    //   9	68	9	localObject4	Object
    //   56	468	10	str	String
    // Exception table:
    //   from	to	target	type
    //   206	211	229	java/lang/Exception
    //   216	221	229	java/lang/Exception
    //   58	69	265	java/nio/channels/OverlappingFileLockException
    //   320	325	343	java/lang/Exception
    //   330	335	343	java/lang/Exception
    //   58	69	379	java/lang/Exception
    //   434	439	465	java/lang/Exception
    //   444	449	465	java/lang/Exception
    //   58	69	501	finally
    //   509	513	532	java/lang/Exception
    //   518	523	532	java/lang/Exception
    //   84	94	568	finally
    //   114	124	568	finally
    //   139	145	568	finally
    //   160	172	568	finally
    //   187	201	568	finally
    //   276	282	568	finally
    //   289	315	568	finally
    //   390	396	568	finally
    //   403	429	568	finally
    //   84	94	572	java/lang/Exception
    //   114	124	572	java/lang/Exception
    //   139	145	572	java/lang/Exception
    //   160	172	572	java/lang/Exception
    //   187	201	572	java/lang/Exception
    //   84	94	576	java/nio/channels/OverlappingFileLockException
    //   114	124	576	java/nio/channels/OverlappingFileLockException
    //   139	145	576	java/nio/channels/OverlappingFileLockException
    //   160	172	576	java/nio/channels/OverlappingFileLockException
    //   187	201	576	java/nio/channels/OverlappingFileLockException
  }
  
  /* Error */
  public boolean a(List paramList, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore 9
    //   9: aconst_null
    //   10: astore 10
    //   12: aconst_null
    //   13: astore 6
    //   15: aload_1
    //   16: ifnull +19 -> 35
    //   19: aload_1
    //   20: invokeinterface 204 1 0
    //   25: ifeq +10 -> 35
    //   28: aload_2
    //   29: invokestatic 67	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   32: ifeq +5 -> 37
    //   35: iconst_0
    //   36: ireturn
    //   37: aload_2
    //   38: invokestatic 186	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Z
    //   41: ifne -6 -> 35
    //   44: new 16	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   51: aload_2
    //   52: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: ldc_w 360
    //   58: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: astore 11
    //   66: new 362	java/io/FileOutputStream
    //   69: dup
    //   70: aload 11
    //   72: iconst_0
    //   73: invokespecial 404	java/io/FileOutputStream:<init>	(Ljava/lang/String;Z)V
    //   76: astore 4
    //   78: aload 9
    //   80: astore 5
    //   82: aload 4
    //   84: astore 7
    //   86: aload 10
    //   88: astore 8
    //   90: aload 4
    //   92: invokevirtual 364	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   95: astore 12
    //   97: aload 9
    //   99: astore 5
    //   101: aload 4
    //   103: astore 7
    //   105: aload 10
    //   107: astore 8
    //   109: aload 12
    //   111: invokevirtual 367	java/nio/channels/FileChannel:tryLock	()Ljava/nio/channels/FileLock;
    //   114: astore 6
    //   116: aload 6
    //   118: ifnull +220 -> 338
    //   121: aload 6
    //   123: astore 5
    //   125: aload 4
    //   127: astore 7
    //   129: aload 6
    //   131: astore 8
    //   133: aload 12
    //   135: lconst_0
    //   136: invokevirtual 371	java/nio/channels/FileChannel:position	(J)Ljava/nio/channels/FileChannel;
    //   139: pop
    //   140: aload 6
    //   142: astore 5
    //   144: aload 4
    //   146: astore 7
    //   148: aload 6
    //   150: astore 8
    //   152: aload_1
    //   153: invokeinterface 258 1 0
    //   158: astore_1
    //   159: aload 6
    //   161: astore 5
    //   163: aload 4
    //   165: astore 7
    //   167: aload 6
    //   169: astore 8
    //   171: aload_1
    //   172: invokeinterface 263 1 0
    //   177: ifeq +161 -> 338
    //   180: aload 6
    //   182: astore 5
    //   184: aload 4
    //   186: astore 7
    //   188: aload 6
    //   190: astore 8
    //   192: aload_0
    //   193: aload_1
    //   194: invokeinterface 267 1 0
    //   199: checkcast 290	com/tencent/mobileqq/activity/aio/doodle/PathDrawer
    //   202: invokevirtual 373	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob:a	(Lcom/tencent/mobileqq/activity/aio/doodle/MyParcelable;)Luxu;
    //   205: astore 9
    //   207: aload 6
    //   209: astore 5
    //   211: aload 4
    //   213: astore 7
    //   215: aload 6
    //   217: astore 8
    //   219: aload 4
    //   221: aload 9
    //   223: getfield 376	uxu:jdField_a_of_type_Int	I
    //   226: invokestatic 379	com/tencent/mobileqq/activity/aio/doodle/DoodleMsgTranslator:a	(I)[B
    //   229: invokevirtual 383	java/io/FileOutputStream:write	([B)V
    //   232: aload 6
    //   234: astore 5
    //   236: aload 4
    //   238: astore 7
    //   240: aload 6
    //   242: astore 8
    //   244: aload 4
    //   246: aload 9
    //   248: getfield 386	uxu:jdField_a_of_type_ArrayOfByte	[B
    //   251: iconst_0
    //   252: aload 9
    //   254: getfield 376	uxu:jdField_a_of_type_Int	I
    //   257: invokevirtual 388	java/io/FileOutputStream:write	([BII)V
    //   260: goto -101 -> 159
    //   263: astore 5
    //   265: aload 6
    //   267: astore_1
    //   268: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   271: ifeq +30 -> 301
    //   274: ldc 109
    //   276: iconst_2
    //   277: new 16	java/lang/StringBuilder
    //   280: dup
    //   281: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   284: ldc_w 406
    //   287: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: aload 5
    //   292: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   295: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   298: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   301: aload_1
    //   302: ifnull +7 -> 309
    //   305: aload_1
    //   306: invokevirtual 123	java/nio/channels/FileLock:release	()V
    //   309: aload 4
    //   311: ifnull +8 -> 319
    //   314: aload 4
    //   316: invokevirtual 389	java/io/FileOutputStream:close	()V
    //   319: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   322: ifeq +360 -> 682
    //   325: ldc 109
    //   327: iconst_2
    //   328: ldc_w 408
    //   331: invokestatic 118	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   334: iconst_0
    //   335: istore_3
    //   336: iload_3
    //   337: ireturn
    //   338: aload 6
    //   340: ifnull +8 -> 348
    //   343: aload 6
    //   345: invokevirtual 123	java/nio/channels/FileLock:release	()V
    //   348: aload 4
    //   350: ifnull +8 -> 358
    //   353: aload 4
    //   355: invokevirtual 389	java/io/FileOutputStream:close	()V
    //   358: aload 11
    //   360: aload_2
    //   361: invokestatic 392	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   364: pop
    //   365: iconst_1
    //   366: istore_3
    //   367: goto -31 -> 336
    //   370: astore_1
    //   371: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   374: ifeq -16 -> 358
    //   377: ldc 109
    //   379: iconst_2
    //   380: new 16	java/lang/StringBuilder
    //   383: dup
    //   384: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   387: ldc_w 410
    //   390: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: aload_1
    //   394: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   397: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   400: invokestatic 118	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   403: goto -45 -> 358
    //   406: astore_1
    //   407: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   410: ifeq -91 -> 319
    //   413: ldc 109
    //   415: iconst_2
    //   416: new 16	java/lang/StringBuilder
    //   419: dup
    //   420: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   423: ldc_w 410
    //   426: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: aload_1
    //   430: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   433: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   436: invokestatic 118	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   439: goto -120 -> 319
    //   442: astore_1
    //   443: aconst_null
    //   444: astore 4
    //   446: aload 8
    //   448: astore 5
    //   450: aload 4
    //   452: astore 7
    //   454: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   457: ifeq +37 -> 494
    //   460: aload 8
    //   462: astore 5
    //   464: aload 4
    //   466: astore 7
    //   468: ldc 109
    //   470: iconst_2
    //   471: new 16	java/lang/StringBuilder
    //   474: dup
    //   475: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   478: ldc_w 412
    //   481: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: aload_1
    //   485: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   488: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   491: invokestatic 118	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   494: aload 8
    //   496: ifnull +8 -> 504
    //   499: aload 8
    //   501: invokevirtual 123	java/nio/channels/FileLock:release	()V
    //   504: aload 4
    //   506: ifnull +8 -> 514
    //   509: aload 4
    //   511: invokevirtual 389	java/io/FileOutputStream:close	()V
    //   514: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   517: ifeq +165 -> 682
    //   520: ldc 109
    //   522: iconst_2
    //   523: ldc_w 408
    //   526: invokestatic 118	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   529: iconst_0
    //   530: istore_3
    //   531: goto -195 -> 336
    //   534: astore_1
    //   535: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   538: ifeq -24 -> 514
    //   541: ldc 109
    //   543: iconst_2
    //   544: new 16	java/lang/StringBuilder
    //   547: dup
    //   548: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   551: ldc_w 410
    //   554: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   557: aload_1
    //   558: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   561: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   564: invokestatic 118	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   567: goto -53 -> 514
    //   570: astore_1
    //   571: aconst_null
    //   572: astore 7
    //   574: aload 5
    //   576: ifnull +8 -> 584
    //   579: aload 5
    //   581: invokevirtual 123	java/nio/channels/FileLock:release	()V
    //   584: aload 7
    //   586: ifnull +8 -> 594
    //   589: aload 7
    //   591: invokevirtual 389	java/io/FileOutputStream:close	()V
    //   594: aload 11
    //   596: aload_2
    //   597: invokestatic 392	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   600: pop
    //   601: aload_1
    //   602: athrow
    //   603: astore 4
    //   605: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   608: ifeq -14 -> 594
    //   611: ldc 109
    //   613: iconst_2
    //   614: new 16	java/lang/StringBuilder
    //   617: dup
    //   618: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   621: ldc_w 410
    //   624: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   627: aload 4
    //   629: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   632: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   635: invokestatic 118	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   638: goto -44 -> 594
    //   641: astore_1
    //   642: goto -68 -> 574
    //   645: astore 6
    //   647: aload_1
    //   648: astore 5
    //   650: aload 6
    //   652: astore_1
    //   653: aload 4
    //   655: astore 7
    //   657: goto -83 -> 574
    //   660: astore_1
    //   661: goto -215 -> 446
    //   664: astore 5
    //   666: aconst_null
    //   667: astore_1
    //   668: aload 6
    //   670: astore 4
    //   672: goto -404 -> 268
    //   675: astore 5
    //   677: aconst_null
    //   678: astore_1
    //   679: goto -411 -> 268
    //   682: iconst_0
    //   683: istore_3
    //   684: goto -348 -> 336
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	687	0	this	LoadDataJob
    //   0	687	1	paramList	List
    //   0	687	2	paramString	String
    //   335	349	3	bool	boolean
    //   76	434	4	localFileOutputStream	java.io.FileOutputStream
    //   603	51	4	localException	Exception
    //   670	1	4	localObject1	Object
    //   4	231	5	localObject2	Object
    //   263	28	5	localOverlappingFileLockException1	java.nio.channels.OverlappingFileLockException
    //   448	201	5	localObject3	Object
    //   664	1	5	localOverlappingFileLockException2	java.nio.channels.OverlappingFileLockException
    //   675	1	5	localOverlappingFileLockException3	java.nio.channels.OverlappingFileLockException
    //   13	331	6	localFileLock	java.nio.channels.FileLock
    //   645	24	6	localObject4	Object
    //   84	572	7	localObject5	Object
    //   1	499	8	localObject6	Object
    //   7	246	9	localuxu	uxu
    //   10	96	10	localObject7	Object
    //   64	531	11	str	String
    //   95	39	12	localFileChannel	java.nio.channels.FileChannel
    // Exception table:
    //   from	to	target	type
    //   133	140	263	java/nio/channels/OverlappingFileLockException
    //   152	159	263	java/nio/channels/OverlappingFileLockException
    //   171	180	263	java/nio/channels/OverlappingFileLockException
    //   192	207	263	java/nio/channels/OverlappingFileLockException
    //   219	232	263	java/nio/channels/OverlappingFileLockException
    //   244	260	263	java/nio/channels/OverlappingFileLockException
    //   343	348	370	java/lang/Exception
    //   353	358	370	java/lang/Exception
    //   305	309	406	java/lang/Exception
    //   314	319	406	java/lang/Exception
    //   66	78	442	java/lang/Exception
    //   499	504	534	java/lang/Exception
    //   509	514	534	java/lang/Exception
    //   66	78	570	finally
    //   579	584	603	java/lang/Exception
    //   589	594	603	java/lang/Exception
    //   90	97	641	finally
    //   109	116	641	finally
    //   133	140	641	finally
    //   152	159	641	finally
    //   171	180	641	finally
    //   192	207	641	finally
    //   219	232	641	finally
    //   244	260	641	finally
    //   454	460	641	finally
    //   468	494	641	finally
    //   268	301	645	finally
    //   90	97	660	java/lang/Exception
    //   109	116	660	java/lang/Exception
    //   133	140	660	java/lang/Exception
    //   152	159	660	java/lang/Exception
    //   171	180	660	java/lang/Exception
    //   192	207	660	java/lang/Exception
    //   219	232	660	java/lang/Exception
    //   244	260	660	java/lang/Exception
    //   66	78	664	java/nio/channels/OverlappingFileLockException
    //   90	97	675	java/nio/channels/OverlappingFileLockException
    //   109	116	675	java/nio/channels/OverlappingFileLockException
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoadDataJob", 2, "run  begin");
    }
    Object localObject1 = new File(jdField_b_of_type_JavaLangString);
    if (!((File)localObject1).exists()) {
      ((File)localObject1).mkdirs();
    }
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {}
    for (uxq localuxq = (uxq)this.jdField_a_of_type_JavaLangRefWeakReference.get();; localuxq = null)
    {
      if (localuxq == null) {
        QLog.d("LoadDataJob", 2, "mListener == null");
      }
      label662:
      for (;;)
      {
        return;
        if (this.jdField_a_of_type_JavaLangString == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("LoadDataJob", 2, "file == null");
          }
          localuxq.a(null, 4, null, null, null);
          return;
        }
        if (!localuxq.a(this.jdField_a_of_type_JavaLangString))
        {
          if (QLog.isColorLevel()) {
            QLog.d("LoadDataJob", 2, "onCheck  false");
          }
        }
        else
        {
          Object localObject3 = a(this.jdField_a_of_type_JavaLangString, true);
          Object localObject2 = b(this.jdField_a_of_type_JavaLangString, true);
          if (localuxq.a(this.jdField_a_of_type_JavaLangString))
          {
            Object localObject4;
            label243:
            PathDrawer localPathDrawer;
            if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (!TextUtils.isEmpty((CharSequence)localObject2)))
            {
              if (QLog.isColorLevel()) {
                QLog.d("LoadDataJob", 2, "run  read parcel begin");
              }
              localObject1 = a((String)localObject3);
              if (!localuxq.a(this.jdField_a_of_type_JavaLangString)) {
                continue;
              }
              if (localObject1 != null)
              {
                localObject4 = ((List)localObject1).iterator();
                if (((Iterator)localObject4).hasNext())
                {
                  localPathDrawer = (PathDrawer)((Iterator)localObject4).next();
                  if ((localPathDrawer == null) || (!localPathDrawer.a()))
                  {
                    FileUtils.d((String)localObject3);
                    localObject1 = null;
                    label287:
                    localObject2 = a((String)localObject2);
                    if (QLog.isColorLevel()) {
                      QLog.d("LoadDataJob", 2, "run  read parcel end");
                    }
                  }
                }
              }
            }
            for (;;)
            {
              if (!localuxq.a(this.jdField_a_of_type_JavaLangString)) {
                break label662;
              }
              if ((localObject1 != null) && (localObject2 != null))
              {
                localObject3 = localObject1;
                if (((List)localObject1).size() != 0) {}
              }
              else
              {
                if (QLog.isColorLevel()) {
                  QLog.d("LoadDataJob", 2, "run load file begin:");
                }
                long l1 = System.currentTimeMillis();
                localObject2 = DoodleMsgTranslator.a(this.jdField_a_of_type_JavaLangString);
                if (localObject2 == null)
                {
                  localuxq.a(this.jdField_a_of_type_JavaLangString, 4, null, null, null);
                  return;
                  localPathDrawer.a(0, 0, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
                  break label243;
                }
                localObject1 = ((DoodleItem)localObject2).a();
                if (!localuxq.a(this.jdField_a_of_type_JavaLangString)) {
                  break;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("LoadDataJob", 2, "run setpathdata ");
                }
                localObject4 = a(((DoodleItem)localObject2).a(), ((DoodleItem)localObject2).a().a());
                long l2 = System.currentTimeMillis();
                if (!localuxq.a(this.jdField_a_of_type_JavaLangString)) {
                  break;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("LoadDataJob", 2, "run load data time:" + (l2 - l1));
                }
                if (l2 - l1 > 100L)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("LoadDataJob", 2, "need cache:");
                  }
                  ThreadManager.post(new uxo(this, (DoodleParam)localObject1, (List)localObject4), 5, null, false);
                }
                localObject2 = localObject1;
                localObject3 = localObject4;
                if (QLog.isColorLevel())
                {
                  QLog.d("LoadDataJob", 2, "run load file end:");
                  localObject3 = localObject4;
                  localObject2 = localObject1;
                }
              }
              if (!localuxq.a(this.jdField_a_of_type_JavaLangString)) {
                break;
              }
              localObject1 = a((List)localObject3);
              localuxq.a(this.jdField_a_of_type_JavaLangString, 0, (DoodleParam)localObject2, (List)localObject3, (Map)localObject1);
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("LoadDataJob", 2, "run  end");
              return;
              break label287;
              localObject2 = null;
              localObject1 = null;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.LoadDataJob
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity.aio.doodle;

import aevb;
import aevh;
import aevu;
import aevw;
import aewc;
import aewd;
import aewg;
import aewh;
import aewi;
import aewl;
import aewm;
import aewp;
import android.graphics.Rect;
import android.text.TextUtils;
import aycc;
import bdcs;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LoadDataJob
  implements Runnable
{
  private static final String jdField_b_of_type_JavaLangString = aycc.a() + "pclcache" + File.separator;
  final int jdField_a_of_type_Int = 3;
  public String a;
  private WeakReference<aewc> jdField_a_of_type_JavaLangRefWeakReference;
  private int jdField_b_of_type_Int;
  private int c;
  private int d;
  
  public LoadDataJob(String paramString, int paramInt1, int paramInt2, aewc paramaewc)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramaewc);
    this.jdField_b_of_type_Int = paramInt1;
    this.c = paramInt2;
  }
  
  /* Error */
  private aevu a(String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aconst_null
    //   3: astore 6
    //   5: aload_1
    //   6: invokestatic 72	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: ifeq +5 -> 14
    //   12: aconst_null
    //   13: areturn
    //   14: new 74	java/io/FileInputStream
    //   17: dup
    //   18: aload_1
    //   19: invokespecial 77	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   22: astore 7
    //   24: aload 7
    //   26: invokevirtual 81	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   29: lconst_0
    //   30: ldc2_w 82
    //   33: iconst_1
    //   34: invokevirtual 89	java/nio/channels/FileChannel:tryLock	(JJZ)Ljava/nio/channels/FileLock;
    //   37: astore 4
    //   39: aload 4
    //   41: astore 6
    //   43: aload 6
    //   45: ifnull +636 -> 681
    //   48: new 91	java/io/BufferedInputStream
    //   51: dup
    //   52: aload 7
    //   54: invokespecial 94	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   57: astore 5
    //   59: iconst_4
    //   60: newarray byte
    //   62: astore 4
    //   64: aload 5
    //   66: aload 4
    //   68: invokevirtual 100	java/io/InputStream:read	([B)I
    //   71: iconst_4
    //   72: if_icmpne +603 -> 675
    //   75: aload 4
    //   77: iconst_0
    //   78: invokestatic 105	aevh:a	([BI)I
    //   81: istore_3
    //   82: iload_3
    //   83: ifle +9 -> 92
    //   86: iload_3
    //   87: ldc 106
    //   89: if_icmplt +103 -> 192
    //   92: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   95: ifeq +28 -> 123
    //   98: ldc 114
    //   100: iconst_2
    //   101: new 18	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   108: ldc 116
    //   110: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: iload_3
    //   114: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   117: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   123: iconst_0
    //   124: istore_2
    //   125: aconst_null
    //   126: astore 4
    //   128: aload 6
    //   130: ifnull +8 -> 138
    //   133: aload 6
    //   135: invokevirtual 128	java/nio/channels/FileLock:release	()V
    //   138: aload 7
    //   140: ifnull +8 -> 148
    //   143: aload 7
    //   145: invokevirtual 131	java/io/FileInputStream:close	()V
    //   148: aload 5
    //   150: ifnull +8 -> 158
    //   153: aload 5
    //   155: invokevirtual 132	java/io/InputStream:close	()V
    //   158: aload 4
    //   160: astore 5
    //   162: iload_2
    //   163: ifne +26 -> 189
    //   166: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   169: ifeq +11 -> 180
    //   172: ldc 114
    //   174: iconst_2
    //   175: ldc 134
    //   177: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   180: aload_1
    //   181: invokestatic 139	bdcs:d	(Ljava/lang/String;)Z
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
    //   203: invokevirtual 142	java/io/InputStream:read	([BII)I
    //   206: iload_3
    //   207: if_icmpeq +37 -> 244
    //   210: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   213: ifeq +477 -> 690
    //   216: ldc 114
    //   218: iconst_2
    //   219: new 18	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   226: ldc 144
    //   228: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: iload_3
    //   232: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   235: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   238: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   241: goto +449 -> 690
    //   244: aload_0
    //   245: aload 4
    //   247: invokevirtual 147	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob:a	([B)Laewg;
    //   250: astore 4
    //   252: aload 4
    //   254: ifnull +421 -> 675
    //   257: getstatic 152	aevu:a	Laewj;
    //   260: aload 4
    //   262: invokeinterface 157 2 0
    //   267: checkcast 149	aevu
    //   270: astore 4
    //   272: goto -144 -> 128
    //   275: astore 5
    //   277: aload 5
    //   279: invokevirtual 160	java/lang/Exception:printStackTrace	()V
    //   282: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   285: ifeq -127 -> 158
    //   288: ldc 114
    //   290: iconst_2
    //   291: new 18	java/lang/StringBuilder
    //   294: dup
    //   295: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   298: ldc 162
    //   300: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: aload 5
    //   305: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   308: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   311: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   314: goto -156 -> 158
    //   317: astore 7
    //   319: aconst_null
    //   320: astore 6
    //   322: aconst_null
    //   323: astore 4
    //   325: aconst_null
    //   326: astore 5
    //   328: aload 7
    //   330: invokevirtual 160	java/lang/Exception:printStackTrace	()V
    //   333: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   336: ifeq +29 -> 365
    //   339: ldc 114
    //   341: iconst_2
    //   342: new 18	java/lang/StringBuilder
    //   345: dup
    //   346: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   349: ldc 169
    //   351: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: aload 7
    //   356: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   359: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   362: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   365: aload 6
    //   367: ifnull +8 -> 375
    //   370: aload 6
    //   372: invokevirtual 128	java/nio/channels/FileLock:release	()V
    //   375: aload 4
    //   377: ifnull +8 -> 385
    //   380: aload 4
    //   382: invokevirtual 131	java/io/FileInputStream:close	()V
    //   385: aload 5
    //   387: ifnull +8 -> 395
    //   390: aload 5
    //   392: invokevirtual 132	java/io/InputStream:close	()V
    //   395: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   398: ifeq +11 -> 409
    //   401: ldc 114
    //   403: iconst_2
    //   404: ldc 134
    //   406: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   409: aload_1
    //   410: invokestatic 139	bdcs:d	(Ljava/lang/String;)Z
    //   413: pop
    //   414: aconst_null
    //   415: astore 5
    //   417: goto -228 -> 189
    //   420: astore 4
    //   422: aload 4
    //   424: invokevirtual 160	java/lang/Exception:printStackTrace	()V
    //   427: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   430: ifeq -35 -> 395
    //   433: ldc 114
    //   435: iconst_2
    //   436: new 18	java/lang/StringBuilder
    //   439: dup
    //   440: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   443: ldc 162
    //   445: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: aload 4
    //   450: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   453: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   456: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   479: invokevirtual 128	java/nio/channels/FileLock:release	()V
    //   482: aload 7
    //   484: ifnull +8 -> 492
    //   487: aload 7
    //   489: invokevirtual 131	java/io/FileInputStream:close	()V
    //   492: aload 5
    //   494: ifnull +8 -> 502
    //   497: aload 5
    //   499: invokevirtual 132	java/io/InputStream:close	()V
    //   502: iload_2
    //   503: ifne +22 -> 525
    //   506: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   509: ifeq +11 -> 520
    //   512: ldc 114
    //   514: iconst_2
    //   515: ldc 134
    //   517: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   520: aload_1
    //   521: invokestatic 139	bdcs:d	(Ljava/lang/String;)Z
    //   524: pop
    //   525: aload 4
    //   527: athrow
    //   528: astore 5
    //   530: aload 5
    //   532: invokevirtual 160	java/lang/Exception:printStackTrace	()V
    //   535: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   538: ifeq -36 -> 502
    //   541: ldc 114
    //   543: iconst_2
    //   544: new 18	java/lang/StringBuilder
    //   547: dup
    //   548: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   551: ldc 162
    //   553: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: aload 5
    //   558: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   561: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   564: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
          paramBoolean = bdcs.a(paramString);
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
  private List<aewp> a(String paramString, aewc paramaewc)
  {
    // Byte code:
    //   0: new 195	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 196	java/util/ArrayList:<init>	()V
    //   7: astore 14
    //   9: aload_1
    //   10: invokestatic 72	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifeq +6 -> 19
    //   16: aload 14
    //   18: areturn
    //   19: iconst_1
    //   20: istore 5
    //   22: iconst_1
    //   23: istore 7
    //   25: iconst_0
    //   26: istore 6
    //   28: new 198	java/util/HashMap
    //   31: dup
    //   32: invokespecial 199	java/util/HashMap:<init>	()V
    //   35: astore 15
    //   37: aload_0
    //   38: iconst_1
    //   39: putfield 63	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob:d	I
    //   42: new 74	java/io/FileInputStream
    //   45: dup
    //   46: aload_1
    //   47: invokespecial 77	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   50: astore 8
    //   52: aload 8
    //   54: invokevirtual 81	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   57: lconst_0
    //   58: ldc2_w 82
    //   61: iconst_1
    //   62: invokevirtual 89	java/nio/channels/FileChannel:tryLock	(JJZ)Ljava/nio/channels/FileLock;
    //   65: astore 9
    //   67: aload 9
    //   69: ifnull +2033 -> 2102
    //   72: new 91	java/io/BufferedInputStream
    //   75: dup
    //   76: aload 8
    //   78: invokespecial 94	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   81: astore 10
    //   83: aload 9
    //   85: astore 11
    //   87: aload 10
    //   89: astore 12
    //   91: aload 8
    //   93: astore 13
    //   95: iload 7
    //   97: istore 5
    //   99: iconst_4
    //   100: newarray byte
    //   102: astore 16
    //   104: iconst_0
    //   105: istore_3
    //   106: aload 9
    //   108: astore 11
    //   110: aload 10
    //   112: astore 12
    //   114: aload 8
    //   116: astore 13
    //   118: iload 7
    //   120: istore 5
    //   122: aload 10
    //   124: aload 16
    //   126: invokevirtual 100	java/io/InputStream:read	([B)I
    //   129: iconst_4
    //   130: if_icmpne +1945 -> 2075
    //   133: aload 9
    //   135: astore 11
    //   137: aload 10
    //   139: astore 12
    //   141: aload 8
    //   143: astore 13
    //   145: iload 7
    //   147: istore 5
    //   149: aload 16
    //   151: iconst_0
    //   152: invokestatic 105	aevh:a	([BI)I
    //   155: istore 4
    //   157: iload 4
    //   159: ifle +10 -> 169
    //   162: iload 4
    //   164: ldc 106
    //   166: if_icmplt +319 -> 485
    //   169: aload 9
    //   171: astore 11
    //   173: aload 10
    //   175: astore 12
    //   177: aload 8
    //   179: astore 13
    //   181: iload 7
    //   183: istore 5
    //   185: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   188: ifeq +45 -> 233
    //   191: aload 9
    //   193: astore 11
    //   195: aload 10
    //   197: astore 12
    //   199: aload 8
    //   201: astore 13
    //   203: iload 7
    //   205: istore 5
    //   207: ldc 114
    //   209: iconst_2
    //   210: new 18	java/lang/StringBuilder
    //   213: dup
    //   214: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   217: ldc 201
    //   219: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: iload 4
    //   224: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   227: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   233: iconst_0
    //   234: istore 5
    //   236: aload 10
    //   238: astore_2
    //   239: iconst_0
    //   240: istore 6
    //   242: aload 14
    //   244: monitorenter
    //   245: aload_0
    //   246: aload_0
    //   247: getfield 63	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob:d	I
    //   250: iconst_1
    //   251: isub
    //   252: putfield 63	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob:d	I
    //   255: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   258: ifeq +66 -> 324
    //   261: ldc 114
    //   263: iconst_2
    //   264: new 18	java/lang/StringBuilder
    //   267: dup
    //   268: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   271: ldc 203
    //   273: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: aload_0
    //   277: getfield 63	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob:d	I
    //   280: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   283: ldc 205
    //   285: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: aload 14
    //   290: invokeinterface 211 1 0
    //   295: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   298: ldc 213
    //   300: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: iload 6
    //   305: invokevirtual 216	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   308: ldc 218
    //   310: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: iload 5
    //   315: invokevirtual 216	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   318: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   321: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   324: aload_0
    //   325: getfield 63	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob:d	I
    //   328: istore_3
    //   329: aload 14
    //   331: invokeinterface 211 1 0
    //   336: istore 4
    //   338: iload_3
    //   339: iload 4
    //   341: if_icmple +16 -> 357
    //   344: iload 6
    //   346: ifeq +11 -> 357
    //   349: aload 14
    //   351: ldc2_w 219
    //   354: invokevirtual 224	java/lang/Object:wait	(J)V
    //   357: aload 14
    //   359: invokeinterface 211 1 0
    //   364: ifle +16 -> 380
    //   367: aload 14
    //   369: new 226	aewd
    //   372: dup
    //   373: aload_0
    //   374: invokespecial 229	aewd:<init>	(Lcom/tencent/mobileqq/activity/aio/doodle/LoadDataJob;)V
    //   377: invokestatic 235	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   380: aload 14
    //   382: monitorexit
    //   383: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   386: ifeq +11 -> 397
    //   389: ldc 114
    //   391: iconst_2
    //   392: ldc 237
    //   394: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   397: aload 9
    //   399: ifnull +8 -> 407
    //   402: aload 9
    //   404: invokevirtual 128	java/nio/channels/FileLock:release	()V
    //   407: aload 8
    //   409: ifnull +8 -> 417
    //   412: aload 8
    //   414: invokevirtual 131	java/io/FileInputStream:close	()V
    //   417: aload_2
    //   418: ifnull +7 -> 425
    //   421: aload_2
    //   422: invokevirtual 132	java/io/InputStream:close	()V
    //   425: iload 5
    //   427: istore 7
    //   429: iload 6
    //   431: ifne +33 -> 464
    //   434: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   437: ifeq +11 -> 448
    //   440: ldc 114
    //   442: iconst_2
    //   443: ldc 239
    //   445: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   448: aload_1
    //   449: invokestatic 139	bdcs:d	(Ljava/lang/String;)Z
    //   452: pop
    //   453: aload 14
    //   455: invokeinterface 242 1 0
    //   460: iload 5
    //   462: istore 7
    //   464: iload 7
    //   466: ifeq +1433 -> 1899
    //   469: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   472: ifeq +11 -> 483
    //   475: ldc 114
    //   477: iconst_2
    //   478: ldc 244
    //   480: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   483: aconst_null
    //   484: areturn
    //   485: aload 9
    //   487: astore 11
    //   489: aload 10
    //   491: astore 12
    //   493: aload 8
    //   495: astore 13
    //   497: iload 7
    //   499: istore 5
    //   501: iload 4
    //   503: newarray byte
    //   505: astore 17
    //   507: aload 9
    //   509: astore 11
    //   511: aload 10
    //   513: astore 12
    //   515: aload 8
    //   517: astore 13
    //   519: iload 7
    //   521: istore 5
    //   523: aload 10
    //   525: aload 17
    //   527: iconst_0
    //   528: iload 4
    //   530: invokevirtual 142	java/io/InputStream:read	([BII)I
    //   533: iload 4
    //   535: if_icmpeq +70 -> 605
    //   538: aload 9
    //   540: astore 11
    //   542: aload 10
    //   544: astore 12
    //   546: aload 8
    //   548: astore 13
    //   550: iload 7
    //   552: istore 5
    //   554: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   557: ifeq +1556 -> 2113
    //   560: aload 9
    //   562: astore 11
    //   564: aload 10
    //   566: astore 12
    //   568: aload 8
    //   570: astore 13
    //   572: iload 7
    //   574: istore 5
    //   576: ldc 114
    //   578: iconst_2
    //   579: new 18	java/lang/StringBuilder
    //   582: dup
    //   583: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   586: ldc 246
    //   588: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   591: iload 4
    //   593: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   596: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   599: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   602: goto +1511 -> 2113
    //   605: aload 9
    //   607: astore 11
    //   609: aload 10
    //   611: astore 12
    //   613: aload 8
    //   615: astore 13
    //   617: iload 7
    //   619: istore 5
    //   621: new 248	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob$UnmarshallJob
    //   624: dup
    //   625: aload_0
    //   626: iload_3
    //   627: aload 17
    //   629: new 250	aewb
    //   632: dup
    //   633: aload_0
    //   634: aload 15
    //   636: aload 14
    //   638: invokespecial 253	aewb:<init>	(Lcom/tencent/mobileqq/activity/aio/doodle/LoadDataJob;Ljava/util/Map;Ljava/util/List;)V
    //   641: invokespecial 256	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob$UnmarshallJob:<init>	(Lcom/tencent/mobileqq/activity/aio/doodle/LoadDataJob;I[BLaewe;)V
    //   644: astore 17
    //   646: aload 9
    //   648: astore 11
    //   650: aload 10
    //   652: astore 12
    //   654: aload 8
    //   656: astore 13
    //   658: iload 7
    //   660: istore 5
    //   662: aload 15
    //   664: monitorenter
    //   665: aload 15
    //   667: invokeinterface 259 1 0
    //   672: istore 4
    //   674: iload 4
    //   676: iconst_3
    //   677: if_icmple +49 -> 726
    //   680: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   683: ifeq +35 -> 718
    //   686: ldc 114
    //   688: iconst_2
    //   689: new 18	java/lang/StringBuilder
    //   692: dup
    //   693: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   696: ldc_w 261
    //   699: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   702: aload 15
    //   704: invokeinterface 259 1 0
    //   709: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   712: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   715: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   718: aload 15
    //   720: ldc2_w 262
    //   723: invokevirtual 224	java/lang/Object:wait	(J)V
    //   726: aload 15
    //   728: monitorexit
    //   729: aload 9
    //   731: astore 11
    //   733: aload 10
    //   735: astore 12
    //   737: aload 8
    //   739: astore 13
    //   741: iload 7
    //   743: istore 5
    //   745: aload_2
    //   746: aload_0
    //   747: getfield 49	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   750: invokeinterface 266 2 0
    //   755: ifne +682 -> 1437
    //   758: aload 9
    //   760: astore 11
    //   762: aload 10
    //   764: astore 12
    //   766: aload 8
    //   768: astore 13
    //   770: iload 7
    //   772: istore 5
    //   774: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   777: ifeq +28 -> 805
    //   780: aload 9
    //   782: astore 11
    //   784: aload 10
    //   786: astore 12
    //   788: aload 8
    //   790: astore 13
    //   792: iload 7
    //   794: istore 5
    //   796: ldc 114
    //   798: iconst_2
    //   799: ldc_w 268
    //   802: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   805: iconst_0
    //   806: istore_3
    //   807: aload 9
    //   809: astore 11
    //   811: aload 10
    //   813: astore 12
    //   815: aload 8
    //   817: astore 13
    //   819: iload 7
    //   821: istore 5
    //   823: aload 15
    //   825: monitorenter
    //   826: aload 15
    //   828: invokeinterface 272 1 0
    //   833: invokeinterface 278 1 0
    //   838: astore_2
    //   839: aload_2
    //   840: invokeinterface 283 1 0
    //   845: ifeq +203 -> 1048
    //   848: aload_2
    //   849: invokeinterface 287 1 0
    //   854: checkcast 248	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob$UnmarshallJob
    //   857: bipush 16
    //   859: invokestatic 293	com/tencent/mobileqq/app/ThreadManager:removeJobFromThreadPool	(Ljava/lang/Runnable;I)Z
    //   862: istore 5
    //   864: iload 5
    //   866: ifeq +1233 -> 2099
    //   869: iload_3
    //   870: iconst_1
    //   871: iadd
    //   872: istore_3
    //   873: goto -34 -> 839
    //   876: astore 11
    //   878: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   881: ifeq -155 -> 726
    //   884: ldc 114
    //   886: iconst_2
    //   887: new 18	java/lang/StringBuilder
    //   890: dup
    //   891: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   894: ldc_w 295
    //   897: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   900: aload 11
    //   902: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   905: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   908: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   911: goto -185 -> 726
    //   914: astore_2
    //   915: aload 15
    //   917: monitorexit
    //   918: aload 9
    //   920: astore 11
    //   922: aload 10
    //   924: astore 12
    //   926: aload 8
    //   928: astore 13
    //   930: iload 7
    //   932: istore 5
    //   934: aload_2
    //   935: athrow
    //   936: astore 11
    //   938: iconst_0
    //   939: istore 5
    //   941: aload 9
    //   943: astore_2
    //   944: aload 11
    //   946: astore 9
    //   948: iconst_0
    //   949: istore 6
    //   951: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   954: ifeq +33 -> 987
    //   957: ldc 114
    //   959: iconst_2
    //   960: new 18	java/lang/StringBuilder
    //   963: dup
    //   964: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   967: ldc_w 297
    //   970: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   973: aload 9
    //   975: invokevirtual 298	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   978: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   981: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   984: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   987: aload_2
    //   988: ifnull +7 -> 995
    //   991: aload_2
    //   992: invokevirtual 128	java/nio/channels/FileLock:release	()V
    //   995: aload 8
    //   997: ifnull +8 -> 1005
    //   1000: aload 8
    //   1002: invokevirtual 131	java/io/FileInputStream:close	()V
    //   1005: aload 10
    //   1007: ifnull +8 -> 1015
    //   1010: aload 10
    //   1012: invokevirtual 132	java/io/InputStream:close	()V
    //   1015: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1018: ifeq +11 -> 1029
    //   1021: ldc 114
    //   1023: iconst_2
    //   1024: ldc 239
    //   1026: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1029: aload_1
    //   1030: invokestatic 139	bdcs:d	(Ljava/lang/String;)Z
    //   1033: pop
    //   1034: aload 14
    //   1036: invokeinterface 242 1 0
    //   1041: iload 5
    //   1043: istore 7
    //   1045: goto -581 -> 464
    //   1048: aload 15
    //   1050: invokeinterface 299 1 0
    //   1055: aload 15
    //   1057: monitorexit
    //   1058: aload 9
    //   1060: astore 11
    //   1062: aload 10
    //   1064: astore 12
    //   1066: aload 8
    //   1068: astore 13
    //   1070: iload 7
    //   1072: istore 5
    //   1074: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1077: ifeq +45 -> 1122
    //   1080: aload 9
    //   1082: astore 11
    //   1084: aload 10
    //   1086: astore 12
    //   1088: aload 8
    //   1090: astore 13
    //   1092: iload 7
    //   1094: istore 5
    //   1096: ldc 114
    //   1098: iconst_2
    //   1099: new 18	java/lang/StringBuilder
    //   1102: dup
    //   1103: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   1106: ldc_w 301
    //   1109: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1112: iload_3
    //   1113: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1116: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1119: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1122: iload_3
    //   1123: ifle +964 -> 2087
    //   1126: aload 9
    //   1128: astore 11
    //   1130: aload 10
    //   1132: astore 12
    //   1134: aload 8
    //   1136: astore 13
    //   1138: iload 7
    //   1140: istore 5
    //   1142: aload 14
    //   1144: monitorenter
    //   1145: aload_0
    //   1146: aload_0
    //   1147: getfield 63	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob:d	I
    //   1150: iload_3
    //   1151: isub
    //   1152: putfield 63	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob:d	I
    //   1155: aload 14
    //   1157: monitorexit
    //   1158: aload 9
    //   1160: astore 11
    //   1162: aload 10
    //   1164: astore 12
    //   1166: aload 8
    //   1168: astore 13
    //   1170: iload 7
    //   1172: istore 5
    //   1174: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1177: ifeq +910 -> 2087
    //   1180: aload 9
    //   1182: astore 11
    //   1184: aload 10
    //   1186: astore 12
    //   1188: aload 8
    //   1190: astore 13
    //   1192: iload 7
    //   1194: istore 5
    //   1196: ldc 114
    //   1198: iconst_2
    //   1199: new 18	java/lang/StringBuilder
    //   1202: dup
    //   1203: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   1206: ldc_w 303
    //   1209: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1212: aload_0
    //   1213: getfield 63	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob:d	I
    //   1216: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1219: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1222: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1225: iconst_1
    //   1226: istore 5
    //   1228: aload 10
    //   1230: astore_2
    //   1231: iconst_1
    //   1232: istore 6
    //   1234: goto -992 -> 242
    //   1237: astore_2
    //   1238: aload 15
    //   1240: monitorexit
    //   1241: aload 9
    //   1243: astore 11
    //   1245: aload 10
    //   1247: astore 12
    //   1249: aload 8
    //   1251: astore 13
    //   1253: iload 7
    //   1255: istore 5
    //   1257: aload_2
    //   1258: athrow
    //   1259: astore 11
    //   1261: iconst_1
    //   1262: istore 5
    //   1264: aload 9
    //   1266: astore_2
    //   1267: aload 11
    //   1269: astore 9
    //   1271: goto -323 -> 948
    //   1274: astore_2
    //   1275: aload 14
    //   1277: monitorexit
    //   1278: aload 9
    //   1280: astore 11
    //   1282: aload 10
    //   1284: astore 12
    //   1286: aload 8
    //   1288: astore 13
    //   1290: iload 7
    //   1292: istore 5
    //   1294: aload_2
    //   1295: athrow
    //   1296: astore_2
    //   1297: iconst_1
    //   1298: istore 6
    //   1300: iconst_1
    //   1301: istore 5
    //   1303: aload_2
    //   1304: invokevirtual 160	java/lang/Exception:printStackTrace	()V
    //   1307: iconst_0
    //   1308: istore 7
    //   1310: aload 9
    //   1312: astore 11
    //   1314: aload 10
    //   1316: astore 12
    //   1318: aload 8
    //   1320: astore 13
    //   1322: iload 7
    //   1324: istore 5
    //   1326: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1329: ifeq +45 -> 1374
    //   1332: aload 9
    //   1334: astore 11
    //   1336: aload 10
    //   1338: astore 12
    //   1340: aload 8
    //   1342: astore 13
    //   1344: iload 7
    //   1346: istore 5
    //   1348: ldc 114
    //   1350: iconst_2
    //   1351: new 18	java/lang/StringBuilder
    //   1354: dup
    //   1355: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   1358: ldc_w 305
    //   1361: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1364: aload_2
    //   1365: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1368: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1371: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1374: aload 9
    //   1376: ifnull +8 -> 1384
    //   1379: aload 9
    //   1381: invokevirtual 128	java/nio/channels/FileLock:release	()V
    //   1384: aload 8
    //   1386: ifnull +8 -> 1394
    //   1389: aload 8
    //   1391: invokevirtual 131	java/io/FileInputStream:close	()V
    //   1394: aload 10
    //   1396: ifnull +8 -> 1404
    //   1399: aload 10
    //   1401: invokevirtual 132	java/io/InputStream:close	()V
    //   1404: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1407: ifeq +11 -> 1418
    //   1410: ldc 114
    //   1412: iconst_2
    //   1413: ldc 239
    //   1415: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1418: aload_1
    //   1419: invokestatic 139	bdcs:d	(Ljava/lang/String;)Z
    //   1422: pop
    //   1423: aload 14
    //   1425: invokeinterface 242 1 0
    //   1430: iload 6
    //   1432: istore 7
    //   1434: goto -970 -> 464
    //   1437: aload 9
    //   1439: astore 11
    //   1441: aload 10
    //   1443: astore 12
    //   1445: aload 8
    //   1447: astore 13
    //   1449: iload 7
    //   1451: istore 5
    //   1453: aload 15
    //   1455: monitorenter
    //   1456: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1459: ifeq +29 -> 1488
    //   1462: ldc 114
    //   1464: iconst_2
    //   1465: new 18	java/lang/StringBuilder
    //   1468: dup
    //   1469: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   1472: ldc_w 307
    //   1475: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1478: iload_3
    //   1479: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1482: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1485: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1488: aload 15
    //   1490: iload_3
    //   1491: invokestatic 313	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1494: aload 17
    //   1496: invokeinterface 317 3 0
    //   1501: pop
    //   1502: aload 15
    //   1504: monitorexit
    //   1505: aload 9
    //   1507: astore 11
    //   1509: aload 10
    //   1511: astore 12
    //   1513: aload 8
    //   1515: astore 13
    //   1517: iload 7
    //   1519: istore 5
    //   1521: aload 14
    //   1523: monitorenter
    //   1524: aload_0
    //   1525: aload_0
    //   1526: getfield 63	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob:d	I
    //   1529: iconst_1
    //   1530: iadd
    //   1531: putfield 63	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob:d	I
    //   1534: aload 14
    //   1536: monitorexit
    //   1537: aload 9
    //   1539: astore 11
    //   1541: aload 10
    //   1543: astore 12
    //   1545: aload 8
    //   1547: astore 13
    //   1549: iload 7
    //   1551: istore 5
    //   1553: aload 17
    //   1555: bipush 16
    //   1557: aconst_null
    //   1558: iconst_1
    //   1559: invokestatic 321	com/tencent/mobileqq/app/ThreadManager:excute	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1562: iload_3
    //   1563: iconst_1
    //   1564: iadd
    //   1565: istore_3
    //   1566: goto -1460 -> 106
    //   1569: astore_2
    //   1570: aload 15
    //   1572: monitorexit
    //   1573: aload 9
    //   1575: astore 11
    //   1577: aload 10
    //   1579: astore 12
    //   1581: aload 8
    //   1583: astore 13
    //   1585: iload 7
    //   1587: istore 5
    //   1589: aload_2
    //   1590: athrow
    //   1591: astore_2
    //   1592: iconst_1
    //   1593: istore 5
    //   1595: goto -292 -> 1303
    //   1598: astore_2
    //   1599: aload 14
    //   1601: monitorexit
    //   1602: aload 9
    //   1604: astore 11
    //   1606: aload 10
    //   1608: astore 12
    //   1610: aload 8
    //   1612: astore 13
    //   1614: iload 7
    //   1616: istore 5
    //   1618: aload_2
    //   1619: athrow
    //   1620: astore_2
    //   1621: aload 13
    //   1623: astore 8
    //   1625: aload 12
    //   1627: astore 10
    //   1629: aload 11
    //   1631: astore 9
    //   1633: aload 9
    //   1635: ifnull +8 -> 1643
    //   1638: aload 9
    //   1640: invokevirtual 128	java/nio/channels/FileLock:release	()V
    //   1643: aload 8
    //   1645: ifnull +8 -> 1653
    //   1648: aload 8
    //   1650: invokevirtual 131	java/io/FileInputStream:close	()V
    //   1653: aload 10
    //   1655: ifnull +8 -> 1663
    //   1658: aload 10
    //   1660: invokevirtual 132	java/io/InputStream:close	()V
    //   1663: iload 5
    //   1665: ifne +29 -> 1694
    //   1668: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1671: ifeq +11 -> 1682
    //   1674: ldc 114
    //   1676: iconst_2
    //   1677: ldc 239
    //   1679: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1682: aload_1
    //   1683: invokestatic 139	bdcs:d	(Ljava/lang/String;)Z
    //   1686: pop
    //   1687: aload 14
    //   1689: invokeinterface 242 1 0
    //   1694: aload_2
    //   1695: athrow
    //   1696: astore 10
    //   1698: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1701: ifeq -1344 -> 357
    //   1704: ldc 114
    //   1706: iconst_2
    //   1707: new 18	java/lang/StringBuilder
    //   1710: dup
    //   1711: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   1714: ldc_w 323
    //   1717: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1720: aload 10
    //   1722: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1725: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1728: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1731: goto -1374 -> 357
    //   1734: astore 10
    //   1736: aload 14
    //   1738: monitorexit
    //   1739: aload 10
    //   1741: athrow
    //   1742: astore 11
    //   1744: aload_2
    //   1745: astore 10
    //   1747: aload 9
    //   1749: astore_2
    //   1750: aload 11
    //   1752: astore 9
    //   1754: goto -806 -> 948
    //   1757: astore_2
    //   1758: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1761: ifeq -1336 -> 425
    //   1764: ldc 114
    //   1766: iconst_2
    //   1767: new 18	java/lang/StringBuilder
    //   1770: dup
    //   1771: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   1774: ldc 162
    //   1776: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1779: aload_2
    //   1780: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1783: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1786: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1789: goto -1364 -> 425
    //   1792: astore_2
    //   1793: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1796: ifeq -781 -> 1015
    //   1799: ldc 114
    //   1801: iconst_2
    //   1802: new 18	java/lang/StringBuilder
    //   1805: dup
    //   1806: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   1809: ldc 162
    //   1811: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1814: aload_2
    //   1815: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1818: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1821: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1824: goto -809 -> 1015
    //   1827: astore_2
    //   1828: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1831: ifeq -427 -> 1404
    //   1834: ldc 114
    //   1836: iconst_2
    //   1837: new 18	java/lang/StringBuilder
    //   1840: dup
    //   1841: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   1844: ldc 162
    //   1846: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1849: aload_2
    //   1850: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1853: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1856: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1859: goto -455 -> 1404
    //   1862: astore 8
    //   1864: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1867: ifeq -204 -> 1663
    //   1870: ldc 114
    //   1872: iconst_2
    //   1873: new 18	java/lang/StringBuilder
    //   1876: dup
    //   1877: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   1880: ldc 162
    //   1882: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1885: aload 8
    //   1887: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1890: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1893: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1896: goto -233 -> 1663
    //   1899: aload 14
    //   1901: areturn
    //   1902: astore_2
    //   1903: aconst_null
    //   1904: astore 9
    //   1906: aconst_null
    //   1907: astore 8
    //   1909: aconst_null
    //   1910: astore 10
    //   1912: goto -279 -> 1633
    //   1915: astore_2
    //   1916: aconst_null
    //   1917: astore 9
    //   1919: aconst_null
    //   1920: astore 10
    //   1922: goto -289 -> 1633
    //   1925: astore_2
    //   1926: aconst_null
    //   1927: astore 10
    //   1929: goto -296 -> 1633
    //   1932: astore 11
    //   1934: iload 6
    //   1936: istore 5
    //   1938: aload_2
    //   1939: astore 10
    //   1941: aload 11
    //   1943: astore_2
    //   1944: goto -311 -> 1633
    //   1947: astore 11
    //   1949: aload_2
    //   1950: astore 9
    //   1952: aload 11
    //   1954: astore_2
    //   1955: iload 6
    //   1957: istore 5
    //   1959: goto -326 -> 1633
    //   1962: astore_2
    //   1963: goto -330 -> 1633
    //   1966: astore_2
    //   1967: aconst_null
    //   1968: astore 9
    //   1970: aconst_null
    //   1971: astore 8
    //   1973: aconst_null
    //   1974: astore 10
    //   1976: iconst_1
    //   1977: istore 5
    //   1979: goto -676 -> 1303
    //   1982: astore_2
    //   1983: iconst_1
    //   1984: istore 5
    //   1986: aconst_null
    //   1987: astore 9
    //   1989: aconst_null
    //   1990: astore 10
    //   1992: goto -689 -> 1303
    //   1995: astore_2
    //   1996: iconst_1
    //   1997: istore 5
    //   1999: aconst_null
    //   2000: astore 10
    //   2002: goto -699 -> 1303
    //   2005: astore 11
    //   2007: iload 5
    //   2009: istore 7
    //   2011: iload 6
    //   2013: istore 5
    //   2015: aload_2
    //   2016: astore 10
    //   2018: aload 11
    //   2020: astore_2
    //   2021: iload 7
    //   2023: istore 6
    //   2025: goto -722 -> 1303
    //   2028: astore 9
    //   2030: aconst_null
    //   2031: astore_2
    //   2032: aconst_null
    //   2033: astore 8
    //   2035: aconst_null
    //   2036: astore 10
    //   2038: iconst_0
    //   2039: istore 5
    //   2041: goto -1093 -> 948
    //   2044: astore 9
    //   2046: iconst_0
    //   2047: istore 5
    //   2049: aconst_null
    //   2050: astore_2
    //   2051: aconst_null
    //   2052: astore 10
    //   2054: goto -1106 -> 948
    //   2057: astore 11
    //   2059: iconst_0
    //   2060: istore 5
    //   2062: aload 9
    //   2064: astore_2
    //   2065: aconst_null
    //   2066: astore 10
    //   2068: aload 11
    //   2070: astore 9
    //   2072: goto -1124 -> 948
    //   2075: iconst_0
    //   2076: istore 5
    //   2078: aload 10
    //   2080: astore_2
    //   2081: iconst_1
    //   2082: istore 6
    //   2084: goto -1842 -> 242
    //   2087: iconst_1
    //   2088: istore 5
    //   2090: aload 10
    //   2092: astore_2
    //   2093: iconst_1
    //   2094: istore 6
    //   2096: goto -1854 -> 242
    //   2099: goto -1226 -> 873
    //   2102: iconst_0
    //   2103: istore 5
    //   2105: iconst_1
    //   2106: istore 6
    //   2108: aconst_null
    //   2109: astore_2
    //   2110: goto -1868 -> 242
    //   2113: iconst_0
    //   2114: istore 5
    //   2116: aload 10
    //   2118: astore_2
    //   2119: iconst_0
    //   2120: istore 6
    //   2122: goto -1880 -> 242
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2125	0	this	LoadDataJob
    //   0	2125	1	paramString	String
    //   0	2125	2	paramaewc	aewc
    //   105	1461	3	i	int
    //   155	523	4	j	int
    //   20	2095	5	bool1	boolean
    //   26	2095	6	bool2	boolean
    //   23	1999	7	bool3	boolean
    //   50	1599	8	localObject1	Object
    //   1862	24	8	localException1	Exception
    //   1907	127	8	localObject2	Object
    //   65	1923	9	localObject3	Object
    //   2028	1	9	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   2044	19	9	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   2070	1	9	localObject4	Object
    //   81	1578	10	localObject5	Object
    //   1696	25	10	localException2	Exception
    //   1734	6	10	localObject6	Object
    //   1745	372	10	localaewc	aewc
    //   85	725	11	localObject7	Object
    //   876	25	11	localException3	Exception
    //   920	1	11	localObject8	Object
    //   936	9	11	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   1060	184	11	localObject9	Object
    //   1259	9	11	localOutOfMemoryError4	java.lang.OutOfMemoryError
    //   1280	350	11	localObject10	Object
    //   1742	9	11	localOutOfMemoryError5	java.lang.OutOfMemoryError
    //   1932	10	11	localObject11	Object
    //   1947	6	11	localObject12	Object
    //   2005	14	11	localException4	Exception
    //   2057	12	11	localOutOfMemoryError6	java.lang.OutOfMemoryError
    //   89	1537	12	localObject13	Object
    //   93	1529	13	localObject14	Object
    //   7	1893	14	localArrayList	ArrayList
    //   35	1536	15	localHashMap	HashMap
    //   102	48	16	arrayOfByte	byte[]
    //   505	1049	17	localObject15	Object
    // Exception table:
    //   from	to	target	type
    //   680	718	876	java/lang/Exception
    //   718	726	876	java/lang/Exception
    //   665	674	914	finally
    //   680	718	914	finally
    //   718	726	914	finally
    //   726	729	914	finally
    //   878	911	914	finally
    //   915	918	914	finally
    //   99	104	936	java/lang/OutOfMemoryError
    //   122	133	936	java/lang/OutOfMemoryError
    //   149	157	936	java/lang/OutOfMemoryError
    //   185	191	936	java/lang/OutOfMemoryError
    //   207	233	936	java/lang/OutOfMemoryError
    //   501	507	936	java/lang/OutOfMemoryError
    //   523	538	936	java/lang/OutOfMemoryError
    //   554	560	936	java/lang/OutOfMemoryError
    //   576	602	936	java/lang/OutOfMemoryError
    //   621	646	936	java/lang/OutOfMemoryError
    //   662	665	936	java/lang/OutOfMemoryError
    //   745	758	936	java/lang/OutOfMemoryError
    //   774	780	936	java/lang/OutOfMemoryError
    //   796	805	936	java/lang/OutOfMemoryError
    //   934	936	936	java/lang/OutOfMemoryError
    //   1453	1456	936	java/lang/OutOfMemoryError
    //   1521	1524	936	java/lang/OutOfMemoryError
    //   1553	1562	936	java/lang/OutOfMemoryError
    //   1589	1591	936	java/lang/OutOfMemoryError
    //   1618	1620	936	java/lang/OutOfMemoryError
    //   826	839	1237	finally
    //   839	864	1237	finally
    //   1048	1058	1237	finally
    //   1238	1241	1237	finally
    //   823	826	1259	java/lang/OutOfMemoryError
    //   1074	1080	1259	java/lang/OutOfMemoryError
    //   1096	1122	1259	java/lang/OutOfMemoryError
    //   1142	1145	1259	java/lang/OutOfMemoryError
    //   1174	1180	1259	java/lang/OutOfMemoryError
    //   1196	1225	1259	java/lang/OutOfMemoryError
    //   1257	1259	1259	java/lang/OutOfMemoryError
    //   1294	1296	1259	java/lang/OutOfMemoryError
    //   1145	1158	1274	finally
    //   1275	1278	1274	finally
    //   823	826	1296	java/lang/Exception
    //   1074	1080	1296	java/lang/Exception
    //   1096	1122	1296	java/lang/Exception
    //   1142	1145	1296	java/lang/Exception
    //   1174	1180	1296	java/lang/Exception
    //   1196	1225	1296	java/lang/Exception
    //   1257	1259	1296	java/lang/Exception
    //   1294	1296	1296	java/lang/Exception
    //   1456	1488	1569	finally
    //   1488	1505	1569	finally
    //   1570	1573	1569	finally
    //   99	104	1591	java/lang/Exception
    //   122	133	1591	java/lang/Exception
    //   149	157	1591	java/lang/Exception
    //   185	191	1591	java/lang/Exception
    //   207	233	1591	java/lang/Exception
    //   501	507	1591	java/lang/Exception
    //   523	538	1591	java/lang/Exception
    //   554	560	1591	java/lang/Exception
    //   576	602	1591	java/lang/Exception
    //   621	646	1591	java/lang/Exception
    //   662	665	1591	java/lang/Exception
    //   745	758	1591	java/lang/Exception
    //   774	780	1591	java/lang/Exception
    //   796	805	1591	java/lang/Exception
    //   934	936	1591	java/lang/Exception
    //   1453	1456	1591	java/lang/Exception
    //   1521	1524	1591	java/lang/Exception
    //   1553	1562	1591	java/lang/Exception
    //   1589	1591	1591	java/lang/Exception
    //   1618	1620	1591	java/lang/Exception
    //   1524	1537	1598	finally
    //   1599	1602	1598	finally
    //   99	104	1620	finally
    //   122	133	1620	finally
    //   149	157	1620	finally
    //   185	191	1620	finally
    //   207	233	1620	finally
    //   501	507	1620	finally
    //   523	538	1620	finally
    //   554	560	1620	finally
    //   576	602	1620	finally
    //   621	646	1620	finally
    //   662	665	1620	finally
    //   745	758	1620	finally
    //   774	780	1620	finally
    //   796	805	1620	finally
    //   823	826	1620	finally
    //   934	936	1620	finally
    //   1074	1080	1620	finally
    //   1096	1122	1620	finally
    //   1142	1145	1620	finally
    //   1174	1180	1620	finally
    //   1196	1225	1620	finally
    //   1257	1259	1620	finally
    //   1294	1296	1620	finally
    //   1326	1332	1620	finally
    //   1348	1374	1620	finally
    //   1453	1456	1620	finally
    //   1521	1524	1620	finally
    //   1553	1562	1620	finally
    //   1589	1591	1620	finally
    //   1618	1620	1620	finally
    //   349	357	1696	java/lang/Exception
    //   245	324	1734	finally
    //   324	338	1734	finally
    //   349	357	1734	finally
    //   357	380	1734	finally
    //   380	383	1734	finally
    //   1698	1731	1734	finally
    //   1736	1739	1734	finally
    //   242	245	1742	java/lang/OutOfMemoryError
    //   383	397	1742	java/lang/OutOfMemoryError
    //   1739	1742	1742	java/lang/OutOfMemoryError
    //   402	407	1757	java/lang/Exception
    //   412	417	1757	java/lang/Exception
    //   421	425	1757	java/lang/Exception
    //   991	995	1792	java/lang/Exception
    //   1000	1005	1792	java/lang/Exception
    //   1010	1015	1792	java/lang/Exception
    //   1379	1384	1827	java/lang/Exception
    //   1389	1394	1827	java/lang/Exception
    //   1399	1404	1827	java/lang/Exception
    //   1638	1643	1862	java/lang/Exception
    //   1648	1653	1862	java/lang/Exception
    //   1658	1663	1862	java/lang/Exception
    //   37	52	1902	finally
    //   52	67	1915	finally
    //   72	83	1925	finally
    //   242	245	1932	finally
    //   383	397	1932	finally
    //   1739	1742	1932	finally
    //   951	987	1947	finally
    //   1303	1307	1962	finally
    //   37	52	1966	java/lang/Exception
    //   52	67	1982	java/lang/Exception
    //   72	83	1995	java/lang/Exception
    //   242	245	2005	java/lang/Exception
    //   383	397	2005	java/lang/Exception
    //   1739	1742	2005	java/lang/Exception
    //   37	52	2028	java/lang/OutOfMemoryError
    //   52	67	2044	java/lang/OutOfMemoryError
    //   72	83	2057	java/lang/OutOfMemoryError
  }
  
  private List<aewp> a(List<aewl> paramList, Rect paramRect)
  {
    Object localObject1 = paramList.iterator();
    long l = 0L;
    Object localObject2;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (aewl)((Iterator)localObject1).next();
      if (((aewl)localObject2).b() == null) {
        break label251;
      }
      l = ((aewl)localObject2).b().a() + l;
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
          localObject2 = new aewp((aewl)paramList.next(), paramRect.width(), paramRect.height(), this.jdField_b_of_type_Int, this.c, i, j, 1.0F);
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
      Collections.sort((List)localObject1, new aewd(this));
      return localObject1;
    }
  }
  
  private Map<Integer, Integer> a(List<aewp> paramList)
  {
    HashMap localHashMap = new HashMap();
    if (paramList == null) {
      return localHashMap;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      int i = ((aewp)paramList.next()).a();
      if (i > 0) {
        if (!aevw.a().b(0, i)) {
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
          paramBoolean = bdcs.a(paramString);
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
  
  public aewg a(byte[] paramArrayOfByte)
  {
    aewg localaewg = new aewg(0);
    localaewg.a(paramArrayOfByte, 0, paramArrayOfByte.length);
    return localaewg;
  }
  
  public aewh a(aewi paramaewi)
  {
    aewg localaewg = new aewg(102400);
    paramaewi.a(localaewg, 0);
    return localaewg.a();
  }
  
  /* Error */
  public void a(aevu paramaevu, String paramString)
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
    //   22: invokestatic 72	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   25: ifeq +4 -> 29
    //   28: return
    //   29: aload_2
    //   30: invokestatic 190	bdcs:a	(Ljava/lang/String;)Z
    //   33: ifne -5 -> 28
    //   36: new 18	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   43: aload_2
    //   44: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: ldc_w 407
    //   50: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: astore 10
    //   58: new 409	java/io/FileOutputStream
    //   61: dup
    //   62: aload 10
    //   64: invokespecial 410	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
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
    //   86: invokevirtual 411	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   89: invokevirtual 414	java/nio/channels/FileChannel:tryLock	()Ljava/nio/channels/FileLock;
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
    //   116: invokevirtual 411	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   119: lconst_0
    //   120: invokevirtual 418	java/nio/channels/FileChannel:position	(J)Ljava/nio/channels/FileChannel;
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
    //   141: invokevirtual 420	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob:a	(Laewi;)Laewh;
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
    //   163: getfield 423	aewh:jdField_a_of_type_Int	I
    //   166: invokestatic 426	aevh:a	(I)[B
    //   169: invokevirtual 430	java/io/FileOutputStream:write	([B)V
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
    //   190: getfield 433	aewh:jdField_a_of_type_ArrayOfByte	[B
    //   193: iconst_0
    //   194: aload_1
    //   195: getfield 423	aewh:jdField_a_of_type_Int	I
    //   198: invokevirtual 435	java/io/FileOutputStream:write	([BII)V
    //   201: aload 8
    //   203: ifnull +8 -> 211
    //   206: aload 8
    //   208: invokevirtual 128	java/nio/channels/FileLock:release	()V
    //   211: aload 5
    //   213: ifnull +8 -> 221
    //   216: aload 5
    //   218: invokevirtual 436	java/io/FileOutputStream:close	()V
    //   221: aload 10
    //   223: aload_2
    //   224: invokestatic 439	bdcs:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   227: pop
    //   228: return
    //   229: astore_1
    //   230: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   233: ifeq -12 -> 221
    //   236: ldc 114
    //   238: iconst_2
    //   239: new 18	java/lang/StringBuilder
    //   242: dup
    //   243: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   246: ldc_w 441
    //   249: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: aload_1
    //   253: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   256: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   262: goto -41 -> 221
    //   265: astore_1
    //   266: aconst_null
    //   267: astore 5
    //   269: aload 7
    //   271: astore_3
    //   272: aload 5
    //   274: astore 4
    //   276: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   279: ifeq +36 -> 315
    //   282: aload 7
    //   284: astore_3
    //   285: aload 5
    //   287: astore 4
    //   289: ldc 114
    //   291: iconst_2
    //   292: new 18	java/lang/StringBuilder
    //   295: dup
    //   296: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   299: ldc_w 443
    //   302: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: aload_1
    //   306: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   309: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   312: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   315: aload 7
    //   317: ifnull +8 -> 325
    //   320: aload 7
    //   322: invokevirtual 128	java/nio/channels/FileLock:release	()V
    //   325: aload 5
    //   327: ifnull +8 -> 335
    //   330: aload 5
    //   332: invokevirtual 436	java/io/FileOutputStream:close	()V
    //   335: aload 10
    //   337: aload_2
    //   338: invokestatic 439	bdcs:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   341: pop
    //   342: return
    //   343: astore_1
    //   344: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   347: ifeq -12 -> 335
    //   350: ldc 114
    //   352: iconst_2
    //   353: new 18	java/lang/StringBuilder
    //   356: dup
    //   357: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   360: ldc_w 441
    //   363: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: aload_1
    //   367: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   370: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   373: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   376: goto -41 -> 335
    //   379: astore_1
    //   380: aconst_null
    //   381: astore 5
    //   383: aload 6
    //   385: astore_3
    //   386: aload 5
    //   388: astore 4
    //   390: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   393: ifeq +36 -> 429
    //   396: aload 6
    //   398: astore_3
    //   399: aload 5
    //   401: astore 4
    //   403: ldc 114
    //   405: iconst_2
    //   406: new 18	java/lang/StringBuilder
    //   409: dup
    //   410: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   413: ldc_w 445
    //   416: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: aload_1
    //   420: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   423: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   426: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   429: aload 6
    //   431: ifnull +8 -> 439
    //   434: aload 6
    //   436: invokevirtual 128	java/nio/channels/FileLock:release	()V
    //   439: aload 5
    //   441: ifnull +8 -> 449
    //   444: aload 5
    //   446: invokevirtual 436	java/io/FileOutputStream:close	()V
    //   449: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   452: ifeq -424 -> 28
    //   455: ldc 114
    //   457: iconst_2
    //   458: ldc_w 447
    //   461: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   464: return
    //   465: astore_1
    //   466: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   469: ifeq -20 -> 449
    //   472: ldc 114
    //   474: iconst_2
    //   475: new 18	java/lang/StringBuilder
    //   478: dup
    //   479: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   482: ldc_w 441
    //   485: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   488: aload_1
    //   489: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   492: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   495: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   498: goto -49 -> 449
    //   501: astore_1
    //   502: aconst_null
    //   503: astore 4
    //   505: aload_3
    //   506: ifnull +7 -> 513
    //   509: aload_3
    //   510: invokevirtual 128	java/nio/channels/FileLock:release	()V
    //   513: aload 4
    //   515: ifnull +8 -> 523
    //   518: aload 4
    //   520: invokevirtual 436	java/io/FileOutputStream:close	()V
    //   523: aload 10
    //   525: aload_2
    //   526: invokestatic 439	bdcs:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   529: pop
    //   530: aload_1
    //   531: athrow
    //   532: astore_3
    //   533: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   536: ifeq -13 -> 523
    //   539: ldc 114
    //   541: iconst_2
    //   542: new 18	java/lang/StringBuilder
    //   545: dup
    //   546: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   549: ldc_w 441
    //   552: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: aload_3
    //   556: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   559: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   562: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   0	580	1	paramaevu	aevu
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
  public boolean a(List<aewp> paramList, String paramString)
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
    //   20: invokeinterface 211 1 0
    //   25: ifeq +10 -> 35
    //   28: aload_2
    //   29: invokestatic 72	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   32: ifeq +5 -> 37
    //   35: iconst_0
    //   36: ireturn
    //   37: aload_2
    //   38: invokestatic 190	bdcs:a	(Ljava/lang/String;)Z
    //   41: ifne -6 -> 35
    //   44: new 18	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   51: aload_2
    //   52: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: ldc_w 407
    //   58: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: astore 11
    //   66: new 409	java/io/FileOutputStream
    //   69: dup
    //   70: aload 11
    //   72: iconst_0
    //   73: invokespecial 451	java/io/FileOutputStream:<init>	(Ljava/lang/String;Z)V
    //   76: astore 4
    //   78: aload 9
    //   80: astore 5
    //   82: aload 4
    //   84: astore 7
    //   86: aload 10
    //   88: astore 8
    //   90: aload 4
    //   92: invokevirtual 411	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   95: astore 12
    //   97: aload 9
    //   99: astore 5
    //   101: aload 4
    //   103: astore 7
    //   105: aload 10
    //   107: astore 8
    //   109: aload 12
    //   111: invokevirtual 414	java/nio/channels/FileChannel:tryLock	()Ljava/nio/channels/FileLock;
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
    //   136: invokevirtual 418	java/nio/channels/FileChannel:position	(J)Ljava/nio/channels/FileChannel;
    //   139: pop
    //   140: aload 6
    //   142: astore 5
    //   144: aload 4
    //   146: astore 7
    //   148: aload 6
    //   150: astore 8
    //   152: aload_1
    //   153: invokeinterface 327 1 0
    //   158: astore_1
    //   159: aload 6
    //   161: astore 5
    //   163: aload 4
    //   165: astore 7
    //   167: aload 6
    //   169: astore 8
    //   171: aload_1
    //   172: invokeinterface 283 1 0
    //   177: ifeq +161 -> 338
    //   180: aload 6
    //   182: astore 5
    //   184: aload 4
    //   186: astore 7
    //   188: aload 6
    //   190: astore 8
    //   192: aload_0
    //   193: aload_1
    //   194: invokeinterface 287 1 0
    //   199: checkcast 350	aewp
    //   202: invokevirtual 420	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob:a	(Laewi;)Laewh;
    //   205: astore 9
    //   207: aload 6
    //   209: astore 5
    //   211: aload 4
    //   213: astore 7
    //   215: aload 6
    //   217: astore 8
    //   219: aload 4
    //   221: aload 9
    //   223: getfield 423	aewh:jdField_a_of_type_Int	I
    //   226: invokestatic 426	aevh:a	(I)[B
    //   229: invokevirtual 430	java/io/FileOutputStream:write	([B)V
    //   232: aload 6
    //   234: astore 5
    //   236: aload 4
    //   238: astore 7
    //   240: aload 6
    //   242: astore 8
    //   244: aload 4
    //   246: aload 9
    //   248: getfield 433	aewh:jdField_a_of_type_ArrayOfByte	[B
    //   251: iconst_0
    //   252: aload 9
    //   254: getfield 423	aewh:jdField_a_of_type_Int	I
    //   257: invokevirtual 435	java/io/FileOutputStream:write	([BII)V
    //   260: goto -101 -> 159
    //   263: astore 5
    //   265: aload 6
    //   267: astore_1
    //   268: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   271: ifeq +30 -> 301
    //   274: ldc 114
    //   276: iconst_2
    //   277: new 18	java/lang/StringBuilder
    //   280: dup
    //   281: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   284: ldc_w 453
    //   287: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: aload 5
    //   292: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   295: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   298: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   301: aload_1
    //   302: ifnull +7 -> 309
    //   305: aload_1
    //   306: invokevirtual 128	java/nio/channels/FileLock:release	()V
    //   309: aload 4
    //   311: ifnull +8 -> 319
    //   314: aload 4
    //   316: invokevirtual 436	java/io/FileOutputStream:close	()V
    //   319: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   322: ifeq +360 -> 682
    //   325: ldc 114
    //   327: iconst_2
    //   328: ldc_w 455
    //   331: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   334: iconst_0
    //   335: istore_3
    //   336: iload_3
    //   337: ireturn
    //   338: aload 6
    //   340: ifnull +8 -> 348
    //   343: aload 6
    //   345: invokevirtual 128	java/nio/channels/FileLock:release	()V
    //   348: aload 4
    //   350: ifnull +8 -> 358
    //   353: aload 4
    //   355: invokevirtual 436	java/io/FileOutputStream:close	()V
    //   358: aload 11
    //   360: aload_2
    //   361: invokestatic 439	bdcs:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   364: pop
    //   365: iconst_1
    //   366: istore_3
    //   367: goto -31 -> 336
    //   370: astore_1
    //   371: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   374: ifeq -16 -> 358
    //   377: ldc 114
    //   379: iconst_2
    //   380: new 18	java/lang/StringBuilder
    //   383: dup
    //   384: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   387: ldc_w 457
    //   390: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: aload_1
    //   394: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   397: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   400: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   403: goto -45 -> 358
    //   406: astore_1
    //   407: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   410: ifeq -91 -> 319
    //   413: ldc 114
    //   415: iconst_2
    //   416: new 18	java/lang/StringBuilder
    //   419: dup
    //   420: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   423: ldc_w 457
    //   426: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: aload_1
    //   430: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   433: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   436: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   439: goto -120 -> 319
    //   442: astore_1
    //   443: aconst_null
    //   444: astore 4
    //   446: aload 8
    //   448: astore 5
    //   450: aload 4
    //   452: astore 7
    //   454: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   457: ifeq +37 -> 494
    //   460: aload 8
    //   462: astore 5
    //   464: aload 4
    //   466: astore 7
    //   468: ldc 114
    //   470: iconst_2
    //   471: new 18	java/lang/StringBuilder
    //   474: dup
    //   475: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   478: ldc_w 459
    //   481: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: aload_1
    //   485: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   488: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   491: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   494: aload 8
    //   496: ifnull +8 -> 504
    //   499: aload 8
    //   501: invokevirtual 128	java/nio/channels/FileLock:release	()V
    //   504: aload 4
    //   506: ifnull +8 -> 514
    //   509: aload 4
    //   511: invokevirtual 436	java/io/FileOutputStream:close	()V
    //   514: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   517: ifeq +165 -> 682
    //   520: ldc 114
    //   522: iconst_2
    //   523: ldc_w 455
    //   526: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   529: iconst_0
    //   530: istore_3
    //   531: goto -195 -> 336
    //   534: astore_1
    //   535: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   538: ifeq -24 -> 514
    //   541: ldc 114
    //   543: iconst_2
    //   544: new 18	java/lang/StringBuilder
    //   547: dup
    //   548: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   551: ldc_w 457
    //   554: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   557: aload_1
    //   558: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   561: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   564: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   567: goto -53 -> 514
    //   570: astore_1
    //   571: aconst_null
    //   572: astore 7
    //   574: aload 5
    //   576: ifnull +8 -> 584
    //   579: aload 5
    //   581: invokevirtual 128	java/nio/channels/FileLock:release	()V
    //   584: aload 7
    //   586: ifnull +8 -> 594
    //   589: aload 7
    //   591: invokevirtual 436	java/io/FileOutputStream:close	()V
    //   594: aload 11
    //   596: aload_2
    //   597: invokestatic 439	bdcs:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   600: pop
    //   601: aload_1
    //   602: athrow
    //   603: astore 4
    //   605: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   608: ifeq -14 -> 594
    //   611: ldc 114
    //   613: iconst_2
    //   614: new 18	java/lang/StringBuilder
    //   617: dup
    //   618: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   621: ldc_w 457
    //   624: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   627: aload 4
    //   629: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   632: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   635: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   0	687	1	paramList	List<aewp>
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
    //   7	246	9	localaewh	aewh
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
    for (aewc localaewc = (aewc)this.jdField_a_of_type_JavaLangRefWeakReference.get();; localaewc = null)
    {
      if (localaewc == null) {
        QLog.d("LoadDataJob", 2, "mListener == null");
      }
      label669:
      for (;;)
      {
        return;
        if (this.jdField_a_of_type_JavaLangString == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("LoadDataJob", 2, "file == null");
          }
          localaewc.a(null, 4, null, null, null);
          return;
        }
        if (!localaewc.a(this.jdField_a_of_type_JavaLangString))
        {
          if (QLog.isColorLevel()) {
            QLog.d("LoadDataJob", 2, "onCheck  false");
          }
        }
        else
        {
          Object localObject3 = a(this.jdField_a_of_type_JavaLangString, true);
          Object localObject2 = b(this.jdField_a_of_type_JavaLangString, true);
          if (localaewc.a(this.jdField_a_of_type_JavaLangString))
          {
            Object localObject4;
            label250:
            aewp localaewp;
            if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (!TextUtils.isEmpty((CharSequence)localObject2)))
            {
              if (QLog.isColorLevel()) {
                QLog.d("LoadDataJob", 2, "run  read parcel begin");
              }
              localObject1 = a((String)localObject3, localaewc);
              if ((!localaewc.a(this.jdField_a_of_type_JavaLangString)) || (localObject1 == null)) {
                continue;
              }
              if (localObject1 != null)
              {
                localObject4 = ((List)localObject1).iterator();
                if (((Iterator)localObject4).hasNext())
                {
                  localaewp = (aewp)((Iterator)localObject4).next();
                  if ((localaewp == null) || (!localaewp.a()))
                  {
                    bdcs.d((String)localObject3);
                    localObject1 = null;
                    label294:
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
              if (!localaewc.a(this.jdField_a_of_type_JavaLangString)) {
                break label669;
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
                localObject2 = aevh.a(this.jdField_a_of_type_JavaLangString);
                if (localObject2 == null)
                {
                  localaewc.a(this.jdField_a_of_type_JavaLangString, 4, null, null, null);
                  return;
                  localaewp.a(0, 0, this.jdField_b_of_type_Int, this.c);
                  break label250;
                }
                localObject1 = ((aevb)localObject2).a();
                if (!localaewc.a(this.jdField_a_of_type_JavaLangString)) {
                  break;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("LoadDataJob", 2, "run setpathdata ");
                }
                localObject4 = a(((aevb)localObject2).a(), ((aevb)localObject2).a().a());
                long l2 = System.currentTimeMillis();
                if (!localaewc.a(this.jdField_a_of_type_JavaLangString)) {
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
                  ThreadManager.post(new LoadDataJob.1(this, (aevu)localObject1, (List)localObject4), 5, null, false);
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
              if (!localaewc.a(this.jdField_a_of_type_JavaLangString)) {
                break;
              }
              localObject1 = a((List)localObject3);
              localaewc.a(this.jdField_a_of_type_JavaLangString, 0, (aevu)localObject2, (List)localObject3, (Map)localObject1);
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("LoadDataJob", 2, "run  end");
              return;
              break label294;
              localObject2 = null;
              localObject1 = null;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.LoadDataJob
 * JD-Core Version:    0.7.0.1
 */
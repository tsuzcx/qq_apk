import android.os.SystemClock;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.utils.SilkCodecWrapper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.wx.voice.vad.WXVadSeg;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import tencent.im.cs.smartptt.Smartptt.ReqBody;

public class bavu
  extends bark
{
  private static final byte[] d = bdml.a(1, 16000);
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private awyt jdField_a_of_type_Awyt;
  private baxu jdField_a_of_type_Baxu;
  Transaction jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction;
  private String jdField_a_of_type_JavaLangString;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private String n = "";
  
  public bavu(bard parambard, bayk parambayk)
  {
    super(parambard, parambayk);
  }
  
  private baxu a()
  {
    baxu localbaxu = new baxu();
    localbaxu.jdField_a_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_Bayk.p);
    localbaxu.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
    localbaxu.jdField_c_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
    localbaxu.e = this.jdField_a_of_type_Bayk.q;
    localbaxu.jdField_b_of_type_JavaLangString = (this.jdField_a_of_type_Bayk.i.substring(0, this.jdField_a_of_type_Bayk.i.lastIndexOf(File.separator)) + "/tmp_" + localbaxu.jdField_a_of_type_JavaLangString + "_" + this.jdField_a_of_type_Int + ".silk");
    localbaxu.jdField_a_of_type_Int = 6;
    if (this.jdField_a_of_type_Int == 0) {}
    for (localbaxu.jdField_a_of_type_Boolean = true;; localbaxu.jdField_a_of_type_Boolean = false)
    {
      localbaxu.jdField_c_of_type_Int = this.jdField_a_of_type_Bayk.jdField_o_of_type_Int;
      localbaxu.d = this.jdField_a_of_type_Bayk.p;
      return localbaxu;
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.o) {
      d(1004);
    }
    do
    {
      do
      {
        return;
        if (!paramBoolean1) {
          break;
        }
        d(2003);
      } while (!QLog.isColorLevel());
      QLog.d("PttSliceUploadProcessor", 2, "sendMessageToUpdate send finished!");
      return;
      g();
    } while (!paramBoolean2);
    d(2002);
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_Bayk.jdField_a_of_type_ComWxVoiceVadWXVadSeg != null) && ((this.jdField_a_of_type_Bayk.jdField_a_of_type_ComWxVoiceVadWXVadSeg instanceof WXVadSeg)))
    {
      WXVadSeg localWXVadSeg = this.jdField_a_of_type_Bayk.jdField_a_of_type_ComWxVoiceVadWXVadSeg;
      this.jdField_a_of_type_Long = (localWXVadSeg.mbtm * 32L);
      this.jdField_b_of_type_Long = (localWXVadSeg.metm * 32L);
      this.jdField_a_of_type_Int = 0;
      if (QLog.isColorLevel()) {
        QLog.d("PttSliceUploadProcessor", 2, "generateFileByOneSeg, bps=" + this.jdField_a_of_type_Long + " EPS=" + this.jdField_b_of_type_Long + " segPos=" + this.jdField_a_of_type_Bayk.p + " size=" + this.jdField_a_of_type_Bayk.jdField_o_of_type_Int);
      }
    }
    try
    {
      this.jdField_a_of_type_JavaIoRandomAccessFile.seek(this.jdField_a_of_type_Long);
      g();
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
    }
  }
  
  /* Error */
  private void g()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 124	bavu:o	Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: invokespecial 190	bavu:a	()Lbaxu;
    //   12: astore 7
    //   14: aconst_null
    //   15: astore 6
    //   17: aconst_null
    //   18: astore 5
    //   20: aload 6
    //   22: astore_3
    //   23: aload_0
    //   24: getfield 163	bavu:jdField_b_of_type_Long	J
    //   27: aload_0
    //   28: getfield 158	bavu:jdField_a_of_type_Long	J
    //   31: lsub
    //   32: ldc2_w 191
    //   35: lcmp
    //   36: ifle +371 -> 407
    //   39: aload 6
    //   41: astore_3
    //   42: sipush 6400
    //   45: newarray byte
    //   47: astore 4
    //   49: aload 6
    //   51: astore_3
    //   52: aload_0
    //   53: getfield 177	bavu:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   56: aload 4
    //   58: iconst_0
    //   59: sipush 6400
    //   62: invokevirtual 196	java/io/RandomAccessFile:read	([BII)I
    //   65: istore_1
    //   66: aload 6
    //   68: astore_3
    //   69: aload_0
    //   70: aload_0
    //   71: getfield 158	bavu:jdField_a_of_type_Long	J
    //   74: ldc2_w 191
    //   77: ladd
    //   78: putfield 158	bavu:jdField_a_of_type_Long	J
    //   81: aload 6
    //   83: astore_3
    //   84: aload 7
    //   86: iconst_0
    //   87: putfield 198	baxu:jdField_b_of_type_Boolean	Z
    //   90: iload_1
    //   91: istore_2
    //   92: aload 6
    //   94: astore_3
    //   95: aload 7
    //   97: getfield 198	baxu:jdField_b_of_type_Boolean	Z
    //   100: ifne +146 -> 246
    //   103: iload_1
    //   104: istore_2
    //   105: aload 6
    //   107: astore_3
    //   108: aload_0
    //   109: getfield 163	bavu:jdField_b_of_type_Long	J
    //   112: aload_0
    //   113: getfield 158	bavu:jdField_a_of_type_Long	J
    //   116: lsub
    //   117: ldc2_w 191
    //   120: lcmp
    //   121: ifge +125 -> 246
    //   124: aload 6
    //   126: astore_3
    //   127: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   130: ifeq +14 -> 144
    //   133: aload 6
    //   135: astore_3
    //   136: ldc 135
    //   138: iconst_2
    //   139: ldc 200
    //   141: invokestatic 140	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   144: aload 6
    //   146: astore_3
    //   147: aload_0
    //   148: getfield 163	bavu:jdField_b_of_type_Long	J
    //   151: aload_0
    //   152: getfield 158	bavu:jdField_a_of_type_Long	J
    //   155: lsub
    //   156: l2i
    //   157: newarray byte
    //   159: astore 8
    //   161: aload 6
    //   163: astore_3
    //   164: aload_0
    //   165: getfield 177	bavu:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   168: aload 8
    //   170: iconst_0
    //   171: aload_0
    //   172: getfield 163	bavu:jdField_b_of_type_Long	J
    //   175: aload_0
    //   176: getfield 158	bavu:jdField_a_of_type_Long	J
    //   179: lsub
    //   180: l2i
    //   181: invokevirtual 196	java/io/RandomAccessFile:read	([BII)I
    //   184: istore_1
    //   185: iload_1
    //   186: istore_2
    //   187: aload 6
    //   189: astore_3
    //   190: aload_0
    //   191: getfield 202	bavu:jdField_a_of_type_Awyt	Lawyt;
    //   194: aload 8
    //   196: iconst_0
    //   197: iload_1
    //   198: invokevirtual 207	awyt:a	([BII)Lawyq;
    //   201: getfield 210	awyq:jdField_a_of_type_Int	I
    //   204: ifne +42 -> 246
    //   207: aload 6
    //   209: astore_3
    //   210: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   213: ifeq +14 -> 227
    //   216: aload 6
    //   218: astore_3
    //   219: ldc 135
    //   221: iconst_2
    //   222: ldc 212
    //   224: invokestatic 140	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   227: aload 6
    //   229: astore_3
    //   230: aload 7
    //   232: iconst_1
    //   233: putfield 198	baxu:jdField_b_of_type_Boolean	Z
    //   236: aload 6
    //   238: astore_3
    //   239: aload_0
    //   240: iconst_0
    //   241: putfield 65	bavu:jdField_a_of_type_Int	I
    //   244: iload_1
    //   245: istore_2
    //   246: aload 6
    //   248: astore_3
    //   249: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   252: ifeq +72 -> 324
    //   255: aload 6
    //   257: astore_3
    //   258: ldc 135
    //   260: iconst_2
    //   261: new 40	java/lang/StringBuilder
    //   264: dup
    //   265: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   268: ldc 214
    //   270: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: aload 4
    //   275: arraylength
    //   276: invokevirtual 58	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   279: ldc 216
    //   281: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: aload_0
    //   285: getfield 158	bavu:jdField_a_of_type_Long	J
    //   288: invokevirtual 168	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   291: ldc 172
    //   293: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: aload_0
    //   297: getfield 50	bavu:jdField_a_of_type_Bayk	Lbayk;
    //   300: getfield 55	bayk:p	I
    //   303: invokevirtual 58	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   306: ldc 218
    //   308: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: aload_0
    //   312: getfield 65	bavu:jdField_a_of_type_Int	I
    //   315: invokevirtual 58	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   318: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   321: invokestatic 140	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   324: aload 6
    //   326: astore_3
    //   327: aload_0
    //   328: getfield 202	bavu:jdField_a_of_type_Awyt	Lawyt;
    //   331: aload 4
    //   333: iconst_0
    //   334: iload_2
    //   335: invokevirtual 207	awyt:a	([BII)Lawyq;
    //   338: astore 8
    //   340: aload 8
    //   342: ifnull +14 -> 356
    //   345: aload 6
    //   347: astore_3
    //   348: aload 8
    //   350: getfield 210	awyq:jdField_a_of_type_Int	I
    //   353: ifne +148 -> 501
    //   356: aload 6
    //   358: astore_3
    //   359: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   362: ifeq +14 -> 376
    //   365: aload 6
    //   367: astore_3
    //   368: ldc 135
    //   370: iconst_2
    //   371: ldc 220
    //   373: invokestatic 140	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   376: aload 6
    //   378: astore_3
    //   379: aload_0
    //   380: aload 7
    //   382: getfield 198	baxu:jdField_b_of_type_Boolean	Z
    //   385: iconst_0
    //   386: invokespecial 122	bavu:a	(ZZ)V
    //   389: iconst_0
    //   390: ifeq -383 -> 7
    //   393: new 222	java/lang/NullPointerException
    //   396: dup
    //   397: invokespecial 223	java/lang/NullPointerException:<init>	()V
    //   400: athrow
    //   401: astore_3
    //   402: aload_3
    //   403: invokevirtual 224	java/lang/Exception:printStackTrace	()V
    //   406: return
    //   407: aload 6
    //   409: astore_3
    //   410: aload_0
    //   411: getfield 163	bavu:jdField_b_of_type_Long	J
    //   414: aload_0
    //   415: getfield 158	bavu:jdField_a_of_type_Long	J
    //   418: lsub
    //   419: l2i
    //   420: newarray byte
    //   422: astore 4
    //   424: aload 6
    //   426: astore_3
    //   427: aload_0
    //   428: getfield 177	bavu:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   431: aload 4
    //   433: iconst_0
    //   434: aload_0
    //   435: getfield 163	bavu:jdField_b_of_type_Long	J
    //   438: aload_0
    //   439: getfield 158	bavu:jdField_a_of_type_Long	J
    //   442: lsub
    //   443: l2i
    //   444: invokevirtual 196	java/io/RandomAccessFile:read	([BII)I
    //   447: istore_1
    //   448: aload 6
    //   450: astore_3
    //   451: aload 7
    //   453: iconst_1
    //   454: putfield 198	baxu:jdField_b_of_type_Boolean	Z
    //   457: aload 6
    //   459: astore_3
    //   460: aload_0
    //   461: iconst_0
    //   462: putfield 65	bavu:jdField_a_of_type_Int	I
    //   465: goto -375 -> 90
    //   468: astore_3
    //   469: aload 5
    //   471: astore 4
    //   473: aload_3
    //   474: astore 5
    //   476: aload 4
    //   478: astore_3
    //   479: aload 5
    //   481: invokevirtual 186	java/io/IOException:printStackTrace	()V
    //   484: aload 4
    //   486: ifnull -479 -> 7
    //   489: aload 4
    //   491: invokevirtual 229	java/io/FileOutputStream:close	()V
    //   494: return
    //   495: astore_3
    //   496: aload_3
    //   497: invokevirtual 224	java/lang/Exception:printStackTrace	()V
    //   500: return
    //   501: aload 6
    //   503: astore_3
    //   504: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   507: ifeq +35 -> 542
    //   510: aload 6
    //   512: astore_3
    //   513: ldc 135
    //   515: iconst_2
    //   516: new 40	java/lang/StringBuilder
    //   519: dup
    //   520: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   523: ldc 231
    //   525: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   528: aload 8
    //   530: getfield 210	awyq:jdField_a_of_type_Int	I
    //   533: invokevirtual 58	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   536: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   539: invokestatic 140	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   542: aload 6
    //   544: astore_3
    //   545: new 82	java/io/File
    //   548: dup
    //   549: aload 7
    //   551: getfield 103	baxu:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   554: invokespecial 234	java/io/File:<init>	(Ljava/lang/String;)V
    //   557: astore 4
    //   559: aload 6
    //   561: astore_3
    //   562: aload 4
    //   564: invokevirtual 237	java/io/File:exists	()Z
    //   567: ifeq +12 -> 579
    //   570: aload 6
    //   572: astore_3
    //   573: aload 4
    //   575: invokevirtual 240	java/io/File:delete	()Z
    //   578: pop
    //   579: aload 6
    //   581: astore_3
    //   582: new 226	java/io/FileOutputStream
    //   585: dup
    //   586: aload 4
    //   588: invokespecial 243	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   591: astore 4
    //   593: aload 7
    //   595: getfield 107	baxu:jdField_a_of_type_Boolean	Z
    //   598: ifeq +132 -> 730
    //   601: aload 4
    //   603: getstatic 24	bavu:d	[B
    //   606: invokevirtual 247	java/io/FileOutputStream:write	([B)V
    //   609: aload_0
    //   610: aload_0
    //   611: getfield 65	bavu:jdField_a_of_type_Int	I
    //   614: aload 8
    //   616: getfield 210	awyq:jdField_a_of_type_Int	I
    //   619: getstatic 24	bavu:d	[B
    //   622: arraylength
    //   623: iadd
    //   624: iadd
    //   625: putfield 65	bavu:jdField_a_of_type_Int	I
    //   628: aload 4
    //   630: aload 8
    //   632: getfield 249	awyq:jdField_a_of_type_ArrayOfByte	[B
    //   635: aload 8
    //   637: getfield 250	awyq:jdField_b_of_type_Int	I
    //   640: aload 8
    //   642: getfield 210	awyq:jdField_a_of_type_Int	I
    //   645: invokevirtual 253	java/io/FileOutputStream:write	([BII)V
    //   648: aload 4
    //   650: invokevirtual 256	java/io/FileOutputStream:flush	()V
    //   653: aload_0
    //   654: aload 7
    //   656: putfield 117	bavu:jdField_a_of_type_Baxu	Lbaxu;
    //   659: aload_0
    //   660: aload 7
    //   662: invokevirtual 259	bavu:a	(Lbaxu;)V
    //   665: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   668: ifeq +45 -> 713
    //   671: ldc 135
    //   673: iconst_2
    //   674: new 40	java/lang/StringBuilder
    //   677: dup
    //   678: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   681: ldc_w 261
    //   684: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   687: aload_0
    //   688: getfield 65	bavu:jdField_a_of_type_Int	I
    //   691: invokevirtual 58	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   694: ldc_w 263
    //   697: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   700: getstatic 24	bavu:d	[B
    //   703: arraylength
    //   704: invokevirtual 58	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   707: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   710: invokestatic 140	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   713: aload 4
    //   715: ifnull -708 -> 7
    //   718: aload 4
    //   720: invokevirtual 229	java/io/FileOutputStream:close	()V
    //   723: return
    //   724: astore_3
    //   725: aload_3
    //   726: invokevirtual 224	java/lang/Exception:printStackTrace	()V
    //   729: return
    //   730: aload 7
    //   732: getfield 198	baxu:jdField_b_of_type_Boolean	Z
    //   735: ifne -107 -> 628
    //   738: aload_0
    //   739: aload_0
    //   740: getfield 65	bavu:jdField_a_of_type_Int	I
    //   743: aload 8
    //   745: getfield 210	awyq:jdField_a_of_type_Int	I
    //   748: iadd
    //   749: putfield 65	bavu:jdField_a_of_type_Int	I
    //   752: goto -124 -> 628
    //   755: astore 5
    //   757: goto -281 -> 476
    //   760: astore 5
    //   762: aload_3
    //   763: astore 4
    //   765: aload 5
    //   767: astore_3
    //   768: aload 4
    //   770: ifnull +8 -> 778
    //   773: aload 4
    //   775: invokevirtual 229	java/io/FileOutputStream:close	()V
    //   778: aload_3
    //   779: athrow
    //   780: astore 4
    //   782: aload 4
    //   784: invokevirtual 224	java/lang/Exception:printStackTrace	()V
    //   787: goto -9 -> 778
    //   790: astore_3
    //   791: goto -23 -> 768
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	794	0	this	bavu
    //   65	383	1	i	int
    //   91	244	2	j	int
    //   22	357	3	localObject1	java.lang.Object
    //   401	2	3	localException1	Exception
    //   409	51	3	localObject2	java.lang.Object
    //   468	6	3	localIOException1	IOException
    //   478	1	3	localObject3	java.lang.Object
    //   495	2	3	localException2	Exception
    //   503	79	3	localObject4	java.lang.Object
    //   724	39	3	localException3	Exception
    //   767	12	3	localObject5	java.lang.Object
    //   790	1	3	localObject6	java.lang.Object
    //   47	727	4	localObject7	java.lang.Object
    //   780	3	4	localException4	Exception
    //   18	462	5	localObject8	java.lang.Object
    //   755	1	5	localIOException2	IOException
    //   760	6	5	localObject9	java.lang.Object
    //   15	565	6	localObject10	java.lang.Object
    //   12	719	7	localbaxu	baxu
    //   159	585	8	localObject11	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   393	401	401	java/lang/Exception
    //   23	39	468	java/io/IOException
    //   42	49	468	java/io/IOException
    //   52	66	468	java/io/IOException
    //   69	81	468	java/io/IOException
    //   84	90	468	java/io/IOException
    //   95	103	468	java/io/IOException
    //   108	124	468	java/io/IOException
    //   127	133	468	java/io/IOException
    //   136	144	468	java/io/IOException
    //   147	161	468	java/io/IOException
    //   164	185	468	java/io/IOException
    //   190	207	468	java/io/IOException
    //   210	216	468	java/io/IOException
    //   219	227	468	java/io/IOException
    //   230	236	468	java/io/IOException
    //   239	244	468	java/io/IOException
    //   249	255	468	java/io/IOException
    //   258	324	468	java/io/IOException
    //   327	340	468	java/io/IOException
    //   348	356	468	java/io/IOException
    //   359	365	468	java/io/IOException
    //   368	376	468	java/io/IOException
    //   379	389	468	java/io/IOException
    //   410	424	468	java/io/IOException
    //   427	448	468	java/io/IOException
    //   451	457	468	java/io/IOException
    //   460	465	468	java/io/IOException
    //   504	510	468	java/io/IOException
    //   513	542	468	java/io/IOException
    //   545	559	468	java/io/IOException
    //   562	570	468	java/io/IOException
    //   573	579	468	java/io/IOException
    //   582	593	468	java/io/IOException
    //   489	494	495	java/lang/Exception
    //   718	723	724	java/lang/Exception
    //   593	628	755	java/io/IOException
    //   628	713	755	java/io/IOException
    //   730	752	755	java/io/IOException
    //   23	39	760	finally
    //   42	49	760	finally
    //   52	66	760	finally
    //   69	81	760	finally
    //   84	90	760	finally
    //   95	103	760	finally
    //   108	124	760	finally
    //   127	133	760	finally
    //   136	144	760	finally
    //   147	161	760	finally
    //   164	185	760	finally
    //   190	207	760	finally
    //   210	216	760	finally
    //   219	227	760	finally
    //   230	236	760	finally
    //   239	244	760	finally
    //   249	255	760	finally
    //   258	324	760	finally
    //   327	340	760	finally
    //   348	356	760	finally
    //   359	365	760	finally
    //   368	376	760	finally
    //   379	389	760	finally
    //   410	424	760	finally
    //   427	448	760	finally
    //   451	457	760	finally
    //   460	465	760	finally
    //   479	484	760	finally
    //   504	510	760	finally
    //   513	542	760	finally
    //   545	559	760	finally
    //   562	570	760	finally
    //   573	579	760	finally
    //   582	593	760	finally
    //   773	778	780	java/lang/Exception
    //   593	628	790	finally
    //   628	713	790	finally
    //   730	752	790	finally
  }
  
  public int a()
  {
    int i = super.a();
    if (QLog.isColorLevel()) {
      QLog.d("PttSliceUploadProcessor", 2, "cancel");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction != null) {
      this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.cancelTransaction();
    }
    return i;
  }
  
  public void a(baxu parambaxu)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PttSliceUploadProcessor", 2, "submitSlice, info:" + parambaxu);
    }
    bavv localbavv = new bavv(this, SystemClock.uptimeMillis());
    this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction = new Transaction(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), 68, parambaxu.jdField_b_of_type_JavaLangString, (int)this.r, a(parambaxu.jdField_b_of_type_JavaLangString), localbavv, baxt.a(parambaxu).toByteArray(), false);
    int i = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getHwEngine().submitTransactionTask(this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction);
    if (QLog.isColorLevel()) {
      QLog.d("PttSliceUploadProcessor", 2, "<BDH_LOG> Transaction submit RetCode:" + i + " T_ID:" + this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.getTransationId() + " UniSeq:" + this.jdField_a_of_type_Bayk.jdField_a_of_type_Long + " bean:" + parambaxu + " Cmd:");
    }
    if (i != 0)
    {
      a(i, "SubmitError.", "", this.jdField_b_of_type_Barh);
      d();
    }
  }
  
  /* Error */
  byte[] a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: new 357	java/io/FileInputStream
    //   9: dup
    //   10: aload_1
    //   11: invokespecial 358	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   14: astore 4
    //   16: aload 4
    //   18: astore_3
    //   19: aload 4
    //   21: aload_0
    //   22: getfield 361	bavu:jdField_a_of_type_Bass	Lbass;
    //   25: getfield 364	bass:jdField_a_of_type_Long	J
    //   28: invokestatic 370	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   31: astore 7
    //   33: aload 7
    //   35: astore_1
    //   36: aload_1
    //   37: astore_3
    //   38: aload 4
    //   40: ifnull +10 -> 50
    //   43: aload 4
    //   45: invokevirtual 371	java/io/FileInputStream:close	()V
    //   48: aload_1
    //   49: astore_3
    //   50: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   53: ifeq +32 -> 85
    //   56: ldc 135
    //   58: iconst_2
    //   59: new 40	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   66: ldc_w 373
    //   69: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: aload_3
    //   73: invokestatic 379	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   76: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokestatic 140	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   85: aload_3
    //   86: areturn
    //   87: astore_3
    //   88: aload 4
    //   90: astore_3
    //   91: new 82	java/io/File
    //   94: dup
    //   95: aload_1
    //   96: invokespecial 234	java/io/File:<init>	(Ljava/lang/String;)V
    //   99: astore 7
    //   101: aload 4
    //   103: astore_3
    //   104: aload 7
    //   106: invokevirtual 237	java/io/File:exists	()Z
    //   109: istore_2
    //   110: aload 5
    //   112: astore_1
    //   113: iload_2
    //   114: ifeq -78 -> 36
    //   117: aload 4
    //   119: astore_3
    //   120: aload 7
    //   122: invokestatic 384	bhpp:a	(Ljava/io/File;)Ljava/lang/String;
    //   125: astore_1
    //   126: aload_1
    //   127: ifnull +14 -> 141
    //   130: aload 4
    //   132: astore_3
    //   133: aload_1
    //   134: invokestatic 387	com/qq/taf/jce/HexUtil:hexStr2Bytes	(Ljava/lang/String;)[B
    //   137: astore_1
    //   138: goto -102 -> 36
    //   141: ldc 31
    //   143: astore_1
    //   144: goto -14 -> 130
    //   147: astore_3
    //   148: aload_3
    //   149: invokevirtual 186	java/io/IOException:printStackTrace	()V
    //   152: aload_1
    //   153: astore_3
    //   154: goto -104 -> 50
    //   157: astore 5
    //   159: aconst_null
    //   160: astore_1
    //   161: aload_1
    //   162: astore_3
    //   163: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   166: ifeq +32 -> 198
    //   169: aload_1
    //   170: astore_3
    //   171: ldc 135
    //   173: iconst_2
    //   174: new 40	java/lang/StringBuilder
    //   177: dup
    //   178: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   181: ldc_w 389
    //   184: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: aload 5
    //   189: invokevirtual 280	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   192: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: invokestatic 140	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   198: aload 6
    //   200: astore_3
    //   201: aload_1
    //   202: ifnull -152 -> 50
    //   205: aload_1
    //   206: invokevirtual 371	java/io/FileInputStream:close	()V
    //   209: aload 6
    //   211: astore_3
    //   212: goto -162 -> 50
    //   215: astore_1
    //   216: aload_1
    //   217: invokevirtual 186	java/io/IOException:printStackTrace	()V
    //   220: aload 6
    //   222: astore_3
    //   223: goto -173 -> 50
    //   226: astore_1
    //   227: aconst_null
    //   228: astore_3
    //   229: aload_3
    //   230: ifnull +7 -> 237
    //   233: aload_3
    //   234: invokevirtual 371	java/io/FileInputStream:close	()V
    //   237: aload_1
    //   238: athrow
    //   239: astore_3
    //   240: aload_3
    //   241: invokevirtual 186	java/io/IOException:printStackTrace	()V
    //   244: goto -7 -> 237
    //   247: astore_1
    //   248: goto -19 -> 229
    //   251: astore 5
    //   253: aload 4
    //   255: astore_1
    //   256: goto -95 -> 161
    //   259: astore_1
    //   260: aload 5
    //   262: astore_1
    //   263: goto -227 -> 36
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	266	0	this	bavu
    //   0	266	1	paramString	String
    //   109	5	2	bool	boolean
    //   18	68	3	localObject1	java.lang.Object
    //   87	1	3	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
    //   90	43	3	localFileInputStream1	java.io.FileInputStream
    //   147	2	3	localIOException1	IOException
    //   153	81	3	localObject2	java.lang.Object
    //   239	2	3	localIOException2	IOException
    //   14	240	4	localFileInputStream2	java.io.FileInputStream
    //   4	107	5	localObject3	java.lang.Object
    //   157	31	5	localIOException3	IOException
    //   251	10	5	localIOException4	IOException
    //   1	220	6	localObject4	java.lang.Object
    //   31	90	7	localObject5	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   19	33	87	java/lang/UnsatisfiedLinkError
    //   43	48	147	java/io/IOException
    //   6	16	157	java/io/IOException
    //   205	209	215	java/io/IOException
    //   6	16	226	finally
    //   233	237	239	java/io/IOException
    //   19	33	247	finally
    //   91	101	247	finally
    //   104	110	247	finally
    //   120	126	247	finally
    //   133	138	247	finally
    //   163	169	247	finally
    //   171	198	247	finally
    //   19	33	251	java/io/IOException
    //   91	101	251	java/io/IOException
    //   104	110	251	java/io/IOException
    //   120	126	259	java/io/IOException
    //   133	138	259	java/io/IOException
  }
  
  public void aP_()
  {
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Bayk.jdField_o_of_type_JavaLangString;
    if (this.jdField_b_of_type_JavaLangString == null)
    {
      b(9042, "No pcm source");
      d();
      return;
    }
    if ((this.jdField_a_of_type_ArrayOfByte == null) && (!h()))
    {
      b(9041, "No Local MD5");
      d();
      return;
    }
    if (this.jdField_a_of_type_JavaIoRandomAccessFile == null) {
      try
      {
        this.jdField_a_of_type_JavaIoRandomAccessFile = new RandomAccessFile(this.jdField_b_of_type_JavaLangString, "r");
        this.jdField_a_of_type_JavaIoRandomAccessFile.seek(0L);
        if (this.jdField_a_of_type_JavaIoRandomAccessFile == null)
        {
          b(9303, "read file error");
          d();
          return;
        }
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        for (;;)
        {
          localFileNotFoundException.printStackTrace();
          this.jdField_a_of_type_JavaIoRandomAccessFile = null;
        }
      }
      catch (IOException localIOException1)
      {
        for (;;)
        {
          localIOException1.printStackTrace();
        }
      }
    }
    File localFile = new File(this.jdField_b_of_type_JavaLangString);
    if (!localFile.exists())
    {
      b(9042, a(new Exception("sendFile not exist " + this.jdField_b_of_type_JavaLangString)));
      d();
      return;
    }
    this.q = localFile.length();
    this.jdField_a_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
    if (QLog.isColorLevel()) {
      QLog.d("PttSliceUploadProcessor", 2, "start, voiceID=" + this.jdField_a_of_type_JavaLangString + " pos=" + this.jdField_a_of_type_Bayk.p + " num=" + this.jdField_a_of_type_Bayk.jdField_o_of_type_Int + " this=" + this);
    }
    this.jdField_a_of_type_Awyt = new awyt();
    this.jdField_a_of_type_Awyt.a(new SilkCodecWrapper(BaseApplication.getContext()));
    try
    {
      this.jdField_a_of_type_Awyt.a(16000, 16000, 1);
      f();
      return;
    }
    catch (IOException localIOException2)
    {
      for (;;)
      {
        localIOException2.printStackTrace();
      }
    }
  }
  
  protected void finalize()
  {
    super.finalize();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bavu
 * JD-Core Version:    0.7.0.1
 */
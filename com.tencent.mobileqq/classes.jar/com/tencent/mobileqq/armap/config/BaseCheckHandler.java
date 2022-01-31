package com.tencent.mobileqq.armap.config;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.armap.ArMapInterface;
import com.tencent.mobileqq.armap.ResDownloadManager;
import com.tencent.mobileqq.armap.ResDownloadManager.IResDownloadListener;
import com.tencent.mobileqq.armap.utils.ARResUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public abstract class BaseCheckHandler
  implements ResDownloadManager.IResDownloadListener
{
  public static final String a;
  public static final String b;
  public static final String c = ARResUtil.a() + File.separator + "map_version";
  public static String e = "";
  public AppInterface a;
  public ResDownloadManager a;
  BaseCheckHandler.ExistsDirInfos jdField_a_of_type_ComTencentMobileqqArmapConfigBaseCheckHandler$ExistsDirInfos;
  public Object a;
  List jdField_a_of_type_JavaUtilList = new ArrayList();
  public boolean a;
  public String d;
  
  static
  {
    jdField_a_of_type_JavaLangString = ARResUtil.a() + "/tree/";
    jdField_b_of_type_JavaLangString = ARResUtil.a() + "/poi/";
  }
  
  public BaseCheckHandler(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    if ((paramAppInterface instanceof QQAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager = ((ResDownloadManager)((QQAppInterface)paramAppInterface).getManager(190));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager.a(this);
      }
      this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(9));
      this.d = a();
      return;
      if ((paramAppInterface instanceof ArMapInterface)) {
        this.jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager = ((ArMapInterface)paramAppInterface).a();
      }
    }
  }
  
  /* Error */
  public static BaseCheckHandler.ExistsDirInfos a()
  {
    // Byte code:
    //   0: new 47	java/io/File
    //   3: dup
    //   4: getstatic 54	com/tencent/mobileqq/armap/config/BaseCheckHandler:c	Ljava/lang/String;
    //   7: invokespecial 111	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: astore_0
    //   11: aload_0
    //   12: invokevirtual 115	java/io/File:exists	()Z
    //   15: ifne +19 -> 34
    //   18: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   21: ifeq +11 -> 32
    //   24: ldc 122
    //   26: iconst_2
    //   27: ldc 124
    //   29: invokestatic 127	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   32: aconst_null
    //   33: areturn
    //   34: new 129	java/io/FileInputStream
    //   37: dup
    //   38: aload_0
    //   39: invokespecial 132	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   42: astore_3
    //   43: new 134	java/io/BufferedInputStream
    //   46: dup
    //   47: aload_3
    //   48: invokespecial 137	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   51: astore_2
    //   52: new 139	java/io/ObjectInputStream
    //   55: dup
    //   56: aload_2
    //   57: invokespecial 140	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   60: astore 7
    //   62: aload 7
    //   64: astore 6
    //   66: aload_2
    //   67: astore 5
    //   69: aload_3
    //   70: astore 4
    //   72: aload 7
    //   74: invokevirtual 144	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   77: checkcast 146	com/tencent/mobileqq/armap/config/BaseCheckHandler$ExistsDirInfos
    //   80: astore_1
    //   81: aload_3
    //   82: ifnull +7 -> 89
    //   85: aload_3
    //   86: invokevirtual 149	java/io/FileInputStream:close	()V
    //   89: aload_2
    //   90: ifnull +7 -> 97
    //   93: aload_2
    //   94: invokevirtual 150	java/io/BufferedInputStream:close	()V
    //   97: aload_1
    //   98: astore_0
    //   99: aload 7
    //   101: ifnull +10 -> 111
    //   104: aload 7
    //   106: invokevirtual 151	java/io/ObjectInputStream:close	()V
    //   109: aload_1
    //   110: astore_0
    //   111: aload_0
    //   112: areturn
    //   113: astore_0
    //   114: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   117: ifeq -28 -> 89
    //   120: aload_0
    //   121: invokevirtual 154	java/io/IOException:printStackTrace	()V
    //   124: goto -35 -> 89
    //   127: astore_0
    //   128: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   131: ifeq -34 -> 97
    //   134: aload_0
    //   135: invokevirtual 154	java/io/IOException:printStackTrace	()V
    //   138: goto -41 -> 97
    //   141: astore_2
    //   142: aload_1
    //   143: astore_0
    //   144: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   147: ifeq -36 -> 111
    //   150: aload_2
    //   151: invokevirtual 154	java/io/IOException:printStackTrace	()V
    //   154: aload_1
    //   155: astore_0
    //   156: goto -45 -> 111
    //   159: astore_1
    //   160: aconst_null
    //   161: astore_0
    //   162: aconst_null
    //   163: astore_2
    //   164: aconst_null
    //   165: astore_3
    //   166: aload_0
    //   167: astore 6
    //   169: aload_2
    //   170: astore 5
    //   172: aload_3
    //   173: astore 4
    //   175: ldc 122
    //   177: iconst_1
    //   178: new 22	java/lang/StringBuilder
    //   181: dup
    //   182: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   185: ldc 156
    //   187: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: aload_1
    //   191: invokevirtual 157	java/lang/Exception:toString	()Ljava/lang/String;
    //   194: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: invokestatic 127	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   203: aload_3
    //   204: ifnull +7 -> 211
    //   207: aload_3
    //   208: invokevirtual 149	java/io/FileInputStream:close	()V
    //   211: aload_2
    //   212: ifnull +7 -> 219
    //   215: aload_2
    //   216: invokevirtual 150	java/io/BufferedInputStream:close	()V
    //   219: aload_0
    //   220: ifnull +179 -> 399
    //   223: aload_0
    //   224: invokevirtual 151	java/io/ObjectInputStream:close	()V
    //   227: aconst_null
    //   228: astore_0
    //   229: goto -118 -> 111
    //   232: astore_1
    //   233: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   236: ifeq -25 -> 211
    //   239: aload_1
    //   240: invokevirtual 154	java/io/IOException:printStackTrace	()V
    //   243: goto -32 -> 211
    //   246: astore_1
    //   247: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   250: ifeq -31 -> 219
    //   253: aload_1
    //   254: invokevirtual 154	java/io/IOException:printStackTrace	()V
    //   257: goto -38 -> 219
    //   260: astore_0
    //   261: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   264: ifeq +7 -> 271
    //   267: aload_0
    //   268: invokevirtual 154	java/io/IOException:printStackTrace	()V
    //   271: aconst_null
    //   272: astore_0
    //   273: goto -162 -> 111
    //   276: astore_0
    //   277: aconst_null
    //   278: astore_1
    //   279: aconst_null
    //   280: astore_2
    //   281: aconst_null
    //   282: astore_3
    //   283: aload_3
    //   284: ifnull +7 -> 291
    //   287: aload_3
    //   288: invokevirtual 149	java/io/FileInputStream:close	()V
    //   291: aload_2
    //   292: ifnull +7 -> 299
    //   295: aload_2
    //   296: invokevirtual 150	java/io/BufferedInputStream:close	()V
    //   299: aload_1
    //   300: ifnull +7 -> 307
    //   303: aload_1
    //   304: invokevirtual 151	java/io/ObjectInputStream:close	()V
    //   307: aload_0
    //   308: athrow
    //   309: astore_3
    //   310: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   313: ifeq -22 -> 291
    //   316: aload_3
    //   317: invokevirtual 154	java/io/IOException:printStackTrace	()V
    //   320: goto -29 -> 291
    //   323: astore_2
    //   324: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   327: ifeq -28 -> 299
    //   330: aload_2
    //   331: invokevirtual 154	java/io/IOException:printStackTrace	()V
    //   334: goto -35 -> 299
    //   337: astore_1
    //   338: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   341: ifeq -34 -> 307
    //   344: aload_1
    //   345: invokevirtual 154	java/io/IOException:printStackTrace	()V
    //   348: goto -41 -> 307
    //   351: astore_0
    //   352: aconst_null
    //   353: astore_1
    //   354: aconst_null
    //   355: astore_2
    //   356: goto -73 -> 283
    //   359: astore_0
    //   360: aconst_null
    //   361: astore_1
    //   362: goto -79 -> 283
    //   365: astore_0
    //   366: aload 6
    //   368: astore_1
    //   369: aload 5
    //   371: astore_2
    //   372: aload 4
    //   374: astore_3
    //   375: goto -92 -> 283
    //   378: astore_1
    //   379: aconst_null
    //   380: astore_0
    //   381: aconst_null
    //   382: astore_2
    //   383: goto -217 -> 166
    //   386: astore_1
    //   387: aconst_null
    //   388: astore_0
    //   389: goto -223 -> 166
    //   392: astore_1
    //   393: aload 7
    //   395: astore_0
    //   396: goto -230 -> 166
    //   399: aconst_null
    //   400: astore_0
    //   401: goto -290 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   10	102	0	localObject1	Object
    //   113	8	0	localIOException1	java.io.IOException
    //   127	8	0	localIOException2	java.io.IOException
    //   143	86	0	localObject2	Object
    //   260	8	0	localIOException3	java.io.IOException
    //   272	1	0	localObject3	Object
    //   276	32	0	localObject4	Object
    //   351	1	0	localObject5	Object
    //   359	1	0	localObject6	Object
    //   365	1	0	localObject7	Object
    //   380	21	0	localObject8	Object
    //   80	75	1	localExistsDirInfos	BaseCheckHandler.ExistsDirInfos
    //   159	32	1	localException1	Exception
    //   232	8	1	localIOException4	java.io.IOException
    //   246	8	1	localIOException5	java.io.IOException
    //   278	26	1	localObject9	Object
    //   337	8	1	localIOException6	java.io.IOException
    //   353	16	1	localObject10	Object
    //   378	1	1	localException2	Exception
    //   386	1	1	localException3	Exception
    //   392	1	1	localException4	Exception
    //   51	43	2	localBufferedInputStream	java.io.BufferedInputStream
    //   141	10	2	localIOException7	java.io.IOException
    //   163	133	2	localObject11	Object
    //   323	8	2	localIOException8	java.io.IOException
    //   355	28	2	localObject12	Object
    //   42	246	3	localFileInputStream1	java.io.FileInputStream
    //   309	8	3	localIOException9	java.io.IOException
    //   374	1	3	localObject13	Object
    //   70	303	4	localFileInputStream2	java.io.FileInputStream
    //   67	303	5	localObject14	Object
    //   64	303	6	localObject15	Object
    //   60	334	7	localObjectInputStream	java.io.ObjectInputStream
    // Exception table:
    //   from	to	target	type
    //   85	89	113	java/io/IOException
    //   93	97	127	java/io/IOException
    //   104	109	141	java/io/IOException
    //   34	43	159	java/lang/Exception
    //   207	211	232	java/io/IOException
    //   215	219	246	java/io/IOException
    //   223	227	260	java/io/IOException
    //   34	43	276	finally
    //   287	291	309	java/io/IOException
    //   295	299	323	java/io/IOException
    //   303	307	337	java/io/IOException
    //   43	52	351	finally
    //   52	62	359	finally
    //   72	81	365	finally
    //   175	203	365	finally
    //   43	52	378	java/lang/Exception
    //   52	62	386	java/lang/Exception
    //   72	81	392	java/lang/Exception
  }
  
  /* Error */
  private static List a(String paramString1, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: new 63	java/util/ArrayList
    //   6: dup
    //   7: invokespecial 64	java/util/ArrayList:<init>	()V
    //   10: astore 15
    //   12: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15: ifeq +37 -> 52
    //   18: ldc 122
    //   20: iconst_2
    //   21: new 22	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   28: ldc 160
    //   30: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload_0
    //   34: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc 162
    //   39: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_1
    //   43: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 127	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   52: new 129	java/io/FileInputStream
    //   55: dup
    //   56: aload_0
    //   57: invokespecial 163	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   60: astore_0
    //   61: new 134	java/io/BufferedInputStream
    //   64: dup
    //   65: aload_0
    //   66: invokespecial 137	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   69: astore 8
    //   71: new 165	com/tencent/commonsdk/zip/QZipInputStream
    //   74: dup
    //   75: aload 8
    //   77: invokespecial 166	com/tencent/commonsdk/zip/QZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   80: astore 9
    //   82: new 47	java/io/File
    //   85: dup
    //   86: aload_1
    //   87: invokespecial 111	java/io/File:<init>	(Ljava/lang/String;)V
    //   90: invokevirtual 169	java/io/File:mkdirs	()Z
    //   93: pop
    //   94: invokestatic 175	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   97: sipush 8192
    //   100: invokevirtual 179	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   103: astore 16
    //   105: aconst_null
    //   106: astore 10
    //   108: aconst_null
    //   109: astore 12
    //   111: aload 9
    //   113: invokevirtual 183	com/tencent/commonsdk/zip/QZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   116: astore 11
    //   118: aload 11
    //   120: ifnonnull +89 -> 209
    //   123: invokestatic 175	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   126: aload 16
    //   128: invokevirtual 187	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   131: invokestatic 193	java/lang/Math:random	()D
    //   134: ldc2_w 194
    //   137: dcmpg
    //   138: ifge +20 -> 158
    //   141: invokestatic 201	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   144: invokestatic 206	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   147: aconst_null
    //   148: ldc 208
    //   150: iconst_1
    //   151: lconst_0
    //   152: lconst_0
    //   153: aconst_null
    //   154: aconst_null
    //   155: invokevirtual 211	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   158: aload 9
    //   160: ifnull +8 -> 168
    //   163: aload 9
    //   165: invokevirtual 212	com/tencent/commonsdk/zip/QZipInputStream:close	()V
    //   168: aload 8
    //   170: ifnull +8 -> 178
    //   173: aload 8
    //   175: invokevirtual 150	java/io/BufferedInputStream:close	()V
    //   178: aload_0
    //   179: ifnull +7 -> 186
    //   182: aload_0
    //   183: invokevirtual 149	java/io/FileInputStream:close	()V
    //   186: aload 12
    //   188: ifnull +8 -> 196
    //   191: aload 12
    //   193: invokevirtual 215	java/io/FileOutputStream:close	()V
    //   196: aload 10
    //   198: ifnull +8 -> 206
    //   201: aload 10
    //   203: invokevirtual 218	java/io/BufferedOutputStream:close	()V
    //   206: aload 15
    //   208: areturn
    //   209: aload 11
    //   211: invokevirtual 223	java/util/zip/ZipEntry:isDirectory	()Z
    //   214: ifne -103 -> 111
    //   217: aload 11
    //   219: invokevirtual 226	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   222: astore 11
    //   224: aload 11
    //   226: ifnull -115 -> 111
    //   229: aload 11
    //   231: ldc 228
    //   233: invokevirtual 234	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   236: ifne -125 -> 111
    //   239: aload 11
    //   241: getstatic 238	java/io/File:separatorChar	C
    //   244: invokevirtual 242	java/lang/String:lastIndexOf	(I)I
    //   247: istore_3
    //   248: iload_3
    //   249: aload 11
    //   251: invokevirtual 246	java/lang/String:length	()I
    //   254: iconst_1
    //   255: isub
    //   256: if_icmpne +143 -> 399
    //   259: new 248	java/lang/IllegalArgumentException
    //   262: dup
    //   263: new 22	java/lang/StringBuilder
    //   266: dup
    //   267: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   270: ldc 250
    //   272: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: aload 11
    //   277: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   283: invokespecial 251	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   286: athrow
    //   287: astore 13
    //   289: aload_0
    //   290: astore 11
    //   292: aload 10
    //   294: astore_1
    //   295: iconst_0
    //   296: istore_3
    //   297: aload 13
    //   299: astore_0
    //   300: aload 8
    //   302: astore 10
    //   304: aload 12
    //   306: astore 8
    //   308: invokestatic 193	java/lang/Math:random	()D
    //   311: ldc2_w 194
    //   314: dcmpg
    //   315: ifge +30 -> 345
    //   318: invokestatic 201	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   321: invokestatic 206	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   324: astore 12
    //   326: iload_3
    //   327: ifne +440 -> 767
    //   330: iconst_1
    //   331: istore_2
    //   332: aload 12
    //   334: aconst_null
    //   335: ldc 208
    //   337: iload_2
    //   338: lconst_0
    //   339: lconst_0
    //   340: aconst_null
    //   341: aconst_null
    //   342: invokevirtual 211	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   345: aload 9
    //   347: ifnull +12 -> 359
    //   350: iload_3
    //   351: ifne +8 -> 359
    //   354: aload 9
    //   356: invokevirtual 212	com/tencent/commonsdk/zip/QZipInputStream:close	()V
    //   359: aload 10
    //   361: ifnull +8 -> 369
    //   364: aload 10
    //   366: invokevirtual 150	java/io/BufferedInputStream:close	()V
    //   369: aload 11
    //   371: ifnull +8 -> 379
    //   374: aload 11
    //   376: invokevirtual 149	java/io/FileInputStream:close	()V
    //   379: aload 8
    //   381: ifnull +8 -> 389
    //   384: aload 8
    //   386: invokevirtual 215	java/io/FileOutputStream:close	()V
    //   389: aload_1
    //   390: ifnull +7 -> 397
    //   393: aload_1
    //   394: invokevirtual 218	java/io/BufferedOutputStream:close	()V
    //   397: aload_0
    //   398: athrow
    //   399: iload_3
    //   400: ifgt +227 -> 627
    //   403: iload_3
    //   404: ifge +209 -> 613
    //   407: aload_1
    //   408: astore 13
    //   410: aload 11
    //   412: astore 14
    //   414: iload_2
    //   415: ifeq +28 -> 443
    //   418: aload 11
    //   420: ldc 253
    //   422: invokevirtual 256	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   425: istore_3
    //   426: aload 11
    //   428: astore 14
    //   430: iload_3
    //   431: ifle +12 -> 443
    //   434: aload 11
    //   436: iconst_0
    //   437: iload_3
    //   438: invokevirtual 260	java/lang/String:substring	(II)Ljava/lang/String;
    //   441: astore 14
    //   443: new 47	java/io/File
    //   446: dup
    //   447: aload 13
    //   449: aload 14
    //   451: invokespecial 263	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   454: astore 11
    //   456: aload 11
    //   458: invokevirtual 267	java/io/File:getParentFile	()Ljava/io/File;
    //   461: invokevirtual 115	java/io/File:exists	()Z
    //   464: ifne +12 -> 476
    //   467: aload 11
    //   469: invokevirtual 267	java/io/File:getParentFile	()Ljava/io/File;
    //   472: invokevirtual 169	java/io/File:mkdirs	()Z
    //   475: pop
    //   476: aload 11
    //   478: invokevirtual 115	java/io/File:exists	()Z
    //   481: ifeq +9 -> 490
    //   484: aload 11
    //   486: invokevirtual 270	java/io/File:delete	()Z
    //   489: pop
    //   490: aload 15
    //   492: aload 11
    //   494: invokevirtual 273	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   497: invokeinterface 95 2 0
    //   502: pop
    //   503: new 214	java/io/FileOutputStream
    //   506: dup
    //   507: aload 11
    //   509: invokespecial 274	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   512: astore 11
    //   514: new 217	java/io/BufferedOutputStream
    //   517: dup
    //   518: aload 11
    //   520: aload 16
    //   522: arraylength
    //   523: invokespecial 277	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   526: astore 12
    //   528: iconst_0
    //   529: istore 5
    //   531: iload 6
    //   533: istore_3
    //   534: aload 9
    //   536: aload 16
    //   538: iconst_0
    //   539: aload 16
    //   541: arraylength
    //   542: invokevirtual 281	com/tencent/commonsdk/zip/QZipInputStream:read	([BII)I
    //   545: istore 7
    //   547: iload 7
    //   549: iconst_m1
    //   550: if_icmpeq +182 -> 732
    //   553: iload 5
    //   555: istore 4
    //   557: iload 7
    //   559: ifne +153 -> 712
    //   562: iload 5
    //   564: iconst_1
    //   565: iadd
    //   566: istore_3
    //   567: iload_3
    //   568: istore 4
    //   570: iload_3
    //   571: bipush 10
    //   573: if_icmple +139 -> 712
    //   576: iconst_1
    //   577: istore_3
    //   578: new 108	java/io/IOException
    //   581: dup
    //   582: ldc_w 283
    //   585: invokespecial 284	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   588: athrow
    //   589: astore_1
    //   590: aload 8
    //   592: astore 10
    //   594: aload_0
    //   595: astore 13
    //   597: aload 11
    //   599: astore 8
    //   601: aload_1
    //   602: astore_0
    //   603: aload 12
    //   605: astore_1
    //   606: aload 13
    //   608: astore 11
    //   610: goto -302 -> 308
    //   613: aload 11
    //   615: iconst_1
    //   616: invokevirtual 287	java/lang/String:substring	(I)Ljava/lang/String;
    //   619: astore 11
    //   621: aload_1
    //   622: astore 13
    //   624: goto -214 -> 410
    //   627: aload 11
    //   629: iconst_0
    //   630: iload_3
    //   631: invokevirtual 260	java/lang/String:substring	(II)Ljava/lang/String;
    //   634: astore 13
    //   636: aload 13
    //   638: iconst_0
    //   639: invokevirtual 291	java/lang/String:charAt	(I)C
    //   642: getstatic 238	java/io/File:separatorChar	C
    //   645: if_icmpne +37 -> 682
    //   648: new 22	java/lang/StringBuilder
    //   651: dup
    //   652: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   655: aload_1
    //   656: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   659: aload 13
    //   661: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   664: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   667: astore 13
    //   669: aload 11
    //   671: iload_3
    //   672: iconst_1
    //   673: iadd
    //   674: invokevirtual 287	java/lang/String:substring	(I)Ljava/lang/String;
    //   677: astore 11
    //   679: goto -269 -> 410
    //   682: new 22	java/lang/StringBuilder
    //   685: dup
    //   686: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   689: aload_1
    //   690: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   693: getstatic 238	java/io/File:separatorChar	C
    //   696: invokevirtual 294	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   699: aload 13
    //   701: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   704: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   707: astore 13
    //   709: goto -40 -> 669
    //   712: iload 6
    //   714: istore_3
    //   715: aload 12
    //   717: aload 16
    //   719: iconst_0
    //   720: iload 7
    //   722: invokevirtual 298	java/io/BufferedOutputStream:write	([BII)V
    //   725: iload 4
    //   727: istore 5
    //   729: goto -198 -> 531
    //   732: iload 6
    //   734: istore_3
    //   735: aload 12
    //   737: invokevirtual 301	java/io/BufferedOutputStream:flush	()V
    //   740: iload 6
    //   742: istore_3
    //   743: aload 12
    //   745: invokevirtual 218	java/io/BufferedOutputStream:close	()V
    //   748: iload 6
    //   750: istore_3
    //   751: aload 11
    //   753: invokevirtual 215	java/io/FileOutputStream:close	()V
    //   756: aload 12
    //   758: astore 10
    //   760: aload 11
    //   762: astore 12
    //   764: goto -653 -> 111
    //   767: iconst_0
    //   768: istore_2
    //   769: goto -437 -> 332
    //   772: astore_1
    //   773: goto -605 -> 168
    //   776: astore_1
    //   777: goto -599 -> 178
    //   780: astore_0
    //   781: goto -595 -> 186
    //   784: astore_0
    //   785: goto -589 -> 196
    //   788: astore_0
    //   789: aload 15
    //   791: areturn
    //   792: astore 9
    //   794: goto -435 -> 359
    //   797: astore 9
    //   799: goto -430 -> 369
    //   802: astore 9
    //   804: goto -425 -> 379
    //   807: astore 8
    //   809: goto -420 -> 389
    //   812: astore_1
    //   813: goto -416 -> 397
    //   816: astore_0
    //   817: iconst_0
    //   818: istore_3
    //   819: aconst_null
    //   820: astore_1
    //   821: aconst_null
    //   822: astore 8
    //   824: aconst_null
    //   825: astore 9
    //   827: aconst_null
    //   828: astore 10
    //   830: aconst_null
    //   831: astore 11
    //   833: goto -525 -> 308
    //   836: astore_1
    //   837: iconst_0
    //   838: istore_3
    //   839: aconst_null
    //   840: astore 12
    //   842: aconst_null
    //   843: astore 8
    //   845: aconst_null
    //   846: astore 10
    //   848: aload_0
    //   849: astore 11
    //   851: aconst_null
    //   852: astore 9
    //   854: aload_1
    //   855: astore_0
    //   856: aload 12
    //   858: astore_1
    //   859: goto -551 -> 308
    //   862: astore_1
    //   863: iconst_0
    //   864: istore_3
    //   865: aconst_null
    //   866: astore 9
    //   868: aload 8
    //   870: astore 10
    //   872: aload_0
    //   873: astore 11
    //   875: aconst_null
    //   876: astore 8
    //   878: aconst_null
    //   879: astore 12
    //   881: aload_1
    //   882: astore_0
    //   883: aload 9
    //   885: astore_1
    //   886: aload 12
    //   888: astore 9
    //   890: goto -582 -> 308
    //   893: astore_1
    //   894: iconst_0
    //   895: istore_3
    //   896: aload 8
    //   898: astore 10
    //   900: aload_0
    //   901: astore 11
    //   903: aconst_null
    //   904: astore 8
    //   906: aconst_null
    //   907: astore 12
    //   909: aload_1
    //   910: astore_0
    //   911: aload 12
    //   913: astore_1
    //   914: goto -606 -> 308
    //   917: astore 14
    //   919: iconst_0
    //   920: istore_3
    //   921: aload 8
    //   923: astore 12
    //   925: aload_0
    //   926: astore 13
    //   928: aload 11
    //   930: astore 8
    //   932: aload 10
    //   934: astore_1
    //   935: aload 14
    //   937: astore_0
    //   938: aload 12
    //   940: astore 10
    //   942: aload 13
    //   944: astore 11
    //   946: goto -638 -> 308
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	949	0	paramString1	String
    //   0	949	1	paramString2	String
    //   0	949	2	paramBoolean	boolean
    //   247	674	3	i	int
    //   555	171	4	j	int
    //   529	199	5	k	int
    //   1	748	6	m	int
    //   545	176	7	n	int
    //   69	531	8	localObject1	Object
    //   807	1	8	localIOException1	java.io.IOException
    //   822	109	8	localObject2	Object
    //   80	455	9	localQZipInputStream	com.tencent.commonsdk.zip.QZipInputStream
    //   792	1	9	localIOException2	java.io.IOException
    //   797	1	9	localIOException3	java.io.IOException
    //   802	1	9	localIOException4	java.io.IOException
    //   825	64	9	localObject3	Object
    //   106	835	10	localObject4	Object
    //   116	829	11	localObject5	Object
    //   109	830	12	localObject6	Object
    //   287	11	13	localObject7	Object
    //   408	535	13	str	String
    //   412	38	14	localObject8	Object
    //   917	19	14	localObject9	Object
    //   10	780	15	localArrayList	ArrayList
    //   103	615	16	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   111	118	287	finally
    //   123	131	287	finally
    //   209	224	287	finally
    //   229	287	287	finally
    //   418	426	287	finally
    //   434	443	287	finally
    //   443	476	287	finally
    //   476	490	287	finally
    //   490	514	287	finally
    //   613	621	287	finally
    //   627	669	287	finally
    //   669	679	287	finally
    //   682	709	287	finally
    //   534	547	589	finally
    //   578	589	589	finally
    //   715	725	589	finally
    //   735	740	589	finally
    //   743	748	589	finally
    //   751	756	589	finally
    //   163	168	772	java/io/IOException
    //   173	178	776	java/io/IOException
    //   182	186	780	java/io/IOException
    //   191	196	784	java/io/IOException
    //   201	206	788	java/io/IOException
    //   354	359	792	java/io/IOException
    //   364	369	797	java/io/IOException
    //   374	379	802	java/io/IOException
    //   384	389	807	java/io/IOException
    //   393	397	812	java/io/IOException
    //   12	52	816	finally
    //   52	61	816	finally
    //   61	71	836	finally
    //   71	82	862	finally
    //   82	105	893	finally
    //   514	528	917	finally
  }
  
  public static boolean a(ARMapConfig.ResInfo paramResInfo)
  {
    return (paramResInfo != null) && (!TextUtils.isEmpty(paramResInfo.md5)) && (!TextUtils.isEmpty(paramResInfo.url));
  }
  
  private boolean c(BaseCheckHandler.ItemConfig paramItemConfig)
  {
    File localFile = new File(paramItemConfig.e);
    int i = 0;
    Object localObject = null;
    boolean bool1 = true;
    for (;;)
    {
      FileUtils.a(paramItemConfig.c, true);
      i += 1;
      try
      {
        List localList = a(localFile.getAbsolutePath(), paramItemConfig.c, false);
        boolean bool2 = bool1;
        if (localList != null)
        {
          localObject = localList;
          boolean bool3 = localList.isEmpty();
          bool2 = bool1;
          if (!bool3) {
            bool2 = true;
          }
        }
        bool1 = bool2;
        localObject = localList;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.d(this.d, 1, "unzipFile exption:" + localException.getMessage());
          bool1 = false;
        }
        a(paramItemConfig, 2);
        QLog.d(this.d, 1, "unzip fialed zipFile:" + paramItemConfig.e + "|destDir:" + paramItemConfig.c);
        return bool1;
      }
      if ((bool1) || (i >= 2)) {
        if (bool1)
        {
          paramItemConfig.jdField_a_of_type_JavaUtilList = localObject;
          a(paramItemConfig, 0);
          return bool1;
        }
      }
    }
  }
  
  abstract int a();
  
  public String a()
  {
    return "BaseCheckHandler";
  }
  
  public List a(BaseCheckHandler.ItemConfig paramItemConfig)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqArmapConfigBaseCheckHandler$ExistsDirInfos == null) || (this.jdField_a_of_type_Boolean)) {}
    for (;;)
    {
      String str1;
      String str2;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqArmapConfigBaseCheckHandler$ExistsDirInfos == null) || (this.jdField_a_of_type_Boolean))
        {
          this.jdField_a_of_type_Boolean = false;
          this.jdField_a_of_type_ComTencentMobileqqArmapConfigBaseCheckHandler$ExistsDirInfos = a();
          if (this.jdField_a_of_type_ComTencentMobileqqArmapConfigBaseCheckHandler$ExistsDirInfos == null) {
            this.jdField_a_of_type_ComTencentMobileqqArmapConfigBaseCheckHandler$ExistsDirInfos = new BaseCheckHandler.ExistsDirInfos();
          }
        }
        int i = paramItemConfig.jdField_b_of_type_Int;
        str1 = paramItemConfig.jdField_b_of_type_JavaLangString;
        str2 = paramItemConfig.d;
        ??? = null;
        paramItemConfig = ???;
        switch (i)
        {
        default: 
          paramItemConfig = ???;
        case 5: 
        case 9: 
          if (QLog.isColorLevel()) {
            QLog.d(this.d, 2, "getExistsFileList:" + paramItemConfig);
          }
          return paramItemConfig;
        }
      }
      paramItemConfig = this.jdField_a_of_type_ComTencentMobileqqArmapConfigBaseCheckHandler$ExistsDirInfos.mapConfigFileList;
      continue;
      paramItemConfig = this.jdField_a_of_type_ComTencentMobileqqArmapConfigBaseCheckHandler$ExistsDirInfos.mapDayFileList;
      continue;
      paramItemConfig = this.jdField_a_of_type_ComTencentMobileqqArmapConfigBaseCheckHandler$ExistsDirInfos.mapNightFileList;
      continue;
      paramItemConfig = this.jdField_a_of_type_ComTencentMobileqqArmapConfigBaseCheckHandler$ExistsDirInfos.skyFileList;
      continue;
      paramItemConfig = this.jdField_a_of_type_ComTencentMobileqqArmapConfigBaseCheckHandler$ExistsDirInfos.commonFileList;
      continue;
      paramItemConfig = ???;
      if (this.jdField_a_of_type_ComTencentMobileqqArmapConfigBaseCheckHandler$ExistsDirInfos.treeFileList != null)
      {
        paramItemConfig = (List)this.jdField_a_of_type_ComTencentMobileqqArmapConfigBaseCheckHandler$ExistsDirInfos.treeFileList.get(str1);
        continue;
        str1 = str1 + str2;
        paramItemConfig = ???;
        if (this.jdField_a_of_type_ComTencentMobileqqArmapConfigBaseCheckHandler$ExistsDirInfos.poiFileList != null)
        {
          paramItemConfig = (List)this.jdField_a_of_type_ComTencentMobileqqArmapConfigBaseCheckHandler$ExistsDirInfos.poiFileList.get(str1);
          continue;
          paramItemConfig = ???;
          if (this.jdField_a_of_type_ComTencentMobileqqArmapConfigBaseCheckHandler$ExistsDirInfos.poiLogoFileList != null)
          {
            paramItemConfig = (List)this.jdField_a_of_type_ComTencentMobileqqArmapConfigBaseCheckHandler$ExistsDirInfos.poiLogoFileList.get(str1);
            continue;
            paramItemConfig = ???;
            if (this.jdField_a_of_type_ComTencentMobileqqArmapConfigBaseCheckHandler$ExistsDirInfos.openBoxFileList != null)
            {
              paramItemConfig = this.jdField_a_of_type_ComTencentMobileqqArmapConfigBaseCheckHandler$ExistsDirInfos.openBoxFileList;
              continue;
              paramItemConfig = ???;
              if (this.jdField_a_of_type_ComTencentMobileqqArmapConfigBaseCheckHandler$ExistsDirInfos.wealthGodFileList != null) {
                paramItemConfig = this.jdField_a_of_type_ComTencentMobileqqArmapConfigBaseCheckHandler$ExistsDirInfos.wealthGodFileList;
              }
            }
          }
        }
      }
    }
  }
  
  /* Error */
  public void a(BaseCheckHandler.ExistsDirInfos paramExistsDirInfos)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_0
    //   4: monitorenter
    //   5: new 47	java/io/File
    //   8: dup
    //   9: getstatic 54	com/tencent/mobileqq/armap/config/BaseCheckHandler:c	Ljava/lang/String;
    //   12: invokespecial 111	java/io/File:<init>	(Ljava/lang/String;)V
    //   15: astore 4
    //   17: new 47	java/io/File
    //   20: dup
    //   21: new 22	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   28: getstatic 54	com/tencent/mobileqq/armap/config/BaseCheckHandler:c	Ljava/lang/String;
    //   31: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: ldc_w 402
    //   37: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokespecial 111	java/io/File:<init>	(Ljava/lang/String;)V
    //   46: astore 9
    //   48: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   51: ifeq +35 -> 86
    //   54: aload_0
    //   55: getfield 98	com/tencent/mobileqq/armap/config/BaseCheckHandler:d	Ljava/lang/String;
    //   58: iconst_2
    //   59: new 22	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   66: ldc_w 404
    //   69: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: aload 4
    //   74: invokevirtual 273	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   77: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: invokestatic 127	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   86: aload 9
    //   88: invokevirtual 115	java/io/File:exists	()Z
    //   91: ifeq +9 -> 100
    //   94: aload 9
    //   96: invokevirtual 270	java/io/File:delete	()Z
    //   99: pop
    //   100: aload 9
    //   102: invokevirtual 407	java/io/File:createNewFile	()Z
    //   105: pop
    //   106: new 214	java/io/FileOutputStream
    //   109: dup
    //   110: aload 9
    //   112: invokespecial 274	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   115: astore_3
    //   116: new 409	java/io/ByteArrayOutputStream
    //   119: dup
    //   120: sipush 8192
    //   123: invokespecial 412	java/io/ByteArrayOutputStream:<init>	(I)V
    //   126: astore_2
    //   127: new 414	java/io/ObjectOutputStream
    //   130: dup
    //   131: aload_2
    //   132: invokespecial 417	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   135: astore 6
    //   137: aload_3
    //   138: astore 8
    //   140: aload_2
    //   141: astore 7
    //   143: aload 6
    //   145: astore 5
    //   147: aload 6
    //   149: aload_1
    //   150: invokevirtual 421	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   153: aload_3
    //   154: astore 8
    //   156: aload_2
    //   157: astore 7
    //   159: aload 6
    //   161: astore 5
    //   163: aload 6
    //   165: invokevirtual 422	java/io/ObjectOutputStream:flush	()V
    //   168: aload_3
    //   169: astore 8
    //   171: aload_2
    //   172: astore 7
    //   174: aload 6
    //   176: astore 5
    //   178: aload_2
    //   179: aload_3
    //   180: invokevirtual 425	java/io/ByteArrayOutputStream:writeTo	(Ljava/io/OutputStream;)V
    //   183: aload_3
    //   184: astore 8
    //   186: aload_2
    //   187: astore 7
    //   189: aload 6
    //   191: astore 5
    //   193: aload_2
    //   194: invokevirtual 426	java/io/ByteArrayOutputStream:flush	()V
    //   197: aload_3
    //   198: astore 8
    //   200: aload_2
    //   201: astore 7
    //   203: aload 6
    //   205: astore 5
    //   207: aload_3
    //   208: invokevirtual 427	java/io/FileOutputStream:flush	()V
    //   211: aload_3
    //   212: astore 8
    //   214: aload_2
    //   215: astore 7
    //   217: aload 6
    //   219: astore 5
    //   221: aload 4
    //   223: invokevirtual 115	java/io/File:exists	()Z
    //   226: ifeq +19 -> 245
    //   229: aload_3
    //   230: astore 8
    //   232: aload_2
    //   233: astore 7
    //   235: aload 6
    //   237: astore 5
    //   239: aload 4
    //   241: invokevirtual 270	java/io/File:delete	()Z
    //   244: pop
    //   245: aload_3
    //   246: astore 8
    //   248: aload_2
    //   249: astore 7
    //   251: aload 6
    //   253: astore 5
    //   255: aload 9
    //   257: aload 4
    //   259: invokevirtual 431	java/io/File:renameTo	(Ljava/io/File;)Z
    //   262: pop
    //   263: aload_3
    //   264: astore 8
    //   266: aload_2
    //   267: astore 7
    //   269: aload 6
    //   271: astore 5
    //   273: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   276: ifeq +87 -> 363
    //   279: aload_3
    //   280: astore 8
    //   282: aload_2
    //   283: astore 7
    //   285: aload 6
    //   287: astore 5
    //   289: aload_0
    //   290: getfield 98	com/tencent/mobileqq/armap/config/BaseCheckHandler:d	Ljava/lang/String;
    //   293: iconst_2
    //   294: new 22	java/lang/StringBuilder
    //   297: dup
    //   298: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   301: ldc_w 433
    //   304: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: aload 9
    //   309: invokevirtual 436	java/io/File:length	()J
    //   312: ldc2_w 437
    //   315: ldiv
    //   316: invokevirtual 441	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   319: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   322: invokestatic 127	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   325: aload_3
    //   326: astore 8
    //   328: aload_2
    //   329: astore 7
    //   331: aload 6
    //   333: astore 5
    //   335: aload_0
    //   336: getfield 98	com/tencent/mobileqq/armap/config/BaseCheckHandler:d	Ljava/lang/String;
    //   339: iconst_2
    //   340: new 22	java/lang/StringBuilder
    //   343: dup
    //   344: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   347: ldc_w 443
    //   350: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: aload_1
    //   354: invokevirtual 360	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   357: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   360: invokestatic 127	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   363: aload_3
    //   364: ifnull +7 -> 371
    //   367: aload_3
    //   368: invokevirtual 215	java/io/FileOutputStream:close	()V
    //   371: aload 6
    //   373: ifnull +8 -> 381
    //   376: aload 6
    //   378: invokevirtual 444	java/io/ObjectOutputStream:close	()V
    //   381: aload_2
    //   382: ifnull +7 -> 389
    //   385: aload_2
    //   386: invokevirtual 445	java/io/ByteArrayOutputStream:close	()V
    //   389: aload_0
    //   390: monitorexit
    //   391: return
    //   392: astore_1
    //   393: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   396: ifeq -25 -> 371
    //   399: aload_1
    //   400: invokevirtual 154	java/io/IOException:printStackTrace	()V
    //   403: goto -32 -> 371
    //   406: astore_1
    //   407: aload_0
    //   408: monitorexit
    //   409: aload_1
    //   410: athrow
    //   411: astore_1
    //   412: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   415: ifeq -34 -> 381
    //   418: aload_1
    //   419: invokevirtual 154	java/io/IOException:printStackTrace	()V
    //   422: goto -41 -> 381
    //   425: astore_1
    //   426: aload_1
    //   427: invokevirtual 154	java/io/IOException:printStackTrace	()V
    //   430: goto -41 -> 389
    //   433: astore 4
    //   435: aconst_null
    //   436: astore_3
    //   437: aconst_null
    //   438: astore_1
    //   439: aload 5
    //   441: astore_2
    //   442: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   445: ifeq +35 -> 480
    //   448: aload_0
    //   449: getfield 98	com/tencent/mobileqq/armap/config/BaseCheckHandler:d	Ljava/lang/String;
    //   452: iconst_2
    //   453: new 22	java/lang/StringBuilder
    //   456: dup
    //   457: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   460: ldc_w 447
    //   463: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: aload 4
    //   468: invokevirtual 448	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   471: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   474: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   477: invokestatic 127	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   480: aload_3
    //   481: ifnull +7 -> 488
    //   484: aload_3
    //   485: invokevirtual 215	java/io/FileOutputStream:close	()V
    //   488: aload_1
    //   489: ifnull +7 -> 496
    //   492: aload_1
    //   493: invokevirtual 444	java/io/ObjectOutputStream:close	()V
    //   496: aload_2
    //   497: ifnull -108 -> 389
    //   500: aload_2
    //   501: invokevirtual 445	java/io/ByteArrayOutputStream:close	()V
    //   504: goto -115 -> 389
    //   507: astore_1
    //   508: aload_1
    //   509: invokevirtual 154	java/io/IOException:printStackTrace	()V
    //   512: goto -123 -> 389
    //   515: astore_3
    //   516: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   519: ifeq -31 -> 488
    //   522: aload_3
    //   523: invokevirtual 154	java/io/IOException:printStackTrace	()V
    //   526: goto -38 -> 488
    //   529: astore_1
    //   530: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   533: ifeq -37 -> 496
    //   536: aload_1
    //   537: invokevirtual 154	java/io/IOException:printStackTrace	()V
    //   540: goto -44 -> 496
    //   543: astore 4
    //   545: aconst_null
    //   546: astore_3
    //   547: aconst_null
    //   548: astore_2
    //   549: aconst_null
    //   550: astore_1
    //   551: aload_3
    //   552: astore 8
    //   554: aload_2
    //   555: astore 7
    //   557: aload_1
    //   558: astore 5
    //   560: aload 4
    //   562: invokevirtual 449	java/lang/Exception:printStackTrace	()V
    //   565: aload_3
    //   566: astore 8
    //   568: aload_2
    //   569: astore 7
    //   571: aload_1
    //   572: astore 5
    //   574: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   577: ifeq +44 -> 621
    //   580: aload_3
    //   581: astore 8
    //   583: aload_2
    //   584: astore 7
    //   586: aload_1
    //   587: astore 5
    //   589: aload_0
    //   590: getfield 98	com/tencent/mobileqq/armap/config/BaseCheckHandler:d	Ljava/lang/String;
    //   593: iconst_2
    //   594: new 22	java/lang/StringBuilder
    //   597: dup
    //   598: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   601: ldc_w 451
    //   604: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: aload 4
    //   609: invokevirtual 157	java/lang/Exception:toString	()Ljava/lang/String;
    //   612: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   615: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   618: invokestatic 127	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   621: aload_3
    //   622: ifnull +7 -> 629
    //   625: aload_3
    //   626: invokevirtual 215	java/io/FileOutputStream:close	()V
    //   629: aload_1
    //   630: ifnull +7 -> 637
    //   633: aload_1
    //   634: invokevirtual 444	java/io/ObjectOutputStream:close	()V
    //   637: aload_2
    //   638: ifnull -249 -> 389
    //   641: aload_2
    //   642: invokevirtual 445	java/io/ByteArrayOutputStream:close	()V
    //   645: goto -256 -> 389
    //   648: astore_1
    //   649: aload_1
    //   650: invokevirtual 154	java/io/IOException:printStackTrace	()V
    //   653: goto -264 -> 389
    //   656: astore_3
    //   657: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   660: ifeq -31 -> 629
    //   663: aload_3
    //   664: invokevirtual 154	java/io/IOException:printStackTrace	()V
    //   667: goto -38 -> 629
    //   670: astore_1
    //   671: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   674: ifeq -37 -> 637
    //   677: aload_1
    //   678: invokevirtual 154	java/io/IOException:printStackTrace	()V
    //   681: goto -44 -> 637
    //   684: astore_1
    //   685: aconst_null
    //   686: astore 4
    //   688: aconst_null
    //   689: astore_2
    //   690: aconst_null
    //   691: astore_3
    //   692: aload 4
    //   694: ifnull +8 -> 702
    //   697: aload 4
    //   699: invokevirtual 215	java/io/FileOutputStream:close	()V
    //   702: aload_3
    //   703: ifnull +7 -> 710
    //   706: aload_3
    //   707: invokevirtual 444	java/io/ObjectOutputStream:close	()V
    //   710: aload_2
    //   711: ifnull +7 -> 718
    //   714: aload_2
    //   715: invokevirtual 445	java/io/ByteArrayOutputStream:close	()V
    //   718: aload_1
    //   719: athrow
    //   720: astore 4
    //   722: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   725: ifeq -23 -> 702
    //   728: aload 4
    //   730: invokevirtual 154	java/io/IOException:printStackTrace	()V
    //   733: goto -31 -> 702
    //   736: astore_3
    //   737: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   740: ifeq -30 -> 710
    //   743: aload_3
    //   744: invokevirtual 154	java/io/IOException:printStackTrace	()V
    //   747: goto -37 -> 710
    //   750: astore_2
    //   751: aload_2
    //   752: invokevirtual 154	java/io/IOException:printStackTrace	()V
    //   755: goto -37 -> 718
    //   758: astore_1
    //   759: aconst_null
    //   760: astore_2
    //   761: aconst_null
    //   762: astore 5
    //   764: aload_3
    //   765: astore 4
    //   767: aload 5
    //   769: astore_3
    //   770: goto -78 -> 692
    //   773: astore_1
    //   774: aconst_null
    //   775: astore 5
    //   777: aload_3
    //   778: astore 4
    //   780: aload 5
    //   782: astore_3
    //   783: goto -91 -> 692
    //   786: astore_1
    //   787: aload 8
    //   789: astore 4
    //   791: aload 7
    //   793: astore_2
    //   794: aload 5
    //   796: astore_3
    //   797: goto -105 -> 692
    //   800: astore 4
    //   802: aload_1
    //   803: astore 5
    //   805: aload 4
    //   807: astore_1
    //   808: aload_3
    //   809: astore 4
    //   811: aload 5
    //   813: astore_3
    //   814: goto -122 -> 692
    //   817: astore 4
    //   819: aconst_null
    //   820: astore_2
    //   821: aconst_null
    //   822: astore_1
    //   823: goto -272 -> 551
    //   826: astore 4
    //   828: aconst_null
    //   829: astore_1
    //   830: goto -279 -> 551
    //   833: astore 4
    //   835: aload 6
    //   837: astore_1
    //   838: goto -287 -> 551
    //   841: astore 4
    //   843: aconst_null
    //   844: astore_1
    //   845: aload 5
    //   847: astore_2
    //   848: goto -406 -> 442
    //   851: astore 4
    //   853: aconst_null
    //   854: astore_1
    //   855: goto -413 -> 442
    //   858: astore 4
    //   860: aload 6
    //   862: astore_1
    //   863: goto -421 -> 442
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	866	0	this	BaseCheckHandler
    //   0	866	1	paramExistsDirInfos	BaseCheckHandler.ExistsDirInfos
    //   126	589	2	localObject1	Object
    //   750	2	2	localIOException1	java.io.IOException
    //   760	88	2	localObject2	Object
    //   115	370	3	localFileOutputStream	java.io.FileOutputStream
    //   515	8	3	localIOException2	java.io.IOException
    //   546	80	3	localObject3	Object
    //   656	8	3	localIOException3	java.io.IOException
    //   691	16	3	localObject4	Object
    //   736	29	3	localIOException4	java.io.IOException
    //   769	45	3	localObject5	Object
    //   15	243	4	localFile1	File
    //   433	34	4	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   543	65	4	localException1	Exception
    //   686	12	4	localObject6	Object
    //   720	9	4	localIOException5	java.io.IOException
    //   765	25	4	localObject7	Object
    //   800	6	4	localObject8	Object
    //   809	1	4	localObject9	Object
    //   817	1	4	localException2	Exception
    //   826	1	4	localException3	Exception
    //   833	1	4	localException4	Exception
    //   841	1	4	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   851	1	4	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   858	1	4	localOutOfMemoryError4	java.lang.OutOfMemoryError
    //   1	845	5	localObject10	Object
    //   135	726	6	localObjectOutputStream	java.io.ObjectOutputStream
    //   141	651	7	localObject11	Object
    //   138	650	8	localObject12	Object
    //   46	262	9	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   367	371	392	java/io/IOException
    //   5	86	406	finally
    //   86	100	406	finally
    //   367	371	406	finally
    //   376	381	406	finally
    //   385	389	406	finally
    //   393	403	406	finally
    //   412	422	406	finally
    //   426	430	406	finally
    //   484	488	406	finally
    //   492	496	406	finally
    //   500	504	406	finally
    //   508	512	406	finally
    //   516	526	406	finally
    //   530	540	406	finally
    //   625	629	406	finally
    //   633	637	406	finally
    //   641	645	406	finally
    //   649	653	406	finally
    //   657	667	406	finally
    //   671	681	406	finally
    //   697	702	406	finally
    //   706	710	406	finally
    //   714	718	406	finally
    //   718	720	406	finally
    //   722	733	406	finally
    //   737	747	406	finally
    //   751	755	406	finally
    //   376	381	411	java/io/IOException
    //   385	389	425	java/io/IOException
    //   100	116	433	java/lang/OutOfMemoryError
    //   500	504	507	java/io/IOException
    //   484	488	515	java/io/IOException
    //   492	496	529	java/io/IOException
    //   100	116	543	java/lang/Exception
    //   641	645	648	java/io/IOException
    //   625	629	656	java/io/IOException
    //   633	637	670	java/io/IOException
    //   100	116	684	finally
    //   697	702	720	java/io/IOException
    //   706	710	736	java/io/IOException
    //   714	718	750	java/io/IOException
    //   116	127	758	finally
    //   127	137	773	finally
    //   147	153	786	finally
    //   163	168	786	finally
    //   178	183	786	finally
    //   193	197	786	finally
    //   207	211	786	finally
    //   221	229	786	finally
    //   239	245	786	finally
    //   255	263	786	finally
    //   273	279	786	finally
    //   289	325	786	finally
    //   335	363	786	finally
    //   560	565	786	finally
    //   574	580	786	finally
    //   589	621	786	finally
    //   442	480	800	finally
    //   116	127	817	java/lang/Exception
    //   127	137	826	java/lang/Exception
    //   147	153	833	java/lang/Exception
    //   163	168	833	java/lang/Exception
    //   178	183	833	java/lang/Exception
    //   193	197	833	java/lang/Exception
    //   207	211	833	java/lang/Exception
    //   221	229	833	java/lang/Exception
    //   239	245	833	java/lang/Exception
    //   255	263	833	java/lang/Exception
    //   273	279	833	java/lang/Exception
    //   289	325	833	java/lang/Exception
    //   335	363	833	java/lang/Exception
    //   116	127	841	java/lang/OutOfMemoryError
    //   127	137	851	java/lang/OutOfMemoryError
    //   147	153	858	java/lang/OutOfMemoryError
    //   163	168	858	java/lang/OutOfMemoryError
    //   178	183	858	java/lang/OutOfMemoryError
    //   193	197	858	java/lang/OutOfMemoryError
    //   207	211	858	java/lang/OutOfMemoryError
    //   221	229	858	java/lang/OutOfMemoryError
    //   239	245	858	java/lang/OutOfMemoryError
    //   255	263	858	java/lang/OutOfMemoryError
    //   273	279	858	java/lang/OutOfMemoryError
    //   289	325	858	java/lang/OutOfMemoryError
    //   335	363	858	java/lang/OutOfMemoryError
  }
  
  public void a(BaseCheckHandler.ItemConfig paramItemConfig)
  {
    for (;;)
    {
      Object localObject;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.d, 2, "updateExistFileInfos url:" + paramItemConfig.jdField_a_of_type_JavaLangString + " ,md5:" + paramItemConfig.jdField_b_of_type_JavaLangString);
        }
        if ((paramItemConfig != null) && (this.jdField_a_of_type_ComTencentMobileqqArmapConfigBaseCheckHandler$ExistsDirInfos != null))
        {
          localObject = paramItemConfig.jdField_a_of_type_JavaUtilList;
          if (localObject != null) {}
        }
        else
        {
          return;
        }
        switch (paramItemConfig.jdField_b_of_type_Int)
        {
        case 0: 
          this.jdField_a_of_type_ComTencentMobileqqArmapConfigBaseCheckHandler$ExistsDirInfos.mapConfigFileList = paramItemConfig.jdField_a_of_type_JavaUtilList;
          break;
        case 1: 
          this.jdField_a_of_type_ComTencentMobileqqArmapConfigBaseCheckHandler$ExistsDirInfos.mapDayFileList = paramItemConfig.jdField_a_of_type_JavaUtilList;
        }
      }
      finally {}
      continue;
      this.jdField_a_of_type_ComTencentMobileqqArmapConfigBaseCheckHandler$ExistsDirInfos.mapNightFileList = paramItemConfig.jdField_a_of_type_JavaUtilList;
      continue;
      this.jdField_a_of_type_ComTencentMobileqqArmapConfigBaseCheckHandler$ExistsDirInfos.skyFileList = paramItemConfig.jdField_a_of_type_JavaUtilList;
      continue;
      this.jdField_a_of_type_ComTencentMobileqqArmapConfigBaseCheckHandler$ExistsDirInfos.commonFileList = paramItemConfig.jdField_a_of_type_JavaUtilList;
      continue;
      if (this.jdField_a_of_type_ComTencentMobileqqArmapConfigBaseCheckHandler$ExistsDirInfos.treeFileList == null) {
        this.jdField_a_of_type_ComTencentMobileqqArmapConfigBaseCheckHandler$ExistsDirInfos.treeFileList = new HashMap();
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqArmapConfigBaseCheckHandler$ExistsDirInfos.treeFileList.put(paramItemConfig.jdField_b_of_type_JavaLangString, paramItemConfig.jdField_a_of_type_JavaUtilList);
        break;
        this.jdField_a_of_type_ComTencentMobileqqArmapConfigBaseCheckHandler$ExistsDirInfos.treeFileList.clear();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqArmapConfigBaseCheckHandler$ExistsDirInfos.poiFileList == null) {
        this.jdField_a_of_type_ComTencentMobileqqArmapConfigBaseCheckHandler$ExistsDirInfos.poiFileList = new HashMap();
      }
      label298:
      label574:
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqArmapConfigBaseCheckHandler$ExistsDirInfos.poiFileList.put(paramItemConfig.jdField_b_of_type_JavaLangString + paramItemConfig.d, paramItemConfig.jdField_a_of_type_JavaUtilList);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(this.d, 2, "updateExistFileInfos ,add poikey " + paramItemConfig.jdField_b_of_type_JavaLangString + paramItemConfig.d);
        break;
        Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqArmapConfigBaseCheckHandler$ExistsDirInfos.poiFileList.keySet().iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = (String)localIterator.next();
        } while (!((String)localObject).endsWith(paramItemConfig.d));
        for (;;)
        {
          if ((TextUtils.isEmpty((CharSequence)localObject)) || (this.jdField_a_of_type_ComTencentMobileqqArmapConfigBaseCheckHandler$ExistsDirInfos.poiFileList == null)) {
            break label574;
          }
          this.jdField_a_of_type_ComTencentMobileqqArmapConfigBaseCheckHandler$ExistsDirInfos.poiFileList.remove(localObject);
          if (!QLog.isColorLevel()) {
            break label298;
          }
          QLog.d(this.d, 2, "updateExistFileInfos ,remove poikey " + (String)localObject);
          break label298;
          if (this.jdField_a_of_type_ComTencentMobileqqArmapConfigBaseCheckHandler$ExistsDirInfos.poiLogoFileList == null) {
            this.jdField_a_of_type_ComTencentMobileqqArmapConfigBaseCheckHandler$ExistsDirInfos.poiLogoFileList = new HashMap();
          }
          this.jdField_a_of_type_ComTencentMobileqqArmapConfigBaseCheckHandler$ExistsDirInfos.poiLogoFileList.put(paramItemConfig.jdField_b_of_type_JavaLangString, paramItemConfig.jdField_a_of_type_JavaUtilList);
          break;
          this.jdField_a_of_type_ComTencentMobileqqArmapConfigBaseCheckHandler$ExistsDirInfos.openBoxFileList = paramItemConfig.jdField_a_of_type_JavaUtilList;
          break;
          this.jdField_a_of_type_ComTencentMobileqqArmapConfigBaseCheckHandler$ExistsDirInfos.wealthGodFileList = paramItemConfig.jdField_a_of_type_JavaUtilList;
          break;
          localObject = "";
        }
      }
    }
  }
  
  protected void a(BaseCheckHandler.ItemConfig paramItemConfig, int paramInt)
  {
    if ((paramItemConfig != null) && (paramItemConfig.jdField_a_of_type_JavaUtilList != null))
    {
      a(paramItemConfig);
      if ((paramItemConfig.jdField_a_of_type_Int == 1) || (paramItemConfig.jdField_a_of_type_Int == 2)) {
        a(this.jdField_a_of_type_ComTencentMobileqqArmapConfigBaseCheckHandler$ExistsDirInfos);
      }
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt) {}
  
  public void a(String paramString1, String paramString2, int paramInt, String paramString3, Object paramObject)
  {
    if ((paramObject instanceof BaseCheckHandler.ItemConfig)) {}
    for (paramString2 = (BaseCheckHandler.ItemConfig)paramObject;; paramString2 = null)
    {
      if ((paramString2 != null) && (paramString2.jdField_a_of_type_Int == a()))
      {
        if (paramInt == 0) {
          c(paramString2);
        }
      }
      else {
        return;
      }
      QLog.d(this.d, 1, "download failed url:" + paramString1 + " errCode:" + paramInt);
      a(paramString2, 3);
      return;
    }
  }
  
  public boolean a(BaseCheckHandler.ItemConfig paramItemConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.d, 2, "checkItemConfig config:" + paramItemConfig);
    }
    File localFile1 = new File(paramItemConfig.c);
    File localFile2 = new File(paramItemConfig.e);
    boolean bool1;
    if ((localFile1.exists()) && (b(paramItemConfig)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.d, 2, "checkItemConfig unzipFile exist");
      }
      a(paramItemConfig, 0);
      bool1 = true;
    }
    boolean bool2;
    do
    {
      return bool1;
      if (!localFile2.exists()) {
        break;
      }
      bool2 = c(paramItemConfig);
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d(this.d, 2, "checkItemConfig zipFile exist, unzip=" + bool2);
    return bool2;
    if (QLog.isColorLevel()) {
      QLog.d(this.d, 2, "checkItemConfig need download");
    }
    this.jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager.a(paramItemConfig.jdField_a_of_type_JavaLangString, paramItemConfig.jdField_b_of_type_JavaLangString, ".zip", false, 2, paramItemConfig);
    return false;
  }
  
  public boolean b(BaseCheckHandler.ItemConfig paramItemConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.d, 2, "checkFilesValidity url:" + paramItemConfig.jdField_a_of_type_JavaLangString + ",md5:" + paramItemConfig.jdField_b_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_JavaUtilList.contains(Integer.valueOf(paramItemConfig.jdField_b_of_type_Int)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.d, 2, "checkFilesValidity url,fileValidityFilter return true ");
      }
      return true;
    }
    Object localObject = a(paramItemConfig);
    if ((localObject == null) || (((List)localObject).isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.d, 2, "checkFilesValidity url,originalFileList empty, return false ");
      }
      return false;
    }
    paramItemConfig = FileUtils.a(paramItemConfig.c);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (!paramItemConfig.contains(str)) {
        QLog.d(this.d, 1, "checkFilesValidity failed!" + str + " not exist!");
      }
    }
    for (boolean bool = false;; bool = true) {
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.config.BaseCheckHandler
 * JD-Core Version:    0.7.0.1
 */
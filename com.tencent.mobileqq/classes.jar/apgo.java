import android.content.Context;
import android.content.SharedPreferences;
import android.util.Xml;
import com.tencent.YTFace.cluster.FaceCluster;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ytcommon.util.YTCommonInterface;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;

public class apgo
{
  private static final Object a;
  public static boolean a;
  public static volatile boolean b;
  public static volatile boolean c;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
  }
  
  /* Error */
  public static byte a(String arg0)
  {
    // Byte code:
    //   0: iconst_1
    //   1: putstatic 22	apgo:jdField_a_of_type_Boolean	Z
    //   4: new 24	java/io/File
    //   7: dup
    //   8: invokestatic 27	apgo:b	()Ljava/lang/String;
    //   11: invokespecial 30	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: astore 4
    //   16: aload 4
    //   18: invokevirtual 34	java/io/File:exists	()Z
    //   21: ifeq +40 -> 61
    //   24: aload 4
    //   26: invokestatic 40	com/tencent/mobileqq/filemanager/util/FileUtil:deleteFile	(Ljava/io/File;)Z
    //   29: istore_3
    //   30: invokestatic 45	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   33: ifeq +28 -> 61
    //   36: ldc 47
    //   38: iconst_2
    //   39: new 49	java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   46: ldc 52
    //   48: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: iload_3
    //   52: invokevirtual 59	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   55: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: invokestatic 66	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   61: aload_0
    //   62: invokestatic 68	apgo:a	()Ljava/lang/String;
    //   65: invokestatic 71	apgo:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   68: new 73	java/util/HashMap
    //   71: dup
    //   72: invokespecial 74	java/util/HashMap:<init>	()V
    //   75: astore 6
    //   77: getstatic 80	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   80: ldc 82
    //   82: iconst_0
    //   83: invokevirtual 86	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   86: invokeinterface 92 1 0
    //   91: astore 5
    //   93: new 24	java/io/File
    //   96: dup
    //   97: new 49	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   104: invokestatic 68	apgo:a	()Ljava/lang/String;
    //   107: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: ldc 94
    //   112: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokespecial 30	java/io/File:<init>	(Ljava/lang/String;)V
    //   121: astore 4
    //   123: aload 4
    //   125: invokevirtual 34	java/io/File:exists	()Z
    //   128: ifeq +315 -> 443
    //   131: aconst_null
    //   132: astore_0
    //   133: aload 4
    //   135: invokestatic 100	com/tencent/mobileqq/utils/FileUtils:readFileToString	(Ljava/io/File;)Ljava/lang/String;
    //   138: astore 4
    //   140: aload 4
    //   142: astore_0
    //   143: aload_0
    //   144: ifnull +276 -> 420
    //   147: aload_0
    //   148: aload 6
    //   150: invokestatic 103	apgo:a	(Ljava/lang/String;Ljava/util/HashMap;)Z
    //   153: ifeq +267 -> 420
    //   156: getstatic 16	apgo:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   159: astore_0
    //   160: aload_0
    //   161: monitorenter
    //   162: aload 6
    //   164: invokevirtual 107	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   167: invokeinterface 113 1 0
    //   172: astore 4
    //   174: aload 4
    //   176: invokeinterface 118 1 0
    //   181: ifeq +281 -> 462
    //   184: aload 4
    //   186: invokeinterface 122 1 0
    //   191: checkcast 124	java/util/Map$Entry
    //   194: astore 6
    //   196: new 49	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   203: invokestatic 68	apgo:a	()Ljava/lang/String;
    //   206: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: getstatic 128	java/io/File:separator	Ljava/lang/String;
    //   212: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: aload 6
    //   217: invokeinterface 131 1 0
    //   222: checkcast 133	java/lang/String
    //   225: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: astore 8
    //   233: new 24	java/io/File
    //   236: dup
    //   237: aload 8
    //   239: invokespecial 30	java/io/File:<init>	(Ljava/lang/String;)V
    //   242: astore 7
    //   244: aload 7
    //   246: invokevirtual 34	java/io/File:exists	()Z
    //   249: ifeq +166 -> 415
    //   252: aload 8
    //   254: invokestatic 138	aznv:a	(Ljava/lang/String;)Ljava/lang/String;
    //   257: astore 8
    //   259: aload 6
    //   261: invokeinterface 141 1 0
    //   266: checkcast 133	java/lang/String
    //   269: aload 8
    //   271: invokevirtual 145	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   274: ifne +85 -> 359
    //   277: aload 7
    //   279: invokevirtual 148	java/io/File:delete	()Z
    //   282: pop
    //   283: iconst_2
    //   284: istore_1
    //   285: aload 5
    //   287: invokeinterface 153 1 0
    //   292: pop
    //   293: aload_0
    //   294: monitorexit
    //   295: iconst_0
    //   296: putstatic 22	apgo:jdField_a_of_type_Boolean	Z
    //   299: iload_1
    //   300: ireturn
    //   301: astore_0
    //   302: iconst_0
    //   303: putstatic 22	apgo:jdField_a_of_type_Boolean	Z
    //   306: invokestatic 45	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   309: ifeq +31 -> 340
    //   312: ldc 47
    //   314: iconst_2
    //   315: new 49	java/lang/StringBuilder
    //   318: dup
    //   319: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   322: ldc 155
    //   324: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: aload_0
    //   328: invokevirtual 158	java/io/IOException:getMessage	()Ljava/lang/String;
    //   331: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   337: invokestatic 66	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   340: invokestatic 68	apgo:a	()Ljava/lang/String;
    //   343: iconst_0
    //   344: invokestatic 161	com/tencent/mobileqq/utils/FileUtils:delete	(Ljava/lang/String;Z)V
    //   347: iconst_m1
    //   348: ireturn
    //   349: astore 4
    //   351: aload 4
    //   353: invokevirtual 164	java/io/IOException:printStackTrace	()V
    //   356: goto -213 -> 143
    //   359: aload 5
    //   361: new 49	java/lang/StringBuilder
    //   364: dup
    //   365: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   368: ldc 166
    //   370: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: aload 6
    //   375: invokeinterface 131 1 0
    //   380: checkcast 133	java/lang/String
    //   383: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   389: aload 6
    //   391: invokeinterface 141 1 0
    //   396: checkcast 133	java/lang/String
    //   399: invokeinterface 170 3 0
    //   404: pop
    //   405: goto -231 -> 174
    //   408: astore 4
    //   410: aload_0
    //   411: monitorexit
    //   412: aload 4
    //   414: athrow
    //   415: iconst_3
    //   416: istore_1
    //   417: goto -132 -> 285
    //   420: iconst_4
    //   421: istore_2
    //   422: iload_2
    //   423: istore_1
    //   424: invokestatic 45	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   427: ifeq -132 -> 295
    //   430: ldc 47
    //   432: iconst_2
    //   433: ldc 172
    //   435: invokestatic 66	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   438: iload_2
    //   439: istore_1
    //   440: goto -145 -> 295
    //   443: invokestatic 45	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   446: ifeq +11 -> 457
    //   449: ldc 47
    //   451: iconst_2
    //   452: ldc 174
    //   454: invokestatic 66	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   457: iconst_0
    //   458: istore_1
    //   459: goto -164 -> 295
    //   462: iconst_0
    //   463: istore_1
    //   464: goto -179 -> 285
    // Local variable table:
    //   start	length	slot	name	signature
    //   284	180	1	b1	byte
    //   421	18	2	b2	byte
    //   29	23	3	bool	boolean
    //   14	171	4	localObject1	Object
    //   349	3	4	localIOException	java.io.IOException
    //   408	5	4	localObject2	Object
    //   91	269	5	localEditor	android.content.SharedPreferences.Editor
    //   75	315	6	localObject3	Object
    //   242	36	7	localFile	File
    //   231	39	8	str	String
    // Exception table:
    //   from	to	target	type
    //   61	68	301	java/io/IOException
    //   133	140	349	java/io/IOException
    //   162	174	408	finally
    //   174	283	408	finally
    //   285	295	408	finally
    //   359	405	408	finally
    //   410	412	408	finally
  }
  
  public static String a()
  {
    Object localObject = BaseApplicationImpl.sApplication.getFilesDir();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FaceScanModelsLoader", 2, "getFilesDir is null");
      }
      localObject = "";
    }
    String str;
    do
    {
      return localObject;
      str = localObject + "/pddata/prd/face_scan_models";
      localObject = str;
    } while (!QLog.isColorLevel());
    QLog.i("FaceScanModelsLoader", 2, "getFaceModelsPath ,path = " + str);
    return str;
  }
  
  public static void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FaceScanModelsLoader", 2, "uninitModels start hasFaceModelInit = " + b);
    }
    c = true;
    if (b)
    {
      FaceCluster.getInstance().release();
      b = false;
    }
    c = false;
    if (QLog.isColorLevel()) {
      QLog.d("FaceScanModelsLoader", 2, "uninitModels finish");
    }
  }
  
  /* Error */
  public static void a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: invokestatic 45	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +28 -> 33
    //   8: ldc 47
    //   10: iconst_2
    //   11: new 49	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   18: ldc 213
    //   20: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_0
    //   24: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 66	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: new 215	com/tencent/commonsdk/zip/QZipFile
    //   36: dup
    //   37: aload_0
    //   38: invokespecial 216	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/lang/String;)V
    //   41: astore 4
    //   43: aload 4
    //   45: invokevirtual 220	com/tencent/commonsdk/zip/QZipFile:entries	()Ljava/util/Enumeration;
    //   48: astore 7
    //   50: sipush 8192
    //   53: newarray byte
    //   55: astore 6
    //   57: aload 7
    //   59: invokeinterface 225 1 0
    //   64: ifeq +332 -> 396
    //   67: aload 7
    //   69: invokeinterface 228 1 0
    //   74: checkcast 230	java/util/zip/ZipEntry
    //   77: astore 5
    //   79: aload 5
    //   81: invokevirtual 233	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   84: astore_0
    //   85: aload_0
    //   86: ifnull +412 -> 498
    //   89: aload_0
    //   90: ldc 235
    //   92: invokevirtual 239	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   95: ifeq +6 -> 101
    //   98: goto -41 -> 57
    //   101: new 49	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   108: aload_1
    //   109: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: getstatic 128	java/io/File:separator	Ljava/lang/String;
    //   115: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload_0
    //   119: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: astore_0
    //   126: aload 5
    //   128: invokevirtual 242	java/util/zip/ZipEntry:isDirectory	()Z
    //   131: ifeq +27 -> 158
    //   134: new 24	java/io/File
    //   137: dup
    //   138: aload_0
    //   139: invokespecial 30	java/io/File:<init>	(Ljava/lang/String;)V
    //   142: astore_0
    //   143: aload_0
    //   144: invokevirtual 34	java/io/File:exists	()Z
    //   147: ifne +354 -> 501
    //   150: aload_0
    //   151: invokevirtual 245	java/io/File:mkdir	()Z
    //   154: pop
    //   155: goto +346 -> 501
    //   158: aload_0
    //   159: getstatic 128	java/io/File:separator	Ljava/lang/String;
    //   162: invokevirtual 249	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   165: istore_2
    //   166: aload_0
    //   167: iconst_0
    //   168: iload_2
    //   169: invokevirtual 253	java/lang/String:substring	(II)Ljava/lang/String;
    //   172: astore 8
    //   174: aload_0
    //   175: iload_2
    //   176: iconst_1
    //   177: iadd
    //   178: invokevirtual 256	java/lang/String:substring	(I)Ljava/lang/String;
    //   181: ldc_w 258
    //   184: invokevirtual 261	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   187: ifeq +6 -> 193
    //   190: goto -133 -> 57
    //   193: new 24	java/io/File
    //   196: dup
    //   197: aload 8
    //   199: invokespecial 30	java/io/File:<init>	(Ljava/lang/String;)V
    //   202: astore 8
    //   204: aload 8
    //   206: invokevirtual 34	java/io/File:exists	()Z
    //   209: ifne +9 -> 218
    //   212: aload 8
    //   214: invokevirtual 245	java/io/File:mkdir	()Z
    //   217: pop
    //   218: new 24	java/io/File
    //   221: dup
    //   222: new 49	java/lang/StringBuilder
    //   225: dup
    //   226: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   229: aload_0
    //   230: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: ldc_w 263
    //   236: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   242: invokespecial 30	java/io/File:<init>	(Ljava/lang/String;)V
    //   245: astore 8
    //   247: new 24	java/io/File
    //   250: dup
    //   251: aload_0
    //   252: invokespecial 30	java/io/File:<init>	(Ljava/lang/String;)V
    //   255: astore 9
    //   257: aload 8
    //   259: invokevirtual 34	java/io/File:exists	()Z
    //   262: ifeq +9 -> 271
    //   265: aload 8
    //   267: invokevirtual 148	java/io/File:delete	()Z
    //   270: pop
    //   271: new 265	java/io/FileOutputStream
    //   274: dup
    //   275: aload 8
    //   277: invokespecial 268	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   280: astore_0
    //   281: aload 4
    //   283: aload 5
    //   285: invokevirtual 272	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   288: astore 5
    //   290: aload 5
    //   292: aload 6
    //   294: iconst_0
    //   295: aload 6
    //   297: arraylength
    //   298: invokevirtual 278	java/io/InputStream:read	([BII)I
    //   301: istore_2
    //   302: iload_2
    //   303: iconst_m1
    //   304: if_icmpeq +52 -> 356
    //   307: aload_0
    //   308: aload 6
    //   310: iconst_0
    //   311: iload_2
    //   312: invokevirtual 282	java/io/FileOutputStream:write	([BII)V
    //   315: goto -25 -> 290
    //   318: astore 6
    //   320: aload 5
    //   322: astore_1
    //   323: aload_0
    //   324: astore_3
    //   325: aload 6
    //   327: astore_0
    //   328: aload_3
    //   329: ifnull +7 -> 336
    //   332: aload_3
    //   333: invokevirtual 285	java/io/FileOutputStream:close	()V
    //   336: aload_1
    //   337: ifnull +7 -> 344
    //   340: aload_1
    //   341: invokevirtual 286	java/io/InputStream:close	()V
    //   344: aload 4
    //   346: ifnull +8 -> 354
    //   349: aload 4
    //   351: invokevirtual 287	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   354: aload_0
    //   355: athrow
    //   356: aload_0
    //   357: invokevirtual 290	java/io/FileOutputStream:flush	()V
    //   360: aload_0
    //   361: invokevirtual 285	java/io/FileOutputStream:close	()V
    //   364: aload 5
    //   366: invokevirtual 286	java/io/InputStream:close	()V
    //   369: aload 8
    //   371: aload 9
    //   373: invokestatic 294	com/tencent/mobileqq/utils/FileUtils:renameFile	(Ljava/io/File;Ljava/io/File;)Z
    //   376: ifne +125 -> 501
    //   379: aload 8
    //   381: aload 9
    //   383: invokestatic 297	com/tencent/mobileqq/utils/FileUtils:copyFile	(Ljava/io/File;Ljava/io/File;)Z
    //   386: pop
    //   387: goto +114 -> 501
    //   390: astore_0
    //   391: aconst_null
    //   392: astore_1
    //   393: goto -65 -> 328
    //   396: iconst_0
    //   397: ifeq +11 -> 408
    //   400: new 299	java/lang/NullPointerException
    //   403: dup
    //   404: invokespecial 300	java/lang/NullPointerException:<init>	()V
    //   407: athrow
    //   408: iconst_0
    //   409: ifeq +11 -> 420
    //   412: new 299	java/lang/NullPointerException
    //   415: dup
    //   416: invokespecial 300	java/lang/NullPointerException:<init>	()V
    //   419: athrow
    //   420: aload 4
    //   422: ifnull +8 -> 430
    //   425: aload 4
    //   427: invokevirtual 287	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   430: return
    //   431: astore_0
    //   432: aload_0
    //   433: invokevirtual 164	java/io/IOException:printStackTrace	()V
    //   436: goto -28 -> 408
    //   439: astore_0
    //   440: aload_0
    //   441: invokevirtual 164	java/io/IOException:printStackTrace	()V
    //   444: goto -24 -> 420
    //   447: astore_0
    //   448: aload_0
    //   449: invokevirtual 164	java/io/IOException:printStackTrace	()V
    //   452: return
    //   453: astore_3
    //   454: aload_3
    //   455: invokevirtual 164	java/io/IOException:printStackTrace	()V
    //   458: goto -122 -> 336
    //   461: astore_1
    //   462: aload_1
    //   463: invokevirtual 164	java/io/IOException:printStackTrace	()V
    //   466: goto -122 -> 344
    //   469: astore_1
    //   470: aload_1
    //   471: invokevirtual 164	java/io/IOException:printStackTrace	()V
    //   474: goto -120 -> 354
    //   477: astore_0
    //   478: aconst_null
    //   479: astore 4
    //   481: aconst_null
    //   482: astore_1
    //   483: goto -155 -> 328
    //   486: astore 5
    //   488: aconst_null
    //   489: astore_1
    //   490: aload_0
    //   491: astore_3
    //   492: aload 5
    //   494: astore_0
    //   495: goto -167 -> 328
    //   498: goto -441 -> 57
    //   501: goto -444 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	504	0	paramString1	String
    //   0	504	1	paramString2	String
    //   165	147	2	i	int
    //   1	332	3	str1	String
    //   453	2	3	localIOException	java.io.IOException
    //   491	1	3	str2	String
    //   41	439	4	localQZipFile	com.tencent.commonsdk.zip.QZipFile
    //   77	288	5	localObject1	Object
    //   486	7	5	localObject2	Object
    //   55	254	6	arrayOfByte	byte[]
    //   318	8	6	localObject3	Object
    //   48	20	7	localEnumeration	java.util.Enumeration
    //   172	208	8	localObject4	Object
    //   255	127	9	localFile	File
    // Exception table:
    //   from	to	target	type
    //   290	302	318	finally
    //   307	315	318	finally
    //   356	369	318	finally
    //   43	57	390	finally
    //   57	85	390	finally
    //   89	98	390	finally
    //   101	155	390	finally
    //   158	190	390	finally
    //   193	218	390	finally
    //   218	271	390	finally
    //   271	281	390	finally
    //   369	387	390	finally
    //   400	408	431	java/io/IOException
    //   412	420	439	java/io/IOException
    //   425	430	447	java/io/IOException
    //   332	336	453	java/io/IOException
    //   340	344	461	java/io/IOException
    //   349	354	469	java/io/IOException
    //   33	43	477	finally
    //   281	290	486	finally
  }
  
  public static boolean a()
  {
    if ((!a("fc_eval.rpdm")) || (!a("rpn_fr_cluster_256_norelu.model")))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FaceScanModelsLoader", 2, "modules is not exist!");
      }
      return false;
    }
    return true;
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if (paramContext == null) {
      return bool2;
    }
    if (b) {
      return b;
    }
    FaceCluster.getInstance();
    YTCommonInterface.initAuthForQQ(paramContext);
    if (FaceCluster.getInstance().isLoadSoSuccess()) {
      bool1 = b(paramContext);
    }
    for (;;)
    {
      b = bool1;
      bool2 = bool1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("FaceScanModelsLoader", 2, "initModels result = " + bool1);
      return bool1;
      QLog.d("FaceScanModelsLoader", 1, "initModels loadSo failed");
    }
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    String str1 = a() + File.separator + paramString;
    ??? = new File(str1);
    if ((!jdField_a_of_type_Boolean) && (((File)???).exists())) {
      for (;;)
      {
        synchronized (jdField_a_of_type_JavaLangObject)
        {
          String str2 = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 0).getString("face_models_" + paramString, null);
          if (str2 != null) {
            if (str2.equalsIgnoreCase(aznv.a(str1)))
            {
              break label173;
              return bool1;
            }
            else
            {
              bool1 = bool2;
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("FaceScanModelsLoader", 2, "isModelFileExist: modelName= " + paramString + " check md5 false!");
              bool1 = bool2;
            }
          }
        }
        label173:
        boolean bool1 = true;
      }
    }
    return false;
  }
  
  public static boolean a(String paramString, HashMap<String, String> paramHashMap)
  {
    boolean bool = true;
    XmlPullParser localXmlPullParser = Xml.newPullParser();
    paramHashMap.clear();
    int i;
    for (;;)
    {
      try
      {
        localXmlPullParser.setInput(new ByteArrayInputStream(paramString.getBytes()), "UTF-8");
        i = localXmlPullParser.getEventType();
      }
      catch (Exception paramHashMap)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("FaceScanModelsLoader", 2, paramString, paramHashMap);
        bool = false;
        return bool;
      }
      i = localXmlPullParser.next();
      break label174;
      String str = localXmlPullParser.getName();
      if (str.equalsIgnoreCase("fc_eval.rpdm"))
      {
        paramHashMap.put("fc_eval.rpdm", localXmlPullParser.nextText());
        continue;
      }
      else
      {
        if (!str.equalsIgnoreCase("rpn_fr_cluster_256_norelu.model")) {
          continue;
        }
        paramHashMap.put("rpn_fr_cluster_256_norelu.model", localXmlPullParser.nextText());
        continue;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("FaceScanModelsLoader", 2, "parseConfig success|config=" + paramHashMap);
      return true;
      label174:
      if (i != 1) {
        switch (i)
        {
        }
      }
    }
  }
  
  public static String b()
  {
    return BaseApplicationImpl.sApplication.getFilesDir().getParent() + "/face_models";
  }
  
  public static boolean b(Context paramContext)
  {
    String str2 = a();
    paramContext = str2 + File.separator + "ufdmtcc.bin";
    String str1 = str2 + File.separator + "ufat.bin";
    str2 = str2 + File.separator;
    return FaceCluster.getInstance().init(paramContext, str1, str2) == 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apgo
 * JD-Core Version:    0.7.0.1
 */
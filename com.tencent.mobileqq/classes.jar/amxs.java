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

public class amxs
{
  private static final Object a;
  public static boolean a;
  public static volatile boolean b;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
  }
  
  /* Error */
  public static byte a(String arg0)
  {
    // Byte code:
    //   0: iconst_1
    //   1: putstatic 21	amxs:jdField_a_of_type_Boolean	Z
    //   4: new 23	java/io/File
    //   7: dup
    //   8: invokestatic 26	amxs:b	()Ljava/lang/String;
    //   11: invokespecial 29	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: astore 4
    //   16: aload 4
    //   18: invokevirtual 33	java/io/File:exists	()Z
    //   21: ifeq +40 -> 61
    //   24: aload 4
    //   26: invokestatic 38	arso:a	(Ljava/io/File;)Z
    //   29: istore_3
    //   30: invokestatic 43	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   33: ifeq +28 -> 61
    //   36: ldc 45
    //   38: iconst_2
    //   39: new 47	java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   46: ldc 50
    //   48: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: iload_3
    //   52: invokevirtual 57	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   55: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: invokestatic 64	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   61: aload_0
    //   62: invokestatic 66	amxs:a	()Ljava/lang/String;
    //   65: invokestatic 69	amxs:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   68: new 71	java/util/HashMap
    //   71: dup
    //   72: invokespecial 72	java/util/HashMap:<init>	()V
    //   75: astore 6
    //   77: getstatic 78	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   80: ldc 80
    //   82: iconst_0
    //   83: invokevirtual 84	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   86: invokeinterface 90 1 0
    //   91: astore 5
    //   93: new 23	java/io/File
    //   96: dup
    //   97: new 47	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   104: invokestatic 66	amxs:a	()Ljava/lang/String;
    //   107: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: ldc 92
    //   112: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokespecial 29	java/io/File:<init>	(Ljava/lang/String;)V
    //   121: astore 4
    //   123: aload 4
    //   125: invokevirtual 33	java/io/File:exists	()Z
    //   128: ifeq +315 -> 443
    //   131: aconst_null
    //   132: astore_0
    //   133: aload 4
    //   135: invokestatic 97	bdhb:b	(Ljava/io/File;)Ljava/lang/String;
    //   138: astore 4
    //   140: aload 4
    //   142: astore_0
    //   143: aload_0
    //   144: ifnull +276 -> 420
    //   147: aload_0
    //   148: aload 6
    //   150: invokestatic 100	amxs:a	(Ljava/lang/String;Ljava/util/HashMap;)Z
    //   153: ifeq +267 -> 420
    //   156: getstatic 15	amxs:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   159: astore_0
    //   160: aload_0
    //   161: monitorenter
    //   162: aload 6
    //   164: invokevirtual 104	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   167: invokeinterface 110 1 0
    //   172: astore 4
    //   174: aload 4
    //   176: invokeinterface 115 1 0
    //   181: ifeq +281 -> 462
    //   184: aload 4
    //   186: invokeinterface 119 1 0
    //   191: checkcast 121	java/util/Map$Entry
    //   194: astore 6
    //   196: new 47	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   203: invokestatic 66	amxs:a	()Ljava/lang/String;
    //   206: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: getstatic 125	java/io/File:separator	Ljava/lang/String;
    //   212: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: aload 6
    //   217: invokeinterface 128 1 0
    //   222: checkcast 130	java/lang/String
    //   225: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: astore 8
    //   233: new 23	java/io/File
    //   236: dup
    //   237: aload 8
    //   239: invokespecial 29	java/io/File:<init>	(Ljava/lang/String;)V
    //   242: astore 7
    //   244: aload 7
    //   246: invokevirtual 33	java/io/File:exists	()Z
    //   249: ifeq +166 -> 415
    //   252: aload 8
    //   254: invokestatic 135	awni:a	(Ljava/lang/String;)Ljava/lang/String;
    //   257: astore 8
    //   259: aload 6
    //   261: invokeinterface 138 1 0
    //   266: checkcast 130	java/lang/String
    //   269: aload 8
    //   271: invokevirtual 142	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   274: ifne +85 -> 359
    //   277: aload 7
    //   279: invokevirtual 145	java/io/File:delete	()Z
    //   282: pop
    //   283: iconst_2
    //   284: istore_1
    //   285: aload 5
    //   287: invokeinterface 150 1 0
    //   292: pop
    //   293: aload_0
    //   294: monitorexit
    //   295: iconst_0
    //   296: putstatic 21	amxs:jdField_a_of_type_Boolean	Z
    //   299: iload_1
    //   300: ireturn
    //   301: astore_0
    //   302: iconst_0
    //   303: putstatic 21	amxs:jdField_a_of_type_Boolean	Z
    //   306: invokestatic 43	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   309: ifeq +31 -> 340
    //   312: ldc 45
    //   314: iconst_2
    //   315: new 47	java/lang/StringBuilder
    //   318: dup
    //   319: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   322: ldc 152
    //   324: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: aload_0
    //   328: invokevirtual 155	java/io/IOException:getMessage	()Ljava/lang/String;
    //   331: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   337: invokestatic 64	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   340: invokestatic 66	amxs:a	()Ljava/lang/String;
    //   343: iconst_0
    //   344: invokestatic 158	bdhb:a	(Ljava/lang/String;Z)V
    //   347: iconst_m1
    //   348: ireturn
    //   349: astore 4
    //   351: aload 4
    //   353: invokevirtual 161	java/io/IOException:printStackTrace	()V
    //   356: goto -213 -> 143
    //   359: aload 5
    //   361: new 47	java/lang/StringBuilder
    //   364: dup
    //   365: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   368: ldc 163
    //   370: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: aload 6
    //   375: invokeinterface 128 1 0
    //   380: checkcast 130	java/lang/String
    //   383: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   389: aload 6
    //   391: invokeinterface 138 1 0
    //   396: checkcast 130	java/lang/String
    //   399: invokeinterface 167 3 0
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
    //   424: invokestatic 43	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   427: ifeq -132 -> 295
    //   430: ldc 45
    //   432: iconst_2
    //   433: ldc 169
    //   435: invokestatic 64	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   438: iload_2
    //   439: istore_1
    //   440: goto -145 -> 295
    //   443: invokestatic 43	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   446: ifeq +11 -> 457
    //   449: ldc 45
    //   451: iconst_2
    //   452: ldc 171
    //   454: invokestatic 64	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
  
  /* Error */
  public static void a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: invokestatic 43	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +28 -> 33
    //   8: ldc 45
    //   10: iconst_2
    //   11: new 47	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   18: ldc 193
    //   20: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_0
    //   24: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 64	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: new 195	com/tencent/commonsdk/zip/QZipFile
    //   36: dup
    //   37: aload_0
    //   38: invokespecial 196	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/lang/String;)V
    //   41: astore 4
    //   43: aload 4
    //   45: invokevirtual 200	com/tencent/commonsdk/zip/QZipFile:entries	()Ljava/util/Enumeration;
    //   48: astore 6
    //   50: sipush 8192
    //   53: newarray byte
    //   55: astore 7
    //   57: aload 6
    //   59: invokeinterface 205 1 0
    //   64: ifeq +330 -> 394
    //   67: aload 6
    //   69: invokeinterface 208 1 0
    //   74: checkcast 210	java/util/zip/ZipEntry
    //   77: astore 5
    //   79: aload 5
    //   81: invokevirtual 213	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   84: astore_0
    //   85: aload_0
    //   86: ifnull +410 -> 496
    //   89: aload_0
    //   90: ldc 215
    //   92: invokevirtual 219	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   95: ifeq +6 -> 101
    //   98: goto -41 -> 57
    //   101: new 47	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   108: aload_1
    //   109: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: getstatic 125	java/io/File:separator	Ljava/lang/String;
    //   115: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload_0
    //   119: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: astore_0
    //   126: aload 5
    //   128: invokevirtual 222	java/util/zip/ZipEntry:isDirectory	()Z
    //   131: ifeq +27 -> 158
    //   134: new 23	java/io/File
    //   137: dup
    //   138: aload_0
    //   139: invokespecial 29	java/io/File:<init>	(Ljava/lang/String;)V
    //   142: astore_0
    //   143: aload_0
    //   144: invokevirtual 33	java/io/File:exists	()Z
    //   147: ifne +352 -> 499
    //   150: aload_0
    //   151: invokevirtual 225	java/io/File:mkdir	()Z
    //   154: pop
    //   155: goto +344 -> 499
    //   158: aload_0
    //   159: getstatic 125	java/io/File:separator	Ljava/lang/String;
    //   162: invokevirtual 229	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   165: istore_2
    //   166: aload_0
    //   167: iconst_0
    //   168: iload_2
    //   169: invokevirtual 233	java/lang/String:substring	(II)Ljava/lang/String;
    //   172: astore 8
    //   174: aload_0
    //   175: iload_2
    //   176: iconst_1
    //   177: iadd
    //   178: invokevirtual 236	java/lang/String:substring	(I)Ljava/lang/String;
    //   181: ldc 238
    //   183: invokevirtual 241	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   186: ifeq +6 -> 192
    //   189: goto -132 -> 57
    //   192: new 23	java/io/File
    //   195: dup
    //   196: aload 8
    //   198: invokespecial 29	java/io/File:<init>	(Ljava/lang/String;)V
    //   201: astore 8
    //   203: aload 8
    //   205: invokevirtual 33	java/io/File:exists	()Z
    //   208: ifne +9 -> 217
    //   211: aload 8
    //   213: invokevirtual 225	java/io/File:mkdir	()Z
    //   216: pop
    //   217: new 23	java/io/File
    //   220: dup
    //   221: new 47	java/lang/StringBuilder
    //   224: dup
    //   225: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   228: aload_0
    //   229: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: ldc 243
    //   234: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokespecial 29	java/io/File:<init>	(Ljava/lang/String;)V
    //   243: astore 8
    //   245: new 23	java/io/File
    //   248: dup
    //   249: aload_0
    //   250: invokespecial 29	java/io/File:<init>	(Ljava/lang/String;)V
    //   253: astore 9
    //   255: aload 8
    //   257: invokevirtual 33	java/io/File:exists	()Z
    //   260: ifeq +9 -> 269
    //   263: aload 8
    //   265: invokevirtual 145	java/io/File:delete	()Z
    //   268: pop
    //   269: new 245	java/io/FileOutputStream
    //   272: dup
    //   273: aload 8
    //   275: invokespecial 248	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   278: astore_0
    //   279: aload 4
    //   281: aload 5
    //   283: invokevirtual 252	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   286: astore 5
    //   288: aload 5
    //   290: aload 7
    //   292: iconst_0
    //   293: aload 7
    //   295: arraylength
    //   296: invokevirtual 258	java/io/InputStream:read	([BII)I
    //   299: istore_2
    //   300: iload_2
    //   301: iconst_m1
    //   302: if_icmpeq +52 -> 354
    //   305: aload_0
    //   306: aload 7
    //   308: iconst_0
    //   309: iload_2
    //   310: invokevirtual 262	java/io/FileOutputStream:write	([BII)V
    //   313: goto -25 -> 288
    //   316: astore 6
    //   318: aload 5
    //   320: astore_1
    //   321: aload_0
    //   322: astore_3
    //   323: aload 6
    //   325: astore_0
    //   326: aload_3
    //   327: ifnull +7 -> 334
    //   330: aload_3
    //   331: invokevirtual 265	java/io/FileOutputStream:close	()V
    //   334: aload_1
    //   335: ifnull +7 -> 342
    //   338: aload_1
    //   339: invokevirtual 266	java/io/InputStream:close	()V
    //   342: aload 4
    //   344: ifnull +8 -> 352
    //   347: aload 4
    //   349: invokevirtual 267	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   352: aload_0
    //   353: athrow
    //   354: aload_0
    //   355: invokevirtual 270	java/io/FileOutputStream:flush	()V
    //   358: aload_0
    //   359: invokevirtual 265	java/io/FileOutputStream:close	()V
    //   362: aload 5
    //   364: invokevirtual 266	java/io/InputStream:close	()V
    //   367: aload 8
    //   369: aload 9
    //   371: invokestatic 273	bdhb:b	(Ljava/io/File;Ljava/io/File;)Z
    //   374: ifne +125 -> 499
    //   377: aload 8
    //   379: aload 9
    //   381: invokestatic 275	bdhb:a	(Ljava/io/File;Ljava/io/File;)Z
    //   384: pop
    //   385: goto +114 -> 499
    //   388: astore_0
    //   389: aconst_null
    //   390: astore_1
    //   391: goto -65 -> 326
    //   394: iconst_0
    //   395: ifeq +11 -> 406
    //   398: new 277	java/lang/NullPointerException
    //   401: dup
    //   402: invokespecial 278	java/lang/NullPointerException:<init>	()V
    //   405: athrow
    //   406: iconst_0
    //   407: ifeq +11 -> 418
    //   410: new 277	java/lang/NullPointerException
    //   413: dup
    //   414: invokespecial 278	java/lang/NullPointerException:<init>	()V
    //   417: athrow
    //   418: aload 4
    //   420: ifnull +8 -> 428
    //   423: aload 4
    //   425: invokevirtual 267	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   428: return
    //   429: astore_0
    //   430: aload_0
    //   431: invokevirtual 161	java/io/IOException:printStackTrace	()V
    //   434: goto -28 -> 406
    //   437: astore_0
    //   438: aload_0
    //   439: invokevirtual 161	java/io/IOException:printStackTrace	()V
    //   442: goto -24 -> 418
    //   445: astore_0
    //   446: aload_0
    //   447: invokevirtual 161	java/io/IOException:printStackTrace	()V
    //   450: return
    //   451: astore_3
    //   452: aload_3
    //   453: invokevirtual 161	java/io/IOException:printStackTrace	()V
    //   456: goto -122 -> 334
    //   459: astore_1
    //   460: aload_1
    //   461: invokevirtual 161	java/io/IOException:printStackTrace	()V
    //   464: goto -122 -> 342
    //   467: astore_1
    //   468: aload_1
    //   469: invokevirtual 161	java/io/IOException:printStackTrace	()V
    //   472: goto -120 -> 352
    //   475: astore_0
    //   476: aconst_null
    //   477: astore 4
    //   479: aconst_null
    //   480: astore_1
    //   481: goto -155 -> 326
    //   484: astore 5
    //   486: aconst_null
    //   487: astore_1
    //   488: aload_0
    //   489: astore_3
    //   490: aload 5
    //   492: astore_0
    //   493: goto -167 -> 326
    //   496: goto -439 -> 57
    //   499: goto -442 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	502	0	paramString1	String
    //   0	502	1	paramString2	String
    //   165	145	2	i	int
    //   1	330	3	str1	String
    //   451	2	3	localIOException	java.io.IOException
    //   489	1	3	str2	String
    //   41	437	4	localQZipFile	com.tencent.commonsdk.zip.QZipFile
    //   77	286	5	localObject1	Object
    //   484	7	5	localObject2	Object
    //   48	20	6	localEnumeration	java.util.Enumeration
    //   316	8	6	localObject3	Object
    //   55	252	7	arrayOfByte	byte[]
    //   172	206	8	localObject4	Object
    //   253	127	9	localFile	File
    // Exception table:
    //   from	to	target	type
    //   288	300	316	finally
    //   305	313	316	finally
    //   354	367	316	finally
    //   43	57	388	finally
    //   57	85	388	finally
    //   89	98	388	finally
    //   101	155	388	finally
    //   158	189	388	finally
    //   192	217	388	finally
    //   217	269	388	finally
    //   269	279	388	finally
    //   367	385	388	finally
    //   398	406	429	java/io/IOException
    //   410	418	437	java/io/IOException
    //   423	428	445	java/io/IOException
    //   330	334	451	java/io/IOException
    //   338	342	459	java/io/IOException
    //   347	352	467	java/io/IOException
    //   33	43	475	finally
    //   279	288	484	finally
  }
  
  public static boolean a()
  {
    if ((!a("fc_eval.rpdm")) || (!a("rpn_fr_cluster_256_norelu.model")) || (!a("ufat.bin")) || (!a("ufdmtcc.bin")))
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
    YTCommonInterface.initAuth(paramContext, "youtusdk_mqq.licence", 0);
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
            if (str2.equalsIgnoreCase(awni.a(str1)))
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
      int i = localXmlPullParser.next();
      break label232;
      String str = localXmlPullParser.getName();
      if (str.equalsIgnoreCase("fc_eval.rpdm"))
      {
        paramHashMap.put("fc_eval.rpdm", localXmlPullParser.nextText());
        continue;
      }
      else
      {
        if (str.equalsIgnoreCase("rpn_fr_cluster_256_norelu.model"))
        {
          paramHashMap.put("rpn_fr_cluster_256_norelu.model", localXmlPullParser.nextText());
          continue;
        }
        if (str.equalsIgnoreCase("ufat.bin"))
        {
          paramHashMap.put("ufat.bin", localXmlPullParser.nextText());
          continue;
        }
        if (!str.equalsIgnoreCase("ufdmtcc.bin")) {
          continue;
        }
        paramHashMap.put("ufdmtcc.bin", localXmlPullParser.nextText());
        continue;
      }
      if (QLog.isColorLevel())
      {
        QLog.d("FaceScanModelsLoader", 2, "parseConfig success|config=" + paramHashMap);
        return true;
        label232:
        if (i != 1) {
          switch (i)
          {
          }
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
 * Qualified Name:     amxs
 * JD-Core Version:    0.7.0.1
 */
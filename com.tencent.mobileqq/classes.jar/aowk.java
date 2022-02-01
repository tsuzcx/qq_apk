import android.content.Context;
import android.content.SharedPreferences;
import android.util.Xml;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;

public class aowk
{
  private static final Object a;
  public static boolean a;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
  }
  
  /* Error */
  public static byte a(String arg0)
  {
    // Byte code:
    //   0: iconst_4
    //   1: istore_2
    //   2: iconst_1
    //   3: putstatic 20	aowk:jdField_a_of_type_Boolean	Z
    //   6: new 22	java/io/File
    //   9: dup
    //   10: invokestatic 26	aowk:b	()Ljava/lang/String;
    //   13: invokespecial 29	java/io/File:<init>	(Ljava/lang/String;)V
    //   16: astore 4
    //   18: aload 4
    //   20: invokevirtual 33	java/io/File:exists	()Z
    //   23: ifeq +40 -> 63
    //   26: aload 4
    //   28: invokestatic 38	atwl:a	(Ljava/io/File;)Z
    //   31: istore_3
    //   32: invokestatic 43	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   35: ifeq +28 -> 63
    //   38: ldc 45
    //   40: iconst_2
    //   41: new 47	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   48: ldc 50
    //   50: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: iload_3
    //   54: invokevirtual 57	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   57: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: invokestatic 64	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   63: aload_0
    //   64: invokestatic 66	aowk:a	()Ljava/lang/String;
    //   67: invokestatic 69	aowk:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   70: new 71	java/util/HashMap
    //   73: dup
    //   74: invokespecial 72	java/util/HashMap:<init>	()V
    //   77: astore 6
    //   79: getstatic 78	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   82: ldc 80
    //   84: iconst_4
    //   85: invokevirtual 84	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   88: invokeinterface 90 1 0
    //   93: astore 5
    //   95: new 22	java/io/File
    //   98: dup
    //   99: new 47	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   106: invokestatic 66	aowk:a	()Ljava/lang/String;
    //   109: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: ldc 92
    //   114: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokespecial 29	java/io/File:<init>	(Ljava/lang/String;)V
    //   123: astore 4
    //   125: aload 4
    //   127: invokevirtual 33	java/io/File:exists	()Z
    //   130: ifeq +375 -> 505
    //   133: aconst_null
    //   134: astore_0
    //   135: aload 4
    //   137: invokestatic 97	bgmg:b	(Ljava/io/File;)Ljava/lang/String;
    //   140: astore 4
    //   142: aload 4
    //   144: astore_0
    //   145: aload_0
    //   146: ifnull +338 -> 484
    //   149: aload_0
    //   150: aload 6
    //   152: invokestatic 100	aowk:a	(Ljava/lang/String;Ljava/util/HashMap;)Z
    //   155: ifeq +329 -> 484
    //   158: getstatic 14	aowk:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   161: astore_0
    //   162: aload_0
    //   163: monitorenter
    //   164: aload 6
    //   166: invokevirtual 104	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   169: invokeinterface 110 1 0
    //   174: astore 4
    //   176: aload 4
    //   178: invokeinterface 115 1 0
    //   183: ifeq +341 -> 524
    //   186: aload 4
    //   188: invokeinterface 119 1 0
    //   193: checkcast 121	java/util/Map$Entry
    //   196: astore 6
    //   198: new 47	java/lang/StringBuilder
    //   201: dup
    //   202: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   205: invokestatic 66	aowk:a	()Ljava/lang/String;
    //   208: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: ldc 123
    //   213: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: aload 6
    //   218: invokeinterface 126 1 0
    //   223: checkcast 128	java/lang/String
    //   226: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: ldc 130
    //   231: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   237: astore 8
    //   239: new 22	java/io/File
    //   242: dup
    //   243: aload 8
    //   245: invokespecial 29	java/io/File:<init>	(Ljava/lang/String;)V
    //   248: astore 7
    //   250: aload 7
    //   252: invokevirtual 33	java/io/File:exists	()Z
    //   255: ifeq +224 -> 479
    //   258: aload 8
    //   260: invokestatic 135	azby:a	(Ljava/lang/String;)Ljava/lang/String;
    //   263: astore 8
    //   265: aload 6
    //   267: invokeinterface 138 1 0
    //   272: checkcast 128	java/lang/String
    //   275: aload 8
    //   277: invokevirtual 142	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   280: ifne +85 -> 365
    //   283: aload 7
    //   285: invokevirtual 145	java/io/File:delete	()Z
    //   288: pop
    //   289: iconst_2
    //   290: istore_1
    //   291: aload 5
    //   293: invokeinterface 150 1 0
    //   298: pop
    //   299: aload_0
    //   300: monitorexit
    //   301: iconst_0
    //   302: putstatic 20	aowk:jdField_a_of_type_Boolean	Z
    //   305: iload_1
    //   306: ireturn
    //   307: astore_0
    //   308: iconst_0
    //   309: putstatic 20	aowk:jdField_a_of_type_Boolean	Z
    //   312: invokestatic 43	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   315: ifeq +31 -> 346
    //   318: ldc 45
    //   320: iconst_2
    //   321: new 47	java/lang/StringBuilder
    //   324: dup
    //   325: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   328: ldc 152
    //   330: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: aload_0
    //   334: invokevirtual 155	java/io/IOException:getMessage	()Ljava/lang/String;
    //   337: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   343: invokestatic 64	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   346: invokestatic 66	aowk:a	()Ljava/lang/String;
    //   349: iconst_0
    //   350: invokestatic 158	bgmg:a	(Ljava/lang/String;Z)V
    //   353: iconst_m1
    //   354: ireturn
    //   355: astore 4
    //   357: aload 4
    //   359: invokevirtual 161	java/io/IOException:printStackTrace	()V
    //   362: goto -217 -> 145
    //   365: aload 5
    //   367: new 47	java/lang/StringBuilder
    //   370: dup
    //   371: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   374: ldc 163
    //   376: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: aload 6
    //   381: invokeinterface 126 1 0
    //   386: checkcast 128	java/lang/String
    //   389: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   395: aload 6
    //   397: invokeinterface 138 1 0
    //   402: checkcast 128	java/lang/String
    //   405: invokeinterface 167 3 0
    //   410: pop
    //   411: invokestatic 43	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   414: ifeq -238 -> 176
    //   417: ldc 45
    //   419: iconst_2
    //   420: new 47	java/lang/StringBuilder
    //   423: dup
    //   424: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   427: ldc 169
    //   429: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: aload 6
    //   434: invokeinterface 126 1 0
    //   439: checkcast 128	java/lang/String
    //   442: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: ldc 171
    //   447: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: aload 6
    //   452: invokeinterface 138 1 0
    //   457: checkcast 128	java/lang/String
    //   460: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   466: invokestatic 64	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   469: goto -293 -> 176
    //   472: astore 4
    //   474: aload_0
    //   475: monitorexit
    //   476: aload 4
    //   478: athrow
    //   479: iconst_3
    //   480: istore_1
    //   481: goto -190 -> 291
    //   484: iload_2
    //   485: istore_1
    //   486: invokestatic 43	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   489: ifeq -188 -> 301
    //   492: ldc 45
    //   494: iconst_2
    //   495: ldc 173
    //   497: invokestatic 64	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   500: iload_2
    //   501: istore_1
    //   502: goto -201 -> 301
    //   505: invokestatic 43	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   508: ifeq +11 -> 519
    //   511: ldc 45
    //   513: iconst_2
    //   514: ldc 175
    //   516: invokestatic 64	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   519: iconst_0
    //   520: istore_1
    //   521: goto -220 -> 301
    //   524: iconst_0
    //   525: istore_1
    //   526: goto -235 -> 291
    // Local variable table:
    //   start	length	slot	name	signature
    //   290	236	1	b1	byte
    //   1	500	2	b2	byte
    //   31	23	3	bool	boolean
    //   16	171	4	localObject1	Object
    //   355	3	4	localIOException	java.io.IOException
    //   472	5	4	localObject2	Object
    //   93	273	5	localEditor	android.content.SharedPreferences.Editor
    //   77	374	6	localObject3	Object
    //   248	36	7	localFile	File
    //   237	39	8	str	String
    // Exception table:
    //   from	to	target	type
    //   63	70	307	java/io/IOException
    //   135	142	355	java/io/IOException
    //   164	176	472	finally
    //   176	289	472	finally
    //   291	301	472	finally
    //   365	469	472	finally
    //   474	476	472	finally
  }
  
  public static String a()
  {
    Object localObject = BaseApplicationImpl.sApplication.getFilesDir();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FaceScanNativeSoLoader", 2, "getFilesDir is null");
      }
      localObject = "";
    }
    String str;
    do
    {
      return localObject;
      str = localObject + "/pddata/prd/face_scan_so_v795";
      localObject = str;
    } while (!QLog.isColorLevel());
    QLog.i("FaceScanNativeSoLoader", 2, "getFaceLibPath ,path = " + str);
    return str;
  }
  
  public static String a(String paramString)
  {
    new StringBuilder().append(a()).append("/lib").append(paramString).append(".so").toString();
    String str = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 4).getString("face_native_" + paramString, null);
    if (QLog.isColorLevel()) {
      QLog.i("FaceScanNativeSoLoader", 2, "getFaceSoMd5 ,soName = " + paramString + ",md5 = " + str);
    }
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
    //   18: ldc 205
    //   20: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_0
    //   24: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 64	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: new 207	com/tencent/commonsdk/zip/QZipFile
    //   36: dup
    //   37: aload_0
    //   38: invokespecial 208	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/lang/String;)V
    //   41: astore 4
    //   43: aload 4
    //   45: invokevirtual 212	com/tencent/commonsdk/zip/QZipFile:entries	()Ljava/util/Enumeration;
    //   48: astore 6
    //   50: sipush 8192
    //   53: newarray byte
    //   55: astore 7
    //   57: aload 6
    //   59: invokeinterface 217 1 0
    //   64: ifeq +331 -> 395
    //   67: aload 6
    //   69: invokeinterface 220 1 0
    //   74: checkcast 222	java/util/zip/ZipEntry
    //   77: astore 5
    //   79: aload 5
    //   81: invokevirtual 225	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   84: astore_0
    //   85: aload_0
    //   86: ifnull +411 -> 497
    //   89: aload_0
    //   90: ldc 227
    //   92: invokevirtual 231	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   95: ifeq +6 -> 101
    //   98: goto -41 -> 57
    //   101: new 47	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   108: aload_1
    //   109: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: getstatic 235	java/io/File:separator	Ljava/lang/String;
    //   115: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload_0
    //   119: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: astore_0
    //   126: aload 5
    //   128: invokevirtual 238	java/util/zip/ZipEntry:isDirectory	()Z
    //   131: ifeq +27 -> 158
    //   134: new 22	java/io/File
    //   137: dup
    //   138: aload_0
    //   139: invokespecial 29	java/io/File:<init>	(Ljava/lang/String;)V
    //   142: astore_0
    //   143: aload_0
    //   144: invokevirtual 33	java/io/File:exists	()Z
    //   147: ifne +353 -> 500
    //   150: aload_0
    //   151: invokevirtual 241	java/io/File:mkdir	()Z
    //   154: pop
    //   155: goto +345 -> 500
    //   158: aload_0
    //   159: getstatic 235	java/io/File:separator	Ljava/lang/String;
    //   162: invokevirtual 245	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   165: istore_2
    //   166: aload_0
    //   167: iconst_0
    //   168: iload_2
    //   169: invokevirtual 249	java/lang/String:substring	(II)Ljava/lang/String;
    //   172: astore 8
    //   174: aload_0
    //   175: iload_2
    //   176: iconst_1
    //   177: iadd
    //   178: invokevirtual 252	java/lang/String:substring	(I)Ljava/lang/String;
    //   181: ldc 254
    //   183: invokevirtual 257	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   186: ifeq +6 -> 192
    //   189: goto -132 -> 57
    //   192: new 22	java/io/File
    //   195: dup
    //   196: aload 8
    //   198: invokespecial 29	java/io/File:<init>	(Ljava/lang/String;)V
    //   201: astore 8
    //   203: aload 8
    //   205: invokevirtual 33	java/io/File:exists	()Z
    //   208: ifne +9 -> 217
    //   211: aload 8
    //   213: invokevirtual 241	java/io/File:mkdir	()Z
    //   216: pop
    //   217: new 22	java/io/File
    //   220: dup
    //   221: new 47	java/lang/StringBuilder
    //   224: dup
    //   225: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   228: aload_0
    //   229: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: ldc_w 259
    //   235: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: invokespecial 29	java/io/File:<init>	(Ljava/lang/String;)V
    //   244: astore 8
    //   246: new 22	java/io/File
    //   249: dup
    //   250: aload_0
    //   251: invokespecial 29	java/io/File:<init>	(Ljava/lang/String;)V
    //   254: astore 9
    //   256: aload 8
    //   258: invokevirtual 33	java/io/File:exists	()Z
    //   261: ifeq +9 -> 270
    //   264: aload 8
    //   266: invokevirtual 145	java/io/File:delete	()Z
    //   269: pop
    //   270: new 261	java/io/FileOutputStream
    //   273: dup
    //   274: aload 8
    //   276: invokespecial 264	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   279: astore_0
    //   280: aload 4
    //   282: aload 5
    //   284: invokevirtual 268	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   287: astore 5
    //   289: aload 5
    //   291: aload 7
    //   293: iconst_0
    //   294: aload 7
    //   296: arraylength
    //   297: invokevirtual 274	java/io/InputStream:read	([BII)I
    //   300: istore_2
    //   301: iload_2
    //   302: iconst_m1
    //   303: if_icmpeq +52 -> 355
    //   306: aload_0
    //   307: aload 7
    //   309: iconst_0
    //   310: iload_2
    //   311: invokevirtual 278	java/io/FileOutputStream:write	([BII)V
    //   314: goto -25 -> 289
    //   317: astore 6
    //   319: aload 5
    //   321: astore_1
    //   322: aload_0
    //   323: astore_3
    //   324: aload 6
    //   326: astore_0
    //   327: aload_3
    //   328: ifnull +7 -> 335
    //   331: aload_3
    //   332: invokevirtual 281	java/io/FileOutputStream:close	()V
    //   335: aload_1
    //   336: ifnull +7 -> 343
    //   339: aload_1
    //   340: invokevirtual 282	java/io/InputStream:close	()V
    //   343: aload 4
    //   345: ifnull +8 -> 353
    //   348: aload 4
    //   350: invokevirtual 283	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   353: aload_0
    //   354: athrow
    //   355: aload_0
    //   356: invokevirtual 286	java/io/FileOutputStream:flush	()V
    //   359: aload_0
    //   360: invokevirtual 281	java/io/FileOutputStream:close	()V
    //   363: aload 5
    //   365: invokevirtual 282	java/io/InputStream:close	()V
    //   368: aload 8
    //   370: aload 9
    //   372: invokestatic 289	bgmg:b	(Ljava/io/File;Ljava/io/File;)Z
    //   375: ifne +125 -> 500
    //   378: aload 8
    //   380: aload 9
    //   382: invokestatic 291	bgmg:a	(Ljava/io/File;Ljava/io/File;)Z
    //   385: pop
    //   386: goto +114 -> 500
    //   389: astore_0
    //   390: aconst_null
    //   391: astore_1
    //   392: goto -65 -> 327
    //   395: iconst_0
    //   396: ifeq +11 -> 407
    //   399: new 293	java/lang/NullPointerException
    //   402: dup
    //   403: invokespecial 294	java/lang/NullPointerException:<init>	()V
    //   406: athrow
    //   407: iconst_0
    //   408: ifeq +11 -> 419
    //   411: new 293	java/lang/NullPointerException
    //   414: dup
    //   415: invokespecial 294	java/lang/NullPointerException:<init>	()V
    //   418: athrow
    //   419: aload 4
    //   421: ifnull +8 -> 429
    //   424: aload 4
    //   426: invokevirtual 283	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   429: return
    //   430: astore_0
    //   431: aload_0
    //   432: invokevirtual 161	java/io/IOException:printStackTrace	()V
    //   435: goto -28 -> 407
    //   438: astore_0
    //   439: aload_0
    //   440: invokevirtual 161	java/io/IOException:printStackTrace	()V
    //   443: goto -24 -> 419
    //   446: astore_0
    //   447: aload_0
    //   448: invokevirtual 161	java/io/IOException:printStackTrace	()V
    //   451: return
    //   452: astore_3
    //   453: aload_3
    //   454: invokevirtual 161	java/io/IOException:printStackTrace	()V
    //   457: goto -122 -> 335
    //   460: astore_1
    //   461: aload_1
    //   462: invokevirtual 161	java/io/IOException:printStackTrace	()V
    //   465: goto -122 -> 343
    //   468: astore_1
    //   469: aload_1
    //   470: invokevirtual 161	java/io/IOException:printStackTrace	()V
    //   473: goto -120 -> 353
    //   476: astore_0
    //   477: aconst_null
    //   478: astore 4
    //   480: aconst_null
    //   481: astore_1
    //   482: goto -155 -> 327
    //   485: astore 5
    //   487: aconst_null
    //   488: astore_1
    //   489: aload_0
    //   490: astore_3
    //   491: aload 5
    //   493: astore_0
    //   494: goto -167 -> 327
    //   497: goto -440 -> 57
    //   500: goto -443 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	503	0	paramString1	String
    //   0	503	1	paramString2	String
    //   165	146	2	i	int
    //   1	331	3	str1	String
    //   452	2	3	localIOException	java.io.IOException
    //   490	1	3	str2	String
    //   41	438	4	localQZipFile	com.tencent.commonsdk.zip.QZipFile
    //   77	287	5	localObject1	Object
    //   485	7	5	localObject2	Object
    //   48	20	6	localEnumeration	java.util.Enumeration
    //   317	8	6	localObject3	Object
    //   55	253	7	arrayOfByte	byte[]
    //   172	207	8	localObject4	Object
    //   254	127	9	localFile	File
    // Exception table:
    //   from	to	target	type
    //   289	301	317	finally
    //   306	314	317	finally
    //   355	368	317	finally
    //   43	57	389	finally
    //   57	85	389	finally
    //   89	98	389	finally
    //   101	155	389	finally
    //   158	189	389	finally
    //   192	217	389	finally
    //   217	270	389	finally
    //   270	280	389	finally
    //   368	386	389	finally
    //   399	407	430	java/io/IOException
    //   411	419	438	java/io/IOException
    //   424	429	446	java/io/IOException
    //   331	335	452	java/io/IOException
    //   339	343	460	java/io/IOException
    //   348	353	468	java/io/IOException
    //   33	43	476	finally
    //   280	289	485	finally
  }
  
  public static boolean a()
  {
    if ((!atwl.a(e())) || (!atwl.a(d())) || (!atwl.a(c())) || (!a("YTFaceCluster")) || (!a("YTFaceExtFeature")) || (!atwl.a(f())) || (!a("YTFaceClusterJNI_V841")))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FaceScanNativeSoLoader", 2, "isAllSoFileReady native so is not exist!");
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FaceScanNativeSoLoader", 2, "isAllSoFileReady true");
    }
    return true;
  }
  
  public static boolean a(String paramString)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    String str1 = a() + "/lib" + paramString + ".so";
    ??? = new File(str1);
    boolean bool1 = bool3;
    if (!jdField_a_of_type_Boolean)
    {
      bool1 = bool3;
      if (!((File)???).exists()) {}
    }
    for (;;)
    {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        String str2 = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 4).getString("face_native_" + paramString, null);
        str1 = azby.a(str1);
        if (QLog.isColorLevel()) {
          QLog.d("FaceScanNativeSoLoader", 2, "isSoFileExist: soName= " + paramString + " ,spmd5 = " + str2 + ",fileMD5 = " + str1);
        }
        if (str2 != null) {
          if (str2.equalsIgnoreCase(str1))
          {
            break label298;
            if (QLog.isColorLevel()) {
              QLog.d("FaceScanNativeSoLoader", 2, "isSoFileExist: soName= " + paramString + " ,result = " + bool1 + ",isUncompressZip = " + jdField_a_of_type_Boolean);
            }
            return bool1;
          }
          else
          {
            bool1 = bool2;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("FaceScanNativeSoLoader", 2, "isSoFileExist: soName= " + paramString + " check md5 false!");
            bool1 = bool2;
          }
        }
      }
      label298:
      bool1 = true;
    }
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
        QLog.e("FaceScanNativeSoLoader", 2, paramString, paramHashMap);
        bool = false;
        return bool;
      }
      int i = localXmlPullParser.next();
      break label203;
      String str = localXmlPullParser.getName();
      if (str.equalsIgnoreCase("YTFaceCluster"))
      {
        paramHashMap.put("YTFaceCluster", localXmlPullParser.nextText());
        continue;
      }
      else
      {
        if (str.equalsIgnoreCase("YTFaceExtFeature"))
        {
          paramHashMap.put("YTFaceExtFeature", localXmlPullParser.nextText());
          continue;
        }
        if (!str.equalsIgnoreCase("YTFaceClusterJNI_V841")) {
          continue;
        }
        paramHashMap.put("YTFaceClusterJNI_V841", localXmlPullParser.nextText());
        continue;
      }
      if (QLog.isColorLevel())
      {
        QLog.d("FaceScanNativeSoLoader", 2, "parseConfig success|config=" + paramHashMap);
        return true;
        label203:
        if (i != 1) {
          switch (i)
          {
          }
        }
      }
    }
  }
  
  public static byte b(String paramString)
  {
    byte b1 = 0;
    try
    {
      System.load(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("FaceScanNativeSoLoader", 2, "loadSoByPath ret = " + b1 + ",soPath = " + paramString);
      }
      return b1;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        byte b2 = -2;
        b1 = b2;
        if (QLog.isColorLevel())
        {
          QLog.e("FaceScanNativeSoLoader", 2, "loadSoByPath error", localUnsatisfiedLinkError);
          b1 = b2;
        }
      }
    }
  }
  
  public static String b()
  {
    return BaseApplicationImpl.sApplication.getFilesDir().getParent() + "/face_scan";
  }
  
  public static byte c(String paramString)
  {
    byte b3 = 0;
    byte b2 = 0;
    if (paramString == null) {
      return -1;
    }
    String str = a() + "/lib" + paramString + ".so";
    if (QLog.isColorLevel()) {
      QLog.i("FaceScanNativeSoLoader", 2, "loadFaceNativeSo start faceNativeSo: " + str);
    }
    File localFile = new File(str);
    if ((!jdField_a_of_type_Boolean) && (localFile.exists())) {}
    for (;;)
    {
      try
      {
        System.load(str);
        b1 = b2;
        if (QLog.isColorLevel())
        {
          QLog.i("FaceScanNativeSoLoader", 2, "load " + str + " success!");
          b1 = b2;
        }
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        QLog.d("FaceScanNativeSoLoader", 1, "loadFaceNativeSo load from face dir failed, libName = " + paramString + "," + localUnsatisfiedLinkError.getMessage());
        b1 = -2;
        continue;
      }
      apaq.a(paramString, b1);
      return b1;
      byte b1 = b3;
      if (jdField_a_of_type_Boolean)
      {
        b1 = b3;
        if (!localFile.exists()) {
          b1 = -3;
        }
      }
      b2 = b1;
      if (jdField_a_of_type_Boolean)
      {
        b2 = b1;
        if (localFile.exists()) {
          b2 = -4;
        }
      }
      b1 = b2;
      if (!jdField_a_of_type_Boolean)
      {
        b1 = b2;
        if (!localFile.exists()) {
          b1 = -5;
        }
      }
      QLog.d("FaceScanNativeSoLoader", 1, "loadFaceNativeSo no face so in face dir,libName = " + paramString);
    }
  }
  
  public static String c()
  {
    return bnpy.a(bnpt.b) + "libc++_shared.so";
  }
  
  public static String d()
  {
    return bnpy.a(bnpt.b) + "libYTCommon.so";
  }
  
  public static String e()
  {
    return bnpy.a(bnpt.b) + "libopencv_world.so";
  }
  
  public static String f()
  {
    return bnpy.a(bnpt.b) + "libYTFaceTrackPro.so";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aowk
 * JD-Core Version:    0.7.0.1
 */